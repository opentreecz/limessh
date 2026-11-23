package cz.opentree;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import cz.opentree.C1848s7;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.o8 */
/* loaded from: classes.dex */
public abstract class AbstractC1636o8 {
    public AbstractC1636o8(int i) {
    }

    /* renamed from: a */
    public static Status m6879a(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (C1501lc.m6142b() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    /* renamed from: b */
    public abstract void mo6881b(@NonNull Status status);

    /* renamed from: c */
    public abstract void mo6882c(@NonNull C0702a9 c0702a9, boolean z);

    /* renamed from: d */
    public abstract void mo6883d(@NonNull RuntimeException runtimeException);

    /* renamed from: f */
    public abstract void mo6884f(C1848s7.a<?> aVar) throws DeadObjectException;
}
