package com.sonelli;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.v2 */
/* loaded from: classes.dex */
public final /* synthetic */ class C2148v2 implements SQLiteEventStore.Function {

    /* renamed from: a */
    public static final C2148v2 f7389a = new C2148v2();

    /* renamed from: a */
    public static SQLiteEventStore.Function m9146a() {
        return f7389a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.m767Z((Cursor) obj);
    }
}
