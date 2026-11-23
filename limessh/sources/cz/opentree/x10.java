package cz.opentree;

import androidx.annotation.WorkerThread;
import com.google.android.gms.measurement.internal.zzib;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
@WorkerThread
/* loaded from: classes.dex */
public final class x10 implements Runnable {

    /* renamed from: O */
    public final URL f7844O;

    /* renamed from: P */
    public final zzib f7845P;

    /* renamed from: Q */
    public final String f7846Q;

    /* renamed from: R */
    public final Map<String, String> f7847R;

    /* renamed from: S */
    public final /* synthetic */ v10 f7848S;

    public x10(v10 v10Var, String str, URL url, byte[] bArr, Map<String, String> map, zzib zzibVar) {
        this.f7848S = v10Var;
        C0813ca.m2725g(str);
        C0813ca.m2729k(url);
        C0813ca.m2729k(zzibVar);
        this.f7844O = url;
        this.f7845P = zzibVar;
        this.f7846Q = str;
        this.f7847R = null;
    }

    /* renamed from: a */
    public final /* synthetic */ void m9668a(int i, Exception exc, byte[] bArr, Map map) {
        this.f7845P.mo1500a(this.f7846Q, i, exc, bArr, map);
    }

    /* renamed from: b */
    public final void m9669b(final int i, final Exception exc, final byte[] bArr, final Map<String, List<String>> map) {
        this.f7848S.mo1481g().m8281A(new Runnable(this, i, exc, bArr, map) { // from class: cz.opentree.w10

            /* renamed from: O */
            public final x10 f7587O;

            /* renamed from: P */
            public final int f7588P;

            /* renamed from: Q */
            public final Exception f7589Q;

            /* renamed from: R */
            public final byte[] f7590R;

            /* renamed from: S */
            public final Map f7591S;

            {
                this.f7587O = this;
                this.f7588P = i;
                this.f7589Q = exc;
                this.f7590R = bArr;
                this.f7591S = map;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f7587O.m9668a(this.f7588P, this.f7589Q, this.f7590R, this.f7591S);
            }
        });
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> map;
        Map<String, List<String>> map2;
        byte[] m9143x;
        this.f7848S.mo7584c();
        int i = 0;
        try {
            httpURLConnection = this.f7848S.m9144v(this.f7844O);
            try {
                Map<String, String> map3 = this.f7847R;
                if (map3 != null) {
                    for (Map.Entry<String, String> entry : map3.entrySet()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                i = httpURLConnection.getResponseCode();
                Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                try {
                    v10 v10Var = this.f7848S;
                    m9143x = v10.m9143x(httpURLConnection);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    m9669b(i, null, m9143x, headerFields);
                } catch (IOException e) {
                    map2 = headerFields;
                    e = e;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    m9669b(i, e, null, map2);
                } catch (Throwable th) {
                    map = headerFields;
                    th = th;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    m9669b(i, null, null, map);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                map2 = null;
            } catch (Throwable th2) {
                th = th2;
                map = null;
            }
        } catch (IOException e3) {
            e = e3;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            map = null;
        }
    }
}
