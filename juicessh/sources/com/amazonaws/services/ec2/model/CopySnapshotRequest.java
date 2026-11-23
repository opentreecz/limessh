package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class CopySnapshotRequest extends AmazonWebServiceRequest implements Serializable, DryRunSupportedRequest<CopySnapshotRequest> {

    /* renamed from: R */
    public String f237R;

    /* renamed from: S */
    public String f238S;

    /* renamed from: T */
    public String f239T;

    /* renamed from: U */
    public String f240U;

    /* renamed from: V */
    public String f241V;

    /* renamed from: W */
    public Boolean f242W;

    /* renamed from: X */
    public String f243X;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CopySnapshotRequest)) {
            return false;
        }
        CopySnapshotRequest copySnapshotRequest = (CopySnapshotRequest) obj;
        if ((copySnapshotRequest.m298o() == null) ^ (m298o() == null)) {
            return false;
        }
        if (copySnapshotRequest.m298o() != null && !copySnapshotRequest.m298o().equals(m298o())) {
            return false;
        }
        if ((copySnapshotRequest.m299q() == null) ^ (m299q() == null)) {
            return false;
        }
        if (copySnapshotRequest.m299q() != null && !copySnapshotRequest.m299q().equals(m299q())) {
            return false;
        }
        if ((copySnapshotRequest.m294j() == null) ^ (m294j() == null)) {
            return false;
        }
        if (copySnapshotRequest.m294j() != null && !copySnapshotRequest.m294j().equals(m294j())) {
            return false;
        }
        if ((copySnapshotRequest.m295k() == null) ^ (m295k() == null)) {
            return false;
        }
        if (copySnapshotRequest.m295k() != null && !copySnapshotRequest.m295k().equals(m295k())) {
            return false;
        }
        if ((copySnapshotRequest.m297m() == null) ^ (m297m() == null)) {
            return false;
        }
        if (copySnapshotRequest.m297m() != null && !copySnapshotRequest.m297m().equals(m297m())) {
            return false;
        }
        if ((copySnapshotRequest.m300r() == null) ^ (m300r() == null)) {
            return false;
        }
        if (copySnapshotRequest.m300r() != null && !copySnapshotRequest.m300r().equals(m300r())) {
            return false;
        }
        if ((copySnapshotRequest.m296l() == null) ^ (m296l() == null)) {
            return false;
        }
        return copySnapshotRequest.m296l() == null || copySnapshotRequest.m296l().equals(m296l());
    }

    public int hashCode() {
        return (((((((((((((m298o() == null ? 0 : m298o().hashCode()) + 31) * 31) + (m299q() == null ? 0 : m299q().hashCode())) * 31) + (m294j() == null ? 0 : m294j().hashCode())) * 31) + (m295k() == null ? 0 : m295k().hashCode())) * 31) + (m297m() == null ? 0 : m297m().hashCode())) * 31) + (m300r() == null ? 0 : m300r().hashCode())) * 31) + (m296l() != null ? m296l().hashCode() : 0);
    }

    /* renamed from: j */
    public String m294j() {
        return this.f239T;
    }

    /* renamed from: k */
    public String m295k() {
        return this.f240U;
    }

    /* renamed from: l */
    public String m296l() {
        return this.f243X;
    }

    /* renamed from: m */
    public String m297m() {
        return this.f241V;
    }

    /* renamed from: o */
    public String m298o() {
        return this.f237R;
    }

    /* renamed from: q */
    public String m299q() {
        return this.f238S;
    }

    /* renamed from: r */
    public Boolean m300r() {
        return this.f242W;
    }

    /* renamed from: s */
    public void m301s(String str) {
        this.f240U = str;
    }

    /* renamed from: t */
    public void m302t(String str) {
        this.f241V = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m298o() != null) {
            sb.append("SourceRegion: " + m298o() + ",");
        }
        if (m299q() != null) {
            sb.append("SourceSnapshotId: " + m299q() + ",");
        }
        if (m294j() != null) {
            sb.append("Description: " + m294j() + ",");
        }
        if (m295k() != null) {
            sb.append("DestinationRegion: " + m295k() + ",");
        }
        if (m297m() != null) {
            sb.append("PresignedUrl: " + m297m() + ",");
        }
        if (m300r() != null) {
            sb.append("Encrypted: " + m300r() + ",");
        }
        if (m296l() != null) {
            sb.append("KmsKeyId: " + m296l());
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: u */
    public CopySnapshotRequest m303u(String str) {
        this.f240U = str;
        return this;
    }

    /* renamed from: v */
    public CopySnapshotRequest m304v(String str) {
        this.f237R = str;
        return this;
    }

    /* renamed from: w */
    public CopySnapshotRequest m305w(String str) {
        this.f238S = str;
        return this;
    }
}
