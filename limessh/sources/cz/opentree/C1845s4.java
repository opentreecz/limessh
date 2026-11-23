package cz.opentree;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.accounttransfer.zzo;
import java.util.ArrayList;

/* renamed from: cz.opentree.s4 */
/* loaded from: classes.dex */
public final class C1845s4 implements Parcelable.Creator<zzo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        ArrayList<String> arrayList = null;
        ArrayList<String> arrayList2 = null;
        ArrayList<String> arrayList3 = null;
        ArrayList<String> arrayList4 = null;
        ArrayList<String> arrayList5 = null;
        int i = 0;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            switch (C1032ga.m4093u(m4062B)) {
                case 1:
                    i = C1032ga.m4064D(parcel, m4062B);
                    break;
                case 2:
                    arrayList = C1032ga.m4089q(parcel, m4062B);
                    break;
                case 3:
                    arrayList2 = C1032ga.m4089q(parcel, m4062B);
                    break;
                case 4:
                    arrayList3 = C1032ga.m4089q(parcel, m4062B);
                    break;
                case 5:
                    arrayList4 = C1032ga.m4089q(parcel, m4062B);
                    break;
                case 6:
                    arrayList5 = C1032ga.m4089q(parcel, m4062B);
                    break;
                default:
                    C1032ga.m4069I(parcel, m4062B);
                    break;
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new zzo(i, arrayList, arrayList2, arrayList3, arrayList4, arrayList5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzo[] newArray(int i) {
        return new zzo[i];
    }
}
