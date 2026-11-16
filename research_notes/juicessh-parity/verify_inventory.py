#!/usr/bin/env python3
"""Cross-check generated indexes against independent cached smali/public.xml.

Standard library only. Optional smali root is argv[1]. Missing comparison evidence
is an error, not a passing verification. Does not execute or rebuild either app.
"""
import collections
import hashlib
import json
from pathlib import Path
import re
import sys
import xml.etree.ElementTree as ET

ROOT = Path(__file__).resolve().parents[2]
BASE = ROOT / '.artifact-analysis/parity'
summary = json.loads((BASE / 'summary.json').read_text())
for name, expected in summary['output_sha256'].items():
    assert hashlib.sha256((BASE / name).read_bytes()).hexdigest() == expected, name
classes, methods, ids, parents = set(), set(), set(), set()
resources = collections.defaultdict(set)
counts = collections.Counter()
for line in (BASE / 'inventory.jsonl').open():
    row = json.loads(line)
    assert row['item_id'] not in ids, row['locator']
    ids.add(row['item_id'])
    if row['parent_id']:
        parents.add(row['parent_id'])
    counts[row['artifact'] + '/' + row['kind']] += 1
    if row['kind'] == 'resource':
        resources[row['artifact']].add(int(row['locator'], 16))
    if row['artifact'] == 'juicessh' and row['kind'] in ('class', 'method'):
        (classes if row['kind'] == 'class' else methods).add(row['locator'].split(':', 1)[1])
assert not parents - ids, 'Orphan parent IDs'
assert dict(counts) == summary['counts'], 'Count mismatch'
assert len(ids) == summary['inventory_rows'], 'Row total mismatch'
for label, resource_ids in resources.items():
    path = ROOT / '.artifact-analysis' / label / 'jadx/resources/res/values/public.xml'
    public_ids = {int(node.attrib['id'], 16) for node in ET.parse(path).getroot()}
    assert resource_ids == public_ids, label + ': independent resource ID mismatch'
smali = Path(sys.argv[1]) if len(sys.argv) > 1 else Path('/tmp/opencode/revtools/apk_smali/smali')
smali_classes, smali_methods = set(), set()
for path in smali.rglob('*.smali'):
    text = path.read_text()
    match = re.search(r'^\.class .* (L[^\s]+;)$', text, re.M)
    assert match, str(path)
    descriptor = match.group(1)
    smali_classes.add(descriptor)
    for method in re.finditer(r'^\.method (.+)$', text, re.M):
        smali_methods.add(descriptor + '->' + method.group(1).split()[-1])
assert smali_classes == classes, 'Smali class set mismatch or missing cache'
assert smali_methods == methods, 'Smali defined-method set mismatch or missing cache'
baseline = json.loads((BASE / 'current-source-baseline.json').read_text())
for item in baseline['files']:
    path = ROOT / item['path']
    actual = hashlib.sha256(path.read_bytes()).hexdigest() if path.is_file() else None
    assert actual == item['sha256'], 'Current source changed: ' + item['path']
result = dict(inventory_rows=len(ids), main_classes=len(classes), main_methods=len(methods),
              resource_ids={k: len(v) for k, v in resources.items()},
              orphan_parents=0, current_source_files=len(baseline['files']),
              result='passed', scope='structural inventory; no bytecode semantic or runtime equivalence claim')
(BASE / 'validation.json').write_text(json.dumps(result, indent=2) + '\n')
print(json.dumps(result, indent=2))
