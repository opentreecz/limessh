package com.sonelli;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.n2 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1585n2 implements SQLiteEventStore.Function {

    /* renamed from: a */
    public final Map f5198a;

    public C1585n2(Map map) {
        this.f5198a = map;
    }

    /* renamed from: a */
    public static SQLiteEventStore.Function m6627a(Map map) {
        return new C1585n2(map);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.m773f0(this.f5198a, (Cursor) obj);
    }
}
