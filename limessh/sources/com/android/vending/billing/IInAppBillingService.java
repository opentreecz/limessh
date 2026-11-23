package com.android.vending.billing;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IInAppBillingService extends IInterface {

    /* renamed from: com.android.vending.billing.IInAppBillingService$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0415a extends Binder implements IInAppBillingService {

        /* renamed from: com.android.vending.billing.IInAppBillingService$a$a */
        /* loaded from: classes.dex */
        public static class a implements IInAppBillingService {

            /* renamed from: b */
            public static IInAppBillingService f500b;

            /* renamed from: a */
            public IBinder f501a;

            public a(IBinder iBinder) {
                this.f501a = iBinder;
            }

            @Override // com.android.vending.billing.IInAppBillingService
            /* renamed from: M0 */
            public int mo711M0(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.f501a.transact(5, obtain, obtain2, 0) && AbstractBinderC0415a.m716r() != null) {
                        return AbstractBinderC0415a.m716r().mo711M0(i, str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            /* renamed from: V */
            public Bundle mo712V(int i, String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (!this.f501a.transact(3, obtain, obtain2, 0) && AbstractBinderC0415a.m716r() != null) {
                        return AbstractBinderC0415a.m716r().mo712V(i, str, str2, str3, str4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f501a;
            }

            @Override // com.android.vending.billing.IInAppBillingService
            /* renamed from: g0 */
            public Bundle mo713g0(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f501a.transact(2, obtain, obtain2, 0) && AbstractBinderC0415a.m716r() != null) {
                        return AbstractBinderC0415a.m716r().mo713g0(i, str, str2, bundle);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            /* renamed from: j0 */
            public Bundle mo714j0(int i, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (!this.f501a.transact(4, obtain, obtain2, 0) && AbstractBinderC0415a.m716r() != null) {
                        return AbstractBinderC0415a.m716r().mo714j0(i, str, str2, str3);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: q */
        public static IInAppBillingService m715q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IInAppBillingService)) ? new a(iBinder) : (IInAppBillingService) queryLocalInterface;
        }

        /* renamed from: r */
        public static IInAppBillingService m716r() {
            return a.f500b;
        }
    }

    /* renamed from: M0 */
    int mo711M0(int i, String str, String str2) throws RemoteException;

    /* renamed from: V */
    Bundle mo712V(int i, String str, String str2, String str3, String str4) throws RemoteException;

    /* renamed from: g0 */
    Bundle mo713g0(int i, String str, String str2, Bundle bundle) throws RemoteException;

    /* renamed from: j0 */
    Bundle mo714j0(int i, String str, String str2, String str3) throws RemoteException;
}
