package com.sonelli;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class ht0 extends Permission {

    /* renamed from: O */
    public final Set<String> f3226O;

    public ht0(String str) {
        super(str);
        HashSet hashSet = new HashSet();
        this.f3226O = hashSet;
        hashSet.add(str);
    }

    public boolean equals(Object obj) {
        return (obj instanceof ht0) && this.f3226O.equals(((ht0) obj).f3226O);
    }

    @Override // java.security.Permission
    public String getActions() {
        return this.f3226O.toString();
    }

    public int hashCode() {
        return this.f3226O.hashCode();
    }

    @Override // java.security.Permission
    public boolean implies(Permission permission) {
        if (!(permission instanceof ht0)) {
            return false;
        }
        ht0 ht0Var = (ht0) permission;
        return getName().equals(ht0Var.getName()) || this.f3226O.containsAll(ht0Var.f3226O);
    }
}
