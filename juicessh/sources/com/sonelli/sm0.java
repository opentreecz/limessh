package com.sonelli;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: MediaType.java */
/* loaded from: classes.dex */
public final class sm0 {

    /* renamed from: d */
    public static final Pattern f6515d = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: e */
    public static final Pattern f6516e = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: a */
    public final String f6517a;

    /* renamed from: b */
    public final String f6518b;

    /* renamed from: c */
    @Nullable
    public final String f6519c;

    public sm0(String str, String str2, String str3, @Nullable String str4) {
        this.f6517a = str;
        this.f6518b = str2;
        this.f6519c = str4;
    }

    /* renamed from: c */
    public static sm0 m8469c(String str) {
        Matcher matcher = f6515d.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String group = matcher.group(1);
        Locale locale = Locale.US;
        String lowerCase = group.toLowerCase(locale);
        String lowerCase2 = matcher.group(2).toLowerCase(locale);
        String str2 = null;
        Matcher matcher2 = f6516e.matcher(str);
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(end) + "\" for: \"" + str + '\"');
            }
            String group2 = matcher2.group(1);
            if (group2 != null && group2.equalsIgnoreCase("charset")) {
                String group3 = matcher2.group(2);
                if (group3 == null) {
                    group3 = matcher2.group(3);
                } else if (group3.startsWith("'") && group3.endsWith("'") && group3.length() > 2) {
                    group3 = group3.substring(1, group3.length() - 1);
                }
                if (str2 != null && !group3.equalsIgnoreCase(str2)) {
                    throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + group3 + "\" for: \"" + str + '\"');
                }
                str2 = group3;
            }
        }
        return new sm0(str, lowerCase, lowerCase2, str2);
    }

    @Nullable
    /* renamed from: d */
    public static sm0 m8470d(String str) {
        try {
            return m8469c(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @Nullable
    /* renamed from: a */
    public Charset m8471a() {
        return m8472b(null);
    }

    @Nullable
    /* renamed from: b */
    public Charset m8472b(@Nullable Charset charset) {
        try {
            String str = this.f6519c;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    /* renamed from: e */
    public String m8473e() {
        return this.f6518b;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof sm0) && ((sm0) obj).f6517a.equals(this.f6517a);
    }

    public int hashCode() {
        return this.f6517a.hashCode();
    }

    public String toString() {
        return this.f6517a;
    }
}
