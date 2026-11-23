package jackpal.androidterm.emulatorview;

import android.graphics.Canvas;
import java.util.Arrays;

/* loaded from: classes.dex */
public class TranscriptScreen implements Screen {
    private int mColumns;
    private UnicodeTranscript mData;
    private int mScreenRows;
    private int mTotalRows;

    public TranscriptScreen(int i, int i2, int i3, ColorScheme colorScheme) {
        init(i, i2, i3, TextStyle.kNormalTextStyle);
    }

    private void init(int i, int i2, int i3, int i4) {
        this.mColumns = i;
        this.mTotalRows = i2;
        this.mScreenRows = i3;
        UnicodeTranscript unicodeTranscript = new UnicodeTranscript(i, i2, i3, i4);
        this.mData = unicodeTranscript;
        unicodeTranscript.blockSet(0, 0, this.mColumns, this.mScreenRows, 32, i4);
    }

    private String internalGetTranscriptText(GrowableIntArray growableIntArray, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        StringBuilder sb = new StringBuilder();
        UnicodeTranscript unicodeTranscript = this.mData;
        int i7 = this.mColumns;
        int i8 = i2 < (-unicodeTranscript.getActiveTranscriptRows()) ? -unicodeTranscript.getActiveTranscriptRows() : i2;
        int i9 = this.mScreenRows;
        int i10 = i4 >= i9 ? i9 - 1 : i4;
        StyleRow styleRow = null;
        int i11 = i8;
        while (i11 <= i10) {
            int i12 = 0;
            int i13 = i11 == i8 ? i : 0;
            if (i11 != i10 || (i5 = i3 + 1) > i7) {
                i5 = i7;
            }
            char[] line = unicodeTranscript.getLine(i11, i13, i5);
            if (growableIntArray != null) {
                styleRow = unicodeTranscript.getLineColor(i11, i13, i5);
            }
            if (line == null) {
                if (!unicodeTranscript.getLineWrap(i11) && i11 < i10 && i11 < this.mScreenRows - 1) {
                    sb.append('\n');
                    if (growableIntArray != null) {
                        growableIntArray.append(0);
                    }
                }
                i6 = i8;
            } else {
                int defaultStyle = this.mData.getDefaultStyle();
                int length = line.length;
                int i14 = i5 - i13;
                i6 = i8;
                int i15 = 0;
                int i16 = -1;
                while (i12 < length && i15 < i14) {
                    int i17 = i14;
                    char c = line[i12];
                    if (c == 0) {
                        break;
                    }
                    int i18 = length;
                    if (c != ' ' || (styleRow != null && styleRow.get(i15) != defaultStyle)) {
                        i16 = i12;
                    }
                    if (!Character.isLowSurrogate(c)) {
                        i15 += UnicodeTranscript.charWidth(line, i12);
                    }
                    i12++;
                    i14 = i17;
                    length = i18;
                }
                if (unicodeTranscript.getLineWrap(i11) && i16 > -1 && i5 == i7) {
                    i16 = i12 - 1;
                }
                sb.append(line, 0, i16 + 1);
                if (growableIntArray != null) {
                    if (styleRow != null) {
                        int i19 = 0;
                        int i20 = 0;
                        while (i20 <= i16) {
                            growableIntArray.append(styleRow.get(i19));
                            i19 += UnicodeTranscript.charWidth(line, i20);
                            if (Character.isHighSurrogate(line[i20])) {
                                i20++;
                            }
                            i20++;
                        }
                    } else {
                        int i21 = 0;
                        while (i21 <= i16) {
                            growableIntArray.append(defaultStyle);
                            if (Character.isHighSurrogate(line[i21])) {
                                i21++;
                            }
                            i21++;
                        }
                    }
                }
                if (!unicodeTranscript.getLineWrap(i11) && i11 < i10 && i11 < this.mScreenRows - 1) {
                    sb.append('\n');
                    if (growableIntArray != null) {
                        growableIntArray.append(0);
                    }
                }
            }
            i11++;
            i8 = i6;
        }
        return sb.toString();
    }

    @Override // jackpal.androidterm.emulatorview.Screen
    public void blockCopy(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mData.blockCopy(i, i2, i3, i4, i5, i6);
    }

    @Override // jackpal.androidterm.emulatorview.Screen
    public void blockSet(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mData.blockSet(i, i2, i3, i4, i5, i6);
    }

    public final void drawText(int i, Canvas canvas, float f, float f2, TextRenderer textRenderer, int i2, int i3, int i4, String str, int i5) {
        int charWidth;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        StyleRow styleRow;
        char[] cArr;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z;
        int i16;
        int i17;
        int i18 = i2;
        int i19 = i3;
        int i20 = i4;
        try {
            char[] line = this.mData.getLine(i);
            StyleRow lineColor = this.mData.getLineColor(i);
            int defaultStyle = this.mData.getDefaultStyle();
            if (line == null) {
                if (i19 != i20) {
                    int i21 = i20 - i19;
                    char[] cArr2 = new char[i21];
                    Arrays.fill(cArr2, ' ');
                    textRenderer.drawTextRun(canvas, f, f2, i3, i21, cArr2, 0, 1, true, defaultStyle, i2, 0, 1, 1, i5);
                    i16 = i2;
                    i17 = -1;
                } else {
                    i16 = i2;
                    i17 = -1;
                }
                if (i16 != i17) {
                    char[] cArr3 = new char[1];
                    Arrays.fill(cArr3, ' ');
                    textRenderer.drawTextRun(canvas, f, f2, i2, 1, cArr3, 0, 1, true, defaultStyle, i2, 0, 1, 1, i5);
                    return;
                }
                return;
            }
            int i22 = 1;
            int i23 = this.mColumns;
            int i24 = -1;
            int i25 = -1;
            int i26 = 1;
            boolean z2 = false;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            int i32 = 0;
            int i33 = 0;
            while (i28 < i23 && i27 < line.length) {
                int i34 = lineColor.get(i28);
                if (Character.isHighSurrogate(line[i27])) {
                    charWidth = UnicodeTranscript.charWidth(line, i27);
                    i6 = 2;
                } else {
                    charWidth = UnicodeTranscript.charWidth(line[i27]);
                    i6 = i22;
                }
                int i35 = charWidth;
                int i36 = (i28 < i19 || i28 > i20) ? 0 : i22;
                if (i34 == i29 && i36 == i31 && (i35 <= 0 || !z2)) {
                    i7 = i35;
                    i8 = i27;
                    i15 = i30;
                    i11 = i23;
                    styleRow = lineColor;
                    cArr = line;
                    i13 = i2;
                    z = z2;
                    i14 = i28;
                } else {
                    if (i24 >= 0) {
                        i8 = i27;
                        i7 = i35;
                        i10 = i34;
                        i11 = i23;
                        styleRow = lineColor;
                        cArr = line;
                        i9 = i28;
                        i12 = i36;
                        i13 = i2;
                        textRenderer.drawTextRun(canvas, f, f2, i24, i30, line, i25, i27 - i25, i31, i29, i2, i32, i33, i26, i5);
                    } else {
                        i7 = i35;
                        i8 = i27;
                        i9 = i28;
                        i10 = i34;
                        i11 = i23;
                        styleRow = lineColor;
                        cArr = line;
                        i12 = i36;
                        i13 = i2;
                    }
                    i14 = i9;
                    i24 = i14;
                    i25 = i8;
                    i31 = i12;
                    i29 = i10;
                    i15 = 0;
                    z = false;
                }
                if (i13 == i14) {
                    i33 = i6;
                    i32 = i8;
                    i26 = i7;
                }
                i30 = i15 + i7;
                i28 = i14 + i7;
                i27 = i8 + i6;
                z2 = i7 > 1 ? true : z;
                i19 = i3;
                i20 = i4;
                i18 = i13;
                i22 = 1;
                lineColor = styleRow;
                i23 = i11;
                line = cArr;
            }
            int i37 = i27;
            int i38 = i29;
            boolean z3 = i31;
            int i39 = i23;
            char[] cArr4 = line;
            int i40 = i18;
            if (i24 >= 0) {
                textRenderer.drawTextRun(canvas, f, f2, i24, i30, cArr4, i25, i37 - i25, z3, i38, i2, i32, i33, i26, i5);
            }
            if (i40 < 0 || str.length() <= 0) {
                return;
            }
            int min = Math.min(i39, str.length());
            textRenderer.drawTextRun(canvas, f, f2, Math.min(i40, i39 - min), min, str.toCharArray(), str.length() - min, min, true, TextStyle.encode(15, 0, 0), -1, 0, 0, 0, 0);
        } catch (IllegalArgumentException | NullPointerException unused) {
        }
    }

    @Override // jackpal.androidterm.emulatorview.Screen
    public boolean fastResize(int i, int i2, int[] iArr) {
        UnicodeTranscript unicodeTranscript = this.mData;
        if (unicodeTranscript == null) {
            return true;
        }
        if (!unicodeTranscript.resize(i, i2, iArr)) {
            return false;
        }
        this.mColumns = i;
        this.mScreenRows = i2;
        return true;
    }

    public void finish() {
        this.mData = null;
    }

    @Override // jackpal.androidterm.emulatorview.Screen
    public int getActiveRows() {
        return this.mData.getActiveRows();
    }

    public int getActiveTranscriptRows() {
        UnicodeTranscript unicodeTranscript = this.mData;
        if (unicodeTranscript == null) {
            return 0;
        }
        return unicodeTranscript.getActiveTranscriptRows();
    }

    public char[] getScriptLine(int i) {
        try {
            return this.mData.getLine(i);
        } catch (IllegalArgumentException | NullPointerException unused) {
            return null;
        }
    }

    public boolean getScriptLineWrap(int i) {
        return this.mData.getLineWrap(i);
    }

    @Override // jackpal.androidterm.emulatorview.Screen
    public String getSelectedText(int i, int i2, int i3, int i4) {
        return internalGetTranscriptText(null, i, i2, i3, i4);
    }

    @Override // jackpal.androidterm.emulatorview.Screen
    public String getSelectedText(GrowableIntArray growableIntArray, int i, int i2, int i3, int i4) {
        return internalGetTranscriptText(growableIntArray, i, i2, i3, i4);
    }

    @Override // jackpal.androidterm.emulatorview.Screen
    public String getTranscriptText() {
        return internalGetTranscriptText(null, 0, -this.mData.getActiveTranscriptRows(), this.mColumns, this.mScreenRows);
    }

    @Override // jackpal.androidterm.emulatorview.Screen
    public String getTranscriptText(GrowableIntArray growableIntArray) {
        return internalGetTranscriptText(growableIntArray, 0, -this.mData.getActiveTranscriptRows(), this.mColumns, this.mScreenRows);
    }

    public boolean isBasicLine(int i) {
        UnicodeTranscript unicodeTranscript = this.mData;
        if (unicodeTranscript != null) {
            return unicodeTranscript.isBasicLine(i);
        }
        return true;
    }

    @Override // jackpal.androidterm.emulatorview.Screen
    public void resize(int i, int i2, int i3) {
        if (i2 > this.mTotalRows) {
            this.mTotalRows = i2;
        }
        init(i, this.mTotalRows, i2, i3);
    }

    @Override // jackpal.androidterm.emulatorview.Screen
    public void scroll(int i, int i2, int i3) {
        this.mData.scroll(i, i2, i3);
    }

    @Override // jackpal.androidterm.emulatorview.Screen
    public void set(int i, int i2, byte b, int i3) {
        this.mData.setChar(i, i2, b, i3);
    }

    @Override // jackpal.androidterm.emulatorview.Screen
    public void set(int i, int i2, int i3, int i4) {
        this.mData.setChar(i, i2, i3, i4);
    }

    public void setColorScheme(ColorScheme colorScheme) {
        this.mData.setDefaultStyle(TextStyle.kNormalTextStyle);
    }

    @Override // jackpal.androidterm.emulatorview.Screen
    public void setLineWrap(int i) {
        this.mData.setLineWrap(i);
    }
}
