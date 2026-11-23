package cz.opentree;

import java.io.IOException;
import okio.Sink;

/* compiled from: ForwardingSink.java */
/* loaded from: classes.dex */
public abstract class bp0 implements Sink {

    /* renamed from: O */
    public final Sink f1780O;

    public bp0(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f1780O = sink;
    }

    @Override // okio.Sink
    /* renamed from: F */
    public void mo2189F(zo0 zo0Var, long j) throws IOException {
        this.f1780O.mo2189F(zo0Var, j);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1780O.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.f1780O.flush();
    }

    @Override // okio.Sink
    /* renamed from: g */
    public mp0 mo2190g() {
        return this.f1780O.mo2190g();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f1780O.toString() + ")";
    }
}
