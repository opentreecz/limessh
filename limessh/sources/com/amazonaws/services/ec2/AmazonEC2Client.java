package com.amazonaws.services.ec2;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.DefaultErrorResponseHandler;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.StaxResponseHandler;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.DescribeRegionsRequest;
import com.amazonaws.services.ec2.model.DescribeRegionsResult;
import com.amazonaws.services.ec2.model.transform.DescribeInstancesRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeInstancesResultStaxUnmarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeRegionsRequestMarshaller;
import com.amazonaws.services.ec2.model.transform.DescribeRegionsResultStaxUnmarshaller;
import com.amazonaws.transform.LegacyErrorUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public class AmazonEC2Client extends AmazonWebServiceClient implements AmazonEC2 {

    /* renamed from: j */
    public AWSCredentialsProvider f235j;

    /* renamed from: k */
    public final List<Unmarshaller<AmazonServiceException, Node>> f236k;

    public AmazonEC2Client(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonEC2Client(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this(new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    public AmazonEC2Client(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    public AmazonEC2Client(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(clientConfiguration, httpClient);
        this.f236k = new ArrayList();
        this.f235j = aWSCredentialsProvider;
        m292u();
    }

    @Override // com.amazonaws.services.ec2.AmazonEC2
    /* renamed from: a */
    public DescribeInstancesResult mo287a() throws AmazonServiceException, AmazonClientException {
        return m290s(new DescribeInstancesRequest());
    }

    @Override // com.amazonaws.services.ec2.AmazonEC2
    /* renamed from: b */
    public DescribeRegionsResult mo288b() throws AmazonServiceException, AmazonClientException {
        return m291t(new DescribeRegionsRequest());
    }

    /* renamed from: s */
    public DescribeInstancesResult m290s(DescribeInstancesRequest describeInstancesRequest) {
        Response<?> response;
        Request<DescribeInstancesRequest> m560a;
        ExecutionContext m15g = m15g(describeInstancesRequest);
        AWSRequestMetrics m165a = m15g.m165a();
        m165a.mo630g(AWSRequestMetrics.Field.ClientExecuteTime);
        Request<DescribeInstancesRequest> request = null;
        Response<?> response2 = null;
        try {
            m560a = new DescribeInstancesRequestMarshaller().m560a(describeInstancesRequest);
        } catch (Throwable th) {
            th = th;
            response = null;
        }
        try {
            m560a.mo58n(m165a);
            response2 = m293v(m560a, new DescribeInstancesResultStaxUnmarshaller(), m15g);
            DescribeInstancesResult describeInstancesResult = (DescribeInstancesResult) response2.m65a();
            m16h(m165a, m560a, response2);
            return describeInstancesResult;
        } catch (Throwable th2) {
            th = th2;
            Response<?> response3 = response2;
            request = m560a;
            response = response3;
            m16h(m165a, request, response);
            throw th;
        }
    }

    /* renamed from: t */
    public DescribeRegionsResult m291t(DescribeRegionsRequest describeRegionsRequest) {
        Response<?> response;
        Request<DescribeRegionsRequest> m563a;
        ExecutionContext m15g = m15g(describeRegionsRequest);
        AWSRequestMetrics m165a = m15g.m165a();
        m165a.mo630g(AWSRequestMetrics.Field.ClientExecuteTime);
        Request<DescribeRegionsRequest> request = null;
        Response<?> response2 = null;
        try {
            m563a = new DescribeRegionsRequestMarshaller().m563a(describeRegionsRequest);
        } catch (Throwable th) {
            th = th;
            response = null;
        }
        try {
            m563a.mo58n(m165a);
            response2 = m293v(m563a, new DescribeRegionsResultStaxUnmarshaller(), m15g);
            DescribeRegionsResult describeRegionsResult = (DescribeRegionsResult) response2.m65a();
            m16h(m165a, m563a, response2);
            return describeRegionsResult;
        } catch (Throwable th2) {
            th = th2;
            Response<?> response3 = response2;
            request = m563a;
            response = response3;
            m16h(m165a, request, response);
            throw th;
        }
    }

    /* renamed from: u */
    public final void m292u() {
        this.f236k.add(new LegacyErrorUnmarshaller());
        m11c("ec2.us-east-1.amazonaws.com");
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.f40e.addAll(handlerChainFactory.m135c("/com/amazonaws/services/ec2/request.handlers"));
        this.f40e.addAll(handlerChainFactory.m134b("/com/amazonaws/services/ec2/request.handler2s"));
    }

    /* renamed from: v */
    public final <X, Y extends AmazonWebServiceRequest> Response<X> m293v(Request<Y> request, Unmarshaller<X, StaxUnmarshallerContext> unmarshaller, ExecutionContext executionContext) {
        request.mo63s(this.f36a);
        request.mo51g(this.f41f);
        AmazonWebServiceRequest mo53i = request.mo53i();
        AWSCredentials mo98a = this.f235j.mo98a();
        if (mo53i.m28d() != null) {
            mo98a = mo53i.m28d();
        }
        executionContext.m170f(mo98a);
        return this.f39d.m146d(request, new StaxResponseHandler(unmarshaller), new DefaultErrorResponseHandler(this.f236k), executionContext);
    }
}
