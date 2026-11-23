package com.google.android.datatransport.runtime.scheduling.persistence;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import cz.opentree.AbstractC0906e0;
import cz.opentree.AbstractC1022g2;
import cz.opentree.AbstractC1138i0;
import java.io.Closeable;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
@WorkerThread
/* loaded from: classes.dex */
public interface EventStore extends Closeable {
    @Nullable
    /* renamed from: M */
    AbstractC1022g2 mo755M(AbstractC1138i0 abstractC1138i0, AbstractC0906e0 abstractC0906e0);

    /* renamed from: Q */
    long mo756Q(AbstractC1138i0 abstractC1138i0);

    /* renamed from: S */
    boolean mo757S(AbstractC1138i0 abstractC1138i0);

    /* renamed from: T */
    void mo758T(Iterable<AbstractC1022g2> iterable);

    /* renamed from: i */
    int mo759i();

    /* renamed from: j */
    void mo760j(Iterable<AbstractC1022g2> iterable);

    /* renamed from: q */
    Iterable<AbstractC1022g2> mo761q(AbstractC1138i0 abstractC1138i0);

    /* renamed from: r */
    void mo762r(AbstractC1138i0 abstractC1138i0, long j);

    /* renamed from: u */
    Iterable<AbstractC1138i0> mo763u();
}
