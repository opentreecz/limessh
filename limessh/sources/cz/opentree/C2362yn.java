package cz.opentree;

import com.google.android.gms.internal.measurement.zzgq;
import com.google.android.gms.internal.measurement.zzgr;
import cz.opentree.AbstractC2303xn;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.yn */
/* loaded from: classes.dex */
public final class C2362yn implements zzgq {

    /* renamed from: a */
    public static final C2362yn f8283a = new C2362yn();

    /* renamed from: c */
    public static C2362yn m10194c() {
        return f8283a;
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    /* renamed from: a */
    public final boolean mo1253a(Class<?> cls) {
        return AbstractC2303xn.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    /* renamed from: b */
    public final zzgr mo1254b(Class<?> cls) {
        if (!AbstractC2303xn.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzgr) AbstractC2303xn.m9832o(cls.asSubclass(AbstractC2303xn.class)).mo2132s(AbstractC2303xn.e.f8026c, null, null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
