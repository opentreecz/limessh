package cz.opentree;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.m2 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1534m2 implements SQLiteEventStore.Function {

    /* renamed from: a */
    public static final C1534m2 f4956a = new C1534m2();

    /* renamed from: a */
    public static SQLiteEventStore.Function m6339a() {
        return f4956a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.m775h0((Cursor) obj);
    }
}
