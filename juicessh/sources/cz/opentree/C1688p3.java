package cz.opentree;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads_identifier.zze;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* renamed from: cz.opentree.p3 */
/* loaded from: classes.dex */
public class C1688p3 {

    /* renamed from: a */
    @Nullable
    @GuardedBy("this")
    public ServiceConnectionC2154v6 f5601a;

    /* renamed from: b */
    @Nullable
    @GuardedBy("this")
    public zze f5602b;

    /* renamed from: c */
    @GuardedBy("this")
    public boolean f5603c;

    /* renamed from: d */
    public final Object f5604d = new Object();

    /* renamed from: e */
    @Nullable
    @GuardedBy("mAutoDisconnectTaskLock")
    public b f5605e;

    /* renamed from: f */
    @GuardedBy("this")
    public final Context f5606f;

    /* renamed from: g */
    public final boolean f5607g;

    /* renamed from: h */
    public final long f5608h;

    /* renamed from: cz.opentree.p3$a */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public final String f5609a;

        /* renamed from: b */
        public final boolean f5610b;

        public a(String str, boolean z) {
            this.f5609a = str;
            this.f5610b = z;
        }

        /* renamed from: a */
        public final String m7239a() {
            return this.f5609a;
        }

        /* renamed from: b */
        public final boolean m7240b() {
            return this.f5610b;
        }

        public final String toString() {
            String str = this.f5609a;
            boolean z = this.f5610b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    /* renamed from: cz.opentree.p3$b */
    /* loaded from: classes.dex */
    public static class b extends Thread {

        /* renamed from: O */
        public WeakReference<C1688p3> f5611O;

        /* renamed from: P */
        public long f5612P;

        /* renamed from: Q */
        public CountDownLatch f5613Q = new CountDownLatch(1);

        /* renamed from: R */
        public boolean f5614R = false;

        public b(C1688p3 c1688p3, long j) {
            this.f5611O = new WeakReference<>(c1688p3);
            this.f5612P = j;
            start();
        }

        /* renamed from: a */
        public final void m7241a() {
            C1688p3 c1688p3 = this.f5611O.get();
            if (c1688p3 != null) {
                c1688p3.m7234a();
                this.f5614R = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (this.f5613Q.await(this.f5612P, TimeUnit.MILLISECONDS)) {
                    return;
                }
                m7241a();
            } catch (InterruptedException unused) {
                m7241a();
            }
        }
    }

    public C1688p3(Context context, long j, boolean z, boolean z2) {
        Context applicationContext;
        C0813ca.m2729k(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f5606f = context;
        this.f5603c = false;
        this.f5608h = j;
        this.f5607g = z2;
    }

    /* renamed from: b */
    public static a m7230b(Context context) throws IOException, IllegalStateException, C2413z6, C0697a7 {
        C1798r3 c1798r3 = new C1798r3(context);
        boolean m7853a = c1798r3.m7853a("gads:ad_id_app_context:enabled", false);
        float m7854b = c1798r3.m7854b("gads:ad_id_app_context:ping_ratio", 0.0f);
        String m7855c = c1798r3.m7855c("gads:ad_id_use_shared_preference:experiment_id", "");
        C1688p3 c1688p3 = new C1688p3(context, -1L, m7853a, c1798r3.m7853a("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            c1688p3.m7237h(false);
            a m7235c = c1688p3.m7235c();
            c1688p3.m7238i(m7235c, m7853a, m7854b, SystemClock.elapsedRealtime() - elapsedRealtime, m7855c, null);
            return m7235c;
        } finally {
        }
    }

    /* renamed from: d */
    public static void m7231d(boolean z) {
    }

    /* renamed from: e */
    public static ServiceConnectionC2154v6 m7232e(Context context, boolean z) throws IOException, C2413z6, C0697a7 {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int mo9713h = C2326y6.m10090f().mo9713h(context, C0810c7.f1875a);
            if (mo9713h != 0 && mo9713h != 2) {
                throw new IOException("Google Play services not available");
            }
            String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
            ServiceConnectionC2154v6 serviceConnectionC2154v6 = new ServiceConnectionC2154v6();
            Intent intent = new Intent(str);
            intent.setPackage("com.google.android.gms");
            try {
                if (C1926tb.m8637b().m8638a(context, intent, serviceConnectionC2154v6, 1)) {
                    return serviceConnectionC2154v6;
                }
                throw new IOException("Connection failure");
            } catch (Throwable th) {
                throw new IOException(th);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            throw new C2413z6(9);
        }
    }

    /* renamed from: f */
    public static zze m7233f(Context context, ServiceConnectionC2154v6 serviceConnectionC2154v6) throws IOException {
        try {
            return AbstractBinderC2340yd.m10124q(serviceConnectionC2154v6.m9171a(10000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    /* renamed from: a */
    public final void m7234a() {
        C0813ca.m2728j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f5606f == null || this.f5601a == null) {
                return;
            }
            try {
                if (this.f5603c) {
                    C1926tb.m8637b().m8639c(this.f5606f, this.f5601a);
                }
            } catch (Throwable th) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
            }
            this.f5603c = false;
            this.f5602b = null;
            this.f5601a = null;
        }
    }

    /* renamed from: c */
    public a m7235c() throws IOException {
        a aVar;
        C0813ca.m2728j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f5603c) {
                synchronized (this.f5604d) {
                    b bVar = this.f5605e;
                    if (bVar == null || !bVar.f5614R) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    m7237h(false);
                    if (!this.f5603c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                }
            }
            C0813ca.m2729k(this.f5601a);
            C0813ca.m2729k(this.f5602b);
            try {
                aVar = new a(this.f5602b.getId(), this.f5602b.mo1205m(true));
            } catch (RemoteException e2) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                throw new IOException("Remote exception");
            }
        }
        m7236g();
        return aVar;
    }

    public void finalize() throws Throwable {
        m7234a();
        super.finalize();
    }

    /* renamed from: g */
    public final void m7236g() {
        synchronized (this.f5604d) {
            b bVar = this.f5605e;
            if (bVar != null) {
                bVar.f5613Q.countDown();
                try {
                    this.f5605e.join();
                } catch (InterruptedException unused) {
                }
            }
            if (this.f5608h > 0) {
                this.f5605e = new b(this, this.f5608h);
            }
        }
    }

    /* renamed from: h */
    public final void m7237h(boolean z) throws IOException, IllegalStateException, C2413z6, C0697a7 {
        C0813ca.m2728j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f5603c) {
                m7234a();
            }
            ServiceConnectionC2154v6 m7232e = m7232e(this.f5606f, this.f5607g);
            this.f5601a = m7232e;
            this.f5602b = m7233f(this.f5606f, m7232e);
            this.f5603c = true;
            if (z) {
                m7236g();
            }
        }
    }

    /* renamed from: i */
    public final boolean m7238i(a aVar, boolean z, float f, long j, String str, Throwable th) {
        if (Math.random() > f) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("app_context", z ? "1" : "0");
        if (aVar != null) {
            hashMap.put("limit_ad_tracking", aVar.m7240b() ? "1" : "0");
        }
        if (aVar != null && aVar.m7239a() != null) {
            hashMap.put("ad_id_size", Integer.toString(aVar.m7239a().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new C1746q3(this, hashMap).start();
        return true;
    }
}
