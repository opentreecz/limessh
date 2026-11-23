package cz.opentree;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

/* compiled from: AsyncHttpClient.java */
/* loaded from: classes.dex */
public class wg0 {

    /* renamed from: f */
    public static int f7692f = 10;

    /* renamed from: g */
    public static int f7693g = 10000;

    /* renamed from: a */
    public final DefaultHttpClient f7694a;

    /* renamed from: b */
    public final HttpContext f7695b;

    /* renamed from: c */
    public ThreadPoolExecutor f7696c;

    /* renamed from: d */
    public final Map<Context, List<WeakReference<Future<?>>>> f7697d;

    /* renamed from: e */
    public final Map<String, String> f7698e;

    /* compiled from: AsyncHttpClient.java */
    /* renamed from: cz.opentree.wg0$a */
    /* loaded from: classes.dex */
    public class C2218a implements HttpRequestInterceptor {
        public C2218a() {
        }

        @Override // org.apache.http.HttpRequestInterceptor
        public void process(HttpRequest httpRequest, HttpContext httpContext) {
            if (!httpRequest.containsHeader("Accept-Encoding")) {
                httpRequest.addHeader("Accept-Encoding", "gzip");
            }
            for (String str : wg0.this.f7698e.keySet()) {
                httpRequest.addHeader(str, (String) wg0.this.f7698e.get(str));
            }
        }
    }

    /* compiled from: AsyncHttpClient.java */
    /* renamed from: cz.opentree.wg0$b */
    /* loaded from: classes.dex */
    public class C2219b implements HttpResponseInterceptor {
        public C2219b(wg0 wg0Var) {
        }

        @Override // org.apache.http.HttpResponseInterceptor
        public void process(HttpResponse httpResponse, HttpContext httpContext) {
            Header contentEncoding;
            HttpEntity entity = httpResponse.getEntity();
            if (entity == null || (contentEncoding = entity.getContentEncoding()) == null) {
                return;
            }
            for (HeaderElement headerElement : contentEncoding.getElements()) {
                if (headerElement.getName().equalsIgnoreCase("gzip")) {
                    httpResponse.setEntity(new C2220c(httpResponse.getEntity()));
                    return;
                }
            }
        }
    }

    /* compiled from: AsyncHttpClient.java */
    /* renamed from: cz.opentree.wg0$c */
    /* loaded from: classes.dex */
    public static class C2220c extends HttpEntityWrapper {
        public C2220c(HttpEntity httpEntity) {
            super(httpEntity);
        }

        @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
        public InputStream getContent() throws IOException {
            return new GZIPInputStream(((HttpEntityWrapper) this).wrappedEntity.getContent());
        }

        @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
        public long getContentLength() {
            return -1L;
        }
    }

    public wg0() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, f7693g);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(f7692f));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, f7693g);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, f7693g);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basicHttpParams, String.format("android-async-http/%s (http://loopj.com/android-async-http)", "1.4.0"));
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        this.f7695b = new SyncBasicHttpContext(new BasicHttpContext());
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        this.f7694a = defaultHttpClient;
        defaultHttpClient.addRequestInterceptor(new C2218a());
        defaultHttpClient.addResponseInterceptor(new C2219b(this));
        defaultHttpClient.setHttpRequestRetryHandler(new bh0(5));
        this.f7696c = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        this.f7697d = new WeakHashMap();
        this.f7698e = new HashMap();
    }

    /* renamed from: b */
    public final HttpEntityEnclosingRequestBase m9504b(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, HttpEntity httpEntity) {
        if (httpEntity != null) {
            httpEntityEnclosingRequestBase.setEntity(httpEntity);
        }
        return httpEntityEnclosingRequestBase;
    }

    /* renamed from: c */
    public void m9505c(String str, String str2) {
        this.f7698e.put(str, str2);
    }

    /* renamed from: d */
    public void m9506d(Context context, String str, yg0 yg0Var) {
        m9516n(this.f7694a, this.f7695b, new HttpDelete(str), null, yg0Var, context);
    }

    /* renamed from: e */
    public void m9507e(Context context, String str, yg0 yg0Var) {
        m9508f(context, str, null, yg0Var);
    }

    /* renamed from: f */
    public void m9508f(Context context, String str, ah0 ah0Var, yg0 yg0Var) {
        m9516n(this.f7694a, this.f7695b, new HttpGet(m9510h(str, ah0Var)), null, yg0Var, context);
    }

    /* renamed from: g */
    public void m9509g(String str, yg0 yg0Var) {
        m9508f(null, str, null, yg0Var);
    }

    /* renamed from: h */
    public final String m9510h(String str, ah0 ah0Var) {
        if (ah0Var == null) {
            return str;
        }
        return str + "?" + ah0Var.m2067b();
    }

    /* renamed from: i */
    public final HttpEntity m9511i(ah0 ah0Var) {
        if (ah0Var != null) {
            return ah0Var.m2066a();
        }
        return null;
    }

    /* renamed from: j */
    public void m9512j(Context context, String str, ah0 ah0Var, yg0 yg0Var) {
        m9513k(context, str, m9511i(ah0Var), null, yg0Var);
    }

    /* renamed from: k */
    public void m9513k(Context context, String str, HttpEntity httpEntity, String str2, yg0 yg0Var) {
        DefaultHttpClient defaultHttpClient = this.f7694a;
        HttpContext httpContext = this.f7695b;
        HttpPost httpPost = new HttpPost(str);
        m9504b(httpPost, httpEntity);
        m9516n(defaultHttpClient, httpContext, httpPost, str2, yg0Var, context);
    }

    /* renamed from: l */
    public void m9514l(String str, ah0 ah0Var, yg0 yg0Var) {
        m9512j(null, str, ah0Var, yg0Var);
    }

    /* renamed from: m */
    public void m9515m(Context context, String str, HttpEntity httpEntity, String str2, yg0 yg0Var) {
        DefaultHttpClient defaultHttpClient = this.f7694a;
        HttpContext httpContext = this.f7695b;
        HttpPut httpPut = new HttpPut(str);
        m9504b(httpPut, httpEntity);
        m9516n(defaultHttpClient, httpContext, httpPut, str2, yg0Var, context);
    }

    /* renamed from: n */
    public final void m9516n(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, yg0 yg0Var, Context context) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        Future<?> submit = this.f7696c.submit(new xg0(defaultHttpClient, httpContext, httpUriRequest, yg0Var));
        if (context != null) {
            List<WeakReference<Future<?>>> list = this.f7697d.get(context);
            if (list == null) {
                list = new LinkedList<>();
                this.f7697d.put(context, list);
            }
            list.add(new WeakReference<>(submit));
        }
    }

    /* renamed from: o */
    public void m9517o(int i) {
        HttpParams params = this.f7694a.getParams();
        ConnManagerParams.setTimeout(params, i);
        HttpConnectionParams.setSoTimeout(params, i);
        HttpConnectionParams.setConnectionTimeout(params, i);
    }

    /* renamed from: p */
    public void m9518p(String str) {
        HttpProtocolParams.setUserAgent(this.f7694a.getParams(), str);
    }
}
