package cz.opentree;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.cl */
/* loaded from: classes.dex */
public class C0834cl {

    /* renamed from: a */
    @GuardedBy("DirectBootUtils.class")
    public static UserManager f1976a;

    /* renamed from: b */
    public static volatile boolean f1977b = !m2864a();

    /* renamed from: a */
    public static boolean m2864a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: b */
    public static boolean m2865b(Context context) {
        return !m2864a() || m2867d(context);
    }

    @RequiresApi(24)
    @TargetApi(24)
    @GuardedBy("DirectBootUtils.class")
    /* renamed from: c */
    public static boolean m2866c(Context context) {
        boolean z;
        boolean z2 = true;
        int i = 1;
        while (true) {
            z = false;
            if (i > 2) {
                break;
            }
            if (f1976a == null) {
                f1976a = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = f1976a;
            if (userManager == null) {
                return true;
            }
            try {
                if (userManager.isUserUnlocked()) {
                    break;
                }
                if (userManager.isUserRunning(Process.myUserHandle())) {
                    z2 = false;
                }
            } catch (NullPointerException e) {
                Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e);
                f1976a = null;
                i++;
            }
        }
        z = z2;
        if (z) {
            f1976a = null;
        }
        return z;
    }

    @RequiresApi(24)
    @TargetApi(24)
    /* renamed from: d */
    public static boolean m2867d(Context context) {
        if (f1977b) {
            return true;
        }
        synchronized (C0834cl.class) {
            if (f1977b) {
                return true;
            }
            boolean m2866c = m2866c(context);
            if (m2866c) {
                f1977b = m2866c;
            }
            return m2866c;
        }
    }
}
