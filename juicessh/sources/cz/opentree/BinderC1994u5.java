package cz.opentree;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: cz.opentree.u5 */
/* loaded from: classes.dex */
public final class BinderC1994u5 extends BinderC1748q5 {

    /* renamed from: a */
    public final /* synthetic */ C2153v5 f6919a;

    public BinderC1994u5(C2153v5 c2153v5) {
        this.f6919a = c2153v5;
    }

    @Override // cz.opentree.BinderC1748q5, com.google.android.gms.auth.api.signin.internal.zzt
    /* renamed from: U */
    public final void mo945U(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
        if (googleSignInAccount != null) {
            C0696a6.m1982c(this.f6919a.f7405o).m1985b(this.f6919a.f7406p, googleSignInAccount);
        }
        this.f6919a.m1013f(new C1490l5(googleSignInAccount, status));
    }
}
