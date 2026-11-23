package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.Protocol;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.handlers.CredentialsRequestHandler;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.regions.RegionUtils;
import com.amazonaws.services.ec2.model.CopySnapshotRequest;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import java.net.URI;
import java.net.URISyntaxException;

/* loaded from: classes.dex */
public class GeneratePreSignUrlRequestHandler extends CredentialsRequestHandler {
    @Override // com.amazonaws.handlers.RequestHandler2
    /* renamed from: b */
    public void mo139b(Request<?> request, Response<?> response, Exception exc) {
    }

    @Override // com.amazonaws.handlers.RequestHandler2
    /* renamed from: c */
    public void mo140c(Request<?> request, Response<?> response) {
    }

    @Override // com.amazonaws.handlers.RequestHandler2
    /* renamed from: d */
    public void mo141d(Request<?> request) {
        AmazonWebServiceRequest mo53i = request.mo53i();
        if (mo53i instanceof CopySnapshotRequest) {
            CopySnapshotRequest copySnapshotRequest = (CopySnapshotRequest) mo53i;
            String m298o = copySnapshotRequest.m298o();
            String m299q = copySnapshotRequest.m299q();
            String m295k = copySnapshotRequest.m295k() != null ? copySnapshotRequest.m295k() : RegionUtils.m268b(request.mo61q().getHost()).toString();
            URI m571h = m571h(RegionUtils.m267a(m298o).m257e("ec2"));
            Request<CopySnapshotRequest> m569f = m569f(m299q, m298o, m295k);
            m569f.mo63s(m571h);
            m569f.mo55k(HttpMethodName.GET);
            new AWS4Signer().m89O(m569f, this.f108a, null);
            copySnapshotRequest.m302t(m570g(m569f));
            copySnapshotRequest.m301s(m295k);
            String m295k2 = copySnapshotRequest.m295k();
            StringUtils.m678c(m295k2);
            request.mo56l("DestinationRegion", m295k2);
            String m297m = copySnapshotRequest.m297m();
            StringUtils.m678c(m297m);
            request.mo56l("PresignedUrl", m297m);
        }
    }

    /* renamed from: f */
    public final Request<CopySnapshotRequest> m569f(String str, String str2, String str3) {
        CopySnapshotRequest copySnapshotRequest = new CopySnapshotRequest();
        copySnapshotRequest.m305w(str);
        copySnapshotRequest.m304v(str2);
        copySnapshotRequest.m303u(str3);
        return new CopySnapshotRequestMarshaller().m559a(copySnapshotRequest);
    }

    /* renamed from: g */
    public final String m570g(Request<?> request) {
        String m664b = HttpUtils.m664b(request.mo61q().toString(), request.mo57m(), true);
        String m665c = HttpUtils.m665c(request);
        if (m665c == null) {
            return m664b;
        }
        return m664b + "?" + m665c;
    }

    /* renamed from: h */
    public final URI m571h(String str) throws IllegalArgumentException {
        if (!str.contains("://")) {
            str = Protocol.HTTPS + "://" + str;
        }
        try {
            return new URI(str);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
