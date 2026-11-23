package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.transform.VoidStaxUnmarshaller;
import com.amazonaws.util.StringUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes.dex */
public class StaxResponseHandler<T> implements HttpResponseHandler<AmazonWebServiceResponse<T>> {

    /* renamed from: b */
    public static final Log f144b = LogFactory.m238d("com.amazonaws.request");

    /* renamed from: c */
    public static final XmlPullParserFactory f145c;

    /* renamed from: a */
    public Unmarshaller<T, StaxUnmarshallerContext> f146a;

    static {
        try {
            f145c = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            throw new AmazonClientException("Couldn't initialize XmlPullParserFactory", e);
        }
    }

    public StaxResponseHandler(Unmarshaller<T, StaxUnmarshallerContext> unmarshaller) {
        this.f146a = unmarshaller;
        if (unmarshaller == null) {
            this.f146a = new VoidStaxUnmarshaller();
        }
    }

    @Override // com.amazonaws.http.HttpResponseHandler
    /* renamed from: b */
    public boolean mo162b() {
        return false;
    }

    @Override // com.amazonaws.http.HttpResponseHandler
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AmazonWebServiceResponse<T> mo161a(HttpResponse httpResponse) throws Exception {
        Log log = f144b;
        log.mo232h("Parsing service response XML");
        InputStream m183b = httpResponse.m183b();
        if (m183b == null) {
            m183b = new ByteArrayInputStream("<eof/>".getBytes(StringUtils.f489a));
        }
        XmlPullParser newPullParser = f145c.newPullParser();
        newPullParser.setInput(m183b, null);
        AmazonWebServiceResponse<T> amazonWebServiceResponse = new AmazonWebServiceResponse<>();
        StaxUnmarshallerContext staxUnmarshallerContext = new StaxUnmarshallerContext(newPullParser, httpResponse.m184c());
        staxUnmarshallerContext.m620f("ResponseMetadata/RequestId", 2, "AWS_REQUEST_ID");
        staxUnmarshallerContext.m620f("requestId", 2, "AWS_REQUEST_ID");
        m194d(staxUnmarshallerContext);
        amazonWebServiceResponse.m34d(this.f146a.mo561a(staxUnmarshallerContext));
        Map<String, String> m616b = staxUnmarshallerContext.m616b();
        Map<String, String> m184c = httpResponse.m184c();
        if (m184c != null && m184c.get("x-amzn-RequestId") != null) {
            m616b.put("AWS_REQUEST_ID", m184c.get("x-amzn-RequestId"));
        }
        amazonWebServiceResponse.m33c(new ResponseMetadata(m616b));
        log.mo232h("Done parsing service response");
        return amazonWebServiceResponse;
    }

    /* renamed from: d */
    public void m194d(StaxUnmarshallerContext staxUnmarshallerContext) {
    }
}
