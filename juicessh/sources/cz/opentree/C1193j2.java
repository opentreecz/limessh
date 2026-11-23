package cz.opentree;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.j2 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1193j2 implements SQLiteEventStore.Function {

    /* renamed from: a */
    public static final C1193j2 f3473a = new C1193j2();

    /* renamed from: a */
    public static SQLiteEventStore.Function m5035a() {
        return f3473a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.m770c0((SQLiteDatabase) obj);
    }
}
