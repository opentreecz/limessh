package com.amazonaws.auth;

import com.amazonaws.Request;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

/* loaded from: classes.dex */
public class AWS3Signer extends AbstractAWSSigner {

    /* renamed from: c */
    public static final Log f83c = LogFactory.m237c(AWS3Signer.class);

    /* renamed from: b */
    public String f84b;

    /* renamed from: A */
    public List<String> m70A(Request<?> request) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, String>> it = request.mo49e().entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            String m679d = StringUtils.m679d(key);
            if (m679d.startsWith("x-amz") || "host".equals(m679d)) {
                arrayList.add(key);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: B */
    public final String m71B(Request<?> request) {
        StringBuilder sb = new StringBuilder();
        sb.append("SignedHeaders=");
        boolean z = true;
        for (String str : m70A(request)) {
            if (!z) {
                sb.append(";");
            }
            sb.append(str);
            z = false;
        }
        return sb.toString();
    }

    @Override // com.amazonaws.auth.Signer
    /* renamed from: b */
    public void mo72b(Request<?> request, AWSCredentials aWSCredentials) {
        AWSCredentials m115t = m115t(aWSCredentials);
        SigningAlgorithm signingAlgorithm = SigningAlgorithm.HmacSHA256;
        UUID.randomUUID().toString();
        String m656c = DateUtils.m656c(m110o(m111p(request)));
        String str = this.f84b;
        if (str != null) {
            m656c = str;
        }
        request.mo60p("Date", m656c);
        request.mo60p("X-Amz-Date", m656c);
        String host = request.mo61q().getHost();
        if (HttpUtils.m666d(request.mo61q())) {
            host = host + ":" + request.mo61q().getPort();
        }
        request.mo60p("Host", host);
        if (m115t instanceof AWSSessionCredentials) {
            m73y(request, (AWSSessionCredentials) m115t);
        }
        String str2 = request.mo54j().toString() + "\n" + m107k(HttpUtils.m663a(request.mo61q().getPath(), request.mo57m())) + "\n" + m106j(request.mo45a()) + "\n" + m74z(request) + "\n" + m109n(request);
        byte[] m113r = m113r(str2);
        f83c.mo225a("Calculated StringToSign: " + str2);
        String m119x = m119x(m113r, m115t.mo97b(), signingAlgorithm);
        StringBuilder sb = new StringBuilder();
        sb.append("AWS3");
        sb.append(" ");
        sb.append("AWSAccessKeyId=" + m115t.mo96a() + ",");
        sb.append("Algorithm=" + signingAlgorithm.toString() + ",");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m71B(request));
        sb2.append(",");
        sb.append(sb2.toString());
        sb.append("Signature=" + m119x);
        request.mo60p("X-Amzn-Authorization", sb.toString());
    }

    /* renamed from: y */
    public void m73y(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.mo60p("x-amz-security-token", aWSSessionCredentials.getSessionToken());
    }

    /* renamed from: z */
    public String m74z(Request<?> request) {
        List<String> m70A = m70A(request);
        for (int i = 0; i < m70A.size(); i++) {
            m70A.set(i, StringUtils.m679d(m70A.get(i)));
        }
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<String, String> entry : request.mo49e().entrySet()) {
            if (m70A.contains(StringUtils.m679d(entry.getKey()))) {
                treeMap.put(StringUtils.m679d(entry.getKey()), entry.getValue());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry2 : treeMap.entrySet()) {
            sb.append(StringUtils.m679d((String) entry2.getKey()));
            sb.append(":");
            sb.append((String) entry2.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }
}
