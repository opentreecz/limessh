package cz.opentree;

import androidx.annotation.Nullable;
import cz.opentree.AbstractC1892t;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: cz.opentree.n */
/* loaded from: classes.dex */
public final class C1581n extends AbstractC1892t {

    /* renamed from: a */
    public final AbstractC1892t.c f5169a;

    /* renamed from: b */
    public final AbstractC1892t.b f5170b;

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: cz.opentree.n$b */
    /* loaded from: classes.dex */
    public static final class b extends AbstractC1892t.a {

        /* renamed from: a */
        public AbstractC1892t.c f5171a;

        /* renamed from: b */
        public AbstractC1892t.b f5172b;

        @Override // cz.opentree.AbstractC1892t.a
        /* renamed from: a */
        public AbstractC1892t.a mo6600a(@Nullable AbstractC1892t.b bVar) {
            this.f5172b = bVar;
            return this;
        }

        @Override // cz.opentree.AbstractC1892t.a
        /* renamed from: b */
        public AbstractC1892t.a mo6601b(@Nullable AbstractC1892t.c cVar) {
            this.f5171a = cVar;
            return this;
        }

        @Override // cz.opentree.AbstractC1892t.a
        /* renamed from: c */
        public AbstractC1892t mo6602c() {
            return new C1581n(this.f5171a, this.f5172b, null);
        }
    }

    public /* synthetic */ C1581n(AbstractC1892t.c cVar, AbstractC1892t.b bVar, a aVar) {
        this.f5169a = cVar;
        this.f5170b = bVar;
    }

    @Override // cz.opentree.AbstractC1892t
    @Nullable
    /* renamed from: b */
    public AbstractC1892t.b mo6598b() {
        return this.f5170b;
    }

    @Override // cz.opentree.AbstractC1892t
    @Nullable
    /* renamed from: c */
    public AbstractC1892t.c mo6599c() {
        return this.f5169a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1892t)) {
            return false;
        }
        AbstractC1892t.c cVar = this.f5169a;
        if (cVar != null ? cVar.equals(((C1581n) obj).f5169a) : ((C1581n) obj).f5169a == null) {
            AbstractC1892t.b bVar = this.f5170b;
            if (bVar == null) {
                if (((C1581n) obj).f5170b == null) {
                    return true;
                }
            } else if (bVar.equals(((C1581n) obj).f5170b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        AbstractC1892t.c cVar = this.f5169a;
        int hashCode = ((cVar == null ? 0 : cVar.hashCode()) ^ 1000003) * 1000003;
        AbstractC1892t.b bVar = this.f5170b;
        return hashCode ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f5169a + ", mobileSubtype=" + this.f5170b + "}";
    }
}
