package cz.opentree;

/* loaded from: classes.dex */
public class s51 {

    /* renamed from: a */
    public String f6354a;

    /* renamed from: b */
    public String f6355b;

    public s51(String str, String str2) {
        this.f6354a = str;
        this.f6355b = str2;
    }

    /* renamed from: a */
    public final int m8333a(String str) {
        if (str == null) {
            return 1;
        }
        return str.hashCode();
    }

    /* renamed from: b */
    public final boolean m8334b(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s51)) {
            return false;
        }
        s51 s51Var = (s51) obj;
        return s51Var == this || (m8334b(this.f6354a, s51Var.f6354a) && m8334b(this.f6355b, s51Var.f6355b));
    }

    public int hashCode() {
        return m8333a(this.f6354a) + (m8333a(this.f6355b) * 31);
    }
}
