package cz.opentree;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.common.zzj;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
@CheckReturnValue
/* renamed from: cz.opentree.ad */
/* loaded from: classes.dex */
public final class C0706ad {

    /* renamed from: a */
    public static volatile zzn f1365a;

    /* renamed from: b */
    public static final Object f1366b = new Object();

    /* renamed from: c */
    public static Context f1367c;

    /* renamed from: a */
    public static C1156id m2040a(String str, AbstractBinderC0763bd abstractBinderC0763bd, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return m2043d(str, abstractBinderC0763bd, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* renamed from: c */
    public static synchronized void m2042c(Context context) {
        synchronized (C0706ad.class) {
            if (f1367c != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f1367c = context.getApplicationContext();
            }
        }
    }

    /* renamed from: d */
    public static C1156id m2043d(final String str, final AbstractBinderC0763bd abstractBinderC0763bd, final boolean z, boolean z2) {
        try {
            if (f1365a == null) {
                C0813ca.m2729k(f1367c);
                synchronized (f1366b) {
                    if (f1365a == null) {
                        f1365a = AbstractBinderC0868db.m3181r(DynamiteModule.m1184d(f1367c, DynamiteModule.f939j, "com.google.android.gms.googlecertificates").m1194c("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            C0813ca.m2729k(f1367c);
            try {
                return f1365a.mo1141E0(new zzj(str, abstractBinderC0763bd, z, z2), BinderC1548md.m6402O0(f1367c.getPackageManager())) ? C1156id.m4749f() : C1156id.m4746c(new Callable(z, str, abstractBinderC0763bd) { // from class: cz.opentree.cd

                    /* renamed from: a */
                    public final boolean f1913a;

                    /* renamed from: b */
                    public final String f1914b;

                    /* renamed from: c */
                    public final AbstractBinderC0763bd f1915c;

                    {
                        this.f1913a = z;
                        this.f1914b = str;
                        this.f1915c = abstractBinderC0763bd;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        String m4748e;
                        m4748e = C1156id.m4748e(this.f1914b, this.f1915c, this.f1913a, !r3 && C0706ad.m2043d(r4, r5, true, false).f3295a);
                        return m4748e;
                    }
                });
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return C1156id.m4745b("module call", e);
            }
        } catch (DynamiteModule.C0448a e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            String valueOf = String.valueOf(e2.getMessage());
            return C1156id.m4745b(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e2);
        }
    }
}
