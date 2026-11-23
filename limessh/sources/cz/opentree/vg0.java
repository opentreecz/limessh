package cz.opentree;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

/* compiled from: Signer.java */
/* loaded from: classes.dex */
public class vg0 {

    /* renamed from: a */
    public static final BigInteger f7456a = new BigInteger("D5D7142396AA5D94E0FF502B57A7AF02DB21C74C5B7F7547C3C865574DD7124329B673786E2F563649B0265F6A748B43E2739B931CDA09B007942FCFA8FC2C81076F4A5A86D61F8B6519E06D3BBF5BE81978D724323D1DE384AEBF81906AFD2CFAB8E4C7051BDDC234E030B1D316EE7D7F321A247549ADEB3F41A103F50531350BAA0273CFA9E51FE67117ADED94591D421B9D3F268633D04DD184ECF631958E8F9EC88622A43577C9402A924528BCAB9AC739575063853E81AA71A1D0E820E5D6C5D4520061710D7492198343CFFA34B9A631A159BE19548D6ACB23BA2065BE9951C61C3197AF53F4242F9EC1C75A90F531D015CFE911E9684A3CA172CDD847", 16);

    /* renamed from: b */
    public static final BigInteger f7457b = new BigInteger("10001", 16);

    /* renamed from: a */
    public static byte[] m9222a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    /* renamed from: b */
    public static boolean m9223b(String str, String str2) {
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(f7456a, f7457b));
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(rSAPublicKey);
            signature.update(str2.getBytes(StandardCharsets.UTF_8));
            return signature.verify(m9222a(str));
        } catch (InvalidKeyException e) {
            gj0.m4142c("cz.opentree.crypto.signer", e.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e2) {
            gj0.m4142c("cz.opentree.crypto.signer", e2.getMessage());
            return false;
        } catch (SignatureException e3) {
            gj0.m4142c("cz.opentree.crypto.signer", e3.getMessage());
            return false;
        } catch (InvalidKeySpecException e4) {
            gj0.m4142c("cz.opentree.crypto.signer", e4.getMessage());
            return false;
        }
    }
}
