package cz.opentree;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public class gd0 {

    /* renamed from: b */
    public static gd0 f2860b;

    /* renamed from: a */
    public final SharedPreferences f2861a;

    public gd0(Context context) {
        this.f2861a = context.getSharedPreferences("FirebaseAppHeartBeat", 0);
    }

    /* renamed from: a */
    public static synchronized gd0 m4115a(Context context) {
        gd0 gd0Var;
        synchronized (gd0.class) {
            if (f2860b == null) {
                f2860b = new gd0(context);
            }
            gd0Var = f2860b;
        }
        return gd0Var;
    }

    /* renamed from: b */
    public synchronized boolean m4116b(long j) {
        return m4117c("fire-global", j);
    }

    /* renamed from: c */
    public synchronized boolean m4117c(String str, long j) {
        if (!this.f2861a.contains(str)) {
            this.f2861a.edit().putLong(str, j).apply();
            return true;
        }
        if (j - this.f2861a.getLong(str, -1L) < 86400000) {
            return false;
        }
        this.f2861a.edit().putLong(str, j).apply();
        return true;
    }
}
