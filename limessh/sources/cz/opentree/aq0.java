package cz.opentree;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class aq0 extends eq0 {

    /* renamed from: Q */
    public static final ConcurrentMap<C0734a, aq0> f1509Q = new ConcurrentHashMap();

    /* renamed from: O */
    public final String f1510O;

    /* renamed from: P */
    public byte[] f1511P;

    /* renamed from: cz.opentree.aq0$a */
    /* loaded from: classes.dex */
    public static class C0734a {

        /* renamed from: a */
        public final int f1512a;

        /* renamed from: b */
        public final byte[] f1513b;

        public C0734a(byte[] bArr) {
            this.f1512a = e51.m3445n(bArr);
            this.f1513b = bArr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0734a) {
                return e51.m3432a(this.f1513b, ((C0734a) obj).f1513b);
            }
            return false;
        }

        public int hashCode() {
            return this.f1512a;
        }
    }

    public aq0(aq0 aq0Var, String str) {
        if (!m2252C(str, 0)) {
            throw new IllegalArgumentException("string " + str + " not a valid OID branch");
        }
        this.f1510O = aq0Var.m2266x() + "." + str;
    }

    public aq0(String str) {
        Objects.requireNonNull(str, "'identifier' cannot be null");
        if (m2253E(str)) {
            this.f1510O = str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not an OID");
    }

    public aq0(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        long j = 0;
        BigInteger bigInteger = null;
        for (int i = 0; i != bArr.length; i++) {
            int i2 = bArr[i] & 255;
            if (j <= 72057594037927808L) {
                long j2 = j + (i2 & KeycodeConstants.KEYCODE_MEDIA_PAUSE);
                if ((i2 & 128) == 0) {
                    if (z) {
                        if (j2 < 40) {
                            stringBuffer.append('0');
                        } else if (j2 < 80) {
                            stringBuffer.append('1');
                            j2 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j2 -= 80;
                        }
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j2);
                    j = 0;
                } else {
                    j = j2 << 7;
                }
            } else {
                BigInteger or = (bigInteger == null ? BigInteger.valueOf(j) : bigInteger).or(BigInteger.valueOf(i2 & KeycodeConstants.KEYCODE_MEDIA_PAUSE));
                if ((i2 & 128) == 0) {
                    if (z) {
                        stringBuffer.append('2');
                        or = or.subtract(BigInteger.valueOf(80L));
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(or);
                    j = 0;
                    bigInteger = null;
                } else {
                    bigInteger = or.shiftLeft(7);
                }
            }
        }
        this.f1510O = stringBuffer.toString();
        this.f1511P = e51.m3436e(bArr);
    }

    /* renamed from: A */
    public static aq0 m2251A(Object obj) {
        if (obj == null || (obj instanceof aq0)) {
            return (aq0) obj;
        }
        if (obj instanceof ASN1Encodable) {
            eq0 mo1950f = ((ASN1Encodable) obj).mo1950f();
            if (mo1950f instanceof aq0) {
                return (aq0) mo1950f;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (aq0) eq0.m3546p((byte[]) obj);
        } catch (IOException e) {
            throw new IllegalArgumentException("failed to construct object identifier from byte[]: " + e.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0015, code lost:
    
        if (r2 == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0017, code lost:
    
        if (r2 <= 1) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x001f, code lost:
    
        if (r7.charAt(r0 + 1) != '0') goto L33;
     */
    /* renamed from: C */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean m2252C(java.lang.String r7, int r8) {
        /*
            int r0 = r7.length()
            r1 = 0
        L5:
            r2 = r1
        L6:
            int r0 = r0 + (-1)
            r3 = 48
            r4 = 1
            if (r0 < r8) goto L2c
            char r5 = r7.charAt(r0)
            r6 = 46
            if (r5 != r6) goto L22
            if (r2 == 0) goto L21
            if (r2 <= r4) goto L5
            int r2 = r0 + 1
            char r2 = r7.charAt(r2)
            if (r2 != r3) goto L5
        L21:
            return r1
        L22:
            if (r3 > r5) goto L2b
            r3 = 57
            if (r5 > r3) goto L2b
            int r2 = r2 + 1
            goto L6
        L2b:
            return r1
        L2c:
            if (r2 == 0) goto L39
            if (r2 <= r4) goto L38
            int r0 = r0 + r4
            char r7 = r7.charAt(r0)
            if (r7 != r3) goto L38
            goto L39
        L38:
            return r4
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.aq0.m2252C(java.lang.String, int):boolean");
    }

    /* renamed from: E */
    public static boolean m2253E(String str) {
        char charAt;
        if (str.length() < 3 || str.charAt(1) != '.' || (charAt = str.charAt(0)) < '0' || charAt > '2') {
            return false;
        }
        return m2252C(str, 2);
    }

    /* renamed from: v */
    public static aq0 m2254v(byte[] bArr) {
        aq0 aq0Var = f1509Q.get(new C0734a(bArr));
        return aq0Var == null ? new aq0(bArr) : aq0Var;
    }

    /* renamed from: B */
    public aq0 m2255B() {
        C0734a c0734a = new C0734a(m2265w());
        ConcurrentMap<C0734a, aq0> concurrentMap = f1509Q;
        aq0 aq0Var = concurrentMap.get(c0734a);
        if (aq0Var != null) {
            return aq0Var;
        }
        aq0 putIfAbsent = concurrentMap.putIfAbsent(c0734a, this);
        return putIfAbsent == null ? this : putIfAbsent;
    }

    /* renamed from: F */
    public boolean m2256F(aq0 aq0Var) {
        String m2266x = m2266x();
        String m2266x2 = aq0Var.m2266x();
        return m2266x.length() > m2266x2.length() && m2266x.charAt(m2266x2.length()) == '.' && m2266x.startsWith(m2266x2);
    }

    /* renamed from: G */
    public final void m2257G(ByteArrayOutputStream byteArrayOutputStream, long j) {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j) & KeycodeConstants.KEYCODE_MEDIA_PAUSE);
        while (j >= 128) {
            j >>= 7;
            i--;
            bArr[i] = (byte) ((((int) j) & KeycodeConstants.KEYCODE_MEDIA_PAUSE) | 128);
        }
        byteArrayOutputStream.write(bArr, i, 9 - i);
    }

    /* renamed from: H */
    public final void m2258H(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[bitLength];
        int i = bitLength - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((bigInteger.intValue() & KeycodeConstants.KEYCODE_MEDIA_PAUSE) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & Byte.MAX_VALUE);
        byteArrayOutputStream.write(bArr, 0, bitLength);
    }

    @Override // cz.opentree.zp0
    public int hashCode() {
        return this.f1510O.hashCode();
    }

    @Override // cz.opentree.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (eq0Var == this) {
            return true;
        }
        if (eq0Var instanceof aq0) {
            return this.f1510O.equals(((aq0) eq0Var).f1510O);
        }
        return false;
    }

    @Override // cz.opentree.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2968n(z, 6, m2265w());
    }

    @Override // cz.opentree.eq0
    /* renamed from: n */
    public int mo2261n() throws IOException {
        int length = m2265w().length;
        return ks0.m5992a(length) + 1 + length;
    }

    @Override // cz.opentree.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }

    /* renamed from: t */
    public aq0 m2263t(String str) {
        return new aq0(this, str);
    }

    public String toString() {
        return m2266x();
    }

    /* renamed from: u */
    public final void m2264u(ByteArrayOutputStream byteArrayOutputStream) {
        js0 js0Var = new js0(this.f1510O);
        int parseInt = Integer.parseInt(js0Var.m5191b()) * 40;
        String m5191b = js0Var.m5191b();
        if (m5191b.length() <= 18) {
            m2257G(byteArrayOutputStream, parseInt + Long.parseLong(m5191b));
        } else {
            m2258H(byteArrayOutputStream, new BigInteger(m5191b).add(BigInteger.valueOf(parseInt)));
        }
        while (js0Var.m5190a()) {
            String m5191b2 = js0Var.m5191b();
            if (m5191b2.length() <= 18) {
                m2257G(byteArrayOutputStream, Long.parseLong(m5191b2));
            } else {
                m2258H(byteArrayOutputStream, new BigInteger(m5191b2));
            }
        }
    }

    /* renamed from: w */
    public final synchronized byte[] m2265w() {
        if (this.f1511P == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            m2264u(byteArrayOutputStream);
            this.f1511P = byteArrayOutputStream.toByteArray();
        }
        return this.f1511P;
    }

    /* renamed from: x */
    public String m2266x() {
        return this.f1510O;
    }
}
