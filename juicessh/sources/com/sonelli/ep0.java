package com.sonelli;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import okio.BufferedSource;
import okio.Source;

/* compiled from: GzipSource.java */
/* loaded from: classes.dex */
public final class ep0 implements Source {

    /* renamed from: P */
    public final BufferedSource f2522P;

    /* renamed from: Q */
    public final Inflater f2523Q;

    /* renamed from: R */
    public final fp0 f2524R;

    /* renamed from: O */
    public int f2521O = 0;

    /* renamed from: S */
    public final CRC32 f2525S = new CRC32();

    public ep0(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.f2523Q = inflater;
        BufferedSource m4228b = gp0.m4228b(source);
        this.f2522P = m4228b;
        this.f2524R = new fp0(m4228b, inflater);
    }

    @Override // okio.Source
    /* renamed from: R */
    public long mo2186R(zo0 zo0Var, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f2521O == 0) {
            m3543b();
            this.f2521O = 1;
        }
        if (this.f2521O == 1) {
            long j2 = zo0Var.f8573P;
            long mo2186R = this.f2524R.mo2186R(zo0Var, j);
            if (mo2186R != -1) {
                m3545d(zo0Var, j2, mo2186R);
                return mo2186R;
            }
            this.f2521O = 2;
        }
        if (this.f2521O == 2) {
            m3544c();
            this.f2521O = 3;
            if (!this.f2522P.mo4907s()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    /* renamed from: a */
    public final void m3542a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    /* renamed from: b */
    public final void m3543b() throws IOException {
        this.f2522P.mo4899U(10L);
        byte m10575z = this.f2522P.mo4905e().m10575z(3L);
        boolean z = ((m10575z >> 1) & 1) == 1;
        if (z) {
            m3545d(this.f2522P.mo4905e(), 0L, 10L);
        }
        m3542a("ID1ID2", 8075, this.f2522P.readShort());
        this.f2522P.skip(8L);
        if (((m10575z >> 2) & 1) == 1) {
            this.f2522P.mo4899U(2L);
            if (z) {
                m3545d(this.f2522P.mo4905e(), 0L, 2L);
            }
            long mo4898P = this.f2522P.mo4905e().mo4898P();
            this.f2522P.mo4899U(mo4898P);
            if (z) {
                m3545d(this.f2522P.mo4905e(), 0L, mo4898P);
            }
            this.f2522P.skip(mo4898P);
        }
        if (((m10575z >> 3) & 1) == 1) {
            long mo4900W = this.f2522P.mo4900W((byte) 0);
            if (mo4900W == -1) {
                throw new EOFException();
            }
            if (z) {
                m3545d(this.f2522P.mo4905e(), 0L, mo4900W + 1);
            }
            this.f2522P.skip(mo4900W + 1);
        }
        if (((m10575z >> 4) & 1) == 1) {
            long mo4900W2 = this.f2522P.mo4900W((byte) 0);
            if (mo4900W2 == -1) {
                throw new EOFException();
            }
            if (z) {
                m3545d(this.f2522P.mo4905e(), 0L, mo4900W2 + 1);
            }
            this.f2522P.skip(mo4900W2 + 1);
        }
        if (z) {
            m3542a("FHCRC", this.f2522P.mo4898P(), (short) this.f2525S.getValue());
            this.f2525S.reset();
        }
    }

    /* renamed from: c */
    public final void m3544c() throws IOException {
        m3542a("CRC", this.f2522P.mo4896J(), (int) this.f2525S.getValue());
        m3542a("ISIZE", this.f2522P.mo4896J(), (int) this.f2523Q.getBytesWritten());
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2524R.close();
    }

    /* renamed from: d */
    public final void m3545d(zo0 zo0Var, long j, long j2) {
        jp0 jp0Var = zo0Var.f8572O;
        while (true) {
            int i = jp0Var.f3640c;
            int i2 = jp0Var.f3639b;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            jp0Var = jp0Var.f3643f;
        }
        while (j2 > 0) {
            int min = (int) Math.min(jp0Var.f3640c - r6, j2);
            this.f2525S.update(jp0Var.f3638a, (int) (jp0Var.f3639b + j), min);
            j2 -= min;
            jp0Var = jp0Var.f3643f;
            j = 0;
        }
    }

    @Override // okio.Source
    /* renamed from: g */
    public mp0 mo2188g() {
        return this.f2522P.mo2188g();
    }
}
