package com.sonelli;

/* compiled from: NamedRunnable.java */
/* loaded from: classes.dex */
public abstract class en0 implements Runnable {

    /* renamed from: O */
    public final String f2501O;

    public en0(String str, Object... objArr) {
        this.f2501O = fn0.m3837r(str, objArr);
    }

    /* renamed from: k */
    public abstract void mo3533k();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f2501O);
        try {
            mo3533k();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
