package com.sonelli;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout.java */
/* loaded from: classes.dex */
public class dp0 extends mp0 {

    /* renamed from: e */
    public mp0 f2269e;

    public dp0(mp0 mp0Var) {
        if (mp0Var == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f2269e = mp0Var;
    }

    @Override // com.sonelli.mp0
    /* renamed from: a */
    public mp0 mo3304a() {
        return this.f2269e.mo3304a();
    }

    @Override // com.sonelli.mp0
    /* renamed from: b */
    public mp0 mo3305b() {
        return this.f2269e.mo3305b();
    }

    @Override // com.sonelli.mp0
    /* renamed from: c */
    public long mo3306c() {
        return this.f2269e.mo3306c();
    }

    @Override // com.sonelli.mp0
    /* renamed from: d */
    public mp0 mo3307d(long j) {
        return this.f2269e.mo3307d(j);
    }

    @Override // com.sonelli.mp0
    /* renamed from: e */
    public boolean mo3308e() {
        return this.f2269e.mo3308e();
    }

    @Override // com.sonelli.mp0
    /* renamed from: f */
    public void mo3309f() throws IOException {
        this.f2269e.mo3309f();
    }

    @Override // com.sonelli.mp0
    /* renamed from: g */
    public mp0 mo3310g(long j, TimeUnit timeUnit) {
        return this.f2269e.mo3310g(j, timeUnit);
    }

    /* renamed from: i */
    public final mp0 m3311i() {
        return this.f2269e;
    }

    /* renamed from: j */
    public final dp0 m3312j(mp0 mp0Var) {
        if (mp0Var == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f2269e = mp0Var;
        return this;
    }
}
