package cz.opentree;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.util.Log;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.kl */
/* loaded from: classes.dex */
public final class C1463kl {

    /* renamed from: a */
    public static volatile AbstractC2358yl<Boolean> f4595a = AbstractC2358yl.m10188d();

    /* renamed from: b */
    public static final Object f4596b = new Object();

    /* renamed from: a */
    public static boolean m5942a(Context context) {
        return (context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & KeycodeConstants.KEYCODE_MEDIA_EJECT) != 0;
    }

    /* renamed from: b */
    public static boolean m5943b(Context context, Uri uri) {
        ProviderInfo resolveContentProvider;
        boolean z;
        String authority = uri.getAuthority();
        boolean z2 = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb = new StringBuilder(String.valueOf(authority).length() + 91);
            sb.append(authority);
            sb.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            Log.e("PhenotypeClientHelper", sb.toString());
            return false;
        }
        if (f4595a.mo9580b()) {
            return f4595a.mo9581c().booleanValue();
        }
        synchronized (f4596b) {
            if (f4595a.mo9580b()) {
                return f4595a.mo9581c().booleanValue();
            }
            if (!"com.google.android.gms".equals(context.getPackageName()) && ((resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0)) == null || !"com.google.android.gms".equals(resolveContentProvider.packageName))) {
                z = false;
                if (z && m5942a(context)) {
                    z2 = true;
                }
                f4595a = AbstractC2358yl.m10187a(Boolean.valueOf(z2));
                return f4595a.mo9581c().booleanValue();
            }
            z = true;
            if (z) {
                z2 = true;
            }
            f4595a = AbstractC2358yl.m10187a(Boolean.valueOf(z2));
            return f4595a.mo9581c().booleanValue();
        }
    }
}
