package cz.opentree;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.ym */
/* loaded from: classes.dex */
public final class C2359ym extends C0722an {

    /* renamed from: S */
    public final int f8275S;

    /* renamed from: T */
    public final int f8276T;

    public C2359ym(byte[] bArr, int i, int i2) {
        super(bArr);
        AbstractC1939tm.m8765p(i, i + i2, bArr.length);
        this.f8275S = i;
        this.f8276T = i2;
    }

    @Override // cz.opentree.C0722an, cz.opentree.AbstractC1939tm
    /* renamed from: e */
    public final byte mo2149e(int i) {
        int mo2150f = mo2150f();
        if (((mo2150f - (i + 1)) | i) >= 0) {
            return this.f1453R[this.f8275S + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(mo2150f);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // cz.opentree.C0722an, cz.opentree.AbstractC1939tm
    /* renamed from: f */
    public final int mo2150f() {
        return this.f8276T;
    }

    @Override // cz.opentree.C0722an, cz.opentree.AbstractC1939tm
    /* renamed from: o */
    public final byte mo2155o(int i) {
        return this.f1453R[this.f8275S + i];
    }

    @Override // cz.opentree.C0722an
    /* renamed from: v */
    public final int mo2158v() {
        return this.f8275S;
    }
}
