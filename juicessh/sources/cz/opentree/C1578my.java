package cz.opentree;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.my */
/* loaded from: classes.dex */
public final class C1578my extends C2011ui implements zzel {
    public C1578my(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    /* renamed from: F */
    public final void mo1464F(zzaq zzaqVar, String str, String str2) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6428c(m8894q, zzaqVar);
        m8894q.writeString(str);
        m8894q.writeString(str2);
        m8896s(5, m8894q);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    /* renamed from: G */
    public final List<zzkn> mo1465G(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel m8894q = m8894q();
        m8894q.writeString(str);
        m8894q.writeString(str2);
        m8894q.writeString(str3);
        C1557mj.m6429d(m8894q, z);
        Parcel m8895r = m8895r(15, m8894q);
        ArrayList createTypedArrayList = m8895r.createTypedArrayList(zzkn.CREATOR);
        m8895r.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    /* renamed from: G0 */
    public final void mo1466G0(zzm zzmVar) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6428c(m8894q, zzmVar);
        m8896s(4, m8894q);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    /* renamed from: H */
    public final void mo1467H(zzy zzyVar, zzm zzmVar) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6428c(m8894q, zzyVar);
        C1557mj.m6428c(m8894q, zzmVar);
        m8896s(12, m8894q);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    /* renamed from: L0 */
    public final void mo1468L0(zzaq zzaqVar, zzm zzmVar) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6428c(m8894q, zzaqVar);
        C1557mj.m6428c(m8894q, zzmVar);
        m8896s(1, m8894q);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    /* renamed from: P */
    public final void mo1469P(zzm zzmVar) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6428c(m8894q, zzmVar);
        m8896s(18, m8894q);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    /* renamed from: R */
    public final List<zzy> mo1470R(String str, String str2, zzm zzmVar) throws RemoteException {
        Parcel m8894q = m8894q();
        m8894q.writeString(str);
        m8894q.writeString(str2);
        C1557mj.m6428c(m8894q, zzmVar);
        Parcel m8895r = m8895r(16, m8894q);
        ArrayList createTypedArrayList = m8895r.createTypedArrayList(zzy.CREATOR);
        m8895r.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    /* renamed from: X */
    public final void mo1471X(zzy zzyVar) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6428c(m8894q, zzyVar);
        m8896s(13, m8894q);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    /* renamed from: Y */
    public final List<zzkn> mo1472Y(String str, String str2, boolean z, zzm zzmVar) throws RemoteException {
        Parcel m8894q = m8894q();
        m8894q.writeString(str);
        m8894q.writeString(str2);
        C1557mj.m6429d(m8894q, z);
        C1557mj.m6428c(m8894q, zzmVar);
        Parcel m8895r = m8895r(14, m8894q);
        ArrayList createTypedArrayList = m8895r.createTypedArrayList(zzkn.CREATOR);
        m8895r.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    /* renamed from: a0 */
    public final void mo1473a0(long j, String str, String str2, String str3) throws RemoteException {
        Parcel m8894q = m8894q();
        m8894q.writeLong(j);
        m8894q.writeString(str);
        m8894q.writeString(str2);
        m8894q.writeString(str3);
        m8896s(10, m8894q);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    /* renamed from: c0 */
    public final List<zzy> mo1474c0(String str, String str2, String str3) throws RemoteException {
        Parcel m8894q = m8894q();
        m8894q.writeString(str);
        m8894q.writeString(str2);
        m8894q.writeString(str3);
        Parcel m8895r = m8895r(17, m8894q);
        ArrayList createTypedArrayList = m8895r.createTypedArrayList(zzy.CREATOR);
        m8895r.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    /* renamed from: h0 */
    public final void mo1475h0(zzkn zzknVar, zzm zzmVar) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6428c(m8894q, zzknVar);
        C1557mj.m6428c(m8894q, zzmVar);
        m8896s(2, m8894q);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    /* renamed from: o0 */
    public final void mo1476o0(zzm zzmVar) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6428c(m8894q, zzmVar);
        m8896s(6, m8894q);
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    /* renamed from: v */
    public final byte[] mo1477v(zzaq zzaqVar, String str) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6428c(m8894q, zzaqVar);
        m8894q.writeString(str);
        Parcel m8895r = m8895r(9, m8894q);
        byte[] createByteArray = m8895r.createByteArray();
        m8895r.recycle();
        return createByteArray;
    }

    @Override // com.google.android.gms.measurement.internal.zzel
    /* renamed from: v0 */
    public final String mo1478v0(zzm zzmVar) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6428c(m8894q, zzmVar);
        Parcel m8895r = m8895r(11, m8894q);
        String readString = m8895r.readString();
        m8895r.recycle();
        return readString;
    }
}
