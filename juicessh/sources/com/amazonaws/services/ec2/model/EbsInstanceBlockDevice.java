package com.amazonaws.services.ec2.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public class EbsInstanceBlockDevice implements Serializable {

    /* renamed from: O */
    public String f254O;

    /* renamed from: P */
    public String f255P;

    /* renamed from: Q */
    public Date f256Q;

    /* renamed from: R */
    public Boolean f257R;

    /* renamed from: a */
    public Date m317a() {
        return this.f256Q;
    }

    /* renamed from: b */
    public String m318b() {
        return this.f255P;
    }

    /* renamed from: c */
    public String m319c() {
        return this.f254O;
    }

    /* renamed from: d */
    public Boolean m320d() {
        return this.f257R;
    }

    /* renamed from: e */
    public void m321e(Date date) {
        this.f256Q = date;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EbsInstanceBlockDevice)) {
            return false;
        }
        EbsInstanceBlockDevice ebsInstanceBlockDevice = (EbsInstanceBlockDevice) obj;
        if ((ebsInstanceBlockDevice.m319c() == null) ^ (m319c() == null)) {
            return false;
        }
        if (ebsInstanceBlockDevice.m319c() != null && !ebsInstanceBlockDevice.m319c().equals(m319c())) {
            return false;
        }
        if ((ebsInstanceBlockDevice.m318b() == null) ^ (m318b() == null)) {
            return false;
        }
        if (ebsInstanceBlockDevice.m318b() != null && !ebsInstanceBlockDevice.m318b().equals(m318b())) {
            return false;
        }
        if ((ebsInstanceBlockDevice.m317a() == null) ^ (m317a() == null)) {
            return false;
        }
        if (ebsInstanceBlockDevice.m317a() != null && !ebsInstanceBlockDevice.m317a().equals(m317a())) {
            return false;
        }
        if ((ebsInstanceBlockDevice.m320d() == null) ^ (m320d() == null)) {
            return false;
        }
        return ebsInstanceBlockDevice.m320d() == null || ebsInstanceBlockDevice.m320d().equals(m320d());
    }

    /* renamed from: f */
    public void m322f(Boolean bool) {
        this.f257R = bool;
    }

    /* renamed from: h */
    public void m323h(String str) {
        this.f255P = str;
    }

    public int hashCode() {
        return (((((((m319c() == null ? 0 : m319c().hashCode()) + 31) * 31) + (m318b() == null ? 0 : m318b().hashCode())) * 31) + (m317a() == null ? 0 : m317a().hashCode())) * 31) + (m320d() != null ? m320d().hashCode() : 0);
    }

    /* renamed from: i */
    public void m324i(String str) {
        this.f254O = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m319c() != null) {
            sb.append("VolumeId: " + m319c() + ",");
        }
        if (m318b() != null) {
            sb.append("Status: " + m318b() + ",");
        }
        if (m317a() != null) {
            sb.append("AttachTime: " + m317a() + ",");
        }
        if (m320d() != null) {
            sb.append("DeleteOnTermination: " + m320d());
        }
        sb.append("}");
        return sb.toString();
    }
}
