package com.sonelli;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.FragmentActivity;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.connections.ConnectionManager;
import com.sonelli.juicessh.connections.transports.ConnectionProvider;
import com.sonelli.juicessh.models.PortForward;
import com.sonelli.juicessh.p002db.C1328DB;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/* compiled from: PortForwardListAdapter.java */
/* loaded from: classes.dex */
public class sh0 extends BaseAdapter implements ListAdapter {

    /* renamed from: O */
    public FragmentActivity f6442O;

    /* renamed from: P */
    public List<PortForward> f6443P = new ArrayList();

    /* renamed from: Q */
    public HashMap<PortForward, View> f6444Q = new HashMap<>();

    /* renamed from: R */
    public LayoutInflater f6445R;

    /* renamed from: S */
    public int f6446S;

    /* renamed from: T */
    public View f6447T;

    /* compiled from: PortForwardListAdapter.java */
    /* renamed from: com.sonelli.sh0$a */
    /* loaded from: classes.dex */
    public class AsyncTaskC1861a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a */
        public final /* synthetic */ TextView f6448a;

        /* renamed from: b */
        public final /* synthetic */ TextView f6449b;

        public AsyncTaskC1861a(TextView textView, TextView textView2) {
            this.f6448a = textView;
            this.f6449b = textView2;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            try {
                sh0 sh0Var = sh0.this;
                sh0Var.f6443P = C1328DB.m5404d(PortForward.class, sh0Var.f6442O).queryForAll();
                Collections.sort(sh0.this.f6443P);
                return null;
            } catch (SQLException e) {
                gj0.m4142c("PortForwardListAdapter", "Could not get list of port forwards from database");
                e.printStackTrace();
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r2) {
            this.f6448a.setText(R.string.no_port_forwards);
            this.f6449b.setText(R.string.you_do_not_have_any_port_forwards);
            sh0.this.notifyDataSetChanged();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            this.f6448a.setText(R.string.loading_dot_dot_dot);
            this.f6449b.setText(R.string.just_fetching_and_organising_your_port_forwards);
            sh0.this.f6443P.clear();
            sh0.this.m8442d();
        }
    }

    /* compiled from: PortForwardListAdapter.java */
    /* renamed from: com.sonelli.sh0$b */
    /* loaded from: classes.dex */
    public class C1862b implements ConnectionManager.ChainQuery {

        /* renamed from: a */
        public final /* synthetic */ PortForward f6451a;

        /* renamed from: b */
        public final /* synthetic */ C1866f f6452b;

        public C1862b(sh0 sh0Var, PortForward portForward, C1866f c1866f) {
            this.f6451a = portForward;
            this.f6452b = c1866f;
        }

        @Override // com.sonelli.juicessh.connections.ConnectionManager.ChainQuery
        /* renamed from: a */
        public void mo5353a(List<ai0> list) {
            if (list.isEmpty()) {
                this.f6452b.f6461c.setChecked(false);
            } else {
                this.f6452b.f6461c.setChecked(true);
            }
        }

        @Override // com.sonelli.juicessh.connections.ConnectionManager.ChainQuery
        /* renamed from: b */
        public ConnectionProvider mo5354b() {
            return this.f6451a;
        }
    }

    /* compiled from: PortForwardListAdapter.java */
    /* renamed from: com.sonelli.sh0$c */
    /* loaded from: classes.dex */
    public class C1863c implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a */
        public final /* synthetic */ PortForward f6453a;

        public C1863c(PortForward portForward) {
            this.f6453a = portForward;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f6453a.m5497v(sh0.this.f6442O, z);
        }
    }

    /* compiled from: PortForwardListAdapter.java */
    /* renamed from: com.sonelli.sh0$d */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1864d implements View.OnClickListener {

        /* renamed from: O */
        public final /* synthetic */ ListView f6455O;

        /* renamed from: P */
        public final /* synthetic */ View f6456P;

        /* renamed from: Q */
        public final /* synthetic */ int f6457Q;

        public ViewOnClickListenerC1864d(sh0 sh0Var, ListView listView, View view, int i) {
            this.f6455O = listView;
            this.f6456P = view;
            this.f6457Q = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f6455O.getOnItemClickListener().onItemClick(this.f6455O, this.f6456P, this.f6457Q, r2.getId());
        }
    }

    /* compiled from: PortForwardListAdapter.java */
    /* renamed from: com.sonelli.sh0$e */
    /* loaded from: classes.dex */
    public class ViewOnLongClickListenerC1865e implements View.OnLongClickListener {

        /* renamed from: O */
        public final /* synthetic */ ListView f6458O;

        public ViewOnLongClickListenerC1865e(sh0 sh0Var, ListView listView) {
            this.f6458O = listView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            this.f6458O.showContextMenuForChild(view);
            return true;
        }
    }

    /* compiled from: PortForwardListAdapter.java */
    /* renamed from: com.sonelli.sh0$f */
    /* loaded from: classes.dex */
    public static class C1866f {

        /* renamed from: a */
        public TextView f6459a;

        /* renamed from: b */
        public TextView f6460b;

        /* renamed from: c */
        public SwitchCompat f6461c;
    }

    public sh0(FragmentActivity fragmentActivity, int i) {
        this.f6442O = fragmentActivity;
        this.f6445R = (LayoutInflater) fragmentActivity.getSystemService("layout_inflater");
        this.f6446S = i;
    }

    /* renamed from: d */
    public void m8442d() {
        this.f6443P.clear();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public PortForward getItem(int i) {
        try {
            return this.f6443P.get(i);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    /* renamed from: f */
    public View m8444f() {
        if (this.f6447T == null) {
            this.f6447T = this.f6445R.inflate(this.f6446S, (ViewGroup) null, false);
        }
        return this.f6447T;
    }

    /* renamed from: g */
    public void m8445g(PortForward portForward, boolean z) {
        SwitchCompat switchCompat = (SwitchCompat) this.f6444Q.get(portForward).findViewById(R.id.toggleIndicator);
        if (switchCompat != null) {
            switchCompat.setChecked(z);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<PortForward> list = this.f6443P;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f6445R.inflate(R.layout.port_forward_item, (ViewGroup) null);
            C1866f c1866f = new C1866f();
            c1866f.f6459a = (TextView) view.findViewById(R.id.itemTitle);
            c1866f.f6460b = (TextView) view.findViewById(R.id.itemSubtitle);
            c1866f.f6461c = (SwitchCompat) view.findViewById(R.id.toggleIndicator);
            view.setTag(c1866f);
        }
        PortForward portForward = this.f6443P.get(i);
        if (portForward != null) {
            C1866f c1866f2 = (C1866f) view.getTag();
            c1866f2.f6459a.setText(portForward.name);
            portForward.connection.m5383m();
            if (portForward.connection.m5471w() != null) {
                c1866f2.f6460b.setText(String.format(this.f6442O.getString(R.string.via_connection_string), portForward.connection.m5471w()));
            } else {
                c1866f2.f6460b.setText(R.string.invalid_connection);
            }
            ConnectionManager.m5350c(this.f6442O, new C1862b(this, portForward, c1866f2));
            c1866f2.f6461c.setOnCheckedChangeListener(new C1863c(portForward));
            ListView listView = (ListView) viewGroup;
            view.setOnClickListener(new ViewOnClickListenerC1864d(this, listView, view, i));
            view.setOnLongClickListener(new ViewOnLongClickListenerC1865e(this, listView));
        }
        this.f6444Q.put(portForward, view);
        return view;
    }

    /* renamed from: h */
    public void m8446h(UUID uuid, boolean z) {
        for (PortForward portForward : this.f6443P) {
            if (portForward.f3993id.equals(uuid)) {
                m8445g(portForward, z);
                return;
            }
        }
    }

    /* renamed from: i */
    public void m8447i(PortForward portForward) {
        SwitchCompat switchCompat = (SwitchCompat) this.f6444Q.get(portForward).findViewById(R.id.toggleIndicator);
        if (switchCompat != null) {
            switchCompat.setChecked(!switchCompat.isChecked());
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        new AsyncTaskC1861a((TextView) m8444f().findViewById(R.id.title), (TextView) m8444f().findViewById(R.id.subtitle)).execute(new Void[0]);
    }
}
