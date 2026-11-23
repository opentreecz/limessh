package com.sonelli;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import androidx.core.os.EnvironmentCompat;
import com.sonelli.juicessh.activities.BookclubActivity;
import com.sonelli.juicessh.activities.ChangelogActivity;
import com.sonelli.juicessh.models.Config;
import com.sonelli.juicessh.models.User;
import com.sonelli.util.Session;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.math.BigInteger;
import java.security.SecureRandom;

/* compiled from: Platform.java */
/* loaded from: classes.dex */
public abstract class kj0 {

    /* renamed from: a */
    public static final int f4580a = Build.VERSION.SDK_INT;

    /* compiled from: Platform.java */
    /* renamed from: com.sonelli.kj0$a */
    /* loaded from: classes.dex */
    public static class C1460a extends Exception {
    }

    /* renamed from: G */
    public static void m5916G(Context context) {
        User.m5525s(context);
        if (User.m5529y(context).booleanValue()) {
            User.m5521D(new BigInteger(KeycodeConstants.KEYCODE_MEDIA_RECORD, new SecureRandom()).toString(32), true, context);
        }
        int m10497f = Session.m9046g().m9049h().m10497f(context);
        try {
            int i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            if (m10497f >= i) {
                return;
            }
            Config.m5456b(context);
            if (m10497f < 26) {
                Session.m9045e(context);
            }
            if (m10497f < 55) {
                Config.m5462h("pinlock:style", String.valueOf(1), context);
            }
            if (m10497f < 93 && Config.m5460f(context, "terminal:theme") == 0) {
                Config.m5462h("terminal:theme", Integer.toString(2), context);
            }
            if (m10497f < 95) {
                PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("plugins:new", true).apply();
            }
            if (m10497f < 112) {
                PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("bookclub:new", true).apply();
            }
            Session.m9046g().m9049h().m10503l(context, i);
            Session.m9046g().m9049h().m10503l(context, i);
            if (m10497f > 0) {
                Intent intent = new Intent(context, (Class<?>) ChangelogActivity.class);
                intent.putExtra("previous_version", m10497f);
                context.startActivity(intent);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static kj0 m5917a() {
        return System.getProperty("os.name").equals("qnx") ? new jj0() : new ij0();
    }

    /* renamed from: b */
    public static int m5918b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 128).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            gj0.m4142c("Platforms/Platform", "Could not determin application version");
            return -1;
        }
    }

    /* renamed from: c */
    public static String m5919c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 128).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            gj0.m4142c("Platforms/Platform", "Could not determin application version");
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    /* renamed from: d */
    public static String m5920d(Context context) {
        return m5919c(context) + " (" + m5918b(context) + ")";
    }

    /* renamed from: A */
    public boolean m5921A() {
        return true;
    }

    /* renamed from: B */
    public boolean m5922B() {
        return true;
    }

    /* renamed from: C */
    public boolean m5923C() {
        return true;
    }

    /* renamed from: D */
    public boolean m5924D() {
        return true;
    }

    /* renamed from: E */
    public boolean m5925E() {
        return true;
    }

    /* renamed from: F */
    public boolean m5926F() {
        return true;
    }

    /* renamed from: e */
    public boolean m5927e(Context context) {
        return BookclubActivity.m5215m(context).m9579o();
    }

    /* renamed from: f */
    public boolean mo5131f() {
        return true;
    }

    /* renamed from: g */
    public boolean m5928g() {
        return true;
    }

    /* renamed from: h */
    public boolean mo5132h() {
        return false;
    }

    /* renamed from: i */
    public boolean m5929i() {
        return true;
    }

    /* renamed from: j */
    public boolean m5930j() {
        return false;
    }

    /* renamed from: k */
    public boolean m5931k() {
        return true;
    }

    /* renamed from: l */
    public boolean mo5133l() {
        return true;
    }

    /* renamed from: m */
    public boolean m5932m() {
        return true;
    }

    /* renamed from: n */
    public boolean m5933n() {
        return false;
    }

    /* renamed from: o */
    public boolean mo5134o() {
        return true;
    }

    /* renamed from: p */
    public boolean m5934p() {
        return true;
    }

    /* renamed from: q */
    public boolean m5935q() {
        return true;
    }

    /* renamed from: r */
    public boolean mo5135r() {
        return true;
    }

    /* renamed from: s */
    public boolean m5936s() {
        return true;
    }

    /* renamed from: t */
    public boolean m5937t() {
        return true;
    }

    /* renamed from: u */
    public boolean m5938u() {
        return true;
    }

    /* renamed from: v */
    public boolean mo5136v() {
        return true;
    }

    /* renamed from: w */
    public boolean mo5137w() {
        return true;
    }

    /* renamed from: x */
    public boolean m5939x() {
        return true;
    }

    /* renamed from: y */
    public boolean mo5138y() {
        return true;
    }

    /* renamed from: z */
    public boolean mo5139z() {
        return true;
    }
}
