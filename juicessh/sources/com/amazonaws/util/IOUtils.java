package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public enum IOUtils {
    ;


    /* renamed from: O */
    public static final Log f484O = LogFactory.m237c(IOUtils.class);

    /* renamed from: f */
    public static byte[] m669f(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            byteArrayOutputStream.close();
        }
    }

    /* renamed from: h */
    public static String m670h(InputStream inputStream) throws IOException {
        return new String(m669f(inputStream), StringUtils.f489a);
    }
}
