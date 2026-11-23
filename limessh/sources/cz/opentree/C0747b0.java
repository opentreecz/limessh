package cz.opentree;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import cz.opentree.AbstractC1138i0;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.b0 */
/* loaded from: classes.dex */
public final class C0747b0 extends AbstractC1138i0 {

    /* renamed from: a */
    public final String f1552a;

    /* renamed from: b */
    public final byte[] f1553b;

    /* renamed from: c */
    public final EnumC0854d f1554c;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: cz.opentree.b0$b */
    /* loaded from: classes.dex */
    public static final class b extends AbstractC1138i0.a {

        /* renamed from: a */
        public String f1555a;

        /* renamed from: b */
        public byte[] f1556b;

        /* renamed from: c */
        public EnumC0854d f1557c;

        @Override // cz.opentree.AbstractC1138i0.a
        /* renamed from: a */
        public AbstractC1138i0 mo2326a() {
            String str = "";
            if (this.f1555a == null) {
                str = " backendName";
            }
            if (this.f1557c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new C0747b0(this.f1555a, this.f1556b, this.f1557c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.AbstractC1138i0.a
        /* renamed from: b */
        public AbstractC1138i0.a mo2327b(String str) {
            Objects.requireNonNull(str, "Null backendName");
            this.f1555a = str;
            return this;
        }

        @Override // cz.opentree.AbstractC1138i0.a
        /* renamed from: c */
        public AbstractC1138i0.a mo2328c(@Nullable byte[] bArr) {
            this.f1556b = bArr;
            return this;
        }

        @Override // cz.opentree.AbstractC1138i0.a
        /* renamed from: d */
        public AbstractC1138i0.a mo2329d(EnumC0854d enumC0854d) {
            Objects.requireNonNull(enumC0854d, "Null priority");
            this.f1557c = enumC0854d;
            return this;
        }
    }

    public C0747b0(String str, @Nullable byte[] bArr, EnumC0854d enumC0854d) {
        this.f1552a = str;
        this.f1553b = bArr;
        this.f1554c = enumC0854d;
    }

    @Override // cz.opentree.AbstractC1138i0
    /* renamed from: b */
    public String mo2323b() {
        return this.f1552a;
    }

    @Override // cz.opentree.AbstractC1138i0
    @Nullable
    /* renamed from: c */
    public byte[] mo2324c() {
        return this.f1553b;
    }

    @Override // cz.opentree.AbstractC1138i0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: d */
    public EnumC0854d mo2325d() {
        return this.f1554c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1138i0)) {
            return false;
        }
        AbstractC1138i0 abstractC1138i0 = (AbstractC1138i0) obj;
        if (this.f1552a.equals(abstractC1138i0.mo2323b())) {
            if (Arrays.equals(this.f1553b, abstractC1138i0 instanceof C0747b0 ? ((C0747b0) abstractC1138i0).f1553b : abstractC1138i0.mo2324c()) && this.f1554c.equals(abstractC1138i0.mo2325d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f1552a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f1553b)) * 1000003) ^ this.f1554c.hashCode();
    }
}
