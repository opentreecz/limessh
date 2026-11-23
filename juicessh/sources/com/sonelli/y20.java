package com.sonelli;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.measurement.internal.zzel;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class y20 implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a */
    public volatile boolean f8114a;

    /* renamed from: b */
    public volatile C1986ty f8115b;

    /* renamed from: c */
    public final /* synthetic */ g20 f8116c;

    public y20(g20 g20Var) {
        this.f8116c = g20Var;
    }

    /* renamed from: c */
    public static /* synthetic */ boolean m10051c(y20 y20Var, boolean z) {
        y20Var.f8114a = false;
        return false;
    }

    @WorkerThread
    /* renamed from: a */
    public final void m10052a() {
        if (this.f8115b != null && (this.f8115b.isConnected() || this.f8115b.m1079d())) {
            this.f8115b.disconnect();
        }
        this.f8115b = null;
    }

    @WorkerThread
    /* renamed from: b */
    public final void m10053b(Intent intent) {
        y20 y20Var;
        this.f8116c.mo7585d();
        Context mo1482h = this.f8116c.mo1482h();
        C1926tb m8637b = C1926tb.m8637b();
        synchronized (this) {
            if (this.f8114a) {
                this.f8116c.mo1484j().m8530P().m9083a("Connection attempt already in progress");
                return;
            }
            this.f8116c.mo1484j().m8530P().m9083a("Using local app measurement service");
            this.f8114a = true;
            y20Var = this.f8116c.f2804c;
            m8637b.m8638a(mo1482h, intent, y20Var, KeycodeConstants.KEYCODE_MEDIA_EJECT);
        }
    }

    @WorkerThread
    /* renamed from: d */
    public final void m10054d() {
        this.f8116c.mo7585d();
        Context mo1482h = this.f8116c.mo1482h();
        synchronized (this) {
            if (this.f8114a) {
                this.f8116c.mo1484j().m8530P().m9083a("Connection attempt already in progress");
                return;
            }
            if (this.f8115b != null && (this.f8115b.m1079d() || this.f8115b.isConnected())) {
                this.f8116c.mo1484j().m8530P().m9083a("Already awaiting connection attempt");
                return;
            }
            this.f8115b = new C1986ty(mo1482h, Looper.getMainLooper(), this, this);
            this.f8116c.mo1484j().m8530P().m9083a("Connecting to remote service");
            this.f8114a = true;
            this.f8115b.m1090p();
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        y20 y20Var;
        C0813ca.m2724f("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f8114a = false;
                this.f8116c.mo1484j().m8522H().m9083a("Service connected with null binder");
                return;
            }
            zzel zzelVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    if (iBinder != null) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                        zzelVar = queryLocalInterface instanceof zzel ? (zzel) queryLocalInterface : new C1578my(iBinder);
                    }
                    this.f8116c.mo1484j().m8530P().m9083a("Bound to IMeasurementService interface");
                } else {
                    this.f8116c.mo1484j().m8522H().m9084b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f8116c.mo1484j().m8522H().m9083a("Service connect failed to get IMeasurementService");
            }
            if (zzelVar == null) {
                this.f8114a = false;
                try {
                    C1926tb m8637b = C1926tb.m8637b();
                    Context mo1482h = this.f8116c.mo1482h();
                    y20Var = this.f8116c.f2804c;
                    m8637b.m8639c(mo1482h, y20Var);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f8116c.mo1481g().m8281A(new b30(this, zzelVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        C0813ca.m2724f("MeasurementServiceConnection.onServiceDisconnected");
        this.f8116c.mo1484j().m8529O().m9083a("Service disconnected");
        this.f8116c.mo1481g().m8281A(new a30(this, componentName));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    @MainThread
    /* renamed from: q */
    public final void mo1101q(int i) {
        C0813ca.m2724f("MeasurementServiceConnection.onConnectionSuspended");
        this.f8116c.mo1484j().m8529O().m9083a("Service connection suspended");
        this.f8116c.mo1481g().m8281A(new c30(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    @MainThread
    /* renamed from: r */
    public final void mo1103r(@NonNull ConnectionResult connectionResult) {
        C0813ca.m2724f("MeasurementServiceConnection.onConnectionFailed");
        C1889sy m9097C = this.f8116c.f5899a.m9097C();
        if (m9097C != null) {
            m9097C.m8525K().m9084b("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f8114a = false;
            this.f8115b = null;
        }
        this.f8116c.mo1481g().m8281A(new f30(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    @MainThread
    /* renamed from: s */
    public final void mo1102s(@Nullable Bundle bundle) {
        C0813ca.m2724f("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.f8116c.mo1481g().m8281A(new d30(this, this.f8115b.m1100z()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f8115b = null;
                this.f8114a = false;
            }
        }
    }
}
