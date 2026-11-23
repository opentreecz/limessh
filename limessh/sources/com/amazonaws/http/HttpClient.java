package com.amazonaws.http;

import java.io.IOException;

/* loaded from: classes.dex */
public interface HttpClient {
    /* renamed from: a */
    HttpResponse mo171a(HttpRequest httpRequest) throws IOException;

    void shutdown();
}
