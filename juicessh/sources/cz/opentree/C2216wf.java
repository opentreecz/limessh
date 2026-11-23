package cz.opentree;

import android.annotation.SuppressLint;
import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.util.Clock;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;

@SuppressLint({"StaticFieldLeak"})
/* renamed from: cz.opentree.wf */
/* loaded from: classes.dex */
public class C2216wf {

    /* renamed from: p */
    public static volatile C2216wf f7670p;

    /* renamed from: a */
    public final Context f7671a;

    /* renamed from: b */
    public final Context f7672b;

    /* renamed from: c */
    public final Clock f7673c;

    /* renamed from: d */
    public final C2007ug f7674d;

    /* renamed from: e */
    public final C1451kh f7675e;

    /* renamed from: f */
    public final C1434k4 f7676f;

    /* renamed from: g */
    public final C1652of f7677g;

    /* renamed from: h */
    public final C2425zg f7678h;

    /* renamed from: i */
    public final C0771bi f7679i;

    /* renamed from: j */
    public final C1654oh f7680j;

    /* renamed from: k */
    public final GoogleAnalytics f7681k;

    /* renamed from: l */
    public final C1653og f7682l;

    /* renamed from: m */
    public final C1602nf f7683m;

    /* renamed from: n */
    public final C1107hg f7684n;

    /* renamed from: o */
    public final C2345yg f7685o;

    public C2216wf(C2342yf c2342yf) {
        Context m10127a = c2342yf.m10127a();
        C0813ca.m2730l(m10127a, "Application context can't be null");
        Context m10128b = c2342yf.m10128b();
        C0813ca.m2729k(m10128b);
        this.f7671a = m10127a;
        this.f7672b = m10128b;
        this.f7673c = C0921ec.m3474d();
        this.f7674d = new C2007ug(this);
        C1451kh c1451kh = new C1451kh(this);
        c1451kh.m8877D0();
        this.f7675e = c1451kh;
        C1451kh m9477e = m9477e();
        String str = C2167vf.f7453a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + KeycodeConstants.KEYCODE_F4);
        sb.append("Google Analytics ");
        sb.append(str);
        sb.append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4");
        m9477e.m8680z0(sb.toString());
        C1654oh c1654oh = new C1654oh(this);
        c1654oh.m8877D0();
        this.f7680j = c1654oh;
        C0771bi c0771bi = new C0771bi(this);
        c0771bi.m8877D0();
        this.f7679i = c0771bi;
        C1652of c1652of = new C1652of(this, c2342yf);
        C1653og c1653og = new C1653og(this);
        C1602nf c1602nf = new C1602nf(this);
        C1107hg c1107hg = new C1107hg(this);
        C2345yg c2345yg = new C2345yg(this);
        C1434k4 m5824j = C1434k4.m5824j(m10127a);
        m5824j.m5830f(new C2275xf(this));
        this.f7676f = m5824j;
        GoogleAnalytics googleAnalytics = new GoogleAnalytics(this);
        c1653og.m8877D0();
        this.f7682l = c1653og;
        c1602nf.m8877D0();
        this.f7683m = c1602nf;
        c1107hg.m8877D0();
        this.f7684n = c1107hg;
        c2345yg.m8877D0();
        this.f7685o = c2345yg;
        C2425zg c2425zg = new C2425zg(this);
        c2425zg.m8877D0();
        this.f7678h = c2425zg;
        c1652of.m8877D0();
        this.f7677g = c1652of;
        googleAnalytics.m824r();
        this.f7681k = googleAnalytics;
        c1652of.m7017H0();
    }

    /* renamed from: b */
    public static void m9473b(AbstractC2006uf abstractC2006uf) {
        C0813ca.m2730l(abstractC2006uf, "Analytics service not created/initialized");
        C0813ca.m2720b(abstractC2006uf.m8876C0(), "Analytics service not initialized");
    }

    /* renamed from: c */
    public static C2216wf m9474c(Context context) {
        C0813ca.m2729k(context);
        if (f7670p == null) {
            synchronized (C2216wf.class) {
                if (f7670p == null) {
                    Clock m3474d = C0921ec.m3474d();
                    long mo1178b = m3474d.mo1178b();
                    C2216wf c2216wf = new C2216wf(new C2342yf(context));
                    f7670p = c2216wf;
                    GoogleAnalytics.m814s();
                    long mo1178b2 = m3474d.mo1178b() - mo1178b;
                    long longValue = C0770bh.f1674D.m2801a().longValue();
                    if (mo1178b2 > longValue) {
                        c2216wf.m9477e().m8657e0("Slow initialization (ms)", Long.valueOf(mo1178b2), Long.valueOf(longValue));
                    }
                }
            }
        }
        return f7670p;
    }

    /* renamed from: a */
    public final Context m9475a() {
        return this.f7671a;
    }

    /* renamed from: d */
    public final Clock m9476d() {
        return this.f7673c;
    }

    /* renamed from: e */
    public final C1451kh m9477e() {
        m9473b(this.f7675e);
        return this.f7675e;
    }

    /* renamed from: f */
    public final C2007ug m9478f() {
        return this.f7674d;
    }

    /* renamed from: g */
    public final C1434k4 m9479g() {
        C0813ca.m2729k(this.f7676f);
        return this.f7676f;
    }

    /* renamed from: h */
    public final C1652of m9480h() {
        m9473b(this.f7677g);
        return this.f7677g;
    }

    /* renamed from: i */
    public final C2425zg m9481i() {
        m9473b(this.f7678h);
        return this.f7678h;
    }

    /* renamed from: j */
    public final C0771bi m9482j() {
        m9473b(this.f7679i);
        return this.f7679i;
    }

    /* renamed from: k */
    public final C1654oh m9483k() {
        m9473b(this.f7680j);
        return this.f7680j;
    }

    /* renamed from: l */
    public final C1107hg m9484l() {
        m9473b(this.f7684n);
        return this.f7684n;
    }

    /* renamed from: m */
    public final C2345yg m9485m() {
        return this.f7685o;
    }

    /* renamed from: n */
    public final Context m9486n() {
        return this.f7672b;
    }

    /* renamed from: o */
    public final C1451kh m9487o() {
        return this.f7675e;
    }

    /* renamed from: p */
    public final GoogleAnalytics m9488p() {
        C0813ca.m2729k(this.f7681k);
        C0813ca.m2720b(this.f7681k.m819m(), "Analytics instance not initialized");
        return this.f7681k;
    }

    /* renamed from: q */
    public final C1654oh m9489q() {
        C1654oh c1654oh = this.f7680j;
        if (c1654oh == null || !c1654oh.m8876C0()) {
            return null;
        }
        return this.f7680j;
    }

    /* renamed from: r */
    public final C1602nf m9490r() {
        m9473b(this.f7683m);
        return this.f7683m;
    }

    /* renamed from: s */
    public final C1653og m9491s() {
        m9473b(this.f7682l);
        return this.f7682l;
    }
}
