package cz.opentree;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.sy */
/* loaded from: classes.dex */
public final class C1889sy extends p00 {

    /* renamed from: c */
    public char f6604c;

    /* renamed from: d */
    public long f6605d;

    /* renamed from: e */
    @GuardedBy("this")
    public String f6606e;

    /* renamed from: f */
    public final C2142uy f6607f;

    /* renamed from: g */
    public final C2142uy f6608g;

    /* renamed from: h */
    public final C2142uy f6609h;

    /* renamed from: i */
    public final C2142uy f6610i;

    /* renamed from: j */
    public final C2142uy f6611j;

    /* renamed from: k */
    public final C2142uy f6612k;

    /* renamed from: l */
    public final C2142uy f6613l;

    /* renamed from: m */
    public final C2142uy f6614m;

    /* renamed from: n */
    public final C2142uy f6615n;

    public C1889sy(C2144uz c2144uz) {
        super(c2144uz);
        this.f6604c = (char) 0;
        this.f6605d = -1L;
        this.f6607f = new C2142uy(this, 6, false, false);
        this.f6608g = new C2142uy(this, 6, true, false);
        this.f6609h = new C2142uy(this, 6, false, true);
        this.f6610i = new C2142uy(this, 5, false, false);
        this.f6611j = new C2142uy(this, 5, true, false);
        this.f6612k = new C2142uy(this, 5, false, true);
        this.f6613l = new C2142uy(this, 4, false, false);
        this.f6614m = new C2142uy(this, 3, false, false);
        this.f6615n = new C2142uy(this, 2, false, false);
    }

    /* renamed from: A */
    public static String m8510A(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String m8517z = m8517z(z, obj);
        String m8517z2 = m8517z(z, obj2);
        String m8517z3 = m8517z(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(m8517z)) {
            sb.append(str2);
            sb.append(m8517z);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(m8517z2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(m8517z2);
        }
        if (!TextUtils.isEmpty(m8517z3)) {
            sb.append(str3);
            sb.append(m8517z3);
        }
        return sb.toString();
    }

    /* renamed from: G */
    public static String m8512G(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    /* renamed from: y */
    public static Object m8516y(String str) {
        if (str == null) {
            return null;
        }
        return new C2317xy(str);
    }

    /* renamed from: z */
    public static String m8517z(boolean z, Object obj) {
        String str;
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str2 = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, valueOf.length() - 1));
            long round2 = Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str2.length() + 43 + str2.length());
            sb.append(str2);
            sb.append(round);
            sb.append("...");
            sb.append(str2);
            sb.append(round2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (!(obj instanceof Throwable)) {
            if (!(obj instanceof C2317xy)) {
                return z ? "-" : String.valueOf(obj);
            }
            str = ((C2317xy) obj).f8062a;
            return str;
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
        String m8512G = m8512G(C2144uz.class.getCanonicalName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        while (true) {
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && m8512G(className).equals(m8512G)) {
                sb2.append(": ");
                sb2.append(stackTraceElement);
                break;
            }
            i++;
        }
        return sb2.toString();
    }

    /* renamed from: B */
    public final void m8518B(int i, String str) {
        Log.println(i, m8521E(), str);
    }

    /* renamed from: C */
    public final void m8519C(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && m8520D(i)) {
            m8518B(i, m8510A(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        C0813ca.m2729k(str);
        C1839rz m9100F = this.f5899a.m9100F();
        if (m9100F == null) {
            m8518B(6, "Scheduler not set. Not logging error/warn");
            return;
        }
        if (!m9100F.m7169u()) {
            m8518B(6, "Scheduler not initialized. Not logging error/warn");
            return;
        }
        if (i < 0) {
            i = 0;
        }
        if (i >= 9) {
            i = 8;
        }
        m9100F.m8281A(new RunnableC2191vy(this, i, str, obj, obj2, obj3));
    }

    /* renamed from: D */
    public final boolean m8520D(int i) {
        return Log.isLoggable(m8521E(), i);
    }

    /* renamed from: E */
    public final String m8521E() {
        String str;
        String str2;
        synchronized (this) {
            if (this.f6606e == null) {
                if (this.f5899a.m9108N() != null) {
                    str2 = this.f5899a.m9108N();
                } else {
                    m7590o().mo1480f();
                    str2 = "FA";
                }
                this.f6606e = str2;
            }
            str = this.f6606e;
        }
        return str;
    }

    /* renamed from: H */
    public final C2142uy m8522H() {
        return this.f6607f;
    }

    /* renamed from: I */
    public final C2142uy m8523I() {
        return this.f6608g;
    }

    /* renamed from: J */
    public final C2142uy m8524J() {
        return this.f6609h;
    }

    /* renamed from: K */
    public final C2142uy m8525K() {
        return this.f6610i;
    }

    /* renamed from: L */
    public final C2142uy m8526L() {
        return this.f6611j;
    }

    /* renamed from: M */
    public final C2142uy m8527M() {
        return this.f6612k;
    }

    /* renamed from: N */
    public final C2142uy m8528N() {
        return this.f6613l;
    }

    /* renamed from: O */
    public final C2142uy m8529O() {
        return this.f6614m;
    }

    /* renamed from: P */
    public final C2142uy m8530P() {
        return this.f6615n;
    }

    /* renamed from: Q */
    public final String m8531Q() {
        Pair<String, Long> m6322a = m7589n().f2559d.m6322a();
        if (m6322a == null || m6322a == C0960ez.f2553E) {
            return null;
        }
        String valueOf = String.valueOf(m6322a.second);
        String str = (String) m6322a.first;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length());
        sb.append(valueOf);
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

    @Override // cz.opentree.p00
    /* renamed from: t */
    public final boolean mo3597t() {
        return false;
    }
}
