package cz.opentree;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.DataEncoder;
import cz.opentree.AbstractC0906e0;
import cz.opentree.AbstractC0962f;
import cz.opentree.AbstractC1684p;
import cz.opentree.AbstractC1742q;
import cz.opentree.AbstractC1794r;
import cz.opentree.AbstractC1892t;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: cz.opentree.x */
/* loaded from: classes.dex */
public final class C2252x implements TransportBackend {

    /* renamed from: a */
    public final DataEncoder f7823a;

    /* renamed from: b */
    public final ConnectivityManager f7824b;

    /* renamed from: c */
    public final URL f7825c;

    /* renamed from: d */
    public final Clock f7826d;

    /* renamed from: e */
    public final Clock f7827e;

    /* renamed from: f */
    public final int f7828f;

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: cz.opentree.x$a */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public final URL f7829a;

        /* renamed from: b */
        public final AbstractC1627o f7830b;

        /* renamed from: c */
        @Nullable
        public final String f7831c;

        public a(URL url, AbstractC1627o abstractC1627o, @Nullable String str) {
            this.f7829a = url;
            this.f7830b = abstractC1627o;
            this.f7831c = str;
        }

        /* renamed from: a */
        public a m9655a(URL url) {
            return new a(url, this.f7830b, this.f7831c);
        }
    }

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: cz.opentree.x$b */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a */
        public final int f7832a;

        /* renamed from: b */
        @Nullable
        public final URL f7833b;

        /* renamed from: c */
        public final long f7834c;

        public b(int i, @Nullable URL url, long j) {
            this.f7832a = i;
            this.f7833b = url;
            this.f7834c = j;
        }
    }

    public C2252x(Context context, Clock clock, Clock clock2) {
        bd0 bd0Var = new bd0();
        bd0Var.m2443g(C1019g.f2784a);
        bd0Var.m2444h(true);
        this.f7823a = bd0Var.m2442f();
        this.f7824b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f7825c = m9652f(C0905e.f2306c);
        this.f7826d = clock2;
        this.f7827e = clock;
        this.f7828f = 40000;
    }

    /* renamed from: c */
    public static /* synthetic */ a m9650c(a aVar, b bVar) {
        URL url = bVar.f7833b;
        if (url == null) {
            return null;
        }
        C2253x0.m9656a("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.m9655a(bVar.f7833b);
    }

    /* renamed from: f */
    public static URL m9652f(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid url: " + str, e);
        }
    }

    /* renamed from: g */
    public static /* synthetic */ void m9653g(Throwable th, AutoCloseable autoCloseable) {
        if (th == null) {
            autoCloseable.close();
        } else {
            try {
                autoCloseable.close();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    /* renamed from: a */
    public AbstractC1795r0 mo748a(AbstractC1743q0 abstractC1743q0) {
        AbstractC1742q.a m7580b;
        HashMap hashMap = new HashMap();
        for (AbstractC0906e0 abstractC0906e0 : abstractC1743q0.mo6603b()) {
            String mo3358j = abstractC0906e0.mo3358j();
            if (hashMap.containsKey(mo3358j)) {
                ((List) hashMap.get(mo3358j)).add(abstractC0906e0);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(abstractC0906e0);
                hashMap.put(mo3358j, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            AbstractC0906e0 abstractC0906e02 = (AbstractC0906e0) ((List) entry.getValue()).get(0);
            AbstractC1794r.a m7833a = AbstractC1794r.m7833a();
            m7833a.mo6026d(EnumC1988u.f6870O);
            m7833a.mo6024b(this.f7827e.mo807a());
            m7833a.mo6031i(this.f7826d.mo807a());
            AbstractC1684p.a m7161a = AbstractC1684p.m7161a();
            m7161a.mo4993b(AbstractC1684p.b.f5584P);
            AbstractC0962f.a m3606a = AbstractC0962f.m3606a();
            m3606a.mo3615a(Integer.valueOf(abstractC0906e02.m3355g("sdk-version")));
            m3606a.mo3621g(abstractC0906e02.m3350b("model"));
            m3606a.mo3619e(abstractC0906e02.m3350b("hardware"));
            m3606a.mo3616b(abstractC0906e02.m3350b("device"));
            m3606a.mo3623i(abstractC0906e02.m3350b("product"));
            m3606a.mo3622h(abstractC0906e02.m3350b("os-uild"));
            m3606a.mo3620f(abstractC0906e02.m3350b("manufacturer"));
            m3606a.mo3618d(abstractC0906e02.m3350b("fingerprint"));
            m7161a.mo4992a(m3606a.mo3617c());
            m7833a.mo6025c(m7161a.mo4994c());
            try {
                m7833a.m7834a(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                m7833a.m7835j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (AbstractC0906e0 abstractC0906e03 : (List) entry.getValue()) {
                C0855d0 mo3353e = abstractC0906e03.mo3353e();
                C0746b m3084b = mo3353e.m3084b();
                if (m3084b.equals(C0746b.m2321b("proto"))) {
                    m7580b = AbstractC1742q.m7580b(mo3353e.m3083a());
                } else if (m3084b.equals(C0746b.m2321b("json"))) {
                    m7580b = AbstractC1742q.m7579a(new String(mo3353e.m3083a(), Charset.forName("UTF-8")));
                } else {
                    C2253x0.m9661f("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", m3084b);
                }
                m7580b.mo5756a(abstractC0906e03.mo3354f());
                m7580b.mo5762g(abstractC0906e03.mo3359k());
                m7580b.mo5763h(abstractC0906e03.m3356h("tz-offset"));
                AbstractC1892t.a m8555a = AbstractC1892t.m8555a();
                m8555a.mo6601b(AbstractC1892t.c.m8558f(abstractC0906e03.m3355g("net-type")));
                m8555a.mo6600a(AbstractC1892t.b.m8556f(abstractC0906e03.m3355g("mobile-subtype")));
                m7580b.mo5757b(m8555a.mo6602c());
                if (abstractC0906e03.mo3352d() != null) {
                    m7580b.mo5758c(abstractC0906e03.mo3352d());
                }
                arrayList3.add(m7580b.mo5761f());
            }
            m7833a.mo6029g(arrayList3);
            arrayList2.add(m7833a.mo6030h());
        }
        AbstractC1627o m6822a = AbstractC1627o.m6822a(arrayList2);
        URL url = this.f7825c;
        if (abstractC1743q0.mo6604c() != null) {
            try {
                C0905e m3345c = C0905e.m3345c(abstractC1743q0.mo6604c());
                r1 = m3345c.m3347d() != null ? m3345c.m3347d() : null;
                if (m3345c.m3348e() != null) {
                    url = m9652f(m3345c.m3348e());
                }
            } catch (IllegalArgumentException unused2) {
                return AbstractC1795r0.m7836a();
            }
        }
        try {
            b bVar = (b) C2320y0.m9989a(5, new a(url, m6822a, r1), C2145v.m9131a(this), C2193w.m9376b());
            int i = bVar.f7832a;
            if (i == 200) {
                return AbstractC1795r0.m7837d(bVar.f7834c);
            }
            if (i < 500 && i != 404) {
                return AbstractC1795r0.m7836a();
            }
            return AbstractC1795r0.m7838e();
        } catch (IOException e) {
            C2253x0.m9658c("CctTransportBackend", "Could not make request to the backend", e);
            return AbstractC1795r0.m7838e();
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    /* renamed from: b */
    public AbstractC0906e0 mo749b(AbstractC0906e0 abstractC0906e0) {
        int subtype;
        NetworkInfo activeNetworkInfo = this.f7824b.getActiveNetworkInfo();
        AbstractC0906e0.a m3360l = abstractC0906e0.m3360l();
        m3360l.m3361a("sdk-version", Build.VERSION.SDK_INT);
        m3360l.m3363c("model", Build.MODEL);
        m3360l.m3363c("hardware", Build.HARDWARE);
        m3360l.m3363c("device", Build.DEVICE);
        m3360l.m3363c("product", Build.PRODUCT);
        m3360l.m3363c("os-uild", Build.ID);
        m3360l.m3363c("manufacturer", Build.MANUFACTURER);
        m3360l.m3363c("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        m3360l.m3362b("tz-offset", TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000);
        m3360l.m3361a("net-type", activeNetworkInfo == null ? AbstractC1892t.c.f6668h0.m8559a() : activeNetworkInfo.getType());
        if (activeNetworkInfo == null) {
            subtype = AbstractC1892t.b.f6627P.m8557a();
        } else {
            subtype = activeNetworkInfo.getSubtype();
            if (subtype == -1) {
                subtype = AbstractC1892t.b.f6647j0.m8557a();
            } else if (AbstractC1892t.b.m8556f(subtype) == null) {
                subtype = 0;
            }
        }
        m3360l.m3361a("mobile-subtype", subtype);
        return m3360l.mo3364d();
    }

    /* renamed from: d */
    public final b m9654d(a aVar) throws IOException {
        C2253x0.m9656a("CctTransportBackend", "Making request to: %s", aVar.f7829a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f7829a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f7828f);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "2.2.1"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f7831c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f7823a.mo1850a(aVar.f7830b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    m9653g(null, gZIPOutputStream);
                    if (outputStream != null) {
                        m9653g(null, outputStream);
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    C2253x0.m9660e("CctTransportBackend", "Status Code: " + responseCode);
                    C2253x0.m9660e("CctTransportBackend", "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                    C2253x0.m9660e("CctTransportBackend", "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            b bVar = new b(responseCode, null, AbstractC1840s.m8288b(new BufferedReader(new InputStreamReader(gZIPInputStream))).mo6326a());
                            if (gZIPInputStream != null) {
                                m9653g(null, gZIPInputStream);
                            }
                            if (inputStream != null) {
                                m9653g(null, inputStream);
                            }
                            return bVar;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (xc0 | IOException e) {
            C2253x0.m9658c("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        }
    }
}
