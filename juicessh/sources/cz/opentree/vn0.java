package cz.opentree;

import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.internal.http.HttpCodec;

/* compiled from: RealInterceptorChain.java */
/* loaded from: classes.dex */
public final class vn0 implements Interceptor.Chain {

    /* renamed from: a */
    public final List<Interceptor> f7529a;

    /* renamed from: b */
    public final pn0 f7530b;

    /* renamed from: c */
    public final HttpCodec f7531c;

    /* renamed from: d */
    public final ln0 f7532d;

    /* renamed from: e */
    public final int f7533e;

    /* renamed from: f */
    public final xm0 f7534f;

    /* renamed from: g */
    public final Call f7535g;

    /* renamed from: h */
    public final EventListener f7536h;

    /* renamed from: i */
    public final int f7537i;

    /* renamed from: j */
    public final int f7538j;

    /* renamed from: k */
    public final int f7539k;

    /* renamed from: l */
    public int f7540l;

    public vn0(List<Interceptor> list, pn0 pn0Var, HttpCodec httpCodec, ln0 ln0Var, int i, xm0 xm0Var, Call call, EventListener eventListener, int i2, int i3, int i4) {
        this.f7529a = list;
        this.f7532d = ln0Var;
        this.f7530b = pn0Var;
        this.f7531c = httpCodec;
        this.f7533e = i;
        this.f7534f = xm0Var;
        this.f7535g = call;
        this.f7536h = eventListener;
        this.f7537i = i2;
        this.f7538j = i3;
        this.f7539k = i4;
    }

    @Override // okhttp3.Interceptor.Chain
    /* renamed from: a */
    public int mo9316a() {
        return this.f7538j;
    }

    @Override // okhttp3.Interceptor.Chain
    /* renamed from: b */
    public int mo9317b() {
        return this.f7539k;
    }

    @Override // okhttp3.Interceptor.Chain
    /* renamed from: c */
    public zm0 mo9318c(xm0 xm0Var) throws IOException {
        return m9325j(xm0Var, this.f7530b, this.f7531c, this.f7532d);
    }

    @Override // okhttp3.Interceptor.Chain
    /* renamed from: d */
    public int mo9319d() {
        return this.f7537i;
    }

    @Override // okhttp3.Interceptor.Chain
    /* renamed from: e */
    public xm0 mo9320e() {
        return this.f7534f;
    }

    /* renamed from: f */
    public Call m9321f() {
        return this.f7535g;
    }

    /* renamed from: g */
    public Connection m9322g() {
        return this.f7532d;
    }

    /* renamed from: h */
    public EventListener m9323h() {
        return this.f7536h;
    }

    /* renamed from: i */
    public HttpCodec m9324i() {
        return this.f7531c;
    }

    /* renamed from: j */
    public zm0 m9325j(xm0 xm0Var, pn0 pn0Var, HttpCodec httpCodec, ln0 ln0Var) throws IOException {
        if (this.f7533e >= this.f7529a.size()) {
            throw new AssertionError();
        }
        this.f7540l++;
        if (this.f7531c != null && !this.f7532d.m6275s(xm0Var.m9821h())) {
            throw new IllegalStateException("network interceptor " + this.f7529a.get(this.f7533e - 1) + " must retain the same host and port");
        }
        if (this.f7531c != null && this.f7540l > 1) {
            throw new IllegalStateException("network interceptor " + this.f7529a.get(this.f7533e - 1) + " must call proceed() exactly once");
        }
        List<Interceptor> list = this.f7529a;
        int i = this.f7533e;
        vn0 vn0Var = new vn0(list, pn0Var, httpCodec, ln0Var, i + 1, xm0Var, this.f7535g, this.f7536h, this.f7537i, this.f7538j, this.f7539k);
        Interceptor interceptor = list.get(i);
        zm0 mo4577a = interceptor.mo4577a(vn0Var);
        if (httpCodec != null && this.f7533e + 1 < this.f7529a.size() && vn0Var.f7540l != 1) {
            throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
        }
        if (mo4577a == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (mo4577a.m10506a() != null) {
            return mo4577a;
        }
        throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
    }

    /* renamed from: k */
    public pn0 m9326k() {
        return this.f7530b;
    }
}
