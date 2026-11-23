package okhttp3.internal.http2;

import com.sonelli.ap0;
import com.sonelli.fn0;
import com.sonelli.qm0;

/* loaded from: classes.dex */
public final class Header {

    /* renamed from: d */
    public static final ap0 f8656d = ap0.m2233o(":");

    /* renamed from: e */
    public static final ap0 f8657e = ap0.m2233o(":status");

    /* renamed from: f */
    public static final ap0 f8658f = ap0.m2233o(":method");

    /* renamed from: g */
    public static final ap0 f8659g = ap0.m2233o(":path");

    /* renamed from: h */
    public static final ap0 f8660h = ap0.m2233o(":scheme");

    /* renamed from: i */
    public static final ap0 f8661i = ap0.m2233o(":authority");

    /* renamed from: a */
    public final ap0 f8662a;

    /* renamed from: b */
    public final ap0 f8663b;

    /* renamed from: c */
    public final int f8664c;

    /* loaded from: classes.dex */
    public interface Listener {
        /* renamed from: a */
        void m10729a(qm0 qm0Var);
    }

    public Header(ap0 ap0Var, ap0 ap0Var2) {
        this.f8662a = ap0Var;
        this.f8663b = ap0Var2;
        this.f8664c = ap0Var.mo2247w() + 32 + ap0Var2.mo2247w();
    }

    public Header(ap0 ap0Var, String str) {
        this(ap0Var, ap0.m2233o(str));
    }

    public Header(String str, String str2) {
        this(ap0.m2233o(str), ap0.m2233o(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return this.f8662a.equals(header.f8662a) && this.f8663b.equals(header.f8663b);
    }

    public int hashCode() {
        return ((527 + this.f8662a.hashCode()) * 31) + this.f8663b.hashCode();
    }

    public String toString() {
        return fn0.m3837r("%s: %s", this.f8662a.mo2236B(), this.f8663b.mo2236B());
    }
}
