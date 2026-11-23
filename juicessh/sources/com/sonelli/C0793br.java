package com.sonelli;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.gms.internal.measurement.zzjl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.br */
/* loaded from: classes.dex */
public final class C0793br implements zzjl {

    /* renamed from: A */
    public static final AbstractC1559ml<Long> f1783A;

    /* renamed from: B */
    public static final AbstractC1559ml<Long> f1784B;

    /* renamed from: C */
    public static final AbstractC1559ml<Long> f1785C;

    /* renamed from: D */
    public static final AbstractC1559ml<Long> f1786D;

    /* renamed from: E */
    public static final AbstractC1559ml<Long> f1787E;

    /* renamed from: F */
    public static final AbstractC1559ml<String> f1788F;

    /* renamed from: G */
    public static final AbstractC1559ml<Long> f1789G;

    /* renamed from: a */
    public static final AbstractC1559ml<Long> f1790a;

    /* renamed from: b */
    public static final AbstractC1559ml<Long> f1791b;

    /* renamed from: c */
    public static final AbstractC1559ml<String> f1792c;

    /* renamed from: d */
    public static final AbstractC1559ml<String> f1793d;

    /* renamed from: e */
    public static final AbstractC1559ml<Long> f1794e;

    /* renamed from: f */
    public static final AbstractC1559ml<Long> f1795f;

    /* renamed from: g */
    public static final AbstractC1559ml<Long> f1796g;

    /* renamed from: h */
    public static final AbstractC1559ml<Long> f1797h;

    /* renamed from: i */
    public static final AbstractC1559ml<Long> f1798i;

    /* renamed from: j */
    public static final AbstractC1559ml<Long> f1799j;

    /* renamed from: k */
    public static final AbstractC1559ml<Long> f1800k;

    /* renamed from: l */
    public static final AbstractC1559ml<Long> f1801l;

    /* renamed from: m */
    public static final AbstractC1559ml<Long> f1802m;

    /* renamed from: n */
    public static final AbstractC1559ml<Long> f1803n;

    /* renamed from: o */
    public static final AbstractC1559ml<Long> f1804o;

    /* renamed from: p */
    public static final AbstractC1559ml<Long> f1805p;

    /* renamed from: q */
    public static final AbstractC1559ml<Long> f1806q;

    /* renamed from: r */
    public static final AbstractC1559ml<Long> f1807r;

    /* renamed from: s */
    public static final AbstractC1559ml<Long> f1808s;

    /* renamed from: t */
    public static final AbstractC1559ml<Long> f1809t;

    /* renamed from: u */
    public static final AbstractC1559ml<Long> f1810u;

    /* renamed from: v */
    public static final AbstractC1559ml<Long> f1811v;

    /* renamed from: w */
    public static final AbstractC1559ml<Long> f1812w;

    /* renamed from: x */
    public static final AbstractC1559ml<Long> f1813x;

    /* renamed from: y */
    public static final AbstractC1559ml<Long> f1814y;

    /* renamed from: z */
    public static final AbstractC1559ml<Long> f1815z;

    static {
        C1875sl c1875sl = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement"));
        f1790a = c1875sl.m8462b("measurement.ad_id_cache_time", 10000L);
        f1791b = c1875sl.m8462b("measurement.config.cache_time", 86400000L);
        c1875sl.m8463c("measurement.log_tag", "FA");
        f1792c = c1875sl.m8463c("measurement.config.url_authority", "app-measurement.com");
        f1793d = c1875sl.m8463c("measurement.config.url_scheme", "https");
        f1794e = c1875sl.m8462b("measurement.upload.debug_upload_interval", 1000L);
        f1795f = c1875sl.m8462b("measurement.lifetimevalue.max_currency_tracked", 4L);
        f1796g = c1875sl.m8462b("measurement.store.max_stored_events_per_app", 100000L);
        f1797h = c1875sl.m8462b("measurement.experiment.max_ids", 50L);
        f1798i = c1875sl.m8462b("measurement.audience.filter_result_max_count", 200L);
        f1799j = c1875sl.m8462b("measurement.alarm_manager.minimum_interval", 60000L);
        f1800k = c1875sl.m8462b("measurement.upload.minimum_delay", 500L);
        f1801l = c1875sl.m8462b("measurement.monitoring.sample_period_millis", 86400000L);
        f1802m = c1875sl.m8462b("measurement.upload.realtime_upload_interval", 10000L);
        f1803n = c1875sl.m8462b("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        c1875sl.m8462b("measurement.config.cache_time.service", 3600000L);
        f1804o = c1875sl.m8462b("measurement.service_client.idle_disconnect_millis", 5000L);
        c1875sl.m8463c("measurement.log_tag.service", "FA-SVC");
        f1805p = c1875sl.m8462b("measurement.upload.stale_data_deletion_interval", 86400000L);
        f1806q = c1875sl.m8462b("measurement.upload.backoff_period", 43200000L);
        f1807r = c1875sl.m8462b("measurement.upload.initial_upload_delay_time", 15000L);
        f1808s = c1875sl.m8462b("measurement.upload.interval", 3600000L);
        f1809t = c1875sl.m8462b("measurement.upload.max_bundle_size", PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        f1810u = c1875sl.m8462b("measurement.upload.max_bundles", 100L);
        f1811v = c1875sl.m8462b("measurement.upload.max_conversions_per_day", 500L);
        f1812w = c1875sl.m8462b("measurement.upload.max_error_events_per_day", 1000L);
        f1813x = c1875sl.m8462b("measurement.upload.max_events_per_bundle", 1000L);
        f1814y = c1875sl.m8462b("measurement.upload.max_events_per_day", 100000L);
        f1815z = c1875sl.m8462b("measurement.upload.max_public_events_per_day", 50000L);
        f1783A = c1875sl.m8462b("measurement.upload.max_queue_time", 2419200000L);
        f1784B = c1875sl.m8462b("measurement.upload.max_realtime_events_per_day", 10L);
        f1785C = c1875sl.m8462b("measurement.upload.max_batch_size", PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        f1786D = c1875sl.m8462b("measurement.upload.retry_count", 6L);
        f1787E = c1875sl.m8462b("measurement.upload.retry_time", 1800000L);
        f1788F = c1875sl.m8463c("measurement.upload.url", "https://app-measurement.com/a");
        f1789G = c1875sl.m8462b("measurement.upload.window_interval", 3600000L);
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: A */
    public final long mo1330A() {
        return f1811v.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: B */
    public final long mo1331B() {
        return f1786D.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: C */
    public final long mo1332C() {
        return f1799j.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: D */
    public final long mo1333D() {
        return f1783A.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: E */
    public final long mo1334E() {
        return f1808s.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: F */
    public final long mo1335F() {
        return f1800k.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: G */
    public final long mo1336G() {
        return f1784B.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: a */
    public final long mo1337a() {
        return f1790a.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: b */
    public final long mo1338b() {
        return f1791b.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: c */
    public final String mo1339c() {
        return f1792c.m6459n();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: d */
    public final String mo1340d() {
        return f1793d.m6459n();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: e */
    public final long mo1341e() {
        return f1794e.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: f */
    public final long mo1342f() {
        return f1810u.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: g */
    public final long mo1343g() {
        return f1806q.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: h */
    public final long mo1344h() {
        return f1803n.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: i */
    public final long mo1345i() {
        return f1802m.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: j */
    public final long mo1346j() {
        return f1807r.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: k */
    public final long mo1347k() {
        return f1795f.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: l */
    public final long mo1348l() {
        return f1787E.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: m */
    public final long mo1349m() {
        return f1796g.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: n */
    public final long mo1350n() {
        return f1809t.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: o */
    public final long mo1351o() {
        return f1805p.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: p */
    public final long mo1352p() {
        return f1814y.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: q */
    public final long mo1353q() {
        return f1797h.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: r */
    public final long mo1354r() {
        return f1789G.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: s */
    public final long mo1355s() {
        return f1815z.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: t */
    public final long mo1356t() {
        return f1798i.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: u */
    public final long mo1357u() {
        return f1812w.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: v */
    public final long mo1358v() {
        return f1804o.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: w */
    public final long mo1359w() {
        return f1813x.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: x */
    public final String mo1360x() {
        return f1788F.m6459n();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: y */
    public final long mo1361y() {
        return f1801l.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjl
    /* renamed from: z */
    public final long mo1362z() {
        return f1785C.m6459n().longValue();
    }
}
