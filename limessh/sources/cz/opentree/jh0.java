package cz.opentree;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cz.opentree.limessh.R;
import java.util.ArrayList;

/* compiled from: ConnectionTypeSpinnerAdapter.java */
/* loaded from: classes.dex */
public class jh0 extends BaseAdapter {

    /* renamed from: O */
    public final LayoutInflater f3557O;

    /* renamed from: P */
    public ArrayList<Pair<Integer, String>> f3558P = new ArrayList<>();

    public jh0(Context context) {
        this.f3557O = (LayoutInflater) context.getSystemService("layout_inflater");
        if (kj0.m5917a().m5924D()) {
            this.f3558P.add(new Pair<>(0, context.getString(R.string.ssh)));
        }
        if (kj0.m5917a().m5923C()) {
            this.f3558P.add(new Pair<>(1, context.getString(R.string.mosh)));
        }
        if (kj0.m5917a().m5922B()) {
            this.f3558P.add(new Pair<>(2, context.getString(R.string.local_device)));
        }
        if (kj0.m5917a().m5925E()) {
            this.f3558P.add(new Pair<>(3, context.getString(R.string.telnet)));
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Pair<Integer, String> getItem(int i) {
        return this.f3558P.get(i);
    }

    /* renamed from: b */
    public int m5115b(int i) {
        for (int i2 = 0; i2 < this.f3558P.size(); i2++) {
            if (((Integer) this.f3558P.get(i2).first).intValue() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: c */
    public void m5116c(Pair<Integer, String> pair) {
        if (this.f3558P.remove(pair)) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3558P.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return ((Integer) this.f3558P.get(i).first).intValue();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f3557O.inflate(R.layout.spinner_item, (ViewGroup) null, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.itemTitle);
        ImageView imageView = (ImageView) view.findViewById(R.id.itemIcon);
        imageView.setImageResource(R.drawable.ic_contact_picture);
        imageView.setVisibility(8);
        textView.setText((CharSequence) this.f3558P.get(i).second);
        return view;
    }
}
