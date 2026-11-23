package cz.opentree;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.math.ec.ECConstants;

/* loaded from: classes.dex */
public abstract class hv0 implements ECConstants {

    /* renamed from: cz.opentree.hv0$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1129a extends hv0 {
        /* renamed from: u */
        public hv0 mo3342u() {
            int mo2280f = mo2280f();
            if ((mo2280f & 1) == 0) {
                throw new IllegalStateException("Half-trace only defined for odd m");
            }
            int i = (mo2280f + 1) >>> 1;
            int m4055a = 31 - g51.m4055a(i);
            hv0 hv0Var = this;
            int i2 = 1;
            while (m4055a > 0) {
                hv0Var = hv0Var.mo3341q(i2 << 1).mo2277a(hv0Var);
                m4055a--;
                i2 = i >>> m4055a;
                if ((i2 & 1) != 0) {
                    hv0Var = hv0Var.mo3341q(2).mo2277a(this);
                }
            }
            return hv0Var;
        }

        /* renamed from: v */
        public boolean mo3343v() {
            return false;
        }

        /* renamed from: w */
        public int mo3344w() {
            int mo2280f = mo2280f();
            int m4055a = 31 - g51.m4055a(mo2280f);
            hv0 hv0Var = this;
            int i = 1;
            while (m4055a > 0) {
                hv0Var = hv0Var.mo3341q(i).mo2277a(hv0Var);
                m4055a--;
                i = mo2280f >>> m4055a;
                if ((i & 1) != 0) {
                    hv0Var = hv0Var.mo2287o().mo2277a(this);
                }
            }
            if (hv0Var.mo2283i()) {
                return 0;
            }
            if (hv0Var.mo2282h()) {
                return 1;
            }
            throw new IllegalStateException("Internal error in trace calculation");
        }
    }

    /* renamed from: cz.opentree.hv0$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1130b extends hv0 {
    }

    /* renamed from: cz.opentree.hv0$c */
    /* loaded from: classes.dex */
    public static class C1131c extends AbstractC1129a {

        /* renamed from: e */
        public int f3232e;

        /* renamed from: f */
        public int f3233f;

        /* renamed from: g */
        public int[] f3234g;

        /* renamed from: h */
        public mv0 f3235h;

        public C1131c(int i, int i2, int i3, int i4, BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
                throw new IllegalArgumentException("x value invalid in F2m field element");
            }
            if (i3 == 0 && i4 == 0) {
                this.f3232e = 2;
                this.f3234g = new int[]{i2};
            } else {
                if (i3 >= i4) {
                    throw new IllegalArgumentException("k2 must be smaller than k3");
                }
                if (i3 <= 0) {
                    throw new IllegalArgumentException("k2 must be larger than 0");
                }
                this.f3232e = 3;
                this.f3234g = new int[]{i2, i3, i4};
            }
            this.f3233f = i;
            this.f3235h = new mv0(bigInteger);
        }

        public C1131c(int i, int[] iArr, mv0 mv0Var) {
            this.f3233f = i;
            this.f3232e = iArr.length == 1 ? 2 : 3;
            this.f3234g = iArr;
            this.f3235h = mv0Var;
        }

        @Override // cz.opentree.hv0
        /* renamed from: a */
        public hv0 mo2277a(hv0 hv0Var) {
            mv0 mv0Var = (mv0) this.f3235h.clone();
            mv0Var.m6563i(((C1131c) hv0Var).f3235h, 0);
            return new C1131c(this.f3233f, this.f3234g, mv0Var);
        }

        @Override // cz.opentree.hv0
        /* renamed from: b */
        public hv0 mo2278b() {
            return new C1131c(this.f3233f, this.f3234g, this.f3235h.m6561e());
        }

        @Override // cz.opentree.hv0
        /* renamed from: c */
        public int mo4653c() {
            return this.f3235h.m6565o();
        }

        @Override // cz.opentree.hv0
        /* renamed from: d */
        public hv0 mo2279d(hv0 hv0Var) {
            return mo2284j(hv0Var.mo2281g());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1131c)) {
                return false;
            }
            C1131c c1131c = (C1131c) obj;
            return this.f3233f == c1131c.f3233f && this.f3232e == c1131c.f3232e && e51.m3434c(this.f3234g, c1131c.f3234g) && this.f3235h.equals(c1131c.f3235h);
        }

        @Override // cz.opentree.hv0
        /* renamed from: f */
        public int mo2280f() {
            return this.f3233f;
        }

        @Override // cz.opentree.hv0
        /* renamed from: g */
        public hv0 mo2281g() {
            int i = this.f3233f;
            int[] iArr = this.f3234g;
            return new C1131c(i, iArr, this.f3235h.m6551A(i, iArr));
        }

        @Override // cz.opentree.hv0
        /* renamed from: h */
        public boolean mo2282h() {
            return this.f3235h.m6569y();
        }

        public int hashCode() {
            return (this.f3235h.hashCode() ^ this.f3233f) ^ e51.m3448q(this.f3234g);
        }

        @Override // cz.opentree.hv0
        /* renamed from: i */
        public boolean mo2283i() {
            return this.f3235h.m6570z();
        }

        @Override // cz.opentree.hv0
        /* renamed from: j */
        public hv0 mo2284j(hv0 hv0Var) {
            int i = this.f3233f;
            int[] iArr = this.f3234g;
            return new C1131c(i, iArr, this.f3235h.m6552B(((C1131c) hv0Var).f3235h, i, iArr));
        }

        @Override // cz.opentree.hv0
        /* renamed from: k */
        public hv0 mo3338k(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
            return mo3339l(hv0Var, hv0Var2, hv0Var3);
        }

        @Override // cz.opentree.hv0
        /* renamed from: l */
        public hv0 mo3339l(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
            mv0 mv0Var = this.f3235h;
            mv0 mv0Var2 = ((C1131c) hv0Var).f3235h;
            mv0 mv0Var3 = ((C1131c) hv0Var2).f3235h;
            mv0 mv0Var4 = ((C1131c) hv0Var3).f3235h;
            mv0 m6555E = mv0Var.m6555E(mv0Var2, this.f3233f, this.f3234g);
            mv0 m6555E2 = mv0Var3.m6555E(mv0Var4, this.f3233f, this.f3234g);
            if (m6555E == mv0Var || m6555E == mv0Var2) {
                m6555E = (mv0) m6555E.clone();
            }
            m6555E.m6563i(m6555E2, 0);
            m6555E.m6556G(this.f3233f, this.f3234g);
            return new C1131c(this.f3233f, this.f3234g, m6555E);
        }

        @Override // cz.opentree.hv0
        /* renamed from: m */
        public hv0 mo2285m() {
            return this;
        }

        @Override // cz.opentree.hv0
        /* renamed from: n */
        public hv0 mo2286n() {
            return (this.f3235h.m6570z() || this.f3235h.m6569y()) ? this : mo3341q(this.f3233f - 1);
        }

        @Override // cz.opentree.hv0
        /* renamed from: o */
        public hv0 mo2287o() {
            int i = this.f3233f;
            int[] iArr = this.f3234g;
            return new C1131c(i, iArr, this.f3235h.m6553C(i, iArr));
        }

        @Override // cz.opentree.hv0
        /* renamed from: p */
        public hv0 mo3340p(hv0 hv0Var, hv0 hv0Var2) {
            mv0 mv0Var = this.f3235h;
            mv0 mv0Var2 = ((C1131c) hv0Var).f3235h;
            mv0 mv0Var3 = ((C1131c) hv0Var2).f3235h;
            mv0 m6558R = mv0Var.m6558R(this.f3233f, this.f3234g);
            mv0 m6555E = mv0Var2.m6555E(mv0Var3, this.f3233f, this.f3234g);
            if (m6558R == mv0Var) {
                m6558R = (mv0) m6558R.clone();
            }
            m6558R.m6563i(m6555E, 0);
            m6558R.m6556G(this.f3233f, this.f3234g);
            return new C1131c(this.f3233f, this.f3234g, m6558R);
        }

        @Override // cz.opentree.hv0
        /* renamed from: q */
        public hv0 mo3341q(int i) {
            if (i < 1) {
                return this;
            }
            int i2 = this.f3233f;
            int[] iArr = this.f3234g;
            return new C1131c(i2, iArr, this.f3235h.m6554D(i, i2, iArr));
        }

        @Override // cz.opentree.hv0
        /* renamed from: r */
        public hv0 mo2288r(hv0 hv0Var) {
            return mo2277a(hv0Var);
        }

        @Override // cz.opentree.hv0
        /* renamed from: s */
        public boolean mo2289s() {
            return this.f3235h.m6559U();
        }

        @Override // cz.opentree.hv0
        /* renamed from: t */
        public BigInteger mo2290t() {
            return this.f3235h.m6560V();
        }
    }

    /* renamed from: cz.opentree.hv0$d */
    /* loaded from: classes.dex */
    public static class C1132d extends AbstractC1130b {

        /* renamed from: e */
        public BigInteger f3236e;

        /* renamed from: f */
        public BigInteger f3237f;

        /* renamed from: g */
        public BigInteger f3238g;

        public C1132d(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 == null || bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.f3236e = bigInteger;
            this.f3237f = bigInteger2;
            this.f3238g = bigInteger3;
        }

        /* renamed from: u */
        public static BigInteger m4655u(BigInteger bigInteger) {
            int bitLength = bigInteger.bitLength();
            if (bitLength < 96 || bigInteger.shiftRight(bitLength - 64).longValue() != -1) {
                return null;
            }
            return ECConstants.f8873b.shiftLeft(bitLength).subtract(bigInteger);
        }

        /* renamed from: A */
        public BigInteger m4656A(BigInteger bigInteger) {
            int mo2280f = mo2280f();
            int i = (mo2280f + 31) >> 5;
            int[] m7205p = p01.m7205p(mo2280f, this.f3236e);
            int[] m7205p2 = p01.m7205p(mo2280f, bigInteger);
            int[] m7200k = p01.m7200k(i);
            e01.m3375d(m7205p, m7205p2, m7200k);
            return p01.m7187R(i, m7200k);
        }

        /* renamed from: B */
        public BigInteger m4657B(BigInteger bigInteger, BigInteger bigInteger2) {
            return m4658C(bigInteger.multiply(bigInteger2));
        }

        /* renamed from: C */
        public BigInteger m4658C(BigInteger bigInteger) {
            if (this.f3237f == null) {
                return bigInteger.mod(this.f3236e);
            }
            boolean z = bigInteger.signum() < 0;
            if (z) {
                bigInteger = bigInteger.abs();
            }
            int bitLength = this.f3236e.bitLength();
            boolean equals = this.f3237f.equals(ECConstants.f8873b);
            while (bigInteger.bitLength() > bitLength + 1) {
                BigInteger shiftRight = bigInteger.shiftRight(bitLength);
                BigInteger subtract = bigInteger.subtract(shiftRight.shiftLeft(bitLength));
                if (!equals) {
                    shiftRight = shiftRight.multiply(this.f3237f);
                }
                bigInteger = shiftRight.add(subtract);
            }
            while (bigInteger.compareTo(this.f3236e) >= 0) {
                bigInteger = bigInteger.subtract(this.f3236e);
            }
            return (!z || bigInteger.signum() == 0) ? bigInteger : this.f3236e.subtract(bigInteger);
        }

        /* renamed from: D */
        public BigInteger m4659D(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger subtract = bigInteger.subtract(bigInteger2);
            return subtract.signum() < 0 ? subtract.add(this.f3236e) : subtract;
        }

        @Override // cz.opentree.hv0
        /* renamed from: a */
        public hv0 mo2277a(hv0 hv0Var) {
            return new C1132d(this.f3236e, this.f3237f, m4662x(this.f3238g, hv0Var.mo2290t()));
        }

        @Override // cz.opentree.hv0
        /* renamed from: b */
        public hv0 mo2278b() {
            BigInteger add = this.f3238g.add(ECConstants.f8873b);
            if (add.compareTo(this.f3236e) == 0) {
                add = ECConstants.f8872a;
            }
            return new C1132d(this.f3236e, this.f3237f, add);
        }

        @Override // cz.opentree.hv0
        /* renamed from: d */
        public hv0 mo2279d(hv0 hv0Var) {
            return new C1132d(this.f3236e, this.f3237f, m4657B(this.f3238g, m4656A(hv0Var.mo2290t())));
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1132d)) {
                return false;
            }
            C1132d c1132d = (C1132d) obj;
            return this.f3236e.equals(c1132d.f3236e) && this.f3238g.equals(c1132d.f3238g);
        }

        @Override // cz.opentree.hv0
        /* renamed from: f */
        public int mo2280f() {
            return this.f3236e.bitLength();
        }

        @Override // cz.opentree.hv0
        /* renamed from: g */
        public hv0 mo2281g() {
            return new C1132d(this.f3236e, this.f3237f, m4656A(this.f3238g));
        }

        public int hashCode() {
            return this.f3236e.hashCode() ^ this.f3238g.hashCode();
        }

        @Override // cz.opentree.hv0
        /* renamed from: j */
        public hv0 mo2284j(hv0 hv0Var) {
            return new C1132d(this.f3236e, this.f3237f, m4657B(this.f3238g, hv0Var.mo2290t()));
        }

        @Override // cz.opentree.hv0
        /* renamed from: k */
        public hv0 mo3338k(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
            BigInteger bigInteger = this.f3238g;
            BigInteger mo2290t = hv0Var.mo2290t();
            BigInteger mo2290t2 = hv0Var2.mo2290t();
            BigInteger mo2290t3 = hv0Var3.mo2290t();
            return new C1132d(this.f3236e, this.f3237f, m4658C(bigInteger.multiply(mo2290t).subtract(mo2290t2.multiply(mo2290t3))));
        }

        @Override // cz.opentree.hv0
        /* renamed from: l */
        public hv0 mo3339l(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
            BigInteger bigInteger = this.f3238g;
            BigInteger mo2290t = hv0Var.mo2290t();
            BigInteger mo2290t2 = hv0Var2.mo2290t();
            BigInteger mo2290t3 = hv0Var3.mo2290t();
            return new C1132d(this.f3236e, this.f3237f, m4658C(bigInteger.multiply(mo2290t).add(mo2290t2.multiply(mo2290t3))));
        }

        @Override // cz.opentree.hv0
        /* renamed from: m */
        public hv0 mo2285m() {
            if (this.f3238g.signum() == 0) {
                return this;
            }
            BigInteger bigInteger = this.f3236e;
            return new C1132d(bigInteger, this.f3237f, bigInteger.subtract(this.f3238g));
        }

        @Override // cz.opentree.hv0
        /* renamed from: n */
        public hv0 mo2286n() {
            if (mo2283i() || mo2282h()) {
                return this;
            }
            if (!this.f3236e.testBit(0)) {
                throw new RuntimeException("not done yet");
            }
            if (this.f3236e.testBit(1)) {
                BigInteger add = this.f3236e.shiftRight(2).add(ECConstants.f8873b);
                BigInteger bigInteger = this.f3236e;
                return m4660v(new C1132d(bigInteger, this.f3237f, this.f3238g.modPow(add, bigInteger)));
            }
            if (this.f3236e.testBit(2)) {
                BigInteger modPow = this.f3238g.modPow(this.f3236e.shiftRight(3), this.f3236e);
                BigInteger m4657B = m4657B(modPow, this.f3238g);
                if (m4657B(m4657B, modPow).equals(ECConstants.f8873b)) {
                    return m4660v(new C1132d(this.f3236e, this.f3237f, m4657B));
                }
                return m4660v(new C1132d(this.f3236e, this.f3237f, m4657B(m4657B, ECConstants.f8874c.modPow(this.f3236e.shiftRight(2), this.f3236e))));
            }
            BigInteger shiftRight = this.f3236e.shiftRight(1);
            BigInteger modPow2 = this.f3238g.modPow(shiftRight, this.f3236e);
            BigInteger bigInteger2 = ECConstants.f8873b;
            if (!modPow2.equals(bigInteger2)) {
                return null;
            }
            BigInteger bigInteger3 = this.f3238g;
            BigInteger m4663y = m4663y(m4663y(bigInteger3));
            BigInteger add2 = shiftRight.add(bigInteger2);
            BigInteger subtract = this.f3236e.subtract(bigInteger2);
            Random random = new Random();
            while (true) {
                BigInteger bigInteger4 = new BigInteger(this.f3236e.bitLength(), random);
                if (bigInteger4.compareTo(this.f3236e) < 0 && m4658C(bigInteger4.multiply(bigInteger4).subtract(m4663y)).modPow(shiftRight, this.f3236e).equals(subtract)) {
                    BigInteger[] m4661w = m4661w(bigInteger4, bigInteger3, add2);
                    BigInteger bigInteger5 = m4661w[0];
                    BigInteger bigInteger6 = m4661w[1];
                    if (m4657B(bigInteger6, bigInteger6).equals(m4663y)) {
                        return new C1132d(this.f3236e, this.f3237f, m4664z(bigInteger6));
                    }
                    if (!bigInteger5.equals(ECConstants.f8873b) && !bigInteger5.equals(subtract)) {
                        return null;
                    }
                }
            }
        }

        @Override // cz.opentree.hv0
        /* renamed from: o */
        public hv0 mo2287o() {
            BigInteger bigInteger = this.f3236e;
            BigInteger bigInteger2 = this.f3237f;
            BigInteger bigInteger3 = this.f3238g;
            return new C1132d(bigInteger, bigInteger2, m4657B(bigInteger3, bigInteger3));
        }

        @Override // cz.opentree.hv0
        /* renamed from: p */
        public hv0 mo3340p(hv0 hv0Var, hv0 hv0Var2) {
            BigInteger bigInteger = this.f3238g;
            BigInteger mo2290t = hv0Var.mo2290t();
            BigInteger mo2290t2 = hv0Var2.mo2290t();
            return new C1132d(this.f3236e, this.f3237f, m4658C(bigInteger.multiply(bigInteger).add(mo2290t.multiply(mo2290t2))));
        }

        @Override // cz.opentree.hv0
        /* renamed from: r */
        public hv0 mo2288r(hv0 hv0Var) {
            return new C1132d(this.f3236e, this.f3237f, m4659D(this.f3238g, hv0Var.mo2290t()));
        }

        @Override // cz.opentree.hv0
        /* renamed from: t */
        public BigInteger mo2290t() {
            return this.f3238g;
        }

        /* renamed from: v */
        public final hv0 m4660v(hv0 hv0Var) {
            if (hv0Var.mo2287o().equals(this)) {
                return hv0Var;
            }
            return null;
        }

        /* renamed from: w */
        public final BigInteger[] m4661w(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            int bitLength = bigInteger3.bitLength();
            int lowestSetBit = bigInteger3.getLowestSetBit();
            BigInteger bigInteger4 = ECConstants.f8873b;
            BigInteger bigInteger5 = bigInteger;
            BigInteger bigInteger6 = bigInteger4;
            BigInteger bigInteger7 = ECConstants.f8874c;
            BigInteger bigInteger8 = bigInteger6;
            for (int i = bitLength - 1; i >= lowestSetBit + 1; i--) {
                bigInteger4 = m4657B(bigInteger4, bigInteger8);
                if (bigInteger3.testBit(i)) {
                    bigInteger8 = m4657B(bigInteger4, bigInteger2);
                    bigInteger6 = m4657B(bigInteger6, bigInteger5);
                    bigInteger7 = m4658C(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(bigInteger4)));
                    bigInteger5 = m4658C(bigInteger5.multiply(bigInteger5).subtract(bigInteger8.shiftLeft(1)));
                } else {
                    BigInteger m4658C = m4658C(bigInteger6.multiply(bigInteger7).subtract(bigInteger4));
                    BigInteger m4658C2 = m4658C(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(bigInteger4)));
                    bigInteger7 = m4658C(bigInteger7.multiply(bigInteger7).subtract(bigInteger4.shiftLeft(1)));
                    bigInteger5 = m4658C2;
                    bigInteger6 = m4658C;
                    bigInteger8 = bigInteger4;
                }
            }
            BigInteger m4657B = m4657B(bigInteger4, bigInteger8);
            BigInteger m4657B2 = m4657B(m4657B, bigInteger2);
            BigInteger m4658C3 = m4658C(bigInteger6.multiply(bigInteger7).subtract(m4657B));
            BigInteger m4658C4 = m4658C(bigInteger5.multiply(bigInteger7).subtract(bigInteger.multiply(m4657B)));
            BigInteger m4657B3 = m4657B(m4657B, m4657B2);
            for (int i2 = 1; i2 <= lowestSetBit; i2++) {
                m4658C3 = m4657B(m4658C3, m4658C4);
                m4658C4 = m4658C(m4658C4.multiply(m4658C4).subtract(m4657B3.shiftLeft(1)));
                m4657B3 = m4657B(m4657B3, m4657B3);
            }
            return new BigInteger[]{m4658C3, m4658C4};
        }

        /* renamed from: x */
        public BigInteger m4662x(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger add = bigInteger.add(bigInteger2);
            return add.compareTo(this.f3236e) >= 0 ? add.subtract(this.f3236e) : add;
        }

        /* renamed from: y */
        public BigInteger m4663y(BigInteger bigInteger) {
            BigInteger shiftLeft = bigInteger.shiftLeft(1);
            return shiftLeft.compareTo(this.f3236e) >= 0 ? shiftLeft.subtract(this.f3236e) : shiftLeft;
        }

        /* renamed from: z */
        public BigInteger m4664z(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.f3236e.subtract(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }
    }

    /* renamed from: a */
    public abstract hv0 mo2277a(hv0 hv0Var);

    /* renamed from: b */
    public abstract hv0 mo2278b();

    /* renamed from: c */
    public int mo4653c() {
        return mo2290t().bitLength();
    }

    /* renamed from: d */
    public abstract hv0 mo2279d(hv0 hv0Var);

    /* renamed from: e */
    public byte[] m4654e() {
        return f51.m3682a((mo2280f() + 7) / 8, mo2290t());
    }

    /* renamed from: f */
    public abstract int mo2280f();

    /* renamed from: g */
    public abstract hv0 mo2281g();

    /* renamed from: h */
    public boolean mo2282h() {
        return mo4653c() == 1;
    }

    /* renamed from: i */
    public boolean mo2283i() {
        return mo2290t().signum() == 0;
    }

    /* renamed from: j */
    public abstract hv0 mo2284j(hv0 hv0Var);

    /* renamed from: k */
    public hv0 mo3338k(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        return mo2284j(hv0Var).mo2288r(hv0Var2.mo2284j(hv0Var3));
    }

    /* renamed from: l */
    public hv0 mo3339l(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        return mo2284j(hv0Var).mo2277a(hv0Var2.mo2284j(hv0Var3));
    }

    /* renamed from: m */
    public abstract hv0 mo2285m();

    /* renamed from: n */
    public abstract hv0 mo2286n();

    /* renamed from: o */
    public abstract hv0 mo2287o();

    /* renamed from: p */
    public hv0 mo3340p(hv0 hv0Var, hv0 hv0Var2) {
        return mo2287o().mo2277a(hv0Var.mo2284j(hv0Var2));
    }

    /* renamed from: q */
    public hv0 mo3341q(int i) {
        hv0 hv0Var = this;
        for (int i2 = 0; i2 < i; i2++) {
            hv0Var = hv0Var.mo2287o();
        }
        return hv0Var;
    }

    /* renamed from: r */
    public abstract hv0 mo2288r(hv0 hv0Var);

    /* renamed from: s */
    public boolean mo2289s() {
        return mo2290t().testBit(0);
    }

    /* renamed from: t */
    public abstract BigInteger mo2290t();

    public String toString() {
        return mo2290t().toString(16);
    }
}
