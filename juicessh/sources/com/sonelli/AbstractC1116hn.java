package com.sonelli;

import com.google.android.gms.internal.measurement.zzgt;
import com.google.android.gms.internal.measurement.zzhi;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.hn */
/* loaded from: classes.dex */
public abstract class AbstractC1116hn extends AbstractC2020um {

    /* renamed from: b */
    public static final Logger f3174b = Logger.getLogger(AbstractC1116hn.class.getName());

    /* renamed from: c */
    public static final boolean f3175c = C0841cq.m2929m();

    /* renamed from: a */
    public C1228jn f3176a;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    /* renamed from: com.sonelli.hn$a */
    /* loaded from: classes.dex */
    public static class a extends IOException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L11
                java.lang.String r3 = r1.concat(r3)
                goto L16
            L11:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L16:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sonelli.AbstractC1116hn.a.<init>(java.lang.String, java.lang.Throwable):void");
        }

        public a(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    /* renamed from: com.sonelli.hn$b */
    /* loaded from: classes.dex */
    public static class b extends AbstractC1116hn {

        /* renamed from: d */
        public final byte[] f3177d;

        /* renamed from: e */
        public final int f3178e;

        /* renamed from: f */
        public int f3179f;

        public b(byte[] bArr, int i, int i2) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            int i3 = i2 + 0;
            if ((i2 | 0 | (bArr.length - i3)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            this.f3177d = bArr;
            this.f3179f = 0;
            this.f3178e = i3;
        }

        /* renamed from: G0 */
        public final void m4571G0(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f3177d, this.f3179f, i2);
                this.f3179f += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3179f), Integer.valueOf(this.f3178e), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: O */
        public final void mo4538O(int i) throws IOException {
            if (!AbstractC1116hn.f3175c || C1775qm.m7743b() || mo4548b() < 5) {
                while ((i & (-128)) != 0) {
                    try {
                        byte[] bArr = this.f3177d;
                        int i2 = this.f3179f;
                        this.f3179f = i2 + 1;
                        bArr[i2] = (byte) ((i & KeycodeConstants.KEYCODE_MEDIA_PAUSE) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3179f), Integer.valueOf(this.f3178e), 1), e);
                    }
                }
                byte[] bArr2 = this.f3177d;
                int i3 = this.f3179f;
                this.f3179f = i3 + 1;
                bArr2[i3] = (byte) i;
                return;
            }
            if ((i & (-128)) == 0) {
                byte[] bArr3 = this.f3177d;
                int i4 = this.f3179f;
                this.f3179f = i4 + 1;
                C0841cq.m2928l(bArr3, i4, (byte) i);
                return;
            }
            byte[] bArr4 = this.f3177d;
            int i5 = this.f3179f;
            this.f3179f = i5 + 1;
            C0841cq.m2928l(bArr4, i5, (byte) (i | 128));
            int i6 = i >>> 7;
            if ((i6 & (-128)) == 0) {
                byte[] bArr5 = this.f3177d;
                int i7 = this.f3179f;
                this.f3179f = i7 + 1;
                C0841cq.m2928l(bArr5, i7, (byte) i6);
                return;
            }
            byte[] bArr6 = this.f3177d;
            int i8 = this.f3179f;
            this.f3179f = i8 + 1;
            C0841cq.m2928l(bArr6, i8, (byte) (i6 | 128));
            int i9 = i6 >>> 7;
            if ((i9 & (-128)) == 0) {
                byte[] bArr7 = this.f3177d;
                int i10 = this.f3179f;
                this.f3179f = i10 + 1;
                C0841cq.m2928l(bArr7, i10, (byte) i9);
                return;
            }
            byte[] bArr8 = this.f3177d;
            int i11 = this.f3179f;
            this.f3179f = i11 + 1;
            C0841cq.m2928l(bArr8, i11, (byte) (i9 | 128));
            int i12 = i9 >>> 7;
            if ((i12 & (-128)) == 0) {
                byte[] bArr9 = this.f3177d;
                int i13 = this.f3179f;
                this.f3179f = i13 + 1;
                C0841cq.m2928l(bArr9, i13, (byte) i12);
                return;
            }
            byte[] bArr10 = this.f3177d;
            int i14 = this.f3179f;
            this.f3179f = i14 + 1;
            C0841cq.m2928l(bArr10, i14, (byte) (i12 | 128));
            byte[] bArr11 = this.f3177d;
            int i15 = this.f3179f;
            this.f3179f = i15 + 1;
            C0841cq.m2928l(bArr11, i15, (byte) (i12 >>> 7));
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: P */
        public final void mo4539P(int i, int i2) throws IOException {
            mo4558m(i, 0);
            mo4554j(i2);
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: R */
        public final void mo4541R(int i, AbstractC1939tm abstractC1939tm) throws IOException {
            mo4558m(1, 3);
            mo4545Y(2, i);
            mo4560o(3, abstractC1939tm);
            mo4558m(1, 4);
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: T */
        public final void mo4543T(byte[] bArr, int i, int i2) throws IOException {
            mo4538O(i2);
            m4571G0(bArr, 0, i2);
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: Y */
        public final void mo4545Y(int i, int i2) throws IOException {
            mo4558m(i, 0);
            mo4538O(i2);
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: Z */
        public final void mo4546Z(int i, long j) throws IOException {
            mo4558m(i, 1);
            mo4547a0(j);
        }

        @Override // com.sonelli.AbstractC2020um
        /* renamed from: a */
        public final void mo4572a(byte[] bArr, int i, int i2) throws IOException {
            m4571G0(bArr, i, i2);
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: a0 */
        public final void mo4547a0(long j) throws IOException {
            try {
                byte[] bArr = this.f3177d;
                int i = this.f3179f;
                int i2 = i + 1;
                this.f3179f = i2;
                bArr[i] = (byte) j;
                int i3 = i2 + 1;
                this.f3179f = i3;
                bArr[i2] = (byte) (j >> 8);
                int i4 = i3 + 1;
                this.f3179f = i4;
                bArr[i3] = (byte) (j >> 16);
                int i5 = i4 + 1;
                this.f3179f = i5;
                bArr[i4] = (byte) (j >> 24);
                int i6 = i5 + 1;
                this.f3179f = i6;
                bArr[i5] = (byte) (j >> 32);
                int i7 = i6 + 1;
                this.f3179f = i7;
                bArr[i6] = (byte) (j >> 40);
                int i8 = i7 + 1;
                this.f3179f = i8;
                bArr[i7] = (byte) (j >> 48);
                this.f3179f = i8 + 1;
                bArr[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3179f), Integer.valueOf(this.f3178e), 1), e);
            }
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: b */
        public final int mo4548b() {
            return this.f3178e - this.f3179f;
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: f0 */
        public final void mo4549f0(int i) throws IOException {
            try {
                byte[] bArr = this.f3177d;
                int i2 = this.f3179f;
                int i3 = i2 + 1;
                this.f3179f = i3;
                bArr[i2] = (byte) i;
                int i4 = i3 + 1;
                this.f3179f = i4;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i4 + 1;
                this.f3179f = i5;
                bArr[i4] = (byte) (i >> 16);
                this.f3179f = i5 + 1;
                bArr[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3179f), Integer.valueOf(this.f3178e), 1), e);
            }
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: g */
        public final void mo4550g(byte b) throws IOException {
            try {
                byte[] bArr = this.f3177d;
                int i = this.f3179f;
                this.f3179f = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3179f), Integer.valueOf(this.f3178e), 1), e);
            }
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: j */
        public final void mo4554j(int i) throws IOException {
            if (i >= 0) {
                mo4538O(i);
            } else {
                mo4565t(i);
            }
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: k0 */
        public final void mo4556k0(int i, int i2) throws IOException {
            mo4558m(i, 5);
            mo4549f0(i2);
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: m */
        public final void mo4558m(int i, int i2) throws IOException {
            mo4538O((i << 3) | i2);
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: n */
        public final void mo4559n(int i, long j) throws IOException {
            mo4558m(i, 0);
            mo4565t(j);
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: o */
        public final void mo4560o(int i, AbstractC1939tm abstractC1939tm) throws IOException {
            mo4558m(i, 2);
            mo4566u(abstractC1939tm);
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: p */
        public final void mo4561p(int i, zzgt zzgtVar) throws IOException {
            mo4558m(1, 3);
            mo4545Y(2, i);
            mo4558m(3, 2);
            mo4567v(zzgtVar);
            mo4558m(1, 4);
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: q */
        public final void mo4562q(int i, zzgt zzgtVar, zzhi zzhiVar) throws IOException {
            mo4558m(i, 2);
            AbstractC1464km abstractC1464km = (AbstractC1464km) zzgtVar;
            int mo5947l = abstractC1464km.mo5947l();
            if (mo5947l == -1) {
                mo5947l = zzhiVar.mo1276e(abstractC1464km);
                abstractC1464km.mo5948m(mo5947l);
            }
            mo4538O(mo5947l);
            zzhiVar.mo1278g(zzgtVar, this.f3176a);
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: r */
        public final void mo4563r(int i, String str) throws IOException {
            mo4558m(i, 2);
            mo4568w(str);
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: s */
        public final void mo4564s(int i, boolean z) throws IOException {
            mo4558m(i, 0);
            mo4550g(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: t */
        public final void mo4565t(long j) throws IOException {
            if (AbstractC1116hn.f3175c && mo4548b() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.f3177d;
                    int i = this.f3179f;
                    this.f3179f = i + 1;
                    C0841cq.m2928l(bArr, i, (byte) ((((int) j) & KeycodeConstants.KEYCODE_MEDIA_PAUSE) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.f3177d;
                int i2 = this.f3179f;
                this.f3179f = i2 + 1;
                C0841cq.m2928l(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f3177d;
                    int i3 = this.f3179f;
                    this.f3179f = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & KeycodeConstants.KEYCODE_MEDIA_PAUSE) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new a(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3179f), Integer.valueOf(this.f3178e), 1), e);
                }
            }
            byte[] bArr4 = this.f3177d;
            int i4 = this.f3179f;
            this.f3179f = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: u */
        public final void mo4566u(AbstractC1939tm abstractC1939tm) throws IOException {
            mo4538O(abstractC1939tm.mo2150f());
            abstractC1939tm.mo2154n(this);
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: v */
        public final void mo4567v(zzgt zzgtVar) throws IOException {
            mo4538O(zzgtVar.mo1267j());
            zzgtVar.mo1264c(this);
        }

        @Override // com.sonelli.AbstractC1116hn
        /* renamed from: w */
        public final void mo4568w(String str) throws IOException {
            int i = this.f3179f;
            try {
                int m4525p0 = AbstractC1116hn.m4525p0(str.length() * 3);
                int m4525p02 = AbstractC1116hn.m4525p0(str.length());
                if (m4525p02 != m4525p0) {
                    mo4538O(C1008fq.m3859d(str));
                    this.f3179f = C1008fq.m3860e(str, this.f3177d, this.f3179f, mo4548b());
                    return;
                }
                int i2 = i + m4525p02;
                this.f3179f = i2;
                int m3860e = C1008fq.m3860e(str, this.f3177d, i2, mo4548b());
                this.f3179f = i;
                mo4538O((m3860e - i) - m4525p02);
                this.f3179f = m3860e;
            } catch (C1172iq e) {
                this.f3179f = i;
                m4569x(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new a(e2);
            }
        }
    }

    public AbstractC1116hn() {
    }

    /* renamed from: A */
    public static int m4488A(float f) {
        return 4;
    }

    /* renamed from: A0 */
    public static int m4489A0(int i) {
        return 4;
    }

    /* renamed from: B */
    public static int m4490B(int i, double d) {
        return m4518h0(i) + 8;
    }

    /* renamed from: B0 */
    public static int m4491B0(int i, int i2) {
        return m4518h0(i) + 4;
    }

    /* renamed from: C */
    public static int m4492C(int i, float f) {
        return m4518h0(i) + 4;
    }

    /* renamed from: C0 */
    public static int m4493C0(int i) {
        return m4521l0(i);
    }

    /* renamed from: D */
    public static int m4494D(int i, C1118ho c1118ho) {
        return (m4518h0(1) << 1) + m4526q0(2, i) + m4511c(3, c1118ho);
    }

    /* renamed from: D0 */
    public static int m4495D0(int i, int i2) {
        return m4518h0(i) + m4521l0(i2);
    }

    /* renamed from: E */
    public static int m4496E(int i, zzgt zzgtVar) {
        return (m4518h0(1) << 1) + m4526q0(2, i) + m4518h0(3) + m4503J(zzgtVar);
    }

    @Deprecated
    /* renamed from: E0 */
    public static int m4497E0(int i) {
        return m4525p0(i);
    }

    /* renamed from: F */
    public static int m4498F(int i, zzgt zzgtVar, zzhi zzhiVar) {
        return m4518h0(i) + m4515e(zzgtVar, zzhiVar);
    }

    /* renamed from: F0 */
    public static int m4499F0(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* renamed from: G */
    public static int m4500G(int i, String str) {
        return m4518h0(i) + m4504K(str);
    }

    /* renamed from: H */
    public static int m4501H(int i, boolean z) {
        return m4518h0(i) + 1;
    }

    /* renamed from: I */
    public static int m4502I(AbstractC1939tm abstractC1939tm) {
        int mo2150f = abstractC1939tm.mo2150f();
        return m4525p0(mo2150f) + mo2150f;
    }

    /* renamed from: J */
    public static int m4503J(zzgt zzgtVar) {
        int mo1267j = zzgtVar.mo1267j();
        return m4525p0(mo1267j) + mo1267j;
    }

    /* renamed from: K */
    public static int m4504K(String str) {
        int length;
        try {
            length = C1008fq.m3859d(str);
        } catch (C1172iq unused) {
            length = str.getBytes(C2435zn.f8565a).length;
        }
        return m4525p0(length) + length;
    }

    /* renamed from: L */
    public static int m4505L(boolean z) {
        return 1;
    }

    /* renamed from: M */
    public static int m4506M(byte[] bArr) {
        int length = bArr.length;
        return m4525p0(length) + length;
    }

    /* renamed from: U */
    public static int m4507U(int i, AbstractC1939tm abstractC1939tm) {
        int m4518h0 = m4518h0(i);
        int mo2150f = abstractC1939tm.mo2150f();
        return m4518h0 + m4525p0(mo2150f) + mo2150f;
    }

    @Deprecated
    /* renamed from: V */
    public static int m4508V(int i, zzgt zzgtVar, zzhi zzhiVar) {
        int m4518h0 = m4518h0(i) << 1;
        AbstractC1464km abstractC1464km = (AbstractC1464km) zzgtVar;
        int mo5947l = abstractC1464km.mo5947l();
        if (mo5947l == -1) {
            mo5947l = zzhiVar.mo1276e(abstractC1464km);
            abstractC1464km.mo5948m(mo5947l);
        }
        return m4518h0 + mo5947l;
    }

    @Deprecated
    /* renamed from: W */
    public static int m4509W(zzgt zzgtVar) {
        return zzgtVar.mo1267j();
    }

    /* renamed from: c */
    public static int m4511c(int i, C1118ho c1118ho) {
        int m4518h0 = m4518h0(i);
        int m4580b = c1118ho.m4580b();
        return m4518h0 + m4525p0(m4580b) + m4580b;
    }

    /* renamed from: c0 */
    public static int m4512c0(int i, long j) {
        return m4518h0(i) + m4520j0(j);
    }

    /* renamed from: d */
    public static int m4513d(C1118ho c1118ho) {
        int m4580b = c1118ho.m4580b();
        return m4525p0(m4580b) + m4580b;
    }

    /* renamed from: d0 */
    public static int m4514d0(int i, AbstractC1939tm abstractC1939tm) {
        return (m4518h0(1) << 1) + m4526q0(2, i) + m4507U(3, abstractC1939tm);
    }

    /* renamed from: e */
    public static int m4515e(zzgt zzgtVar, zzhi zzhiVar) {
        AbstractC1464km abstractC1464km = (AbstractC1464km) zzgtVar;
        int mo5947l = abstractC1464km.mo5947l();
        if (mo5947l == -1) {
            mo5947l = zzhiVar.mo1276e(abstractC1464km);
            abstractC1464km.mo5948m(mo5947l);
        }
        return m4525p0(mo5947l) + mo5947l;
    }

    /* renamed from: e0 */
    public static int m4516e0(long j) {
        return m4520j0(j);
    }

    /* renamed from: f */
    public static AbstractC1116hn m4517f(byte[] bArr) {
        return new b(bArr, 0, bArr.length);
    }

    /* renamed from: h0 */
    public static int m4518h0(int i) {
        return m4525p0(i << 3);
    }

    /* renamed from: i0 */
    public static int m4519i0(int i, long j) {
        return m4518h0(i) + m4520j0(j);
    }

    /* renamed from: j0 */
    public static int m4520j0(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    /* renamed from: l0 */
    public static int m4521l0(int i) {
        if (i >= 0) {
            return m4525p0(i);
        }
        return 10;
    }

    /* renamed from: m0 */
    public static int m4522m0(int i, int i2) {
        return m4518h0(i) + m4521l0(i2);
    }

    /* renamed from: n0 */
    public static int m4523n0(int i, long j) {
        return m4518h0(i) + m4520j0(m4536z0(j));
    }

    /* renamed from: o0 */
    public static int m4524o0(long j) {
        return m4520j0(m4536z0(j));
    }

    /* renamed from: p0 */
    public static int m4525p0(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    /* renamed from: q0 */
    public static int m4526q0(int i, int i2) {
        return m4518h0(i) + m4525p0(i2);
    }

    /* renamed from: r0 */
    public static int m4527r0(int i, long j) {
        return m4518h0(i) + 8;
    }

    /* renamed from: s0 */
    public static int m4528s0(long j) {
        return 8;
    }

    /* renamed from: t0 */
    public static int m4529t0(int i) {
        return m4525p0(m4499F0(i));
    }

    /* renamed from: u0 */
    public static int m4530u0(int i, int i2) {
        return m4518h0(i) + m4525p0(m4499F0(i2));
    }

    /* renamed from: v0 */
    public static int m4531v0(int i, long j) {
        return m4518h0(i) + 8;
    }

    /* renamed from: w0 */
    public static int m4532w0(long j) {
        return 8;
    }

    /* renamed from: x0 */
    public static int m4533x0(int i) {
        return 4;
    }

    /* renamed from: y0 */
    public static int m4534y0(int i, int i2) {
        return m4518h0(i) + 4;
    }

    /* renamed from: z */
    public static int m4535z(double d) {
        return 8;
    }

    /* renamed from: z0 */
    public static long m4536z0(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* renamed from: N */
    public final void m4537N() {
        if (mo4548b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: O */
    public abstract void mo4538O(int i) throws IOException;

    /* renamed from: P */
    public abstract void mo4539P(int i, int i2) throws IOException;

    /* renamed from: Q */
    public final void m4540Q(int i, long j) throws IOException {
        mo4559n(i, m4536z0(j));
    }

    /* renamed from: R */
    public abstract void mo4541R(int i, AbstractC1939tm abstractC1939tm) throws IOException;

    /* renamed from: S */
    public final void m4542S(long j) throws IOException {
        mo4565t(m4536z0(j));
    }

    /* renamed from: T */
    public abstract void mo4543T(byte[] bArr, int i, int i2) throws IOException;

    /* renamed from: X */
    public final void m4544X(int i) throws IOException {
        mo4538O(m4499F0(i));
    }

    /* renamed from: Y */
    public abstract void mo4545Y(int i, int i2) throws IOException;

    /* renamed from: Z */
    public abstract void mo4546Z(int i, long j) throws IOException;

    /* renamed from: a0 */
    public abstract void mo4547a0(long j) throws IOException;

    /* renamed from: b */
    public abstract int mo4548b();

    /* renamed from: f0 */
    public abstract void mo4549f0(int i) throws IOException;

    /* renamed from: g */
    public abstract void mo4550g(byte b2) throws IOException;

    /* renamed from: g0 */
    public final void m4551g0(int i, int i2) throws IOException {
        mo4545Y(i, m4499F0(i2));
    }

    /* renamed from: h */
    public final void m4552h(double d) throws IOException {
        mo4547a0(Double.doubleToRawLongBits(d));
    }

    /* renamed from: i */
    public final void m4553i(float f) throws IOException {
        mo4549f0(Float.floatToRawIntBits(f));
    }

    /* renamed from: j */
    public abstract void mo4554j(int i) throws IOException;

    /* renamed from: k */
    public final void m4555k(int i, double d) throws IOException {
        mo4546Z(i, Double.doubleToRawLongBits(d));
    }

    /* renamed from: k0 */
    public abstract void mo4556k0(int i, int i2) throws IOException;

    /* renamed from: l */
    public final void m4557l(int i, float f) throws IOException {
        mo4556k0(i, Float.floatToRawIntBits(f));
    }

    /* renamed from: m */
    public abstract void mo4558m(int i, int i2) throws IOException;

    /* renamed from: n */
    public abstract void mo4559n(int i, long j) throws IOException;

    /* renamed from: o */
    public abstract void mo4560o(int i, AbstractC1939tm abstractC1939tm) throws IOException;

    /* renamed from: p */
    public abstract void mo4561p(int i, zzgt zzgtVar) throws IOException;

    /* renamed from: q */
    public abstract void mo4562q(int i, zzgt zzgtVar, zzhi zzhiVar) throws IOException;

    /* renamed from: r */
    public abstract void mo4563r(int i, String str) throws IOException;

    /* renamed from: s */
    public abstract void mo4564s(int i, boolean z) throws IOException;

    /* renamed from: t */
    public abstract void mo4565t(long j) throws IOException;

    /* renamed from: u */
    public abstract void mo4566u(AbstractC1939tm abstractC1939tm) throws IOException;

    /* renamed from: v */
    public abstract void mo4567v(zzgt zzgtVar) throws IOException;

    /* renamed from: w */
    public abstract void mo4568w(String str) throws IOException;

    /* renamed from: x */
    public final void m4569x(String str, C1172iq c1172iq) throws IOException {
        f3174b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) c1172iq);
        byte[] bytes = str.getBytes(C2435zn.f8565a);
        try {
            mo4538O(bytes.length);
            mo4572a(bytes, 0, bytes.length);
        } catch (a e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new a(e2);
        }
    }

    /* renamed from: y */
    public final void m4570y(boolean z) throws IOException {
        mo4550g(z ? (byte) 1 : (byte) 0);
    }
}
