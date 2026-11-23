package com.amazonaws.metrics;

import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.MetricCollector;
import com.amazonaws.regions.Regions;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSServiceMetrics;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public enum AwsSdkMetrics {
    ;


    /* renamed from: O */
    public static final boolean f184O;

    /* renamed from: P */
    public static volatile MetricCollector f185P;

    /* renamed from: Q */
    public static boolean f186Q;

    static {
        String str = "com.amazonaws.management:type=" + AwsSdkMetrics.class.getSimpleName();
        String property = System.getProperty("com.amazonaws.sdk.enableDefaultMetrics");
        boolean z = property != null;
        f184O = z;
        if (z) {
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            for (String str2 : property.split(",")) {
                String trim = str2.trim();
                if (!z2 && "excludeMachineMetrics".equals(trim)) {
                    z2 = true;
                } else if (!z3 && "includePerHostMetrics".equals(trim)) {
                    z3 = true;
                } else if (z4 || !"useSingleMetricNamespace".equals(trim)) {
                    String[] split = trim.split(SimpleComparison.EQUAL_TO_OPERATION);
                    if (split.length == 2) {
                        String trim2 = split[0].trim();
                        String trim3 = split[1].trim();
                        try {
                            if ("credentialFile".equals(trim2)) {
                                m244l(trim3);
                            } else if ("cloudwatchRegion".equals(trim2)) {
                                Regions.m275f(trim3);
                            } else if ("metricQueueSize".equals(trim2)) {
                                if (new Integer(trim3).intValue() < 1) {
                                    throw new IllegalArgumentException("metricQueueSize must be at least 1");
                                }
                            } else if ("getQueuePollTimeoutMilli".equals(trim2)) {
                                if (new Long(trim3).intValue() < 1000) {
                                    throw new IllegalArgumentException("getQueuePollTimeoutMilli must be at least 1000");
                                }
                            } else if (!"metricNameSpace".equals(trim2) && !"jvmMetricName".equals(trim2) && !"hostMetricName".equals(trim2)) {
                                LogFactory.m237c(AwsSdkMetrics.class).mo225a("Ignoring unrecognized parameter: " + trim);
                            }
                        } catch (Exception e) {
                            LogFactory.m237c(AwsSdkMetrics.class).mo226b("Ignoring failure", e);
                        }
                    } else {
                        continue;
                    }
                } else {
                    z4 = true;
                }
            }
        }
        new Object() { // from class: com.amazonaws.metrics.AwsSdkMetrics.MetricRegistry

            /* renamed from: a */
            public final Set<MetricType> f188a;

            /* renamed from: b */
            public volatile Set<MetricType> f189b;

            {
                HashSet hashSet = new HashSet();
                this.f188a = hashSet;
                hashSet.add(AWSRequestMetrics.Field.ClientExecuteTime);
                hashSet.add(AWSRequestMetrics.Field.Exception);
                hashSet.add(AWSRequestMetrics.Field.HttpClientRetryCount);
                hashSet.add(AWSRequestMetrics.Field.HttpRequestTime);
                hashSet.add(AWSRequestMetrics.Field.RequestCount);
                hashSet.add(AWSRequestMetrics.Field.RetryCount);
                hashSet.add(AWSRequestMetrics.Field.HttpClientSendRequestTime);
                hashSet.add(AWSRequestMetrics.Field.HttpClientReceiveResponseTime);
                hashSet.add(AWSRequestMetrics.Field.HttpClientPoolAvailableCount);
                hashSet.add(AWSRequestMetrics.Field.HttpClientPoolLeasedCount);
                hashSet.add(AWSRequestMetrics.Field.HttpClientPoolPendingCount);
                hashSet.add(AWSServiceMetrics.HttpClientGetConnectionTime);
                m246a();
            }

            /* renamed from: a */
            public final void m246a() {
                this.f189b = Collections.unmodifiableSet(new HashSet(this.f188a));
            }
        };
    }

    /* renamed from: f */
    public static synchronized boolean m241f() {
        synchronized (AwsSdkMetrics.class) {
            if (f185P == null || !f185P.m248b()) {
                if (f186Q) {
                    throw new IllegalStateException("Reentrancy is not allowed");
                }
                f186Q = true;
                try {
                    try {
                        MetricCollector m250a = ((MetricCollector.Factory) Class.forName("com.amazonaws.metrics.internal.cloudwatch.DefaultMetricCollectorFactory").newInstance()).m250a();
                        if (m250a != null) {
                            m245m(m250a);
                            return true;
                        }
                    } catch (Exception e) {
                        LogFactory.m237c(AwsSdkMetrics.class).mo230f("Failed to enable the default metrics", e);
                    }
                } finally {
                    f186Q = false;
                }
            }
            return false;
        }
    }

    /* renamed from: h */
    public static <T extends RequestMetricCollector> T m242h() {
        if (f185P == null && m243k()) {
            m241f();
        }
        return f185P == null ? (T) RequestMetricCollector.f190a : (T) f185P.m247a();
    }

    /* renamed from: k */
    public static boolean m243k() {
        return f184O;
    }

    /* renamed from: l */
    public static void m244l(String str) throws IOException {
        new PropertiesCredentials(new File(str));
        synchronized (AwsSdkMetrics.class) {
        }
    }

    /* renamed from: m */
    public static synchronized void m245m(MetricCollector metricCollector) {
        synchronized (AwsSdkMetrics.class) {
            MetricCollector metricCollector2 = f185P;
            if (metricCollector2 != null) {
                metricCollector2.m249c();
            }
        }
    }
}
