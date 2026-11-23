package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import cz.opentree.C1099ha;
import cz.opentree.C1845s4;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class zzo extends zzaz {
    public static final Parcelable.Creator<zzo> CREATOR = new C1845s4();

    /* renamed from: U */
    public static final ArrayMap<String, FastJsonResponse.Field<?, ?>> f568U;

    /* renamed from: O */
    public final int f569O;

    /* renamed from: P */
    public List<String> f570P;

    /* renamed from: Q */
    public List<String> f571Q;

    /* renamed from: R */
    public List<String> f572R;

    /* renamed from: S */
    public List<String> f573S;

    /* renamed from: T */
    public List<String> f574T;

    static {
        ArrayMap<String, FastJsonResponse.Field<?, ?>> arrayMap = new ArrayMap<>();
        f568U = arrayMap;
        arrayMap.put("registered", FastJsonResponse.Field.m1156b0("registered", 2));
        arrayMap.put("in_progress", FastJsonResponse.Field.m1156b0("in_progress", 3));
        arrayMap.put("success", FastJsonResponse.Field.m1156b0("success", 4));
        arrayMap.put("failed", FastJsonResponse.Field.m1156b0("failed", 5));
        arrayMap.put("escrowed", FastJsonResponse.Field.m1156b0("escrowed", 6));
    }

    public zzo() {
        this.f569O = 1;
    }

    public zzo(int i, @Nullable List<String> list, @Nullable List<String> list2, @Nullable List<String> list3, @Nullable List<String> list4, @Nullable List<String> list5) {
        this.f569O = i;
        this.f570P = list;
        this.f571Q = list2;
        this.f572R = list3;
        this.f573S = list4;
        this.f574T = list5;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: a */
    public Map<String, FastJsonResponse.Field<?, ?>> mo840a() {
        return f568U;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: b */
    public Object mo841b(FastJsonResponse.Field field) {
        switch (field.m1159c0()) {
            case 1:
                return Integer.valueOf(this.f569O);
            case 2:
                return this.f570P;
            case 3:
                return this.f571Q;
            case 4:
                return this.f572R;
            case 5:
                return this.f573S;
            case 6:
                return this.f574T;
            default:
                int m1159c0 = field.m1159c0();
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unknown SafeParcelable id=");
                sb.append(m1159c0);
                throw new IllegalStateException(sb.toString());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: d */
    public boolean mo842d(FastJsonResponse.Field field) {
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f569O);
        C1099ha.m4414s(parcel, 2, this.f570P, false);
        C1099ha.m4414s(parcel, 3, this.f571Q, false);
        C1099ha.m4414s(parcel, 4, this.f572R, false);
        C1099ha.m4414s(parcel, 5, this.f573S, false);
        C1099ha.m4414s(parcel, 6, this.f574T, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
