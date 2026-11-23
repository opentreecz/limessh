package com.sonelli;

import java.util.Objects;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class rp0 {

    /* renamed from: d */
    public static final ASN1Encodable[] f6271d = new ASN1Encodable[0];

    /* renamed from: a */
    public ASN1Encodable[] f6272a;

    /* renamed from: b */
    public int f6273b;

    /* renamed from: c */
    public boolean f6274c;

    public rp0() {
        this(10);
    }

    public rp0(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("'initialCapacity' must not be negative");
        }
        this.f6272a = i == 0 ? f6271d : new ASN1Encodable[i];
        this.f6273b = 0;
        this.f6274c = false;
    }

    /* renamed from: b */
    public static ASN1Encodable[] m8223b(ASN1Encodable[] aSN1EncodableArr) {
        return aSN1EncodableArr.length < 1 ? f6271d : (ASN1Encodable[]) aSN1EncodableArr.clone();
    }

    /* renamed from: a */
    public void m8224a(ASN1Encodable aSN1Encodable) {
        Objects.requireNonNull(aSN1Encodable, "'element' cannot be null");
        int length = this.f6272a.length;
        int i = this.f6273b + 1;
        if (this.f6274c | (i > length)) {
            m8227e(i);
        }
        this.f6272a[this.f6273b] = aSN1Encodable;
        this.f6273b = i;
    }

    /* renamed from: c */
    public ASN1Encodable[] m8225c() {
        int i = this.f6273b;
        if (i == 0) {
            return f6271d;
        }
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[i];
        System.arraycopy(this.f6272a, 0, aSN1EncodableArr, 0, i);
        return aSN1EncodableArr;
    }

    /* renamed from: d */
    public ASN1Encodable m8226d(int i) {
        if (i < this.f6273b) {
            return this.f6272a[i];
        }
        throw new ArrayIndexOutOfBoundsException(i + " >= " + this.f6273b);
    }

    /* renamed from: e */
    public final void m8227e(int i) {
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[Math.max(this.f6272a.length, i + (i >> 1))];
        System.arraycopy(this.f6272a, 0, aSN1EncodableArr, 0, this.f6273b);
        this.f6272a = aSN1EncodableArr;
        this.f6274c = false;
    }

    /* renamed from: f */
    public int m8228f() {
        return this.f6273b;
    }

    /* renamed from: g */
    public ASN1Encodable[] m8229g() {
        int i = this.f6273b;
        if (i == 0) {
            return f6271d;
        }
        ASN1Encodable[] aSN1EncodableArr = this.f6272a;
        if (aSN1EncodableArr.length == i) {
            this.f6274c = true;
            return aSN1EncodableArr;
        }
        ASN1Encodable[] aSN1EncodableArr2 = new ASN1Encodable[i];
        System.arraycopy(aSN1EncodableArr, 0, aSN1EncodableArr2, 0, i);
        return aSN1EncodableArr2;
    }
}
