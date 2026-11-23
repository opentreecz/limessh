package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.util.AWSRequestMetrics;

/* loaded from: classes.dex */
public final class RequestHandler2Adaptor extends RequestHandler2 {

    /* renamed from: a */
    public final RequestHandler f109a;

    public RequestHandler2Adaptor(RequestHandler requestHandler) {
        if (requestHandler == null) {
            throw new IllegalArgumentException();
        }
        this.f109a = requestHandler;
    }

    @Override // com.amazonaws.handlers.RequestHandler2
    /* renamed from: b */
    public void mo139b(Request<?> request, Response<?> response, Exception exc) {
        this.f109a.mo131c(request, exc);
    }

    @Override // com.amazonaws.handlers.RequestHandler2
    /* renamed from: c */
    public void mo140c(Request<?> request, Response<?> response) {
        AWSRequestMetrics mo47c = request == null ? null : request.mo47c();
        this.f109a.mo137b(request, response == null ? null : response.m65a(), mo47c != null ? mo47c.m626c() : null);
    }

    @Override // com.amazonaws.handlers.RequestHandler2
    /* renamed from: d */
    public void mo141d(Request<?> request) {
        this.f109a.mo136a(request);
    }

    public boolean equals(Object obj) {
        if (obj instanceof RequestHandler2Adaptor) {
            return this.f109a.equals(((RequestHandler2Adaptor) obj).f109a);
        }
        return false;
    }

    public int hashCode() {
        return this.f109a.hashCode();
    }
}
