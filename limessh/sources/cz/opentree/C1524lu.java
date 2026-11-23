package cz.opentree;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.lu */
/* loaded from: classes.dex */
public final class C1524lu implements Parcelable.Creator<zzal> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            if (C1032ga.m4093u(m4062B) != 2) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                bundle = C1032ga.m4078f(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new zzal(bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal[] newArray(int i) {
        return new zzal[i];
    }
}
