package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.CopySnapshotRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/* loaded from: classes.dex */
public class CopySnapshotRequestMarshaller implements Marshaller<Request<CopySnapshotRequest>, CopySnapshotRequest> {
    /* renamed from: a */
    public Request<CopySnapshotRequest> m559a(CopySnapshotRequest copySnapshotRequest) {
        if (copySnapshotRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(copySnapshotRequest, "AmazonEC2");
        defaultRequest.mo56l("Action", "CopySnapshot");
        defaultRequest.mo56l("Version", "2015-10-01");
        if (copySnapshotRequest.m298o() != null) {
            String m298o = copySnapshotRequest.m298o();
            StringUtils.m678c(m298o);
            defaultRequest.mo56l("SourceRegion", m298o);
        }
        if (copySnapshotRequest.m299q() != null) {
            String m299q = copySnapshotRequest.m299q();
            StringUtils.m678c(m299q);
            defaultRequest.mo56l("SourceSnapshotId", m299q);
        }
        if (copySnapshotRequest.m294j() != null) {
            String m294j = copySnapshotRequest.m294j();
            StringUtils.m678c(m294j);
            defaultRequest.mo56l("Description", m294j);
        }
        if (copySnapshotRequest.m295k() != null) {
            String m295k = copySnapshotRequest.m295k();
            StringUtils.m678c(m295k);
            defaultRequest.mo56l("DestinationRegion", m295k);
        }
        if (copySnapshotRequest.m297m() != null) {
            String m297m = copySnapshotRequest.m297m();
            StringUtils.m678c(m297m);
            defaultRequest.mo56l("PresignedUrl", m297m);
        }
        if (copySnapshotRequest.m300r() != null) {
            defaultRequest.mo56l("Encrypted", StringUtils.m676a(copySnapshotRequest.m300r()));
        }
        if (copySnapshotRequest.m296l() != null) {
            String m296l = copySnapshotRequest.m296l();
            StringUtils.m678c(m296l);
            defaultRequest.mo56l("KmsKeyId", m296l);
        }
        return defaultRequest;
    }
}
