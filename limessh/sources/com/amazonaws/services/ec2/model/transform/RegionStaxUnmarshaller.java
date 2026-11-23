package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.services.ec2.model.Region;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class RegionStaxUnmarshaller implements Unmarshaller<Region, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static RegionStaxUnmarshaller f421a;

    /* renamed from: b */
    public static RegionStaxUnmarshaller m596b() {
        if (f421a == null) {
            f421a = new RegionStaxUnmarshaller();
        }
        return f421a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Region mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Region region = new Region();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return region;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("regionName", i)) {
                    region.m488d(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("regionEndpoint", i)) {
                    region.m487c(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return region;
            }
        }
    }
}
