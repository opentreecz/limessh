package cz.opentree.limessh.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class TerminalThemedButton extends UnswipableButton {

    /* renamed from: Q */
    public int f4327Q;

    /* renamed from: R */
    public int f4328R;

    /* renamed from: S */
    public int f4329S;

    public TerminalThemedButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4329S = 0;
    }

    /* renamed from: c */
    public void m5691c(int i, int i2, int i3) {
        if (getBackground() instanceof StateListDrawable) {
            this.f4327Q = i2;
            this.f4328R = i3;
            setTextColor(i);
            Drawable[] children = ((DrawableContainer.DrawableContainerState) ((StateListDrawable) getBackground()).getConstantState()).getChildren();
            GradientDrawable gradientDrawable = (GradientDrawable) children[0];
            GradientDrawable gradientDrawable2 = (GradientDrawable) children[1];
            gradientDrawable.setColor(i2);
            gradientDrawable2.setColor(i3);
        }
    }

    /* renamed from: d */
    public void m5692d(int i) {
        if (this.f4329S == i) {
            return;
        }
        Drawable[] children = ((DrawableContainer.DrawableContainerState) ((StateListDrawable) getBackground()).getConstantState()).getChildren();
        GradientDrawable gradientDrawable = (GradientDrawable) children[0];
        GradientDrawable gradientDrawable2 = (GradientDrawable) children[1];
        if (i == 1) {
            gradientDrawable.setColor(this.f4328R);
            gradientDrawable2.setColor(this.f4327Q);
            this.f4329S = 1;
        } else {
            gradientDrawable.setColor(this.f4327Q);
            gradientDrawable2.setColor(this.f4328R);
            this.f4329S = 0;
        }
    }
}
