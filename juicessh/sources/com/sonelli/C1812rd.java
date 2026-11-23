package com.sonelli;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.rd */
/* loaded from: classes.dex */
public final class C1812rd implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    /* renamed from: a */
    public final DynamiteModule.VersionPolicy.C0447a mo1195a(Context context, String str, DynamiteModule.VersionPolicy.zzb zzbVar) throws DynamiteModule.C0448a {
        DynamiteModule.VersionPolicy.C0447a c0447a = new DynamiteModule.VersionPolicy.C0447a();
        c0447a.f942a = zzbVar.mo1196a(context, str);
        int mo1197b = zzbVar.mo1197b(context, str, true);
        c0447a.f943b = mo1197b;
        int i = c0447a.f942a;
        if (i == 0 && mo1197b == 0) {
            c0447a.f944c = 0;
        } else if (mo1197b >= i) {
            c0447a.f944c = 1;
        } else {
            c0447a.f944c = -1;
        }
        return c0447a;
    }
}
