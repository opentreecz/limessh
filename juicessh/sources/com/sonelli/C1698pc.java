package com.sonelli;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.pc */
/* loaded from: classes.dex */
public class C1698pc {

    /* renamed from: a */
    public static final Method f5649a;

    /* renamed from: b */
    public static final Method f5650b;

    /* renamed from: c */
    public static final Method f5651c;

    /* renamed from: d */
    public static final Method f5652d;

    static {
        Process.myUid();
        f5649a = m7315l();
        f5650b = m7316m();
        f5651c = m7317n();
        m7311h();
        f5652d = m7312i();
        m7313j();
        m7314k();
    }

    @Nullable
    /* renamed from: a */
    public static WorkSource m7304a(Context context, @Nullable String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo m9466c = C2272xc.m9755a(context).m9466c(str, 0);
                if (m9466c != null) {
                    return m7308e(m9466c.uid, str);
                }
                String valueOf = String.valueOf(str);
                Log.e("WorkSourceUtil", valueOf.length() != 0 ? "Could not get applicationInfo from package: ".concat(valueOf) : new String("Could not get applicationInfo from package: "));
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                String valueOf2 = String.valueOf(str);
                Log.e("WorkSourceUtil", valueOf2.length() != 0 ? "Could not find package: ".concat(valueOf2) : new String("Could not find package: "));
            }
        }
        return null;
    }

    /* renamed from: b */
    public static List<String> m7305b(@Nullable WorkSource workSource) {
        int m7307d = workSource == null ? 0 : m7307d(workSource);
        if (m7307d == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < m7307d; i++) {
            String m7309f = m7309f(workSource, i);
            if (!C1599nc.m6663a(m7309f)) {
                arrayList.add(m7309f);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public static boolean m7306c(Context context) {
        return (context == null || context.getPackageManager() == null || C2272xc.m9755a(context).m9465b("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    /* renamed from: d */
    public static int m7307d(WorkSource workSource) {
        Method method = f5651c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }

    /* renamed from: e */
    public static WorkSource m7308e(int i, String str) {
        WorkSource workSource = new WorkSource();
        m7310g(workSource, i, str);
        return workSource;
    }

    @Nullable
    /* renamed from: f */
    public static String m7309f(WorkSource workSource, int i) {
        Method method = f5652d;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, Integer.valueOf(i));
        } catch (Exception e) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            return null;
        }
    }

    /* renamed from: g */
    public static void m7310g(WorkSource workSource, int i, @Nullable String str) {
        Method method = f5650b;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i), str);
                return;
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
                return;
            }
        }
        Method method2 = f5649a;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i));
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
    }

    /* renamed from: h */
    public static Method m7311h() {
        try {
            return WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: i */
    public static Method m7312i() {
        if (C1501lc.m6145e()) {
            try {
                return WorkSource.class.getMethod("getName", Integer.TYPE);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: j */
    public static final Method m7313j() {
        if (C1501lc.m6151k()) {
            try {
                return WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    /* renamed from: k */
    public static final Method m7314k() {
        if (C1501lc.m6151k()) {
            try {
                return Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            } catch (Exception e) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e);
            }
        }
        return null;
    }

    /* renamed from: l */
    public static Method m7315l() {
        try {
            return WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: m */
    public static Method m7316m() {
        if (C1501lc.m6145e()) {
            try {
                return WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: n */
    public static Method m7317n() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
