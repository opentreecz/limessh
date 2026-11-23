package okhttp3;

import cz.opentree.xm0;
import cz.opentree.zm0;
import java.io.IOException;

/* loaded from: classes.dex */
public interface Interceptor {

    /* loaded from: classes.dex */
    public interface Chain {
        /* renamed from: a */
        int mo9316a();

        /* renamed from: b */
        int mo9317b();

        /* renamed from: c */
        zm0 mo9318c(xm0 xm0Var) throws IOException;

        /* renamed from: d */
        int mo9319d();

        /* renamed from: e */
        xm0 mo9320e();
    }

    /* renamed from: a */
    zm0 mo4577a(Chain chain) throws IOException;
}
