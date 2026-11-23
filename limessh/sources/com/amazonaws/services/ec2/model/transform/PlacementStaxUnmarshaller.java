package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.services.ec2.model.Placement;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class PlacementStaxUnmarshaller implements Unmarshaller<Placement, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static PlacementStaxUnmarshaller f419a;

    /* renamed from: b */
    public static PlacementStaxUnmarshaller m592b() {
        if (f419a == null) {
            f419a = new PlacementStaxUnmarshaller();
        }
        return f419a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Placement mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Placement placement = new Placement();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return placement;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("availabilityZone", i)) {
                    placement.m477h(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("groupName", i)) {
                    placement.m478i(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("tenancy", i)) {
                    placement.m480k(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("hostId", i)) {
                    placement.m479j(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("affinity", i)) {
                    placement.m476f(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return placement;
            }
        }
    }
}
