package jackpal.androidterm.emulatorview.compat;

import android.content.Context;
import android.text.ClipboardManager;

/* loaded from: classes.dex */
public class ClipboardManagerCompatV1 implements ClipboardManagerCompat {
    private final ClipboardManager clip;

    public ClipboardManagerCompatV1(Context context) {
        this.clip = (ClipboardManager) context.getApplicationContext().getSystemService("clipboard");
    }

    @Override // jackpal.androidterm.emulatorview.compat.ClipboardManagerCompat
    public CharSequence getText() {
        return this.clip.getText();
    }

    @Override // jackpal.androidterm.emulatorview.compat.ClipboardManagerCompat
    public boolean hasText() {
        return this.clip.hasText();
    }

    @Override // jackpal.androidterm.emulatorview.compat.ClipboardManagerCompat
    public void setText(CharSequence charSequence) {
        this.clip.setText(charSequence);
    }
}
