package com.sonelli;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: Cookie.java */
/* loaded from: classes.dex */
public final class nm0 {

    /* renamed from: j */
    public static final Pattern f5312j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k */
    public static final Pattern f5313k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l */
    public static final Pattern f5314l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m */
    public static final Pattern f5315m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a */
    public final String f5316a;

    /* renamed from: b */
    public final String f5317b;

    /* renamed from: c */
    public final long f5318c;

    /* renamed from: d */
    public final String f5319d;

    /* renamed from: e */
    public final String f5320e;

    /* renamed from: f */
    public final boolean f5321f;

    /* renamed from: g */
    public final boolean f5322g;

    /* renamed from: h */
    public final boolean f5323h;

    /* renamed from: i */
    public final boolean f5324i;

    public nm0(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f5316a = str;
        this.f5317b = str2;
        this.f5318c = j;
        this.f5319d = str3;
        this.f5320e = str4;
        this.f5321f = z;
        this.f5322g = z2;
        this.f5324i = z3;
        this.f5323h = z4;
    }

    /* renamed from: a */
    public static int m6740a(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: b */
    public static boolean m6741b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !fn0.m3819J(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f0  */
    @javax.annotation.Nullable
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.sonelli.nm0 m6742d(long r23, com.sonelli.rm0 r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.nm0.m6742d(long, com.sonelli.rm0, java.lang.String):com.sonelli.nm0");
    }

    @Nullable
    /* renamed from: e */
    public static nm0 m6743e(rm0 rm0Var, String str) {
        return m6742d(System.currentTimeMillis(), rm0Var, str);
    }

    /* renamed from: f */
    public static List<nm0> m6744f(rm0 rm0Var, qm0 qm0Var) {
        List<String> m7754j = qm0Var.m7754j("Set-Cookie");
        int size = m7754j.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            nm0 m6743e = m6743e(rm0Var, m7754j.get(i));
            if (m6743e != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(m6743e);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    /* renamed from: g */
    public static String m6745g(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String m3823d = fn0.m3823d(str);
        if (m3823d != null) {
            return m3823d;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: h */
    public static long m6746h(String str, int i, int i2) {
        int m6740a = m6740a(str, i, i2, false);
        Matcher matcher = f5315m.matcher(str);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (m6740a < i2) {
            int m6740a2 = m6740a(str, m6740a + 1, i2, true);
            matcher.region(m6740a, m6740a2);
            if (i4 == -1 && matcher.usePattern(f5315m).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
                i7 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
            } else if (i5 == -1 && matcher.usePattern(f5314l).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
            } else {
                if (i6 == -1) {
                    Pattern pattern = f5313k;
                    if (matcher.usePattern(pattern).matches()) {
                        i6 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i3 == -1 && matcher.usePattern(f5312j).matches()) {
                    i3 = Integer.parseInt(matcher.group(1));
                }
            }
            m6740a = m6740a(str, m6740a2 + 1, i2, false);
        }
        if (i3 >= 70 && i3 <= 99) {
            i3 += 1900;
        }
        if (i3 >= 0 && i3 <= 69) {
            i3 += RecyclerView.MAX_SCROLL_DURATION;
        }
        if (i3 < 1601) {
            throw new IllegalArgumentException();
        }
        if (i6 == -1) {
            throw new IllegalArgumentException();
        }
        if (i5 < 1 || i5 > 31) {
            throw new IllegalArgumentException();
        }
        if (i4 < 0 || i4 > 23) {
            throw new IllegalArgumentException();
        }
        if (i7 < 0 || i7 > 59) {
            throw new IllegalArgumentException();
        }
        if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(fn0.f2735n);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i3);
        gregorianCalendar.set(2, i6 - 1);
        gregorianCalendar.set(5, i5);
        gregorianCalendar.set(11, i4);
        gregorianCalendar.set(12, i7);
        gregorianCalendar.set(13, i8);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    /* renamed from: i */
    public static long m6747i(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (!str.matches("-?\\d+")) {
                throw e;
            }
            if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            }
            return RecyclerView.FOREVER_NS;
        }
    }

    /* renamed from: c */
    public String m6748c() {
        return this.f5316a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof nm0)) {
            return false;
        }
        nm0 nm0Var = (nm0) obj;
        return nm0Var.f5316a.equals(this.f5316a) && nm0Var.f5317b.equals(this.f5317b) && nm0Var.f5319d.equals(this.f5319d) && nm0Var.f5320e.equals(this.f5320e) && nm0Var.f5318c == this.f5318c && nm0Var.f5321f == this.f5321f && nm0Var.f5322g == this.f5322g && nm0Var.f5323h == this.f5323h && nm0Var.f5324i == this.f5324i;
    }

    public int hashCode() {
        int hashCode = (((((((527 + this.f5316a.hashCode()) * 31) + this.f5317b.hashCode()) * 31) + this.f5319d.hashCode()) * 31) + this.f5320e.hashCode()) * 31;
        long j = this.f5318c;
        return ((((((((hashCode + ((int) (j ^ (j >>> 32)))) * 31) + (!this.f5321f ? 1 : 0)) * 31) + (!this.f5322g ? 1 : 0)) * 31) + (!this.f5323h ? 1 : 0)) * 31) + (!this.f5324i ? 1 : 0);
    }

    /* renamed from: j */
    public String m6749j(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5316a);
        sb.append('=');
        sb.append(this.f5317b);
        if (this.f5323h) {
            if (this.f5318c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(sn0.m8475a(new Date(this.f5318c)));
            }
        }
        if (!this.f5324i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f5319d);
        }
        sb.append("; path=");
        sb.append(this.f5320e);
        if (this.f5321f) {
            sb.append("; secure");
        }
        if (this.f5322g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    /* renamed from: k */
    public String m6750k() {
        return this.f5317b;
    }

    public String toString() {
        return m6749j(false);
    }
}
