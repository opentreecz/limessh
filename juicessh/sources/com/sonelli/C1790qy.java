package com.sonelli;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.internal.zzal;
import com.google.android.gms.measurement.internal.zzaq;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.qy */
/* loaded from: classes.dex */
public final class C1790qy extends p00 {

    /* renamed from: c */
    public static final AtomicReference<String[]> f6125c = new AtomicReference<>();

    /* renamed from: d */
    public static final AtomicReference<String[]> f6126d = new AtomicReference<>();

    /* renamed from: e */
    public static final AtomicReference<String[]> f6127e = new AtomicReference<>();

    public C1790qy(C2144uz c2144uz) {
        super(c2144uz);
    }

    @Nullable
    /* renamed from: y */
    public static String m7803y(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        C0813ca.m2729k(strArr);
        C0813ca.m2729k(strArr2);
        C0813ca.m2729k(atomicReference);
        C0813ca.m2719a(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (g40.m4008z0(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    @Nullable
    /* renamed from: A */
    public final String m7804A(String str) {
        if (str == null) {
            return null;
        }
        return !m7806C() ? str : m7803y(str, s00.f6312b, s00.f6311a, f6126d);
    }

    @Nullable
    /* renamed from: B */
    public final String m7805B(String str) {
        if (str == null) {
            return null;
        }
        if (!m7806C()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return m7803y(str, u00.f6881b, u00.f6880a, f6127e);
        }
        return "experiment_id(" + str + ")";
    }

    /* renamed from: C */
    public final boolean m7806C() {
        mo1480f();
        return this.f5899a.m9105K() && this.f5899a.mo1484j().m8520D(3);
    }

    @Override // com.sonelli.p00
    /* renamed from: t */
    public final boolean mo3597t() {
        return false;
    }

    @Nullable
    /* renamed from: v */
    public final String m7807v(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!m7806C()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(m7804A(str));
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            if (C1069gr.m4250b() && m7590o().m2630u(C1735pu.f5791G0)) {
                Object obj = bundle.get(str);
                sb.append(obj instanceof Bundle ? m7810z(new Object[]{obj}) : obj instanceof Object[] ? m7810z((Object[]) obj) : obj instanceof ArrayList ? m7810z(((ArrayList) obj).toArray()) : String.valueOf(obj));
            } else {
                sb.append(bundle.get(str));
            }
        }
        sb.append("}]");
        return sb.toString();
    }

    @Nullable
    /* renamed from: w */
    public final String m7808w(zzaq zzaqVar) {
        if (zzaqVar == null) {
            return null;
        }
        if (!m7806C()) {
            return zzaqVar.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(zzaqVar.f988Q);
        sb.append(",name=");
        sb.append(m7809x(zzaqVar.f986O));
        sb.append(",params=");
        zzal zzalVar = zzaqVar.f987P;
        sb.append(zzalVar != null ? !m7806C() ? zzalVar.toString() : m7807v(zzalVar.m1457Z()) : null);
        return sb.toString();
    }

    @Nullable
    /* renamed from: x */
    public final String m7809x(String str) {
        if (str == null) {
            return null;
        }
        return !m7806C() ? str : m7803y(str, t00.f6675b, t00.f6674a, f6125c);
    }

    @Nullable
    /* renamed from: z */
    public final String m7810z(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object obj : objArr) {
            String m7807v = obj instanceof Bundle ? m7807v((Bundle) obj) : String.valueOf(obj);
            if (m7807v != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(m7807v);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
