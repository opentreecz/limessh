package cz.opentree;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.internal.zzv;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: cz.opentree.z5 */
/* loaded from: classes.dex */
public final class C2412z5 extends AbstractC0754b6<Status> {
    public C2412z5(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* renamed from: c */
    public final /* synthetic */ Result mo1010c(Status status) {
        return status;
    }

    @Override // cz.opentree.AbstractC1802r7
    /* renamed from: n */
    public final /* synthetic */ void mo7883n(C1900t5 c1900t5) throws RemoteException {
        C1900t5 c1900t52 = c1900t5;
        ((zzv) c1900t52.m1100z()).mo948D(new BinderC2325y5(this), c1900t52.m8595k0());
    }
}
