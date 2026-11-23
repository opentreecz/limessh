package com.amazonaws.metrics;

import com.amazonaws.Request;
import com.amazonaws.Response;

/* loaded from: classes.dex */
public abstract class RequestMetricCollector {

    /* renamed from: a */
    public static final RequestMetricCollector f190a = new RequestMetricCollector() { // from class: com.amazonaws.metrics.RequestMetricCollector.1
        @Override // com.amazonaws.metrics.RequestMetricCollector
        /* renamed from: a */
        public void mo251a(Request<?> request, Response<?> response) {
        }

        @Override // com.amazonaws.metrics.RequestMetricCollector
        /* renamed from: b */
        public boolean mo252b() {
            return false;
        }
    };

    /* loaded from: classes.dex */
    public interface Factory {
    }

    /* renamed from: a */
    public abstract void mo251a(Request<?> request, Response<?> response);

    /* renamed from: b */
    public abstract boolean mo252b();
}
