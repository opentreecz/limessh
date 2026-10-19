#!/usr/bin/env python3
"""Static APK inventory. Requires androguard; never executes APK code.

Run from repository root: python <this-script> [--extract]
All generated evidence is private/ignored under .artifact-analysis/.
"""
import argparse
import hashlib
import json
from pathlib import Path
import zipfile
from importlib.metadata import version

from androguard.core.apk import APK
from loguru import logger

logger.remove()
root = Path(__file__).resolve().parents[2]
out = root / '.artifact-analysis'
out.mkdir(exist_ok=True)
parser = argparse.ArgumentParser()
parser.add_argument('--extract', action='store_true')
args = parser.parse_args()
report = {'androguard_version': version('androguard'), 'artifacts': []}
for path in sorted(root.glob('*.apk')):
    label = 'fix' if path.name.startswith('JuiceSSHOffline') else 'juicessh'
    dest = out / label
    dest.mkdir(exist_ok=True)
    apk = APK(str(path))
    from lxml import etree
    (dest / 'AndroidManifest.xml').write_bytes(etree.tostring(apk.get_android_manifest_xml(), pretty_print=True))
    with zipfile.ZipFile(path) as archive:
        entries = [{'name': i.filename, 'size': i.file_size, 'compressed': i.compress_size} for i in archive.infolist()]
        if args.extract:
            base = (dest / 'unpacked').resolve()
            for item in archive.infolist():
                target = (base / item.filename).resolve()
                if not target.is_relative_to(base):
                    raise ValueError('Unsafe ZIP member: ' + item.filename)
            archive.extractall(base)
    certs = []
    for cert in apk.get_certificates():
        certs.append({'sha256': hashlib.sha256(cert.dump()).hexdigest(), 'subject': cert.subject.human_friendly,
                      'issuer': cert.issuer.human_friendly, 'serial': cert.serial_number})
    item = {'file': path.name, 'size': path.stat().st_size, 'sha256': hashlib.sha256(path.read_bytes()).hexdigest(),
            'package': apk.get_package(), 'version_name': apk.get_androidversion_name(),
            'version_code': apk.get_androidversion_code(), 'min_sdk': apk.get_min_sdk_version(),
            'target_sdk': apk.get_target_sdk_version(), 'permissions': apk.get_permissions(),
            'activities': apk.get_activities(), 'services': apk.get_services(), 'receivers': apk.get_receivers(),
            'providers': apk.get_providers(), 'signature_present': {'v1': apk.is_signed_v1(), 'v2': apk.is_signed_v2(), 'v3': apk.is_signed_v3()},
            'certificates': certs, 'entries': entries}
    report['artifacts'].append(item)
(out / 'inventory.json').write_text(json.dumps(report, indent=2) + '\n')
print(out / 'inventory.json')
