package cz.opentree;

import androidx.annotation.Nullable;
import cz.opentree.AbstractC1684p;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: cz.opentree.j */
/* loaded from: classes.dex */
public final class C1190j extends AbstractC1684p {

    /* renamed from: a */
    public final AbstractC1684p.b f3455a;

    /* renamed from: b */
    public final AbstractC0962f f3456b;

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: cz.opentree.j$b */
    /* loaded from: classes.dex */
    public static final class b extends AbstractC1684p.a {

        /* renamed from: a */
        public AbstractC1684p.b f3457a;

        /* renamed from: b */
        public AbstractC0962f f3458b;

        @Override // cz.opentree.AbstractC1684p.a
        /* renamed from: a */
        public AbstractC1684p.a mo4992a(@Nullable AbstractC0962f abstractC0962f) {
            this.f3458b = abstractC0962f;
            return this;
        }

        @Override // cz.opentree.AbstractC1684p.a
        /* renamed from: b */
        public AbstractC1684p.a mo4993b(@Nullable AbstractC1684p.b bVar) {
            this.f3457a = bVar;
            return this;
        }

        @Override // cz.opentree.AbstractC1684p.a
        /* renamed from: c */
        public AbstractC1684p mo4994c() {
            return new C1190j(this.f3457a, this.f3458b, null);
        }
    }

    public /* synthetic */ C1190j(AbstractC1684p.b bVar, AbstractC0962f abstractC0962f, a aVar) {
        this.f3455a = bVar;
        this.f3456b = abstractC0962f;
    }

    @Override // cz.opentree.AbstractC1684p
    @Nullable
    /* renamed from: b */
    public AbstractC0962f mo4990b() {
        return this.f3456b;
    }

    @Override // cz.opentree.AbstractC1684p
    @Nullable
    /* renamed from: c */
    public AbstractC1684p.b mo4991c() {
        return this.f3455a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1684p)) {
            return false;
        }
        AbstractC1684p.b bVar = this.f3455a;
        if (bVar != null ? bVar.equals(((C1190j) obj).f3455a) : ((C1190j) obj).f3455a == null) {
            AbstractC0962f abstractC0962f = this.f3456b;
            if (abstractC0962f == null) {
                if (((C1190j) obj).f3456b == null) {
                    return true;
                }
            } else if (abstractC0962f.equals(((C1190j) obj).f3456b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        AbstractC1684p.b bVar = this.f3455a;
        int hashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        AbstractC0962f abstractC0962f = this.f3456b;
        return hashCode ^ (abstractC0962f != null ? abstractC0962f.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f3455a + ", androidClientInfo=" + this.f3456b + "}";
    }
}
