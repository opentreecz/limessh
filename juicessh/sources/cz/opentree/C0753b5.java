package cz.opentree;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.IdToken;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: cz.opentree.b5 */
/* loaded from: classes.dex */
public final class C0753b5 implements Parcelable.Creator<IdToken> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ IdToken createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                str = C1032ga.m4087o(parcel, m4062B);
            } else if (m4093u != 2) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                str2 = C1032ga.m4087o(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new IdToken(str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ IdToken[] newArray(int i) {
        return new IdToken[i];
    }
}
