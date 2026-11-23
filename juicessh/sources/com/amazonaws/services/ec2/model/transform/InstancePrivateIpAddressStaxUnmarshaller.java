package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.services.ec2.model.InstancePrivateIpAddress;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class InstancePrivateIpAddressStaxUnmarshaller implements Unmarshaller<InstancePrivateIpAddress, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static InstancePrivateIpAddressStaxUnmarshaller f415a;

    /* renamed from: b */
    public static InstancePrivateIpAddressStaxUnmarshaller m584b() {
        if (f415a == null) {
            f415a = new InstancePrivateIpAddressStaxUnmarshaller();
        }
        return f415a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InstancePrivateIpAddress mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstancePrivateIpAddress instancePrivateIpAddress = new InstancePrivateIpAddress();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return instancePrivateIpAddress;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("privateIpAddress", i)) {
                    instancePrivateIpAddress.m459i(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("privateDnsName", i)) {
                    instancePrivateIpAddress.m458h(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("primary", i)) {
                    instancePrivateIpAddress.m457f(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.m607b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("association", i)) {
                    instancePrivateIpAddress.m456e(InstanceNetworkInterfaceAssociationStaxUnmarshaller.m578b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return instancePrivateIpAddress;
            }
        }
    }
}
