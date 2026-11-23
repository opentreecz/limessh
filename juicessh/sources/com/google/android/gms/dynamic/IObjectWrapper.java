package com.google.android.gms.dynamic;

import android.os.IBinder;
import android.os.IInterface;
import com.sonelli.BinderC2274xe;
import com.sonelli.C2341ye;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public interface IObjectWrapper extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.dynamic.IObjectWrapper$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0446a extends BinderC2274xe implements IObjectWrapper {

        /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
        /* renamed from: com.google.android.gms.dynamic.IObjectWrapper$a$a */
        /* loaded from: classes.dex */
        public static class a extends C2341ye implements IObjectWrapper {
            public a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public AbstractBinderC0446a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        /* renamed from: r */
        public static IObjectWrapper m1181r(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return queryLocalInterface instanceof IObjectWrapper ? (IObjectWrapper) queryLocalInterface : new a(iBinder);
        }
    }
}
