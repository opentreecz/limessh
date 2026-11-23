package com.sonelli;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: GCMRegistrar.java */
/* renamed from: com.sonelli.o3 */
/* loaded from: classes.dex */
public final class C1631o3 {

    /* renamed from: a */
    public static C1586n3 f5410a;

    /* renamed from: b */
    public static String f5411b;

    /* renamed from: a */
    public static void m6842a(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 8) {
            try {
                context.getPackageManager().getPackageInfo("com.google.android.gsf", 0);
            } catch (PackageManager.NameNotFoundException unused) {
                throw new UnsupportedOperationException("Device does not have package com.google.android.gsf");
            }
        } else {
            throw new UnsupportedOperationException("Device must be at least API Level 8 (instead of " + i + ")");
        }
    }

    /* renamed from: b */
    public static void m6843b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        String str = packageName + ".permission.C2D_MESSAGE";
        try {
            packageManager.getPermissionInfo(str, 4096);
            try {
                ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(packageName, 2).receivers;
                if (activityInfoArr == null || activityInfoArr.length == 0) {
                    throw new IllegalStateException("No receiver for package " + packageName);
                }
                if (Log.isLoggable("GCMRegistrar", 2)) {
                    Log.v("GCMRegistrar", "number of receivers for " + packageName + ": " + activityInfoArr.length);
                }
                HashSet hashSet = new HashSet();
                for (ActivityInfo activityInfo : activityInfoArr) {
                    if ("com.google.android.c2dm.permission.SEND".equals(activityInfo.permission)) {
                        hashSet.add(activityInfo.name);
                    }
                }
                if (hashSet.isEmpty()) {
                    throw new IllegalStateException("No receiver allowed to receive com.google.android.c2dm.permission.SEND");
                }
                m6844c(context, hashSet, "com.google.android.c2dm.intent.REGISTRATION");
                m6844c(context, hashSet, "com.google.android.c2dm.intent.RECEIVE");
            } catch (PackageManager.NameNotFoundException unused) {
                throw new IllegalStateException("Could not get receivers for package " + packageName);
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new IllegalStateException("Application does not define permission " + str);
        }
    }

    /* renamed from: c */
    public static void m6844c(Context context, Set<String> set, String str) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(str);
        intent.setPackage(packageName);
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 32);
        if (queryBroadcastReceivers.isEmpty()) {
            throw new IllegalStateException("No receivers for action " + str);
        }
        if (Log.isLoggable("GCMRegistrar", 2)) {
            Log.v("GCMRegistrar", "Found " + queryBroadcastReceivers.size() + " receivers for action " + str);
        }
        Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
        while (it.hasNext()) {
            String str2 = it.next().activityInfo.name;
            if (!set.contains(str2)) {
                throw new IllegalStateException("Receiver " + str2 + " is not set with permission com.google.android.c2dm.permission.SEND");
            }
        }
    }

    /* renamed from: d */
    public static String m6845d(Context context) {
        return m6857p(context, "");
    }

    /* renamed from: e */
    public static int m6846e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Coult not get package name: " + e);
        }
    }

    /* renamed from: f */
    public static int m6847f(Context context) {
        return m6849h(context).getInt("backoff_ms", PathInterpolatorCompat.MAX_NUM_POINTS);
    }

    /* renamed from: g */
    public static String m6848g(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(',');
            sb.append(strArr[i]);
        }
        return sb.toString();
    }

    /* renamed from: h */
    public static SharedPreferences m6849h(Context context) {
        return context.getSharedPreferences("com.google.android.gcm", 0);
    }

    /* renamed from: i */
    public static String m6850i(Context context) {
        SharedPreferences m6849h = m6849h(context);
        String string = m6849h.getString("regId", "");
        int i = m6849h.getInt("appVersion", Integer.MIN_VALUE);
        int m6846e = m6846e(context);
        if (i == Integer.MIN_VALUE || i == m6846e) {
            return string;
        }
        Log.v("GCMRegistrar", "App version changed from " + i + " to " + m6846e + "; resetting registration id");
        m6845d(context);
        return "";
    }

    /* renamed from: j */
    public static void m6851j(Context context, String... strArr) {
        String m6848g = m6848g(strArr);
        Log.v("GCMRegistrar", "Registering app " + context.getPackageName() + " of senders " + m6848g);
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gsf");
        intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        intent.putExtra(NotificationCompat.MessagingStyle.Message.KEY_SENDER, m6848g);
        context.startService(intent);
    }

    /* renamed from: k */
    public static void m6852k(Context context) {
        Log.v("GCMRegistrar", "Unregistering app " + context.getPackageName());
        Intent intent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        intent.setPackage("com.google.android.gsf");
        intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        context.startService(intent);
    }

    /* renamed from: l */
    public static boolean m6853l(Context context) {
        return m6850i(context).length() > 0;
    }

    /* renamed from: m */
    public static void m6854m(Context context, String... strArr) {
        m6855n(context);
        m6851j(context, strArr);
    }

    /* renamed from: n */
    public static void m6855n(Context context) {
        Log.d("GCMRegistrar", "resetting backoff for " + context.getPackageName());
        m6856o(context, PathInterpolatorCompat.MAX_NUM_POINTS);
    }

    /* renamed from: o */
    public static void m6856o(Context context, int i) {
        SharedPreferences.Editor edit = m6849h(context).edit();
        edit.putInt("backoff_ms", i);
        edit.commit();
    }

    /* renamed from: p */
    public static String m6857p(Context context, String str) {
        SharedPreferences m6849h = m6849h(context);
        String string = m6849h.getString("regId", "");
        int m6846e = m6846e(context);
        Log.v("GCMRegistrar", "Saving regId on app version " + m6846e);
        SharedPreferences.Editor edit = m6849h.edit();
        edit.putString("regId", str);
        edit.putInt("appVersion", m6846e);
        edit.commit();
        return string;
    }

    /* renamed from: q */
    public static synchronized void m6858q(Context context) {
        synchronized (C1631o3.class) {
            if (f5410a == null) {
                String str = f5411b;
                if (str == null) {
                    Log.e("GCMRegistrar", "internal error: retry receiver class not set yet");
                    f5410a = new C1586n3();
                } else {
                    try {
                        f5410a = (C1586n3) Class.forName(str).newInstance();
                    } catch (Exception unused) {
                        Log.e("GCMRegistrar", "Could not create instance of " + f5411b + ". Using " + C1586n3.class.getName() + " directly.");
                        f5410a = new C1586n3();
                    }
                }
                String packageName = context.getPackageName();
                IntentFilter intentFilter = new IntentFilter("com.google.android.gcm.intent.RETRY");
                intentFilter.addCategory(packageName);
                Log.v("GCMRegistrar", "Registering receiver");
                context.registerReceiver(f5410a, intentFilter, packageName + ".permission.C2D_MESSAGE", null);
            }
        }
    }

    /* renamed from: r */
    public static void m6859r(String str) {
        Log.v("GCMRegistrar", "Setting the name of retry receiver class to " + str);
        f5411b = str;
    }
}
