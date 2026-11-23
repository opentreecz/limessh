package com.sonelli;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.models.ConnectionIdentity;
import com.sonelli.juicessh.models.Identity;
import com.sonelli.juicessh.p002db.C1328DB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: IdentityListAdapter.java */
/* loaded from: classes.dex */
public class nh0 extends BaseAdapter implements ListAdapter {

    /* renamed from: O */
    public Context f5278O;

    /* renamed from: P */
    public View f5279P;

    /* renamed from: Q */
    public int f5280Q;

    /* renamed from: R */
    public List<Identity> f5281R = Collections.emptyList();

    /* renamed from: S */
    public HashMap<Identity, String> f5282S = new HashMap<>();

    /* renamed from: T */
    public final Object f5283T = new Object();

    /* compiled from: IdentityListAdapter.java */
    /* renamed from: com.sonelli.nh0$a */
    /* loaded from: classes.dex */
    public class RunnableC1605a implements Runnable {
        public RunnableC1605a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (nh0.this.f5283T) {
                    nh0 nh0Var = nh0.this;
                    nh0Var.f5281R = C1328DB.m5404d(Identity.class, nh0Var.f5278O).queryForAll();
                    Collections.sort(nh0.this.f5281R);
                }
            } catch (SQLException e) {
                gj0.m4142c("IdentityListAdapter", "Could not fetch identity list from database");
                e.printStackTrace();
            }
        }
    }

    /* compiled from: IdentityListAdapter.java */
    /* renamed from: com.sonelli.nh0$b */
    /* loaded from: classes.dex */
    public class RunnableC1606b implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ Handler f5285O;

        /* compiled from: IdentityListAdapter.java */
        /* renamed from: com.sonelli.nh0$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                nh0.this.notifyDataSetChanged();
            }
        }

        public RunnableC1606b(Handler handler) {
            this.f5285O = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            List arrayList;
            String str;
            synchronized (nh0.this.f5283T) {
                for (Identity identity : nh0.this.f5281R) {
                    try {
                        arrayList = C1328DB.m5404d(ConnectionIdentity.class, nh0.this.f5278O).queryForEq("identity_id", identity);
                    } catch (SQLException unused) {
                        arrayList = new ArrayList();
                    }
                    int i = 0;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        try {
                            ((ConnectionIdentity) it.next()).connection.m5383m().toString();
                            i++;
                        } catch (NullPointerException unused2) {
                        }
                    }
                    if (i == 0) {
                        str = nh0.this.f5278O.getString(R.string.not_used);
                    } else if (i == 1) {
                        str = nh0.this.f5278O.getString(R.string.used_by) + " " + i + " " + nh0.this.f5278O.getString(R.string.connection);
                    } else {
                        str = nh0.this.f5278O.getString(R.string.used_by) + " " + i + " " + nh0.this.f5278O.getString(R.string.connections_lowercase);
                    }
                    nh0.this.f5282S.put(identity, str);
                }
            }
            this.f5285O.postDelayed(new a(), 200L);
        }
    }

    /* compiled from: IdentityListAdapter.java */
    /* renamed from: com.sonelli.nh0$c */
    /* loaded from: classes.dex */
    public static class C1607c {

        /* renamed from: a */
        public TextView f5288a;

        /* renamed from: b */
        public TextView f5289b;
    }

    public nh0(Context context, int i) {
        this.f5278O = context;
        this.f5280Q = i;
    }

    @Override // android.widget.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Identity getItem(int i) {
        Identity identity;
        synchronized (this.f5283T) {
            identity = this.f5281R.get(i);
        }
        return identity;
    }

    /* renamed from: g */
    public View m6685g() {
        if (this.f5279P == null) {
            this.f5279P = ((LayoutInflater) this.f5278O.getSystemService("layout_inflater")).inflate(this.f5280Q, (ViewGroup) null, false);
        }
        return this.f5279P;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size;
        synchronized (this.f5283T) {
            size = this.f5281R.size();
        }
        return size;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.f5278O.getSystemService("layout_inflater")).inflate(R.layout.identity_menu_item, viewGroup, false);
            C1607c c1607c = new C1607c();
            c1607c.f5288a = (TextView) view.findViewById(R.id.itemTitle);
            c1607c.f5289b = (TextView) view.findViewById(R.id.itemSubtitle);
            view.setTag(c1607c);
        }
        synchronized (this.f5283T) {
            Identity identity = this.f5281R.get(i);
            if (identity != null) {
                C1607c c1607c2 = (C1607c) view.getTag();
                c1607c2.f5288a.setText(identity.toString());
                String str = this.f5282S.get(identity);
                if (str != null) {
                    c1607c2.f5289b.setText(str);
                } else {
                    c1607c2.f5289b.setText("");
                }
            }
        }
        return view;
    }

    /* renamed from: h */
    public void m6686h() {
        new Thread(new RunnableC1606b(new Handler()), "IdentityListAdapter.populateSubtitles").start();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        synchronized (this.f5283T) {
            this.f5281R.clear();
        }
        new Thread(new RunnableC1605a(), "IdentityListAdapter.notifyDataSetInvalidated").start();
        notifyDataSetChanged();
        m6686h();
    }
}
