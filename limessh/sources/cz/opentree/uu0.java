package cz.opentree;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import org.bouncycastle.jce.interfaces.ECPrivateKey;

/* loaded from: classes.dex */
public class uu0 {
    /* renamed from: a */
    public static int[] m9072a(int[] iArr) {
        int[] iArr2 = new int[3];
        if (iArr.length == 1) {
            iArr2[0] = iArr[0];
        } else {
            if (iArr.length != 3) {
                throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
            }
            if (iArr[0] < iArr[1] && iArr[0] < iArr[2]) {
                iArr2[0] = iArr[0];
                if (iArr[1] < iArr[2]) {
                    iArr2[1] = iArr[1];
                    iArr2[2] = iArr[2];
                } else {
                    iArr2[1] = iArr[2];
                    iArr2[2] = iArr[1];
                }
            } else if (iArr[1] < iArr[2]) {
                iArr2[0] = iArr[1];
                if (iArr[0] < iArr[2]) {
                    iArr2[1] = iArr[0];
                    iArr2[2] = iArr[2];
                } else {
                    iArr2[1] = iArr[2];
                    iArr2[2] = iArr[0];
                }
            } else {
                iArr2[0] = iArr[2];
                if (iArr[0] < iArr[1]) {
                    iArr2[1] = iArr[0];
                    iArr2[2] = iArr[1];
                } else {
                    iArr2[1] = iArr[1];
                    iArr2[2] = iArr[0];
                }
            }
        }
        return iArr2;
    }

    /* renamed from: b */
    public static vt0 m9073b(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof ECPrivateKey) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) privateKey;
            cv0 m10756a = eCPrivateKey.m10756a();
            if (m10756a == null) {
                m10756a = yu0.f8321P.mo10632a();
            }
            if (!(eCPrivateKey.m10756a() instanceof av0)) {
                return new gu0(eCPrivateKey.m10757g(), new du0(m10756a.m3046a(), m10756a.m3047b(), m10756a.m3049d(), m10756a.m3048c(), m10756a.m3050e()));
            }
            return new gu0(eCPrivateKey.m10757g(), new fu0(xs0.m9883d(((av0) eCPrivateKey.m10756a()).m2276f()), m10756a.m3046a(), m10756a.m3047b(), m10756a.m3049d(), m10756a.m3048c(), m10756a.m3050e()));
        }
        if (privateKey instanceof java.security.interfaces.ECPrivateKey) {
            java.security.interfaces.ECPrivateKey eCPrivateKey2 = (java.security.interfaces.ECPrivateKey) privateKey;
            cv0 m8815c = tu0.m8815c(eCPrivateKey2.getParams());
            return new gu0(eCPrivateKey2.getS(), new du0(m8815c.m3046a(), m8815c.m3047b(), m8815c.m3049d(), m8815c.m3048c(), m8815c.m3050e()));
        }
        try {
            byte[] encoded = privateKey.getEncoded();
            if (encoded == null) {
                throw new InvalidKeyException("no encoding for EC private key");
            }
            PrivateKey m10225e = yu0.m10225e(qs0.m7779m(encoded));
            if (m10225e instanceof java.security.interfaces.ECPrivateKey) {
                return m9073b(m10225e);
            }
            throw new InvalidKeyException("can't identify EC private key.");
        } catch (Exception e) {
            throw new InvalidKeyException("cannot identify EC private key: " + e.toString());
        }
    }
}
