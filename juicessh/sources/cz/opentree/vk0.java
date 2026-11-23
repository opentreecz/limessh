package cz.opentree;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: CustomAlertBuilder.java */
/* loaded from: classes.dex */
public class vk0 extends AlertDialog.Builder {

    /* renamed from: O */
    public TextView f7493O;

    /* renamed from: P */
    public TextView f7494P;

    /* renamed from: Q */
    public Context f7495Q;

    /* renamed from: R */
    public Activity f7496R;

    public vk0(Context context) {
        super(context);
        this.f7493O = null;
        this.f7494P = null;
        try {
            this.f7496R = (Activity) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        this.f7495Q = context;
    }

    /* renamed from: a */
    public Activity m9291a() {
        return this.f7496R;
    }

    /* renamed from: e */
    public vk0 m9292e(int i) {
        if (kj0.f4580a < 11) {
            this.f7493O.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, R.drawable.divider_horizontal_bright);
            this.f7493O.setCompoundDrawablePadding(Math.round(TypedValue.applyDimension(1, 10.0f, this.f7495Q.getResources().getDisplayMetrics())));
        } else {
            super.setIcon(i);
        }
        return this;
    }

    /* renamed from: f */
    public vk0 m9293f(Drawable drawable) {
        if (kj0.f4580a < 11) {
            this.f7493O.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, this.f7495Q.getResources().getDrawable(R.drawable.divider_horizontal_bright));
            this.f7493O.setCompoundDrawablePadding(Math.round(TypedValue.applyDimension(1, 10.0f, this.f7495Q.getResources().getDisplayMetrics())));
        } else {
            super.setIcon(drawable);
        }
        return this;
    }

    /* renamed from: g */
    public vk0 m9294g(int i) {
        if (kj0.f4580a >= 11) {
            super.setMessage(i);
        } else if (this.f7495Q.getResources().getString(i).isEmpty()) {
            this.f7494P.setVisibility(8);
        } else {
            this.f7494P.setText(i);
            this.f7494P.setVisibility(0);
        }
        return this;
    }

    /* renamed from: h */
    public vk0 m9295h(CharSequence charSequence) {
        if (kj0.f4580a >= 11) {
            super.setMessage(charSequence);
        } else if (charSequence.length() > 0) {
            this.f7494P.setText(charSequence);
            this.f7494P.setVisibility(0);
        } else {
            this.f7494P.setVisibility(8);
        }
        return this;
    }

    /* renamed from: i */
    public vk0 m9296i(int i) {
        if (kj0.f4580a < 11) {
            this.f7493O.setText(i);
        } else {
            super.setTitle(i);
        }
        return this;
    }

    /* renamed from: j */
    public vk0 m9297j(CharSequence charSequence) {
        if (kj0.f4580a < 11) {
            this.f7493O.setText(charSequence);
        } else {
            super.setTitle(charSequence);
        }
        return this;
    }

    /* renamed from: k */
    public vk0 m9298k(View view) {
        if (kj0.f4580a < 11) {
            LinearLayout linearLayout = new LinearLayout(this.f7495Q);
            linearLayout.setOrientation(1);
            ((LinearLayout) this.f7494P.getParent()).removeView(this.f7494P);
            linearLayout.addView(this.f7494P);
            linearLayout.addView(view);
            super.setView(linearLayout);
        } else {
            super.setView(view);
        }
        return this;
    }

    @Override // android.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setIcon(int i) {
        m9292e(i);
        return this;
    }

    @Override // android.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setIcon(Drawable drawable) {
        m9293f(drawable);
        return this;
    }

    @Override // android.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setMessage(int i) {
        m9294g(i);
        return this;
    }

    @Override // android.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setMessage(CharSequence charSequence) {
        m9295h(charSequence);
        return this;
    }

    @Override // android.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setTitle(int i) {
        m9296i(i);
        return this;
    }

    @Override // android.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setTitle(CharSequence charSequence) {
        m9297j(charSequence);
        return this;
    }

    @Override // android.app.AlertDialog.Builder
    public /* bridge */ /* synthetic */ AlertDialog.Builder setView(View view) {
        m9298k(view);
        return this;
    }
}
