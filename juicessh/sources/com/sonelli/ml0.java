package com.sonelli;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/* compiled from: ImageViewAction.java */
/* loaded from: classes.dex */
public class ml0 extends dl0<ImageView> {

    /* renamed from: k */
    public Callback f5094k;

    public ml0(Picasso picasso, ImageView imageView, ul0 ul0Var, boolean z, boolean z2, int i, Drawable drawable, String str, Callback callback) {
        super(picasso, imageView, ul0Var, z, z2, i, drawable, str);
        this.f5094k = callback;
    }

    @Override // com.sonelli.dl0
    /* renamed from: a */
    public void mo3254a() {
        super.mo3254a();
        if (this.f5094k != null) {
            this.f5094k = null;
        }
    }

    @Override // com.sonelli.dl0
    /* renamed from: b */
    public void mo3255b(Bitmap bitmap, Picasso.EnumC2454d enumC2454d) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        }
        ImageView imageView = (ImageView) this.f2234c.get();
        if (imageView == null) {
            return;
        }
        Picasso picasso = this.f2232a;
        sl0.m8466c(imageView, picasso.f8623d, bitmap, enumC2454d, this.f2236e, picasso.f8630k);
        Callback callback = this.f5094k;
        if (callback != null) {
            callback.m10671d();
        }
    }

    @Override // com.sonelli.dl0
    /* renamed from: c */
    public void mo3256c() {
        ImageView imageView = (ImageView) this.f2234c.get();
        if (imageView == null) {
            return;
        }
        int i = this.f2237f;
        if (i != 0) {
            imageView.setImageResource(i);
        } else {
            Drawable drawable = this.f2238g;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
        }
        Callback callback = this.f5094k;
        if (callback != null) {
            callback.m10670a();
        }
    }
}
