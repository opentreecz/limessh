package com.sonelli;

import android.content.Context;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class u50 {

    /* renamed from: a */
    public static Map<String, String> f6920a = new HashMap();

    /* renamed from: a */
    public static String m8852a(String str, String str2) {
        if (str2 != null) {
            String valueOf = String.valueOf(str);
            return Uri.parse(valueOf.length() != 0 ? "http://hostname/?".concat(valueOf) : new String("http://hostname/?")).getQueryParameter(str2);
        }
        if (str.length() > 0) {
            return str;
        }
        return null;
    }

    /* renamed from: b */
    public static void m8853b(Context context, String str) {
        String m8852a = m8852a(str, "conv");
        if (m8852a == null || m8852a.length() <= 0) {
            return;
        }
        f6920a.put(m8852a, str);
        b60.m2391a(context, "gtm_click_referrers", m8852a, str);
    }
}
