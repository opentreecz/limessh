package jackpal.androidterm.emulatorview;

/* loaded from: classes.dex */
public class GrowableIntArray {
    public int[] mData;
    public int mLength = 0;

    public GrowableIntArray(int i) {
        this.mData = new int[i];
    }

    public void append(int i) {
        int i2 = this.mLength + 1;
        int[] iArr = this.mData;
        if (i2 > iArr.length) {
            int[] iArr2 = new int[Math.max((iArr.length * 3) >> 1, 16)];
            System.arraycopy(this.mData, 0, iArr2, 0, this.mLength);
            this.mData = iArr2;
        }
        int[] iArr3 = this.mData;
        int i3 = this.mLength;
        this.mLength = i3 + 1;
        iArr3[i3] = i;
    }

    /* renamed from: at */
    public int m10692at(int i) {
        return this.mData[i];
    }

    public int length() {
        return this.mLength;
    }
}
