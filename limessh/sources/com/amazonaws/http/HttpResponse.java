package com.amazonaws.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: classes.dex */
public class HttpResponse {

    /* renamed from: a */
    public final String f135a;

    /* renamed from: b */
    public final int f136b;

    /* renamed from: c */
    public final InputStream f137c;

    /* renamed from: d */
    public final Map<String, String> f138d;

    /* renamed from: e */
    public InputStream f139e;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a */
        public String f140a;

        /* renamed from: b */
        public int f141b;

        /* renamed from: c */
        public InputStream f142c;

        /* renamed from: d */
        public final Map<String, String> f143d = new HashMap();

        /* renamed from: a */
        public HttpResponse m188a() {
            return new HttpResponse(this.f140a, this.f141b, Collections.unmodifiableMap(this.f143d), this.f142c);
        }

        /* renamed from: b */
        public Builder m189b(InputStream inputStream) {
            this.f142c = inputStream;
            return this;
        }

        /* renamed from: c */
        public Builder m190c(String str, String str2) {
            this.f143d.put(str, str2);
            return this;
        }

        /* renamed from: d */
        public Builder m191d(int i) {
            this.f141b = i;
            return this;
        }

        /* renamed from: e */
        public Builder m192e(String str) {
            this.f140a = str;
            return this;
        }
    }

    public HttpResponse(String str, int i, Map<String, String> map, InputStream inputStream) {
        this.f135a = str;
        this.f136b = i;
        this.f138d = map;
        this.f137c = inputStream;
    }

    /* renamed from: a */
    public static Builder m182a() {
        return new Builder();
    }

    /* renamed from: b */
    public InputStream m183b() throws IOException {
        if (this.f139e == null) {
            synchronized (this) {
                if (this.f137c == null || !"gzip".equals(this.f138d.get("Content-Encoding"))) {
                    this.f139e = this.f137c;
                } else {
                    this.f139e = new GZIPInputStream(this.f137c);
                }
            }
        }
        return this.f139e;
    }

    /* renamed from: c */
    public Map<String, String> m184c() {
        return this.f138d;
    }

    /* renamed from: d */
    public InputStream m185d() throws IOException {
        return this.f137c;
    }

    /* renamed from: e */
    public int m186e() {
        return this.f136b;
    }

    /* renamed from: f */
    public String m187f() {
        return this.f135a;
    }
}
