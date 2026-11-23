package cz.opentree;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class ce0 {

    /* renamed from: e */
    public static ce0 f1923e;

    /* renamed from: a */
    @Nullable
    @GuardedBy("this")
    public String f1924a = null;

    /* renamed from: b */
    public Boolean f1925b = null;

    /* renamed from: c */
    public Boolean f1926c = null;

    /* renamed from: d */
    public final Queue<Intent> f1927d = new ArrayDeque();

    /* renamed from: b */
    public static synchronized ce0 m2778b() {
        ce0 ce0Var;
        synchronized (ce0.class) {
            if (f1923e == null) {
                f1923e = new ce0();
            }
            ce0Var = f1923e;
        }
        return ce0Var;
    }

    @MainThread
    /* renamed from: a */
    public final int m2779a(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Starting service");
        }
        this.f1927d.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return m2781d(context, intent2);
    }

    /* renamed from: c */
    public final boolean m2780c(Context context) {
        if (this.f1925b == null) {
            this.f1925b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f1925b.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f1925b.booleanValue();
    }

    /* renamed from: d */
    public final int m2781d(Context context, Intent intent) {
        ComponentName startService;
        String m2783f = m2783f(context, intent);
        if (m2783f != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(m2783f);
                Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Restricting intent to a specific service: ".concat(valueOf) : new String("Restricting intent to a specific service: "));
            }
            intent.setClassName(context.getPackageName(), m2783f);
        }
        try {
            if (m2780c(context)) {
                startService = je0.m5107a(context, intent);
            } else {
                startService = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (startService != null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (IllegalStateException e) {
            String valueOf2 = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 45);
            sb.append("Failed to start service while in background: ");
            sb.append(valueOf2);
            Log.e("FirebaseInstanceId", sb.toString());
            return 402;
        } catch (SecurityException e2) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e2);
            return 401;
        }
    }

    /* renamed from: e */
    public final boolean m2782e(Context context) {
        if (this.f1926c == null) {
            this.f1926c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f1925b.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f1926c.booleanValue();
    }

    @Nullable
    /* renamed from: f */
    public final synchronized String m2783f(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        String str2 = this.f1924a;
        if (str2 != null) {
            return str2;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService != null && (serviceInfo = resolveService.serviceInfo) != null) {
            if (context.getPackageName().equals(serviceInfo.packageName) && (str = serviceInfo.name) != null) {
                if (str.startsWith(".")) {
                    String valueOf = String.valueOf(context.getPackageName());
                    String valueOf2 = String.valueOf(serviceInfo.name);
                    this.f1924a = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                } else {
                    this.f1924a = serviceInfo.name;
                }
                return this.f1924a;
            }
            String str3 = serviceInfo.packageName;
            String str4 = serviceInfo.name;
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 94 + String.valueOf(str4).length());
            sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
            sb.append(str3);
            sb.append("/");
            sb.append(str4);
            Log.e("FirebaseInstanceId", sb.toString());
            return null;
        }
        Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
        return null;
    }
}
