package cz.opentree;

import androidx.annotation.NonNull;
import cz.opentree.oa0;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class x90 extends oa0.AbstractC1644c.b {

    /* renamed from: a */
    public final String f7907a;

    /* renamed from: b */
    public final byte[] f7908b;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.x90$b */
    /* loaded from: classes.dex */
    public static final class C2269b extends oa0.AbstractC1644c.b.a {

        /* renamed from: a */
        public String f7909a;

        /* renamed from: b */
        public byte[] f7910b;

        @Override // cz.opentree.oa0.AbstractC1644c.b.a
        /* renamed from: a */
        public oa0.AbstractC1644c.b mo6951a() {
            String str = "";
            if (this.f7909a == null) {
                str = " filename";
            }
            if (this.f7910b == null) {
                str = str + " contents";
            }
            if (str.isEmpty()) {
                return new x90(this.f7909a, this.f7910b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.oa0.AbstractC1644c.b.a
        /* renamed from: b */
        public oa0.AbstractC1644c.b.a mo6952b(byte[] bArr) {
            Objects.requireNonNull(bArr, "Null contents");
            this.f7910b = bArr;
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1644c.b.a
        /* renamed from: c */
        public oa0.AbstractC1644c.b.a mo6953c(String str) {
            Objects.requireNonNull(str, "Null filename");
            this.f7909a = str;
            return this;
        }
    }

    public x90(String str, byte[] bArr) {
        this.f7907a = str;
        this.f7908b = bArr;
    }

    @Override // cz.opentree.oa0.AbstractC1644c.b
    @NonNull
    /* renamed from: b */
    public byte[] mo6949b() {
        return this.f7908b;
    }

    @Override // cz.opentree.oa0.AbstractC1644c.b
    @NonNull
    /* renamed from: c */
    public String mo6950c() {
        return this.f7907a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0.AbstractC1644c.b)) {
            return false;
        }
        oa0.AbstractC1644c.b bVar = (oa0.AbstractC1644c.b) obj;
        if (this.f7907a.equals(bVar.mo6950c())) {
            if (Arrays.equals(this.f7908b, bVar instanceof x90 ? ((x90) bVar).f7908b : bVar.mo6949b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f7907a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f7908b);
    }

    public String toString() {
        return "File{filename=" + this.f7907a + ", contents=" + Arrays.toString(this.f7908b) + "}";
    }
}
