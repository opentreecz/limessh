package com.sonelli;

import com.sonelli.w21;
import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface;
import org.bouncycastle.util.Encodable;

/* loaded from: classes.dex */
public final class k31 extends c31 implements XMSSStoreableObjectInterface, Encodable {

    /* renamed from: P */
    public final j31 f4453P;

    /* renamed from: Q */
    public final byte[] f4454Q;

    /* renamed from: R */
    public final byte[] f4455R;

    /* renamed from: S */
    public final byte[] f4456S;

    /* renamed from: T */
    public final byte[] f4457T;

    /* renamed from: U */
    public volatile n21 f4458U;

    /* renamed from: com.sonelli.k31$b */
    /* loaded from: classes.dex */
    public static class C1433b {

        /* renamed from: a */
        public final j31 f4459a;

        /* renamed from: b */
        public int f4460b = 0;

        /* renamed from: c */
        public int f4461c = -1;

        /* renamed from: d */
        public byte[] f4462d = null;

        /* renamed from: e */
        public byte[] f4463e = null;

        /* renamed from: f */
        public byte[] f4464f = null;

        /* renamed from: g */
        public byte[] f4465g = null;

        /* renamed from: h */
        public n21 f4466h = null;

        /* renamed from: i */
        public byte[] f4467i = null;

        public C1433b(j31 j31Var) {
            this.f4459a = j31Var;
        }

        /* renamed from: j */
        public k31 m5813j() {
            return new k31(this);
        }

        /* renamed from: k */
        public C1433b m5814k(n21 n21Var) {
            this.f4466h = n21Var;
            return this;
        }

        /* renamed from: l */
        public C1433b m5815l(int i) {
            this.f4460b = i;
            return this;
        }

        /* renamed from: m */
        public C1433b m5816m(int i) {
            this.f4461c = i;
            return this;
        }

        /* renamed from: n */
        public C1433b m5817n(byte[] bArr) {
            this.f4464f = m31.m6353c(bArr);
            return this;
        }

        /* renamed from: o */
        public C1433b m5818o(byte[] bArr) {
            this.f4465g = m31.m6353c(bArr);
            return this;
        }

        /* renamed from: p */
        public C1433b m5819p(byte[] bArr) {
            this.f4463e = m31.m6353c(bArr);
            return this;
        }

        /* renamed from: q */
        public C1433b m5820q(byte[] bArr) {
            this.f4462d = m31.m6353c(bArr);
            return this;
        }
    }

    public k31(C1433b c1433b) {
        super(true, c1433b.f4459a.m5045f());
        j31 j31Var = c1433b.f4459a;
        this.f4453P = j31Var;
        Objects.requireNonNull(j31Var, "params == null");
        int m5047h = j31Var.m5047h();
        byte[] bArr = c1433b.f4467i;
        if (bArr != null) {
            int m5041b = j31Var.m5041b();
            int m4365a = h51.m4365a(bArr, 0);
            if (!m31.m6362l(m5041b, m4365a)) {
                throw new IllegalArgumentException("index out of bounds");
            }
            this.f4454Q = m31.m6357g(bArr, 4, m5047h);
            int i = 4 + m5047h;
            this.f4455R = m31.m6357g(bArr, i, m5047h);
            int i2 = i + m5047h;
            this.f4456S = m31.m6357g(bArr, i2, m5047h);
            int i3 = i2 + m5047h;
            this.f4457T = m31.m6357g(bArr, i3, m5047h);
            int i4 = i3 + m5047h;
            try {
                n21 n21Var = (n21) m31.m6356f(m31.m6357g(bArr, i4, bArr.length - i4), n21.class);
                if (n21Var.m6629b() != m4365a) {
                    throw new IllegalStateException("serialized BDS has wrong index");
                }
                this.f4458U = n21Var.m6635i(c1433b.f4459a.m5046g());
                return;
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage(), e);
            } catch (ClassNotFoundException e2) {
                throw new IllegalArgumentException(e2.getMessage(), e2);
            }
        }
        byte[] bArr2 = c1433b.f4462d;
        if (bArr2 == null) {
            this.f4454Q = new byte[m5047h];
        } else {
            if (bArr2.length != m5047h) {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            this.f4454Q = bArr2;
        }
        byte[] bArr3 = c1433b.f4463e;
        if (bArr3 == null) {
            this.f4455R = new byte[m5047h];
        } else {
            if (bArr3.length != m5047h) {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            this.f4455R = bArr3;
        }
        byte[] bArr4 = c1433b.f4464f;
        if (bArr4 == null) {
            this.f4456S = new byte[m5047h];
        } else {
            if (bArr4.length != m5047h) {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            this.f4456S = bArr4;
        }
        byte[] bArr5 = c1433b.f4465g;
        if (bArr5 == null) {
            this.f4457T = new byte[m5047h];
        } else {
            if (bArr5.length != m5047h) {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            this.f4457T = bArr5;
        }
        n21 n21Var2 = c1433b.f4466h;
        this.f4458U = n21Var2 == null ? (c1433b.f4460b >= (1 << j31Var.m5041b()) + (-2) || bArr4 == null || bArr2 == null) ? new n21(j31Var, (1 << j31Var.m5041b()) - 1, c1433b.f4460b) : new n21(j31Var, bArr4, bArr2, (w21) new w21.C2198b().m9396l(), c1433b.f4460b) : n21Var2;
        if (c1433b.f4461c >= 0 && c1433b.f4461c != this.f4458U.m6630c()) {
            throw new IllegalArgumentException("maxIndex set but not reflected in state");
        }
    }

    /* renamed from: b */
    public j31 m5802b() {
        return this.f4453P;
    }

    /* renamed from: c */
    public byte[] m5803c() {
        byte[] m3440i;
        synchronized (this) {
            int m5047h = this.f4453P.m5047h();
            byte[] bArr = new byte[m5047h + 4 + m5047h + m5047h + m5047h];
            h51.m4367c(this.f4458U.m6629b(), bArr, 0);
            m31.m6355e(bArr, this.f4454Q, 4);
            int i = 4 + m5047h;
            m31.m6355e(bArr, this.f4455R, i);
            int i2 = i + m5047h;
            m31.m6355e(bArr, this.f4456S, i2);
            m31.m6355e(bArr, this.f4457T, i2 + m5047h);
            try {
                m3440i = e51.m3440i(bArr, m31.m6366p(this.f4458U));
            } catch (IOException e) {
                throw new RuntimeException("error serializing bds state: " + e.getMessage());
            }
        }
        return m3440i;
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        byte[] m5803c;
        synchronized (this) {
            m5803c = m5803c();
        }
        return m5803c;
    }
}
