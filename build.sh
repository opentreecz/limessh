#!/usr/bin/env bash
# Build the LimeSSH APK by repackaging the base JuiceSSH APK with apktool:
# decode -> apply patches (offline-pro + green lime icon) -> rebuild ->
# zipalign -> sign. Produces an installable, debug-signed APK.
#
# Requirements: JDK 17+, an Android SDK with build-tools (ANDROID_HOME),
# curl, and python3. apktool is downloaded automatically.
set -euo pipefail

APKTOOL_VERSION="2.10.0"
BASE_APK="juicessh-base.apk"
WORK="build"
DECODED="$WORK/decoded"
UNSIGNED="$WORK/limessh-unsigned.apk"
ALIGNED="$WORK/limessh-aligned.apk"
OUTPUT="$WORK/limessh-debug.apk"
KEYSTORE="${LIMESSH_KEYSTORE:-$WORK/debug.keystore}"
KS_PASS="${LIMESSH_KEYSTORE_PASS:-android}"
KEY_ALIAS="${LIMESSH_KEY_ALIAS:-androiddebugkey}"
KEY_PASS="${LIMESSH_KEY_PASS:-android}"

root="$(cd "$(dirname "$0")" && pwd)"
cd "$root"

: "${ANDROID_HOME:=${ANDROID_SDK_ROOT:-}}"
if [[ -z "${ANDROID_HOME:-}" ]]; then
  echo "error: ANDROID_HOME/ANDROID_SDK_ROOT is not set" >&2
  exit 1
fi
if [[ ! -f "$BASE_APK" ]]; then
  echo "error: base APK not found: $BASE_APK" >&2
  exit 1
fi

# Pick the newest installed build-tools for zipalign/apksigner.
BUILD_TOOLS="$(ls -d "$ANDROID_HOME"/build-tools/*/ 2>/dev/null | sort -V | tail -1)"
if [[ -z "$BUILD_TOOLS" ]]; then
  echo "error: no build-tools found under $ANDROID_HOME/build-tools" >&2
  exit 1
fi
ZIPALIGN="$BUILD_TOOLS/zipalign"
APKSIGNER="$BUILD_TOOLS/apksigner"

mkdir -p "$WORK"

# Fetch apktool.
APKTOOL="$WORK/apktool-$APKTOOL_VERSION.jar"
if [[ ! -f "$APKTOOL" ]]; then
  echo ">> downloading apktool $APKTOOL_VERSION"
  curl -fsSL -o "$APKTOOL" \
    "https://github.com/iBotPeaches/Apktool/releases/download/v$APKTOOL_VERSION/apktool_$APKTOOL_VERSION.jar"
fi

echo ">> decoding $BASE_APK"
rm -rf "$DECODED"
java -jar "$APKTOOL" d -f -o "$DECODED" "$BASE_APK"

echo ">> applying patches"
python3 patches/patch.py "$DECODED"

echo ">> rebuilding"
java -jar "$APKTOOL" b -f "$DECODED" -o "$UNSIGNED"

echo ">> zipalign"
"$ZIPALIGN" -p -f 4 "$UNSIGNED" "$ALIGNED"

if [[ ! -f "$KEYSTORE" ]]; then
  echo ">> generating debug keystore"
  keytool -genkeypair -v -keystore "$KEYSTORE" -alias "$KEY_ALIAS" \
    -storepass "$KS_PASS" -keypass "$KEY_PASS" -keyalg RSA -keysize 2048 \
    -validity 10000 -dname "CN=LimeSSH Debug,O=LimeSSH,C=US"
fi

echo ">> signing"
"$APKSIGNER" sign --ks "$KEYSTORE" --ks-pass "pass:$KS_PASS" \
  --key-pass "pass:$KEY_PASS" --out "$OUTPUT" "$ALIGNED"
"$APKSIGNER" verify --verbose "$OUTPUT"

echo ">> built: $OUTPUT"
