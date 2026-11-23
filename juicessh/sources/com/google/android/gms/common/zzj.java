package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.sonelli.AbstractBinderC0763bd;
import com.sonelli.AbstractBinderC0816cb;
import com.sonelli.BinderC0922ed;
import com.sonelli.BinderC1548md;
import com.sonelli.C1099ha;
import com.sonelli.C1208jd;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new C1208jd();

    /* renamed from: O */
    public final String f927O;

    /* renamed from: P */
    @Nullable
    public final AbstractBinderC0763bd f928P;

    /* renamed from: Q */
    public final boolean f929Q;

    /* renamed from: R */
    public final boolean f930R;

    public zzj(String str, @Nullable IBinder iBinder, boolean z, boolean z2) {
        this.f927O = str;
        this.f928P = m1180x(iBinder);
        this.f929Q = z;
        this.f930R = z2;
    }

    public zzj(String str, @Nullable AbstractBinderC0763bd abstractBinderC0763bd, boolean z, boolean z2) {
        this.f927O = str;
        this.f928P = abstractBinderC0763bd;
        this.f929Q = z;
        this.f930R = z2;
    }

    @Nullable
    /* renamed from: x */
    public static AbstractBinderC0763bd m1180x(@Nullable IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper mo1139b = AbstractBinderC0816cb.m2747r(iBinder).mo1139b();
            byte[] bArr = mo1139b == null ? null : (byte[]) BinderC1548md.m6403s(mo1139b);
            if (bArr != null) {
                return new BinderC0922ed(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (RemoteException e) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4412q(parcel, 1, this.f927O, false);
        AbstractBinderC0763bd abstractBinderC0763bd = this.f928P;
        if (abstractBinderC0763bd == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            abstractBinderC0763bd = null;
        } else {
            abstractBinderC0763bd.asBinder();
        }
        C1099ha.m4405j(parcel, 2, abstractBinderC0763bd, false);
        C1099ha.m4398c(parcel, 3, this.f929Q);
        C1099ha.m4398c(parcel, 4, this.f930R);
        C1099ha.m4397b(parcel, m4396a);
    }
}
