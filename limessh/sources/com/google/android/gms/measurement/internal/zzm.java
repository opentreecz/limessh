package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C0813ca;
import cz.opentree.C1099ha;
import cz.opentree.m40;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new m40();

    /* renamed from: O */
    public final String f997O;

    /* renamed from: P */
    public final String f998P;

    /* renamed from: Q */
    public final String f999Q;

    /* renamed from: R */
    public final String f1000R;

    /* renamed from: S */
    public final long f1001S;

    /* renamed from: T */
    public final long f1002T;

    /* renamed from: U */
    public final String f1003U;

    /* renamed from: V */
    public final boolean f1004V;

    /* renamed from: W */
    public final boolean f1005W;

    /* renamed from: X */
    public final long f1006X;

    /* renamed from: Y */
    public final String f1007Y;

    /* renamed from: Z */
    public final long f1008Z;

    /* renamed from: a0 */
    public final long f1009a0;

    /* renamed from: b0 */
    public final int f1010b0;

    /* renamed from: c0 */
    public final boolean f1011c0;

    /* renamed from: d0 */
    public final boolean f1012d0;

    /* renamed from: e0 */
    public final boolean f1013e0;

    /* renamed from: f0 */
    public final String f1014f0;

    /* renamed from: g0 */
    public final Boolean f1015g0;

    /* renamed from: h0 */
    public final long f1016h0;

    /* renamed from: i0 */
    public final List<String> f1017i0;

    /* renamed from: j0 */
    public final String f1018j0;

    public zzm(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3, boolean z4, boolean z5, String str7, Boolean bool, long j6, List<String> list, String str8) {
        C0813ca.m2725g(str);
        this.f997O = str;
        this.f998P = TextUtils.isEmpty(str2) ? null : str2;
        this.f999Q = str3;
        this.f1006X = j;
        this.f1000R = str4;
        this.f1001S = j2;
        this.f1002T = j3;
        this.f1003U = str5;
        this.f1004V = z;
        this.f1005W = z2;
        this.f1007Y = str6;
        this.f1008Z = j4;
        this.f1009a0 = j5;
        this.f1010b0 = i;
        this.f1011c0 = z3;
        this.f1012d0 = z4;
        this.f1013e0 = z5;
        this.f1014f0 = str7;
        this.f1015g0 = bool;
        this.f1016h0 = j6;
        this.f1017i0 = list;
        this.f1018j0 = str8;
    }

    public zzm(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, long j5, int i, boolean z3, boolean z4, boolean z5, String str7, Boolean bool, long j6, List<String> list, String str8) {
        this.f997O = str;
        this.f998P = str2;
        this.f999Q = str3;
        this.f1006X = j3;
        this.f1000R = str4;
        this.f1001S = j;
        this.f1002T = j2;
        this.f1003U = str5;
        this.f1004V = z;
        this.f1005W = z2;
        this.f1007Y = str6;
        this.f1008Z = j4;
        this.f1009a0 = j5;
        this.f1010b0 = i;
        this.f1011c0 = z3;
        this.f1012d0 = z4;
        this.f1013e0 = z5;
        this.f1014f0 = str7;
        this.f1015g0 = bool;
        this.f1016h0 = j6;
        this.f1017i0 = list;
        this.f1018j0 = str8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4412q(parcel, 2, this.f997O, false);
        C1099ha.m4412q(parcel, 3, this.f998P, false);
        C1099ha.m4412q(parcel, 4, this.f999Q, false);
        C1099ha.m4412q(parcel, 5, this.f1000R, false);
        C1099ha.m4408m(parcel, 6, this.f1001S);
        C1099ha.m4408m(parcel, 7, this.f1002T);
        C1099ha.m4412q(parcel, 8, this.f1003U, false);
        C1099ha.m4398c(parcel, 9, this.f1004V);
        C1099ha.m4398c(parcel, 10, this.f1005W);
        C1099ha.m4408m(parcel, 11, this.f1006X);
        C1099ha.m4412q(parcel, 12, this.f1007Y, false);
        C1099ha.m4408m(parcel, 13, this.f1008Z);
        C1099ha.m4408m(parcel, 14, this.f1009a0);
        C1099ha.m4406k(parcel, 15, this.f1010b0);
        C1099ha.m4398c(parcel, 16, this.f1011c0);
        C1099ha.m4398c(parcel, 17, this.f1012d0);
        C1099ha.m4398c(parcel, 18, this.f1013e0);
        C1099ha.m4412q(parcel, 19, this.f1014f0, false);
        C1099ha.m4399d(parcel, 21, this.f1015g0, false);
        C1099ha.m4408m(parcel, 22, this.f1016h0);
        C1099ha.m4414s(parcel, 23, this.f1017i0, false);
        C1099ha.m4412q(parcel, 24, this.f1018j0, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
