package com.amazonaws.http;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.Signer;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSRequestMetricsFullSupport;
import java.net.URI;
import java.util.List;

/* loaded from: classes.dex */
public class ExecutionContext {

    /* renamed from: a */
    public final AWSRequestMetrics f118a;

    /* renamed from: b */
    public final List<RequestHandler2> f119b;

    /* renamed from: c */
    public String f120c;

    /* renamed from: d */
    public final AmazonWebServiceClient f121d;

    /* renamed from: e */
    public AWSCredentials f122e;

    public ExecutionContext(List<RequestHandler2> list, boolean z, AmazonWebServiceClient amazonWebServiceClient) {
        this.f119b = list;
        this.f118a = z ? new AWSRequestMetricsFullSupport() : new AWSRequestMetrics();
        this.f121d = amazonWebServiceClient;
    }

    @Deprecated
    /* renamed from: a */
    public AWSRequestMetrics m165a() {
        return this.f118a;
    }

    /* renamed from: b */
    public String m166b() {
        return this.f120c;
    }

    /* renamed from: c */
    public AWSCredentials m167c() {
        return this.f122e;
    }

    /* renamed from: d */
    public List<RequestHandler2> m168d() {
        return this.f119b;
    }

    /* renamed from: e */
    public Signer m169e(URI uri) {
        AmazonWebServiceClient amazonWebServiceClient = this.f121d;
        if (amazonWebServiceClient == null) {
            return null;
        }
        return amazonWebServiceClient.m21m(uri);
    }

    /* renamed from: f */
    public void m170f(AWSCredentials aWSCredentials) {
        this.f122e = aWSCredentials;
    }
}
