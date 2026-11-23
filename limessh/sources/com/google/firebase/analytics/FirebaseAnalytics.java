package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import com.google.android.gms.measurement.internal.zzhz;
import com.google.firebase.iid.FirebaseInstanceId;
import cz.opentree.C0813ca;
import cz.opentree.C2144uz;
import cz.opentree.C2224wi;
import cz.opentree.r70;
import cz.opentree.t40;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
/* loaded from: classes.dex */
public final class FirebaseAnalytics {

    /* renamed from: d */
    public static volatile FirebaseAnalytics f1112d;

    /* renamed from: a */
    public final C2144uz f1113a;

    /* renamed from: b */
    public final C2224wi f1114b;

    /* renamed from: c */
    public final boolean f1115c;

    public FirebaseAnalytics(C2144uz c2144uz) {
        C0813ca.m2729k(c2144uz);
        this.f1113a = c2144uz;
        this.f1114b = null;
        this.f1115c = false;
    }

    public FirebaseAnalytics(C2224wi c2224wi) {
        C0813ca.m2729k(c2224wi);
        this.f1113a = null;
        this.f1114b = c2224wi;
        this.f1115c = true;
    }

    @NonNull
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Keep
    public static FirebaseAnalytics getInstance(@NonNull Context context) {
        if (f1112d == null) {
            synchronized (FirebaseAnalytics.class) {
                if (f1112d == null) {
                    if (C2224wi.m9545z(context)) {
                        f1112d = new FirebaseAnalytics(C2224wi.m9535a(context));
                    } else {
                        f1112d = new FirebaseAnalytics(C2144uz.m9091a(context, null, null));
                    }
                }
            }
        }
        return f1112d;
    }

    @Keep
    public static zzhz getScionFrontendApiImplementation(Context context, Bundle bundle) {
        C2224wi m9536b;
        if (C2224wi.m9545z(context) && (m9536b = C2224wi.m9536b(context, null, null, null, bundle)) != null) {
            return new r70(m9536b);
        }
        return null;
    }

    /* renamed from: a */
    public final void m1594a(@NonNull @Size(max = 40, min = 1) String str, @Nullable Bundle bundle) {
        if (this.f1115c) {
            this.f1114b.m9561o(str, bundle);
        } else {
            this.f1113a.m9101G().m10010T("app", str, bundle, true);
        }
    }

    @Keep
    public final String getFirebaseInstanceId() {
        return FirebaseInstanceId.m1866b().m1878a();
    }

    @Keep
    @MainThread
    public final void setCurrentScreen(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        if (this.f1115c) {
            this.f1114b.m9556h(activity, str, str2);
        } else if (t40.m8593a()) {
            this.f1113a.m9110P().m1965J(activity, str, str2);
        } else {
            this.f1113a.mo1484j().m8525K().m9083a("setCurrentScreen must be called from the main thread");
        }
    }
}
