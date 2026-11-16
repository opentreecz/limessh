#!/bin/sh
# Local limessh build entry point for Linux and macOS.
set -eu

if ! command -v python3 >/dev/null 2>&1; then
    printf '%s\n' 'Python 3 is required. Install python3 and run ./build.sh again.' >&2
    exit 1
fi

SCRIPT_DIR=$(CDPATH='' cd -- "$(dirname -- "$0")" && pwd)
exec python3 "$SCRIPT_DIR/build-local.py" "$@"
