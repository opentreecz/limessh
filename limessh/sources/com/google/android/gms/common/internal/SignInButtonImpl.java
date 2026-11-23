package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.base.R$color;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.base.R$string;
import cz.opentree.C0813ca;
import cz.opentree.C0981fc;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class SignInButtonImpl extends Button {
    public SignInButtonImpl(Context context) {
        this(context, null);
    }

    public SignInButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.buttonStyle);
    }

    /* renamed from: b */
    public static int m1137b(int i, int i2, int i3, int i4) {
        if (i == 0) {
            return i2;
        }
        if (i == 1) {
            return i3;
        }
        if (i == 2) {
            return i4;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("Unknown color scheme: ");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public final void m1138a(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i3 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i3);
        setMinWidth(i3);
        int i4 = R$drawable.common_google_signin_btn_icon_dark;
        int i5 = R$drawable.common_google_signin_btn_icon_light;
        int m1137b = m1137b(i2, i4, i5, i5);
        int i6 = R$drawable.common_google_signin_btn_text_dark;
        int i7 = R$drawable.common_google_signin_btn_text_light;
        int m1137b2 = m1137b(i2, i6, i7, i7);
        if (i == 0 || i == 1) {
            m1137b = m1137b2;
        } else if (i != 2) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Unknown button size: ");
            sb.append(i);
            throw new IllegalStateException(sb.toString());
        }
        Drawable wrap = DrawableCompat.wrap(resources.getDrawable(m1137b));
        DrawableCompat.setTintList(wrap, resources.getColorStateList(R$color.common_google_signin_btn_tint));
        DrawableCompat.setTintMode(wrap, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(wrap);
        int i8 = R$color.common_google_signin_btn_text_dark;
        int i9 = R$color.common_google_signin_btn_text_light;
        ColorStateList colorStateList = resources.getColorStateList(m1137b(i2, i8, i9, i9));
        C0813ca.m2729k(colorStateList);
        setTextColor(colorStateList);
        if (i == 0) {
            setText(resources.getString(R$string.common_signin_button_text));
        } else if (i == 1) {
            setText(resources.getString(R$string.common_signin_button_text_long));
        } else {
            if (i != 2) {
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Unknown button size: ");
                sb2.append(i);
                throw new IllegalStateException(sb2.toString());
            }
            setText((CharSequence) null);
        }
        setTransformationMethod(null);
        if (C0981fc.m3711b(getContext())) {
            setGravity(19);
        }
    }
}
