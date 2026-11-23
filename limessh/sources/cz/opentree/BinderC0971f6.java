package cz.opentree;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: cz.opentree.f6 */
/* loaded from: classes.dex */
public final class BinderC0971f6 extends AbstractBinderC0809c6 {

    /* renamed from: a */
    public final Context f2622a;

    public BinderC0971f6(Context context) {
        this.f2622a = context;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzr
    /* renamed from: h */
    public final void mo942h() {
        m3686r();
        C0696a6.m1982c(this.f2622a).m1984a();
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzr
    /* renamed from: i */
    public final void mo943i() {
        m3686r();
        C1588n5 m6639b = C1588n5.m6639b(this.f2622a);
        GoogleSignInAccount m6642c = m6639b.m6642c();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f671e0;
        if (m6642c != null) {
            googleSignInOptions = m6639b.m6643d();
        }
        C1435k5 m5055a = C1196j5.m5055a(this.f2622a, googleSignInOptions);
        if (m6642c != null) {
            m5055a.m5836n();
        } else {
            m5055a.m5837o();
        }
    }

    /* renamed from: r */
    public final void m3686r() {
        if (C1649oc.m7010a(this.f2622a, Binder.getCallingUid())) {
            return;
        }
        int callingUid = Binder.getCallingUid();
        StringBuilder sb = new StringBuilder(52);
        sb.append("Calling UID ");
        sb.append(callingUid);
        sb.append(" is not Google Play services.");
        throw new SecurityException(sb.toString());
    }
}
