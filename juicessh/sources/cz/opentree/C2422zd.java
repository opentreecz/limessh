package cz.opentree;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads_identifier.zze;

/* renamed from: cz.opentree.zd */
/* loaded from: classes.dex */
public final class C2422zd extends C2165vd implements zze {
    public C2422zd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    public final String getId() throws RemoteException {
        Parcel m9212r = m9212r(1, m9211q());
        String readString = m9212r.readString();
        m9212r.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads_identifier.zze
    /* renamed from: m */
    public final boolean mo1205m(boolean z) throws RemoteException {
        Parcel m9211q = m9211q();
        C2273xd.m9757a(m9211q, true);
        Parcel m9212r = m9212r(2, m9211q);
        boolean m9758b = C2273xd.m9758b(m9212r);
        m9212r.recycle();
        return m9758b;
    }
}
