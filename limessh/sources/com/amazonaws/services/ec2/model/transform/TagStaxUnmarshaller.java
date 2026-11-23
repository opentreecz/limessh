package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.services.ec2.model.Tag;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class TagStaxUnmarshaller implements Unmarshaller<Tag, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static TagStaxUnmarshaller f424a;

    /* renamed from: b */
    public static TagStaxUnmarshaller m602b() {
        if (f424a == null) {
            f424a = new TagStaxUnmarshaller();
        }
        return f424a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Tag mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Tag tag = new Tag();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return tag;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("key", i)) {
                    tag.m557c(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("value", i)) {
                    tag.m558d(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return tag;
            }
        }
    }
}
