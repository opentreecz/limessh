package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.base.R$styleable;
import com.google.android.gms.common.internal.SignInButtonImpl;
import cz.opentree.AbstractC1600nd;
import cz.opentree.C0865da;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* renamed from: O */
    public int f716O;

    /* renamed from: P */
    public int f717P;

    /* renamed from: Q */
    public View f718Q;

    /* renamed from: R */
    public View.OnClickListener f719R;

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f719R = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SignInButton, 0, 0);
        try {
            this.f716O = obtainStyledAttributes.getInt(R$styleable.SignInButton_buttonSize, 0);
            this.f717P = obtainStyledAttributes.getInt(R$styleable.SignInButton_colorScheme, 2);
            obtainStyledAttributes.recycle();
            m959b(this.f716O, this.f717P);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* renamed from: a */
    public final void m958a(int i) {
        m959b(i, this.f717P);
    }

    /* renamed from: b */
    public final void m959b(int i, int i2) {
        this.f716O = i;
        this.f717P = i2;
        Context context = getContext();
        View view = this.f718Q;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f718Q = C0865da.m3167c(context, this.f716O, this.f717P);
        } catch (AbstractC1600nd.a unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i3 = this.f716O;
            int i4 = this.f717P;
            SignInButtonImpl signInButtonImpl = new SignInButtonImpl(context);
            signInButtonImpl.m1138a(context.getResources(), i3, i4);
            this.f718Q = signInButtonImpl;
        }
        addView(this.f718Q);
        this.f718Q.setEnabled(isEnabled());
        this.f718Q.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.f719R;
        if (onClickListener == null || view != this.f718Q) {
            return;
        }
        onClickListener.onClick(this);
    }

    @Override // android.view.View
    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f718Q.setEnabled(z);
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.f719R = onClickListener;
        View view = this.f718Q;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }
}
