package cz.opentree;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public final class b80 {

    /* renamed from: a */
    public final Class<?> f1613a;

    /* renamed from: b */
    public final int f1614b;

    /* renamed from: c */
    public final int f1615c;

    public b80(Class<?> cls, int i, int i2) {
        i80.m4728c(cls, "Null dependency anInterface.");
        this.f1613a = cls;
        this.f1614b = i;
        this.f1615c = i2;
    }

    /* renamed from: e */
    public static b80 m2393e(Class<?> cls) {
        return new b80(cls, 0, 0);
    }

    /* renamed from: f */
    public static b80 m2394f(Class<?> cls) {
        return new b80(cls, 1, 0);
    }

    /* renamed from: g */
    public static b80 m2395g(Class<?> cls) {
        return new b80(cls, 1, 1);
    }

    /* renamed from: h */
    public static b80 m2396h(Class<?> cls) {
        return new b80(cls, 2, 0);
    }

    /* renamed from: a */
    public Class<?> m2397a() {
        return this.f1613a;
    }

    /* renamed from: b */
    public boolean m2398b() {
        return this.f1615c == 0;
    }

    /* renamed from: c */
    public boolean m2399c() {
        return this.f1614b == 1;
    }

    /* renamed from: d */
    public boolean m2400d() {
        return this.f1614b == 2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b80)) {
            return false;
        }
        b80 b80Var = (b80) obj;
        return this.f1613a == b80Var.f1613a && this.f1614b == b80Var.f1614b && this.f1615c == b80Var.f1615c;
    }

    public int hashCode() {
        return ((((this.f1613a.hashCode() ^ 1000003) * 1000003) ^ this.f1614b) * 1000003) ^ this.f1615c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f1613a);
        sb.append(", type=");
        int i = this.f1614b;
        sb.append(i == 1 ? "required" : i == 0 ? "optional" : "set");
        sb.append(", direct=");
        sb.append(this.f1615c == 0);
        sb.append("}");
        return sb.toString();
    }
}
