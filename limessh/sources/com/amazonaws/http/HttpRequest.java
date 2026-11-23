package com.amazonaws.http;

import com.amazonaws.util.StringUtils;
import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpRequest {

    /* renamed from: a */
    public final String f130a;

    /* renamed from: b */
    public URI f131b;

    /* renamed from: c */
    public final Map<String, String> f132c;

    /* renamed from: d */
    public final InputStream f133d;

    /* renamed from: e */
    public boolean f134e;

    public HttpRequest(String str, URI uri, Map<String, String> map, InputStream inputStream) {
        this.f130a = StringUtils.m680e(str);
        this.f131b = uri;
        this.f132c = map == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(map);
        this.f133d = inputStream;
    }

    /* renamed from: a */
    public InputStream m172a() {
        return this.f133d;
    }

    /* renamed from: b */
    public long m173b() {
        String str;
        Map<String, String> map = this.f132c;
        if (map == null || (str = map.get("Content-Length")) == null || str.isEmpty()) {
            return 0L;
        }
        return Long.valueOf(str).longValue();
    }

    /* renamed from: c */
    public Map<String, String> m174c() {
        return this.f132c;
    }

    /* renamed from: d */
    public String m175d() {
        return this.f130a;
    }

    /* renamed from: e */
    public URI m176e() {
        return this.f131b;
    }

    /* renamed from: f */
    public boolean m177f() {
        return this.f134e;
    }

    /* renamed from: g */
    public void m178g(boolean z) {
        this.f134e = z;
    }
}
