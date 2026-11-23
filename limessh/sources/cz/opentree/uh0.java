package cz.opentree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import cz.opentree.limessh.R;
import cz.opentree.limessh.models.Snippet;
import cz.opentree.limessh.p002db.C1328DB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SnippetSpinnerAdapter.java */
/* loaded from: classes.dex */
public class uh0 extends BaseAdapter implements ListAdapter {

    /* renamed from: O */
    public LayoutInflater f6966O;

    /* renamed from: P */
    public Context f6967P;

    /* renamed from: Q */
    public List<Snippet> f6968Q;

    public uh0(Context context) {
        this.f6966O = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f6967P = context;
        try {
            this.f6968Q = C1328DB.m5404d(Snippet.class, context).queryForAll();
        } catch (SQLException unused) {
            this.f6968Q = new ArrayList();
        }
        Collections.sort(this.f6968Q);
    }

    /* renamed from: a */
    public int m8893a(Snippet snippet) {
        for (int i = 0; i < this.f6968Q.size(); i++) {
            if (this.f6968Q.get(i).f3993id.toString().equals(snippet.f3993id.toString())) {
                return i + 1;
            }
        }
        return -1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<Snippet> list = this.f6968Q;
        if (list == null) {
            return 0;
        }
        return list.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > 0) {
            return this.f6968Q.get(i - 1);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f6966O.inflate(R.layout.spinner_item, (ViewGroup) null, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.itemTitle);
        ((ImageView) view.findViewById(R.id.itemIcon)).setVisibility(8);
        if (i == 0) {
            textView.setText(this.f6967P.getString(R.string.optional));
        } else {
            textView.setText(this.f6968Q.get(i - 1).m5503s());
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 1;
    }
}
