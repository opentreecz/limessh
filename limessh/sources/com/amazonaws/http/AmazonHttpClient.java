package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.RequestClientOptions;
import com.amazonaws.Response;
import com.amazonaws.handlers.CredentialsRequestHandler;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.internal.CRC32MismatchException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.TimingInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class AmazonHttpClient {

    /* renamed from: e */
    public static final Log f110e = LogFactory.m238d("com.amazonaws.request");

    /* renamed from: f */
    public static final Log f111f = LogFactory.m237c(AmazonHttpClient.class);

    /* renamed from: a */
    public final HttpClient f112a;

    /* renamed from: b */
    public final ClientConfiguration f113b;

    /* renamed from: d */
    public final HttpRequestFactory f115d = new HttpRequestFactory();

    /* renamed from: c */
    public final RequestMetricCollector f114c = null;

    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.f113b = clientConfiguration;
        this.f112a = httpClient;
    }

    /* renamed from: c */
    public static String m142c(String str, String str2) {
        if (str.contains(str2)) {
            return str;
        }
        return str.trim() + " " + str2.trim();
    }

    /* renamed from: l */
    public static boolean m143l(HttpResponse httpResponse) {
        int m186e = httpResponse.m186e();
        String str = httpResponse.m184c().get("Location");
        return (m186e != 307 || str == null || str.isEmpty()) ? false : true;
    }

    /* renamed from: a */
    public void m144a(Request<?> request, Response<?> response, List<RequestHandler2> list, AmazonClientException amazonClientException) {
        Iterator<RequestHandler2> it = list.iterator();
        while (it.hasNext()) {
            it.next().mo139b(request, response, amazonClientException);
        }
    }

    /* renamed from: b */
    public <T> void m145b(Request<?> request, List<RequestHandler2> list, Response<T> response, TimingInfo timingInfo) {
        Iterator<RequestHandler2> it = list.iterator();
        while (it.hasNext()) {
            it.next().mo140c(request, response);
        }
    }

    /* renamed from: d */
    public <T> Response<T> m146d(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponseHandler<AmazonServiceException> httpResponseHandler2, ExecutionContext executionContext) {
        if (executionContext == null) {
            throw new AmazonClientException("Internal SDK Error: No execution context parameter specified.");
        }
        List<RequestHandler2> m156o = m156o(request, executionContext);
        AWSRequestMetrics m165a = executionContext.m165a();
        Response<T> response = null;
        try {
            response = m147e(request, httpResponseHandler, httpResponseHandler2, executionContext);
            m145b(request, m156o, response, m165a.m626c().mo687c());
            return response;
        } catch (AmazonClientException e) {
            m144a(request, response, m156o, e);
            throw e;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:17|(7:251|252|253|254|256|257|(1:261))(1:19)|(10:20|21|(1:23)|24|(5:27|28|29|30|31)|83|(1:85)|86|(4:87|88|89|90)|(6:92|93|(10:185|186|187|188|189|190|191|193|(3:196|197|(1:199))|203)(8:95|96|97|(6:165|166|167|168|169|170)(10:99|100|101|102|103|104|105|106|107|(4:109|(1:111)|112|113)(2:125|127))|(3:116|117|(1:119))|123|124|62)|180|181|(5:50|(3:53|54|(1:56))|60|61|62)(2:63|64)))|41|42|43|44|45|(1:47)|48) */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0433, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0438, code lost:
    
        if (r6 != 0) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x043e, code lost:
    
        if (r6.m185d() != null) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0440, code lost:
    
        r6.m185d().close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0448, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0449, code lost:
    
        com.amazonaws.http.AmazonHttpClient.f111f.mo230f(r9, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x044e, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
    
        throw r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x03ad A[Catch: all -> 0x0433, TRY_ENTER, TryCatch #8 {all -> 0x0433, blocks: (B:44:0x03a3, B:47:0x03ad, B:48:0x03c3, B:50:0x0406, B:64:0x0432, B:234:0x0356, B:235:0x035b), top: B:43:0x03a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0406 A[Catch: all -> 0x0433, TRY_LEAVE, TryCatch #8 {all -> 0x0433, blocks: (B:44:0x03a3, B:47:0x03ad, B:48:0x03c3, B:50:0x0406, B:64:0x0432, B:234:0x0356, B:235:0x035b), top: B:43:0x03a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0432 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v58, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6, types: [long] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> com.amazonaws.Response<T> m147e(com.amazonaws.Request<?> r27, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonWebServiceResponse<T>> r28, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonServiceException> r29, com.amazonaws.http.ExecutionContext r30) {
        /*
            Method dump skipped, instructions count: 1103
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.http.AmazonHttpClient.m147e(com.amazonaws.Request, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.ExecutionContext):com.amazonaws.Response");
    }

    /* renamed from: f */
    public RequestMetricCollector m148f() {
        return this.f114c;
    }

    public void finalize() throws Throwable {
        m160s();
        super.finalize();
    }

    /* renamed from: g */
    public final String m149g(String str) {
        return str.substring(str.indexOf("(") + 1, str.contains(" + 15") ? str.indexOf(" + 15") : str.indexOf(" - 15"));
    }

    /* renamed from: h */
    public AmazonServiceException m150h(Request<?> request, HttpResponseHandler<AmazonServiceException> httpResponseHandler, HttpResponse httpResponse) throws IOException {
        AmazonServiceException amazonServiceException;
        int m186e = httpResponse.m186e();
        try {
            amazonServiceException = httpResponseHandler.mo161a(httpResponse);
            f110e.mo225a("Received error response: " + amazonServiceException.toString());
        } catch (Exception e) {
            if (m186e == 413) {
                amazonServiceException = new AmazonServiceException("Request entity too large");
                amazonServiceException.setServiceName(request.mo50f());
                amazonServiceException.setStatusCode(413);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Client);
                amazonServiceException.setErrorCode("Request entity too large");
            } else {
                if (m186e != 503 || !"Service Unavailable".equalsIgnoreCase(httpResponse.m187f())) {
                    if (e instanceof IOException) {
                        throw ((IOException) e);
                    }
                    throw new AmazonClientException("Unable to unmarshall error response (" + e.getMessage() + "). Response Code: " + m186e + ", Response Text: " + httpResponse.m187f() + ", Response Headers: " + httpResponse.m184c(), e);
                }
                amazonServiceException = new AmazonServiceException("Service unavailable");
                amazonServiceException.setServiceName(request.mo50f());
                amazonServiceException.setStatusCode(503);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Service);
                amazonServiceException.setErrorCode("Service unavailable");
            }
        }
        amazonServiceException.setStatusCode(m186e);
        amazonServiceException.setServiceName(request.mo50f());
        amazonServiceException.fillInStackTrace();
        return amazonServiceException;
    }

    /* renamed from: i */
    public <T> T m151i(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponse httpResponse, ExecutionContext executionContext) throws IOException {
        try {
            AWSRequestMetrics m165a = executionContext.m165a();
            AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ResponseProcessingTime;
            m165a.mo630g(field);
            try {
                AmazonWebServiceResponse<T> mo161a = httpResponseHandler.mo161a(httpResponse);
                m165a.mo625b(field);
                if (mo161a == null) {
                    throw new RuntimeException("Unable to unmarshall response metadata. Response Code: " + httpResponse.m186e() + ", Response Text: " + httpResponse.m187f());
                }
                Log log = f110e;
                if (log.mo227c()) {
                    log.mo225a("Received successful response: " + httpResponse.m186e() + ", AWS Request ID: " + mo161a.m31a());
                }
                m165a.mo624a(AWSRequestMetrics.Field.AWSRequestID, mo161a.m31a());
                return mo161a.m32b();
            } catch (Throwable th) {
                m165a.mo625b(AWSRequestMetrics.Field.ResponseProcessingTime);
                throw th;
            }
        } catch (CRC32MismatchException e) {
            throw e;
        } catch (IOException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new AmazonClientException("Unable to unmarshall response (" + e3.getMessage() + "). Response Code: " + httpResponse.m186e() + ", Response Text: " + httpResponse.m187f(), e3);
        }
    }

    /* renamed from: j */
    public final <T extends Throwable> T m152j(T t, AWSRequestMetrics aWSRequestMetrics) {
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.Exception;
        aWSRequestMetrics.mo627d(field);
        aWSRequestMetrics.mo624a(field, t);
        return t;
    }

    /* renamed from: k */
    public final boolean m153k(HttpResponse httpResponse) {
        int m186e = httpResponse.m186e();
        return m186e >= 200 && m186e < 300;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13, types: [int] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    /* renamed from: m */
    public int m154m(HttpResponse httpResponse, AmazonServiceException amazonServiceException) {
        Date m661h;
        Date date = new Date();
        String str = httpResponse.m184c().get("Date");
        try {
            if (str != 0) {
                try {
                    if (!str.isEmpty()) {
                        m661h = DateUtils.m661h(str);
                        str = (int) ((date.getTime() - m661h.getTime()) / 1000);
                        return str;
                    }
                } catch (RuntimeException e) {
                    e = e;
                    str = 0;
                    f111f.mo230f("Unable to parse clock skew offset from response: " + str, e);
                    return 0;
                }
            }
            m661h = DateUtils.m659f(m149g(amazonServiceException.getMessage()));
            str = (int) ((date.getTime() - m661h.getTime()) / 1000);
            return str;
        } catch (RuntimeException e2) {
            e = e2;
        }
    }

    /* renamed from: n */
    public final long m155n(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i, RetryPolicy retryPolicy) {
        int i2 = (i - 1) - 1;
        long mo279a = retryPolicy.m281a().mo279a(amazonWebServiceRequest, amazonClientException, i2);
        Log log = f111f;
        if (log.mo227c()) {
            log.mo225a("Retriable error detected, will retry in " + mo279a + "ms, attempt number: " + i2);
        }
        try {
            Thread.sleep(mo279a);
            return mo279a;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AmazonClientException(e.getMessage(), e);
        }
    }

    /* renamed from: o */
    public List<RequestHandler2> m156o(Request<?> request, ExecutionContext executionContext) {
        List<RequestHandler2> m168d = executionContext.m168d();
        if (m168d == null) {
            return Collections.emptyList();
        }
        for (RequestHandler2 requestHandler2 : m168d) {
            if (requestHandler2 instanceof CredentialsRequestHandler) {
                ((CredentialsRequestHandler) requestHandler2).m132e(executionContext.m167c());
            }
            requestHandler2.mo141d(request);
        }
        return m168d;
    }

    /* renamed from: p */
    public void m157p(Request<?> request, Exception exc) {
        if (request.getContent() == null) {
            return;
        }
        if (!request.getContent().markSupported()) {
            throw new AmazonClientException("Encountered an exception and stream is not resettable", exc);
        }
        try {
            request.getContent().reset();
        } catch (IOException unused) {
            throw new AmazonClientException("Encountered an exception and couldn't reset the stream to retry", exc);
        }
    }

    /* renamed from: q */
    public void m158q(Request<?> request) {
        RequestClientOptions m27c;
        String m64a;
        String str = ClientConfiguration.f49k;
        AmazonWebServiceRequest mo53i = request.mo53i();
        String m142c = (mo53i == null || (m27c = mo53i.m27c()) == null || (m64a = m27c.m64a(RequestClientOptions.Marker.USER_AGENT)) == null) ? str : m142c(str, m64a);
        if (!str.equals(this.f113b.m42h())) {
            m142c = m142c(m142c, this.f113b.m42h());
        }
        request.mo60p("User-Agent", m142c);
    }

    /* renamed from: r */
    public final boolean m159r(AmazonWebServiceRequest amazonWebServiceRequest, InputStream inputStream, AmazonClientException amazonClientException, int i, RetryPolicy retryPolicy) {
        int i2 = i - 1;
        int m36b = this.f113b.m36b();
        if (m36b < 0 || !retryPolicy.m284d()) {
            m36b = retryPolicy.m282b();
        }
        if (i2 >= m36b) {
            return false;
        }
        if (inputStream == null || inputStream.markSupported()) {
            return retryPolicy.m283c().mo280a(amazonWebServiceRequest, amazonClientException, i2);
        }
        Log log = f111f;
        if (log.mo227c()) {
            log.mo225a("Content not repeatable");
        }
        return false;
    }

    /* renamed from: s */
    public void m160s() {
        this.f112a.shutdown();
    }
}
