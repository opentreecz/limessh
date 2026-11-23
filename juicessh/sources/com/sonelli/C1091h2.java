package com.sonelli;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.h2 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1091h2 implements SQLiteEventStore.Function {

    /* renamed from: a */
    public final long f3078a;

    /* renamed from: b */
    public final AbstractC1138i0 f3079b;

    public C1091h2(long j, AbstractC1138i0 abstractC1138i0) {
        this.f3078a = j;
        this.f3079b = abstractC1138i0;
    }

    /* renamed from: a */
    public static SQLiteEventStore.Function m4342a(long j, AbstractC1138i0 abstractC1138i0) {
        return new C1091h2(j, abstractC1138i0);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.m777j0(this.f3078a, this.f3079b, (SQLiteDatabase) obj);
    }
}
