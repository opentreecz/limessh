package com.amazonaws.services.ec2.model.transform;

import androidx.core.app.NotificationCompat;
import com.amazonaws.services.ec2.model.InstanceNetworkInterfaceAttachment;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class InstanceNetworkInterfaceAttachmentStaxUnmarshaller implements Unmarshaller<InstanceNetworkInterfaceAttachment, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static InstanceNetworkInterfaceAttachmentStaxUnmarshaller f413a;

    /* renamed from: b */
    public static InstanceNetworkInterfaceAttachmentStaxUnmarshaller m580b() {
        if (f413a == null) {
            f413a = new InstanceNetworkInterfaceAttachmentStaxUnmarshaller();
        }
        return f413a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InstanceNetworkInterfaceAttachment mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceNetworkInterfaceAttachment instanceNetworkInterfaceAttachment = new InstanceNetworkInterfaceAttachment();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return instanceNetworkInterfaceAttachment;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("attachmentId", i)) {
                    instanceNetworkInterfaceAttachment.m448h(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("deviceIndex", i)) {
                    instanceNetworkInterfaceAttachment.m450j(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.m611b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g(NotificationCompat.CATEGORY_STATUS, i)) {
                    instanceNetworkInterfaceAttachment.m451k(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("attachTime", i)) {
                    instanceNetworkInterfaceAttachment.m447f(SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller.m609b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("deleteOnTermination", i)) {
                    instanceNetworkInterfaceAttachment.m449i(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.m607b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return instanceNetworkInterfaceAttachment;
            }
        }
    }
}
