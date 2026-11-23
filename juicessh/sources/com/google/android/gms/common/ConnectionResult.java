package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C0758ba;
import com.sonelli.C1099ha;
import com.sonelli.C2339yc;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public final class ConnectionResult extends AbstractSafeParcelable {

    /* renamed from: O */
    public final int f709O;

    /* renamed from: P */
    public final int f710P;

    /* renamed from: Q */
    public final PendingIntent f711Q;

    /* renamed from: R */
    public final String f712R;

    /* renamed from: S */
    public static final ConnectionResult f708S = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new C2339yc();

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    public ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f709O = i;
        this.f710P = i2;
        this.f711Q = pendingIntent;
        this.f712R = str;
    }

    public ConnectionResult(int i, @Nullable PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, @Nullable PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    /* renamed from: b0 */
    public static String m950b0(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    @Nullable
    /* renamed from: K */
    public final String m951K() {
        return this.f712R;
    }

    @Nullable
    /* renamed from: Y */
    public final PendingIntent m952Y() {
        return this.f711Q;
    }

    /* renamed from: Z */
    public final boolean m953Z() {
        return (this.f710P == 0 || this.f711Q == null) ? false : true;
    }

    /* renamed from: a0 */
    public final boolean m954a0() {
        return this.f710P == 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f710P == connectionResult.f710P && C0758ba.m2404a(this.f711Q, connectionResult.f711Q) && C0758ba.m2404a(this.f712R, connectionResult.f712R);
    }

    public final int hashCode() {
        return C0758ba.m2405b(Integer.valueOf(this.f710P), this.f711Q, this.f712R);
    }

    public final String toString() {
        C0758ba.a m2406c = C0758ba.m2406c(this);
        m2406c.m2407a("statusCode", m950b0(this.f710P));
        m2406c.m2407a("resolution", this.f711Q);
        m2406c.m2407a("message", this.f712R);
        return m2406c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f709O);
        C1099ha.m4406k(parcel, 2, m955x());
        C1099ha.m4411p(parcel, 3, m952Y(), i, false);
        C1099ha.m4412q(parcel, 4, m951K(), false);
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public final int m955x() {
        return this.f710P;
    }
}
