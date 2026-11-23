package com.sonelli;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.j6 */
/* loaded from: classes.dex */
public final class C1198j6 implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        int i = 0;
        long j = 0;
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
                    str2 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 4:
                    str3 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 5:
                    str4 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 6:
                    uri = (Uri) C1032ga.m4086n(parcel, m4062B, Uri.CREATOR);
                    break;
                case 7:
                    str5 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 8:
                    j = C1032ga.m4066F(parcel, m4062B);
                    break;
                case 9:
                    str6 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 10:
                    arrayList = C1032ga.m4091s(parcel, m4062B, Scope.CREATOR);
                    break;
                case 11:
                    str7 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 12:
                    str8 = C1032ga.m4087o(parcel, m4062B);
                    break;
                default:
                    C1032ga.m4069I(parcel, m4062B);
                    break;
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, arrayList, str7, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
