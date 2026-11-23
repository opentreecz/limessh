package cz.opentree;

import android.graphics.Bitmap;
import android.net.Uri;
import com.squareup.picasso.Transformation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: Request.java */
/* loaded from: classes.dex */
public final class ul0 {

    /* renamed from: o */
    public static final long f6995o = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: a */
    public int f6996a;

    /* renamed from: b */
    public long f6997b;

    /* renamed from: c */
    public final Uri f6998c;

    /* renamed from: d */
    public final int f6999d;

    /* renamed from: e */
    public final List<Transformation> f7000e;

    /* renamed from: f */
    public final int f7001f;

    /* renamed from: g */
    public final int f7002g;

    /* renamed from: h */
    public final boolean f7003h;

    /* renamed from: i */
    public final boolean f7004i;

    /* renamed from: j */
    public final float f7005j;

    /* renamed from: k */
    public final float f7006k;

    /* renamed from: l */
    public final float f7007l;

    /* renamed from: m */
    public final boolean f7008m;

    /* renamed from: n */
    public final Bitmap.Config f7009n;

    /* compiled from: Request.java */
    /* renamed from: cz.opentree.ul0$b */
    /* loaded from: classes.dex */
    public static final class C2019b {

        /* renamed from: a */
        public Uri f7010a;

        /* renamed from: b */
        public int f7011b;

        /* renamed from: c */
        public int f7012c;

        /* renamed from: d */
        public int f7013d;

        /* renamed from: e */
        public boolean f7014e;

        /* renamed from: f */
        public boolean f7015f;

        /* renamed from: g */
        public float f7016g;

        /* renamed from: h */
        public float f7017h;

        /* renamed from: i */
        public float f7018i;

        /* renamed from: j */
        public boolean f7019j;

        /* renamed from: k */
        public List<Transformation> f7020k;

        /* renamed from: l */
        public Bitmap.Config f7021l;

        public C2019b(Uri uri, int i) {
            this.f7010a = uri;
            this.f7011b = i;
        }

        /* renamed from: a */
        public ul0 m8925a() {
            boolean z = this.f7015f;
            if (z && this.f7014e) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            }
            if (this.f7014e && this.f7012c == 0) {
                throw new IllegalStateException("Center crop requires calling resize.");
            }
            if (z && this.f7012c == 0) {
                throw new IllegalStateException("Center inside requires calling resize.");
            }
            return new ul0(this.f7010a, this.f7011b, this.f7020k, this.f7012c, this.f7013d, this.f7014e, this.f7015f, this.f7016g, this.f7017h, this.f7018i, this.f7019j, this.f7021l);
        }

        /* renamed from: b */
        public boolean m8926b() {
            return (this.f7010a == null && this.f7011b == 0) ? false : true;
        }

        /* renamed from: c */
        public boolean m8927c() {
            return this.f7012c != 0;
        }

        /* renamed from: d */
        public C2019b m8928d(int i, int i2) {
            if (i <= 0) {
                throw new IllegalArgumentException("Width must be positive number.");
            }
            if (i2 <= 0) {
                throw new IllegalArgumentException("Height must be positive number.");
            }
            this.f7012c = i;
            this.f7013d = i2;
            return this;
        }

        /* renamed from: e */
        public C2019b m8929e(Transformation transformation) {
            if (transformation == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            }
            if (this.f7020k == null) {
                this.f7020k = new ArrayList(2);
            }
            this.f7020k.add(transformation);
            return this;
        }
    }

    public ul0(Uri uri, int i, List<Transformation> list, int i2, int i3, boolean z, boolean z2, float f, float f2, float f3, boolean z3, Bitmap.Config config) {
        this.f6998c = uri;
        this.f6999d = i;
        if (list == null) {
            this.f7000e = null;
        } else {
            this.f7000e = Collections.unmodifiableList(list);
        }
        this.f7001f = i2;
        this.f7002g = i3;
        this.f7003h = z;
        this.f7004i = z2;
        this.f7005j = f;
        this.f7006k = f2;
        this.f7007l = f3;
        this.f7008m = z3;
        this.f7009n = config;
    }

    /* renamed from: a */
    public String m8918a() {
        Uri uri = this.f6998c;
        return uri != null ? String.valueOf(uri.getPath()) : Integer.toHexString(this.f6999d);
    }

    /* renamed from: b */
    public boolean m8919b() {
        return this.f7000e != null;
    }

    /* renamed from: c */
    public boolean m8920c() {
        return this.f7001f != 0;
    }

    /* renamed from: d */
    public String m8921d() {
        long nanoTime = System.nanoTime() - this.f6997b;
        if (nanoTime > f6995o) {
            return m8924g() + '+' + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + 's';
        }
        return m8924g() + '+' + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    /* renamed from: e */
    public boolean m8922e() {
        return (this.f7001f == 0 && this.f7005j == 0.0f) ? false : true;
    }

    /* renamed from: f */
    public boolean m8923f() {
        return m8922e() || m8919b();
    }

    /* renamed from: g */
    public String m8924g() {
        return "[R" + this.f6996a + ']';
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        int i = this.f6999d;
        if (i > 0) {
            sb.append(i);
        } else {
            sb.append(this.f6998c);
        }
        List<Transformation> list = this.f7000e;
        if (list != null && !list.isEmpty()) {
            for (Transformation transformation : this.f7000e) {
                sb.append(' ');
                sb.append(transformation.mo8917b());
            }
        }
        if (this.f7001f > 0) {
            sb.append(" resize(");
            sb.append(this.f7001f);
            sb.append(',');
            sb.append(this.f7002g);
            sb.append(')');
        }
        if (this.f7003h) {
            sb.append(" centerCrop");
        }
        if (this.f7004i) {
            sb.append(" centerInside");
        }
        if (this.f7005j != 0.0f) {
            sb.append(" rotation(");
            sb.append(this.f7005j);
            if (this.f7008m) {
                sb.append(" @ ");
                sb.append(this.f7006k);
                sb.append(',');
                sb.append(this.f7007l);
            }
            sb.append(')');
        }
        if (this.f7009n != null) {
            sb.append(' ');
            sb.append(this.f7009n);
        }
        sb.append('}');
        return sb.toString();
    }
}
