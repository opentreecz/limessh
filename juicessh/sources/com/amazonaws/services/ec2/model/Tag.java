package com.amazonaws.services.ec2.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Tag implements Serializable {

    /* renamed from: O */
    public String f406O;

    /* renamed from: P */
    public String f407P;

    /* renamed from: a */
    public String m555a() {
        return this.f406O;
    }

    /* renamed from: b */
    public String m556b() {
        return this.f407P;
    }

    /* renamed from: c */
    public void m557c(String str) {
        this.f406O = str;
    }

    /* renamed from: d */
    public void m558d(String str) {
        this.f407P = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        if ((tag.m555a() == null) ^ (m555a() == null)) {
            return false;
        }
        if (tag.m555a() != null && !tag.m555a().equals(m555a())) {
            return false;
        }
        if ((tag.m556b() == null) ^ (m556b() == null)) {
            return false;
        }
        return tag.m556b() == null || tag.m556b().equals(m556b());
    }

    public int hashCode() {
        return (((m555a() == null ? 0 : m555a().hashCode()) + 31) * 31) + (m556b() != null ? m556b().hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m555a() != null) {
            sb.append("Key: " + m555a() + ",");
        }
        if (m556b() != null) {
            sb.append("Value: " + m556b());
        }
        sb.append("}");
        return sb.toString();
    }
}
