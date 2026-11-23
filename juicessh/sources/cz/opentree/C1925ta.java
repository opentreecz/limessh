package cz.opentree;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonConfig;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.ta */
/* loaded from: classes.dex */
public final class C1925ta implements Parcelable.Creator<SignInButtonConfig> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInButtonConfig createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        int i = 0;
        int i2 = 0;
        Scope[] scopeArr = null;
        int i3 = 0;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                i = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u == 2) {
                i3 = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u == 3) {
                i2 = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u != 4) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                scopeArr = (Scope[]) C1032ga.m4090r(parcel, m4062B, Scope.CREATOR);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new SignInButtonConfig(i, i3, i2, scopeArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInButtonConfig[] newArray(int i) {
        return new SignInButtonConfig[i];
    }
}
