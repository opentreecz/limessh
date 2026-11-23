package com.sonelli;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.InMemoryRepresentable;

/* loaded from: classes.dex */
public class hq0 {

    /* renamed from: a */
    public final InputStream f3216a;

    /* renamed from: b */
    public final int f3217b;

    /* renamed from: c */
    public final byte[][] f3218c;

    public hq0(InputStream inputStream) {
        this(inputStream, ks0.m5994c(inputStream));
    }

    public hq0(InputStream inputStream, int i) {
        this.f3216a = inputStream;
        this.f3217b = i;
        this.f3218c = new byte[11];
    }

    /* renamed from: a */
    public ASN1Encodable m4638a(int i) throws IOException {
        if (i == 4) {
            return new oq0(this);
        }
        if (i == 8) {
            return new zq0(this);
        }
        if (i == 16) {
            return new qq0(this);
        }
        if (i == 17) {
            return new sq0(this);
        }
        throw new tp0("unknown BER object encountered: 0x" + Integer.toHexString(i));
    }

    /* renamed from: b */
    public ASN1Encodable m4639b() throws IOException {
        int read = this.f3216a.read();
        if (read == -1) {
            return null;
        }
        m4642e(false);
        int m9625p = wp0.m9625p(this.f3216a, read);
        boolean z = (read & 32) != 0;
        int m9624l = wp0.m9624l(this.f3216a, this.f3217b, m9625p == 4 || m9625p == 16 || m9625p == 17 || m9625p == 8);
        if (m9624l < 0) {
            if (!z) {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
            hq0 hq0Var = new hq0(new fs0(this.f3216a, this.f3217b), this.f3217b);
            return (read & 64) != 0 ? new lq0(m9625p, hq0Var) : (read & 128) != 0 ? new uq0(true, m9625p, hq0Var) : hq0Var.m4638a(m9625p);
        }
        es0 es0Var = new es0(this.f3216a, m9624l, this.f3217b);
        if ((read & 64) != 0) {
            return new ur0(z, m9625p, es0Var.m3553f());
        }
        if ((read & 128) != 0) {
            return new uq0(z, m9625p, new hq0(es0Var));
        }
        if (!z) {
            if (m9625p == 4) {
                return new hr0(es0Var);
            }
            try {
                return wp0.m9621b(m9625p, es0Var, this.f3218c);
            } catch (IllegalArgumentException e) {
                throw new tp0("corrupted stream detected", e);
            }
        }
        if (m9625p == 4) {
            return new oq0(new hq0(es0Var));
        }
        if (m9625p == 8) {
            return new zq0(new hq0(es0Var));
        }
        if (m9625p == 16) {
            return new as0(new hq0(es0Var));
        }
        if (m9625p == 17) {
            return new cs0(new hq0(es0Var));
        }
        throw new IOException("unknown tag " + m9625p + " encountered");
    }

    /* renamed from: c */
    public eq0 m4640c(boolean z, int i) throws IOException {
        if (!z) {
            return new ds0(false, i, new gr0(((es0) this.f3216a).m3553f()));
        }
        rp0 m4641d = m4641d();
        return this.f3216a instanceof fs0 ? m4641d.m8228f() == 1 ? new tq0(true, i, m4641d.m8226d(0)) : new tq0(false, i, mq0.m6511a(m4641d)) : m4641d.m8228f() == 1 ? new ds0(true, i, m4641d.m8226d(0)) : new ds0(false, i, xr0.m9878a(m4641d));
    }

    /* renamed from: d */
    public rp0 m4641d() throws IOException {
        ASN1Encodable m4639b = m4639b();
        if (m4639b == null) {
            return new rp0(0);
        }
        rp0 rp0Var = new rp0();
        do {
            rp0Var.m8224a(m4639b instanceof InMemoryRepresentable ? ((InMemoryRepresentable) m4639b).mo2595g() : m4639b.mo1950f());
            m4639b = m4639b();
        } while (m4639b != null);
        return rp0Var;
    }

    /* renamed from: e */
    public final void m4642e(boolean z) {
        InputStream inputStream = this.f3216a;
        if (inputStream instanceof fs0) {
            ((fs0) inputStream).m3877d(z);
        }
    }
}
