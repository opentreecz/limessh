package com.sonelli;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.google.android.gms.tagmanager.TagManager;

/* loaded from: classes.dex */
public final class f60 implements ComponentCallbacks2 {

    /* renamed from: O */
    public final /* synthetic */ TagManager f2623O;

    public f60(TagManager tagManager) {
        this.f2623O = tagManager;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20) {
            this.f2623O.m1536a();
        }
    }
}
