package cz.opentree;

import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzgt;
import com.google.android.gms.internal.measurement.zzhb;
import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzix;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.ap */
/* loaded from: classes.dex */
public final class C0732ap<T> implements zzhi<T> {

    /* renamed from: q */
    public static final int[] f1483q = new int[0];

    /* renamed from: r */
    public static final Unsafe f1484r = C0841cq.m2936t();

    /* renamed from: a */
    public final int[] f1485a;

    /* renamed from: b */
    public final Object[] f1486b;

    /* renamed from: c */
    public final int f1487c;

    /* renamed from: d */
    public final int f1488d;

    /* renamed from: e */
    public final zzgt f1489e;

    /* renamed from: f */
    public final boolean f1490f;

    /* renamed from: g */
    public final boolean f1491g;

    /* renamed from: h */
    public final boolean f1492h;

    /* renamed from: i */
    public final int[] f1493i;

    /* renamed from: j */
    public final int f1494j;

    /* renamed from: k */
    public final int f1495k;

    /* renamed from: l */
    public final zzhb f1496l;

    /* renamed from: m */
    public final AbstractC1563mo f1497m;

    /* renamed from: n */
    public final AbstractC2238wp<?, ?> f1498n;

    /* renamed from: o */
    public final AbstractC1562mn<?> f1499o;

    /* renamed from: p */
    public final zzgm f1500p;

    public C0732ap(int[] iArr, Object[] objArr, int i, int i2, zzgt zzgtVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzhb zzhbVar, AbstractC1563mo abstractC1563mo, AbstractC2238wp<?, ?> abstractC2238wp, AbstractC1562mn<?> abstractC1562mn, zzgm zzgmVar) {
        this.f1485a = iArr;
        this.f1486b = objArr;
        this.f1487c = i;
        this.f1488d = i2;
        boolean z3 = zzgtVar instanceof AbstractC2303xn;
        this.f1491g = z;
        this.f1490f = abstractC1562mn != null && abstractC1562mn.mo6480e(zzgtVar);
        this.f1492h = false;
        this.f1493i = iArr2;
        this.f1494j = i3;
        this.f1495k = i4;
        this.f1496l = zzhbVar;
        this.f1497m = abstractC1563mo;
        this.f1498n = abstractC2238wp;
        this.f1499o = abstractC1562mn;
        this.f1489e = zzgtVar;
        this.f1500p = zzgmVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: D */
    public static boolean m2192D(Object obj, int i, zzhi zzhiVar) {
        return zzhiVar.mo1274c(C0841cq.m2907F(obj, i & 1048575));
    }

    /* renamed from: E */
    public static <T> double m2193E(T t, long j) {
        return ((Double) C0841cq.m2907F(t, j)).doubleValue();
    }

    /* renamed from: L */
    public static <T> float m2194L(T t, long j) {
        return ((Float) C0841cq.m2907F(t, j)).floatValue();
    }

    /* renamed from: P */
    public static <T> int m2195P(T t, long j) {
        return ((Integer) C0841cq.m2907F(t, j)).intValue();
    }

    /* renamed from: R */
    public static <T> long m2196R(T t, long j) {
        return ((Long) C0841cq.m2907F(t, j)).longValue();
    }

    /* renamed from: S */
    public static C2437zp m2197S(Object obj) {
        AbstractC2303xn abstractC2303xn = (AbstractC2303xn) obj;
        C2437zp c2437zp = abstractC2303xn.zzb;
        if (c2437zp != C2437zp.m10576a()) {
            return c2437zp;
        }
        C2437zp m10579g = C2437zp.m10579g();
        abstractC2303xn.zzb = m10579g;
        return m10579g;
    }

    /* renamed from: T */
    public static <T> boolean m2198T(T t, long j) {
        return ((Boolean) C0841cq.m2907F(t, j)).booleanValue();
    }

    /* renamed from: k */
    public static <UT, UB> int m2199k(AbstractC2238wp<UT, UB> abstractC2238wp, T t) {
        return abstractC2238wp.mo9620l(abstractC2238wp.mo9614f(t));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    /* renamed from: p */
    public static int m2200p(byte[] bArr, int i, int i2, EnumC1616nq enumC1616nq, Class<?> cls, C1876sm c1876sm) throws IOException {
        switch (C2436zo.f8570a[enumC1616nq.ordinal()]) {
            case 1:
                int m7402k = C1725pm.m7402k(bArr, i, c1876sm);
                c1876sm.f6513c = Boolean.valueOf(c1876sm.f6512b != 0);
                return m7402k;
            case 2:
                return C1725pm.m7408q(bArr, i, c1876sm);
            case 3:
                c1876sm.f6513c = Double.valueOf(C1725pm.m7404m(bArr, i));
                return i + 8;
            case 4:
            case 5:
                c1876sm.f6513c = Integer.valueOf(C1725pm.m7399h(bArr, i));
                return i + 4;
            case 6:
            case 7:
                c1876sm.f6513c = Long.valueOf(C1725pm.m7403l(bArr, i));
                return i + 8;
            case 8:
                c1876sm.f6513c = Float.valueOf(C1725pm.m7406o(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int m7400i = C1725pm.m7400i(bArr, i, c1876sm);
                c1876sm.f6513c = Integer.valueOf(c1876sm.f6511a);
                return m7400i;
            case 12:
            case 13:
                int m7402k2 = C1725pm.m7402k(bArr, i, c1876sm);
                c1876sm.f6513c = Long.valueOf(c1876sm.f6512b);
                return m7402k2;
            case 14:
                return C1725pm.m7398g(C1007fp.m3851a().m3852b(cls), bArr, i, i2, c1876sm);
            case 15:
                int m7400i2 = C1725pm.m7400i(bArr, i, c1876sm);
                c1876sm.f6513c = Integer.valueOf(AbstractC0838cn.m2884d(c1876sm.f6511a));
                return m7400i2;
            case 16:
                int m7402k3 = C1725pm.m7402k(bArr, i, c1876sm);
                c1876sm.f6513c = Long.valueOf(AbstractC0838cn.m2882a(c1876sm.f6512b));
                return m7402k3;
            case 17:
                return C1725pm.m7407p(bArr, i, c1876sm);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0397  */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> cz.opentree.C0732ap<T> m2201q(java.lang.Class<T> r33, com.google.android.gms.internal.measurement.zzgr r34, com.google.android.gms.internal.measurement.zzhb r35, cz.opentree.AbstractC1563mo r36, cz.opentree.AbstractC2238wp<?, ?> r37, cz.opentree.AbstractC1562mn<?> r38, com.google.android.gms.internal.measurement.zzgm r39) {
        /*
            Method dump skipped, instructions count: 1039
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0732ap.m2201q(java.lang.Class, com.google.android.gms.internal.measurement.zzgr, com.google.android.gms.internal.measurement.zzhb, cz.opentree.mo, cz.opentree.wp, cz.opentree.mn, com.google.android.gms.internal.measurement.zzgm):cz.opentree.ap");
    }

    /* renamed from: u */
    public static Field m2202u(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    /* renamed from: v */
    public static List<?> m2203v(Object obj, long j) {
        return (List) C0841cq.m2907F(obj, j);
    }

    /* renamed from: w */
    public static void m2204w(int i, Object obj, zzix zzixVar) throws IOException {
        if (obj instanceof String) {
            zzixVar.mo1318t(i, (String) obj);
        } else {
            zzixVar.mo1286C(i, (AbstractC1939tm) obj);
        }
    }

    /* renamed from: x */
    public static <UT, UB> void m2205x(AbstractC2238wp<UT, UB> abstractC2238wp, T t, zzix zzixVar) throws IOException {
        abstractC2238wp.mo9612d(abstractC2238wp.mo9614f(t), zzixVar);
    }

    /* renamed from: A */
    public final boolean m2206A(T t, int i) {
        int m2218Q = m2218Q(i);
        long j = m2218Q & 1048575;
        if (j != 1048575) {
            return (C0841cq.m2918b(t, j) & (1 << (m2218Q >>> 20))) != 0;
        }
        int m2217O = m2217O(i);
        long j2 = m2217O & 1048575;
        switch ((m2217O & 267386880) >>> 20) {
            case 0:
                return C0841cq.m2904C(t, j2) != ShadowDrawableWrapper.COS_45;
            case 1:
                return C0841cq.m2940x(t, j2) != 0.0f;
            case 2:
                return C0841cq.m2931o(t, j2) != 0;
            case 3:
                return C0841cq.m2931o(t, j2) != 0;
            case 4:
                return C0841cq.m2918b(t, j2) != 0;
            case 5:
                return C0841cq.m2931o(t, j2) != 0;
            case 6:
                return C0841cq.m2918b(t, j2) != 0;
            case 7:
                return C0841cq.m2939w(t, j2);
            case 8:
                Object m2907F = C0841cq.m2907F(t, j2);
                if (m2907F instanceof String) {
                    return !((String) m2907F).isEmpty();
                }
                if (m2907F instanceof AbstractC1939tm) {
                    return !AbstractC1939tm.f6790P.equals(m2907F);
                }
                throw new IllegalArgumentException();
            case 9:
                return C0841cq.m2907F(t, j2) != null;
            case 10:
                return !AbstractC1939tm.f6790P.equals(C0841cq.m2907F(t, j2));
            case 11:
                return C0841cq.m2918b(t, j2) != 0;
            case 12:
                return C0841cq.m2918b(t, j2) != 0;
            case 13:
                return C0841cq.m2918b(t, j2) != 0;
            case 14:
                return C0841cq.m2931o(t, j2) != 0;
            case 15:
                return C0841cq.m2918b(t, j2) != 0;
            case 16:
                return C0841cq.m2931o(t, j2) != 0;
            case 17:
                return C0841cq.m2907F(t, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* renamed from: B */
    public final boolean m2207B(T t, int i, int i2) {
        return C0841cq.m2918b(t, (long) (m2218Q(i2) & 1048575)) == i;
    }

    /* renamed from: C */
    public final boolean m2208C(T t, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? m2206A(t, i) : (i3 & i4) != 0;
    }

    /* renamed from: F */
    public final int m2209F(int i, int i2) {
        int length = (this.f1485a.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.f1485a[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* renamed from: G */
    public final Object m2210G(int i) {
        return this.f1486b[(i / 3) << 1];
    }

    /* renamed from: H */
    public final void m2211H(T t, int i) {
        int m2218Q = m2218Q(i);
        long j = 1048575 & m2218Q;
        if (j == 1048575) {
            return;
        }
        C0841cq.m2924h(t, j, (1 << (m2218Q >>> 20)) | C0841cq.m2918b(t, j));
    }

    /* renamed from: I */
    public final void m2212I(T t, int i, int i2) {
        C0841cq.m2924h(t, m2218Q(i2) & 1048575, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x0082. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:218:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /* renamed from: J */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2213J(T r18, com.google.android.gms.internal.measurement.zzix r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0732ap.m2213J(java.lang.Object, com.google.android.gms.internal.measurement.zzix):void");
    }

    /* renamed from: K */
    public final void m2214K(T t, T t2, int i) {
        int m2217O = m2217O(i);
        int i2 = this.f1485a[i];
        long j = m2217O & 1048575;
        if (m2207B(t2, i2, i)) {
            Object m2907F = C0841cq.m2907F(t, j);
            Object m2907F2 = C0841cq.m2907F(t2, j);
            if (m2907F != null && m2907F2 != null) {
                C0841cq.m2926j(t, j, C2435zn.m10539e(m2907F, m2907F2));
                m2212I(t, i2, i);
            } else if (m2907F2 != null) {
                C0841cq.m2926j(t, j, m2907F2);
                m2212I(t, i2, i);
            }
        }
    }

    /* renamed from: M */
    public final zzfp m2215M(int i) {
        return (zzfp) this.f1486b[((i / 3) << 1) + 1];
    }

    /* renamed from: N */
    public final boolean m2216N(T t, T t2, int i) {
        return m2206A(t, i) == m2206A(t2, i);
    }

    /* renamed from: O */
    public final int m2217O(int i) {
        return this.f1485a[i + 1];
    }

    /* renamed from: Q */
    public final int m2218Q(int i) {
        return this.f1485a[i + 2];
    }

    /* renamed from: U */
    public final int m2219U(int i) {
        if (i < this.f1487c || i > this.f1488d) {
            return -1;
        }
        return m2209F(i, 0);
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: a */
    public final T mo1272a() {
        return (T) this.f1496l.mo1271b(this.f1489e);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: b */
    public final int mo1273b(T t) {
        int i;
        int m10536b;
        int length = this.f1485a.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int m2217O = m2217O(i3);
            int i4 = this.f1485a[i3];
            long j = 1048575 & m2217O;
            int i5 = 37;
            switch ((m2217O & 267386880) >>> 20) {
                case 0:
                    i = i2 * 53;
                    m10536b = C2435zn.m10536b(Double.doubleToLongBits(C0841cq.m2904C(t, j)));
                    i2 = i + m10536b;
                    break;
                case 1:
                    i = i2 * 53;
                    m10536b = Float.floatToIntBits(C0841cq.m2940x(t, j));
                    i2 = i + m10536b;
                    break;
                case 2:
                    i = i2 * 53;
                    m10536b = C2435zn.m10536b(C0841cq.m2931o(t, j));
                    i2 = i + m10536b;
                    break;
                case 3:
                    i = i2 * 53;
                    m10536b = C2435zn.m10536b(C0841cq.m2931o(t, j));
                    i2 = i + m10536b;
                    break;
                case 4:
                    i = i2 * 53;
                    m10536b = C0841cq.m2918b(t, j);
                    i2 = i + m10536b;
                    break;
                case 5:
                    i = i2 * 53;
                    m10536b = C2435zn.m10536b(C0841cq.m2931o(t, j));
                    i2 = i + m10536b;
                    break;
                case 6:
                    i = i2 * 53;
                    m10536b = C0841cq.m2918b(t, j);
                    i2 = i + m10536b;
                    break;
                case 7:
                    i = i2 * 53;
                    m10536b = C2435zn.m10537c(C0841cq.m2939w(t, j));
                    i2 = i + m10536b;
                    break;
                case 8:
                    i = i2 * 53;
                    m10536b = ((String) C0841cq.m2907F(t, j)).hashCode();
                    i2 = i + m10536b;
                    break;
                case 9:
                    Object m2907F = C0841cq.m2907F(t, j);
                    if (m2907F != null) {
                        i5 = m2907F.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 10:
                    i = i2 * 53;
                    m10536b = C0841cq.m2907F(t, j).hashCode();
                    i2 = i + m10536b;
                    break;
                case 11:
                    i = i2 * 53;
                    m10536b = C0841cq.m2918b(t, j);
                    i2 = i + m10536b;
                    break;
                case 12:
                    i = i2 * 53;
                    m10536b = C0841cq.m2918b(t, j);
                    i2 = i + m10536b;
                    break;
                case 13:
                    i = i2 * 53;
                    m10536b = C0841cq.m2918b(t, j);
                    i2 = i + m10536b;
                    break;
                case 14:
                    i = i2 * 53;
                    m10536b = C2435zn.m10536b(C0841cq.m2931o(t, j));
                    i2 = i + m10536b;
                    break;
                case 15:
                    i = i2 * 53;
                    m10536b = C0841cq.m2918b(t, j);
                    i2 = i + m10536b;
                    break;
                case 16:
                    i = i2 * 53;
                    m10536b = C2435zn.m10536b(C0841cq.m2931o(t, j));
                    i2 = i + m10536b;
                    break;
                case 17:
                    Object m2907F2 = C0841cq.m2907F(t, j);
                    if (m2907F2 != null) {
                        i5 = m2907F2.hashCode();
                    }
                    i2 = (i2 * 53) + i5;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    m10536b = C0841cq.m2907F(t, j).hashCode();
                    i2 = i + m10536b;
                    break;
                case 50:
                    i = i2 * 53;
                    m10536b = C0841cq.m2907F(t, j).hashCode();
                    i2 = i + m10536b;
                    break;
                case 51:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = C2435zn.m10536b(Double.doubleToLongBits(m2193E(t, j)));
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = Float.floatToIntBits(m2194L(t, j));
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = C2435zn.m10536b(m2196R(t, j));
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = C2435zn.m10536b(m2196R(t, j));
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = m2195P(t, j);
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = C2435zn.m10536b(m2196R(t, j));
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = m2195P(t, j);
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = C2435zn.m10537c(m2198T(t, j));
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = ((String) C0841cq.m2907F(t, j)).hashCode();
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = C0841cq.m2907F(t, j).hashCode();
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = C0841cq.m2907F(t, j).hashCode();
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = m2195P(t, j);
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = m2195P(t, j);
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = m2195P(t, j);
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = C2435zn.m10536b(m2196R(t, j));
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = m2195P(t, j);
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = C2435zn.m10536b(m2196R(t, j));
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (m2207B(t, i4, i3)) {
                        i = i2 * 53;
                        m10536b = C0841cq.m2907F(t, j).hashCode();
                        i2 = i + m10536b;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i2 * 53) + this.f1498n.mo9614f(t).hashCode();
        return this.f1490f ? (hashCode * 53) + this.f1499o.mo6477b(t).hashCode() : hashCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.measurement.zzhi] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.measurement.zzhi] */
    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: c */
    public final boolean mo1274c(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= this.f1494j) {
                return !this.f1490f || this.f1499o.mo6477b(t).m8216r();
            }
            int i6 = this.f1493i[i5];
            int i7 = this.f1485a[i6];
            int m2217O = m2217O(i6);
            int i8 = this.f1485a[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = f1484r.getInt(t, i9);
                }
                i2 = i4;
                i = i9;
            } else {
                i = i3;
                i2 = i4;
            }
            if (((268435456 & m2217O) != 0) && !m2208C(t, i6, i, i2, i10)) {
                return false;
            }
            int i11 = (267386880 & m2217O) >>> 20;
            if (i11 != 9 && i11 != 17) {
                if (i11 != 27) {
                    if (i11 == 60 || i11 == 68) {
                        if (m2207B(t, i7, i6) && !m2192D(t, m2217O, m2225r(i6))) {
                            return false;
                        }
                    } else if (i11 != 49) {
                        if (i11 != 50) {
                            continue;
                        } else {
                            Map<?, ?> mo1248e = this.f1500p.mo1248e(C0841cq.m2907F(t, m2217O & 1048575));
                            if (!mo1248e.isEmpty()) {
                                if (this.f1500p.mo1250g(m2210G(i6)).f6814c.m6767f() == EnumC1780qq.MESSAGE) {
                                    ?? r1 = 0;
                                    Iterator<?> it = mo1248e.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        r1 = r1;
                                        if (r1 == 0) {
                                            r1 = C1007fp.m3851a().m3852b(next.getClass());
                                        }
                                        if (!r1.mo1274c(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) C0841cq.m2907F(t, m2217O & 1048575);
                if (!list.isEmpty()) {
                    ?? m2225r = m2225r(i6);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        }
                        if (!m2225r.mo1274c(list.get(i12))) {
                            z = false;
                            break;
                        }
                        i12++;
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (m2208C(t, i6, i, i2, i10) && !m2192D(t, m2217O, m2225r(i6))) {
                return false;
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: d */
    public final void mo1275d(T t) {
        int i;
        int i2 = this.f1494j;
        while (true) {
            i = this.f1495k;
            if (i2 >= i) {
                break;
            }
            long m2217O = m2217O(this.f1493i[i2]) & 1048575;
            Object m2907F = C0841cq.m2907F(t, m2217O);
            if (m2907F != null) {
                C0841cq.m2926j(t, m2217O, this.f1500p.mo1246c(m2907F));
            }
            i2++;
        }
        int length = this.f1493i.length;
        while (i < length) {
            this.f1497m.mo6489d(t, this.f1493i[i]);
            i++;
        }
        this.f1498n.mo9618j(t);
        if (this.f1490f) {
            this.f1499o.mo6482g(t);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0042. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:299:0x0545. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: e */
    public final int mo1276e(T t) {
        int i;
        int i2;
        int i3;
        boolean z;
        long j;
        int m4512c0;
        int m4501H;
        int m4491B0;
        int i4;
        int m4854R;
        int m4858V;
        int m4518h0;
        int m4525p0;
        int m4490B;
        int m4858V2;
        int m4518h02;
        int m4525p02;
        int i5 = 267386880;
        int i6 = 0;
        if (this.f1491g) {
            Unsafe unsafe = f1484r;
            int i7 = 0;
            int i8 = 0;
            while (i7 < this.f1485a.length) {
                int m2217O = m2217O(i7);
                int i9 = (m2217O & i5) >>> 20;
                int i10 = this.f1485a[i7];
                long j2 = m2217O & 1048575;
                int i11 = (i9 < EnumC1877sn.f6571y0.m8474a() || i9 > EnumC1877sn.f6531L0.m8474a()) ? 0 : this.f1485a[i7 + 2] & 1048575;
                switch (i9) {
                    case 0:
                        if (m2206A(t, i7)) {
                            m4490B = AbstractC1116hn.m4490B(i10, ShadowDrawableWrapper.COS_45);
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (m2206A(t, i7)) {
                            m4490B = AbstractC1116hn.m4492C(i10, 0.0f);
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (m2206A(t, i7)) {
                            m4490B = AbstractC1116hn.m4512c0(i10, C0841cq.m2931o(t, j2));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (m2206A(t, i7)) {
                            m4490B = AbstractC1116hn.m4519i0(i10, C0841cq.m2931o(t, j2));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (m2206A(t, i7)) {
                            m4490B = AbstractC1116hn.m4522m0(i10, C0841cq.m2918b(t, j2));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (m2206A(t, i7)) {
                            m4490B = AbstractC1116hn.m4527r0(i10, 0L);
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (m2206A(t, i7)) {
                            m4490B = AbstractC1116hn.m4534y0(i10, 0);
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (m2206A(t, i7)) {
                            m4490B = AbstractC1116hn.m4501H(i10, true);
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (m2206A(t, i7)) {
                            Object m2907F = C0841cq.m2907F(t, j2);
                            m4490B = m2907F instanceof AbstractC1939tm ? AbstractC1116hn.m4507U(i10, (AbstractC1939tm) m2907F) : AbstractC1116hn.m4500G(i10, (String) m2907F);
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (m2206A(t, i7)) {
                            m4490B = C1171ip.m4863a(i10, C0841cq.m2907F(t, j2), m2225r(i7));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (m2206A(t, i7)) {
                            m4490B = AbstractC1116hn.m4507U(i10, (AbstractC1939tm) C0841cq.m2907F(t, j2));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (m2206A(t, i7)) {
                            m4490B = AbstractC1116hn.m4526q0(i10, C0841cq.m2918b(t, j2));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (m2206A(t, i7)) {
                            m4490B = AbstractC1116hn.m4495D0(i10, C0841cq.m2918b(t, j2));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (m2206A(t, i7)) {
                            m4490B = AbstractC1116hn.m4491B0(i10, 0);
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (m2206A(t, i7)) {
                            m4490B = AbstractC1116hn.m4531v0(i10, 0L);
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (m2206A(t, i7)) {
                            m4490B = AbstractC1116hn.m4530u0(i10, C0841cq.m2918b(t, j2));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (m2206A(t, i7)) {
                            m4490B = AbstractC1116hn.m4523n0(i10, C0841cq.m2931o(t, j2));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (m2206A(t, i7)) {
                            m4490B = AbstractC1116hn.m4508V(i10, (zzgt) C0841cq.m2907F(t, j2), m2225r(i7));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        m4490B = C1171ip.m4857U(i10, m2203v(t, j2), false);
                        i8 += m4490B;
                        break;
                    case 19:
                        m4490B = C1171ip.m4854R(i10, m2203v(t, j2), false);
                        i8 += m4490B;
                        break;
                    case 20:
                        m4490B = C1171ip.m4869d(i10, m2203v(t, j2), false);
                        i8 += m4490B;
                        break;
                    case 21:
                        m4490B = C1171ip.m4886t(i10, m2203v(t, j2), false);
                        i8 += m4490B;
                        break;
                    case 22:
                        m4490B = C1171ip.m4844H(i10, m2203v(t, j2), false);
                        i8 += m4490B;
                        break;
                    case 23:
                        m4490B = C1171ip.m4857U(i10, m2203v(t, j2), false);
                        i8 += m4490B;
                        break;
                    case 24:
                        m4490B = C1171ip.m4854R(i10, m2203v(t, j2), false);
                        i8 += m4490B;
                        break;
                    case 25:
                        m4490B = C1171ip.m4860X(i10, m2203v(t, j2), false);
                        i8 += m4490B;
                        break;
                    case 26:
                        m4490B = C1171ip.m4865b(i10, m2203v(t, j2));
                        i8 += m4490B;
                        break;
                    case 27:
                        m4490B = C1171ip.m4867c(i10, m2203v(t, j2), m2225r(i7));
                        i8 += m4490B;
                        break;
                    case 28:
                        m4490B = C1171ip.m4884r(i10, m2203v(t, j2));
                        i8 += m4490B;
                        break;
                    case 29:
                        m4490B = C1171ip.m4848L(i10, m2203v(t, j2), false);
                        i8 += m4490B;
                        break;
                    case 30:
                        m4490B = C1171ip.m4840D(i10, m2203v(t, j2), false);
                        i8 += m4490B;
                        break;
                    case 31:
                        m4490B = C1171ip.m4854R(i10, m2203v(t, j2), false);
                        i8 += m4490B;
                        break;
                    case 32:
                        m4490B = C1171ip.m4857U(i10, m2203v(t, j2), false);
                        i8 += m4490B;
                        break;
                    case 33:
                        m4490B = C1171ip.m4851O(i10, m2203v(t, j2), false);
                        i8 += m4490B;
                        break;
                    case 34:
                        m4490B = C1171ip.m4892z(i10, m2203v(t, j2), false);
                        i8 += m4490B;
                        break;
                    case 35:
                        m4858V2 = C1171ip.m4858V((List) unsafe.getObject(t, j2));
                        if (m4858V2 <= 0) {
                            break;
                        } else {
                            if (this.f1492h) {
                                unsafe.putInt(t, i11, m4858V2);
                            }
                            m4518h02 = AbstractC1116hn.m4518h0(i10);
                            m4525p02 = AbstractC1116hn.m4525p0(m4858V2);
                            m4490B = m4518h02 + m4525p02 + m4858V2;
                            i8 += m4490B;
                            break;
                        }
                    case 36:
                        m4858V2 = C1171ip.m4855S((List) unsafe.getObject(t, j2));
                        if (m4858V2 <= 0) {
                            break;
                        } else {
                            if (this.f1492h) {
                                unsafe.putInt(t, i11, m4858V2);
                            }
                            m4518h02 = AbstractC1116hn.m4518h0(i10);
                            m4525p02 = AbstractC1116hn.m4525p0(m4858V2);
                            m4490B = m4518h02 + m4525p02 + m4858V2;
                            i8 += m4490B;
                            break;
                        }
                    case 37:
                        m4858V2 = C1171ip.m4871e((List) unsafe.getObject(t, j2));
                        if (m4858V2 <= 0) {
                            break;
                        } else {
                            if (this.f1492h) {
                                unsafe.putInt(t, i11, m4858V2);
                            }
                            m4518h02 = AbstractC1116hn.m4518h0(i10);
                            m4525p02 = AbstractC1116hn.m4525p0(m4858V2);
                            m4490B = m4518h02 + m4525p02 + m4858V2;
                            i8 += m4490B;
                            break;
                        }
                    case 38:
                        m4858V2 = C1171ip.m4887u((List) unsafe.getObject(t, j2));
                        if (m4858V2 <= 0) {
                            break;
                        } else {
                            if (this.f1492h) {
                                unsafe.putInt(t, i11, m4858V2);
                            }
                            m4518h02 = AbstractC1116hn.m4518h0(i10);
                            m4525p02 = AbstractC1116hn.m4525p0(m4858V2);
                            m4490B = m4518h02 + m4525p02 + m4858V2;
                            i8 += m4490B;
                            break;
                        }
                    case 39:
                        m4858V2 = C1171ip.m4845I((List) unsafe.getObject(t, j2));
                        if (m4858V2 <= 0) {
                            break;
                        } else {
                            if (this.f1492h) {
                                unsafe.putInt(t, i11, m4858V2);
                            }
                            m4518h02 = AbstractC1116hn.m4518h0(i10);
                            m4525p02 = AbstractC1116hn.m4525p0(m4858V2);
                            m4490B = m4518h02 + m4525p02 + m4858V2;
                            i8 += m4490B;
                            break;
                        }
                    case 40:
                        m4858V2 = C1171ip.m4858V((List) unsafe.getObject(t, j2));
                        if (m4858V2 <= 0) {
                            break;
                        } else {
                            if (this.f1492h) {
                                unsafe.putInt(t, i11, m4858V2);
                            }
                            m4518h02 = AbstractC1116hn.m4518h0(i10);
                            m4525p02 = AbstractC1116hn.m4525p0(m4858V2);
                            m4490B = m4518h02 + m4525p02 + m4858V2;
                            i8 += m4490B;
                            break;
                        }
                    case 41:
                        m4858V2 = C1171ip.m4855S((List) unsafe.getObject(t, j2));
                        if (m4858V2 <= 0) {
                            break;
                        } else {
                            if (this.f1492h) {
                                unsafe.putInt(t, i11, m4858V2);
                            }
                            m4518h02 = AbstractC1116hn.m4518h0(i10);
                            m4525p02 = AbstractC1116hn.m4525p0(m4858V2);
                            m4490B = m4518h02 + m4525p02 + m4858V2;
                            i8 += m4490B;
                            break;
                        }
                    case 42:
                        m4858V2 = C1171ip.m4861Y((List) unsafe.getObject(t, j2));
                        if (m4858V2 <= 0) {
                            break;
                        } else {
                            if (this.f1492h) {
                                unsafe.putInt(t, i11, m4858V2);
                            }
                            m4518h02 = AbstractC1116hn.m4518h0(i10);
                            m4525p02 = AbstractC1116hn.m4525p0(m4858V2);
                            m4490B = m4518h02 + m4525p02 + m4858V2;
                            i8 += m4490B;
                            break;
                        }
                    case 43:
                        m4858V2 = C1171ip.m4849M((List) unsafe.getObject(t, j2));
                        if (m4858V2 <= 0) {
                            break;
                        } else {
                            if (this.f1492h) {
                                unsafe.putInt(t, i11, m4858V2);
                            }
                            m4518h02 = AbstractC1116hn.m4518h0(i10);
                            m4525p02 = AbstractC1116hn.m4525p0(m4858V2);
                            m4490B = m4518h02 + m4525p02 + m4858V2;
                            i8 += m4490B;
                            break;
                        }
                    case 44:
                        m4858V2 = C1171ip.m4841E((List) unsafe.getObject(t, j2));
                        if (m4858V2 <= 0) {
                            break;
                        } else {
                            if (this.f1492h) {
                                unsafe.putInt(t, i11, m4858V2);
                            }
                            m4518h02 = AbstractC1116hn.m4518h0(i10);
                            m4525p02 = AbstractC1116hn.m4525p0(m4858V2);
                            m4490B = m4518h02 + m4525p02 + m4858V2;
                            i8 += m4490B;
                            break;
                        }
                    case 45:
                        m4858V2 = C1171ip.m4855S((List) unsafe.getObject(t, j2));
                        if (m4858V2 <= 0) {
                            break;
                        } else {
                            if (this.f1492h) {
                                unsafe.putInt(t, i11, m4858V2);
                            }
                            m4518h02 = AbstractC1116hn.m4518h0(i10);
                            m4525p02 = AbstractC1116hn.m4525p0(m4858V2);
                            m4490B = m4518h02 + m4525p02 + m4858V2;
                            i8 += m4490B;
                            break;
                        }
                    case 46:
                        m4858V2 = C1171ip.m4858V((List) unsafe.getObject(t, j2));
                        if (m4858V2 <= 0) {
                            break;
                        } else {
                            if (this.f1492h) {
                                unsafe.putInt(t, i11, m4858V2);
                            }
                            m4518h02 = AbstractC1116hn.m4518h0(i10);
                            m4525p02 = AbstractC1116hn.m4525p0(m4858V2);
                            m4490B = m4518h02 + m4525p02 + m4858V2;
                            i8 += m4490B;
                            break;
                        }
                    case 47:
                        m4858V2 = C1171ip.m4852P((List) unsafe.getObject(t, j2));
                        if (m4858V2 <= 0) {
                            break;
                        } else {
                            if (this.f1492h) {
                                unsafe.putInt(t, i11, m4858V2);
                            }
                            m4518h02 = AbstractC1116hn.m4518h0(i10);
                            m4525p02 = AbstractC1116hn.m4525p0(m4858V2);
                            m4490B = m4518h02 + m4525p02 + m4858V2;
                            i8 += m4490B;
                            break;
                        }
                    case 48:
                        m4858V2 = C1171ip.m4837A((List) unsafe.getObject(t, j2));
                        if (m4858V2 <= 0) {
                            break;
                        } else {
                            if (this.f1492h) {
                                unsafe.putInt(t, i11, m4858V2);
                            }
                            m4518h02 = AbstractC1116hn.m4518h0(i10);
                            m4525p02 = AbstractC1116hn.m4525p0(m4858V2);
                            m4490B = m4518h02 + m4525p02 + m4858V2;
                            i8 += m4490B;
                            break;
                        }
                    case 49:
                        m4490B = C1171ip.m4885s(i10, m2203v(t, j2), m2225r(i7));
                        i8 += m4490B;
                        break;
                    case 50:
                        m4490B = this.f1500p.mo1252i(i10, C0841cq.m2907F(t, j2), m2210G(i7));
                        i8 += m4490B;
                        break;
                    case 51:
                        if (m2207B(t, i10, i7)) {
                            m4490B = AbstractC1116hn.m4490B(i10, ShadowDrawableWrapper.COS_45);
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (m2207B(t, i10, i7)) {
                            m4490B = AbstractC1116hn.m4492C(i10, 0.0f);
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (m2207B(t, i10, i7)) {
                            m4490B = AbstractC1116hn.m4512c0(i10, m2196R(t, j2));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (m2207B(t, i10, i7)) {
                            m4490B = AbstractC1116hn.m4519i0(i10, m2196R(t, j2));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (m2207B(t, i10, i7)) {
                            m4490B = AbstractC1116hn.m4522m0(i10, m2195P(t, j2));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (m2207B(t, i10, i7)) {
                            m4490B = AbstractC1116hn.m4527r0(i10, 0L);
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (m2207B(t, i10, i7)) {
                            m4490B = AbstractC1116hn.m4534y0(i10, 0);
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (m2207B(t, i10, i7)) {
                            m4490B = AbstractC1116hn.m4501H(i10, true);
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (m2207B(t, i10, i7)) {
                            Object m2907F2 = C0841cq.m2907F(t, j2);
                            m4490B = m2907F2 instanceof AbstractC1939tm ? AbstractC1116hn.m4507U(i10, (AbstractC1939tm) m2907F2) : AbstractC1116hn.m4500G(i10, (String) m2907F2);
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (m2207B(t, i10, i7)) {
                            m4490B = C1171ip.m4863a(i10, C0841cq.m2907F(t, j2), m2225r(i7));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (m2207B(t, i10, i7)) {
                            m4490B = AbstractC1116hn.m4507U(i10, (AbstractC1939tm) C0841cq.m2907F(t, j2));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (m2207B(t, i10, i7)) {
                            m4490B = AbstractC1116hn.m4526q0(i10, m2195P(t, j2));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (m2207B(t, i10, i7)) {
                            m4490B = AbstractC1116hn.m4495D0(i10, m2195P(t, j2));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (m2207B(t, i10, i7)) {
                            m4490B = AbstractC1116hn.m4491B0(i10, 0);
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (m2207B(t, i10, i7)) {
                            m4490B = AbstractC1116hn.m4531v0(i10, 0L);
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (m2207B(t, i10, i7)) {
                            m4490B = AbstractC1116hn.m4530u0(i10, m2195P(t, j2));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (m2207B(t, i10, i7)) {
                            m4490B = AbstractC1116hn.m4523n0(i10, m2196R(t, j2));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (m2207B(t, i10, i7)) {
                            m4490B = AbstractC1116hn.m4508V(i10, (zzgt) C0841cq.m2907F(t, j2), m2225r(i7));
                            i8 += m4490B;
                            break;
                        } else {
                            break;
                        }
                }
                i7 += 3;
                i5 = 267386880;
            }
            return i8 + m2199k(this.f1498n, t);
        }
        Unsafe unsafe2 = f1484r;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < this.f1485a.length) {
            int m2217O2 = m2217O(i13);
            int[] iArr = this.f1485a;
            int i16 = iArr[i13];
            int i17 = (m2217O2 & 267386880) >>> 20;
            if (i17 <= 17) {
                int i18 = iArr[i13 + 2];
                int i19 = i18 & 1048575;
                i2 = 1 << (i18 >>> 20);
                if (i19 != i12) {
                    i15 = unsafe2.getInt(t, i19);
                    i12 = i19;
                }
                i = i18;
            } else {
                i = (!this.f1492h || i17 < EnumC1877sn.f6571y0.m8474a() || i17 > EnumC1877sn.f6531L0.m8474a()) ? 0 : this.f1485a[i13 + 2] & 1048575;
                i2 = 0;
            }
            long j3 = m2217O2 & 1048575;
            switch (i17) {
                case 0:
                    i3 = 0;
                    z = false;
                    j = 0;
                    if ((i15 & i2) != 0) {
                        i14 += AbstractC1116hn.m4490B(i16, ShadowDrawableWrapper.COS_45);
                        break;
                    }
                    break;
                case 1:
                    i3 = 0;
                    j = 0;
                    if ((i15 & i2) != 0) {
                        z = false;
                        i14 += AbstractC1116hn.m4492C(i16, 0.0f);
                        break;
                    }
                    z = false;
                case 2:
                    i3 = 0;
                    j = 0;
                    if ((i15 & i2) != 0) {
                        m4512c0 = AbstractC1116hn.m4512c0(i16, unsafe2.getLong(t, j3));
                        i14 += m4512c0;
                    }
                    z = false;
                    break;
                case 3:
                    i3 = 0;
                    j = 0;
                    if ((i15 & i2) != 0) {
                        m4512c0 = AbstractC1116hn.m4519i0(i16, unsafe2.getLong(t, j3));
                        i14 += m4512c0;
                    }
                    z = false;
                    break;
                case 4:
                    i3 = 0;
                    j = 0;
                    if ((i15 & i2) != 0) {
                        m4512c0 = AbstractC1116hn.m4522m0(i16, unsafe2.getInt(t, j3));
                        i14 += m4512c0;
                    }
                    z = false;
                    break;
                case 5:
                    i3 = 0;
                    j = 0;
                    if ((i15 & i2) != 0) {
                        m4512c0 = AbstractC1116hn.m4527r0(i16, 0L);
                        i14 += m4512c0;
                    }
                    z = false;
                    break;
                case 6:
                    if ((i15 & i2) != 0) {
                        i3 = 0;
                        i14 += AbstractC1116hn.m4534y0(i16, 0);
                        z = false;
                        j = 0;
                        break;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                case 7:
                    if ((i15 & i2) != 0) {
                        m4501H = AbstractC1116hn.m4501H(i16, true);
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 8:
                    if ((i15 & i2) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        m4501H = object instanceof AbstractC1939tm ? AbstractC1116hn.m4507U(i16, (AbstractC1939tm) object) : AbstractC1116hn.m4500G(i16, (String) object);
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 9:
                    if ((i15 & i2) != 0) {
                        m4501H = C1171ip.m4863a(i16, unsafe2.getObject(t, j3), m2225r(i13));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 10:
                    if ((i15 & i2) != 0) {
                        m4501H = AbstractC1116hn.m4507U(i16, (AbstractC1939tm) unsafe2.getObject(t, j3));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 11:
                    if ((i15 & i2) != 0) {
                        m4501H = AbstractC1116hn.m4526q0(i16, unsafe2.getInt(t, j3));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 12:
                    if ((i15 & i2) != 0) {
                        m4501H = AbstractC1116hn.m4495D0(i16, unsafe2.getInt(t, j3));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 13:
                    if ((i15 & i2) != 0) {
                        m4491B0 = AbstractC1116hn.m4491B0(i16, 0);
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 14:
                    if ((i15 & i2) != 0) {
                        m4501H = AbstractC1116hn.m4531v0(i16, 0L);
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 15:
                    if ((i15 & i2) != 0) {
                        m4501H = AbstractC1116hn.m4530u0(i16, unsafe2.getInt(t, j3));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 16:
                    if ((i15 & i2) != 0) {
                        m4501H = AbstractC1116hn.m4523n0(i16, unsafe2.getLong(t, j3));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 17:
                    if ((i15 & i2) != 0) {
                        m4501H = AbstractC1116hn.m4508V(i16, (zzgt) unsafe2.getObject(t, j3), m2225r(i13));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 18:
                    m4501H = C1171ip.m4857U(i16, (List) unsafe2.getObject(t, j3), false);
                    i14 += m4501H;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 19:
                    i4 = 0;
                    m4854R = C1171ip.m4854R(i16, (List) unsafe2.getObject(t, j3), false);
                    i14 += m4854R;
                    i3 = i4;
                    z = false;
                    j = 0;
                    break;
                case 20:
                    i4 = 0;
                    m4854R = C1171ip.m4869d(i16, (List) unsafe2.getObject(t, j3), false);
                    i14 += m4854R;
                    i3 = i4;
                    z = false;
                    j = 0;
                    break;
                case 21:
                    i4 = 0;
                    m4854R = C1171ip.m4886t(i16, (List) unsafe2.getObject(t, j3), false);
                    i14 += m4854R;
                    i3 = i4;
                    z = false;
                    j = 0;
                    break;
                case 22:
                    i4 = 0;
                    m4854R = C1171ip.m4844H(i16, (List) unsafe2.getObject(t, j3), false);
                    i14 += m4854R;
                    i3 = i4;
                    z = false;
                    j = 0;
                    break;
                case 23:
                    i4 = 0;
                    m4854R = C1171ip.m4857U(i16, (List) unsafe2.getObject(t, j3), false);
                    i14 += m4854R;
                    i3 = i4;
                    z = false;
                    j = 0;
                    break;
                case 24:
                    i4 = 0;
                    m4854R = C1171ip.m4854R(i16, (List) unsafe2.getObject(t, j3), false);
                    i14 += m4854R;
                    i3 = i4;
                    z = false;
                    j = 0;
                    break;
                case 25:
                    i4 = 0;
                    m4854R = C1171ip.m4860X(i16, (List) unsafe2.getObject(t, j3), false);
                    i14 += m4854R;
                    i3 = i4;
                    z = false;
                    j = 0;
                    break;
                case 26:
                    m4501H = C1171ip.m4865b(i16, (List) unsafe2.getObject(t, j3));
                    i14 += m4501H;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 27:
                    m4501H = C1171ip.m4867c(i16, (List) unsafe2.getObject(t, j3), m2225r(i13));
                    i14 += m4501H;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 28:
                    m4501H = C1171ip.m4884r(i16, (List) unsafe2.getObject(t, j3));
                    i14 += m4501H;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 29:
                    m4501H = C1171ip.m4848L(i16, (List) unsafe2.getObject(t, j3), false);
                    i14 += m4501H;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 30:
                    i4 = 0;
                    m4854R = C1171ip.m4840D(i16, (List) unsafe2.getObject(t, j3), false);
                    i14 += m4854R;
                    i3 = i4;
                    z = false;
                    j = 0;
                    break;
                case 31:
                    i4 = 0;
                    m4854R = C1171ip.m4854R(i16, (List) unsafe2.getObject(t, j3), false);
                    i14 += m4854R;
                    i3 = i4;
                    z = false;
                    j = 0;
                    break;
                case 32:
                    i4 = 0;
                    m4854R = C1171ip.m4857U(i16, (List) unsafe2.getObject(t, j3), false);
                    i14 += m4854R;
                    i3 = i4;
                    z = false;
                    j = 0;
                    break;
                case 33:
                    i4 = 0;
                    m4854R = C1171ip.m4851O(i16, (List) unsafe2.getObject(t, j3), false);
                    i14 += m4854R;
                    i3 = i4;
                    z = false;
                    j = 0;
                    break;
                case 34:
                    i4 = 0;
                    m4854R = C1171ip.m4892z(i16, (List) unsafe2.getObject(t, j3), false);
                    i14 += m4854R;
                    i3 = i4;
                    z = false;
                    j = 0;
                    break;
                case 35:
                    m4858V = C1171ip.m4858V((List) unsafe2.getObject(t, j3));
                    if (m4858V > 0) {
                        if (this.f1492h) {
                            unsafe2.putInt(t, i, m4858V);
                        }
                        m4518h0 = AbstractC1116hn.m4518h0(i16);
                        m4525p0 = AbstractC1116hn.m4525p0(m4858V);
                        m4491B0 = m4518h0 + m4525p0 + m4858V;
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 36:
                    m4858V = C1171ip.m4855S((List) unsafe2.getObject(t, j3));
                    if (m4858V > 0) {
                        if (this.f1492h) {
                            unsafe2.putInt(t, i, m4858V);
                        }
                        m4518h0 = AbstractC1116hn.m4518h0(i16);
                        m4525p0 = AbstractC1116hn.m4525p0(m4858V);
                        m4491B0 = m4518h0 + m4525p0 + m4858V;
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 37:
                    m4858V = C1171ip.m4871e((List) unsafe2.getObject(t, j3));
                    if (m4858V > 0) {
                        if (this.f1492h) {
                            unsafe2.putInt(t, i, m4858V);
                        }
                        m4518h0 = AbstractC1116hn.m4518h0(i16);
                        m4525p0 = AbstractC1116hn.m4525p0(m4858V);
                        m4491B0 = m4518h0 + m4525p0 + m4858V;
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 38:
                    m4858V = C1171ip.m4887u((List) unsafe2.getObject(t, j3));
                    if (m4858V > 0) {
                        if (this.f1492h) {
                            unsafe2.putInt(t, i, m4858V);
                        }
                        m4518h0 = AbstractC1116hn.m4518h0(i16);
                        m4525p0 = AbstractC1116hn.m4525p0(m4858V);
                        m4491B0 = m4518h0 + m4525p0 + m4858V;
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 39:
                    m4858V = C1171ip.m4845I((List) unsafe2.getObject(t, j3));
                    if (m4858V > 0) {
                        if (this.f1492h) {
                            unsafe2.putInt(t, i, m4858V);
                        }
                        m4518h0 = AbstractC1116hn.m4518h0(i16);
                        m4525p0 = AbstractC1116hn.m4525p0(m4858V);
                        m4491B0 = m4518h0 + m4525p0 + m4858V;
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 40:
                    m4858V = C1171ip.m4858V((List) unsafe2.getObject(t, j3));
                    if (m4858V > 0) {
                        if (this.f1492h) {
                            unsafe2.putInt(t, i, m4858V);
                        }
                        m4518h0 = AbstractC1116hn.m4518h0(i16);
                        m4525p0 = AbstractC1116hn.m4525p0(m4858V);
                        m4491B0 = m4518h0 + m4525p0 + m4858V;
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 41:
                    m4858V = C1171ip.m4855S((List) unsafe2.getObject(t, j3));
                    if (m4858V > 0) {
                        if (this.f1492h) {
                            unsafe2.putInt(t, i, m4858V);
                        }
                        m4518h0 = AbstractC1116hn.m4518h0(i16);
                        m4525p0 = AbstractC1116hn.m4525p0(m4858V);
                        m4491B0 = m4518h0 + m4525p0 + m4858V;
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 42:
                    m4858V = C1171ip.m4861Y((List) unsafe2.getObject(t, j3));
                    if (m4858V > 0) {
                        if (this.f1492h) {
                            unsafe2.putInt(t, i, m4858V);
                        }
                        m4518h0 = AbstractC1116hn.m4518h0(i16);
                        m4525p0 = AbstractC1116hn.m4525p0(m4858V);
                        m4491B0 = m4518h0 + m4525p0 + m4858V;
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 43:
                    m4858V = C1171ip.m4849M((List) unsafe2.getObject(t, j3));
                    if (m4858V > 0) {
                        if (this.f1492h) {
                            unsafe2.putInt(t, i, m4858V);
                        }
                        m4518h0 = AbstractC1116hn.m4518h0(i16);
                        m4525p0 = AbstractC1116hn.m4525p0(m4858V);
                        m4491B0 = m4518h0 + m4525p0 + m4858V;
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 44:
                    m4858V = C1171ip.m4841E((List) unsafe2.getObject(t, j3));
                    if (m4858V > 0) {
                        if (this.f1492h) {
                            unsafe2.putInt(t, i, m4858V);
                        }
                        m4518h0 = AbstractC1116hn.m4518h0(i16);
                        m4525p0 = AbstractC1116hn.m4525p0(m4858V);
                        m4491B0 = m4518h0 + m4525p0 + m4858V;
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 45:
                    m4858V = C1171ip.m4855S((List) unsafe2.getObject(t, j3));
                    if (m4858V > 0) {
                        if (this.f1492h) {
                            unsafe2.putInt(t, i, m4858V);
                        }
                        m4518h0 = AbstractC1116hn.m4518h0(i16);
                        m4525p0 = AbstractC1116hn.m4525p0(m4858V);
                        m4491B0 = m4518h0 + m4525p0 + m4858V;
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 46:
                    m4858V = C1171ip.m4858V((List) unsafe2.getObject(t, j3));
                    if (m4858V > 0) {
                        if (this.f1492h) {
                            unsafe2.putInt(t, i, m4858V);
                        }
                        m4518h0 = AbstractC1116hn.m4518h0(i16);
                        m4525p0 = AbstractC1116hn.m4525p0(m4858V);
                        m4491B0 = m4518h0 + m4525p0 + m4858V;
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 47:
                    m4858V = C1171ip.m4852P((List) unsafe2.getObject(t, j3));
                    if (m4858V > 0) {
                        if (this.f1492h) {
                            unsafe2.putInt(t, i, m4858V);
                        }
                        m4518h0 = AbstractC1116hn.m4518h0(i16);
                        m4525p0 = AbstractC1116hn.m4525p0(m4858V);
                        m4491B0 = m4518h0 + m4525p0 + m4858V;
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 48:
                    m4858V = C1171ip.m4837A((List) unsafe2.getObject(t, j3));
                    if (m4858V > 0) {
                        if (this.f1492h) {
                            unsafe2.putInt(t, i, m4858V);
                        }
                        m4518h0 = AbstractC1116hn.m4518h0(i16);
                        m4525p0 = AbstractC1116hn.m4525p0(m4858V);
                        m4491B0 = m4518h0 + m4525p0 + m4858V;
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 49:
                    m4501H = C1171ip.m4885s(i16, (List) unsafe2.getObject(t, j3), m2225r(i13));
                    i14 += m4501H;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 50:
                    m4501H = this.f1500p.mo1252i(i16, unsafe2.getObject(t, j3), m2210G(i13));
                    i14 += m4501H;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 51:
                    if (m2207B(t, i16, i13)) {
                        m4501H = AbstractC1116hn.m4490B(i16, ShadowDrawableWrapper.COS_45);
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 52:
                    if (m2207B(t, i16, i13)) {
                        m4491B0 = AbstractC1116hn.m4492C(i16, 0.0f);
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 53:
                    if (m2207B(t, i16, i13)) {
                        m4501H = AbstractC1116hn.m4512c0(i16, m2196R(t, j3));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 54:
                    if (m2207B(t, i16, i13)) {
                        m4501H = AbstractC1116hn.m4519i0(i16, m2196R(t, j3));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 55:
                    if (m2207B(t, i16, i13)) {
                        m4501H = AbstractC1116hn.m4522m0(i16, m2195P(t, j3));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 56:
                    if (m2207B(t, i16, i13)) {
                        m4501H = AbstractC1116hn.m4527r0(i16, 0L);
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 57:
                    if (m2207B(t, i16, i13)) {
                        m4491B0 = AbstractC1116hn.m4534y0(i16, 0);
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 58:
                    if (m2207B(t, i16, i13)) {
                        m4501H = AbstractC1116hn.m4501H(i16, true);
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 59:
                    if (m2207B(t, i16, i13)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        m4501H = object2 instanceof AbstractC1939tm ? AbstractC1116hn.m4507U(i16, (AbstractC1939tm) object2) : AbstractC1116hn.m4500G(i16, (String) object2);
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 60:
                    if (m2207B(t, i16, i13)) {
                        m4501H = C1171ip.m4863a(i16, unsafe2.getObject(t, j3), m2225r(i13));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 61:
                    if (m2207B(t, i16, i13)) {
                        m4501H = AbstractC1116hn.m4507U(i16, (AbstractC1939tm) unsafe2.getObject(t, j3));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 62:
                    if (m2207B(t, i16, i13)) {
                        m4501H = AbstractC1116hn.m4526q0(i16, m2195P(t, j3));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 63:
                    if (m2207B(t, i16, i13)) {
                        m4501H = AbstractC1116hn.m4495D0(i16, m2195P(t, j3));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 64:
                    if (m2207B(t, i16, i13)) {
                        m4491B0 = AbstractC1116hn.m4491B0(i16, 0);
                        i14 += m4491B0;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 65:
                    if (m2207B(t, i16, i13)) {
                        m4501H = AbstractC1116hn.m4531v0(i16, 0L);
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 66:
                    if (m2207B(t, i16, i13)) {
                        m4501H = AbstractC1116hn.m4530u0(i16, m2195P(t, j3));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 67:
                    if (m2207B(t, i16, i13)) {
                        m4501H = AbstractC1116hn.m4523n0(i16, m2196R(t, j3));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 68:
                    if (m2207B(t, i16, i13)) {
                        m4501H = AbstractC1116hn.m4508V(i16, (zzgt) unsafe2.getObject(t, j3), m2225r(i13));
                        i14 += m4501H;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                default:
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
            }
            i13 += 3;
            i6 = i3;
        }
        int i20 = i6;
        int m2199k = i14 + m2199k(this.f1498n, t);
        if (!this.f1490f) {
            return m2199k;
        }
        C1826rn<?> mo6477b = this.f1499o.mo6477b(t);
        for (int i21 = i20; i21 < mo6477b.f6262a.m5981j(); i21++) {
            Map.Entry<?, Object> m5979h = mo6477b.f6262a.m5979h(i21);
            i20 += C1826rn.m8199a((zzfd) m5979h.getKey(), m5979h.getValue());
        }
        for (Map.Entry<?, Object> entry : mo6477b.f6262a.m5983m()) {
            i20 += C1826rn.m8199a((zzfd) entry.getKey(), entry.getValue());
        }
        return m2199k + i20;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        if (cz.opentree.C1171ip.m4883q(cz.opentree.C0841cq.m2907F(r10, r6), cz.opentree.C0841cq.m2907F(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
    
        if (cz.opentree.C0841cq.m2931o(r10, r6) == cz.opentree.C0841cq.m2931o(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
    
        if (cz.opentree.C0841cq.m2918b(r10, r6) == cz.opentree.C0841cq.m2918b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
    
        if (cz.opentree.C0841cq.m2931o(r10, r6) == cz.opentree.C0841cq.m2931o(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b6, code lost:
    
        if (cz.opentree.C0841cq.m2918b(r10, r6) == cz.opentree.C0841cq.m2918b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:
    
        if (cz.opentree.C0841cq.m2918b(r10, r6) == cz.opentree.C0841cq.m2918b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00da, code lost:
    
        if (cz.opentree.C0841cq.m2918b(r10, r6) == cz.opentree.C0841cq.m2918b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f0, code lost:
    
        if (cz.opentree.C1171ip.m4883q(cz.opentree.C0841cq.m2907F(r10, r6), cz.opentree.C0841cq.m2907F(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0106, code lost:
    
        if (cz.opentree.C1171ip.m4883q(cz.opentree.C0841cq.m2907F(r10, r6), cz.opentree.C0841cq.m2907F(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x011c, code lost:
    
        if (cz.opentree.C1171ip.m4883q(cz.opentree.C0841cq.m2907F(r10, r6), cz.opentree.C0841cq.m2907F(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012e, code lost:
    
        if (cz.opentree.C0841cq.m2939w(r10, r6) == cz.opentree.C0841cq.m2939w(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0140, code lost:
    
        if (cz.opentree.C0841cq.m2918b(r10, r6) == cz.opentree.C0841cq.m2918b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0154, code lost:
    
        if (cz.opentree.C0841cq.m2931o(r10, r6) == cz.opentree.C0841cq.m2931o(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0165, code lost:
    
        if (cz.opentree.C0841cq.m2918b(r10, r6) == cz.opentree.C0841cq.m2918b(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0178, code lost:
    
        if (cz.opentree.C0841cq.m2931o(r10, r6) == cz.opentree.C0841cq.m2931o(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018b, code lost:
    
        if (cz.opentree.C0841cq.m2931o(r10, r6) == cz.opentree.C0841cq.m2931o(r11, r6)) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a4, code lost:
    
        if (java.lang.Float.floatToIntBits(cz.opentree.C0841cq.m2940x(r10, r6)) == java.lang.Float.floatToIntBits(cz.opentree.C0841cq.m2940x(r11, r6))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bf, code lost:
    
        if (java.lang.Double.doubleToLongBits(cz.opentree.C0841cq.m2904C(r10, r6)) == java.lang.Double.doubleToLongBits(cz.opentree.C0841cq.m2904C(r11, r6))) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (cz.opentree.C1171ip.m4883q(cz.opentree.C0841cq.m2907F(r10, r6), cz.opentree.C0841cq.m2907F(r11, r6)) != false) goto L105;
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c5 A[LOOP:0: B:2:0x0005->B:86:0x01c5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c4 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean mo1277f(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0732ap.mo1277f(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x0a2a  */
    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void mo1278g(T r14, com.google.android.gms.internal.measurement.zzix r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2916
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0732ap.mo1278g(java.lang.Object, com.google.android.gms.internal.measurement.zzix):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x02d1, code lost:
    
        if (r0 == r5) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x02d5, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r2 = r18;
        r10 = r20;
        r1 = r25;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x033f, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x031a, code lost:
    
        if (r0 == r15) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x033d, code lost:
    
        if (r0 == r15) goto L115;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x0094. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void mo1279h(T r31, byte[] r32, int r33, int r34, cz.opentree.C1876sm r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 956
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0732ap.mo1279h(java.lang.Object, byte[], int, int, cz.opentree.sm):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzhi
    /* renamed from: i */
    public final void mo1280i(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.f1485a.length; i += 3) {
            int m2217O = m2217O(i);
            long j = 1048575 & m2217O;
            int i2 = this.f1485a[i];
            switch ((m2217O & 267386880) >>> 20) {
                case 0:
                    if (m2206A(t2, i)) {
                        C0841cq.m2922f(t, j, C0841cq.m2904C(t2, j));
                        m2211H(t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (m2206A(t2, i)) {
                        C0841cq.m2923g(t, j, C0841cq.m2940x(t2, j));
                        m2211H(t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (m2206A(t2, i)) {
                        C0841cq.m2925i(t, j, C0841cq.m2931o(t2, j));
                        m2211H(t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (m2206A(t2, i)) {
                        C0841cq.m2925i(t, j, C0841cq.m2931o(t2, j));
                        m2211H(t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (m2206A(t2, i)) {
                        C0841cq.m2924h(t, j, C0841cq.m2918b(t2, j));
                        m2211H(t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (m2206A(t2, i)) {
                        C0841cq.m2925i(t, j, C0841cq.m2931o(t2, j));
                        m2211H(t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (m2206A(t2, i)) {
                        C0841cq.m2924h(t, j, C0841cq.m2918b(t2, j));
                        m2211H(t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (m2206A(t2, i)) {
                        C0841cq.m2927k(t, j, C0841cq.m2939w(t2, j));
                        m2211H(t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (m2206A(t2, i)) {
                        C0841cq.m2926j(t, j, C0841cq.m2907F(t2, j));
                        m2211H(t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    m2229z(t, t2, i);
                    break;
                case 10:
                    if (m2206A(t2, i)) {
                        C0841cq.m2926j(t, j, C0841cq.m2907F(t2, j));
                        m2211H(t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (m2206A(t2, i)) {
                        C0841cq.m2924h(t, j, C0841cq.m2918b(t2, j));
                        m2211H(t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (m2206A(t2, i)) {
                        C0841cq.m2924h(t, j, C0841cq.m2918b(t2, j));
                        m2211H(t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (m2206A(t2, i)) {
                        C0841cq.m2924h(t, j, C0841cq.m2918b(t2, j));
                        m2211H(t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (m2206A(t2, i)) {
                        C0841cq.m2925i(t, j, C0841cq.m2931o(t2, j));
                        m2211H(t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (m2206A(t2, i)) {
                        C0841cq.m2924h(t, j, C0841cq.m2918b(t2, j));
                        m2211H(t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (m2206A(t2, i)) {
                        C0841cq.m2925i(t, j, C0841cq.m2931o(t2, j));
                        m2211H(t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    m2229z(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.f1497m.mo6488b(t, t2, j);
                    break;
                case 50:
                    C1171ip.m4880n(this.f1500p, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (m2207B(t2, i2, i)) {
                        C0841cq.m2926j(t, j, C0841cq.m2907F(t2, j));
                        m2212I(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    m2214K(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (m2207B(t2, i2, i)) {
                        C0841cq.m2926j(t, j, C0841cq.m2907F(t2, j));
                        m2212I(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    m2214K(t, t2, i);
                    break;
            }
        }
        C1171ip.m4881o(this.f1498n, t, t2);
        if (this.f1490f) {
            C1171ip.m4879m(this.f1499o, t, t2);
        }
    }

    /* renamed from: j */
    public final int m2220j(int i, int i2) {
        if (i < this.f1487c || i > this.f1488d) {
            return -1;
        }
        return m2209F(i, i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    /* renamed from: l */
    public final int m2221l(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, C1876sm c1876sm) throws IOException {
        int m7402k;
        Unsafe unsafe = f1484r;
        long j2 = this.f1485a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(C1725pm.m7404m(bArr, i)));
                    m7402k = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return m7402k;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(C1725pm.m7406o(bArr, i)));
                    m7402k = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return m7402k;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    m7402k = C1725pm.m7402k(bArr, i, c1876sm);
                    unsafe.putObject(t, j, Long.valueOf(c1876sm.f6512b));
                    unsafe.putInt(t, j2, i4);
                    return m7402k;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    m7402k = C1725pm.m7400i(bArr, i, c1876sm);
                    unsafe.putObject(t, j, Integer.valueOf(c1876sm.f6511a));
                    unsafe.putInt(t, j2, i4);
                    return m7402k;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(C1725pm.m7403l(bArr, i)));
                    m7402k = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return m7402k;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(C1725pm.m7399h(bArr, i)));
                    m7402k = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return m7402k;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    m7402k = C1725pm.m7402k(bArr, i, c1876sm);
                    unsafe.putObject(t, j, Boolean.valueOf(c1876sm.f6512b != 0));
                    unsafe.putInt(t, j2, i4);
                    return m7402k;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int m7400i = C1725pm.m7400i(bArr, i, c1876sm);
                    int i9 = c1876sm.f6511a;
                    if (i9 == 0) {
                        unsafe.putObject(t, j, "");
                    } else {
                        if ((i6 & 536870912) != 0 && !C1008fq.m3862g(bArr, m7400i, m7400i + i9)) {
                            throw C0839co.m2894f();
                        }
                        unsafe.putObject(t, j, new String(bArr, m7400i, i9, C2435zn.f8565a));
                        m7400i += i9;
                    }
                    unsafe.putInt(t, j2, i4);
                    return m7400i;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int m7398g = C1725pm.m7398g(m2225r(i8), bArr, i, i2, c1876sm);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, c1876sm.f6513c);
                    } else {
                        unsafe.putObject(t, j, C2435zn.m10539e(object, c1876sm.f6513c));
                    }
                    unsafe.putInt(t, j2, i4);
                    return m7398g;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    m7402k = C1725pm.m7408q(bArr, i, c1876sm);
                    unsafe.putObject(t, j, c1876sm.f6513c);
                    unsafe.putInt(t, j2, i4);
                    return m7402k;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int m7400i2 = C1725pm.m7400i(bArr, i, c1876sm);
                    int i10 = c1876sm.f6511a;
                    zzfp m2215M = m2215M(i8);
                    if (m2215M != null && !m2215M.mo1235c(i10)) {
                        m2197S(t).m10580c(i3, Long.valueOf(i10));
                        return m7400i2;
                    }
                    unsafe.putObject(t, j, Integer.valueOf(i10));
                    m7402k = m7400i2;
                    unsafe.putInt(t, j2, i4);
                    return m7402k;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    m7402k = C1725pm.m7400i(bArr, i, c1876sm);
                    unsafe.putObject(t, j, Integer.valueOf(AbstractC0838cn.m2884d(c1876sm.f6511a)));
                    unsafe.putInt(t, j2, i4);
                    return m7402k;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    m7402k = C1725pm.m7402k(bArr, i, c1876sm);
                    unsafe.putObject(t, j, Long.valueOf(AbstractC0838cn.m2882a(c1876sm.f6512b)));
                    unsafe.putInt(t, j2, i4);
                    return m7402k;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    m7402k = C1725pm.m7397f(m2225r(i8), bArr, i, i2, (i3 & (-8)) | 4, c1876sm);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, c1876sm.f6513c);
                    } else {
                        unsafe.putObject(t, j, C2435zn.m10539e(object2, c1876sm.f6513c));
                    }
                    unsafe.putInt(t, j2, i4);
                    return m7402k;
                }
                return i;
            default:
                return i;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0037. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: m */
    public final int m2222m(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, C1876sm c1876sm) throws IOException {
        int m7400i;
        int i8 = i;
        Unsafe unsafe = f1484r;
        zzfq zzfqVar = (zzfq) unsafe.getObject(t, j2);
        if (!zzfqVar.mo1236a()) {
            int size = zzfqVar.size();
            zzfqVar = zzfqVar.mo1237c(size == 0 ? 10 : size << 1);
            unsafe.putObject(t, j2, zzfqVar);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    C1168in c1168in = (C1168in) zzfqVar;
                    int m7400i2 = C1725pm.m7400i(bArr, i8, c1876sm);
                    int i9 = c1876sm.f6511a + m7400i2;
                    while (m7400i2 < i9) {
                        c1168in.m4811f(C1725pm.m7404m(bArr, m7400i2));
                        m7400i2 += 8;
                    }
                    if (m7400i2 == i9) {
                        return m7400i2;
                    }
                    throw C0839co.m2889a();
                }
                if (i5 == 1) {
                    C1168in c1168in2 = (C1168in) zzfqVar;
                    c1168in2.m4811f(C1725pm.m7404m(bArr, i));
                    while (true) {
                        int i10 = i8 + 8;
                        if (i10 >= i2) {
                            return i10;
                        }
                        i8 = C1725pm.m7400i(bArr, i10, c1876sm);
                        if (i3 != c1876sm.f6511a) {
                            return i10;
                        }
                        c1168in2.m4811f(C1725pm.m7404m(bArr, i8));
                    }
                }
                return i8;
            case 19:
            case 36:
                if (i5 == 2) {
                    C2236wn c2236wn = (C2236wn) zzfqVar;
                    int m7400i3 = C1725pm.m7400i(bArr, i8, c1876sm);
                    int i11 = c1876sm.f6511a + m7400i3;
                    while (m7400i3 < i11) {
                        c2236wn.m9597f(C1725pm.m7406o(bArr, m7400i3));
                        m7400i3 += 4;
                    }
                    if (m7400i3 == i11) {
                        return m7400i3;
                    }
                    throw C0839co.m2889a();
                }
                if (i5 == 5) {
                    C2236wn c2236wn2 = (C2236wn) zzfqVar;
                    c2236wn2.m9597f(C1725pm.m7406o(bArr, i));
                    while (true) {
                        int i12 = i8 + 4;
                        if (i12 >= i2) {
                            return i12;
                        }
                        i8 = C1725pm.m7400i(bArr, i12, c1876sm);
                        if (i3 != c1876sm.f6511a) {
                            return i12;
                        }
                        c2236wn2.m9597f(C1725pm.m7406o(bArr, i8));
                    }
                }
                return i8;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    C1778qo c1778qo = (C1778qo) zzfqVar;
                    int m7400i4 = C1725pm.m7400i(bArr, i8, c1876sm);
                    int i13 = c1876sm.f6511a + m7400i4;
                    while (m7400i4 < i13) {
                        m7400i4 = C1725pm.m7402k(bArr, m7400i4, c1876sm);
                        c1778qo.m7763f(c1876sm.f6512b);
                    }
                    if (m7400i4 == i13) {
                        return m7400i4;
                    }
                    throw C0839co.m2889a();
                }
                if (i5 == 0) {
                    C1778qo c1778qo2 = (C1778qo) zzfqVar;
                    int m7402k = C1725pm.m7402k(bArr, i8, c1876sm);
                    c1778qo2.m7763f(c1876sm.f6512b);
                    while (m7402k < i2) {
                        int m7400i5 = C1725pm.m7400i(bArr, m7402k, c1876sm);
                        if (i3 != c1876sm.f6511a) {
                            return m7402k;
                        }
                        m7402k = C1725pm.m7402k(bArr, m7400i5, c1876sm);
                        c1778qo2.m7763f(c1876sm.f6512b);
                    }
                    return m7402k;
                }
                return i8;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return C1725pm.m7401j(bArr, i8, zzfqVar, c1876sm);
                }
                if (i5 == 0) {
                    return C1725pm.m7393b(i3, bArr, i, i2, zzfqVar, c1876sm);
                }
                return i8;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    C1778qo c1778qo3 = (C1778qo) zzfqVar;
                    int m7400i6 = C1725pm.m7400i(bArr, i8, c1876sm);
                    int i14 = c1876sm.f6511a + m7400i6;
                    while (m7400i6 < i14) {
                        c1778qo3.m7763f(C1725pm.m7403l(bArr, m7400i6));
                        m7400i6 += 8;
                    }
                    if (m7400i6 == i14) {
                        return m7400i6;
                    }
                    throw C0839co.m2889a();
                }
                if (i5 == 1) {
                    C1778qo c1778qo4 = (C1778qo) zzfqVar;
                    c1778qo4.m7763f(C1725pm.m7403l(bArr, i));
                    while (true) {
                        int i15 = i8 + 8;
                        if (i15 >= i2) {
                            return i15;
                        }
                        i8 = C1725pm.m7400i(bArr, i15, c1876sm);
                        if (i3 != c1876sm.f6511a) {
                            return i15;
                        }
                        c1778qo4.m7763f(C1725pm.m7403l(bArr, i8));
                    }
                }
                return i8;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    C0724ao c0724ao = (C0724ao) zzfqVar;
                    int m7400i7 = C1725pm.m7400i(bArr, i8, c1876sm);
                    int i16 = c1876sm.f6511a + m7400i7;
                    while (m7400i7 < i16) {
                        c0724ao.m2168h(C1725pm.m7399h(bArr, m7400i7));
                        m7400i7 += 4;
                    }
                    if (m7400i7 == i16) {
                        return m7400i7;
                    }
                    throw C0839co.m2889a();
                }
                if (i5 == 5) {
                    C0724ao c0724ao2 = (C0724ao) zzfqVar;
                    c0724ao2.m2168h(C1725pm.m7399h(bArr, i));
                    while (true) {
                        int i17 = i8 + 4;
                        if (i17 >= i2) {
                            return i17;
                        }
                        i8 = C1725pm.m7400i(bArr, i17, c1876sm);
                        if (i3 != c1876sm.f6511a) {
                            return i17;
                        }
                        c0724ao2.m2168h(C1725pm.m7399h(bArr, i8));
                    }
                }
                return i8;
            case 25:
            case 42:
                if (i5 == 2) {
                    C1824rm c1824rm = (C1824rm) zzfqVar;
                    m7400i = C1725pm.m7400i(bArr, i8, c1876sm);
                    int i18 = c1876sm.f6511a + m7400i;
                    while (m7400i < i18) {
                        m7400i = C1725pm.m7402k(bArr, m7400i, c1876sm);
                        c1824rm.m8145f(c1876sm.f6512b != 0);
                    }
                    if (m7400i != i18) {
                        throw C0839co.m2889a();
                    }
                    return m7400i;
                }
                if (i5 == 0) {
                    C1824rm c1824rm2 = (C1824rm) zzfqVar;
                    i8 = C1725pm.m7402k(bArr, i8, c1876sm);
                    c1824rm2.m8145f(c1876sm.f6512b != 0);
                    while (i8 < i2) {
                        int m7400i8 = C1725pm.m7400i(bArr, i8, c1876sm);
                        if (i3 == c1876sm.f6511a) {
                            i8 = C1725pm.m7402k(bArr, m7400i8, c1876sm);
                            c1824rm2.m8145f(c1876sm.f6512b != 0);
                        }
                    }
                }
                return i8;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int m7400i9 = C1725pm.m7400i(bArr, i8, c1876sm);
                        int i19 = c1876sm.f6511a;
                        if (i19 < 0) {
                            throw C0839co.m2890b();
                        }
                        if (i19 == 0) {
                            zzfqVar.add("");
                        } else {
                            zzfqVar.add(new String(bArr, m7400i9, i19, C2435zn.f8565a));
                            m7400i9 += i19;
                        }
                        while (m7400i9 < i2) {
                            int m7400i10 = C1725pm.m7400i(bArr, m7400i9, c1876sm);
                            if (i3 != c1876sm.f6511a) {
                                return m7400i9;
                            }
                            m7400i9 = C1725pm.m7400i(bArr, m7400i10, c1876sm);
                            int i20 = c1876sm.f6511a;
                            if (i20 < 0) {
                                throw C0839co.m2890b();
                            }
                            if (i20 == 0) {
                                zzfqVar.add("");
                            } else {
                                zzfqVar.add(new String(bArr, m7400i9, i20, C2435zn.f8565a));
                                m7400i9 += i20;
                            }
                        }
                        return m7400i9;
                    }
                    int m7400i11 = C1725pm.m7400i(bArr, i8, c1876sm);
                    int i21 = c1876sm.f6511a;
                    if (i21 < 0) {
                        throw C0839co.m2890b();
                    }
                    if (i21 == 0) {
                        zzfqVar.add("");
                    } else {
                        int i22 = m7400i11 + i21;
                        if (!C1008fq.m3862g(bArr, m7400i11, i22)) {
                            throw C0839co.m2894f();
                        }
                        zzfqVar.add(new String(bArr, m7400i11, i21, C2435zn.f8565a));
                        m7400i11 = i22;
                    }
                    while (m7400i11 < i2) {
                        int m7400i12 = C1725pm.m7400i(bArr, m7400i11, c1876sm);
                        if (i3 != c1876sm.f6511a) {
                            return m7400i11;
                        }
                        m7400i11 = C1725pm.m7400i(bArr, m7400i12, c1876sm);
                        int i23 = c1876sm.f6511a;
                        if (i23 < 0) {
                            throw C0839co.m2890b();
                        }
                        if (i23 == 0) {
                            zzfqVar.add("");
                        } else {
                            int i24 = m7400i11 + i23;
                            if (!C1008fq.m3862g(bArr, m7400i11, i24)) {
                                throw C0839co.m2894f();
                            }
                            zzfqVar.add(new String(bArr, m7400i11, i23, C2435zn.f8565a));
                            m7400i11 = i24;
                        }
                    }
                    return m7400i11;
                }
                return i8;
            case 27:
                if (i5 == 2) {
                    return C1725pm.m7396e(m2225r(i6), i3, bArr, i, i2, zzfqVar, c1876sm);
                }
                return i8;
            case 28:
                if (i5 == 2) {
                    int m7400i13 = C1725pm.m7400i(bArr, i8, c1876sm);
                    int i25 = c1876sm.f6511a;
                    if (i25 < 0) {
                        throw C0839co.m2890b();
                    }
                    if (i25 > bArr.length - m7400i13) {
                        throw C0839co.m2889a();
                    }
                    if (i25 == 0) {
                        zzfqVar.add(AbstractC1939tm.f6790P);
                    } else {
                        zzfqVar.add(AbstractC1939tm.m8764k(bArr, m7400i13, i25));
                        m7400i13 += i25;
                    }
                    while (m7400i13 < i2) {
                        int m7400i14 = C1725pm.m7400i(bArr, m7400i13, c1876sm);
                        if (i3 != c1876sm.f6511a) {
                            return m7400i13;
                        }
                        m7400i13 = C1725pm.m7400i(bArr, m7400i14, c1876sm);
                        int i26 = c1876sm.f6511a;
                        if (i26 < 0) {
                            throw C0839co.m2890b();
                        }
                        if (i26 > bArr.length - m7400i13) {
                            throw C0839co.m2889a();
                        }
                        if (i26 == 0) {
                            zzfqVar.add(AbstractC1939tm.f6790P);
                        } else {
                            zzfqVar.add(AbstractC1939tm.m8764k(bArr, m7400i13, i26));
                            m7400i13 += i26;
                        }
                    }
                    return m7400i13;
                }
                return i8;
            case 30:
            case 44:
                if (i5 != 2) {
                    if (i5 == 0) {
                        m7400i = C1725pm.m7393b(i3, bArr, i, i2, zzfqVar, c1876sm);
                    }
                    return i8;
                }
                m7400i = C1725pm.m7401j(bArr, i8, zzfqVar, c1876sm);
                AbstractC2303xn abstractC2303xn = (AbstractC2303xn) t;
                C2437zp c2437zp = abstractC2303xn.zzb;
                if (c2437zp == C2437zp.m10576a()) {
                    c2437zp = null;
                }
                C2437zp c2437zp2 = (C2437zp) C1171ip.m4875i(i4, zzfqVar, m2215M(i6), c2437zp, this.f1498n);
                if (c2437zp2 != null) {
                    abstractC2303xn.zzb = c2437zp2;
                }
                return m7400i;
            case 33:
            case 47:
                if (i5 == 2) {
                    C0724ao c0724ao3 = (C0724ao) zzfqVar;
                    int m7400i15 = C1725pm.m7400i(bArr, i8, c1876sm);
                    int i27 = c1876sm.f6511a + m7400i15;
                    while (m7400i15 < i27) {
                        m7400i15 = C1725pm.m7400i(bArr, m7400i15, c1876sm);
                        c0724ao3.m2168h(AbstractC0838cn.m2884d(c1876sm.f6511a));
                    }
                    if (m7400i15 == i27) {
                        return m7400i15;
                    }
                    throw C0839co.m2889a();
                }
                if (i5 == 0) {
                    C0724ao c0724ao4 = (C0724ao) zzfqVar;
                    int m7400i16 = C1725pm.m7400i(bArr, i8, c1876sm);
                    c0724ao4.m2168h(AbstractC0838cn.m2884d(c1876sm.f6511a));
                    while (m7400i16 < i2) {
                        int m7400i17 = C1725pm.m7400i(bArr, m7400i16, c1876sm);
                        if (i3 != c1876sm.f6511a) {
                            return m7400i16;
                        }
                        m7400i16 = C1725pm.m7400i(bArr, m7400i17, c1876sm);
                        c0724ao4.m2168h(AbstractC0838cn.m2884d(c1876sm.f6511a));
                    }
                    return m7400i16;
                }
                return i8;
            case 34:
            case 48:
                if (i5 == 2) {
                    C1778qo c1778qo5 = (C1778qo) zzfqVar;
                    int m7400i18 = C1725pm.m7400i(bArr, i8, c1876sm);
                    int i28 = c1876sm.f6511a + m7400i18;
                    while (m7400i18 < i28) {
                        m7400i18 = C1725pm.m7402k(bArr, m7400i18, c1876sm);
                        c1778qo5.m7763f(AbstractC0838cn.m2882a(c1876sm.f6512b));
                    }
                    if (m7400i18 == i28) {
                        return m7400i18;
                    }
                    throw C0839co.m2889a();
                }
                if (i5 == 0) {
                    C1778qo c1778qo6 = (C1778qo) zzfqVar;
                    int m7402k2 = C1725pm.m7402k(bArr, i8, c1876sm);
                    c1778qo6.m7763f(AbstractC0838cn.m2882a(c1876sm.f6512b));
                    while (m7402k2 < i2) {
                        int m7400i19 = C1725pm.m7400i(bArr, m7402k2, c1876sm);
                        if (i3 != c1876sm.f6511a) {
                            return m7402k2;
                        }
                        m7402k2 = C1725pm.m7402k(bArr, m7400i19, c1876sm);
                        c1778qo6.m7763f(AbstractC0838cn.m2882a(c1876sm.f6512b));
                    }
                    return m7402k2;
                }
                return i8;
            case 49:
                if (i5 == 3) {
                    zzhi m2225r = m2225r(i6);
                    int i29 = (i3 & (-8)) | 4;
                    i8 = C1725pm.m7397f(m2225r, bArr, i, i2, i29, c1876sm);
                    zzfqVar.add(c1876sm.f6513c);
                    while (i8 < i2) {
                        int m7400i20 = C1725pm.m7400i(bArr, i8, c1876sm);
                        if (i3 == c1876sm.f6511a) {
                            i8 = C1725pm.m7397f(m2225r, bArr, m7400i20, i2, i29, c1876sm);
                            zzfqVar.add(c1876sm.f6513c);
                        }
                    }
                }
                return i8;
            default:
                return i8;
        }
    }

    /* renamed from: n */
    public final <K, V> int m2223n(T t, byte[] bArr, int i, int i2, int i3, long j, C1876sm c1876sm) throws IOException {
        Unsafe unsafe = f1484r;
        Object m2210G = m2210G(i3);
        Object object = unsafe.getObject(t, j);
        if (this.f1500p.mo1247d(object)) {
            Object mo1251h = this.f1500p.mo1251h(m2210G);
            this.f1500p.mo1249f(mo1251h, object);
            unsafe.putObject(t, j, mo1251h);
            object = mo1251h;
        }
        C1943to<?, ?> mo1250g = this.f1500p.mo1250g(m2210G);
        Map<?, ?> mo1245b = this.f1500p.mo1245b(object);
        int m7400i = C1725pm.m7400i(bArr, i, c1876sm);
        int i4 = c1876sm.f6511a;
        if (i4 < 0 || i4 > i2 - m7400i) {
            throw C0839co.m2889a();
        }
        int i5 = i4 + m7400i;
        K k = mo1250g.f6813b;
        V v = mo1250g.f6815d;
        while (m7400i < i5) {
            int i6 = m7400i + 1;
            int i7 = bArr[m7400i];
            if (i7 < 0) {
                i6 = C1725pm.m7395d(i7, bArr, i6, c1876sm);
                i7 = c1876sm.f6511a;
            }
            int i8 = i6;
            int i9 = i7 >>> 3;
            int i10 = i7 & 7;
            if (i9 != 1) {
                if (i9 == 2 && i10 == mo1250g.f6814c.m6768h()) {
                    m7400i = m2200p(bArr, i8, i2, mo1250g.f6814c, mo1250g.f6815d.getClass(), c1876sm);
                    v = c1876sm.f6513c;
                }
                m7400i = C1725pm.m7392a(i7, bArr, i8, i2, c1876sm);
            } else if (i10 == mo1250g.f6812a.m6768h()) {
                m7400i = m2200p(bArr, i8, i2, mo1250g.f6812a, null, c1876sm);
                k = (K) c1876sm.f6513c;
            } else {
                m7400i = C1725pm.m7392a(i7, bArr, i8, i2, c1876sm);
            }
        }
        if (m7400i != i5) {
            throw C0839co.m2893e();
        }
        mo1245b.put(k, v);
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x04c9, code lost:
    
        if (r6 == 1048575) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x04cb, code lost:
    
        r26.putInt(r12, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x04d1, code lost:
    
        r1 = null;
        r2 = r9.f1494j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x04d6, code lost:
    
        if (r2 >= r9.f1495k) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x04d8, code lost:
    
        r1 = (cz.opentree.C2437zp) r9.m2227t(r12, r9.f1493i[r2], r1, r9.f1498n);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x04e7, code lost:
    
        if (r1 == null) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x04e9, code lost:
    
        r9.f1498n.mo9616h(r12, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x04ee, code lost:
    
        if (r7 != 0) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x04f2, code lost:
    
        if (r0 != r31) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x04f9, code lost:
    
        throw cz.opentree.C0839co.m2893e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0500, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x04fc, code lost:
    
        if (r0 > r31) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x04fe, code lost:
    
        if (r3 != r7) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0505, code lost:
    
        throw cz.opentree.C0839co.m2893e();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:111:0x0089. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m2224o(T r28, byte[] r29, int r30, int r31, int r32, cz.opentree.C1876sm r33) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0732ap.m2224o(java.lang.Object, byte[], int, int, int, cz.opentree.sm):int");
    }

    /* renamed from: r */
    public final zzhi m2225r(int i) {
        int i2 = (i / 3) << 1;
        zzhi zzhiVar = (zzhi) this.f1486b[i2];
        if (zzhiVar != null) {
            return zzhiVar;
        }
        zzhi<T> m3852b = C1007fp.m3851a().m3852b((Class) this.f1486b[i2 + 1]);
        this.f1486b[i2] = m3852b;
        return m3852b;
    }

    /* renamed from: s */
    public final <K, V, UT, UB> UB m2226s(int i, int i2, Map<K, V> map, zzfp zzfpVar, UB ub, AbstractC2238wp<UT, UB> abstractC2238wp) {
        C1943to<?, ?> mo1250g = this.f1500p.mo1250g(m2210G(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzfpVar.mo1235c(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = abstractC2238wp.mo9609a();
                }
                C2433zm m8766r = AbstractC1939tm.m8766r(C2024uo.m8966a(mo1250g, next.getKey(), next.getValue()));
                try {
                    C2024uo.m8967b(m8766r.m10505b(), mo1250g, next.getKey(), next.getValue());
                    abstractC2238wp.mo9611c(ub, i2, m8766r.m10504a());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* renamed from: t */
    public final <UT, UB> UB m2227t(Object obj, int i, UB ub, AbstractC2238wp<UT, UB> abstractC2238wp) {
        zzfp m2215M;
        int i2 = this.f1485a[i];
        Object m2907F = C0841cq.m2907F(obj, m2217O(i) & 1048575);
        return (m2907F == null || (m2215M = m2215M(i)) == null) ? ub : (UB) m2226s(i, i2, this.f1500p.mo1245b(m2907F), m2215M, ub, abstractC2238wp);
    }

    /* renamed from: y */
    public final <K, V> void m2228y(zzix zzixVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzixVar.mo1290G(i, this.f1500p.mo1250g(m2210G(i2)), this.f1500p.mo1248e(obj));
        }
    }

    /* renamed from: z */
    public final void m2229z(T t, T t2, int i) {
        long m2217O = m2217O(i) & 1048575;
        if (m2206A(t2, i)) {
            Object m2907F = C0841cq.m2907F(t, m2217O);
            Object m2907F2 = C0841cq.m2907F(t2, m2217O);
            if (m2907F != null && m2907F2 != null) {
                C0841cq.m2926j(t, m2217O, C2435zn.m10539e(m2907F, m2907F2));
                m2211H(t, i);
            } else if (m2907F2 != null) {
                C0841cq.m2926j(t, m2217O, m2907F2);
                m2211H(t, i);
            }
        }
    }
}
