package cz.opentree;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.a3 */
/* loaded from: classes.dex */
public final /* synthetic */ class C0693a3 implements SchemaManager.Migration {

    /* renamed from: a */
    public static final C0693a3 f1325a = new C0693a3();

    /* renamed from: b */
    public static SchemaManager.Migration m1976b() {
        return f1325a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
    /* renamed from: a */
    public void mo805a(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.m799b(sQLiteDatabase);
    }
}
