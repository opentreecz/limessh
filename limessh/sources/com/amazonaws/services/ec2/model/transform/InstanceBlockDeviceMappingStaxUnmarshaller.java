package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.services.ec2.model.InstanceBlockDeviceMapping;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class InstanceBlockDeviceMappingStaxUnmarshaller implements Unmarshaller<InstanceBlockDeviceMapping, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static InstanceBlockDeviceMappingStaxUnmarshaller f411a;

    /* renamed from: b */
    public static InstanceBlockDeviceMappingStaxUnmarshaller m576b() {
        if (f411a == null) {
            f411a = new InstanceBlockDeviceMappingStaxUnmarshaller();
        }
        return f411a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InstanceBlockDeviceMapping mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceBlockDeviceMapping instanceBlockDeviceMapping = new InstanceBlockDeviceMapping();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return instanceBlockDeviceMapping;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("deviceName", i)) {
                    instanceBlockDeviceMapping.m408c(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("ebs", i)) {
                    instanceBlockDeviceMapping.m409d(EbsInstanceBlockDeviceStaxUnmarshaller.m567b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return instanceBlockDeviceMapping;
            }
        }
    }
}
