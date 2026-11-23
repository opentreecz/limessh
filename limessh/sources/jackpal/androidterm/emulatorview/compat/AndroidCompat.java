package jackpal.androidterm.emulatorview.compat;

import android.os.Build;

/* loaded from: classes.dex */
public class AndroidCompat {
    public static final int SDK = getSDK();

    private static final int getSDK() {
        try {
            try {
                return AndroidLevel4PlusCompat.getSDKInt();
            } catch (NumberFormatException unused) {
                return 1;
            }
        } catch (VerifyError unused2) {
            return Integer.valueOf(Build.VERSION.SDK).intValue();
        }
    }
}
