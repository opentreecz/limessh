package com.sonelli;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DSAExt;
import org.bouncycastle.crypto.signers.DSAKCalculator;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECMultiplier;

/* loaded from: classes.dex */
public class nu0 implements ECConstants, DSAExt {

    /* renamed from: e */
    public final DSAKCalculator f5378e = new pu0();

    /* renamed from: f */
    public eu0 f5379f;

    /* renamed from: g */
    public SecureRandom f5380g;

    /* renamed from: a */
    public BigInteger m6794a(BigInteger bigInteger, byte[] bArr) {
        int bitLength = bigInteger.bitLength();
        int length = bArr.length * 8;
        BigInteger bigInteger2 = new BigInteger(1, bArr);
        return bitLength < length ? bigInteger2.shiftRight(length - bitLength) : bigInteger2;
    }

    /* renamed from: b */
    public ECMultiplier m6795b() {
        return new jv0();
    }

    /* renamed from: c */
    public BigInteger[] m6796c(byte[] bArr) {
        du0 m3559a = this.f5379f.m3559a();
        BigInteger m3321d = m3559a.m3321d();
        BigInteger m6794a = m6794a(m3321d, bArr);
        BigInteger m4258b = ((gu0) this.f5379f).m4258b();
        if (this.f5378e.mo7550b()) {
            this.f5378e.mo7552d(m3321d, m4258b, bArr);
        } else {
            this.f5378e.mo7551c(m3321d, this.f5380g);
        }
        ECMultiplier m6795b = m6795b();
        while (true) {
            BigInteger mo7549a = this.f5378e.mo7549a();
            BigInteger mod = m6795b.mo3560a(m3559a.m3319b(), mo7549a).m4949w().m4935e().mo2290t().mod(m3321d);
            BigInteger bigInteger = ECConstants.f8872a;
            if (!mod.equals(bigInteger)) {
                BigInteger mod2 = mo7549a.modInverse(m3321d).multiply(m6794a.add(m4258b.multiply(mod))).mod(m3321d);
                if (!mod2.equals(bigInteger)) {
                    return new BigInteger[]{mod, mod2};
                }
            }
        }
    }

    /* renamed from: d */
    public void m6797d(boolean z, CipherParameters cipherParameters) {
        eu0 eu0Var;
        SecureRandom secureRandom;
        if (!z) {
            eu0Var = (hu0) cipherParameters;
        } else {
            if (cipherParameters instanceof ku0) {
                ku0 ku0Var = (ku0) cipherParameters;
                this.f5379f = (gu0) ku0Var.m5998a();
                secureRandom = ku0Var.m5999b();
                this.f5380g = m6798e((z || this.f5378e.mo7550b()) ? false : true, secureRandom);
            }
            eu0Var = (gu0) cipherParameters;
        }
        this.f5379f = eu0Var;
        secureRandom = null;
        this.f5380g = m6798e((z || this.f5378e.mo7550b()) ? false : true, secureRandom);
    }

    /* renamed from: e */
    public SecureRandom m6798e(boolean z, SecureRandom secureRandom) {
        if (z) {
            return secureRandom != null ? secureRandom : it0.m4920b();
        }
        return null;
    }
}
