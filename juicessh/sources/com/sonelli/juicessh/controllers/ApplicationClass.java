package com.sonelli.juicessh.controllers;

import android.app.Application;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.sonelli.C1196j5;
import com.sonelli.C1435k5;
import com.sonelli.C2323y3;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.services.CloudSync;
import com.sonelli.juicessh.services.Ec2Link;

/* loaded from: classes.dex */
public class ApplicationClass extends Application {

    /* renamed from: O */
    public static GoogleAnalytics f3982O;

    /* renamed from: P */
    public static C2323y3 f3983P;

    /* renamed from: Q */
    public static C1435k5 f3984Q;

    /* renamed from: a */
    public synchronized C2323y3 m5370a() {
        if (f3983P == null) {
            f3983P = f3982O.m820n(R.xml.google_analytics);
        }
        return f3983P;
    }

    /* renamed from: b */
    public synchronized C1435k5 m5371b() {
        return f3984Q;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        GoogleSignInOptions.C0424a c0424a = new GoogleSignInOptions.C0424a(GoogleSignInOptions.f671e0);
        c0424a.m928b();
        c0424a.m930d("425124909500-6umqqdtq7q4tr7c85hfic2fupfss16io.apps.googleusercontent.com");
        c0424a.m931e();
        f3984Q = C1196j5.m5055a(getApplicationContext(), c0424a.m927a());
        f3982O = GoogleAnalytics.m813k(this);
        CloudSync.m5629i(getApplicationContext(), 86400000L);
        Ec2Link.m5634d(getApplicationContext(), 86400000L);
    }
}
