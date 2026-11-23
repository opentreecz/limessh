package com.sonelli;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.sonelli.qm0;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.http2.Header;
import okio.BufferedSource;
import okio.Source;

/* compiled from: Util.java */
/* loaded from: classes.dex */
public final class fn0 {

    /* renamed from: a */
    public static final byte[] f2722a;

    /* renamed from: b */
    public static final String[] f2723b = new String[0];

    /* renamed from: c */
    public static final an0 f2724c;

    /* renamed from: d */
    public static final ap0 f2725d;

    /* renamed from: e */
    public static final ap0 f2726e;

    /* renamed from: f */
    public static final ap0 f2727f;

    /* renamed from: g */
    public static final ap0 f2728g;

    /* renamed from: h */
    public static final ap0 f2729h;

    /* renamed from: i */
    public static final Charset f2730i;

    /* renamed from: j */
    public static final Charset f2731j;

    /* renamed from: k */
    public static final Charset f2732k;

    /* renamed from: l */
    public static final Charset f2733l;

    /* renamed from: m */
    public static final Charset f2734m;

    /* renamed from: n */
    public static final TimeZone f2735n;

    /* renamed from: o */
    public static final Comparator<String> f2736o;

    /* renamed from: p */
    public static final Method f2737p;

    /* renamed from: q */
    public static final Pattern f2738q;

    /* compiled from: Util.java */
    /* renamed from: com.sonelli.fn0$a */
    /* loaded from: classes.dex */
    public class C1003a implements Comparator<String> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    /* compiled from: Util.java */
    /* renamed from: com.sonelli.fn0$b */
    /* loaded from: classes.dex */
    public class ThreadFactoryC1004b implements ThreadFactory {

        /* renamed from: a */
        public final /* synthetic */ String f2739a;

        /* renamed from: b */
        public final /* synthetic */ boolean f2740b;

        public ThreadFactoryC1004b(String str, boolean z) {
            this.f2739a = str;
            this.f2740b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f2739a);
            thread.setDaemon(this.f2740b);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        f2722a = bArr;
        Method method = null;
        f2724c = an0.m2160f(null, bArr);
        ym0.m10192e(null, bArr);
        f2725d = ap0.m2231l("efbbbf");
        f2726e = ap0.m2231l("feff");
        f2727f = ap0.m2231l("fffe");
        f2728g = ap0.m2231l("0000ffff");
        f2729h = ap0.m2231l("ffff0000");
        f2730i = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        f2731j = Charset.forName("UTF-16BE");
        f2732k = Charset.forName("UTF-16LE");
        f2733l = Charset.forName("UTF-32BE");
        f2734m = Charset.forName("UTF-32LE");
        f2735n = TimeZone.getTimeZone("GMT");
        f2736o = new C1003a();
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        f2737p = method;
        f2738q = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    /* renamed from: A */
    public static boolean m3810A(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: B */
    public static boolean m3811B(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: C */
    public static X509TrustManager m3812C() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw m3821b("No System TLS", e);
        }
    }

    /* renamed from: D */
    public static boolean m3813D(Source source, int i, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long mo3306c = source.mo2188g().mo3308e() ? source.mo2188g().mo3306c() - nanoTime : Long.MAX_VALUE;
        source.mo2188g().mo3307d(Math.min(mo3306c, timeUnit.toNanos(i)) + nanoTime);
        try {
            zo0 zo0Var = new zo0();
            while (source.mo2186R(zo0Var, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                zo0Var.m10550b();
            }
            if (mo3306c == RecyclerView.FOREVER_NS) {
                source.mo2188g().mo3304a();
            } else {
                source.mo2188g().mo3307d(nanoTime + mo3306c);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (mo3306c == RecyclerView.FOREVER_NS) {
                source.mo2188g().mo3304a();
            } else {
                source.mo2188g().mo3307d(nanoTime + mo3306c);
            }
            return false;
        } catch (Throwable th) {
            if (mo3306c == RecyclerView.FOREVER_NS) {
                source.mo2188g().mo3304a();
            } else {
                source.mo2188g().mo3307d(nanoTime + mo3306c);
            }
            throw th;
        }
    }

    /* renamed from: E */
    public static int m3814E(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: F */
    public static int m3815F(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    /* renamed from: G */
    public static ThreadFactory m3816G(String str, boolean z) {
        return new ThreadFactoryC1004b(str, z);
    }

    /* renamed from: H */
    public static qm0 m3817H(List<Header> list) {
        qm0.C1776a c1776a = new qm0.C1776a();
        for (Header header : list) {
            dn0.f2249a.mo3266b(c1776a, header.f8662a.mo2236B(), header.f8663b.mo2236B());
        }
        return c1776a.m7758d();
    }

    /* renamed from: I */
    public static String m3818I(String str, int i, int i2) {
        int m3814E = m3814E(str, i, i2);
        return str.substring(m3814E, m3815F(str, m3814E, i2));
    }

    /* renamed from: J */
    public static boolean m3819J(String str) {
        return f2738q.matcher(str).matches();
    }

    /* renamed from: a */
    public static void m3820a(Throwable th, Throwable th2) {
        Method method = f2737p;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    /* renamed from: b */
    public static AssertionError m3821b(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    /* renamed from: c */
    public static Charset m3822c(BufferedSource bufferedSource, Charset charset) throws IOException {
        if (bufferedSource.mo4893B(0L, f2725d)) {
            bufferedSource.skip(r0.mo2247w());
            return f2730i;
        }
        if (bufferedSource.mo4893B(0L, f2726e)) {
            bufferedSource.skip(r0.mo2247w());
            return f2731j;
        }
        if (bufferedSource.mo4893B(0L, f2727f)) {
            bufferedSource.skip(r0.mo2247w());
            return f2732k;
        }
        if (bufferedSource.mo4893B(0L, f2728g)) {
            bufferedSource.skip(r0.mo2247w());
            return f2733l;
        }
        if (!bufferedSource.mo4893B(0L, f2729h)) {
            return charset;
        }
        bufferedSource.skip(r0.mo2247w());
        return f2734m;
    }

    /* renamed from: d */
    public static String m3823d(String str) {
        if (!str.contains(":")) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (m3829j(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress m3832m = (str.startsWith("[") && str.endsWith("]")) ? m3832m(str, 1, str.length() - 1) : m3832m(str, 0, str.length());
        if (m3832m == null) {
            return null;
        }
        byte[] address = m3832m.getAddress();
        if (address.length == 16) {
            return m3844y(address);
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + "'");
    }

    /* renamed from: e */
    public static int m3824e(String str, long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        Objects.requireNonNull(timeUnit, "unit == null");
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str + " too large.");
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str + " too small.");
    }

    /* renamed from: f */
    public static void m3825f(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: g */
    public static void m3826g(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: h */
    public static void m3827h(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e) {
                if (!m3810A(e)) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: i */
    public static String[] m3828i(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    /* renamed from: j */
    public static boolean m3829j(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: k */
    public static int m3830k(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    /* renamed from: l */
    public static boolean m3831l(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = str.charAt(i5);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    @javax.annotation.Nullable
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.net.InetAddress m3832m(java.lang.String r11, int r12, int r13) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = -1
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L9:
            r7 = 0
            if (r12 >= r13) goto L7a
            if (r4 != r0) goto Lf
            return r7
        Lf:
            int r8 = r12 + 2
            if (r8 > r13) goto L27
            java.lang.String r9 = "::"
            r10 = 2
            boolean r9 = r11.regionMatches(r12, r9, r3, r10)
            if (r9 == 0) goto L27
            if (r5 == r2) goto L1f
            return r7
        L1f:
            int r4 = r4 + 2
            r5 = r4
            if (r8 != r13) goto L25
            goto L7a
        L25:
            r6 = r8
            goto L4b
        L27:
            if (r4 == 0) goto L4a
            java.lang.String r8 = ":"
            r9 = 1
            boolean r8 = r11.regionMatches(r12, r8, r3, r9)
            if (r8 == 0) goto L35
            int r12 = r12 + 1
            goto L4a
        L35:
            java.lang.String r8 = "."
            boolean r12 = r11.regionMatches(r12, r8, r3, r9)
            if (r12 == 0) goto L49
            int r12 = r4 + (-2)
            boolean r11 = m3831l(r11, r6, r13, r1, r12)
            if (r11 != 0) goto L46
            return r7
        L46:
            int r4 = r4 + 2
            goto L7a
        L49:
            return r7
        L4a:
            r6 = r12
        L4b:
            r8 = r3
            r12 = r6
        L4d:
            if (r12 >= r13) goto L60
            char r9 = r11.charAt(r12)
            int r9 = m3830k(r9)
            if (r9 != r2) goto L5a
            goto L60
        L5a:
            int r8 = r8 << 4
            int r8 = r8 + r9
            int r12 = r12 + 1
            goto L4d
        L60:
            int r9 = r12 - r6
            if (r9 == 0) goto L79
            r10 = 4
            if (r9 <= r10) goto L68
            goto L79
        L68:
            int r7 = r4 + 1
            int r9 = r8 >>> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r1[r4] = r9
            int r4 = r7 + 1
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r1[r7] = r8
            goto L9
        L79:
            return r7
        L7a:
            if (r4 == r0) goto L8b
            if (r5 != r2) goto L7f
            return r7
        L7f:
            int r11 = r4 - r5
            int r12 = 16 - r11
            java.lang.System.arraycopy(r1, r5, r1, r12, r11)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r3)
        L8b:
            java.net.InetAddress r11 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L90
            return r11
        L90:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.fn0.m3832m(java.lang.String, int, int):java.net.InetAddress");
    }

    /* renamed from: n */
    public static int m3833n(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: o */
    public static int m3834o(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: p */
    public static boolean m3835p(Source source, int i, TimeUnit timeUnit) {
        try {
            return m3813D(source, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: q */
    public static boolean m3836q(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: r */
    public static String m3837r(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: s */
    public static String m3838s(rm0 rm0Var, boolean z) {
        String m8171l;
        if (rm0Var.m8171l().contains(":")) {
            m8171l = "[" + rm0Var.m8171l() + "]";
        } else {
            m8171l = rm0Var.m8171l();
        }
        if (!z && rm0Var.m8176x() == rm0.m8151d(rm0Var.m8163C())) {
            return m8171l;
        }
        return m8171l + ":" + rm0Var.m8176x();
    }

    /* renamed from: t */
    public static <T> List<T> m3839t(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    /* renamed from: u */
    public static <T> List<T> m3840u(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    /* renamed from: v */
    public static <K, V> Map<K, V> m3841v(Map<K, V> map) {
        return map.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    /* renamed from: w */
    public static int m3842w(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: x */
    public static int m3843x(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: y */
    public static String m3844y(byte[] bArr) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i2 = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        zo0 zo0Var = new zo0();
        while (i < bArr.length) {
            if (i == i2) {
                zo0Var.m10565m0(58);
                i += i4;
                if (i == 16) {
                    zo0Var.m10565m0(58);
                }
            } else {
                if (i > 0) {
                    zo0Var.m10565m0(58);
                }
                zo0Var.m10567o0(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
                i += 2;
            }
        }
        return zo0Var.m10553c0();
    }

    /* renamed from: z */
    public static String[] m3845z(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
