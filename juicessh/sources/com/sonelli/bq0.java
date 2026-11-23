package com.sonelli;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetStringParser;

/* loaded from: classes.dex */
public abstract class bq0 extends eq0 implements ASN1OctetStringParser {

    /* renamed from: O */
    public byte[] f1782O;

    public bq0(byte[] bArr) {
        Objects.requireNonNull(bArr, "'string' cannot be null");
        this.f1782O = bArr;
    }

    /* renamed from: t */
    public static bq0 m2592t(Object obj) {
        if (obj == null || (obj instanceof bq0)) {
            return (bq0) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return m2592t(eq0.m3546p((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct OCTET STRING from byte[]: " + e.getMessage());
            }
        }
        if (obj instanceof ASN1Encodable) {
            eq0 mo1950f = ((ASN1Encodable) obj).mo1950f();
            if (mo1950f instanceof bq0) {
                return (bq0) mo1950f;
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    /* renamed from: u */
    public static bq0 m2593u(iq0 iq0Var, boolean z) {
        if (z) {
            if (iq0Var.m4912w()) {
                return m2592t(iq0Var.m4910u());
            }
            throw new IllegalArgumentException("object implicit - explicit expected.");
        }
        eq0 m4910u = iq0Var.m4910u();
        if (iq0Var.m4912w()) {
            bq0 m2592t = m2592t(m4910u);
            return iq0Var instanceof tq0 ? new nq0(new bq0[]{m2592t}) : (bq0) new nq0(new bq0[]{m2592t}).mo2597s();
        }
        if (m4910u instanceof bq0) {
            bq0 bq0Var = (bq0) m4910u;
            return iq0Var instanceof tq0 ? bq0Var : (bq0) bq0Var.mo2597s();
        }
        if (m4910u instanceof fq0) {
            fq0 fq0Var = (fq0) m4910u;
            return iq0Var instanceof tq0 ? nq0.m6771x(fq0Var) : (bq0) nq0.m6771x(fq0Var).mo2597s();
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + iq0Var.getClass().getName());
    }

    @Override // org.bouncycastle.asn1.ASN1OctetStringParser
    /* renamed from: e */
    public InputStream mo2594e() {
        return new ByteArrayInputStream(this.f1782O);
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    /* renamed from: g */
    public eq0 mo2595g() {
        mo1950f();
        return this;
    }

    @Override // com.sonelli.zp0
    public int hashCode() {
        return e51.m3445n(m2598v());
    }

    @Override // com.sonelli.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (eq0Var instanceof bq0) {
            return e51.m3432a(this.f1782O, ((bq0) eq0Var).f1782O);
        }
        return false;
    }

    @Override // com.sonelli.eq0
    /* renamed from: r */
    public eq0 mo2596r() {
        return new gr0(this.f1782O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return new gr0(this.f1782O);
    }

    public String toString() {
        return "#" + j51.m5063b(o51.m6873b(this.f1782O));
    }

    /* renamed from: v */
    public byte[] m2598v() {
        return this.f1782O;
    }
}
