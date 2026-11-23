package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.Request;
import com.amazonaws.handlers.AbstractRequestHandler;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.DescribeSpotInstanceRequestsResult;
import com.amazonaws.services.ec2.model.GroupIdentifier;
import com.amazonaws.services.ec2.model.ImportKeyPairRequest;
import com.amazonaws.services.ec2.model.LaunchSpecification;
import com.amazonaws.services.ec2.model.ModifyReservedInstancesRequest;
import com.amazonaws.services.ec2.model.RequestSpotInstancesRequest;
import com.amazonaws.services.ec2.model.RequestSpotInstancesResult;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.amazonaws.services.ec2.model.SpotInstanceRequest;
import com.amazonaws.util.Base64;
import com.amazonaws.util.TimingInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

/* loaded from: classes.dex */
public class EC2RequestHandler extends AbstractRequestHandler {
    @Override // com.amazonaws.handlers.RequestHandler
    /* renamed from: a */
    public void mo136a(Request<?> request) {
        AmazonWebServiceRequest mo53i = request.mo53i();
        if (mo53i instanceof ImportKeyPairRequest) {
            request.mo56l("PublicKeyMaterial", Base64.m641f(((ImportKeyPairRequest) mo53i).m336k().getBytes()));
            return;
        }
        if (mo53i instanceof RequestSpotInstancesRequest) {
            ((RequestSpotInstancesRequest) mo53i).m494q().m465b();
            throw null;
        }
        if (mo53i instanceof RunInstancesRequest) {
            if (((RunInstancesRequest) mo53i).m520l() == null) {
                request.mo45a().put("ClientToken", UUID.randomUUID().toString());
            }
        } else if ((mo53i instanceof ModifyReservedInstancesRequest) && ((ModifyReservedInstancesRequest) mo53i).m466j() == null) {
            request.mo45a().put("ClientToken", UUID.randomUUID().toString());
        }
    }

    @Override // com.amazonaws.handlers.RequestHandler
    /* renamed from: b */
    public void mo137b(Request<?> request, Object obj, TimingInfo timingInfo) {
        if (obj instanceof DescribeSpotInstanceRequestsResult) {
            Iterator<SpotInstanceRequest> it = ((DescribeSpotInstanceRequestsResult) obj).m316a().iterator();
            if (it.hasNext()) {
                m565d(it.next().m540i());
                throw null;
            }
            return;
        }
        if (obj instanceof RequestSpotInstancesResult) {
            Iterator<SpotInstanceRequest> it2 = ((RequestSpotInstancesResult) obj).m499a().iterator();
            if (it2.hasNext()) {
                m565d(it2.next().m540i());
                throw null;
            }
            return;
        }
        if (obj instanceof DescribeInstancesResult) {
            Iterator<Reservation> it3 = ((DescribeInstancesResult) obj).m311b().iterator();
            while (it3.hasNext()) {
                m566e(it3.next());
            }
        } else if (obj instanceof RunInstancesResult) {
            m566e(((RunInstancesResult) obj).m532a());
        }
    }

    /* renamed from: d */
    public final void m565d(LaunchSpecification launchSpecification) {
        new ArrayList();
        launchSpecification.m464a();
        throw null;
    }

    /* renamed from: e */
    public final void m566e(Reservation reservation) {
        ArrayList arrayList = new ArrayList();
        Iterator<GroupIdentifier> it = reservation.m501b().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m328b());
        }
        reservation.m506h(arrayList);
    }
}
