package cz.opentree;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public class wf0 {

    /* renamed from: a */
    public static final byte f7686a = Byte.parseByte("01110000", 2);

    /* renamed from: b */
    public static final byte f7687b = Byte.parseByte("00001111", 2);

    /* renamed from: b */
    public static String m9492b(byte[] bArr) {
        return new String(Base64.encode(bArr, 11), Charset.defaultCharset()).substring(0, 22);
    }

    /* renamed from: c */
    public static byte[] m9493c(UUID uuid, byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.putLong(uuid.getMostSignificantBits());
        wrap.putLong(uuid.getLeastSignificantBits());
        return wrap.array();
    }

    @NonNull
    /* renamed from: a */
    public String m9494a() {
        byte[] m9493c = m9493c(UUID.randomUUID(), new byte[17]);
        m9493c[16] = m9493c[0];
        m9493c[0] = (byte) ((f7687b & m9493c[0]) | f7686a);
        return m9492b(m9493c);
    }
}
