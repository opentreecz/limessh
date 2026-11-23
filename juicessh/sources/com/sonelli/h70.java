package com.sonelli;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.sonelli.C0758ba;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public final class h70 {

    /* renamed from: a */
    public final String f3113a;

    /* renamed from: b */
    public final String f3114b;

    /* renamed from: c */
    public final String f3115c;

    /* renamed from: d */
    public final String f3116d;

    /* renamed from: e */
    public final String f3117e;

    /* renamed from: f */
    public final String f3118f;

    /* renamed from: g */
    public final String f3119g;

    public h70(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        C0813ca.m2733o(!C1599nc.m6663a(str), "ApplicationId must be set.");
        this.f3114b = str;
        this.f3113a = str2;
        this.f3115c = str3;
        this.f3116d = str4;
        this.f3117e = str5;
        this.f3118f = str6;
        this.f3119g = str7;
    }

    @Nullable
    /* renamed from: a */
    public static h70 m4382a(@NonNull Context context) {
        C0977fa c0977fa = new C0977fa(context);
        String m3696a = c0977fa.m3696a("google_app_id");
        if (TextUtils.isEmpty(m3696a)) {
            return null;
        }
        return new h70(m3696a, c0977fa.m3696a("google_api_key"), c0977fa.m3696a("firebase_database_url"), c0977fa.m3696a("ga_trackingId"), c0977fa.m3696a("gcm_defaultSenderId"), c0977fa.m3696a("google_storage_bucket"), c0977fa.m3696a("project_id"));
    }

    @NonNull
    /* renamed from: b */
    public String m4383b() {
        return this.f3113a;
    }

    @NonNull
    /* renamed from: c */
    public String m4384c() {
        return this.f3114b;
    }

    @Nullable
    /* renamed from: d */
    public String m4385d() {
        return this.f3117e;
    }

    @Nullable
    /* renamed from: e */
    public String m4386e() {
        return this.f3119g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h70)) {
            return false;
        }
        h70 h70Var = (h70) obj;
        return C0758ba.m2404a(this.f3114b, h70Var.f3114b) && C0758ba.m2404a(this.f3113a, h70Var.f3113a) && C0758ba.m2404a(this.f3115c, h70Var.f3115c) && C0758ba.m2404a(this.f3116d, h70Var.f3116d) && C0758ba.m2404a(this.f3117e, h70Var.f3117e) && C0758ba.m2404a(this.f3118f, h70Var.f3118f) && C0758ba.m2404a(this.f3119g, h70Var.f3119g);
    }

    public int hashCode() {
        return C0758ba.m2405b(this.f3114b, this.f3113a, this.f3115c, this.f3116d, this.f3117e, this.f3118f, this.f3119g);
    }

    public String toString() {
        C0758ba.a m2406c = C0758ba.m2406c(this);
        m2406c.m2407a("applicationId", this.f3114b);
        m2406c.m2407a("apiKey", this.f3113a);
        m2406c.m2407a("databaseUrl", this.f3115c);
        m2406c.m2407a("gcmSenderId", this.f3117e);
        m2406c.m2407a("storageBucket", this.f3118f);
        m2406c.m2407a("projectId", this.f3119g);
        return m2406c.toString();
    }
}
