package com.sonelli;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamite.zzl;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.ud */
/* loaded from: classes.dex */
public final class C2004ud extends C2341ye implements zzl {
    public C2004ud(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // com.google.android.gms.dynamite.zzl
    /* renamed from: A */
    public final IObjectWrapper mo1203A(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel m10125q = m10125q();
        C2423ze.m10430c(m10125q, iObjectWrapper);
        m10125q.writeString(str);
        m10125q.writeInt(i);
        C2423ze.m10430c(m10125q, iObjectWrapper2);
        Parcel m10126r = m10126r(2, m10125q);
        IObjectWrapper m1181r = IObjectWrapper.AbstractBinderC0446a.m1181r(m10126r.readStrongBinder());
        m10126r.recycle();
        return m1181r;
    }

    @Override // com.google.android.gms.dynamite.zzl
    /* renamed from: B */
    public final IObjectWrapper mo1204B(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel m10125q = m10125q();
        C2423ze.m10430c(m10125q, iObjectWrapper);
        m10125q.writeString(str);
        m10125q.writeInt(i);
        C2423ze.m10430c(m10125q, iObjectWrapper2);
        Parcel m10126r = m10126r(3, m10125q);
        IObjectWrapper m1181r = IObjectWrapper.AbstractBinderC0446a.m1181r(m10126r.readStrongBinder());
        m10126r.recycle();
        return m1181r;
    }
}
