package com.amazonaws.services.ec2.model.transform;

import androidx.core.app.NotificationCompat;
import com.amazonaws.services.ec2.model.ProductCode;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class ProductCodeStaxUnmarshaller implements Unmarshaller<ProductCode, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static ProductCodeStaxUnmarshaller f420a;

    /* renamed from: b */
    public static ProductCodeStaxUnmarshaller m594b() {
        if (f420a == null) {
            f420a = new ProductCodeStaxUnmarshaller();
        }
        return f420a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ProductCode mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ProductCode productCode = new ProductCode();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return productCode;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("productCode", i)) {
                    productCode.m483c(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, i)) {
                    productCode.m484d(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return productCode;
            }
        }
    }
}
