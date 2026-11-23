package cz.opentree;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: RequestParams.java */
/* loaded from: classes.dex */
public class ah0 {

    /* renamed from: c */
    public static String f1389c = "UTF-8";

    /* renamed from: a */
    public ConcurrentHashMap<String, String> f1390a;

    /* renamed from: b */
    public ConcurrentHashMap<String, C0712a> f1391b;

    /* compiled from: RequestParams.java */
    /* renamed from: cz.opentree.ah0$a */
    /* loaded from: classes.dex */
    public static class C0712a {

        /* renamed from: a */
        public InputStream f1392a;

        /* renamed from: b */
        public String f1393b;

        /* renamed from: c */
        public String f1394c;

        /* renamed from: a */
        public String m2071a() {
            String str = this.f1393b;
            return str != null ? str : "nofilename";
        }
    }

    public ah0() {
        m2069d();
    }

    /* renamed from: a */
    public HttpEntity m2066a() {
        if (this.f1391b.isEmpty()) {
            try {
                return new UrlEncodedFormEntity(m2068c(), f1389c);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }
        ch0 ch0Var = new ch0();
        for (Map.Entry<String, String> entry : this.f1390a.entrySet()) {
            ch0Var.m2802a(entry.getKey(), entry.getValue());
        }
        int size = this.f1391b.entrySet().size() - 1;
        int i = 0;
        for (Map.Entry<String, C0712a> entry2 : this.f1391b.entrySet()) {
            C0712a value = entry2.getValue();
            if (value.f1392a != null) {
                boolean z = i == size;
                if (value.f1394c != null) {
                    ch0Var.m2803b(entry2.getKey(), value.m2071a(), value.f1392a, value.f1394c, z);
                } else {
                    ch0Var.m2804c(entry2.getKey(), value.m2071a(), value.f1392a, z);
                }
            }
            i++;
        }
        return ch0Var;
    }

    /* renamed from: b */
    public String m2067b() {
        return URLEncodedUtils.format(m2068c(), f1389c);
    }

    /* renamed from: c */
    public List<BasicNameValuePair> m2068c() {
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, String> entry : this.f1390a.entrySet()) {
            linkedList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return linkedList;
    }

    /* renamed from: d */
    public final void m2069d() {
        this.f1390a = new ConcurrentHashMap<>();
        this.f1391b = new ConcurrentHashMap<>();
    }

    /* renamed from: e */
    public void m2070e(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f1390a.put(str, str2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.f1390a.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(entry.getValue());
        }
        for (Map.Entry<String, C0712a> entry2 : this.f1391b.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry2.getKey());
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append("FILE");
        }
        return sb.toString();
    }
}
