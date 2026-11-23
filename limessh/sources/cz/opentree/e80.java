package cz.opentree;

import com.google.firebase.events.EventHandler;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class e80 implements Runnable {

    /* renamed from: O */
    public final Map.Entry f2344O;

    /* renamed from: P */
    public final dd0 f2345P;

    public e80(Map.Entry entry, dd0 dd0Var) {
        this.f2344O = entry;
        this.f2345P = dd0Var;
    }

    /* renamed from: a */
    public static Runnable m3457a(Map.Entry entry, dd0 dd0Var) {
        return new e80(entry, dd0Var);
    }

    @Override // java.lang.Runnable
    public void run() {
        ((EventHandler) this.f2344O.getKey()).mo1861a(this.f2345P);
    }
}
