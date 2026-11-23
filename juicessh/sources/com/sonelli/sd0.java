package com.sonelli;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.google.firebase.iid.zzj;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class sd0 {

    /* renamed from: a */
    public final Messenger f6431a;

    /* renamed from: b */
    public final zzj f6432b;

    public sd0(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f6431a = new Messenger(iBinder);
            this.f6432b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f6432b = new zzj(iBinder);
            this.f6431a = null;
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            Log.w("MessengerIpcClient", valueOf.length() != 0 ? "Invalid interface descriptor: ".concat(valueOf) : new String("Invalid interface descriptor: "));
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void m8426a(Message message) throws RemoteException {
        Messenger messenger = this.f6431a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        zzj zzjVar = this.f6432b;
        if (zzjVar == null) {
            throw new IllegalStateException("Both messengers are null");
        }
        zzjVar.m1906b(message);
    }
}
