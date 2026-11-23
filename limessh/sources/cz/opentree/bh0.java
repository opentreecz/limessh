package cz.opentree;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* compiled from: RetryHandler.java */
/* loaded from: classes.dex */
public class bh0 implements HttpRequestRetryHandler {

    /* renamed from: b */
    public static HashSet<Class<?>> f1702b = new HashSet<>();

    /* renamed from: c */
    public static HashSet<Class<?>> f1703c = new HashSet<>();

    /* renamed from: a */
    public final int f1704a;

    static {
        f1702b.add(NoHttpResponseException.class);
        f1702b.add(UnknownHostException.class);
        f1702b.add(SocketException.class);
        f1703c.add(InterruptedIOException.class);
        f1703c.add(SSLHandshakeException.class);
    }

    public bh0(int i) {
        this.f1704a = i;
    }

    @Override // org.apache.http.client.HttpRequestRetryHandler
    public boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        Boolean bool = (Boolean) httpContext.getAttribute("http.request_sent");
        boolean z = false;
        boolean z2 = bool != null && bool.booleanValue();
        if (i <= this.f1704a && !f1703c.contains(iOException.getClass())) {
            z = (!f1702b.contains(iOException.getClass()) && z2) ? !((HttpUriRequest) httpContext.getAttribute("http.request")).getMethod().equals("POST") : true;
        }
        if (z) {
            SystemClock.sleep(1500L);
        } else {
            iOException.printStackTrace();
        }
        return z;
    }
}
