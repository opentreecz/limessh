package com.sonelli;

import android.content.Context;
import android.net.Uri;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;
import com.squareup.picasso.Downloader;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: OkHttpDownloader.java */
/* loaded from: classes.dex */
public class rl0 implements Downloader {

    /* renamed from: a */
    public final OkUrlFactory f6240a;

    public rl0(Context context) {
        this(bm0.m2565f(context));
    }

    public rl0(OkHttpClient okHttpClient) {
        this.f6240a = new OkUrlFactory(okHttpClient);
    }

    public rl0(File file) {
        this(file, bm0.m2560a(file));
    }

    public rl0(File file, long j) {
        this(new OkHttpClient());
        try {
            this.f6240a.client().setCache(new Cache(file, j));
        } catch (IOException unused) {
        }
    }

    @Override // com.squareup.picasso.Downloader
    /* renamed from: a */
    public Downloader.C2448a mo2146a(Uri uri, boolean z) throws IOException {
        HttpURLConnection m8144b = m8144b(uri);
        m8144b.setUseCaches(true);
        if (z) {
            m8144b.setRequestProperty("Cache-Control", "only-if-cached,max-age=2147483647");
        }
        int responseCode = m8144b.getResponseCode();
        if (responseCode < 300) {
            String headerField = m8144b.getHeaderField("OkHttp-Response-Source");
            if (headerField == null) {
                headerField = m8144b.getHeaderField("X-Android-Response-Source");
            }
            return new Downloader.C2448a(m8144b.getInputStream(), bm0.m2581v(headerField), m8144b.getHeaderFieldInt("Content-Length", -1));
        }
        m8144b.disconnect();
        throw new Downloader.C2449b(responseCode + " " + m8144b.getResponseMessage());
    }

    /* renamed from: b */
    public HttpURLConnection m8144b(Uri uri) throws IOException {
        HttpURLConnection open = this.f6240a.open(new URL(uri.toString()));
        open.setConnectTimeout(15000);
        open.setReadTimeout(20000);
        return open;
    }
}
