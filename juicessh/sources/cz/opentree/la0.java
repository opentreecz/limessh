package cz.opentree;

import androidx.annotation.NonNull;
import cz.opentree.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class la0 extends oa0.AbstractC1645d.d.AbstractC2512d {

    /* renamed from: a */
    public final String f4772a;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.la0$b */
    /* loaded from: classes.dex */
    public static final class C1499b extends oa0.AbstractC1645d.d.AbstractC2512d.a {

        /* renamed from: a */
        public String f4773a;

        @Override // cz.opentree.oa0.AbstractC1645d.d.AbstractC2512d.a
        /* renamed from: a */
        public oa0.AbstractC1645d.d.AbstractC2512d mo6101a() {
            String str = "";
            if (this.f4773a == null) {
                str = " content";
            }
            if (str.isEmpty()) {
                return new la0(this.f4773a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.AbstractC2512d.a
        /* renamed from: b */
        public oa0.AbstractC1645d.d.AbstractC2512d.a mo6102b(String str) {
            Objects.requireNonNull(str, "Null content");
            this.f4773a = str;
            return this;
        }
    }

    public la0(String str) {
        this.f4772a = str;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.AbstractC2512d
    @NonNull
    /* renamed from: b */
    public String mo6100b() {
        return this.f4772a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof oa0.AbstractC1645d.d.AbstractC2512d) {
            return this.f4772a.equals(((oa0.AbstractC1645d.d.AbstractC2512d) obj).mo6100b());
        }
        return false;
    }

    public int hashCode() {
        return this.f4772a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.f4772a + "}";
    }
}
