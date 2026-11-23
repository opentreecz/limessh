package com.sonelli;

import java.io.IOException;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class xp0 extends eq0 {

    /* renamed from: O */
    public final byte[] f8046O;

    /* renamed from: P */
    public final int f8047P;

    public xp0(long j) {
        this.f8046O = BigInteger.valueOf(j).toByteArray();
        this.f8047P = 0;
    }

    public xp0(BigInteger bigInteger) {
        this.f8046O = bigInteger.toByteArray();
        this.f8047P = 0;
    }

    public xp0(byte[] bArr) {
        this(bArr, true);
    }

    public xp0(byte[] bArr, boolean z) {
        if (m9863C(bArr)) {
            throw new IllegalArgumentException("malformed integer");
        }
        this.f8046O = z ? e51.m3436e(bArr) : bArr;
        this.f8047P = m9865G(bArr);
    }

    /* renamed from: A */
    public static int m9862A(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        int max = Math.max(i, length - 4);
        int i3 = i2 & bArr[max];
        while (true) {
            max++;
            if (max >= length) {
                return i3;
            }
            i3 = (i3 << 8) | (bArr[max] & 255);
        }
    }

    /* renamed from: C */
    public static boolean m9863C(byte[] bArr) {
        int length = bArr.length;
        if (length == 0) {
            return true;
        }
        if (length != 1) {
            return bArr[0] == (bArr[1] >> 7) && !i51.m4721b("org.bouncycastle.asn1.allow_unsafe_integer");
        }
        return false;
    }

    /* renamed from: E */
    public static long m9864E(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        int max = Math.max(i, length - 8);
        long j = i2 & bArr[max];
        while (true) {
            max++;
            if (max >= length) {
                return j;
            }
            j = (j << 8) | (bArr[max] & 255);
        }
    }

    /* renamed from: G */
    public static int m9865G(byte[] bArr) {
        int length = bArr.length - 1;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            if (bArr[i] != (bArr[i2] >> 7)) {
                break;
            }
            i = i2;
        }
        return i;
    }

    /* renamed from: t */
    public static xp0 m9866t(Object obj) {
        if (obj == null || (obj instanceof xp0)) {
            return (xp0) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (xp0) eq0.m3546p((byte[]) obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
        }
    }

    /* renamed from: u */
    public static xp0 m9867u(iq0 iq0Var, boolean z) {
        eq0 m4910u = iq0Var.m4910u();
        return (z || (m4910u instanceof xp0)) ? m9866t(m4910u) : new xp0(bq0.m2592t(m4910u).m2598v());
    }

    /* renamed from: B */
    public int m9868B() {
        byte[] bArr = this.f8046O;
        int length = bArr.length;
        int i = this.f8047P;
        if (length - i <= 4) {
            return m9862A(bArr, i, -1);
        }
        throw new ArithmeticException("ASN.1 Integer out of int range");
    }

    /* renamed from: F */
    public long m9869F() {
        byte[] bArr = this.f8046O;
        int length = bArr.length;
        int i = this.f8047P;
        if (length - i <= 8) {
            return m9864E(bArr, i, -1);
        }
        throw new ArithmeticException("ASN.1 Integer out of long range");
    }

    @Override // com.sonelli.zp0
    public int hashCode() {
        return e51.m3445n(this.f8046O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (eq0Var instanceof xp0) {
            return e51.m3432a(this.f8046O, ((xp0) eq0Var).f8046O);
        }
        return false;
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2968n(z, 2, this.f8046O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() {
        return ks0.m5992a(this.f8046O.length) + 1 + this.f8046O.length;
    }

    @Override // com.sonelli.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }

    public String toString() {
        return m9871w().toString();
    }

    /* renamed from: v */
    public BigInteger m9870v() {
        return new BigInteger(1, this.f8046O);
    }

    /* renamed from: w */
    public BigInteger m9871w() {
        return new BigInteger(this.f8046O);
    }

    /* renamed from: x */
    public boolean m9872x(BigInteger bigInteger) {
        return bigInteger != null && m9862A(this.f8046O, this.f8047P, -1) == bigInteger.intValue() && m9871w().equals(bigInteger);
    }
}
