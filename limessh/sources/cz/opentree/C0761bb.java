package cz.opentree;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.bb */
/* loaded from: classes.dex */
public final class C0761bb extends C2341ye implements zzi {
    public C0761bb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzi
    /* renamed from: b */
    public final IObjectWrapper mo1139b() throws RemoteException {
        Parcel m10126r = m10126r(1, m10125q());
        IObjectWrapper m1181r = IObjectWrapper.AbstractBinderC0446a.m1181r(m10126r.readStrongBinder());
        m10126r.recycle();
        return m1181r;
    }

    @Override // com.google.android.gms.common.internal.zzi
    /* renamed from: c */
    public final int mo1140c() throws RemoteException {
        Parcel m10126r = m10126r(2, m10125q());
        int readInt = m10126r.readInt();
        m10126r.recycle();
        return readInt;
    }
}
