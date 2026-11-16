#!/usr/bin/env python3
"""Capture the small fix APK's full method evidence, never executing its code.

Use .artifact-analysis/parity-env/bin/python. Generated evidence stays ignored.
"""
import hashlib
import json
from pathlib import Path
import zipfile
from androguard.core.dex import DEX
from loguru import logger

logger.remove()
root = Path(__file__).resolve().parents[2]
apk = root / 'JuiceSSHOfflineProFix-v1.0-xposed82-release.apk'
assert hashlib.sha256(apk.read_bytes()).hexdigest() == '5dea4033623bc6562fe388c4f47e9df6cd2643327138b0f10578ef6f171a267d'
with zipfile.ZipFile(apk) as archive:
    dex = DEX(archive.read('classes.dex'))
out = root / '.artifact-analysis/parity/r001'
out.mkdir(exist_ok=True)
records = []
for cls in dex.get_classes():
    for method in cls.get_methods():
        code = method.get_code()
        handlers = code.get_handlers()
        tries = []
        for entry in code.get_tries():
            handler = next(h for h in handlers.get_list()
                           if h.get_off() - handlers.get_off() == entry.get_handler_off())
            types = [{'type': dex.get_cm_type(h.get_type_idx()), 'target_bytes': h.get_addr() * 2}
                     for h in handler.get_handlers()]
            if handler.get_size() <= 0:
                types.append({'type': 'catch-all', 'target_bytes': handler.get_catch_all_addr() * 2})
            tries.append({'start_bytes': entry.get_start_addr() * 2,
                          'end_exclusive_bytes': (entry.get_start_addr() + entry.get_insn_count()) * 2,
                          'handlers': types})
        records.append({'signature': cls.get_name() + '->' + method.get_name() + method.get_descriptor().replace(' ', ''),
                        'access_flags': method.get_access_flags(), 'tries': tries,
                        'instructions': [{'offset_bytes': offset, 'opcode': ins.get_name(), 'operands': ins.get_output()}
                                         for offset, ins in method.get_instructions_idx()]})
(out / 'methods.json').write_text(json.dumps(records, indent=2) + '\n')
assert len(records) == 31
print('Captured all 31 fix methods and their exception regions.')
for r in records:
    if 'replaceHookedMethod' in r['signature']:
        print(json.dumps({'signature': r['signature'], 'tries': r['tries']}))
    if ('SyntheticLambda' in r['signature'] or 'lambda' in r['signature']
            or 'Nest' in r['signature'] or '/R' in r['signature']):
        print(r['signature'], [i['opcode'] + ' ' + i['operands'] for i in r['instructions']])
