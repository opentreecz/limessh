package com.sonelli;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.bouncycastle.crypto.Digest;

/* loaded from: classes.dex */
public class m31 {

    /* renamed from: com.sonelli.m31$a */
    /* loaded from: classes.dex */
    public static class C1536a extends ObjectInputStream {

        /* renamed from: Q */
        public static final Set f4978Q;

        /* renamed from: O */
        public final Class f4979O;

        /* renamed from: P */
        public boolean f4980P;

        static {
            HashSet hashSet = new HashSet();
            f4978Q = hashSet;
            hashSet.add("java.util.TreeMap");
            hashSet.add("java.lang.Integer");
            hashSet.add("java.lang.Number");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.BDS");
            hashSet.add("java.util.ArrayList");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.XMSSNode");
            hashSet.add("[B");
            hashSet.add("java.util.LinkedList");
            hashSet.add("java.util.Stack");
            hashSet.add("java.util.Vector");
            hashSet.add("[Ljava.lang.Object;");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.BDSTreeHash");
        }

        public C1536a(Class cls, InputStream inputStream) throws IOException {
            super(inputStream);
            this.f4980P = false;
            this.f4979O = cls;
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            if (this.f4980P) {
                if (!f4978Q.contains(objectStreamClass.getName())) {
                    throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
                }
            } else {
                if (!objectStreamClass.getName().equals(this.f4979O.getName())) {
                    throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
                }
                this.f4980P = true;
            }
            return super.resolveClass(objectStreamClass);
        }
    }

    /* renamed from: a */
    public static long m6351a(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "in == null");
        long j = 0;
        for (int i3 = i; i3 < i + i2; i3++) {
            j = (j << 8) | (bArr[i3] & 255);
        }
        return j;
    }

    /* renamed from: b */
    public static int m6352b(int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (((i >> i3) & 1) == 0) {
                return i3;
            }
        }
        return 0;
    }

    /* renamed from: c */
    public static byte[] m6353c(byte[] bArr) {
        Objects.requireNonNull(bArr, "in == null");
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* renamed from: d */
    public static byte[][] m6354d(byte[][] bArr) {
        if (m6361k(bArr)) {
            throw new NullPointerException("in has null pointers");
        }
        byte[][] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = new byte[bArr[i].length];
            System.arraycopy(bArr[i], 0, bArr2[i], 0, bArr[i].length);
        }
        return bArr2;
    }

    /* renamed from: e */
    public static void m6355e(byte[] bArr, byte[] bArr2, int i) {
        Objects.requireNonNull(bArr, "dst == null");
        Objects.requireNonNull(bArr2, "src == null");
        if (i < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        }
        if (bArr2.length + i > bArr.length) {
            throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            bArr[i + i2] = bArr2[i2];
        }
    }

    /* renamed from: f */
    public static Object m6356f(byte[] bArr, Class cls) throws IOException, ClassNotFoundException {
        C1536a c1536a = new C1536a(cls, new ByteArrayInputStream(bArr));
        Object readObject = c1536a.readObject();
        if (c1536a.available() != 0) {
            throw new IOException("unexpected data found at end of ObjectInputStream");
        }
        if (cls.isInstance(readObject)) {
            return readObject;
        }
        throw new IOException("unexpected class found in ObjectInputStream");
    }

    /* renamed from: g */
    public static byte[] m6357g(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "src == null");
        if (i < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("length hast to be >= 0");
        }
        if (i + i2 > bArr.length) {
            throw new IllegalArgumentException("offset + length must not be greater then size of source array");
        }
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr2[i3] = bArr[i + i3];
        }
        return bArr2;
    }

    /* renamed from: h */
    public static int m6358h(Digest digest) {
        Objects.requireNonNull(digest, "digest == null");
        String mo7097e = digest.mo7097e();
        if (mo7097e.equals("SHAKE128")) {
            return 32;
        }
        if (mo7097e.equals("SHAKE256")) {
            return 64;
        }
        return digest.mo6519f();
    }

    /* renamed from: i */
    public static int m6359i(long j, int i) {
        return (int) (j & ((1 << i) - 1));
    }

    /* renamed from: j */
    public static long m6360j(long j, int i) {
        return j >> i;
    }

    /* renamed from: k */
    public static boolean m6361k(byte[][] bArr) {
        if (bArr == null) {
            return true;
        }
        for (byte[] bArr2 : bArr) {
            if (bArr2 == null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: l */
    public static boolean m6362l(int i, long j) {
        if (j >= 0) {
            return j < (1 << i);
        }
        throw new IllegalStateException("index must not be negative");
    }

    /* renamed from: m */
    public static boolean m6363m(long j, int i, int i2) {
        return j != 0 && (j + 1) % ((long) Math.pow((double) (1 << i), (double) i2)) == 0;
    }

    /* renamed from: n */
    public static boolean m6364n(long j, int i, int i2) {
        return j != 0 && j % ((long) Math.pow((double) (1 << i), (double) (i2 + 1))) == 0;
    }

    /* renamed from: o */
    public static int m6365o(int i) {
        int i2 = 0;
        while (true) {
            i >>= 1;
            if (i == 0) {
                return i2;
            }
            i2++;
        }
    }

    /* renamed from: p */
    public static byte[] m6366p(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: q */
    public static byte[] m6367q(long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            bArr[i2] = (byte) j;
            j >>>= 8;
        }
        return bArr;
    }
}
