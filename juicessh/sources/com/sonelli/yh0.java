package com.sonelli;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.models.Config;

/* compiled from: TerminalFontListAdapter.java */
/* loaded from: classes.dex */
public class yh0 extends BaseAdapter implements ListAdapter {

    /* renamed from: O */
    public final Context f8220O;

    /* renamed from: P */
    public final CharSequence[] f8221P;

    /* renamed from: Q */
    public final CharSequence[] f8222Q;

    /* renamed from: R */
    public final int[] f8223R;

    public yh0(Context context, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2) {
        this.f8220O = context;
        this.f8221P = charSequenceArr;
        this.f8222Q = charSequenceArr2;
        this.f8223R = ni0.m6688a(Config.m5460f(context, "terminal:theme"));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f8221P.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f8222Q[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return -1L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) this.f8220O.getSystemService("layout_inflater")).inflate(R.layout.terminal_font_item, viewGroup, false);
        TextView textView = (TextView) linearLayout.findViewById(R.id.font_name);
        textView.setTypeface(Typeface.createFromAsset(this.f8220O.getAssets(), aj0.m2115b().get(i).m2119k()));
        textView.setText(this.f8221P[i]);
        int[] iArr = this.f8223R;
        int i2 = iArr[257];
        int i3 = iArr[256];
        if (Build.VERSION.SDK_INT >= 29) {
            linearLayout.setForceDarkAllowed(false);
        }
        linearLayout.setBackgroundColor(i2);
        textView.setTextColor(i3);
        return linearLayout;
    }
}
