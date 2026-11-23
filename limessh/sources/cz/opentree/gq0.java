package cz.opentree;

import cz.opentree.e51;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.util.Iterable;

/* loaded from: classes.dex */
public abstract class gq0 extends eq0 implements Iterable<ASN1Encodable> {

    /* renamed from: O */
    public final ASN1Encodable[] f2973O;

    /* renamed from: P */
    public final boolean f2974P;

    /* renamed from: cz.opentree.gq0$a */
    /* loaded from: classes.dex */
    public class C1068a implements Enumeration {

        /* renamed from: a */
        public int f2975a = 0;

        public C1068a() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f2975a < gq0.this.f2973O.length;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            int i = this.f2975a;
            ASN1Encodable[] aSN1EncodableArr = gq0.this.f2973O;
            if (i >= aSN1EncodableArr.length) {
                throw new NoSuchElementException("ASN1Set Enumeration");
            }
            this.f2975a = i + 1;
            return aSN1EncodableArr[i];
        }
    }

    public gq0() {
        this.f2973O = rp0.f6271d;
        this.f2974P = true;
    }

    public gq0(rp0 rp0Var, boolean z) {
        ASN1Encodable[] m8229g;
        Objects.requireNonNull(rp0Var, "'elementVector' cannot be null");
        if (!z || rp0Var.m8228f() < 2) {
            m8229g = rp0Var.m8229g();
        } else {
            m8229g = rp0Var.m8225c();
            m4243A(m8229g);
        }
        this.f2973O = m8229g;
        this.f2974P = z || m8229g.length < 2;
    }

    public gq0(ASN1Encodable aSN1Encodable) {
        Objects.requireNonNull(aSN1Encodable, "'element' cannot be null");
        this.f2973O = new ASN1Encodable[]{aSN1Encodable};
        this.f2974P = true;
    }

    public gq0(boolean z, ASN1Encodable[] aSN1EncodableArr) {
        this.f2973O = aSN1EncodableArr;
        this.f2974P = z || aSN1EncodableArr.length < 2;
    }

    /* renamed from: A */
    public static void m4243A(ASN1Encodable[] aSN1EncodableArr) {
        int length = aSN1EncodableArr.length;
        if (length < 2) {
            return;
        }
        ASN1Encodable aSN1Encodable = aSN1EncodableArr[0];
        ASN1Encodable aSN1Encodable2 = aSN1EncodableArr[1];
        byte[] m4244t = m4244t(aSN1Encodable);
        byte[] m4244t2 = m4244t(aSN1Encodable2);
        if (m4247x(m4244t2, m4244t)) {
            aSN1Encodable2 = aSN1Encodable;
            aSN1Encodable = aSN1Encodable2;
            m4244t2 = m4244t;
            m4244t = m4244t2;
        }
        for (int i = 2; i < length; i++) {
            ASN1Encodable aSN1Encodable3 = aSN1EncodableArr[i];
            byte[] m4244t3 = m4244t(aSN1Encodable3);
            if (m4247x(m4244t2, m4244t3)) {
                aSN1EncodableArr[i - 2] = aSN1Encodable;
                aSN1Encodable = aSN1Encodable2;
                m4244t = m4244t2;
                aSN1Encodable2 = aSN1Encodable3;
                m4244t2 = m4244t3;
            } else if (m4247x(m4244t, m4244t3)) {
                aSN1EncodableArr[i - 2] = aSN1Encodable;
                aSN1Encodable = aSN1Encodable3;
                m4244t = m4244t3;
            } else {
                int i2 = i - 1;
                while (true) {
                    i2--;
                    if (i2 <= 0) {
                        break;
                    }
                    ASN1Encodable aSN1Encodable4 = aSN1EncodableArr[i2 - 1];
                    if (m4247x(m4244t(aSN1Encodable4), m4244t3)) {
                        break;
                    } else {
                        aSN1EncodableArr[i2] = aSN1Encodable4;
                    }
                }
                aSN1EncodableArr[i2] = aSN1Encodable3;
            }
        }
        aSN1EncodableArr[length - 2] = aSN1Encodable;
        aSN1EncodableArr[length - 1] = aSN1Encodable2;
    }

    /* renamed from: t */
    public static byte[] m4244t(ASN1Encodable aSN1Encodable) {
        try {
            return aSN1Encodable.mo1950f().m10587j("DER");
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    /* renamed from: u */
    public static gq0 m4245u(Object obj) {
        if (obj == null || (obj instanceof gq0)) {
            return (gq0) obj;
        }
        if (obj instanceof ASN1SetParser) {
            return m4245u(((ASN1SetParser) obj).mo1950f());
        }
        if (obj instanceof byte[]) {
            try {
                return m4245u(eq0.m3546p((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct set from byte[]: " + e.getMessage());
            }
        }
        if (obj instanceof ASN1Encodable) {
            eq0 mo1950f = ((ASN1Encodable) obj).mo1950f();
            if (mo1950f instanceof gq0) {
                return (gq0) mo1950f;
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    /* renamed from: v */
    public static gq0 m4246v(iq0 iq0Var, boolean z) {
        if (z) {
            if (iq0Var.m4912w()) {
                return m4245u(iq0Var.m4910u());
            }
            throw new IllegalArgumentException("object implicit - explicit expected.");
        }
        eq0 m4910u = iq0Var.m4910u();
        if (iq0Var.m4912w()) {
            return iq0Var instanceof tq0 ? new rq0(m4910u) : new bs0(m4910u);
        }
        if (m4910u instanceof gq0) {
            gq0 gq0Var = (gq0) m4910u;
            return iq0Var instanceof tq0 ? gq0Var : (gq0) gq0Var.mo2597s();
        }
        if (m4910u instanceof fq0) {
            ASN1Encodable[] mo3872w = ((fq0) m4910u).mo3872w();
            return iq0Var instanceof tq0 ? new rq0(false, mo3872w) : new bs0(false, mo3872w);
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + iq0Var.getClass().getName());
    }

    /* renamed from: x */
    public static boolean m4247x(byte[] bArr, byte[] bArr2) {
        int i = bArr[0] & (-33);
        int i2 = bArr2[0] & (-33);
        if (i != i2) {
            return i < i2;
        }
        int min = Math.min(bArr.length, bArr2.length) - 1;
        for (int i3 = 1; i3 < min; i3++) {
            if (bArr[i3] != bArr2[i3]) {
                return (bArr[i3] & 255) < (bArr2[i3] & 255);
            }
        }
        return (bArr[min] & 255) <= (bArr2[min] & 255);
    }

    /* renamed from: B */
    public ASN1Encodable[] m4248B() {
        return rp0.m8223b(this.f2973O);
    }

    @Override // cz.opentree.zp0
    public int hashCode() {
        int length = this.f2973O.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i += this.f2973O[length].mo1950f().hashCode();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<ASN1Encodable> iterator() {
        return new e51.C0912a(m4248B());
    }

    @Override // cz.opentree.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (!(eq0Var instanceof gq0)) {
            return false;
        }
        gq0 gq0Var = (gq0) eq0Var;
        int size = size();
        if (gq0Var.size() != size) {
            return false;
        }
        mr0 mr0Var = (mr0) mo2596r();
        mr0 mr0Var2 = (mr0) gq0Var.mo2596r();
        for (int i = 0; i < size; i++) {
            eq0 mo1950f = mr0Var.f2973O[i].mo1950f();
            eq0 mo1950f2 = mr0Var2.f2973O[i].mo1950f();
            if (mo1950f != mo1950f2 && !mo1950f.mo2259k(mo1950f2)) {
                return false;
            }
        }
        return true;
    }

    @Override // cz.opentree.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return true;
    }

    @Override // cz.opentree.eq0
    /* renamed from: r */
    public eq0 mo2596r() {
        ASN1Encodable[] aSN1EncodableArr;
        if (this.f2974P) {
            aSN1EncodableArr = this.f2973O;
        } else {
            aSN1EncodableArr = (ASN1Encodable[]) this.f2973O.clone();
            m4243A(aSN1EncodableArr);
        }
        return new mr0(true, aSN1EncodableArr);
    }

    @Override // cz.opentree.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return new bs0(this.f2974P, this.f2973O);
    }

    public int size() {
        return this.f2973O.length;
    }

    public String toString() {
        int size = size();
        if (size == 0) {
            return "[]";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        int i = 0;
        while (true) {
            stringBuffer.append(this.f2973O[i]);
            i++;
            if (i >= size) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }

    /* renamed from: w */
    public Enumeration m4249w() {
        return new C1068a();
    }
}
