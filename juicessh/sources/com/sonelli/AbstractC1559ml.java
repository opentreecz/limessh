package com.sonelli;

import android.annotation.SuppressLint;
import android.content.Context;
import com.google.android.gms.internal.measurement.zzde;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.ml */
/* loaded from: classes.dex */
public abstract class AbstractC1559ml<T> {

    /* renamed from: g */
    @SuppressLint({"StaticFieldLeak"})
    public static Context f5086g;

    /* renamed from: h */
    public static zzde<AbstractC2358yl<C1165il>> f5087h;

    /* renamed from: a */
    public final C1875sl f5089a;

    /* renamed from: b */
    public final String f5090b;

    /* renamed from: c */
    public final T f5091c;

    /* renamed from: d */
    public volatile int f5092d;

    /* renamed from: e */
    public volatile T f5093e;

    /* renamed from: f */
    public static final Object f5085f = new Object();

    /* renamed from: i */
    public static final AtomicInteger f5088i = new AtomicInteger();

    public AbstractC1559ml(C1875sl c1875sl, String str, T t, boolean z) {
        this.f5092d = -1;
        if (c1875sl.f6500a == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.f5089a = c1875sl;
        this.f5090b = str;
        this.f5091c = t;
    }

    public /* synthetic */ AbstractC1559ml(C1875sl c1875sl, String str, Object obj, boolean z, C1662ol c1662ol) {
        this(c1875sl, str, obj, z);
    }

    /* renamed from: g */
    public static void m6449g() {
        f5088i.incrementAndGet();
    }

    /* renamed from: h */
    public static void m6450h(Context context) {
        synchronized (f5085f) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (f5086g != context) {
                C0782bl.m2552d();
                C2176vl.m9300b();
                C1114hl.m4483b();
                f5088i.incrementAndGet();
                f5086g = context;
                f5087h = C0783bm.m2558a(C1723pl.f5714O);
            }
        }
    }

    /* renamed from: i */
    public static AbstractC1559ml<Double> m6451i(C1875sl c1875sl, String str, double d, boolean z) {
        return new C1774ql(c1875sl, str, Double.valueOf(d), false);
    }

    /* renamed from: j */
    public static AbstractC1559ml<Long> m6452j(C1875sl c1875sl, String str, long j, boolean z) {
        return new C1662ol(c1875sl, str, Long.valueOf(j), false);
    }

    /* renamed from: k */
    public static AbstractC1559ml<String> m6453k(C1875sl c1875sl, String str, String str2, boolean z) {
        return new C1938tl(c1875sl, str, str2, false);
    }

    /* renamed from: l */
    public static AbstractC1559ml<Boolean> m6454l(C1875sl c1875sl, String str, boolean z, boolean z2) {
        return new C1823rl(c1875sl, str, Boolean.valueOf(z), false);
    }

    /* renamed from: e */
    public abstract T mo6456e(Object obj);

    /* renamed from: f */
    public final String m6457f(String str) {
        if (str != null && str.isEmpty()) {
            return this.f5090b;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.f5090b);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* renamed from: m */
    public final String m6458m() {
        return m6457f(this.f5089a.f6502c);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c3 A[Catch: all -> 0x00ed, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0021, B:16:0x0033, B:18:0x0039, B:20:0x0041, B:22:0x005a, B:24:0x0064, B:27:0x00b5, B:29:0x00c3, B:31:0x00d7, B:32:0x00da, B:33:0x00de, B:34:0x0096, B:36:0x00aa, B:39:0x00b3, B:43:0x0052, B:44:0x0069, B:46:0x0072, B:48:0x0084, B:49:0x008f, B:50:0x0089, B:52:0x00e3, B:53:0x00ea, B:55:0x00eb), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0096 A[Catch: all -> 0x00ed, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0021, B:16:0x0033, B:18:0x0039, B:20:0x0041, B:22:0x005a, B:24:0x0064, B:27:0x00b5, B:29:0x00c3, B:31:0x00d7, B:32:0x00da, B:33:0x00de, B:34:0x0096, B:36:0x00aa, B:39:0x00b3, B:43:0x0052, B:44:0x0069, B:46:0x0072, B:48:0x0084, B:49:0x008f, B:50:0x0089, B:52:0x00e3, B:53:0x00ea, B:55:0x00eb), top: B:4:0x000b }] */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T m6459n() {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.AbstractC1559ml.m6459n():java.lang.Object");
    }
}
