package com.sonelli;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.r7 */
/* loaded from: classes.dex */
public abstract class AbstractC1802r7<R extends Result, A extends Api.AnyClient> extends BasePendingResult<R> implements BaseImplementation$ResultHolder<R> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC1802r7(@NonNull Api<?> api, @NonNull GoogleApiClient googleApiClient) {
        super(googleApiClient);
        C0813ca.m2730l(googleApiClient, "GoogleApiClient must not be null");
        C0813ca.m2730l(api, "Api must not be null");
        api.m960a();
    }

    /* renamed from: n */
    public abstract void mo7883n(@NonNull A a) throws RemoteException;

    /* renamed from: o */
    public void m7884o(@NonNull R r) {
    }

    /* renamed from: p */
    public final void m7885p(@NonNull A a) throws DeadObjectException {
        if (a instanceof C0917ea) {
            a = ((C0917ea) a).m3460k0();
        }
        try {
            mo7883n(a);
        } catch (DeadObjectException e) {
            m7886q(e);
            throw e;
        } catch (RemoteException e2) {
            m7886q(e2);
        }
    }

    /* renamed from: q */
    public final void m7886q(@NonNull RemoteException remoteException) {
        m7887r(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    /* renamed from: r */
    public final void m7887r(@NonNull Status status) {
        C0813ca.m2720b(!status.m996Z(), "Failed result must not be success");
        R mo1010c = mo1010c(status);
        m1013f(mo1010c);
        m7884o(mo1010c);
    }
}
