package com.amazonaws.services.ec2.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class RunInstancesResult implements Serializable {

    /* renamed from: O */
    public Reservation f385O;

    /* renamed from: a */
    public Reservation m532a() {
        return this.f385O;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RunInstancesResult)) {
            return false;
        }
        RunInstancesResult runInstancesResult = (RunInstancesResult) obj;
        if ((runInstancesResult.m532a() == null) ^ (m532a() == null)) {
            return false;
        }
        return runInstancesResult.m532a() == null || runInstancesResult.m532a().equals(m532a());
    }

    public int hashCode() {
        return 31 + (m532a() == null ? 0 : m532a().hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m532a() != null) {
            sb.append("Reservation: " + m532a());
        }
        sb.append("}");
        return sb.toString();
    }
}
