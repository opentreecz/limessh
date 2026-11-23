package com.amazonaws.auth;

/* loaded from: classes.dex */
public class BasicSessionCredentials implements AWSSessionCredentials {

    /* renamed from: a */
    public final String f94a;

    /* renamed from: b */
    public final String f95b;

    /* renamed from: c */
    public final String f96c;

    public BasicSessionCredentials(String str, String str2, String str3) {
        this.f94a = str;
        this.f95b = str2;
        this.f96c = str3;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    /* renamed from: a */
    public String mo96a() {
        return this.f94a;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    /* renamed from: b */
    public String mo97b() {
        return this.f95b;
    }

    @Override // com.amazonaws.auth.AWSSessionCredentials
    public String getSessionToken() {
        return this.f96c;
    }
}
