package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.sonelli.C1099ha;
import com.sonelli.C1696pb;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new C1696pb();

    /* renamed from: O */
    public final int f908O;

    /* renamed from: P */
    public final String f909P;

    /* renamed from: Q */
    public final ArrayList<zal> f910Q;

    public zam(int i, String str, ArrayList<zal> arrayList) {
        this.f908O = i;
        this.f909P = str;
        this.f910Q = arrayList;
    }

    public zam(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
        ArrayList<zal> arrayList;
        this.f908O = 1;
        this.f909P = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (String str2 : map.keySet()) {
                arrayList.add(new zal(str2, map.get(str2)));
            }
        }
        this.f910Q = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f908O);
        C1099ha.m4412q(parcel, 2, this.f909P, false);
        C1099ha.m4416u(parcel, 3, this.f910Q, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
