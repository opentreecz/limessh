package cz.opentree;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.qc */
/* loaded from: classes.dex */
public class ThreadFactoryC1755qc implements ThreadFactory {

    /* renamed from: a */
    public final String f5970a;

    /* renamed from: b */
    public final ThreadFactory f5971b;

    public ThreadFactoryC1755qc(String str) {
        this(str, 0);
    }

    public ThreadFactoryC1755qc(String str, int i) {
        this.f5971b = Executors.defaultThreadFactory();
        C0813ca.m2730l(str, "Name must not be null");
        this.f5970a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f5971b.newThread(new RunnableC1811rc(runnable, 0));
        newThread.setName(this.f5970a);
        return newThread;
    }
}
