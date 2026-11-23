package com.sonelli;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.sonelli.C1848s7;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.v8 */
/* loaded from: classes.dex */
public abstract class AbstractC2158v8<T> extends AbstractC0915e8 {

    /* renamed from: a */
    public final k60<T> f7426a;

    public AbstractC2158v8(int i, k60<T> k60Var) {
        super(i);
        this.f7426a = k60Var;
    }

    @Override // com.sonelli.AbstractC1636o8
    /* renamed from: b */
    public void mo6881b(@NonNull Status status) {
        this.f7426a.m5845d(new C1029g7(status));
    }

    @Override // com.sonelli.AbstractC1636o8
    /* renamed from: d */
    public void mo6883d(@NonNull RuntimeException runtimeException) {
        this.f7426a.m5845d(runtimeException);
    }

    @Override // com.sonelli.AbstractC1636o8
    /* renamed from: f */
    public final void mo6884f(C1848s7.a<?> aVar) throws DeadObjectException {
        Status m6879a;
        Status m6879a2;
        try {
            mo9195i(aVar);
        } catch (DeadObjectException e) {
            m6879a2 = AbstractC1636o8.m6879a(e);
            mo6881b(m6879a2);
            throw e;
        } catch (RemoteException e2) {
            m6879a = AbstractC1636o8.m6879a(e2);
            mo6881b(m6879a);
        } catch (RuntimeException e3) {
            mo6883d(e3);
        }
    }

    /* renamed from: i */
    public abstract void mo9195i(C1848s7.a<?> aVar) throws RemoteException;
}
