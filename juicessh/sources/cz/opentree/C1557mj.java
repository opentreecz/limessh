package cz.opentree;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.mj */
/* loaded from: classes.dex */
public class C1557mj {

    /* renamed from: a */
    public static final ClassLoader f5083a = C1557mj.class.getClassLoader();

    /* renamed from: a */
    public static <T extends Parcelable> T m6426a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    /* renamed from: b */
    public static void m6427b(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }

    /* renamed from: c */
    public static void m6428c(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    /* renamed from: d */
    public static void m6429d(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    /* renamed from: e */
    public static boolean m6430e(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    /* renamed from: f */
    public static HashMap m6431f(Parcel parcel) {
        return parcel.readHashMap(f5083a);
    }
}
