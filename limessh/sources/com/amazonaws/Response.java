package com.amazonaws;

import com.amazonaws.http.HttpResponse;

/* loaded from: classes.dex */
public final class Response<T> {

    /* renamed from: a */
    public final T f79a;

    public Response(T t, HttpResponse httpResponse) {
        this.f79a = t;
    }

    /* renamed from: a */
    public T m65a() {
        return this.f79a;
    }
}
