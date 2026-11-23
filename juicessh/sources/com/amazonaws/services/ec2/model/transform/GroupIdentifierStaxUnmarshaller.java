package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.services.ec2.model.GroupIdentifier;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class GroupIdentifierStaxUnmarshaller implements Unmarshaller<GroupIdentifier, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static GroupIdentifierStaxUnmarshaller f409a;

    /* renamed from: b */
    public static GroupIdentifierStaxUnmarshaller m572b() {
        if (f409a == null) {
            f409a = new GroupIdentifierStaxUnmarshaller();
        }
        return f409a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GroupIdentifier mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        GroupIdentifier groupIdentifier = new GroupIdentifier();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return groupIdentifier;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("groupName", i)) {
                    groupIdentifier.m330d(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("groupId", i)) {
                    groupIdentifier.m329c(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return groupIdentifier;
            }
        }
    }
}
