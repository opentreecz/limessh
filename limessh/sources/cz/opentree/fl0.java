package cz.opentree;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.ContactsContract;
import com.squareup.picasso.Cache;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

/* compiled from: BitmapHunter.java */
/* loaded from: classes.dex */
public abstract class fl0 implements Runnable {

    /* renamed from: c0 */
    public static final Object f2702c0 = new Object();

    /* renamed from: d0 */
    public static final ThreadLocal<StringBuilder> f2703d0 = new C0997a();

    /* renamed from: O */
    public final Picasso f2704O;

    /* renamed from: P */
    public final jl0 f2705P;

    /* renamed from: Q */
    public final Cache f2706Q;

    /* renamed from: R */
    public final xl0 f2707R;

    /* renamed from: S */
    public final String f2708S;

    /* renamed from: T */
    public final ul0 f2709T;

    /* renamed from: U */
    public final boolean f2710U;

    /* renamed from: V */
    public dl0 f2711V;

    /* renamed from: W */
    public List<dl0> f2712W;

    /* renamed from: X */
    public Bitmap f2713X;

    /* renamed from: Y */
    public Future<?> f2714Y;

    /* renamed from: Z */
    public Picasso.EnumC2454d f2715Z;

    /* renamed from: a0 */
    public Exception f2716a0;

    /* renamed from: b0 */
    public int f2717b0;

    /* compiled from: BitmapHunter.java */
    /* renamed from: cz.opentree.fl0$a */
    /* loaded from: classes.dex */
    public static class C0997a extends ThreadLocal<StringBuilder> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    }

    /* compiled from: BitmapHunter.java */
    /* renamed from: cz.opentree.fl0$b */
    /* loaded from: classes.dex */
    public static class RunnableC0998b implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ StringBuilder f2718O;

        public RunnableC0998b(StringBuilder sb) {
            this.f2718O = sb;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw new NullPointerException(this.f2718O.toString());
        }
    }

    /* compiled from: BitmapHunter.java */
    /* renamed from: cz.opentree.fl0$c */
    /* loaded from: classes.dex */
    public static class RunnableC0999c implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ Transformation f2719O;

        public RunnableC0999c(Transformation transformation) {
            this.f2719O = transformation;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw new IllegalStateException("Transformation " + this.f2719O.mo8917b() + " returned input Bitmap but recycled it.");
        }
    }

    /* compiled from: BitmapHunter.java */
    /* renamed from: cz.opentree.fl0$d */
    /* loaded from: classes.dex */
    public static class RunnableC1000d implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ Transformation f2720O;

        public RunnableC1000d(Transformation transformation) {
            this.f2720O = transformation;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw new IllegalStateException("Transformation " + this.f2720O.mo8917b() + " mutated input Bitmap but failed to recycle the original.");
        }
    }

    public fl0(Picasso picasso, jl0 jl0Var, Cache cache, xl0 xl0Var, dl0 dl0Var) {
        this.f2704O = picasso;
        this.f2705P = jl0Var;
        this.f2706Q = cache;
        this.f2707R = xl0Var;
        this.f2708S = dl0Var.m3257d();
        this.f2709T = dl0Var.m3259f();
        this.f2710U = dl0Var.f2235d;
        this.f2711V = dl0Var;
    }

    /* renamed from: a */
    public static Bitmap m3780a(List<Transformation> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            Transformation transformation = list.get(i);
            Bitmap mo8916a = transformation.mo8916a(bitmap);
            if (mo8916a == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Transformation ");
                sb.append(transformation.mo8917b());
                sb.append(" returned null after ");
                sb.append(i);
                sb.append(" previous transformation(s).\n\nTransformation list:\n");
                Iterator<Transformation> it = list.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().mo8917b());
                    sb.append('\n');
                }
                Picasso.f8618n.post(new RunnableC0998b(sb));
                return null;
            }
            if (mo8916a == bitmap && bitmap.isRecycled()) {
                Picasso.f8618n.post(new RunnableC0999c(transformation));
                return null;
            }
            if (mo8916a != bitmap && !bitmap.isRecycled()) {
                Picasso.f8618n.post(new RunnableC1000d(transformation));
                return null;
            }
            i++;
            bitmap = mo8916a;
        }
        return bitmap;
    }

    /* renamed from: c */
    public static void m3781c(int i, int i2, int i3, int i4, BitmapFactory.Options options) {
        int floor;
        if (i4 > i2 || i3 > i) {
            int floor2 = (int) Math.floor(i4 / i2);
            floor = (int) Math.floor(i3 / i);
            if (floor2 < floor) {
                floor = floor2;
            }
        } else {
            floor = 1;
        }
        options.inSampleSize = floor;
        options.inJustDecodeBounds = false;
    }

    /* renamed from: d */
    public static void m3782d(int i, int i2, BitmapFactory.Options options) {
        m3781c(i, i2, options.outWidth, options.outHeight, options);
    }

    /* renamed from: f */
    public static BitmapFactory.Options m3783f(ul0 ul0Var) {
        boolean m8920c = ul0Var.m8920c();
        boolean z = ul0Var.f7009n != null;
        BitmapFactory.Options options = null;
        if (m8920c || z) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = m8920c;
            if (z) {
                options.inPreferredConfig = ul0Var.f7009n;
            }
        }
        return options;
    }

    /* renamed from: i */
    public static fl0 m3784i(Context context, Picasso picasso, jl0 jl0Var, Cache cache, xl0 xl0Var, dl0 dl0Var, Downloader downloader) {
        if (dl0Var.m3259f().f6999d != 0) {
            return new wl0(context, picasso, jl0Var, cache, xl0Var, dl0Var);
        }
        Uri uri = dl0Var.m3259f().f6998c;
        String scheme = uri.getScheme();
        return "content".equals(scheme) ? (!ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) || uri.getPathSegments().contains("photo")) ? "media".equals(uri.getAuthority()) ? new pl0(context, picasso, jl0Var, cache, xl0Var, dl0Var) : new hl0(context, picasso, jl0Var, cache, xl0Var, dl0Var) : new gl0(context, picasso, jl0Var, cache, xl0Var, dl0Var) : "file".equals(scheme) ? (uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) ? new kl0(context, picasso, jl0Var, cache, xl0Var, dl0Var) : new el0(context, picasso, jl0Var, cache, xl0Var, dl0Var) : "android.resource".equals(scheme) ? new wl0(context, picasso, jl0Var, cache, xl0Var, dl0Var) : new ql0(picasso, jl0Var, cache, xl0Var, dl0Var, downloader);
    }

    /* renamed from: t */
    public static boolean m3785t(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap m3786y(cz.opentree.ul0 r10, android.graphics.Bitmap r11, int r12) {
        /*
            int r0 = r11.getWidth()
            int r1 = r11.getHeight()
            android.graphics.Matrix r7 = new android.graphics.Matrix
            r7.<init>()
            boolean r2 = r10.m8922e()
            r3 = 0
            if (r2 == 0) goto L86
            int r2 = r10.f7001f
            int r4 = r10.f7002g
            float r5 = r10.f7005j
            r6 = 0
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L2e
            boolean r6 = r10.f7008m
            if (r6 == 0) goto L2b
            float r6 = r10.f7006k
            float r8 = r10.f7007l
            r7.setRotate(r5, r6, r8)
            goto L2e
        L2b:
            r7.setRotate(r5)
        L2e:
            boolean r5 = r10.f7003h
            if (r5 == 0) goto L61
            float r10 = (float) r2
            float r2 = (float) r0
            float r10 = r10 / r2
            float r4 = (float) r4
            float r5 = (float) r1
            float r4 = r4 / r5
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 <= 0) goto L4b
            float r4 = r4 / r10
            float r5 = r5 * r4
            double r4 = (double) r5
            double r4 = java.lang.Math.ceil(r4)
            int r2 = (int) r4
            int r1 = r1 - r2
            int r1 = r1 / 2
            r9 = r2
            r2 = r1
            r1 = r9
            goto L5a
        L4b:
            float r10 = r10 / r4
            float r2 = r2 * r10
            double r5 = (double) r2
            double r5 = java.lang.Math.ceil(r5)
            int r10 = (int) r5
            int r0 = r0 - r10
            int r0 = r0 / 2
            r2 = r3
            r3 = r0
            r0 = r10
            r10 = r4
        L5a:
            r7.preScale(r10, r10)
            r5 = r0
            r6 = r1
            r4 = r2
            goto L89
        L61:
            boolean r10 = r10.f7004i
            if (r10 == 0) goto L75
            float r10 = (float) r2
            float r2 = (float) r0
            float r10 = r10 / r2
            float r2 = (float) r4
            float r4 = (float) r1
            float r2 = r2 / r4
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 >= 0) goto L70
            goto L71
        L70:
            r10 = r2
        L71:
            r7.preScale(r10, r10)
            goto L86
        L75:
            if (r2 == 0) goto L86
            if (r4 == 0) goto L86
            if (r2 != r0) goto L7d
            if (r4 == r1) goto L86
        L7d:
            float r10 = (float) r2
            float r2 = (float) r0
            float r10 = r10 / r2
            float r2 = (float) r4
            float r4 = (float) r1
            float r2 = r2 / r4
            r7.preScale(r10, r2)
        L86:
            r5 = r0
            r6 = r1
            r4 = r3
        L89:
            if (r12 == 0) goto L8f
            float r10 = (float) r12
            r7.preRotate(r10)
        L8f:
            r8 = 1
            r2 = r11
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r2, r3, r4, r5, r6, r7, r8)
            if (r10 == r11) goto L9b
            r11.recycle()
            r11 = r10
        L9b:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.fl0.m3786y(cz.opentree.ul0, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    /* renamed from: z */
    public static void m3787z(ul0 ul0Var) {
        String m8918a = ul0Var.m8918a();
        StringBuilder sb = f2703d0.get();
        sb.ensureCapacity(m8918a.length() + 8);
        sb.replace(8, sb.length(), m8918a);
        Thread.currentThread().setName(sb.toString());
    }

    /* renamed from: b */
    public void m3788b(dl0 dl0Var) {
        boolean z = this.f2704O.f8631l;
        ul0 ul0Var = dl0Var.f2233b;
        if (this.f2711V != null) {
            if (this.f2712W == null) {
                this.f2712W = new ArrayList(3);
            }
            this.f2712W.add(dl0Var);
            if (z) {
                bm0.m2580u("Hunter", "joined", ul0Var.m8921d(), bm0.m2571l(this, "to "));
                return;
            }
            return;
        }
        this.f2711V = dl0Var;
        if (z) {
            List<dl0> list = this.f2712W;
            if (list == null || list.isEmpty()) {
                bm0.m2580u("Hunter", "joined", ul0Var.m8921d(), "to empty hunter");
            } else {
                bm0.m2580u("Hunter", "joined", ul0Var.m8921d(), bm0.m2571l(this, "to "));
            }
        }
    }

    /* renamed from: e */
    public boolean m3789e() {
        Future<?> future;
        if (this.f2711V != null) {
            return false;
        }
        List<dl0> list = this.f2712W;
        return (list == null || list.isEmpty()) && (future = this.f2714Y) != null && future.cancel(false);
    }

    /* renamed from: g */
    public abstract Bitmap mo3528g(ul0 ul0Var) throws IOException;

    /* renamed from: h */
    public void m3790h(dl0 dl0Var) {
        if (this.f2711V == dl0Var) {
            this.f2711V = null;
        } else {
            List<dl0> list = this.f2712W;
            if (list != null) {
                list.remove(dl0Var);
            }
        }
        if (this.f2704O.f8631l) {
            bm0.m2580u("Hunter", "removed", dl0Var.f2233b.m8921d(), bm0.m2571l(this, "from "));
        }
    }

    /* renamed from: j */
    public dl0 m3791j() {
        return this.f2711V;
    }

    /* renamed from: k */
    public List<dl0> m3792k() {
        return this.f2712W;
    }

    /* renamed from: l */
    public ul0 m3793l() {
        return this.f2709T;
    }

    /* renamed from: m */
    public Exception m3794m() {
        return this.f2716a0;
    }

    /* renamed from: n */
    public String m3795n() {
        return this.f2708S;
    }

    /* renamed from: o */
    public Picasso.EnumC2454d mo3529o() {
        return this.f2715Z;
    }

    /* renamed from: p */
    public Picasso m3796p() {
        return this.f2704O;
    }

    /* renamed from: q */
    public Bitmap m3797q() {
        return this.f2713X;
    }

    /* renamed from: r */
    public Bitmap m3798r() throws IOException {
        Bitmap mo6735a;
        if (!this.f2710U && (mo6735a = this.f2706Q.mo6735a(this.f2708S)) != null) {
            this.f2707R.m9805d();
            this.f2715Z = Picasso.EnumC2454d.MEMORY;
            if (this.f2704O.f8631l) {
                bm0.m2580u("Hunter", "decoded", this.f2709T.m8921d(), "from cache");
            }
            return mo6735a;
        }
        Bitmap mo3528g = mo3528g(this.f2709T);
        if (mo3528g != null) {
            if (this.f2704O.f8631l) {
                bm0.m2579t("Hunter", "decoded", this.f2709T.m8921d());
            }
            this.f2707R.m9803b(mo3528g);
            if (this.f2709T.m8923f() || this.f2717b0 != 0) {
                synchronized (f2702c0) {
                    if (this.f2709T.m8922e() || this.f2717b0 != 0) {
                        mo3528g = m3786y(this.f2709T, mo3528g, this.f2717b0);
                        if (this.f2704O.f8631l) {
                            bm0.m2579t("Hunter", "transformed", this.f2709T.m8921d());
                        }
                    }
                    if (this.f2709T.m8919b()) {
                        mo3528g = m3780a(this.f2709T.f7000e, mo3528g);
                        if (this.f2704O.f8631l) {
                            bm0.m2580u("Hunter", "transformed", this.f2709T.m8921d(), "from custom transformations");
                        }
                    }
                }
                if (mo3528g != null) {
                    this.f2707R.m9804c(mo3528g);
                }
            }
        }
        return mo3528g;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    m3787z(this.f2709T);
                    if (this.f2704O.f8631l) {
                        bm0.m2579t("Hunter", "executing", bm0.m2570k(this));
                    }
                    Bitmap m3798r = m3798r();
                    this.f2713X = m3798r;
                    if (m3798r == null) {
                        this.f2705P.m5147e(this);
                    } else {
                        this.f2705P.m5146d(this);
                    }
                } catch (Exception e) {
                    this.f2716a0 = e;
                    this.f2705P.m5147e(this);
                } catch (OutOfMemoryError e2) {
                    StringWriter stringWriter = new StringWriter();
                    this.f2707R.m9802a().m10189a(new PrintWriter(stringWriter));
                    this.f2716a0 = new RuntimeException(stringWriter.toString(), e2);
                    this.f2705P.m5147e(this);
                }
            } catch (Downloader.C2449b e3) {
                this.f2716a0 = e3;
                this.f2705P.m5147e(this);
            } catch (IOException e4) {
                this.f2716a0 = e4;
                this.f2705P.m5149g(this);
            }
        } finally {
            Thread.currentThread().setName("Picasso-Idle");
        }
    }

    /* renamed from: s */
    public boolean m3799s() {
        Future<?> future = this.f2714Y;
        return future != null && future.isCancelled();
    }

    /* renamed from: u */
    public void m3800u(int i) {
        this.f2717b0 = i;
    }

    /* renamed from: v */
    public boolean mo3801v(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    /* renamed from: w */
    public boolean m3802w() {
        return this.f2710U;
    }

    /* renamed from: x */
    public boolean mo3803x() {
        return false;
    }
}
