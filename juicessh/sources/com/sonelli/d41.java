package com.sonelli;

import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;

/* loaded from: classes.dex */
public class d41 implements PrivateKey {

    /* renamed from: O */
    public short[][] f2125O;

    /* renamed from: P */
    public short[] f2126P;

    /* renamed from: Q */
    public short[][] f2127Q;

    /* renamed from: R */
    public short[] f2128R;

    /* renamed from: S */
    public d21[] f2129S;

    /* renamed from: T */
    public int[] f2130T;

    public d41(r41 r41Var) {
        this(r41Var.m7874c(), r41Var.m7872a(), r41Var.m7875d(), r41Var.m7873b(), r41Var.m7877f(), r41Var.m7876e());
    }

    public d41(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, d21[] d21VarArr) {
        this.f2125O = sArr;
        this.f2126P = sArr2;
        this.f2127Q = sArr3;
        this.f2128R = sArr4;
        this.f2130T = iArr;
        this.f2129S = d21VarArr;
    }

    /* renamed from: a */
    public short[] m3149a() {
        return this.f2126P;
    }

    /* renamed from: b */
    public short[] m3150b() {
        return this.f2128R;
    }

    /* renamed from: c */
    public short[][] m3151c() {
        return this.f2125O;
    }

    /* renamed from: d */
    public short[][] m3152d() {
        return this.f2127Q;
    }

    /* renamed from: e */
    public d21[] m3153e() {
        return this.f2129S;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d41)) {
            return false;
        }
        d41 d41Var = (d41) obj;
        boolean z = ((((e21.m3393j(this.f2125O, d41Var.m3151c())) && e21.m3393j(this.f2127Q, d41Var.m3152d())) && e21.m3392i(this.f2126P, d41Var.m3149a())) && e21.m3392i(this.f2128R, d41Var.m3150b())) && Arrays.equals(this.f2130T, d41Var.m3154f());
        if (this.f2129S.length != d41Var.m3153e().length) {
            return false;
        }
        for (int length = this.f2129S.length - 1; length >= 0; length--) {
            z &= this.f2129S[length].equals(d41Var.m3153e()[length]);
        }
        return z;
    }

    /* renamed from: f */
    public int[] m3154f() {
        return this.f2130T;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new qs0(new vs0(PQCObjectIdentifiers.f8876a, er0.f2528O), new u01(this.f2125O, this.f2126P, this.f2127Q, this.f2128R, this.f2130T, this.f2129S)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        int length = (((((((((this.f2129S.length * 37) + e51.m3452u(this.f2125O)) * 37) + e51.m3451t(this.f2126P)) * 37) + e51.m3452u(this.f2127Q)) * 37) + e51.m3451t(this.f2128R)) * 37) + e51.m3448q(this.f2130T);
        for (int length2 = this.f2129S.length - 1; length2 >= 0; length2--) {
            length = (length * 37) + this.f2129S[length2].hashCode();
        }
        return length;
    }
}
