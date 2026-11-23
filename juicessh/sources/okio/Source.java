package okio;

import com.sonelli.mp0;
import com.sonelli.zo0;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes.dex */
public interface Source extends Closeable {
    /* renamed from: R */
    long mo2186R(zo0 zo0Var, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    /* renamed from: g */
    mp0 mo2188g();
}
