package cz.opentree;

import java.util.Objects;
import javax.annotation.Nonnull;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public final class ig0 extends ng0 {

    /* renamed from: a */
    public final String f3312a;

    /* renamed from: b */
    public final String f3313b;

    public ig0(String str, String str2) {
        Objects.requireNonNull(str, "Null libraryName");
        this.f3312a = str;
        Objects.requireNonNull(str2, "Null version");
        this.f3313b = str2;
    }

    @Override // cz.opentree.ng0
    @Nonnull
    /* renamed from: b */
    public String mo4776b() {
        return this.f3312a;
    }

    @Override // cz.opentree.ng0
    @Nonnull
    /* renamed from: c */
    public String mo4777c() {
        return this.f3313b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ng0)) {
            return false;
        }
        ng0 ng0Var = (ng0) obj;
        return this.f3312a.equals(ng0Var.mo4776b()) && this.f3313b.equals(ng0Var.mo4777c());
    }

    public int hashCode() {
        return ((this.f3312a.hashCode() ^ 1000003) * 1000003) ^ this.f3313b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f3312a + ", version=" + this.f3313b + "}";
    }
}
