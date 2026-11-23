package com.amazonaws;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AWSRequestMetrics;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class DefaultRequest<T> implements Request<T> {

    /* renamed from: a */
    public String f61a;

    /* renamed from: e */
    public URI f65e;

    /* renamed from: f */
    public String f66f;

    /* renamed from: g */
    public final AmazonWebServiceRequest f67g;

    /* renamed from: i */
    public InputStream f69i;

    /* renamed from: j */
    public int f70j;

    /* renamed from: k */
    public AWSRequestMetrics f71k;

    /* renamed from: b */
    public boolean f62b = false;

    /* renamed from: c */
    public final Map<String, String> f63c = new LinkedHashMap();

    /* renamed from: d */
    public final Map<String, String> f64d = new HashMap();

    /* renamed from: h */
    public HttpMethodName f68h = HttpMethodName.POST;

    public DefaultRequest(AmazonWebServiceRequest amazonWebServiceRequest, String str) {
        this.f66f = str;
        this.f67g = amazonWebServiceRequest;
    }

    @Override // com.amazonaws.Request
    /* renamed from: a */
    public Map<String, String> mo45a() {
        return this.f63c;
    }

    @Override // com.amazonaws.Request
    /* renamed from: b */
    public void mo46b(InputStream inputStream) {
        this.f69i = inputStream;
    }

    @Override // com.amazonaws.Request
    @Deprecated
    /* renamed from: c */
    public AWSRequestMetrics mo47c() {
        return this.f71k;
    }

    @Override // com.amazonaws.Request
    /* renamed from: d */
    public void mo48d(String str) {
        this.f61a = str;
    }

    @Override // com.amazonaws.Request
    /* renamed from: e */
    public Map<String, String> mo49e() {
        return this.f64d;
    }

    @Override // com.amazonaws.Request
    /* renamed from: f */
    public String mo50f() {
        return this.f66f;
    }

    @Override // com.amazonaws.Request
    /* renamed from: g */
    public void mo51g(int i) {
        this.f70j = i;
    }

    @Override // com.amazonaws.Request
    public InputStream getContent() {
        return this.f69i;
    }

    @Override // com.amazonaws.Request
    /* renamed from: h */
    public int mo52h() {
        return this.f70j;
    }

    @Override // com.amazonaws.Request
    /* renamed from: i */
    public AmazonWebServiceRequest mo53i() {
        return this.f67g;
    }

    @Override // com.amazonaws.Request
    public boolean isStreaming() {
        return this.f62b;
    }

    @Override // com.amazonaws.Request
    /* renamed from: j */
    public HttpMethodName mo54j() {
        return this.f68h;
    }

    @Override // com.amazonaws.Request
    /* renamed from: k */
    public void mo55k(HttpMethodName httpMethodName) {
        this.f68h = httpMethodName;
    }

    @Override // com.amazonaws.Request
    /* renamed from: l */
    public void mo56l(String str, String str2) {
        this.f63c.put(str, str2);
    }

    @Override // com.amazonaws.Request
    /* renamed from: m */
    public String mo57m() {
        return this.f61a;
    }

    @Override // com.amazonaws.Request
    @Deprecated
    /* renamed from: n */
    public void mo58n(AWSRequestMetrics aWSRequestMetrics) {
        if (this.f71k != null) {
            throw new IllegalStateException("AWSRequestMetrics has already been set on this request");
        }
        this.f71k = aWSRequestMetrics;
    }

    @Override // com.amazonaws.Request
    /* renamed from: o */
    public void mo59o(Map<String, String> map) {
        this.f63c.clear();
        this.f63c.putAll(map);
    }

    @Override // com.amazonaws.Request
    /* renamed from: p */
    public void mo60p(String str, String str2) {
        this.f64d.put(str, str2);
    }

    @Override // com.amazonaws.Request
    /* renamed from: q */
    public URI mo61q() {
        return this.f65e;
    }

    @Override // com.amazonaws.Request
    /* renamed from: r */
    public void mo62r(Map<String, String> map) {
        this.f64d.clear();
        this.f64d.putAll(map);
    }

    @Override // com.amazonaws.Request
    /* renamed from: s */
    public void mo63s(URI uri) {
        this.f65e = uri;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo54j());
        sb.append(" ");
        sb.append(mo61q());
        sb.append(" ");
        String mo57m = mo57m();
        if (mo57m == null) {
            sb.append("/");
        } else {
            if (!mo57m.startsWith("/")) {
                sb.append("/");
            }
            sb.append(mo57m);
        }
        sb.append(" ");
        if (!mo45a().isEmpty()) {
            sb.append("Parameters: (");
            for (String str : mo45a().keySet()) {
                String str2 = mo45a().get(str);
                sb.append(str);
                sb.append(": ");
                sb.append(str2);
                sb.append(", ");
            }
            sb.append(") ");
        }
        if (!mo49e().isEmpty()) {
            sb.append("Headers: (");
            for (String str3 : mo49e().keySet()) {
                String str4 = mo49e().get(str3);
                sb.append(str3);
                sb.append(": ");
                sb.append(str4);
                sb.append(", ");
            }
            sb.append(") ");
        }
        return sb.toString();
    }
}
