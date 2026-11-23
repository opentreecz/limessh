package com.amazonaws.services.ec2.model;

import com.amazonaws.internal.ListWithAutoConstructFlag;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class DescribeSpotInstanceRequestsResult implements Serializable {

    /* renamed from: O */
    public ListWithAutoConstructFlag<SpotInstanceRequest> f253O;

    /* renamed from: a */
    public List<SpotInstanceRequest> m316a() {
        if (this.f253O == null) {
            ListWithAutoConstructFlag<SpotInstanceRequest> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f253O = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f253O;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeSpotInstanceRequestsResult)) {
            return false;
        }
        DescribeSpotInstanceRequestsResult describeSpotInstanceRequestsResult = (DescribeSpotInstanceRequestsResult) obj;
        if ((describeSpotInstanceRequestsResult.m316a() == null) ^ (m316a() == null)) {
            return false;
        }
        return describeSpotInstanceRequestsResult.m316a() == null || describeSpotInstanceRequestsResult.m316a().equals(m316a());
    }

    public int hashCode() {
        return 31 + (m316a() == null ? 0 : m316a().hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m316a() != null) {
            sb.append("SpotInstanceRequests: " + m316a());
        }
        sb.append("}");
        return sb.toString();
    }
}
