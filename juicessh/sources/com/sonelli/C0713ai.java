package com.sonelli;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.sonelli.ai */
/* loaded from: classes.dex */
public final class C0713ai {
    /* renamed from: a */
    public static double m2072a(String str, double d) {
        if (str == null) {
            return 100.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return 100.0d;
        }
    }

    /* renamed from: b */
    public static C1507li m2073b(C1451kh c1451kh, String str) {
        C0813ca.m2729k(c1451kh);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new HashMap();
        try {
            String valueOf = String.valueOf(str);
            Map<String, String> m4430b = C1103hc.m4430b(new URI(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")), "UTF-8");
            C1507li c1507li = new C1507li();
            c1507li.m6185s(m4430b.get("utm_content"));
            c1507li.m6183q(m4430b.get("utm_medium"));
            c1507li.m6174h(m4430b.get("utm_campaign"));
            c1507li.m6182p(m4430b.get("utm_source"));
            c1507li.m6184r(m4430b.get("utm_term"));
            c1507li.m6186t(m4430b.get("utm_id"));
            c1507li.m6187u(m4430b.get("anid"));
            c1507li.m6188v(m4430b.get("gclid"));
            c1507li.m6189w(m4430b.get("dclid"));
            c1507li.m6190x(m4430b.get("aclid"));
            return c1507li;
        } catch (URISyntaxException e) {
            c1451kh.m8672t0("No valid campaign data found", e);
            return null;
        }
    }

    /* renamed from: c */
    public static String m2074c(Locale locale) {
        if (locale == null) {
            return null;
        }
        String language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(language.toLowerCase(locale));
        if (!TextUtils.isEmpty(locale.getCountry())) {
            sb.append("-");
            sb.append(locale.getCountry().toLowerCase(locale));
        }
        return sb.toString();
    }

    /* renamed from: d */
    public static void m2075d(Map<String, String> map, String str, Map<String, String> map2) {
        m2081j(map, str, map2.get(str));
    }

    /* renamed from: e */
    public static boolean m2076e(double d, String str) {
        int i;
        if (d > ShadowDrawableWrapper.COS_45 && d < 100.0d) {
            if (TextUtils.isEmpty(str)) {
                i = 1;
            } else {
                i = 0;
                for (int length = str.length() - 1; length >= 0; length--) {
                    char charAt = str.charAt(length);
                    i = ((i << 6) & 268435455) + charAt + (charAt << 14);
                    int i2 = 266338304 & i;
                    if (i2 != 0) {
                        i ^= i2 >> 21;
                    }
                }
            }
            if (i % 10000 >= d * 100.0d) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public static boolean m2077f(Context context, String str, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, str), 0);
            if (receiverInfo != null && receiverInfo.enabled) {
                if (!z) {
                    return true;
                }
                if (receiverInfo.exported) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* renamed from: g */
    public static long m2078g(String str) {
        if (str == null) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    /* renamed from: h */
    public static MessageDigest m2079h(String str) {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    /* renamed from: i */
    public static boolean m2080i(String str) {
        return TextUtils.isEmpty(str) || !str.startsWith("http:");
    }

    /* renamed from: j */
    public static void m2081j(Map<String, String> map, String str, String str2) {
        if (str2 == null || map.containsKey(str)) {
            return;
        }
        map.put(str, str2);
    }

    /* renamed from: k */
    public static void m2082k(Map<String, String> map, String str, boolean z) {
        if (map.containsKey(str)) {
            return;
        }
        map.put(str, z ? "1" : "0");
    }

    /* renamed from: l */
    public static boolean m2083l(String str, boolean z) {
        return str == null || str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("1") || !(str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no") || str.equalsIgnoreCase("0"));
    }

    /* renamed from: m */
    public static String m2084m(boolean z) {
        return z ? "1" : "0";
    }

    /* renamed from: n */
    public static void m2085n(Map<String, String> map, String str, String str2) {
        if (str2 == null || !TextUtils.isEmpty(map.get(str))) {
            return;
        }
        map.put(str, str2);
    }

    /* renamed from: o */
    public static boolean m2086o(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, str), 0);
            if (serviceInfo != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }
}
