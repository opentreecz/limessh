package cz.opentree;

import androidx.annotation.NonNull;
import cz.opentree.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class v90 extends oa0.AbstractC1643b {

    /* renamed from: a */
    public final String f7432a;

    /* renamed from: b */
    public final String f7433b;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.v90$b */
    /* loaded from: classes.dex */
    public static final class C2161b extends oa0.AbstractC1643b.a {

        /* renamed from: a */
        public String f7434a;

        /* renamed from: b */
        public String f7435b;

        @Override // cz.opentree.oa0.AbstractC1643b.a
        /* renamed from: a */
        public oa0.AbstractC1643b mo6939a() {
            String str = "";
            if (this.f7434a == null) {
                str = " key";
            }
            if (this.f7435b == null) {
                str = str + " value";
            }
            if (str.isEmpty()) {
                return new v90(this.f7434a, this.f7435b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.oa0.AbstractC1643b.a
        /* renamed from: b */
        public oa0.AbstractC1643b.a mo6940b(String str) {
            Objects.requireNonNull(str, "Null key");
            this.f7434a = str;
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1643b.a
        /* renamed from: c */
        public oa0.AbstractC1643b.a mo6941c(String str) {
            Objects.requireNonNull(str, "Null value");
            this.f7435b = str;
            return this;
        }
    }

    public v90(String str, String str2) {
        this.f7432a = str;
        this.f7433b = str2;
    }

    @Override // cz.opentree.oa0.AbstractC1643b
    @NonNull
    /* renamed from: b */
    public String mo6937b() {
        return this.f7432a;
    }

    @Override // cz.opentree.oa0.AbstractC1643b
    @NonNull
    /* renamed from: c */
    public String mo6938c() {
        return this.f7433b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0.AbstractC1643b)) {
            return false;
        }
        oa0.AbstractC1643b abstractC1643b = (oa0.AbstractC1643b) obj;
        return this.f7432a.equals(abstractC1643b.mo6937b()) && this.f7433b.equals(abstractC1643b.mo6938c());
    }

    public int hashCode() {
        return ((this.f7432a.hashCode() ^ 1000003) * 1000003) ^ this.f7433b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.f7432a + ", value=" + this.f7433b + "}";
    }
}
