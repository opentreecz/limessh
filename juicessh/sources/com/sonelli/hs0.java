package com.sonelli;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class hs0 extends fq0 {

    /* renamed from: P */
    public byte[] f3223P;

    public hs0(byte[] bArr) throws IOException {
        this.f3223P = bArr;
    }

    @Override // com.sonelli.fq0, com.sonelli.zp0
    public synchronized int hashCode() {
        m4644x();
        return super.hashCode();
    }

    @Override // com.sonelli.fq0, java.lang.Iterable
    public synchronized Iterator<ASN1Encodable> iterator() {
        m4644x();
        return super.iterator();
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public synchronized void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        byte[] bArr = this.f3223P;
        if (bArr != null) {
            cq0Var.m2968n(z, 48, bArr);
        } else {
            super.mo2597s().mo2260m(cq0Var, z);
        }
    }

    @Override // com.sonelli.eq0
    /* renamed from: n */
    public synchronized int mo2261n() throws IOException {
        byte[] bArr = this.f3223P;
        if (bArr != null) {
            return ks0.m5992a(bArr.length) + 1 + this.f3223P.length;
        }
        return super.mo2597s().mo2261n();
    }

    @Override // com.sonelli.fq0, com.sonelli.eq0
    /* renamed from: r */
    public synchronized eq0 mo2596r() {
        m4644x();
        return super.mo2596r();
    }

    @Override // com.sonelli.fq0, com.sonelli.eq0
    /* renamed from: s */
    public synchronized eq0 mo2597s() {
        m4644x();
        return super.mo2597s();
    }

    @Override // com.sonelli.fq0
    public synchronized int size() {
        m4644x();
        return super.size();
    }

    @Override // com.sonelli.fq0
    /* renamed from: u */
    public synchronized ASN1Encodable mo3870u(int i) {
        m4644x();
        return super.mo3870u(i);
    }

    @Override // com.sonelli.fq0
    /* renamed from: v */
    public synchronized Enumeration mo3871v() {
        byte[] bArr = this.f3223P;
        if (bArr != null) {
            return new gs0(bArr);
        }
        return super.mo3871v();
    }

    @Override // com.sonelli.fq0
    /* renamed from: w */
    public ASN1Encodable[] mo3872w() {
        m4644x();
        return super.mo3872w();
    }

    /* renamed from: x */
    public final void m4644x() {
        if (this.f3223P != null) {
            rp0 rp0Var = new rp0();
            gs0 gs0Var = new gs0(this.f3223P);
            while (gs0Var.hasMoreElements()) {
                rp0Var.m8224a((eq0) gs0Var.nextElement());
            }
            this.f2760O = rp0Var.m8229g();
            this.f3223P = null;
        }
    }
}
