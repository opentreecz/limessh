package com.amazonaws.services.ec2.model;

import com.amazonaws.internal.ListWithAutoConstructFlag;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class SpotInstanceRequest implements Serializable {

    /* renamed from: O */
    public String f386O;

    /* renamed from: P */
    public String f387P;

    /* renamed from: Q */
    public String f388Q;

    /* renamed from: R */
    public String f389R;

    /* renamed from: S */
    public SpotInstanceStateFault f390S;

    /* renamed from: T */
    public SpotInstanceStatus f391T;

    /* renamed from: U */
    public Date f392U;

    /* renamed from: V */
    public Date f393V;

    /* renamed from: W */
    public String f394W;

    /* renamed from: X */
    public String f395X;

    /* renamed from: Y */
    public LaunchSpecification f396Y;

    /* renamed from: Z */
    public String f397Z;

    /* renamed from: a0 */
    public Date f398a0;

    /* renamed from: b0 */
    public String f399b0;

    /* renamed from: c0 */
    public Integer f400c0;

    /* renamed from: d0 */
    public String f401d0;

    /* renamed from: e0 */
    public ListWithAutoConstructFlag<Tag> f402e0;

    /* renamed from: f0 */
    public String f403f0;

    /* renamed from: a */
    public String m533a() {
        return this.f401d0;
    }

    /* renamed from: b */
    public String m534b() {
        return this.f395X;
    }

    /* renamed from: c */
    public Integer m535c() {
        return this.f400c0;
    }

    /* renamed from: d */
    public Date m536d() {
        return this.f398a0;
    }

    /* renamed from: e */
    public SpotInstanceStateFault m537e() {
        return this.f390S;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SpotInstanceRequest)) {
            return false;
        }
        SpotInstanceRequest spotInstanceRequest = (SpotInstanceRequest) obj;
        if ((spotInstanceRequest.m543l() == null) ^ (m543l() == null)) {
            return false;
        }
        if (spotInstanceRequest.m543l() != null && !spotInstanceRequest.m543l().equals(m543l())) {
            return false;
        }
        if ((spotInstanceRequest.m544m() == null) ^ (m544m() == null)) {
            return false;
        }
        if (spotInstanceRequest.m544m() != null && !spotInstanceRequest.m544m().equals(m544m())) {
            return false;
        }
        if ((spotInstanceRequest.m548q() == null) ^ (m548q() == null)) {
            return false;
        }
        if (spotInstanceRequest.m548q() != null && !spotInstanceRequest.m548q().equals(m548q())) {
            return false;
        }
        if ((spotInstanceRequest.m545n() == null) ^ (m545n() == null)) {
            return false;
        }
        if (spotInstanceRequest.m545n() != null && !spotInstanceRequest.m545n().equals(m545n())) {
            return false;
        }
        if ((spotInstanceRequest.m537e() == null) ^ (m537e() == null)) {
            return false;
        }
        if (spotInstanceRequest.m537e() != null) {
            spotInstanceRequest.m537e().equals(m537e());
            throw null;
        }
        if ((spotInstanceRequest.m546o() == null) ^ (m546o() == null)) {
            return false;
        }
        if (spotInstanceRequest.m546o() != null) {
            spotInstanceRequest.m546o().equals(m546o());
            throw null;
        }
        if ((spotInstanceRequest.m549r() == null) ^ (m549r() == null)) {
            return false;
        }
        if (spotInstanceRequest.m549r() != null && !spotInstanceRequest.m549r().equals(m549r())) {
            return false;
        }
        if ((spotInstanceRequest.m550s() == null) ^ (m550s() == null)) {
            return false;
        }
        if (spotInstanceRequest.m550s() != null && !spotInstanceRequest.m550s().equals(m550s())) {
            return false;
        }
        if ((spotInstanceRequest.m539h() == null) ^ (m539h() == null)) {
            return false;
        }
        if (spotInstanceRequest.m539h() != null && !spotInstanceRequest.m539h().equals(m539h())) {
            return false;
        }
        if ((spotInstanceRequest.m534b() == null) ^ (m534b() == null)) {
            return false;
        }
        if (spotInstanceRequest.m534b() != null && !spotInstanceRequest.m534b().equals(m534b())) {
            return false;
        }
        if ((spotInstanceRequest.m540i() == null) ^ (m540i() == null)) {
            return false;
        }
        if (spotInstanceRequest.m540i() != null) {
            spotInstanceRequest.m540i().equals(m540i());
            throw null;
        }
        if ((spotInstanceRequest.m538f() == null) ^ (m538f() == null)) {
            return false;
        }
        if (spotInstanceRequest.m538f() != null && !spotInstanceRequest.m538f().equals(m538f())) {
            return false;
        }
        if ((spotInstanceRequest.m536d() == null) ^ (m536d() == null)) {
            return false;
        }
        if (spotInstanceRequest.m536d() != null && !spotInstanceRequest.m536d().equals(m536d())) {
            return false;
        }
        if ((spotInstanceRequest.m542k() == null) ^ (m542k() == null)) {
            return false;
        }
        if (spotInstanceRequest.m542k() != null && !spotInstanceRequest.m542k().equals(m542k())) {
            return false;
        }
        if ((spotInstanceRequest.m535c() == null) ^ (m535c() == null)) {
            return false;
        }
        if (spotInstanceRequest.m535c() != null && !spotInstanceRequest.m535c().equals(m535c())) {
            return false;
        }
        if ((spotInstanceRequest.m533a() == null) ^ (m533a() == null)) {
            return false;
        }
        if (spotInstanceRequest.m533a() != null && !spotInstanceRequest.m533a().equals(m533a())) {
            return false;
        }
        if ((spotInstanceRequest.m547p() == null) ^ (m547p() == null)) {
            return false;
        }
        if (spotInstanceRequest.m547p() != null && !spotInstanceRequest.m547p().equals(m547p())) {
            return false;
        }
        if ((spotInstanceRequest.m541j() == null) ^ (m541j() == null)) {
            return false;
        }
        return spotInstanceRequest.m541j() == null || spotInstanceRequest.m541j().equals(m541j());
    }

    /* renamed from: f */
    public String m538f() {
        return this.f397Z;
    }

    /* renamed from: h */
    public String m539h() {
        return this.f394W;
    }

    public int hashCode() {
        int hashCode = ((((((((m543l() == null ? 0 : m543l().hashCode()) + 31) * 31) + (m544m() == null ? 0 : m544m().hashCode())) * 31) + (m548q() == null ? 0 : m548q().hashCode())) * 31) + (m545n() == null ? 0 : m545n().hashCode())) * 31;
        if (m537e() != null) {
            m537e().hashCode();
            throw null;
        }
        int i = (hashCode + 0) * 31;
        if (m546o() != null) {
            m546o().hashCode();
            throw null;
        }
        int hashCode2 = (((((((((i + 0) * 31) + (m549r() == null ? 0 : m549r().hashCode())) * 31) + (m550s() == null ? 0 : m550s().hashCode())) * 31) + (m539h() == null ? 0 : m539h().hashCode())) * 31) + (m534b() == null ? 0 : m534b().hashCode())) * 31;
        if (m540i() == null) {
            return ((((((((((((((hashCode2 + 0) * 31) + (m538f() == null ? 0 : m538f().hashCode())) * 31) + (m536d() == null ? 0 : m536d().hashCode())) * 31) + (m542k() == null ? 0 : m542k().hashCode())) * 31) + (m535c() == null ? 0 : m535c().hashCode())) * 31) + (m533a() == null ? 0 : m533a().hashCode())) * 31) + (m547p() == null ? 0 : m547p().hashCode())) * 31) + (m541j() != null ? m541j().hashCode() : 0);
        }
        m540i().hashCode();
        throw null;
    }

    /* renamed from: i */
    public LaunchSpecification m540i() {
        return this.f396Y;
    }

    /* renamed from: j */
    public String m541j() {
        return this.f403f0;
    }

    /* renamed from: k */
    public String m542k() {
        return this.f399b0;
    }

    /* renamed from: l */
    public String m543l() {
        return this.f386O;
    }

    /* renamed from: m */
    public String m544m() {
        return this.f387P;
    }

    /* renamed from: n */
    public String m545n() {
        return this.f389R;
    }

    /* renamed from: o */
    public SpotInstanceStatus m546o() {
        return this.f391T;
    }

    /* renamed from: p */
    public List<Tag> m547p() {
        if (this.f402e0 == null) {
            ListWithAutoConstructFlag<Tag> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f402e0 = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f402e0;
    }

    /* renamed from: q */
    public String m548q() {
        return this.f388Q;
    }

    /* renamed from: r */
    public Date m549r() {
        return this.f392U;
    }

    /* renamed from: s */
    public Date m550s() {
        return this.f393V;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m543l() != null) {
            sb.append("SpotInstanceRequestId: " + m543l() + ",");
        }
        if (m544m() != null) {
            sb.append("SpotPrice: " + m544m() + ",");
        }
        if (m548q() != null) {
            sb.append("Type: " + m548q() + ",");
        }
        if (m545n() != null) {
            sb.append("State: " + m545n() + ",");
        }
        if (m537e() != null) {
            sb.append("Fault: " + m537e() + ",");
        }
        if (m546o() != null) {
            sb.append("Status: " + m546o() + ",");
        }
        if (m549r() != null) {
            sb.append("ValidFrom: " + m549r() + ",");
        }
        if (m550s() != null) {
            sb.append("ValidUntil: " + m550s() + ",");
        }
        if (m539h() != null) {
            sb.append("LaunchGroup: " + m539h() + ",");
        }
        if (m534b() != null) {
            sb.append("AvailabilityZoneGroup: " + m534b() + ",");
        }
        if (m540i() != null) {
            sb.append("LaunchSpecification: " + m540i() + ",");
        }
        if (m538f() != null) {
            sb.append("InstanceId: " + m538f() + ",");
        }
        if (m536d() != null) {
            sb.append("CreateTime: " + m536d() + ",");
        }
        if (m542k() != null) {
            sb.append("ProductDescription: " + m542k() + ",");
        }
        if (m535c() != null) {
            sb.append("BlockDurationMinutes: " + m535c() + ",");
        }
        if (m533a() != null) {
            sb.append("ActualBlockHourlyPrice: " + m533a() + ",");
        }
        if (m547p() != null) {
            sb.append("Tags: " + m547p() + ",");
        }
        if (m541j() != null) {
            sb.append("LaunchedAvailabilityZone: " + m541j());
        }
        sb.append("}");
        return sb.toString();
    }
}
