package cz.opentree;

import android.content.Context;
import android.os.Build;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.f1 */
/* loaded from: classes.dex */
public abstract class AbstractC0964f1 {
    /* renamed from: a */
    public static WorkScheduler m3651a(Context context, EventStore eventStore, AbstractC1583n1 abstractC1583n1, Clock clock) {
        return Build.VERSION.SDK_INT >= 21 ? new C1484l1(context, eventStore, abstractC1583n1) : new C1089h1(context, eventStore, clock, abstractC1583n1);
    }
}
