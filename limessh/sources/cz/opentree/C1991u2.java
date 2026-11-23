package cz.opentree;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.u2 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1991u2 implements SQLiteEventStore.Function {

    /* renamed from: a */
    public final SQLiteEventStore f6902a;

    /* renamed from: b */
    public final AbstractC1138i0 f6903b;

    /* renamed from: c */
    public final AbstractC0906e0 f6904c;

    public C1991u2(SQLiteEventStore sQLiteEventStore, AbstractC1138i0 abstractC1138i0, AbstractC0906e0 abstractC0906e0) {
        this.f6902a = sQLiteEventStore;
        this.f6903b = abstractC1138i0;
        this.f6904c = abstractC0906e0;
    }

    /* renamed from: a */
    public static SQLiteEventStore.Function m8833a(SQLiteEventStore sQLiteEventStore, AbstractC1138i0 abstractC1138i0, AbstractC0906e0 abstractC0906e0) {
        return new C1991u2(sQLiteEventStore, abstractC1138i0, abstractC0906e0);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.m774g0(this.f6902a, this.f6903b, this.f6904c, (SQLiteDatabase) obj);
    }
}
