package cz.opentree;

import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class r80 extends b90 {

    /* renamed from: a */
    public final oa0 f6191a;

    /* renamed from: b */
    public final String f6192b;

    public r80(oa0 oa0Var, String str) {
        Objects.requireNonNull(oa0Var, "Null report");
        this.f6191a = oa0Var;
        Objects.requireNonNull(str, "Null sessionId");
        this.f6192b = str;
    }

    @Override // cz.opentree.b90
    /* renamed from: b */
    public oa0 mo2402b() {
        return this.f6191a;
    }

    @Override // cz.opentree.b90
    /* renamed from: c */
    public String mo2403c() {
        return this.f6192b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b90)) {
            return false;
        }
        b90 b90Var = (b90) obj;
        return this.f6191a.equals(b90Var.mo2402b()) && this.f6192b.equals(b90Var.mo2403c());
    }

    public int hashCode() {
        return ((this.f6191a.hashCode() ^ 1000003) * 1000003) ^ this.f6192b.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f6191a + ", sessionId=" + this.f6192b + "}";
    }
}
