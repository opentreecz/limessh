package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import com.sonelli.C1099ha;
import com.sonelli.C1993u4;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class zzt extends zzaz {
    public static final Parcelable.Creator<zzt> CREATOR = new C1993u4();

    /* renamed from: V */
    public static final HashMap<String, FastJsonResponse.Field<?, ?>> f582V;

    /* renamed from: O */
    public final Set<Integer> f583O;

    /* renamed from: P */
    public final int f584P;

    /* renamed from: Q */
    public String f585Q;

    /* renamed from: R */
    public int f586R;

    /* renamed from: S */
    public byte[] f587S;

    /* renamed from: T */
    public PendingIntent f588T;

    /* renamed from: U */
    public DeviceMetaData f589U;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f582V = hashMap;
        hashMap.put("accountType", FastJsonResponse.Field.m1155a0("accountType", 2));
        hashMap.put(NotificationCompat.CATEGORY_STATUS, FastJsonResponse.Field.m1154Z(NotificationCompat.CATEGORY_STATUS, 3));
        hashMap.put("transferBytes", FastJsonResponse.Field.m1158x("transferBytes", 4));
    }

    public zzt() {
        this.f583O = new ArraySet(3);
        this.f584P = 1;
    }

    public zzt(Set<Integer> set, int i, String str, int i2, byte[] bArr, PendingIntent pendingIntent, DeviceMetaData deviceMetaData) {
        this.f583O = set;
        this.f584P = i;
        this.f585Q = str;
        this.f586R = i2;
        this.f587S = bArr;
        this.f588T = pendingIntent;
        this.f589U = deviceMetaData;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: a */
    public /* synthetic */ Map mo840a() {
        return f582V;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* renamed from: b */
    public Object mo841b(FastJsonResponse.Field field) {
        int m1159c0 = field.m1159c0();
        if (m1159c0 == 1) {
            return Integer.valueOf(this.f584P);
        }
        if (m1159c0 == 2) {
            return this.f585Q;
        }
        if (m1159c0 == 3) {
            return Integer.valueOf(this.f586R);
        }
        if (m1159c0 == 4) {
            return this.f587S;
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
        return this.f583O.contains(Integer.valueOf(field.m1159c0()));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        Set<Integer> set = this.f583O;
        if (set.contains(1)) {
            C1099ha.m4406k(parcel, 1, this.f584P);
        }
        if (set.contains(2)) {
            C1099ha.m4412q(parcel, 2, this.f585Q, true);
        }
        if (set.contains(3)) {
            C1099ha.m4406k(parcel, 3, this.f586R);
        }
        if (set.contains(4)) {
            C1099ha.m4401f(parcel, 4, this.f587S, true);
        }
        if (set.contains(5)) {
            C1099ha.m4411p(parcel, 5, this.f588T, i, true);
        }
        if (set.contains(6)) {
            C1099ha.m4411p(parcel, 6, this.f589U, i, true);
        }
        C1099ha.m4397b(parcel, m4396a);
    }
}
