package cz.opentree;

import android.content.Context;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import cz.opentree.limessh.R;
import cz.opentree.limessh.models.Connection;
import cz.opentree.limessh.models.ConnectionGroup;
import cz.opentree.limessh.models.Identity;
import java.util.HashMap;

/* compiled from: ConnectionListAdapter.java */
/* loaded from: classes.dex */
public class hh0 extends dh0<ConnectionGroup, Connection> {

    /* renamed from: h */
    public int f3148h;

    /* renamed from: i */
    public View f3149i;

    /* renamed from: j */
    public Context f3150j;

    /* renamed from: k */
    public HashMap<ConnectionGroup, String> f3151k;

    /* renamed from: l */
    public HashMap<Connection, String> f3152l;

    /* compiled from: ConnectionListAdapter.java */
    /* renamed from: cz.opentree.hh0$a */
    /* loaded from: classes.dex */
    public class AsyncTaskC1109a extends AsyncTask<Void, Void, Void> {

        /* renamed from: a */
        public final /* synthetic */ TextView f3153a;

        /* renamed from: b */
        public final /* synthetic */ TextView f3154b;

        public AsyncTaskC1109a(TextView textView, TextView textView2) {
            this.f3153a = textView;
            this.f3154b = textView2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:24:0x007e A[LOOP:3: B:22:0x0078->B:24:0x007e, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x010a  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x013b A[LOOP:6: B:61:0x0135->B:63:0x013b, LOOP_END] */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Void doInBackground(java.lang.Void... r8) {
            /*
                Method dump skipped, instructions count: 332
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.opentree.hh0.AsyncTaskC1109a.doInBackground(java.lang.Void[]):java.lang.Void");
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r3) {
            super.onPostExecute(r3);
            this.f3153a.setText(R.string.no_connections);
            this.f3154b.setText(R.string.you_do_not_have_any_connections);
            hh0.this.m3209h();
            ExpandableListView expandableListView = (ExpandableListView) hh0.this.m4448i().findViewById(R.id.expandable_list);
            if (expandableListView != null) {
                int size = hh0.this.m3208g().size();
                if (size == 1 || size == 2) {
                    try {
                        expandableListView.expandGroup(0);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            this.f3153a.setText(R.string.loading_dot_dot_dot);
            this.f3154b.setText(R.string.just_fetching_and_organising_your_connections);
            hh0.this.m3203b();
        }
    }

    /* compiled from: ConnectionListAdapter.java */
    /* renamed from: cz.opentree.hh0$b */
    /* loaded from: classes.dex */
    public static class C1110b {

        /* renamed from: a */
        public TextView f3156a;

        /* renamed from: b */
        public TextView f3157b;

        /* renamed from: c */
        public TextView f3158c;
    }

    public hh0(Context context, int i) {
        super(context, R.layout.connection_menu_group_item, R.layout.connection_menu_group_item, R.layout.connection_menu_item);
        this.f3151k = new HashMap<>();
        this.f3152l = new HashMap<>();
        this.f3150j = context;
        this.f3148h = i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C1110b c1110b;
        if (view != null) {
            c1110b = (C1110b) view.getTag();
        } else {
            view = this.f2176g.inflate(m3204c().intValue(), viewGroup, false);
            c1110b = new C1110b();
            c1110b.f3156a = (TextView) view.findViewById(R.id.itemTitle);
            c1110b.f3157b = (TextView) view.findViewById(R.id.itemSubtitle);
            c1110b.f3158c = (TextView) view.findViewById(R.id.itemIcon);
            c1110b.f3158c.setTypeface(Typeface.createFromAsset(this.f3150j.getAssets(), "fonts/fontawesome-webfont.ttf"));
            view.setTag(c1110b);
        }
        Connection connection = m3208g().get(i).getValue().get(i2);
        String str = this.f3152l.get(connection);
        if (str == null) {
            Identity m5470v = connection.m5470v(this.f3150j);
            str = m5470v != null ? m5470v.toString() : this.f3150j.getString(R.string.no_identity);
            this.f3152l.put(connection, str);
        }
        c1110b.f3156a.setText(connection.toString());
        c1110b.f3157b.setText(str);
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0074  */
    @Override // android.widget.ExpandableListAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getGroupView(int r5, boolean r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r4 = this;
            r0 = 0
            if (r7 == 0) goto L1f
            int r1 = r7.getId()
            if (r6 == 0) goto Le
            java.lang.Integer r2 = r4.m3207f()
            goto L12
        Le:
            java.lang.Integer r2 = r4.m3206e()
        L12:
            int r2 = r2.intValue()
            if (r1 == r2) goto L1f
            java.lang.Object r6 = r7.getTag()
            cz.opentree.hh0$b r6 = (cz.opentree.hh0.C1110b) r6
            goto L64
        L1f:
            android.view.LayoutInflater r7 = r4.f2176g
            if (r6 == 0) goto L28
            java.lang.Integer r6 = r4.m3207f()
            goto L2c
        L28:
            java.lang.Integer r6 = r4.m3206e()
        L2c:
            int r6 = r6.intValue()
            android.view.View r7 = r7.inflate(r6, r8, r0)
            cz.opentree.hh0$b r6 = new cz.opentree.hh0$b
            r6.<init>()
            r8 = 16908308(0x1020014, float:2.3877285E-38)
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6.f3156a = r8
            r8 = 16908309(0x1020015, float:2.3877288E-38)
            android.view.View r8 = r7.findViewById(r8)
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6.f3157b = r8
            r7.setTag(r6)
            android.widget.TextView r8 = r6.f3157b
            android.content.Context r1 = r4.f3150j
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2131099881(0x7f0600e9, float:1.7812128E38)
            int r1 = r1.getColor(r2)
            r8.setTextColor(r1)
        L64:
            java.lang.Object r5 = r4.getGroup(r5)
            cz.opentree.limessh.models.ConnectionGroup r5 = (cz.opentree.limessh.models.ConnectionGroup) r5
            java.util.HashMap<cz.opentree.limessh.models.ConnectionGroup, java.lang.String> r8 = r4.f3151k
            java.lang.Object r8 = r8.get(r5)
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto Lb5
            android.content.Context r8 = r4.f3150j
            java.util.List r8 = cz.opentree.limessh.models.Share.m5499r(r5, r8)
            int r1 = r8.size()
            if (r1 == 0) goto La7
            r2 = 1
            if (r1 == r2) goto L9d
            android.content.Context r1 = r4.f3150j
            r3 = 2131821471(0x7f11039f, float:1.9275686E38)
            java.lang.String r1 = r1.getString(r3)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            int r8 = r8.size()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r2[r0] = r8
            java.lang.String r8 = java.lang.String.format(r1, r2)
            goto Lb0
        L9d:
            android.content.Context r8 = r4.f3150j
            r0 = 2131821470(0x7f11039e, float:1.9275684E38)
            java.lang.String r8 = r8.getString(r0)
            goto Lb0
        La7:
            android.content.Context r8 = r4.f3150j
            r0 = 2131821335(0x7f110317, float:1.927541E38)
            java.lang.String r8 = r8.getString(r0)
        Lb0:
            java.util.HashMap<cz.opentree.limessh.models.ConnectionGroup, java.lang.String> r0 = r4.f3151k
            r0.put(r5, r8)
        Lb5:
            android.widget.TextView r0 = r6.f3156a
            java.lang.String r5 = r5.toString()
            r0.setText(r5)
            android.widget.TextView r5 = r6.f3157b
            r5.setText(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.hh0.getGroupView(int, boolean, android.view.View, android.view.ViewGroup):android.view.View");
    }

    /* renamed from: i */
    public View m4448i() {
        if (this.f3149i == null) {
            this.f3149i = ((LayoutInflater) this.f3150j.getSystemService("layout_inflater")).inflate(this.f3148h, (ViewGroup) null, false);
        }
        return this.f3149i;
    }

    /* renamed from: j */
    public void m4449j() {
        m3203b();
        this.f3151k.clear();
        this.f3152l.clear();
        new AsyncTaskC1109a((TextView) m4448i().findViewById(R.id.title), (TextView) m4448i().findViewById(R.id.subtitle)).execute(new Void[0]);
    }
}
