package cz.opentree;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class ff0 {

    /* renamed from: a */
    public final FirebaseApp f2671a;

    /* renamed from: b */
    public final vd0 f2672b;

    /* renamed from: c */
    public final be0 f2673c;

    /* renamed from: d */
    public final Executor f2674d;

    /* renamed from: e */
    public final UserAgentPublisher f2675e;

    /* renamed from: f */
    public final HeartBeatInfo f2676f;

    /* renamed from: g */
    public final FirebaseInstallationsApi f2677g;

    public ff0(FirebaseApp firebaseApp, vd0 vd0Var, Executor executor, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, vd0Var, executor, new be0(firebaseApp.m1580g(), vd0Var), userAgentPublisher, heartBeatInfo, firebaseInstallationsApi);
    }

    @VisibleForTesting
    public ff0(FirebaseApp firebaseApp, vd0 vd0Var, Executor executor, be0 be0Var, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.f2671a = firebaseApp;
        this.f2672b = vd0Var;
        this.f2673c = be0Var;
        this.f2674d = executor;
        this.f2675e = userAgentPublisher;
        this.f2676f = heartBeatInfo;
        this.f2677g = firebaseInstallationsApi;
    }

    /* renamed from: a */
    public final j60<String> m3744a(String str, String str2, String str3) {
        return m3749f(m3745b(str, str2, str3, new Bundle()));
    }

    /* renamed from: b */
    public final j60<Bundle> m3745b(final String str, final String str2, final String str3, final Bundle bundle) {
        final k60 k60Var = new k60();
        this.f2674d.execute(new Runnable(this, str, str2, str3, bundle, k60Var) { // from class: cz.opentree.ef0

            /* renamed from: O */
            public final ff0 f2376O;

            /* renamed from: P */
            public final String f2377P;

            /* renamed from: Q */
            public final String f2378Q;

            /* renamed from: R */
            public final String f2379R;

            /* renamed from: S */
            public final Bundle f2380S;

            /* renamed from: T */
            public final k60 f2381T;

            {
                this.f2376O = this;
                this.f2377P = str;
                this.f2378Q = str2;
                this.f2379R = str3;
                this.f2380S = bundle;
                this.f2381T = k60Var;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2376O.m3747d(this.f2377P, this.f2378Q, this.f2379R, this.f2380S, this.f2381T);
            }
        });
        return k60Var.m5842a();
    }

    /* renamed from: c */
    public final String m3746c() {
        try {
            return Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(this.f2671a.m1581i().getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    /* renamed from: d */
    public final /* synthetic */ void m3747d(String str, String str2, String str3, Bundle bundle, k60 k60Var) {
        try {
            m3748e(str, str2, str3, bundle);
            k60Var.m5844c(this.f2673c.m2452a(bundle));
        } catch (IOException e) {
            k60Var.m5843b(e);
        }
    }

    /* renamed from: e */
    public final Bundle m3748e(String str, String str2, String str3, Bundle bundle) {
        bundle.putString("scope", str3);
        bundle.putString(NotificationCompat.MessagingStyle.Message.KEY_SENDER, str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        bundle.putString("gmp_app_id", this.f2671a.m1582j().m4384c());
        bundle.putString("gmsv", Integer.toString(this.f2672b.m9219g()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f2672b.m9217e());
        bundle.putString("app_ver_name", this.f2672b.m9218f());
        bundle.putString("firebase-app-name-hash", m3746c());
        try {
            String mo5877b = ((vf0) Tasks.m1558a(this.f2677g.mo1908a(false))).mo5877b();
            if (TextUtils.isEmpty(mo5877b)) {
                Log.w("FirebaseInstanceId", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", mo5877b);
            }
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e);
        }
        String m2029b = C0703aa.m2028a().m2029b("firebase-iid");
        if ("UNKNOWN".equals(m2029b)) {
            int i = C2326y6.f8141a;
            StringBuilder sb = new StringBuilder(19);
            sb.append("unknown_");
            sb.append(i);
            m2029b = sb.toString();
        }
        String valueOf = String.valueOf(m2029b);
        bundle.putString("cliv", valueOf.length() != 0 ? "fiid-".concat(valueOf) : new String("fiid-"));
        HeartBeatInfo.EnumC0664a mo1864a = this.f2676f.mo1864a("fire-iid");
        if (mo1864a != HeartBeatInfo.EnumC0664a.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(mo1864a.m1865f()));
            bundle.putString("Firebase-Client", this.f2675e.mo1911a());
        }
        return bundle;
    }

    /* renamed from: f */
    public final j60<String> m3749f(j60<Bundle> j60Var) {
        return j60Var.mo2694g(this.f2674d, new Continuation(this) { // from class: cz.opentree.gf0
            @Override // com.google.android.gms.tasks.Continuation
            /* renamed from: a */
            public final Object mo1552a(j60 j60Var2) {
                Bundle bundle = (Bundle) j60Var2.mo2698k(IOException.class);
                if (bundle == null) {
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
                String string = bundle.getString("registration_id");
                if (string != null) {
                    return string;
                }
                String string2 = bundle.getString("unregistered");
                if (string2 != null) {
                    return string2;
                }
                String string3 = bundle.getString("error");
                if ("RST".equals(string3)) {
                    throw new IOException("INSTANCE_ID_RESET");
                }
                if (string3 != null) {
                    throw new IOException(string3);
                }
                String valueOf = String.valueOf(bundle);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
                sb.append("Unexpected response: ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        });
    }
}
