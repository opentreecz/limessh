package com.sonelli;

import androidx.annotation.NonNull;
import com.sonelli.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class na0 extends oa0.AbstractC1645d.f {

    /* renamed from: a */
    public final String f5244a;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.na0$b */
    /* loaded from: classes.dex */
    public static final class C1597b extends oa0.AbstractC1645d.f.a {

        /* renamed from: a */
        public String f5245a;

        @Override // com.sonelli.oa0.AbstractC1645d.f.a
        /* renamed from: a */
        public oa0.AbstractC1645d.f mo6655a() {
            String str = "";
            if (this.f5245a == null) {
                str = " identifier";
            }
            if (str.isEmpty()) {
                return new na0(this.f5245a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.sonelli.oa0.AbstractC1645d.f.a
        /* renamed from: b */
        public oa0.AbstractC1645d.f.a mo6656b(String str) {
            Objects.requireNonNull(str, "Null identifier");
            this.f5245a = str;
            return this;
        }
    }

    public na0(String str) {
        this.f5244a = str;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.f
    @NonNull
    /* renamed from: b */
    public String mo6654b() {
        return this.f5244a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof oa0.AbstractC1645d.f) {
            return this.f5244a.equals(((oa0.AbstractC1645d.f) obj).mo6654b());
        }
        return false;
    }

    public int hashCode() {
        return this.f5244a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.f5244a + "}";
    }
}
