package com.sonelli;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.b3 */
/* loaded from: classes.dex */
public final /* synthetic */ class C0750b3 implements SchemaManager.Migration {

    /* renamed from: a */
    public static final C0750b3 f1595a = new C0750b3();

    /* renamed from: b */
    public static SchemaManager.Migration m2358b() {
        return f1595a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
    /* renamed from: a */
    public void mo805a(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.m800c(sQLiteDatabase);
    }
}
