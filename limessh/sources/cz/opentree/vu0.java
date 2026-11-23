package cz.opentree;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class vu0 extends BasicPermission {

    /* renamed from: O */
    public final String f7556O;

    /* renamed from: P */
    public final int f7557P;

    public vu0(String str, String str2) {
        super(str, str2);
        this.f7556O = str2;
        this.f7557P = m9345a(str2);
    }

    /* renamed from: a */
    public final int m9345a(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(j51.m5066e(str), " ,");
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.equals("threadlocalecimplicitlyca")) {
                i |= 1;
            } else if (nextToken.equals("ecimplicitlyca")) {
                i |= 2;
            } else if (nextToken.equals("threadlocaldhdefaultparams")) {
                i |= 4;
            } else if (nextToken.equals("dhdefaultparams")) {
                i |= 8;
            } else if (nextToken.equals("acceptableeccurves")) {
                i |= 16;
            } else if (nextToken.equals("additionalecparameters")) {
                i |= 32;
            } else if (nextToken.equals("all")) {
                i |= 63;
            }
        }
        if (i != 0) {
            return i;
        }
        throw new IllegalArgumentException("unknown permissions passed to mask");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof vu0)) {
            return false;
        }
        vu0 vu0Var = (vu0) obj;
        return this.f7557P == vu0Var.f7557P && getName().equals(vu0Var.getName());
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public String getActions() {
        return this.f7556O;
    }

    public int hashCode() {
        return getName().hashCode() + this.f7557P;
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public boolean implies(Permission permission) {
        if (!(permission instanceof vu0) || !getName().equals(permission.getName())) {
            return false;
        }
        int i = this.f7557P;
        int i2 = ((vu0) permission).f7557P;
        return (i & i2) == i2;
    }
}
