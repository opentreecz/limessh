package cz.opentree;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.x9 */
/* loaded from: classes.dex */
public final class C2267x9 {

    /* renamed from: a */
    public final String f7905a;

    /* renamed from: b */
    public final String f7906b;

    public C2267x9(String str) {
        this(str, null);
    }

    public C2267x9(String str, String str2) {
        C0813ca.m2730l(str, "log tag cannot be null");
        C0813ca.m2721c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f7905a = str;
        if (str2 == null || str2.length() <= 0) {
            this.f7906b = null;
        } else {
            this.f7906b = str2;
        }
    }

    /* renamed from: a */
    public final boolean m9741a(int i) {
        return Log.isLoggable(this.f7905a, i);
    }

    /* renamed from: b */
    public final void m9742b(String str, String str2) {
        if (m9741a(3)) {
            Log.d(str, m9746f(str2));
        }
    }

    /* renamed from: c */
    public final void m9743c(String str, String str2, Throwable th) {
        if (m9741a(6)) {
            Log.e(str, m9746f(str2), th);
        }
    }

    /* renamed from: d */
    public final void m9744d(String str, String str2) {
        if (m9741a(2)) {
            Log.v(str, m9746f(str2));
        }
    }

    /* renamed from: e */
    public final void m9745e(String str, String str2) {
        if (m9741a(5)) {
            Log.w(str, m9746f(str2));
        }
    }

    /* renamed from: f */
    public final String m9746f(String str) {
        String str2 = this.f7906b;
        return str2 == null ? str : str2.concat(str);
    }
}
