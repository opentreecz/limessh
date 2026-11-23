package cz.opentree;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: cz.opentree.bh */
/* loaded from: classes.dex */
public final class C0770bh {

    /* renamed from: A */
    public static C0824ch<Long> f1671A;

    /* renamed from: B */
    public static C0824ch<Long> f1672B;

    /* renamed from: C */
    public static C0824ch<Long> f1673C;

    /* renamed from: D */
    public static C0824ch<Long> f1674D;

    /* renamed from: E */
    public static C0824ch<Boolean> f1675E;

    /* renamed from: a */
    public static C0824ch<Boolean> f1676a;

    /* renamed from: b */
    public static C0824ch<String> f1677b;

    /* renamed from: c */
    public static C0824ch<Integer> f1678c;

    /* renamed from: d */
    public static C0824ch<Long> f1679d;

    /* renamed from: e */
    public static C0824ch<Long> f1680e;

    /* renamed from: f */
    public static C0824ch<Long> f1681f;

    /* renamed from: g */
    public static C0824ch<Long> f1682g;

    /* renamed from: h */
    public static C0824ch<Integer> f1683h;

    /* renamed from: i */
    public static C0824ch<Integer> f1684i;

    /* renamed from: j */
    public static C0824ch<String> f1685j;

    /* renamed from: k */
    public static C0824ch<String> f1686k;

    /* renamed from: l */
    public static C0824ch<String> f1687l;

    /* renamed from: m */
    public static C0824ch<String> f1688m;

    /* renamed from: n */
    public static C0824ch<Integer> f1689n;

    /* renamed from: o */
    public static C0824ch<String> f1690o;

    /* renamed from: p */
    public static C0824ch<String> f1691p;

    /* renamed from: q */
    public static C0824ch<Integer> f1692q;

    /* renamed from: r */
    public static C0824ch<Integer> f1693r;

    /* renamed from: s */
    public static C0824ch<Integer> f1694s;

    /* renamed from: t */
    public static C0824ch<String> f1695t;

    /* renamed from: u */
    public static C0824ch<Integer> f1696u;

    /* renamed from: v */
    public static C0824ch<Integer> f1697v;

    /* renamed from: w */
    public static C0824ch<Integer> f1698w;

    /* renamed from: x */
    public static C0824ch<Long> f1699x;

    /* renamed from: y */
    public static C0824ch<Boolean> f1700y;

    /* renamed from: z */
    public static C0824ch<Long> f1701z;

    static {
        C0824ch.m2800f("analytics.service_enabled", false, false);
        f1676a = C0824ch.m2800f("analytics.service_client_enabled", true, true);
        f1677b = C0824ch.m2799e("analytics.log_tag", "GAv4", "GAv4-SVC");
        C0824ch.m2798d("analytics.max_tokens", 60L, 60L);
        C0824ch.m2796b("analytics.tokens_per_sec", 0.5f, 0.5f);
        f1678c = C0824ch.m2797c("analytics.max_stored_hits", RecyclerView.MAX_SCROLL_DURATION, 20000);
        C0824ch.m2797c("analytics.max_stored_hits_per_app", RecyclerView.MAX_SCROLL_DURATION, RecyclerView.MAX_SCROLL_DURATION);
        C0824ch.m2797c("analytics.max_stored_properties_per_app", 100, 100);
        f1679d = C0824ch.m2798d("analytics.local_dispatch_millis", 1800000L, 120000L);
        f1680e = C0824ch.m2798d("analytics.initial_local_dispatch_millis", 5000L, 5000L);
        C0824ch.m2798d("analytics.min_local_dispatch_millis", 120000L, 120000L);
        C0824ch.m2798d("analytics.max_local_dispatch_millis", 7200000L, 7200000L);
        f1681f = C0824ch.m2798d("analytics.dispatch_alarm_millis", 7200000L, 7200000L);
        f1682g = C0824ch.m2798d("analytics.max_dispatch_alarm_millis", 32400000L, 32400000L);
        f1683h = C0824ch.m2797c("analytics.max_hits_per_dispatch", 20, 20);
        f1684i = C0824ch.m2797c("analytics.max_hits_per_batch", 20, 20);
        f1685j = C0824ch.m2799e("analytics.insecure_host", "http://www.google-analytics.com", "http://www.google-analytics.com");
        f1686k = C0824ch.m2799e("analytics.secure_host", "https://ssl.google-analytics.com", "https://ssl.google-analytics.com");
        f1687l = C0824ch.m2799e("analytics.simple_endpoint", "/collect", "/collect");
        f1688m = C0824ch.m2799e("analytics.batching_endpoint", "/batch", "/batch");
        f1689n = C0824ch.m2797c("analytics.max_get_length", 2036, 2036);
        EnumC1603ng enumC1603ng = EnumC1603ng.BATCH_BY_COUNT;
        f1690o = C0824ch.m2799e("analytics.batching_strategy.k", enumC1603ng.name(), enumC1603ng.name());
        String name = EnumC1859sg.GZIP.name();
        f1691p = C0824ch.m2799e("analytics.compression_strategy.k", name, name);
        C0824ch.m2797c("analytics.max_hits_per_request.k", 20, 20);
        f1692q = C0824ch.m2797c("analytics.max_hit_length.k", 8192, 8192);
        f1693r = C0824ch.m2797c("analytics.max_post_length.k", 8192, 8192);
        f1694s = C0824ch.m2797c("analytics.max_batch_post_length", 8192, 8192);
        f1695t = C0824ch.m2799e("analytics.fallback_responses.k", "404,502", "404,502");
        f1696u = C0824ch.m2797c("analytics.batch_retry_interval.seconds.k", 3600, 3600);
        C0824ch.m2798d("analytics.service_monitor_interval", 86400000L, 86400000L);
        f1697v = C0824ch.m2797c("analytics.http_connection.connect_timeout_millis", 60000, 60000);
        f1698w = C0824ch.m2797c("analytics.http_connection.read_timeout_millis", 61000, 61000);
        f1699x = C0824ch.m2798d("analytics.campaigns.time_limit", 86400000L, 86400000L);
        C0824ch.m2799e("analytics.first_party_experiment_id", "", "");
        C0824ch.m2797c("analytics.first_party_experiment_variant", 0, 0);
        f1700y = C0824ch.m2800f("analytics.test.disable_receiver", false, false);
        f1701z = C0824ch.m2798d("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
        f1671A = C0824ch.m2798d("analytics.service_client.connect_timeout_millis", 5000L, 5000L);
        C0824ch.m2798d("analytics.service_client.second_connect_delay_millis", 5000L, 5000L);
        C0824ch.m2798d("analytics.service_client.unexpected_reconnect_millis", 60000L, 60000L);
        f1672B = C0824ch.m2798d("analytics.service_client.reconnect_throttle_millis", 1800000L, 1800000L);
        f1673C = C0824ch.m2798d("analytics.monitoring.sample_period_millis", 86400000L, 86400000L);
        f1674D = C0824ch.m2798d("analytics.initialization_warning_threshold", 5000L, 5000L);
        f1675E = C0824ch.m2800f("analytics.gcm_task_service", false, false);
    }
}
