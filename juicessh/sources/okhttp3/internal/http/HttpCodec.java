package okhttp3.internal.http;

import com.sonelli.an0;
import com.sonelli.xm0;
import com.sonelli.zm0;
import java.io.IOException;
import okio.Sink;

/* loaded from: classes.dex */
public interface HttpCodec {
    /* renamed from: a */
    void mo2171a() throws IOException;

    /* renamed from: b */
    void mo2172b(xm0 xm0Var) throws IOException;

    /* renamed from: c */
    an0 mo2173c(zm0 zm0Var) throws IOException;

    void cancel();

    /* renamed from: d */
    zm0.C2434a mo2174d(boolean z) throws IOException;

    /* renamed from: e */
    void mo2175e() throws IOException;

    /* renamed from: f */
    Sink mo2176f(xm0 xm0Var, long j);
}
