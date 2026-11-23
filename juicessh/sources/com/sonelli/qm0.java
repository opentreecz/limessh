package com.sonelli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: Headers.java */
/* loaded from: classes.dex */
public final class qm0 {

    /* renamed from: a */
    public final String[] f6054a;

    /* compiled from: Headers.java */
    /* renamed from: com.sonelli.qm0$a */
    /* loaded from: classes.dex */
    public static final class C1776a {

        /* renamed from: a */
        public final List<String> f6055a = new ArrayList(20);

        /* renamed from: a */
        public C1776a m7755a(String str, String str2) {
            qm0.m7745a(str);
            qm0.m7746b(str2, str);
            m7757c(str, str2);
            return this;
        }

        /* renamed from: b */
        public C1776a m7756b(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                m7757c(str.substring(0, indexOf), str.substring(indexOf + 1));
                return this;
            }
            if (str.startsWith(":")) {
                m7757c("", str.substring(1));
                return this;
            }
            m7757c("", str);
            return this;
        }

        /* renamed from: c */
        public C1776a m7757c(String str, String str2) {
            this.f6055a.add(str);
            this.f6055a.add(str2.trim());
            return this;
        }

        /* renamed from: d */
        public qm0 m7758d() {
            return new qm0(this);
        }

        /* renamed from: e */
        public C1776a m7759e(String str) {
            int i = 0;
            while (i < this.f6055a.size()) {
                if (str.equalsIgnoreCase(this.f6055a.get(i))) {
                    this.f6055a.remove(i);
                    this.f6055a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        /* renamed from: f */
        public C1776a m7760f(String str, String str2) {
            qm0.m7745a(str);
            qm0.m7746b(str2, str);
            m7759e(str);
            m7757c(str, str2);
            return this;
        }
    }

    public qm0(C1776a c1776a) {
        List<String> list = c1776a.f6055a;
        this.f6054a = (String[]) list.toArray(new String[list.size()]);
    }

    public qm0(String[] strArr) {
        this.f6054a = strArr;
    }

    /* renamed from: a */
    public static void m7745a(String str) {
        Objects.requireNonNull(str, "name == null");
        if (str.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= ' ' || charAt >= 127) {
                throw new IllegalArgumentException(fn0.m3837r("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
            }
        }
    }

    /* renamed from: b */
    public static void m7746b(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                throw new IllegalArgumentException(fn0.m3837r("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str));
            }
        }
    }

    /* renamed from: d */
    public static String m7747d(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: g */
    public static qm0 m7748g(String... strArr) {
        Objects.requireNonNull(strArr, "namesAndValues == null");
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            if (strArr2[i] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = strArr2[i].trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            String str = strArr2[i2];
            String str2 = strArr2[i2 + 1];
            m7745a(str);
            m7746b(str2, str);
        }
        return new qm0(strArr2);
    }

    @Nullable
    /* renamed from: c */
    public String m7749c(String str) {
        return m7747d(this.f6054a, str);
    }

    /* renamed from: e */
    public String m7750e(int i) {
        return this.f6054a[i * 2];
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof qm0) && Arrays.equals(((qm0) obj).f6054a, this.f6054a);
    }

    /* renamed from: f */
    public C1776a m7751f() {
        C1776a c1776a = new C1776a();
        Collections.addAll(c1776a.f6055a, this.f6054a);
        return c1776a;
    }

    /* renamed from: h */
    public int m7752h() {
        return this.f6054a.length / 2;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f6054a);
    }

    /* renamed from: i */
    public String m7753i(int i) {
        return this.f6054a[(i * 2) + 1];
    }

    /* renamed from: j */
    public List<String> m7754j(String str) {
        int m7752h = m7752h();
        ArrayList arrayList = null;
        for (int i = 0; i < m7752h; i++) {
            if (str.equalsIgnoreCase(m7750e(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(m7753i(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int m7752h = m7752h();
        for (int i = 0; i < m7752h; i++) {
            sb.append(m7750e(i));
            sb.append(": ");
            sb.append(m7753i(i));
            sb.append("\n");
        }
        return sb.toString();
    }
}
