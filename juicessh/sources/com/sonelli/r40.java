package com.sonelli;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.sonelli.C0886dk;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public abstract class r40 {

    /* renamed from: a */
    public String f6171a;

    /* renamed from: b */
    public int f6172b;

    /* renamed from: c */
    public Boolean f6173c;

    /* renamed from: d */
    public Boolean f6174d;

    /* renamed from: e */
    public Long f6175e;

    /* renamed from: f */
    public Long f6176f;

    public r40(String str, int i) {
        this.f6171a = str;
        this.f6172b = i;
    }

    /* renamed from: b */
    public static Boolean m7862b(double d, C0781bk c0781bk) {
        try {
            return m7868h(new BigDecimal(d), c0781bk, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static Boolean m7863c(long j, C0781bk c0781bk) {
        try {
            return m7868h(new BigDecimal(j), c0781bk, ShadowDrawableWrapper.COS_45);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: d */
    public static Boolean m7864d(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    /* renamed from: e */
    public static Boolean m7865e(String str, C0781bk c0781bk) {
        if (!d40.m3128T(str)) {
            return null;
        }
        try {
            return m7868h(new BigDecimal(str), c0781bk, ShadowDrawableWrapper.COS_45);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* renamed from: f */
    public static Boolean m7866f(String str, C0886dk.b bVar, boolean z, String str2, List<String> list, String str3, C1889sy c1889sy) {
        if (str == null) {
            return null;
        }
        if (bVar == C0886dk.b.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && bVar != C0886dk.b.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (n40.f5225a[bVar.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (c1889sy != null) {
                        c1889sy.m8525K().m9084b("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    /* renamed from: g */
    public static Boolean m7867g(String str, C0886dk c0886dk, C1889sy c1889sy) {
        List<String> list;
        C0813ca.m2729k(c0886dk);
        if (str == null || !c0886dk.m3235D() || c0886dk.m3236E() == C0886dk.b.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        C0886dk.b m3236E = c0886dk.m3236E();
        C0886dk.b bVar = C0886dk.b.IN_LIST;
        if (m3236E == bVar) {
            if (c0886dk.m3242L() == 0) {
                return null;
            }
        } else if (!c0886dk.m3237F()) {
            return null;
        }
        C0886dk.b m3236E2 = c0886dk.m3236E();
        boolean m3240I = c0886dk.m3240I();
        String m3238G = (m3240I || m3236E2 == C0886dk.b.REGEXP || m3236E2 == bVar) ? c0886dk.m3238G() : c0886dk.m3238G().toUpperCase(Locale.ENGLISH);
        if (c0886dk.m3242L() == 0) {
            list = null;
        } else {
            List<String> m3241J = c0886dk.m3241J();
            if (!m3240I) {
                ArrayList arrayList = new ArrayList(m3241J.size());
                Iterator<String> it = m3241J.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
                }
                m3241J = Collections.unmodifiableList(arrayList);
            }
            list = m3241J;
        }
        return m7866f(str, m3236E2, m3240I, m3238G, list, m3236E2 == C0886dk.b.REGEXP ? m3238G : null, c1889sy);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0081, code lost:
    
        if (r3 != null) goto L37;
     */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Boolean m7868h(java.math.BigDecimal r9, com.sonelli.C0781bk r10, double r11) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.r40.m7868h(java.math.BigDecimal, com.sonelli.bk, double):java.lang.Boolean");
    }

    /* renamed from: a */
    public abstract int mo7869a();

    /* renamed from: i */
    public abstract boolean mo7870i();

    /* renamed from: j */
    public abstract boolean mo7871j();
}
