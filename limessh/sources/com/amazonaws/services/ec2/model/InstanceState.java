package com.amazonaws.services.ec2.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class InstanceState implements Serializable {

    /* renamed from: O */
    public Integer f331O;

    /* renamed from: P */
    public String f332P;

    /* renamed from: a */
    public Integer m460a() {
        return this.f331O;
    }

    /* renamed from: b */
    public String m461b() {
        return this.f332P;
    }

    /* renamed from: c */
    public void m462c(Integer num) {
        this.f331O = num;
    }

    /* renamed from: d */
    public void m463d(String str) {
        this.f332P = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceState)) {
            return false;
        }
        InstanceState instanceState = (InstanceState) obj;
        if ((instanceState.m460a() == null) ^ (m460a() == null)) {
            return false;
        }
        if (instanceState.m460a() != null && !instanceState.m460a().equals(m460a())) {
            return false;
        }
        if ((instanceState.m461b() == null) ^ (m461b() == null)) {
            return false;
        }
        return instanceState.m461b() == null || instanceState.m461b().equals(m461b());
    }

    public int hashCode() {
        return (((m460a() == null ? 0 : m460a().hashCode()) + 31) * 31) + (m461b() != null ? m461b().hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m460a() != null) {
            sb.append("Code: " + m460a() + ",");
        }
        if (m461b() != null) {
            sb.append("Name: " + m461b());
        }
        sb.append("}");
        return sb.toString();
    }
}
