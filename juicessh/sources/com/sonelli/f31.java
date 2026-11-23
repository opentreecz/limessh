package com.sonelli;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface;
import org.bouncycastle.util.Encodable;

/* loaded from: classes.dex */
public final class f31 extends d31 implements XMSSStoreableObjectInterface, Encodable {

    /* renamed from: P */
    public final e31 f2601P;

    /* renamed from: Q */
    public final byte[] f2602Q;

    /* renamed from: R */
    public final byte[] f2603R;

    /* renamed from: S */
    public final byte[] f2604S;

    /* renamed from: T */
    public final byte[] f2605T;

    /* renamed from: U */
    public volatile long f2606U;

    /* renamed from: V */
    public volatile o21 f2607V;

    /* renamed from: com.sonelli.f31$b */
    /* loaded from: classes.dex */
    public static class C0968b {

        /* renamed from: a */
        public final e31 f2608a;

        /* renamed from: b */
        public long f2609b = 0;

        /* renamed from: c */
        public long f2610c = -1;

        /* renamed from: d */
        public byte[] f2611d = null;

        /* renamed from: e */
        public byte[] f2612e = null;

        /* renamed from: f */
        public byte[] f2613f = null;

        /* renamed from: g */
        public byte[] f2614g = null;

        /* renamed from: h */
        public o21 f2615h = null;

        /* renamed from: i */
        public byte[] f2616i = null;

        /* renamed from: j */
        public j31 f2617j = null;

        public C0968b(e31 e31Var) {
            this.f2608a = e31Var;
        }

        /* renamed from: k */
        public f31 m3673k() {
            return new f31(this);
        }

        /* renamed from: l */
        public C0968b m3674l(o21 o21Var) {
            if (o21Var.m6837b() == 0) {
                this.f2615h = new o21(o21Var, (1 << this.f2608a.m3410a()) - 1);
            } else {
                this.f2615h = o21Var;
            }
            return this;
        }

        /* renamed from: m */
        public C0968b m3675m(long j) {
            this.f2609b = j;
            return this;
        }

        /* renamed from: n */
        public C0968b m3676n(long j) {
            this.f2610c = j;
            return this;
        }

        /* renamed from: o */
        public C0968b m3677o(byte[] bArr) {
            this.f2613f = m31.m6353c(bArr);
            return this;
        }

        /* renamed from: p */
        public C0968b m3678p(byte[] bArr) {
            this.f2614g = m31.m6353c(bArr);
            return this;
        }

        /* renamed from: q */
        public C0968b m3679q(byte[] bArr) {
            this.f2612e = m31.m6353c(bArr);
            return this;
        }

        /* renamed from: r */
        public C0968b m3680r(byte[] bArr) {
            this.f2611d = m31.m6353c(bArr);
            return this;
        }
    }

    public f31(C0968b c0968b) {
        super(true, c0968b.f2608a.m3414e());
        e31 e31Var = c0968b.f2608a;
        this.f2601P = e31Var;
        Objects.requireNonNull(e31Var, "params == null");
        int m3415f = e31Var.m3415f();
        byte[] bArr = c0968b.f2616i;
        if (bArr != null) {
            Objects.requireNonNull(c0968b.f2617j, "xmss == null");
            int m3410a = e31Var.m3410a();
            int i = (m3410a + 7) / 8;
            this.f2606U = m31.m6351a(bArr, 0, i);
            if (!m31.m6362l(m3410a, this.f2606U)) {
                throw new IllegalArgumentException("index out of bounds");
            }
            int i2 = i + 0;
            this.f2602Q = m31.m6357g(bArr, i2, m3415f);
            int i3 = i2 + m3415f;
            this.f2603R = m31.m6357g(bArr, i3, m3415f);
            int i4 = i3 + m3415f;
            this.f2604S = m31.m6357g(bArr, i4, m3415f);
            int i5 = i4 + m3415f;
            this.f2605T = m31.m6357g(bArr, i5, m3415f);
            int i6 = i5 + m3415f;
            try {
                this.f2607V = ((o21) m31.m6356f(m31.m6357g(bArr, i6, bArr.length - i6), o21.class)).m6841f(c0968b.f2617j.m5046g());
                return;
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage(), e);
            } catch (ClassNotFoundException e2) {
                throw new IllegalArgumentException(e2.getMessage(), e2);
            }
        }
        this.f2606U = c0968b.f2609b;
        byte[] bArr2 = c0968b.f2611d;
        if (bArr2 == null) {
            this.f2602Q = new byte[m3415f];
        } else {
            if (bArr2.length != m3415f) {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            this.f2602Q = bArr2;
        }
        byte[] bArr3 = c0968b.f2612e;
        if (bArr3 == null) {
            this.f2603R = new byte[m3415f];
        } else {
            if (bArr3.length != m3415f) {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            this.f2603R = bArr3;
        }
        byte[] bArr4 = c0968b.f2613f;
        if (bArr4 == null) {
            this.f2604S = new byte[m3415f];
        } else {
            if (bArr4.length != m3415f) {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            this.f2604S = bArr4;
        }
        byte[] bArr5 = c0968b.f2614g;
        if (bArr5 == null) {
            this.f2605T = new byte[m3415f];
        } else {
            if (bArr5.length != m3415f) {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            this.f2605T = bArr5;
        }
        o21 o21Var = c0968b.f2615h;
        if (o21Var == null) {
            o21Var = (!m31.m6362l(e31Var.m3410a(), c0968b.f2609b) || bArr4 == null || bArr2 == null) ? new o21(c0968b.f2610c + 1) : new o21(e31Var, c0968b.f2609b, bArr4, bArr2);
        }
        this.f2607V = o21Var;
        if (c0968b.f2610c >= 0 && c0968b.f2610c != this.f2607V.m6837b()) {
            throw new IllegalArgumentException("maxIndex set but not reflected in state");
        }
    }

    /* renamed from: b */
    public e31 m3661b() {
        return this.f2601P;
    }

    /* renamed from: c */
    public byte[] m3662c() {
        byte[] m3440i;
        synchronized (this) {
            int m3415f = this.f2601P.m3415f();
            int m3410a = (this.f2601P.m3410a() + 7) / 8;
            byte[] bArr = new byte[m3410a + m3415f + m3415f + m3415f + m3415f];
            m31.m6355e(bArr, m31.m6367q(this.f2606U, m3410a), 0);
            int i = m3410a + 0;
            m31.m6355e(bArr, this.f2602Q, i);
            int i2 = i + m3415f;
            m31.m6355e(bArr, this.f2603R, i2);
            int i3 = i2 + m3415f;
            m31.m6355e(bArr, this.f2604S, i3);
            m31.m6355e(bArr, this.f2605T, i3 + m3415f);
            try {
                m3440i = e51.m3440i(bArr, m31.m6366p(this.f2607V));
            } catch (IOException e) {
                throw new IllegalStateException("error serializing bds state: " + e.getMessage(), e);
            }
        }
        return m3440i;
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        byte[] m3662c;
        synchronized (this) {
            m3662c = m3662c();
        }
        return m3662c;
    }
}
