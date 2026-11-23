package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.sonelli.C1099ha;
import com.sonelli.C1500lb;
import com.sonelli.C1546mb;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new C1546mb();

    /* renamed from: O */
    public final int f876O;

    /* renamed from: P */
    public final HashMap<String, Integer> f877P;

    /* renamed from: Q */
    public final SparseArray<String> f878Q;

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes.dex */
    public static final class zaa extends AbstractSafeParcelable {
        public static final Parcelable.Creator<zaa> CREATOR = new C1500lb();

        /* renamed from: O */
        public final int f879O;

        /* renamed from: P */
        public final String f880P;

        /* renamed from: Q */
        public final int f881Q;

        public zaa(int i, String str, int i2) {
            this.f879O = i;
            this.f880P = str;
            this.f881Q = i2;
        }

        public zaa(String str, int i) {
            this.f879O = 1;
            this.f880P = str;
            this.f881Q = i;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int m4396a = C1099ha.m4396a(parcel);
            C1099ha.m4406k(parcel, 1, this.f879O);
            C1099ha.m4412q(parcel, 2, this.f880P, false);
            C1099ha.m4406k(parcel, 3, this.f881Q);
            C1099ha.m4397b(parcel, m4396a);
        }
    }

    public StringToIntConverter() {
        this.f876O = 1;
        this.f877P = new HashMap<>();
        this.f878Q = new SparseArray<>();
    }

    public StringToIntConverter(int i, ArrayList<zaa> arrayList) {
        this.f876O = i;
        this.f877P = new HashMap<>();
        this.f878Q = new SparseArray<>();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            zaa zaaVar = arrayList.get(i2);
            i2++;
            zaa zaaVar2 = zaaVar;
            m1145x(zaaVar2.f880P, zaaVar2.f881Q);
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    /* renamed from: f */
    public final /* synthetic */ String mo1144f(Integer num) {
        String str = this.f878Q.get(num.intValue());
        return (str == null && this.f877P.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f876O);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f877P.keySet()) {
            arrayList.add(new zaa(str, this.f877P.get(str).intValue()));
        }
        C1099ha.m4416u(parcel, 2, arrayList, false);
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public final StringToIntConverter m1145x(String str, int i) {
        this.f877P.put(str, Integer.valueOf(i));
        this.f878Q.put(i, str);
        return this;
    }
}
