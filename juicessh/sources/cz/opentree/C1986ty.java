package cz.opentree;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.measurement.internal.zzel;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.ty */
/* loaded from: classes.dex */
public final class C1986ty extends BaseGmsClient<zzel> {
    public C1986ty(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(context, looper, 93, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @NonNull
    /* renamed from: i */
    public final String mo1085i() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: j */
    public final /* synthetic */ zzel mo1086j(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return queryLocalInterface instanceof zzel ? (zzel) queryLocalInterface : new C1578my(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    /* renamed from: l */
    public final int mo972l() {
        return C0810c7.f1875a;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @NonNull
    /* renamed from: o */
    public final String mo1089o() {
        return "com.google.android.gms.measurement.START";
    }
}
