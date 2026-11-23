package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.internal.ListWithAutoConstructFlag;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class ModifyReservedInstancesRequest extends AmazonWebServiceRequest implements Serializable {

    /* renamed from: R */
    public String f333R;

    /* renamed from: S */
    public ListWithAutoConstructFlag<String> f334S;

    /* renamed from: T */
    public ListWithAutoConstructFlag<Object> f335T;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ModifyReservedInstancesRequest)) {
            return false;
        }
        ModifyReservedInstancesRequest modifyReservedInstancesRequest = (ModifyReservedInstancesRequest) obj;
        if ((modifyReservedInstancesRequest.m466j() == null) ^ (m466j() == null)) {
            return false;
        }
        if (modifyReservedInstancesRequest.m466j() != null && !modifyReservedInstancesRequest.m466j().equals(m466j())) {
            return false;
        }
        if ((modifyReservedInstancesRequest.m467k() == null) ^ (m467k() == null)) {
            return false;
        }
        if (modifyReservedInstancesRequest.m467k() != null && !modifyReservedInstancesRequest.m467k().equals(m467k())) {
            return false;
        }
        if ((modifyReservedInstancesRequest.m468l() == null) ^ (m468l() == null)) {
            return false;
        }
        return modifyReservedInstancesRequest.m468l() == null || modifyReservedInstancesRequest.m468l().equals(m468l());
    }

    public int hashCode() {
        return (((((m466j() == null ? 0 : m466j().hashCode()) + 31) * 31) + (m467k() == null ? 0 : m467k().hashCode())) * 31) + (m468l() != null ? m468l().hashCode() : 0);
    }

    /* renamed from: j */
    public String m466j() {
        return this.f333R;
    }

    /* renamed from: k */
    public List<String> m467k() {
        if (this.f334S == null) {
            ListWithAutoConstructFlag<String> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f334S = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f334S;
    }

    /* renamed from: l */
    public List<Object> m468l() {
        if (this.f335T == null) {
            ListWithAutoConstructFlag<Object> listWithAutoConstructFlag = new ListWithAutoConstructFlag<>();
            this.f335T = listWithAutoConstructFlag;
            listWithAutoConstructFlag.m208e(true);
        }
        return this.f335T;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m466j() != null) {
            sb.append("ClientToken: " + m466j() + ",");
        }
        if (m467k() != null) {
            sb.append("ReservedInstancesIds: " + m467k() + ",");
        }
        if (m468l() != null) {
            sb.append("TargetConfigurations: " + m468l());
        }
        sb.append("}");
        return sb.toString();
    }
}
