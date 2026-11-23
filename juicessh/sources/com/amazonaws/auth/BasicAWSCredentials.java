package com.amazonaws.auth;

/* loaded from: classes.dex */
public class BasicAWSCredentials implements AWSCredentials {

    /* renamed from: a */
    public final String f92a;

    /* renamed from: b */
    public final String f93b;

    public BasicAWSCredentials(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Access key cannot be null.");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("Secret key cannot be null.");
        }
        this.f92a = str;
        this.f93b = str2;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    /* renamed from: a */
    public String mo96a() {
        return this.f92a;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    /* renamed from: b */
    public String mo97b() {
        return this.f93b;
    }
}
