package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.services.ec2.model.Monitoring;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class MonitoringStaxUnmarshaller implements Unmarshaller<Monitoring, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static MonitoringStaxUnmarshaller f418a;

    /* renamed from: b */
    public static MonitoringStaxUnmarshaller m590b() {
        if (f418a == null) {
            f418a = new MonitoringStaxUnmarshaller();
        }
        return f418a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Monitoring mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Monitoring monitoring = new Monitoring();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return monitoring;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("state", i)) {
                    monitoring.m470b(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return monitoring;
            }
        }
    }
}
