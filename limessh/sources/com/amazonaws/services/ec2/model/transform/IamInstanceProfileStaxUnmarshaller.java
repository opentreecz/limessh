package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.services.ec2.model.IamInstanceProfile;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class IamInstanceProfileStaxUnmarshaller implements Unmarshaller<IamInstanceProfile, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static IamInstanceProfileStaxUnmarshaller f410a;

    /* renamed from: b */
    public static IamInstanceProfileStaxUnmarshaller m574b() {
        if (f410a == null) {
            f410a = new IamInstanceProfileStaxUnmarshaller();
        }
        return f410a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public IamInstanceProfile mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        IamInstanceProfile iamInstanceProfile = new IamInstanceProfile();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return iamInstanceProfile;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("arn", i)) {
                    iamInstanceProfile.m333c(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("id", i)) {
                    iamInstanceProfile.m334d(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return iamInstanceProfile;
            }
        }
    }
}
