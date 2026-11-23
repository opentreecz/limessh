package com.sonelli;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.sonelli.oa0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class a90 {

    /* renamed from: e */
    public static final String f1350e = String.format(Locale.US, "Crashlytics Android SDK/%s", "17.0.0");

    /* renamed from: f */
    public static final Map<String, Integer> f1351f;

    /* renamed from: a */
    public final Context f1352a;

    /* renamed from: b */
    public final h90 f1353b;

    /* renamed from: c */
    public final q80 f1354c;

    /* renamed from: d */
    public final StackTraceTrimmingStrategy f1355d;

    static {
        HashMap hashMap = new HashMap();
        f1351f = hashMap;
        hashMap.put("armeabi", 5);
        hashMap.put("armeabi-v7a", 6);
        hashMap.put("arm64-v8a", 9);
        hashMap.put("x86", 0);
        hashMap.put("x86_64", 1);
    }

    public a90(Context context, h90 h90Var, q80 q80Var, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        this.f1352a = context;
        this.f1353b = h90Var;
        this.f1354c = q80Var;
        this.f1355d = stackTraceTrimmingStrategy;
    }

    /* renamed from: d */
    public static int m2007d() {
        Integer num;
        String str = Build.CPU_ABI;
        if (TextUtils.isEmpty(str) || (num = f1351f.get(str.toLowerCase(Locale.US))) == null) {
            return 7;
        }
        return num.intValue();
    }

    /* renamed from: a */
    public final oa0.AbstractC1642a m2008a() {
        oa0.AbstractC1642a m6913b = oa0.m6913b();
        m6913b.mo6934h("17.0.0");
        m6913b.mo6930d(this.f1354c.f5959a);
        m6913b.mo6931e(this.f1353b.mo1740a());
        m6913b.mo6928b(this.f1354c.f5963e);
        m6913b.mo6929c(this.f1354c.f5964f);
        m6913b.mo6933g(4);
        return m6913b;
    }

    /* renamed from: b */
    public oa0.AbstractC1645d.d m2009b(Throwable th, Thread thread, String str, long j, int i, int i2, boolean z) {
        int i3 = this.f1352a.getResources().getConfiguration().orientation;
        vc0 vc0Var = new vc0(th, this.f1355d);
        oa0.AbstractC1645d.d.b m6995a = oa0.AbstractC1645d.d.m6995a();
        m6995a.mo2746f(str);
        m6995a.mo2745e(j);
        m6995a.mo2742b(m2013g(i3, vc0Var, thread, i, i2, z));
        m6995a.mo2743c(m2014h(i3));
        return m6995a.mo2741a();
    }

    /* renamed from: c */
    public oa0 m2010c(String str, long j) {
        oa0.AbstractC1642a m2008a = m2008a();
        m2008a.mo6935i(m2021o(str, j));
        return m2008a.mo6927a();
    }

    /* renamed from: e */
    public final oa0.AbstractC1645d.d.a.b.AbstractC2503a m2011e() {
        oa0.AbstractC1645d.d.a.b.AbstractC2503a.AbstractC2504a m6998a = oa0.AbstractC1645d.d.a.b.AbstractC2503a.m6998a();
        m6998a.mo3702b(0L);
        m6998a.mo3704d(0L);
        m6998a.mo3703c(this.f1354c.f5962d);
        m6998a.mo3705e(this.f1354c.f5960b);
        return m6998a.mo3701a();
    }

    /* renamed from: f */
    public final pa0<oa0.AbstractC1645d.d.a.b.AbstractC2503a> m2012f() {
        return pa0.m7256f(m2011e());
    }

    /* renamed from: g */
    public final oa0.AbstractC1645d.d.a m2013g(int i, vc0 vc0Var, Thread thread, int i2, int i3, boolean z) {
        Boolean bool;
        ActivityManager.RunningAppProcessInfo m9432k = w80.m9432k(this.f1354c.f5962d, this.f1352a);
        if (m9432k != null) {
            bool = Boolean.valueOf(m9432k.importance != 100);
        } else {
            bool = null;
        }
        oa0.AbstractC1645d.d.a.AbstractC2502a m6996a = oa0.AbstractC1645d.d.a.m6996a();
        m6996a.mo3177b(bool);
        m6996a.mo3180e(i);
        m6996a.mo3179d(m2017k(vc0Var, thread, i2, i3, z));
        return m6996a.mo3176a();
    }

    /* renamed from: h */
    public final oa0.AbstractC1645d.d.c m2014h(int i) {
        t80 m8602a = t80.m8602a(this.f1352a);
        Float m8605b = m8602a.m8605b();
        Double valueOf = m8605b != null ? Double.valueOf(m8605b.doubleValue()) : null;
        int m8606c = m8602a.m8606c();
        boolean m9438q = w80.m9438q(this.f1352a);
        long m9443v = w80.m9443v() - w80.m9422a(this.f1352a);
        long m9423b = w80.m9423b(Environment.getDataDirectory().getPath());
        oa0.AbstractC1645d.d.c.a m7005a = oa0.AbstractC1645d.d.c.m7005a();
        m7005a.mo5859b(valueOf);
        m7005a.mo5860c(m8606c);
        m7005a.mo5863f(m9438q);
        m7005a.mo5862e(i);
        m7005a.mo5864g(m9443v);
        m7005a.mo5861d(m9423b);
        return m7005a.mo5858a();
    }

    /* renamed from: i */
    public final oa0.AbstractC1645d.d.a.b.c m2015i(vc0 vc0Var, int i, int i2) {
        return m2016j(vc0Var, i, i2, 0);
    }

    /* renamed from: j */
    public final oa0.AbstractC1645d.d.a.b.c m2016j(vc0 vc0Var, int i, int i2, int i3) {
        String str = vc0Var.f7443b;
        String str2 = vc0Var.f7442a;
        StackTraceElement[] stackTraceElementArr = vc0Var.f7444c;
        int i4 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        vc0 vc0Var2 = vc0Var.f7445d;
        if (i3 >= i2) {
            vc0 vc0Var3 = vc0Var2;
            while (vc0Var3 != null) {
                vc0Var3 = vc0Var3.f7445d;
                i4++;
            }
        }
        oa0.AbstractC1645d.d.a.b.c.AbstractC2506a m7001a = oa0.AbstractC1645d.d.a.b.c.m7001a();
        m7001a.mo4109f(str);
        m7001a.mo4108e(str2);
        m7001a.mo4106c(pa0.m7255e(m2019m(stackTraceElementArr, i)));
        m7001a.mo4107d(i4);
        if (vc0Var2 != null && i4 == 0) {
            m7001a.mo4105b(m2016j(vc0Var2, i, i2, i3 + 1));
        }
        return m7001a.mo4104a();
    }

    /* renamed from: k */
    public final oa0.AbstractC1645d.d.a.b m2017k(vc0 vc0Var, Thread thread, int i, int i2, boolean z) {
        oa0.AbstractC1645d.d.a.b.AbstractC2505b m6997a = oa0.AbstractC1645d.d.a.b.m6997a();
        m6997a.mo3469e(m2027u(vc0Var, thread, i, z));
        m6997a.mo3467c(m2015i(vc0Var, i, i2));
        m6997a.mo3468d(m2024r());
        m6997a.mo3466b(m2012f());
        return m6997a.mo3465a();
    }

    /* renamed from: l */
    public final oa0.AbstractC1645d.d.a.b.e.AbstractC2510b m2018l(StackTraceElement stackTraceElement, oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.AbstractC2511a abstractC2511a) {
        long j = 0;
        long max = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            j = stackTraceElement.getLineNumber();
        }
        abstractC2511a.mo5097e(max);
        abstractC2511a.mo5098f(str);
        abstractC2511a.mo5094b(fileName);
        abstractC2511a.mo5096d(j);
        return abstractC2511a.mo5093a();
    }

    /* renamed from: m */
    public final pa0<oa0.AbstractC1645d.d.a.b.e.AbstractC2510b> m2019m(StackTraceElement[] stackTraceElementArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.AbstractC2511a m7004a = oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.m7004a();
            m7004a.mo5095c(i);
            arrayList.add(m2018l(stackTraceElement, m7004a));
        }
        return pa0.m7255e(arrayList);
    }

    /* renamed from: n */
    public final oa0.AbstractC1645d.a m2020n() {
        oa0.AbstractC1645d.a.AbstractC2501a m6970a = oa0.AbstractC1645d.a.m6970a();
        m6970a.mo6978c(this.f1353b.m4389d());
        m6970a.mo6980e(this.f1354c.f5963e);
        m6970a.mo6977b(this.f1354c.f5964f);
        m6970a.mo6979d(this.f1353b.mo1740a());
        return m6970a.mo6976a();
    }

    /* renamed from: o */
    public final oa0.AbstractC1645d m2021o(String str, long j) {
        oa0.AbstractC1645d.b m6954a = oa0.AbstractC1645d.m6954a();
        m6954a.mo6992l(j);
        m6954a.mo6989i(str);
        m6954a.mo6987g(f1350e);
        m6954a.mo6982b(m2020n());
        m6954a.mo6991k(m2023q());
        m6954a.mo6984d(m2022p());
        m6954a.mo6988h(3);
        return m6954a.mo6981a();
    }

    /* renamed from: p */
    public final oa0.AbstractC1645d.c m2022p() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int m2007d = m2007d();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long m9443v = w80.m9443v();
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        boolean m9415B = w80.m9415B(this.f1352a);
        int m9435n = w80.m9435n(this.f1352a);
        String str = Build.MANUFACTURER;
        String str2 = Build.PRODUCT;
        oa0.AbstractC1645d.c.a m6994a = oa0.AbstractC1645d.c.m6994a();
        m6994a.mo2418b(m2007d);
        m6994a.mo2422f(Build.MODEL);
        m6994a.mo2419c(availableProcessors);
        m6994a.mo2424h(m9443v);
        m6994a.mo2420d(blockCount);
        m6994a.mo2425i(m9415B);
        m6994a.mo2426j(m9435n);
        m6994a.mo2421e(str);
        m6994a.mo2423g(str2);
        return m6994a.mo2417a();
    }

    /* renamed from: q */
    public final oa0.AbstractC1645d.e m2023q() {
        oa0.AbstractC1645d.e.a m7007a = oa0.AbstractC1645d.e.m7007a();
        m7007a.mo6393d(3);
        m7007a.mo6394e(Build.VERSION.RELEASE);
        m7007a.mo6391b(Build.VERSION.CODENAME);
        m7007a.mo6392c(w80.m9417D(this.f1352a));
        return m7007a.mo6390a();
    }

    /* renamed from: r */
    public final oa0.AbstractC1645d.d.a.b.AbstractC2507d m2024r() {
        oa0.AbstractC1645d.d.a.b.AbstractC2507d.AbstractC2508a m7002a = oa0.AbstractC1645d.d.a.b.AbstractC2507d.m7002a();
        m7002a.mo4427d("0");
        m7002a.mo4426c("0");
        m7002a.mo4425b(0L);
        return m7002a.mo4424a();
    }

    /* renamed from: s */
    public final oa0.AbstractC1645d.d.a.b.e m2025s(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return m2026t(thread, stackTraceElementArr, 0);
    }

    /* renamed from: t */
    public final oa0.AbstractC1645d.d.a.b.e m2026t(Thread thread, StackTraceElement[] stackTraceElementArr, int i) {
        oa0.AbstractC1645d.d.a.b.e.AbstractC2509a m7003a = oa0.AbstractC1645d.d.a.b.e.m7003a();
        m7003a.mo4738d(thread.getName());
        m7003a.mo4737c(i);
        m7003a.mo4736b(pa0.m7255e(m2019m(stackTraceElementArr, i)));
        return m7003a.mo4735a();
    }

    /* renamed from: u */
    public final pa0<oa0.AbstractC1645d.d.a.b.e> m2027u(vc0 vc0Var, Thread thread, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(m2026t(thread, vc0Var.f7444c, i));
        if (z) {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                if (!key.equals(thread)) {
                    arrayList.add(m2025s(key, this.f1355d.mo1848a(entry.getValue())));
                }
            }
        }
        return pa0.m7255e(arrayList);
    }
}
