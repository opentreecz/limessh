package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.services.ec2.model.DescribeRegionsResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class DescribeRegionsResultStaxUnmarshaller implements Unmarshaller<DescribeRegionsResult, StaxUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public DescribeRegionsResult mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeRegionsResult describeRegionsResult = new DescribeRegionsResult();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return describeRegionsResult;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("regionInfo/item", i)) {
                    describeRegionsResult.m315a().add(RegionStaxUnmarshaller.m596b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return describeRegionsResult;
            }
        }
    }
}
