package cz.opentree;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SHA256.java */
/* loaded from: classes.dex */
public class tg0 {
    /* renamed from: a */
    public static byte[] m8683a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return m8684b(str.getBytes(StandardCharsets.UTF_8));
    }

    /* renamed from: b */
    public static byte[] m8684b(byte[] bArr) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    /* renamed from: c */
    public static String m8685c(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return rg0.m7903a(m8683a(str));
    }
}
