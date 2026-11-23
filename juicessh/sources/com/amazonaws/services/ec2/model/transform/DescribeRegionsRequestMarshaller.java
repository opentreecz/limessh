package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeRegionsRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/* loaded from: classes.dex */
public class DescribeRegionsRequestMarshaller implements Marshaller<Request<DescribeRegionsRequest>, DescribeRegionsRequest> {
    /* renamed from: a */
    public Request<DescribeRegionsRequest> m563a(DescribeRegionsRequest describeRegionsRequest) {
        if (describeRegionsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(describeRegionsRequest, "AmazonEC2");
        defaultRequest.mo56l("Action", "DescribeRegions");
        defaultRequest.mo56l("Version", "2015-10-01");
        int i = 1;
        for (String str : describeRegionsRequest.m314k()) {
            if (str != null) {
                StringUtils.m678c(str);
                defaultRequest.mo56l("RegionName." + i, str);
            }
            i++;
        }
        int i2 = 1;
        for (Filter filter : describeRegionsRequest.m313j()) {
            if (filter != null) {
                if (filter.m325a() != null) {
                    String m325a = filter.m325a();
                    StringUtils.m678c(m325a);
                    defaultRequest.mo56l("Filter." + i2 + ".Name", m325a);
                }
                int i3 = 1;
                for (String str2 : filter.m326b()) {
                    if (str2 != null) {
                        StringUtils.m678c(str2);
                        defaultRequest.mo56l("Filter." + i2 + ".Value." + i3, str2);
                    }
                    i3++;
                }
            }
            i2++;
        }
        return defaultRequest;
    }
}
