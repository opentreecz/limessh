package cz.opentree;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.fb */
/* loaded from: classes.dex */
public final class C0980fb {

    /* renamed from: a */
    public static Object f2647a = new Object();

    /* renamed from: b */
    @GuardedBy("sLock")
    public static boolean f2648b;

    /* renamed from: c */
    public static String f2649c;

    /* renamed from: d */
    public static int f2650d;

    /* renamed from: a */
    public static String m3706a(Context context) {
        m3708c(context);
        return f2649c;
    }

    /* renamed from: b */
    public static int m3707b(Context context) {
        m3708c(context);
        return f2650d;
    }

    /* renamed from: c */
    public static void m3708c(Context context) {
        Bundle bundle;
        synchronized (f2647a) {
            if (f2648b) {
                return;
            }
            f2648b = true;
            try {
                bundle = C2272xc.m9755a(context).m9466c(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
            if (bundle == null) {
                return;
            }
            f2649c = bundle.getString("com.google.app.id");
            f2650d = bundle.getInt("com.google.android.gms.version");
        }
    }
}
