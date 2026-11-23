package com.amazonaws.services.ec2.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Placement implements Serializable {

    /* renamed from: O */
    public String f337O;

    /* renamed from: P */
    public String f338P;

    /* renamed from: Q */
    public String f339Q;

    /* renamed from: R */
    public String f340R;

    /* renamed from: S */
    public String f341S;

    /* renamed from: a */
    public String m471a() {
        return this.f341S;
    }

    /* renamed from: b */
    public String m472b() {
        return this.f337O;
    }

    /* renamed from: c */
    public String m473c() {
        return this.f338P;
    }

    /* renamed from: d */
    public String m474d() {
        return this.f340R;
    }

    /* renamed from: e */
    public String m475e() {
        return this.f339Q;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Placement)) {
            return false;
        }
        Placement placement = (Placement) obj;
        if ((placement.m472b() == null) ^ (m472b() == null)) {
            return false;
        }
        if (placement.m472b() != null && !placement.m472b().equals(m472b())) {
            return false;
        }
        if ((placement.m473c() == null) ^ (m473c() == null)) {
            return false;
        }
        if (placement.m473c() != null && !placement.m473c().equals(m473c())) {
            return false;
        }
        if ((placement.m475e() == null) ^ (m475e() == null)) {
            return false;
        }
        if (placement.m475e() != null && !placement.m475e().equals(m475e())) {
            return false;
        }
        if ((placement.m474d() == null) ^ (m474d() == null)) {
            return false;
        }
        if (placement.m474d() != null && !placement.m474d().equals(m474d())) {
            return false;
        }
        if ((placement.m471a() == null) ^ (m471a() == null)) {
            return false;
        }
        return placement.m471a() == null || placement.m471a().equals(m471a());
    }

    /* renamed from: f */
    public void m476f(String str) {
        this.f341S = str;
    }

    /* renamed from: h */
    public void m477h(String str) {
        this.f337O = str;
    }

    public int hashCode() {
        return (((((((((m472b() == null ? 0 : m472b().hashCode()) + 31) * 31) + (m473c() == null ? 0 : m473c().hashCode())) * 31) + (m475e() == null ? 0 : m475e().hashCode())) * 31) + (m474d() == null ? 0 : m474d().hashCode())) * 31) + (m471a() != null ? m471a().hashCode() : 0);
    }

    /* renamed from: i */
    public void m478i(String str) {
        this.f338P = str;
    }

    /* renamed from: j */
    public void m479j(String str) {
        this.f340R = str;
    }

    /* renamed from: k */
    public void m480k(String str) {
        this.f339Q = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m472b() != null) {
            sb.append("AvailabilityZone: " + m472b() + ",");
        }
        if (m473c() != null) {
            sb.append("GroupName: " + m473c() + ",");
        }
        if (m475e() != null) {
            sb.append("Tenancy: " + m475e() + ",");
        }
        if (m474d() != null) {
            sb.append("HostId: " + m474d() + ",");
        }
        if (m471a() != null) {
            sb.append("Affinity: " + m471a());
        }
        sb.append("}");
        return sb.toString();
    }
}
