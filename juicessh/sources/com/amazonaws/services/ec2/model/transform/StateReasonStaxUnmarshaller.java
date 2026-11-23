package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.services.ec2.model.StateReason;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class StateReasonStaxUnmarshaller implements Unmarshaller<StateReason, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static StateReasonStaxUnmarshaller f423a;

    /* renamed from: b */
    public static StateReasonStaxUnmarshaller m600b() {
        if (f423a == null) {
            f423a = new StateReasonStaxUnmarshaller();
        }
        return f423a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public StateReason mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        StateReason stateReason = new StateReason();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return stateReason;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("code", i)) {
                    stateReason.m553c(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("message", i)) {
                    stateReason.m554d(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return stateReason;
            }
        }
    }
}
