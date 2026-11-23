package cz.opentree;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.TokenData;
import java.util.ArrayList;

/* renamed from: cz.opentree.u6 */
/* loaded from: classes.dex */
public final class C1995u6 implements Parcelable.Creator<TokenData> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TokenData createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        String str = null;
        Long l = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            switch (C1032ga.m4093u(m4062B)) {
                case 1:
                    i = C1032ga.m4064D(parcel, m4062B);
                    break;
                case 2:
                    str = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 3:
                    l = C1032ga.m4067G(parcel, m4062B);
                    break;
                case 4:
                    z = C1032ga.m4094v(parcel, m4062B);
                    break;
                case 5:
                    z2 = C1032ga.m4094v(parcel, m4062B);
                    break;
                case 6:
                    arrayList = C1032ga.m4089q(parcel, m4062B);
                    break;
                case 7:
                    str2 = C1032ga.m4087o(parcel, m4062B);
                    break;
                default:
                    C1032ga.m4069I(parcel, m4062B);
                    break;
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new TokenData(i, str, l, z, z2, arrayList, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ TokenData[] newArray(int i) {
        return new TokenData[i];
    }
}
