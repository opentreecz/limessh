package com.amazonaws.services.ec2.model;

import com.amazonaws.internal.ListWithAutoConstructFlag;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class InstanceNetworkInterface implements Serializable {

    /* renamed from: O */
    public String f305O;

    /* renamed from: P */
    public String f306P;

    /* renamed from: Q */
    public String f307Q;

    /* renamed from: R */
    public String f308R;

    /* renamed from: S */
    public String f309S;

    /* renamed from: T */
    public String f310T;

    /* renamed from: U */
    public String f311U;

    /* renamed from: V */
    public String f312V;

    /* renamed from: W */
    public String f313W;

    /* renamed from: X */
    public Boolean f314X;

    /* renamed from: Y */
    public ListWithAutoConstructFlag<GroupIdentifier> f315Y;

    /* renamed from: Z */
    public InstanceNetworkInterfaceAttachment f316Z;

    /* renamed from: a0 */
    public InstanceNetworkInterfaceAssociation f317a0;

    /* renamed from: b0 */
    public ListWithAutoConstructFlag<InstancePrivateIpAddress> f318b0;

    /* renamed from: A */
    public void m410A(String str) {
        this.f307Q = str;
    }

    /* renamed from: a */
    public InstanceNetworkInterfaceAssociation m411a() {
        return this.f317a0;
    }

    /* renamed from: b */
    public InstanceNetworkInterfaceAttachment m412b() {
        return this.f316Z;
    }

    /* renamed from: c */
    public String m413c() {
        return this.f308R;
    }

    /* renamed from: d */
    public List<GroupIdentifier> m414d() {
        if (this.f315Y == null) {
            ListWithAutoConstructFlag<GroupIdentifier> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f315Y = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f315Y;
    }

    /* renamed from: e */
    public String m415e() {
        return this.f311U;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InstanceNetworkInterface)) {
            return false;
        }
        InstanceNetworkInterface instanceNetworkInterface = (InstanceNetworkInterface) obj;
        if ((instanceNetworkInterface.m416f() == null) ^ (m416f() == null)) {
            return false;
        }
        if (instanceNetworkInterface.m416f() != null && !instanceNetworkInterface.m416f().equals(m416f())) {
            return false;
        }
        if ((instanceNetworkInterface.m422m() == null) ^ (m422m() == null)) {
            return false;
        }
        if (instanceNetworkInterface.m422m() != null && !instanceNetworkInterface.m422m().equals(m422m())) {
            return false;
        }
        if ((instanceNetworkInterface.m423n() == null) ^ (m423n() == null)) {
            return false;
        }
        if (instanceNetworkInterface.m423n() != null && !instanceNetworkInterface.m423n().equals(m423n())) {
            return false;
        }
        if ((instanceNetworkInterface.m413c() == null) ^ (m413c() == null)) {
            return false;
        }
        if (instanceNetworkInterface.m413c() != null && !instanceNetworkInterface.m413c().equals(m413c())) {
            return false;
        }
        if ((instanceNetworkInterface.m417h() == null) ^ (m417h() == null)) {
            return false;
        }
        if (instanceNetworkInterface.m417h() != null && !instanceNetworkInterface.m417h().equals(m417h())) {
            return false;
        }
        if ((instanceNetworkInterface.m421l() == null) ^ (m421l() == null)) {
            return false;
        }
        if (instanceNetworkInterface.m421l() != null && !instanceNetworkInterface.m421l().equals(m421l())) {
            return false;
        }
        if ((instanceNetworkInterface.m415e() == null) ^ (m415e() == null)) {
            return false;
        }
        if (instanceNetworkInterface.m415e() != null && !instanceNetworkInterface.m415e().equals(m415e())) {
            return false;
        }
        if ((instanceNetworkInterface.m419j() == null) ^ (m419j() == null)) {
            return false;
        }
        if (instanceNetworkInterface.m419j() != null && !instanceNetworkInterface.m419j().equals(m419j())) {
            return false;
        }
        if ((instanceNetworkInterface.m418i() == null) ^ (m418i() == null)) {
            return false;
        }
        if (instanceNetworkInterface.m418i() != null && !instanceNetworkInterface.m418i().equals(m418i())) {
            return false;
        }
        if ((instanceNetworkInterface.m424o() == null) ^ (m424o() == null)) {
            return false;
        }
        if (instanceNetworkInterface.m424o() != null && !instanceNetworkInterface.m424o().equals(m424o())) {
            return false;
        }
        if ((instanceNetworkInterface.m414d() == null) ^ (m414d() == null)) {
            return false;
        }
        if (instanceNetworkInterface.m414d() != null && !instanceNetworkInterface.m414d().equals(m414d())) {
            return false;
        }
        if ((instanceNetworkInterface.m412b() == null) ^ (m412b() == null)) {
            return false;
        }
        if (instanceNetworkInterface.m412b() != null && !instanceNetworkInterface.m412b().equals(m412b())) {
            return false;
        }
        if ((instanceNetworkInterface.m411a() == null) ^ (m411a() == null)) {
            return false;
        }
        if (instanceNetworkInterface.m411a() != null && !instanceNetworkInterface.m411a().equals(m411a())) {
            return false;
        }
        if ((instanceNetworkInterface.m420k() == null) ^ (m420k() == null)) {
            return false;
        }
        return instanceNetworkInterface.m420k() == null || instanceNetworkInterface.m420k().equals(m420k());
    }

    /* renamed from: f */
    public String m416f() {
        return this.f305O;
    }

    /* renamed from: h */
    public String m417h() {
        return this.f309S;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((m416f() == null ? 0 : m416f().hashCode()) + 31) * 31) + (m422m() == null ? 0 : m422m().hashCode())) * 31) + (m423n() == null ? 0 : m423n().hashCode())) * 31) + (m413c() == null ? 0 : m413c().hashCode())) * 31) + (m417h() == null ? 0 : m417h().hashCode())) * 31) + (m421l() == null ? 0 : m421l().hashCode())) * 31) + (m415e() == null ? 0 : m415e().hashCode())) * 31) + (m419j() == null ? 0 : m419j().hashCode())) * 31) + (m418i() == null ? 0 : m418i().hashCode())) * 31) + (m424o() == null ? 0 : m424o().hashCode())) * 31) + (m414d() == null ? 0 : m414d().hashCode())) * 31) + (m412b() == null ? 0 : m412b().hashCode())) * 31) + (m411a() == null ? 0 : m411a().hashCode())) * 31) + (m420k() != null ? m420k().hashCode() : 0);
    }

    /* renamed from: i */
    public String m418i() {
        return this.f313W;
    }

    /* renamed from: j */
    public String m419j() {
        return this.f312V;
    }

    /* renamed from: k */
    public List<InstancePrivateIpAddress> m420k() {
        if (this.f318b0 == null) {
            ListWithAutoConstructFlag<InstancePrivateIpAddress> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f318b0 = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f318b0;
    }

    /* renamed from: l */
    public String m421l() {
        return this.f310T;
    }

    /* renamed from: m */
    public String m422m() {
        return this.f306P;
    }

    /* renamed from: n */
    public String m423n() {
        return this.f307Q;
    }

    /* renamed from: o */
    public Boolean m424o() {
        return this.f314X;
    }

    /* renamed from: p */
    public void m425p(InstanceNetworkInterfaceAssociation instanceNetworkInterfaceAssociation) {
        this.f317a0 = instanceNetworkInterfaceAssociation;
    }

    /* renamed from: q */
    public void m426q(InstanceNetworkInterfaceAttachment instanceNetworkInterfaceAttachment) {
        this.f316Z = instanceNetworkInterfaceAttachment;
    }

    /* renamed from: r */
    public void m427r(String str) {
        this.f308R = str;
    }

    /* renamed from: s */
    public void m428s(String str) {
        this.f311U = str;
    }

    /* renamed from: t */
    public void m429t(String str) {
        this.f305O = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m416f() != null) {
            sb.append("NetworkInterfaceId: " + m416f() + ",");
        }
        if (m422m() != null) {
            sb.append("SubnetId: " + m422m() + ",");
        }
        if (m423n() != null) {
            sb.append("VpcId: " + m423n() + ",");
        }
        if (m413c() != null) {
            sb.append("Description: " + m413c() + ",");
        }
        if (m417h() != null) {
            sb.append("OwnerId: " + m417h() + ",");
        }
        if (m421l() != null) {
            sb.append("Status: " + m421l() + ",");
        }
        if (m415e() != null) {
            sb.append("MacAddress: " + m415e() + ",");
        }
        if (m419j() != null) {
            sb.append("PrivateIpAddress: " + m419j() + ",");
        }
        if (m418i() != null) {
            sb.append("PrivateDnsName: " + m418i() + ",");
        }
        if (m424o() != null) {
            sb.append("SourceDestCheck: " + m424o() + ",");
        }
        if (m414d() != null) {
            sb.append("Groups: " + m414d() + ",");
        }
        if (m412b() != null) {
            sb.append("Attachment: " + m412b() + ",");
        }
        if (m411a() != null) {
            sb.append("Association: " + m411a() + ",");
        }
        if (m420k() != null) {
            sb.append("PrivateIpAddresses: " + m420k());
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: u */
    public void m430u(String str) {
        this.f309S = str;
    }

    /* renamed from: v */
    public void m431v(String str) {
        this.f313W = str;
    }

    /* renamed from: w */
    public void m432w(String str) {
        this.f312V = str;
    }

    /* renamed from: x */
    public void m433x(Boolean bool) {
        this.f314X = bool;
    }

    /* renamed from: y */
    public void m434y(String str) {
        this.f310T = str;
    }

    /* renamed from: z */
    public void m435z(String str) {
        this.f306P = str;
    }
}
