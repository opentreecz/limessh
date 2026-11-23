package cz.opentree;

import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzgt;
import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzgy;
import cz.opentree.AbstractC2303xn;
import cz.opentree.AbstractC2303xn.b;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.xn */
/* loaded from: classes.dex */
public abstract class AbstractC2303xn<MessageType extends AbstractC2303xn<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends AbstractC1464km<MessageType, BuilderType> {
    private static Map<Object, AbstractC2303xn<?, ?>> zzd = new ConcurrentHashMap();
    public C2437zp zzb = C2437zp.m10576a();
    private int zzc = -1;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    /* renamed from: cz.opentree.xn$a */
    /* loaded from: classes.dex */
    public static class a<T extends AbstractC2303xn<T, ?>> extends C1663om<T> {
        public a(T t) {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    /* renamed from: cz.opentree.xn$b */
    /* loaded from: classes.dex */
    public static abstract class b<MessageType extends AbstractC2303xn<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends AbstractC1560mm<MessageType, BuilderType> {

        /* renamed from: O */
        public final MessageType f8021O;

        /* renamed from: P */
        public MessageType f8022P;

        /* renamed from: Q */
        public boolean f8023Q = false;

        public b(MessageType messagetype) {
            this.f8021O = messagetype;
            this.f8022P = (MessageType) messagetype.mo2132s(e.f8027d, null, null);
        }

        /* renamed from: q */
        public static void m9841q(MessageType messagetype, MessageType messagetype2) {
            C1007fp.m3851a().m3853c(messagetype).mo1280i(messagetype, messagetype2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // cz.opentree.AbstractC1560mm
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            b bVar = (b) this.f8021O.mo2132s(e.f8028e, null, null);
            bVar.m9842o((AbstractC2303xn) mo1260n());
            return bVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzgv
        /* renamed from: e */
        public final /* synthetic */ zzgt mo1269e() {
            return this.f8021O;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // cz.opentree.AbstractC1560mm
        /* renamed from: k */
        public final /* synthetic */ AbstractC1560mm mo6460k(AbstractC1464km abstractC1464km) {
            m9842o((AbstractC2303xn) abstractC1464km);
            return this;
        }

        @Override // cz.opentree.AbstractC1560mm
        /* renamed from: l */
        public final /* synthetic */ AbstractC1560mm mo6461l(byte[] bArr, int i, int i2) throws C0839co {
            m9843r(bArr, 0, i2, C1466kn.m5954a());
            return this;
        }

        @Override // cz.opentree.AbstractC1560mm
        /* renamed from: m */
        public final /* synthetic */ AbstractC1560mm mo6462m(byte[] bArr, int i, int i2, C1466kn c1466kn) throws C0839co {
            m9843r(bArr, 0, i2, c1466kn);
            return this;
        }

        /* renamed from: o */
        public final BuilderType m9842o(MessageType messagetype) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            m9841q(this.f8022P, messagetype);
            return this;
        }

        /* renamed from: r */
        public final BuilderType m9843r(byte[] bArr, int i, int i2, C1466kn c1466kn) throws C0839co {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            try {
                C1007fp.m3851a().m3853c(this.f8022P).mo1279h(this.f8022P, bArr, 0, i2 + 0, new C1876sm(c1466kn));
                return this;
            } catch (C0839co e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw C0839co.m2889a();
            }
        }

        /* renamed from: s */
        public void m9844s() {
            MessageType messagetype = (MessageType) this.f8022P.mo2132s(e.f8027d, null, null);
            m9841q(messagetype, this.f8022P);
            this.f8022P = messagetype;
        }

        @Override // com.google.android.gms.internal.measurement.zzgs
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public MessageType mo1260n() {
            if (this.f8023Q) {
                return this.f8022P;
            }
            MessageType messagetype = this.f8022P;
            C1007fp.m3851a().m3853c(messagetype).mo1275d(messagetype);
            this.f8023Q = true;
            return this.f8022P;
        }

        @Override // com.google.android.gms.internal.measurement.zzgs
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public final MessageType mo1259f() {
            MessageType messagetype = (MessageType) mo1260n();
            if (messagetype.mo1268d()) {
                return messagetype;
            }
            throw new C2308xp(messagetype);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    /* renamed from: cz.opentree.xn$c */
    /* loaded from: classes.dex */
    public static final class c implements zzfd<c> {
        @Override // com.google.android.gms.internal.measurement.zzfd
        /* renamed from: a */
        public final int mo1226a() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        /* renamed from: b */
        public final EnumC1616nq mo1227b() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        /* renamed from: c */
        public final EnumC1780qq mo1228c() {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        /* renamed from: d */
        public final boolean mo1229d() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        /* renamed from: e */
        public final boolean mo1230e() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        /* renamed from: i */
        public final zzgy mo1231i(zzgy zzgyVar, zzgy zzgyVar2) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        /* renamed from: j */
        public final zzgs mo1232j(zzgs zzgsVar, zzgt zzgtVar) {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    /* renamed from: cz.opentree.xn$d */
    /* loaded from: classes.dex */
    public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType> extends AbstractC2303xn<MessageType, BuilderType> implements zzgv {
        public C1826rn<c> zzc = C1826rn.m8201c();

        /* renamed from: D */
        public final C1826rn<c> m9847D() {
            if (this.zzc.m8213o()) {
                this.zzc = (C1826rn) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    /* renamed from: cz.opentree.xn$e */
    /* loaded from: classes.dex */
    public enum e {

        /* renamed from: a */
        public static final int f8024a = 1;

        /* renamed from: b */
        public static final int f8025b = 2;

        /* renamed from: c */
        public static final int f8026c = 3;

        /* renamed from: d */
        public static final int f8027d = 4;

        /* renamed from: e */
        public static final int f8028e = 5;

        /* renamed from: f */
        public static final int f8029f = 6;

        /* renamed from: g */
        public static final int f8030g = 7;

        /* renamed from: h */
        public static final /* synthetic */ int[] f8031h = {1, 2, 3, 4, 5, 6, 7};

        /* renamed from: i */
        public static final int f8032i = 1;

        /* renamed from: j */
        public static final int f8033j = 2;

        /* renamed from: k */
        public static final int f8034k = 1;

        /* renamed from: l */
        public static final int f8035l = 2;

        /* renamed from: a */
        public static int[] m9848a() {
            return (int[]) f8031h.clone();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    /* renamed from: cz.opentree.xn$f */
    /* loaded from: classes.dex */
    public static class f<ContainingType extends zzgt, Type> extends C1516ln<ContainingType, Type> {
    }

    /* renamed from: A */
    public static zzfo m9829A() {
        return C0724ao.m2166g();
    }

    /* renamed from: B */
    public static zzfr m9830B() {
        return C1778qo.m7762g();
    }

    /* renamed from: C */
    public static <E> zzfq<E> m9831C() {
        return C1122hp.m4608h();
    }

    /* renamed from: o */
    public static <T extends AbstractC2303xn<?, ?>> T m9832o(Class<T> cls) {
        AbstractC2303xn<?, ?> abstractC2303xn = zzd.get(cls);
        if (abstractC2303xn == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC2303xn = zzd.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (abstractC2303xn == null) {
            abstractC2303xn = (T) ((AbstractC2303xn) C0841cq.m2919c(cls)).mo2132s(e.f8029f, null, null);
            if (abstractC2303xn == null) {
                throw new IllegalStateException();
            }
            zzd.put(cls, abstractC2303xn);
        }
        return (T) abstractC2303xn;
    }

    /* renamed from: q */
    public static <E> zzfq<E> m9833q(zzfq<E> zzfqVar) {
        int size = zzfqVar.size();
        return zzfqVar.mo1237c(size == 0 ? 10 : size << 1);
    }

    /* renamed from: r */
    public static zzfr m9834r(zzfr zzfrVar) {
        int size = zzfrVar.size();
        return zzfrVar.mo1237c(size == 0 ? 10 : size << 1);
    }

    /* renamed from: t */
    public static Object m9835t(zzgt zzgtVar, String str, Object[] objArr) {
        return new C1063gp(zzgtVar, str, objArr);
    }

    /* renamed from: u */
    public static Object m9836u(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* renamed from: v */
    public static <T extends AbstractC2303xn<?, ?>> void m9837v(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    /* renamed from: w */
    public static final <T extends AbstractC2303xn<T, ?>> boolean m9838w(T t, boolean z) {
        byte byteValue = ((Byte) t.mo2132s(e.f8024a, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean mo1274c = C1007fp.m3851a().m3853c(t).mo1274c(t);
        if (z) {
            t.mo2132s(e.f8025b, mo1274c ? t : null, null);
        }
        return mo1274c;
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    /* renamed from: b */
    public final /* synthetic */ zzgs mo1263b() {
        return (b) mo2132s(e.f8028e, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    /* renamed from: c */
    public final void mo1264c(AbstractC1116hn abstractC1116hn) throws IOException {
        C1007fp.m3851a().m3853c(this).mo1278g(this, C1228jn.m5172P(abstractC1116hn));
    }

    @Override // com.google.android.gms.internal.measurement.zzgv
    /* renamed from: d */
    public final boolean mo1268d() {
        return m9838w(this, true);
    }

    @Override // com.google.android.gms.internal.measurement.zzgv
    /* renamed from: e */
    public final /* synthetic */ zzgt mo1269e() {
        return (AbstractC2303xn) mo2132s(e.f8029f, null, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return C1007fp.m3851a().m3853c(this).mo1277f(this, (AbstractC2303xn) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int mo1273b = C1007fp.m3851a().m3853c(this).mo1273b(this);
        this.zza = mo1273b;
        return mo1273b;
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    /* renamed from: i */
    public final /* synthetic */ zzgs mo1266i() {
        b bVar = (b) mo2132s(e.f8028e, null, null);
        bVar.m9842o(this);
        return bVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    /* renamed from: j */
    public final int mo1267j() {
        if (this.zzc == -1) {
            this.zzc = C1007fp.m3851a().m3853c(this).mo1276e(this);
        }
        return this.zzc;
    }

    @Override // cz.opentree.AbstractC1464km
    /* renamed from: l */
    public final int mo5947l() {
        return this.zzc;
    }

    @Override // cz.opentree.AbstractC1464km
    /* renamed from: m */
    public final void mo5948m(int i) {
        this.zzc = i;
    }

    /* renamed from: s */
    public abstract Object mo2132s(int i, Object obj, Object obj2);

    public String toString() {
        return C2363yo.m10204a(this, super.toString());
    }

    /* renamed from: y */
    public final <MessageType extends AbstractC2303xn<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> BuilderType m9839y() {
        return (BuilderType) mo2132s(e.f8028e, null, null);
    }

    /* renamed from: z */
    public final BuilderType m9840z() {
        BuilderType buildertype = (BuilderType) mo2132s(e.f8028e, null, null);
        buildertype.m9842o(this);
        return buildertype;
    }
}
