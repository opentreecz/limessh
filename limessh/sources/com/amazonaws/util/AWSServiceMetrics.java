package com.amazonaws.util;

import com.amazonaws.metrics.ServiceMetricType;

@Deprecated
/* loaded from: classes.dex */
public enum AWSServiceMetrics implements ServiceMetricType {
    HttpClientGetConnectionTime("HttpClient");

    AWSServiceMetrics(String str) {
    }
}
