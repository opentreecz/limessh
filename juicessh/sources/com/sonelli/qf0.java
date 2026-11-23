package com.sonelli;

import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.StateListener;
import com.google.firebase.platforminfo.UserAgentPublisher;
import com.sonelli.fg0;
import com.sonelli.gg0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public class qf0 implements FirebaseInstallationsApi {

    /* renamed from: k */
    public static final Object f5979k = new Object();

    /* renamed from: l */
    public static final ThreadFactory f5980l = new ThreadFactoryC1759a();

    /* renamed from: a */
    public final FirebaseApp f5981a;

    /* renamed from: b */
    public final eg0 f5982b;

    /* renamed from: c */
    public final ag0 f5983c;

    /* renamed from: d */
    public final xf0 f5984d;

    /* renamed from: e */
    public final zf0 f5985e;

    /* renamed from: f */
    public final wf0 f5986f;

    /* renamed from: g */
    public final Object f5987g;

    /* renamed from: h */
    public final ExecutorService f5988h;

    /* renamed from: i */
    public final ExecutorService f5989i;

    /* renamed from: j */
    @GuardedBy("lock")
    public final List<StateListener> f5990j;

    /* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
    /* renamed from: com.sonelli.qf0$a */
    /* loaded from: classes.dex */
    public class ThreadFactoryC1759a implements ThreadFactory {

        /* renamed from: a */
        public final AtomicInteger f5991a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f5991a.getAndIncrement())));
        }
    }

    /* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
    /* renamed from: com.sonelli.qf0$b */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C1760b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f5992a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f5993b;

        static {
            int[] iArr = new int[gg0.EnumC1042b.values().length];
            f5993b = iArr;
            try {
                iArr[gg0.EnumC1042b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5993b[gg0.EnumC1042b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5993b[gg0.EnumC1042b.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[fg0.EnumC0988b.values().length];
            f5992a = iArr2;
            try {
                iArr2[fg0.EnumC0988b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5992a[fg0.EnumC0988b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public qf0(FirebaseApp firebaseApp, @Nullable UserAgentPublisher userAgentPublisher, @Nullable HeartBeatInfo heartBeatInfo) {
        this(new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f5980l), firebaseApp, new eg0(firebaseApp.m1580g(), userAgentPublisher, heartBeatInfo), new ag0(firebaseApp), new xf0(), new zf0(firebaseApp), new wf0());
    }

    public qf0(ExecutorService executorService, FirebaseApp firebaseApp, eg0 eg0Var, ag0 ag0Var, xf0 xf0Var, zf0 zf0Var, wf0 wf0Var) {
        this.f5987g = new Object();
        this.f5990j = new ArrayList();
        this.f5981a = firebaseApp;
        this.f5982b = eg0Var;
        this.f5983c = ag0Var;
        this.f5984d = xf0Var;
        this.f5985e = zf0Var;
        this.f5986f = wf0Var;
        this.f5988h = executorService;
        this.f5989i = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f5980l);
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    @NonNull
    /* renamed from: a */
    public j60<vf0> mo1908a(boolean z) {
        m7695r();
        j60<vf0> m7683e = m7683e();
        if (z) {
            this.f5988h.execute(nf0.m6673a(this));
        } else {
            this.f5988h.execute(of0.m7025a(this));
        }
        return m7683e;
    }

    /* renamed from: e */
    public final j60<vf0> m7683e() {
        k60 k60Var = new k60();
        tf0 tf0Var = new tf0(this.f5984d, k60Var);
        synchronized (this.f5987g) {
            this.f5990j.add(tf0Var);
        }
        return k60Var.m5842a();
    }

    /* renamed from: f */
    public final j60<String> m7684f() {
        k60 k60Var = new k60();
        uf0 uf0Var = new uf0(k60Var);
        synchronized (this.f5987g) {
            this.f5990j.add(uf0Var);
        }
        return k60Var.m5842a();
    }

    /* renamed from: g */
    public final void m7685g() {
        m7689k(true);
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    @NonNull
    public j60<String> getId() {
        m7695r();
        j60<String> m7684f = m7684f();
        this.f5988h.execute(mf0.m6407a(this));
        return m7684f;
    }

    /* renamed from: h */
    public final void m7686h() {
        m7689k(false);
    }

    /* renamed from: i */
    public final void m7687i() {
        m7689k(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m7688j(boolean r3) {
        /*
            r2 = this;
            com.sonelli.bg0 r0 = r2.m7693o()
            boolean r1 = r0.m2466i()     // Catch: java.io.IOException -> L51
            if (r1 != 0) goto L22
            boolean r1 = r0.m2469l()     // Catch: java.io.IOException -> L51
            if (r1 == 0) goto L11
            goto L22
        L11:
            if (r3 != 0) goto L1d
            com.sonelli.xf0 r3 = r2.f5984d     // Catch: java.io.IOException -> L51
            boolean r3 = r3.m9760b(r0)     // Catch: java.io.IOException -> L51
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            return
        L1d:
            com.sonelli.bg0 r3 = r2.m7690l(r0)     // Catch: java.io.IOException -> L51
            goto L26
        L22:
            com.sonelli.bg0 r3 = r2.m7697t(r0)     // Catch: java.io.IOException -> L51
        L26:
            com.sonelli.ag0 r0 = r2.f5983c
            r0.m2062a(r3)
            boolean r0 = r3.m2466i()
            if (r0 == 0) goto L3c
            com.sonelli.rf0 r0 = new com.sonelli.rf0
            com.sonelli.rf0$a r1 = com.sonelli.rf0.EnumC1815a.BAD_CONFIG
            r0.<init>(r1)
            r2.m7698u(r3, r0)
            goto L50
        L3c:
            boolean r0 = r3.m2467j()
            if (r0 == 0) goto L4d
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "cleared fid due to auth error"
            r0.<init>(r1)
            r2.m7698u(r3, r0)
            goto L50
        L4d:
            r2.m7699v(r3)
        L50:
            return
        L51:
            r3 = move-exception
            r2.m7698u(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.qf0.m7688j(boolean):void");
    }

    /* renamed from: k */
    public final void m7689k(boolean z) {
        bg0 m7693o = m7693o();
        if (z) {
            m7693o = m7693o.m2473p();
        }
        m7699v(m7693o);
        this.f5989i.execute(pf0.m7318a(this, z));
    }

    /* renamed from: l */
    public final bg0 m7690l(@NonNull bg0 bg0Var) throws IOException {
        gg0 m3486d = this.f5982b.m3486d(m7691m(), bg0Var.mo2461d(), m7694p(), bg0Var.mo2463f());
        int i = C1760b.f5993b[m3486d.mo3195b().ordinal()];
        if (i == 1) {
            return bg0Var.m2472o(m3486d.mo3196c(), m3486d.mo3197d(), this.f5984d.m9759a());
        }
        if (i == 2) {
            return bg0Var.m2474q("BAD CONFIG");
        }
        if (i == 3) {
            return bg0Var.m2475r();
        }
        throw new IOException();
    }

    @Nullable
    /* renamed from: m */
    public String m7691m() {
        return this.f5981a.m1582j().m4383b();
    }

    @VisibleForTesting
    /* renamed from: n */
    public String m7692n() {
        return this.f5981a.m1582j().m4384c();
    }

    /* renamed from: o */
    public final bg0 m7693o() {
        bg0 m2064c;
        synchronized (f5979k) {
            lf0 m6155a = lf0.m6155a(this.f5981a.m1580g(), "generatefid.lock");
            try {
                m2064c = this.f5983c.m2064c();
                if (m2064c.m2467j()) {
                    String m7696s = m7696s(m2064c);
                    ag0 ag0Var = this.f5983c;
                    m2064c = m2064c.m2477t(m7696s);
                    ag0Var.m2062a(m2064c);
                }
            } finally {
                if (m6155a != null) {
                    m6155a.m6156b();
                }
            }
        }
        return m2064c;
    }

    @Nullable
    /* renamed from: p */
    public String m7694p() {
        return TextUtils.isEmpty(this.f5981a.m1582j().m4386e()) ? this.f5981a.m1582j().m4385d() : this.f5981a.m1582j().m4386e();
    }

    /* renamed from: r */
    public final void m7695r() {
        C0813ca.m2725g(m7692n());
        C0813ca.m2725g(m7694p());
        C0813ca.m2725g(m7691m());
    }

    /* renamed from: s */
    public final String m7696s(bg0 bg0Var) {
        if ((!this.f5981a.m1581i().equals("CHIME_ANDROID_SDK") && !this.f5981a.m1586q()) || !bg0Var.m2470m()) {
            return this.f5986f.m9494a();
        }
        String m10445f = this.f5985e.m10445f();
        return TextUtils.isEmpty(m10445f) ? this.f5986f.m9494a() : m10445f;
    }

    /* renamed from: t */
    public final bg0 m7697t(bg0 bg0Var) throws IOException {
        fg0 m3485c = this.f5982b.m3485c(m7691m(), bg0Var.mo2461d(), m7694p(), m7692n(), bg0Var.mo2461d().length() == 11 ? this.f5985e.m10448i() : null);
        int i = C1760b.f5992a[m3485c.mo2788e().ordinal()];
        if (i == 1) {
            return bg0Var.m2476s(m3485c.mo2786c(), m3485c.mo2787d(), this.f5984d.m9759a(), m3485c.mo2785b().mo3196c(), m3485c.mo2785b().mo3197d());
        }
        if (i == 2) {
            return bg0Var.m2474q("BAD CONFIG");
        }
        throw new IOException();
    }

    /* renamed from: u */
    public final void m7698u(bg0 bg0Var, Exception exc) {
        synchronized (this.f5987g) {
            Iterator<StateListener> it = this.f5990j.iterator();
            while (it.hasNext()) {
                if (it.next().mo1909a(bg0Var, exc)) {
                    it.remove();
                }
            }
        }
    }

    /* renamed from: v */
    public final void m7699v(bg0 bg0Var) {
        synchronized (this.f5987g) {
            Iterator<StateListener> it = this.f5990j.iterator();
            while (it.hasNext()) {
                if (it.next().mo1910b(bg0Var)) {
                    it.remove();
                }
            }
        }
    }
}
