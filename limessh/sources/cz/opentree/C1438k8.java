package cz.opentree;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.k8 */
/* loaded from: classes.dex */
public final class C1438k8<O extends Api.ApiOptions> extends C0863d8 {

    /* renamed from: b */
    public final C1199j7<O> f4495b;

    public C1438k8(C1199j7<O> c1199j7) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f4495b = c1199j7;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* renamed from: a */
    public final <A extends Api.AnyClient, R extends Result, T extends AbstractC1802r7<R, A>> T mo983a(@NonNull T t) {
        this.f4495b.m5071c(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* renamed from: b */
    public final <A extends Api.AnyClient, T extends AbstractC1802r7<? extends Result, A>> T mo984b(@NonNull T t) {
        this.f4495b.m5072d(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* renamed from: d */
    public final Looper mo985d() {
        return this.f4495b.m5077i();
    }
}
