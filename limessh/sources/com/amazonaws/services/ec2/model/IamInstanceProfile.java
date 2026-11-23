package com.amazonaws.services.ec2.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class IamInstanceProfile implements Serializable {

    /* renamed from: O */
    public String f262O;

    /* renamed from: P */
    public String f263P;

    /* renamed from: a */
    public String m331a() {
        return this.f262O;
    }

    /* renamed from: b */
    public String m332b() {
        return this.f263P;
    }

    /* renamed from: c */
    public void m333c(String str) {
        this.f262O = str;
    }

    /* renamed from: d */
    public void m334d(String str) {
        this.f263P = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IamInstanceProfile)) {
            return false;
        }
        IamInstanceProfile iamInstanceProfile = (IamInstanceProfile) obj;
        if ((iamInstanceProfile.m331a() == null) ^ (m331a() == null)) {
            return false;
        }
        if (iamInstanceProfile.m331a() != null && !iamInstanceProfile.m331a().equals(m331a())) {
            return false;
        }
        if ((iamInstanceProfile.m332b() == null) ^ (m332b() == null)) {
            return false;
        }
        return iamInstanceProfile.m332b() == null || iamInstanceProfile.m332b().equals(m332b());
    }

    public int hashCode() {
        return (((m331a() == null ? 0 : m331a().hashCode()) + 31) * 31) + (m332b() != null ? m332b().hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m331a() != null) {
            sb.append("Arn: " + m331a() + ",");
        }
        if (m332b() != null) {
            sb.append("Id: " + m332b());
        }
        sb.append("}");
        return sb.toString();
    }
}
