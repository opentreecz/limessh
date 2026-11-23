package cz.opentree;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.l6 */
/* loaded from: classes.dex */
public final class C1491l6 implements Parcelable.Creator<GoogleSignInOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        ArrayList arrayList = null;
        Account account = null;
        String str = null;
        String str2 = null;
        ArrayList arrayList2 = null;
        String str3 = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            switch (C1032ga.m4093u(m4062B)) {
                case 1:
                    i = C1032ga.m4064D(parcel, m4062B);
                    break;
                case 2:
                    arrayList = C1032ga.m4091s(parcel, m4062B, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) C1032ga.m4086n(parcel, m4062B, Account.CREATOR);
                    break;
                case 4:
                    z = C1032ga.m4094v(parcel, m4062B);
                    break;
                case 5:
                    z2 = C1032ga.m4094v(parcel, m4062B);
                    break;
                case 6:
                    z3 = C1032ga.m4094v(parcel, m4062B);
                    break;
                case 7:
                    str = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 8:
                    str2 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 9:
                    arrayList2 = C1032ga.m4091s(parcel, m4062B, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case 10:
                    str3 = C1032ga.m4087o(parcel, m4062B);
                    break;
                default:
                    C1032ga.m4069I(parcel, m4062B);
                    break;
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new GoogleSignInOptions(i, (ArrayList<Scope>) arrayList, account, z, z2, z3, str, str2, (ArrayList<GoogleSignInOptionsExtensionParcelable>) arrayList2, str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
