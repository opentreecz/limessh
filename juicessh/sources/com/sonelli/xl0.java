package com.sonelli;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.squareup.picasso.Cache;
import com.squareup.picasso.Picasso;

/* compiled from: Stats.java */
/* loaded from: classes.dex */
public class xl0 {

    /* renamed from: a */
    public final HandlerThread f7994a;

    /* renamed from: b */
    public final Cache f7995b;

    /* renamed from: c */
    public final Handler f7996c;

    /* renamed from: d */
    public long f7997d;

    /* renamed from: e */
    public long f7998e;

    /* renamed from: f */
    public long f7999f;

    /* renamed from: g */
    public long f8000g;

    /* renamed from: h */
    public long f8001h;

    /* renamed from: i */
    public long f8002i;

    /* renamed from: j */
    public long f8003j;

    /* renamed from: k */
    public long f8004k;

    /* renamed from: l */
    public int f8005l;

    /* renamed from: m */
    public int f8006m;

    /* renamed from: n */
    public int f8007n;

    /* compiled from: Stats.java */
    /* renamed from: com.sonelli.xl0$a */
    /* loaded from: classes.dex */
    public static class HandlerC2300a extends Handler {

        /* renamed from: a */
        public final xl0 f8008a;

        /* compiled from: Stats.java */
        /* renamed from: com.sonelli.xl0$a$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: O */
            public final /* synthetic */ Message f8009O;

            public a(HandlerC2300a handlerC2300a, Message message) {
                this.f8009O = message;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw new AssertionError("Unhandled stats message." + this.f8009O.what);
            }
        }

        public HandlerC2300a(Looper looper, xl0 xl0Var) {
            super(looper);
            this.f8008a = xl0Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.f8008a.m9810j();
                return;
            }
            if (i == 1) {
                this.f8008a.m9811k();
                return;
            }
            if (i == 2) {
                this.f8008a.m9808h(message.arg1);
                return;
            }
            if (i == 3) {
                this.f8008a.m9809i(message.arg1);
            } else if (i != 4) {
                Picasso.f8618n.post(new a(this, message));
            } else {
                this.f8008a.m9812l((Long) message.obj);
            }
        }
    }

    public xl0(Cache cache) {
        this.f7995b = cache;
        HandlerThread handlerThread = new HandlerThread("Picasso-Stats", 10);
        this.f7994a = handlerThread;
        handlerThread.start();
        this.f7996c = new HandlerC2300a(handlerThread.getLooper(), this);
    }

    /* renamed from: g */
    public static long m9801g(int i, long j) {
        return j / i;
    }

    /* renamed from: a */
    public yl0 m9802a() {
        return new yl0(this.f7995b.mo6736b(), this.f7995b.size(), this.f7997d, this.f7998e, this.f7999f, this.f8000g, this.f8001h, this.f8002i, this.f8003j, this.f8004k, this.f8005l, this.f8006m, this.f8007n, System.currentTimeMillis());
    }

    /* renamed from: b */
    public void m9803b(Bitmap bitmap) {
        m9813m(bitmap, 2);
    }

    /* renamed from: c */
    public void m9804c(Bitmap bitmap) {
        m9813m(bitmap, 3);
    }

    /* renamed from: d */
    public void m9805d() {
        this.f7996c.sendEmptyMessage(0);
    }

    /* renamed from: e */
    public void m9806e() {
        this.f7996c.sendEmptyMessage(1);
    }

    /* renamed from: f */
    public void m9807f(long j) {
        Handler handler = this.f7996c;
        handler.sendMessage(handler.obtainMessage(4, Long.valueOf(j)));
    }

    /* renamed from: h */
    public void m9808h(long j) {
        int i = this.f8006m + 1;
        this.f8006m = i;
        long j2 = this.f8000g + j;
        this.f8000g = j2;
        this.f8003j = m9801g(i, j2);
    }

    /* renamed from: i */
    public void m9809i(long j) {
        this.f8007n++;
        long j2 = this.f8001h + j;
        this.f8001h = j2;
        this.f8004k = m9801g(this.f8006m, j2);
    }

    /* renamed from: j */
    public void m9810j() {
        this.f7997d++;
    }

    /* renamed from: k */
    public void m9811k() {
        this.f7998e++;
    }

    /* renamed from: l */
    public void m9812l(Long l) {
        this.f8005l++;
        long longValue = this.f7999f + l.longValue();
        this.f7999f = longValue;
        this.f8002i = m9801g(this.f8005l, longValue);
    }

    /* renamed from: m */
    public final void m9813m(Bitmap bitmap, int i) {
        int m2569j = bm0.m2569j(bitmap);
        Handler handler = this.f7996c;
        handler.sendMessage(handler.obtainMessage(i, m2569j, 0));
    }
}
