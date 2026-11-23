package com.amazonaws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class DateUtils {

    /* renamed from: a */
    public static final TimeZone f480a = TimeZone.getTimeZone("GMT");

    /* renamed from: b */
    public static final Map<String, ThreadLocal<SimpleDateFormat>> f481b = new HashMap();

    /* renamed from: b */
    public static String m655b(String str, Date date) {
        return m657d(str).get().format(date);
    }

    /* renamed from: c */
    public static String m656c(Date date) {
        return m655b("EEE, dd MMM yyyy HH:mm:ss z", date);
    }

    /* renamed from: d */
    public static ThreadLocal<SimpleDateFormat> m657d(final String str) {
        Map<String, ThreadLocal<SimpleDateFormat>> map = f481b;
        ThreadLocal<SimpleDateFormat> threadLocal = map.get(str);
        if (threadLocal == null) {
            synchronized (map) {
                threadLocal = map.get(str);
                if (threadLocal == null) {
                    threadLocal = new ThreadLocal<SimpleDateFormat>() { // from class: com.amazonaws.util.DateUtils.1
                        @Override // java.lang.ThreadLocal
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public SimpleDateFormat initialValue() {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
                            simpleDateFormat.setTimeZone(DateUtils.f480a);
                            simpleDateFormat.setLenient(false);
                            return simpleDateFormat;
                        }
                    };
                    map.put(str, threadLocal);
                }
            }
        }
        return threadLocal;
    }

    /* renamed from: e */
    public static Date m658e(String str, String str2) {
        try {
            return m657d(str).get().parse(str2);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: f */
    public static Date m659f(String str) {
        return m658e("yyyyMMdd'T'HHmmss'Z'", str);
    }

    /* renamed from: g */
    public static Date m660g(String str) {
        try {
            return m658e("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", str);
        } catch (IllegalArgumentException unused) {
            return m658e("yyyy-MM-dd'T'HH:mm:ss'Z'", str);
        }
    }

    /* renamed from: h */
    public static Date m661h(String str) {
        return m658e("EEE, dd MMM yyyy HH:mm:ss z", str);
    }
}
