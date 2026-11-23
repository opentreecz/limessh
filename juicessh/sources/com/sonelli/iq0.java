package com.sonelli;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;

/* loaded from: classes.dex */
public abstract class iq0 extends eq0 implements ASN1TaggedObjectParser {

    /* renamed from: O */
    public final int f3394O;

    /* renamed from: P */
    public final boolean f3395P;

    /* renamed from: Q */
    public final ASN1Encodable f3396Q;

    public iq0(boolean z, int i, ASN1Encodable aSN1Encodable) {
        Objects.requireNonNull(aSN1Encodable, "'obj' cannot be null");
        this.f3394O = i;
        this.f3395P = z || (aSN1Encodable instanceof ASN1Choice);
        this.f3396Q = aSN1Encodable;
    }

    /* renamed from: t */
    public static iq0 m4909t(Object obj) {
        if (obj == null || (obj instanceof iq0)) {
            return (iq0) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
        try {
            return m4909t(eq0.m3546p((byte[]) obj));
        } catch (IOException e) {
            throw new IllegalArgumentException("failed to construct tagged object from byte[]: " + e.getMessage());
        }
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    /* renamed from: g */
    public eq0 mo2595g() {
        mo1950f();
        return this;
    }

    @Override // com.sonelli.zp0
    public int hashCode() {
        return (this.f3394O ^ (this.f3395P ? 15 : 240)) ^ this.f3396Q.mo1950f().hashCode();
    }

    @Override // com.sonelli.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (!(eq0Var instanceof iq0)) {
            return false;
        }
        iq0 iq0Var = (iq0) eq0Var;
        if (this.f3394O != iq0Var.f3394O || this.f3395P != iq0Var.f3395P) {
            return false;
        }
        eq0 mo1950f = this.f3396Q.mo1950f();
        eq0 mo1950f2 = iq0Var.f3396Q.mo1950f();
        return mo1950f == mo1950f2 || mo1950f.mo2259k(mo1950f2);
    }

    @Override // com.sonelli.eq0
    /* renamed from: r */
    public eq0 mo2596r() {
        return new pr0(this.f3395P, this.f3394O, this.f3396Q);
    }

    @Override // com.sonelli.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return new ds0(this.f3395P, this.f3394O, this.f3396Q);
    }

    public String toString() {
        return "[" + this.f3394O + "]" + this.f3396Q;
    }

    /* renamed from: u */
    public eq0 m4910u() {
        return this.f3396Q.mo1950f();
    }

    /* renamed from: v */
    public int m4911v() {
        return this.f3394O;
    }

    /* renamed from: w */
    public boolean m4912w() {
        return this.f3395P;
    }
}
