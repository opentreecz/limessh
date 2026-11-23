package cz.opentree;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.y2 */
/* loaded from: classes.dex */
public final /* synthetic */ class C2322y2 implements SQLiteEventStore.Function {

    /* renamed from: a */
    public final SQLiteEventStore f8112a;

    /* renamed from: b */
    public final AbstractC1138i0 f8113b;

    public C2322y2(SQLiteEventStore sQLiteEventStore, AbstractC1138i0 abstractC1138i0) {
        this.f8112a = sQLiteEventStore;
        this.f8113b = abstractC1138i0;
    }

    /* renamed from: a */
    public static SQLiteEventStore.Function m10050a(SQLiteEventStore sQLiteEventStore, AbstractC1138i0 abstractC1138i0) {
        return new C2322y2(sQLiteEventStore, abstractC1138i0);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.m768a0(this.f8112a, this.f8113b, (SQLiteDatabase) obj);
    }
}
