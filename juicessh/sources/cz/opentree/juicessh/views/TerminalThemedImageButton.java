package cz.opentree.juicessh.views;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageButton;

/* loaded from: classes.dex */
public class TerminalThemedImageButton extends AppCompatImageButton {

    /* renamed from: O */
    public Context f4330O;

    /* renamed from: P */
    public int f4331P;

    public TerminalThemedImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4330O = context;
        this.f4331P = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "src", 0);
    }

    /* renamed from: a */
    public void m5693a(int i, int i2, int i3) {
        if (getBackground() instanceof StateListDrawable) {
            if (this.f4331P > 0) {
                Drawable drawable = Build.VERSION.SDK_INT >= 21 ? getResources().getDrawable(this.f4331P, this.f4330O.getTheme()) : getResources().getDrawable(this.f4331P);
                drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
                setImageDrawable(drawable);
            }
            Drawable[] children = ((DrawableContainer.DrawableContainerState) ((StateListDrawable) getBackground()).getConstantState()).getChildren();
            GradientDrawable gradientDrawable = (GradientDrawable) children[0];
            GradientDrawable gradientDrawable2 = (GradientDrawable) children[1];
            gradientDrawable.setColor(i2);
            gradientDrawable2.setColor(i3);
        }
    }
}
