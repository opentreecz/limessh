package com.amazonaws.services.ec2.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class InstanceNetworkInterfaceAssociation implements Serializable {

    /* renamed from: O */
    public String f319O;

    /* renamed from: P */
    public String f320P;

    /* renamed from: Q */
    public String f321Q;

    /* renamed from: a */
    public String m436a() {
        return this.f321Q;
    }

    /* renamed from: b */
    public String m437b() {
        return this.f320P;
    }

    /* renamed from: c */
    public String m438c() {
        return this.f319O;
    }

    /* renamed from: d */
    public void m439d(String str) {
        this.f321Q = str;
    }

    /* renamed from: e */
    public void m440e(String str) {
        this.f320P = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceNetworkInterfaceAssociation)) {
            return false;
        }
        InstanceNetworkInterfaceAssociation instanceNetworkInterfaceAssociation = (InstanceNetworkInterfaceAssociation) obj;
        if ((instanceNetworkInterfaceAssociation.m438c() == null) ^ (m438c() == null)) {
            return false;
        }
        if (instanceNetworkInterfaceAssociation.m438c() != null && !instanceNetworkInterfaceAssociation.m438c().equals(m438c())) {
            return false;
        }
        if ((instanceNetworkInterfaceAssociation.m437b() == null) ^ (m437b() == null)) {
            return false;
        }
        if (instanceNetworkInterfaceAssociation.m437b() != null && !instanceNetworkInterfaceAssociation.m437b().equals(m437b())) {
            return false;
        }
        if ((instanceNetworkInterfaceAssociation.m436a() == null) ^ (m436a() == null)) {
            return false;
        }
        return instanceNetworkInterfaceAssociation.m436a() == null || instanceNetworkInterfaceAssociation.m436a().equals(m436a());
    }

    /* renamed from: f */
    public void m441f(String str) {
        this.f319O = str;
    }

    public int hashCode() {
        return (((((m438c() == null ? 0 : m438c().hashCode()) + 31) * 31) + (m437b() == null ? 0 : m437b().hashCode())) * 31) + (m436a() != null ? m436a().hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m438c() != null) {
            sb.append("PublicIp: " + m438c() + ",");
        }
        if (m437b() != null) {
            sb.append("PublicDnsName: " + m437b() + ",");
        }
        if (m436a() != null) {
            sb.append("IpOwnerId: " + m436a());
        }
        sb.append("}");
        return sb.toString();
    }
}
