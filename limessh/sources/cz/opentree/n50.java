package cz.opentree;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.zzaq;
import java.util.List;

/* loaded from: classes.dex */
public final class n50 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzaq f5233O;

    /* renamed from: P */
    public final /* synthetic */ l50 f5234P;

    public n50(l50 l50Var, zzaq zzaqVar) {
        this.f5234P = l50Var;
        this.f5233O = zzaqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<DataLayer.C0453a> m6077j;
        zzaq zzaqVar = this.f5233O;
        m6077j = this.f5234P.m6077j();
        zzaqVar.mo1540a(m6077j);
    }
}
