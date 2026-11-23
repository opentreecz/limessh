package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.internal.SdkDigestInputStream;
import com.amazonaws.util.Base64;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public abstract class AbstractAWSSigner implements Signer {

    /* renamed from: a */
    public static final ThreadLocal<MessageDigest> f91a = new ThreadLocal<MessageDigest>() { // from class: com.amazonaws.auth.AbstractAWSSigner.1
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                throw new AmazonClientException("Unable to get SHA256 Function" + e.getMessage(), e);
            }
        }
    };

    static {
        BinaryUtils.m646a(m99d(""));
    }

    /* renamed from: d */
    public static byte[] m99d(String str) {
        try {
            MessageDigest m100m = m100m();
            m100m.update(str.getBytes(StringUtils.f489a));
            return m100m.digest();
        } catch (Exception e) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e.getMessage(), e);
        }
    }

    /* renamed from: m */
    public static MessageDigest m100m() {
        MessageDigest messageDigest = f91a.get();
        messageDigest.reset();
        return messageDigest;
    }

    /* renamed from: e */
    public InputStream m101e(Request<?> request) {
        if (!HttpUtils.m668f(request)) {
            return m102f(request);
        }
        String m665c = HttpUtils.m665c(request);
        return m665c == null ? new ByteArrayInputStream(new byte[0]) : new ByteArrayInputStream(m665c.getBytes(StringUtils.f489a));
    }

    /* renamed from: f */
    public InputStream m102f(Request<?> request) {
        try {
            InputStream content = request.getContent();
            if (content == null) {
                return new ByteArrayInputStream(new byte[0]);
            }
            if (content.markSupported()) {
                return request.getContent();
            }
            throw new AmazonClientException("Unable to read request payload to sign request.");
        } catch (Exception e) {
            throw new AmazonClientException("Unable to read request payload to sign request: " + e.getMessage(), e);
        }
    }

    /* renamed from: g */
    public byte[] m103g(Request<?> request) {
        InputStream m102f = m102f(request);
        try {
            m102f.mark(-1);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[5120];
            while (true) {
                int read = m102f.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.close();
                    m102f.reset();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e) {
            throw new AmazonClientException("Unable to read request payload to sign request: " + e.getMessage(), e);
        }
    }

    /* renamed from: h */
    public String m104h(URI uri) {
        String m679d = StringUtils.m679d(uri.getHost());
        if (!HttpUtils.m666d(uri)) {
            return m679d;
        }
        return m679d + ":" + uri.getPort();
    }

    /* renamed from: i */
    public String m105i(Request<?> request) {
        return HttpUtils.m668f(request) ? "" : m106j(request.mo45a());
    }

    /* renamed from: j */
    public String m106j(Map<String, String> map) {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            treeMap.put(HttpUtils.m667e(entry.getKey(), false), HttpUtils.m667e(entry.getValue(), false));
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = treeMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            sb.append((String) entry2.getKey());
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append((String) entry2.getValue());
            if (it.hasNext()) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    /* renamed from: k */
    public String m107k(String str) {
        return m108l(str, true);
    }

    /* renamed from: l */
    public String m108l(String str, boolean z) {
        if (str == null || str.length() == 0) {
            return "/";
        }
        if (z) {
            str = HttpUtils.m667e(str, true);
        }
        return str.startsWith("/") ? str : "/".concat(str);
    }

    /* renamed from: n */
    public String m109n(Request<?> request) {
        return m114s(m103g(request));
    }

    /* renamed from: o */
    public Date m110o(int i) {
        Date date = new Date();
        return i != 0 ? new Date(date.getTime() - (i * 1000)) : date;
    }

    /* renamed from: p */
    public int m111p(Request<?> request) {
        return SDKGlobalConfiguration.m67a() != 0 ? SDKGlobalConfiguration.m67a() : request.mo52h();
    }

    /* renamed from: q */
    public byte[] m112q(InputStream inputStream) {
        try {
            SdkDigestInputStream sdkDigestInputStream = new SdkDigestInputStream(inputStream, m100m());
            do {
            } while (sdkDigestInputStream.read(new byte[1024]) > -1);
            return sdkDigestInputStream.getMessageDigest().digest();
        } catch (Exception e) {
            throw new AmazonClientException("Unable to compute hash while signing request: " + e.getMessage(), e);
        }
    }

    /* renamed from: r */
    public byte[] m113r(String str) {
        return m99d(str);
    }

    /* renamed from: s */
    public String m114s(byte[] bArr) {
        return new String(bArr, StringUtils.f489a);
    }

    /* renamed from: t */
    public AWSCredentials m115t(AWSCredentials aWSCredentials) {
        String mo96a;
        String mo97b;
        String sessionToken;
        synchronized (aWSCredentials) {
            mo96a = aWSCredentials.mo96a();
            mo97b = aWSCredentials.mo97b();
            sessionToken = aWSCredentials instanceof AWSSessionCredentials ? ((AWSSessionCredentials) aWSCredentials).getSessionToken() : null;
        }
        if (mo97b != null) {
            mo97b = mo97b.trim();
        }
        if (mo96a != null) {
            mo96a = mo96a.trim();
        }
        if (sessionToken != null) {
            sessionToken = sessionToken.trim();
        }
        return aWSCredentials instanceof AWSSessionCredentials ? new BasicSessionCredentials(mo96a, mo97b, sessionToken) : new BasicAWSCredentials(mo96a, mo97b);
    }

    /* renamed from: u */
    public byte[] m116u(String str, byte[] bArr, SigningAlgorithm signingAlgorithm) {
        try {
            return m117v(str.getBytes(StringUtils.f489a), bArr, signingAlgorithm);
        } catch (Exception e) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e.getMessage(), e);
        }
    }

    /* renamed from: v */
    public byte[] m117v(byte[] bArr, byte[] bArr2, SigningAlgorithm signingAlgorithm) {
        try {
            Mac mac = Mac.getInstance(signingAlgorithm.toString());
            mac.init(new SecretKeySpec(bArr2, signingAlgorithm.toString()));
            return mac.doFinal(bArr);
        } catch (Exception e) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e.getMessage(), e);
        }
    }

    /* renamed from: w */
    public String m118w(String str, String str2, SigningAlgorithm signingAlgorithm) {
        return m119x(str.getBytes(StringUtils.f489a), str2, signingAlgorithm);
    }

    /* renamed from: x */
    public String m119x(byte[] bArr, String str, SigningAlgorithm signingAlgorithm) {
        try {
            return Base64.m641f(m117v(bArr, str.getBytes(StringUtils.f489a), signingAlgorithm));
        } catch (Exception e) {
            throw new AmazonClientException("Unable to calculate a request signature: " + e.getMessage(), e);
        }
    }
}
