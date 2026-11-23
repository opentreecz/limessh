package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import cz.opentree.C1099ha;
import cz.opentree.C1899t4;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class zzr extends zzaz {
    public static final Parcelable.Creator<zzr> CREATOR = new C1899t4();

    /* renamed from: U */
    public static final HashMap<String, FastJsonResponse.Field<?, ?>> f575U;

    /* renamed from: O */
    public final Set<Integer> f576O;

    /* renamed from: P */
    public final int f577P;

    /* renamed from: Q */
    public zzt f578Q;

    /* renamed from: R */
    public String f579R;

    /* renamed from: S */
    public String f580S;

    /* renamed from: T */
    public String f581T;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f575U = hashMap;
        hashMap.put("authenticatorInfo", FastJsonResponse.Field.m1152K("authenticatorInfo", 2, zzt.class));
        hashMap.put("signature", FastJsonResponse.Field.m1155a0("signature", 3));
        hashMap.put("package", FastJsonResponse.Field.m1155a0("package", 4));
    }

    public zzr() {
        this.f576O = new HashSet(3);
        this.f577P = 1;
    }

    public zzr(Set<Integer> set, int i, zzt zztVar, String str, String str2, String str3) {
        this.f576O = set;
        this.f577P = i;
        this.f578Q = zztVar;
        this.f579R = str;
        this.f580S = str2;
        this.f581T = str3;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: a */
    public /* synthetic */ Map mo840a() {
        return f575U;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: b */
    public Object mo841b(FastJsonResponse.Field field) {
        int m1159c0 = field.m1159c0();
        if (m1159c0 == 1) {
            return Integer.valueOf(this.f577P);
        }
        if (m1159c0 == 2) {
            return this.f578Q;
        }
        if (m1159c0 == 3) {
            return this.f579R;
        }
        if (m1159c0 == 4) {
            return this.f580S;
        }
        int m1159c02 = field.m1159c0();
        StringBuilder sb = new StringBuilder(37);
        sb.append("Unknown SafeParcelable id=");
        sb.append(m1159c02);
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: d */
    public boolean mo842d(FastJsonResponse.Field field) {
        return this.f576O.contains(Integer.valueOf(field.m1159c0()));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        Set<Integer> set = this.f576O;
        if (set.contains(1)) {
            C1099ha.m4406k(parcel, 1, this.f577P);
        }
        if (set.contains(2)) {
            C1099ha.m4411p(parcel, 2, this.f578Q, i, true);
        }
        if (set.contains(3)) {
            C1099ha.m4412q(parcel, 3, this.f579R, true);
        }
        if (set.contains(4)) {
            C1099ha.m4412q(parcel, 4, this.f580S, true);
        }
        if (set.contains(5)) {
            C1099ha.m4412q(parcel, 5, this.f581T, true);
        }
        C1099ha.m4397b(parcel, m4396a);
    }
}
