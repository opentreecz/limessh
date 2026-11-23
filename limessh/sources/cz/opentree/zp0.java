package cz.opentree;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.util.Encodable;

/* loaded from: classes.dex */
public abstract class zp0 implements ASN1Encodable, Encodable {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ASN1Encodable) {
            return mo1950f().m3549o(((ASN1Encodable) obj).mo1950f());
        }
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public abstract eq0 mo1950f();

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        mo3547h(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: h */
    public void mo3547h(OutputStream outputStream) throws IOException {
        cq0.m2955a(outputStream).m2973s(this);
    }

    public int hashCode() {
        return mo1950f().hashCode();
    }

    /* renamed from: i */
    public void mo3548i(OutputStream outputStream, String str) throws IOException {
        cq0.m2956b(outputStream, str).m2973s(this);
    }

    /* renamed from: j */
    public byte[] m10587j(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        mo3548i(byteArrayOutputStream, str);
        return byteArrayOutputStream.toByteArray();
    }
}
