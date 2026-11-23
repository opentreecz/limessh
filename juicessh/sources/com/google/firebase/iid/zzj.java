package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.sonelli.hf0;
import com.sonelli.ve0;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public class zzj implements Parcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new ve0();

    /* renamed from: O */
    public Messenger f1280O;

    /* renamed from: P */
    public zzx f1281P;

    /* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
    /* renamed from: com.google.firebase.iid.zzj$a */
    /* loaded from: classes.dex */
    public static final class C0667a extends ClassLoader {
        @Override // java.lang.ClassLoader
        public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z);
            }
            if (!FirebaseInstanceId.m1873v()) {
                return zzj.class;
            }
            Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
            return zzj.class;
        }
    }

    public zzj(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1280O = new Messenger(iBinder);
        } else {
            this.f1281P = new hf0(iBinder);
        }
    }

    /* renamed from: a */
    public final IBinder m1905a() {
        Messenger messenger = this.f1280O;
        return messenger != null ? messenger.getBinder() : this.f1281P.asBinder();
    }

    /* renamed from: b */
    public final void m1906b(Message message) throws RemoteException {
        Messenger messenger = this.f1280O;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f1281P.mo1907D0(message);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return m1905a().equals(((zzj) obj).m1905a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return m1905a().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.f1280O;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.f1281P.asBinder());
        }
    }
}
