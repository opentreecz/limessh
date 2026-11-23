package com.sonelli;

import android.content.Context;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.y9 */
/* loaded from: classes.dex */
public class C2334y9 {

    /* renamed from: a */
    public final SparseIntArray f8166a = new SparseIntArray();

    /* renamed from: b */
    public C2326y6 f8167b;

    public C2334y9(@NonNull C2326y6 c2326y6) {
        C0813ca.m2729k(c2326y6);
        this.f8167b = c2326y6;
    }

    /* renamed from: a */
    public void m10114a() {
        this.f8166a.clear();
    }

    /* renamed from: b */
    public int m10115b(@NonNull Context context, @NonNull Api.Client client) {
        C0813ca.m2729k(context);
        C0813ca.m2729k(client);
        int i = 0;
        if (!client.m971k()) {
            return 0;
        }
        int mo972l = client.mo972l();
        int i2 = this.f8166a.get(mo972l, -1);
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.f8166a.size()) {
                i = i2;
                break;
            }
            int keyAt = this.f8166a.keyAt(i3);
            if (keyAt > mo972l && this.f8166a.get(keyAt) == 0) {
                break;
            }
            i3++;
        }
        if (i == -1) {
            i = this.f8167b.mo9713h(context, mo972l);
        }
        this.f8166a.put(mo972l, i);
        return i;
    }
}
