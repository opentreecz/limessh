package com.sonelli;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.r2 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1797r2 implements SQLiteEventStore.Function {

    /* renamed from: a */
    public static final C1797r2 f6157a = new C1797r2();

    /* renamed from: a */
    public static SQLiteEventStore.Function m7850a() {
        return f6157a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.m769b0((Cursor) obj);
    }
}
