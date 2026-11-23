package com.sonelli;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/* compiled from: TargetAction.java */
/* loaded from: classes.dex */
public final class zl0 extends dl0<Target> {
    public zl0(Picasso picasso, Target target, ul0 ul0Var, boolean z, int i, Drawable drawable, String str) {
        super(picasso, target, ul0Var, z, false, i, drawable, str);
    }

    @Override // com.sonelli.dl0
    /* renamed from: b */
    public void mo3255b(Bitmap bitmap, Picasso.EnumC2454d enumC2454d) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        }
        Target m3260g = m3260g();
        if (m3260g != null) {
            m3260g.mo5661c(bitmap, enumC2454d);
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Target callback must not recycle bitmap!");
            }
        }
    }

    @Override // com.sonelli.dl0
    /* renamed from: c */
    public void mo3256c() {
        Target m3260g = m3260g();
        if (m3260g != null) {
            if (this.f2237f != 0) {
                m3260g.mo5659a(this.f2232a.f8623d.getResources().getDrawable(this.f2237f));
            } else {
                m3260g.mo5659a(this.f2238g);
            }
        }
    }
}
