package jackpal.androidterm.emulatorview;

/* loaded from: classes.dex */
public class EmulatorDebug {
    public static final boolean DEBUG = false;
    public static final boolean LOG_CHARACTERS_FLAG = false;
    public static final boolean LOG_IME = false;
    public static final String LOG_TAG = "EmulatorView";
    public static final boolean LOG_UNKNOWN_ESCAPE_SEQUENCES = false;

    public static String bytesToString(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            byte b = bArr[i + i3];
            if (b < 32 || b > 126) {
                sb.append(String.format("\\x%02x", Byte.valueOf(b)));
            } else {
                sb.append((char) b);
            }
        }
        return sb.toString();
    }
}
