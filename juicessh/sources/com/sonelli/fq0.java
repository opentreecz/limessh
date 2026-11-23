package com.sonelli;

import com.sonelli.e51;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.util.Iterable;

/* loaded from: classes.dex */
public abstract class fq0 extends eq0 implements Iterable<ASN1Encodable> {

    /* renamed from: O */
    public ASN1Encodable[] f2760O;

    /* renamed from: com.sonelli.fq0$a */
    /* loaded from: classes.dex */
    public class C1009a implements Enumeration {

        /* renamed from: a */
        public int f2761a = 0;

        public C1009a() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f2761a < fq0.this.f2760O.length;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            int i = this.f2761a;
            ASN1Encodable[] aSN1EncodableArr = fq0.this.f2760O;
            if (i >= aSN1EncodableArr.length) {
                throw new NoSuchElementException("ASN1Sequence Enumeration");
            }
            this.f2761a = i + 1;
            return aSN1EncodableArr[i];
        }
    }

    public fq0() {
        this.f2760O = rp0.f6271d;
    }

    public fq0(rp0 rp0Var) {
        Objects.requireNonNull(rp0Var, "'elementVector' cannot be null");
        this.f2760O = rp0Var.m8229g();
    }

    public fq0(ASN1Encodable[] aSN1EncodableArr, boolean z) {
        this.f2760O = z ? rp0.m8223b(aSN1EncodableArr) : aSN1EncodableArr;
    }

    /* renamed from: t */
    public static fq0 m3869t(Object obj) {
        if (obj == null || (obj instanceof fq0)) {
            return (fq0) obj;
        }
        if (obj instanceof ASN1SequenceParser) {
            return m3869t(((ASN1SequenceParser) obj).mo1950f());
        }
        if (obj instanceof byte[]) {
            try {
                return m3869t(eq0.m3546p((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e.getMessage());
            }
        }
        if (obj instanceof ASN1Encodable) {
            eq0 mo1950f = ((ASN1Encodable) obj).mo1950f();
            if (mo1950f instanceof fq0) {
                return (fq0) mo1950f;
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    @Override // com.sonelli.zp0
    public int hashCode() {
        int length = this.f2760O.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ this.f2760O[length].mo1950f().hashCode();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<ASN1Encodable> iterator() {
        return new e51.C0912a(this.f2760O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (!(eq0Var instanceof fq0)) {
            return false;
        }
        fq0 fq0Var = (fq0) eq0Var;
        int size = size();
        if (fq0Var.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            eq0 mo1950f = this.f2760O[i].mo1950f();
            eq0 mo1950f2 = fq0Var.f2760O[i].mo1950f();
            if (mo1950f != mo1950f2 && !mo1950f.mo2259k(mo1950f2)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.sonelli.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return true;
    }

    @Override // com.sonelli.eq0
    /* renamed from: r */
    public eq0 mo2596r() {
        return new kr0(this.f2760O, false);
    }

    @Override // com.sonelli.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return new zr0(this.f2760O, false);
    }

    public int size() {
        return this.f2760O.length;
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
            stringBuffer.append(this.f2760O[i]);
            i++;
            if (i >= size) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }

    /* renamed from: u */
    public ASN1Encodable mo3870u(int i) {
        return this.f2760O[i];
    }

    /* renamed from: v */
    public Enumeration mo3871v() {
        return new C1009a();
    }

    /* renamed from: w */
    public ASN1Encodable[] mo3872w() {
        return this.f2760O;
    }
}
