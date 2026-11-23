package com.sonelli;

import com.google.android.datatransport.runtime.retries.Function;
import com.sonelli.C2252x;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: com.sonelli.v */
/* loaded from: classes.dex */
public final /* synthetic */ class C2145v implements Function {

    /* renamed from: a */
    public final C2252x f7366a;

    public C2145v(C2252x c2252x) {
        this.f7366a = c2252x;
    }

    /* renamed from: a */
    public static Function m9131a(C2252x c2252x) {
        return new C2145v(c2252x);
    }

    @Override // com.google.android.datatransport.runtime.retries.Function
    public Object apply(Object obj) {
        C2252x.b m9654d;
        m9654d = this.f7366a.m9654d((C2252x.a) obj);
        return m9654d;
    }
}
