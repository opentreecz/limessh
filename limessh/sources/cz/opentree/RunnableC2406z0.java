package cz.opentree;

import com.google.android.datatransport.TransportScheduleCallback;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.z0 */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC2406z0 implements Runnable {

    /* renamed from: O */
    public final C0748b1 f8383O;

    /* renamed from: P */
    public final AbstractC1138i0 f8384P;

    /* renamed from: Q */
    public final TransportScheduleCallback f8385Q;

    /* renamed from: R */
    public final AbstractC0906e0 f8386R;

    public RunnableC2406z0(C0748b1 c0748b1, AbstractC1138i0 abstractC1138i0, TransportScheduleCallback transportScheduleCallback, AbstractC0906e0 abstractC0906e0) {
        this.f8383O = c0748b1;
        this.f8384P = abstractC1138i0;
        this.f8385Q = transportScheduleCallback;
        this.f8386R = abstractC0906e0;
    }

    /* renamed from: a */
    public static Runnable m10311a(C0748b1 c0748b1, AbstractC1138i0 abstractC1138i0, TransportScheduleCallback transportScheduleCallback, AbstractC0906e0 abstractC0906e0) {
        return new RunnableC2406z0(c0748b1, abstractC1138i0, transportScheduleCallback, abstractC0906e0);
    }

    @Override // java.lang.Runnable
    public void run() {
        C0748b1.m2334c(this.f8383O, this.f8384P, this.f8385Q, this.f8386R);
    }
}
