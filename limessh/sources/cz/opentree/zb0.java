package cz.opentree;

import com.google.android.datatransport.TransportScheduleCallback;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zb0 implements TransportScheduleCallback {

    /* renamed from: a */
    public final k60 f8488a;

    /* renamed from: b */
    public final b90 f8489b;

    public zb0(k60 k60Var, b90 b90Var) {
        this.f8488a = k60Var;
        this.f8489b = b90Var;
    }

    /* renamed from: b */
    public static TransportScheduleCallback m10426b(k60 k60Var, b90 b90Var) {
        return new zb0(k60Var, b90Var);
    }

    @Override // com.google.android.datatransport.TransportScheduleCallback
    /* renamed from: a */
    public void mo740a(Exception exc) {
        bc0.m2429b(this.f8488a, this.f8489b, exc);
    }
}
