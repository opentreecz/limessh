package com.sonelli;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.ql */
/* loaded from: classes.dex */
public final class C1774ql extends AbstractC1559ml<Double> {
    public C1774ql(C1875sl c1875sl, String str, Double d, boolean z) {
        super(c1875sl, str, d, z, null);
    }

    @Override // com.sonelli.AbstractC1559ml
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final Double mo6456e(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String m6458m = super.m6458m();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(m6458m).length() + 27 + String.valueOf(valueOf).length());
        sb.append("Invalid double value for ");
        sb.append(m6458m);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
