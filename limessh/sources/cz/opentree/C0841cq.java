package cz.opentree;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.cq */
/* loaded from: classes.dex */
public final class C0841cq {

    /* renamed from: a */
    public static final Logger f2026a = Logger.getLogger(C0841cq.class.getName());

    /* renamed from: b */
    public static final Unsafe f2027b;

    /* renamed from: c */
    public static final Class<?> f2028c;

    /* renamed from: d */
    public static final boolean f2029d;

    /* renamed from: e */
    public static final boolean f2030e;

    /* renamed from: f */
    public static final d f2031f;

    /* renamed from: g */
    public static final boolean f2032g;

    /* renamed from: h */
    public static final boolean f2033h;

    /* renamed from: i */
    public static final long f2034i;

    /* renamed from: j */
    public static final boolean f2035j;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    /* renamed from: cz.opentree.cq$a */
    /* loaded from: classes.dex */
    public static final class a extends d {
        public a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: a */
        public final byte mo2943a(Object obj, long j) {
            return C0841cq.f2035j ? C0841cq.m2913L(obj, j) : C0841cq.m2914M(obj, j);
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: b */
        public final void mo2944b(Object obj, long j, byte b) {
            if (C0841cq.f2035j) {
                C0841cq.m2937u(obj, j, b);
            } else {
                C0841cq.m2941y(obj, j, b);
            }
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: c */
        public final void mo2945c(Object obj, long j, double d) {
            m2952f(obj, j, Double.doubleToLongBits(d));
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: d */
        public final void mo2946d(Object obj, long j, float f) {
            m2951e(obj, j, Float.floatToIntBits(f));
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: g */
        public final void mo2947g(Object obj, long j, boolean z) {
            if (C0841cq.f2035j) {
                C0841cq.m2942z(obj, j, z);
            } else {
                C0841cq.m2905D(obj, j, z);
            }
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: h */
        public final boolean mo2948h(Object obj, long j) {
            return C0841cq.f2035j ? C0841cq.m2915N(obj, j) : C0841cq.m2916O(obj, j);
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: i */
        public final float mo2949i(Object obj, long j) {
            return Float.intBitsToFloat(m2953k(obj, j));
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: j */
        public final double mo2950j(Object obj, long j) {
            return Double.longBitsToDouble(m2954l(obj, j));
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    /* renamed from: cz.opentree.cq$b */
    /* loaded from: classes.dex */
    public static final class b extends d {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: a */
        public final byte mo2943a(Object obj, long j) {
            return this.f2036a.getByte(obj, j);
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: b */
        public final void mo2944b(Object obj, long j, byte b) {
            this.f2036a.putByte(obj, j, b);
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: c */
        public final void mo2945c(Object obj, long j, double d) {
            this.f2036a.putDouble(obj, j, d);
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: d */
        public final void mo2946d(Object obj, long j, float f) {
            this.f2036a.putFloat(obj, j, f);
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: g */
        public final void mo2947g(Object obj, long j, boolean z) {
            this.f2036a.putBoolean(obj, j, z);
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: h */
        public final boolean mo2948h(Object obj, long j) {
            return this.f2036a.getBoolean(obj, j);
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: i */
        public final float mo2949i(Object obj, long j) {
            return this.f2036a.getFloat(obj, j);
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: j */
        public final double mo2950j(Object obj, long j) {
            return this.f2036a.getDouble(obj, j);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    /* renamed from: cz.opentree.cq$c */
    /* loaded from: classes.dex */
    public static final class c extends d {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: a */
        public final byte mo2943a(Object obj, long j) {
            return C0841cq.f2035j ? C0841cq.m2913L(obj, j) : C0841cq.m2914M(obj, j);
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: b */
        public final void mo2944b(Object obj, long j, byte b) {
            if (C0841cq.f2035j) {
                C0841cq.m2937u(obj, j, b);
            } else {
                C0841cq.m2941y(obj, j, b);
            }
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: c */
        public final void mo2945c(Object obj, long j, double d) {
            m2952f(obj, j, Double.doubleToLongBits(d));
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: d */
        public final void mo2946d(Object obj, long j, float f) {
            m2951e(obj, j, Float.floatToIntBits(f));
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: g */
        public final void mo2947g(Object obj, long j, boolean z) {
            if (C0841cq.f2035j) {
                C0841cq.m2942z(obj, j, z);
            } else {
                C0841cq.m2905D(obj, j, z);
            }
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: h */
        public final boolean mo2948h(Object obj, long j) {
            return C0841cq.f2035j ? C0841cq.m2915N(obj, j) : C0841cq.m2916O(obj, j);
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: i */
        public final float mo2949i(Object obj, long j) {
            return Float.intBitsToFloat(m2953k(obj, j));
        }

        @Override // cz.opentree.C0841cq.d
        /* renamed from: j */
        public final double mo2950j(Object obj, long j) {
            return Double.longBitsToDouble(m2954l(obj, j));
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    /* renamed from: cz.opentree.cq$d */
    /* loaded from: classes.dex */
    public static abstract class d {

        /* renamed from: a */
        public Unsafe f2036a;

        public d(Unsafe unsafe) {
            this.f2036a = unsafe;
        }

        /* renamed from: a */
        public abstract byte mo2943a(Object obj, long j);

        /* renamed from: b */
        public abstract void mo2944b(Object obj, long j, byte b);

        /* renamed from: c */
        public abstract void mo2945c(Object obj, long j, double d);

        /* renamed from: d */
        public abstract void mo2946d(Object obj, long j, float f);

        /* renamed from: e */
        public final void m2951e(Object obj, long j, int i) {
            this.f2036a.putInt(obj, j, i);
        }

        /* renamed from: f */
        public final void m2952f(Object obj, long j, long j2) {
            this.f2036a.putLong(obj, j, j2);
        }

        /* renamed from: g */
        public abstract void mo2947g(Object obj, long j, boolean z);

        /* renamed from: h */
        public abstract boolean mo2948h(Object obj, long j);

        /* renamed from: i */
        public abstract float mo2949i(Object obj, long j);

        /* renamed from: j */
        public abstract double mo2950j(Object obj, long j);

        /* renamed from: k */
        public final int m2953k(Object obj, long j) {
            return this.f2036a.getInt(obj, j);
        }

        /* renamed from: l */
        public final long m2954l(Object obj, long j) {
            return this.f2036a.getLong(obj, j);
        }
    }

    static {
        Unsafe m2936t = m2936t();
        f2027b = m2936t;
        f2028c = C1775qm.m7744c();
        boolean m2903B = m2903B(Long.TYPE);
        f2029d = m2903B;
        boolean m2903B2 = m2903B(Integer.TYPE);
        f2030e = m2903B2;
        d dVar = null;
        if (m2936t != null) {
            if (!C1775qm.m7743b()) {
                dVar = new b(m2936t);
            } else if (m2903B) {
                dVar = new c(m2936t);
            } else if (m2903B2) {
                dVar = new a(m2936t);
            }
        }
        f2031f = dVar;
        f2032g = m2906E();
        f2033h = m2902A();
        f2034i = m2930n(byte[].class);
        m2930n(boolean[].class);
        m2935s(boolean[].class);
        m2930n(int[].class);
        m2935s(int[].class);
        m2930n(long[].class);
        m2935s(long[].class);
        m2930n(float[].class);
        m2935s(float[].class);
        m2930n(double[].class);
        m2935s(double[].class);
        m2930n(Object[].class);
        m2935s(Object[].class);
        Field m2908G = m2908G();
        if (m2908G != null && dVar != null) {
            dVar.f2036a.objectFieldOffset(m2908G);
        }
        f2035j = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    /* renamed from: A */
    public static boolean m2902A() {
        Unsafe unsafe = f2027b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (C1775qm.m7743b()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = f2026a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    /* renamed from: B */
    public static boolean m2903B(Class<?> cls) {
        if (!C1775qm.m7743b()) {
            return false;
        }
        try {
            Class<?> cls2 = f2028c;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: C */
    public static double m2904C(Object obj, long j) {
        return f2031f.mo2950j(obj, j);
    }

    /* renamed from: D */
    public static void m2905D(Object obj, long j, boolean z) {
        m2941y(obj, j, z ? (byte) 1 : (byte) 0);
    }

    /* renamed from: E */
    public static boolean m2906E() {
        Unsafe unsafe = f2027b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (m2908G() == null) {
                return false;
            }
            if (C1775qm.m7743b()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th) {
            Logger logger = f2026a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    /* renamed from: F */
    public static Object m2907F(Object obj, long j) {
        return f2031f.f2036a.getObject(obj, j);
    }

    /* renamed from: G */
    public static Field m2908G() {
        Field m2920d;
        if (C1775qm.m7743b() && (m2920d = m2920d(Buffer.class, "effectiveDirectAddress")) != null) {
            return m2920d;
        }
        Field m2920d2 = m2920d(Buffer.class, "address");
        if (m2920d2 == null || m2920d2.getType() != Long.TYPE) {
            return null;
        }
        return m2920d2;
    }

    /* renamed from: L */
    public static byte m2913L(Object obj, long j) {
        return (byte) (m2918b(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* renamed from: M */
    public static byte m2914M(Object obj, long j) {
        return (byte) (m2918b(obj, (-4) & j) >>> ((int) ((j & 3) << 3)));
    }

    /* renamed from: N */
    public static boolean m2915N(Object obj, long j) {
        return m2913L(obj, j) != 0;
    }

    /* renamed from: O */
    public static boolean m2916O(Object obj, long j) {
        return m2914M(obj, j) != 0;
    }

    /* renamed from: a */
    public static byte m2917a(byte[] bArr, long j) {
        return f2031f.mo2943a(bArr, f2034i + j);
    }

    /* renamed from: b */
    public static int m2918b(Object obj, long j) {
        return f2031f.m2953k(obj, j);
    }

    /* renamed from: c */
    public static <T> T m2919c(Class<T> cls) {
        try {
            return (T) f2027b.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: d */
    public static Field m2920d(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: f */
    public static void m2922f(Object obj, long j, double d2) {
        f2031f.mo2945c(obj, j, d2);
    }

    /* renamed from: g */
    public static void m2923g(Object obj, long j, float f) {
        f2031f.mo2946d(obj, j, f);
    }

    /* renamed from: h */
    public static void m2924h(Object obj, long j, int i) {
        f2031f.m2951e(obj, j, i);
    }

    /* renamed from: i */
    public static void m2925i(Object obj, long j, long j2) {
        f2031f.m2952f(obj, j, j2);
    }

    /* renamed from: j */
    public static void m2926j(Object obj, long j, Object obj2) {
        f2031f.f2036a.putObject(obj, j, obj2);
    }

    /* renamed from: k */
    public static void m2927k(Object obj, long j, boolean z) {
        f2031f.mo2947g(obj, j, z);
    }

    /* renamed from: l */
    public static void m2928l(byte[] bArr, long j, byte b2) {
        f2031f.mo2944b(bArr, f2034i + j, b2);
    }

    /* renamed from: m */
    public static boolean m2929m() {
        return f2033h;
    }

    /* renamed from: n */
    public static int m2930n(Class<?> cls) {
        if (f2033h) {
            return f2031f.f2036a.arrayBaseOffset(cls);
        }
        return -1;
    }

    /* renamed from: o */
    public static long m2931o(Object obj, long j) {
        return f2031f.m2954l(obj, j);
    }

    /* renamed from: r */
    public static boolean m2934r() {
        return f2032g;
    }

    /* renamed from: s */
    public static int m2935s(Class<?> cls) {
        if (f2033h) {
            return f2031f.f2036a.arrayIndexScale(cls);
        }
        return -1;
    }

    /* renamed from: t */
    public static Unsafe m2936t() {
        try {
            return (Unsafe) AccessController.doPrivileged(new C0950eq());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: u */
    public static void m2937u(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int m2918b = m2918b(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        m2924h(obj, j2, ((255 & b2) << i) | (m2918b & (~(255 << i))));
    }

    /* renamed from: w */
    public static boolean m2939w(Object obj, long j) {
        return f2031f.mo2948h(obj, j);
    }

    /* renamed from: x */
    public static float m2940x(Object obj, long j) {
        return f2031f.mo2949i(obj, j);
    }

    /* renamed from: y */
    public static void m2941y(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        m2924h(obj, j2, ((255 & b2) << i) | (m2918b(obj, j2) & (~(255 << i))));
    }

    /* renamed from: z */
    public static void m2942z(Object obj, long j, boolean z) {
        m2937u(obj, j, z ? (byte) 1 : (byte) 0);
    }
}
