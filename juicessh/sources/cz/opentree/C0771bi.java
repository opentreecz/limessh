package cz.opentree;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.Locale;

/* renamed from: cz.opentree.bi */
/* loaded from: classes.dex */
public final class C0771bi extends AbstractC2006uf {

    /* renamed from: Q */
    public String f1705Q;

    /* renamed from: R */
    public String f1706R;

    /* renamed from: S */
    public boolean f1707S;

    /* renamed from: T */
    public int f1708T;

    /* renamed from: U */
    public boolean f1709U;

    /* renamed from: V */
    public boolean f1710V;

    public C0771bi(C2216wf c2216wf) {
        super(c2216wf);
    }

    @Override // cz.opentree.AbstractC2006uf
    /* renamed from: E0 */
    public final void mo2053E0() {
        ApplicationInfo applicationInfo;
        int i;
        C0989fh m8682D0;
        Context m8675x = m8675x();
        try {
            applicationInfo = m8675x.getPackageManager().getApplicationInfo(m8675x.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            m8672t0("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            m8649A0("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null || (i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) <= 0 || (m8682D0 = new C0876dh(m8658f0()).m8682D0(i)) == null) {
            return;
        }
        m8676x0("Loading global XML config values");
        String str = m8682D0.f2686a;
        if (str != null) {
            this.f1706R = str;
            m8653Z("XML config - app name", str);
        }
        String str2 = m8682D0.f2687b;
        if (str2 != null) {
            this.f1705Q = str2;
            m8653Z("XML config - app version", str2);
        }
        String str3 = m8682D0.f2688c;
        if (str3 != null) {
            String lowerCase = str3.toLowerCase(Locale.US);
            int i2 = "verbose".equals(lowerCase) ? 0 : "info".equals(lowerCase) ? 1 : "warning".equals(lowerCase) ? 2 : "error".equals(lowerCase) ? 3 : -1;
            if (i2 >= 0) {
                m8679z("XML config - log level", Integer.valueOf(i2));
            }
        }
        int i3 = m8682D0.f2689d;
        if (i3 >= 0) {
            this.f1708T = i3;
            this.f1707S = true;
            m8653Z("XML config - dispatch period (sec)", Integer.valueOf(i3));
        }
        int i4 = m8682D0.f2690e;
        if (i4 != -1) {
            boolean z = i4 == 1;
            this.f1710V = z;
            this.f1709U = true;
            m8653Z("XML config - dry run", Boolean.valueOf(z));
        }
    }

    /* renamed from: G0 */
    public final String m2486G0() {
        m8878F0();
        return this.f1706R;
    }

    /* renamed from: H0 */
    public final String m2487H0() {
        m8878F0();
        return this.f1705Q;
    }

    /* renamed from: I0 */
    public final boolean m2488I0() {
        m8878F0();
        return false;
    }

    /* renamed from: J0 */
    public final boolean m2489J0() {
        m8878F0();
        return this.f1709U;
    }

    /* renamed from: K0 */
    public final boolean m2490K0() {
        m8878F0();
        return this.f1710V;
    }
}
