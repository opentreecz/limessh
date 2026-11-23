package com.sonelli;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.internal.measurement.zzy;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.ut */
/* loaded from: classes.dex */
public abstract class AbstractBinderC2043ut extends BinderC2357yk implements zzr {
    public AbstractBinderC2043ut() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzr asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return queryLocalInterface instanceof zzr ? (zzr) queryLocalInterface : new C2186vt(iBinder);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0005. Please report as an issue. */
    @Override // com.sonelli.BinderC2357yk
    /* renamed from: q */
    public final boolean mo6818q(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzs c2242wt;
        zzs zzsVar = null;
        zzs zzsVar2 = null;
        zzs zzsVar3 = null;
        zzx zzxVar = null;
        zzx zzxVar2 = null;
        zzx zzxVar3 = null;
        zzs zzsVar4 = null;
        zzs zzsVar5 = null;
        zzs zzsVar6 = null;
        zzs zzsVar7 = null;
        zzs zzsVar8 = null;
        zzs zzsVar9 = null;
        zzy zzyVar = null;
        zzs zzsVar10 = null;
        zzs zzsVar11 = null;
        zzs zzsVar12 = null;
        zzs zzsVar13 = null;
        switch (i) {
            case 1:
                initialize(IObjectWrapper.AbstractBinderC0446a.m1181r(parcel.readStrongBinder()), (zzaa) C1557mj.m6426a(parcel, zzaa.CREATOR), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 2:
                logEvent(parcel.readString(), parcel.readString(), (Bundle) C1557mj.m6426a(parcel, Bundle.CREATOR), C1557mj.m6430e(parcel), C1557mj.m6430e(parcel), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 3:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) C1557mj.m6426a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    c2242wt = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c2242wt = queryLocalInterface instanceof zzs ? (zzs) queryLocalInterface : new C2242wt(readStrongBinder);
                }
                logEventAndBundle(readString, readString2, bundle, c2242wt, parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 4:
                setUserProperty(parcel.readString(), parcel.readString(), IObjectWrapper.AbstractBinderC0446a.m1181r(parcel.readStrongBinder()), C1557mj.m6430e(parcel), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 5:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                boolean m6430e = C1557mj.m6430e(parcel);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzsVar = queryLocalInterface2 instanceof zzs ? (zzs) queryLocalInterface2 : new C2242wt(readStrongBinder2);
                }
                getUserProperties(readString3, readString4, m6430e, zzsVar);
                parcel2.writeNoException();
                return true;
            case 6:
                String readString5 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzsVar13 = queryLocalInterface3 instanceof zzs ? (zzs) queryLocalInterface3 : new C2242wt(readStrongBinder3);
                }
                getMaxUserProperties(readString5, zzsVar13);
                parcel2.writeNoException();
                return true;
            case 7:
                setUserId(parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 8:
                setConditionalUserProperty((Bundle) C1557mj.m6426a(parcel, Bundle.CREATOR), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 9:
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) C1557mj.m6426a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 10:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzsVar12 = queryLocalInterface4 instanceof zzs ? (zzs) queryLocalInterface4 : new C2242wt(readStrongBinder4);
                }
                getConditionalUserProperties(readString6, readString7, zzsVar12);
                parcel2.writeNoException();
                return true;
            case 11:
                setMeasurementEnabled(C1557mj.m6430e(parcel), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 12:
                resetAnalyticsData(parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 13:
                setMinimumSessionDuration(parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 14:
                setSessionTimeoutDuration(parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 15:
                setCurrentScreen(IObjectWrapper.AbstractBinderC0446a.m1181r(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzsVar11 = queryLocalInterface5 instanceof zzs ? (zzs) queryLocalInterface5 : new C2242wt(readStrongBinder5);
                }
                getCurrentScreenName(zzsVar11);
                parcel2.writeNoException();
                return true;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzsVar10 = queryLocalInterface6 instanceof zzs ? (zzs) queryLocalInterface6 : new C2242wt(readStrongBinder6);
                }
                getCurrentScreenClass(zzsVar10);
                parcel2.writeNoException();
                return true;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    zzyVar = queryLocalInterface7 instanceof zzy ? (zzy) queryLocalInterface7 : new C2171vi(readStrongBinder7);
                }
                setInstanceIdProvider(zzyVar);
                parcel2.writeNoException();
                return true;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzsVar9 = queryLocalInterface8 instanceof zzs ? (zzs) queryLocalInterface8 : new C2242wt(readStrongBinder8);
                }
                getCachedAppInstanceId(zzsVar9);
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzsVar8 = queryLocalInterface9 instanceof zzs ? (zzs) queryLocalInterface9 : new C2242wt(readStrongBinder9);
                }
                getAppInstanceId(zzsVar8);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzsVar7 = queryLocalInterface10 instanceof zzs ? (zzs) queryLocalInterface10 : new C2242wt(readStrongBinder10);
                }
                getGmpAppId(zzsVar7);
                parcel2.writeNoException();
                return true;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzsVar6 = queryLocalInterface11 instanceof zzs ? (zzs) queryLocalInterface11 : new C2242wt(readStrongBinder11);
                }
                generateEventId(zzsVar6);
                parcel2.writeNoException();
                return true;
            case 23:
                beginAdUnitExposure(parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 24:
                endAdUnitExposure(parcel.readString(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 25:
                onActivityStarted(IObjectWrapper.AbstractBinderC0446a.m1181r(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 26:
                onActivityStopped(IObjectWrapper.AbstractBinderC0446a.m1181r(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 27:
                onActivityCreated(IObjectWrapper.AbstractBinderC0446a.m1181r(parcel.readStrongBinder()), (Bundle) C1557mj.m6426a(parcel, Bundle.CREATOR), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 28:
                onActivityDestroyed(IObjectWrapper.AbstractBinderC0446a.m1181r(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 29:
                onActivityPaused(IObjectWrapper.AbstractBinderC0446a.m1181r(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 30:
                onActivityResumed(IObjectWrapper.AbstractBinderC0446a.m1181r(parcel.readStrongBinder()), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 31:
                IObjectWrapper m1181r = IObjectWrapper.AbstractBinderC0446a.m1181r(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzsVar5 = queryLocalInterface12 instanceof zzs ? (zzs) queryLocalInterface12 : new C2242wt(readStrongBinder12);
                }
                onActivitySaveInstanceState(m1181r, zzsVar5, parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 32:
                Bundle bundle2 = (Bundle) C1557mj.m6426a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzsVar4 = queryLocalInterface13 instanceof zzs ? (zzs) queryLocalInterface13 : new C2242wt(readStrongBinder13);
                }
                performAction(bundle2, zzsVar4, parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 33:
                logHealthData(parcel.readInt(), parcel.readString(), IObjectWrapper.AbstractBinderC0446a.m1181r(parcel.readStrongBinder()), IObjectWrapper.AbstractBinderC0446a.m1181r(parcel.readStrongBinder()), IObjectWrapper.AbstractBinderC0446a.m1181r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzxVar3 = queryLocalInterface14 instanceof zzx ? (zzx) queryLocalInterface14 : new C2441zt(readStrongBinder14);
                }
                setEventInterceptor(zzxVar3);
                parcel2.writeNoException();
                return true;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzxVar2 = queryLocalInterface15 instanceof zzx ? (zzx) queryLocalInterface15 : new C2441zt(readStrongBinder15);
                }
                registerOnMeasurementEventListener(zzxVar2);
                parcel2.writeNoException();
                return true;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzxVar = queryLocalInterface16 instanceof zzx ? (zzx) queryLocalInterface16 : new C2441zt(readStrongBinder16);
                }
                unregisterOnMeasurementEventListener(zzxVar);
                parcel2.writeNoException();
                return true;
            case 37:
                initForTests(C1557mj.m6431f(parcel));
                parcel2.writeNoException();
                return true;
            case 38:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzsVar3 = queryLocalInterface17 instanceof zzs ? (zzs) queryLocalInterface17 : new C2242wt(readStrongBinder17);
                }
                getTestFlag(zzsVar3, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 39:
                setDataCollectionEnabled(C1557mj.m6430e(parcel));
                parcel2.writeNoException();
                return true;
            case 40:
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzsVar2 = queryLocalInterface18 instanceof zzs ? (zzs) queryLocalInterface18 : new C2242wt(readStrongBinder18);
                }
                isDataCollectionEnabled(zzsVar2);
                parcel2.writeNoException();
                return true;
            case 41:
            default:
                return false;
            case 42:
                setDefaultEventParameters((Bundle) C1557mj.m6426a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
