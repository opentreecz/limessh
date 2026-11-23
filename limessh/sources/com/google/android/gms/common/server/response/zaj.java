package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import cz.opentree.C0813ca;
import cz.opentree.C1099ha;
import cz.opentree.C1754qb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class zaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaj> CREATOR = new C1754qb();

    /* renamed from: O */
    public final int f902O;

    /* renamed from: P */
    public final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> f903P;

    /* renamed from: Q */
    public final String f904Q;

    public zaj(int i, ArrayList<zam> arrayList, String str) {
        this.f902O = i;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zam zamVar = arrayList.get(i2);
            String str2 = zamVar.f909P;
            HashMap hashMap2 = new HashMap();
            int size2 = zamVar.f910Q.size();
            for (int i3 = 0; i3 < size2; i3++) {
                zal zalVar = zamVar.f910Q.get(i3);
                hashMap2.put(zalVar.f906P, zalVar.f907Q);
            }
            hashMap.put(str2, hashMap2);
        }
        this.f903P = hashMap;
        C0813ca.m2729k(str);
        this.f904Q = str;
        m1172x();
    }

    /* renamed from: K */
    public final String m1170K() {
        return this.f904Q;
    }

    /* renamed from: Y */
    public final Map<String, FastJsonResponse.Field<?, ?>> m1171Y(String str) {
        return this.f903P.get(str);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f903P.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f903P.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f902O);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f903P.keySet()) {
            arrayList.add(new zam(str, this.f903P.get(str)));
        }
        C1099ha.m4416u(parcel, 2, arrayList, false);
        C1099ha.m4412q(parcel, 3, this.f904Q, false);
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public final void m1172x() {
        Iterator<String> it = this.f903P.keySet().iterator();
        while (it.hasNext()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f903P.get(it.next());
            Iterator<String> it2 = map.keySet().iterator();
            while (it2.hasNext()) {
                map.get(it2.next()).m1160e0(this);
            }
        }
    }
}
