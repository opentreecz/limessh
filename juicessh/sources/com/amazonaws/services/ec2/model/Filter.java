package com.amazonaws.services.ec2.model;

import com.amazonaws.internal.ListWithAutoConstructFlag;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class Filter implements Serializable {

    /* renamed from: O */
    public String f258O;

    /* renamed from: P */
    public ListWithAutoConstructFlag<String> f259P;

    /* renamed from: a */
    public String m325a() {
        return this.f258O;
    }

    /* renamed from: b */
    public List<String> m326b() {
        if (this.f259P == null) {
            ListWithAutoConstructFlag<String> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f259P = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f259P;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Filter)) {
            return false;
        }
        Filter filter = (Filter) obj;
        if ((filter.m325a() == null) ^ (m325a() == null)) {
            return false;
        }
        if (filter.m325a() != null && !filter.m325a().equals(m325a())) {
            return false;
        }
        if ((filter.m326b() == null) ^ (m326b() == null)) {
            return false;
        }
        return filter.m326b() == null || filter.m326b().equals(m326b());
    }

    public int hashCode() {
        return (((m325a() == null ? 0 : m325a().hashCode()) + 31) * 31) + (m326b() != null ? m326b().hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m325a() != null) {
            sb.append("Name: " + m325a() + ",");
        }
        if (m326b() != null) {
            sb.append("Values: " + m326b());
        }
        sb.append("}");
        return sb.toString();
    }
}
