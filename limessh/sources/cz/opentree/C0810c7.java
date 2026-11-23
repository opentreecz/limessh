package cz.opentree;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.R$string;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.c7 */
/* loaded from: classes.dex */
public class C0810c7 {

    /* renamed from: a */
    @Deprecated
    public static final int f1875a = 12451000;

    /* renamed from: b */
    public static boolean f1876b = false;

    /* renamed from: c */
    public static boolean f1877c = false;

    /* renamed from: d */
    public static final AtomicBoolean f1878d = new AtomicBoolean();

    /* renamed from: e */
    public static final AtomicBoolean f1879e = new AtomicBoolean();

    @Deprecated
    /* renamed from: a */
    public static int m2676a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @Deprecated
    /* renamed from: b */
    public static String m2677b(int i) {
        return ConnectionResult.m950b0(i);
    }

    /* renamed from: c */
    public static Context m2678c(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: d */
    public static Resources m2679d(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: e */
    public static boolean m2680e(Context context) {
        try {
            if (!f1877c) {
                PackageInfo m9468e = C2272xc.m9755a(context).m9468e("com.google.android.gms", 64);
                C0862d7.m3159a(context);
                if (m9468e == null || C0862d7.m3161f(m9468e, false) || !C0862d7.m3161f(m9468e, true)) {
                    f1876b = false;
                } else {
                    f1876b = true;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
        } finally {
            f1877c = true;
        }
        return f1876b || !C0981fc.m3710a();
    }

    @Deprecated
    /* renamed from: f */
    public static int m2681f(Context context, int i) {
        try {
            context.getResources().getString(R$string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !f1879e.get()) {
            int m3707b = C0980fb.m3707b(context);
            if (m3707b == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
            int i2 = f1875a;
            if (m3707b != i2) {
                StringBuilder sb = new StringBuilder(320);
                sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                sb.append(i2);
                sb.append(" but found ");
                sb.append(m3707b);
                sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                throw new IllegalStateException(sb.toString());
            }
        }
        return m2687l(context, (C0981fc.m3712c(context) || C0981fc.m3714e(context)) ? false : true, i);
    }

    @Deprecated
    /* renamed from: g */
    public static boolean m2682g(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return m2684i(context, "com.google.android.gms");
        }
        return false;
    }

    @TargetApi(18)
    /* renamed from: h */
    public static boolean m2683h(Context context) {
        Bundle applicationRestrictions;
        return C1501lc.m6145e() && (applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName())) != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    @TargetApi(21)
    /* renamed from: i */
    public static boolean m2684i(Context context, String str) {
        ApplicationInfo applicationInfo;
        boolean equals = str.equals("com.google.android.gms");
        if (C1501lc.m6148h()) {
            try {
                Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return equals ? applicationInfo.enabled : applicationInfo.enabled && !m2683h(context);
    }

    @Deprecated
    /* renamed from: j */
    public static boolean m2685j(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    @TargetApi(19)
    @Deprecated
    /* renamed from: k */
    public static boolean m2686k(Context context, int i, String str) {
        return C1649oc.m7011b(context, i, str);
    }

    /* renamed from: l */
    public static int m2687l(Context context, boolean z, int i) {
        C0813ca.m2719a(i >= 0);
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            C0862d7.m3159a(context);
            if (!C0862d7.m3161f(packageInfo2, true)) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (z && (!C0862d7.m3161f(packageInfo, true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                return 9;
            }
            if (C1927tc.m8641a(packageInfo2.versionCode) >= C1927tc.m8641a(i)) {
                ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                if (applicationInfo == null) {
                    try {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    } catch (PackageManager.NameNotFoundException e) {
                        Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e);
                        return 1;
                    }
                }
                return !applicationInfo.enabled ? 3 : 0;
            }
            int i2 = packageInfo2.versionCode;
            StringBuilder sb = new StringBuilder(77);
            sb.append("Google Play services out of date.  Requires ");
            sb.append(i);
            sb.append(" but found ");
            sb.append(i2);
            Log.w("GooglePlayServicesUtil", sb.toString());
            return 2;
        } catch (PackageManager.NameNotFoundException unused2) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }
}
