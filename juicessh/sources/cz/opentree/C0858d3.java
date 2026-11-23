package cz.opentree;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.d3 */
/* loaded from: classes.dex */
public final /* synthetic */ class C0858d3 implements SchemaManager.Migration {

    /* renamed from: a */
    public static final C0858d3 f2117a = new C0858d3();

    /* renamed from: b */
    public static SchemaManager.Migration m3111b() {
        return f2117a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
    /* renamed from: a */
    public void mo805a(SQLiteDatabase sQLiteDatabase) {
        SchemaManager.m802f(sQLiteDatabase);
    }
}
