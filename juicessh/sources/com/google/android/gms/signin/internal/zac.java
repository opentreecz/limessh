package com.google.android.gms.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public interface zac extends IInterface {
    /* renamed from: C0 */
    void mo1502C0(ConnectionResult connectionResult, zab zabVar) throws RemoteException;

    /* renamed from: L */
    void mo1503L(zak zakVar) throws RemoteException;

    /* renamed from: i0 */
    void mo1504i0(Status status) throws RemoteException;

    /* renamed from: p0 */
    void mo1505p0(Status status) throws RemoteException;

    /* renamed from: u */
    void mo1506u(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException;
}
