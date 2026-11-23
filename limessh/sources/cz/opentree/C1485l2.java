package cz.opentree;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.List;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.l2 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1485l2 implements SQLiteEventStore.Function {

    /* renamed from: a */
    public final SQLiteEventStore f4720a;

    /* renamed from: b */
    public final List f4721b;

    /* renamed from: c */
    public final AbstractC1138i0 f4722c;

    public C1485l2(SQLiteEventStore sQLiteEventStore, List list, AbstractC1138i0 abstractC1138i0) {
        this.f4720a = sQLiteEventStore;
        this.f4721b = list;
        this.f4722c = abstractC1138i0;
    }

    /* renamed from: a */
    public static SQLiteEventStore.Function m6044a(SQLiteEventStore sQLiteEventStore, List list, AbstractC1138i0 abstractC1138i0) {
        return new C1485l2(sQLiteEventStore, list, abstractC1138i0);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.m772e0(this.f4720a, this.f4721b, this.f4722c, (Cursor) obj);
    }
}
