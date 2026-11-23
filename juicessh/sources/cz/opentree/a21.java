package cz.opentree;

/* loaded from: classes.dex */
public final class a21 extends vt0 {

    /* renamed from: O */
    public int f1323O;

    /* renamed from: P */
    public byte[] f1324P;

    public a21(int i, byte[] bArr) {
        super(true);
        if (bArr.length != c21.m2659b(i)) {
            throw new IllegalArgumentException("invalid key size for security category");
        }
        this.f1323O = i;
        this.f1324P = e51.m3436e(bArr);
    }

    /* renamed from: a */
    public byte[] m1974a() {
        return e51.m3436e(this.f1324P);
    }

    /* renamed from: b */
    public int m1975b() {
        return this.f1323O;
    }
}
