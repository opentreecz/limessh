package com.sonelli.juicessh.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sonelli.juicessh.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/* loaded from: classes.dex */
public class CardListItem implements Target {

    /* renamed from: a */
    public int f4295a;

    /* renamed from: b */
    public View f4296b;

    /* renamed from: c */
    public TextView f4297c;

    /* renamed from: d */
    public TextView f4298d;

    /* renamed from: e */
    public TextView f4299e;

    /* renamed from: f */
    public ImageView f4300f;

    /* renamed from: g */
    public LinearLayout f4301g;

    /* renamed from: h */
    public Button f4302h;

    /* renamed from: i */
    public View f4303i;

    /* renamed from: j */
    public ImageView f4304j;

    /* renamed from: k */
    public Context f4305k;

    /* loaded from: classes.dex */
    public interface OnClickListener {
        /* renamed from: g */
        void mo2526g(int i);
    }

    /* renamed from: com.sonelli.juicessh.views.CardListItem$a */
    /* loaded from: classes.dex */
    public class RunnableC1392a implements Runnable {
        public RunnableC1392a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CardListItem.this.f4300f.setVisibility(8);
        }
    }

    /* renamed from: com.sonelli.juicessh.views.CardListItem$b */
    /* loaded from: classes.dex */
    public class RunnableC1393b implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ int f4307O;

        public RunnableC1393b(int i) {
            this.f4307O = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            CardListItem.this.f4299e.setVisibility(0);
            CardListItem cardListItem = CardListItem.this;
            cardListItem.f4299e.setText(cardListItem.f4305k.getString(this.f4307O));
        }
    }

    /* renamed from: com.sonelli.juicessh.views.CardListItem$c */
    /* loaded from: classes.dex */
    public class RunnableC1394c implements Runnable {
        public RunnableC1394c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CardListItem.this.f4299e.setVisibility(8);
        }
    }

    /* renamed from: com.sonelli.juicessh.views.CardListItem$d */
    /* loaded from: classes.dex */
    public class RunnableC1395d implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ Bitmap f4310O;

        public RunnableC1395d(Bitmap bitmap) {
            this.f4310O = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            CardListItem.this.f4300f.setVisibility(0);
            CardListItem.this.f4300f.setImageBitmap(this.f4310O);
        }
    }

    /* renamed from: com.sonelli.juicessh.views.CardListItem$e */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1396e implements View.OnClickListener {

        /* renamed from: O */
        public final /* synthetic */ OnClickListener f4312O;

        public ViewOnClickListenerC1396e(OnClickListener onClickListener) {
            this.f4312O = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnClickListener onClickListener = this.f4312O;
            if (onClickListener != null) {
                onClickListener.mo2526g(CardListItem.this.f4295a);
            }
        }
    }

    public CardListItem(Context context, int i) {
        this(context, i, R.layout.card_list_item);
    }

    public CardListItem(Context context, int i, int i2) {
        this.f4305k = context;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f4295a = i;
        View inflate = layoutInflater.inflate(i2, (ViewGroup) null);
        this.f4296b = inflate;
        this.f4297c = (TextView) inflate.findViewById(R.id.itemTitle);
        this.f4298d = (TextView) this.f4296b.findViewById(R.id.itemSubtitle);
        this.f4299e = (TextView) this.f4296b.findViewById(R.id.itemTextIcon);
        this.f4300f = (ImageView) this.f4296b.findViewById(R.id.itemImageIcon);
        this.f4301g = (LinearLayout) this.f4296b.findViewById(R.id.itemContent);
        this.f4302h = (Button) this.f4296b.findViewById(R.id.button1);
        this.f4303i = this.f4296b.findViewById(R.id.button1_divider);
        this.f4304j = (ImageView) this.f4296b.findViewById(R.id.banner);
        this.f4299e.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/fontawesome-webfont.ttf"));
    }

    @Override // com.squareup.picasso.Target
    /* renamed from: a */
    public void mo5659a(Drawable drawable) {
    }

    @Override // com.squareup.picasso.Target
    /* renamed from: b */
    public void mo5660b(Drawable drawable) {
    }

    @Override // com.squareup.picasso.Target
    /* renamed from: c */
    public void mo5661c(Bitmap bitmap, Picasso.EnumC2454d enumC2454d) {
        m5675q(bitmap);
    }

    /* renamed from: d */
    public void m5662d(View view) {
        if (view == null) {
            this.f4301g.setVisibility(8);
        } else {
            this.f4301g.setVisibility(0);
            this.f4301g.addView(view, 0);
        }
    }

    /* renamed from: e */
    public View m5663e() {
        return this.f4301g;
    }

    /* renamed from: f */
    public ImageView m5664f() {
        return this.f4300f;
    }

    /* renamed from: g */
    public View m5665g() {
        return this.f4299e;
    }

    /* renamed from: h */
    public int m5666h() {
        return this.f4295a;
    }

    /* renamed from: i */
    public TextView m5667i() {
        return this.f4298d;
    }

    /* renamed from: j */
    public View m5668j() {
        return this.f4296b;
    }

    /* renamed from: k */
    public void m5669k() {
        this.f4296b.setVisibility(8);
    }

    /* renamed from: l */
    public void m5670l(boolean z) {
        if (z) {
            this.f4304j.setVisibility(0);
        } else {
            this.f4304j.setVisibility(8);
        }
    }

    /* renamed from: m */
    public void m5671m(View.OnClickListener onClickListener) {
        this.f4302h.setOnClickListener(onClickListener);
    }

    /* renamed from: n */
    public void m5672n(String str) {
        if (str == null) {
            this.f4302h.setVisibility(8);
            this.f4303i.setVisibility(8);
        } else {
            this.f4302h.setText(str);
            this.f4302h.setVisibility(0);
            this.f4303i.setVisibility(0);
        }
    }

    /* renamed from: o */
    public void m5673o(View view) {
        this.f4301g.removeAllViews();
        m5662d(view);
    }

    /* renamed from: p */
    public void m5674p(int i) {
        this.f4300f.post(new RunnableC1392a());
        this.f4299e.post(new RunnableC1393b(i));
    }

    /* renamed from: q */
    public void m5675q(Bitmap bitmap) {
        this.f4299e.post(new RunnableC1394c());
        this.f4300f.post(new RunnableC1395d(bitmap));
    }

    /* renamed from: r */
    public void m5676r(OnClickListener onClickListener) {
        this.f4296b.setClickable(true);
        this.f4296b.setOnClickListener(new ViewOnClickListenerC1396e(onClickListener));
    }

    /* renamed from: s */
    public void m5677s(String str) {
        this.f4298d.setText(str);
    }

    /* renamed from: t */
    public void m5678t(String str) {
        this.f4297c.setText(str);
    }

    /* renamed from: u */
    public void m5679u(boolean z) {
        if (z) {
            m5680v();
        } else {
            m5669k();
        }
    }

    /* renamed from: v */
    public void m5680v() {
        this.f4296b.setVisibility(0);
    }
}
