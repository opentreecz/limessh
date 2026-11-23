package com.sonelli;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.Container;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;
import com.google.android.gms.tagmanager.zzw;

/* loaded from: classes.dex */
public final class h60 implements ContainerHolder {

    /* renamed from: O */
    public Container f3107O;

    /* renamed from: P */
    public Status f3108P;

    /* renamed from: Q */
    public zzw f3109Q;

    /* renamed from: R */
    public boolean f3110R;

    /* renamed from: S */
    public TagManager f3111S;

    /* renamed from: a */
    public final String m4377a() {
        if (this.f3110R) {
            v50.m9168c("getContainerId called on a released ContainerHolder.");
            return "";
        }
        this.f3107O.m1519a();
        throw null;
    }

    /* renamed from: b */
    public final synchronized void m4378b() {
        if (this.f3110R) {
            v50.m9168c("Refreshing a released ContainerHolder.");
        } else {
            this.f3109Q.m1550b();
        }
    }

    /* renamed from: c */
    public final synchronized void m4379c(String str) {
        if (!this.f3110R) {
            this.f3107O.m1521c(str);
            throw null;
        }
    }

    /* renamed from: d */
    public final void m4380d(String str) {
        if (this.f3110R) {
            v50.m9168c("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.f3109Q.m1551c(str);
        }
    }

    /* renamed from: e */
    public final String m4381e() {
        if (!this.f3110R) {
            return this.f3109Q.m1549a();
        }
        v50.m9168c("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    @Override // com.google.android.gms.common.api.Result
    /* renamed from: n */
    public final Status mo991n() {
        return this.f3108P;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final synchronized void release() {
        if (!this.f3110R) {
            this.f3110R = true;
            this.f3111S.m1538e(this);
            this.f3107O.m1520b();
            throw null;
        }
        v50.m9168c("Releasing a released ContainerHolder.");
    }
}
