package com.amazonaws.services.ec2.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class InstancePrivateIpAddress implements Serializable {

    /* renamed from: O */
    public String f327O;

    /* renamed from: P */
    public String f328P;

    /* renamed from: Q */
    public Boolean f329Q;

    /* renamed from: R */
    public InstanceNetworkInterfaceAssociation f330R;

    /* renamed from: a */
    public InstanceNetworkInterfaceAssociation m452a() {
        return this.f330R;
    }

    /* renamed from: b */
    public String m453b() {
        return this.f328P;
    }

    /* renamed from: c */
    public String m454c() {
        return this.f327O;
    }

    /* renamed from: d */
    public Boolean m455d() {
        return this.f329Q;
    }

    /* renamed from: e */
    public void m456e(InstanceNetworkInterfaceAssociation instanceNetworkInterfaceAssociation) {
        this.f330R = instanceNetworkInterfaceAssociation;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstancePrivateIpAddress)) {
            return false;
        }
        InstancePrivateIpAddress instancePrivateIpAddress = (InstancePrivateIpAddress) obj;
        if ((instancePrivateIpAddress.m454c() == null) ^ (m454c() == null)) {
            return false;
        }
        if (instancePrivateIpAddress.m454c() != null && !instancePrivateIpAddress.m454c().equals(m454c())) {
            return false;
        }
        if ((instancePrivateIpAddress.m453b() == null) ^ (m453b() == null)) {
            return false;
        }
        if (instancePrivateIpAddress.m453b() != null && !instancePrivateIpAddress.m453b().equals(m453b())) {
            return false;
        }
        if ((instancePrivateIpAddress.m455d() == null) ^ (m455d() == null)) {
            return false;
        }
        if (instancePrivateIpAddress.m455d() != null && !instancePrivateIpAddress.m455d().equals(m455d())) {
            return false;
        }
        if ((instancePrivateIpAddress.m452a() == null) ^ (m452a() == null)) {
            return false;
        }
        return instancePrivateIpAddress.m452a() == null || instancePrivateIpAddress.m452a().equals(m452a());
    }

    /* renamed from: f */
    public void m457f(Boolean bool) {
        this.f329Q = bool;
    }

    /* renamed from: h */
    public void m458h(String str) {
        this.f328P = str;
    }

    public int hashCode() {
        return (((((((m454c() == null ? 0 : m454c().hashCode()) + 31) * 31) + (m453b() == null ? 0 : m453b().hashCode())) * 31) + (m455d() == null ? 0 : m455d().hashCode())) * 31) + (m452a() != null ? m452a().hashCode() : 0);
    }

    /* renamed from: i */
    public void m459i(String str) {
        this.f327O = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m454c() != null) {
            sb.append("PrivateIpAddress: " + m454c() + ",");
        }
        if (m453b() != null) {
            sb.append("PrivateDnsName: " + m453b() + ",");
        }
        if (m455d() != null) {
            sb.append("Primary: " + m455d() + ",");
        }
        if (m452a() != null) {
            sb.append("Association: " + m452a());
        }
        sb.append("}");
        return sb.toString();
    }
}
