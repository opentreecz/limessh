package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import cz.opentree.bm0;
import cz.opentree.dl0;
import cz.opentree.fl0;
import cz.opentree.il0;
import cz.opentree.jl0;
import cz.opentree.nl0;
import cz.opentree.tl0;
import cz.opentree.ul0;
import cz.opentree.vl0;
import cz.opentree.xl0;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class Picasso {

    /* renamed from: n */
    public static final Handler f8618n = new HandlerC2451a(Looper.getMainLooper());

    /* renamed from: o */
    public static Picasso f8619o = null;

    /* renamed from: a */
    public final Listener f8620a;

    /* renamed from: b */
    public final RequestTransformer f8621b;

    /* renamed from: c */
    public final C2453c f8622c;

    /* renamed from: d */
    public final Context f8623d;

    /* renamed from: e */
    public final jl0 f8624e;

    /* renamed from: f */
    public final Cache f8625f;

    /* renamed from: g */
    public final xl0 f8626g;

    /* renamed from: h */
    public final Map<Object, dl0> f8627h = new WeakHashMap();

    /* renamed from: i */
    public final Map<ImageView, il0> f8628i = new WeakHashMap();

    /* renamed from: j */
    public final ReferenceQueue<Object> f8629j;

    /* renamed from: k */
    public boolean f8630k;

    /* renamed from: l */
    public volatile boolean f8631l;

    /* renamed from: m */
    public boolean f8632m;

    /* loaded from: classes.dex */
    public interface Listener {
        /* renamed from: a */
        void m10689a(Picasso picasso, Uri uri, Exception exc);
    }

    /* loaded from: classes.dex */
    public interface RequestTransformer {

        /* renamed from: a */
        public static final RequestTransformer f8633a = new C2450a();

        /* renamed from: com.squareup.picasso.Picasso$RequestTransformer$a */
        /* loaded from: classes.dex */
        public static class C2450a implements RequestTransformer {
            @Override // com.squareup.picasso.Picasso.RequestTransformer
            /* renamed from: a */
            public ul0 mo10690a(ul0 ul0Var) {
                return ul0Var;
            }
        }

        /* renamed from: a */
        ul0 mo10690a(ul0 ul0Var);
    }

    /* renamed from: com.squareup.picasso.Picasso$a */
    /* loaded from: classes.dex */
    public static class HandlerC2451a extends Handler {
        public HandlerC2451a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 3) {
                dl0 dl0Var = (dl0) message.obj;
                dl0Var.f2232a.m10677b(dl0Var.m3260g());
                return;
            }
            if (i != 8) {
                throw new AssertionError("Unknown handler message received: " + message.what);
            }
            List list = (List) message.obj;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                fl0 fl0Var = (fl0) list.get(i2);
                fl0Var.f2704O.m10680e(fl0Var);
            }
        }
    }

    /* renamed from: com.squareup.picasso.Picasso$b */
    /* loaded from: classes.dex */
    public static class C2452b {

        /* renamed from: a */
        public final Context f8634a;

        /* renamed from: b */
        public Downloader f8635b;

        /* renamed from: c */
        public ExecutorService f8636c;

        /* renamed from: d */
        public Cache f8637d;

        /* renamed from: e */
        public Listener f8638e;

        /* renamed from: f */
        public RequestTransformer f8639f;

        /* renamed from: g */
        public boolean f8640g;

        /* renamed from: h */
        public boolean f8641h;

        public C2452b(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f8634a = context.getApplicationContext();
        }

        /* renamed from: a */
        public Picasso m10691a() {
            Context context = this.f8634a;
            if (this.f8635b == null) {
                this.f8635b = bm0.m2566g(context);
            }
            if (this.f8637d == null) {
                this.f8637d = new nl0(context);
            }
            if (this.f8636c == null) {
                this.f8636c = new tl0();
            }
            if (this.f8639f == null) {
                this.f8639f = RequestTransformer.f8633a;
            }
            xl0 xl0Var = new xl0(this.f8637d);
            return new Picasso(context, new jl0(context, this.f8636c, Picasso.f8618n, this.f8635b, this.f8637d, xl0Var), this.f8637d, this.f8638e, this.f8639f, xl0Var, this.f8640g, this.f8641h);
        }
    }

    /* renamed from: com.squareup.picasso.Picasso$c */
    /* loaded from: classes.dex */
    public static class C2453c extends Thread {

        /* renamed from: O */
        public final ReferenceQueue<?> f8642O;

        /* renamed from: P */
        public final Handler f8643P;

        /* renamed from: com.squareup.picasso.Picasso$c$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: O */
            public final /* synthetic */ Exception f8644O;

            public a(C2453c c2453c, Exception exc) {
                this.f8644O = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw new RuntimeException(this.f8644O);
            }
        }

        public C2453c(ReferenceQueue<?> referenceQueue, Handler handler) {
            this.f8642O = referenceQueue;
            this.f8643P = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    dl0.C0888a c0888a = (dl0.C0888a) this.f8642O.remove();
                    Handler handler = this.f8643P;
                    handler.sendMessage(handler.obtainMessage(3, c0888a.f2242a));
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e) {
                    this.f8643P.post(new a(this, e));
                    return;
                }
            }
        }
    }

    /* renamed from: com.squareup.picasso.Picasso$d */
    /* loaded from: classes.dex */
    public enum EnumC2454d {
        MEMORY(-16711936),
        DISK(InputDeviceCompat.SOURCE_ANY),
        NETWORK(SupportMenu.CATEGORY_MASK);


        /* renamed from: O */
        public final int f8649O;

        EnumC2454d(int i) {
            this.f8649O = i;
        }
    }

    public Picasso(Context context, jl0 jl0Var, Cache cache, Listener listener, RequestTransformer requestTransformer, xl0 xl0Var, boolean z, boolean z2) {
        this.f8623d = context;
        this.f8624e = jl0Var;
        this.f8625f = cache;
        this.f8620a = listener;
        this.f8621b = requestTransformer;
        this.f8626g = xl0Var;
        this.f8630k = z;
        this.f8631l = z2;
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.f8629j = referenceQueue;
        C2453c c2453c = new C2453c(referenceQueue, f8618n);
        this.f8622c = c2453c;
        c2453c.start();
    }

    /* renamed from: n */
    public static Picasso m10676n(Context context) {
        if (f8619o == null) {
            synchronized (Picasso.class) {
                if (f8619o == null) {
                    f8619o = new C2452b(context).m10691a();
                }
            }
        }
        return f8619o;
    }

    /* renamed from: b */
    public final void m10677b(Object obj) {
        bm0.m2562c();
        dl0 remove = this.f8627h.remove(obj);
        if (remove != null) {
            remove.mo3254a();
            this.f8624e.m5145c(remove);
        }
        if (obj instanceof ImageView) {
            il0 remove2 = this.f8628i.remove((ImageView) obj);
            if (remove2 != null) {
                remove2.m4795a();
            }
        }
    }

    /* renamed from: c */
    public void m10678c(ImageView imageView) {
        m10677b(imageView);
    }

    /* renamed from: d */
    public void m10679d(Target target) {
        m10677b(target);
    }

    /* renamed from: e */
    public void m10680e(fl0 fl0Var) {
        dl0 m3791j = fl0Var.m3791j();
        List<dl0> m3792k = fl0Var.m3792k();
        boolean z = true;
        boolean z2 = (m3792k == null || m3792k.isEmpty()) ? false : true;
        if (m3791j == null && !z2) {
            z = false;
        }
        if (z) {
            Uri uri = fl0Var.m3793l().f6998c;
            Exception m3794m = fl0Var.m3794m();
            Bitmap m3797q = fl0Var.m3797q();
            EnumC2454d mo3529o = fl0Var.mo3529o();
            if (m3791j != null) {
                m10682g(m3797q, mo3529o, m3791j);
            }
            if (z2) {
                int size = m3792k.size();
                for (int i = 0; i < size; i++) {
                    m10682g(m3797q, mo3529o, m3792k.get(i));
                }
            }
            Listener listener = this.f8620a;
            if (listener == null || m3794m == null) {
                return;
            }
            listener.m10689a(this, uri, m3794m);
        }
    }

    /* renamed from: f */
    public void m10681f(ImageView imageView, il0 il0Var) {
        this.f8628i.put(imageView, il0Var);
    }

    /* renamed from: g */
    public final void m10682g(Bitmap bitmap, EnumC2454d enumC2454d, dl0 dl0Var) {
        if (dl0Var.m3261h()) {
            return;
        }
        if (!dl0Var.m3262i()) {
            this.f8627h.remove(dl0Var.m3260g());
        }
        if (bitmap == null) {
            dl0Var.mo3256c();
            if (this.f8631l) {
                bm0.m2579t("Main", "errored", dl0Var.f2233b.m8921d());
                return;
            }
            return;
        }
        if (enumC2454d == null) {
            throw new AssertionError("LoadedFrom cannot be null.");
        }
        dl0Var.mo3255b(bitmap, enumC2454d);
        if (this.f8631l) {
            bm0.m2580u("Main", "completed", dl0Var.f2233b.m8921d(), "from " + enumC2454d);
        }
    }

    /* renamed from: h */
    public void m10683h(dl0 dl0Var) {
        Object m3260g = dl0Var.m3260g();
        if (m3260g != null) {
            m10677b(m3260g);
            this.f8627h.put(m3260g, dl0Var);
        }
        m10687l(dl0Var);
    }

    /* renamed from: i */
    public vl0 m10684i(Uri uri) {
        return new vl0(this, uri, 0);
    }

    /* renamed from: j */
    public vl0 m10685j(String str) {
        if (str == null) {
            return new vl0(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return m10684i(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    /* renamed from: k */
    public Bitmap m10686k(String str) {
        Bitmap mo6735a = this.f8625f.mo6735a(str);
        if (mo6735a != null) {
            this.f8626g.m9805d();
        } else {
            this.f8626g.m9806e();
        }
        return mo6735a;
    }

    /* renamed from: l */
    public void m10687l(dl0 dl0Var) {
        this.f8624e.m5150h(dl0Var);
    }

    /* renamed from: m */
    public ul0 m10688m(ul0 ul0Var) {
        ul0 mo10690a = this.f8621b.mo10690a(ul0Var);
        if (mo10690a != null) {
            return mo10690a;
        }
        throw new IllegalStateException("Request transformer " + this.f8621b.getClass().getCanonicalName() + " returned null for " + ul0Var);
    }
}
