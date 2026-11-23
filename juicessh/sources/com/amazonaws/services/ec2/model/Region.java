package com.amazonaws.services.ec2.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Region implements Serializable {

    /* renamed from: O */
    public String f344O;

    /* renamed from: P */
    public String f345P;

    /* renamed from: a */
    public String m485a() {
        return this.f345P;
    }

    /* renamed from: b */
    public String m486b() {
        return this.f344O;
    }

    /* renamed from: c */
    public void m487c(String str) {
        this.f345P = str;
    }

    /* renamed from: d */
    public void m488d(String str) {
        this.f344O = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Region)) {
            return false;
        }
        Region region = (Region) obj;
        if ((region.m486b() == null) ^ (m486b() == null)) {
            return false;
        }
        if (region.m486b() != null && !region.m486b().equals(m486b())) {
            return false;
        }
        if ((region.m485a() == null) ^ (m485a() == null)) {
            return false;
        }
        return region.m485a() == null || region.m485a().equals(m485a());
    }

    public int hashCode() {
        return (((m486b() == null ? 0 : m486b().hashCode()) + 31) * 31) + (m485a() != null ? m485a().hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m486b() != null) {
            sb.append("RegionName: " + m486b() + ",");
        }
        if (m485a() != null) {
            sb.append("Endpoint: " + m485a());
        }
        sb.append("}");
        return sb.toString();
    }
}
