package cz.opentree;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzt;
import com.google.android.gms.auth.api.signin.internal.zzv;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: cz.opentree.e6 */
/* loaded from: classes.dex */
public final class C0913e6 extends C0871de implements zzv {
    public C0913e6(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzv
    /* renamed from: A0 */
    public final void mo947A0(zzt zztVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel m3193q = m3193q();
        C0923ee.m3477b(m3193q, zztVar);
        C0923ee.m3478c(m3193q, googleSignInOptions);
        m3194r(102, m3193q);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzv
    /* renamed from: D */
    public final void mo948D(zzt zztVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel m3193q = m3193q();
        C0923ee.m3477b(m3193q, zztVar);
        C0923ee.m3478c(m3193q, googleSignInOptions);
        m3194r(103, m3193q);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzv
    /* renamed from: H0 */
    public final void mo949H0(zzt zztVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel m3193q = m3193q();
        C0923ee.m3477b(m3193q, zztVar);
        C0923ee.m3478c(m3193q, googleSignInOptions);
        m3194r(101, m3193q);
    }
}
