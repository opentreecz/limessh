package cz.opentree;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: Action.java */
/* loaded from: classes.dex */
public abstract class dl0<T> {

    /* renamed from: a */
    public final Picasso f2232a;

    /* renamed from: b */
    public final ul0 f2233b;

    /* renamed from: c */
    public final WeakReference<T> f2234c;

    /* renamed from: d */
    public final boolean f2235d;

    /* renamed from: e */
    public final boolean f2236e;

    /* renamed from: f */
    public final int f2237f;

    /* renamed from: g */
    public final Drawable f2238g;

    /* renamed from: h */
    public final String f2239h;

    /* renamed from: i */
    public boolean f2240i;

    /* renamed from: j */
    public boolean f2241j;

    /* compiled from: Action.java */
    /* renamed from: cz.opentree.dl0$a */
    /* loaded from: classes.dex */
    public static class C0888a<T> extends WeakReference<T> {

        /* renamed from: a */
        public final dl0 f2242a;

        public C0888a(dl0 dl0Var, T t, ReferenceQueue<? super T> referenceQueue) {
            super(t, referenceQueue);
            this.f2242a = dl0Var;
        }
    }

    public dl0(Picasso picasso, T t, ul0 ul0Var, boolean z, boolean z2, int i, Drawable drawable, String str) {
        this.f2232a = picasso;
        this.f2233b = ul0Var;
        this.f2234c = new C0888a(this, t, picasso.f8629j);
        this.f2235d = z;
        this.f2236e = z2;
        this.f2237f = i;
        this.f2238g = drawable;
        this.f2239h = str;
    }

    /* renamed from: a */
    public void mo3254a() {
        this.f2241j = true;
    }

    /* renamed from: b */
    public abstract void mo3255b(Bitmap bitmap, Picasso.EnumC2454d enumC2454d);

    /* renamed from: c */
    public abstract void mo3256c();

    /* renamed from: d */
    public String m3257d() {
        return this.f2239h;
    }

    /* renamed from: e */
    public Picasso m3258e() {
        return this.f2232a;
    }

    /* renamed from: f */
    public ul0 m3259f() {
        return this.f2233b;
    }

    /* renamed from: g */
    public T m3260g() {
        return this.f2234c.get();
    }

    /* renamed from: h */
    public boolean m3261h() {
        return this.f2241j;
    }

    /* renamed from: i */
    public boolean m3262i() {
        return this.f2240i;
    }
}
