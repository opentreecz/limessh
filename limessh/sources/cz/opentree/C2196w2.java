package cz.opentree;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.w2 */
/* loaded from: classes.dex */
public final /* synthetic */ class C2196w2 implements SQLiteEventStore.Function {

    /* renamed from: a */
    public final String f7599a;

    public C2196w2(String str) {
        this.f7599a = str;
    }

    /* renamed from: a */
    public static SQLiteEventStore.Function m9389a(String str) {
        return new C2196w2(str);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        return SQLiteEventStore.m776i0(this.f7599a, (SQLiteDatabase) obj);
    }
}
