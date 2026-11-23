package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.internal.ListWithAutoConstructFlag;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class DescribeInstancesRequest extends AmazonWebServiceRequest implements Serializable, DryRunSupportedRequest<DescribeInstancesRequest> {

    /* renamed from: R */
    public ListWithAutoConstructFlag<String> f244R;

    /* renamed from: S */
    public ListWithAutoConstructFlag<Filter> f245S;

    /* renamed from: T */
    public String f246T;

    /* renamed from: U */
    public Integer f247U;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeInstancesRequest)) {
            return false;
        }
        DescribeInstancesRequest describeInstancesRequest = (DescribeInstancesRequest) obj;
        if ((describeInstancesRequest.m307k() == null) ^ (m307k() == null)) {
            return false;
        }
        if (describeInstancesRequest.m307k() != null && !describeInstancesRequest.m307k().equals(m307k())) {
            return false;
        }
        if ((describeInstancesRequest.m306j() == null) ^ (m306j() == null)) {
            return false;
        }
        if (describeInstancesRequest.m306j() != null && !describeInstancesRequest.m306j().equals(m306j())) {
            return false;
        }
        if ((describeInstancesRequest.m309m() == null) ^ (m309m() == null)) {
            return false;
        }
        if (describeInstancesRequest.m309m() != null && !describeInstancesRequest.m309m().equals(m309m())) {
            return false;
        }
        if ((describeInstancesRequest.m308l() == null) ^ (m308l() == null)) {
            return false;
        }
        return describeInstancesRequest.m308l() == null || describeInstancesRequest.m308l().equals(m308l());
    }

    public int hashCode() {
        return (((((((m307k() == null ? 0 : m307k().hashCode()) + 31) * 31) + (m306j() == null ? 0 : m306j().hashCode())) * 31) + (m309m() == null ? 0 : m309m().hashCode())) * 31) + (m308l() != null ? m308l().hashCode() : 0);
    }

    /* renamed from: j */
    public List<Filter> m306j() {
        if (this.f245S == null) {
            ListWithAutoConstructFlag<Filter> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f245S = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f245S;
    }

    /* renamed from: k */
    public List<String> m307k() {
        if (this.f244R == null) {
            ListWithAutoConstructFlag<String> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f244R = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f244R;
    }

    /* renamed from: l */
    public Integer m308l() {
        return this.f247U;
    }

    /* renamed from: m */
    public String m309m() {
        return this.f246T;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m307k() != null) {
            sb.append("InstanceIds: " + m307k() + ",");
        }
        if (m306j() != null) {
            sb.append("Filters: " + m306j() + ",");
        }
        if (m309m() != null) {
            sb.append("NextToken: " + m309m() + ",");
        }
        if (m308l() != null) {
            sb.append("MaxResults: " + m308l());
        }
        sb.append("}");
        return sb.toString();
    }
}
