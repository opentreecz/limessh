package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ImportKeyPairRequest extends AmazonWebServiceRequest implements Serializable, DryRunSupportedRequest<ImportKeyPairRequest> {

    /* renamed from: R */
    public String f264R;

    /* renamed from: S */
    public String f265S;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ImportKeyPairRequest)) {
            return false;
        }
        ImportKeyPairRequest importKeyPairRequest = (ImportKeyPairRequest) obj;
        if ((importKeyPairRequest.m335j() == null) ^ (m335j() == null)) {
            return false;
        }
        if (importKeyPairRequest.m335j() != null && !importKeyPairRequest.m335j().equals(m335j())) {
            return false;
        }
        if ((importKeyPairRequest.m336k() == null) ^ (m336k() == null)) {
            return false;
        }
        return importKeyPairRequest.m336k() == null || importKeyPairRequest.m336k().equals(m336k());
    }

    public int hashCode() {
        return (((m335j() == null ? 0 : m335j().hashCode()) + 31) * 31) + (m336k() != null ? m336k().hashCode() : 0);
    }

    /* renamed from: j */
    public String m335j() {
        return this.f264R;
    }

    /* renamed from: k */
    public String m336k() {
        return this.f265S;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (m335j() != null) {
            sb.append("KeyName: " + m335j() + ",");
        }
        if (m336k() != null) {
            sb.append("PublicKeyMaterial: " + m336k());
        }
        sb.append("}");
        return sb.toString();
    }
}
