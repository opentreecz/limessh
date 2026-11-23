package com.sonelli;

import android.annotation.SuppressLint;
import android.util.Log;
import com.google.android.gms.analytics.Logger;

@Deprecated
/* renamed from: com.sonelli.jh */
/* loaded from: classes.dex */
public final class C1212jh {

    /* renamed from: a */
    public static volatile Logger f3556a = new C2169vg();

    /* renamed from: a */
    public static boolean m5110a(int i) {
        return f3556a != null && f3556a.mo831c() <= i;
    }

    @SuppressLint({"LogTagMismatch"})
    /* renamed from: b */
    public static void m5111b(String str) {
        C1451kh m5888K0 = C1451kh.m5888K0();
        if (m5888K0 != null) {
            m5888K0.m8676x0(str);
        } else if (m5110a(0)) {
            Log.v(C0770bh.f1677b.m2801a(), str);
        }
        Logger logger = f3556a;
        if (logger != null) {
            logger.mo830b(str);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    /* renamed from: c */
    public static void m5112c(String str) {
        C1451kh m5888K0 = C1451kh.m5888K0();
        if (m5888K0 != null) {
            m5888K0.m8649A0(str);
        } else if (m5110a(2)) {
            Log.w(C0770bh.f1677b.m2801a(), str);
        }
        Logger logger = f3556a;
        if (logger != null) {
            logger.mo832d(str);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    /* renamed from: d */
    public static void m5113d(String str, Object obj) {
        String str2;
        C1451kh m5888K0 = C1451kh.m5888K0();
        if (m5888K0 != null) {
            m5888K0.m8674w0(str, obj);
        } else if (m5110a(3)) {
            if (obj != null) {
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(valueOf).length());
                sb.append(str);
                sb.append(":");
                sb.append(valueOf);
                str2 = sb.toString();
            } else {
                str2 = str;
            }
            Log.e(C0770bh.f1677b.m2801a(), str2);
        }
        Logger logger = f3556a;
        if (logger != null) {
            logger.mo829a(str);
        }
    }
}
