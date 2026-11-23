package com.sonelli;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface;
import org.bouncycastle.util.Encodable;

/* loaded from: classes.dex */
public final class g31 extends d31 implements XMSSStoreableObjectInterface, Encodable {

    /* renamed from: P */
    public final e31 f2815P;

    /* renamed from: Q */
    public final int f2816Q;

    /* renamed from: R */
    public final byte[] f2817R;

    /* renamed from: S */
    public final byte[] f2818S;

    /* renamed from: com.sonelli.g31$b */
    /* loaded from: classes.dex */
    public static class C1025b {

        /* renamed from: a */
        public final e31 f2819a;

        /* renamed from: b */
        public byte[] f2820b = null;

        /* renamed from: c */
        public byte[] f2821c = null;

        /* renamed from: d */
        public byte[] f2822d = null;

        public C1025b(e31 e31Var) {
            this.f2819a = e31Var;
        }

        /* renamed from: e */
        public g31 m3979e() {
            return new g31(this);
        }

        /* renamed from: f */
        public C1025b m3980f(byte[] bArr) {
            this.f2822d = m31.m6353c(bArr);
            return this;
        }

        /* renamed from: g */
        public C1025b m3981g(byte[] bArr) {
            this.f2821c = m31.m6353c(bArr);
            return this;
        }

        /* renamed from: h */
        public C1025b m3982h(byte[] bArr) {
            this.f2820b = m31.m6353c(bArr);
            return this;
        }
    }

    public g31(C1025b c1025b) {
        super(false, c1025b.f2819a.m3414e());
        e31 e31Var = c1025b.f2819a;
        this.f2815P = e31Var;
        Objects.requireNonNull(e31Var, "params == null");
        int m3415f = e31Var.m3415f();
        byte[] bArr = c1025b.f2822d;
        if (bArr != null) {
            if (bArr.length == m3415f + m3415f) {
                this.f2816Q = 0;
                this.f2817R = m31.m6357g(bArr, 0, m3415f);
                this.f2818S = m31.m6357g(bArr, m3415f + 0, m3415f);
                return;
            } else {
                if (bArr.length != m3415f + 4 + m3415f) {
                    throw new IllegalArgumentException("public key has wrong size");
                }
                this.f2816Q = h51.m4365a(bArr, 0);
                this.f2817R = m31.m6357g(bArr, 4, m3415f);
                this.f2818S = m31.m6357g(bArr, 4 + m3415f, m3415f);
                return;
            }
        }
        if (e31Var.m3413d() != null) {
            this.f2816Q = e31Var.m3413d().mo7606a();
        } else {
            this.f2816Q = 0;
        }
        byte[] bArr2 = c1025b.f2820b;
        if (bArr2 == null) {
            this.f2817R = new byte[m3415f];
        } else {
            if (bArr2.length != m3415f) {
                throw new IllegalArgumentException("length of root must be equal to length of digest");
            }
            this.f2817R = bArr2;
        }
        byte[] bArr3 = c1025b.f2821c;
        if (bArr3 == null) {
            this.f2818S = new byte[m3415f];
        } else {
            if (bArr3.length != m3415f) {
                throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
            }
            this.f2818S = bArr3;
        }
    }

    /* renamed from: b */
    public e31 m3971b() {
        return this.f2815P;
    }

    /* renamed from: c */
    public byte[] m3972c() {
        return m31.m6353c(this.f2818S);
    }

    /* renamed from: d */
    public byte[] m3973d() {
        return m31.m6353c(this.f2817R);
    }

    /* renamed from: e */
    public byte[] m3974e() {
        byte[] bArr;
        int m3415f = this.f2815P.m3415f();
        int i = this.f2816Q;
        int i2 = 0;
        if (i != 0) {
            bArr = new byte[m3415f + 4 + m3415f];
            h51.m4367c(i, bArr, 0);
            i2 = 4;
        } else {
            bArr = new byte[m3415f + m3415f];
        }
        m31.m6355e(bArr, this.f2817R, i2);
        m31.m6355e(bArr, this.f2818S, i2 + m3415f);
        return bArr;
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        return m3974e();
    }
}
