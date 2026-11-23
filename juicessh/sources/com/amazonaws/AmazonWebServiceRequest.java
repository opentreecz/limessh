package com.amazonaws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.metrics.RequestMetricCollector;

/* loaded from: classes.dex */
public abstract class AmazonWebServiceRequest implements Cloneable {

    /* renamed from: O */
    public final RequestClientOptions f44O = new RequestClientOptions();

    /* renamed from: P */
    @Deprecated
    public RequestMetricCollector f45P;

    /* renamed from: Q */
    public AWSCredentials f46Q;

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AmazonWebServiceRequest clone() {
        try {
            AmazonWebServiceRequest amazonWebServiceRequest = (AmazonWebServiceRequest) super.clone();
            amazonWebServiceRequest.m30i(this);
            return amazonWebServiceRequest;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }

    /* renamed from: c */
    public RequestClientOptions m27c() {
        return this.f44O;
    }

    /* renamed from: d */
    public AWSCredentials m28d() {
        return this.f46Q;
    }

    @Deprecated
    /* renamed from: e */
    public RequestMetricCollector m29e() {
        return this.f45P;
    }

    /* renamed from: i */
    public final void m30i(AmazonWebServiceRequest amazonWebServiceRequest) {
    }
}
