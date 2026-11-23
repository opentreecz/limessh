package com.sonelli;

import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.q2 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1745q2 implements SQLiteEventStore.Producer {

    /* renamed from: a */
    public final SchemaManager f5918a;

    public C1745q2(SchemaManager schemaManager) {
        this.f5918a = schemaManager;
    }

    /* renamed from: b */
    public static SQLiteEventStore.Producer m7603b(SchemaManager schemaManager) {
        return new C1745q2(schemaManager);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Producer
    /* renamed from: a */
    public Object mo798a() {
        return this.f5918a.getWritableDatabase();
    }
}
