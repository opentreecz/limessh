package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.MetricType;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
public class AWSRequestMetricsFullSupport extends AWSRequestMetrics {

    /* renamed from: d */
    public static final Log f466d = LogFactory.m238d("com.amazonaws.latency");

    /* renamed from: e */
    public static final Object f467e = SimpleComparison.EQUAL_TO_OPERATION;

    /* renamed from: f */
    public static final Object f468f = ", ";

    /* renamed from: b */
    public final Map<String, List<Object>> f469b;

    /* renamed from: c */
    public final Map<String, TimingInfo> f470c;

    public AWSRequestMetricsFullSupport() {
        super(TimingInfo.m683n());
        this.f469b = new HashMap();
        this.f470c = new HashMap();
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    /* renamed from: a */
    public void mo624a(MetricType metricType, Object obj) {
        m631h(metricType.name(), obj);
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    /* renamed from: b */
    public void mo625b(MetricType metricType) {
        m632i(metricType.name());
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    /* renamed from: d */
    public void mo627d(MetricType metricType) {
        m633j(metricType.name());
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    /* renamed from: e */
    public void mo628e() {
        if (f466d.mo228d()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, List<Object>> entry : this.f469b.entrySet()) {
                m634k(entry.getKey(), entry.getValue(), sb);
            }
            for (Map.Entry<String, Number> entry2 : this.f441a.mo688d().entrySet()) {
                m634k(entry2.getKey(), entry2.getValue(), sb);
            }
            for (Map.Entry<String, List<TimingInfo>> entry3 : this.f441a.mo691g().entrySet()) {
                m634k(entry3.getKey(), entry3.getValue(), sb);
            }
            f466d.mo229e(sb.toString());
        }
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    /* renamed from: f */
    public void mo629f(MetricType metricType, long j) {
        m635l(metricType.name(), j);
    }

    @Override // com.amazonaws.util.AWSRequestMetrics
    /* renamed from: g */
    public void mo630g(MetricType metricType) {
        m636m(metricType.name());
    }

    /* renamed from: h */
    public void m631h(String str, Object obj) {
        List<Object> list = this.f469b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f469b.put(str, list);
        }
        list.add(obj);
    }

    /* renamed from: i */
    public void m632i(String str) {
        TimingInfo timingInfo = this.f470c.get(str);
        if (timingInfo != null) {
            timingInfo.mo687c();
            this.f441a.mo686a(str, TimingInfo.m685p(timingInfo.m690f(), Long.valueOf(timingInfo.m689e())));
            return;
        }
        LogFactory.m237c(AWSRequestMetricsFullSupport.class).mo231g("Trying to end an event which was never started: " + str);
    }

    /* renamed from: j */
    public void m633j(String str) {
        this.f441a.mo694j(str);
    }

    /* renamed from: k */
    public final void m634k(Object obj, Object obj2, StringBuilder sb) {
        sb.append(obj);
        sb.append(f467e);
        sb.append(obj2);
        sb.append(f468f);
    }

    /* renamed from: l */
    public void m635l(String str, long j) {
        this.f441a.mo696l(str, j);
    }

    /* renamed from: m */
    public void m636m(String str) {
        this.f470c.put(str, TimingInfo.m684o(System.nanoTime()));
    }
}
