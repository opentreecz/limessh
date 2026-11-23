package cz.opentree.util;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes.dex */
public class BlockingOnUIRunnable {

    /* renamed from: a */
    public Context f7152a;

    /* renamed from: b */
    public BlockingOnUIRunnableListener f7153b;

    /* renamed from: c */
    public final Runnable f7154c = new RunnableC2079a();

    /* loaded from: classes.dex */
    public interface BlockingOnUIFinishedListener {
        /* renamed from: a */
        void mo8999a();
    }

    /* loaded from: classes.dex */
    public interface BlockingOnUIRunnableListener {
        /* renamed from: a */
        void mo8900a(BlockingOnUIFinishedListener blockingOnUIFinishedListener);
    }

    /* renamed from: cz.opentree.util.BlockingOnUIRunnable$a */
    /* loaded from: classes.dex */
    public class RunnableC2079a implements Runnable {

        /* renamed from: cz.opentree.util.BlockingOnUIRunnable$a$a */
        /* loaded from: classes.dex */
        public class a implements BlockingOnUIFinishedListener {
            public a() {
            }

            @Override // cz.opentree.util.BlockingOnUIRunnable.BlockingOnUIFinishedListener
            /* renamed from: a */
            public void mo8999a() {
                synchronized (BlockingOnUIRunnable.this.f7154c) {
                    BlockingOnUIRunnable.this.f7154c.notify();
                }
            }
        }

        public RunnableC2079a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = new a();
            if (BlockingOnUIRunnable.this.f7153b != null) {
                BlockingOnUIRunnable.this.f7153b.mo8900a(aVar);
            }
        }
    }

    public BlockingOnUIRunnable(Context context, BlockingOnUIRunnableListener blockingOnUIRunnableListener) {
        this.f7152a = context;
        this.f7153b = blockingOnUIRunnableListener;
    }

    /* renamed from: c */
    public void m8998c() {
        synchronized (this.f7154c) {
            Context context = this.f7152a;
            if (context instanceof Activity) {
                ((Activity) context).runOnUiThread(this.f7154c);
            }
            try {
                this.f7154c.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
