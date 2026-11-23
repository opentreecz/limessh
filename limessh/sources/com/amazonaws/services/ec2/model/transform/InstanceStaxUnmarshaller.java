package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class InstanceStaxUnmarshaller implements Unmarshaller<Instance, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static InstanceStaxUnmarshaller f417a;

    /* renamed from: b */
    public static InstanceStaxUnmarshaller m588b() {
        if (f417a == null) {
            f417a = new InstanceStaxUnmarshaller();
        }
        return f417a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Instance mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Instance instance = new Instance();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return instance;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("instanceId", i)) {
                    instance.m356T(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("imageId", i)) {
                    instance.m355S(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("instanceState", i)) {
                    instance.m387m0(InstanceStateStaxUnmarshaller.m586b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("privateDnsName", i)) {
                    instance.m368c0(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("dnsName", i)) {
                    instance.m372e0(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("reason", i)) {
                    instance.m391o0(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("keyName", i)) {
                    instance.m360X(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("amiLaunchIndex", i)) {
                    instance.m349M(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.m611b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("productCodes/item", i)) {
                    instance.m400u().add(ProductCodeStaxUnmarshaller.m594b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("instanceType", i)) {
                    instance.m358V(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("launchTime", i)) {
                    instance.m361Y(SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller.m609b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("placement", i)) {
                    instance.m364a0(PlacementStaxUnmarshaller.m592b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("kernelId", i)) {
                    instance.m359W(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("ramdiskId", i)) {
                    instance.m375g0(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("platform", i)) {
                    instance.m366b0(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("monitoring", i)) {
                    instance.m362Z(MonitoringStaxUnmarshaller.m590b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("subnetId", i)) {
                    instance.m393p0(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("vpcId", i)) {
                    instance.m397r0(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("privateIpAddress", i)) {
                    instance.m370d0(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("ipAddress", i)) {
                    instance.m374f0(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("stateReason", i)) {
                    instance.m389n0(StateReasonStaxUnmarshaller.m600b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("architecture", i)) {
                    instance.m350N(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("rootDeviceType", i)) {
                    instance.m379i0(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("rootDeviceName", i)) {
                    instance.m377h0(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("blockDeviceMapping/item", i)) {
                    instance.m367c().add(InstanceBlockDeviceMappingStaxUnmarshaller.m576b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("virtualizationType", i)) {
                    instance.m395q0(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("instanceLifecycle", i)) {
                    instance.m357U(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("spotInstanceRequestId", i)) {
                    instance.m383k0(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("clientToken", i)) {
                    instance.m351O(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("tagSet/item", i)) {
                    instance.m344H().add(TagStaxUnmarshaller.m602b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("groupSet/item", i)) {
                    instance.m337A().add(GroupIdentifierStaxUnmarshaller.m572b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("sourceDestCheck", i)) {
                    instance.m381j0(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.m607b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("hypervisor", i)) {
                    instance.m353Q(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("networkInterfaceSet/item", i)) {
                    instance.m392p().add(InstanceNetworkInterfaceStaxUnmarshaller.m582b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("iamInstanceProfile", i)) {
                    instance.m354R(IamInstanceProfileStaxUnmarshaller.m574b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("ebsOptimized", i)) {
                    instance.m352P(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.m607b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("sriovNetSupport", i)) {
                    instance.m385l0(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return instance;
            }
        }
    }
}
