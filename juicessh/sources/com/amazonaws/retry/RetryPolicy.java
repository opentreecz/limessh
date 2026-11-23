package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;

/* loaded from: classes.dex */
public final class RetryPolicy {

    /* renamed from: a */
    public final RetryCondition f229a;

    /* renamed from: b */
    public final BackoffStrategy f230b;

    /* renamed from: c */
    public final int f231c;

    /* renamed from: d */
    public final boolean f232d;

    /* loaded from: classes.dex */
    public interface BackoffStrategy {

        /* renamed from: a */
        public static final BackoffStrategy f233a = new BackoffStrategy() { // from class: com.amazonaws.retry.RetryPolicy.BackoffStrategy.1
            @Override // com.amazonaws.retry.RetryPolicy.BackoffStrategy
            /* renamed from: a */
            public long mo279a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i) {
                return 0L;
            }
        };

        /* renamed from: a */
        long mo279a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i);
    }

    /* loaded from: classes.dex */
    public interface RetryCondition {

        /* renamed from: a */
        public static final RetryCondition f234a = new RetryCondition() { // from class: com.amazonaws.retry.RetryPolicy.RetryCondition.1
            @Override // com.amazonaws.retry.RetryPolicy.RetryCondition
            /* renamed from: a */
            public boolean mo280a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i) {
                return false;
            }
        };

        /* renamed from: a */
        boolean mo280a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i);
    }

    public RetryPolicy(RetryCondition retryCondition, BackoffStrategy backoffStrategy, int i, boolean z) {
        retryCondition = retryCondition == null ? PredefinedRetryPolicies.f224b : retryCondition;
        backoffStrategy = backoffStrategy == null ? PredefinedRetryPolicies.f225c : backoffStrategy;
        if (i < 0) {
            throw new IllegalArgumentException("Please provide a non-negative value for maxErrorRetry.");
        }
        this.f229a = retryCondition;
        this.f230b = backoffStrategy;
        this.f231c = i;
        this.f232d = z;
    }

    /* renamed from: a */
    public BackoffStrategy m281a() {
        return this.f230b;
    }

    /* renamed from: b */
    public int m282b() {
        return this.f231c;
    }

    /* renamed from: c */
    public RetryCondition m283c() {
        return this.f229a;
    }

    /* renamed from: d */
    public boolean m284d() {
        return this.f232d;
    }
}
