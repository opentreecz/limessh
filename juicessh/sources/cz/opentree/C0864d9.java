package cz.opentree;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.d9 */
/* loaded from: classes.dex */
public final class C0864d9 implements Parcelable.Creator<Status> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                i2 = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u == 2) {
                str = C1032ga.m4087o(parcel, m4062B);
            } else if (m4093u == 3) {
                pendingIntent = (PendingIntent) C1032ga.m4086n(parcel, m4062B, PendingIntent.CREATOR);
            } else if (m4093u != 1000) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                i = C1032ga.m4064D(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new Status(i, i2, str, pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i) {
        return new Status[i];
    }
}
