package com.sonelli;

import android.os.Binder;
import com.google.android.gms.internal.measurement.zzci;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.fl */
/* loaded from: classes.dex */
public final /* synthetic */ class C0996fl {
    /* renamed from: a */
    public static <V> V m3779a(zzci<V> zzciVar) {
        try {
            return zzciVar.mo1221a();
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzciVar.mo1221a();
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }
}
