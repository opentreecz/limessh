package com.sonelli;

import android.content.Context;
import com.google.android.gms.tagmanager.zzd;
import com.sonelli.C1688p3;
import java.io.IOException;

/* loaded from: classes.dex */
public final class q50 implements zzd {

    /* renamed from: a */
    public final /* synthetic */ j50 f5940a;

    public q50(j50 j50Var) {
        this.f5940a = j50Var;
    }

    @Override // com.google.android.gms.tagmanager.zzd
    /* renamed from: a */
    public final C1688p3.a mo1543a() {
        Context context;
        try {
            context = this.f5940a.f3494c;
            return C1688p3.m7230b(context);
        } catch (C0697a7 e) {
            v50.m9170e("GooglePlayServicesRepairableException getting Advertising Id Info", e);
            return null;
        } catch (C2413z6 e2) {
            this.f5940a.m5060a();
            v50.m9170e("GooglePlayServicesNotAvailableException getting Advertising Id Info", e2);
            return null;
        } catch (IOException e3) {
            v50.m9170e("IOException getting Ad Id Info", e3);
            return null;
        } catch (IllegalStateException e4) {
            v50.m9170e("IllegalStateException getting Advertising Id Info", e4);
            return null;
        } catch (Exception e5) {
            v50.m9170e("Unknown exception. Could not get the Advertising Id Info.", e5);
            return null;
        }
    }
}
