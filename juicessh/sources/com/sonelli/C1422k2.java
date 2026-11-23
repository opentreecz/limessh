package com.sonelli;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.k2 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1422k2 implements SQLiteEventStore.Function {

    /* renamed from: a */
    public final long f4445a;

    public C1422k2(long j) {
        this.f4445a = j;
    }

    /* renamed from: a */
    public static SQLiteEventStore.Function m5790a(long j) {
        return new C1422k2(j);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        Integer valueOf;
        valueOf = Integer.valueOf(((SQLiteDatabase) obj).delete("events", "timestamp_ms < ?", new String[]{String.valueOf(this.f4445a)}));
        return valueOf;
    }
}
