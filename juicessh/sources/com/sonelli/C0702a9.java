package com.sonelli;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.a9 */
/* loaded from: classes.dex */
public final class C0702a9 {

    /* renamed from: a */
    public final Map<BasePendingResult<?>, Boolean> f1348a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b */
    public final Map<k60<?>, Boolean> f1349b = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b */
    public final void m2002b(BasePendingResult<? extends Result> basePendingResult, boolean z) {
        this.f1348a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.mo988a(new C0698a8(this, basePendingResult));
    }

    /* renamed from: c */
    public final void m2003c(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f1348a) {
            hashMap = new HashMap(this.f1348a);
        }
        synchronized (this.f1349b) {
            hashMap2 = new HashMap(this.f1349b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).m1015l(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((k60) entry2.getKey()).m5845d(new C1029g7(status));
            }
        }
    }

    /* renamed from: d */
    public final boolean m2004d() {
        return (this.f1348a.isEmpty() && this.f1349b.isEmpty()) ? false : true;
    }

    /* renamed from: e */
    public final void m2005e() {
        m2003c(false, C1848s7.f6359n);
    }

    /* renamed from: f */
    public final void m2006f() {
        m2003c(true, C1903t8.f6722a);
    }
}
