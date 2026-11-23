package com.sonelli;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.bouncycastle.util.Encodable;

/* loaded from: classes.dex */
public class m11 implements Encodable {

    /* renamed from: O */
    public final int f4952O;

    /* renamed from: P */
    public final i11 f4953P;

    /* renamed from: Q */
    public final n11 f4954Q;

    /* renamed from: R */
    public final byte[][] f4955R;

    public m11(int i, i11 i11Var, n11 n11Var, byte[][] bArr) {
        this.f4952O = i;
        this.f4953P = i11Var;
        this.f4954Q = n11Var;
        this.f4955R = bArr;
    }

    /* renamed from: a */
    public static m11 m6338a(Object obj) throws IOException {
        if (obj instanceof m11) {
            return (m11) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            int readInt = dataInputStream.readInt();
            i11 m4706a = i11.m4706a(obj);
            n11 m6622e = n11.m6622e(dataInputStream.readInt());
            int m6624c = m6622e.m6624c();
            byte[][] bArr = new byte[m6624c];
            for (int i = 0; i < m6624c; i++) {
                bArr[i] = new byte[m6622e.m6625d()];
                dataInputStream.readFully(bArr[i]);
            }
            return new m11(readInt, m4706a, m6622e, bArr);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return m6338a(r51.m7880b((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                m11 m6338a = m6338a(dataInputStream3);
                dataInputStream3.close();
                return m6338a;
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
        if (obj == null || m11.class != obj.getClass()) {
            return false;
        }
        m11 m11Var = (m11) obj;
        if (this.f4952O != m11Var.f4952O) {
            return false;
        }
        i11 i11Var = this.f4953P;
        if (i11Var == null ? m11Var.f4953P != null : !i11Var.equals(m11Var.f4953P)) {
            return false;
        }
        n11 n11Var = this.f4954Q;
        if (n11Var == null ? m11Var.f4954Q == null : n11Var.equals(m11Var.f4954Q)) {
            return Arrays.deepEquals(this.f4955R, m11Var.f4955R);
        }
        return false;
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        d11 m3091f = d11.m3091f();
        m3091f.m3099i(this.f4952O);
        m3091f.m3095d(this.f4953P.getEncoded());
        m3091f.m3099i(this.f4954Q.m6626f());
        m3091f.m3096e(this.f4955R);
        return m3091f.m3093b();
    }

    public int hashCode() {
        int i = this.f4952O * 31;
        i11 i11Var = this.f4953P;
        int hashCode = (i + (i11Var != null ? i11Var.hashCode() : 0)) * 31;
        n11 n11Var = this.f4954Q;
        return ((hashCode + (n11Var != null ? n11Var.hashCode() : 0)) * 31) + Arrays.deepHashCode(this.f4955R);
    }
}
