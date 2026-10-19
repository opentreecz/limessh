#!/usr/bin/env python3
"""Record DEX counts and targeted instruction evidence in ignored storage."""
from pathlib import Path
import json
from androguard.core.dex import DEX
from loguru import logger

logger.remove()
root = Path(__file__).resolve().parents[2] / '.artifact-analysis'
summary = {}
targets = {
    'fix': {'Lorg/lyf/juicesshofflinepro/JuiceSshOfflineProModule$1;'},
    'juicessh': {'Lcom/sonelli/oi0;', 'Lcom/sonelli/juicessh/models/User;'},
}
for label in targets:
    stats = []
    evidence = []
    for path in sorted((root / label / 'unpacked').glob('classes*.dex')):
        dex = DEX(path.read_bytes())
        stats.append({'dex': path.name, 'classes': len(dex.get_classes()), 'method_ids': len(dex.get_methods())})
        for cls in dex.get_classes():
            if cls.get_name() not in targets[label]:
                continue
            for method in cls.get_methods():
                code = method.get_code()
                if not code:
                    continue
                evidence.append(f'{cls.get_name()} {method.get_name()} {method.get_descriptor()} tries={code.get_tries_size()}')
                evidence.extend(f'{offset:04x}: {ins.get_name()} {ins.get_output()}' for offset, ins in method.get_instructions_idx())
    (root / label / 'targeted-dex.txt').write_text('\n'.join(evidence) + '\n')
    summary[label] = stats
(root / 'dex-summary.json').write_text(json.dumps(summary, indent=2) + '\n')
print(json.dumps(summary, indent=2))
