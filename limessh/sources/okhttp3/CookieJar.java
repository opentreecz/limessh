package okhttp3;

import cz.opentree.nm0;
import cz.opentree.rm0;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public interface CookieJar {

    /* renamed from: a */
    public static final CookieJar f8652a = new C2482a();

    /* renamed from: okhttp3.CookieJar$a */
    /* loaded from: classes.dex */
    public class C2482a implements CookieJar {
        @Override // okhttp3.CookieJar
        /* renamed from: a */
        public void mo10696a(rm0 rm0Var, List<nm0> list) {
        }

        @Override // okhttp3.CookieJar
        /* renamed from: b */
        public List<nm0> mo10697b(rm0 rm0Var) {
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    void mo10696a(rm0 rm0Var, List<nm0> list);

    /* renamed from: b */
    List<nm0> mo10697b(rm0 rm0Var);
}
