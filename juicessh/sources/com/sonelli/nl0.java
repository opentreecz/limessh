package com.sonelli;

import android.content.Context;
import android.graphics.Bitmap;
import com.squareup.picasso.Cache;
import java.util.LinkedHashMap;
import java.util.Objects;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class nl0 implements Cache {

    /* renamed from: a */
    public final LinkedHashMap<String, Bitmap> f5304a;

    /* renamed from: b */
    public final int f5305b;

    /* renamed from: c */
    public int f5306c;

    /* renamed from: d */
    public int f5307d;

    /* renamed from: e */
    public int f5308e;

    /* renamed from: f */
    public int f5309f;

    /* renamed from: g */
    public int f5310g;

    public nl0(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.f5305b = i;
        this.f5304a = new LinkedHashMap<>(0, 0.75f, true);
    }

    public nl0(Context context) {
        this(bm0.m2561b(context));
    }

    @Override // com.squareup.picasso.Cache
    /* renamed from: a */
    public Bitmap mo6735a(String str) {
        Objects.requireNonNull(str, "key == null");
        synchronized (this) {
            Bitmap bitmap = this.f5304a.get(str);
            if (bitmap != null) {
                this.f5309f++;
                return bitmap;
            }
            this.f5310g++;
            return null;
        }
    }

    @Override // com.squareup.picasso.Cache
    /* renamed from: b */
    public final synchronized int mo6736b() {
        return this.f5305b;
    }

    @Override // com.squareup.picasso.Cache
    /* renamed from: c */
    public void mo6737c(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        synchronized (this) {
            this.f5307d++;
            this.f5306c += bm0.m2569j(bitmap);
            Bitmap put = this.f5304a.put(str, bitmap);
            if (put != null) {
                this.f5306c -= bm0.m2569j(put);
            }
        }
        m6738d(this.f5305b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0070, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m6738d(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.f5306c     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f5304a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r3.f5306c     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L52
        L11:
            int r0 = r3.f5306c     // Catch: java.lang.Throwable -> L71
            if (r0 <= r4) goto L50
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f5304a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r0 = r3.f5304a     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r2 = r3.f5304a     // Catch: java.lang.Throwable -> L71
            r2.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r1 = r3.f5306c     // Catch: java.lang.Throwable -> L71
            int r0 = com.sonelli.bm0.m2569j(r0)     // Catch: java.lang.Throwable -> L71
            int r1 = r1 - r0
            r3.f5306c = r1     // Catch: java.lang.Throwable -> L71
            int r0 = r3.f5308e     // Catch: java.lang.Throwable -> L71
            int r0 = r0 + 1
            r3.f5308e = r0     // Catch: java.lang.Throwable -> L71
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L71
            goto L0
        L50:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L71
            return
        L52:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r0.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L71
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L71
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L71
            throw r4     // Catch: java.lang.Throwable -> L71
        L71:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L71
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.nl0.m6738d(int):void");
    }

    @Override // com.squareup.picasso.Cache
    public final synchronized int size() {
        return this.f5306c;
    }
}
