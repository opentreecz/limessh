package jackpal.androidterm.emulatorview;

/* loaded from: classes.dex */
public final class StyleRow {
    private int mColumns;
    private byte[] mData;
    private int mStyle;

    public StyleRow(int i, int i2) {
        this.mStyle = i;
        this.mColumns = i2;
    }

    private void allocate() {
        this.mData = new byte[this.mColumns * 3];
        for (int i = 0; i < this.mColumns; i++) {
            setStyle(i, this.mStyle);
        }
    }

    private int getStyle(int i) {
        int i2 = i * 3;
        byte[] bArr = this.mData;
        return ((bArr[i2 + 2] & 255) << 16) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8);
    }

    private void setStyle(int i, int i2) {
        int i3 = i * 3;
        byte[] bArr = this.mData;
        bArr[i3] = (byte) (i2 & 255);
        bArr[i3 + 1] = (byte) ((i2 >> 8) & 255);
        bArr[i3 + 2] = (byte) ((i2 >> 16) & 255);
    }

    public void copy(int i, StyleRow styleRow, int i2, int i3) {
        if (this.mData == null && styleRow.mData == null && i == 0 && i2 == 0 && i3 == this.mColumns) {
            styleRow.mStyle = this.mStyle;
            return;
        }
        ensureData();
        styleRow.ensureData();
        System.arraycopy(this.mData, i * 3, styleRow.mData, i2 * 3, i3 * 3);
    }

    public void ensureData() {
        if (this.mData == null) {
            allocate();
        }
    }

    public int get(int i) {
        return this.mData == null ? this.mStyle : getStyle(i);
    }

    public int getSolidStyle() {
        if (this.mData == null) {
            return this.mStyle;
        }
        throw new IllegalArgumentException("Not a solid style");
    }

    public boolean isSolidStyle() {
        return this.mData == null;
    }

    public void set(int i, int i2) {
        if (i2 == this.mStyle && this.mData == null) {
            return;
        }
        ensureData();
        setStyle(i, i2);
    }
}
