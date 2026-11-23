package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C1099ha;
import cz.opentree.C2324y4;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes.dex */
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new C2324y4();

    /* renamed from: O */
    public final int f598O;

    /* renamed from: P */
    public final boolean f599P;

    /* renamed from: Q */
    public final boolean f600Q;

    /* renamed from: R */
    public final int f601R;

    /* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
    /* renamed from: com.google.android.gms.auth.api.credentials.CredentialPickerConfig$a */
    /* loaded from: classes.dex */
    public static class C0423a {

        /* renamed from: a */
        public boolean f602a = false;

        /* renamed from: b */
        public boolean f603b = true;

        /* renamed from: c */
        public int f604c = 1;

        /* renamed from: a */
        public CredentialPickerConfig m857a() {
            return new CredentialPickerConfig(this);
        }
    }

    public CredentialPickerConfig(int i, boolean z, boolean z2, boolean z3, int i2) {
        this.f598O = i;
        this.f599P = z;
        this.f600Q = z2;
        if (i < 2) {
            this.f601R = z3 ? 3 : 1;
        } else {
            this.f601R = i2;
        }
    }

    public CredentialPickerConfig(C0423a c0423a) {
        this(2, c0423a.f602a, c0423a.f603b, false, c0423a.f604c);
    }

    /* renamed from: K */
    public final boolean m851K() {
        return this.f599P;
    }

    /* renamed from: Y */
    public final boolean m852Y() {
        return this.f600Q;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4398c(parcel, 1, m851K());
        C1099ha.m4398c(parcel, 2, m852Y());
        C1099ha.m4398c(parcel, 3, m853x());
        C1099ha.m4406k(parcel, 4, this.f601R);
        C1099ha.m4406k(parcel, 1000, this.f598O);
        C1099ha.m4397b(parcel, m4396a);
    }

    @Deprecated
    /* renamed from: x */
    public final boolean m853x() {
        return this.f601R == 3;
    }
}
