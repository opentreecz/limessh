package cz.opentree;

import com.google.android.gms.internal.measurement.zzgt;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.zn */
/* loaded from: classes.dex */
public final class C2435zn {

    /* renamed from: a */
    public static final Charset f8565a = Charset.forName("UTF-8");

    /* renamed from: b */
    public static final byte[] f8566b;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f8566b = bArr;
        ByteBuffer.wrap(bArr);
        AbstractC0838cn.m2883b(bArr, 0, bArr.length, false);
    }

    /* renamed from: a */
    public static int m10535a(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    /* renamed from: b */
    public static int m10536b(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: c */
    public static int m10537c(boolean z) {
        return z ? 1231 : 1237;
    }

    /* renamed from: d */
    public static <T> T m10538d(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    /* renamed from: e */
    public static Object m10539e(Object obj, Object obj2) {
        return ((zzgt) obj).mo1266i().mo1258K((zzgt) obj2).mo1260n();
    }

    /* renamed from: f */
    public static <T> T m10540f(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    /* renamed from: g */
    public static boolean m10541g(zzgt zzgtVar) {
        if (!(zzgtVar instanceof AbstractC1514lm)) {
            return false;
        }
        return false;
    }

    /* renamed from: h */
    public static boolean m10542h(byte[] bArr) {
        return C1008fq.m3861f(bArr);
    }

    /* renamed from: i */
    public static String m10543i(byte[] bArr) {
        return new String(bArr, f8565a);
    }

    /* renamed from: j */
    public static int m10544j(byte[] bArr) {
        int length = bArr.length;
        int m10535a = m10535a(length, bArr, 0, length);
        if (m10535a == 0) {
            return 1;
        }
        return m10535a;
    }
}
