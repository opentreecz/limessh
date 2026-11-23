package com.sonelli;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.WeakHashMap;
import org.bouncycastle.crypto.Digest;

/* loaded from: classes.dex */
public class k11 extends j11 {

    /* renamed from: Y */
    public static C1421a f4432Y;

    /* renamed from: Z */
    public static C1421a[] f4433Z;

    /* renamed from: O */
    public final byte[] f4434O;

    /* renamed from: P */
    public final n11 f4435P;

    /* renamed from: Q */
    public final h11 f4436Q;

    /* renamed from: R */
    public final int f4437R;

    /* renamed from: S */
    public final byte[] f4438S;

    /* renamed from: T */
    public int f4439T;

    /* renamed from: U */
    public l11 f4440U;

    /* renamed from: V */
    public int f4441V;

    /* renamed from: W */
    public Map<C1421a, byte[]> f4442W;

    /* renamed from: X */
    public Digest f4443X;

    /* renamed from: com.sonelli.k11$a */
    /* loaded from: classes.dex */
    public static class C1421a {

        /* renamed from: a */
        public final int f4444a;

        public C1421a(int i) {
            this.f4444a = i;
        }

        public boolean equals(Object obj) {
            return (obj instanceof C1421a) && ((C1421a) obj).f4444a == this.f4444a;
        }

        public int hashCode() {
            return this.f4444a;
        }
    }

    static {
        C1421a c1421a = new C1421a(1);
        f4432Y = c1421a;
        C1421a[] c1421aArr = new C1421a[KeycodeConstants.KEYCODE_MEDIA_EJECT];
        f4433Z = c1421aArr;
        c1421aArr[1] = c1421a;
        int i = 2;
        while (true) {
            C1421a[] c1421aArr2 = f4433Z;
            if (i >= c1421aArr2.length) {
                return;
            }
            c1421aArr2[i] = new C1421a(i);
            i++;
        }
    }

    public k11(n11 n11Var, h11 h11Var, int i, byte[] bArr, int i2, byte[] bArr2) {
        super(true);
        this.f4435P = n11Var;
        this.f4436Q = h11Var;
        this.f4439T = i;
        this.f4434O = e51.m3436e(bArr);
        this.f4437R = i2;
        this.f4438S = e51.m3436e(bArr2);
        this.f4441V = 1 << (n11Var.m6624c() + 1);
        this.f4442W = new WeakHashMap();
        this.f4443X = e11.m3380a(n11Var.m6623b());
    }

    /* renamed from: e */
    public static k11 m5779e(Object obj) throws IOException {
        DataInputStream dataInputStream;
        if (obj instanceof k11) {
            return (k11) obj;
        }
        if (!(obj instanceof DataInputStream)) {
            if (!(obj instanceof byte[])) {
                if (obj instanceof InputStream) {
                    return m5779e(r51.m7880b((InputStream) obj));
                }
                throw new IllegalArgumentException("cannot parse " + obj);
            }
            DataInputStream dataInputStream2 = null;
            try {
                dataInputStream = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            } catch (Throwable th) {
                th = th;
            }
            try {
                k11 m5779e = m5779e(dataInputStream);
                dataInputStream.close();
                return m5779e;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                throw th;
            }
        }
        DataInputStream dataInputStream3 = (DataInputStream) obj;
        if (dataInputStream3.readInt() != 0) {
            throw new IllegalStateException("expected version 0 lms private key");
        }
        n11 m6622e = n11.m6622e(dataInputStream3.readInt());
        h11 m4336e = h11.m4336e(dataInputStream3.readInt());
        byte[] bArr = new byte[16];
        dataInputStream3.readFully(bArr);
        int readInt = dataInputStream3.readInt();
        int readInt2 = dataInputStream3.readInt();
        int readInt3 = dataInputStream3.readInt();
        if (readInt3 < 0) {
            throw new IllegalStateException("secret length less than zero");
        }
        if (readInt3 <= dataInputStream3.available()) {
            byte[] bArr2 = new byte[readInt3];
            dataInputStream3.readFully(bArr2);
            return new k11(m6622e, m4336e, readInt, bArr, readInt2, bArr2);
        }
        throw new IOException("secret length exceeded " + dataInputStream3.available());
    }

    /* renamed from: f */
    public static k11 m5780f(byte[] bArr, byte[] bArr2) throws IOException {
        k11 m5779e = m5779e(bArr);
        m5779e.f4440U = l11.m6042a(bArr2);
        return m5779e;
    }

    /* renamed from: a */
    public final byte[] m5781a(int i) {
        int m6624c = 1 << m5788j().m6624c();
        if (i >= m6624c) {
            p11.m7217a(m5784d(), this.f4443X);
            p11.m7219c(i, this.f4443X);
            p11.m7218b((short) -32126, this.f4443X);
            p11.m7217a(o11.m6834a(m5786h(), m5784d(), i - m6624c, m5785g()), this.f4443X);
            byte[] bArr = new byte[this.f4443X.mo6519f()];
            this.f4443X.mo7096b(bArr, 0);
            return bArr;
        }
        int i2 = i * 2;
        byte[] m5782b = m5782b(i2);
        byte[] m5782b2 = m5782b(i2 + 1);
        p11.m7217a(m5784d(), this.f4443X);
        p11.m7219c(i, this.f4443X);
        p11.m7218b((short) -31869, this.f4443X);
        p11.m7217a(m5782b, this.f4443X);
        p11.m7217a(m5782b2, this.f4443X);
        byte[] bArr2 = new byte[this.f4443X.mo6519f()];
        this.f4443X.mo7096b(bArr2, 0);
        return bArr2;
    }

    /* renamed from: b */
    public byte[] m5782b(int i) {
        if (i >= this.f4441V) {
            return m5781a(i);
        }
        C1421a[] c1421aArr = f4433Z;
        return m5783c(i < c1421aArr.length ? c1421aArr[i] : new C1421a(i));
    }

    /* renamed from: c */
    public final byte[] m5783c(C1421a c1421a) {
        synchronized (this.f4442W) {
            byte[] bArr = this.f4442W.get(c1421a);
            if (bArr != null) {
                return bArr;
            }
            byte[] m5781a = m5781a(c1421a.f4444a);
            this.f4442W.put(c1421a, m5781a);
            return m5781a;
        }
    }

    /* renamed from: d */
    public byte[] m5784d() {
        return e51.m3436e(this.f4434O);
    }

    public boolean equals(Object obj) {
        l11 l11Var;
        if (this == obj) {
            return true;
        }
        if (obj == null || k11.class != obj.getClass()) {
            return false;
        }
        k11 k11Var = (k11) obj;
        if (this.f4439T != k11Var.f4439T || this.f4437R != k11Var.f4437R || !e51.m3432a(this.f4434O, k11Var.f4434O)) {
            return false;
        }
        n11 n11Var = this.f4435P;
        if (n11Var == null ? k11Var.f4435P != null : !n11Var.equals(k11Var.f4435P)) {
            return false;
        }
        h11 h11Var = this.f4436Q;
        if (h11Var == null ? k11Var.f4436Q != null : !h11Var.equals(k11Var.f4436Q)) {
            return false;
        }
        if (!e51.m3432a(this.f4438S, k11Var.f4438S)) {
            return false;
        }
        l11 l11Var2 = this.f4440U;
        if (l11Var2 == null || (l11Var = k11Var.f4440U) == null) {
            return true;
        }
        return l11Var2.equals(l11Var);
    }

    /* renamed from: g */
    public byte[] m5785g() {
        return e51.m3436e(this.f4438S);
    }

    @Override // com.sonelli.j11, org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        d11 m3091f = d11.m3091f();
        m3091f.m3099i(0);
        m3091f.m3099i(this.f4435P.m6626f());
        m3091f.m3099i(this.f4436Q.m4340f());
        m3091f.m3095d(this.f4434O);
        m3091f.m3099i(this.f4439T);
        m3091f.m3099i(this.f4437R);
        m3091f.m3099i(this.f4438S.length);
        m3091f.m3095d(this.f4438S);
        return m3091f.m3093b();
    }

    /* renamed from: h */
    public h11 m5786h() {
        return this.f4436Q;
    }

    public int hashCode() {
        int m3445n = ((this.f4439T * 31) + e51.m3445n(this.f4434O)) * 31;
        n11 n11Var = this.f4435P;
        int hashCode = (m3445n + (n11Var != null ? n11Var.hashCode() : 0)) * 31;
        h11 h11Var = this.f4436Q;
        int hashCode2 = (((((hashCode + (h11Var != null ? h11Var.hashCode() : 0)) * 31) + this.f4437R) * 31) + e51.m3445n(this.f4438S)) * 31;
        l11 l11Var = this.f4440U;
        return hashCode2 + (l11Var != null ? l11Var.hashCode() : 0);
    }

    /* renamed from: i */
    public l11 m5787i() {
        l11 l11Var;
        synchronized (this) {
            if (this.f4440U == null) {
                this.f4440U = new l11(this.f4435P, this.f4436Q, m5783c(f4432Y), this.f4434O);
            }
            l11Var = this.f4440U;
        }
        return l11Var;
    }

    /* renamed from: j */
    public n11 m5788j() {
        return this.f4435P;
    }
}
