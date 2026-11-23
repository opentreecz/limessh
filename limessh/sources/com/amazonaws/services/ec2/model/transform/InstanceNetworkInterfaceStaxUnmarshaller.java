package com.amazonaws.services.ec2.model.transform;

import androidx.core.app.NotificationCompat;
import com.amazonaws.services.ec2.model.InstanceNetworkInterface;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class InstanceNetworkInterfaceStaxUnmarshaller implements Unmarshaller<InstanceNetworkInterface, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static InstanceNetworkInterfaceStaxUnmarshaller f414a;

    /* renamed from: b */
    public static InstanceNetworkInterfaceStaxUnmarshaller m582b() {
        if (f414a == null) {
            f414a = new InstanceNetworkInterfaceStaxUnmarshaller();
        }
        return f414a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InstanceNetworkInterface mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceNetworkInterface instanceNetworkInterface = new InstanceNetworkInterface();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return instanceNetworkInterface;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("networkInterfaceId", i)) {
                    instanceNetworkInterface.m429t(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("subnetId", i)) {
                    instanceNetworkInterface.m435z(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("vpcId", i)) {
                    instanceNetworkInterface.m410A(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("description", i)) {
                    instanceNetworkInterface.m427r(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("ownerId", i)) {
                    instanceNetworkInterface.m430u(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g(NotificationCompat.CATEGORY_STATUS, i)) {
                    instanceNetworkInterface.m434y(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("macAddress", i)) {
                    instanceNetworkInterface.m428s(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("privateIpAddress", i)) {
                    instanceNetworkInterface.m432w(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("privateDnsName", i)) {
                    instanceNetworkInterface.m431v(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("sourceDestCheck", i)) {
                    instanceNetworkInterface.m433x(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.m607b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("groupSet/item", i)) {
                    instanceNetworkInterface.m414d().add(GroupIdentifierStaxUnmarshaller.m572b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("attachment", i)) {
                    instanceNetworkInterface.m426q(InstanceNetworkInterfaceAttachmentStaxUnmarshaller.m580b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("association", i)) {
                    instanceNetworkInterface.m425p(InstanceNetworkInterfaceAssociationStaxUnmarshaller.m578b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("privateIpAddressesSet/item", i)) {
                    instanceNetworkInterface.m420k().add(InstancePrivateIpAddressStaxUnmarshaller.m584b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return instanceNetworkInterface;
            }
        }
    }
}
