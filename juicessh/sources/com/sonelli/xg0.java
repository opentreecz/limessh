package com.sonelli;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

/* compiled from: AsyncHttpRequest.java */
/* loaded from: classes.dex */
public class xg0 implements Runnable {

    /* renamed from: O */
    public final AbstractHttpClient f7925O;

    /* renamed from: P */
    public final HttpContext f7926P;

    /* renamed from: Q */
    public final HttpUriRequest f7927Q;

    /* renamed from: R */
    public final yg0 f7928R;

    /* renamed from: S */
    public boolean f7929S;

    /* renamed from: T */
    public int f7930T;

    public xg0(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, yg0 yg0Var) {
        this.f7925O = abstractHttpClient;
        this.f7926P = httpContext;
        this.f7927Q = httpUriRequest;
        this.f7928R = yg0Var;
    }

    /* renamed from: a */
    public final void m9761a() throws IOException {
        yg0 yg0Var;
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        HttpResponse execute = this.f7925O.execute(this.f7927Q, this.f7926P);
        if (Thread.currentThread().isInterrupted() || (yg0Var = this.f7928R) == null) {
            return;
        }
        yg0Var.m10142o(execute);
    }

    /* renamed from: b */
    public final void m9762b() throws ConnectException {
        HttpRequestRetryHandler httpRequestRetryHandler = this.f7925O.getHttpRequestRetryHandler();
        IOException e = null;
        boolean z = true;
        while (z) {
            try {
                m9761a();
                return;
            } catch (NullPointerException e2) {
                e2.printStackTrace();
                IOException iOException = new IOException("NPE in HttpClient" + e2.getMessage());
                int i = this.f7930T + 1;
                this.f7930T = i;
                z = httpRequestRetryHandler.retryRequest(iOException, i, this.f7926P);
                e = iOException;
            } catch (UnknownHostException e3) {
                if (this.f7928R != null) {
                    this.f7928R.mo7341g(e3, "Can't resolve host");
                    return;
                }
                return;
            } catch (HttpHostConnectException e4) {
                if (this.f7928R != null) {
                    this.f7928R.mo7341g(e4, "Can't connect to host");
                    return;
                }
                return;
            } catch (IOException e5) {
                e = e5;
                int i2 = this.f7930T + 1;
                this.f7930T = i2;
                z = httpRequestRetryHandler.retryRequest(e, i2, this.f7926P);
            }
        }
        ConnectException connectException = new ConnectException();
        connectException.initCause(e);
        throw connectException;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            yg0 yg0Var = this.f7928R;
            if (yg0Var != null) {
                yg0Var.m10143p();
            }
            m9762b();
            yg0 yg0Var2 = this.f7928R;
            if (yg0Var2 != null) {
                yg0Var2.m10140m();
            }
        } catch (IOException e) {
            yg0 yg0Var3 = this.f7928R;
            if (yg0Var3 != null) {
                yg0Var3.m10140m();
                if (this.f7929S) {
                    this.f7928R.m10139l(e, null);
                } else {
                    this.f7928R.m10138k(e, null);
                }
            }
        }
    }
}
