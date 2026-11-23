package cz.opentree;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import javax.annotation.CheckReturnValue;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
@CheckReturnValue
/* renamed from: cz.opentree.d7 */
/* loaded from: classes.dex */
public class C0862d7 {

    /* renamed from: b */
    public static C0862d7 f2136b;

    /* renamed from: a */
    public final Context f2137a;

    public C0862d7(Context context) {
        this.f2137a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C0862d7 m3159a(Context context) {
        C0813ca.m2729k(context);
        synchronized (C0862d7.class) {
            if (f2136b == null) {
                C0706ad.m2042c(context);
                f2136b = new C0862d7(context);
            }
        }
        return f2136b;
    }

    /* renamed from: d */
    public static AbstractBinderC0763bd m3160d(PackageInfo packageInfo, AbstractBinderC0763bd... abstractBinderC0763bdArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        BinderC0922ed binderC0922ed = new BinderC0922ed(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < abstractBinderC0763bdArr.length; i++) {
            if (abstractBinderC0763bdArr[i].equals(binderC0922ed)) {
                return abstractBinderC0763bdArr[i];
            }
        }
        return null;
    }

    /* renamed from: f */
    public static boolean m3161f(PackageInfo packageInfo, boolean z) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? m3160d(packageInfo, C1037gd.f2859a) : m3160d(packageInfo, C1037gd.f2859a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public boolean m3162b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (m3161f(packageInfo, false)) {
            return true;
        }
        if (m3161f(packageInfo, true)) {
            if (C0810c7.m2680e(this.f2137a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    /* renamed from: c */
    public boolean m3163c(int i) {
        C1156id m4747d;
        String[] m9469f = C2272xc.m9755a(this.f2137a).m9469f(i);
        if (m9469f == null || m9469f.length == 0) {
            m4747d = C1156id.m4747d("no pkgs");
        } else {
            m4747d = null;
            for (String str : m9469f) {
                m4747d = m3164e(str, i);
                if (m4747d.f3295a) {
                    break;
                }
            }
        }
        m4747d.m4751g();
        return m4747d.f3295a;
    }

    /* renamed from: e */
    public final C1156id m3164e(String str, int i) {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo m9471h = C2272xc.m9755a(this.f2137a).m9471h(str, 64, i);
            boolean m2680e = C0810c7.m2680e(this.f2137a);
            if (m9471h == null) {
                return C1156id.m4747d("null pkg");
            }
            Signature[] signatureArr = m9471h.signatures;
            if (signatureArr != null && signatureArr.length == 1) {
                BinderC0922ed binderC0922ed = new BinderC0922ed(m9471h.signatures[0].toByteArray());
                String str2 = m9471h.packageName;
                C1156id m2040a = C0706ad.m2040a(str2, binderC0922ed, m2680e, false);
                return (!m2040a.f3295a || (applicationInfo = m9471h.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !C0706ad.m2040a(str2, binderC0922ed, false, true).f3295a) ? m2040a : C1156id.m4747d("debuggable release cert app rejected");
            }
            return C1156id.m4747d("single cert required");
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return C1156id.m4747d(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }
}
