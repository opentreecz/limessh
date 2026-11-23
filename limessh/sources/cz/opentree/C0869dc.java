package cz.opentree;

import android.content.Context;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.dc */
/* loaded from: classes.dex */
public final class C0869dc {
    /* renamed from: a */
    public static boolean m3183a(Context context, Throwable th) {
        return m3184b(context, th, 536870912);
    }

    /* renamed from: b */
    public static boolean m3184b(Context context, Throwable th, int i) {
        try {
            C0813ca.m2729k(context);
            C0813ca.m2729k(th);
            return false;
        } catch (Exception e) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e);
            return false;
        }
    }
}
