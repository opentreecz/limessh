package com.sonelli;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.sonelli.juicessh.R;

/* compiled from: TerminalThemeListAdapter.java */
/* loaded from: classes.dex */
public class zh0 extends BaseAdapter implements ListAdapter {

    /* renamed from: O */
    public final Context f8514O;

    /* renamed from: P */
    public final CharSequence[] f8515P;

    /* renamed from: Q */
    public final CharSequence[] f8516Q;

    /* renamed from: R */
    public final Typeface f8517R;

    public zh0(Context context, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2) {
        this.f8514O = context;
        this.f8515P = charSequenceArr;
        this.f8516Q = charSequenceArr2;
        this.f8517R = Typeface.createFromAsset(context.getAssets(), aj0.m2116c(context));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f8515P.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f8516Q[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return -1L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) this.f8514O.getSystemService("layout_inflater")).inflate(R.layout.terminal_theme_item, viewGroup, false);
        TextView textView = (TextView) linearLayout.findViewById(R.id.theme_name);
        textView.setTypeface(this.f8517R);
        textView.setText(this.f8515P[i]);
        int[] m6688a = ni0.m6688a(Integer.parseInt(this.f8516Q[i].toString()));
        int i2 = m6688a[257];
        int i3 = m6688a[256];
        if (Build.VERSION.SDK_INT >= 29) {
            linearLayout.setForceDarkAllowed(false);
        }
        linearLayout.setBackgroundColor(i2);
        textView.setTextColor(i3);
        ((FrameLayout) linearLayout.findViewById(R.id.theme_color_0)).setBackgroundColor(m6688a[0]);
        ((FrameLayout) linearLayout.findViewById(R.id.theme_color_1)).setBackgroundColor(m6688a[1]);
        ((FrameLayout) linearLayout.findViewById(R.id.theme_color_2)).setBackgroundColor(m6688a[2]);
        ((FrameLayout) linearLayout.findViewById(R.id.theme_color_3)).setBackgroundColor(m6688a[3]);
        ((FrameLayout) linearLayout.findViewById(R.id.theme_color_4)).setBackgroundColor(m6688a[4]);
        ((FrameLayout) linearLayout.findViewById(R.id.theme_color_5)).setBackgroundColor(m6688a[5]);
        ((FrameLayout) linearLayout.findViewById(R.id.theme_color_6)).setBackgroundColor(m6688a[6]);
        ((FrameLayout) linearLayout.findViewById(R.id.theme_color_7)).setBackgroundColor(m6688a[7]);
        return linearLayout;
    }
}
