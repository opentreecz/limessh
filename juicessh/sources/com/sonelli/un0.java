package com.sonelli;

/* compiled from: HttpMethod.java */
/* loaded from: classes.dex */
public final class un0 {
    /* renamed from: a */
    public static boolean m8961a(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    /* renamed from: b */
    public static boolean m8962b(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    /* renamed from: c */
    public static boolean m8963c(String str) {
        return !str.equals("PROPFIND");
    }

    /* renamed from: d */
    public static boolean m8964d(String str) {
        return str.equals("PROPFIND");
    }

    /* renamed from: e */
    public static boolean m8965e(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }
}
