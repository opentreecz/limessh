package cz.opentree;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: Route.java */
/* loaded from: classes.dex */
public final class bn0 {

    /* renamed from: a */
    public final gm0 f1773a;

    /* renamed from: b */
    public final Proxy f1774b;

    /* renamed from: c */
    public final InetSocketAddress f1775c;

    public bn0(gm0 gm0Var, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Objects.requireNonNull(gm0Var, "address == null");
        Objects.requireNonNull(proxy, "proxy == null");
        Objects.requireNonNull(inetSocketAddress, "inetSocketAddress == null");
        this.f1773a = gm0Var;
        this.f1774b = proxy;
        this.f1775c = inetSocketAddress;
    }

    /* renamed from: a */
    public gm0 m2586a() {
        return this.f1773a;
    }

    /* renamed from: b */
    public Proxy m2587b() {
        return this.f1774b;
    }

    /* renamed from: c */
    public boolean m2588c() {
        return this.f1773a.f2898i != null && this.f1774b.type() == Proxy.Type.HTTP;
    }

    /* renamed from: d */
    public InetSocketAddress m2589d() {
        return this.f1775c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof bn0) {
            bn0 bn0Var = (bn0) obj;
            if (bn0Var.f1773a.equals(this.f1773a) && bn0Var.f1774b.equals(this.f1774b) && bn0Var.f1775c.equals(this.f1775c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f1773a.hashCode()) * 31) + this.f1774b.hashCode()) * 31) + this.f1775c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f1775c + "}";
    }
}
