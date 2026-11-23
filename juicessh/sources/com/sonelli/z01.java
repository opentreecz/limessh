package com.sonelli;

/* loaded from: classes.dex */
public class z01 extends zp0 {

    /* renamed from: O */
    public final int f8389O;

    /* renamed from: P */
    public final long f8390P;

    /* renamed from: Q */
    public final long f8391Q;

    /* renamed from: R */
    public final byte[] f8392R;

    /* renamed from: S */
    public final byte[] f8393S;

    /* renamed from: T */
    public final byte[] f8394T;

    /* renamed from: U */
    public final byte[] f8395U;

    /* renamed from: V */
    public final byte[] f8396V;

    public z01(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f8389O = 0;
        this.f8390P = j;
        this.f8392R = e51.m3436e(bArr);
        this.f8393S = e51.m3436e(bArr2);
        this.f8394T = e51.m3436e(bArr3);
        this.f8395U = e51.m3436e(bArr4);
        this.f8396V = e51.m3436e(bArr5);
        this.f8391Q = -1L;
    }

    public z01(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, long j2) {
        this.f8389O = 1;
        this.f8390P = j;
        this.f8392R = e51.m3436e(bArr);
        this.f8393S = e51.m3436e(bArr2);
        this.f8394T = e51.m3436e(bArr3);
        this.f8395U = e51.m3436e(bArr4);
        this.f8396V = e51.m3436e(bArr5);
        this.f8391Q = j2;
    }

    public z01(fq0 fq0Var) {
        long j;
        xp0 m9866t = xp0.m9866t(fq0Var.mo3870u(0));
        if (!m9866t.m9872x(f51.f2620a) && !m9866t.m9872x(f51.f2621b)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f8389O = m9866t.m9868B();
        if (fq0Var.size() != 2 && fq0Var.size() != 3) {
            throw new IllegalArgumentException("key sequence wrong size");
        }
        fq0 m3869t = fq0.m3869t(fq0Var.mo3870u(1));
        this.f8390P = xp0.m9866t(m3869t.mo3870u(0)).m9869F();
        this.f8392R = e51.m3436e(bq0.m2592t(m3869t.mo3870u(1)).m2598v());
        this.f8393S = e51.m3436e(bq0.m2592t(m3869t.mo3870u(2)).m2598v());
        this.f8394T = e51.m3436e(bq0.m2592t(m3869t.mo3870u(3)).m2598v());
        this.f8395U = e51.m3436e(bq0.m2592t(m3869t.mo3870u(4)).m2598v());
        if (m3869t.size() == 6) {
            iq0 m4909t = iq0.m4909t(m3869t.mo3870u(5));
            if (m4909t.m4911v() != 0) {
                throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
            }
            j = xp0.m9867u(m4909t, false).m9869F();
        } else {
            if (m3869t.size() != 5) {
                throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
            }
            j = -1;
        }
        this.f8391Q = j;
        if (fq0Var.size() == 3) {
            this.f8396V = e51.m3436e(bq0.m2593u(iq0.m4909t(fq0Var.mo3870u(2)), true).m2598v());
        } else {
            this.f8396V = null;
        }
    }

    /* renamed from: n */
    public static z01 m10312n(Object obj) {
        if (obj instanceof z01) {
            return (z01) obj;
        }
        if (obj != null) {
            return new z01(fq0.m3869t(obj));
        }
        return null;
    }

    @Override // com.sonelli.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0();
        rp0Var.m8224a(this.f8391Q >= 0 ? new xp0(1L) : new xp0(0L));
        rp0 rp0Var2 = new rp0();
        rp0Var2.m8224a(new xp0(this.f8390P));
        rp0Var2.m8224a(new gr0(this.f8392R));
        rp0Var2.m8224a(new gr0(this.f8393S));
        rp0Var2.m8224a(new gr0(this.f8394T));
        rp0Var2.m8224a(new gr0(this.f8395U));
        long j = this.f8391Q;
        if (j >= 0) {
            rp0Var2.m8224a(new pr0(false, 0, new xp0(j)));
        }
        rp0Var.m8224a(new kr0(rp0Var2));
        rp0Var.m8224a(new pr0(true, 0, new gr0(this.f8396V)));
        return new kr0(rp0Var);
    }

    /* renamed from: k */
    public byte[] m10313k() {
        return e51.m3436e(this.f8396V);
    }

    /* renamed from: m */
    public long m10314m() {
        return this.f8390P;
    }

    /* renamed from: o */
    public long m10315o() {
        return this.f8391Q;
    }

    /* renamed from: p */
    public byte[] m10316p() {
        return e51.m3436e(this.f8394T);
    }

    /* renamed from: q */
    public byte[] m10317q() {
        return e51.m3436e(this.f8395U);
    }

    /* renamed from: r */
    public byte[] m10318r() {
        return e51.m3436e(this.f8393S);
    }

    /* renamed from: s */
    public byte[] m10319s() {
        return e51.m3436e(this.f8392R);
    }

    /* renamed from: t */
    public int m10320t() {
        return this.f8389O;
    }
}
