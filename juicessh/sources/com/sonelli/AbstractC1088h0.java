package com.sonelli;

import com.google.android.datatransport.Transformer;
import com.sonelli.C0690a0;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.h0 */
/* loaded from: classes.dex */
public abstract class AbstractC1088h0 {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: com.sonelli.h0$a */
    /* loaded from: classes.dex */
    public static abstract class a {
        /* renamed from: a */
        public abstract AbstractC1088h0 mo1936a();

        /* renamed from: b */
        public abstract a mo1937b(C0746b c0746b);

        /* renamed from: c */
        public abstract a mo1938c(AbstractC0802c<?> abstractC0802c);

        /* renamed from: d */
        public abstract a mo1939d(Transformer<?, byte[]> transformer);

        /* renamed from: e */
        public abstract a mo1940e(AbstractC1138i0 abstractC1138i0);

        /* renamed from: f */
        public abstract a mo1941f(String str);
    }

    /* renamed from: a */
    public static a m4296a() {
        return new C0690a0.b();
    }

    /* renamed from: b */
    public abstract C0746b mo1931b();

    /* renamed from: c */
    public abstract AbstractC0802c<?> mo1932c();

    /* renamed from: d */
    public byte[] m4297d() {
        return mo1933e().apply(mo1932c().mo1929b());
    }

    /* renamed from: e */
    public abstract Transformer<?, byte[]> mo1933e();

    /* renamed from: f */
    public abstract AbstractC1138i0 mo1934f();

    /* renamed from: g */
    public abstract String mo1935g();
}
