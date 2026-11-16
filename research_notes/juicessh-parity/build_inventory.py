#!/usr/bin/env python3
"""R-000 static indexes; never execute APK code or overwrite reviewed dispositions.

Run from any directory with Python + androguard==4.1.4. Outputs are generated seeds
under ignored .artifact-analysis/parity/. Review annotations belong in separate
task/coverage files. APK hash mismatch or count/cache mismatch aborts publication.
"""
import collections
import hashlib
import importlib.metadata
import json
from pathlib import Path
import re
import shutil
import struct
import subprocess
import sys
import tempfile
import zipfile

from androguard.core.apk import APK
from androguard.core.dex import DEX
from loguru import logger

logger.remove()
ROOT = Path(__file__).resolve().parents[2]
CACHE = ROOT / '.artifact-analysis'
OUT = CACHE / 'parity'
ANDROID = '{http://schemas.android.com/apk/res/android}'
INPUTS = {
    'fix': ('JuiceSSHOfflineProFix-v1.0-xposed82-release.apk',
            '5dea4033623bc6562fe388c4f47e9df6cd2643327138b0f10578ef6f171a267d'),
    'juicessh': ('com.sonelli.juicessh_3.2.2-200_minAPI26(arm64-v8a,armeabi-v7a,x86,x86_64)(nodpi)_apkmirror.com.apk',
                 '167d3afb1c832698ca512d9bf418c341a6f6e441bc64f57aaa1b264d47a8d64b'),
}


def sha(data):
    return hashlib.sha256(data).hexdigest()


def packed(value):
    return json.dumps(value, sort_keys=True, ensure_ascii=True, separators=(',', ':'))


def run(*args):
    return subprocess.check_output(args, cwd=ROOT).decode().strip()


def signature(method):
    return method.get_class_name() + '->' + method.get_name() + method.get_descriptor().replace(' ', '')


def classify(label, descriptor):
    """Conservative seed, never a license or behavioral-equivalence finding."""
    if re.search(r'/(R(?:\$[^;]+)?|BuildConfig);$', descriptor):
        return 'generated', 'resource/build class name; provisional', 'R-001' if label == 'fix' else 'W-24'
    if label == 'fix':
        return 'application', 'module namespace; source available; review pending', 'R-001'
    if descriptor.startswith('Ljackpal/'):
        return 'dependency', 'jackpal namespace; attribution review pending', 'W-02'
    if descriptor.startswith(('Landroid/', 'Landroidx/', 'Lcom/google/', 'Lcom/crashlytics/',
                              'Lio/fabric/', 'Lorg/', 'Lokhttp', 'Lokio/', 'Lcom/sun/', 'Lcom/j256/')):
        return 'dependency', 'recognized package prefix; attribution review pending', 'W-22'
    if descriptor.startswith('Lcom/sonelli/juicessh/'):
        groups = [('pluginlibrary/', 'W-14'), ('providers/', 'W-14'), ('db/', 'W-12'),
                  ('models/', 'W-12'), ('widgets/', 'W-16'), ('views/', 'W-01'),
                  ('connections/', 'W-05')]
        for prefix, stream in groups:
            if descriptor.startswith('Lcom/sonelli/juicessh/' + prefix):
                return 'application', 'named app namespace; provisional routing', stream
        return 'application', 'named app namespace; subsystem unreviewed', 'W-23'
    return 'unknown', 'ownership requires review; namespace alone insufficient', 'W-23'


def snapshot():
    candidates = subprocess.check_output(
        ['git', 'ls-files', '--cached', '--others', '--exclude-standard', '-z'], cwd=ROOT).decode().split('\0')
    files = []
    for name in sorted(set(candidates)):
        if not name:
            continue
        selected = name.startswith(('app/src/', 'app/schemas/', '.github/', 'gradle/', 'tests/')) or name in {
            'build.gradle.kts', 'settings.gradle.kts', 'gradle.properties', 'gradlew', 'gradlew.bat',
            'build.sh', 'build-local.py', 'app/build.gradle.kts', 'app/proguard-rules.pro'}
        if not selected:
            continue
        path = ROOT / name
        files.append({'path': name, 'sha256': sha(path.read_bytes()) if path.is_file() else None,
                      'state': 'present' if path.is_file() else 'deleted'})
    identity = {'head': run('git', 'rev-parse', 'HEAD'), 'files': files}
    return {**identity, 'baseline_id': sha(packed(identity).encode()),
            'git_status': run('git', 'status', '--porcelain=v1', '--untracked-files=all'),
            'scope': 'app/src, app/schemas, build, gradle, CI, tests; no local.properties, credentials, generated build files'}


def main():
    if importlib.metadata.version('androguard') != '4.1.4':
        raise RuntimeError('Use the recorded androguard==4.1.4 parser version')
    old = json.loads((CACHE / 'dex-summary.json').read_text())
    prior = {x['sha256']: x for x in json.loads((CACHE / 'inventory.json').read_text())['artifacts']}
    OUT.mkdir(exist_ok=True)
    with tempfile.TemporaryDirectory(prefix='r000-', dir=CACHE) as tmp:
        dest = Path(tmp)
        inventory = (dest / 'inventory.jsonl').open('w')
        edges = (dest / 'direct-invokes.jsonl').open('w')
        boundaries = (dest / 'dynamic-boundaries.jsonl').open('w')
        warnings = (dest / 'decompiler-markers.jsonl').open('w')
        seen = set()
        counts = collections.Counter()
        ownership = collections.Counter()
        streams = collections.Counter()

        def add(label, kind, locator, parent='', owner='unknown', why='unreviewed', stream='W-23', **extra):
            artifact = INPUTS[label][1]
            item_id = sha((artifact + '\0' + kind + '\0' + locator).encode())
            if item_id in seen:
                raise RuntimeError('Duplicate stable item: ' + locator)
            seen.add(item_id)
            item = dict(item_id=item_id, artifact_sha256=artifact, artifact=label,
                        kind=kind, locator=locator, parent_id=parent, owner_classification=owner,
                        classification_evidence=why, workstream_id=stream,
                        leaf_id='R-001' if label == 'fix' else '', review_status='unreviewed',
                        disposition='queued', evidence_card='', uncertainty='seed routing, not behavior review', **extra)
            inventory.write(packed(item) + '\n')
            counts[(label, kind)] += 1
            if kind == 'class':
                ownership[(label, owner)] += 1
                streams[(label, stream)] += 1
            return item_id

        artifacts = {}
        invocations = collections.Counter()
        markers = collections.Counter()
        for label, (filename, expected) in INPUTS.items():
            path = ROOT / filename
            if sha(path.read_bytes()) != expected:
                raise RuntimeError('APK hash differs from approved baseline: ' + filename)
            apk = APK(str(path))
            artifact = {'sha256': expected, 'bytes': path.stat().st_size, 'file': filename,
                        'package': apk.get_package(), 'version': apk.get_androidversion_name(),
                        'dex': [], 'cached_entries_verified': 0}
            archive_ids = {}
            with zipfile.ZipFile(path) as archive:
                infos = archive.infolist()
                if len({i.filename for i in infos}) != len(infos):
                    raise RuntimeError('Duplicate archive path requires occurrence IDs')
                if len(infos) != len(prior[expected]['entries']):
                    raise RuntimeError('Prior archive inventory count mismatch')
                for info in infos:
                    data = archive.read(info)
                    name = info.filename
                    group = 'resource-file' if name.startswith('res/') else 'asset' if name.startswith('assets/') else 'other'
                    archive_ids[name] = add(label, 'archive', name, stream='R-001' if label == 'fix' else 'W-24',
                                            bytes=len(data), sha256=sha(data), group=group)
                    cached = CACHE / label / 'unpacked' / name
                    if not info.is_dir():
                        if not cached.is_file() or sha(cached.read_bytes()) != sha(data):
                            raise RuntimeError('Missing/mismatched extracted member: ' + str(cached))
                        artifact['cached_entries_verified'] += 1
                    if name.startswith('lib/') or name.endswith(('.so', '.jnilib', '.dll', '.dylib')):
                        add(label, 'native-file', name, archive_ids[name], stream='W-22',
                            sha256=sha(data), bytes=len(data), elf=data[:4] == b'\x7fELF',
                            abi=name.split('/')[1] if name.startswith('lib/') else 'auxiliary',
                            family=Path(name).name)
                for info in infos:
                    if not re.fullmatch(r'classes\d*\.dex', info.filename):
                        continue
                    data = archive.read(info)
                    dex = DEX(data)
                    header_methods = struct.unpack_from('<I', data, 88)[0]
                    header_classes = struct.unpack_from('<I', data, 96)[0]
                    classes = dex.get_classes()
                    method_ids = dex.get_methods()
                    if len(classes) != header_classes or len(method_ids) != header_methods:
                        raise RuntimeError('DEX parser/header count mismatch')
                    recorded = next(d for d in old[label] if d['dex'] == info.filename)
                    if recorded['classes'] != header_classes or recorded['method_ids'] != header_methods:
                        raise RuntimeError('Historical DEX count mismatch')
                    dex_stats = dict(file=info.filename, sha256=sha(data), classes=header_classes,
                                     method_ids=header_methods, defined_methods=0, methods_with_code=0,
                                     native_methods=0, abstract_methods=0)
                    for cls in classes:
                        descriptor = cls.get_name()
                        owner, why, stream = classify(label, descriptor)
                        classid = add(label, 'class', info.filename + ':' + descriptor,
                                      archive_ids[info.filename], owner, why, stream)
                        methods = cls.get_methods()
                        for method in methods:
                            sig = signature(method)
                            flags = method.get_access_flags()
                            methodid = add(label, 'method', info.filename + ':' + sig, classid,
                                           owner, why, stream, access_flags=flags,
                                           code_offset=method.get_code_off())
                            dex_stats['defined_methods'] += 1
                            dex_stats['methods_with_code'] += bool(method.get_code())
                            dex_stats['native_methods'] += bool(flags & 0x100)
                            dex_stats['abstract_methods'] += bool(flags & 0x400)
                            if flags & 0x100:
                                boundaries.write(packed(dict(artifact=label, source_id=methodid,
                                    kind='native-declaration', locator=sig, target='unresolved JNI binding')) + '\n')
                            for offset, ins in method.get_instructions_idx():
                                op = ins.get_op_value()
                                if op in (*range(0x6e, 0x73), *range(0x74, 0x79)):
                                    target = signature(method_ids[ins.get_ref_kind()])
                                    edge = dict(artifact=label, source_id=methodid, source=sig,
                                                offset_bytes=offset, target=target)
                                    edges.write(packed(edge) + '\n')
                                    invocations[label] += 1
                                    if (target.startswith(('Ljava/lang/reflect/', 'Ljava/lang/Class;->forName',
                                                          'Ljava/lang/Class;->get', 'Ljava/lang/ClassLoader;->loadClass'))
                                            or '->loadLibrary(' in target or '->load(Ljava/lang/String;' in target):
                                        boundaries.write(packed({**edge, 'kind': 'reflection-or-library-load',
                                                                 'target_resolution': 'dynamic argument unreviewed'}) + '\n')
                                elif op in (0xfa, 0xfb, 0xfc, 0xfd):
                                    boundaries.write(packed(dict(artifact=label, source_id=methodid,
                                        kind='dynamic-invoke', offset_bytes=offset, opcode=op)) + '\n')
                    artifact['dex'].append(dex_stats)
            manifest = apk.get_android_manifest_xml()
            component_counts = collections.Counter()
            for tag in ('activity', 'activity-alias', 'service', 'receiver', 'provider'):
                for node in manifest.findall('.//' + tag):
                    name = node.get(ANDROID + 'name')
                    add(label, 'component', tag + ':' + name, archive_ids['AndroidManifest.xml'],
                        stream='R-001' if label == 'fix' else 'W-16',
                        attributes=dict(node.attrib), intent_filters=[
                            {'attributes': dict(f.attrib), 'children': [dict(tag=c.tag, attributes=dict(c.attrib)) for c in f]}
                            for f in node.findall('intent-filter')],
                        exported=node.get(ANDROID + 'exported', 'not_explicit; platform default requires review'))
                    component_counts[tag] += 1
            artifact['components'] = dict(component_counts)
            for tag, key in [('activity', 'activities'), ('service', 'services'), ('receiver', 'receivers'), ('provider', 'providers')]:
                if component_counts[tag] != len(prior[expected][key]):
                    raise RuntimeError('Manifest component count mismatch: ' + key)
            arsc = apk.get_android_resources()
            arsc._analyse()  # pinned Androguard 4.1.4: enumerate all parsed IDs/configs, not only public XML
            names = {}
            for package, types in arsc.resource_keys.items():
                for kind, entries in types.items():
                    for name, rid in entries.items():
                        names[rid] = f'{package}:{kind}/{name}'
            for rid, configs in sorted(arsc.resource_values.items()):
                add(label, 'resource', f'0x{rid:08x}', archive_ids['resources.arsc'],
                    stream='R-001' if label == 'fix' else 'W-24',
                    resource_name=names.get(rid, 'unknown'),
                    configurations=sorted(c.get_qualifier() for c in configs))
            artifact['resource_configurations'] = sum(len(c) for c in arsc.resource_values.values())
            source_root = CACHE / label / 'jadx/sources'
            source_hashes = []
            for source in sorted(source_root.rglob('*.java')):
                content = source.read_bytes()
                relative = str(source.relative_to(ROOT))
                source_hashes.append((relative, sha(content)))
                for line, text in enumerate(content.decode(errors='replace').splitlines(), 1):
                    if re.search(r'JADX (?:ERROR|WARN)|Method not decompiled|Code decompiled incorrectly', text):
                        warnings.write(packed(dict(artifact=label, path=relative, line=line,
                            text=text.strip(), source_sha256=sha(content), status='unreconciled-marker')) + '\n')
                        markers[label] += 1
            artifact['jadx_java_files'] = len(source_hashes)
            (dest / f'{label}-jadx-files.json').write_text(json.dumps(source_hashes, indent=2) + '\n')
            artifacts[label] = artifact
        for file in (inventory, edges, boundaries, warnings):
            file.close()
        current = snapshot()
        (dest / 'current-source-baseline.json').write_text(json.dumps(current, indent=2) + '\n')
        tools = {'python': sys.version, 'python_executable_sha256': sha(Path(sys.executable).read_bytes()),
                 'generator_sha256': sha(Path(__file__).read_bytes()),
                 'packages': sorted(f'{d.metadata["Name"]}=={d.version}' for d in importlib.metadata.distributions()),
                 'generator_command': '.artifact-analysis/parity-env/bin/python research_notes/juicessh-parity/build_inventory.py',
                 'prior_tools': [], 'fallback_files': []}
        temp_tools = Path('/tmp/opencode/revtools')
        if temp_tools.exists():
            for path in sorted(temp_tools.iterdir()):
                if path.is_file() and path.suffix in ('.jar', '.zip'):
                    tools['prior_tools'].append(dict(path=str(path), sha256=sha(path.read_bytes()),
                        version_evidence='filename/prior notes; not executed in R-000'))
            for dirname in ('outA', 'out_simple', 'out_fallback', 'out_cfr', 'out_vf'):
                files = sorted((temp_tools / dirname).rglob('*'))
                for path in files:
                    if path.is_file():
                        tools['fallback_files'].append(dict(path=str(path), sha256=sha(path.read_bytes()),
                            source_apk_identity='unverified; existence is not recovery evidence'))
        (dest / 'provenance.json').write_text(json.dumps(tools, indent=2) + '\n')
        summary = dict(artifacts=artifacts, baseline_id=current['baseline_id'],
                       current_source_files=len(current['files']),
                       inventory_rows=len(seen), counts={f'{a}/{k}': v for (a, k), v in sorted(counts.items())},
                       class_ownership={f'{a}/{k}': v for (a, k), v in sorted(ownership.items())},
                       class_workstreams={f'{a}/{k}': v for (a, k), v in sorted(streams.items())},
                       direct_invoke_sites=dict(invocations), decompiler_marker_lines=dict(markers),
                       limitations=['Class ownership/routing is a seed, not reviewed attribution.',
                                    'Dynamic/native target arguments are unresolved; call index covers direct invoke opcodes only.',
                                    'Resource IDs/configurations enumerate pinned parser output; decoded values are not behavior review.',
                                    'Historical 26 JADX errors are not equivalent to current marker-line counts.',
                                    'Fallback files have hashes but source-APK identity is not independently established.'])
        summary['output_sha256'] = {p.name: sha(p.read_bytes()) for p in sorted(dest.iterdir())}
        (dest / 'summary.json').write_text(json.dumps(summary, indent=2) + '\n')
        for path in dest.iterdir():
            shutil.copyfile(path, OUT / path.name)
        print(json.dumps({k: summary[k] for k in ('baseline_id', 'current_source_files', 'inventory_rows', 'counts',
                                                'class_ownership', 'direct_invoke_sites', 'decompiler_marker_lines')}, indent=2))


if __name__ == '__main__':
    main()
