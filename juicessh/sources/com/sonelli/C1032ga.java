package com.sonelli;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.ga */
/* loaded from: classes.dex */
public class C1032ga {

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.sonelli.ga$a */
    /* loaded from: classes.dex */
    public static class a extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a(java.lang.String r4, android.os.Parcel r5) {
            /*
                r3 = this;
                int r0 = r5.dataPosition()
                int r5 = r5.dataSize()
                java.lang.String r1 = java.lang.String.valueOf(r4)
                int r1 = r1.length()
                int r1 = r1 + 41
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                r2.append(r4)
                java.lang.String r4 = " Parcel: pos="
                r2.append(r4)
                r2.append(r0)
                java.lang.String r4 = " size="
                r2.append(r4)
                r2.append(r5)
                java.lang.String r4 = r2.toString()
                r3.<init>(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sonelli.C1032ga.a.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    /* renamed from: A */
    public static Float m4061A(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        if (m4068H == 0) {
            return null;
        }
        m4072L(parcel, i, m4068H, 4);
        return Float.valueOf(parcel.readFloat());
    }

    /* renamed from: B */
    public static int m4062B(Parcel parcel) {
        return parcel.readInt();
    }

    /* renamed from: C */
    public static IBinder m4063C(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + m4068H);
        return readStrongBinder;
    }

    /* renamed from: D */
    public static int m4064D(Parcel parcel, int i) {
        m4071K(parcel, i, 4);
        return parcel.readInt();
    }

    /* renamed from: E */
    public static Integer m4065E(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        if (m4068H == 0) {
            return null;
        }
        m4072L(parcel, i, m4068H, 4);
        return Integer.valueOf(parcel.readInt());
    }

    /* renamed from: F */
    public static long m4066F(Parcel parcel, int i) {
        m4071K(parcel, i, 8);
        return parcel.readLong();
    }

    /* renamed from: G */
    public static Long m4067G(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        if (m4068H == 0) {
            return null;
        }
        m4072L(parcel, i, m4068H, 8);
        return Long.valueOf(parcel.readLong());
    }

    /* renamed from: H */
    public static int m4068H(Parcel parcel, int i) {
        return (i & SupportMenu.CATEGORY_MASK) != -65536 ? (i >> 16) & SupportMenu.USER_MASK : parcel.readInt();
    }

    /* renamed from: I */
    public static void m4069I(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + m4068H(parcel, i));
    }

    /* renamed from: J */
    public static int m4070J(Parcel parcel) {
        int m4062B = m4062B(parcel);
        int m4068H = m4068H(parcel, m4062B);
        int dataPosition = parcel.dataPosition();
        if (m4093u(m4062B) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(m4062B));
            throw new a(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i = m4068H + dataPosition;
        if (i >= dataPosition && i <= parcel.dataSize()) {
            return i;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(i);
        throw new a(sb.toString(), parcel);
    }

    /* renamed from: K */
    public static void m4071K(Parcel parcel, int i, int i2) {
        int m4068H = m4068H(parcel, i);
        if (m4068H == i2) {
            return;
        }
        String hexString = Integer.toHexString(m4068H);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(m4068H);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new a(sb.toString(), parcel);
    }

    /* renamed from: L */
    public static void m4072L(Parcel parcel, int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        String hexString = Integer.toHexString(i2);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(i2);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new a(sb.toString(), parcel);
    }

    /* renamed from: a */
    public static BigDecimal m4073a(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(dataPosition + m4068H);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    /* renamed from: b */
    public static BigDecimal[] m4074b(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + m4068H);
        return bigDecimalArr;
    }

    /* renamed from: c */
    public static BigInteger m4075c(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + m4068H);
        return new BigInteger(createByteArray);
    }

    /* renamed from: d */
    public static BigInteger[] m4076d(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + m4068H);
        return bigIntegerArr;
    }

    /* renamed from: e */
    public static boolean[] m4077e(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(dataPosition + m4068H);
        return createBooleanArray;
    }

    /* renamed from: f */
    public static Bundle m4078f(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + m4068H);
        return readBundle;
    }

    /* renamed from: g */
    public static byte[] m4079g(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + m4068H);
        return createByteArray;
    }

    /* renamed from: h */
    public static double[] m4080h(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(dataPosition + m4068H);
        return createDoubleArray;
    }

    /* renamed from: i */
    public static float[] m4081i(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + m4068H);
        return createFloatArray;
    }

    /* renamed from: j */
    public static int[] m4082j(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + m4068H);
        return createIntArray;
    }

    /* renamed from: k */
    public static long[] m4083k(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + m4068H);
        return createLongArray;
    }

    /* renamed from: l */
    public static Parcel m4084l(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, m4068H);
        parcel.setDataPosition(dataPosition + m4068H);
        return obtain;
    }

    /* renamed from: m */
    public static Parcel[] m4085m(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + m4068H);
        return parcelArr;
    }

    /* renamed from: n */
    public static <T extends Parcelable> T m4086n(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + m4068H);
        return createFromParcel;
    }

    /* renamed from: o */
    public static String m4087o(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + m4068H);
        return readString;
    }

    /* renamed from: p */
    public static String[] m4088p(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + m4068H);
        return createStringArray;
    }

    /* renamed from: q */
    public static ArrayList<String> m4089q(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + m4068H);
        return createStringArrayList;
    }

    /* renamed from: r */
    public static <T> T[] m4090r(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + m4068H);
        return tArr;
    }

    /* renamed from: s */
    public static <T> ArrayList<T> m4091s(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int m4068H = m4068H(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (m4068H == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + m4068H);
        return createTypedArrayList;
    }

    /* renamed from: t */
    public static void m4092t(Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i);
        throw new a(sb.toString(), parcel);
    }

    /* renamed from: u */
    public static int m4093u(int i) {
        return i & SupportMenu.USER_MASK;
    }

    /* renamed from: v */
    public static boolean m4094v(Parcel parcel, int i) {
        m4071K(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    /* renamed from: w */
    public static Boolean m4095w(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        if (m4068H == 0) {
            return null;
        }
        m4072L(parcel, i, m4068H, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    /* renamed from: x */
    public static double m4096x(Parcel parcel, int i) {
        m4071K(parcel, i, 8);
        return parcel.readDouble();
    }

    /* renamed from: y */
    public static Double m4097y(Parcel parcel, int i) {
        int m4068H = m4068H(parcel, i);
        if (m4068H == 0) {
            return null;
        }
        m4072L(parcel, i, m4068H, 8);
        return Double.valueOf(parcel.readDouble());
    }

    /* renamed from: z */
    public static float m4098z(Parcel parcel, int i) {
        m4071K(parcel, i, 4);
        return parcel.readFloat();
    }
}
