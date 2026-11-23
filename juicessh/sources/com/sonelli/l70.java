package com.sonelli;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
/* loaded from: classes.dex */
public final class l70 {

    /* renamed from: a */
    public static final Set<String> f4758a = new HashSet(Arrays.asList("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"));

    /* renamed from: b */
    public static final List<String> f4759b = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");

    /* renamed from: c */
    public static final List<String> f4760c = Arrays.asList("auto", "app", "am");

    /* renamed from: d */
    public static final List<String> f4761d = Arrays.asList("_r", "_dbg");

    /* renamed from: e */
    public static final List<String> f4762e = Arrays.asList((String[]) C2420zb.m10417a(u00.f6880a, u00.f6881b));

    /* renamed from: f */
    public static final List<String> f4763f = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    /* renamed from: a */
    public static boolean m6091a(@NonNull String str) {
        return !f4760c.contains(str);
    }

    /* renamed from: b */
    public static boolean m6092b(@NonNull String str, @Nullable Bundle bundle) {
        if (f4759b.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        Iterator<String> it = f4761d.iterator();
        while (it.hasNext()) {
            if (bundle.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public static boolean m6093c(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!m6091a(str) || bundle == null) {
            return false;
        }
        Iterator<String> it = f4761d.iterator();
        while (it.hasNext()) {
            if (bundle.containsKey(it.next())) {
                return false;
            }
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 101200:
                if (str.equals("fcm")) {
                    c = 0;
                    break;
                }
                break;
            case 101230:
                if (str.equals("fdl")) {
                    c = 1;
                    break;
                }
                break;
            case 3142703:
                if (str.equals("fiam")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                bundle.putString("_cis", "fcm_integration");
                return true;
            case 1:
                bundle.putString("_cis", "fdl_integration");
                return true;
            case 2:
                bundle.putString("_cis", "fiam_integration");
                return true;
            default:
                return false;
        }
    }

    /* renamed from: d */
    public static void m6094d(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
    }

    /* renamed from: e */
    public static boolean m6095e(@NonNull String str) {
        return !f4758a.contains(str);
    }

    /* renamed from: f */
    public static String m6096f(String str) {
        String m8561a = t00.m8561a(str);
        return m8561a != null ? m8561a : str;
    }
}
