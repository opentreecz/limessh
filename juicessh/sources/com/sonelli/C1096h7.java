package com.sonelli;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.h7 */
/* loaded from: classes.dex */
public class C1096h7 extends Exception {

    /* renamed from: O */
    public final ArrayMap<C1750q7<?>, ConnectionResult> f3112O;

    public C1096h7(ArrayMap<C1750q7<?>, ConnectionResult> arrayMap) {
        this.f3112O = arrayMap;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (C1750q7<?> c1750q7 : this.f3112O.keySet()) {
            ConnectionResult connectionResult = this.f3112O.get(c1750q7);
            if (connectionResult.m954a0()) {
                z = false;
            }
            String m7630a = c1750q7.m7630a();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(m7630a).length() + 2 + String.valueOf(valueOf).length());
            sb.append(m7630a);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
