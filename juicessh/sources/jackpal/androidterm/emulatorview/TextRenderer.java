package jackpal.androidterm.emulatorview;

import android.graphics.Canvas;

/* loaded from: classes.dex */
public interface TextRenderer {
    public static final int MODE_ALT_SHIFT = 2;
    public static final int MODE_CTRL_SHIFT = 4;
    public static final int MODE_FN_SHIFT = 6;
    public static final int MODE_LOCKED = 2;
    public static final int MODE_MASK = 3;
    public static final int MODE_OFF = 0;
    public static final int MODE_ON = 1;
    public static final int MODE_SHIFT_SHIFT = 0;

    void drawTextRun(Canvas canvas, float f, float f2, int i, int i2, char[] cArr, int i3, int i4, boolean z, int i5, int i6, int i7, int i8, int i9, int i10);

    int getCharacterHeight();

    float getCharacterWidth();

    int getTopMargin();

    void setReverseVideo(boolean z);
}
