package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import cz.opentree.C2001ua;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
@KeepName
/* loaded from: classes.dex */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new C2001ua();

    /* renamed from: O */
    public IBinder f839O;

    public BinderWrapper() {
        this.f839O = null;
    }

    public BinderWrapper(Parcel parcel) {
        this.f839O = null;
        this.f839O = parcel.readStrongBinder();
    }

    public /* synthetic */ BinderWrapper(Parcel parcel, C2001ua c2001ua) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f839O);
    }
}
