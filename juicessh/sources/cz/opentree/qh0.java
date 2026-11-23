package cz.opentree;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import cz.opentree.juicessh.R;

/* compiled from: KeyStrengthAdapter.java */
/* loaded from: classes.dex */
public class qh0 extends BaseAdapter implements SpinnerAdapter {

    /* renamed from: O */
    public final SparseArray<String> f5999O = new SparseArray<>();

    /* renamed from: P */
    public LayoutInflater f6000P;

    /* renamed from: Q */
    public int f6001Q;

    public qh0(Context context, int[] iArr, int i) {
        this.f6000P = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f6001Q = i;
        for (int i2 : iArr) {
            this.f5999O.put(i2, i2 + "bit");
        }
    }

    /* renamed from: a */
    public int m7710a(int i) {
        return this.f5999O.indexOfKey(i);
    }

    /* renamed from: b */
    public int m7711b() {
        return this.f6001Q;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5999O.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(this.f5999O.keyAt(i));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.f5999O.keyAt(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f6000P.inflate(R.layout.spinner_item, (ViewGroup) null, false);
        }
        ((TextView) view.findViewById(R.id.itemTitle)).setText(this.f5999O.valueAt(i));
        ImageView imageView = (ImageView) view.findViewById(R.id.itemIcon);
        imageView.setImageResource(R.drawable.ic_contact_picture);
        imageView.setVisibility(8);
        return view;
    }
}
