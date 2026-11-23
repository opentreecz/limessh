package cz.opentree;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class nq0 extends bq0 {

    /* renamed from: P */
    public final int f5351P;

    /* renamed from: Q */
    public final bq0[] f5352Q;

    /* renamed from: cz.opentree.nq0$a */
    /* loaded from: classes.dex */
    public class C1617a implements Enumeration {

        /* renamed from: a */
        public int f5353a = 0;

        public C1617a() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f5353a < nq0.this.f5352Q.length;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            bq0[] bq0VarArr = nq0.this.f5352Q;
            int i = this.f5353a;
            this.f5353a = i + 1;
            return bq0VarArr[i];
        }
    }

    public nq0(byte[] bArr) {
        this(bArr, 1000);
    }

    public nq0(byte[] bArr, int i) {
        this(bArr, null, i);
    }

    public nq0(byte[] bArr, bq0[] bq0VarArr, int i) {
        super(bArr);
        this.f5352Q = bq0VarArr;
        this.f5351P = i;
    }

    public nq0(bq0[] bq0VarArr) {
        this(bq0VarArr, 1000);
    }

    public nq0(bq0[] bq0VarArr, int i) {
        this(m6769C(bq0VarArr), bq0VarArr, i);
    }

    /* renamed from: C */
    public static byte[] m6769C(bq0[] bq0VarArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i != bq0VarArr.length; i++) {
            try {
                byteArrayOutputStream.write(((gr0) bq0VarArr[i]).m2598v());
            } catch (IOException e) {
                throw new IllegalArgumentException("exception converting octets " + e.toString());
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException(bq0VarArr[i].getClass().getName() + " found in input should only contain DEROctetString");
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: x */
    public static nq0 m6771x(fq0 fq0Var) {
        int size = fq0Var.size();
        bq0[] bq0VarArr = new bq0[size];
        for (int i = 0; i < size; i++) {
            bq0VarArr[i] = bq0.m2592t(fq0Var.mo3870u(i));
        }
        return new nq0(bq0VarArr);
    }

    /* renamed from: A */
    public final Vector m6772A() {
        Vector vector = new Vector();
        int i = 0;
        while (true) {
            byte[] bArr = this.f1782O;
            if (i >= bArr.length) {
                return vector;
            }
            int min = Math.min(bArr.length, this.f5351P + i) - i;
            byte[] bArr2 = new byte[min];
            System.arraycopy(this.f1782O, i, bArr2, 0, min);
            vector.addElement(new gr0(bArr2));
            i += this.f5351P;
        }
    }

    /* renamed from: B */
    public Enumeration m6773B() {
        return this.f5352Q == null ? m6772A().elements() : new C1617a();
    }

    @Override // cz.opentree.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2970p(z, 36, m6773B());
    }

    @Override // cz.opentree.eq0
    /* renamed from: n */
    public int mo2261n() throws IOException {
        Enumeration m6773B = m6773B();
        int i = 0;
        while (m6773B.hasMoreElements()) {
            i += ((ASN1Encodable) m6773B.nextElement()).mo1950f().mo2261n();
        }
        return i + 2 + 2;
    }

    @Override // cz.opentree.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return true;
    }
}
