package com.amazonaws.regions;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class Region {

    /* renamed from: a */
    public final String f191a;

    /* renamed from: b */
    public final Map<String, String> f192b = new HashMap();

    /* renamed from: c */
    public final Map<String, Boolean> f193c = new HashMap();

    /* renamed from: d */
    public final Map<String, Boolean> f194d = new HashMap();

    public Region(String str, String str2) {
        this.f191a = str;
        if (str2 != null) {
            str2.isEmpty();
        }
    }

    /* renamed from: d */
    public static Region m253d(String str) {
        return RegionUtils.m267a(str);
    }

    /* renamed from: a */
    public Map<String, Boolean> m254a() {
        return this.f193c;
    }

    /* renamed from: b */
    public Map<String, Boolean> m255b() {
        return this.f194d;
    }

    /* renamed from: c */
    public String m256c() {
        return this.f191a;
    }

    /* renamed from: e */
    public String m257e(String str) {
        return this.f192b.get(str);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Region) {
            return m256c().equals(((Region) obj).m256c());
        }
        return false;
    }

    /* renamed from: f */
    public Map<String, String> m258f() {
        return this.f192b;
    }

    public int hashCode() {
        return m256c().hashCode();
    }

    public String toString() {
        return m256c();
    }
}
