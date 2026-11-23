package com.sonelli;

import android.os.Process;
import androidx.annotation.GuardedBy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.vz */
/* loaded from: classes.dex */
public final class C2192vz extends Thread {

    /* renamed from: O */
    public final Object f7572O;

    /* renamed from: P */
    public final BlockingQueue<C1890sz<?>> f7573P;

    /* renamed from: Q */
    @GuardedBy("threadLifeCycleLock")
    public boolean f7574Q = false;

    /* renamed from: R */
    public final /* synthetic */ C1839rz f7575R;

    public C2192vz(C1839rz c1839rz, String str, BlockingQueue<C1890sz<?>> blockingQueue) {
        this.f7575R = c1839rz;
        C0813ca.m2729k(str);
        C0813ca.m2729k(blockingQueue);
        this.f7572O = new Object();
        this.f7573P = blockingQueue;
        setName(str);
    }

    /* renamed from: a */
    public final void m9372a() {
        synchronized (this.f7572O) {
            this.f7572O.notifyAll();
        }
    }

    /* renamed from: b */
    public final void m9373b(InterruptedException interruptedException) {
        this.f7575R.mo1484j().m8525K().m9084b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    /* renamed from: c */
    public final void m9374c() {
        Object obj;
        Semaphore semaphore;
        Object obj2;
        C2192vz c2192vz;
        C2192vz c2192vz2;
        obj = this.f7575R.f6308i;
        synchronized (obj) {
            if (!this.f7574Q) {
                semaphore = this.f7575R.f6309j;
                semaphore.release();
                obj2 = this.f7575R.f6308i;
                obj2.notifyAll();
                c2192vz = this.f7575R.f6302c;
                if (this == c2192vz) {
                    C1839rz.m8279v(this.f7575R, null);
                } else {
                    c2192vz2 = this.f7575R.f6303d;
                    if (this == c2192vz2) {
                        C1839rz.m8273B(this.f7575R, null);
                    } else {
                        this.f7575R.mo1484j().m8522H().m9083a("Current scheduler thread is neither worker nor network");
                    }
                }
                this.f7574Q = true;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Semaphore semaphore;
        Object obj;
        boolean z;
        boolean z2 = false;
        while (!z2) {
            try {
                semaphore = this.f7575R.f6309j;
                semaphore.acquire();
                z2 = true;
            } catch (InterruptedException e) {
                m9373b(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                C1890sz<?> poll = this.f7573P.poll();
                if (poll == null) {
                    synchronized (this.f7572O) {
                        if (this.f7573P.peek() == null) {
                            z = this.f7575R.f6310k;
                            if (!z) {
                                try {
                                    this.f7572O.wait(30000L);
                                } catch (InterruptedException e2) {
                                    m9373b(e2);
                                }
                            }
                        }
                    }
                    obj = this.f7575R.f6308i;
                    synchronized (obj) {
                        if (this.f7573P.peek() == null) {
                            break;
                        }
                    }
                } else {
                    Process.setThreadPriority(poll.f6617P ? threadPriority : 10);
                    poll.run();
                }
            }
            if (this.f7575R.m7590o().m2630u(C1735pu.f5779A0)) {
                m9374c();
            }
        } finally {
            m9374c();
        }
    }
}
