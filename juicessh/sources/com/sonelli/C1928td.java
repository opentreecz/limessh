package com.sonelli;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamite.zzj;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.td */
/* loaded from: classes.dex */
public final class C1928td extends C2341ye implements zzj {
    public C1928td(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.zzj
    /* renamed from: I0 */
    public final int mo1198I0() throws RemoteException {
        Parcel m10126r = m10126r(6, m10125q());
        int readInt = m10126r.readInt();
        m10126r.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzj
    /* renamed from: T */
    public final IObjectWrapper mo1199T(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel m10125q = m10125q();
        C2423ze.m10430c(m10125q, iObjectWrapper);
        m10125q.writeString(str);
        m10125q.writeInt(i);
        Parcel m10126r = m10126r(2, m10125q);
        IObjectWrapper m1181r = IObjectWrapper.AbstractBinderC0446a.m1181r(m10126r.readStrongBinder());
        m10126r.recycle();
        return m1181r;
    }

    @Override // com.google.android.gms.dynamite.zzj
    /* renamed from: m0 */
    public final int mo1200m0(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel m10125q = m10125q();
        C2423ze.m10430c(m10125q, iObjectWrapper);
        m10125q.writeString(str);
        C2423ze.m10428a(m10125q, z);
        Parcel m10126r = m10126r(5, m10125q);
        int readInt = m10126r.readInt();
        m10126r.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzj
    /* renamed from: u0 */
    public final int mo1201u0(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        Parcel m10125q = m10125q();
        C2423ze.m10430c(m10125q, iObjectWrapper);
        m10125q.writeString(str);
        C2423ze.m10428a(m10125q, z);
        Parcel m10126r = m10126r(3, m10125q);
        int readInt = m10126r.readInt();
        m10126r.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzj
    /* renamed from: y0 */
    public final IObjectWrapper mo1202y0(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel m10125q = m10125q();
        C2423ze.m10430c(m10125q, iObjectWrapper);
        m10125q.writeString(str);
        m10125q.writeInt(i);
        Parcel m10126r = m10126r(4, m10125q);
        IObjectWrapper m1181r = IObjectWrapper.AbstractBinderC0446a.m1181r(m10126r.readStrongBinder());
        m10126r.recycle();
        return m1181r;
    }
}
