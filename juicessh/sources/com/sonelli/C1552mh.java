package com.sonelli;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.sonelli.mh */
/* loaded from: classes.dex */
public final class C1552mh extends AbstractC2006uf {

    /* renamed from: S */
    public static final byte[] f5036S = "\n".getBytes();

    /* renamed from: Q */
    public final String f5037Q;

    /* renamed from: R */
    public final C2221wh f5038R;

    public C1552mh(C2216wf c2216wf) {
        super(c2216wf);
        this.f5037Q = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", C2167vf.f7453a, Build.VERSION.RELEASE, C0713ai.m2074c(Locale.getDefault()), Build.MODEL, Build.ID);
        this.f5038R = new C2221wh(c2216wf.m9476d());
    }

    /* renamed from: J0 */
    public static void m6409J0(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    @Override // com.sonelli.AbstractC2006uf
    /* renamed from: E0 */
    public final void mo2053E0() {
        m8679z("Network initialized. User agent", this.f5037Q);
    }

    /* renamed from: G0 */
    public final int m6411G0(URL url) {
        C0813ca.m2729k(url);
        m8653Z("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                httpURLConnection = m6416M0(url);
                httpURLConnection.connect();
                m6414K0(httpURLConnection);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    m8664l0().m7024P0();
                }
                m8653Z("GET status", Integer.valueOf(responseCode));
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return responseCode;
            } catch (IOException e) {
                m8672t0("Network GET connection error", e);
                if (httpURLConnection == null) {
                    return 0;
                }
                httpURLConnection.disconnect();
                return 0;
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.net.URL, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.net.HttpURLConnection] */
    /* renamed from: H0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m6412H0(java.net.URL r5, byte[] r6) {
        /*
            r4 = this;
            java.lang.String r0 = "Error closing http post connection output stream"
            com.sonelli.C0813ca.m2729k(r5)
            com.sonelli.C0813ca.m2729k(r6)
            int r1 = r6.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "POST bytes, url"
            r4.m8654a0(r2, r1, r5)
            boolean r1 = com.sonelli.C1930tf.m8648v0()
            if (r1 == 0) goto L22
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6)
            java.lang.String r2 = "Post payload\n"
            r4.m8679z(r2, r1)
        L22:
            r1 = 0
            android.content.Context r2 = r4.m8675x()     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L70
            r2.getPackageName()     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L70
            java.net.HttpURLConnection r5 = r4.m6416M0(r5)     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L70
            r2 = 1
            r5.setDoOutput(r2)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            int r2 = r6.length     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            r5.setFixedLengthStreamingMode(r2)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            r5.connect()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            java.io.OutputStream r1 = r5.getOutputStream()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            r1.write(r6)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            r4.m6414K0(r5)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            int r6 = r5.getResponseCode()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            r2 = 200(0xc8, float:2.8E-43)
            if (r6 != r2) goto L52
            com.sonelli.of r2 = r4.m8664l0()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            r2.m7024P0()     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
        L52:
            java.lang.String r2 = "POST status"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            r4.m8653Z(r2, r3)     // Catch: java.io.IOException -> L6b java.lang.Throwable -> L88
            if (r1 == 0) goto L65
            r1.close()     // Catch: java.io.IOException -> L61
            goto L65
        L61:
            r1 = move-exception
            r4.m8674w0(r0, r1)
        L65:
            if (r5 == 0) goto L6a
            r5.disconnect()
        L6a:
            return r6
        L6b:
            r6 = move-exception
            goto L72
        L6d:
            r6 = move-exception
            r5 = r1
            goto L89
        L70:
            r6 = move-exception
            r5 = r1
        L72:
            java.lang.String r2 = "Network POST connection error"
            r4.m8672t0(r2, r6)     // Catch: java.lang.Throwable -> L88
            if (r1 == 0) goto L81
            r1.close()     // Catch: java.io.IOException -> L7d
            goto L81
        L7d:
            r6 = move-exception
            r4.m8674w0(r0, r6)
        L81:
            if (r5 == 0) goto L86
            r5.disconnect()
        L86:
            r5 = 0
            return r5
        L88:
            r6 = move-exception
        L89:
            if (r1 == 0) goto L93
            r1.close()     // Catch: java.io.IOException -> L8f
            goto L93
        L8f:
            r1 = move-exception
            r4.m8674w0(r0, r1)
        L93:
            if (r5 == 0) goto L98
            r5.disconnect()
        L98:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.C1552mh.m6412H0(java.net.URL, byte[]):int");
    }

    /* renamed from: I0 */
    public final String m6413I0(C1043gh c1043gh, boolean z) {
        C0813ca.m2729k(c1043gh);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : c1043gh.m4126e().entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    m6409J0(sb, key, entry.getValue());
                }
            }
            m6409J0(sb, "ht", String.valueOf(c1043gh.m4129h()));
            m6409J0(sb, "qt", String.valueOf(m8659g0().mo1177a() - c1043gh.m4129h()));
            if (z) {
                long m4132k = c1043gh.m4132k();
                m6409J0(sb, "z", m4132k != 0 ? String.valueOf(m4132k) : String.valueOf(c1043gh.m4128g()));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            m8674w0("Failed to encode name or value", e);
            return null;
        }
    }

    /* renamed from: K0 */
    public final void m6414K0(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                do {
                } while (inputStream.read(new byte[1024]) > 0);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        m8674w0("Error closing http connection input stream", e);
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        m8674w0("Error closing http connection input stream", e2);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: L0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m6415L0(java.net.URL r11, byte[] r12) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.C1552mh.m6415L0(java.net.URL, byte[]):int");
    }

    /* renamed from: M0 */
    public final HttpURLConnection m6416M0(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!(openConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(C0770bh.f1697v.m2801a().intValue());
        httpURLConnection.setReadTimeout(C0770bh.f1698w.m2801a().intValue());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.f5037Q);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* renamed from: N0 */
    public final URL m6417N0(C1043gh c1043gh, String str) {
        String sb;
        if (c1043gh.m4131j()) {
            String m8885h = C2007ug.m8885h();
            String m8887j = C2007ug.m8887j();
            StringBuilder sb2 = new StringBuilder(String.valueOf(m8885h).length() + 1 + String.valueOf(m8887j).length() + String.valueOf(str).length());
            sb2.append(m8885h);
            sb2.append(m8887j);
            sb2.append("?");
            sb2.append(str);
            sb = sb2.toString();
        } else {
            String m8886i = C2007ug.m8886i();
            String m8887j2 = C2007ug.m8887j();
            StringBuilder sb3 = new StringBuilder(String.valueOf(m8886i).length() + 1 + String.valueOf(m8887j2).length() + String.valueOf(str).length());
            sb3.append(m8886i);
            sb3.append(m8887j2);
            sb3.append("?");
            sb3.append(str);
            sb = sb3.toString();
        }
        try {
            return new URL(sb);
        } catch (MalformedURLException e) {
            m8674w0("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0157, code lost:
    
        if (m6411G0(r5) == 200) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0199, code lost:
    
        if (m6412H0(r6, r5) == 200) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01b3 A[EDGE_INSN: B:52:0x01b3->B:50:0x01b3 BREAK  A[LOOP:1: B:40:0x010f->B:51:?], SYNTHETIC] */
    /* renamed from: O0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<java.lang.Long> m6418O0(java.util.List<com.sonelli.C1043gh> r9) {
        /*
            Method dump skipped, instructions count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.C1552mh.m6418O0(java.util.List):java.util.List");
    }

    /* renamed from: P0 */
    public final URL m6419P0(C1043gh c1043gh) {
        String str;
        String concat;
        if (c1043gh.m4131j()) {
            String valueOf = String.valueOf(C2007ug.m8885h());
            String valueOf2 = String.valueOf(C2007ug.m8887j());
            if (valueOf2.length() != 0) {
                concat = valueOf.concat(valueOf2);
            } else {
                str = new String(valueOf);
                concat = str;
            }
        } else {
            String valueOf3 = String.valueOf(C2007ug.m8886i());
            String valueOf4 = String.valueOf(C2007ug.m8887j());
            if (valueOf4.length() != 0) {
                concat = valueOf3.concat(valueOf4);
            } else {
                str = new String(valueOf3);
                concat = str;
            }
        }
        try {
            return new URL(concat);
        } catch (MalformedURLException e) {
            m8674w0("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    /* renamed from: Q0 */
    public final boolean m6420Q0() {
        NetworkInfo networkInfo;
        C1434k4.m5823i();
        m8878F0();
        try {
            networkInfo = ((ConnectivityManager) m8675x().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        m8676x0("No network connectivity");
        return false;
    }

    /* renamed from: R0 */
    public final URL m6421R0() {
        String valueOf = String.valueOf(C2007ug.m8885h());
        String valueOf2 = String.valueOf(C0770bh.f1688m.m2801a());
        try {
            return new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        } catch (MalformedURLException e) {
            m8674w0("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }
}
