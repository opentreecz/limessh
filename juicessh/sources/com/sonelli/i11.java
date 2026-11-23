package com.sonelli;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.bouncycastle.util.Encodable;

/* loaded from: classes.dex */
public class i11 implements Encodable {

    /* renamed from: O */
    public final h11 f3251O;

    /* renamed from: P */
    public final byte[] f3252P;

    /* renamed from: Q */
    public final byte[] f3253Q;

    public i11(h11 h11Var, byte[] bArr, byte[] bArr2) {
        this.f3251O = h11Var;
        this.f3252P = bArr;
        this.f3253Q = bArr2;
    }

    /* renamed from: a */
    public static i11 m4706a(Object obj) throws IOException {
        if (obj instanceof i11) {
            return (i11) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            h11 m4336e = h11.m4336e(dataInputStream.readInt());
            byte[] bArr = new byte[m4336e.m4338c()];
            dataInputStream.readFully(bArr);
            byte[] bArr2 = new byte[m4336e.m4339d() * m4336e.m4338c()];
            dataInputStream.readFully(bArr2);
            return new i11(m4336e, bArr, bArr2);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return m4706a(r51.m7880b((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                i11 m4706a = m4706a(dataInputStream3);
                dataInputStream3.close();
                return m4706a;
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i11.class != obj.getClass()) {
            return false;
        }
        i11 i11Var = (i11) obj;
        h11 h11Var = this.f3251O;
        if (h11Var == null ? i11Var.f3251O != null : !h11Var.equals(i11Var.f3251O)) {
            return false;
        }
        if (Arrays.equals(this.f3252P, i11Var.f3252P)) {
            return Arrays.equals(this.f3253Q, i11Var.f3253Q);
        }
        return false;
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        d11 m3091f = d11.m3091f();
        m3091f.m3099i(this.f3251O.m4340f());
        m3091f.m3095d(this.f3252P);
        m3091f.m3095d(this.f3253Q);
        return m3091f.m3093b();
    }

    public int hashCode() {
        h11 h11Var = this.f3251O;
        return ((((h11Var != null ? h11Var.hashCode() : 0) * 31) + Arrays.hashCode(this.f3252P)) * 31) + Arrays.hashCode(this.f3253Q);
    }
}
