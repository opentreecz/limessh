package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.services.ec2.model.InstanceNetworkInterfaceAssociation;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class InstanceNetworkInterfaceAssociationStaxUnmarshaller implements Unmarshaller<InstanceNetworkInterfaceAssociation, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static InstanceNetworkInterfaceAssociationStaxUnmarshaller f412a;

    /* renamed from: b */
    public static InstanceNetworkInterfaceAssociationStaxUnmarshaller m578b() {
        if (f412a == null) {
            f412a = new InstanceNetworkInterfaceAssociationStaxUnmarshaller();
        }
        return f412a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InstanceNetworkInterfaceAssociation mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceNetworkInterfaceAssociation instanceNetworkInterfaceAssociation = new InstanceNetworkInterfaceAssociation();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return instanceNetworkInterfaceAssociation;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("publicIp", i)) {
                    instanceNetworkInterfaceAssociation.m441f(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("publicDnsName", i)) {
                    instanceNetworkInterfaceAssociation.m440e(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("ipOwnerId", i)) {
                    instanceNetworkInterfaceAssociation.m439d(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return instanceNetworkInterfaceAssociation;
            }
        }
    }
}
