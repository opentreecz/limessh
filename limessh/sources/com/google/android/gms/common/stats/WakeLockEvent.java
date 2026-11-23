package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cz.opentree.C1099ha;
import cz.opentree.C2271xb;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new C2271xb();

    /* renamed from: O */
    public final int f911O;

    /* renamed from: P */
    public final long f912P;

    /* renamed from: Q */
    public int f913Q;

    /* renamed from: R */
    public final String f914R;

    /* renamed from: S */
    public final String f915S;

    /* renamed from: T */
    public final String f916T;

    /* renamed from: U */
    public final int f917U;

    /* renamed from: V */
    public final List<String> f918V;

    /* renamed from: W */
    public final String f919W;

    /* renamed from: X */
    public final long f920X;

    /* renamed from: Y */
    public int f921Y;

    /* renamed from: Z */
    public final String f922Z;

    /* renamed from: a0 */
    public final float f923a0;

    /* renamed from: b0 */
    public final long f924b0;

    /* renamed from: c0 */
    public final boolean f925c0;

    /* renamed from: d0 */
    public long f926d0;

    public WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5, boolean z) {
        this.f911O = i;
        this.f912P = j;
        this.f913Q = i2;
        this.f914R = str;
        this.f915S = str3;
        this.f916T = str5;
        this.f917U = i3;
        this.f926d0 = -1L;
        this.f918V = list;
        this.f919W = str2;
        this.f920X = j2;
        this.f921Y = i4;
        this.f922Z = str4;
        this.f923a0 = f;
        this.f924b0 = j3;
        this.f925c0 = z;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5, boolean z) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5, z);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    /* renamed from: K */
    public final long mo1173K() {
        return this.f912P;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    /* renamed from: Y */
    public final long mo1174Y() {
        return this.f926d0;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    /* renamed from: Z */
    public final String mo1175Z() {
        String str = this.f914R;
        int i = this.f917U;
        List<String> list = this.f918V;
        String join = list == null ? "" : TextUtils.join(",", list);
        int i2 = this.f921Y;
        String str2 = this.f915S;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.f922Z;
        if (str3 == null) {
            str3 = "";
        }
        float f = this.f923a0;
        String str4 = this.f916T;
        String str5 = str4 != null ? str4 : "";
        boolean z = this.f925c0;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(join).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str5).length());
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f);
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f911O);
        C1099ha.m4408m(parcel, 2, mo1173K());
        C1099ha.m4412q(parcel, 4, this.f914R, false);
        C1099ha.m4406k(parcel, 5, this.f917U);
        C1099ha.m4414s(parcel, 6, this.f918V, false);
        C1099ha.m4408m(parcel, 8, this.f920X);
        C1099ha.m4412q(parcel, 10, this.f915S, false);
        C1099ha.m4406k(parcel, 11, mo1176x());
        C1099ha.m4412q(parcel, 12, this.f919W, false);
        C1099ha.m4412q(parcel, 13, this.f922Z, false);
        C1099ha.m4406k(parcel, 14, this.f921Y);
        C1099ha.m4403h(parcel, 15, this.f923a0);
        C1099ha.m4408m(parcel, 16, this.f924b0);
        C1099ha.m4412q(parcel, 17, this.f916T, false);
        C1099ha.m4398c(parcel, 18, this.f925c0);
        C1099ha.m4397b(parcel, m4396a);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    /* renamed from: x */
    public final int mo1176x() {
        return this.f913Q;
    }
}
