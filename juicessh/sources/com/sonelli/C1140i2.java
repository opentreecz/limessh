package com.sonelli;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.i2 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1140i2 implements SQLiteEventStore.Function {

    /* renamed from: a */
    public final SQLiteEventStore f3254a;

    /* renamed from: b */
    public final AbstractC1138i0 f3255b;

    public C1140i2(SQLiteEventStore sQLiteEventStore, AbstractC1138i0 abstractC1138i0) {
        this.f3254a = sQLiteEventStore;
        this.f3255b = abstractC1138i0;
    }

    /* renamed from: a */
    public static SQLiteEventStore.Function m4707a(SQLiteEventStore sQLiteEventStore, AbstractC1138i0 abstractC1138i0) {
        return new C1140i2(sQLiteEventStore, abstractC1138i0);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.m771d0(this.f3254a, this.f3255b, (SQLiteDatabase) obj);
    }
}
