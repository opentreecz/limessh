package cz.opentree;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzkn;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class f40 implements Parcelable.Creator<zzkn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzkn createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        String str = null;
        Long l = null;
        Float f = null;
        String str2 = null;
        String str3 = null;
        Double d = null;
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
                    j = C1032ga.m4066F(parcel, m4062B);
                    break;
                case 4:
                    l = C1032ga.m4067G(parcel, m4062B);
                    break;
                case 5:
                    f = C1032ga.m4061A(parcel, m4062B);
                    break;
                case 6:
                    str2 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 7:
                    str3 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 8:
                    d = C1032ga.m4097y(parcel, m4062B);
                    break;
                default:
                    C1032ga.m4069I(parcel, m4062B);
                    break;
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new zzkn(i, str, j, l, f, str2, str3, d);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzkn[] newArray(int i) {
        return new zzkn[i];
    }
}
