package okhttp3;

import cz.opentree.pm0;
import cz.opentree.vm0;
import cz.opentree.xm0;
import cz.opentree.zm0;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class EventListener {

    /* renamed from: a */
    public static final EventListener f8654a = new C2484a();

    /* loaded from: classes.dex */
    public interface Factory {
        /* renamed from: a */
        EventListener mo10720a(Call call);
    }

    /* renamed from: okhttp3.EventListener$a */
    /* loaded from: classes.dex */
    public class C2484a extends EventListener {
    }

    /* renamed from: okhttp3.EventListener$b */
    /* loaded from: classes.dex */
    public class C2485b implements Factory {
        public C2485b() {
        }

        @Override // okhttp3.EventListener.Factory
        /* renamed from: a */
        public EventListener mo10720a(Call call) {
            return EventListener.this;
        }
    }

    /* renamed from: k */
    public static Factory m10699k(EventListener eventListener) {
        return new C2485b();
    }

    /* renamed from: a */
    public void m10700a(Call call) {
    }

    /* renamed from: b */
    public void m10701b(Call call, IOException iOException) {
    }

    /* renamed from: c */
    public void m10702c(Call call) {
    }

    /* renamed from: d */
    public void m10703d(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable vm0 vm0Var) {
    }

    /* renamed from: e */
    public void m10704e(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable vm0 vm0Var, IOException iOException) {
    }

    /* renamed from: f */
    public void m10705f(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    /* renamed from: g */
    public void m10706g(Call call, Connection connection) {
    }

    /* renamed from: h */
    public void m10707h(Call call, Connection connection) {
    }

    /* renamed from: i */
    public void m10708i(Call call, String str, List<InetAddress> list) {
    }

    /* renamed from: j */
    public void m10709j(Call call, String str) {
    }

    /* renamed from: l */
    public void m10710l(Call call, long j) {
    }

    /* renamed from: m */
    public void m10711m(Call call) {
    }

    /* renamed from: n */
    public void m10712n(Call call, xm0 xm0Var) {
    }

    /* renamed from: o */
    public void m10713o(Call call) {
    }

    /* renamed from: p */
    public void m10714p(Call call, long j) {
    }

    /* renamed from: q */
    public void m10715q(Call call) {
    }

    /* renamed from: r */
    public void m10716r(Call call, zm0 zm0Var) {
    }

    /* renamed from: s */
    public void m10717s(Call call) {
    }

    /* renamed from: t */
    public void m10718t(Call call, @Nullable pm0 pm0Var) {
    }

    /* renamed from: u */
    public void m10719u(Call call) {
    }
}
