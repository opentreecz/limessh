package cz.opentree;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.internal.measurement.zzd;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.mz */
/* loaded from: classes.dex */
public final class ServiceConnectionC1579mz implements ServiceConnection {

    /* renamed from: a */
    public final String f5162a;

    /* renamed from: b */
    public final /* synthetic */ C1626nz f5163b;

    public ServiceConnectionC1579mz(C1626nz c1626nz, String str) {
        this.f5163b = c1626nz;
        this.f5162a = str;
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f5163b.f5391a.mo1484j().m8525K().m9083a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            zzd m5173r = AbstractBinderC1229jo.m5173r(iBinder);
            if (m5173r == null) {
                this.f5163b.f5391a.mo1484j().m8525K().m9083a("Install Referrer Service implementation was not found");
            } else {
                this.f5163b.f5391a.mo1484j().m8530P().m9083a("Install Referrer Service connected");
                this.f5163b.f5391a.mo1481g().m8281A(new RunnableC1741pz(this, m5173r, this));
            }
        } catch (Exception e) {
            this.f5163b.f5391a.mo1484j().m8525K().m9084b("Exception occurred while calling Install Referrer API", e);
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f5163b.f5391a.mo1484j().m8530P().m9083a("Install Referrer Service disconnected");
    }
}
