package cz.opentree;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import cz.opentree.juicessh.R;

/* compiled from: BackspaceModeSpinnerAdapter.java */
/* loaded from: classes.dex */
public class fh0 extends BaseAdapter implements ListAdapter {

    /* renamed from: Q */
    public static final SparseIntArray f2691Q = new C0990a();

    /* renamed from: O */
    public Context f2692O;

    /* renamed from: P */
    public LayoutInflater f2693P;

    /* compiled from: BackspaceModeSpinnerAdapter.java */
    /* renamed from: cz.opentree.fh0$a */
    /* loaded from: classes.dex */
    public static class C0990a extends SparseIntArray {
        public C0990a() {
            append(0, R.string.backspace_mode_default);
            append(1, R.string.backspace_mode_legacy);
        }
    }

    public fh0(Context context) {
        this.f2692O = context;
        this.f2693P = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return f2691Q.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(f2691Q.get(i));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return f2691Q.keyAt(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f2693P.inflate(R.layout.spinner_item, (ViewGroup) null, false);
        }
        ((TextView) view.findViewById(R.id.itemTitle)).setText(this.f2692O.getString(f2691Q.get(i)));
        return view;
    }
}
