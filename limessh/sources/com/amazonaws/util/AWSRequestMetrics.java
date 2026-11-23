package com.amazonaws.util;

import com.amazonaws.metrics.MetricType;
import com.amazonaws.metrics.RequestMetricType;

@Deprecated
/* loaded from: classes.dex */
public class AWSRequestMetrics {

    /* renamed from: a */
    public final TimingInfo f441a;

    /* loaded from: classes.dex */
    public enum Field implements RequestMetricType {
        AWSErrorCode,
        AWSRequestID,
        BytesProcessed,
        ClientExecuteTime,
        CredentialsRequestTime,
        Exception,
        HttpRequestTime,
        RedirectLocation,
        RequestMarshallTime,
        RequestSigningTime,
        ResponseProcessingTime,
        RequestCount,
        RetryCount,
        HttpClientRetryCount,
        HttpClientSendRequestTime,
        HttpClientReceiveResponseTime,
        HttpClientPoolAvailableCount,
        HttpClientPoolLeasedCount,
        HttpClientPoolPendingCount,
        RetryPauseTime,
        ServiceEndpoint,
        ServiceName,
        StatusCode
    }

    public AWSRequestMetrics() {
        this.f441a = TimingInfo.m682m();
    }

    public AWSRequestMetrics(TimingInfo timingInfo) {
        this.f441a = timingInfo;
    }

    /* renamed from: a */
    public void mo624a(MetricType metricType, Object obj) {
    }

    /* renamed from: b */
    public void mo625b(MetricType metricType) {
    }

    /* renamed from: c */
    public final TimingInfo m626c() {
        return this.f441a;
    }

    /* renamed from: d */
    public void mo627d(MetricType metricType) {
    }

    /* renamed from: e */
    public void mo628e() {
    }

    /* renamed from: f */
    public void mo629f(MetricType metricType, long j) {
    }

    /* renamed from: g */
    public void mo630g(MetricType metricType) {
    }
}
