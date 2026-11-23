package com.sonelli;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.ol */
/* loaded from: classes.dex */
public final class C1662ol extends AbstractC1559ml<Long> {
    public C1662ol(C1875sl c1875sl, String str, Long l, boolean z) {
        super(c1875sl, str, l, z, null);
    }

    @Override // com.sonelli.AbstractC1559ml
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final Long mo6456e(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String m6458m = super.m6458m();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(m6458m).length() + 25 + String.valueOf(valueOf).length());
        sb.append("Invalid long value for ");
        sb.append(m6458m);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
