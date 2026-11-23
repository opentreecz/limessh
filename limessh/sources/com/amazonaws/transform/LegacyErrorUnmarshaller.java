package com.amazonaws.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

/* loaded from: classes.dex */
public class LegacyErrorUnmarshaller implements Unmarshaller<AmazonServiceException, Node> {

    /* renamed from: a */
    public final Class<? extends AmazonServiceException> f425a;

    public LegacyErrorUnmarshaller() {
        this(AmazonServiceException.class);
    }

    public LegacyErrorUnmarshaller(Class<? extends AmazonServiceException> cls) {
        this.f425a = cls;
    }

    /* renamed from: b */
    public String m604b(Node node) throws Exception {
        return XpathUtils.m705b("Response/Errors/Error/Code", node);
    }

    @Override // com.amazonaws.transform.Unmarshaller
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AmazonServiceException mo561a(Node node) throws Exception {
        String m604b = m604b(node);
        String m705b = XpathUtils.m705b("Response/Errors/Error/Message", node);
        String m705b2 = XpathUtils.m705b("Response/RequestID", node);
        String m705b3 = XpathUtils.m705b("Response/Errors/Error/Type", node);
        AmazonServiceException newInstance = this.f425a.getConstructor(String.class).newInstance(m705b);
        newInstance.setErrorCode(m604b);
        newInstance.setRequestId(m705b2);
        if (m705b3 == null) {
            newInstance.setErrorType(AmazonServiceException.ErrorType.Unknown);
        } else if ("server".equalsIgnoreCase(m705b3)) {
            newInstance.setErrorType(AmazonServiceException.ErrorType.Service);
        } else if ("client".equalsIgnoreCase(m705b3)) {
            newInstance.setErrorType(AmazonServiceException.ErrorType.Client);
        }
        return newInstance;
    }
}
