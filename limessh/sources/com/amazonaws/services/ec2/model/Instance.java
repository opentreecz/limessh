package com.amazonaws.services.ec2.model;

import com.amazonaws.internal.ListWithAutoConstructFlag;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class Instance implements Serializable {

    /* renamed from: O */
    public String f266O;

    /* renamed from: P */
    public String f267P;

    /* renamed from: Q */
    public InstanceState f268Q;

    /* renamed from: R */
    public String f269R;

    /* renamed from: S */
    public String f270S;

    /* renamed from: T */
    public String f271T;

    /* renamed from: U */
    public String f272U;

    /* renamed from: V */
    public Integer f273V;

    /* renamed from: W */
    public ListWithAutoConstructFlag<ProductCode> f274W;

    /* renamed from: X */
    public String f275X;

    /* renamed from: Y */
    public Date f276Y;

    /* renamed from: Z */
    public Placement f277Z;

    /* renamed from: a0 */
    public String f278a0;

    /* renamed from: b0 */
    public String f279b0;

    /* renamed from: c0 */
    public String f280c0;

    /* renamed from: d0 */
    public Monitoring f281d0;

    /* renamed from: e0 */
    public String f282e0;

    /* renamed from: f0 */
    public String f283f0;

    /* renamed from: g0 */
    public String f284g0;

    /* renamed from: h0 */
    public String f285h0;

    /* renamed from: i0 */
    public StateReason f286i0;

    /* renamed from: j0 */
    public String f287j0;

    /* renamed from: k0 */
    public String f288k0;

    /* renamed from: l0 */
    public String f289l0;

    /* renamed from: m0 */
    public ListWithAutoConstructFlag<InstanceBlockDeviceMapping> f290m0;

    /* renamed from: n0 */
    public String f291n0;

    /* renamed from: o0 */
    public String f292o0;

    /* renamed from: p0 */
    public String f293p0;

    /* renamed from: q0 */
    public String f294q0;

    /* renamed from: r0 */
    public ListWithAutoConstructFlag<Tag> f295r0;

    /* renamed from: s0 */
    public ListWithAutoConstructFlag<GroupIdentifier> f296s0;

    /* renamed from: t0 */
    public Boolean f297t0;

    /* renamed from: u0 */
    public String f298u0;

    /* renamed from: v0 */
    public ListWithAutoConstructFlag<InstanceNetworkInterface> f299v0;

    /* renamed from: w0 */
    public IamInstanceProfile f300w0;

    /* renamed from: x0 */
    public Boolean f301x0;

    /* renamed from: y0 */
    public String f302y0;

    /* renamed from: A */
    public List<GroupIdentifier> m337A() {
        if (this.f296s0 == null) {
            ListWithAutoConstructFlag<GroupIdentifier> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f296s0 = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f296s0;
    }

    /* renamed from: B */
    public String m338B() {
        return this.f293p0;
    }

    /* renamed from: C */
    public String m339C() {
        return this.f302y0;
    }

    /* renamed from: D */
    public InstanceState m340D() {
        return this.f268Q;
    }

    /* renamed from: E */
    public StateReason m341E() {
        return this.f286i0;
    }

    /* renamed from: F */
    public String m342F() {
        return this.f271T;
    }

    /* renamed from: G */
    public String m343G() {
        return this.f282e0;
    }

    /* renamed from: H */
    public List<Tag> m344H() {
        if (this.f295r0 == null) {
            ListWithAutoConstructFlag<Tag> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f295r0 = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f295r0;
    }

    /* renamed from: I */
    public String m345I() {
        return this.f291n0;
    }

    /* renamed from: J */
    public String m346J() {
        return this.f283f0;
    }

    /* renamed from: K */
    public Boolean m347K() {
        return this.f301x0;
    }

    /* renamed from: L */
    public Boolean m348L() {
        return this.f297t0;
    }

    /* renamed from: M */
    public void m349M(Integer num) {
        this.f273V = num;
    }

    /* renamed from: N */
    public void m350N(String str) {
        this.f287j0 = str;
    }

    /* renamed from: O */
    public void m351O(String str) {
        this.f294q0 = str;
    }

    /* renamed from: P */
    public void m352P(Boolean bool) {
        this.f301x0 = bool;
    }

    /* renamed from: Q */
    public void m353Q(String str) {
        this.f298u0 = str;
    }

    /* renamed from: R */
    public void m354R(IamInstanceProfile iamInstanceProfile) {
        this.f300w0 = iamInstanceProfile;
    }

    /* renamed from: S */
    public void m355S(String str) {
        this.f267P = str;
    }

    /* renamed from: T */
    public void m356T(String str) {
        this.f266O = str;
    }

    /* renamed from: U */
    public void m357U(String str) {
        this.f292o0 = str;
    }

    /* renamed from: V */
    public void m358V(String str) {
        this.f275X = str;
    }

    /* renamed from: W */
    public void m359W(String str) {
        this.f278a0 = str;
    }

    /* renamed from: X */
    public void m360X(String str) {
        this.f272U = str;
    }

    /* renamed from: Y */
    public void m361Y(Date date) {
        this.f276Y = date;
    }

    /* renamed from: Z */
    public void m362Z(Monitoring monitoring) {
        this.f281d0 = monitoring;
    }

    /* renamed from: a */
    public Integer m363a() {
        return this.f273V;
    }

    /* renamed from: a0 */
    public void m364a0(Placement placement) {
        this.f277Z = placement;
    }

    /* renamed from: b */
    public String m365b() {
        return this.f287j0;
    }

    /* renamed from: b0 */
    public void m366b0(String str) {
        this.f280c0 = str;
    }

    /* renamed from: c */
    public List<InstanceBlockDeviceMapping> m367c() {
        if (this.f290m0 == null) {
            ListWithAutoConstructFlag<InstanceBlockDeviceMapping> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f290m0 = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f290m0;
    }

    /* renamed from: c0 */
    public void m368c0(String str) {
        this.f269R = str;
    }

    /* renamed from: d */
    public String m369d() {
        return this.f294q0;
    }

    /* renamed from: d0 */
    public void m370d0(String str) {
        this.f284g0 = str;
    }

    /* renamed from: e */
    public String m371e() {
        return this.f298u0;
    }

    /* renamed from: e0 */
    public void m372e0(String str) {
        this.f270S = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Instance)) {
            return false;
        }
        Instance instance = (Instance) obj;
        if ((instance.m378i() == null) ^ (m378i() == null)) {
            return false;
        }
        if (instance.m378i() != null && !instance.m378i().equals(m378i())) {
            return false;
        }
        if ((instance.m376h() == null) ^ (m376h() == null)) {
            return false;
        }
        if (instance.m376h() != null && !instance.m376h().equals(m376h())) {
            return false;
        }
        if ((instance.m340D() == null) ^ (m340D() == null)) {
            return false;
        }
        if (instance.m340D() != null && !instance.m340D().equals(m340D())) {
            return false;
        }
        if ((instance.m398s() == null) ^ (m398s() == null)) {
            return false;
        }
        if (instance.m398s() != null && !instance.m398s().equals(m398s())) {
            return false;
        }
        if ((instance.m401v() == null) ^ (m401v() == null)) {
            return false;
        }
        if (instance.m401v() != null && !instance.m401v().equals(m401v())) {
            return false;
        }
        if ((instance.m342F() == null) ^ (m342F() == null)) {
            return false;
        }
        if (instance.m342F() != null && !instance.m342F().equals(m342F())) {
            return false;
        }
        if ((instance.m386m() == null) ^ (m386m() == null)) {
            return false;
        }
        if (instance.m386m() != null && !instance.m386m().equals(m386m())) {
            return false;
        }
        if ((instance.m363a() == null) ^ (m363a() == null)) {
            return false;
        }
        if (instance.m363a() != null && !instance.m363a().equals(m363a())) {
            return false;
        }
        if ((instance.m400u() == null) ^ (m400u() == null)) {
            return false;
        }
        if (instance.m400u() != null && !instance.m400u().equals(m400u())) {
            return false;
        }
        if ((instance.m382k() == null) ^ (m382k() == null)) {
            return false;
        }
        if (instance.m382k() != null && !instance.m382k().equals(m382k())) {
            return false;
        }
        if ((instance.m388n() == null) ^ (m388n() == null)) {
            return false;
        }
        if (instance.m388n() != null && !instance.m388n().equals(m388n())) {
            return false;
        }
        if ((instance.m394q() == null) ^ (m394q() == null)) {
            return false;
        }
        if (instance.m394q() != null && !instance.m394q().equals(m394q())) {
            return false;
        }
        if ((instance.m384l() == null) ^ (m384l() == null)) {
            return false;
        }
        if (instance.m384l() != null && !instance.m384l().equals(m384l())) {
            return false;
        }
        if ((instance.m403x() == null) ^ (m403x() == null)) {
            return false;
        }
        if (instance.m403x() != null && !instance.m403x().equals(m403x())) {
            return false;
        }
        if ((instance.m396r() == null) ^ (m396r() == null)) {
            return false;
        }
        if (instance.m396r() != null && !instance.m396r().equals(m396r())) {
            return false;
        }
        if ((instance.m390o() == null) ^ (m390o() == null)) {
            return false;
        }
        if (instance.m390o() != null && !instance.m390o().equals(m390o())) {
            return false;
        }
        if ((instance.m343G() == null) ^ (m343G() == null)) {
            return false;
        }
        if (instance.m343G() != null && !instance.m343G().equals(m343G())) {
            return false;
        }
        if ((instance.m346J() == null) ^ (m346J() == null)) {
            return false;
        }
        if (instance.m346J() != null && !instance.m346J().equals(m346J())) {
            return false;
        }
        if ((instance.m399t() == null) ^ (m399t() == null)) {
            return false;
        }
        if (instance.m399t() != null && !instance.m399t().equals(m399t())) {
            return false;
        }
        if ((instance.m402w() == null) ^ (m402w() == null)) {
            return false;
        }
        if (instance.m402w() != null && !instance.m402w().equals(m402w())) {
            return false;
        }
        if ((instance.m341E() == null) ^ (m341E() == null)) {
            return false;
        }
        if (instance.m341E() != null && !instance.m341E().equals(m341E())) {
            return false;
        }
        if ((instance.m365b() == null) ^ (m365b() == null)) {
            return false;
        }
        if (instance.m365b() != null && !instance.m365b().equals(m365b())) {
            return false;
        }
        if ((instance.m405z() == null) ^ (m405z() == null)) {
            return false;
        }
        if (instance.m405z() != null && !instance.m405z().equals(m405z())) {
            return false;
        }
        if ((instance.m404y() == null) ^ (m404y() == null)) {
            return false;
        }
        if (instance.m404y() != null && !instance.m404y().equals(m404y())) {
            return false;
        }
        if ((instance.m367c() == null) ^ (m367c() == null)) {
            return false;
        }
        if (instance.m367c() != null && !instance.m367c().equals(m367c())) {
            return false;
        }
        if ((instance.m345I() == null) ^ (m345I() == null)) {
            return false;
        }
        if (instance.m345I() != null && !instance.m345I().equals(m345I())) {
            return false;
        }
        if ((instance.m380j() == null) ^ (m380j() == null)) {
            return false;
        }
        if (instance.m380j() != null && !instance.m380j().equals(m380j())) {
            return false;
        }
        if ((instance.m338B() == null) ^ (m338B() == null)) {
            return false;
        }
        if (instance.m338B() != null && !instance.m338B().equals(m338B())) {
            return false;
        }
        if ((instance.m369d() == null) ^ (m369d() == null)) {
            return false;
        }
        if (instance.m369d() != null && !instance.m369d().equals(m369d())) {
            return false;
        }
        if ((instance.m344H() == null) ^ (m344H() == null)) {
            return false;
        }
        if (instance.m344H() != null && !instance.m344H().equals(m344H())) {
            return false;
        }
        if ((instance.m337A() == null) ^ (m337A() == null)) {
            return false;
        }
        if (instance.m337A() != null && !instance.m337A().equals(m337A())) {
            return false;
        }
        if ((instance.m348L() == null) ^ (m348L() == null)) {
            return false;
        }
        if (instance.m348L() != null && !instance.m348L().equals(m348L())) {
            return false;
        }
        if ((instance.m371e() == null) ^ (m371e() == null)) {
            return false;
        }
        if (instance.m371e() != null && !instance.m371e().equals(m371e())) {
            return false;
        }
        if ((instance.m392p() == null) ^ (m392p() == null)) {
            return false;
        }
        if (instance.m392p() != null && !instance.m392p().equals(m392p())) {
            return false;
        }
        if ((instance.m373f() == null) ^ (m373f() == null)) {
            return false;
        }
        if (instance.m373f() != null && !instance.m373f().equals(m373f())) {
            return false;
        }
        if ((instance.m347K() == null) ^ (m347K() == null)) {
            return false;
        }
        if (instance.m347K() != null && !instance.m347K().equals(m347K())) {
            return false;
        }
        if ((instance.m339C() == null) ^ (m339C() == null)) {
            return false;
        }
        return instance.m339C() == null || instance.m339C().equals(m339C());
    }

    /* renamed from: f */
    public IamInstanceProfile m373f() {
        return this.f300w0;
    }

    /* renamed from: f0 */
    public void m374f0(String str) {
        this.f285h0 = str;
    }

    /* renamed from: g0 */
    public void m375g0(String str) {
        this.f279b0 = str;
    }

    /* renamed from: h */
    public String m376h() {
        return this.f267P;
    }

    /* renamed from: h0 */
    public void m377h0(String str) {
        this.f289l0 = str;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((m378i() == null ? 0 : m378i().hashCode()) + 31) * 31) + (m376h() == null ? 0 : m376h().hashCode())) * 31) + (m340D() == null ? 0 : m340D().hashCode())) * 31) + (m398s() == null ? 0 : m398s().hashCode())) * 31) + (m401v() == null ? 0 : m401v().hashCode())) * 31) + (m342F() == null ? 0 : m342F().hashCode())) * 31) + (m386m() == null ? 0 : m386m().hashCode())) * 31) + (m363a() == null ? 0 : m363a().hashCode())) * 31) + (m400u() == null ? 0 : m400u().hashCode())) * 31) + (m382k() == null ? 0 : m382k().hashCode())) * 31) + (m388n() == null ? 0 : m388n().hashCode())) * 31) + (m394q() == null ? 0 : m394q().hashCode())) * 31) + (m384l() == null ? 0 : m384l().hashCode())) * 31) + (m403x() == null ? 0 : m403x().hashCode())) * 31) + (m396r() == null ? 0 : m396r().hashCode())) * 31) + (m390o() == null ? 0 : m390o().hashCode())) * 31) + (m343G() == null ? 0 : m343G().hashCode())) * 31) + (m346J() == null ? 0 : m346J().hashCode())) * 31) + (m399t() == null ? 0 : m399t().hashCode())) * 31) + (m402w() == null ? 0 : m402w().hashCode())) * 31) + (m341E() == null ? 0 : m341E().hashCode())) * 31) + (m365b() == null ? 0 : m365b().hashCode())) * 31) + (m405z() == null ? 0 : m405z().hashCode())) * 31) + (m404y() == null ? 0 : m404y().hashCode())) * 31) + (m367c() == null ? 0 : m367c().hashCode())) * 31) + (m345I() == null ? 0 : m345I().hashCode())) * 31) + (m380j() == null ? 0 : m380j().hashCode())) * 31) + (m338B() == null ? 0 : m338B().hashCode())) * 31) + (m369d() == null ? 0 : m369d().hashCode())) * 31) + (m344H() == null ? 0 : m344H().hashCode())) * 31) + (m337A() == null ? 0 : m337A().hashCode())) * 31) + (m348L() == null ? 0 : m348L().hashCode())) * 31) + (m371e() == null ? 0 : m371e().hashCode())) * 31) + (m392p() == null ? 0 : m392p().hashCode())) * 31) + (m373f() == null ? 0 : m373f().hashCode())) * 31) + (m347K() == null ? 0 : m347K().hashCode())) * 31) + (m339C() != null ? m339C().hashCode() : 0);
    }

    /* renamed from: i */
    public String m378i() {
        return this.f266O;
    }

    /* renamed from: i0 */
    public void m379i0(String str) {
        this.f288k0 = str;
    }

    /* renamed from: j */
    public String m380j() {
        return this.f292o0;
    }

    /* renamed from: j0 */
    public void m381j0(Boolean bool) {
        this.f297t0 = bool;
    }

    /* renamed from: k */
    public String m382k() {
        return this.f275X;
    }

    /* renamed from: k0 */
    public void m383k0(String str) {
        this.f293p0 = str;
    }

    /* renamed from: l */
    public String m384l() {
        return this.f278a0;
    }

    /* renamed from: l0 */
    public void m385l0(String str) {
        this.f302y0 = str;
    }

    /* renamed from: m */
    public String m386m() {
        return this.f272U;
    }

    /* renamed from: m0 */
    public void m387m0(InstanceState instanceState) {
        this.f268Q = instanceState;
    }

    /* renamed from: n */
    public Date m388n() {
        return this.f276Y;
    }

    /* renamed from: n0 */
    public void m389n0(StateReason stateReason) {
        this.f286i0 = stateReason;
    }

    /* renamed from: o */
    public Monitoring m390o() {
        return this.f281d0;
    }

    /* renamed from: o0 */
    public void m391o0(String str) {
        this.f271T = str;
    }

    /* renamed from: p */
    public List<InstanceNetworkInterface> m392p() {
        if (this.f299v0 == null) {
            ListWithAutoConstructFlag<InstanceNetworkInterface> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f299v0 = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f299v0;
    }

    /* renamed from: p0 */
    public void m393p0(String str) {
        this.f282e0 = str;
    }

    /* renamed from: q */
    public Placement m394q() {
        return this.f277Z;
    }

    /* renamed from: q0 */
    public void m395q0(String str) {
        this.f291n0 = str;
    }

    /* renamed from: r */
    public String m396r() {
        return this.f280c0;
    }

    /* renamed from: r0 */
    public void m397r0(String str) {
        this.f283f0 = str;
    }

    /* renamed from: s */
    public String m398s() {
        return this.f269R;
    }

    /* renamed from: t */
    public String m399t() {
        return this.f284g0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m378i() != null) {
            sb.append("InstanceId: " + m378i() + ",");
        }
        if (m376h() != null) {
            sb.append("ImageId: " + m376h() + ",");
        }
        if (m340D() != null) {
            sb.append("State: " + m340D() + ",");
        }
        if (m398s() != null) {
            sb.append("PrivateDnsName: " + m398s() + ",");
        }
        if (m401v() != null) {
            sb.append("PublicDnsName: " + m401v() + ",");
        }
        if (m342F() != null) {
            sb.append("StateTransitionReason: " + m342F() + ",");
        }
        if (m386m() != null) {
            sb.append("KeyName: " + m386m() + ",");
        }
        if (m363a() != null) {
            sb.append("AmiLaunchIndex: " + m363a() + ",");
        }
        if (m400u() != null) {
            sb.append("ProductCodes: " + m400u() + ",");
        }
        if (m382k() != null) {
            sb.append("InstanceType: " + m382k() + ",");
        }
        if (m388n() != null) {
            sb.append("LaunchTime: " + m388n() + ",");
        }
        if (m394q() != null) {
            sb.append("Placement: " + m394q() + ",");
        }
        if (m384l() != null) {
            sb.append("KernelId: " + m384l() + ",");
        }
        if (m403x() != null) {
            sb.append("RamdiskId: " + m403x() + ",");
        }
        if (m396r() != null) {
            sb.append("Platform: " + m396r() + ",");
        }
        if (m390o() != null) {
            sb.append("Monitoring: " + m390o() + ",");
        }
        if (m343G() != null) {
            sb.append("SubnetId: " + m343G() + ",");
        }
        if (m346J() != null) {
            sb.append("VpcId: " + m346J() + ",");
        }
        if (m399t() != null) {
            sb.append("PrivateIpAddress: " + m399t() + ",");
        }
        if (m402w() != null) {
            sb.append("PublicIpAddress: " + m402w() + ",");
        }
        if (m341E() != null) {
            sb.append("StateReason: " + m341E() + ",");
        }
        if (m365b() != null) {
            sb.append("Architecture: " + m365b() + ",");
        }
        if (m405z() != null) {
            sb.append("RootDeviceType: " + m405z() + ",");
        }
        if (m404y() != null) {
            sb.append("RootDeviceName: " + m404y() + ",");
        }
        if (m367c() != null) {
            sb.append("BlockDeviceMappings: " + m367c() + ",");
        }
        if (m345I() != null) {
            sb.append("VirtualizationType: " + m345I() + ",");
        }
        if (m380j() != null) {
            sb.append("InstanceLifecycle: " + m380j() + ",");
        }
        if (m338B() != null) {
            sb.append("SpotInstanceRequestId: " + m338B() + ",");
        }
        if (m369d() != null) {
            sb.append("ClientToken: " + m369d() + ",");
        }
        if (m344H() != null) {
            sb.append("Tags: " + m344H() + ",");
        }
        if (m337A() != null) {
            sb.append("SecurityGroups: " + m337A() + ",");
        }
        if (m348L() != null) {
            sb.append("SourceDestCheck: " + m348L() + ",");
        }
        if (m371e() != null) {
            sb.append("Hypervisor: " + m371e() + ",");
        }
        if (m392p() != null) {
            sb.append("NetworkInterfaces: " + m392p() + ",");
        }
        if (m373f() != null) {
            sb.append("IamInstanceProfile: " + m373f() + ",");
        }
        if (m347K() != null) {
            sb.append("EbsOptimized: " + m347K() + ",");
        }
        if (m339C() != null) {
            sb.append("SriovNetSupport: " + m339C());
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: u */
    public List<ProductCode> m400u() {
        if (this.f274W == null) {
            ListWithAutoConstructFlag<ProductCode> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f274W = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f274W;
    }

    /* renamed from: v */
    public String m401v() {
        return this.f270S;
    }

    /* renamed from: w */
    public String m402w() {
        return this.f285h0;
    }

    /* renamed from: x */
    public String m403x() {
        return this.f279b0;
    }

    /* renamed from: y */
    public String m404y() {
        return this.f289l0;
    }

    /* renamed from: z */
    public String m405z() {
        return this.f288k0;
    }
}
