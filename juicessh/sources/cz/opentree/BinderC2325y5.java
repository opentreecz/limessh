package cz.opentree;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: cz.opentree.y5 */
/* loaded from: classes.dex */
public final class BinderC2325y5 extends BinderC1748q5 {

    /* renamed from: a */
    public final /* synthetic */ C2412z5 f8140a;

    public BinderC2325y5(C2412z5 c2412z5) {
        this.f8140a = c2412z5;
    }

    @Override // cz.opentree.BinderC1748q5, com.google.android.gms.auth.api.signin.internal.zzt
    /* renamed from: J */
    public final void mo944J(Status status) throws RemoteException {
        this.f8140a.m1013f(status);
    }
}
