package cz.opentree;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.t0 */
/* loaded from: classes.dex */
public class C1893t0 {

    /* renamed from: a */
    public final Context f6671a;

    /* renamed from: b */
    public final Clock f6672b;

    /* renamed from: c */
    public final Clock f6673c;

    public C1893t0(Context context, Clock clock, Clock clock2) {
        this.f6671a = context;
        this.f6672b = clock;
        this.f6673c = clock2;
    }

    /* renamed from: a */
    public AbstractC1841s0 m8560a(String str) {
        return AbstractC1841s0.m8289a(this.f6671a, this.f6672b, this.f6673c, str);
    }
}
