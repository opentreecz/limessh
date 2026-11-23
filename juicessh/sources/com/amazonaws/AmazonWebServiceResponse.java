package com.amazonaws;

/* loaded from: classes.dex */
public class AmazonWebServiceResponse<T> {

    /* renamed from: a */
    public T f47a;

    /* renamed from: b */
    public ResponseMetadata f48b;

    /* renamed from: a */
    public String m31a() {
        ResponseMetadata responseMetadata = this.f48b;
        if (responseMetadata == null) {
            return null;
        }
        return responseMetadata.m66a();
    }

    /* renamed from: b */
    public T m32b() {
        return this.f47a;
    }

    /* renamed from: c */
    public void m33c(ResponseMetadata responseMetadata) {
        this.f48b = responseMetadata;
    }

    /* renamed from: d */
    public void m34d(T t) {
        this.f47a = t;
    }
}
