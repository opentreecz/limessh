package cz.opentree;

import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class is0 extends InputStream {

    /* renamed from: O */
    public final InputStream f3405O;

    /* renamed from: P */
    public int f3406P;

    public is0(InputStream inputStream, int i) {
        this.f3405O = inputStream;
        this.f3406P = i;
    }

    /* renamed from: a */
    public int m4916a() {
        return this.f3406P;
    }

    /* renamed from: b */
    public void m4917b(boolean z) {
        InputStream inputStream = this.f3405O;
        if (inputStream instanceof fs0) {
            ((fs0) inputStream).m3877d(z);
        }
    }
}
