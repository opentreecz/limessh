package jackpal.androidterm.emulatorview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import cz.opentree.juicessh.R;
import jackpal.androidterm.emulatorview.compat.AndroidCompat;

/* loaded from: classes.dex */
public class Bitmap4x8FontRenderer extends BaseTextRenderer {
    private static final float BYTE_SCALE = 0.003921569f;
    private static final int kCharacterHeight = 8;
    private static final int kCharacterWidth = 4;
    private float[] mColorMatrix;
    private int mCurrentBackColor;
    private int mCurrentForeColor;
    private Bitmap mFont;
    private Paint mPaint;

    public Bitmap4x8FontRenderer(Resources resources, ColorScheme colorScheme) {
        super(colorScheme);
        this.mFont = BitmapFactory.decodeResource(resources, AndroidCompat.SDK <= 3 ? R.drawable.atari_small : R.drawable.atari_small_nodpi);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private void drawTextRunHelper(Canvas canvas, float f, float f2, int i, char[] cArr, int i2, int i3, int i4, int i5) {
        int[] iArr = this.mPalette;
        setColorMatrix(iArr[i4], iArr[i5]);
        int i6 = ((int) f) + (i * 4);
        int i7 = (int) f2;
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        rect2.top = i7 - 8;
        rect2.bottom = i7;
        int[] iArr2 = this.mPalette;
        boolean z = iArr2[i5] != iArr2[257];
        for (int i8 = 0; i8 < i3; i8++) {
            char c = cArr[i8 + i2];
            if (c < 128 && (c != ' ' || z)) {
                int i9 = (c & 31) * 4;
                int i10 = ((c >> 5) & 3) * 8;
                rect.set(i9, i10, i9 + 4, i10 + 8);
                rect2.left = i6;
                rect2.right = i6 + 4;
                canvas.drawBitmap(this.mFont, rect, rect2, this.mPaint);
            }
            i6 += 4;
        }
    }

    private void setColorMatrix(int i, int i2) {
        if (i == this.mCurrentForeColor && i2 == this.mCurrentBackColor && this.mColorMatrix != null) {
            return;
        }
        this.mCurrentForeColor = i;
        this.mCurrentBackColor = i2;
        if (this.mColorMatrix == null) {
            float[] fArr = new float[20];
            this.mColorMatrix = fArr;
            fArr[18] = 1.0f;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            float[] fArr2 = this.mColorMatrix;
            fArr2[i3 * 6] = (((i2 >> r1) & 255) - r2) * BYTE_SCALE;
            fArr2[(i3 * 5) + 4] = (i >> ((2 - i3) << 3)) & 255;
        }
        this.mPaint.setColorFilter(new ColorMatrixColorFilter(this.mColorMatrix));
    }

    @Override // jackpal.androidterm.emulatorview.BaseTextRenderer, jackpal.androidterm.emulatorview.TextRenderer
    public void drawTextRun(Canvas canvas, float f, float f2, int i, int i2, char[] cArr, int i3, int i4, boolean z, int i5, int i6, int i7, int i8, int i9, int i10) {
        int decodeForeColor = TextStyle.decodeForeColor(i5);
        int decodeBackColor = TextStyle.decodeBackColor(i5);
        int decodeEffect = TextStyle.decodeEffect(i5);
        if (this.mReverseVideo ^ ((decodeEffect & 18) != 0)) {
            decodeBackColor = decodeForeColor;
            decodeForeColor = decodeBackColor;
        }
        if (((decodeEffect & 1) != 0) && decodeForeColor < 8) {
            decodeForeColor += 8;
        }
        if (((decodeEffect & 8) != 0) && decodeBackColor < 8) {
            decodeBackColor += 8;
        }
        if (z) {
            decodeBackColor = TextStyle.ciCursorBackground;
        }
        int i11 = decodeBackColor;
        drawTextRunHelper(canvas, f, f2, i, cArr, i3, i4, (decodeEffect & 32) != 0 ? i11 : decodeForeColor, i11);
        if (i > i6 || i6 >= i + i4) {
            return;
        }
        drawTextRunHelper(canvas, f, f2, i6, cArr, i6 - i, 1, TextStyle.ciCursorForeground, TextStyle.ciCursorBackground);
    }

    @Override // jackpal.androidterm.emulatorview.BaseTextRenderer, jackpal.androidterm.emulatorview.TextRenderer
    public int getCharacterHeight() {
        return 8;
    }

    @Override // jackpal.androidterm.emulatorview.BaseTextRenderer, jackpal.androidterm.emulatorview.TextRenderer
    public float getCharacterWidth() {
        return 4.0f;
    }

    @Override // jackpal.androidterm.emulatorview.BaseTextRenderer, jackpal.androidterm.emulatorview.TextRenderer
    public int getTopMargin() {
        return 0;
    }
}
