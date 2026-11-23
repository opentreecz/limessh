package cz.opentree;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.vt */
/* loaded from: classes.dex */
public final class C2186vt extends C2011ui implements zzr {
    public C2186vt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel m8894q = m8894q();
        m8894q.writeString(str);
        m8894q.writeLong(j);
        m8896s(23, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel m8894q = m8894q();
        m8894q.writeString(str);
        m8894q.writeString(str2);
        C1557mj.m6428c(m8894q, bundle);
        m8896s(9, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel m8894q = m8894q();
        m8894q.writeString(str);
        m8894q.writeLong(j);
        m8896s(24, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void generateEventId(zzs zzsVar) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6427b(m8894q, zzsVar);
        m8896s(22, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void getCachedAppInstanceId(zzs zzsVar) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6427b(m8894q, zzsVar);
        m8896s(19, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void getConditionalUserProperties(String str, String str2, zzs zzsVar) throws RemoteException {
        Parcel m8894q = m8894q();
        m8894q.writeString(str);
        m8894q.writeString(str2);
        C1557mj.m6427b(m8894q, zzsVar);
        m8896s(10, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void getCurrentScreenClass(zzs zzsVar) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6427b(m8894q, zzsVar);
        m8896s(17, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void getCurrentScreenName(zzs zzsVar) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6427b(m8894q, zzsVar);
        m8896s(16, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void getGmpAppId(zzs zzsVar) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6427b(m8894q, zzsVar);
        m8896s(21, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void getMaxUserProperties(String str, zzs zzsVar) throws RemoteException {
        Parcel m8894q = m8894q();
        m8894q.writeString(str);
        C1557mj.m6427b(m8894q, zzsVar);
        m8896s(6, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void getUserProperties(String str, String str2, boolean z, zzs zzsVar) throws RemoteException {
        Parcel m8894q = m8894q();
        m8894q.writeString(str);
        m8894q.writeString(str2);
        C1557mj.m6429d(m8894q, z);
        C1557mj.m6427b(m8894q, zzsVar);
        m8896s(5, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void initialize(IObjectWrapper iObjectWrapper, zzaa zzaaVar, long j) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6427b(m8894q, iObjectWrapper);
        C1557mj.m6428c(m8894q, zzaaVar);
        m8894q.writeLong(j);
        m8896s(1, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        Parcel m8894q = m8894q();
        m8894q.writeString(str);
        m8894q.writeString(str2);
        C1557mj.m6428c(m8894q, bundle);
        C1557mj.m6429d(m8894q, z);
        C1557mj.m6429d(m8894q, z2);
        m8894q.writeLong(j);
        m8896s(2, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel m8894q = m8894q();
        m8894q.writeInt(i);
        m8894q.writeString(str);
        C1557mj.m6427b(m8894q, iObjectWrapper);
        C1557mj.m6427b(m8894q, iObjectWrapper2);
        C1557mj.m6427b(m8894q, iObjectWrapper3);
        m8896s(33, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6427b(m8894q, iObjectWrapper);
        C1557mj.m6428c(m8894q, bundle);
        m8894q.writeLong(j);
        m8896s(27, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6427b(m8894q, iObjectWrapper);
        m8894q.writeLong(j);
        m8896s(28, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6427b(m8894q, iObjectWrapper);
        m8894q.writeLong(j);
        m8896s(29, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6427b(m8894q, iObjectWrapper);
        m8894q.writeLong(j);
        m8896s(30, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzs zzsVar, long j) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6427b(m8894q, iObjectWrapper);
        C1557mj.m6427b(m8894q, zzsVar);
        m8894q.writeLong(j);
        m8896s(31, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6427b(m8894q, iObjectWrapper);
        m8894q.writeLong(j);
        m8896s(25, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6427b(m8894q, iObjectWrapper);
        m8894q.writeLong(j);
        m8896s(26, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void registerOnMeasurementEventListener(zzx zzxVar) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6427b(m8894q, zzxVar);
        m8896s(35, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6428c(m8894q, bundle);
        m8894q.writeLong(j);
        m8896s(8, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6427b(m8894q, iObjectWrapper);
        m8894q.writeString(str);
        m8894q.writeString(str2);
        m8894q.writeLong(j);
        m8896s(15, m8894q);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6429d(m8894q, z);
        m8896s(39, m8894q);
    }
}
