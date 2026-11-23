package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.IOUtils;
import com.amazonaws.util.XpathUtils;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public class DefaultErrorResponseHandler implements HttpResponseHandler<AmazonServiceException> {

    /* renamed from: b */
    public static final Log f116b = LogFactory.m237c(DefaultErrorResponseHandler.class);

    /* renamed from: a */
    public List<Unmarshaller<AmazonServiceException, Node>> f117a;

    public DefaultErrorResponseHandler(List<Unmarshaller<AmazonServiceException, Node>> list) {
        this.f117a = list;
    }

    @Override // com.amazonaws.http.HttpResponseHandler
    /* renamed from: b */
    public boolean mo162b() {
        return false;
    }

    @Override // com.amazonaws.http.HttpResponseHandler
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AmazonServiceException mo161a(HttpResponse httpResponse) throws Exception {
        try {
            String m670h = IOUtils.m670h(httpResponse.m183b());
            try {
                Document m707d = XpathUtils.m707d(m670h);
                Iterator<Unmarshaller<AmazonServiceException, Node>> it = this.f117a.iterator();
                while (it.hasNext()) {
                    AmazonServiceException mo561a = it.next().mo561a(m707d);
                    if (mo561a != null) {
                        mo561a.setStatusCode(httpResponse.m186e());
                        return mo561a;
                    }
                }
                throw new AmazonClientException("Unable to unmarshall error response from service");
            } catch (Exception e) {
                return m164d(String.format("Unable to unmarshall error response (%s)", m670h), httpResponse, e);
            }
        } catch (IOException e2) {
            Log log = f116b;
            if (log.mo227c()) {
                log.mo226b("Failed in reading the error response", e2);
            }
            return m164d("Unable to unmarshall error response", httpResponse, e2);
        }
    }

    /* renamed from: d */
    public final AmazonServiceException m164d(String str, HttpResponse httpResponse, Exception exc) {
        AmazonServiceException amazonServiceException = new AmazonServiceException(str, exc);
        int m186e = httpResponse.m186e();
        amazonServiceException.setErrorCode(m186e + " " + httpResponse.m187f());
        amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Unknown);
        amazonServiceException.setStatusCode(m186e);
        return amazonServiceException;
    }
}
