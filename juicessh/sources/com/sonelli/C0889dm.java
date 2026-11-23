package com.sonelli;

import com.google.android.gms.internal.measurement.zzde;
import com.j256.ormlite.stmt.query.SimpleComparison;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.dm */
/* loaded from: classes.dex */
public final class C0889dm<T> implements zzde<T> {

    /* renamed from: O */
    public volatile zzde<T> f2243O;

    /* renamed from: P */
    public volatile boolean f2244P;

    /* renamed from: Q */
    @NullableDecl
    public T f2245Q;

    public C0889dm(zzde<T> zzdeVar) {
        C2299xl.m9800a(zzdeVar);
        this.f2243O = zzdeVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    /* renamed from: a */
    public final T mo1223a() {
        if (!this.f2244P) {
            synchronized (this) {
                if (!this.f2244P) {
                    T mo1223a = this.f2243O.mo1223a();
                    this.f2245Q = mo1223a;
                    this.f2244P = true;
                    this.f2243O = null;
                    return mo1223a;
                }
            }
        }
        return this.f2245Q;
    }

    public final String toString() {
        Object obj = this.f2243O;
        if (obj == null) {
            String valueOf = String.valueOf(this.f2245Q);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            obj = sb.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
