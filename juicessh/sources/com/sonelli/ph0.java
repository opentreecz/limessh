package com.sonelli;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.sonelli.juicessh.R;
import com.sun.jna.Function;

/* compiled from: KeyFormatAdapter.java */
/* loaded from: classes.dex */
public class ph0 extends BaseAdapter implements SpinnerAdapter {

    /* renamed from: O */
    public final SparseArray<String> f5661O;

    /* renamed from: P */
    public LayoutInflater f5662P;

    public ph0(Context context) {
        SparseArray<String> sparseArray = new SparseArray<>();
        this.f5661O = sparseArray;
        this.f5662P = (LayoutInflater) context.getSystemService("layout_inflater");
        sparseArray.put(2, "RSA");
        sparseArray.put(1, "ECDSA");
        sparseArray.put(0, "ed25519");
    }

    /* renamed from: a */
    public qh0 m7319a(Context context, int i) {
        int keyAt = this.f5661O.keyAt(i);
        if (keyAt == 0) {
            return new qh0(context, new int[]{256}, 256);
        }
        if (keyAt == 1) {
            return new qh0(context, new int[]{256, Function.USE_VARARGS, 521}, Function.USE_VARARGS);
        }
        if (keyAt != 2) {
            return null;
        }
        return new qh0(context, new int[]{1024, 2048, 4096}, 2048);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5661O.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(this.f5661O.keyAt(i));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.f5661O.keyAt(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5662P.inflate(R.layout.spinner_item, (ViewGroup) null, false);
        }
        ((TextView) view.findViewById(R.id.itemTitle)).setText(this.f5661O.valueAt(i));
        ImageView imageView = (ImageView) view.findViewById(R.id.itemIcon);
        imageView.setImageResource(R.drawable.ic_contact_picture);
        imageView.setVisibility(8);
        return view;
    }
}
