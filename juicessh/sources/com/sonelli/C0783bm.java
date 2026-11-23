package com.sonelli;

import com.google.android.gms.internal.measurement.zzde;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.bm */
/* loaded from: classes.dex */
public final class C0783bm {
    /* renamed from: a */
    public static <T> zzde<T> m2558a(zzde<T> zzdeVar) {
        return ((zzdeVar instanceof C0889dm) || (zzdeVar instanceof C0720am)) ? zzdeVar : zzdeVar instanceof Serializable ? new C0720am(zzdeVar) : new C0889dm(zzdeVar);
    }

    /* renamed from: b */
    public static <T> zzde<T> m2559b(@NullableDecl T t) {
        return new C0837cm(t);
    }
}
