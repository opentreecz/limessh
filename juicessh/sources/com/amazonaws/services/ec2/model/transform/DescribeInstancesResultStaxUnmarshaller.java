package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class DescribeInstancesResultStaxUnmarshaller implements Unmarshaller<DescribeInstancesResult, StaxUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public DescribeInstancesResult mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeInstancesResult describeInstancesResult = new DescribeInstancesResult();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return describeInstancesResult;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("reservationSet/item", i)) {
                    describeInstancesResult.m311b().add(ReservationStaxUnmarshaller.m598b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("nextToken", i)) {
                    describeInstancesResult.m312c(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return describeInstancesResult;
            }
        }
    }
}
