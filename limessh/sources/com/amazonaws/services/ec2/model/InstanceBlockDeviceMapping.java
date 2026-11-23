package com.amazonaws.services.ec2.model;

import java.io.Serializable;

/* loaded from: classes.dex */
public class InstanceBlockDeviceMapping implements Serializable {

    /* renamed from: O */
    public String f303O;

    /* renamed from: P */
    public EbsInstanceBlockDevice f304P;

    /* renamed from: a */
    public String m406a() {
        return this.f303O;
    }

    /* renamed from: b */
    public EbsInstanceBlockDevice m407b() {
        return this.f304P;
    }

    /* renamed from: c */
    public void m408c(String str) {
        this.f303O = str;
    }

    /* renamed from: d */
    public void m409d(EbsInstanceBlockDevice ebsInstanceBlockDevice) {
        this.f304P = ebsInstanceBlockDevice;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceBlockDeviceMapping)) {
            return false;
        }
        InstanceBlockDeviceMapping instanceBlockDeviceMapping = (InstanceBlockDeviceMapping) obj;
        if ((instanceBlockDeviceMapping.m406a() == null) ^ (m406a() == null)) {
            return false;
        }
        if (instanceBlockDeviceMapping.m406a() != null && !instanceBlockDeviceMapping.m406a().equals(m406a())) {
            return false;
        }
        if ((instanceBlockDeviceMapping.m407b() == null) ^ (m407b() == null)) {
            return false;
        }
        return instanceBlockDeviceMapping.m407b() == null || instanceBlockDeviceMapping.m407b().equals(m407b());
    }

    public int hashCode() {
        return (((m406a() == null ? 0 : m406a().hashCode()) + 31) * 31) + (m407b() != null ? m407b().hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m406a() != null) {
            sb.append("DeviceName: " + m406a() + ",");
        }
        if (m407b() != null) {
            sb.append("Ebs: " + m407b());
        }
        sb.append("}");
        return sb.toString();
    }
}
