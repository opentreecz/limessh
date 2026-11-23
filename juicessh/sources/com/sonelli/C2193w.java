package com.sonelli;

import com.google.android.datatransport.runtime.retries.RetryStrategy;
import com.sonelli.C2252x;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: com.sonelli.w */
/* loaded from: classes.dex */
public final /* synthetic */ class C2193w implements RetryStrategy {

    /* renamed from: a */
    public static final C2193w f7577a = new C2193w();

    /* renamed from: b */
    public static RetryStrategy m9376b() {
        return f7577a;
    }

    @Override // com.google.android.datatransport.runtime.retries.RetryStrategy
    /* renamed from: a */
    public Object mo750a(Object obj, Object obj2) {
        return C2252x.m9650c((C2252x.a) obj, (C2252x.b) obj2);
    }
}
