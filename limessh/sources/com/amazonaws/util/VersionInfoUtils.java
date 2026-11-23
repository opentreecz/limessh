package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

/* loaded from: classes.dex */
public class VersionInfoUtils {

    /* renamed from: a */
    public static volatile String f494a = "2.16.12";

    /* renamed from: b */
    public static volatile String f495b = "android";

    /* renamed from: c */
    public static volatile String f496c;

    /* renamed from: d */
    public static final Log f497d = LogFactory.m237c(VersionInfoUtils.class);

    /* renamed from: a */
    public static String m698a() {
        return f495b;
    }

    /* renamed from: b */
    public static String m699b() {
        if (f496c == null) {
            synchronized (VersionInfoUtils.class) {
                if (f496c == null) {
                    m701d();
                }
            }
        }
        return f496c;
    }

    /* renamed from: c */
    public static String m700c() {
        return f494a;
    }

    /* renamed from: d */
    public static void m701d() {
        f496c = m703f();
    }

    /* renamed from: e */
    public static String m702e(String str) {
        return str.replace(' ', '_');
    }

    /* renamed from: f */
    public static String m703f() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("aws-sdk-");
        sb.append(StringUtils.m679d(m698a()));
        sb.append("/");
        sb.append(m700c());
        sb.append(" ");
        sb.append(m702e(System.getProperty("os.name")));
        sb.append("/");
        sb.append(m702e(System.getProperty("os.version")));
        sb.append(" ");
        sb.append(m702e(System.getProperty("java.vm.name")));
        sb.append("/");
        sb.append(m702e(System.getProperty("java.vm.version")));
        sb.append("/");
        sb.append(m702e(System.getProperty("java.version")));
        String property = System.getProperty("user.language");
        String property2 = System.getProperty("user.region");
        if (property != null && property2 != null) {
            sb.append(" ");
            sb.append(m702e(property));
            sb.append("_");
            sb.append(m702e(property2));
        }
        return sb.toString();
    }
}
