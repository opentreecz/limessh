package com.amazonaws.util;

import java.nio.charset.Charset;
import java.util.Locale;

/* loaded from: classes.dex */
public class StringUtils {

    /* renamed from: a */
    public static final Charset f489a = Charset.forName("UTF-8");

    /* renamed from: a */
    public static String m676a(Boolean bool) {
        return Boolean.toString(bool.booleanValue());
    }

    /* renamed from: b */
    public static String m677b(Integer num) {
        return Integer.toString(num.intValue());
    }

    /* renamed from: c */
    public static String m678c(String str) {
        return str;
    }

    /* renamed from: d */
    public static String m679d(String str) {
        if (str == null) {
            return null;
        }
        return str.isEmpty() ? "" : str.toLowerCase(Locale.ENGLISH);
    }

    /* renamed from: e */
    public static String m680e(String str) {
        if (str == null) {
            return null;
        }
        return str.isEmpty() ? "" : str.toUpperCase(Locale.ENGLISH);
    }
}
