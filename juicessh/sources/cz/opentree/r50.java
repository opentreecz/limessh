package cz.opentree;

import android.util.Log;
import com.google.android.gms.tagmanager.zzdj;

/* loaded from: classes.dex */
public final class r50 implements zzdj {

    /* renamed from: a */
    public int f6185a = 5;

    @Override // com.google.android.gms.tagmanager.zzdj
    /* renamed from: a */
    public final void mo1544a(String str) {
        if (this.f6185a <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzdj
    /* renamed from: b */
    public final void mo1545b(String str) {
        if (this.f6185a <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzdj
    /* renamed from: c */
    public final void mo1546c(String str) {
        if (this.f6185a <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzdj
    /* renamed from: d */
    public final void mo1547d(String str) {
        if (this.f6185a <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzdj
    /* renamed from: e */
    public final void mo1548e(String str, Throwable th) {
        if (this.f6185a <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }
}
