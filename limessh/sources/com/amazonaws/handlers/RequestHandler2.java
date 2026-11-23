package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.Response;

/* loaded from: classes.dex */
public abstract class RequestHandler2 {
    /* renamed from: a */
    public static RequestHandler2 m138a(RequestHandler requestHandler) {
        return new RequestHandler2Adaptor(requestHandler);
    }

    /* renamed from: b */
    public abstract void mo139b(Request<?> request, Response<?> response, Exception exc);

    /* renamed from: c */
    public abstract void mo140c(Request<?> request, Response<?> response);

    /* renamed from: d */
    public abstract void mo141d(Request<?> request);
}
