package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public interface Downloader {

    /* renamed from: com.squareup.picasso.Downloader$a */
    /* loaded from: classes.dex */
    public static class C2448a {

        /* renamed from: a */
        public final InputStream f8614a;

        /* renamed from: b */
        public final Bitmap f8615b;

        /* renamed from: c */
        public final boolean f8616c;

        /* renamed from: d */
        public final long f8617d;

        public C2448a(InputStream inputStream, boolean z, long j) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.f8614a = inputStream;
            this.f8615b = null;
            this.f8616c = z;
            this.f8617d = j;
        }

        /* renamed from: a */
        public Bitmap m10672a() {
            return this.f8615b;
        }

        /* renamed from: b */
        public long m10673b() {
            return this.f8617d;
        }

        /* renamed from: c */
        public InputStream m10674c() {
            return this.f8614a;
        }
    }

    /* renamed from: com.squareup.picasso.Downloader$b */
    /* loaded from: classes.dex */
    public static class C2449b extends IOException {
        public C2449b(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    C2448a mo2146a(Uri uri, boolean z) throws IOException;
}
