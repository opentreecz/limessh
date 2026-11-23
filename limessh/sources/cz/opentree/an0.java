package cz.opentree;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import javax.annotation.Nullable;
import okio.BufferedSource;

/* compiled from: ResponseBody.java */
/* loaded from: classes.dex */
public abstract class an0 implements Closeable {

    /* compiled from: ResponseBody.java */
    /* renamed from: cz.opentree.an0$a */
    /* loaded from: classes.dex */
    public class C0723a extends an0 {

        /* renamed from: O */
        public final /* synthetic */ sm0 f1454O;

        /* renamed from: P */
        public final /* synthetic */ long f1455P;

        /* renamed from: Q */
        public final /* synthetic */ BufferedSource f1456Q;

        public C0723a(sm0 sm0Var, long j, BufferedSource bufferedSource) {
            this.f1454O = sm0Var;
            this.f1455P = j;
            this.f1456Q = bufferedSource;
        }

        @Override // cz.opentree.an0
        /* renamed from: b */
        public long mo2162b() {
            return this.f1455P;
        }

        @Override // cz.opentree.an0
        @Nullable
        /* renamed from: c */
        public sm0 mo2163c() {
            return this.f1454O;
        }

        @Override // cz.opentree.an0
        /* renamed from: h */
        public BufferedSource mo2164h() {
            return this.f1456Q;
        }
    }

    /* renamed from: d */
    public static an0 m2159d(@Nullable sm0 sm0Var, long j, BufferedSource bufferedSource) {
        Objects.requireNonNull(bufferedSource, "source == null");
        return new C0723a(sm0Var, j, bufferedSource);
    }

    /* renamed from: f */
    public static an0 m2160f(@Nullable sm0 sm0Var, byte[] bArr) {
        zo0 zo0Var = new zo0();
        zo0Var.m10562k0(bArr);
        return m2159d(sm0Var, bArr.length, zo0Var);
    }

    /* renamed from: a */
    public final Charset m2161a() {
        sm0 mo2163c = mo2163c();
        return mo2163c != null ? mo2163c.m8472b(fn0.f2730i) : fn0.f2730i;
    }

    /* renamed from: b */
    public abstract long mo2162b();

    @Nullable
    /* renamed from: c */
    public abstract sm0 mo2163c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        fn0.m3826g(mo2164h());
    }

    /* renamed from: h */
    public abstract BufferedSource mo2164h();

    /* renamed from: l */
    public final String m2165l() throws IOException {
        BufferedSource mo2164h = mo2164h();
        try {
            return mo2164h.mo4894C(fn0.m3822c(mo2164h, m2161a()));
        } finally {
            fn0.m3826g(mo2164h);
        }
    }
}
