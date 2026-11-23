package com.amazonaws;

import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.VersionInfoUtils;
import javax.net.ssl.TrustManager;

/* loaded from: classes.dex */
public class ClientConfiguration {

    /* renamed from: k */
    public static final String f49k = VersionInfoUtils.m699b();

    /* renamed from: l */
    public static final RetryPolicy f50l = PredefinedRetryPolicies.f223a;

    /* renamed from: g */
    public String f57g;

    /* renamed from: a */
    public String f51a = f49k;

    /* renamed from: b */
    public int f52b = -1;

    /* renamed from: c */
    public RetryPolicy f53c = f50l;

    /* renamed from: d */
    public Protocol f54d = Protocol.HTTPS;

    /* renamed from: e */
    public int f55e = 15000;

    /* renamed from: f */
    public int f56f = 15000;

    /* renamed from: h */
    public TrustManager f58h = null;

    /* renamed from: i */
    public boolean f59i = false;

    /* renamed from: j */
    public boolean f60j = false;

    /* renamed from: a */
    public int m35a() {
        return this.f56f;
    }

    /* renamed from: b */
    public int m36b() {
        return this.f52b;
    }

    /* renamed from: c */
    public Protocol m37c() {
        return this.f54d;
    }

    /* renamed from: d */
    public RetryPolicy m38d() {
        return this.f53c;
    }

    /* renamed from: e */
    public String m39e() {
        return this.f57g;
    }

    /* renamed from: f */
    public int m40f() {
        return this.f55e;
    }

    /* renamed from: g */
    public TrustManager m41g() {
        return this.f58h;
    }

    /* renamed from: h */
    public String m42h() {
        return this.f51a;
    }

    /* renamed from: i */
    public boolean m43i() {
        return this.f59i;
    }

    /* renamed from: j */
    public boolean m44j() {
        return this.f60j;
    }
}
