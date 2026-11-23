package cz.opentree;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.lq */
/* loaded from: classes.dex */
public final class C1519lq extends AbstractC1067gq {
    /* renamed from: e */
    public static int m6278e(byte[] bArr, int i, long j, int i2) {
        int m3863h;
        int m3864i;
        int m3865j;
        if (i2 == 0) {
            m3863h = C1008fq.m3863h(i);
            return m3863h;
        }
        if (i2 == 1) {
            m3864i = C1008fq.m3864i(i, C0841cq.m2917a(bArr, j));
            return m3864i;
        }
        if (i2 != 2) {
            throw new AssertionError();
        }
        m3865j = C1008fq.m3865j(i, C0841cq.m2917a(bArr, j), C0841cq.m2917a(bArr, j + 1));
        return m3865j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ba, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0065, code lost:
    
        return -1;
     */
    @Override // cz.opentree.AbstractC1067gq
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int mo4239a(int r18, byte[] r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C1519lq.mo4239a(int, byte[], int, int):int");
    }

    @Override // cz.opentree.AbstractC1067gq
    /* renamed from: b */
    public final int mo4240b(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char c;
        long j;
        long j2;
        long j3;
        char c2;
        int i3;
        char charAt;
        long j4 = i;
        long j5 = i2 + j4;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            c = 128;
            j = 1;
            if (i4 >= length || (charAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            C0841cq.m2928l(bArr, j4, (byte) charAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char charAt3 = charSequence.charAt(i4);
            if (charAt3 < c && j4 < j5) {
                long j6 = j4 + j;
                C0841cq.m2928l(bArr, j4, (byte) charAt3);
                j3 = j;
                j2 = j6;
                c2 = c;
            } else if (charAt3 < 2048 && j4 <= j5 - 2) {
                long j7 = j4 + j;
                C0841cq.m2928l(bArr, j4, (byte) ((charAt3 >>> 6) | 960));
                long j8 = j7 + j;
                C0841cq.m2928l(bArr, j7, (byte) ((charAt3 & '?') | 128));
                long j9 = j;
                c2 = 128;
                j2 = j8;
                j3 = j9;
            } else {
                if ((charAt3 >= 55296 && 57343 >= charAt3) || j4 > j5 - 3) {
                    if (j4 > j5 - 4) {
                        if (55296 <= charAt3 && charAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                            throw new C1172iq(i4, length);
                        }
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(charAt3);
                        sb2.append(" at index ");
                        sb2.append(j4);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                    int i5 = i4 + 1;
                    if (i5 != length) {
                        char charAt4 = charSequence.charAt(i5);
                        if (Character.isSurrogatePair(charAt3, charAt4)) {
                            int codePoint = Character.toCodePoint(charAt3, charAt4);
                            long j10 = j4 + 1;
                            C0841cq.m2928l(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                            long j11 = j10 + 1;
                            c2 = 128;
                            C0841cq.m2928l(bArr, j10, (byte) (((codePoint >>> 12) & 63) | 128));
                            long j12 = j11 + 1;
                            C0841cq.m2928l(bArr, j11, (byte) (((codePoint >>> 6) & 63) | 128));
                            j3 = 1;
                            j2 = j12 + 1;
                            C0841cq.m2928l(bArr, j12, (byte) ((codePoint & 63) | 128));
                            i4 = i5;
                        } else {
                            i4 = i5;
                        }
                    }
                    throw new C1172iq(i4 - 1, length);
                }
                long j13 = j4 + j;
                C0841cq.m2928l(bArr, j4, (byte) ((charAt3 >>> '\f') | 480));
                long j14 = j13 + j;
                C0841cq.m2928l(bArr, j13, (byte) (((charAt3 >>> 6) & 63) | 128));
                C0841cq.m2928l(bArr, j14, (byte) ((charAt3 & '?') | 128));
                j2 = j14 + 1;
                j3 = 1;
                c2 = 128;
            }
            i4++;
            c = c2;
            long j15 = j3;
            j4 = j2;
            j = j15;
        }
        return (int) j4;
    }

    @Override // cz.opentree.AbstractC1067gq
    /* renamed from: d */
    public final String mo4242d(byte[] bArr, int i, int i2) throws C0839co {
        boolean m4634l;
        boolean m4634l2;
        boolean m4635m;
        boolean m4636n;
        boolean m4634l3;
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte m2917a = C0841cq.m2917a(bArr, i);
            m4634l3 = C1123hq.m4634l(m2917a);
            if (!m4634l3) {
                break;
            }
            i++;
            C1123hq.m4631i(m2917a, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte m2917a2 = C0841cq.m2917a(bArr, i);
            m4634l = C1123hq.m4634l(m2917a2);
            if (m4634l) {
                int i7 = i5 + 1;
                C1123hq.m4631i(m2917a2, cArr, i5);
                while (i6 < i3) {
                    byte m2917a3 = C0841cq.m2917a(bArr, i6);
                    m4634l2 = C1123hq.m4634l(m2917a3);
                    if (!m4634l2) {
                        break;
                    }
                    i6++;
                    C1123hq.m4631i(m2917a3, cArr, i7);
                    i7++;
                }
                i = i6;
                i5 = i7;
            } else {
                m4635m = C1123hq.m4635m(m2917a2);
                if (!m4635m) {
                    m4636n = C1123hq.m4636n(m2917a2);
                    if (m4636n) {
                        if (i6 >= i3 - 1) {
                            throw C0839co.m2894f();
                        }
                        int i8 = i6 + 1;
                        C1123hq.m4629g(m2917a2, C0841cq.m2917a(bArr, i6), C0841cq.m2917a(bArr, i8), cArr, i5);
                        i = i8 + 1;
                        i5++;
                    } else {
                        if (i6 >= i3 - 2) {
                            throw C0839co.m2894f();
                        }
                        int i9 = i6 + 1;
                        byte m2917a4 = C0841cq.m2917a(bArr, i6);
                        int i10 = i9 + 1;
                        C1123hq.m4628f(m2917a2, m2917a4, C0841cq.m2917a(bArr, i9), C0841cq.m2917a(bArr, i10), cArr, i5);
                        i = i10 + 1;
                        i5 = i5 + 1 + 1;
                    }
                } else {
                    if (i6 >= i3) {
                        throw C0839co.m2894f();
                    }
                    C1123hq.m4630h(m2917a2, C0841cq.m2917a(bArr, i6), cArr, i5);
                    i = i6 + 1;
                    i5++;
                }
            }
        }
        return new String(cArr, 0, i5);
    }
}
