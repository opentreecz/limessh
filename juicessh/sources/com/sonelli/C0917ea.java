package com.sonelli;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.ea */
/* loaded from: classes.dex */
public class C0917ea<T extends IInterface> extends AbstractC2159v9<T> {

    /* renamed from: z */
    public final Api.SimpleClient<T> f2352z;

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: G */
    public void mo1068G(int i, T t) {
        this.f2352z.m975g(i, t);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: i */
    public String mo1085i() {
        return this.f2352z.m976i();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: j */
    public T mo1086j(IBinder iBinder) {
        return this.f2352z.m977j(iBinder);
    }

    /* renamed from: k0 */
    public Api.SimpleClient<T> m3460k0() {
        return this.f2352z;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: o */
    public String mo1089o() {
        return this.f2352z.m978o();
    }
}
