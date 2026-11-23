package com.amazonaws.services.ec2.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class ProductCode implements Serializable {

    /* renamed from: O */
    public String f342O;

    /* renamed from: P */
    public String f343P;

    /* renamed from: a */
    public String m481a() {
        return this.f342O;
    }

    /* renamed from: b */
    public String m482b() {
        return this.f343P;
    }

    /* renamed from: c */
    public void m483c(String str) {
        this.f342O = str;
    }

    /* renamed from: d */
    public void m484d(String str) {
        this.f343P = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ProductCode)) {
            return false;
        }
        ProductCode productCode = (ProductCode) obj;
        if ((productCode.m481a() == null) ^ (m481a() == null)) {
            return false;
        }
        if (productCode.m481a() != null && !productCode.m481a().equals(m481a())) {
            return false;
        }
        if ((productCode.m482b() == null) ^ (m482b() == null)) {
            return false;
        }
        return productCode.m482b() == null || productCode.m482b().equals(m482b());
    }

    public int hashCode() {
        return (((m481a() == null ? 0 : m481a().hashCode()) + 31) * 31) + (m482b() != null ? m482b().hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m481a() != null) {
            sb.append("ProductCodeId: " + m481a() + ",");
        }
        if (m482b() != null) {
            sb.append("ProductCodeType: " + m482b());
        }
        sb.append("}");
        return sb.toString();
    }
}
