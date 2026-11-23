package com.amazonaws.services.ec2.model;

import com.amazonaws.internal.ListWithAutoConstructFlag;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class DescribeInstancesResult implements Serializable {

    /* renamed from: O */
    public ListWithAutoConstructFlag<Reservation> f248O;

    /* renamed from: P */
    public String f249P;

    /* renamed from: a */
    public String m310a() {
        return this.f249P;
    }

    /* renamed from: b */
    public List<Reservation> m311b() {
        if (this.f248O == null) {
            ListWithAutoConstructFlag<Reservation> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f248O = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f248O;
    }

    /* renamed from: c */
    public void m312c(String str) {
        this.f249P = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeInstancesResult)) {
            return false;
        }
        DescribeInstancesResult describeInstancesResult = (DescribeInstancesResult) obj;
        if ((describeInstancesResult.m311b() == null) ^ (m311b() == null)) {
            return false;
        }
        if (describeInstancesResult.m311b() != null && !describeInstancesResult.m311b().equals(m311b())) {
            return false;
        }
        if ((describeInstancesResult.m310a() == null) ^ (m310a() == null)) {
            return false;
        }
        return describeInstancesResult.m310a() == null || describeInstancesResult.m310a().equals(m310a());
    }

    public int hashCode() {
        return (((m311b() == null ? 0 : m311b().hashCode()) + 31) * 31) + (m310a() != null ? m310a().hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m311b() != null) {
            sb.append("Reservations: " + m311b() + ",");
        }
        if (m310a() != null) {
            sb.append("NextToken: " + m310a());
        }
        sb.append("}");
        return sb.toString();
    }
}
