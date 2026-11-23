package com.sonelli;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.util.encoders.Encoder;

/* loaded from: classes.dex */
public class k51 {

    /* renamed from: a */
    public static final Encoder f4489a = new l51();

    /* renamed from: a */
    public static byte[] m5841a(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((str.length() / 4) * 3);
        try {
            f4489a.mo6083a(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new m51("unable to decode base64 string: " + e.getMessage(), e);
        }
    }
}
