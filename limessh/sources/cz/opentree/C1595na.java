package cz.opentree;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ISignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonConfig;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.na */
/* loaded from: classes.dex */
public final class C1595na extends C1929te implements ISignInButtonCreator {
    public C1595na(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    @Override // com.google.android.gms.common.internal.ISignInButtonCreator
    /* renamed from: b0 */
    public final IObjectWrapper mo1122b0(IObjectWrapper iObjectWrapper, SignInButtonConfig signInButtonConfig) throws RemoteException {
        Parcel m8643q = m8643q();
        C2005ue.m8872b(m8643q, iObjectWrapper);
        C2005ue.m8873c(m8643q, signInButtonConfig);
        Parcel m8644r = m8644r(2, m8643q);
        IObjectWrapper m1181r = IObjectWrapper.AbstractBinderC0446a.m1181r(m8644r.readStrongBinder());
        m8644r.recycle();
        return m1181r;
    }
}
