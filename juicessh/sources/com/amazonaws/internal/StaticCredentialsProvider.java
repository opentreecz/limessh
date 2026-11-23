package com.amazonaws.internal;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

/* loaded from: classes.dex */
public class StaticCredentialsProvider implements AWSCredentialsProvider {

    /* renamed from: a */
    public final AWSCredentials f155a;

    public StaticCredentialsProvider(AWSCredentials aWSCredentials) {
        this.f155a = aWSCredentials;
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    /* renamed from: a */
    public AWSCredentials mo98a() {
        return this.f155a;
    }
}
