package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes.dex */
    public interface Types {
    }

    /* renamed from: K */
    public abstract long mo1173K();

    /* renamed from: Y */
    public abstract long mo1174Y();

    /* renamed from: Z */
    public abstract String mo1175Z();

    public String toString() {
        long mo1173K = mo1173K();
        int mo1176x = mo1176x();
        long mo1174Y = mo1174Y();
        String mo1175Z = mo1175Z();
        StringBuilder sb = new StringBuilder(String.valueOf(mo1175Z).length() + 53);
        sb.append(mo1173K);
        sb.append("\t");
        sb.append(mo1176x);
        sb.append("\t");
        sb.append(mo1174Y);
        sb.append(mo1175Z);
        return sb.toString();
    }

    /* renamed from: x */
    public abstract int mo1176x();
}
