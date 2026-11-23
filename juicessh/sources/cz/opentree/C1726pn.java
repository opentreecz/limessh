package cz.opentree;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzd;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.pn */
/* loaded from: classes.dex */
public final class C1726pn extends C2011ui implements zzd {
    public C1726pn(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.zzd
    /* renamed from: j */
    public final Bundle mo1222j(Bundle bundle) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6428c(m8894q, bundle);
        Parcel m8895r = m8895r(1, m8894q);
        Bundle bundle2 = (Bundle) C1557mj.m6426a(m8895r, Bundle.CREATOR);
        m8895r.recycle();
        return bundle2;
    }
}
