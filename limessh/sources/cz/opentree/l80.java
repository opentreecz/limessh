package cz.opentree;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class l80 {

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.l80$a */
    /* loaded from: classes.dex */
    public class CallableC1495a implements Callable<Void> {

        /* renamed from: a */
        public final /* synthetic */ o80 f4766a;

        /* renamed from: b */
        public final /* synthetic */ ExecutorService f4767b;

        /* renamed from: c */
        public final /* synthetic */ fc0 f4768c;

        /* renamed from: d */
        public final /* synthetic */ boolean f4769d;

        /* renamed from: e */
        public final /* synthetic */ y80 f4770e;

        public CallableC1495a(o80 o80Var, ExecutorService executorService, fc0 fc0Var, boolean z, y80 y80Var) {
            this.f4766a = o80Var;
            this.f4767b = executorService;
            this.f4768c = fc0Var;
            this.f4769d = z;
            this.f4770e = y80Var;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            this.f4766a.m6888c(this.f4767b, this.f4768c);
            if (!this.f4769d) {
                return null;
            }
            this.f4770e.m10105g(this.f4768c);
            return null;
        }
    }

    public l80(@NonNull y80 y80Var) {
    }

    @Nullable
    /* renamed from: a */
    public static l80 m6097a(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseInstanceIdInternal firebaseInstanceIdInternal, @Nullable CrashlyticsNativeComponent crashlyticsNativeComponent, @Nullable AnalyticsConnector analyticsConnector) {
        Context m1580g = firebaseApp.m1580g();
        h90 h90Var = new h90(m1580g, m1580g.getPackageName(), firebaseInstanceIdInternal);
        c90 c90Var = new c90(firebaseApp);
        CrashlyticsNativeComponent n80Var = crashlyticsNativeComponent == null ? new n80() : crashlyticsNativeComponent;
        o80 o80Var = new o80(firebaseApp, m1580g, h90Var, c90Var);
        y80 y80Var = new y80(firebaseApp, h90Var, n80Var, c90Var, analyticsConnector);
        if (!o80Var.m6892h()) {
            m80.m6375f().m6379d("Unable to start Crashlytics.");
            return null;
        }
        ExecutorService m3694c = f90.m3694c("com.google.firebase.crashlytics.startup");
        fc0 m6896l = o80Var.m6896l(m1580g, firebaseApp, m3694c);
        Tasks.m1560c(m3694c, new CallableC1495a(o80Var, m3694c, m6896l, y80Var.m10110n(m6896l), y80Var));
        return new l80(y80Var);
    }
}
