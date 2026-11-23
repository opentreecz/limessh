package cz.opentree;

import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzhl;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.fp */
/* loaded from: classes.dex */
public final class C1007fp {

    /* renamed from: c */
    public static final C1007fp f2752c = new C1007fp();

    /* renamed from: b */
    public final ConcurrentMap<Class<?>, zzhi<?>> f2754b = new ConcurrentHashMap();

    /* renamed from: a */
    public final zzhl f2753a = new C1728po();

    /* renamed from: a */
    public static C1007fp m3851a() {
        return f2752c;
    }

    /* renamed from: b */
    public final <T> zzhi<T> m3852b(Class<T> cls) {
        C2435zn.m10540f(cls, "messageType");
        zzhi<T> zzhiVar = (zzhi) this.f2754b.get(cls);
        if (zzhiVar != null) {
            return zzhiVar;
        }
        zzhi<T> mo1281a = this.f2753a.mo1281a(cls);
        C2435zn.m10540f(cls, "messageType");
        C2435zn.m10540f(mo1281a, "schema");
        zzhi<T> zzhiVar2 = (zzhi) this.f2754b.putIfAbsent(cls, mo1281a);
        return zzhiVar2 != null ? zzhiVar2 : mo1281a;
    }

    /* renamed from: c */
    public final <T> zzhi<T> m3853c(T t) {
        return m3852b(t.getClass());
    }
}
