package com.sonelli;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.common.internal.ISignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonConfig;
import com.sonelli.AbstractC1600nd;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.da */
/* loaded from: classes.dex */
public final class C0865da extends AbstractC1600nd<ISignInButtonCreator> {

    /* renamed from: c */
    public static final C0865da f2144c = new C0865da();

    public C0865da() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    /* renamed from: c */
    public static View m3167c(Context context, int i, int i2) throws AbstractC1600nd.a {
        return f2144c.m3170e(context, i, i2);
    }

    @Override // com.sonelli.AbstractC1600nd
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final ISignInButtonCreator mo3168a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return queryLocalInterface instanceof ISignInButtonCreator ? (ISignInButtonCreator) queryLocalInterface : new C1595na(iBinder);
    }

    /* renamed from: e */
    public final View m3170e(Context context, int i, int i2) throws AbstractC1600nd.a {
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i, i2, null);
            return (View) BinderC1548md.m6403s(m6664b(context).mo1122b0(BinderC1548md.m6402O0(context), signInButtonConfig));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("Could not get button with size ");
            sb.append(i);
            sb.append(" and color ");
            sb.append(i2);
            throw new AbstractC1600nd.a(sb.toString(), e);
        }
    }
}
