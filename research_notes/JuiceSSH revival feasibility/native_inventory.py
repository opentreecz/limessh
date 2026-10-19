#!/usr/bin/env python3
"""Record ELF metadata and selected version strings without loading binaries."""
import hashlib
import json
from pathlib import Path
import re
import subprocess

root = Path(__file__).resolve().parents[2]
base = root / '.artifact-analysis/juicessh/unpacked/lib'
result = []
for path in sorted(base.glob('*/*')):
    data = path.read_bytes()
    elf = data.startswith(b'\x7fELF')
    item = {'path': str(path.relative_to(base)), 'size': len(data),
            'sha256': hashlib.sha256(data).hexdigest(), 'elf': elf}
    if elf:
        proc = subprocess.run(['readelf', '-h', '-l', '-d', '-W', str(path)], capture_output=True, text=True)
        item['readelf'] = proc.stdout
        item['stderr'] = proc.stderr
        item['version_strings'] = sorted(set(x.decode('ascii') for x in re.findall(rb'[\x20-\x7e]{8,}', data)
             if re.search(rb'OpenSSL [0-9]|libssh[-_ ][0-9]|GNU bash|mosh [0-9]', x)))
    result.append(item)
out = root / '.artifact-analysis/native-inventory.json'
out.write_text(json.dumps(result, indent=2) + '\n')
for item in result:
    print(item['path'], 'ELF' if item['elf'] else 'non-ELF', item.get('version_strings', []))
