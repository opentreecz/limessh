package com.amazonaws.transform;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.DateUtils;
import java.util.Date;

/* loaded from: classes.dex */
public class SimpleTypeStaxUnmarshallers {

    /* renamed from: a */
    public static Log f426a = LogFactory.m237c(SimpleTypeStaxUnmarshallers.class);

    /* loaded from: classes.dex */
    public static class BooleanStaxUnmarshaller implements Unmarshaller<Boolean, StaxUnmarshallerContext> {

        /* renamed from: a */
        public static BooleanStaxUnmarshaller f427a;

        /* renamed from: b */
        public static BooleanStaxUnmarshaller m607b() {
            if (f427a == null) {
                f427a = new BooleanStaxUnmarshaller();
            }
            return f427a;
        }

        @Override // com.amazonaws.transform.Unmarshaller
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String m619e = staxUnmarshallerContext.m619e();
            if (m619e == null) {
                return null;
            }
            return Boolean.valueOf(Boolean.parseBoolean(m619e));
        }
    }

    /* loaded from: classes.dex */
    public static class DateStaxUnmarshaller implements Unmarshaller<Date, StaxUnmarshallerContext> {

        /* renamed from: a */
        public static DateStaxUnmarshaller f428a;

        /* renamed from: b */
        public static DateStaxUnmarshaller m609b() {
            if (f428a == null) {
                f428a = new DateStaxUnmarshaller();
            }
            return f428a;
        }

        @Override // com.amazonaws.transform.Unmarshaller
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Date mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String m619e = staxUnmarshallerContext.m619e();
            if (m619e == null) {
                return null;
            }
            try {
                return DateUtils.m660g(m619e);
            } catch (Exception e) {
                SimpleTypeStaxUnmarshallers.f426a.mo230f("Unable to parse date '" + m619e + "':  " + e.getMessage(), e);
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class IntegerStaxUnmarshaller implements Unmarshaller<Integer, StaxUnmarshallerContext> {

        /* renamed from: a */
        public static IntegerStaxUnmarshaller f429a;

        /* renamed from: b */
        public static IntegerStaxUnmarshaller m611b() {
            if (f429a == null) {
                f429a = new IntegerStaxUnmarshaller();
            }
            return f429a;
        }

        @Override // com.amazonaws.transform.Unmarshaller
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String m619e = staxUnmarshallerContext.m619e();
            if (m619e == null) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(m619e));
        }
    }

    /* loaded from: classes.dex */
    public static class StringStaxUnmarshaller implements Unmarshaller<String, StaxUnmarshallerContext> {

        /* renamed from: a */
        public static StringStaxUnmarshaller f430a;

        /* renamed from: b */
        public static StringStaxUnmarshaller m613b() {
            if (f430a == null) {
                f430a = new StringStaxUnmarshaller();
            }
            return f430a;
        }

        @Override // com.amazonaws.transform.Unmarshaller
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            return staxUnmarshallerContext.m619e();
        }
    }
}
