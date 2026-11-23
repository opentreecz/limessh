package cz.opentree;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.internal.zzek;
import cz.opentree.libssh.SshLibrary;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.pu */
/* loaded from: classes.dex */
public final class C1735pu {

    /* renamed from: A */
    public static C1529ly<Long> f5778A;

    /* renamed from: A0 */
    public static C1529ly<Boolean> f5779A0;

    /* renamed from: B */
    public static C1529ly<Long> f5780B;

    /* renamed from: B0 */
    public static C1529ly<Boolean> f5781B0;

    /* renamed from: C */
    public static C1529ly<Long> f5782C;

    /* renamed from: C0 */
    public static C1529ly<Boolean> f5783C0;

    /* renamed from: D */
    public static C1529ly<Integer> f5784D;

    /* renamed from: D0 */
    public static C1529ly<Boolean> f5785D0;

    /* renamed from: E */
    public static C1529ly<Long> f5786E;

    /* renamed from: E0 */
    public static C1529ly<Boolean> f5787E0;

    /* renamed from: F */
    public static C1529ly<Integer> f5788F;

    /* renamed from: F0 */
    public static C1529ly<Boolean> f5789F0;

    /* renamed from: G */
    public static C1529ly<Integer> f5790G;

    /* renamed from: G0 */
    public static C1529ly<Boolean> f5791G0;

    /* renamed from: H */
    public static C1529ly<Integer> f5792H;

    /* renamed from: H0 */
    public static C1529ly<Boolean> f5793H0;

    /* renamed from: I */
    public static C1529ly<Integer> f5794I;

    /* renamed from: I0 */
    public static C1529ly<Boolean> f5795I0;

    /* renamed from: J */
    public static C1529ly<Integer> f5796J;

    /* renamed from: J0 */
    public static C1529ly<Boolean> f5797J0;

    /* renamed from: K */
    public static C1529ly<Long> f5798K;

    /* renamed from: K0 */
    public static C1529ly<Boolean> f5799K0;

    /* renamed from: L */
    public static C1529ly<Boolean> f5800L;

    /* renamed from: L0 */
    public static C1529ly<Boolean> f5801L0;

    /* renamed from: M */
    public static C1529ly<String> f5802M;

    /* renamed from: M0 */
    public static C1529ly<Boolean> f5803M0;

    /* renamed from: N */
    public static C1529ly<Long> f5804N;

    /* renamed from: N0 */
    public static C1529ly<Boolean> f5805N0;

    /* renamed from: O */
    public static C1529ly<Integer> f5806O;

    /* renamed from: O0 */
    public static C1529ly<Boolean> f5807O0;

    /* renamed from: P */
    public static C1529ly<Double> f5808P;

    /* renamed from: P0 */
    public static C1529ly<Boolean> f5809P0;

    /* renamed from: Q */
    public static C1529ly<Integer> f5810Q;

    /* renamed from: Q0 */
    public static C1529ly<Boolean> f5811Q0;

    /* renamed from: R */
    public static C1529ly<Integer> f5812R;

    /* renamed from: R0 */
    public static C1529ly<Boolean> f5813R0;

    /* renamed from: S */
    public static C1529ly<Boolean> f5814S;

    /* renamed from: S0 */
    public static C1529ly<Long> f5815S0;

    /* renamed from: T */
    public static C1529ly<Boolean> f5816T;

    /* renamed from: U */
    public static C1529ly<Boolean> f5817U;

    /* renamed from: V */
    public static C1529ly<Boolean> f5818V;

    /* renamed from: W */
    public static C1529ly<Boolean> f5819W;

    /* renamed from: X */
    public static C1529ly<Boolean> f5820X;

    /* renamed from: Y */
    public static C1529ly<Boolean> f5821Y;

    /* renamed from: Z */
    public static C1529ly<Boolean> f5822Z;

    /* renamed from: a0 */
    public static C1529ly<Boolean> f5824a0;

    /* renamed from: b0 */
    public static C1529ly<Boolean> f5826b0;

    /* renamed from: c0 */
    public static C1529ly<Boolean> f5828c0;

    /* renamed from: d0 */
    public static C1529ly<Boolean> f5830d0;

    /* renamed from: e0 */
    public static C1529ly<Boolean> f5832e0;

    /* renamed from: f0 */
    public static C1529ly<Boolean> f5834f0;

    /* renamed from: g0 */
    public static C1529ly<Boolean> f5836g0;

    /* renamed from: h0 */
    public static C1529ly<Boolean> f5838h0;

    /* renamed from: i0 */
    public static C1529ly<Boolean> f5840i0;

    /* renamed from: j0 */
    public static C1529ly<Boolean> f5842j0;

    /* renamed from: k0 */
    public static C1529ly<Boolean> f5844k0;

    /* renamed from: l */
    public static C1529ly<Integer> f5845l;

    /* renamed from: l0 */
    public static C1529ly<Boolean> f5846l0;

    /* renamed from: m */
    public static C1529ly<Integer> f5847m;

    /* renamed from: m0 */
    public static C1529ly<Boolean> f5848m0;

    /* renamed from: n */
    public static C1529ly<Integer> f5849n;

    /* renamed from: n0 */
    public static C1529ly<Boolean> f5850n0;

    /* renamed from: o */
    public static C1529ly<Integer> f5851o;

    /* renamed from: o0 */
    public static C1529ly<Boolean> f5852o0;

    /* renamed from: p */
    public static C1529ly<Integer> f5853p;

    /* renamed from: p0 */
    public static C1529ly<Boolean> f5854p0;

    /* renamed from: q */
    public static C1529ly<Integer> f5855q;

    /* renamed from: q0 */
    public static C1529ly<Boolean> f5856q0;

    /* renamed from: r */
    public static C1529ly<String> f5857r;

    /* renamed from: r0 */
    public static C1529ly<Boolean> f5858r0;

    /* renamed from: s */
    public static C1529ly<Long> f5859s;

    /* renamed from: s0 */
    public static C1529ly<Boolean> f5860s0;

    /* renamed from: t */
    public static C1529ly<Long> f5861t;

    /* renamed from: t0 */
    public static C1529ly<Boolean> f5862t0;

    /* renamed from: u */
    public static C1529ly<Long> f5863u;

    /* renamed from: u0 */
    public static C1529ly<Boolean> f5864u0;

    /* renamed from: v */
    public static C1529ly<Long> f5865v;

    /* renamed from: v0 */
    public static C1529ly<Boolean> f5866v0;

    /* renamed from: w */
    public static C1529ly<Long> f5867w;

    /* renamed from: w0 */
    public static C1529ly<Boolean> f5868w0;

    /* renamed from: x */
    public static C1529ly<Long> f5869x;

    /* renamed from: x0 */
    public static C1529ly<Boolean> f5870x0;

    /* renamed from: y */
    public static C1529ly<Long> f5871y;

    /* renamed from: y0 */
    public static C1529ly<Boolean> f5872y0;

    /* renamed from: z */
    public static C1529ly<Long> f5873z;

    /* renamed from: z0 */
    public static C1529ly<Boolean> f5874z0;

    /* renamed from: a */
    public static List<C1529ly<?>> f5823a = Collections.synchronizedList(new ArrayList());

    /* renamed from: b */
    public static Set<C1529ly<?>> f5825b = Collections.synchronizedSet(new HashSet());

    /* renamed from: c */
    public static C1529ly<Long> f5827c = m7497a("measurement.ad_id_cache_time", 10000L, 10000L, C1674ou.f5554a);

    /* renamed from: d */
    public static C1529ly<Long> f5829d = m7497a("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, C1834ru.f6291a);

    /* renamed from: e */
    public static C1529ly<Long> f5831e = m7497a("measurement.config.cache_time", 86400000L, 3600000L, C0797bv.f1830a);

    /* renamed from: f */
    public static C1529ly<String> f5833f = m7497a("measurement.config.url_scheme", "https", "https", C1677ov.f5558a);

    /* renamed from: g */
    public static C1529ly<String> f5835g = m7497a("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", C2314xv.f8059a);

    /* renamed from: h */
    public static C1529ly<Integer> f5837h = m7497a("measurement.upload.max_bundles", 100, 100, C1527lw.f4922a);

    /* renamed from: i */
    public static C1529ly<Integer> f5839i = m7497a("measurement.upload.max_batch_size", 65536, 65536, C2138uw.f7311a);

    /* renamed from: j */
    public static C1529ly<Integer> f5841j = m7497a("measurement.upload.max_bundle_size", 65536, 65536, C1186ix.f3442a);

    /* renamed from: k */
    public static C1529ly<Integer> f5843k = m7497a("measurement.upload.max_events_per_bundle", 1000, 1000, C1837rx.f6299a);

    static {
        Integer valueOf = Integer.valueOf(SshLibrary.SSH_S_IFREG);
        f5845l = m7497a("measurement.upload.max_events_per_day", valueOf, valueOf, C1017fy.f2780a);
        f5847m = m7497a("measurement.upload.max_error_events_per_day", 1000, 1000, C1784qu.f6105a);
        f5849n = m7497a("measurement.upload.max_public_events_per_day", 50000, 50000, C1982tu.f6861a);
        f5851o = m7497a("measurement.upload.max_conversions_per_day", 10000, 10000, C1885su.f6593a);
        f5853p = m7497a("measurement.upload.max_realtime_events_per_day", 10, 10, C2187vu.f7555a);
        f5855q = m7497a("measurement.store.max_stored_events_per_app", valueOf, valueOf, C2135uu.f7303a);
        f5857r = m7497a("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", C2392yu.f8319a);
        f5859s = m7497a("measurement.upload.backoff_period", 43200000L, 43200000L, C2243wu.f7797a);
        f5861t = m7497a("measurement.upload.window_interval", 3600000L, 3600000L, C0739av.f1531a);
        f5863u = m7497a("measurement.upload.interval", 3600000L, 3600000L, C2442zu.f8594a);
        f5865v = m7497a("measurement.upload.realtime_upload_interval", 10000L, 10000L, C0846cv.f2058a);
        f5867w = m7497a("measurement.upload.debug_upload_interval", 1000L, 1000L, C0955ev.f2540a);
        f5869x = m7497a("measurement.upload.minimum_delay", 500L, 500L, C0900dv.f2292a);
        f5871y = m7497a("measurement.alarm_manager.minimum_interval", 60000L, 60000L, C1073gv.f2986a);
        f5873z = m7497a("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, C1014fv.f2774a);
        f5778A = m7497a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, C1178iv.f3425a);
        f5780B = m7497a("measurement.upload.initial_upload_delay_time", 15000L, 15000L, C1128hv.f3231a);
        f5782C = m7497a("measurement.upload.retry_time", 1800000L, 1800000L, C1474kv.f4661a);
        f5784D = m7497a("measurement.upload.retry_count", 6, 6, C1413jv.f4386a);
        f5786E = m7497a("measurement.upload.max_queue_time", 2419200000L, 2419200000L, C1574mv.f5148a);
        f5788F = m7497a("measurement.lifetimevalue.max_currency_tracked", 4, 4, C1525lv.f4919a);
        f5790G = m7497a("measurement.audience.filter_result_max_count", 200, 200, C1622nv.f5381a);
        f5792H = m7497a("measurement.upload.max_public_user_properties", 25, 25, null);
        f5794I = m7497a("measurement.upload.max_event_name_cardinality", 500, 500, null);
        f5796J = m7497a("measurement.upload.max_public_event_params", 25, 25, null);
        f5798K = m7497a("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, C1785qv.f6106a);
        Boolean bool = Boolean.FALSE;
        f5800L = m7497a("measurement.test.boolean_flag", bool, bool, C1736pv.f5878a);
        f5802M = m7497a("measurement.test.string_flag", "---", "---", C1886sv.f6596a);
        f5804N = m7497a("measurement.test.long_flag", -1L, -1L, C1835rv.f6292a);
        f5806O = m7497a("measurement.test.int_flag", -2, -2, C2136uv.f7304a);
        Double valueOf2 = Double.valueOf(-3.0d);
        f5808P = m7497a("measurement.test.double_flag", valueOf2, valueOf2, C1983tv.f6863a);
        f5810Q = m7497a("measurement.experiment.max_ids", 50, 50, C2245wv.f7799a);
        f5812R = m7497a("measurement.max_bundles_per_iteration", 2, 2, C2188vv.f7558a);
        f5814S = m7497a("measurement.validation.internal_limits_internal_event_params", bool, bool, C2443zv.f8597a);
        Boolean bool2 = Boolean.TRUE;
        f5816T = m7497a("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", bool2, bool2, C0798bw.f1832a);
        f5817U = m7497a("measurement.collection.firebase_global_collection_flag_enabled", bool2, bool2, C0740aw.f1533a);
        f5818V = m7497a("measurement.collection.efficient_engagement_reporting_enabled_2", bool2, bool2, C0901dw.f2293a);
        f5819W = m7497a("measurement.collection.redundant_engagement_removal_enabled", bool, bool, C0847cw.f2064a);
        f5820X = m7497a("measurement.client.freeride_engagement_fix", bool2, bool2, C1015fw.f2775a);
        f5821Y = m7497a("measurement.experiment.enable_experiment_reporting", bool2, bool2, C0956ew.f2541a);
        f5822Z = m7497a("measurement.collection.log_event_and_bundle_v2", bool2, bool2, C1133hw.f3239a);
        f5824a0 = m7497a("measurement.quality.checksum", bool, bool, null);
        f5826b0 = m7497a("measurement.sdk.dynamite.use_dynamite3", bool2, bool2, C1080gw.f3016a);
        f5828c0 = m7497a("measurement.sdk.dynamite.allow_remote_dynamite", bool, bool, C1414jw.f4387a);
        f5830d0 = m7497a("measurement.sdk.collection.validate_param_names_alphabetical", bool2, bool2, C1184iw.f3435a);
        f5832e0 = m7497a("measurement.collection.event_safelist", bool2, bool2, C1475kw.f4665a);
        m7497a("measurement.service.audience.invalidate_config_cache_after_app_unisntall", bool2, bool2, C1623nw.f5385a);
        f5834f0 = m7497a("measurement.service.audience.fix_skip_audience_with_failed_filters", bool2, bool2, C1575mw.f5152a);
        f5836g0 = m7497a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, bool, C1738pw.f5881a);
        f5838h0 = m7497a("measurement.audience.refresh_event_count_filters_timestamp", bool, bool, C1678ow.f5564a);
        f5840i0 = m7497a("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, bool, C1836rw.f6295a);
        f5842j0 = m7497a("measurement.sdk.collection.retrieve_deeplink_from_bow_2", bool2, bool2, C1787qw.f6115a);
        f5844k0 = m7497a("measurement.sdk.collection.last_deep_link_referrer2", bool2, bool2, C1984tw.f6864a);
        f5846l0 = m7497a("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, bool, C1887sw.f6600a);
        f5848m0 = m7497a("measurement.sdk.collection.last_gclid_from_referrer2", bool, bool, C2189vw.f7561a);
        f5850n0 = m7497a("measurement.sdk.collection.enable_extend_user_property_size", bool2, bool2, C2315xw.f8060a);
        f5852o0 = m7497a("measurement.upload.file_lock_state_check", bool, bool, C2246ww.f7802a);
        f5854p0 = m7497a("measurement.sampling.calculate_bundle_timestamp_before_sampling", bool2, bool2, C0741ax.f1536a);
        f5856q0 = m7497a("measurement.ga.ga_app_id", bool, bool, C2396yw.f8340a);
        f5858r0 = m7497a("measurement.lifecycle.app_backgrounded_tracking", bool2, bool2, C0849cx.f2071a);
        f5860s0 = m7497a("measurement.lifecycle.app_in_background_parameter", bool, bool, C0799bx.f1833a);
        f5862t0 = m7497a("measurement.integration.disable_firebase_instance_id", bool, bool, C0958ex.f2548a);
        f5864u0 = m7497a("measurement.lifecycle.app_backgrounded_engagement", bool, bool, C0902dx.f2294a);
        f5866v0 = m7497a("measurement.collection.service.update_with_analytics_fix", bool, bool, C1081gx.f3019a);
        f5868w0 = m7497a("measurement.service.use_appinfo_modified", bool, bool, C1016fx.f2779a);
        f5870x0 = m7497a("measurement.client.firebase_feature_rollout.v1.enable", bool2, bool2, C1134hx.f3240a);
        f5872y0 = m7497a("measurement.client.sessions.check_on_reset_and_enable2", bool2, bool2, C1476kx.f4668a);
        f5874z0 = m7497a("measurement.config.string.always_update_disk_on_set", bool2, bool2, C1415jx.f4391a);
        f5779A0 = m7497a("measurement.scheduler.task_thread.cleanup_on_exit", bool, bool, C1577mx.f5159a);
        f5781B0 = m7497a("measurement.upload.file_truncate_fix", bool, bool, C1528lx.f4923a);
        f5783C0 = m7497a("measurement.engagement_time_main_thread", bool2, bool2, C1679ox.f5567a);
        f5785D0 = m7497a("measurement.sdk.referrer.delayed_install_referrer_api", bool, bool, C1624nx.f5389a);
        f5787E0 = m7497a("measurement.sdk.screen.disabling_automatic_reporting", bool2, bool2, C1789qx.f6122a);
        f5789F0 = m7497a("measurement.sdk.screen.manual_screen_view_logging", bool2, bool2, C1739px.f5882a);
        f5791G0 = m7497a("measurement.gold.enhanced_ecommerce.format_logs", bool, bool, C1888sx.f6603a);
        Boolean bool3 = Boolean.FALSE;
        f5793H0 = m7497a("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", bool3, bool3, C2140ux.f7318a);
        f5795I0 = m7497a("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", bool3, bool3, C1985tx.f6865a);
        f5797J0 = m7497a("measurement.gold.enhanced_ecommerce.log_nested_complex_events", bool3, bool3, C2247wx.f7806a);
        f5799K0 = m7497a("measurement.gold.enhanced_ecommerce.updated_schema.client", bool3, bool3, C2190vx.f7565a);
        f5801L0 = m7497a("measurement.gold.enhanced_ecommerce.updated_schema.service", bool3, bool3, C2398yx.f8347a);
        m7497a("measurement.collection.synthetic_data_mitigation", bool3, bool3, C2316xx.f8061a);
        f5803M0 = m7497a("measurement.service.configurable_service_limits", bool3, bool3, C0800by.f1834a);
        f5805N0 = m7497a("measurement.client.configurable_service_limits", bool3, bool3, C2445zx.f8607a);
        Boolean bool4 = Boolean.TRUE;
        f5807O0 = m7497a("measurement.androidId.delete_feature", bool4, bool4, C0903dy.f2298a);
        f5809P0 = m7497a("measurement.client.global_params.dev", bool3, bool3, C0851cy.f2078a);
        m7497a("measurement.service.global_params", bool3, bool3, C0959ey.f2551a);
        f5811Q0 = m7497a("measurement.client.string_reader", bool4, bool4, C1135hy.f3243a);
        f5813R0 = m7497a("measurement.sdk.attribution.cache", bool4, bool4, C1083gy.f3026a);
        f5815S0 = m7497a("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, C1416jy.f4392a);
    }

    /* renamed from: a */
    public static <V> C1529ly<V> m7497a(@Nullable String str, @Nullable V v, @Nullable V v2, @Nullable zzek<V> zzekVar) {
        C1529ly<V> c1529ly = new C1529ly<>(str, v, v2, zzekVar);
        f5823a.add(c1529ly);
        return c1529ly;
    }

    /* renamed from: c */
    public static Map<String, String> m7501c(Context context) {
        C0782bl m2551a = C0782bl.m2551a(context.getContentResolver(), C1611nl.m6734a("com.google.android.gms.measurement"));
        return m2551a == null ? Collections.emptyMap() : m2551a.m2553b();
    }

    /* renamed from: s0 */
    public static final /* synthetic */ Long m7534s0() {
        t40 t40Var = C1478ky.f4675a;
        return Long.valueOf(C2438zq.m10605k());
    }
}
