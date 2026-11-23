package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes.dex */
public interface zzt extends IInterface {
    /* renamed from: J */
    void mo944J(Status status) throws RemoteException;

    /* renamed from: U */
    void mo945U(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException;

    /* renamed from: y */
    void mo946y(Status status) throws RemoteException;
}
