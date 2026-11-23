package com.amazonaws.services.ec2.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Monitoring implements Serializable {

    /* renamed from: O */
    public String f336O;

    /* renamed from: a */
    public String m469a() {
        return this.f336O;
    }

    /* renamed from: b */
    public void m470b(String str) {
        this.f336O = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Monitoring)) {
            return false;
        }
        Monitoring monitoring = (Monitoring) obj;
        if ((monitoring.m469a() == null) ^ (m469a() == null)) {
            return false;
        }
        return monitoring.m469a() == null || monitoring.m469a().equals(m469a());
    }

    public int hashCode() {
        return 31 + (m469a() == null ? 0 : m469a().hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m469a() != null) {
            sb.append("State: " + m469a());
        }
        sb.append("}");
        return sb.toString();
    }
}
