package cz.opentree;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: cz.opentree.zf */
/* loaded from: classes.dex */
public final class C2424zf {

    /* renamed from: a */
    public final long f8494a;

    /* renamed from: b */
    public final String f8495b;

    /* renamed from: c */
    public final String f8496c;

    /* renamed from: d */
    public final boolean f8497d;

    /* renamed from: e */
    public long f8498e;

    /* renamed from: f */
    public final Map<String, String> f8499f;

    public C2424zf(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        C0813ca.m2725g(str);
        C0813ca.m2725g(str2);
        this.f8494a = 0L;
        this.f8495b = str;
        this.f8496c = str2;
        this.f8497d = z;
        this.f8498e = j2;
        if (map != null) {
            this.f8499f = new HashMap(map);
        } else {
            this.f8499f = Collections.emptyMap();
        }
    }

    /* renamed from: a */
    public final void m10433a(long j) {
        this.f8498e = j;
    }

    /* renamed from: b */
    public final String m10434b() {
        return this.f8495b;
    }

    /* renamed from: c */
    public final long m10435c() {
        return this.f8494a;
    }

    /* renamed from: d */
    public final String m10436d() {
        return this.f8496c;
    }

    /* renamed from: e */
    public final boolean m10437e() {
        return this.f8497d;
    }

    /* renamed from: f */
    public final long m10438f() {
        return this.f8498e;
    }

    /* renamed from: g */
    public final Map<String, String> m10439g() {
        return this.f8499f;
    }
}
