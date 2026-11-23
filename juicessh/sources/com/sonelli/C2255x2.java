package com.sonelli;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.x2 */
/* loaded from: classes.dex */
public final /* synthetic */ class C2255x2 implements SQLiteEventStore.Function {

    /* renamed from: a */
    public static final C2255x2 f7852a = new C2255x2();

    /* renamed from: a */
    public static SQLiteEventStore.Function m9673a() {
        return f7852a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.m766Y((Cursor) obj);
    }
}
