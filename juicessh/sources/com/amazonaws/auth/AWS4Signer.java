package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/* loaded from: classes.dex */
public class AWS4Signer extends AbstractAWSSigner implements ServiceAwareSigner, RegionAwareSigner, Presigner {

    /* renamed from: f */
    public static final Log f85f = LogFactory.m237c(AWS4Signer.class);

    /* renamed from: b */
    public String f86b;

    /* renamed from: c */
    public String f87c;

    /* renamed from: d */
    public Date f88d;

    /* renamed from: e */
    public boolean f89e;

    /* loaded from: classes.dex */
    public static class HeaderSigningResult {

        /* renamed from: a */
        public final byte[] f90a;

        public HeaderSigningResult(String str, String str2, byte[] bArr, byte[] bArr2) {
            this.f90a = bArr2;
        }

        /* renamed from: a */
        public byte[] m95a() {
            byte[] bArr = this.f90a;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
    }

    public AWS4Signer() {
        this(true);
    }

    public AWS4Signer(boolean z) {
        this.f89e = z;
    }

    /* renamed from: A */
    public String m75A(Request<?> request) {
        InputStream m101e = m101e(request);
        m101e.mark(-1);
        String m646a = BinaryUtils.m646a(m112q(m101e));
        try {
            m101e.reset();
            return m646a;
        } catch (IOException e) {
            throw new AmazonClientException("Unable to reset stream after calculating AWS4 signature", e);
        }
    }

    /* renamed from: B */
    public String m76B(Request<?> request) {
        return m75A(request);
    }

    /* renamed from: C */
    public final HeaderSigningResult m77C(Request<?> request, String str, String str2, String str3, String str4, AWSCredentials aWSCredentials) {
        String m78D = m78D(request.mo61q());
        String m79E = m79E(request.mo61q());
        String str5 = str + "/" + m78D + "/" + m79E + "/aws4_request";
        String m86L = m86L(str3, str2, str5, m80F(request, str4));
        String str6 = "AWS4" + aWSCredentials.mo97b();
        Charset charset = StringUtils.f489a;
        byte[] bytes = str6.getBytes(charset);
        SigningAlgorithm signingAlgorithm = SigningAlgorithm.HmacSHA256;
        byte[] m116u = m116u("aws4_request", m116u(m79E, m116u(m78D, m116u(str, bytes, signingAlgorithm), signingAlgorithm), signingAlgorithm), signingAlgorithm);
        return new HeaderSigningResult(str2, str5, m116u, m117v(m86L.getBytes(charset), m116u, signingAlgorithm));
    }

    /* renamed from: D */
    public String m78D(URI uri) {
        String str = this.f87c;
        return str != null ? str : AwsHostNameUtils.m637a(uri.getHost(), this.f86b);
    }

    /* renamed from: E */
    public String m79E(URI uri) {
        String str = this.f86b;
        return str != null ? str : AwsHostNameUtils.m639c(uri);
    }

    /* renamed from: F */
    public String m80F(Request<?> request, String str) {
        String str2 = request.mo54j().toString() + "\n" + m108l(HttpUtils.m663a(request.mo61q().getPath(), request.mo57m()), this.f89e) + "\n" + m105i(request) + "\n" + m81G(request) + "\n" + m85K(request) + "\n" + str;
        f85f.mo225a("AWS4 Canonical Request: '\"" + str2 + "\"");
        return str2;
    }

    /* renamed from: G */
    public String m81G(Request<?> request) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(request.mo49e().keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (m88N(str)) {
                String replaceAll = StringUtils.m679d(str).replaceAll("\\s+", " ");
                String str2 = request.mo49e().get(str);
                sb.append(replaceAll);
                sb.append(":");
                if (str2 != null) {
                    sb.append(str2.replaceAll("\\s+", " "));
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* renamed from: H */
    public final long m82H(Request<?> request) {
        Date m110o = m110o(m111p(request));
        Date date = this.f88d;
        if (date != null) {
            m110o = date;
        }
        return m110o.getTime();
    }

    /* renamed from: I */
    public final String m83I(long j) {
        return DateUtils.m655b("yyyyMMdd", new Date(j));
    }

    /* renamed from: J */
    public String m84J(Request<?> request, String str) {
        return str + "/" + m78D(request.mo61q()) + "/" + m79E(request.mo61q()) + "/aws4_request";
    }

    /* renamed from: K */
    public String m85K(Request<?> request) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(request.mo49e().keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (m88N(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(StringUtils.m679d(str));
            }
        }
        return sb.toString();
    }

    /* renamed from: L */
    public String m86L(String str, String str2, String str3, String str4) {
        String str5 = str + "\n" + str2 + "\n" + str3 + "\n" + BinaryUtils.m646a(m113r(str4));
        f85f.mo225a("AWS4 String to Sign: '\"" + str5 + "\"");
        return str5;
    }

    /* renamed from: M */
    public final String m87M(long j) {
        return DateUtils.m655b("yyyyMMdd'T'HHmmss'Z'", new Date(j));
    }

    /* renamed from: N */
    public boolean m88N(String str) {
        return "date".equalsIgnoreCase(str) || "Content-MD5".equalsIgnoreCase(str) || "host".equalsIgnoreCase(str) || str.startsWith("x-amz") || str.startsWith("X-Amz");
    }

    /* renamed from: O */
    public void m89O(Request<?> request, AWSCredentials aWSCredentials, Date date) {
        long time = date != null ? (date.getTime() - System.currentTimeMillis()) / 1000 : 604800L;
        if (time > 604800) {
            throw new AmazonClientException("Requests that are pre-signed by SigV4 algorithm are valid for at most 7 days. The expiration date set on the current request [" + m87M(date.getTime()) + "] has exceeded this limit.");
        }
        m93y(request);
        AWSCredentials m115t = m115t(aWSCredentials);
        if (m115t instanceof AWSSessionCredentials) {
            request.mo56l("X-Amz-Security-Token", ((AWSSessionCredentials) m115t).getSessionToken());
        }
        long m82H = m82H(request);
        String m83I = m83I(m82H);
        String str = m115t.mo96a() + "/" + m84J(request, m83I);
        String m87M = m87M(m82H);
        request.mo56l("X-Amz-Algorithm", "AWS4-HMAC-SHA256");
        request.mo56l("X-Amz-Date", m87M);
        request.mo56l("X-Amz-SignedHeaders", m85K(request));
        request.mo56l("X-Amz-Expires", Long.toString(time));
        request.mo56l("X-Amz-Credential", str);
        request.mo56l("X-Amz-Signature", BinaryUtils.m646a(m77C(request, m83I, m87M, "AWS4-HMAC-SHA256", m76B(request), m115t).m95a()));
    }

    /* renamed from: P */
    public void m90P(Request<?> request, HeaderSigningResult headerSigningResult) {
    }

    @Override // com.amazonaws.auth.ServiceAwareSigner
    /* renamed from: a */
    public void mo91a(String str) {
        this.f86b = str;
    }

    @Override // com.amazonaws.auth.Signer
    /* renamed from: b */
    public void mo72b(Request<?> request, AWSCredentials aWSCredentials) {
        AWSCredentials m115t = m115t(aWSCredentials);
        if (m115t instanceof AWSSessionCredentials) {
            m94z(request, (AWSSessionCredentials) m115t);
        }
        m93y(request);
        long m82H = m82H(request);
        String m83I = m83I(m82H);
        String m84J = m84J(request, m83I);
        String m75A = m75A(request);
        String m87M = m87M(m82H);
        request.mo60p("X-Amz-Date", m87M);
        if (request.mo49e().get("x-amz-content-sha256") != null && "required".equals(request.mo49e().get("x-amz-content-sha256"))) {
            request.mo60p("x-amz-content-sha256", m75A);
        }
        String str = m115t.mo96a() + "/" + m84J;
        HeaderSigningResult m77C = m77C(request, m83I, m87M, "AWS4-HMAC-SHA256", m75A, m115t);
        request.mo60p("Authorization", "AWS4-HMAC-SHA256 " + ("Credential=" + str) + ", " + ("SignedHeaders=" + m85K(request)) + ", " + ("Signature=" + BinaryUtils.m646a(m77C.m95a())));
        m90P(request, m77C);
    }

    @Override // com.amazonaws.auth.RegionAwareSigner
    /* renamed from: c */
    public void mo92c(String str) {
        this.f87c = str;
    }

    /* renamed from: y */
    public void m93y(Request<?> request) {
        String host = request.mo61q().getHost();
        if (HttpUtils.m666d(request.mo61q())) {
            host = host + ":" + request.mo61q().getPort();
        }
        request.mo60p("Host", host);
    }

    /* renamed from: z */
    public void m94z(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.mo60p("x-amz-security-token", aWSSessionCredentials.getSessionToken());
    }
}
