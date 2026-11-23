package cz.opentree;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.wc */
/* loaded from: classes.dex */
public class C2213wc {

    /* renamed from: a */
    public final Context f7663a;

    public C2213wc(Context context) {
        this.f7663a = context;
    }

    /* renamed from: a */
    public int m9464a(String str) {
        return this.f7663a.checkCallingOrSelfPermission(str);
    }

    /* renamed from: b */
    public int m9465b(String str, String str2) {
        return this.f7663a.getPackageManager().checkPermission(str, str2);
    }

    /* renamed from: c */
    public ApplicationInfo m9466c(String str, int i) throws PackageManager.NameNotFoundException {
        return this.f7663a.getPackageManager().getApplicationInfo(str, i);
    }

    /* renamed from: d */
    public CharSequence m9467d(String str) throws PackageManager.NameNotFoundException {
        return this.f7663a.getPackageManager().getApplicationLabel(this.f7663a.getPackageManager().getApplicationInfo(str, 0));
    }

    /* renamed from: e */
    public PackageInfo m9468e(String str, int i) throws PackageManager.NameNotFoundException {
        return this.f7663a.getPackageManager().getPackageInfo(str, i);
    }

    /* renamed from: f */
    public final String[] m9469f(int i) {
        return this.f7663a.getPackageManager().getPackagesForUid(i);
    }

    /* renamed from: g */
    public boolean m9470g() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return C2164vc.m9210a(this.f7663a);
        }
        if (!C1501lc.m6150j() || (nameForUid = this.f7663a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f7663a.getPackageManager().isInstantApp(nameForUid);
    }

    /* renamed from: h */
    public final PackageInfo m9471h(String str, int i, int i2) throws PackageManager.NameNotFoundException {
        return this.f7663a.getPackageManager().getPackageInfo(str, 64);
    }

    @TargetApi(19)
    /* renamed from: i */
    public final boolean m9472i(int i, String str) {
        if (C1501lc.m6146f()) {
            try {
                ((AppOpsManager) this.f7663a.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        String[] packagesForUid = this.f7663a.getPackageManager().getPackagesForUid(i);
        if (str != null && packagesForUid != null) {
            for (String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
