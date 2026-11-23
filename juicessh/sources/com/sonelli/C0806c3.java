package com.sonelli;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.c3 */
/* loaded from: classes.dex */
public final /* synthetic */ class C0806c3 implements SchemaManager.Migration {

    /* renamed from: a */
    public static final C0806c3 f1867a = new C0806c3();

    /* renamed from: b */
    public static SchemaManager.Migration m2661b() {
        return f1867a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
    /* renamed from: a */
    public void mo805a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
