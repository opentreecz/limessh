package com.sonelli;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetStringParser;

/* loaded from: classes.dex */
public class vq0 extends InputStream {

    /* renamed from: O */
    public final hq0 f7547O;

    /* renamed from: P */
    public boolean f7548P = true;

    /* renamed from: Q */
    public InputStream f7549Q;

    public vq0(hq0 hq0Var) {
        this.f7547O = hq0Var;
    }

    /* renamed from: a */
    public final ASN1OctetStringParser m9340a() throws IOException {
        ASN1Encodable m4639b = this.f7547O.m4639b();
        if (m4639b == null) {
            return null;
        }
        if (m4639b instanceof ASN1OctetStringParser) {
            return (ASN1OctetStringParser) m4639b;
        }
        throw new IOException("unknown object encountered: " + m4639b.getClass());
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        ASN1OctetStringParser m9340a;
        if (this.f7549Q == null) {
            if (!this.f7548P || (m9340a = m9340a()) == null) {
                return -1;
            }
            this.f7548P = false;
            this.f7549Q = m9340a.mo2594e();
        }
        while (true) {
            int read = this.f7549Q.read();
            if (read >= 0) {
                return read;
            }
            ASN1OctetStringParser m9340a2 = m9340a();
            if (m9340a2 == null) {
                this.f7549Q = null;
                return -1;
            }
            this.f7549Q = m9340a2.mo2594e();
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        ASN1OctetStringParser m9340a;
        int i3 = 0;
        if (this.f7549Q == null) {
            if (!this.f7548P || (m9340a = m9340a()) == null) {
                return -1;
            }
            this.f7548P = false;
            this.f7549Q = m9340a.mo2594e();
        }
        while (true) {
            int read = this.f7549Q.read(bArr, i + i3, i2 - i3);
            if (read >= 0) {
                i3 += read;
                if (i3 == i2) {
                    return i3;
                }
            } else {
                ASN1OctetStringParser m9340a2 = m9340a();
                if (m9340a2 == null) {
                    this.f7549Q = null;
                    if (i3 < 1) {
                        return -1;
                    }
                    return i3;
                }
                this.f7549Q = m9340a2.mo2594e();
            }
        }
    }
}
