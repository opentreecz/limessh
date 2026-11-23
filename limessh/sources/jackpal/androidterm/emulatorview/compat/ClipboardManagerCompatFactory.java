package jackpal.androidterm.emulatorview.compat;

import android.content.Context;

/* loaded from: classes.dex */
public class ClipboardManagerCompatFactory {
    private ClipboardManagerCompatFactory() {
    }

    public static ClipboardManagerCompat getManager(Context context) {
        return AndroidCompat.SDK < 11 ? new ClipboardManagerCompatV1(context) : new ClipboardManagerCompatV11(context);
    }
}
