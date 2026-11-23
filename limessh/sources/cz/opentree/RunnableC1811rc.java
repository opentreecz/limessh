package cz.opentree;

import android.os.Process;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.rc */
/* loaded from: classes.dex */
public final class RunnableC1811rc implements Runnable {

    /* renamed from: O */
    public final Runnable f6201O;

    /* renamed from: P */
    public final int f6202P;

    public RunnableC1811rc(Runnable runnable, int i) {
        this.f6201O = runnable;
        this.f6202P = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f6202P);
        this.f6201O.run();
    }
}
