package cz.opentree;

import androidx.annotation.Nullable;
import cz.opentree.AbstractC1743q0;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.n0 */
/* loaded from: classes.dex */
public final class C1582n0 extends AbstractC1743q0 {

    /* renamed from: a */
    public final Iterable<AbstractC0906e0> f5173a;

    /* renamed from: b */
    public final byte[] f5174b;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: cz.opentree.n0$b */
    /* loaded from: classes.dex */
    public static final class b extends AbstractC1743q0.a {

        /* renamed from: a */
        public Iterable<AbstractC0906e0> f5175a;

        /* renamed from: b */
        public byte[] f5176b;

        @Override // cz.opentree.AbstractC1743q0.a
        /* renamed from: a */
        public AbstractC1743q0 mo6605a() {
            String str = "";
            if (this.f5175a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new C1582n0(this.f5175a, this.f5176b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.AbstractC1743q0.a
        /* renamed from: b */
        public AbstractC1743q0.a mo6606b(Iterable<AbstractC0906e0> iterable) {
            Objects.requireNonNull(iterable, "Null events");
            this.f5175a = iterable;
            return this;
        }

        @Override // cz.opentree.AbstractC1743q0.a
        /* renamed from: c */
        public AbstractC1743q0.a mo6607c(@Nullable byte[] bArr) {
            this.f5176b = bArr;
            return this;
        }
    }

    public C1582n0(Iterable<AbstractC0906e0> iterable, @Nullable byte[] bArr) {
        this.f5173a = iterable;
        this.f5174b = bArr;
    }

    @Override // cz.opentree.AbstractC1743q0
    /* renamed from: b */
    public Iterable<AbstractC0906e0> mo6603b() {
        return this.f5173a;
    }

    @Override // cz.opentree.AbstractC1743q0
    @Nullable
    /* renamed from: c */
    public byte[] mo6604c() {
        return this.f5174b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1743q0)) {
            return false;
        }
        AbstractC1743q0 abstractC1743q0 = (AbstractC1743q0) obj;
        if (this.f5173a.equals(abstractC1743q0.mo6603b())) {
            if (Arrays.equals(this.f5174b, abstractC1743q0 instanceof C1582n0 ? ((C1582n0) abstractC1743q0).f5174b : abstractC1743q0.mo6604c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f5173a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f5174b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f5173a + ", extras=" + Arrays.toString(this.f5174b) + "}";
    }
}
