package okhttp3.internal.http2;

import com.sonelli.co0;
import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

/* loaded from: classes.dex */
public interface PushObserver {

    /* renamed from: a */
    public static final PushObserver f8676a = new C2487a();

    /* renamed from: okhttp3.internal.http2.PushObserver$a */
    /* loaded from: classes.dex */
    public class C2487a implements PushObserver {
        @Override // okhttp3.internal.http2.PushObserver
        /* renamed from: a */
        public boolean mo10746a(int i, List<Header> list) {
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        /* renamed from: b */
        public boolean mo10747b(int i, List<Header> list, boolean z) {
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        /* renamed from: c */
        public void mo10748c(int i, co0 co0Var) {
        }

        @Override // okhttp3.internal.http2.PushObserver
        /* renamed from: d */
        public boolean mo10749d(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
            bufferedSource.skip(i2);
            return true;
        }
    }

    /* renamed from: a */
    boolean mo10746a(int i, List<Header> list);

    /* renamed from: b */
    boolean mo10747b(int i, List<Header> list, boolean z);

    /* renamed from: c */
    void mo10748c(int i, co0 co0Var);

    /* renamed from: d */
    boolean mo10749d(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException;
}
