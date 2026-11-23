package okio;

import cz.opentree.mp0;
import cz.opentree.zo0;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* loaded from: classes.dex */
public interface Sink extends Closeable, Flushable {
    /* renamed from: F */
    void mo2189F(zo0 zo0Var, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;

    /* renamed from: g */
    mp0 mo2190g();
}
