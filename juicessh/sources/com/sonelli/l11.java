package com.sonelli;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class l11 extends j11 {

    /* renamed from: O */
    public final n11 f4716O;

    /* renamed from: P */
    public final h11 f4717P;

    /* renamed from: Q */
    public final byte[] f4718Q;

    /* renamed from: R */
    public final byte[] f4719R;

    public l11(n11 n11Var, h11 h11Var, byte[] bArr, byte[] bArr2) {
        super(false);
        this.f4716O = n11Var;
        this.f4717P = h11Var;
        this.f4718Q = e51.m3436e(bArr2);
        this.f4719R = e51.m3436e(bArr);
    }

    /* renamed from: a */
    public static l11 m6042a(Object obj) throws IOException {
        if (obj instanceof l11) {
            return (l11) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            n11 m6622e = n11.m6622e(dataInputStream.readInt());
            h11 m4336e = h11.m4336e(dataInputStream.readInt());
            byte[] bArr = new byte[16];
            dataInputStream.readFully(bArr);
            byte[] bArr2 = new byte[m6622e.m6625d()];
            dataInputStream.readFully(bArr2);
            return new l11(m6622e, m4336e, bArr2, bArr);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return m6042a(r51.m7880b((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                l11 m6042a = m6042a(dataInputStream3);
                dataInputStream3.close();
                return m6042a;
            } catch (Throwable th) {
                th = th;
                dataInputStream2 = dataInputStream3;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: b */
    public byte[] m6043b() {
        d11 m3091f = d11.m3091f();
        m3091f.m3099i(this.f4716O.m6626f());
        m3091f.m3099i(this.f4717P.m4340f());
        m3091f.m3095d(this.f4718Q);
        m3091f.m3095d(this.f4719R);
        return m3091f.m3093b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l11.class != obj.getClass()) {
            return false;
        }
        l11 l11Var = (l11) obj;
        if (this.f4716O.equals(l11Var.f4716O) && this.f4717P.equals(l11Var.f4717P) && e51.m3432a(this.f4718Q, l11Var.f4718Q)) {
            return e51.m3432a(this.f4719R, l11Var.f4719R);
        }
        return false;
    }

    @Override // com.sonelli.j11, org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        return m6043b();
    }

    public int hashCode() {
        return (((((this.f4716O.hashCode() * 31) + this.f4717P.hashCode()) * 31) + e51.m3445n(this.f4718Q)) * 31) + e51.m3445n(this.f4719R);
    }
}
