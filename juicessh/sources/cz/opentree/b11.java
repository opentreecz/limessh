package cz.opentree;

/* loaded from: classes.dex */
public class b11 extends zp0 {

    /* renamed from: O */
    public final int f1579O;

    /* renamed from: P */
    public final int f1580P;

    /* renamed from: Q */
    public final byte[] f1581Q;

    /* renamed from: R */
    public final byte[] f1582R;

    /* renamed from: S */
    public final byte[] f1583S;

    /* renamed from: T */
    public final byte[] f1584T;

    /* renamed from: U */
    public final int f1585U;

    /* renamed from: V */
    public final byte[] f1586V;

    public b11(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f1579O = 0;
        this.f1580P = i;
        this.f1581Q = e51.m3436e(bArr);
        this.f1582R = e51.m3436e(bArr2);
        this.f1583S = e51.m3436e(bArr3);
        this.f1584T = e51.m3436e(bArr4);
        this.f1586V = e51.m3436e(bArr5);
        this.f1585U = -1;
    }

    public b11(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i2) {
        this.f1579O = 1;
        this.f1580P = i;
        this.f1581Q = e51.m3436e(bArr);
        this.f1582R = e51.m3436e(bArr2);
        this.f1583S = e51.m3436e(bArr3);
        this.f1584T = e51.m3436e(bArr4);
        this.f1586V = e51.m3436e(bArr5);
        this.f1585U = i2;
    }

    public b11(fq0 fq0Var) {
        int i;
        xp0 m9866t = xp0.m9866t(fq0Var.mo3870u(0));
        if (!m9866t.m9872x(f51.f2620a) && !m9866t.m9872x(f51.f2621b)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f1579O = m9866t.m9868B();
        if (fq0Var.size() != 2 && fq0Var.size() != 3) {
            throw new IllegalArgumentException("key sequence wrong size");
        }
        fq0 m3869t = fq0.m3869t(fq0Var.mo3870u(1));
        this.f1580P = xp0.m9866t(m3869t.mo3870u(0)).m9868B();
        this.f1581Q = e51.m3436e(bq0.m2592t(m3869t.mo3870u(1)).m2598v());
        this.f1582R = e51.m3436e(bq0.m2592t(m3869t.mo3870u(2)).m2598v());
        this.f1583S = e51.m3436e(bq0.m2592t(m3869t.mo3870u(3)).m2598v());
        this.f1584T = e51.m3436e(bq0.m2592t(m3869t.mo3870u(4)).m2598v());
        if (m3869t.size() == 6) {
            iq0 m4909t = iq0.m4909t(m3869t.mo3870u(5));
            if (m4909t.m4911v() != 0) {
                throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
            }
            i = xp0.m9867u(m4909t, false).m9868B();
        } else {
            if (m3869t.size() != 5) {
                throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
            }
            i = -1;
        }
        this.f1585U = i;
        if (fq0Var.size() == 3) {
            this.f1586V = e51.m3436e(bq0.m2593u(iq0.m4909t(fq0Var.mo3870u(2)), true).m2598v());
        } else {
            this.f1586V = null;
        }
    }

    /* renamed from: n */
    public static b11 m2335n(Object obj) {
        if (obj instanceof b11) {
            return (b11) obj;
        }
        if (obj != null) {
            return new b11(fq0.m3869t(obj));
        }
        return null;
    }

    @Override // cz.opentree.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0();
        rp0Var.m8224a(this.f1585U >= 0 ? new xp0(1L) : new xp0(0L));
        rp0 rp0Var2 = new rp0();
        rp0Var2.m8224a(new xp0(this.f1580P));
        rp0Var2.m8224a(new gr0(this.f1581Q));
        rp0Var2.m8224a(new gr0(this.f1582R));
        rp0Var2.m8224a(new gr0(this.f1583S));
        rp0Var2.m8224a(new gr0(this.f1584T));
        int i = this.f1585U;
        if (i >= 0) {
            rp0Var2.m8224a(new pr0(false, 0, new xp0(i)));
        }
        rp0Var.m8224a(new kr0(rp0Var2));
        rp0Var.m8224a(new pr0(true, 0, new gr0(this.f1586V)));
        return new kr0(rp0Var);
    }

    /* renamed from: k */
    public byte[] m2336k() {
        return e51.m3436e(this.f1586V);
    }

    /* renamed from: m */
    public int m2337m() {
        return this.f1580P;
    }

    /* renamed from: o */
    public int m2338o() {
        return this.f1585U;
    }

    /* renamed from: p */
    public byte[] m2339p() {
        return e51.m3436e(this.f1583S);
    }

    /* renamed from: q */
    public byte[] m2340q() {
        return e51.m3436e(this.f1584T);
    }

    /* renamed from: r */
    public byte[] m2341r() {
        return e51.m3436e(this.f1582R);
    }

    /* renamed from: s */
    public byte[] m2342s() {
        return e51.m3436e(this.f1581Q);
    }

    /* renamed from: t */
    public int m2343t() {
        return this.f1579O;
    }
}
