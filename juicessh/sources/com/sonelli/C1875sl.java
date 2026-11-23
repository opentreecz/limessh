package com.sonelli;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.internal.measurement.zzda;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.sl */
/* loaded from: classes.dex */
public final class C1875sl {

    /* renamed from: a */
    public final Uri f6500a;

    /* renamed from: b */
    public final String f6501b;

    /* renamed from: c */
    public final String f6502c;

    public C1875sl(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    public C1875sl(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable zzda<Context, Boolean> zzdaVar) {
        this.f6500a = uri;
        this.f6501b = str2;
        this.f6502c = str3;
    }

    /* renamed from: a */
    public final AbstractC1559ml<Double> m8461a(String str, double d) {
        AbstractC1559ml<Double> m6451i;
        m6451i = AbstractC1559ml.m6451i(this, str, -3.0d, false);
        return m6451i;
    }

    /* renamed from: b */
    public final AbstractC1559ml<Long> m8462b(String str, long j) {
        AbstractC1559ml<Long> m6452j;
        m6452j = AbstractC1559ml.m6452j(this, str, j, false);
        return m6452j;
    }

    /* renamed from: c */
    public final AbstractC1559ml<String> m8463c(String str, String str2) {
        AbstractC1559ml<String> m6453k;
        m6453k = AbstractC1559ml.m6453k(this, str, str2, false);
        return m6453k;
    }

    /* renamed from: d */
    public final AbstractC1559ml<Boolean> m8464d(String str, boolean z) {
        AbstractC1559ml<Boolean> m6454l;
        m6454l = AbstractC1559ml.m6454l(this, str, z, false);
        return m6454l;
    }
}
