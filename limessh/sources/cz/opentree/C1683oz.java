package cz.opentree;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import androidx.annotation.MainThread;
import com.google.android.gms.measurement.internal.zzfs;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.oz */
/* loaded from: classes.dex */
public final class C1683oz {

    /* renamed from: a */
    public final zzfs f5581a;

    public C1683oz(zzfs zzfsVar) {
        C0813ca.m2729k(zzfsVar);
        this.f5581a = zzfsVar;
    }

    /* renamed from: b */
    public static boolean m7134b(Context context) {
        ActivityInfo receiverInfo;
        C0813ca.m2729k(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    @MainThread
    /* renamed from: a */
    public final void m7135a(Context context, Intent intent) {
        C2144uz m9091a = C2144uz.m9091a(context, null, null);
        C1889sy mo1484j = m9091a.mo1484j();
        if (intent == null) {
            mo1484j.m8525K().m9083a("Receiver called with null intent");
            return;
        }
        m9091a.mo1480f();
        String action = intent.getAction();
        mo1484j.m8530P().m9084b("Local receiver got", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                mo1484j.m8525K().m9083a("Install Referrer Broadcasts are deprecated");
            }
        } else {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            mo1484j.m8530P().m9083a("Starting wakeful intent.");
            this.f5581a.mo1446a(context, className);
        }
    }
}
