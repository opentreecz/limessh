package cz.opentree;

import java.io.IOException;
import okio.Source;

/* compiled from: ForwardingSource.java */
/* loaded from: classes.dex */
public abstract class cp0 implements Source {

    /* renamed from: O */
    public final Source f2025O;

    public cp0(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f2025O = source;
    }

    /* renamed from: a */
    public final Source m2901a() {
        return this.f2025O;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2025O.close();
    }

    @Override // okio.Source
    /* renamed from: g */
    public mp0 mo2188g() {
        return this.f2025O.mo2188g();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f2025O.toString() + ")";
    }
}
