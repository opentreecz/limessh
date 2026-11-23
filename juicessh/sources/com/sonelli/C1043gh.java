package com.sonelli;

import android.text.TextUtils;
import com.google.android.gms.internal.gtm.zzbk;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.sonelli.gh */
/* loaded from: classes.dex */
public final class C1043gh {

    /* renamed from: a */
    public final Map<String, String> f2868a;

    /* renamed from: b */
    public final List<zzbk> f2869b;

    /* renamed from: c */
    public final long f2870c;

    /* renamed from: d */
    public final long f2871d;

    /* renamed from: e */
    public final int f2872e;

    /* renamed from: f */
    public final boolean f2873f;

    /* renamed from: g */
    public final String f2874g;

    public C1043gh(C1930tf c1930tf, Map<String, String> map, long j, boolean z) {
        this(c1930tf, map, j, z, 0L, 0, null);
    }

    public C1043gh(C1930tf c1930tf, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(c1930tf, map, j, z, j2, i, null);
    }

    public C1043gh(C1930tf c1930tf, Map<String, String> map, long j, boolean z, long j2, int i, List<zzbk> list) {
        String str;
        String m4122a;
        String m4122a2;
        C0813ca.m2729k(c1930tf);
        C0813ca.m2729k(map);
        this.f2871d = j;
        this.f2873f = z;
        this.f2870c = j2;
        this.f2872e = i;
        this.f2869b = list != null ? list : Collections.emptyList();
        if (list != null) {
            for (zzbk zzbkVar : list) {
                if ("appendVersion".equals(zzbkVar.m1208a())) {
                    str = zzbkVar.m1209b();
                    break;
                }
            }
        }
        str = null;
        this.f2874g = TextUtils.isEmpty(str) ? null : str;
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (m4124c(entry.getKey()) && (m4122a2 = m4122a(c1930tf, entry.getKey())) != null) {
                hashMap.put(m4122a2, m4123b(c1930tf, entry.getValue()));
            }
        }
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            if (!m4124c(entry2.getKey()) && (m4122a = m4122a(c1930tf, entry2.getKey())) != null) {
                hashMap.put(m4122a, m4123b(c1930tf, entry2.getValue()));
            }
        }
        if (!TextUtils.isEmpty(this.f2874g)) {
            C0713ai.m2081j(hashMap, "_v", this.f2874g);
            if (this.f2874g.equals("ma4.0.0") || this.f2874g.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.f2868a = Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: a */
    public static String m4122a(C1930tf c1930tf, Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            c1930tf.m8657e0("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        if (TextUtils.isEmpty(obj2)) {
            return null;
        }
        return obj2;
    }

    /* renamed from: b */
    public static String m4123b(C1930tf c1930tf, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        String substring = obj2.substring(0, 8192);
        c1930tf.m8657e0("Hit param value is too long and will be trimmed", Integer.valueOf(length), substring);
        return substring;
    }

    /* renamed from: c */
    public static boolean m4124c(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith("&");
    }

    /* renamed from: d */
    public final String m4125d(String str, String str2) {
        C0813ca.m2725g(str);
        C0813ca.m2720b(!str.startsWith("&"), "Short param name required");
        String str3 = this.f2868a.get(str);
        return str3 != null ? str3 : str2;
    }

    /* renamed from: e */
    public final Map<String, String> m4126e() {
        return this.f2868a;
    }

    /* renamed from: f */
    public final int m4127f() {
        return this.f2872e;
    }

    /* renamed from: g */
    public final long m4128g() {
        return this.f2870c;
    }

    /* renamed from: h */
    public final long m4129h() {
        return this.f2871d;
    }

    /* renamed from: i */
    public final List<zzbk> m4130i() {
        return this.f2869b;
    }

    /* renamed from: j */
    public final boolean m4131j() {
        return this.f2873f;
    }

    /* renamed from: k */
    public final long m4132k() {
        return C0713ai.m2078g(m4125d("_s", "0"));
    }

    /* renamed from: l */
    public final String m4133l() {
        return m4125d("_m", "");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ht=");
        sb.append(this.f2871d);
        if (this.f2870c != 0) {
            sb.append(", dbId=");
            sb.append(this.f2870c);
        }
        if (this.f2872e != 0) {
            sb.append(", appUID=");
            sb.append(this.f2872e);
        }
        ArrayList arrayList = new ArrayList(this.f2868a.keySet());
        Collections.sort(arrayList);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str = (String) obj;
            sb.append(", ");
            sb.append(str);
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(this.f2868a.get(str));
        }
        return sb.toString();
    }
}
