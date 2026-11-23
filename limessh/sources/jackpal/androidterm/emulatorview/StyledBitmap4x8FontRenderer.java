package jackpal.androidterm.emulatorview;

import android.content.res.Resources;
import android.graphics.Canvas;

/* loaded from: classes.dex */
public class StyledBitmap4x8FontRenderer extends Bitmap4x8FontRenderer {
    public StyledBitmap4x8FontRenderer(Resources resources, ColorScheme colorScheme, int[] iArr) {
        super(resources, colorScheme);
        if (iArr == null || iArr.length != 260) {
            return;
        }
        this.mPalette = iArr;
    }

    @Override // jackpal.androidterm.emulatorview.Bitmap4x8FontRenderer, jackpal.androidterm.emulatorview.BaseTextRenderer, jackpal.androidterm.emulatorview.TextRenderer
    public /* bridge */ /* synthetic */ void drawTextRun(Canvas canvas, float f, float f2, int i, int i2, char[] cArr, int i3, int i4, boolean z, int i5, int i6, int i7, int i8, int i9, int i10) {
        super.drawTextRun(canvas, f, f2, i, i2, cArr, i3, i4, z, i5, i6, i7, i8, i9, i10);
    }

    @Override // jackpal.androidterm.emulatorview.Bitmap4x8FontRenderer, jackpal.androidterm.emulatorview.BaseTextRenderer, jackpal.androidterm.emulatorview.TextRenderer
    public /* bridge */ /* synthetic */ int getCharacterHeight() {
        return super.getCharacterHeight();
    }

    @Override // jackpal.androidterm.emulatorview.Bitmap4x8FontRenderer, jackpal.androidterm.emulatorview.BaseTextRenderer, jackpal.androidterm.emulatorview.TextRenderer
    public /* bridge */ /* synthetic */ float getCharacterWidth() {
        return super.getCharacterWidth();
    }

    @Override // jackpal.androidterm.emulatorview.Bitmap4x8FontRenderer, jackpal.androidterm.emulatorview.BaseTextRenderer, jackpal.androidterm.emulatorview.TextRenderer
    public /* bridge */ /* synthetic */ int getTopMargin() {
        return super.getTopMargin();
    }

    @Override // jackpal.androidterm.emulatorview.BaseTextRenderer, jackpal.androidterm.emulatorview.TextRenderer
    public /* bridge */ /* synthetic */ void setReverseVideo(boolean z) {
        super.setReverseVideo(z);
    }
}
