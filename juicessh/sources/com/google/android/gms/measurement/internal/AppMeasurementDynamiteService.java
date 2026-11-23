package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzx;
import com.j256.ormlite.field.FieldType;
import com.sonelli.AbstractBinderC2043ut;
import com.sonelli.BinderC1548md;
import com.sonelli.C0813ca;
import com.sonelli.C2144uz;
import com.sonelli.g10;
import com.sonelli.g40;
import com.sonelli.k40;
import com.sonelli.r10;
import com.sonelli.s20;
import com.sonelli.s30;
import com.sonelli.t10;
import com.sonelli.w00;
import com.sonelli.y00;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
@DynamiteApi
/* loaded from: classes.dex */
public class AppMeasurementDynamiteService extends AbstractBinderC2043ut {

    /* renamed from: a */
    public C2144uz f979a = null;

    /* renamed from: b */
    public Map<Integer, zzha> f980b = new ArrayMap();

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
    /* renamed from: com.google.android.gms.measurement.internal.AppMeasurementDynamiteService$a */
    /* loaded from: classes.dex */
    public class C0451a implements zzgx {

        /* renamed from: a */
        public zzx f981a;

        public C0451a(zzx zzxVar) {
            this.f981a = zzxVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzgx
        /* renamed from: a */
        public final void mo1450a(String str, String str2, Bundle bundle, long j) {
            try {
                this.f981a.mo1435s0(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.f979a.mo1484j().m8525K().m9084b("Event interceptor threw exception", e);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
    /* renamed from: com.google.android.gms.measurement.internal.AppMeasurementDynamiteService$b */
    /* loaded from: classes.dex */
    public class C0452b implements zzha {

        /* renamed from: a */
        public zzx f983a;

        public C0452b(zzx zzxVar) {
            this.f983a = zzxVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzha
        /* renamed from: a */
        public final void mo1451a(String str, String str2, Bundle bundle, long j) {
            try {
                this.f983a.mo1435s0(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.f979a.mo1484j().m8525K().m9084b("Event listener threw exception", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        m1448r();
        this.f979a.m9114T().m9887A(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        m1448r();
        this.f979a.m9101G().m10040y0(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void endAdUnitExposure(String str, long j) throws RemoteException {
        m1448r();
        this.f979a.m9114T().m9890E(str, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void generateEventId(zzs zzsVar) throws RemoteException {
        m1448r();
        this.f979a.m9102H().m4030P(zzsVar, this.f979a.m9102H().m4014D0());
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getAppInstanceId(zzs zzsVar) throws RemoteException {
        m1448r();
        this.f979a.mo1481g().m8281A(new t10(this, zzsVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getCachedAppInstanceId(zzs zzsVar) throws RemoteException {
        m1448r();
        m1449s(zzsVar, this.f979a.m9101G().m10023g0());
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getConditionalUserProperties(String str, String str2, zzs zzsVar) throws RemoteException {
        m1448r();
        this.f979a.mo1481g().m8281A(new s20(this, zzsVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getCurrentScreenClass(zzs zzsVar) throws RemoteException {
        m1448r();
        m1449s(zzsVar, this.f979a.m9101G().m10026j0());
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getCurrentScreenName(zzs zzsVar) throws RemoteException {
        m1448r();
        m1449s(zzsVar, this.f979a.m9101G().m10025i0());
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getGmpAppId(zzs zzsVar) throws RemoteException {
        m1448r();
        m1449s(zzsVar, this.f979a.m9101G().m10027k0());
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getMaxUserProperties(String str, zzs zzsVar) throws RemoteException {
        m1448r();
        this.f979a.m9101G();
        C0813ca.m2725g(str);
        this.f979a.m9102H().m4029O(zzsVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getTestFlag(zzs zzsVar, int i) throws RemoteException {
        m1448r();
        if (i == 0) {
            this.f979a.m9102H().m4032R(zzsVar, this.f979a.m9101G().m10019c0());
            return;
        }
        if (i == 1) {
            this.f979a.m9102H().m4030P(zzsVar, this.f979a.m9101G().m10020d0().longValue());
            return;
        }
        if (i != 2) {
            if (i == 3) {
                this.f979a.m9102H().m4029O(zzsVar, this.f979a.m9101G().m10021e0().intValue());
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this.f979a.m9102H().m4034T(zzsVar, this.f979a.m9101G().m10018b0().booleanValue());
                return;
            }
        }
        g40 m9102H = this.f979a.m9102H();
        double doubleValue = this.f979a.m9101G().m10022f0().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", doubleValue);
        try {
            zzsVar.mo1433j(bundle);
        } catch (RemoteException e) {
            m9102H.f5899a.mo1484j().m8525K().m9084b("Error returning double value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void getUserProperties(String str, String str2, boolean z, zzs zzsVar) throws RemoteException {
        m1448r();
        this.f979a.mo1481g().m8281A(new s30(this, zzsVar, str, str2, z));
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void initForTests(Map map) throws RemoteException {
        m1448r();
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void initialize(IObjectWrapper iObjectWrapper, zzaa zzaaVar, long j) throws RemoteException {
        Context context = (Context) BinderC1548md.m6403s(iObjectWrapper);
        C2144uz c2144uz = this.f979a;
        if (c2144uz == null) {
            this.f979a = C2144uz.m9091a(context, zzaaVar, Long.valueOf(j));
        } else {
            c2144uz.mo1484j().m8525K().m9083a("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void isDataCollectionEnabled(zzs zzsVar) throws RemoteException {
        m1448r();
        this.f979a.mo1481g().m8281A(new k40(this, zzsVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        m1448r();
        this.f979a.m9101G().m10011U(str, str2, bundle, z, z2, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void logEventAndBundle(String str, String str2, Bundle bundle, zzs zzsVar, long j) throws RemoteException {
        m1448r();
        C0813ca.m2725g(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.f979a.mo1481g().m8281A(new w00(this, zzsVar, new zzaq(str2, new zzal(bundle), "app", j), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        m1448r();
        this.f979a.mo1484j().m8519C(i, true, false, str, iObjectWrapper == null ? null : BinderC1548md.m6403s(iObjectWrapper), iObjectWrapper2 == null ? null : BinderC1548md.m6403s(iObjectWrapper2), iObjectWrapper3 != null ? BinderC1548md.m6403s(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        m1448r();
        r10 r10Var = this.f979a.m9101G().f8096c;
        if (r10Var != null) {
            this.f979a.m9101G().m10017a0();
            r10Var.onActivityCreated((Activity) BinderC1548md.m6403s(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        m1448r();
        r10 r10Var = this.f979a.m9101G().f8096c;
        if (r10Var != null) {
            this.f979a.m9101G().m10017a0();
            r10Var.onActivityDestroyed((Activity) BinderC1548md.m6403s(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        m1448r();
        r10 r10Var = this.f979a.m9101G().f8096c;
        if (r10Var != null) {
            this.f979a.m9101G().m10017a0();
            r10Var.onActivityPaused((Activity) BinderC1548md.m6403s(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        m1448r();
        r10 r10Var = this.f979a.m9101G().f8096c;
        if (r10Var != null) {
            this.f979a.m9101G().m10017a0();
            r10Var.onActivityResumed((Activity) BinderC1548md.m6403s(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzs zzsVar, long j) throws RemoteException {
        m1448r();
        r10 r10Var = this.f979a.m9101G().f8096c;
        Bundle bundle = new Bundle();
        if (r10Var != null) {
            this.f979a.m9101G().m10017a0();
            r10Var.onActivitySaveInstanceState((Activity) BinderC1548md.m6403s(iObjectWrapper), bundle);
        }
        try {
            zzsVar.mo1433j(bundle);
        } catch (RemoteException e) {
            this.f979a.mo1484j().m8525K().m9084b("Error returning bundle value to wrapper", e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        m1448r();
        r10 r10Var = this.f979a.m9101G().f8096c;
        if (r10Var != null) {
            this.f979a.m9101G().m10017a0();
            r10Var.onActivityStarted((Activity) BinderC1548md.m6403s(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        m1448r();
        r10 r10Var = this.f979a.m9101G().f8096c;
        if (r10Var != null) {
            this.f979a.m9101G().m10017a0();
            r10Var.onActivityStopped((Activity) BinderC1548md.m6403s(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void performAction(Bundle bundle, zzs zzsVar, long j) throws RemoteException {
        m1448r();
        zzsVar.mo1433j(null);
    }

    /* renamed from: r */
    public final void m1448r() {
        if (this.f979a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void registerOnMeasurementEventListener(zzx zzxVar) throws RemoteException {
        m1448r();
        zzha zzhaVar = this.f980b.get(Integer.valueOf(zzxVar.mo1434a()));
        if (zzhaVar == null) {
            zzhaVar = new C0452b(zzxVar);
            this.f980b.put(Integer.valueOf(zzxVar.mo1434a()), zzhaVar);
        }
        this.f979a.m9101G().m10004K(zzhaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void resetAnalyticsData(long j) throws RemoteException {
        m1448r();
        this.f979a.m9101G().m10041z0(j);
    }

    /* renamed from: s */
    public final void m1449s(zzs zzsVar, String str) {
        this.f979a.m9102H().m4032R(zzsVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        m1448r();
        if (bundle == null) {
            this.f979a.mo1484j().m8522H().m9083a("Conditional user property must not be null");
        } else {
            this.f979a.m9101G().m10002I(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        m1448r();
        this.f979a.m9110P().m1965J((Activity) BinderC1548md.m6403s(iObjectWrapper), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        m1448r();
        this.f979a.m9101G().m10038w0(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setDefaultEventParameters(Bundle bundle) {
        m1448r();
        final y00 m9101G = this.f979a.m9101G();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        m9101G.mo1481g().m8281A(new Runnable(m9101G, bundle2) { // from class: com.sonelli.x00

            /* renamed from: O */
            public final y00 f7835O;

            /* renamed from: P */
            public final Bundle f7836P;

            {
                this.f7835O = m9101G;
                this.f7836P = bundle2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                y00 y00Var = this.f7835O;
                Bundle bundle3 = this.f7836P;
                if (C1174is.m4913b() && y00Var.m7590o().m2630u(C1735pu.f5809P0)) {
                    if (bundle3 == null) {
                        y00Var.m7589n().f2557D.m5747b(new Bundle());
                        return;
                    }
                    Bundle m5746a = y00Var.m7589n().f2557D.m5746a();
                    for (String str : bundle3.keySet()) {
                        Object obj = bundle3.get(str);
                        if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                            y00Var.m7588m();
                            if (g40.m3995b0(obj)) {
                                y00Var.m7588m().m4023K(27, null, null, 0);
                            }
                            y00Var.mo1484j().m8527M().m9085c("Invalid default event parameter type. Name, value", str, obj);
                        } else if (g40.m3984B0(str)) {
                            y00Var.mo1484j().m8527M().m9084b("Invalid default event parameter name. Name", str);
                        } else if (obj == null) {
                            m5746a.remove(str);
                        } else if (y00Var.m7588m().m4041g0("param", str, 100, obj)) {
                            y00Var.m7588m().m4027N(m5746a, str, obj);
                        }
                    }
                    y00Var.m7588m();
                    if (g40.m3993Z(m5746a, y00Var.m7590o().m2608B())) {
                        y00Var.m7588m().m4023K(26, null, null, 0);
                        y00Var.mo1484j().m8527M().m9083a("Too many default event parameters set. Discarding beyond event parameter limit");
                    }
                    y00Var.m7589n().f2557D.m5747b(m5746a);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setEventInterceptor(zzx zzxVar) throws RemoteException {
        m1448r();
        y00 m9101G = this.f979a.m9101G();
        C0451a c0451a = new C0451a(zzxVar);
        m9101G.mo7583b();
        m9101G.m2299y();
        m9101G.mo1481g().m8281A(new g10(m9101G, c0451a));
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzy zzyVar) throws RemoteException {
        m1448r();
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        m1448r();
        this.f979a.m9101G().m10016Z(z);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setMinimumSessionDuration(long j) throws RemoteException {
        m1448r();
        this.f979a.m9101G().m10000G(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setSessionTimeoutDuration(long j) throws RemoteException {
        m1448r();
        this.f979a.m9101G().m10031o0(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setUserId(String str, long j) throws RemoteException {
        m1448r();
        this.f979a.m9101G().m10014X(null, FieldType.FOREIGN_ID_FIELD_SUFFIX, str, true, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        m1448r();
        this.f979a.m9101G().m10014X(str, str2, BinderC1548md.m6403s(iObjectWrapper), z, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public void unregisterOnMeasurementEventListener(zzx zzxVar) throws RemoteException {
        m1448r();
        zzha remove = this.f980b.remove(Integer.valueOf(zzxVar.mo1434a()));
        if (remove == null) {
            remove = new C0452b(zzxVar);
        }
        this.f979a.m9101G().m10034r0(remove);
    }
}
