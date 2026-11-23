package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.google.android.material.datepicker.UtcDates;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class QueryStringSigner extends AbstractAWSSigner implements Signer {

    /* renamed from: b */
    public Date f99b;

    /* renamed from: A */
    public final String m121A(Request<?> request) {
        return "POST\n" + m104h(request.mo61q()) + "\n" + m122B(request) + "\n" + m106j(request.mo45a());
    }

    /* renamed from: B */
    public final String m122B(Request<?> request) {
        String str = "";
        if (request.mo61q().getPath() != null) {
            str = "" + request.mo61q().getPath();
        }
        if (request.mo57m() != null) {
            if (str.length() > 0 && !str.endsWith("/") && !request.mo57m().startsWith("/")) {
                str = str + "/";
            }
            str = str + request.mo57m();
        } else if (!str.endsWith("/")) {
            str = str + "/";
        }
        if (!str.startsWith("/")) {
            str = "/" + str;
        }
        return str.startsWith("//") ? str.substring(1) : str;
    }

    /* renamed from: C */
    public final String m123C(int i) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        Date date = this.f99b;
        return date != null ? simpleDateFormat.format(date) : simpleDateFormat.format(m110o(i));
    }

    /* renamed from: D */
    public void m124D(Request<?> request, SignatureVersion signatureVersion, SigningAlgorithm signingAlgorithm, AWSCredentials aWSCredentials) {
        String m121A;
        AWSCredentials m115t = m115t(aWSCredentials);
        request.mo56l("AWSAccessKeyId", m115t.mo96a());
        request.mo56l("SignatureVersion", signatureVersion.toString());
        request.mo56l("Timestamp", m123C(m111p(request)));
        if (m115t instanceof AWSSessionCredentials) {
            m125y(request, (AWSSessionCredentials) m115t);
        }
        if (signatureVersion.equals(SignatureVersion.V1)) {
            m121A = m126z(request.mo45a());
        } else {
            if (!signatureVersion.equals(SignatureVersion.V2)) {
                throw new AmazonClientException("Invalid Signature Version specified");
            }
            request.mo56l("SignatureMethod", signingAlgorithm.toString());
            m121A = m121A(request);
        }
        request.mo56l("Signature", m118w(m121A, m115t.mo97b(), signingAlgorithm));
    }

    @Override // com.amazonaws.auth.Signer
    /* renamed from: b */
    public void mo72b(Request<?> request, AWSCredentials aWSCredentials) {
        m124D(request, SignatureVersion.V2, SigningAlgorithm.HmacSHA256, aWSCredentials);
    }

    /* renamed from: y */
    public void m125y(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.mo56l("SecurityToken", aWSSessionCredentials.getSessionToken());
    }

    /* renamed from: z */
    public final String m126z(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        treeMap.putAll(map);
        for (Map.Entry entry : treeMap.entrySet()) {
            sb.append((String) entry.getKey());
            sb.append((String) entry.getValue());
        }
        return sb.toString();
    }
}
