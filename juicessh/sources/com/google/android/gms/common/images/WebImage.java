package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C0758ba;
import com.sonelli.C1099ha;
import com.sonelli.C1640o9;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new C1640o9();

    /* renamed from: O */
    public final int f792O;

    /* renamed from: P */
    public final Uri f793P;

    /* renamed from: Q */
    public final int f794Q;

    /* renamed from: R */
    public final int f795R;

    public WebImage(int i, Uri uri, int i2, int i3) {
        this.f792O = i;
        this.f793P = uri;
        this.f794Q = i2;
        this.f795R = i3;
    }

    /* renamed from: K */
    public final Uri m1046K() {
        return this.f793P;
    }

    /* renamed from: Y */
    public final int m1047Y() {
        return this.f794Q;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (C0758ba.m2404a(this.f793P, webImage.f793P) && this.f794Q == webImage.f794Q && this.f795R == webImage.f795R) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return C0758ba.m2405b(this.f793P, Integer.valueOf(this.f794Q), Integer.valueOf(this.f795R));
    }

    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.f794Q), Integer.valueOf(this.f795R), this.f793P.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f792O);
        C1099ha.m4411p(parcel, 2, m1046K(), i, false);
        C1099ha.m4406k(parcel, 3, m1047Y());
        C1099ha.m4406k(parcel, 4, m1048x());
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public final int m1048x() {
        return this.f795R;
    }
}
