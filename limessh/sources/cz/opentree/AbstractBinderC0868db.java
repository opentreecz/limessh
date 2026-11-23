package cz.opentree;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.zzn;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.db */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0868db extends BinderC2274xe implements zzn {
    /* renamed from: r */
    public static zzn m3181r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        return queryLocalInterface instanceof zzn ? (zzn) queryLocalInterface : new C0920eb(iBinder);
    }
}
