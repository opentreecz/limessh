package com.sonelli;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import okio.BufferedSource;
import okio.Source;

/* compiled from: InflaterSource.java */
/* loaded from: classes.dex */
public final class fp0 implements Source {

    /* renamed from: O */
    public final BufferedSource f2755O;

    /* renamed from: P */
    public final Inflater f2756P;

    /* renamed from: Q */
    public int f2757Q;

    /* renamed from: R */
    public boolean f2758R;

    public fp0(BufferedSource bufferedSource, Inflater inflater) {
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f2755O = bufferedSource;
        this.f2756P = inflater;
    }

    @Override // okio.Source
    /* renamed from: R */
    public long mo2186R(zo0 zo0Var, long j) throws IOException {
        boolean m3854a;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f2758R) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            m3854a = m3854a();
            try {
                jp0 m10560i0 = zo0Var.m10560i0(1);
                int inflate = this.f2756P.inflate(m10560i0.f3638a, m10560i0.f3640c, (int) Math.min(j, 8192 - m10560i0.f3640c));
                if (inflate > 0) {
                    m10560i0.f3640c += inflate;
                    long j2 = inflate;
                    zo0Var.f8573P += j2;
                    return j2;
                }
                if (!this.f2756P.finished() && !this.f2756P.needsDictionary()) {
                }
                m3855b();
                if (m10560i0.f3639b != m10560i0.f3640c) {
                    return -1L;
                }
                zo0Var.f8572O = m10560i0.m5182b();
                kp0.m5987a(m10560i0);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!m3854a);
        throw new EOFException("source exhausted prematurely");
    }

    /* renamed from: a */
    public final boolean m3854a() throws IOException {
        if (!this.f2756P.needsInput()) {
            return false;
        }
        m3855b();
        if (this.f2756P.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f2755O.mo4907s()) {
            return true;
        }
        jp0 jp0Var = this.f2755O.mo4905e().f8572O;
        int i = jp0Var.f3640c;
        int i2 = jp0Var.f3639b;
        int i3 = i - i2;
        this.f2757Q = i3;
        this.f2756P.setInput(jp0Var.f3638a, i2, i3);
        return false;
    }

    /* renamed from: b */
    public final void m3855b() throws IOException {
        int i = this.f2757Q;
        if (i == 0) {
            return;
        }
        int remaining = i - this.f2756P.getRemaining();
        this.f2757Q -= remaining;
        this.f2755O.skip(remaining);
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f2758R) {
            return;
        }
        this.f2756P.end();
        this.f2758R = true;
        this.f2755O.close();
    }

    @Override // okio.Source
    /* renamed from: g */
    public mp0 mo2188g() {
        return this.f2755O.mo2188g();
    }
}
