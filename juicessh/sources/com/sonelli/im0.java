package com.sonelli;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: CacheControl.java */
/* loaded from: classes.dex */
public final class im0 {

    /* renamed from: a */
    public final boolean f3342a;

    /* renamed from: b */
    public final boolean f3343b;

    /* renamed from: c */
    public final int f3344c;

    /* renamed from: d */
    public final int f3345d;

    /* renamed from: e */
    public final boolean f3346e;

    /* renamed from: f */
    public final boolean f3347f;

    /* renamed from: g */
    public final boolean f3348g;

    /* renamed from: h */
    public final int f3349h;

    /* renamed from: i */
    public final int f3350i;

    /* renamed from: j */
    public final boolean f3351j;

    /* renamed from: k */
    public final boolean f3352k;

    /* renamed from: l */
    public final boolean f3353l;

    /* renamed from: m */
    @Nullable
    public String f3354m;

    /* compiled from: CacheControl.java */
    /* renamed from: com.sonelli.im0$a */
    /* loaded from: classes.dex */
    public static final class C1167a {

        /* renamed from: a */
        public boolean f3355a;

        /* renamed from: b */
        public boolean f3356b;

        /* renamed from: c */
        public int f3357c = -1;

        /* renamed from: d */
        public int f3358d = -1;

        /* renamed from: e */
        public int f3359e = -1;

        /* renamed from: f */
        public boolean f3360f;

        /* renamed from: g */
        public boolean f3361g;

        /* renamed from: h */
        public boolean f3362h;

        /* renamed from: a */
        public im0 m4807a() {
            return new im0(this);
        }

        /* renamed from: b */
        public C1167a m4808b(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.f3358d = seconds > 2147483647L ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        /* renamed from: c */
        public C1167a m4809c() {
            this.f3355a = true;
            return this;
        }

        /* renamed from: d */
        public C1167a m4810d() {
            this.f3360f = true;
            return this;
        }
    }

    static {
        C1167a c1167a = new C1167a();
        c1167a.m4809c();
        c1167a.m4807a();
        C1167a c1167a2 = new C1167a();
        c1167a2.m4810d();
        c1167a2.m4808b(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, TimeUnit.SECONDS);
        c1167a2.m4807a();
    }

    public im0(C1167a c1167a) {
        this.f3342a = c1167a.f3355a;
        this.f3343b = c1167a.f3356b;
        this.f3344c = c1167a.f3357c;
        this.f3345d = -1;
        this.f3346e = false;
        this.f3347f = false;
        this.f3348g = false;
        this.f3349h = c1167a.f3358d;
        this.f3350i = c1167a.f3359e;
        this.f3351j = c1167a.f3360f;
        this.f3352k = c1167a.f3361g;
        this.f3353l = c1167a.f3362h;
    }

    public im0(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        this.f3342a = z;
        this.f3343b = z2;
        this.f3344c = i;
        this.f3345d = i2;
        this.f3346e = z3;
        this.f3347f = z4;
        this.f3348g = z5;
        this.f3349h = i3;
        this.f3350i = i4;
        this.f3351j = z6;
        this.f3352k = z7;
        this.f3353l = z8;
        this.f3354m = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.sonelli.im0 m4796k(com.sonelli.qm0 r22) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.im0.m4796k(com.sonelli.qm0):com.sonelli.im0");
    }

    /* renamed from: a */
    public final String m4797a() {
        StringBuilder sb = new StringBuilder();
        if (this.f3342a) {
            sb.append("no-cache, ");
        }
        if (this.f3343b) {
            sb.append("no-store, ");
        }
        if (this.f3344c != -1) {
            sb.append("max-age=");
            sb.append(this.f3344c);
            sb.append(", ");
        }
        if (this.f3345d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f3345d);
            sb.append(", ");
        }
        if (this.f3346e) {
            sb.append("private, ");
        }
        if (this.f3347f) {
            sb.append("public, ");
        }
        if (this.f3348g) {
            sb.append("must-revalidate, ");
        }
        if (this.f3349h != -1) {
            sb.append("max-stale=");
            sb.append(this.f3349h);
            sb.append(", ");
        }
        if (this.f3350i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f3350i);
            sb.append(", ");
        }
        if (this.f3351j) {
            sb.append("only-if-cached, ");
        }
        if (this.f3352k) {
            sb.append("no-transform, ");
        }
        if (this.f3353l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* renamed from: b */
    public boolean m4798b() {
        return this.f3346e;
    }

    /* renamed from: c */
    public boolean m4799c() {
        return this.f3347f;
    }

    /* renamed from: d */
    public int m4800d() {
        return this.f3344c;
    }

    /* renamed from: e */
    public int m4801e() {
        return this.f3349h;
    }

    /* renamed from: f */
    public int m4802f() {
        return this.f3350i;
    }

    /* renamed from: g */
    public boolean m4803g() {
        return this.f3348g;
    }

    /* renamed from: h */
    public boolean m4804h() {
        return this.f3342a;
    }

    /* renamed from: i */
    public boolean m4805i() {
        return this.f3343b;
    }

    /* renamed from: j */
    public boolean m4806j() {
        return this.f3351j;
    }

    public String toString() {
        String str = this.f3354m;
        if (str != null) {
            return str;
        }
        String m4797a = m4797a();
        this.f3354m = m4797a;
        return m4797a;
    }
}
