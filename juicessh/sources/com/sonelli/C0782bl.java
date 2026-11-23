package com.sonelli;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzcg;
import com.google.android.gms.internal.measurement.zzch;
import com.google.android.gms.internal.measurement.zzci;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.bl */
/* loaded from: classes.dex */
public final class C0782bl implements zzcg {

    /* renamed from: g */
    @GuardedBy("ConfigurationContentLoader.class")
    public static final Map<Uri, C0782bl> f1764g = new ArrayMap();

    /* renamed from: h */
    public static final String[] f1765h = {"key", "value"};

    /* renamed from: a */
    public final ContentResolver f1766a;

    /* renamed from: b */
    public final Uri f1767b;

    /* renamed from: c */
    public final ContentObserver f1768c;

    /* renamed from: d */
    public final Object f1769d;

    /* renamed from: e */
    public volatile Map<String, String> f1770e;

    /* renamed from: f */
    @GuardedBy("this")
    public final List<zzch> f1771f;

    public C0782bl(ContentResolver contentResolver, Uri uri) {
        C0887dl c0887dl = new C0887dl(this, null);
        this.f1768c = c0887dl;
        this.f1769d = new Object();
        this.f1771f = new ArrayList();
        this.f1766a = contentResolver;
        this.f1767b = uri;
        contentResolver.registerContentObserver(uri, false, c0887dl);
    }

    /* renamed from: a */
    public static C0782bl m2551a(ContentResolver contentResolver, Uri uri) {
        C0782bl c0782bl;
        synchronized (C0782bl.class) {
            Map<Uri, C0782bl> map = f1764g;
            c0782bl = map.get(uri);
            if (c0782bl == null) {
                try {
                    C0782bl c0782bl2 = new C0782bl(contentResolver, uri);
                    try {
                        map.put(uri, c0782bl2);
                    } catch (SecurityException unused) {
                    }
                    c0782bl = c0782bl2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return c0782bl;
    }

    /* renamed from: d */
    public static synchronized void m2552d() {
        synchronized (C0782bl.class) {
            for (C0782bl c0782bl : f1764g.values()) {
                c0782bl.f1766a.unregisterContentObserver(c0782bl.f1768c);
            }
            f1764g.clear();
        }
    }

    /* renamed from: b */
    public final Map<String, String> m2553b() {
        Map<String, String> map = this.f1770e;
        if (map == null) {
            synchronized (this.f1769d) {
                map = this.f1770e;
                if (map == null) {
                    map = m2556g();
                    this.f1770e = map;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    /* renamed from: c */
    public final void m2554c() {
        synchronized (this.f1769d) {
            this.f1770e = null;
            AbstractC1559ml.m6449g();
        }
        synchronized (this) {
            Iterator<zzch> it = this.f1771f.iterator();
            while (it.hasNext()) {
                it.next().m1220a();
            }
        }
    }

    /* renamed from: e */
    public final /* synthetic */ Map m2555e() {
        Cursor query = this.f1766a.query(this.f1767b, f1765h, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
            while (query.moveToNext()) {
                arrayMap.put(query.getString(0), query.getString(1));
            }
            return arrayMap;
        } finally {
            query.close();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcg
    /* renamed from: f */
    public final /* synthetic */ Object mo1219f(String str) {
        return m2553b().get(str);
    }

    /* renamed from: g */
    public final Map<String, String> m2556g() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) C0996fl.m3779a(new zzci(this) { // from class: com.sonelli.el

                    /* renamed from: a */
                    public final C0782bl f2492a;

                    {
                        this.f2492a = this;
                    }

                    @Override // com.google.android.gms.internal.measurement.zzci
                    /* renamed from: a */
                    public final Object mo1221a() {
                        return this.f2492a.m2555e();
                    }
                });
            } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return null;
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
