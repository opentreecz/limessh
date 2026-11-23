package cz.opentree;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.s2 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1843s2 implements SQLiteEventStore.Function {

    /* renamed from: a */
    public static final C1843s2 f6333a = new C1843s2();

    /* renamed from: a */
    public static SQLiteEventStore.Function m8306a() {
        return f6333a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return Boolean.valueOf(((Cursor) obj).moveToNext());
    }
}
