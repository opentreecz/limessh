package com.amazonaws.services.ec2.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class GroupIdentifier implements Serializable {

    /* renamed from: O */
    public String f260O;

    /* renamed from: P */
    public String f261P;

    /* renamed from: a */
    public String m327a() {
        return this.f261P;
    }

    /* renamed from: b */
    public String m328b() {
        return this.f260O;
    }

    /* renamed from: c */
    public void m329c(String str) {
        this.f261P = str;
    }

    /* renamed from: d */
    public void m330d(String str) {
        this.f260O = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GroupIdentifier)) {
            return false;
        }
        GroupIdentifier groupIdentifier = (GroupIdentifier) obj;
        if ((groupIdentifier.m328b() == null) ^ (m328b() == null)) {
            return false;
        }
        if (groupIdentifier.m328b() != null && !groupIdentifier.m328b().equals(m328b())) {
            return false;
        }
        if ((groupIdentifier.m327a() == null) ^ (m327a() == null)) {
            return false;
        }
        return groupIdentifier.m327a() == null || groupIdentifier.m327a().equals(m327a());
    }

    public int hashCode() {
        return (((m328b() == null ? 0 : m328b().hashCode()) + 31) * 31) + (m327a() != null ? m327a().hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m328b() != null) {
            sb.append("GroupName: " + m328b() + ",");
        }
        if (m327a() != null) {
            sb.append("GroupId: " + m327a());
        }
        sb.append("}");
        return sb.toString();
    }
}
