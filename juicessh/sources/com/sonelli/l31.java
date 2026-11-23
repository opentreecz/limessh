package com.sonelli;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface;
import org.bouncycastle.util.Encodable;

/* loaded from: classes.dex */
public final class l31 extends c31 implements XMSSStoreableObjectInterface, Encodable {

    /* renamed from: P */
    public final j31 f4730P;

    /* renamed from: Q */
    public final int f4731Q;

    /* renamed from: R */
    public final byte[] f4732R;

    /* renamed from: S */
    public final byte[] f4733S;

    /* renamed from: com.sonelli.l31$b */
    /* loaded from: classes.dex */
    public static class C1488b {

        /* renamed from: a */
        public final j31 f4734a;

        /* renamed from: b */
        public byte[] f4735b = null;

        /* renamed from: c */
        public byte[] f4736c = null;

        /* renamed from: d */
        public byte[] f4737d = null;

        public C1488b(j31 j31Var) {
            this.f4734a = j31Var;
        }

        /* renamed from: e */
        public l31 m6058e() {
            return new l31(this);
        }

        /* renamed from: f */
        public C1488b m6059f(byte[] bArr) {
            this.f4737d = m31.m6353c(bArr);
            return this;
        }

        /* renamed from: g */
        public C1488b m6060g(byte[] bArr) {
            this.f4736c = m31.m6353c(bArr);
            return this;
        }

        /* renamed from: h */
        public C1488b m6061h(byte[] bArr) {
            this.f4735b = m31.m6353c(bArr);
            return this;
        }
    }

    public l31(C1488b c1488b) {
        super(false, c1488b.f4734a.m5045f());
        j31 j31Var = c1488b.f4734a;
        this.f4730P = j31Var;
        Objects.requireNonNull(j31Var, "params == null");
        int m5047h = j31Var.m5047h();
        byte[] bArr = c1488b.f4737d;
        if (bArr == null) {
            if (j31Var.m5044e() != null) {
                this.f4731Q = j31Var.m5044e().mo7606a();
            } else {
                this.f4731Q = 0;
            }
            byte[] bArr2 = c1488b.f4735b;
            if (bArr2 == null) {
                this.f4732R = new byte[m5047h];
            } else {
                if (bArr2.length != m5047h) {
                    throw new IllegalArgumentException("length of root must be equal to length of digest");
                }
                this.f4732R = bArr2;
            }
            byte[] bArr3 = c1488b.f4736c;
            if (bArr3 == null) {
                this.f4733S = new byte[m5047h];
                return;
            } else {
                if (bArr3.length != m5047h) {
                    throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
                }
                this.f4733S = bArr3;
                return;
            }
        }
        if (bArr.length == m5047h + m5047h) {
            this.f4731Q = 0;
            this.f4732R = m31.m6357g(bArr, 0, m5047h);
            this.f4733S = m31.m6357g(bArr, m5047h + 0, m5047h);
            return;
        }
        int i = m5047h + 4 + m5047h;
        if (bArr.length == i) {
            this.f4731Q = h51.m4365a(bArr, 0);
            this.f4732R = m31.m6357g(bArr, 4, m5047h);
            this.f4733S = m31.m6357g(bArr, 4 + m5047h, m5047h);
        } else {
            System.err.println(bArr.length + " " + i);
            throw new IllegalArgumentException("public key has wrong size");
        }
    }

    /* renamed from: b */
    public j31 m6050b() {
        return this.f4730P;
    }

    /* renamed from: c */
    public byte[] m6051c() {
        return m31.m6353c(this.f4733S);
    }

    /* renamed from: d */
    public byte[] m6052d() {
        return m31.m6353c(this.f4732R);
    }

    /* renamed from: e */
    public byte[] m6053e() {
        byte[] bArr;
        int m5047h = this.f4730P.m5047h();
        int i = this.f4731Q;
        int i2 = 0;
        if (i != 0) {
            bArr = new byte[m5047h + 4 + m5047h];
            h51.m4367c(i, bArr, 0);
            i2 = 4;
        } else {
            bArr = new byte[m5047h + m5047h];
        }
        m31.m6355e(bArr, this.f4732R, i2);
        m31.m6355e(bArr, this.f4733S, i2 + m5047h);
        return bArr;
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        return m6053e();
    }
}
