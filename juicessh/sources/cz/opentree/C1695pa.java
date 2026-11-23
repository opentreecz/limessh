package cz.opentree;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.pa */
/* loaded from: classes.dex */
public final class C1695pa implements PendingResult.StatusListener {

    /* renamed from: a */
    public final /* synthetic */ PendingResult f5640a;

    /* renamed from: b */
    public final /* synthetic */ k60 f5641b;

    /* renamed from: c */
    public final /* synthetic */ PendingResultUtil.ResultConverter f5642c;

    /* renamed from: d */
    public final /* synthetic */ PendingResultUtil.zaa f5643d;

    public C1695pa(PendingResult pendingResult, k60 k60Var, PendingResultUtil.ResultConverter resultConverter, PendingResultUtil.zaa zaaVar) {
        this.f5640a = pendingResult;
        this.f5641b = k60Var;
        this.f5642c = resultConverter;
        this.f5643d = zaaVar;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    /* renamed from: a */
    public final void mo990a(Status status) {
        if (!status.m996Z()) {
            this.f5641b.m5843b(this.f5643d.mo1126a(status));
        } else {
            this.f5641b.m5844c(this.f5642c.mo1125a(this.f5640a.mo989b(0L, TimeUnit.MILLISECONDS)));
        }
    }
}
