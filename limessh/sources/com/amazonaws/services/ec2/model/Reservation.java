package com.amazonaws.services.ec2.model;

import com.amazonaws.internal.ListWithAutoConstructFlag;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public class Reservation implements Serializable {

    /* renamed from: O */
    public String f357O;

    /* renamed from: P */
    public String f358P;

    /* renamed from: Q */
    public String f359Q;

    /* renamed from: R */
    public ListWithAutoConstructFlag<GroupIdentifier> f360R;

    /* renamed from: S */
    public ListWithAutoConstructFlag<String> f361S;

    /* renamed from: T */
    public ListWithAutoConstructFlag<Instance> f362T;

    /* renamed from: a */
    public List<String> m500a() {
        if (this.f361S == null) {
            ListWithAutoConstructFlag<String> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f361S = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f361S;
    }

    /* renamed from: b */
    public List<GroupIdentifier> m501b() {
        if (this.f360R == null) {
            ListWithAutoConstructFlag<GroupIdentifier> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f360R = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f360R;
    }

    /* renamed from: c */
    public List<Instance> m502c() {
        if (this.f362T == null) {
            ListWithAutoConstructFlag<Instance> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f362T = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f362T;
    }

    /* renamed from: d */
    public String m503d() {
        return this.f358P;
    }

    /* renamed from: e */
    public String m504e() {
        return this.f359Q;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Reservation)) {
            return false;
        }
        Reservation reservation = (Reservation) obj;
        if ((reservation.m505f() == null) ^ (m505f() == null)) {
            return false;
        }
        if (reservation.m505f() != null && !reservation.m505f().equals(m505f())) {
            return false;
        }
        if ((reservation.m503d() == null) ^ (m503d() == null)) {
            return false;
        }
        if (reservation.m503d() != null && !reservation.m503d().equals(m503d())) {
            return false;
        }
        if ((reservation.m504e() == null) ^ (m504e() == null)) {
            return false;
        }
        if (reservation.m504e() != null && !reservation.m504e().equals(m504e())) {
            return false;
        }
        if ((reservation.m501b() == null) ^ (m501b() == null)) {
            return false;
        }
        if (reservation.m501b() != null && !reservation.m501b().equals(m501b())) {
            return false;
        }
        if ((reservation.m500a() == null) ^ (m500a() == null)) {
            return false;
        }
        if (reservation.m500a() != null && !reservation.m500a().equals(m500a())) {
            return false;
        }
        if ((reservation.m502c() == null) ^ (m502c() == null)) {
            return false;
        }
        return reservation.m502c() == null || reservation.m502c().equals(m502c());
    }

    /* renamed from: f */
    public String m505f() {
        return this.f357O;
    }

    /* renamed from: h */
    public void m506h(Collection<String> collection) {
        if (collection == null) {
            this.f361S = null;
            return;
        }
        ListWithAutoConstructFlag<String> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>(collection.size());
        listWithAutoConstructFlag.addAll(collection);
        this.f361S = listWithAutoConstructFlag;
    }

    public int hashCode() {
        return (((((((((((m505f() == null ? 0 : m505f().hashCode()) + 31) * 31) + (m503d() == null ? 0 : m503d().hashCode())) * 31) + (m504e() == null ? 0 : m504e().hashCode())) * 31) + (m501b() == null ? 0 : m501b().hashCode())) * 31) + (m500a() == null ? 0 : m500a().hashCode())) * 31) + (m502c() != null ? m502c().hashCode() : 0);
    }

    /* renamed from: i */
    public void m507i(String str) {
        this.f358P = str;
    }

    /* renamed from: j */
    public void m508j(String str) {
        this.f359Q = str;
    }

    /* renamed from: k */
    public void m509k(String str) {
        this.f357O = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m505f() != null) {
            sb.append("ReservationId: " + m505f() + ",");
        }
        if (m503d() != null) {
            sb.append("OwnerId: " + m503d() + ",");
        }
        if (m504e() != null) {
            sb.append("RequesterId: " + m504e() + ",");
        }
        if (m501b() != null) {
            sb.append("Groups: " + m501b() + ",");
        }
        if (m500a() != null) {
            sb.append("GroupNames: " + m500a() + ",");
        }
        if (m502c() != null) {
            sb.append("Instances: " + m502c());
        }
        sb.append("}");
        return sb.toString();
    }
}
