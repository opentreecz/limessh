package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.retry.RetryPolicy;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Random;

/* loaded from: classes.dex */
public class PredefinedRetryPolicies {

    /* renamed from: a */
    public static final RetryPolicy f223a;

    /* renamed from: b */
    public static final RetryPolicy.RetryCondition f224b;

    /* renamed from: c */
    public static final RetryPolicy.BackoffStrategy f225c;

    /* loaded from: classes.dex */
    public static final class SDKDefaultBackoffStrategy implements RetryPolicy.BackoffStrategy {

        /* renamed from: b */
        public final Random f226b;

        /* renamed from: c */
        public final int f227c;

        /* renamed from: d */
        public final int f228d;

        public SDKDefaultBackoffStrategy(int i, int i2) {
            this.f226b = new Random();
            this.f227c = i;
            this.f228d = i2;
        }

        @Override // com.amazonaws.retry.RetryPolicy.BackoffStrategy
        /* renamed from: a */
        public final long mo279a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i) {
            if (i <= 0) {
                return 0L;
            }
            return this.f226b.nextInt(Math.min(this.f228d, (1 << i) * this.f227c));
        }
    }

    /* loaded from: classes.dex */
    public static class SDKDefaultRetryCondition implements RetryPolicy.RetryCondition {
        @Override // com.amazonaws.retry.RetryPolicy.RetryCondition
        /* renamed from: a */
        public boolean mo280a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i) {
            if ((amazonClientException.getCause() instanceof IOException) && !(amazonClientException.getCause() instanceof InterruptedIOException)) {
                return true;
            }
            if (!(amazonClientException instanceof AmazonServiceException)) {
                return false;
            }
            AmazonServiceException amazonServiceException = (AmazonServiceException) amazonClientException;
            int statusCode = amazonServiceException.getStatusCode();
            return statusCode == 500 || statusCode == 503 || statusCode == 502 || statusCode == 504 || RetryUtils.m286b(amazonServiceException) || RetryUtils.m285a(amazonServiceException);
        }
    }

    static {
        new RetryPolicy(RetryPolicy.RetryCondition.f234a, RetryPolicy.BackoffStrategy.f233a, 0, false);
        f224b = new SDKDefaultRetryCondition();
        f225c = new SDKDefaultBackoffStrategy(100, 20000);
        f223a = m277a();
        m278b();
    }

    /* renamed from: a */
    public static RetryPolicy m277a() {
        return new RetryPolicy(f224b, f225c, 3, true);
    }

    /* renamed from: b */
    public static RetryPolicy m278b() {
        return new RetryPolicy(f224b, f225c, 10, true);
    }
}
