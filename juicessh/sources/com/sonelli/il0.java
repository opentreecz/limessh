package com.sonelli;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.squareup.picasso.Callback;
import java.lang.ref.WeakReference;

/* compiled from: DeferredRequestCreator.java */
/* loaded from: classes.dex */
public class il0 implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: O */
    public final vl0 f3338O;

    /* renamed from: P */
    public final WeakReference<ImageView> f3339P;

    /* renamed from: Q */
    public Callback f3340Q;

    public il0(vl0 vl0Var, ImageView imageView, Callback callback) {
        this.f3338O = vl0Var;
        this.f3339P = new WeakReference<>(imageView);
        this.f3340Q = callback;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    /* renamed from: a */
    public void m4795a() {
        this.f3340Q = null;
        ImageView imageView = this.f3339P.get();
        if (imageView == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        ImageView imageView = this.f3339P.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0) {
            viewTreeObserver.removeOnPreDrawListener(this);
            vl0 vl0Var = this.f3338O;
            vl0Var.m9312j();
            vl0Var.m9310h(width, height);
            vl0Var.m9308f(imageView, this.f3340Q);
        }
        return true;
    }
}
