package com.amazonaws.services.ec2.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class StateReason implements Serializable {

    /* renamed from: O */
    public String f404O;

    /* renamed from: P */
    public String f405P;

    /* renamed from: a */
    public String m551a() {
        return this.f404O;
    }

    /* renamed from: b */
    public String m552b() {
        return this.f405P;
    }

    /* renamed from: c */
    public void m553c(String str) {
        this.f404O = str;
    }

    /* renamed from: d */
    public void m554d(String str) {
        this.f405P = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StateReason)) {
            return false;
        }
        StateReason stateReason = (StateReason) obj;
        if ((stateReason.m551a() == null) ^ (m551a() == null)) {
            return false;
        }
        if (stateReason.m551a() != null && !stateReason.m551a().equals(m551a())) {
            return false;
        }
        if ((stateReason.m552b() == null) ^ (m552b() == null)) {
            return false;
        }
        return stateReason.m552b() == null || stateReason.m552b().equals(m552b());
    }

    public int hashCode() {
        return (((m551a() == null ? 0 : m551a().hashCode()) + 31) * 31) + (m552b() != null ? m552b().hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m551a() != null) {
            sb.append("Code: " + m551a() + ",");
        }
        if (m552b() != null) {
            sb.append("Message: " + m552b());
        }
        sb.append("}");
        return sb.toString();
    }
}
