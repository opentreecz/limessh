package cz.opentree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cz.opentree.gg0;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public final class dg0 extends gg0 {

    /* renamed from: a */
    public final String f2164a;

    /* renamed from: b */
    public final long f2165b;

    /* renamed from: c */
    public final gg0.EnumC1042b f2166c;

    /* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
    /* renamed from: cz.opentree.dg0$b */
    /* loaded from: classes.dex */
    public static final class C0875b extends gg0.AbstractC1041a {

        /* renamed from: a */
        public String f2167a;

        /* renamed from: b */
        public Long f2168b;

        /* renamed from: c */
        public gg0.EnumC1042b f2169c;

        @Override // cz.opentree.gg0.AbstractC1041a
        /* renamed from: a */
        public gg0 mo3198a() {
            String str = "";
            if (this.f2168b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new dg0(this.f2167a, this.f2168b.longValue(), this.f2169c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.gg0.AbstractC1041a
        /* renamed from: b */
        public gg0.AbstractC1041a mo3199b(gg0.EnumC1042b enumC1042b) {
            this.f2169c = enumC1042b;
            return this;
        }

        @Override // cz.opentree.gg0.AbstractC1041a
        /* renamed from: c */
        public gg0.AbstractC1041a mo3200c(String str) {
            this.f2167a = str;
            return this;
        }

        @Override // cz.opentree.gg0.AbstractC1041a
        /* renamed from: d */
        public gg0.AbstractC1041a mo3201d(long j) {
            this.f2168b = Long.valueOf(j);
            return this;
        }
    }

    public dg0(@Nullable String str, long j, @Nullable gg0.EnumC1042b enumC1042b) {
        this.f2164a = str;
        this.f2165b = j;
        this.f2166c = enumC1042b;
    }

    @Override // cz.opentree.gg0
    @Nullable
    /* renamed from: b */
    public gg0.EnumC1042b mo3195b() {
        return this.f2166c;
    }

    @Override // cz.opentree.gg0
    @Nullable
    /* renamed from: c */
    public String mo3196c() {
        return this.f2164a;
    }

    @Override // cz.opentree.gg0
    @NonNull
    /* renamed from: d */
    public long mo3197d() {
        return this.f2165b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof gg0)) {
            return false;
        }
        gg0 gg0Var = (gg0) obj;
        String str = this.f2164a;
        if (str != null ? str.equals(gg0Var.mo3196c()) : gg0Var.mo3196c() == null) {
            if (this.f2165b == gg0Var.mo3197d()) {
                gg0.EnumC1042b enumC1042b = this.f2166c;
                if (enumC1042b == null) {
                    if (gg0Var.mo3195b() == null) {
                        return true;
                    }
                } else if (enumC1042b.equals(gg0Var.mo3195b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f2164a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f2165b;
        int i = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        gg0.EnumC1042b enumC1042b = this.f2166c;
        return i ^ (enumC1042b != null ? enumC1042b.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.f2164a + ", tokenExpirationTimestamp=" + this.f2165b + ", responseCode=" + this.f2166c + "}";
    }
}
