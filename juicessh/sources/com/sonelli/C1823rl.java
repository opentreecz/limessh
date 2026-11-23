package com.sonelli;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.rl */
/* loaded from: classes.dex */
public final class C1823rl extends AbstractC1559ml<Boolean> {
    public C1823rl(C1875sl c1875sl, String str, Boolean bool, boolean z) {
        super(c1875sl, str, bool, z, null);
    }

    @Override // com.sonelli.AbstractC1559ml
    /* renamed from: e */
    public final /* synthetic */ Boolean mo6456e(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (C0719al.f1436c.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (C0719al.f1437d.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String m6458m = super.m6458m();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(m6458m).length() + 28 + String.valueOf(valueOf).length());
        sb.append("Invalid boolean value for ");
        sb.append(m6458m);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
