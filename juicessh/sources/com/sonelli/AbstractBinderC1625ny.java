package com.sonelli;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.ny */
/* loaded from: classes.dex */
public abstract class AbstractBinderC1625ny extends BinderC2357yk implements zzel {
    public AbstractBinderC1625ny() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.sonelli.BinderC2357yk
    /* renamed from: q */
    public final boolean mo6818q(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                mo1468L0((zzaq) C1557mj.m6426a(parcel, zzaq.CREATOR), (zzm) C1557mj.m6426a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                mo1475h0((zzkn) C1557mj.m6426a(parcel, zzkn.CREATOR), (zzm) C1557mj.m6426a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                mo1466G0((zzm) C1557mj.m6426a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                mo1464F((zzaq) C1557mj.m6426a(parcel, zzaq.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                mo1476o0((zzm) C1557mj.m6426a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                List<zzkn> mo1463E = mo1463E((zzm) C1557mj.m6426a(parcel, zzm.CREATOR), C1557mj.m6430e(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(mo1463E);
                return true;
            case 9:
                byte[] mo1477v = mo1477v((zzaq) C1557mj.m6426a(parcel, zzaq.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(mo1477v);
                return true;
            case 10:
                mo1473a0(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String mo1478v0 = mo1478v0((zzm) C1557mj.m6426a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(mo1478v0);
                return true;
            case 12:
                mo1467H((zzy) C1557mj.m6426a(parcel, zzy.CREATOR), (zzm) C1557mj.m6426a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                mo1471X((zzy) C1557mj.m6426a(parcel, zzy.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                List<zzkn> mo1472Y = mo1472Y(parcel.readString(), parcel.readString(), C1557mj.m6430e(parcel), (zzm) C1557mj.m6426a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(mo1472Y);
                return true;
            case 15:
                List<zzkn> mo1465G = mo1465G(parcel.readString(), parcel.readString(), parcel.readString(), C1557mj.m6430e(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(mo1465G);
                return true;
            case 16:
                List<zzy> mo1470R = mo1470R(parcel.readString(), parcel.readString(), (zzm) C1557mj.m6426a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(mo1470R);
                return true;
            case 17:
                List<zzy> mo1474c0 = mo1474c0(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(mo1474c0);
                return true;
            case 18:
                mo1469P((zzm) C1557mj.m6426a(parcel, zzm.CREATOR));
                parcel2.writeNoException();
                return true;
        }
    }
}
