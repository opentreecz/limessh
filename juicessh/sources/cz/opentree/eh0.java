package cz.opentree;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.activities.ManageConnectionActivity;
import cz.opentree.juicessh.activities.ManageIdentityActivity;
import cz.opentree.juicessh.activities.ManagePortForwardActivity;
import cz.opentree.juicessh.activities.PurchaseActivity;
import cz.opentree.juicessh.models.User;
import cz.opentree.pi0;
import java.util.ArrayList;

/* compiled from: AddressBookPagerAdapter.java */
/* loaded from: classes.dex */
public class eh0 extends PagerAdapter {

    /* renamed from: a */
    public FragmentActivity f2391a;

    /* renamed from: b */
    public ArrayList<Integer> f2392b = new ArrayList<>();

    /* renamed from: c */
    public SparseArray<View> f2393c = new SparseArray<>();

    /* renamed from: d */
    public sh0 f2394d;

    /* renamed from: e */
    public hh0 f2395e;

    /* renamed from: f */
    public nh0 f2396f;

    /* compiled from: AddressBookPagerAdapter.java */
    /* renamed from: cz.opentree.eh0$a */
    /* loaded from: classes.dex */
    public class C0927a implements AdapterView.OnItemClickListener {
        public C0927a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            eh0.this.f2394d.m8447i(eh0.this.f2394d.getItem(i));
        }
    }

    /* compiled from: AddressBookPagerAdapter.java */
    /* renamed from: cz.opentree.eh0$b */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0928b implements View.OnClickListener {
        public ViewOnClickListenerC0928b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eh0.this.f2391a.startActivityForResult(new Intent(eh0.this.f2391a, (Class<?>) ManagePortForwardActivity.class), 4);
        }
    }

    /* compiled from: AddressBookPagerAdapter.java */
    /* renamed from: cz.opentree.eh0$c */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0929c implements View.OnClickListener {
        public ViewOnClickListenerC0929c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eh0.this.f2391a.startActivity(new Intent(eh0.this.f2391a, (Class<?>) PurchaseActivity.class));
        }
    }

    /* compiled from: AddressBookPagerAdapter.java */
    /* renamed from: cz.opentree.eh0$d */
    /* loaded from: classes.dex */
    public class C0930d extends pi0.AbstractC1720p {

        /* renamed from: a */
        public final /* synthetic */ RelativeLayout f2400a;

        /* renamed from: b */
        public final /* synthetic */ RelativeLayout f2401b;

        public C0930d(eh0 eh0Var, RelativeLayout relativeLayout, RelativeLayout relativeLayout2) {
            this.f2400a = relativeLayout;
            this.f2401b = relativeLayout2;
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: a */
        public void mo3228a(String str) {
            this.f2400a.setVisibility(0);
            this.f2401b.setVisibility(8);
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            if (oi0.m7047d(user)) {
                this.f2400a.setVisibility(8);
                this.f2401b.setVisibility(0);
            } else {
                this.f2400a.setVisibility(0);
                this.f2401b.setVisibility(8);
            }
        }
    }

    /* compiled from: AddressBookPagerAdapter.java */
    /* renamed from: cz.opentree.eh0$e */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0931e implements View.OnClickListener {
        public ViewOnClickListenerC0931e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eh0.this.f2391a.startActivityForResult(new Intent(eh0.this.f2391a, (Class<?>) ManageConnectionActivity.class), 5);
        }
    }

    /* compiled from: AddressBookPagerAdapter.java */
    /* renamed from: cz.opentree.eh0$f */
    /* loaded from: classes.dex */
    public class C0932f implements ExpandableListView.OnChildClickListener {
        public C0932f() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0037, code lost:
        
            if (r3 != 3) goto L12;
         */
        @Override // android.widget.ExpandableListView.OnChildClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onChildClick(android.widget.ExpandableListView r1, android.view.View r2, int r3, int r4, long r5) {
            /*
                r0 = this;
                cz.opentree.eh0 r1 = cz.opentree.eh0.this
                cz.opentree.hh0 r1 = cz.opentree.eh0.m3495d(r1)
                java.util.List r1 = r1.m3208g()
                java.lang.Object r1 = r1.get(r3)
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1
                java.lang.Object r1 = r1.getValue()
                java.util.List r1 = (java.util.List) r1
                java.lang.Object r1 = r1.get(r4)
                cz.opentree.juicessh.models.Connection r1 = (cz.opentree.juicessh.models.Connection) r1
                android.content.Intent r2 = new android.content.Intent
                cz.opentree.eh0 r3 = cz.opentree.eh0.this
                androidx.fragment.app.FragmentActivity r3 = cz.opentree.eh0.m3494c(r3)
                java.lang.Class<cz.opentree.juicessh.activities.TerminalEmulatorActivity> r4 = cz.opentree.juicessh.activities.TerminalEmulatorActivity.class
                r2.<init>(r3, r4)
                r3 = 603979776(0x24000000, float:2.7755576E-17)
                r2.setFlags(r3)
                int r3 = r1.type
                r4 = 1
                if (r3 == r4) goto L76
                r5 = 2
                if (r3 == r5) goto L3a
                r5 = 3
                if (r3 == r5) goto L58
                goto L94
            L3a:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r5 = "local://"
                r3.append(r5)
                java.util.UUID r5 = r1.f3993id
                java.lang.String r5 = r5.toString()
                r3.append(r5)
                java.lang.String r3 = r3.toString()
                android.net.Uri r3 = android.net.Uri.parse(r3)
                r2.setData(r3)
            L58:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r5 = "telnet://"
                r3.append(r5)
                java.util.UUID r5 = r1.f3993id
                java.lang.String r5 = r5.toString()
                r3.append(r5)
                java.lang.String r3 = r3.toString()
                android.net.Uri r3 = android.net.Uri.parse(r3)
                r2.setData(r3)
            L76:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r5 = "mosh://"
                r3.append(r5)
                java.util.UUID r5 = r1.f3993id
                java.lang.String r5 = r5.toString()
                r3.append(r5)
                java.lang.String r3 = r3.toString()
                android.net.Uri r3 = android.net.Uri.parse(r3)
                r2.setData(r3)
            L94:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r5 = "ssh://"
                r3.append(r5)
                java.util.UUID r1 = r1.f3993id
                java.lang.String r1 = r1.toString()
                r3.append(r1)
                java.lang.String r1 = r3.toString()
                android.net.Uri r1 = android.net.Uri.parse(r1)
                r2.setData(r1)
                r1 = 0
                java.lang.String r3 = "background"
                r2.putExtra(r3, r1)
                cz.opentree.eh0 r1 = cz.opentree.eh0.this
                androidx.fragment.app.FragmentActivity r1 = cz.opentree.eh0.m3494c(r1)
                r1.startActivity(r2)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.opentree.eh0.C0932f.onChildClick(android.widget.ExpandableListView, android.view.View, int, int, long):boolean");
        }
    }

    /* compiled from: AddressBookPagerAdapter.java */
    /* renamed from: cz.opentree.eh0$g */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0933g implements View.OnClickListener {
        public ViewOnClickListenerC0933g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eh0.this.f2391a.startActivityForResult(new Intent(eh0.this.f2391a, (Class<?>) ManageIdentityActivity.class), 2);
        }
    }

    /* compiled from: AddressBookPagerAdapter.java */
    /* renamed from: cz.opentree.eh0$h */
    /* loaded from: classes.dex */
    public class C0934h implements AdapterView.OnItemClickListener {
        public C0934h() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Intent intent = new Intent(eh0.this.f2391a, (Class<?>) ManageIdentityActivity.class);
            intent.putExtra("identity_id", eh0.this.f2396f.getItem(i).f3993id);
            eh0.this.f2391a.startActivity(intent);
        }
    }

    public eh0(FragmentActivity fragmentActivity) {
        this.f2391a = fragmentActivity;
        if (kj0.m5917a().m5937t()) {
            this.f2392b.add(0);
        }
        this.f2392b.add(1);
        this.f2392b.add(2);
        this.f2394d = new sh0(fragmentActivity, R.layout.port_forwards);
        this.f2395e = new hh0(fragmentActivity, R.layout.address_list);
        this.f2396f = new nh0(fragmentActivity, R.layout.identity_list);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    /* renamed from: f */
    public hh0 m3497f() {
        return this.f2395e;
    }

    /* renamed from: g */
    public nh0 m3498g() {
        return this.f2396f;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f2392b.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        int intValue = this.f2392b.get(i).intValue();
        if (intValue == 0) {
            return this.f2391a.getString(R.string.port_forwards);
        }
        if (intValue == 1) {
            return this.f2391a.getString(R.string.connections_capital_c);
        }
        if (intValue != 2) {
            return null;
        }
        return this.f2391a.getString(R.string.identities);
    }

    /* renamed from: h */
    public int m3499h(int i) {
        return this.f2392b.indexOf(Integer.valueOf(i));
    }

    /* renamed from: i */
    public sh0 m3500i() {
        return this.f2394d;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @TargetApi(18)
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        int intValue = this.f2392b.get(i).intValue();
        if (this.f2393c.get(intValue) != null) {
            View view = this.f2393c.get(intValue);
            viewGroup.addView(view);
            return view;
        }
        RelativeLayout relativeLayout = intValue != 1 ? intValue != 2 ? (RelativeLayout) this.f2394d.m8444f() : (RelativeLayout) this.f2396f.m6685g() : (RelativeLayout) this.f2395e.m4448i();
        if (intValue == 0) {
            ListView listView = (ListView) relativeLayout.findViewById(R.id.page_list);
            RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.list_container);
            RelativeLayout relativeLayout3 = (RelativeLayout) relativeLayout.findViewById(R.id.problock);
            FloatingActionButton floatingActionButton = (FloatingActionButton) relativeLayout3.findViewById(R.id.fab_purchase);
            FloatingActionButton floatingActionButton2 = (FloatingActionButton) relativeLayout.findViewById(R.id.fab_new_portforward);
            TextView textView = (TextView) relativeLayout3.findViewById(R.id.problock_title);
            TextView textView2 = (TextView) relativeLayout3.findViewById(R.id.problock_subtitle);
            listView.setAdapter((ListAdapter) this.f2394d);
            listView.setClickable(true);
            listView.setOnItemClickListener(new C0927a());
            floatingActionButton2.setOnClickListener(new ViewOnClickListenerC0928b());
            listView.setEmptyView((LinearLayout) relativeLayout.findViewById(R.id.empty));
            ViewOnClickListenerC0929c viewOnClickListenerC0929c = new ViewOnClickListenerC0929c();
            floatingActionButton.setOnClickListener(viewOnClickListenerC0929c);
            textView.setOnClickListener(viewOnClickListenerC0929c);
            textView2.setOnClickListener(viewOnClickListenerC0929c);
            this.f2391a.registerForContextMenu(listView);
            viewGroup.addView(relativeLayout);
            this.f2393c.put(intValue, relativeLayout);
            relativeLayout3.setVisibility(0);
            relativeLayout2.setVisibility(8);
            if (kj0.m5917a().m5938u()) {
                pi0.m7331j(this.f2391a, new C0930d(this, relativeLayout3, relativeLayout2));
            }
            return relativeLayout;
        }
        if (intValue != 1) {
            if (intValue != 2) {
                return null;
            }
            ListView listView2 = (ListView) relativeLayout.findViewById(R.id.page_list);
            ((FloatingActionButton) relativeLayout.findViewById(R.id.fab_new_identity)).setOnClickListener(new ViewOnClickListenerC0933g());
            this.f2391a.registerForContextMenu(listView2);
            listView2.setAdapter((ListAdapter) this.f2396f);
            listView2.setClickable(true);
            listView2.setOnItemClickListener(new C0934h());
            listView2.setEmptyView((LinearLayout) relativeLayout.findViewById(R.id.empty));
            viewGroup.addView(relativeLayout);
            this.f2393c.put(intValue, relativeLayout);
            return relativeLayout;
        }
        ExpandableListView expandableListView = (ExpandableListView) relativeLayout.findViewById(R.id.expandable_list);
        ((FloatingActionButton) relativeLayout.findViewById(R.id.fab_new_connection)).setOnClickListener(new ViewOnClickListenerC0931e());
        int dimensionPixelSize = this.f2391a.getResources().getDimensionPixelSize(R.dimen.activity_padding);
        int dimensionPixelSize2 = this.f2391a.getResources().getDimensionPixelSize(R.dimen.list_item_icon_width) + dimensionPixelSize;
        if (Build.VERSION.SDK_INT >= 19) {
            expandableListView.setIndicatorBoundsRelative(dimensionPixelSize, dimensionPixelSize2);
        } else {
            expandableListView.setIndicatorBounds(dimensionPixelSize, dimensionPixelSize2);
        }
        expandableListView.setAdapter(this.f2395e);
        expandableListView.setOnChildClickListener(new C0932f());
        expandableListView.setEmptyView((LinearLayout) relativeLayout.findViewById(R.id.empty));
        this.f2391a.registerForContextMenu(expandableListView);
        viewGroup.addView(relativeLayout);
        this.f2393c.put(intValue, relativeLayout);
        return relativeLayout;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
