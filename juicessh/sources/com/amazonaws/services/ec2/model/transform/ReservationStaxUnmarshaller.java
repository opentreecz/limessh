package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes.dex */
public class ReservationStaxUnmarshaller implements Unmarshaller<Reservation, StaxUnmarshallerContext> {

    /* renamed from: a */
    public static ReservationStaxUnmarshaller f422a;

    /* renamed from: b */
    public static ReservationStaxUnmarshaller m598b() {
        if (f422a == null) {
            f422a = new ReservationStaxUnmarshaller();
        }
        return f422a;
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Reservation mo561a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Reservation reservation = new Reservation();
        int m615a = staxUnmarshallerContext.m615a();
        int i = m615a + 1;
        if (staxUnmarshallerContext.m617c()) {
            i++;
        }
        while (true) {
            int m618d = staxUnmarshallerContext.m618d();
            if (m618d == 1) {
                return reservation;
            }
            if (m618d == 2) {
                if (staxUnmarshallerContext.m621g("reservationId", i)) {
                    reservation.m509k(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("ownerId", i)) {
                    reservation.m507i(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("requesterId", i)) {
                    reservation.m508j(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("groupSet/item", i)) {
                    reservation.m501b().add(GroupIdentifierStaxUnmarshaller.m572b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("groupSet/item/groupName", i)) {
                    reservation.m500a().add(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.m613b().mo561a(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.m621g("instancesSet/item", i)) {
                    reservation.m502c().add(InstanceStaxUnmarshaller.m588b().mo561a(staxUnmarshallerContext));
                }
            } else if (m618d == 3 && staxUnmarshallerContext.m615a() < m615a) {
                return reservation;
            }
        }
    }
}
