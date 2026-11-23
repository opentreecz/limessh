package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.services.ec2.model.InstanceState;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class InstanceStateStaxUnmarshaller implements Unmarshaller<InstanceState, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static InstanceStateStaxUnmarshaller f416a;

    /* renamed from: b */
    public static InstanceStateStaxUnmarshaller m586b() {
        if (f416a == null) {
            f416a = new InstanceStateStaxUnmarshaller();
        }
        return f416a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public InstanceState mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceState instanceState = new InstanceState();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return instanceState;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("code", i)) {
                    instanceState.m462c(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.m611b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("name", i)) {
                    instanceState.m463d(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return instanceState;
            }
        }
    }
}
