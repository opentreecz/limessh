package com.sonelli;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build;
import com.squareup.picasso.Downloader;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: UrlConnectionDownloader.java */
/* loaded from: classes.dex */
public class am0 implements Downloader {

    /* renamed from: b */
    public static final Object f1450b = new Object();

    /* renamed from: c */
    public static volatile Object f1451c;

    /* renamed from: a */
    public final Context f1452a;

    /* compiled from: UrlConnectionDownloader.java */
    /* renamed from: com.sonelli.am0$a */
    /* loaded from: classes.dex */
    public static class C0721a {
        /* renamed from: a */
        public static Object m2148a(Context context) throws IOException {
            File m2565f = bm0.m2565f(context);
            HttpResponseCache installed = HttpResponseCache.getInstalled();
            return installed == null ? HttpResponseCache.install(m2565f, bm0.m2560a(m2565f)) : installed;
        }
    }

    public am0(Context context) {
        this.f1452a = context.getApplicationContext();
    }

    /* renamed from: b */
    public static void m2145b(Context context) {
        if (f1451c == null) {
            try {
                synchronized (f1450b) {
                    if (f1451c == null) {
                        f1451c = C0721a.m2148a(context);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.squareup.picasso.Downloader
    /* renamed from: a */
    public Downloader.C2448a mo2146a(Uri uri, boolean z) throws IOException {
        if (Build.VERSION.SDK_INT >= 14) {
            m2145b(this.f1452a);
        }
        HttpURLConnection m2147c = m2147c(uri);
        m2147c.setUseCaches(true);
        if (z) {
            m2147c.setRequestProperty("Cache-Control", "only-if-cached,max-age=2147483647");
        }
        int responseCode = m2147c.getResponseCode();
        if (responseCode < 300) {
            return new Downloader.C2448a(m2147c.getInputStream(), bm0.m2581v(m2147c.getHeaderField("X-Android-Response-Source")), m2147c.getHeaderFieldInt("Content-Length", -1));
        }
        m2147c.disconnect();
        throw new Downloader.C2449b(responseCode + " " + m2147c.getResponseMessage());
    }

    /* renamed from: c */
    public HttpURLConnection m2147c(Uri uri) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        return httpURLConnection;
    }
}
