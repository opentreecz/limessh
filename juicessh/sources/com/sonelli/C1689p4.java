package com.sonelli;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.Api;

/* renamed from: com.sonelli.p4 */
/* loaded from: classes.dex */
public final class C1689p4 {

    /* renamed from: a */
    public static final Api.C0429d<C1651oe> f5616a;

    /* renamed from: b */
    public static final Api.AbstractC0426a<C1651oe, C1747q4> f5617b;

    /* renamed from: c */
    public static final Api<C1747q4> f5618c;

    /* renamed from: d */
    public static final ProxyApi f5619d;

    static {
        Api.C0429d<C1651oe> c0429d = new Api.C0429d<>();
        f5616a = c0429d;
        C1634o6 c1634o6 = new C1634o6();
        f5617b = c1634o6;
        f5618c = new Api<>("Auth.PROXY_API", c1634o6, c0429d);
        f5619d = new C1757qe();
    }
}
