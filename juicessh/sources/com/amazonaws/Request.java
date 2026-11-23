package com.amazonaws;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AWSRequestMetrics;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

/* loaded from: classes.dex */
public interface Request<T> {
    /* renamed from: a */
    Map<String, String> mo45a();

    /* renamed from: b */
    void mo46b(InputStream inputStream);

    /* renamed from: c */
    AWSRequestMetrics mo47c();

    /* renamed from: d */
    void mo48d(String str);

    /* renamed from: e */
    Map<String, String> mo49e();

    /* renamed from: f */
    String mo50f();

    /* renamed from: g */
    void mo51g(int i);

    InputStream getContent();

    /* renamed from: h */
    int mo52h();

    /* renamed from: i */
    AmazonWebServiceRequest mo53i();

    boolean isStreaming();

    /* renamed from: j */
    HttpMethodName mo54j();

    /* renamed from: k */
    void mo55k(HttpMethodName httpMethodName);

    /* renamed from: l */
    void mo56l(String str, String str2);

    /* renamed from: m */
    String mo57m();

    /* renamed from: n */
    void mo58n(AWSRequestMetrics aWSRequestMetrics);

    /* renamed from: o */
    void mo59o(Map<String, String> map);

    /* renamed from: p */
    void mo60p(String str, String str2);

    /* renamed from: q */
    URI mo61q();

    /* renamed from: r */
    void mo62r(Map<String, String> map);

    /* renamed from: s */
    void mo63s(URI uri);
}
