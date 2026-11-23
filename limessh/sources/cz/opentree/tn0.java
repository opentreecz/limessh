package cz.opentree;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.List;
import okhttp3.CookieJar;

/* compiled from: HttpHeaders.java */
/* loaded from: classes.dex */
public final class tn0 {
    static {
        ap0.m2233o("\"\\");
        ap0.m2233o("\t ,=");
    }

    /* renamed from: a */
    public static long m8782a(qm0 qm0Var) {
        return m8789h(qm0Var.m7749c("Content-Length"));
    }

    /* renamed from: b */
    public static long m8783b(zm0 zm0Var) {
        return m8782a(zm0Var.m10512l());
    }

    /* renamed from: c */
    public static boolean m8784c(zm0 zm0Var) {
        if (zm0Var.m10516y().m9819f().equals("HEAD")) {
            return false;
        }
        int m10508c = zm0Var.m10508c();
        return (((m10508c >= 100 && m10508c < 200) || m10508c == 204 || m10508c == 304) && m8783b(zm0Var) == -1 && !"chunked".equalsIgnoreCase(zm0Var.m10510f("Transfer-Encoding"))) ? false : true;
    }

    /* renamed from: d */
    public static int m8785d(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    /* renamed from: e */
    public static void m8786e(CookieJar cookieJar, rm0 rm0Var, qm0 qm0Var) {
        if (cookieJar == CookieJar.f8652a) {
            return;
        }
        List<nm0> m6744f = nm0.m6744f(rm0Var, qm0Var);
        if (m6744f.isEmpty()) {
            return;
        }
        cookieJar.mo10696a(rm0Var, m6744f);
    }

    /* renamed from: f */
    public static int m8787f(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    /* renamed from: g */
    public static int m8788g(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }

    /* renamed from: h */
    public static long m8789h(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }
}
