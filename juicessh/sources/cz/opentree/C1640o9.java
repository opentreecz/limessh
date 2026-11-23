package cz.opentree;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.o9 */
/* loaded from: classes.dex */
public final class C1640o9 implements Parcelable.Creator<WebImage> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WebImage createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        int i = 0;
        int i2 = 0;
        Uri uri = null;
        int i3 = 0;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                i = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u == 2) {
                uri = (Uri) C1032ga.m4086n(parcel, m4062B, Uri.CREATOR);
            } else if (m4093u == 3) {
                i3 = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u != 4) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                i2 = C1032ga.m4064D(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new WebImage(i, uri, i3, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WebImage[] newArray(int i) {
        return new WebImage[i];
    }
}
