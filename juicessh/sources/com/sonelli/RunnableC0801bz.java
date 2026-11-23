package com.sonelli;

import androidx.annotation.WorkerThread;
import com.google.android.gms.measurement.internal.zzfc;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
@WorkerThread
/* renamed from: com.sonelli.bz */
/* loaded from: classes.dex */
public final class RunnableC0801bz implements Runnable {

    /* renamed from: O */
    public final zzfc f1835O;

    /* renamed from: P */
    public final int f1836P;

    /* renamed from: Q */
    public final Throwable f1837Q;

    /* renamed from: R */
    public final byte[] f1838R;

    /* renamed from: S */
    public final String f1839S;

    /* renamed from: T */
    public final Map<String, List<String>> f1840T;

    public RunnableC0801bz(String str, zzfc zzfcVar, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        C0813ca.m2729k(zzfcVar);
        this.f1835O = zzfcVar;
        this.f1836P = i;
        this.f1837Q = th;
        this.f1838R = bArr;
        this.f1839S = str;
        this.f1840T = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1835O.mo1479a(this.f1839S, this.f1836P, this.f1837Q, this.f1838R, this.f1840T);
    }
}
