package cz.opentree;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class v80 {

    /* renamed from: a */
    public static final AtomicLong f7427a = new AtomicLong(0);

    /* renamed from: b */
    public static String f7428b;

    public v80(h90 h90Var) {
        byte[] bArr = new byte[10];
        m9200e(bArr);
        m9199d(bArr);
        m9198c(bArr);
        String m9420G = w80.m9420G(h90Var.mo1740a());
        String m9447z = w80.m9447z(bArr);
        Locale locale = Locale.US;
        f7428b = String.format(locale, "%s-%s-%s-%s", m9447z.substring(0, 12), m9447z.substring(12, 16), m9447z.subSequence(16, 20), m9420G.substring(0, 12)).toUpperCase(locale);
    }

    /* renamed from: a */
    public static byte[] m9196a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    /* renamed from: b */
    public static byte[] m9197b(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    /* renamed from: c */
    public final void m9198c(byte[] bArr) {
        byte[] m9197b = m9197b(Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = m9197b[0];
        bArr[9] = m9197b[1];
    }

    /* renamed from: d */
    public final void m9199d(byte[] bArr) {
        byte[] m9197b = m9197b(f7427a.incrementAndGet());
        bArr[6] = m9197b[0];
        bArr[7] = m9197b[1];
    }

    /* renamed from: e */
    public final void m9200e(byte[] bArr) {
        long time = new Date().getTime();
        byte[] m9196a = m9196a(time / 1000);
        bArr[0] = m9196a[0];
        bArr[1] = m9196a[1];
        bArr[2] = m9196a[2];
        bArr[3] = m9196a[3];
        byte[] m9197b = m9197b(time % 1000);
        bArr[4] = m9197b[0];
        bArr[5] = m9197b[1];
    }

    public String toString() {
        return f7428b;
    }
}
