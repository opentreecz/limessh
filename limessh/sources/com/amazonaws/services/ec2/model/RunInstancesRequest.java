package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.internal.ListWithAutoConstructFlag;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class RunInstancesRequest extends AmazonWebServiceRequest implements Serializable, DryRunSupportedRequest<RunInstancesRequest> {

    /* renamed from: R */
    public String f363R;

    /* renamed from: S */
    public Integer f364S;

    /* renamed from: T */
    public Integer f365T;

    /* renamed from: U */
    public String f366U;

    /* renamed from: V */
    public ListWithAutoConstructFlag<String> f367V;

    /* renamed from: W */
    public ListWithAutoConstructFlag<String> f368W;

    /* renamed from: X */
    public String f369X;

    /* renamed from: Y */
    public String f370Y;

    /* renamed from: Z */
    public Placement f371Z;

    /* renamed from: a0 */
    public String f372a0;

    /* renamed from: b0 */
    public String f373b0;

    /* renamed from: c0 */
    public ListWithAutoConstructFlag<Object> f374c0;

    /* renamed from: d0 */
    public Boolean f375d0;

    /* renamed from: e0 */
    public String f376e0;

    /* renamed from: f0 */
    public Boolean f377f0;

    /* renamed from: g0 */
    public String f378g0;

    /* renamed from: h0 */
    public String f379h0;

    /* renamed from: i0 */
    public String f380i0;

    /* renamed from: j0 */
    public String f381j0;

    /* renamed from: k0 */
    public ListWithAutoConstructFlag<Object> f382k0;

    /* renamed from: l0 */
    public IamInstanceProfileSpecification f383l0;

    /* renamed from: m0 */
    public Boolean f384m0;

    /* renamed from: A */
    public String m510A() {
        return this.f373b0;
    }

    /* renamed from: B */
    public List<String> m511B() {
        if (this.f368W == null) {
            ListWithAutoConstructFlag<String> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f368W = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f368W;
    }

    /* renamed from: C */
    public List<String> m512C() {
        if (this.f367V == null) {
            ListWithAutoConstructFlag<String> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f367V = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f367V;
    }

    /* renamed from: D */
    public String m513D() {
        return this.f376e0;
    }

    /* renamed from: E */
    public String m514E() {
        return this.f369X;
    }

    /* renamed from: F */
    public Boolean m515F() {
        return this.f377f0;
    }

    /* renamed from: G */
    public Boolean m516G() {
        return this.f384m0;
    }

    /* renamed from: H */
    public Boolean m517H() {
        return this.f375d0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RunInstancesRequest)) {
            return false;
        }
        RunInstancesRequest runInstancesRequest = (RunInstancesRequest) obj;
        if ((runInstancesRequest.m522o() == null) ^ (m522o() == null)) {
            return false;
        }
        if (runInstancesRequest.m522o() != null && !runInstancesRequest.m522o().equals(m522o())) {
            return false;
        }
        if ((runInstancesRequest.m528v() == null) ^ (m528v() == null)) {
            return false;
        }
        if (runInstancesRequest.m528v() != null && !runInstancesRequest.m528v().equals(m528v())) {
            return false;
        }
        if ((runInstancesRequest.m527u() == null) ^ (m527u() == null)) {
            return false;
        }
        if (runInstancesRequest.m527u() != null && !runInstancesRequest.m527u().equals(m527u())) {
            return false;
        }
        if ((runInstancesRequest.m526t() == null) ^ (m526t() == null)) {
            return false;
        }
        if (runInstancesRequest.m526t() != null && !runInstancesRequest.m526t().equals(m526t())) {
            return false;
        }
        if ((runInstancesRequest.m512C() == null) ^ (m512C() == null)) {
            return false;
        }
        if (runInstancesRequest.m512C() != null && !runInstancesRequest.m512C().equals(m512C())) {
            return false;
        }
        if ((runInstancesRequest.m511B() == null) ^ (m511B() == null)) {
            return false;
        }
        if (runInstancesRequest.m511B() != null && !runInstancesRequest.m511B().equals(m511B())) {
            return false;
        }
        if ((runInstancesRequest.m514E() == null) ^ (m514E() == null)) {
            return false;
        }
        if (runInstancesRequest.m514E() != null && !runInstancesRequest.m514E().equals(m514E())) {
            return false;
        }
        if ((runInstancesRequest.m524r() == null) ^ (m524r() == null)) {
            return false;
        }
        if (runInstancesRequest.m524r() != null && !runInstancesRequest.m524r().equals(m524r())) {
            return false;
        }
        if ((runInstancesRequest.m530y() == null) ^ (m530y() == null)) {
            return false;
        }
        if (runInstancesRequest.m530y() != null && !runInstancesRequest.m530y().equals(m530y())) {
            return false;
        }
        if ((runInstancesRequest.m525s() == null) ^ (m525s() == null)) {
            return false;
        }
        if (runInstancesRequest.m525s() != null && !runInstancesRequest.m525s().equals(m525s())) {
            return false;
        }
        if ((runInstancesRequest.m510A() == null) ^ (m510A() == null)) {
            return false;
        }
        if (runInstancesRequest.m510A() != null && !runInstancesRequest.m510A().equals(m510A())) {
            return false;
        }
        if ((runInstancesRequest.m519k() == null) ^ (m519k() == null)) {
            return false;
        }
        if (runInstancesRequest.m519k() != null && !runInstancesRequest.m519k().equals(m519k())) {
            return false;
        }
        if ((runInstancesRequest.m517H() == null) ^ (m517H() == null)) {
            return false;
        }
        if (runInstancesRequest.m517H() != null && !runInstancesRequest.m517H().equals(m517H())) {
            return false;
        }
        if ((runInstancesRequest.m513D() == null) ^ (m513D() == null)) {
            return false;
        }
        if (runInstancesRequest.m513D() != null && !runInstancesRequest.m513D().equals(m513D())) {
            return false;
        }
        if ((runInstancesRequest.m515F() == null) ^ (m515F() == null)) {
            return false;
        }
        if (runInstancesRequest.m515F() != null && !runInstancesRequest.m515F().equals(m515F())) {
            return false;
        }
        if ((runInstancesRequest.m523q() == null) ^ (m523q() == null)) {
            return false;
        }
        if (runInstancesRequest.m523q() != null && !runInstancesRequest.m523q().equals(m523q())) {
            return false;
        }
        if ((runInstancesRequest.m531z() == null) ^ (m531z() == null)) {
            return false;
        }
        if (runInstancesRequest.m531z() != null && !runInstancesRequest.m531z().equals(m531z())) {
            return false;
        }
        if ((runInstancesRequest.m520l() == null) ^ (m520l() == null)) {
            return false;
        }
        if (runInstancesRequest.m520l() != null && !runInstancesRequest.m520l().equals(m520l())) {
            return false;
        }
        if ((runInstancesRequest.m518j() == null) ^ (m518j() == null)) {
            return false;
        }
        if (runInstancesRequest.m518j() != null && !runInstancesRequest.m518j().equals(m518j())) {
            return false;
        }
        if ((runInstancesRequest.m529w() == null) ^ (m529w() == null)) {
            return false;
        }
        if (runInstancesRequest.m529w() != null && !runInstancesRequest.m529w().equals(m529w())) {
            return false;
        }
        if ((runInstancesRequest.m521m() == null) ^ (m521m() == null)) {
            return false;
        }
        if (runInstancesRequest.m521m() != null) {
            runInstancesRequest.m521m().equals(m521m());
            throw null;
        }
        if ((runInstancesRequest.m516G() == null) ^ (m516G() == null)) {
            return false;
        }
        return runInstancesRequest.m516G() == null || runInstancesRequest.m516G().equals(m516G());
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((((((((((m522o() == null ? 0 : m522o().hashCode()) + 31) * 31) + (m528v() == null ? 0 : m528v().hashCode())) * 31) + (m527u() == null ? 0 : m527u().hashCode())) * 31) + (m526t() == null ? 0 : m526t().hashCode())) * 31) + (m512C() == null ? 0 : m512C().hashCode())) * 31) + (m511B() == null ? 0 : m511B().hashCode())) * 31) + (m514E() == null ? 0 : m514E().hashCode())) * 31) + (m524r() == null ? 0 : m524r().hashCode())) * 31) + (m530y() == null ? 0 : m530y().hashCode())) * 31) + (m525s() == null ? 0 : m525s().hashCode())) * 31) + (m510A() == null ? 0 : m510A().hashCode())) * 31) + (m519k() == null ? 0 : m519k().hashCode())) * 31) + (m517H() == null ? 0 : m517H().hashCode())) * 31) + (m513D() == null ? 0 : m513D().hashCode())) * 31) + (m515F() == null ? 0 : m515F().hashCode())) * 31) + (m523q() == null ? 0 : m523q().hashCode())) * 31) + (m531z() == null ? 0 : m531z().hashCode())) * 31) + (m520l() == null ? 0 : m520l().hashCode())) * 31) + (m518j() == null ? 0 : m518j().hashCode())) * 31) + (m529w() == null ? 0 : m529w().hashCode())) * 31;
        if (m521m() == null) {
            return ((hashCode + 0) * 31) + (m516G() != null ? m516G().hashCode() : 0);
        }
        m521m().hashCode();
        throw null;
    }

    /* renamed from: j */
    public String m518j() {
        return this.f381j0;
    }

    /* renamed from: k */
    public List<Object> m519k() {
        if (this.f374c0 == null) {
            ListWithAutoConstructFlag<Object> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f374c0 = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f374c0;
    }

    /* renamed from: l */
    public String m520l() {
        return this.f380i0;
    }

    /* renamed from: m */
    public IamInstanceProfileSpecification m521m() {
        return this.f383l0;
    }

    /* renamed from: o */
    public String m522o() {
        return this.f363R;
    }

    /* renamed from: q */
    public String m523q() {
        return this.f378g0;
    }

    /* renamed from: r */
    public String m524r() {
        return this.f370Y;
    }

    /* renamed from: s */
    public String m525s() {
        return this.f372a0;
    }

    /* renamed from: t */
    public String m526t() {
        return this.f366U;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m522o() != null) {
            sb.append("ImageId: " + m522o() + ",");
        }
        if (m528v() != null) {
            sb.append("MinCount: " + m528v() + ",");
        }
        if (m527u() != null) {
            sb.append("MaxCount: " + m527u() + ",");
        }
        if (m526t() != null) {
            sb.append("KeyName: " + m526t() + ",");
        }
        if (m512C() != null) {
            sb.append("SecurityGroups: " + m512C() + ",");
        }
        if (m511B() != null) {
            sb.append("SecurityGroupIds: " + m511B() + ",");
        }
        if (m514E() != null) {
            sb.append("UserData: " + m514E() + ",");
        }
        if (m524r() != null) {
            sb.append("InstanceType: " + m524r() + ",");
        }
        if (m530y() != null) {
            sb.append("Placement: " + m530y() + ",");
        }
        if (m525s() != null) {
            sb.append("KernelId: " + m525s() + ",");
        }
        if (m510A() != null) {
            sb.append("RamdiskId: " + m510A() + ",");
        }
        if (m519k() != null) {
            sb.append("BlockDeviceMappings: " + m519k() + ",");
        }
        if (m517H() != null) {
            sb.append("Monitoring: " + m517H() + ",");
        }
        if (m513D() != null) {
            sb.append("SubnetId: " + m513D() + ",");
        }
        if (m515F() != null) {
            sb.append("DisableApiTermination: " + m515F() + ",");
        }
        if (m523q() != null) {
            sb.append("InstanceInitiatedShutdownBehavior: " + m523q() + ",");
        }
        if (m531z() != null) {
            sb.append("PrivateIpAddress: " + m531z() + ",");
        }
        if (m520l() != null) {
            sb.append("ClientToken: " + m520l() + ",");
        }
        if (m518j() != null) {
            sb.append("AdditionalInfo: " + m518j() + ",");
        }
        if (m529w() != null) {
            sb.append("NetworkInterfaces: " + m529w() + ",");
        }
        if (m521m() != null) {
            sb.append("IamInstanceProfile: " + m521m() + ",");
        }
        if (m516G() != null) {
            sb.append("EbsOptimized: " + m516G());
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: u */
    public Integer m527u() {
        return this.f365T;
    }

    /* renamed from: v */
    public Integer m528v() {
        return this.f364S;
    }

    /* renamed from: w */
    public List<Object> m529w() {
        if (this.f382k0 == null) {
            ListWithAutoConstructFlag<Object> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f382k0 = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f382k0;
    }

    /* renamed from: y */
    public Placement m530y() {
        return this.f371Z;
    }

    /* renamed from: z */
    public String m531z() {
        return this.f379h0;
    }
}
