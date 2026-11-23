package cz.opentree;

import cz.opentree.w21;
import java.util.Objects;

/* loaded from: classes.dex */
public final class x21 {

    /* renamed from: a */
    public final z21 f7858a;

    /* renamed from: b */
    public final u21 f7859b;

    /* renamed from: c */
    public byte[] f7860c;

    /* renamed from: d */
    public byte[] f7861d;

    public x21(z21 z21Var) {
        Objects.requireNonNull(z21Var, "params == null");
        this.f7858a = z21Var;
        int m10327c = z21Var.m10327c();
        this.f7859b = new u21(z21Var.m10326b(), m10327c);
        this.f7860c = new byte[m10327c];
        this.f7861d = new byte[m10327c];
    }

    /* renamed from: a */
    public final byte[] m9674a(byte[] bArr, int i, int i2, w21 w21Var) {
        int m10327c = this.f7858a.m10327c();
        Objects.requireNonNull(bArr, "startHash == null");
        if (bArr.length != m10327c) {
            throw new IllegalArgumentException("startHash needs to be " + m10327c + "bytes");
        }
        Objects.requireNonNull(w21Var, "otsHashAddress == null");
        Objects.requireNonNull(w21Var.mo2362d(), "otsHashAddress byte array == null");
        int i3 = i + i2;
        if (i3 > this.f7858a.m10328d() - 1) {
            throw new IllegalArgumentException("max chain length must not be greater than w");
        }
        if (i2 == 0) {
            return bArr;
        }
        byte[] m9674a = m9674a(bArr, i, i2 - 1, w21Var);
        w21.C2198b m2370h = new w21.C2198b().m2369g(w21Var.m2360b()).m2370h(w21Var.m2361c());
        m2370h.m9400p(w21Var.m9392g());
        m2370h.m9398n(w21Var.m9390e());
        m2370h.m9399o(i3 - 1);
        w21 w21Var2 = (w21) m2370h.m2368f(0).m9396l();
        byte[] m8836c = this.f7859b.m8836c(this.f7861d, w21Var2.mo2362d());
        w21.C2198b m2370h2 = new w21.C2198b().m2369g(w21Var2.m2360b()).m2370h(w21Var2.m2361c());
        m2370h2.m9400p(w21Var2.m9392g());
        m2370h2.m9398n(w21Var2.m9390e());
        m2370h2.m9399o(w21Var2.m9391f());
        byte[] m8836c2 = this.f7859b.m8836c(this.f7861d, ((w21) m2370h2.m2368f(1).m9396l()).mo2362d());
        byte[] bArr2 = new byte[m10327c];
        for (int i4 = 0; i4 < m10327c; i4++) {
            bArr2[i4] = (byte) (m9674a[i4] ^ m8836c2[i4]);
        }
        return this.f7859b.m8834a(m8836c, bArr2);
    }

    /* renamed from: b */
    public final byte[] m9675b(int i) {
        if (i < 0 || i >= this.f7858a.m10325a()) {
            throw new IllegalArgumentException("index out of bounds");
        }
        return this.f7859b.m8836c(this.f7860c, m31.m6367q(i, 32));
    }

    /* renamed from: c */
    public u21 m9676c() {
        return this.f7859b;
    }

    /* renamed from: d */
    public z21 m9677d() {
        return this.f7858a;
    }

    /* renamed from: e */
    public a31 m9678e(w21 w21Var) {
        Objects.requireNonNull(w21Var, "otsHashAddress == null");
        byte[][] bArr = new byte[this.f7858a.m10325a()];
        for (int i = 0; i < this.f7858a.m10325a(); i++) {
            w21.C2198b m2370h = new w21.C2198b().m2369g(w21Var.m2360b()).m2370h(w21Var.m2361c());
            m2370h.m9400p(w21Var.m9392g());
            m2370h.m9398n(i);
            m2370h.m9399o(w21Var.m9391f());
            w21Var = (w21) m2370h.m2368f(w21Var.m2359a()).m9396l();
            bArr[i] = m9674a(m9675b(i), 0, this.f7858a.m10328d() - 1, w21Var);
        }
        return new a31(this.f7858a, bArr);
    }

    /* renamed from: f */
    public byte[] m9679f() {
        return e51.m3436e(this.f7861d);
    }

    /* renamed from: g */
    public byte[] m9680g(byte[] bArr, w21 w21Var) {
        w21.C2198b m2370h = new w21.C2198b().m2369g(w21Var.m2360b()).m2370h(w21Var.m2361c());
        m2370h.m9400p(w21Var.m9392g());
        return this.f7859b.m8836c(bArr, ((w21) m2370h.m9396l()).mo2362d());
    }

    /* renamed from: h */
    public void m9681h(byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(bArr, "secretKeySeed == null");
        if (bArr.length != this.f7858a.m10327c()) {
            throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
        }
        Objects.requireNonNull(bArr2, "publicSeed == null");
        if (bArr2.length != this.f7858a.m10327c()) {
            throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
        }
        this.f7860c = bArr;
        this.f7861d = bArr2;
    }
}
