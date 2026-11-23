package cz.opentree;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.firebase.FirebaseApp;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class o80 {

    /* renamed from: a */
    public final db0 f5441a = new db0();

    /* renamed from: b */
    public final FirebaseApp f5442b;

    /* renamed from: c */
    public final Context f5443c;

    /* renamed from: d */
    public PackageManager f5444d;

    /* renamed from: e */
    public String f5445e;

    /* renamed from: f */
    public PackageInfo f5446f;

    /* renamed from: g */
    public String f5447g;

    /* renamed from: h */
    public String f5448h;

    /* renamed from: i */
    public String f5449i;

    /* renamed from: j */
    public String f5450j;

    /* renamed from: k */
    public String f5451k;

    /* renamed from: l */
    public h90 f5452l;

    /* renamed from: m */
    public c90 f5453m;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.o80$a */
    /* loaded from: classes.dex */
    public class C1637a implements SuccessContinuation<jc0, Void> {

        /* renamed from: a */
        public final /* synthetic */ String f5454a;

        /* renamed from: b */
        public final /* synthetic */ fc0 f5455b;

        /* renamed from: c */
        public final /* synthetic */ Executor f5456c;

        public C1637a(String str, fc0 fc0Var, Executor executor) {
            this.f5454a = str;
            this.f5455b = fc0Var;
            this.f5456c = executor;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j60<Void> mo1557a(@Nullable jc0 jc0Var) throws Exception {
            try {
                o80.this.m6893i(jc0Var, this.f5454a, this.f5455b, this.f5456c, true);
                return null;
            } catch (Exception e) {
                m80.m6375f().m6380e("Error performing auto configuration.", e);
                throw e;
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.o80$b */
    /* loaded from: classes.dex */
    public class C1638b implements SuccessContinuation<Void, jc0> {

        /* renamed from: a */
        public final /* synthetic */ fc0 f5458a;

        public C1638b(o80 o80Var, fc0 fc0Var) {
            this.f5458a = fc0Var;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j60<jc0> mo1557a(@Nullable Void r1) throws Exception {
            return this.f5458a.mo1842a();
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.o80$c */
    /* loaded from: classes.dex */
    public class C1639c implements Continuation<Void, Object> {
        public C1639c(o80 o80Var) {
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: a */
        public Object mo1552a(@NonNull j60<Void> j60Var) throws Exception {
            if (j60Var.mo2701n()) {
                return null;
            }
            m80.m6375f().m6380e("Error fetching settings.", j60Var.mo2696i());
            return null;
        }
    }

    public o80(FirebaseApp firebaseApp, Context context, h90 h90Var, c90 c90Var) {
        this.f5442b = firebaseApp;
        this.f5443c = context;
        this.f5452l = h90Var;
        this.f5453m = c90Var;
    }

    /* renamed from: g */
    public static String m6886g() {
        return y80.m10100i();
    }

    /* renamed from: b */
    public final ic0 m6887b(String str, String str2) {
        return new ic0(str, str2, m6890e().m4389d(), this.f5448h, this.f5447g, w80.m9429h(w80.m9437p(m6889d()), str2, this.f5448h, this.f5447g), this.f5450j, e90.m3458f(this.f5449i).m3459h(), this.f5451k, "0");
    }

    /* renamed from: c */
    public void m6888c(Executor executor, fc0 fc0Var) {
        this.f5453m.m2718d().mo2703p(executor, new C1638b(this, fc0Var)).mo2703p(executor, new C1637a(this.f5442b.m1582j().m4384c(), fc0Var, executor));
    }

    /* renamed from: d */
    public Context m6889d() {
        return this.f5443c;
    }

    /* renamed from: e */
    public final h90 m6890e() {
        return this.f5452l;
    }

    /* renamed from: f */
    public String m6891f() {
        return w80.m9442u(this.f5443c, "com.crashlytics.ApiEndpoint");
    }

    /* renamed from: h */
    public boolean m6892h() {
        try {
            this.f5449i = this.f5452l.m4390e();
            this.f5444d = this.f5443c.getPackageManager();
            String packageName = this.f5443c.getPackageName();
            this.f5445e = packageName;
            PackageInfo packageInfo = this.f5444d.getPackageInfo(packageName, 0);
            this.f5446f = packageInfo;
            this.f5447g = Integer.toString(packageInfo.versionCode);
            String str = this.f5446f.versionName;
            if (str == null) {
                str = "0.0";
            }
            this.f5448h = str;
            this.f5450j = this.f5444d.getApplicationLabel(this.f5443c.getApplicationInfo()).toString();
            this.f5451k = Integer.toString(this.f5443c.getApplicationInfo().targetSdkVersion);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            m80.m6375f().m6380e("Failed init", e);
            return false;
        }
    }

    /* renamed from: i */
    public final void m6893i(jc0 jc0Var, String str, fc0 fc0Var, Executor executor, boolean z) {
        if ("new".equals(jc0Var.f3535a)) {
            if (m6894j(jc0Var, str, z)) {
                fc0Var.m3727o(ec0.SKIP_CACHE_LOOKUP, executor);
                return;
            } else {
                m80.m6375f().m6380e("Failed to create app with Crashlytics service.", null);
                return;
            }
        }
        if ("configured".equals(jc0Var.f3535a)) {
            fc0Var.m3727o(ec0.SKIP_CACHE_LOOKUP, executor);
        } else if (jc0Var.f3540f) {
            m80.m6375f().m6377b("Server says an update is required - forcing a full App update.");
            m6895k(jc0Var, str, z);
        }
    }

    /* renamed from: j */
    public final boolean m6894j(jc0 jc0Var, String str, boolean z) {
        return new pc0(m6891f(), jc0Var.f3536b, this.f5441a, m6886g()).m7014i(m6887b(jc0Var.f3539e, str), z);
    }

    /* renamed from: k */
    public final boolean m6895k(jc0 jc0Var, String str, boolean z) {
        return new rc0(m6891f(), jc0Var.f3536b, this.f5441a, m6886g()).m7014i(m6887b(jc0Var.f3539e, str), z);
    }

    /* renamed from: l */
    public fc0 m6896l(Context context, FirebaseApp firebaseApp, Executor executor) {
        fc0 m3723l = fc0.m3723l(context, firebaseApp.m1582j().m4384c(), this.f5452l, this.f5441a, this.f5447g, this.f5448h, m6891f(), this.f5453m);
        m3723l.m3728p(executor).mo2694g(executor, new C1639c(this));
        return m3723l;
    }
}
