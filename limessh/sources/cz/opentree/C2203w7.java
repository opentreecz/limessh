package cz.opentree;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.w7 */
/* loaded from: classes.dex */
public final class C2203w7<R extends Result> extends AbstractC1437k7<R> {

    /* renamed from: a */
    public final BasePendingResult<R> f7626a;

    public C2203w7(PendingResult<R> pendingResult) {
        this.f7626a = (BasePendingResult) pendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    /* renamed from: a */
    public final void mo988a(PendingResult.StatusListener statusListener) {
        this.f7626a.mo988a(statusListener);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    /* renamed from: b */
    public final R mo989b(long j, TimeUnit timeUnit) {
        return this.f7626a.mo989b(j, timeUnit);
    }
}
