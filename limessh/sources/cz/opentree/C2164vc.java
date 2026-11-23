package cz.opentree;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.vc */
/* loaded from: classes.dex */
public class C2164vc {

    /* renamed from: a */
    public static Context f7440a;

    /* renamed from: b */
    public static Boolean f7441b;

    /* renamed from: a */
    public static synchronized boolean m9210a(Context context) {
        Boolean bool;
        synchronized (C2164vc.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = f7440a;
            if (context2 != null && (bool = f7441b) != null && context2 == applicationContext) {
                return bool.booleanValue();
            }
            f7441b = null;
            if (C1501lc.m6150j()) {
                f7441b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    f7441b = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    f7441b = Boolean.FALSE;
                }
            }
            f7440a = applicationContext;
            return f7441b.booleanValue();
        }
    }
}
