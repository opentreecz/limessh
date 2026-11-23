package com.sonelli;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.sonelli.C1848s7;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.l8 */
/* loaded from: classes.dex */
public final class RunnableC1494l8 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ ConnectionResult f4764O;

    /* renamed from: P */
    public final /* synthetic */ C1848s7.b f4765P;

    public RunnableC1494l8(C1848s7.b bVar, ConnectionResult connectionResult) {
        this.f4765P = bVar;
        this.f4764O = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1750q7 c1750q7;
        Api.Client client;
        Api.Client client2;
        Api.Client client3;
        Map map = C1848s7.this.f6371i;
        c1750q7 = this.f4765P.f6390b;
        C1848s7.a aVar = (C1848s7.a) map.get(c1750q7);
        if (aVar == null) {
            return;
        }
        if (!this.f4764O.m954a0()) {
            aVar.mo1020r(this.f4764O);
            return;
        }
        C1848s7.b.m8394e(this.f4765P, true);
        client = this.f4765P.f6389a;
        if (client.mo974n()) {
            this.f4765P.m8397g();
            return;
        }
        try {
            client2 = this.f4765P.f6389a;
            client3 = this.f4765P.f6389a;
            client2.m966b(null, client3.mo965a());
        } catch (SecurityException e) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
            aVar.mo1020r(new ConnectionResult(10));
        }
    }
}
