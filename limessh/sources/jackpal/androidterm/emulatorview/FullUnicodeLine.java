package jackpal.androidterm.emulatorview;

/* compiled from: UnicodeTranscript.java */
/* loaded from: classes.dex */
public class FullUnicodeLine {
    private static final float SPARE_CAPACITY_FACTOR = 1.5f;
    private int mColumns;
    private short[] mOffset;
    private char[] mText;

    public FullUnicodeLine(int i) {
        commonConstructor(i);
        char[] cArr = this.mText;
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = ' ';
        }
        this.mOffset[0] = (short) i;
    }

    public FullUnicodeLine(char[] cArr) {
        commonConstructor(cArr.length);
        System.arraycopy(cArr, 0, this.mText, 0, this.mColumns);
        this.mOffset[0] = (short) cArr.length;
    }

    private void commonConstructor(int i) {
        this.mColumns = i;
        this.mOffset = new short[i];
        this.mText = new char[(int) (i * 1.5f)];
    }

    public int findStartOfColumn(int i) {
        if (i == 0) {
            return 0;
        }
        return i + this.mOffset[i];
    }

    public boolean getChar(int i, int i2, char[] cArr, int i3) {
        int findStartOfColumn = findStartOfColumn(i);
        int i4 = i + 1;
        int findStartOfColumn2 = (i4 < this.mColumns ? findStartOfColumn(i4) : getSpaceUsed()) - findStartOfColumn;
        if (i2 >= findStartOfColumn2) {
            throw new IllegalArgumentException();
        }
        cArr[i3] = this.mText[findStartOfColumn + i2];
        return i2 + 1 < findStartOfColumn2;
    }

    public char[] getLine() {
        return this.mText;
    }

    public int getSpaceUsed() {
        return this.mOffset[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x010c, code lost:
    
        if (r13 != 2) goto L77;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0193 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0112 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0088  */
    /* JADX WARN: Type inference failed for: r6v18, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setChar(int r20, int r21) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jackpal.androidterm.emulatorview.FullUnicodeLine.setChar(int, int):void");
    }
}
