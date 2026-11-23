package cz.opentree;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.google.firebase.events.Publisher;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public class hg0 {

    /* renamed from: a */
    public final Context f3144a;

    /* renamed from: b */
    public final SharedPreferences f3145b;

    /* renamed from: c */
    public final Publisher f3146c;

    /* renamed from: d */
    public final AtomicBoolean f3147d = new AtomicBoolean(m4447c());

    public hg0(Context context, String str, Publisher publisher) {
        this.f3144a = m4445a(context);
        this.f3145b = context.getSharedPreferences("com.google.firebase.common.prefs:" + str, 0);
        this.f3146c = publisher;
    }

    /* renamed from: a */
    public static Context m4445a(Context context) {
        return (Build.VERSION.SDK_INT < 24 || ContextCompat.isDeviceProtectedStorage(context)) ? context : ContextCompat.createDeviceProtectedStorageContext(context);
    }

    /* renamed from: b */
    public boolean m4446b() {
        return this.f3147d.get();
    }

    /* renamed from: c */
    public final boolean m4447c() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        if (this.f3145b.contains("firebase_data_collection_default_enabled")) {
            return this.f3145b.getBoolean("firebase_data_collection_default_enabled", true);
        }
        try {
            PackageManager packageManager = this.f3144a.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.f3144a.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_data_collection_default_enabled")) {
                return applicationInfo.metaData.getBoolean("firebase_data_collection_default_enabled");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return true;
    }
}
