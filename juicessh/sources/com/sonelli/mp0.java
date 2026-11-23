package com.sonelli;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout.java */
/* loaded from: classes.dex */
public class mp0 {

    /* renamed from: d */
    public static final mp0 f5125d = new C1568a();

    /* renamed from: a */
    public boolean f5126a;

    /* renamed from: b */
    public long f5127b;

    /* renamed from: c */
    public long f5128c;

    /* compiled from: Timeout.java */
    /* renamed from: com.sonelli.mp0$a */
    /* loaded from: classes.dex */
    public class C1568a extends mp0 {
        @Override // com.sonelli.mp0
        /* renamed from: d */
        public mp0 mo3307d(long j) {
            return this;
        }

        @Override // com.sonelli.mp0
        /* renamed from: f */
        public void mo3309f() throws IOException {
        }

        @Override // com.sonelli.mp0
        /* renamed from: g */
        public mp0 mo3310g(long j, TimeUnit timeUnit) {
            return this;
        }
    }

    /* renamed from: a */
    public mp0 mo3304a() {
        this.f5126a = false;
        return this;
    }

    /* renamed from: b */
    public mp0 mo3305b() {
        this.f5128c = 0L;
        return this;
    }

    /* renamed from: c */
    public long mo3306c() {
        if (this.f5126a) {
            return this.f5127b;
        }
        throw new IllegalStateException("No deadline");
    }

    /* renamed from: d */
    public mp0 mo3307d(long j) {
        this.f5126a = true;
        this.f5127b = j;
        return this;
    }

    /* renamed from: e */
    public boolean mo3308e() {
        return this.f5126a;
    }

    /* renamed from: f */
    public void mo3309f() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f5126a && this.f5127b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    /* renamed from: g */
    public mp0 mo3310g(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            }
            this.f5128c = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    /* renamed from: h */
    public long m6510h() {
        return this.f5128c;
    }
}
