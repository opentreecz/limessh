package com.sonelli;

import java.net.Proxy;

/* compiled from: RequestLine.java */
/* loaded from: classes.dex */
public final class xn0 {
    /* renamed from: a */
    public static String m9849a(xm0 xm0Var, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(xm0Var.m9819f());
        sb.append(' ');
        if (m9850b(xm0Var, type)) {
            sb.append(xm0Var.m9821h());
        } else {
            sb.append(m9851c(xm0Var.m9821h()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    /* renamed from: b */
    public static boolean m9850b(xm0 xm0Var, Proxy.Type type) {
        return !xm0Var.m9818e() && type == Proxy.Type.HTTP;
    }

    /* renamed from: c */
    public static String m9851c(rm0 rm0Var) {
        String m8167g = rm0Var.m8167g();
        String m8169i = rm0Var.m8169i();
        if (m8169i == null) {
            return m8167g;
        }
        return m8167g + '?' + m8169i;
    }
}
