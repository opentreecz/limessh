package cz.opentree;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzal;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.iu */
/* loaded from: classes.dex */
public final class C1177iu {

    /* renamed from: a */
    public final String f3417a;

    /* renamed from: b */
    public final String f3418b;

    /* renamed from: c */
    public final String f3419c;

    /* renamed from: d */
    public final long f3420d;

    /* renamed from: e */
    public final long f3421e;

    /* renamed from: f */
    public final zzal f3422f;

    public C1177iu(C2144uz c2144uz, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzal zzalVar;
        C0813ca.m2725g(str2);
        C0813ca.m2725g(str3);
        this.f3417a = str2;
        this.f3418b = str3;
        this.f3419c = TextUtils.isEmpty(str) ? null : str;
        this.f3420d = j;
        this.f3421e = j2;
        if (j2 != 0 && j2 > j) {
            c2144uz.mo1484j().m8525K().m9084b("Event created with reverse previous/current timestamps. appId", C1889sy.m8516y(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzalVar = new zzal(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    c2144uz.mo1484j().m8522H().m9083a("Param name can't be null");
                    it.remove();
                } else {
                    Object m4019H = c2144uz.m9102H().m4019H(next, bundle2.get(next));
                    if (m4019H == null) {
                        c2144uz.mo1484j().m8525K().m9084b("Param value can't be null", c2144uz.m9103I().m7804A(next));
                        it.remove();
                    } else {
                        c2144uz.m9102H().m4027N(bundle2, next, m4019H);
                    }
                }
            }
            zzalVar = new zzal(bundle2);
        }
        this.f3422f = zzalVar;
    }

    public C1177iu(C2144uz c2144uz, String str, String str2, String str3, long j, long j2, zzal zzalVar) {
        C0813ca.m2725g(str2);
        C0813ca.m2725g(str3);
        C0813ca.m2729k(zzalVar);
        this.f3417a = str2;
        this.f3418b = str3;
        this.f3419c = TextUtils.isEmpty(str) ? null : str;
        this.f3420d = j;
        this.f3421e = j2;
        if (j2 != 0 && j2 > j) {
            c2144uz.mo1484j().m8525K().m9085c("Event created with reverse previous/current timestamps. appId, name", C1889sy.m8516y(str2), C1889sy.m8516y(str3));
        }
        this.f3422f = zzalVar;
    }

    /* renamed from: a */
    public final C1177iu m4926a(C2144uz c2144uz, long j) {
        return new C1177iu(c2144uz, this.f3419c, this.f3417a, this.f3418b, this.f3420d, j, this.f3422f);
    }

    public final String toString() {
        String str = this.f3417a;
        String str2 = this.f3418b;
        String valueOf = String.valueOf(this.f3422f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }
}
