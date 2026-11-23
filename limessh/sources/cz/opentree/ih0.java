package cz.opentree;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cz.opentree.limessh.R;
import cz.opentree.limessh.models.Connection;
import cz.opentree.limessh.p002db.C1328DB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: ConnectionSpinnerAdapter.java */
/* loaded from: classes.dex */
public class ih0 extends BaseAdapter {

    /* renamed from: O */
    public List<Connection> f3321O;

    /* renamed from: P */
    public LayoutInflater f3322P;

    /* renamed from: Q */
    public Context f3323Q;

    /* renamed from: R */
    public boolean f3324R;

    public ih0(Context context, Connection connection, boolean z) {
        this.f3322P = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f3323Q = context;
        this.f3324R = z;
        try {
            this.f3321O = C1328DB.m5404d(Connection.class, context).queryForAll();
        } catch (SQLException unused) {
            this.f3321O = new ArrayList();
        }
        Collections.sort(this.f3321O);
        if (connection != null) {
            Iterator<Connection> it = this.f3321O.iterator();
            while (it.hasNext()) {
                if (it.next().f3993id.toString().equals(connection.f3993id.toString())) {
                    it.remove();
                    return;
                }
            }
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Connection getItem(int i) {
        if (i > 0) {
            return this.f3321O.get(i - 1);
        }
        return null;
    }

    /* renamed from: b */
    public int m4780b(Connection connection) {
        for (int i = 0; i < this.f3321O.size(); i++) {
            if (this.f3321O.get(i).f3993id.toString().equals(connection.f3993id.toString())) {
                return i + 1;
            }
        }
        return -1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3321O.size() + 1;
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
            view = this.f3322P.inflate(R.layout.spinner_item, (ViewGroup) null, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.itemTitle);
        ImageView imageView = (ImageView) view.findViewById(R.id.itemIcon);
        imageView.setImageResource(R.drawable.ic_contact_picture);
        imageView.setVisibility(8);
        if (i != 0) {
            textView.setText(this.f3321O.get(i - 1).m5471w());
        } else if (this.f3324R) {
            textView.setText(this.f3323Q.getString(R.string.optional));
        } else {
            textView.setText(this.f3323Q.getString(R.string.pick_one));
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }
}
