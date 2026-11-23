package com.sonelli;

import android.app.ActivityManager;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class qb0 {

    /* renamed from: a */
    public static final nb0 f5968a = nb0.m6659c("0");

    /* renamed from: b */
    public static final nb0 f5969b = nb0.m6659c("Unity");

    /* renamed from: A */
    public static void m7643A(pb0 pb0Var, nb0 nb0Var) throws Exception {
        if (nb0Var != null) {
            pb0Var.m7299e0(6, 2);
            pb0Var.m7295a0(m7654h(nb0Var));
            pb0Var.m7281J(1, nb0Var);
        }
    }

    /* renamed from: B */
    public static void m7644B(pb0 pb0Var, String str, String str2, boolean z) throws Exception {
        nb0 m6659c = nb0.m6659c(str);
        nb0 m6659c2 = nb0.m6659c(str2);
        pb0Var.m7299e0(8, 2);
        pb0Var.m7295a0(m7659m(m6659c, m6659c2, z));
        pb0Var.m7283L(1, 3);
        pb0Var.m7281J(2, m6659c);
        pb0Var.m7281J(3, m6659c2);
        pb0Var.m7279D(4, z);
    }

    /* renamed from: C */
    public static void m7645C(pb0 pb0Var, String str, String str2, String str3) throws Exception {
        if (str == null) {
            str = "";
        }
        nb0 m6659c = nb0.m6659c(str);
        nb0 m7661o = m7661o(str2);
        nb0 m7661o2 = m7661o(str3);
        int m7260c = pb0.m7260c(1, m6659c) + 0;
        if (str2 != null) {
            m7260c += pb0.m7260c(2, m7661o);
        }
        if (str3 != null) {
            m7260c += pb0.m7260c(3, m7661o2);
        }
        pb0Var.m7299e0(6, 2);
        pb0Var.m7295a0(m7260c);
        pb0Var.m7281J(1, m6659c);
        if (str2 != null) {
            pb0Var.m7281J(2, m7661o);
        }
        if (str3 != null) {
            pb0Var.m7281J(3, m7661o2);
        }
    }

    /* renamed from: D */
    public static void m7646D(pb0 pb0Var, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) throws Exception {
        pb0Var.m7299e0(1, 2);
        pb0Var.m7295a0(m7660n(thread, stackTraceElementArr, i, z));
        pb0Var.m7281J(1, nb0.m6659c(thread.getName()));
        pb0Var.m7300f0(2, i);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            m7663q(pb0Var, 3, stackTraceElement, z);
        }
    }

    /* renamed from: a */
    public static int m7647a(nb0 nb0Var, nb0 nb0Var2) {
        int m7274w = pb0.m7274w(1, 0L) + 0 + pb0.m7274w(2, 0L) + pb0.m7260c(3, nb0Var);
        return nb0Var2 != null ? m7274w + pb0.m7260c(4, nb0Var2) : m7274w;
    }

    /* renamed from: b */
    public static int m7648b(String str, String str2) {
        int m7260c = pb0.m7260c(1, nb0.m6659c(str));
        if (str2 == null) {
            str2 = "";
        }
        return m7260c + pb0.m7260c(2, nb0.m6659c(str2));
    }

    /* renamed from: c */
    public static int m7649c(vc0 vc0Var, int i, int i2) {
        int i3 = 0;
        int m7260c = pb0.m7260c(1, nb0.m6659c(vc0Var.f7443b)) + 0;
        String str = vc0Var.f7442a;
        if (str != null) {
            m7260c += pb0.m7260c(3, nb0.m6659c(str));
        }
        for (StackTraceElement stackTraceElement : vc0Var.f7444c) {
            int m7655i = m7655i(stackTraceElement, true);
            m7260c += pb0.m7271r(4) + pb0.m7267l(m7655i) + m7655i;
        }
        vc0 vc0Var2 = vc0Var.f7445d;
        if (vc0Var2 == null) {
            return m7260c;
        }
        if (i < i2) {
            int m7649c = m7649c(vc0Var2, i + 1, i2);
            return m7260c + pb0.m7271r(6) + pb0.m7267l(m7649c) + m7649c;
        }
        while (vc0Var2 != null) {
            vc0Var2 = vc0Var2.f7445d;
            i3++;
        }
        return m7260c + pb0.m7272s(7, i3);
    }

    /* renamed from: d */
    public static int m7650d() {
        nb0 nb0Var = f5968a;
        return pb0.m7260c(1, nb0Var) + 0 + pb0.m7260c(2, nb0Var) + pb0.m7274w(3, 0L);
    }

    /* renamed from: e */
    public static int m7651e(vc0 vc0Var, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, nb0 nb0Var, nb0 nb0Var2) {
        int m7660n = m7660n(thread, stackTraceElementArr, 4, true);
        int m7271r = pb0.m7271r(1) + pb0.m7267l(m7660n) + m7660n + 0;
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int m7660n2 = m7660n(threadArr[i2], list.get(i2), 0, false);
            m7271r += pb0.m7271r(1) + pb0.m7267l(m7660n2) + m7660n2;
        }
        int m7649c = m7649c(vc0Var, 1, i);
        int m7271r2 = m7271r + pb0.m7271r(2) + pb0.m7267l(m7649c) + m7649c;
        int m7650d = m7650d();
        int m7271r3 = m7271r2 + pb0.m7271r(3) + pb0.m7267l(m7650d) + m7650d;
        int m7647a = m7647a(nb0Var, nb0Var2);
        return m7271r3 + pb0.m7271r(3) + pb0.m7267l(m7647a) + m7647a;
    }

    /* renamed from: f */
    public static int m7652f(vc0 vc0Var, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, nb0 nb0Var, nb0 nb0Var2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int m7651e = m7651e(vc0Var, thread, stackTraceElementArr, threadArr, list, i, nb0Var, nb0Var2);
        int m7271r = pb0.m7271r(1) + pb0.m7267l(m7651e) + m7651e + 0;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                int m7648b = m7648b(entry.getKey(), entry.getValue());
                m7271r += pb0.m7271r(2) + pb0.m7267l(m7648b) + m7648b;
            }
        }
        if (runningAppProcessInfo != null) {
            m7271r += pb0.m7258a(3, runningAppProcessInfo.importance != 100);
        }
        return m7271r + pb0.m7272s(4, i2);
    }

    /* renamed from: g */
    public static int m7653g(Float f, int i, boolean z, int i2, long j, long j2) {
        return (f != null ? 0 + pb0.m7264i(1, f.floatValue()) : 0) + pb0.m7269p(2, i) + pb0.m7258a(3, z) + pb0.m7272s(4, i2) + pb0.m7274w(5, j) + pb0.m7274w(6, j2);
    }

    /* renamed from: h */
    public static int m7654h(nb0 nb0Var) {
        return pb0.m7260c(1, nb0Var);
    }

    /* renamed from: i */
    public static int m7655i(StackTraceElement stackTraceElement, boolean z) {
        int m7274w = (stackTraceElement.isNativeMethod() ? pb0.m7274w(1, Math.max(stackTraceElement.getLineNumber(), 0)) : pb0.m7274w(1, 0L)) + 0 + pb0.m7260c(2, nb0.m6659c(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            m7274w += pb0.m7260c(3, nb0.m6659c(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            m7274w += pb0.m7274w(4, stackTraceElement.getLineNumber());
        }
        return m7274w + pb0.m7272s(5, z ? 2 : 0);
    }

    /* renamed from: j */
    public static int m7656j(nb0 nb0Var, nb0 nb0Var2, nb0 nb0Var3, nb0 nb0Var4, int i, nb0 nb0Var5) {
        int m7260c = pb0.m7260c(1, nb0Var) + 0 + pb0.m7260c(2, nb0Var2) + pb0.m7260c(3, nb0Var3) + pb0.m7260c(6, nb0Var4);
        if (nb0Var5 != null) {
            m7260c = m7260c + pb0.m7260c(8, f5969b) + pb0.m7260c(9, nb0Var5);
        }
        return m7260c + pb0.m7262f(10, i);
    }

    /* renamed from: k */
    public static int m7657k(int i, nb0 nb0Var, int i2, long j, long j2, boolean z, int i3, nb0 nb0Var2, nb0 nb0Var3) {
        return pb0.m7262f(3, i) + 0 + (nb0Var == null ? 0 : pb0.m7260c(4, nb0Var)) + pb0.m7272s(5, i2) + pb0.m7274w(6, j) + pb0.m7274w(7, j2) + pb0.m7258a(10, z) + pb0.m7272s(12, i3) + (nb0Var2 == null ? 0 : pb0.m7260c(13, nb0Var2)) + (nb0Var3 != null ? pb0.m7260c(14, nb0Var3) : 0);
    }

    /* renamed from: l */
    public static int m7658l(long j, String str, vc0 vc0Var, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2, nb0 nb0Var, nb0 nb0Var2, Float f, int i3, boolean z, long j2, long j3, nb0 nb0Var3) {
        int m7274w = pb0.m7274w(1, j) + 0 + pb0.m7260c(2, nb0.m6659c(str));
        int m7652f = m7652f(vc0Var, thread, stackTraceElementArr, threadArr, list, i, nb0Var, nb0Var2, map, runningAppProcessInfo, i2);
        int m7271r = m7274w + pb0.m7271r(3) + pb0.m7267l(m7652f) + m7652f;
        int m7653g = m7653g(f, i3, z, i2, j2, j3);
        int m7271r2 = m7271r + pb0.m7271r(5) + pb0.m7267l(m7653g) + m7653g;
        if (nb0Var3 == null) {
            return m7271r2;
        }
        int m7654h = m7654h(nb0Var3);
        return m7271r2 + pb0.m7271r(6) + pb0.m7267l(m7654h) + m7654h;
    }

    /* renamed from: m */
    public static int m7659m(nb0 nb0Var, nb0 nb0Var2, boolean z) {
        return pb0.m7262f(1, 3) + 0 + pb0.m7260c(2, nb0Var) + pb0.m7260c(3, nb0Var2) + pb0.m7258a(4, z);
    }

    /* renamed from: n */
    public static int m7660n(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int m7260c = pb0.m7260c(1, nb0.m6659c(thread.getName())) + pb0.m7272s(2, i);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            int m7655i = m7655i(stackTraceElement, z);
            m7260c += pb0.m7271r(3) + pb0.m7267l(m7655i) + m7655i;
        }
        return m7260c;
    }

    /* renamed from: o */
    public static nb0 m7661o(String str) {
        if (str == null) {
            return null;
        }
        return nb0.m6659c(str);
    }

    /* renamed from: p */
    public static void m7662p(pb0 pb0Var, String str, String str2, long j) throws Exception {
        pb0Var.m7281J(1, nb0.m6659c(str2));
        pb0Var.m7281J(2, nb0.m6659c(str));
        pb0Var.m7302h0(3, j);
    }

    /* renamed from: q */
    public static void m7663q(pb0 pb0Var, int i, StackTraceElement stackTraceElement, boolean z) throws Exception {
        pb0Var.m7299e0(i, 2);
        pb0Var.m7295a0(m7655i(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            pb0Var.m7302h0(1, Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            pb0Var.m7302h0(1, 0L);
        }
        pb0Var.m7281J(2, nb0.m6659c(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            pb0Var.m7281J(3, nb0.m6659c(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            pb0Var.m7302h0(4, stackTraceElement.getLineNumber());
        }
        pb0Var.m7300f0(5, z ? 4 : 0);
    }

    /* renamed from: r */
    public static void m7664r(pb0 pb0Var, String str, String str2, String str3, String str4, int i, String str5) throws Exception {
        nb0 m6659c = nb0.m6659c(str);
        nb0 m6659c2 = nb0.m6659c(str2);
        nb0 m6659c3 = nb0.m6659c(str3);
        nb0 m6659c4 = nb0.m6659c(str4);
        nb0 m6659c5 = str5 != null ? nb0.m6659c(str5) : null;
        pb0Var.m7299e0(7, 2);
        pb0Var.m7295a0(m7656j(m6659c, m6659c2, m6659c3, m6659c4, i, m6659c5));
        pb0Var.m7281J(1, m6659c);
        pb0Var.m7281J(2, m6659c2);
        pb0Var.m7281J(3, m6659c3);
        pb0Var.m7281J(6, m6659c4);
        if (m6659c5 != null) {
            pb0Var.m7281J(8, f5969b);
            pb0Var.m7281J(9, m6659c5);
        }
        pb0Var.m7283L(10, i);
    }

    /* renamed from: s */
    public static void m7665s(pb0 pb0Var, String str) throws Exception {
        nb0 m6659c = nb0.m6659c(str);
        pb0Var.m7299e0(7, 2);
        int m7260c = pb0.m7260c(2, m6659c);
        pb0Var.m7295a0(pb0.m7271r(5) + pb0.m7267l(m7260c) + m7260c);
        pb0Var.m7299e0(5, 2);
        pb0Var.m7295a0(m7260c);
        pb0Var.m7281J(2, m6659c);
    }

    /* renamed from: t */
    public static void m7666t(pb0 pb0Var, int i, String str, int i2, long j, long j2, boolean z, int i3, String str2, String str3) throws Exception {
        nb0 m7661o = m7661o(str);
        nb0 m7661o2 = m7661o(str3);
        nb0 m7661o3 = m7661o(str2);
        pb0Var.m7299e0(9, 2);
        pb0Var.m7295a0(m7657k(i, m7661o, i2, j, j2, z, i3, m7661o3, m7661o2));
        pb0Var.m7283L(3, i);
        pb0Var.m7281J(4, m7661o);
        pb0Var.m7300f0(5, i2);
        pb0Var.m7302h0(6, j);
        pb0Var.m7302h0(7, j2);
        pb0Var.m7279D(10, z);
        pb0Var.m7300f0(12, i3);
        if (m7661o3 != null) {
            pb0Var.m7281J(13, m7661o3);
        }
        if (m7661o2 != null) {
            pb0Var.m7281J(14, m7661o2);
        }
    }

    /* renamed from: u */
    public static void m7667u(pb0 pb0Var, long j, String str, vc0 vc0Var, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, byte[] bArr, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2, String str2, String str3, Float f, int i3, boolean z, long j2, long j3) throws Exception {
        nb0 m6659c = nb0.m6659c(str2);
        nb0 nb0Var = null;
        nb0 m6659c2 = str3 == null ? null : nb0.m6659c(str3.replace("-", ""));
        if (bArr != null) {
            nb0Var = nb0.m6657a(bArr);
        } else {
            m80.m6375f().m6377b("No log data to include with this event.");
        }
        nb0 nb0Var2 = nb0Var;
        pb0Var.m7299e0(10, 2);
        pb0Var.m7295a0(m7658l(j, str, vc0Var, thread, stackTraceElementArr, threadArr, list, i, map, runningAppProcessInfo, i2, m6659c, m6659c2, f, i3, z, j2, j3, nb0Var2));
        pb0Var.m7302h0(1, j);
        pb0Var.m7281J(2, nb0.m6659c(str));
        m7668v(pb0Var, vc0Var, thread, stackTraceElementArr, threadArr, list, i, m6659c, m6659c2, map, runningAppProcessInfo, i2);
        m7672z(pb0Var, f, i3, z, i2, j2, j3);
        m7643A(pb0Var, nb0Var2);
    }

    /* renamed from: v */
    public static void m7668v(pb0 pb0Var, vc0 vc0Var, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, nb0 nb0Var, nb0 nb0Var2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) throws Exception {
        pb0Var.m7299e0(3, 2);
        pb0Var.m7295a0(m7652f(vc0Var, thread, stackTraceElementArr, threadArr, list, i, nb0Var, nb0Var2, map, runningAppProcessInfo, i2));
        m7670x(pb0Var, vc0Var, thread, stackTraceElementArr, threadArr, list, i, nb0Var, nb0Var2);
        if (map != null && !map.isEmpty()) {
            m7669w(pb0Var, map);
        }
        if (runningAppProcessInfo != null) {
            pb0Var.m7279D(3, runningAppProcessInfo.importance != 100);
        }
        pb0Var.m7300f0(4, i2);
    }

    /* renamed from: w */
    public static void m7669w(pb0 pb0Var, Map<String, String> map) throws Exception {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            pb0Var.m7299e0(2, 2);
            pb0Var.m7295a0(m7648b(entry.getKey(), entry.getValue()));
            pb0Var.m7281J(1, nb0.m6659c(entry.getKey()));
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            pb0Var.m7281J(2, nb0.m6659c(value));
        }
    }

    /* renamed from: x */
    public static void m7670x(pb0 pb0Var, vc0 vc0Var, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, nb0 nb0Var, nb0 nb0Var2) throws Exception {
        pb0Var.m7299e0(1, 2);
        pb0Var.m7295a0(m7651e(vc0Var, thread, stackTraceElementArr, threadArr, list, i, nb0Var, nb0Var2));
        m7646D(pb0Var, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            m7646D(pb0Var, threadArr[i2], list.get(i2), 0, false);
        }
        m7671y(pb0Var, vc0Var, 1, i, 2);
        pb0Var.m7299e0(3, 2);
        pb0Var.m7295a0(m7650d());
        nb0 nb0Var3 = f5968a;
        pb0Var.m7281J(1, nb0Var3);
        pb0Var.m7281J(2, nb0Var3);
        pb0Var.m7302h0(3, 0L);
        pb0Var.m7299e0(4, 2);
        pb0Var.m7295a0(m7647a(nb0Var, nb0Var2));
        pb0Var.m7302h0(1, 0L);
        pb0Var.m7302h0(2, 0L);
        pb0Var.m7281J(3, nb0Var);
        if (nb0Var2 != null) {
            pb0Var.m7281J(4, nb0Var2);
        }
    }

    /* renamed from: y */
    public static void m7671y(pb0 pb0Var, vc0 vc0Var, int i, int i2, int i3) throws Exception {
        pb0Var.m7299e0(i3, 2);
        pb0Var.m7295a0(m7649c(vc0Var, 1, i2));
        pb0Var.m7281J(1, nb0.m6659c(vc0Var.f7443b));
        String str = vc0Var.f7442a;
        if (str != null) {
            pb0Var.m7281J(3, nb0.m6659c(str));
        }
        int i4 = 0;
        for (StackTraceElement stackTraceElement : vc0Var.f7444c) {
            m7663q(pb0Var, 4, stackTraceElement, true);
        }
        vc0 vc0Var2 = vc0Var.f7445d;
        if (vc0Var2 != null) {
            if (i < i2) {
                m7671y(pb0Var, vc0Var2, i + 1, i2, 6);
                return;
            }
            while (vc0Var2 != null) {
                vc0Var2 = vc0Var2.f7445d;
                i4++;
            }
            pb0Var.m7300f0(7, i4);
        }
    }

    /* renamed from: z */
    public static void m7672z(pb0 pb0Var, Float f, int i, boolean z, int i2, long j, long j2) throws Exception {
        pb0Var.m7299e0(5, 2);
        pb0Var.m7295a0(m7653g(f, i, z, i2, j, j2));
        if (f != null) {
            pb0Var.m7285P(1, f.floatValue());
        }
        pb0Var.m7297c0(2, i);
        pb0Var.m7279D(3, z);
        pb0Var.m7300f0(4, i2);
        pb0Var.m7302h0(5, j);
        pb0Var.m7302h0(6, j2);
    }
}
