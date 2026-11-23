package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C0758ba;
import cz.opentree.C0864d9;
import cz.opentree.C1099ha;
import cz.opentree.C1147i7;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {

    /* renamed from: O */
    public final int f732O;

    /* renamed from: P */
    public final int f733P;

    /* renamed from: Q */
    @Nullable
    public final String f734Q;

    /* renamed from: R */
    @Nullable
    public final PendingIntent f735R;

    /* renamed from: S */
    public static final Status f727S = new Status(0);

    /* renamed from: T */
    public static final Status f728T = new Status(14);

    /* renamed from: U */
    public static final Status f729U = new Status(8);

    /* renamed from: V */
    public static final Status f730V = new Status(15);

    /* renamed from: W */
    public static final Status f731W = new Status(16);
    public static final Parcelable.Creator<Status> CREATOR = new C0864d9();

    public Status(int i) {
        this(i, null);
    }

    public Status(int i, int i2, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this.f732O = i;
        this.f733P = i2;
        this.f734Q = str;
        this.f735R = pendingIntent;
    }

    public Status(int i, @Nullable String str) {
        this(1, i, str, null);
    }

    public Status(int i, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    @Nullable
    /* renamed from: K */
    public final String m994K() {
        return this.f734Q;
    }

    /* renamed from: Y */
    public final boolean m995Y() {
        return this.f735R != null;
    }

    /* renamed from: Z */
    public final boolean m996Z() {
        return this.f733P <= 0;
    }

    /* renamed from: a0 */
    public final String m997a0() {
        String str = this.f734Q;
        return str != null ? str : C1147i7.m4722a(this.f733P);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f732O == status.f732O && this.f733P == status.f733P && C0758ba.m2404a(this.f734Q, status.f734Q) && C0758ba.m2404a(this.f735R, status.f735R);
    }

    public final int hashCode() {
        return C0758ba.m2405b(Integer.valueOf(this.f732O), Integer.valueOf(this.f733P), this.f734Q, this.f735R);
    }

    @Override // com.google.android.gms.common.api.Result
    /* renamed from: n */
    public final Status mo991n() {
        return this;
    }

    public final String toString() {
        C0758ba.a m2406c = C0758ba.m2406c(this);
        m2406c.m2407a("statusCode", m997a0());
        m2406c.m2407a("resolution", this.f735R);
        return m2406c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, m998x());
        C1099ha.m4412q(parcel, 2, m994K(), false);
        C1099ha.m4411p(parcel, 3, this.f735R, i, false);
        C1099ha.m4406k(parcel, 1000, this.f732O);
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public final int m998x() {
        return this.f733P;
    }
}
