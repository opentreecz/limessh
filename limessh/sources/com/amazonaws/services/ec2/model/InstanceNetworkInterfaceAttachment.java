package com.amazonaws.services.ec2.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public class InstanceNetworkInterfaceAttachment implements Serializable {

    /* renamed from: O */
    public String f322O;

    /* renamed from: P */
    public Integer f323P;

    /* renamed from: Q */
    public String f324Q;

    /* renamed from: R */
    public Date f325R;

    /* renamed from: S */
    public Boolean f326S;

    /* renamed from: a */
    public Date m442a() {
        return this.f325R;
    }

    /* renamed from: b */
    public String m443b() {
        return this.f322O;
    }

    /* renamed from: c */
    public Integer m444c() {
        return this.f323P;
    }

    /* renamed from: d */
    public String m445d() {
        return this.f324Q;
    }

    /* renamed from: e */
    public Boolean m446e() {
        return this.f326S;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceNetworkInterfaceAttachment)) {
            return false;
        }
        InstanceNetworkInterfaceAttachment instanceNetworkInterfaceAttachment = (InstanceNetworkInterfaceAttachment) obj;
        if ((instanceNetworkInterfaceAttachment.m443b() == null) ^ (m443b() == null)) {
            return false;
        }
        if (instanceNetworkInterfaceAttachment.m443b() != null && !instanceNetworkInterfaceAttachment.m443b().equals(m443b())) {
            return false;
        }
        if ((instanceNetworkInterfaceAttachment.m444c() == null) ^ (m444c() == null)) {
            return false;
        }
        if (instanceNetworkInterfaceAttachment.m444c() != null && !instanceNetworkInterfaceAttachment.m444c().equals(m444c())) {
            return false;
        }
        if ((instanceNetworkInterfaceAttachment.m445d() == null) ^ (m445d() == null)) {
            return false;
        }
        if (instanceNetworkInterfaceAttachment.m445d() != null && !instanceNetworkInterfaceAttachment.m445d().equals(m445d())) {
            return false;
        }
        if ((instanceNetworkInterfaceAttachment.m442a() == null) ^ (m442a() == null)) {
            return false;
        }
        if (instanceNetworkInterfaceAttachment.m442a() != null && !instanceNetworkInterfaceAttachment.m442a().equals(m442a())) {
            return false;
        }
        if ((instanceNetworkInterfaceAttachment.m446e() == null) ^ (m446e() == null)) {
            return false;
        }
        return instanceNetworkInterfaceAttachment.m446e() == null || instanceNetworkInterfaceAttachment.m446e().equals(m446e());
    }

    /* renamed from: f */
    public void m447f(Date date) {
        this.f325R = date;
    }

    /* renamed from: h */
    public void m448h(String str) {
        this.f322O = str;
    }

    public int hashCode() {
        return (((((((((m443b() == null ? 0 : m443b().hashCode()) + 31) * 31) + (m444c() == null ? 0 : m444c().hashCode())) * 31) + (m445d() == null ? 0 : m445d().hashCode())) * 31) + (m442a() == null ? 0 : m442a().hashCode())) * 31) + (m446e() != null ? m446e().hashCode() : 0);
    }

    /* renamed from: i */
    public void m449i(Boolean bool) {
        this.f326S = bool;
    }

    /* renamed from: j */
    public void m450j(Integer num) {
        this.f323P = num;
    }

    /* renamed from: k */
    public void m451k(String str) {
        this.f324Q = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m443b() != null) {
            sb.append("AttachmentId: " + m443b() + ",");
        }
        if (m444c() != null) {
            sb.append("DeviceIndex: " + m444c() + ",");
        }
        if (m445d() != null) {
            sb.append("Status: " + m445d() + ",");
        }
        if (m442a() != null) {
            sb.append("AttachTime: " + m442a() + ",");
        }
        if (m446e() != null) {
            sb.append("DeleteOnTermination: " + m446e());
        }
        sb.append("}");
        return sb.toString();
    }
}
