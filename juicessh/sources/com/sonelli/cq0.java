package com.sonelli;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class cq0 {

    /* renamed from: a */
    public OutputStream f2037a;

    public cq0(OutputStream outputStream) {
        this.f2037a = outputStream;
    }

    /* renamed from: a */
    public static cq0 m2955a(OutputStream outputStream) {
        return new cq0(outputStream);
    }

    /* renamed from: b */
    public static cq0 m2956b(OutputStream outputStream, String str) {
        return str.equals("DER") ? new ir0(outputStream) : str.equals("DL") ? new yr0(outputStream) : new cq0(outputStream);
    }

    /* renamed from: c */
    public void m2957c() throws IOException {
    }

    /* renamed from: d */
    public ir0 mo2958d() {
        return new ir0(this.f2037a);
    }

    /* renamed from: e */
    public cq0 mo2959e() {
        return new yr0(this.f2037a);
    }

    /* renamed from: f */
    public final void m2960f(int i) throws IOException {
        this.f2037a.write(i);
    }

    /* renamed from: g */
    public final void m2961g(byte[] bArr, int i, int i2) throws IOException {
        this.f2037a.write(bArr, i, i2);
    }

    /* renamed from: h */
    public final void m2962h(Enumeration enumeration) throws IOException {
        while (enumeration.hasMoreElements()) {
            mo2975u(((ASN1Encodable) enumeration.nextElement()).mo1950f(), true);
        }
    }

    /* renamed from: i */
    public final void m2963i(ASN1Encodable[] aSN1EncodableArr) throws IOException {
        for (ASN1Encodable aSN1Encodable : aSN1EncodableArr) {
            mo2975u(aSN1Encodable.mo1950f(), true);
        }
    }

    /* renamed from: j */
    public final void m2964j(boolean z, int i, byte b) throws IOException {
        if (z) {
            m2960f(i);
        }
        m2972r(1);
        m2960f(b);
    }

    /* renamed from: k */
    public final void m2965k(boolean z, int i, byte b, byte[] bArr) throws IOException {
        if (z) {
            m2960f(i);
        }
        m2972r(bArr.length + 1);
        m2960f(b);
        m2961g(bArr, 0, bArr.length);
    }

    /* renamed from: l */
    public final void m2966l(boolean z, int i, byte b, byte[] bArr, int i2, int i3, byte b2) throws IOException {
        if (z) {
            m2960f(i);
        }
        m2972r(i3 + 2);
        m2960f(b);
        m2961g(bArr, i2, i3);
        m2960f(b2);
    }

    /* renamed from: m */
    public final void m2967m(boolean z, int i, int i2, byte[] bArr) throws IOException {
        m2976v(z, i, i2);
        m2972r(bArr.length);
        m2961g(bArr, 0, bArr.length);
    }

    /* renamed from: n */
    public final void m2968n(boolean z, int i, byte[] bArr) throws IOException {
        if (z) {
            m2960f(i);
        }
        m2972r(bArr.length);
        m2961g(bArr, 0, bArr.length);
    }

    /* renamed from: o */
    public final void m2969o(boolean z, int i, int i2, byte[] bArr) throws IOException {
        m2976v(z, i, i2);
        m2960f(128);
        m2961g(bArr, 0, bArr.length);
        m2960f(0);
        m2960f(0);
    }

    /* renamed from: p */
    public final void m2970p(boolean z, int i, Enumeration enumeration) throws IOException {
        if (z) {
            m2960f(i);
        }
        m2960f(128);
        m2962h(enumeration);
        m2960f(0);
        m2960f(0);
    }

    /* renamed from: q */
    public final void m2971q(boolean z, int i, ASN1Encodable[] aSN1EncodableArr) throws IOException {
        if (z) {
            m2960f(i);
        }
        m2960f(128);
        m2963i(aSN1EncodableArr);
        m2960f(0);
        m2960f(0);
    }

    /* renamed from: r */
    public final void m2972r(int i) throws IOException {
        if (i <= 127) {
            m2960f((byte) i);
            return;
        }
        int i2 = i;
        int i3 = 1;
        while (true) {
            i2 >>>= 8;
            if (i2 == 0) {
                break;
            } else {
                i3++;
            }
        }
        m2960f((byte) (i3 | 128));
        for (int i4 = (i3 - 1) * 8; i4 >= 0; i4 -= 8) {
            m2960f((byte) (i >> i4));
        }
    }

    /* renamed from: s */
    public void m2973s(ASN1Encodable aSN1Encodable) throws IOException {
        if (aSN1Encodable == null) {
            throw new IOException("null object detected");
        }
        mo2975u(aSN1Encodable.mo1950f(), true);
        m2957c();
    }

    /* renamed from: t */
    public void m2974t(eq0 eq0Var) throws IOException {
        if (eq0Var == null) {
            throw new IOException("null object detected");
        }
        mo2975u(eq0Var, true);
        m2957c();
    }

    /* renamed from: u */
    public void mo2975u(eq0 eq0Var, boolean z) throws IOException {
        eq0Var.mo2260m(this, z);
    }

    /* renamed from: v */
    public final void m2976v(boolean z, int i, int i2) throws IOException {
        if (z) {
            if (i2 < 31) {
                m2960f(i | i2);
                return;
            }
            m2960f(31 | i);
            if (i2 < 128) {
                m2960f(i2);
                return;
            }
            byte[] bArr = new byte[5];
            int i3 = 4;
            bArr[4] = (byte) (i2 & KeycodeConstants.KEYCODE_MEDIA_PAUSE);
            do {
                i2 >>= 7;
                i3--;
                bArr[i3] = (byte) ((i2 & KeycodeConstants.KEYCODE_MEDIA_PAUSE) | 128);
            } while (i2 > 127);
            m2961g(bArr, i3, 5 - i3);
        }
    }
}
