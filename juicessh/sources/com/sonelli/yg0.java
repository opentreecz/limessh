package com.sonelli;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

/* compiled from: AsyncHttpResponseHandler.java */
/* loaded from: classes.dex */
public class yg0 {

    /* renamed from: a */
    public Handler f8216a;

    /* renamed from: b */
    public HttpResponse f8217b;

    /* compiled from: AsyncHttpResponseHandler.java */
    /* renamed from: com.sonelli.yg0$a */
    /* loaded from: classes.dex */
    public class HandlerC2346a extends Handler {
        public HandlerC2346a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            yg0.this.m10133c(message);
        }
    }

    public yg0() {
        if (Looper.myLooper() != null) {
            this.f8216a = new HandlerC2346a();
        }
    }

    /* renamed from: a */
    public int m10131a() {
        StatusLine statusLine;
        HttpResponse httpResponse = this.f8217b;
        if (httpResponse == null || (statusLine = httpResponse.getStatusLine()) == null) {
            return 0;
        }
        return statusLine.getStatusCode();
    }

    /* renamed from: b */
    public void mo10132b(Throwable th, String str) {
        mo7341g(th, str);
    }

    /* renamed from: c */
    public void m10133c(Message message) {
        int i = message.what;
        if (i == 0) {
            mo10134d((String) message.obj);
            return;
        }
        if (i == 1) {
            Object[] objArr = (Object[]) message.obj;
            mo10132b((Throwable) objArr[0], (String) objArr[1]);
        } else if (i == 2) {
            m10137i();
        } else {
            if (i != 3) {
                return;
            }
            mo7342h();
        }
    }

    /* renamed from: d */
    public void mo10134d(String str) {
        mo7343j(str);
    }

    /* renamed from: e */
    public Message m10135e(int i, Object obj) {
        Handler handler = this.f8216a;
        if (handler != null) {
            return handler.obtainMessage(i, obj);
        }
        Message message = new Message();
        message.what = i;
        message.obj = obj;
        return message;
    }

    /* renamed from: f */
    public void m10136f(Throwable th) {
    }

    /* renamed from: g */
    public void mo7341g(Throwable th, String str) {
        m10136f(th);
    }

    /* renamed from: h */
    public void mo7342h() {
    }

    /* renamed from: i */
    public void m10137i() {
    }

    /* renamed from: j */
    public void mo7343j(String str) {
    }

    /* renamed from: k */
    public void m10138k(Throwable th, String str) {
        m10141n(m10135e(1, new Object[]{th, str}));
    }

    /* renamed from: l */
    public void m10139l(Throwable th, byte[] bArr) {
        m10141n(m10135e(1, new Object[]{th, bArr}));
    }

    /* renamed from: m */
    public void m10140m() {
        m10141n(m10135e(3, null));
    }

    /* renamed from: n */
    public void m10141n(Message message) {
        Handler handler = this.f8216a;
        if (handler != null) {
            handler.sendMessage(message);
        } else {
            m10133c(message);
        }
    }

    /* renamed from: o */
    public void m10142o(HttpResponse httpResponse) {
        this.f8217b = httpResponse;
        StatusLine statusLine = httpResponse.getStatusLine();
        String str = null;
        try {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                str = EntityUtils.toString(new BufferedHttpEntity(entity), "UTF-8");
            }
        } catch (IOException e) {
            m10138k(e, null);
        }
        if (statusLine.getStatusCode() >= 300) {
            m10138k(new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), str);
        } else {
            m10144q(str);
        }
    }

    /* renamed from: p */
    public void m10143p() {
        m10141n(m10135e(2, null));
    }

    /* renamed from: q */
    public void m10144q(String str) {
        m10141n(m10135e(0, str));
    }
}
