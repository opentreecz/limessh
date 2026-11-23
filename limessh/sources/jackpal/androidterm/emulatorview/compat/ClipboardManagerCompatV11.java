package jackpal.androidterm.emulatorview.compat;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class ClipboardManagerCompatV11 implements ClipboardManagerCompat {
    private final ClipboardManager clip;

    public ClipboardManagerCompatV11(Context context) {
        this.clip = (ClipboardManager) context.getApplicationContext().getSystemService("clipboard");
    }

    @Override // jackpal.androidterm.emulatorview.compat.ClipboardManagerCompat
    public CharSequence getText() {
        return this.clip.getPrimaryClip().getItemAt(0).getText();
    }

    @Override // jackpal.androidterm.emulatorview.compat.ClipboardManagerCompat
    public boolean hasText() {
        return this.clip.hasPrimaryClip() && this.clip.getPrimaryClipDescription().hasMimeType("text/plain");
    }

    @Override // jackpal.androidterm.emulatorview.compat.ClipboardManagerCompat
    public void setText(CharSequence charSequence) {
        this.clip.setPrimaryClip(ClipData.newPlainText("simple text", charSequence));
    }
}
