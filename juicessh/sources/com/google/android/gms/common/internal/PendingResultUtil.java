package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.sonelli.C1029g7;
import com.sonelli.C1641oa;
import com.sonelli.C1695pa;
import com.sonelli.C1753qa;
import com.sonelli.j60;
import com.sonelli.k60;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public class PendingResultUtil {

    /* renamed from: a */
    public static final zaa f854a = new C1641oa();

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes.dex */
    public interface ResultConverter<R extends Result, T> {
        /* renamed from: a */
        T mo1125a(R r);
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes.dex */
    public interface zaa {
        /* renamed from: a */
        C1029g7 mo1126a(Status status);
    }

    /* renamed from: a */
    public static <R extends Result, T> j60<T> m1123a(PendingResult<R> pendingResult, ResultConverter<R, T> resultConverter) {
        zaa zaaVar = f854a;
        k60 k60Var = new k60();
        pendingResult.mo988a(new C1695pa(pendingResult, k60Var, resultConverter, zaaVar));
        return k60Var.m5842a();
    }

    /* renamed from: b */
    public static <R extends Result> j60<Void> m1124b(PendingResult<R> pendingResult) {
        return m1123a(pendingResult, new C1753qa());
    }
}
