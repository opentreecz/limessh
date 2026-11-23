package cz.opentree;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.o2 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1630o2 implements SQLiteEventStore.Producer {

    /* renamed from: a */
    public final SQLiteDatabase f5405a;

    public C1630o2(SQLiteDatabase sQLiteDatabase) {
        this.f5405a = sQLiteDatabase;
    }

    /* renamed from: b */
    public static SQLiteEventStore.Producer m6835b(SQLiteDatabase sQLiteDatabase) {
        return new C1630o2(sQLiteDatabase);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Producer
    /* renamed from: a */
    public Object mo798a() {
        return SQLiteEventStore.m783z(this.f5405a);
    }
}
