package com.amazonaws.http;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* loaded from: classes.dex */
public class UrlHttpClient implements HttpClient {

    /* renamed from: c */
    public static final Log f147c = LogFactory.m237c(UrlHttpClient.class);

    /* renamed from: a */
    public final ClientConfiguration f148a;

    /* renamed from: b */
    public SSLContext f149b = null;

    /* loaded from: classes.dex */
    public final class CurlBuilder {

        /* renamed from: a */
        public final URL f150a;

        /* renamed from: b */
        public String f151b = null;

        /* renamed from: c */
        public final HashMap<String, String> f152c = new HashMap<>();

        /* renamed from: d */
        public String f153d = null;

        /* renamed from: e */
        public boolean f154e = false;

        public CurlBuilder(UrlHttpClient urlHttpClient, URL url) {
            if (url == null) {
                throw new IllegalArgumentException("Must have a valid url");
            }
            this.f150a = url;
        }

        /* renamed from: a */
        public String m202a() {
            if (!m203b()) {
                throw new IllegalStateException("Invalid state, cannot create curl command");
            }
            StringBuilder sb = new StringBuilder("curl");
            if (this.f151b != null) {
                sb.append(" -X ");
                sb.append(this.f151b);
            }
            for (Map.Entry<String, String> entry : this.f152c.entrySet()) {
                sb.append(" -H \"");
                sb.append(entry.getKey());
                sb.append(":");
                sb.append(entry.getValue());
                sb.append("\"");
            }
            if (this.f153d != null) {
                sb.append(" -d '");
                sb.append(this.f153d);
                sb.append("'");
            }
            sb.append(" ");
            sb.append(this.f150a.toString());
            return sb.toString();
        }

        /* renamed from: b */
        public boolean m203b() {
            return !this.f154e;
        }

        /* renamed from: c */
        public CurlBuilder m204c(String str) {
            this.f153d = str;
            return this;
        }

        /* renamed from: d */
        public CurlBuilder m205d(boolean z) {
            this.f154e = z;
            return this;
        }

        /* renamed from: e */
        public CurlBuilder m206e(Map<String, String> map) {
            this.f152c.clear();
            this.f152c.putAll(map);
            return this;
        }

        /* renamed from: f */
        public CurlBuilder m207f(String str) {
            this.f151b = str;
            return this;
        }
    }

    public UrlHttpClient(ClientConfiguration clientConfiguration) {
        this.f148a = clientConfiguration;
    }

    @Override // com.amazonaws.http.HttpClient
    /* renamed from: a */
    public HttpResponse mo171a(HttpRequest httpRequest) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpRequest.m176e().toURL().openConnection();
        CurlBuilder curlBuilder = this.f148a.m43i() ? new CurlBuilder(this, httpRequest.m176e().toURL()) : null;
        m196c(httpRequest, httpURLConnection);
        m195b(httpRequest, httpURLConnection, curlBuilder);
        m201h(httpRequest, httpURLConnection, curlBuilder);
        if (curlBuilder != null) {
            if (curlBuilder.m203b()) {
                m199f(curlBuilder.m202a());
            } else {
                m199f("Failed to create curl, content too long");
            }
        }
        return m197d(httpRequest, httpURLConnection);
    }

    /* renamed from: b */
    public HttpURLConnection m195b(HttpRequest httpRequest, HttpURLConnection httpURLConnection, CurlBuilder curlBuilder) throws ProtocolException {
        if (httpRequest.m174c() != null && !httpRequest.m174c().isEmpty()) {
            if (curlBuilder != null) {
                curlBuilder.m206e(httpRequest.m174c());
            }
            for (Map.Entry<String, String> entry : httpRequest.m174c().entrySet()) {
                String key = entry.getKey();
                if (!key.equals("Content-Length") && !key.equals("Host")) {
                    key.equals("Expect");
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        String m175d = httpRequest.m175d();
        httpURLConnection.setRequestMethod(m175d);
        if (curlBuilder != null) {
            curlBuilder.m207f(m175d);
        }
        return httpURLConnection;
    }

    /* renamed from: c */
    public void m196c(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(this.f148a.m35a());
        httpURLConnection.setReadTimeout(this.f148a.m40f());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setUseCaches(false);
        if (httpRequest.m177f()) {
            httpURLConnection.setChunkedStreamingMode(0);
        }
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            if (this.f148a.m41g() != null) {
                m198e(httpsURLConnection);
            }
        }
    }

    /* renamed from: d */
    public HttpResponse m197d(HttpRequest httpRequest, HttpURLConnection httpURLConnection) throws IOException {
        String responseMessage = httpURLConnection.getResponseMessage();
        int responseCode = httpURLConnection.getResponseCode();
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null && !"HEAD".equals(httpRequest.m175d())) {
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (IOException unused) {
            }
        }
        HttpResponse.Builder m182a = HttpResponse.m182a();
        m182a.m191d(responseCode);
        m182a.m192e(responseMessage);
        m182a.m189b(errorStream);
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                m182a.m190c(entry.getKey(), entry.getValue().get(0));
            }
        }
        return m182a.m188a();
    }

    /* renamed from: e */
    public final void m198e(HttpsURLConnection httpsURLConnection) {
        if (this.f149b == null) {
            TrustManager[] trustManagerArr = {this.f148a.m41g()};
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                this.f149b = sSLContext;
                sSLContext.init(null, trustManagerArr, null);
            } catch (GeneralSecurityException e) {
                throw new RuntimeException(e);
            }
        }
        httpsURLConnection.setSSLSocketFactory(this.f149b.getSocketFactory());
    }

    /* renamed from: f */
    public void m199f(String str) {
        f147c.mo225a(str);
    }

    /* renamed from: g */
    public final void m200g(InputStream inputStream, OutputStream outputStream, CurlBuilder curlBuilder, ByteBuffer byteBuffer) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            if (byteBuffer != null) {
                try {
                    byteBuffer.put(bArr, 0, read);
                } catch (BufferOverflowException unused) {
                    curlBuilder.m205d(true);
                }
            }
            outputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: h */
    public void m201h(HttpRequest httpRequest, HttpURLConnection httpURLConnection, CurlBuilder curlBuilder) throws IOException {
        if (httpRequest.m172a() == null || httpRequest.m173b() < 0) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        if (!httpRequest.m177f()) {
            httpURLConnection.setFixedLengthStreamingMode((int) httpRequest.m173b());
        }
        OutputStream outputStream = httpURLConnection.getOutputStream();
        ByteBuffer byteBuffer = null;
        if (curlBuilder != null) {
            if (httpRequest.m173b() < 2147483647L) {
                byteBuffer = ByteBuffer.allocate((int) httpRequest.m173b());
            } else {
                curlBuilder.m205d(true);
            }
        }
        m200g(httpRequest.m172a(), outputStream, curlBuilder, byteBuffer);
        if (curlBuilder != null && byteBuffer != null && byteBuffer.position() != 0) {
            curlBuilder.m204c(new String(byteBuffer.array(), "UTF-8"));
        }
        outputStream.flush();
        outputStream.close();
    }

    @Override // com.amazonaws.http.HttpClient
    public void shutdown() {
    }
}
