package com.sonelli;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class g11 extends j11 {

    /* renamed from: O */
    public final int f2802O;

    /* renamed from: P */
    public final l11 f2803P;

    public g11(int i, l11 l11Var) {
        super(false);
        this.f2802O = i;
        this.f2803P = l11Var;
    }

    /* renamed from: a */
    public static g11 m3929a(Object obj) throws IOException {
        if (obj instanceof g11) {
            return (g11) obj;
        }
        if (obj instanceof DataInputStream) {
            return new g11(((DataInputStream) obj).readInt(), l11.m6042a(obj));
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return m3929a(r51.m7880b((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                g11 m3929a = m3929a(dataInputStream2);
                dataInputStream2.close();
                return m3929a;
            } catch (Throwable th) {
                th = th;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: b */
    public int m3930b() {
        return this.f2802O;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g11.class != obj.getClass()) {
            return false;
        }
        g11 g11Var = (g11) obj;
        if (this.f2802O != g11Var.f2802O) {
            return false;
        }
        return this.f2803P.equals(g11Var.f2803P);
    }

    @Override // com.sonelli.j11, org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        d11 m3091f = d11.m3091f();
        m3091f.m3099i(this.f2802O);
        m3091f.m3095d(this.f2803P.getEncoded());
        return m3091f.m3093b();
    }

    public int hashCode() {
        return (this.f2802O * 31) + this.f2803P.hashCode();
    }
}
