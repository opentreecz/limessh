package cz.opentree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cz.opentree.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class w90 extends oa0.AbstractC1644c {

    /* renamed from: a */
    public final pa0<oa0.AbstractC1644c.b> f7653a;

    /* renamed from: b */
    public final String f7654b;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.w90$b */
    /* loaded from: classes.dex */
    public static final class C2209b extends oa0.AbstractC1644c.a {

        /* renamed from: a */
        public pa0<oa0.AbstractC1644c.b> f7655a;

        /* renamed from: b */
        public String f7656b;

        @Override // cz.opentree.oa0.AbstractC1644c.a
        /* renamed from: a */
        public oa0.AbstractC1644c mo6945a() {
            String str = "";
            if (this.f7655a == null) {
                str = " files";
            }
            if (str.isEmpty()) {
                return new w90(this.f7655a, this.f7656b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.oa0.AbstractC1644c.a
        /* renamed from: b */
        public oa0.AbstractC1644c.a mo6946b(pa0<oa0.AbstractC1644c.b> pa0Var) {
            Objects.requireNonNull(pa0Var, "Null files");
            this.f7655a = pa0Var;
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1644c.a
        /* renamed from: c */
        public oa0.AbstractC1644c.a mo6947c(String str) {
            this.f7656b = str;
            return this;
        }
    }

    public w90(pa0<oa0.AbstractC1644c.b> pa0Var, @Nullable String str) {
        this.f7653a = pa0Var;
        this.f7654b = str;
    }

    @Override // cz.opentree.oa0.AbstractC1644c
    @NonNull
    /* renamed from: b */
    public pa0<oa0.AbstractC1644c.b> mo6943b() {
        return this.f7653a;
    }

    @Override // cz.opentree.oa0.AbstractC1644c
    @Nullable
    /* renamed from: c */
    public String mo6944c() {
        return this.f7654b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0.AbstractC1644c)) {
            return false;
        }
        oa0.AbstractC1644c abstractC1644c = (oa0.AbstractC1644c) obj;
        if (this.f7653a.equals(abstractC1644c.mo6943b())) {
            String str = this.f7654b;
            if (str == null) {
                if (abstractC1644c.mo6944c() == null) {
                    return true;
                }
            } else if (str.equals(abstractC1644c.mo6944c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.f7653a.hashCode() ^ 1000003) * 1000003;
        String str = this.f7654b;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilesPayload{files=" + this.f7653a + ", orgId=" + this.f7654b + "}";
    }
}
