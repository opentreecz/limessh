package cz.opentree;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import cz.opentree.ul0;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.squareup.picasso.Transformation;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RequestCreator.java */
/* loaded from: classes.dex */
public class vl0 {

    /* renamed from: j */
    public static int f7503j;

    /* renamed from: a */
    public final Picasso f7504a;

    /* renamed from: b */
    public final ul0.C2019b f7505b;

    /* renamed from: c */
    public boolean f7506c;

    /* renamed from: d */
    public boolean f7507d;

    /* renamed from: e */
    public boolean f7508e;

    /* renamed from: f */
    public int f7509f;

    /* renamed from: g */
    public int f7510g;

    /* renamed from: h */
    public Drawable f7511h;

    /* renamed from: i */
    public Drawable f7512i;

    /* compiled from: RequestCreator.java */
    /* renamed from: cz.opentree.vl0$a */
    /* loaded from: classes.dex */
    public static class RunnableC2177a implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ AtomicInteger f7513O;

        /* renamed from: P */
        public final /* synthetic */ CountDownLatch f7514P;

        public RunnableC2177a(AtomicInteger atomicInteger, CountDownLatch countDownLatch) {
            this.f7513O = atomicInteger;
            this.f7514P = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7513O.set(vl0.m9303a());
            this.f7514P.countDown();
        }
    }

    /* compiled from: RequestCreator.java */
    /* renamed from: cz.opentree.vl0$b */
    /* loaded from: classes.dex */
    public static class RunnableC2178b implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ InterruptedException f7515O;

        public RunnableC2178b(InterruptedException interruptedException) {
            this.f7515O = interruptedException;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw new RuntimeException(this.f7515O);
        }
    }

    public vl0(Picasso picasso, Uri uri, int i) {
        if (picasso.f8632m) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.f7504a = picasso;
        this.f7505b = new ul0.C2019b(uri, i);
    }

    /* renamed from: a */
    public static /* synthetic */ int m9303a() {
        return m9304d();
    }

    /* renamed from: d */
    public static int m9304d() {
        if (bm0.m2577r()) {
            int i = f7503j;
            f7503j = i + 1;
            return i;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicInteger atomicInteger = new AtomicInteger();
        Picasso.f8618n.post(new RunnableC2177a(atomicInteger, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Picasso.f8618n.post(new RunnableC2178b(e));
        }
        return atomicInteger.get();
    }

    /* renamed from: b */
    public final ul0 m9305b(long j) {
        int m9304d = m9304d();
        ul0 m8925a = this.f7505b.m8925a();
        m8925a.f6996a = m9304d;
        m8925a.f6997b = j;
        boolean z = this.f7504a.f8631l;
        if (z) {
            bm0.m2580u("Main", "created", m8925a.m8924g(), m8925a.toString());
        }
        ul0 m10688m = this.f7504a.m10688m(m8925a);
        if (m10688m != m8925a) {
            m10688m.f6996a = m9304d;
            m10688m.f6997b = j;
            if (z) {
                bm0.m2580u("Main", "changed", m10688m.m8921d(), "into " + m10688m);
            }
        }
        return m10688m;
    }

    /* renamed from: c */
    public Bitmap m9306c() throws IOException {
        long nanoTime = System.nanoTime();
        bm0.m2563d();
        if (this.f7508e) {
            throw new IllegalStateException("Fit cannot be used with get.");
        }
        if (!this.f7505b.m8926b()) {
            return null;
        }
        ul0 m9305b = m9305b(nanoTime);
        ll0 ll0Var = new ll0(this.f7504a, m9305b, this.f7506c, bm0.m2568i(m9305b, new StringBuilder()));
        Picasso picasso = this.f7504a;
        Context context = picasso.f8623d;
        jl0 jl0Var = picasso.f8624e;
        return fl0.m3784i(context, picasso, jl0Var, picasso.f8625f, picasso.f8626g, ll0Var, jl0Var.f3607d).m3798r();
    }

    /* renamed from: e */
    public void m9307e(ImageView imageView) {
        m9308f(imageView, null);
    }

    /* renamed from: f */
    public void m9308f(ImageView imageView, Callback callback) {
        Bitmap m10686k;
        long nanoTime = System.nanoTime();
        bm0.m2562c();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (!this.f7505b.m8926b()) {
            this.f7504a.m10678c(imageView);
            sl0.m8467d(imageView, this.f7509f, this.f7511h);
            return;
        }
        if (this.f7508e) {
            if (this.f7505b.m8927c()) {
                throw new IllegalStateException("Fit cannot be used with resize.");
            }
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            if (width == 0 || height == 0) {
                sl0.m8467d(imageView, this.f7509f, this.f7511h);
                this.f7504a.m10681f(imageView, new il0(this, imageView, callback));
                return;
            }
            this.f7505b.m8928d(width, height);
        }
        ul0 m9305b = m9305b(nanoTime);
        String m2567h = bm0.m2567h(m9305b);
        if (this.f7506c || (m10686k = this.f7504a.m10686k(m2567h)) == null) {
            sl0.m8467d(imageView, this.f7509f, this.f7511h);
            this.f7504a.m10683h(new ml0(this.f7504a, imageView, m9305b, this.f7506c, this.f7507d, this.f7510g, this.f7512i, m2567h, callback));
            return;
        }
        this.f7504a.m10678c(imageView);
        Picasso picasso = this.f7504a;
        Context context = picasso.f8623d;
        Picasso.EnumC2454d enumC2454d = Picasso.EnumC2454d.MEMORY;
        sl0.m8466c(imageView, context, m10686k, enumC2454d, this.f7507d, picasso.f8630k);
        if (this.f7504a.f8631l) {
            bm0.m2580u("Main", "completed", m9305b.m8924g(), "from " + enumC2454d);
        }
        if (callback != null) {
            callback.m10671d();
        }
    }

    /* renamed from: g */
    public void m9309g(Target target) {
        Bitmap m10686k;
        long nanoTime = System.nanoTime();
        bm0.m2562c();
        if (target == null) {
            throw new IllegalArgumentException("Target must not be null.");
        }
        if (this.f7508e) {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
        Drawable drawable = this.f7509f != 0 ? this.f7504a.f8623d.getResources().getDrawable(this.f7509f) : this.f7511h;
        if (!this.f7505b.m8926b()) {
            this.f7504a.m10679d(target);
            target.mo5660b(drawable);
            return;
        }
        ul0 m9305b = m9305b(nanoTime);
        String m2567h = bm0.m2567h(m9305b);
        if (this.f7506c || (m10686k = this.f7504a.m10686k(m2567h)) == null) {
            target.mo5660b(drawable);
            this.f7504a.m10683h(new zl0(this.f7504a, target, m9305b, this.f7506c, this.f7510g, this.f7512i, m2567h));
        } else {
            this.f7504a.m10679d(target);
            target.mo5661c(m10686k, Picasso.EnumC2454d.MEMORY);
        }
    }

    /* renamed from: h */
    public vl0 m9310h(int i, int i2) {
        this.f7505b.m8928d(i, i2);
        return this;
    }

    /* renamed from: i */
    public vl0 m9311i(Transformation transformation) {
        this.f7505b.m8929e(transformation);
        return this;
    }

    /* renamed from: j */
    public vl0 m9312j() {
        this.f7508e = false;
        return this;
    }
}
