package cz.opentree;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES.java */
/* loaded from: classes.dex */
public class qg0 {

    /* renamed from: a */
    public static boolean f5995a = false;

    /* compiled from: AES.java */
    /* renamed from: cz.opentree.qg0$a */
    /* loaded from: classes.dex */
    public static class C1762a extends Exception {
    }

    /* renamed from: a */
    public static String m7700a(String str, String str2) throws C1762a {
        if (str == null || str.length() < 1 || str2 == null || str2.length() < 1) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String[] split = str.split("#");
        if (split.length != 3) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(split[0], 2);
            byte[] decode2 = Base64.decode(split[1], 2);
            byte[] decode3 = Base64.decode(split[2], 2);
            SecretKey m7701b = m7701b(decode, str2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, m7701b, new IvParameterSpec(decode2));
            String str3 = new String(cipher.doFinal(decode3), StandardCharsets.UTF_8);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (f5995a) {
                gj0.m4141b("AES", String.format("AES-256 decryption took %dms.", Long.valueOf(currentTimeMillis2)));
            }
            return str3;
        } catch (IllegalArgumentException unused) {
            gj0.m4141b("AES", "Tried to decrypt an invalid encrypted string");
            return null;
        } catch (GeneralSecurityException e) {
            gj0.m4141b("AES", "GeneralSecurityException: " + e.getMessage());
            throw new C1762a();
        }
    }

    /* renamed from: b */
    public static SecretKey m7701b(byte[] bArr, String str) {
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), bArr, 1000, 256)).getEncoded(), "AES");
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    public static String m7702c(String str, String str2) {
        if (str != null && str.length() >= 1 && str2 != null && str2.length() >= 1) {
            long currentTimeMillis = System.currentTimeMillis();
            SecureRandom secureRandom = new SecureRandom();
            byte[] bArr = new byte[8];
            secureRandom.nextBytes(bArr);
            try {
                try {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str2.toCharArray(), bArr, 1000, 256)).getEncoded(), "AES");
                    try {
                        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        byte[] bArr2 = new byte[cipher.getBlockSize()];
                        secureRandom.nextBytes(bArr2);
                        try {
                            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2));
                            try {
                                byte[] doFinal = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
                                String str3 = Base64.encodeToString(bArr, 2) + "#" + Base64.encodeToString(bArr2, 2) + "#" + Base64.encodeToString(doFinal, 2);
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                if (f5995a) {
                                    gj0.m4141b("AES", String.format("AES-256 encryption took %dms.", Long.valueOf(currentTimeMillis2)));
                                }
                                return str3;
                            } catch (BadPaddingException e) {
                                e.printStackTrace();
                                return null;
                            } catch (IllegalBlockSizeException e2) {
                                e2.printStackTrace();
                                return null;
                            }
                        } catch (InvalidAlgorithmParameterException e3) {
                            e3.printStackTrace();
                            return null;
                        } catch (InvalidKeyException e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    } catch (NoSuchAlgorithmException e5) {
                        e5.printStackTrace();
                        return null;
                    } catch (NoSuchPaddingException e6) {
                        e6.printStackTrace();
                        return null;
                    }
                } catch (InvalidKeySpecException e7) {
                    e7.printStackTrace();
                    return null;
                }
            } catch (NoSuchAlgorithmException e8) {
                e8.printStackTrace();
            }
        }
        return null;
    }
}
