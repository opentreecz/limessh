package com.sonelli;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class eb0 {

    /* renamed from: a */
    public int f2361a;

    /* renamed from: b */
    public String f2362b;

    /* renamed from: c */
    public qm0 f2363c;

    public eb0(int i, String str, qm0 qm0Var) {
        this.f2361a = i;
        this.f2362b = str;
        this.f2363c = qm0Var;
    }

    /* renamed from: c */
    public static eb0 m3470c(zm0 zm0Var) throws IOException {
        return new eb0(zm0Var.m10508c(), zm0Var.m10506a() == null ? null : zm0Var.m10506a().m2165l(), zm0Var.m10512l());
    }

    /* renamed from: a */
    public String m3471a() {
        return this.f2362b;
    }

    /* renamed from: b */
    public int m3472b() {
        return this.f2361a;
    }

    /* renamed from: d */
    public String m3473d(String str) {
        return this.f2363c.m7749c(str);
    }
}
