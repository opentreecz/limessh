package com.sonelli;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.IdToken;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.w4 */
/* loaded from: classes.dex */
public final class C2200w4 implements Parcelable.Creator<Credential> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Credential createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        String str = null;
        String str2 = null;
        Uri uri = null;
        ArrayList arrayList = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            switch (C1032ga.m4093u(m4062B)) {
                case 1:
                    str = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 2:
                    str2 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 3:
                    uri = (Uri) C1032ga.m4086n(parcel, m4062B, Uri.CREATOR);
                    break;
                case 4:
                    arrayList = C1032ga.m4091s(parcel, m4062B, IdToken.CREATOR);
                    break;
                case 5:
                    str3 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 6:
                    str4 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 7:
                case 8:
                default:
                    C1032ga.m4069I(parcel, m4062B);
                    break;
                case 9:
                    str5 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 10:
                    str6 = C1032ga.m4087o(parcel, m4062B);
                    break;
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new Credential(str, str2, uri, arrayList, str3, str4, str5, str6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Credential[] newArray(int i) {
        return new Credential[i];
    }
}
