package com.amazonaws.services.ec2.model.transform;

import androidx.core.app.NotificationCompat;
import com.amazonaws.services.ec2.model.EbsInstanceBlockDevice;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class EbsInstanceBlockDeviceStaxUnmarshaller implements Unmarshaller<EbsInstanceBlockDevice, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static EbsInstanceBlockDeviceStaxUnmarshaller f408a;

    /* renamed from: b */
    public static EbsInstanceBlockDeviceStaxUnmarshaller m567b() {
        if (f408a == null) {
            f408a = new EbsInstanceBlockDeviceStaxUnmarshaller();
        }
        return f408a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public EbsInstanceBlockDevice mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        EbsInstanceBlockDevice ebsInstanceBlockDevice = new EbsInstanceBlockDevice();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return ebsInstanceBlockDevice;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("volumeId", i)) {
                    ebsInstanceBlockDevice.m324i(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g(NotificationCompat.CATEGORY_STATUS, i)) {
                    ebsInstanceBlockDevice.m323h(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("attachTime", i)) {
                    ebsInstanceBlockDevice.m321e(SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller.m609b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("deleteOnTermination", i)) {
                    ebsInstanceBlockDevice.m322f(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.m607b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return ebsInstanceBlockDevice;
            }
        }
    }
}
