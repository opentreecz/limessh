package com.amazonaws.http;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpRequestFactory {
    /* renamed from: a */
    public final void m179a(Map<String, String> map, Request<?> request, ExecutionContext executionContext, ClientConfiguration clientConfiguration) {
        URI mo61q = request.mo61q();
        String host = mo61q.getHost();
        if (HttpUtils.m666d(mo61q)) {
            host = host + ":" + mo61q.getPort();
        }
        map.put("Host", host);
        for (Map.Entry<String, String> entry : request.mo49e().entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        if (map.get("Content-Type") == null || map.get("Content-Type").isEmpty()) {
            map.put("Content-Type", "application/x-www-form-urlencoded; charset=" + StringUtils.m679d("UTF-8"));
        }
        if (executionContext == null || executionContext.m166b() == null) {
            return;
        }
        map.put("User-Agent", m181c(clientConfiguration, executionContext.m166b()));
    }

    /* renamed from: b */
    public HttpRequest m180b(Request<?> request, ClientConfiguration clientConfiguration, ExecutionContext executionContext) {
        boolean z = true;
        String m664b = HttpUtils.m664b(request.mo61q().toString(), request.mo57m(), true);
        String m665c = HttpUtils.m665c(request);
        HttpMethodName mo54j = request.mo54j();
        boolean z2 = request.getContent() != null;
        HttpMethodName httpMethodName = HttpMethodName.POST;
        if ((mo54j == httpMethodName) && !z2) {
            z = false;
        }
        if (m665c != null && z) {
            m664b = m664b + "?" + m665c;
        }
        HashMap hashMap = new HashMap();
        m179a(hashMap, request, executionContext, clientConfiguration);
        InputStream content = request.getContent();
        HttpMethodName httpMethodName2 = HttpMethodName.PATCH;
        if (mo54j == httpMethodName2) {
            hashMap.put("X-HTTP-Method-Override", httpMethodName2.toString());
            mo54j = httpMethodName;
        }
        if (mo54j == httpMethodName && request.getContent() == null && m665c != null) {
            byte[] bytes = m665c.getBytes(StringUtils.f489a);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            hashMap.put("Content-Length", String.valueOf(bytes.length));
            content = byteArrayInputStream;
        }
        if (clientConfiguration.m44j() && hashMap.get("Accept-Encoding") == null) {
            hashMap.put("Accept-Encoding", "gzip");
        } else {
            hashMap.put("Accept-Encoding", "identity");
        }
        HttpRequest httpRequest = new HttpRequest(mo54j.toString(), URI.create(m664b), hashMap, content);
        httpRequest.m178g(request.isStreaming());
        return httpRequest;
    }

    /* renamed from: c */
    public final String m181c(ClientConfiguration clientConfiguration, String str) {
        if (clientConfiguration.m42h().contains(str)) {
            return clientConfiguration.m42h();
        }
        return clientConfiguration.m42h() + " " + str;
    }
}
