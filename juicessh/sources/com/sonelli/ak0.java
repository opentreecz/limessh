package com.sonelli;

import android.util.Base64;
import com.sonelli.libssh.adapter.SSHAuthenticator;
import com.sun.jna.Function;
import java.io.StringReader;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Security;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

/* compiled from: SSHAuthAgentKey.java */
/* loaded from: classes.dex */
public class ak0 {

    /* renamed from: a */
    public final ck0 f1430a;

    /* renamed from: b */
    public final int f1431b;

    /* renamed from: c */
    public final String f1432c;

    /* renamed from: d */
    public final String f1433d;

    public ak0(ck0 ck0Var, int i, String str, String str2) {
        Security.addProvider(new yu0());
        this.f1430a = ck0Var;
        this.f1431b = i;
        this.f1432c = str;
        this.f1433d = str2;
    }

    /* renamed from: a */
    public String m2134a() {
        return this.f1433d;
    }

    /* renamed from: b */
    public byte[] m2135b() {
        return Base64.decode(this.f1433d, 0);
    }

    /* renamed from: c */
    public int m2136c() {
        return this.f1431b;
    }

    /* renamed from: d */
    public byte[] m2137d(byte[] bArr, int i) {
        int i2 = this.f1431b;
        if (i2 == 2) {
            return m2140g(bArr, i);
        }
        if (i2 == 5) {
            return m2139f(bArr);
        }
        switch (i2) {
            case 8:
                return m2138e(256, bArr, i);
            case 9:
                return m2138e(Function.USE_VARARGS, bArr, i);
            case 10:
                return m2138e(521, bArr, i);
            default:
                return null;
        }
    }

    /* renamed from: e */
    public final byte[] m2138e(int i, byte[] bArr, int i2) {
        String str = "SHA-256";
        if (i != 256) {
            if (i == 384) {
                str = "SHA-384";
            } else if (i == 521) {
                str = "SHA-512";
            }
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            vt0 m9073b = uu0.m9073b(KeyFactory.getInstance("EC").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(this.f1432c.replace("-----BEGIN PRIVATE KEY-----\n", "").replace("-----END PRIVATE KEY-----", "").trim(), 0))));
            nu0 nu0Var = new nu0();
            nu0Var.m6797d(true, m9073b);
            BigInteger[] m6796c = nu0Var.m6796c(digest);
            byte[] byteArray = m6796c[0].abs().toByteArray();
            byte[] byteArray2 = m6796c[1].abs().toByteArray();
            byte[] bytes = SSHAuthenticator.m6192f(m2136c()).trim().getBytes();
            ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 4 + 4 + 4 + byteArray.length + 4 + byteArray2.length);
            allocate.order(ByteOrder.BIG_ENDIAN);
            allocate.putInt(bytes.length);
            allocate.put(bytes);
            allocate.putInt(byteArray.length + 4 + 4 + byteArray2.length);
            allocate.putInt(byteArray.length);
            allocate.put(byteArray);
            allocate.putInt(byteArray2.length);
            allocate.put(byteArray2);
            return allocate.array();
        } catch (Exception e) {
            this.f1430a.m2849j("Failed to sign data with ECDSA key for auth agent request: " + e.getMessage());
            return null;
        }
    }

    /* renamed from: f */
    public final byte[] m2139f(byte[] bArr) {
        try {
            iu0 iu0Var = (iu0) hk0.m4481b(new u51(new StringReader(this.f1432c)).m8855b().m8596a());
            ou0 ou0Var = new ou0();
            ou0Var.mo7102b(true, iu0Var);
            ou0Var.mo7101a(bArr, 0, bArr.length);
            byte[] mo7103c = ou0Var.mo7103c();
            byte[] bytes = SSHAuthenticator.m6192f(m2136c()).trim().getBytes();
            ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 4 + 4 + mo7103c.length);
            allocate.order(ByteOrder.BIG_ENDIAN);
            allocate.putInt(bytes.length);
            allocate.put(bytes);
            allocate.putInt(mo7103c.length);
            allocate.put(mo7103c);
            return allocate.array();
        } catch (Exception e) {
            this.f1430a.m2849j("Failed to sign data with ed25519 for auth agent request: " + e.getMessage());
            return null;
        }
    }

    /* renamed from: g */
    public final byte[] m2140g(byte[] bArr, int i) {
        String str;
        String str2;
        if (i == 0) {
            str = "SHA1withRSA";
            str2 = "ssh-rsa";
        } else {
            try {
                if ((i & 4) > 0) {
                    str = "SHA512withRSA";
                    str2 = "rsa-sha2-512";
                } else {
                    if ((i & 2) <= 0) {
                        this.f1430a.m2849j("Invalid SSH agent signing flags for RSA key: " + i);
                        return null;
                    }
                    str = "SHA256withRSA";
                    str2 = "rsa-sha2-256";
                }
            } catch (Exception e) {
                this.f1430a.m2849j("Failed to sign data with RSA key for auth agent request: " + e.getMessage());
                return null;
            }
        }
        String str3 = str2;
        String str4 = str;
        byte[] decode = Base64.decode(this.f1432c.replace("-----BEGIN PRIVATE KEY-----\n", "").replace("-----END PRIVATE KEY-----", "").trim(), 0);
        try {
            fq0 m3869t = fq0.m3869t(decode);
            fq0 m3869t2 = fq0.m3869t(((bq0) m3869t.mo3870u(2)).m2598v());
            if (m3869t2.size() == 6) {
                this.f1430a.m2849j("Received a PKCS#8 RSA key without dP, dQ and qInv parameters - generating them...");
                ((xp0) m3869t2.mo3870u(1)).m9870v();
                ((xp0) m3869t2.mo3870u(2)).m9870v();
                BigInteger m9870v = ((xp0) m3869t2.mo3870u(3)).m9870v();
                BigInteger m9870v2 = ((xp0) m3869t2.mo3870u(4)).m9870v();
                BigInteger m9870v3 = ((xp0) m3869t2.mo3870u(5)).m9870v();
                BigInteger mod = m9870v.mod(m9870v2.subtract(BigInteger.valueOf(1L)));
                BigInteger mod2 = m9870v.mod(m9870v3.subtract(BigInteger.valueOf(1L)));
                BigInteger modInverse = m9870v3.modInverse(m9870v2);
                rp0 rp0Var = new rp0();
                rp0Var.m8224a(m3869t.mo3870u(0));
                rp0Var.m8224a(m3869t.mo3870u(1));
                rp0 rp0Var2 = new rp0();
                rp0Var2.m8224a(m3869t2.mo3870u(0));
                rp0Var2.m8224a(m3869t2.mo3870u(1));
                rp0Var2.m8224a(m3869t2.mo3870u(2));
                rp0Var2.m8224a(m3869t2.mo3870u(3));
                rp0Var2.m8224a(m3869t2.mo3870u(4));
                rp0Var2.m8224a(m3869t2.mo3870u(5));
                rp0Var2.m8224a(new xp0(mod));
                rp0Var2.m8224a(new xp0(mod2));
                rp0Var2.m8224a(new xp0(modInverse));
                rp0Var.m8224a(new gr0(new kr0(rp0Var2).getEncoded()));
                decode = new kr0(rp0Var).getEncoded();
            }
        } catch (Exception e2) {
            this.f1430a.m2849j("Failed to patch bad PKCS#8 RSA key: " + e2.getMessage());
        }
        PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decode));
        Signature signature = Signature.getInstance(str4);
        signature.initSign(generatePrivate);
        signature.update(bArr);
        byte[] sign = signature.sign();
        ByteBuffer allocate = ByteBuffer.allocate(str3.getBytes().length + 4 + 4 + sign.length);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.putInt(str3.getBytes().length);
        allocate.put(str3.getBytes());
        allocate.putInt(sign.length);
        allocate.put(sign);
        return allocate.array();
    }
}
