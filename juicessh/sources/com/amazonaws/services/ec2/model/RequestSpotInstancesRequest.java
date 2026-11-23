package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.Date;

/* loaded from: classes.dex */
public class RequestSpotInstancesRequest extends AmazonWebServiceRequest implements Serializable, DryRunSupportedRequest<RequestSpotInstancesRequest> {

    /* renamed from: R */
    public String f346R;

    /* renamed from: S */
    public String f347S;

    /* renamed from: T */
    public Integer f348T;

    /* renamed from: U */
    public String f349U;

    /* renamed from: V */
    public Date f350V;

    /* renamed from: W */
    public Date f351W;

    /* renamed from: X */
    public String f352X;

    /* renamed from: Y */
    public String f353Y;

    /* renamed from: Z */
    public Integer f354Z;

    /* renamed from: a0 */
    public LaunchSpecification f355a0;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RequestSpotInstancesRequest)) {
            return false;
        }
        RequestSpotInstancesRequest requestSpotInstancesRequest = (RequestSpotInstancesRequest) obj;
        if ((requestSpotInstancesRequest.m495r() == null) ^ (m495r() == null)) {
            return false;
        }
        if (requestSpotInstancesRequest.m495r() != null && !requestSpotInstancesRequest.m495r().equals(m495r())) {
            return false;
        }
        if ((requestSpotInstancesRequest.m491l() == null) ^ (m491l() == null)) {
            return false;
        }
        if (requestSpotInstancesRequest.m491l() != null && !requestSpotInstancesRequest.m491l().equals(m491l())) {
            return false;
        }
        if ((requestSpotInstancesRequest.m492m() == null) ^ (m492m() == null)) {
            return false;
        }
        if (requestSpotInstancesRequest.m492m() != null && !requestSpotInstancesRequest.m492m().equals(m492m())) {
            return false;
        }
        if ((requestSpotInstancesRequest.m496s() == null) ^ (m496s() == null)) {
            return false;
        }
        if (requestSpotInstancesRequest.m496s() != null && !requestSpotInstancesRequest.m496s().equals(m496s())) {
            return false;
        }
        if ((requestSpotInstancesRequest.m497t() == null) ^ (m497t() == null)) {
            return false;
        }
        if (requestSpotInstancesRequest.m497t() != null && !requestSpotInstancesRequest.m497t().equals(m497t())) {
            return false;
        }
        if ((requestSpotInstancesRequest.m498u() == null) ^ (m498u() == null)) {
            return false;
        }
        if (requestSpotInstancesRequest.m498u() != null && !requestSpotInstancesRequest.m498u().equals(m498u())) {
            return false;
        }
        if ((requestSpotInstancesRequest.m493o() == null) ^ (m493o() == null)) {
            return false;
        }
        if (requestSpotInstancesRequest.m493o() != null && !requestSpotInstancesRequest.m493o().equals(m493o())) {
            return false;
        }
        if ((requestSpotInstancesRequest.m489j() == null) ^ (m489j() == null)) {
            return false;
        }
        if (requestSpotInstancesRequest.m489j() != null && !requestSpotInstancesRequest.m489j().equals(m489j())) {
            return false;
        }
        if ((requestSpotInstancesRequest.m490k() == null) ^ (m490k() == null)) {
            return false;
        }
        if (requestSpotInstancesRequest.m490k() != null && !requestSpotInstancesRequest.m490k().equals(m490k())) {
            return false;
        }
        if ((requestSpotInstancesRequest.m494q() == null) ^ (m494q() == null)) {
            return false;
        }
        if (requestSpotInstancesRequest.m494q() == null) {
            return true;
        }
        requestSpotInstancesRequest.m494q().equals(m494q());
        throw null;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((m495r() == null ? 0 : m495r().hashCode()) + 31) * 31) + (m491l() == null ? 0 : m491l().hashCode())) * 31) + (m492m() == null ? 0 : m492m().hashCode())) * 31) + (m496s() == null ? 0 : m496s().hashCode())) * 31) + (m497t() == null ? 0 : m497t().hashCode())) * 31) + (m498u() == null ? 0 : m498u().hashCode())) * 31) + (m493o() == null ? 0 : m493o().hashCode())) * 31) + (m489j() == null ? 0 : m489j().hashCode())) * 31) + (m490k() == null ? 0 : m490k().hashCode())) * 31;
        if (m494q() == null) {
            return hashCode + 0;
        }
        m494q().hashCode();
        throw null;
    }

    /* renamed from: j */
    public String m489j() {
        return this.f353Y;
    }

    /* renamed from: k */
    public Integer m490k() {
        return this.f354Z;
    }

    /* renamed from: l */
    public String m491l() {
        return this.f347S;
    }

    /* renamed from: m */
    public Integer m492m() {
        return this.f348T;
    }

    /* renamed from: o */
    public String m493o() {
        return this.f352X;
    }

    /* renamed from: q */
    public LaunchSpecification m494q() {
        return this.f355a0;
    }

    /* renamed from: r */
    public String m495r() {
        return this.f346R;
    }

    /* renamed from: s */
    public String m496s() {
        return this.f349U;
    }

    /* renamed from: t */
    public Date m497t() {
        return this.f350V;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m495r() != null) {
            sb.append("SpotPrice: " + m495r() + ",");
        }
        if (m491l() != null) {
            sb.append("ClientToken: " + m491l() + ",");
        }
        if (m492m() != null) {
            sb.append("InstanceCount: " + m492m() + ",");
        }
        if (m496s() != null) {
            sb.append("Type: " + m496s() + ",");
        }
        if (m497t() != null) {
            sb.append("ValidFrom: " + m497t() + ",");
        }
        if (m498u() != null) {
            sb.append("ValidUntil: " + m498u() + ",");
        }
        if (m493o() != null) {
            sb.append("LaunchGroup: " + m493o() + ",");
        }
        if (m489j() != null) {
            sb.append("AvailabilityZoneGroup: " + m489j() + ",");
        }
        if (m490k() != null) {
            sb.append("BlockDurationMinutes: " + m490k() + ",");
        }
        if (m494q() != null) {
            sb.append("LaunchSpecification: " + m494q());
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: u */
    public Date m498u() {
        return this.f351W;
    }
}
