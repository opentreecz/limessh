package cz.opentree;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.MainThread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
@TargetApi(14)
@MainThread
/* loaded from: classes.dex */
public final class r10 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: O */
    public final /* synthetic */ y00 f6155O;

    public r10(y00 y00Var) {
        this.f6155O = y00Var;
    }

    public /* synthetic */ r10(y00 y00Var, z00 z00Var) {
        this(y00Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00a1 A[Catch: Exception -> 0x01d6, TRY_ENTER, TryCatch #0 {Exception -> 0x01d6, blocks: (B:3:0x000b, B:6:0x0025, B:8:0x0033, B:14:0x00a1, B:16:0x00af, B:18:0x00c2, B:21:0x00ca, B:23:0x00d0, B:24:0x00e3, B:26:0x00f6, B:27:0x00ff, B:30:0x010f, B:33:0x011f, B:36:0x0127, B:38:0x012d, B:39:0x0138, B:43:0x013f, B:47:0x0160, B:49:0x0173, B:50:0x018a, B:52:0x017b, B:53:0x0191, B:55:0x0197, B:57:0x019d, B:59:0x01a3, B:61:0x01a9, B:63:0x01b1, B:67:0x01bc, B:69:0x01ca, B:71:0x01d0, B:75:0x0044, B:78:0x0051, B:80:0x0057, B:82:0x005d, B:84:0x0063, B:86:0x0069, B:87:0x0075, B:89:0x0081, B:90:0x008c, B:92:0x0096, B:93:0x0086), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010f A[Catch: Exception -> 0x01d6, TRY_ENTER, TryCatch #0 {Exception -> 0x01d6, blocks: (B:3:0x000b, B:6:0x0025, B:8:0x0033, B:14:0x00a1, B:16:0x00af, B:18:0x00c2, B:21:0x00ca, B:23:0x00d0, B:24:0x00e3, B:26:0x00f6, B:27:0x00ff, B:30:0x010f, B:33:0x011f, B:36:0x0127, B:38:0x012d, B:39:0x0138, B:43:0x013f, B:47:0x0160, B:49:0x0173, B:50:0x018a, B:52:0x017b, B:53:0x0191, B:55:0x0197, B:57:0x019d, B:59:0x01a3, B:61:0x01a9, B:63:0x01b1, B:67:0x01bc, B:69:0x01ca, B:71:0x01d0, B:75:0x0044, B:78:0x0051, B:80:0x0057, B:82:0x005d, B:84:0x0063, B:86:0x0069, B:87:0x0075, B:89:0x0081, B:90:0x008c, B:92:0x0096, B:93:0x0086), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013f A[Catch: Exception -> 0x01d6, TRY_LEAVE, TryCatch #0 {Exception -> 0x01d6, blocks: (B:3:0x000b, B:6:0x0025, B:8:0x0033, B:14:0x00a1, B:16:0x00af, B:18:0x00c2, B:21:0x00ca, B:23:0x00d0, B:24:0x00e3, B:26:0x00f6, B:27:0x00ff, B:30:0x010f, B:33:0x011f, B:36:0x0127, B:38:0x012d, B:39:0x0138, B:43:0x013f, B:47:0x0160, B:49:0x0173, B:50:0x018a, B:52:0x017b, B:53:0x0191, B:55:0x0197, B:57:0x019d, B:59:0x01a3, B:61:0x01a9, B:63:0x01b1, B:67:0x01bc, B:69:0x01ca, B:71:0x01d0, B:75:0x0044, B:78:0x0051, B:80:0x0057, B:82:0x005d, B:84:0x0063, B:86:0x0069, B:87:0x0075, B:89:0x0081, B:90:0x008c, B:92:0x0096, B:93:0x0086), top: B:2:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00fe  */
    @androidx.annotation.WorkerThread
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m7848b(boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.r10.m7848b(boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.f6155O.mo1484j().m8530P().m9083a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
                return;
            }
            Uri data = intent.getData();
            if (data != null && data.isHierarchical()) {
                this.f6155O.m7588m();
                this.f6155O.mo1481g().m8281A(new u10(this, bundle == null, data, g40.m3992Y(intent) ? "gs" : "auto", data.getQueryParameter("referrer")));
            }
        } catch (Exception e) {
            this.f6155O.mo1484j().m8522H().m9084b("Throwable caught in onActivityCreated", e);
        } finally {
            this.f6155O.m10665t().m1963H(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.f6155O.m10665t().m1972T(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @MainThread
    public final void onActivityPaused(Activity activity) {
        this.f6155O.m10665t().m1970R(activity);
        k30 m10667v = this.f6155O.m10667v();
        m10667v.mo1481g().m8281A(new m30(m10667v, m10667v.mo1483i().mo1178b()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @MainThread
    public final void onActivityResumed(Activity activity) {
        k30 m10667v = this.f6155O.m10667v();
        m10667v.mo1481g().m8281A(new j30(m10667v, m10667v.mo1483i().mo1178b()));
        this.f6155O.m10665t().m1962G(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f6155O.m10665t().m1971S(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
