package com.sonelli;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.yb */
/* loaded from: classes.dex */
public class C2338yb {
    /* renamed from: a */
    public static byte[] m10119a(Context context, String str) throws PackageManager.NameNotFoundException {
        MessageDigest m10120b;
        PackageInfo m9468e = C2272xc.m9755a(context).m9468e(str, 64);
        Signature[] signatureArr = m9468e.signatures;
        if (signatureArr == null || signatureArr.length != 1 || (m10120b = m10120b("SHA1")) == null) {
            return null;
        }
        return m10120b.digest(m9468e.signatures[0].toByteArray());
    }

    /* renamed from: b */
    public static MessageDigest m10120b(String str) {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }
}
