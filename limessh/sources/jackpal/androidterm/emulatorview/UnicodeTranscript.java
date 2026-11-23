package jackpal.androidterm.emulatorview;

import android.util.Log;
import jackpal.androidterm.emulatorview.compat.AndroidCharacterCompat;
import jackpal.androidterm.emulatorview.compat.AndroidCompat;

/* loaded from: classes.dex */
public class UnicodeTranscript {
    public static final int HANGUL_CONJOINING_MIN_SDK = 16;
    private static final String TAG = "UnicodeTranscript";
    private StyleRow[] mColor;
    private int mColumns;
    private int mDefaultStyle;
    private boolean[] mLineWrap;
    private Object[] mLines;
    private int mScreenRows;
    private int mTotalRows;
    private StyleRow tmpColor;
    private char[] tmpLine;
    private int mActiveTranscriptRows = 0;
    private int mScreenFirstRow = 0;

    public UnicodeTranscript(int i, int i2, int i3, int i4) {
        this.mDefaultStyle = 0;
        this.mColumns = i;
        this.mTotalRows = i2;
        this.mScreenRows = i3;
        this.mLines = new Object[i2];
        this.mColor = new StyleRow[i2];
        this.mLineWrap = new boolean[i2];
        this.tmpColor = new StyleRow(i4, i);
        this.mDefaultStyle = i4;
    }

    private char[] allocateBasicLine(int i, int i2) {
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = ' ';
        }
        this.mLines[i] = cArr;
        StyleRow[] styleRowArr = this.mColor;
        if (styleRowArr[i] == null) {
            styleRowArr[i] = new StyleRow(0, i2);
        }
        return cArr;
    }

    private FullUnicodeLine allocateFullLine(int i, int i2) {
        FullUnicodeLine fullUnicodeLine = new FullUnicodeLine(i2);
        this.mLines[i] = fullUnicodeLine;
        StyleRow[] styleRowArr = this.mColor;
        if (styleRowArr[i] == null) {
            styleRowArr[i] = new StyleRow(0, i2);
        }
        return fullUnicodeLine;
    }

    private void blockCopyLines(int i, int i2, int i3) {
        int i4 = this.mTotalRows;
        int i5 = i + i3;
        int i6 = i5 >= 0 ? i5 % i4 : i4 + i + i3;
        if (i + i2 <= i4 && i6 + i2 <= i4) {
            Object[] objArr = this.mLines;
            System.arraycopy(objArr, i, objArr, i6, i2);
            StyleRow[] styleRowArr = this.mColor;
            System.arraycopy(styleRowArr, i, styleRowArr, i6, i2);
            boolean[] zArr = this.mLineWrap;
            System.arraycopy(zArr, i, zArr, i6, i2);
            return;
        }
        if (i3 < 0) {
            for (int i7 = 0; i7 < i2; i7++) {
                Object[] objArr2 = this.mLines;
                int i8 = (i6 + i7) % i4;
                int i9 = (i + i7) % i4;
                objArr2[i8] = objArr2[i9];
                StyleRow[] styleRowArr2 = this.mColor;
                styleRowArr2[i8] = styleRowArr2[i9];
                boolean[] zArr2 = this.mLineWrap;
                zArr2[i8] = zArr2[i9];
            }
            return;
        }
        for (int i10 = i2 - 1; i10 >= 0; i10--) {
            Object[] objArr3 = this.mLines;
            int i11 = (i6 + i10) % i4;
            int i12 = (i + i10) % i4;
            objArr3[i11] = objArr3[i12];
            StyleRow[] styleRowArr3 = this.mColor;
            styleRowArr3[i11] = styleRowArr3[i12];
            boolean[] zArr3 = this.mLineWrap;
            zArr3[i11] = zArr3[i12];
        }
    }

    public static int charWidth(char c, char c2) {
        return charWidth(Character.toCodePoint(c, c2));
    }

    public static int charWidth(int i) {
        if ((i > 31 && i < 127) || i == 27) {
            return 1;
        }
        int type = Character.getType(i);
        if (type == 6 || type == 7 || type == 15 || type == 16) {
            return 0;
        }
        if ((i >= 4448 && i <= 4607) || (i >= 55216 && i <= 55295)) {
            return AndroidCompat.SDK >= 16 ? 0 : 2;
        }
        if (Character.charCount(i) == 1) {
            int eastAsianWidth = AndroidCharacterCompat.getEastAsianWidth((char) i);
            if (eastAsianWidth == 3 || eastAsianWidth == 5) {
                return 2;
            }
        } else {
            int i2 = (i >> 16) & 15;
            if (i2 == 2 || i2 == 3) {
                return 2;
            }
        }
        return 1;
    }

    public static int charWidth(char[] cArr, int i) {
        char c = cArr[i];
        return Character.isHighSurrogate(c) ? charWidth(c, cArr[i + 1]) : charWidth(c);
    }

    private int externalToInternalRow(int i) {
        if (i >= (-this.mActiveTranscriptRows) && i <= this.mScreenRows) {
            if (i >= 0) {
                return (this.mScreenFirstRow + i) % this.mTotalRows;
            }
            int i2 = -i;
            int i3 = this.mScreenFirstRow;
            return i2 > i3 ? this.mTotalRows + i3 + i : i3 + i;
        }
        String str = "externalToInternalRow " + i + " " + this.mScreenRows + " " + this.mActiveTranscriptRows;
        Log.e(TAG, str);
        throw new IllegalArgumentException(str);
    }

    private char[] getLine(int i, int i2, int i3, boolean z) {
        int spaceUsed;
        if (i < (-this.mActiveTranscriptRows) || i > this.mScreenRows - 1) {
            throw new IllegalArgumentException();
        }
        int i4 = this.mColumns;
        int externalToInternalRow = externalToInternalRow(i);
        Object[] objArr = this.mLines;
        if (objArr[externalToInternalRow] == null) {
            return null;
        }
        if (objArr[externalToInternalRow] instanceof char[]) {
            if (i2 == 0 && i3 == i4) {
                return (char[]) objArr[externalToInternalRow];
            }
            char[] cArr = this.tmpLine;
            if (cArr == null || cArr.length < i4 + 1) {
                this.tmpLine = new char[i4 + 1];
            }
            int i5 = i3 - i2;
            System.arraycopy(objArr[externalToInternalRow], i2, this.tmpLine, 0, i5);
            char[] cArr2 = this.tmpLine;
            cArr2[i5] = 0;
            return cArr2;
        }
        FullUnicodeLine fullUnicodeLine = (FullUnicodeLine) objArr[externalToInternalRow];
        char[] line = fullUnicodeLine.getLine();
        if (i2 == 0 && i3 == i4) {
            int spaceUsed2 = fullUnicodeLine.getSpaceUsed();
            if (spaceUsed2 < line.length) {
                line[spaceUsed2] = 0;
            }
            return line;
        }
        int findStartOfColumn = fullUnicodeLine.findStartOfColumn(i2);
        if (i3 < i4) {
            spaceUsed = fullUnicodeLine.findStartOfColumn(i3);
            if (!z && i3 > 0 && i3 < i4 - 1 && spaceUsed == fullUnicodeLine.findStartOfColumn(i3 - 1)) {
                spaceUsed = fullUnicodeLine.findStartOfColumn(i3 + 1);
            }
        } else {
            spaceUsed = fullUnicodeLine.getSpaceUsed();
        }
        int i6 = spaceUsed - findStartOfColumn;
        char[] cArr3 = this.tmpLine;
        if (cArr3 == null || cArr3.length < i6 + 1) {
            this.tmpLine = new char[i6 + 1];
        }
        System.arraycopy(line, findStartOfColumn, this.tmpLine, 0, i6);
        char[] cArr4 = this.tmpLine;
        cArr4[i6] = 0;
        return cArr4;
    }

    private StyleRow getLineColor(int i, int i2, int i3, boolean z) {
        if (i < (-this.mActiveTranscriptRows) || i > this.mScreenRows - 1) {
            throw new IllegalArgumentException();
        }
        int externalToInternalRow = externalToInternalRow(i);
        StyleRow styleRow = this.mColor[externalToInternalRow];
        StyleRow styleRow2 = this.tmpColor;
        if (styleRow == null) {
            return null;
        }
        int i4 = this.mColumns;
        if (!z) {
            Object[] objArr = this.mLines;
            if (objArr[externalToInternalRow] != null && (objArr[externalToInternalRow] instanceof FullUnicodeLine)) {
                FullUnicodeLine fullUnicodeLine = (FullUnicodeLine) objArr[externalToInternalRow];
                if (i2 > 0 && fullUnicodeLine.findStartOfColumn(i2 - 1) == fullUnicodeLine.findStartOfColumn(i2)) {
                    i2--;
                }
                if (i3 < i4 - 1) {
                    int i5 = i3 + 1;
                    if (fullUnicodeLine.findStartOfColumn(i5) == fullUnicodeLine.findStartOfColumn(i3)) {
                        i3 = i5;
                    }
                }
            }
        }
        if (i2 == 0 && i3 == i4) {
            return styleRow;
        }
        styleRow.copy(i2, styleRow2, 0, i3 - i2);
        return styleRow2;
    }

    private boolean isBasicChar(int i) {
        return charWidth(i) == 1 && Character.charCount(i) == 1;
    }

    public void blockCopy(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int charWidth;
        int i12;
        StyleRow[] styleRowArr;
        int i13;
        Object[] objArr;
        int i14;
        int i15;
        int charWidth2;
        int i16 = i2;
        int i17 = i4;
        if (i >= 0 && (i7 = i + i3) <= (i8 = this.mColumns) && i16 >= 0) {
            int i18 = i16 + i17;
            int i19 = this.mScreenRows;
            if (i18 <= i19 && i5 >= 0 && i5 + i3 <= i8 && i6 >= 0 && i6 + i17 <= i19) {
                Object[] objArr2 = this.mLines;
                StyleRow[] styleRowArr2 = this.mColor;
                if (i16 <= i6) {
                    int i20 = i7;
                    int i21 = 0;
                    while (i21 < i17) {
                        int i22 = i21 + 1;
                        int i23 = i17 - i22;
                        int i24 = i16 + i23;
                        int externalToInternalRow = externalToInternalRow(i24);
                        int i25 = i6 + i23;
                        int externalToInternalRow2 = externalToInternalRow(i25);
                        if ((objArr2[externalToInternalRow] instanceof char[]) && (objArr2[externalToInternalRow2] instanceof char[])) {
                            System.arraycopy(objArr2[externalToInternalRow], i, objArr2[externalToInternalRow2], i5, i3);
                            i9 = i20;
                        } else {
                            i9 = i20;
                            char[] line = getLine(i24, i, i9, true);
                            if (line == null) {
                                blockSet(i5, i25, i3, 1, 32, this.mDefaultStyle);
                                i16 = i2;
                                i17 = i4;
                                i21 = i22;
                                i20 = i9;
                            } else {
                                int i26 = this.mColumns;
                                int i27 = 0;
                                int i28 = 0;
                                char c = 0;
                                while (i27 < line.length && line[i27] != 0 && (i10 = i5 + i28) < i26) {
                                    if (Character.isHighSurrogate(line[i27])) {
                                        c = line[i27];
                                        i11 = i26;
                                    } else {
                                        if (Character.isLowSurrogate(line[i27])) {
                                            i11 = i26;
                                            int codePoint = Character.toCodePoint(c, line[i27]);
                                            setChar(i10, i25, codePoint);
                                            charWidth = charWidth(codePoint);
                                        } else {
                                            i11 = i26;
                                            setChar(i10, i25, line[i27]);
                                            charWidth = charWidth(line[i27]);
                                        }
                                        i28 += charWidth;
                                    }
                                    i27++;
                                    i26 = i11;
                                }
                            }
                        }
                        styleRowArr2[externalToInternalRow].copy(i, styleRowArr2[externalToInternalRow2], i5, i3);
                        i16 = i2;
                        i17 = i4;
                        i21 = i22;
                        i20 = i9;
                    }
                    return;
                }
                int i29 = 0;
                while (i29 < i17) {
                    int i30 = i16 + i29;
                    int externalToInternalRow3 = externalToInternalRow(i30);
                    int i31 = i6 + i29;
                    int externalToInternalRow4 = externalToInternalRow(i31);
                    if ((objArr2[externalToInternalRow3] instanceof char[]) && (objArr2[externalToInternalRow4] instanceof char[])) {
                        System.arraycopy(objArr2[externalToInternalRow3], i, objArr2[externalToInternalRow4], i5, i3);
                        i12 = i29;
                        styleRowArr = styleRowArr2;
                        i13 = i7;
                        objArr = objArr2;
                    } else {
                        char[] line2 = getLine(i30, i, i7, true);
                        if (line2 == null) {
                            i12 = i29;
                            styleRowArr = styleRowArr2;
                            blockSet(i5, i31, i3, 1, 32, this.mDefaultStyle);
                            i13 = i7;
                            objArr = objArr2;
                            i29 = i12 + 1;
                            styleRowArr2 = styleRowArr;
                            i7 = i13;
                            objArr2 = objArr;
                        } else {
                            i12 = i29;
                            styleRowArr = styleRowArr2;
                            int i32 = this.mColumns;
                            i13 = i7;
                            objArr = objArr2;
                            int i33 = 0;
                            int i34 = 0;
                            char c2 = 0;
                            while (i33 < line2.length && line2[i33] != 0 && (i14 = i5 + i34) < i32) {
                                if (Character.isHighSurrogate(line2[i33])) {
                                    c2 = line2[i33];
                                    i15 = i32;
                                } else {
                                    if (Character.isLowSurrogate(line2[i33])) {
                                        i15 = i32;
                                        int codePoint2 = Character.toCodePoint(c2, line2[i33]);
                                        setChar(i14, i31, codePoint2);
                                        charWidth2 = charWidth(codePoint2);
                                    } else {
                                        i15 = i32;
                                        setChar(i14, i31, line2[i33]);
                                        charWidth2 = charWidth(line2[i33]);
                                    }
                                    i34 += charWidth2;
                                }
                                i33++;
                                i32 = i15;
                            }
                        }
                    }
                    styleRowArr[externalToInternalRow3].copy(i, styleRowArr[externalToInternalRow4], i5, i3);
                    i29 = i12 + 1;
                    styleRowArr2 = styleRowArr;
                    i7 = i13;
                    objArr2 = objArr;
                }
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public void blockSet(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i >= 0 && i + i3 <= this.mColumns && i2 >= 0 && i2 + i4 <= this.mScreenRows) {
            for (int i7 = 0; i7 < i4; i7++) {
                for (int i8 = 0; i8 < i3; i8++) {
                    setChar(i + i8, i2 + i7, i5, i6);
                }
            }
            return;
        }
        Log.e(TAG, "illegal arguments! " + i + " " + i2 + " " + i3 + " " + i4 + " " + i5 + " " + this.mColumns + " " + this.mScreenRows);
        throw new IllegalArgumentException();
    }

    public int getActiveRows() {
        return this.mActiveTranscriptRows + this.mScreenRows;
    }

    public int getActiveTranscriptRows() {
        return this.mActiveTranscriptRows;
    }

    public boolean getChar(int i, int i2) {
        return getChar(i, i2, 0);
    }

    public boolean getChar(int i, int i2, int i3) {
        return getChar(i, i2, i3, new char[1], 0);
    }

    public boolean getChar(int i, int i2, int i3, char[] cArr, int i4) {
        if (i < (-this.mActiveTranscriptRows) || i > this.mScreenRows - 1) {
            throw new IllegalArgumentException();
        }
        int externalToInternalRow = externalToInternalRow(i);
        Object[] objArr = this.mLines;
        if (!(objArr[externalToInternalRow] instanceof char[])) {
            return ((FullUnicodeLine) objArr[externalToInternalRow]).getChar(i2, i3, cArr, i4);
        }
        cArr[i4] = ((char[]) objArr[externalToInternalRow])[i2];
        return false;
    }

    public int getDefaultStyle() {
        return this.mDefaultStyle;
    }

    public char[] getLine(int i) {
        return getLine(i, 0, this.mColumns, true);
    }

    public char[] getLine(int i, int i2, int i3) {
        return getLine(i, i2, i3, false);
    }

    public StyleRow getLineColor(int i) {
        return getLineColor(i, 0, this.mColumns, true);
    }

    public StyleRow getLineColor(int i, int i2, int i3) {
        return getLineColor(i, i2, i3, false);
    }

    public boolean getLineWrap(int i) {
        return this.mLineWrap[externalToInternalRow(i)];
    }

    public boolean isBasicLine(int i) {
        if (i < (-this.mActiveTranscriptRows) || i > this.mScreenRows - 1) {
            throw new IllegalArgumentException();
        }
        return this.mLines[externalToInternalRow(i)] instanceof char[];
    }

    public boolean resize(int i, int i2, int[] iArr) {
        int i3;
        int i4;
        if (i != this.mColumns || i2 > (i3 = this.mTotalRows)) {
            return false;
        }
        int i5 = this.mScreenRows;
        int i6 = this.mActiveTranscriptRows;
        int i7 = i5 - i2;
        int i8 = -i6;
        if (i7 < i8) {
            Object[] objArr = this.mLines;
            StyleRow[] styleRowArr = this.mColor;
            boolean[] zArr = this.mLineWrap;
            int i9 = this.mScreenFirstRow;
            for (int i10 = 0; i10 < i6 - i7; i10++) {
                int i11 = ((i9 + i5) + i10) % i3;
                objArr[i11] = null;
                styleRowArr[i11] = null;
                zArr[i11] = false;
            }
            i7 = i8;
        } else if (i7 > 0 && iArr != null && iArr[1] != (i4 = i5 - 1)) {
            Object[] objArr2 = this.mLines;
            for (i4 = i5 - 1; i4 > iArr[1]; i4--) {
                int externalToInternalRow = externalToInternalRow(i4);
                if (objArr2[externalToInternalRow] != null) {
                    char[] line = objArr2[externalToInternalRow] instanceof char[] ? (char[]) objArr2[externalToInternalRow] : ((FullUnicodeLine) objArr2[externalToInternalRow]).getLine();
                    int length = line.length;
                    int i12 = 0;
                    while (true) {
                        if (i12 >= length) {
                            break;
                        }
                        if (line[i12] == 0) {
                            i12 = length;
                            break;
                        }
                        if (line[i12] != ' ') {
                            break;
                        }
                        i12++;
                    }
                    if (i12 != length || i7 - 1 == 0) {
                        break;
                    }
                } else {
                    i7--;
                    if (i7 == 0) {
                        break;
                    }
                }
            }
        }
        if (i7 > 0 || (i7 < 0 && this.mScreenFirstRow >= (-i7))) {
            this.mScreenFirstRow = (this.mScreenFirstRow + i7) % this.mTotalRows;
        } else if (i7 < 0) {
            this.mScreenFirstRow = this.mTotalRows + this.mScreenFirstRow + i7;
        }
        int i13 = this.mActiveTranscriptRows;
        if (i13 + i7 < 0) {
            this.mActiveTranscriptRows = 0;
        } else {
            this.mActiveTranscriptRows = i13 + i7;
        }
        if (iArr != null) {
            iArr[1] = iArr[1] - i7;
        }
        this.mScreenRows = i2;
        return true;
    }

    public void scroll(int i, int i2, int i3) {
        int i4 = i2 - 1;
        if (i > i4) {
            throw new IllegalArgumentException();
        }
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int i5 = this.mScreenRows;
        if (i2 > i5) {
            throw new IllegalArgumentException();
        }
        int i6 = this.mTotalRows;
        if (i == 0 && i2 == i5) {
            this.mScreenFirstRow = (this.mScreenFirstRow + 1) % i6;
            int i7 = this.mActiveTranscriptRows;
            if (i7 < i6 - i5) {
                this.mActiveTranscriptRows = i7 + 1;
            }
            int externalToInternalRow = externalToInternalRow(i4);
            this.mLines[externalToInternalRow] = null;
            this.mColor[externalToInternalRow] = new StyleRow(i3, this.mColumns);
            this.mLineWrap[externalToInternalRow] = false;
            return;
        }
        int i8 = this.mScreenFirstRow;
        int externalToInternalRow2 = externalToInternalRow(i);
        int externalToInternalRow3 = externalToInternalRow(i2);
        Object[] objArr = this.mLines;
        StyleRow[] styleRowArr = this.mColor;
        boolean[] zArr = this.mLineWrap;
        Object obj = objArr[externalToInternalRow2];
        StyleRow styleRow = styleRowArr[externalToInternalRow2];
        boolean z = zArr[externalToInternalRow2];
        blockCopyLines(i8, i, 1);
        blockCopyLines(externalToInternalRow3, i5 - i2, 1);
        objArr[i8] = obj;
        styleRowArr[i8] = styleRow;
        zArr[i8] = z;
        this.mScreenFirstRow = (i8 + 1) % i6;
        int i9 = this.mActiveTranscriptRows;
        if (i9 < i6 - i5) {
            this.mActiveTranscriptRows = i9 + 1;
        }
        int externalToInternalRow4 = externalToInternalRow(i4);
        objArr[externalToInternalRow4] = null;
        styleRowArr[externalToInternalRow4] = new StyleRow(i3, this.mColumns);
        zArr[externalToInternalRow4] = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean setChar(int i, int i2, int i3) {
        boolean z;
        if (i2 >= this.mScreenRows || i >= this.mColumns) {
            Log.e(TAG, "illegal arguments! " + i2 + " " + i + " " + this.mScreenRows + " " + this.mColumns);
            throw new IllegalArgumentException();
        }
        int externalToInternalRow = externalToInternalRow(i2);
        boolean z2 = false;
        if (this.mLines[externalToInternalRow] != null) {
            z = -1;
        } else if (isBasicChar(i3)) {
            allocateBasicLine(externalToInternalRow, this.mColumns);
            z = 1;
        } else {
            allocateFullLine(externalToInternalRow, this.mColumns);
            z = 0;
        }
        Object[] objArr = this.mLines;
        if (objArr[externalToInternalRow] instanceof char[]) {
            char[] cArr = (char[]) objArr[externalToInternalRow];
            if (z != -1) {
                z2 = z;
            } else if (isBasicChar(i3)) {
                z2 = true;
            }
            if (z2) {
                cArr[i] = (char) i3;
                return true;
            }
            this.mLines[externalToInternalRow] = new FullUnicodeLine(cArr);
        }
        ((FullUnicodeLine) this.mLines[externalToInternalRow]).setChar(i, i3);
        return true;
    }

    public boolean setChar(int i, int i2, int i3, int i4) {
        if (!setChar(i, i2, i3)) {
            return false;
        }
        this.mColor[externalToInternalRow(i2)].set(i, i4);
        return true;
    }

    public void setDefaultStyle(int i) {
        this.mDefaultStyle = i;
    }

    public void setLineWrap(int i) {
        this.mLineWrap[externalToInternalRow(i)] = true;
    }
}
