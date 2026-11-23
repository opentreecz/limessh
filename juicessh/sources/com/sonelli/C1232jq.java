package com.sonelli;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.jq */
/* loaded from: classes.dex */
public final class C1232jq extends AbstractC1067gq {
    @Override // com.sonelli.AbstractC1067gq
    /* renamed from: a */
    public final int mo4239a(int i, byte[] bArr, int i2, int i3) {
        int m3868m;
        int m3868m2;
        while (i2 < i3 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i3) {
            return 0;
        }
        while (i2 < i3) {
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b < 0) {
                if (b < -32) {
                    if (i4 >= i3) {
                        return b;
                    }
                    if (b >= -62) {
                        i2 = i4 + 1;
                        if (bArr[i4] > -65) {
                        }
                    }
                    return -1;
                }
                if (b >= -16) {
                    if (i4 >= i3 - 2) {
                        m3868m2 = C1008fq.m3868m(bArr, i4, i3);
                        return m3868m2;
                    }
                    int i5 = i4 + 1;
                    byte b2 = bArr[i4];
                    if (b2 <= -65 && (((b << 28) + (b2 + 112)) >> 30) == 0) {
                        int i6 = i5 + 1;
                        if (bArr[i5] <= -65) {
                            i4 = i6 + 1;
                            if (bArr[i6] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                if (i4 >= i3 - 1) {
                    m3868m = C1008fq.m3868m(bArr, i4, i3);
                    return m3868m;
                }
                int i7 = i4 + 1;
                byte b3 = bArr[i4];
                if (b3 <= -65 && ((b != -32 || b3 >= -96) && (b != -19 || b3 < -96))) {
                    i2 = i7 + 1;
                    if (bArr[i7] > -65) {
                    }
                }
                return -1;
            }
            i2 = i4;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r10 + r0;
     */
    @Override // com.sonelli.AbstractC1067gq
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int mo4240b(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.C1232jq.mo4240b(java.lang.CharSequence, byte[], int, int):int");
    }

    @Override // com.sonelli.AbstractC1067gq
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
            byte b = bArr[i];
            m4634l3 = C1123hq.m4634l(b);
            if (!m4634l3) {
                break;
            }
            i++;
            C1123hq.m4631i(b, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            m4634l = C1123hq.m4634l(b2);
            if (m4634l) {
                int i7 = i5 + 1;
                C1123hq.m4631i(b2, cArr, i5);
                while (i6 < i3) {
                    byte b3 = bArr[i6];
                    m4634l2 = C1123hq.m4634l(b3);
                    if (!m4634l2) {
                        break;
                    }
                    i6++;
                    C1123hq.m4631i(b3, cArr, i7);
                    i7++;
                }
                i = i6;
                i5 = i7;
            } else {
                m4635m = C1123hq.m4635m(b2);
                if (!m4635m) {
                    m4636n = C1123hq.m4636n(b2);
                    if (m4636n) {
                        if (i6 >= i3 - 1) {
                            throw C0839co.m2894f();
                        }
                        int i8 = i6 + 1;
                        C1123hq.m4629g(b2, bArr[i6], bArr[i8], cArr, i5);
                        i = i8 + 1;
                        i5++;
                    } else {
                        if (i6 >= i3 - 2) {
                            throw C0839co.m2894f();
                        }
                        int i9 = i6 + 1;
                        byte b4 = bArr[i6];
                        int i10 = i9 + 1;
                        C1123hq.m4628f(b2, b4, bArr[i9], bArr[i10], cArr, i5);
                        i = i10 + 1;
                        i5 = i5 + 1 + 1;
                    }
                } else {
                    if (i6 >= i3) {
                        throw C0839co.m2894f();
                    }
                    C1123hq.m4630h(b2, bArr[i6], cArr, i5);
                    i = i6 + 1;
                    i5++;
                }
            }
        }
        return new String(cArr, 0, i5);
    }
}
