package com.amazonaws.handlers;

import com.amazonaws.auth.AWSCredentials;

/* loaded from: classes.dex */
public abstract class CredentialsRequestHandler extends RequestHandler2 {

    /* renamed from: a */
    public AWSCredentials f108a;

    /* renamed from: e */
    public void m132e(AWSCredentials aWSCredentials) {
        this.f108a = aWSCredentials;
    }
}
