package cz.opentree;

import java.lang.Thread;

/* renamed from: cz.opentree.xf */
/* loaded from: classes.dex */
public final class C2275xf implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public final /* synthetic */ C2216wf f7922a;

    public C2275xf(C2216wf c2216wf) {
        this.f7922a = c2216wf;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        C1451kh m9487o = this.f7922a.m9487o();
        if (m9487o != null) {
            m9487o.m8674w0("Job execution failed", th);
        }
    }
}
