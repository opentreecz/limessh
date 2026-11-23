package com.sonelli;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.tt */
/* loaded from: classes.dex */
public final class BinderC1981tt extends AbstractBinderC2312xt {

    /* renamed from: a */
    public final AtomicReference<Bundle> f6859a = new AtomicReference<>();

    /* renamed from: b */
    public boolean f6860b;

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:
    
        r4 = r4.get("r");
     */
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> T m8807r(android.os.Bundle r4, java.lang.Class<T> r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L38
            java.lang.String r1 = "r"
            java.lang.Object r4 = r4.get(r1)
            if (r4 == 0) goto L38
            java.lang.Object r4 = r5.cast(r4)     // Catch: java.lang.ClassCastException -> L10
            return r4
        L10:
            r0 = move-exception
            java.lang.String r5 = r5.getCanonicalName()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getCanonicalName()
            java.lang.String r1 = "Unexpected object type. Expected, Received"
            java.lang.String r2 = ": %s, %s"
            java.lang.String r1 = r1.concat(r2)
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r5
            r5 = 1
            r2[r5] = r4
            java.lang.String r4 = java.lang.String.format(r1, r2)
            java.lang.String r5 = "AM"
            android.util.Log.w(r5, r4, r0)
            throw r0
        L38:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.BinderC1981tt.m8807r(android.os.Bundle, java.lang.Class):java.lang.Object");
    }

    /* renamed from: O0 */
    public final Bundle m8808O0(long j) {
        Bundle bundle;
        synchronized (this.f6859a) {
            if (!this.f6860b) {
                try {
                    this.f6859a.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.f6859a.get();
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzs
    /* renamed from: j */
    public final void mo1433j(Bundle bundle) {
        synchronized (this.f6859a) {
            try {
                this.f6859a.set(bundle);
                this.f6860b = true;
            } finally {
                this.f6859a.notify();
            }
        }
    }

    /* renamed from: s */
    public final String m8809s(long j) {
        return (String) m8807r(m8808O0(j), String.class);
    }
}
