package cz.opentree;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class ft0 {
    /* renamed from: a */
    public int m3878a(hv0 hv0Var) {
        return (hv0Var.mo2280f() + 7) / 8;
    }

    /* renamed from: b */
    public byte[] m3879b(BigInteger bigInteger, int i) {
        byte[] byteArray = bigInteger.toByteArray();
        if (i < byteArray.length) {
            byte[] bArr = new byte[i];
            System.arraycopy(byteArray, byteArray.length - i, bArr, 0, i);
            return bArr;
        }
        if (i <= byteArray.length) {
            return byteArray;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(byteArray, 0, bArr2, i - byteArray.length, byteArray.length);
        return bArr2;
    }
}
