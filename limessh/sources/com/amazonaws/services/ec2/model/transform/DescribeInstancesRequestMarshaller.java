package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/* loaded from: classes.dex */
public class DescribeInstancesRequestMarshaller implements Marshaller<Request<DescribeInstancesRequest>, DescribeInstancesRequest> {
    /* renamed from: a */
    public Request<DescribeInstancesRequest> m560a(DescribeInstancesRequest describeInstancesRequest) {
        if (describeInstancesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(describeInstancesRequest, "AmazonEC2");
        defaultRequest.mo56l("Action", "DescribeInstances");
        defaultRequest.mo56l("Version", "2015-10-01");
        int i = 1;
        for (String str : describeInstancesRequest.m307k()) {
            if (str != null) {
                StringUtils.m678c(str);
                defaultRequest.mo56l("InstanceId." + i, str);
            }
            i++;
        }
        int i2 = 1;
        for (Filter filter : describeInstancesRequest.m306j()) {
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
        if (describeInstancesRequest.m309m() != null) {
            String m309m = describeInstancesRequest.m309m();
            StringUtils.m678c(m309m);
            defaultRequest.mo56l("NextToken", m309m);
        }
        if (describeInstancesRequest.m308l() != null) {
            defaultRequest.mo56l("MaxResults", StringUtils.m677b(describeInstancesRequest.m308l()));
        }
        return defaultRequest;
    }
}
