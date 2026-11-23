package com.sonelli;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.sonelli.juicessh.R;

/* compiled from: PortForwardModeAdapter.java */
/* loaded from: classes.dex */
public class th0 extends BaseAdapter implements SpinnerAdapter {

    /* renamed from: O */
    public Context f6769O;

    /* renamed from: P */
    public Integer[] f6770P = {0, 1, 2};

    public th0(Context context) {
        this.f6769O = context;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i) {
        return this.f6770P[i];
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f6770P.length;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.f6770P[i].intValue();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.f6769O.getSystemService("layout_inflater")).inflate(R.layout.spinner_item, (ViewGroup) null, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.itemTitle);
        int intValue = this.f6770P[i].intValue();
        if (intValue == 0) {
            textView.setText(R.string.local);
        } else if (intValue == 1) {
            textView.setText(R.string.remote);
        } else if (intValue == 2) {
            textView.setText(R.string.dynamic_socks);
        }
        return view;
    }
}
