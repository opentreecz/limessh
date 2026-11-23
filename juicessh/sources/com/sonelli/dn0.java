package com.sonelli;

import com.sonelli.qm0;
import com.sonelli.zm0;
import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.Call;

/* compiled from: Internal.java */
/* loaded from: classes.dex */
public abstract class dn0 {

    /* renamed from: a */
    public static dn0 f2249a;

    /* renamed from: a */
    public abstract void mo3265a(qm0.C1776a c1776a, String str);

    /* renamed from: b */
    public abstract void mo3266b(qm0.C1776a c1776a, String str, String str2);

    /* renamed from: c */
    public abstract void mo3267c(mm0 mm0Var, SSLSocket sSLSocket, boolean z);

    /* renamed from: d */
    public abstract int mo3268d(zm0.C2434a c2434a);

    /* renamed from: e */
    public abstract boolean mo3269e(lm0 lm0Var, ln0 ln0Var);

    /* renamed from: f */
    public abstract Socket mo3270f(lm0 lm0Var, gm0 gm0Var, pn0 pn0Var);

    /* renamed from: g */
    public abstract boolean mo3271g(gm0 gm0Var, gm0 gm0Var2);

    /* renamed from: h */
    public abstract ln0 mo3272h(lm0 lm0Var, gm0 gm0Var, pn0 pn0Var, bn0 bn0Var);

    /* renamed from: i */
    public abstract void mo3273i(lm0 lm0Var, ln0 ln0Var);

    /* renamed from: j */
    public abstract mn0 mo3274j(lm0 lm0Var);

    @Nullable
    /* renamed from: k */
    public abstract IOException mo3275k(Call call, @Nullable IOException iOException);
}
