package com.sonelli;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.gm */
/* loaded from: classes.dex */
public final class C1050gm extends WeakReference<Throwable> {

    /* renamed from: a */
    public final int f2889a;

    public C1050gm(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.f2889a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == C1050gm.class) {
            if (this == obj) {
                return true;
            }
            C1050gm c1050gm = (C1050gm) obj;
            if (this.f2889a == c1050gm.f2889a && get() == c1050gm.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2889a;
    }
}
