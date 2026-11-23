package cz.opentree;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.an */
/* loaded from: classes.dex */
public class C0722an extends AbstractC0789bn {

    /* renamed from: R */
    public final byte[] f1453R;

    public C0722an(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.f1453R = bArr;
    }

    @Override // cz.opentree.AbstractC1939tm
    /* renamed from: e */
    public byte mo2149e(int i) {
        return this.f1453R[i];
    }

    @Override // cz.opentree.AbstractC1939tm
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1939tm) || mo2150f() != ((AbstractC1939tm) obj).mo2150f()) {
            return false;
        }
        if (mo2150f() == 0) {
            return true;
        }
        if (!(obj instanceof C0722an)) {
            return obj.equals(this);
        }
        C0722an c0722an = (C0722an) obj;
        int m8768t = m8768t();
        int m8768t2 = c0722an.m8768t();
        if (m8768t == 0 || m8768t2 == 0 || m8768t == m8768t2) {
            return mo2157u(c0722an, 0, mo2150f());
        }
        return false;
    }

    @Override // cz.opentree.AbstractC1939tm
    /* renamed from: f */
    public int mo2150f() {
        return this.f1453R.length;
    }

    @Override // cz.opentree.AbstractC1939tm
    /* renamed from: h */
    public final int mo2151h(int i, int i2, int i3) {
        return C2435zn.m10535a(i, this.f1453R, mo2158v(), i3);
    }

    @Override // cz.opentree.AbstractC1939tm
    /* renamed from: i */
    public final AbstractC1939tm mo2152i(int i, int i2) {
        int m8765p = AbstractC1939tm.m8765p(0, i2, mo2150f());
        return m8765p == 0 ? AbstractC1939tm.f6790P : new C2359ym(this.f1453R, mo2158v(), m8765p);
    }

    @Override // cz.opentree.AbstractC1939tm
    /* renamed from: m */
    public final String mo2153m(Charset charset) {
        return new String(this.f1453R, mo2158v(), mo2150f(), charset);
    }

    @Override // cz.opentree.AbstractC1939tm
    /* renamed from: n */
    public final void mo2154n(AbstractC2020um abstractC2020um) throws IOException {
        abstractC2020um.mo4572a(this.f1453R, mo2158v(), mo2150f());
    }

    @Override // cz.opentree.AbstractC1939tm
    /* renamed from: o */
    public byte mo2155o(int i) {
        return this.f1453R[i];
    }

    @Override // cz.opentree.AbstractC1939tm
    /* renamed from: s */
    public final boolean mo2156s() {
        int mo2158v = mo2158v();
        return C1008fq.m3862g(this.f1453R, mo2158v, mo2150f() + mo2158v);
    }

    @Override // cz.opentree.AbstractC0789bn
    /* renamed from: u */
    public final boolean mo2157u(AbstractC1939tm abstractC1939tm, int i, int i2) {
        if (i2 > abstractC1939tm.mo2150f()) {
            int mo2150f = mo2150f();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(mo2150f);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > abstractC1939tm.mo2150f()) {
            int mo2150f2 = abstractC1939tm.mo2150f();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(mo2150f2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!(abstractC1939tm instanceof C0722an)) {
            return abstractC1939tm.mo2152i(0, i2).equals(mo2152i(0, i2));
        }
        C0722an c0722an = (C0722an) abstractC1939tm;
        byte[] bArr = this.f1453R;
        byte[] bArr2 = c0722an.f1453R;
        int mo2158v = mo2158v() + i2;
        int mo2158v2 = mo2158v();
        int mo2158v3 = c0722an.mo2158v();
        while (mo2158v2 < mo2158v) {
            if (bArr[mo2158v2] != bArr2[mo2158v3]) {
                return false;
            }
            mo2158v2++;
            mo2158v3++;
        }
        return true;
    }

    /* renamed from: v */
    public int mo2158v() {
        return 0;
    }
}
