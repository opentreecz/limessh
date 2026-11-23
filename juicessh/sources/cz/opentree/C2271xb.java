package cz.opentree;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.xb */
/* loaded from: classes.dex */
public final class C2271xb implements Parcelable.Creator<WakeLockEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        float f = 0.0f;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            switch (C1032ga.m4093u(m4062B)) {
                case 1:
                    i = C1032ga.m4064D(parcel, m4062B);
                    break;
                case 2:
                    j = C1032ga.m4066F(parcel, m4062B);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    C1032ga.m4069I(parcel, m4062B);
                    break;
                case 4:
                    str = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 5:
                    i3 = C1032ga.m4064D(parcel, m4062B);
                    break;
                case 6:
                    arrayList = C1032ga.m4089q(parcel, m4062B);
                    break;
                case 8:
                    j2 = C1032ga.m4066F(parcel, m4062B);
                    break;
                case 10:
                    str3 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 11:
                    i2 = C1032ga.m4064D(parcel, m4062B);
                    break;
                case 12:
                    str2 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 13:
                    str4 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 14:
                    i4 = C1032ga.m4064D(parcel, m4062B);
                    break;
                case 15:
                    f = C1032ga.m4098z(parcel, m4062B);
                    break;
                case 16:
                    j3 = C1032ga.m4066F(parcel, m4062B);
                    break;
                case 17:
                    str5 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 18:
                    z = C1032ga.m4094v(parcel, m4062B);
                    break;
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new WakeLockEvent(i, j, i2, str, i3, arrayList, str2, j2, i4, str3, str4, f, j3, str5, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
