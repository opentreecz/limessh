package com.amazonaws;

import com.amazonaws.auth.RegionAwareSigner;
import com.amazonaws.auth.Signer;
import com.amazonaws.auth.SignerFactory;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.http.AmazonHttpClient;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.AwsSdkMetrics;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.regions.Region;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.Classes;
import com.amazonaws.util.StringUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class AmazonWebServiceClient {

    /* renamed from: i */
    public static final Log f35i = LogFactory.m237c(AmazonWebServiceClient.class);

    /* renamed from: a */
    public volatile URI f36a;

    /* renamed from: b */
    public volatile String f37b;

    /* renamed from: c */
    public ClientConfiguration f38c;

    /* renamed from: d */
    public AmazonHttpClient f39d;

    /* renamed from: e */
    public final List<RequestHandler2> f40e = new CopyOnWriteArrayList();

    /* renamed from: f */
    public int f41f;

    /* renamed from: g */
    public volatile Signer f42g;

    /* renamed from: h */
    public volatile String f43h;

    public AmazonWebServiceClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.f38c = clientConfiguration;
        this.f39d = new AmazonHttpClient(clientConfiguration, httpClient);
    }

    @Deprecated
    /* renamed from: n */
    public static boolean m10n() {
        return System.getProperty("com.amazonaws.sdk.enableRuntimeProfiling") != null;
    }

    /* renamed from: c */
    public void m11c(String str) {
        URI m25r = m25r(str);
        Signer m14f = m14f(m25r, this.f37b, false);
        synchronized (this) {
            this.f36a = m25r;
            this.f42g = m14f;
        }
    }

    /* renamed from: d */
    public final String m12d() {
        int i;
        String simpleName = Classes.m651f(AmazonWebServiceClient.class, this).getSimpleName();
        String m69f = ServiceNameFactory.m69f(simpleName);
        if (m69f != null) {
            return m69f;
        }
        int indexOf = simpleName.indexOf("JavaClient");
        if (indexOf == -1 && (indexOf = simpleName.indexOf("Client")) == -1) {
            throw new IllegalStateException("Unrecognized suffix for the AWS http client class name " + simpleName);
        }
        int indexOf2 = simpleName.indexOf("Amazon");
        if (indexOf2 == -1) {
            indexOf2 = simpleName.indexOf("AWS");
            if (indexOf2 == -1) {
                throw new IllegalStateException("Unrecognized prefix for the AWS http client class name " + simpleName);
            }
            i = 3;
        } else {
            i = 6;
        }
        if (indexOf2 < indexOf) {
            return StringUtils.m679d(simpleName.substring(indexOf2 + i, indexOf));
        }
        throw new IllegalStateException("Unrecognized AWS http client class name " + simpleName);
    }

    /* renamed from: e */
    public final Signer m13e(String str, String str2, String str3, boolean z) {
        String m39e = this.f38c.m39e();
        Signer m128b = m39e == null ? SignerFactory.m128b(str, str2) : SignerFactory.m129c(m39e, str);
        if (m128b instanceof RegionAwareSigner) {
            RegionAwareSigner regionAwareSigner = (RegionAwareSigner) m128b;
            if (str3 != null) {
                regionAwareSigner.mo92c(str3);
            } else if (str2 != null && z) {
                regionAwareSigner.mo92c(str2);
            }
        }
        synchronized (this) {
            Region.m253d(str2);
        }
        return m128b;
    }

    /* renamed from: f */
    public final Signer m14f(URI uri, String str, boolean z) {
        if (uri == null) {
            throw new IllegalArgumentException("Endpoint is not set. Use setEndpoint to set an endpoint before performing any request.");
        }
        String m20l = m20l();
        return m13e(m20l, AwsHostNameUtils.m637a(uri.getHost(), m20l), str, z);
    }

    /* renamed from: g */
    public ExecutionContext m15g(AmazonWebServiceRequest amazonWebServiceRequest) {
        return new ExecutionContext(this.f40e, m23p(amazonWebServiceRequest) || m10n(), this);
    }

    @Deprecated
    /* renamed from: h */
    public final void m16h(AWSRequestMetrics aWSRequestMetrics, Request<?> request, Response<?> response) {
        m17i(aWSRequestMetrics, request, response, false);
    }

    @Deprecated
    /* renamed from: i */
    public final void m17i(AWSRequestMetrics aWSRequestMetrics, Request<?> request, Response<?> response, boolean z) {
        if (request != null) {
            aWSRequestMetrics.mo625b(AWSRequestMetrics.Field.ClientExecuteTime);
            aWSRequestMetrics.m626c().mo687c();
            m18j(request).mo251a(request, response);
        }
        if (z) {
            aWSRequestMetrics.mo628e();
        }
    }

    @Deprecated
    /* renamed from: j */
    public final RequestMetricCollector m18j(Request<?> request) {
        RequestMetricCollector m29e = request.mo53i().m29e();
        if (m29e != null) {
            return m29e;
        }
        RequestMetricCollector m19k = m19k();
        return m19k == null ? AwsSdkMetrics.m242h() : m19k;
    }

    @Deprecated
    /* renamed from: k */
    public RequestMetricCollector m19k() {
        return this.f39d.m148f();
    }

    /* renamed from: l */
    public String m20l() {
        if (this.f43h == null) {
            synchronized (this) {
                if (this.f43h == null) {
                    this.f43h = m12d();
                    return this.f43h;
                }
            }
        }
        return this.f43h;
    }

    /* renamed from: m */
    public Signer m21m(URI uri) {
        return m14f(uri, this.f37b, true);
    }

    @Deprecated
    /* renamed from: o */
    public final boolean m22o() {
        RequestMetricCollector m24q = m24q();
        return m24q != null && m24q.mo252b();
    }

    @Deprecated
    /* renamed from: p */
    public final boolean m23p(AmazonWebServiceRequest amazonWebServiceRequest) {
        RequestMetricCollector m29e = amazonWebServiceRequest.m29e();
        if (m29e == null || !m29e.mo252b()) {
            return m22o();
        }
        return true;
    }

    @Deprecated
    /* renamed from: q */
    public RequestMetricCollector m24q() {
        RequestMetricCollector m148f = this.f39d.m148f();
        return m148f == null ? AwsSdkMetrics.m242h() : m148f;
    }

    /* renamed from: r */
    public final URI m25r(String str) {
        if (!str.contains("://")) {
            str = this.f38c.m37c().toString() + "://" + str;
        }
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
