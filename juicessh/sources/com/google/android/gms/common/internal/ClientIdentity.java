package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C0758ba;
import cz.opentree.C1099ha;
import cz.opentree.C1203ja;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public class ClientIdentity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new C1203ja();

    /* renamed from: O */
    public final int f840O;

    /* renamed from: P */
    @Nullable
    public final String f841P;

    public ClientIdentity(int i, @Nullable String str) {
        this.f840O = i;
        this.f841P = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof ClientIdentity)) {
            ClientIdentity clientIdentity = (ClientIdentity) obj;
            if (clientIdentity.f840O == this.f840O && C0758ba.m2404a(clientIdentity.f841P, this.f841P)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f840O;
    }

    public String toString() {
        int i = this.f840O;
        String str = this.f841P;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(i);
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f840O);
        C1099ha.m4412q(parcel, 2, this.f841P, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
