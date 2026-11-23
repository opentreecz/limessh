package com.sonelli;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import javax.annotation.Nullable;
import okio.BufferedSink;
import okio.Source;

/* compiled from: RequestBody.java */
/* loaded from: classes.dex */
public abstract class ym0 {

    /* compiled from: RequestBody.java */
    /* renamed from: com.sonelli.ym0$a */
    /* loaded from: classes.dex */
    public class C2360a extends ym0 {

        /* renamed from: a */
        public final /* synthetic */ sm0 f8277a;

        /* renamed from: b */
        public final /* synthetic */ int f8278b;

        /* renamed from: c */
        public final /* synthetic */ byte[] f8279c;

        /* renamed from: d */
        public final /* synthetic */ int f8280d;

        public C2360a(sm0 sm0Var, int i, byte[] bArr, int i2) {
            this.f8277a = sm0Var;
            this.f8278b = i;
            this.f8279c = bArr;
            this.f8280d = i2;
        }

        @Override // com.sonelli.ym0
        /* renamed from: a */
        public long mo8770a() {
            return this.f8278b;
        }

        @Override // com.sonelli.ym0
        @Nullable
        /* renamed from: b */
        public sm0 mo8771b() {
            return this.f8277a;
        }

        @Override // com.sonelli.ym0
        /* renamed from: g */
        public void mo8772g(BufferedSink bufferedSink) throws IOException {
            bufferedSink.mo4612E(this.f8279c, this.f8280d, this.f8278b);
        }
    }

    /* compiled from: RequestBody.java */
    /* renamed from: com.sonelli.ym0$b */
    /* loaded from: classes.dex */
    public class C2361b extends ym0 {

        /* renamed from: a */
        public final /* synthetic */ sm0 f8281a;

        /* renamed from: b */
        public final /* synthetic */ File f8282b;

        public C2361b(sm0 sm0Var, File file) {
            this.f8281a = sm0Var;
            this.f8282b = file;
        }

        @Override // com.sonelli.ym0
        /* renamed from: a */
        public long mo8770a() {
            return this.f8282b.length();
        }

        @Override // com.sonelli.ym0
        @Nullable
        /* renamed from: b */
        public sm0 mo8771b() {
            return this.f8281a;
        }

        @Override // com.sonelli.ym0
        /* renamed from: g */
        public void mo8772g(BufferedSink bufferedSink) throws IOException {
            Source source = null;
            try {
                source = gp0.m4232f(this.f8282b);
                bufferedSink.mo4613G(source);
            } finally {
                fn0.m3826g(source);
            }
        }
    }

    /* renamed from: c */
    public static ym0 m10190c(@Nullable sm0 sm0Var, File file) {
        Objects.requireNonNull(file, "file == null");
        return new C2361b(sm0Var, file);
    }

    /* renamed from: d */
    public static ym0 m10191d(@Nullable sm0 sm0Var, String str) {
        Charset charset = fn0.f2730i;
        if (sm0Var != null) {
            Charset m8471a = sm0Var.m8471a();
            if (m8471a == null) {
                sm0Var = sm0.m8470d(sm0Var + "; charset=utf-8");
            } else {
                charset = m8471a;
            }
        }
        return m10192e(sm0Var, str.getBytes(charset));
    }

    /* renamed from: e */
    public static ym0 m10192e(@Nullable sm0 sm0Var, byte[] bArr) {
        return m10193f(sm0Var, bArr, 0, bArr.length);
    }

    /* renamed from: f */
    public static ym0 m10193f(@Nullable sm0 sm0Var, byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "content == null");
        fn0.m3825f(bArr.length, i, i2);
        return new C2360a(sm0Var, i2, bArr, i);
    }

    /* renamed from: a */
    public abstract long mo8770a() throws IOException;

    @Nullable
    /* renamed from: b */
    public abstract sm0 mo8771b();

    /* renamed from: g */
    public abstract void mo8772g(BufferedSink bufferedSink) throws IOException;
}
