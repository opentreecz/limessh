package cz.opentree;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.a8 */
/* loaded from: classes.dex */
public final class C0698a8 implements PendingResult.StatusListener {

    /* renamed from: a */
    public final /* synthetic */ BasePendingResult f1341a;

    /* renamed from: b */
    public final /* synthetic */ C0702a9 f1342b;

    public C0698a8(C0702a9 c0702a9, BasePendingResult basePendingResult) {
        this.f1342b = c0702a9;
        this.f1341a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    /* renamed from: a */
    public final void mo990a(Status status) {
        Map map;
        map = this.f1342b.f1348a;
        map.remove(this.f1341a);
    }
}
