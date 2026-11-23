package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import cz.opentree.BinderC2274xe;
import cz.opentree.C2341ye;
import cz.opentree.C2423ze;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public interface IAccountAccessor extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.common.internal.IAccountAccessor$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0444a extends BinderC2274xe implements IAccountAccessor {

        /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
        /* renamed from: com.google.android.gms.common.internal.IAccountAccessor$a$a */
        /* loaded from: classes.dex */
        public static class a extends C2341ye implements IAccountAccessor {
            public a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // com.google.android.gms.common.internal.IAccountAccessor
            /* renamed from: p */
            public final Account mo1118p() throws RemoteException {
                Parcel m10126r = m10126r(2, m10125q());
                Account account = (Account) C2423ze.m10429b(m10126r, Account.CREATOR);
                m10126r.recycle();
                return account;
            }
        }

        /* renamed from: r */
        public static IAccountAccessor m1119r(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return queryLocalInterface instanceof IAccountAccessor ? (IAccountAccessor) queryLocalInterface : new a(iBinder);
        }
    }

    /* renamed from: p */
    Account mo1118p() throws RemoteException;
}
