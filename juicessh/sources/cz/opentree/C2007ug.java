package cz.opentree;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* renamed from: cz.opentree.ug */
/* loaded from: classes.dex */
public final class C2007ug {

    /* renamed from: a */
    public final C2216wf f6956a;

    /* renamed from: b */
    public volatile Boolean f6957b;

    /* renamed from: c */
    public String f6958c;

    /* renamed from: d */
    public Set<Integer> f6959d;

    public C2007ug(C2216wf c2216wf) {
        C0813ca.m2729k(c2216wf);
        this.f6956a = c2216wf;
    }

    /* renamed from: b */
    public static boolean m8879b() {
        return C0770bh.f1676a.m2801a().booleanValue();
    }

    /* renamed from: c */
    public static int m8880c() {
        return C0770bh.f1692q.m2801a().intValue();
    }

    /* renamed from: d */
    public static long m8881d() {
        return C0770bh.f1680e.m2801a().longValue();
    }

    /* renamed from: e */
    public static long m8882e() {
        return C0770bh.f1681f.m2801a().longValue();
    }

    /* renamed from: f */
    public static int m8883f() {
        return C0770bh.f1683h.m2801a().intValue();
    }

    /* renamed from: g */
    public static int m8884g() {
        return C0770bh.f1684i.m2801a().intValue();
    }

    /* renamed from: h */
    public static String m8885h() {
        return C0770bh.f1686k.m2801a();
    }

    /* renamed from: i */
    public static String m8886i() {
        return C0770bh.f1685j.m2801a();
    }

    /* renamed from: j */
    public static String m8887j() {
        return C0770bh.f1687l.m2801a();
    }

    /* renamed from: l */
    public static long m8888l() {
        return C0770bh.f1699x.m2801a().longValue();
    }

    /* renamed from: a */
    public final boolean m8889a() {
        if (this.f6957b == null) {
            synchronized (this) {
                if (this.f6957b == null) {
                    ApplicationInfo applicationInfo = this.f6956a.m9475a().getApplicationInfo();
                    String m6396a = C1547mc.m6396a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f6957b = Boolean.valueOf(str != null && str.equals(m6396a));
                    }
                    if ((this.f6957b == null || !this.f6957b.booleanValue()) && "com.google.android.gms.analytics".equals(m6396a)) {
                        this.f6957b = Boolean.TRUE;
                    }
                    if (this.f6957b == null) {
                        this.f6957b = Boolean.TRUE;
                        this.f6956a.m9477e().m8650B0("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f6957b.booleanValue();
    }

    /* renamed from: k */
    public final Set<Integer> m8890k() {
        String str;
        String m2801a = C0770bh.f1695t.m2801a();
        if (this.f6959d == null || (str = this.f6958c) == null || !str.equals(m2801a)) {
            String[] split = TextUtils.split(m2801a, ",");
            HashSet hashSet = new HashSet();
            for (String str2 : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(str2)));
                } catch (NumberFormatException unused) {
                }
            }
            this.f6958c = m2801a;
            this.f6959d = hashSet;
        }
        return this.f6959d;
    }
}
