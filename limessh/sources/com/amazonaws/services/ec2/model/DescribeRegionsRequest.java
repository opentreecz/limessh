package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.internal.ListWithAutoConstructFlag;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class DescribeRegionsRequest extends AmazonWebServiceRequest implements Serializable, DryRunSupportedRequest<DescribeRegionsRequest> {

    /* renamed from: R */
    public ListWithAutoConstructFlag<String> f250R;

    /* renamed from: S */
    public ListWithAutoConstructFlag<Filter> f251S;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeRegionsRequest)) {
            return false;
        }
        DescribeRegionsRequest describeRegionsRequest = (DescribeRegionsRequest) obj;
        if ((describeRegionsRequest.m314k() == null) ^ (m314k() == null)) {
            return false;
        }
        if (describeRegionsRequest.m314k() != null && !describeRegionsRequest.m314k().equals(m314k())) {
            return false;
        }
        if ((describeRegionsRequest.m313j() == null) ^ (m313j() == null)) {
            return false;
        }
        return describeRegionsRequest.m313j() == null || describeRegionsRequest.m313j().equals(m313j());
    }

    public int hashCode() {
        return (((m314k() == null ? 0 : m314k().hashCode()) + 31) * 31) + (m313j() != null ? m313j().hashCode() : 0);
    }

    /* renamed from: j */
    public List<Filter> m313j() {
        if (this.f251S == null) {
            ListWithAutoConstructFlag<Filter> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f251S = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f251S;
    }

    /* renamed from: k */
    public List<String> m314k() {
        if (this.f250R == null) {
            ListWithAutoConstructFlag<String> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f250R = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f250R;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m314k() != null) {
            sb.append("RegionNames: " + m314k() + ",");
        }
        if (m313j() != null) {
            sb.append("Filters: " + m313j());
        }
        sb.append("}");
        return sb.toString();
    }
}
