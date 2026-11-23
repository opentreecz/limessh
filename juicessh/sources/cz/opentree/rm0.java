package cz.opentree;

import com.google.android.material.badge.BadgeDrawable;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: HttpUrl.java */
/* loaded from: classes.dex */
public final class rm0 {

    /* renamed from: j */
    public static final char[] f6243j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public final String f6244a;

    /* renamed from: b */
    public final String f6245b;

    /* renamed from: c */
    public final String f6246c;

    /* renamed from: d */
    public final String f6247d;

    /* renamed from: e */
    public final int f6248e;

    /* renamed from: f */
    public final List<String> f6249f;

    /* renamed from: g */
    @Nullable
    public final List<String> f6250g;

    /* renamed from: h */
    @Nullable
    public final String f6251h;

    /* renamed from: i */
    public final String f6252i;

    /* compiled from: HttpUrl.java */
    /* renamed from: cz.opentree.rm0$a */
    /* loaded from: classes.dex */
    public static final class C1825a {

        /* renamed from: a */
        @Nullable
        public String f6253a;

        /* renamed from: d */
        @Nullable
        public String f6256d;

        /* renamed from: f */
        public final List<String> f6258f;

        /* renamed from: g */
        @Nullable
        public List<String> f6259g;

        /* renamed from: h */
        @Nullable
        public String f6260h;

        /* renamed from: b */
        public String f6254b = "";

        /* renamed from: c */
        public String f6255c = "";

        /* renamed from: e */
        public int f6257e = -1;

        public C1825a() {
            ArrayList arrayList = new ArrayList();
            this.f6258f = arrayList;
            arrayList.add("");
        }

        /* renamed from: c */
        public static String m8178c(String str, int i, int i2) {
            return fn0.m3823d(rm0.m8156s(str, i, i2, false));
        }

        /* renamed from: j */
        public static int m8179j(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(rm0.m8148a(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        /* renamed from: n */
        public static int m8180n(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt != '[') {
                    i++;
                }
                do {
                    i++;
                    if (i < i2) {
                    }
                    i++;
                } while (str.charAt(i) != ']');
                i++;
            }
            return i2;
        }

        /* renamed from: s */
        public static int m8181s(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        /* renamed from: t */
        public static int m8182t(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        /* renamed from: a */
        public C1825a m8183a(String str, @Nullable String str2) {
            Objects.requireNonNull(str, "encodedName == null");
            if (this.f6259g == null) {
                this.f6259g = new ArrayList();
            }
            this.f6259g.add(rm0.m8149b(str, " \"'<>#&=", true, false, true, true));
            this.f6259g.add(str2 != null ? rm0.m8149b(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        /* renamed from: b */
        public rm0 m8184b() {
            if (this.f6253a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f6256d != null) {
                return new rm0(this);
            }
            throw new IllegalStateException("host == null");
        }

        /* renamed from: d */
        public int m8185d() {
            int i = this.f6257e;
            return i != -1 ? i : rm0.m8151d(this.f6253a);
        }

        /* renamed from: e */
        public C1825a m8186e(@Nullable String str) {
            this.f6259g = str != null ? rm0.m8160z(rm0.m8149b(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        /* renamed from: f */
        public C1825a m8187f(String str) {
            Objects.requireNonNull(str, "host == null");
            String m8178c = m8178c(str, 0, str.length());
            if (m8178c != null) {
                this.f6256d = m8178c;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        /* renamed from: g */
        public final boolean m8188g(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        /* renamed from: h */
        public final boolean m8189h(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* renamed from: i */
        public C1825a m8190i(@Nullable rm0 rm0Var, String str) {
            int m3834o;
            int i;
            int m3814E = fn0.m3814E(str, 0, str.length());
            int m3815F = fn0.m3815F(str, m3814E, str.length());
            int m8181s = m8181s(str, m3814E, m3815F);
            if (m8181s != -1) {
                if (str.regionMatches(true, m3814E, "https:", 0, 6)) {
                    this.f6253a = "https";
                    m3814E += 6;
                } else {
                    if (!str.regionMatches(true, m3814E, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, m8181s) + "'");
                    }
                    this.f6253a = "http";
                    m3814E += 5;
                }
            } else {
                if (rm0Var == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f6253a = rm0Var.f6244a;
            }
            int m8182t = m8182t(str, m3814E, m3815F);
            char c = '?';
            char c2 = '#';
            if (m8182t >= 2 || rm0Var == null || !rm0Var.f6244a.equals(this.f6253a)) {
                boolean z = false;
                boolean z2 = false;
                int i2 = m3814E + m8182t;
                while (true) {
                    m3834o = fn0.m3834o(str, i2, m3815F, "@/\\?#");
                    char charAt = m3834o != m3815F ? str.charAt(m3834o) : (char) 65535;
                    if (charAt == 65535 || charAt == c2 || charAt == '/' || charAt == '\\' || charAt == c) {
                        break;
                    }
                    if (charAt == '@') {
                        if (z) {
                            i = m3834o;
                            this.f6255c += "%40" + rm0.m8148a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int m3833n = fn0.m3833n(str, i2, m3834o, ':');
                            i = m3834o;
                            String m8148a = rm0.m8148a(str, i2, m3833n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                m8148a = this.f6254b + "%40" + m8148a;
                            }
                            this.f6254b = m8148a;
                            if (m3833n != i) {
                                this.f6255c = rm0.m8148a(str, m3833n + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        }
                        i2 = i + 1;
                    }
                    c = '?';
                    c2 = '#';
                }
                int m8180n = m8180n(str, i2, m3834o);
                int i3 = m8180n + 1;
                if (i3 < m3834o) {
                    this.f6256d = m8178c(str, i2, m8180n);
                    int m8179j = m8179j(str, i3, m3834o);
                    this.f6257e = m8179j;
                    if (m8179j == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i3, m3834o) + '\"');
                    }
                } else {
                    this.f6256d = m8178c(str, i2, m8180n);
                    this.f6257e = rm0.m8151d(this.f6253a);
                }
                if (this.f6256d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, m8180n) + '\"');
                }
                m3814E = m3834o;
            } else {
                this.f6254b = rm0Var.m8170j();
                this.f6255c = rm0Var.m8166f();
                this.f6256d = rm0Var.f6247d;
                this.f6257e = rm0Var.f6248e;
                this.f6258f.clear();
                this.f6258f.addAll(rm0Var.m8168h());
                if (m3814E == m3815F || str.charAt(m3814E) == '#') {
                    m8186e(rm0Var.m8169i());
                }
            }
            int m3834o2 = fn0.m3834o(str, m3814E, m3815F, "?#");
            m8196q(str, m3814E, m3834o2);
            if (m3834o2 < m3815F && str.charAt(m3834o2) == '?') {
                int m3833n2 = fn0.m3833n(str, m3834o2, m3815F, '#');
                this.f6259g = rm0.m8160z(rm0.m8148a(str, m3834o2 + 1, m3833n2, " \"'<>#", true, false, true, true, null));
                m3834o2 = m3833n2;
            }
            if (m3834o2 < m3815F && str.charAt(m3834o2) == '#') {
                this.f6260h = rm0.m8148a(str, 1 + m3834o2, m3815F, "", true, false, false, false, null);
            }
            return this;
        }

        /* renamed from: k */
        public C1825a m8191k(String str) {
            Objects.requireNonNull(str, "password == null");
            this.f6255c = rm0.m8149b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        /* renamed from: l */
        public final void m8192l() {
            if (!this.f6258f.remove(r0.size() - 1).isEmpty() || this.f6258f.isEmpty()) {
                this.f6258f.add("");
            } else {
                this.f6258f.set(r0.size() - 1, "");
            }
        }

        /* renamed from: m */
        public C1825a m8193m(int i) {
            if (i > 0 && i <= 65535) {
                this.f6257e = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        /* renamed from: o */
        public final void m8194o(String str, int i, int i2, boolean z, boolean z2) {
            String m8148a = rm0.m8148a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (m8188g(m8148a)) {
                return;
            }
            if (m8189h(m8148a)) {
                m8192l();
                return;
            }
            if (this.f6258f.get(r11.size() - 1).isEmpty()) {
                this.f6258f.set(r11.size() - 1, m8148a);
            } else {
                this.f6258f.add(m8148a);
            }
            if (z) {
                this.f6258f.add("");
            }
        }

        /* renamed from: p */
        public C1825a m8195p() {
            int size = this.f6258f.size();
            for (int i = 0; i < size; i++) {
                this.f6258f.set(i, rm0.m8149b(this.f6258f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.f6259g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.f6259g.get(i2);
                    if (str != null) {
                        this.f6259g.set(i2, rm0.m8149b(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f6260h;
            if (str2 != null) {
                this.f6260h = rm0.m8149b(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        /* renamed from: q */
        public final void m8196q(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '\\') {
                this.f6258f.clear();
                this.f6258f.add("");
                i++;
            } else {
                List<String> list = this.f6258f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = fn0.m3834o(str, i3, i2, "/\\");
                boolean z = i < i2;
                m8194o(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        /* renamed from: r */
        public C1825a m8197r(String str) {
            Objects.requireNonNull(str, "scheme == null");
            if (str.equalsIgnoreCase("http")) {
                this.f6253a = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.f6253a = "https";
            }
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f6253a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.f6254b.isEmpty() || !this.f6255c.isEmpty()) {
                sb.append(this.f6254b);
                if (!this.f6255c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f6255c);
                }
                sb.append('@');
            }
            String str2 = this.f6256d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f6256d);
                    sb.append(']');
                } else {
                    sb.append(this.f6256d);
                }
            }
            if (this.f6257e != -1 || this.f6253a != null) {
                int m8185d = m8185d();
                String str3 = this.f6253a;
                if (str3 == null || m8185d != rm0.m8151d(str3)) {
                    sb.append(':');
                    sb.append(m8185d);
                }
            }
            rm0.m8155r(sb, this.f6258f);
            if (this.f6259g != null) {
                sb.append('?');
                rm0.m8153n(sb, this.f6259g);
            }
            if (this.f6260h != null) {
                sb.append('#');
                sb.append(this.f6260h);
            }
            return sb.toString();
        }

        /* renamed from: u */
        public C1825a m8198u(String str) {
            Objects.requireNonNull(str, "username == null");
            this.f6254b = rm0.m8149b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }
    }

    public rm0(C1825a c1825a) {
        this.f6244a = c1825a.f6253a;
        this.f6245b = m8157t(c1825a.f6254b, false);
        this.f6246c = m8157t(c1825a.f6255c, false);
        this.f6247d = c1825a.f6256d;
        this.f6248e = c1825a.m8185d();
        this.f6249f = m8175u(c1825a.f6258f, false);
        List<String> list = c1825a.f6259g;
        this.f6250g = list != null ? m8175u(list, true) : null;
        String str = c1825a.f6260h;
        this.f6251h = str != null ? m8157t(str, false) : null;
        this.f6252i = c1825a.toString();
    }

    /* renamed from: a */
    public static String m8148a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || m8159w(str, i3, i2)))) && (codePointAt != 43 || !z3))) {
                    i3 += Character.charCount(codePointAt);
                }
            }
            zo0 zo0Var = new zo0();
            zo0Var.m10572t0(str, i, i3);
            m8150c(zo0Var, str, i3, i2, str2, z, z2, z3, z4, charset);
            return zo0Var.m10553c0();
        }
        return str.substring(i, i2);
    }

    /* renamed from: b */
    public static String m8149b(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return m8148a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }

    /* renamed from: c */
    public static void m8150c(zo0 zo0Var, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        zo0 zo0Var2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    zo0Var.m10571s0(z ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !m8159w(str, i, i2)))))) {
                    if (zo0Var2 == null) {
                        zo0Var2 = new zo0();
                    }
                    if (charset == null || charset.equals(fn0.f2730i)) {
                        zo0Var2.m10573u0(codePointAt);
                    } else {
                        zo0Var2.m10570r0(str, i, Character.charCount(codePointAt) + i, charset);
                    }
                    while (!zo0Var2.mo4907s()) {
                        int readByte = zo0Var2.readByte() & 255;
                        zo0Var.m10565m0(37);
                        char[] cArr = f6243j;
                        zo0Var.m10565m0(cArr[(readByte >> 4) & 15]);
                        zo0Var.m10565m0(cArr[readByte & 15]);
                    }
                } else {
                    zo0Var.m10573u0(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: d */
    public static int m8151d(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* renamed from: k */
    public static rm0 m8152k(String str) {
        C1825a c1825a = new C1825a();
        c1825a.m8190i(null, str);
        return c1825a.m8184b();
    }

    /* renamed from: n */
    public static void m8153n(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    @Nullable
    /* renamed from: q */
    public static rm0 m8154q(String str) {
        try {
            return m8152k(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: r */
    public static void m8155r(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    /* renamed from: s */
    public static String m8156s(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                zo0 zo0Var = new zo0();
                zo0Var.m10572t0(str, i, i3);
                m8158v(zo0Var, str, i3, i2, z);
                return zo0Var.m10553c0();
            }
        }
        return str.substring(i, i2);
    }

    /* renamed from: t */
    public static String m8157t(String str, boolean z) {
        return m8156s(str, 0, str.length(), z);
    }

    /* renamed from: v */
    public static void m8158v(zo0 zo0Var, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt != 37 || (i3 = i + 2) >= i2) {
                if (codePointAt == 43 && z) {
                    zo0Var.m10565m0(32);
                }
                zo0Var.m10573u0(codePointAt);
            } else {
                int m3830k = fn0.m3830k(str.charAt(i + 1));
                int m3830k2 = fn0.m3830k(str.charAt(i3));
                if (m3830k != -1 && m3830k2 != -1) {
                    zo0Var.m10565m0((m3830k << 4) + m3830k2);
                    i = i3;
                }
                zo0Var.m10573u0(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    /* renamed from: w */
    public static boolean m8159w(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && fn0.m3830k(str.charAt(i + 1)) != -1 && fn0.m3830k(str.charAt(i3)) != -1;
    }

    /* renamed from: z */
    public static List<String> m8160z(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    /* renamed from: A */
    public String m8161A() {
        C1825a m8174p = m8174p("/...");
        m8174p.m8198u("");
        m8174p.m8191k("");
        return m8174p.m8184b().toString();
    }

    @Nullable
    /* renamed from: B */
    public rm0 m8162B(String str) {
        C1825a m8174p = m8174p(str);
        if (m8174p != null) {
            return m8174p.m8184b();
        }
        return null;
    }

    /* renamed from: C */
    public String m8163C() {
        return this.f6244a;
    }

    /* renamed from: D */
    public URI m8164D() {
        C1825a m8173o = m8173o();
        m8173o.m8195p();
        String c1825a = m8173o.toString();
        try {
            return new URI(c1825a);
        } catch (URISyntaxException e) {
            try {
                return URI.create(c1825a.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    @Nullable
    /* renamed from: e */
    public String m8165e() {
        if (this.f6251h == null) {
            return null;
        }
        return this.f6252i.substring(this.f6252i.indexOf(35) + 1);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof rm0) && ((rm0) obj).f6252i.equals(this.f6252i);
    }

    /* renamed from: f */
    public String m8166f() {
        if (this.f6246c.isEmpty()) {
            return "";
        }
        return this.f6252i.substring(this.f6252i.indexOf(58, this.f6244a.length() + 3) + 1, this.f6252i.indexOf(64));
    }

    /* renamed from: g */
    public String m8167g() {
        int indexOf = this.f6252i.indexOf(47, this.f6244a.length() + 3);
        String str = this.f6252i;
        return this.f6252i.substring(indexOf, fn0.m3834o(str, indexOf, str.length(), "?#"));
    }

    /* renamed from: h */
    public List<String> m8168h() {
        int indexOf = this.f6252i.indexOf(47, this.f6244a.length() + 3);
        String str = this.f6252i;
        int m3834o = fn0.m3834o(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < m3834o) {
            int i = indexOf + 1;
            int m3833n = fn0.m3833n(this.f6252i, i, m3834o, '/');
            arrayList.add(this.f6252i.substring(i, m3833n));
            indexOf = m3833n;
        }
        return arrayList;
    }

    public int hashCode() {
        return this.f6252i.hashCode();
    }

    @Nullable
    /* renamed from: i */
    public String m8169i() {
        if (this.f6250g == null) {
            return null;
        }
        int indexOf = this.f6252i.indexOf(63) + 1;
        String str = this.f6252i;
        return this.f6252i.substring(indexOf, fn0.m3833n(str, indexOf, str.length(), '#'));
    }

    /* renamed from: j */
    public String m8170j() {
        if (this.f6245b.isEmpty()) {
            return "";
        }
        int length = this.f6244a.length() + 3;
        String str = this.f6252i;
        return this.f6252i.substring(length, fn0.m3834o(str, length, str.length(), ":@"));
    }

    /* renamed from: l */
    public String m8171l() {
        return this.f6247d;
    }

    /* renamed from: m */
    public boolean m8172m() {
        return this.f6244a.equals("https");
    }

    /* renamed from: o */
    public C1825a m8173o() {
        C1825a c1825a = new C1825a();
        c1825a.f6253a = this.f6244a;
        c1825a.f6254b = m8170j();
        c1825a.f6255c = m8166f();
        c1825a.f6256d = this.f6247d;
        c1825a.f6257e = this.f6248e != m8151d(this.f6244a) ? this.f6248e : -1;
        c1825a.f6258f.clear();
        c1825a.f6258f.addAll(m8168h());
        c1825a.m8186e(m8169i());
        c1825a.f6260h = m8165e();
        return c1825a;
    }

    @Nullable
    /* renamed from: p */
    public C1825a m8174p(String str) {
        try {
            C1825a c1825a = new C1825a();
            c1825a.m8190i(this, str);
            return c1825a;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String toString() {
        return this.f6252i;
    }

    /* renamed from: u */
    public final List<String> m8175u(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? m8157t(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: x */
    public int m8176x() {
        return this.f6248e;
    }

    @Nullable
    /* renamed from: y */
    public String m8177y() {
        if (this.f6250g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        m8153n(sb, this.f6250g);
        return sb.toString();
    }
}
