package com.amazonaws.services.ec2.model;

import com.amazonaws.internal.ListWithAutoConstructFlag;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class DescribeRegionsResult implements Serializable {

    /* renamed from: O */
    public ListWithAutoConstructFlag<Region> f252O;

    /* renamed from: a */
    public List<Region> m315a() {
        if (this.f252O == null) {
            ListWithAutoConstructFlag<Region> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f252O = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f252O;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeRegionsResult)) {
            return false;
        }
        DescribeRegionsResult describeRegionsResult = (DescribeRegionsResult) obj;
        if ((describeRegionsResult.m315a() == null) ^ (m315a() == null)) {
            return false;
        }
        return describeRegionsResult.m315a() == null || describeRegionsResult.m315a().equals(m315a());
    }

    public int hashCode() {
        return 31 + (m315a() == null ? 0 : m315a().hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m315a() != null) {
            sb.append("Regions: " + m315a());
        }
        sb.append("}");
        return sb.toString();
    }
}
