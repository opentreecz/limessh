package jackpal.androidterm.emulatorview;

/* loaded from: classes.dex */
public class ByteQueue {
    private byte[] mBuffer;
    private int mHead;
    private int mStoredBytes;

    public ByteQueue(int i) {
        this.mBuffer = new byte[i];
    }

    public int getBytesAvailable() {
        int i;
        synchronized (this) {
            i = this.mStoredBytes;
        }
        return i;
    }

    public int read(byte[] bArr, int i, int i2) throws InterruptedException {
        int i3;
        int i4;
        if (i2 + i > bArr.length) {
            throw new IllegalArgumentException("length + offset > buffer.length");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("length < 0");
        }
        if (i2 == 0) {
            return 0;
        }
        synchronized (this) {
            while (true) {
                i3 = this.mStoredBytes;
                if (i3 != 0) {
                    break;
                }
                wait();
            }
            int length = this.mBuffer.length;
            boolean z = length == i3;
            i4 = 0;
            while (i2 > 0) {
                int i5 = this.mStoredBytes;
                if (i5 <= 0) {
                    break;
                }
                int min = Math.min(i2, Math.min(length - this.mHead, i5));
                System.arraycopy(this.mBuffer, this.mHead, bArr, i, min);
                int i6 = this.mHead + min;
                this.mHead = i6;
                if (i6 >= length) {
                    this.mHead = 0;
                }
                this.mStoredBytes -= min;
                i2 -= min;
                i += min;
                i4 += min;
            }
            if (z) {
                notify();
            }
        }
        return i4;
    }

    public int write(byte[] bArr, int i, int i2) throws InterruptedException {
        int i3;
        int i4;
        int min;
        if (i2 + i > bArr.length) {
            throw new IllegalArgumentException("length + offset > buffer.length");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("length < 0");
        }
        if (i2 == 0) {
            return 0;
        }
        synchronized (this) {
            int length = this.mBuffer.length;
            boolean z = this.mStoredBytes == 0;
            while (true) {
                i3 = this.mStoredBytes;
                if (length != i3) {
                    break;
                }
                wait();
            }
            int i5 = this.mHead;
            int i6 = i3 + i5;
            if (i6 >= length) {
                i6 -= length;
                i4 = i5 - i6;
            } else {
                i4 = length - i6;
            }
            min = Math.min(i4, i2);
            System.arraycopy(bArr, i, this.mBuffer, i6, min);
            this.mStoredBytes += min;
            if (z) {
                notify();
            }
        }
        return min;
    }
}
