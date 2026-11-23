package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import com.sonelli.C1099ha;
import com.sonelli.C1799r4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzl extends zzaz {
    public static final Parcelable.Creator<zzl> CREATOR = new C1799r4();

    /* renamed from: T */
    public static final HashMap<String, FastJsonResponse.Field<?, ?>> f562T;

    /* renamed from: O */
    public final Set<Integer> f563O;

    /* renamed from: P */
    public final int f564P;

    /* renamed from: Q */
    public ArrayList<zzr> f565Q;

    /* renamed from: R */
    public int f566R;

    /* renamed from: S */
    public zzo f567S;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f562T = hashMap;
        hashMap.put("authenticatorData", FastJsonResponse.Field.m1153Y("authenticatorData", 2, zzr.class));
        hashMap.put(NotificationCompat.CATEGORY_PROGRESS, FastJsonResponse.Field.m1152K(NotificationCompat.CATEGORY_PROGRESS, 4, zzo.class));
    }

    public zzl() {
        this.f563O = new HashSet(1);
        this.f564P = 1;
    }

    public zzl(Set<Integer> set, int i, ArrayList<zzr> arrayList, int i2, zzo zzoVar) {
        this.f563O = set;
        this.f564P = i;
        this.f565Q = arrayList;
        this.f566R = i2;
        this.f567S = zzoVar;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: a */
    public final /* synthetic */ Map mo840a() {
        return f562T;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: b */
    public final Object mo841b(FastJsonResponse.Field field) {
        int m1159c0 = field.m1159c0();
        if (m1159c0 == 1) {
            return Integer.valueOf(this.f564P);
        }
        if (m1159c0 == 2) {
            return this.f565Q;
        }
        if (m1159c0 == 4) {
            return this.f567S;
        }
        int m1159c02 = field.m1159c0();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(m1159c02);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: d */
    public final boolean mo842d(FastJsonResponse.Field field) {
        return this.f563O.contains(Integer.valueOf(field.m1159c0()));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        Set<Integer> set = this.f563O;
        if (set.contains(1)) {
            C1099ha.m4406k(parcel, 1, this.f564P);
        }
        if (set.contains(2)) {
            C1099ha.m4416u(parcel, 2, this.f565Q, true);
        }
        if (set.contains(3)) {
            C1099ha.m4406k(parcel, 3, this.f566R);
        }
        if (set.contains(4)) {
            C1099ha.m4411p(parcel, 4, this.f567S, i, true);
        }
        C1099ha.m4397b(parcel, m4396a);
    }
}
