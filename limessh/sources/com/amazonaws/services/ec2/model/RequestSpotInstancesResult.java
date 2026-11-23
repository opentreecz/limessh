package com.amazonaws.services.ec2.model;

import com.amazonaws.internal.ListWithAutoConstructFlag;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class RequestSpotInstancesResult implements Serializable {

    /* renamed from: O */
    public ListWithAutoConstructFlag<SpotInstanceRequest> f356O;

    /* renamed from: a */
    public List<SpotInstanceRequest> m499a() {
        if (this.f356O == null) {
            ListWithAutoConstructFlag<SpotInstanceRequest> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f356O = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f356O;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RequestSpotInstancesResult)) {
            return false;
        }
        RequestSpotInstancesResult requestSpotInstancesResult = (RequestSpotInstancesResult) obj;
        if ((requestSpotInstancesResult.m499a() == null) ^ (m499a() == null)) {
            return false;
        }
        return requestSpotInstancesResult.m499a() == null || requestSpotInstancesResult.m499a().equals(m499a());
    }

    public int hashCode() {
        return 31 + (m499a() == null ? 0 : m499a().hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m499a() != null) {
            sb.append("SpotInstanceRequests: " + m499a());
        }
        sb.append("}");
        return sb.toString();
    }
}
