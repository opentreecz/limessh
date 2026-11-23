package jackpal.androidterm.emulatorview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/* loaded from: classes.dex */
public class PaintRenderer extends BaseTextRenderer {
    private static final char[] EXAMPLE_CHAR = {'X'};
    private int mCharAscent;
    private int mCharDescent;
    private int mCharHeight;
    private float mCharWidth;
    private Paint mTextPaint;

    public PaintRenderer(int i, Typeface typeface, ColorScheme colorScheme) {
        super(colorScheme);
        Paint paint = new Paint();
        this.mTextPaint = paint;
        paint.setTypeface(typeface);
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSize(i);
        this.mCharHeight = (int) Math.ceil(this.mTextPaint.getFontSpacing());
        int ceil = (int) Math.ceil(this.mTextPaint.ascent());
        this.mCharAscent = ceil;
        this.mCharDescent = this.mCharHeight + ceil;
        this.mCharWidth = this.mTextPaint.measureText(EXAMPLE_CHAR, 0, 1);
    }

    @Override // jackpal.androidterm.emulatorview.BaseTextRenderer, jackpal.androidterm.emulatorview.TextRenderer
    public void drawTextRun(Canvas canvas, float f, float f2, int i, int i2, char[] cArr, int i3, int i4, boolean z, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        int decodeForeColor = TextStyle.decodeForeColor(i5);
        int decodeBackColor = TextStyle.decodeBackColor(i5);
        int decodeEffect = TextStyle.decodeEffect(i5);
        if (this.mReverseVideo ^ ((decodeEffect & 18) != 0)) {
            i11 = decodeBackColor;
        } else {
            i11 = decodeForeColor;
            decodeForeColor = decodeBackColor;
        }
        if (z) {
            decodeForeColor = TextStyle.ciCursorBackground;
        }
        if (((decodeEffect & 8) != 0) && decodeForeColor < 8) {
            decodeForeColor += 8;
        }
        this.mTextPaint.setColor(this.mPalette[decodeForeColor]);
        float f3 = this.mCharWidth;
        float f4 = f + (i * f3);
        canvas.drawRect(f4, (f2 + this.mCharAscent) - this.mCharDescent, f4 + (i2 * f3), f2, this.mTextPaint);
        boolean z2 = i3 <= i6 && i6 < i3 + i4;
        if (z2) {
            drawCursorImp(canvas, (int) (f + (i6 * r1)), f2, i9 * this.mCharWidth, this.mCharHeight, i10);
        }
        if ((decodeEffect & 32) != 0) {
            return;
        }
        boolean z3 = (decodeEffect & 1) != 0;
        boolean z4 = (decodeEffect & 4) != 0;
        if (z3) {
            this.mTextPaint.setFakeBoldText(true);
        }
        if (z4) {
            this.mTextPaint.setUnderlineText(true);
        }
        int i12 = (i11 >= 8 || !z3) ? this.mPalette[i11] : this.mPalette[i11 + 8];
        this.mTextPaint.setColor(i12);
        float f5 = f2 - this.mCharDescent;
        if (z2) {
            int i13 = i7 - i3;
            int i14 = i4 - (i13 + 1);
            if (i13 > 0) {
                canvas.drawText(cArr, i3, i13, f4, f5, this.mTextPaint);
            }
            this.mTextPaint.setColor(this.mPalette[258]);
            canvas.drawText(cArr, i7, i8, f + (i6 * this.mCharWidth), f5, this.mTextPaint);
            if (i14 > 0) {
                this.mTextPaint.setColor(i12);
                canvas.drawText(cArr, i7 + i8, i14, f + ((i6 + i9) * this.mCharWidth), f5, this.mTextPaint);
            }
        } else {
            canvas.drawText(cArr, i3, i4, f4, f5, this.mTextPaint);
        }
        if (z3) {
            this.mTextPaint.setFakeBoldText(false);
        }
        if (z4) {
            this.mTextPaint.setUnderlineText(false);
        }
    }

    @Override // jackpal.androidterm.emulatorview.BaseTextRenderer, jackpal.androidterm.emulatorview.TextRenderer
    public int getCharacterHeight() {
        return this.mCharHeight;
    }

    @Override // jackpal.androidterm.emulatorview.BaseTextRenderer, jackpal.androidterm.emulatorview.TextRenderer
    public float getCharacterWidth() {
        return this.mCharWidth;
    }

    @Override // jackpal.androidterm.emulatorview.BaseTextRenderer, jackpal.androidterm.emulatorview.TextRenderer
    public int getTopMargin() {
        return this.mCharDescent;
    }
}
