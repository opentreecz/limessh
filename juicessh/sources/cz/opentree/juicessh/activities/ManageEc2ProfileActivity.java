package cz.opentree.juicessh.activities;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeRegionsResult;
import com.amazonaws.services.ec2.model.Region;
import cz.opentree.gj0;
import cz.opentree.ih0;
import cz.opentree.jh0;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.Connection;
import cz.opentree.juicessh.models.ConnectionGroup;
import cz.opentree.juicessh.models.Identity;
import cz.opentree.juicessh.models.User;
import cz.opentree.juicessh.models.ec2link.Ec2Filter;
import cz.opentree.juicessh.models.ec2link.Ec2GroupMapping;
import cz.opentree.juicessh.models.ec2link.Ec2Mapping;
import cz.opentree.juicessh.models.ec2link.Ec2Profile;
import cz.opentree.juicessh.p002db.C1328DB;
import cz.opentree.juicessh.services.Ec2Link;
import cz.opentree.qg0;
import cz.opentree.util.SessionedActivity;
import cz.opentree.vh0;
import cz.opentree.vj0;
import cz.opentree.xj0;
import cz.opentree.yj0;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class ManageEc2ProfileActivity extends SessionedActivity {

    /* renamed from: Q */
    public ViewPager f3781Q;

    /* renamed from: R */
    public Menu f3782R;

    /* renamed from: S */
    public yj0<ConnectionGroup> f3783S;

    /* renamed from: U */
    public Spinner f3785U;

    /* renamed from: P */
    public Ec2Profile f3780P = new Ec2Profile();

    /* renamed from: T */
    public xj0.AbstractC2296d f3784T = new C1263a();

    /* renamed from: V */
    public xj0.AbstractC2296d f3786V = new C1264b();

    /* renamed from: cz.opentree.juicessh.activities.ManageEc2ProfileActivity$a */
    /* loaded from: classes.dex */
    public class C1263a extends xj0.AbstractC2296d {
        public C1263a() {
        }

        @Override // cz.opentree.xj0.AbstractC2296d
        /* renamed from: a */
        public void mo5244a(View view) {
            ManageEc2ProfileActivity.this.f3783S = (yj0) view;
            ManageEc2ProfileActivity.this.startActivityForResult(new Intent(ManageEc2ProfileActivity.this, (Class<?>) ManageGroupActivity.class), 1);
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.ManageEc2ProfileActivity$b */
    /* loaded from: classes.dex */
    public class C1264b extends xj0.AbstractC2296d {
        public C1264b() {
        }

        @Override // cz.opentree.xj0.AbstractC2296d
        /* renamed from: a */
        public void mo5244a(View view) {
            ManageEc2ProfileActivity.this.f3785U = (Spinner) view;
            ManageEc2ProfileActivity.this.startActivityForResult(new Intent(ManageEc2ProfileActivity.this, (Class<?>) ManageIdentityActivity.class), 2);
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.ManageEc2ProfileActivity$c */
    /* loaded from: classes.dex */
    public class C1265c implements ViewPager.OnPageChangeListener {
        public C1265c() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ManageEc2ProfileActivity.this.f3782R.clear();
            ManageEc2ProfileActivity manageEc2ProfileActivity = ManageEc2ProfileActivity.this;
            ManageEc2ProfileActivity.super.onCreateOptionsMenu(manageEc2ProfileActivity.f3782R);
            if (i != 0) {
                ManageEc2ProfileActivity.this.getMenuInflater().inflate(R.menu.menu_manage_ec2_mapping, ManageEc2ProfileActivity.this.f3782R);
            } else {
                ManageEc2ProfileActivity.this.getMenuInflater().inflate(R.menu.menu_manage_ec2_profile, ManageEc2ProfileActivity.this.f3782R);
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.ManageEc2ProfileActivity$d */
    /* loaded from: classes.dex */
    public class C1266d extends vh0<String> {
        public C1266d(ManageEc2ProfileActivity manageEc2ProfileActivity, Context context, List list) {
            super(context, list);
        }

        @Override // cz.opentree.vh0, android.widget.Adapter
        public int getCount() {
            return m9225b();
        }

        @Override // cz.opentree.vh0, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f7462Q.inflate(R.layout.spinner_item, (ViewGroup) null, false);
            }
            ((TextView) view.findViewById(R.id.itemTitle)).setText((String) this.f7461P.get(i));
            return view;
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.ManageEc2ProfileActivity$e */
    /* loaded from: classes.dex */
    public class C1267e implements AdapterView.OnItemSelectedListener {

        /* renamed from: O */
        public final /* synthetic */ String[] f3790O;

        /* renamed from: P */
        public final /* synthetic */ TextView f3791P;

        public C1267e(ManageEc2ProfileActivity manageEc2ProfileActivity, String[] strArr, TextView textView) {
            this.f3790O = strArr;
            this.f3791P = textView;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == this.f3790O.length) {
                this.f3791P.setEnabled(true);
            } else {
                this.f3791P.setText("");
                this.f3791P.setEnabled(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            this.f3791P.setText("");
            this.f3791P.setEnabled(false);
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.ManageEc2ProfileActivity$f */
    /* loaded from: classes.dex */
    public class C1268f extends vh0<Identity> {
        public C1268f(ManageEc2ProfileActivity manageEc2ProfileActivity, Context context, List list) {
            super(context, list);
        }

        @Override // cz.opentree.vh0, android.widget.Adapter
        public int getCount() {
            return super.m9225b() + 2;
        }

        @Override // cz.opentree.vh0, android.widget.Adapter
        public Object getItem(int i) {
            if (i == 0 || i > m9225b()) {
                return null;
            }
            return super.getItem(i - 1);
        }

        @Override // cz.opentree.vh0, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f7462Q.inflate(R.layout.spinner_item, (ViewGroup) null, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.itemTitle);
            ImageView imageView = (ImageView) view.findViewById(R.id.itemIcon);
            imageView.setImageResource(R.drawable.ic_contact_picture);
            imageView.setVisibility(8);
            if (i == 0) {
                textView.setText("");
            } else if (i > super.m9225b()) {
                textView.setText(R.string.new_dot_dot_dot);
            } else {
                textView.setText(getItem(i).toString());
            }
            return view;
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.ManageEc2ProfileActivity$g */
    /* loaded from: classes.dex */
    public class C1269g implements AdapterView.OnItemSelectedListener {

        /* renamed from: O */
        public final /* synthetic */ Spinner f3792O;

        public C1269g(Spinner spinner) {
            this.f3792O = spinner;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [android.widget.Adapter] */
        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == adapterView.getAdapter().getCount() - 1) {
                ManageEc2ProfileActivity.this.f3786V.mo5244a(this.f3792O);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.ManageEc2ProfileActivity$h */
    /* loaded from: classes.dex */
    public class C1270h extends PagerAdapter {

        /* renamed from: a */
        public final Context f3794a;

        /* renamed from: b */
        public Ec2Profile f3795b;

        /* renamed from: d */
        public List<Ec2Mapping> f3797d;

        /* renamed from: j */
        public Spinner f3803j;

        /* renamed from: k */
        public TextView f3804k;

        /* renamed from: l */
        public TextView f3805l;

        /* renamed from: c */
        public ArrayList<View> f3796c = new ArrayList<>();

        /* renamed from: e */
        public HashMap<Ec2Mapping, List<Ec2Filter>> f3798e = new HashMap<>();

        /* renamed from: f */
        public HashMap<Ec2Mapping, List<Ec2GroupMapping>> f3799f = new HashMap<>();

        /* renamed from: g */
        public List<Ec2Mapping> f3800g = new ArrayList();

        /* renamed from: h */
        public HashMap<Ec2Mapping, List<Ec2Filter>> f3801h = new HashMap<>();

        /* renamed from: i */
        public HashMap<Ec2Mapping, List<Ec2GroupMapping>> f3802i = new HashMap<>();

        /* renamed from: cz.opentree.juicessh.activities.ManageEc2ProfileActivity$h$a */
        /* loaded from: classes.dex */
        public class a implements CompoundButton.OnCheckedChangeListener {
            public a() {
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C1270h.this.f3804k.setVisibility(8);
                C1270h.this.f3795b.disabledReason = null;
            }
        }

        /* renamed from: cz.opentree.juicessh.activities.ManageEc2ProfileActivity$h$b */
        /* loaded from: classes.dex */
        public class b implements View.OnClickListener {

            /* renamed from: cz.opentree.juicessh.activities.ManageEc2ProfileActivity$h$b$a */
            /* loaded from: classes.dex */
            public class a extends AsyncTask<String, Void, String[]> {

                /* renamed from: a */
                public String f3809a;

                /* renamed from: b */
                public String f3810b = "";

                public a() {
                }

                @Override // android.os.AsyncTask
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public String[] doInBackground(String... strArr) {
                    try {
                        this.f3809a = strArr[0];
                    } catch (IndexOutOfBoundsException unused) {
                        this.f3809a = null;
                    }
                    try {
                        String m7700a = qg0.m7700a(C1270h.this.f3795b.key, User.m5527u(C1270h.this.f3794a));
                        String m7700a2 = qg0.m7700a(C1270h.this.f3795b.secret, User.m5527u(C1270h.this.f3794a));
                        if (m7700a == null || m7700a2 == null) {
                            this.f3810b = C1270h.this.f3794a.getString(R.string.ec2exception_bad_credentials);
                            return null;
                        }
                        try {
                            DescribeRegionsResult mo288b = new AmazonEC2Client(new BasicAWSCredentials(m7700a, m7700a2)).mo288b();
                            ArrayList arrayList = new ArrayList();
                            Iterator<Region> it = mo288b.m315a().iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next().m486b());
                            }
                            Collections.sort(arrayList);
                            return (String[]) arrayList.toArray(new String[0]);
                        } catch (Exception e) {
                            e.printStackTrace();
                            if (e.getMessage().contains("Unable to execute HTTP request: Unable to resolve host")) {
                                this.f3810b = C1270h.this.f3794a.getString(R.string.ec2exception_bad_connection);
                                return null;
                            }
                            if (e.getMessage().contains("Unable to execute HTTP request: No peer certificate")) {
                                this.f3810b = C1270h.this.f3794a.getString(R.string.ec2exception_api_certificate_error);
                                return null;
                            }
                            if (e.getMessage().contains("AWS was not able to validate the provided access credentials")) {
                                this.f3810b = C1270h.this.f3794a.getString(R.string.ec2exception_bad_credentials);
                            }
                            return null;
                        }
                    } catch (qg0.C1762a unused2) {
                        this.f3810b = C1270h.this.f3794a.getString(R.string.ec2exception_bad_credentials);
                        return null;
                    } catch (NullPointerException unused3) {
                        this.f3810b = C1270h.this.f3794a.getString(R.string.ec2exception_bad_credentials);
                        return null;
                    }
                }

                @Override // android.os.AsyncTask
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public void onPostExecute(String[] strArr) {
                    if (strArr != null) {
                        C1270h c1270h = C1270h.this;
                        ManageEc2ProfileActivity.this.m5251s(c1270h.f3803j, C1270h.this.f3805l, strArr, this.f3809a);
                        Toast.makeText(C1270h.this.f3794a, C1270h.this.f3794a.getString(R.string.updated_regions), 1).show();
                    } else if (this.f3810b.isEmpty()) {
                        Toast.makeText(C1270h.this.f3794a, C1270h.this.f3794a.getString(R.string.unrecognized_failure), 1).show();
                    } else {
                        Toast.makeText(C1270h.this.f3794a, this.f3810b, 1).show();
                    }
                }
            }

            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new a().execute(C1270h.this.f3795b.region);
            }
        }

        /* renamed from: cz.opentree.juicessh.activities.ManageEc2ProfileActivity$h$c */
        /* loaded from: classes.dex */
        public class c implements View.OnFocusChangeListener {
            public c() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    C1270h.this.m5269B(view);
                } else {
                    C1270h.this.m5280w(view);
                }
            }
        }

        /* renamed from: cz.opentree.juicessh.activities.ManageEc2ProfileActivity$h$d */
        /* loaded from: classes.dex */
        public class d implements View.OnFocusChangeListener {
            public d() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    C1270h.this.m5270C(view);
                } else {
                    C1270h.this.m5281x(view);
                }
            }
        }

        public C1270h(Context context, Ec2Profile ec2Profile) {
            this.f3795b = ec2Profile;
            this.f3794a = context;
            boolean z = false;
            try {
                if (((Ec2Profile) C1328DB.m5404d(Ec2Profile.class, context).queryForId(ec2Profile.f3993id)) != null) {
                    z = true;
                }
            } catch (SQLException unused) {
            }
            if (z) {
                try {
                    this.f3797d = C1328DB.m5404d(Ec2Mapping.class, context).queryForEq("profile_id", ec2Profile.f3993id);
                } catch (SQLException unused2) {
                    this.f3797d = new ArrayList();
                }
            } else {
                ArrayList arrayList = new ArrayList();
                this.f3797d = arrayList;
                arrayList.add(new Ec2Mapping());
            }
            for (Ec2Mapping ec2Mapping : this.f3797d) {
                try {
                    this.f3798e.put(ec2Mapping, C1328DB.m5404d(Ec2Filter.class, context).queryForEq("mapping_id", ec2Mapping));
                    gj0.m4141b("ManageEc2ProfileActivity", "Found a total of " + this.f3798e.size() + " filters");
                } catch (SQLException unused3) {
                }
                try {
                    this.f3799f.put(ec2Mapping, C1328DB.m5404d(Ec2GroupMapping.class, context).queryForEq("mapping_id", ec2Mapping));
                    gj0.m4141b("ManageEc2ProfileActivity", "Found a total of " + this.f3799f.size() + " group mappings");
                } catch (SQLException unused4) {
                }
            }
        }

        /* renamed from: A */
        public void m5268A(ViewPager viewPager, int i) {
            if (i == 0) {
                return;
            }
            int i2 = i - 1;
            Ec2Mapping ec2Mapping = this.f3797d.get(i2);
            this.f3797d.remove(ec2Mapping);
            this.f3800g.add(ec2Mapping);
            if (this.f3799f.get(ec2Mapping) != null) {
                List<Ec2GroupMapping> list = this.f3802i.get(ec2Mapping);
                if (list == null) {
                    this.f3802i.put(ec2Mapping, this.f3799f.get(ec2Mapping));
                } else {
                    list.addAll(this.f3799f.get(ec2Mapping));
                    this.f3802i.put(ec2Mapping, list);
                }
                this.f3799f.remove(ec2Mapping);
            }
            if (this.f3798e.get(ec2Mapping) != null) {
                List<Ec2Filter> list2 = this.f3801h.get(ec2Mapping);
                if (list2 == null) {
                    this.f3801h.put(ec2Mapping, this.f3798e.get(ec2Mapping));
                } else {
                    list2.addAll(this.f3798e.get(ec2Mapping));
                    this.f3801h.put(ec2Mapping, list2);
                }
                this.f3798e.remove(ec2Mapping);
            }
            this.f3796c.remove(i);
            notifyDataSetChanged();
            if (viewPager.getCurrentItem() == i) {
                if (i < getCount() - 1) {
                    viewPager.setCurrentItem(i + 1);
                } else {
                    viewPager.setCurrentItem(i2);
                }
            }
            Ec2Link.m5631a(this.f3794a);
        }

        /* renamed from: B */
        public final void m5269B(View view) {
            EditText editText = (EditText) view;
            String str = this.f3795b.key;
            if (str != null) {
                try {
                    editText.setText(qg0.m7700a(str, User.m5527u(this.f3794a)));
                } catch (qg0.C1762a e) {
                    e.printStackTrace();
                }
            }
            editText.setHint("");
        }

        /* renamed from: C */
        public final void m5270C(View view) {
            EditText editText = (EditText) view;
            String str = this.f3795b.secret;
            if (str != null) {
                try {
                    editText.setText(qg0.m7700a(str, User.m5527u(this.f3794a)));
                } catch (qg0.C1762a e) {
                    e.printStackTrace();
                }
            }
            editText.setHint("");
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            try {
                if (i == 0) {
                    m5283z((ViewPager) viewGroup, i, obj);
                } else {
                    m5282y((ViewPager) viewGroup, i, obj);
                }
            } catch (IndexOutOfBoundsException unused) {
            }
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f3797d.size() + 1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            if (i == 0) {
                return ManageEc2ProfileActivity.this.getResources().getString(R.string.profile_overview);
            }
            return ManageEc2ProfileActivity.this.getResources().getString(R.string.mapping) + " " + i;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View inflate;
            String str;
            if (i < this.f3796c.size() && this.f3796c.get(i) != null) {
                View view = this.f3796c.get(i);
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                viewGroup.addView(view);
                return view;
            }
            if (i != 0) {
                inflate = m5272o(this.f3797d.get(i - 1));
            } else {
                inflate = ((LayoutInflater) this.f3794a.getSystemService("layout_inflater")).inflate(R.layout.manage_ec2profile_overview, (ViewGroup) null, false);
                EditText editText = (EditText) inflate.findViewById(R.id.name_value);
                CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.enabled);
                this.f3804k = (TextView) inflate.findViewById(R.id.ec2_disabled_reason);
                this.f3803j = (Spinner) inflate.findViewById(R.id.region_spinner);
                this.f3805l = (TextView) inflate.findViewById(R.id.custom_endpoint_value);
                ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.refresh_regions);
                EditText editText2 = (EditText) inflate.findViewById(R.id.ec2_key_value);
                EditText editText3 = (EditText) inflate.findViewById(R.id.ec2_secret_value);
                String str2 = this.f3795b.name;
                if (str2 != null) {
                    editText.setText(str2);
                }
                checkBox.setChecked(this.f3795b.isEnabled);
                Ec2Profile ec2Profile = this.f3795b;
                if (!ec2Profile.isEnabled && (str = ec2Profile.disabledReason) != null && !str.isEmpty()) {
                    this.f3804k.setText(this.f3795b.disabledReason);
                    this.f3804k.setVisibility(0);
                }
                checkBox.setOnCheckedChangeListener(new a());
                ManageEc2ProfileActivity.this.m5251s(this.f3803j, this.f3805l, Ec2Profile.regions, this.f3795b.region);
                imageButton.setOnClickListener(new b());
                if (this.f3795b.key != null) {
                    editText2.setHint(R.string.click_to_show);
                }
                if (this.f3795b.secret != null) {
                    editText3.setHint(R.string.click_to_show);
                }
                editText2.setOnFocusChangeListener(new c());
                editText3.setOnFocusChangeListener(new d());
            }
            if (i == this.f3796c.size()) {
                this.f3796c.add(inflate);
            } else if (i < this.f3796c.size()) {
                this.f3796c.set(i, inflate);
            }
            viewGroup.addView(inflate);
            return inflate;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }

        /* renamed from: n */
        public void m5271n() {
            Ec2Mapping ec2Mapping = new Ec2Mapping();
            ec2Mapping.profile = this.f3795b;
            this.f3797d.add(ec2Mapping);
            notifyDataSetChanged();
        }

        /* renamed from: o */
        public final ScrollView m5272o(Ec2Mapping ec2Mapping) {
            ScrollView scrollView = (ScrollView) ((LayoutInflater) this.f3794a.getSystemService("layout_inflater")).inflate(R.layout.manage_ec2profile_mapping, (ViewGroup) null, false);
            ArrayList<Ec2Filter> arrayList = this.f3798e.get(ec2Mapping) != null ? new ArrayList<>(this.f3798e.get(ec2Mapping)) : new ArrayList<>();
            gj0.m4141b("ManageEc2ProfileActivity", "Found " + arrayList.size() + " mapping specific filters");
            LinearLayout linearLayout = (LinearLayout) scrollView.findViewById(R.id.filter_selector_holder);
            vj0 vj0Var = new vj0(this.f3794a);
            vj0Var.m9253l(ManageEc2ProfileActivity.this.getString(R.string.filters) + ":");
            vj0Var.m9251j(ManageEc2ProfileActivity.this.getString(R.string.add_filter));
            vj0Var.m9252k(ec2Mapping);
            vj0Var.m9254m(Arrays.asList(Ec2Filter.filters), arrayList);
            linearLayout.addView(vj0Var);
            ArrayList arrayList2 = new ArrayList();
            if (this.f3799f.get(ec2Mapping) != null) {
                Iterator<Ec2GroupMapping> it = this.f3799f.get(ec2Mapping).iterator();
                while (it.hasNext()) {
                    try {
                        arrayList2.add(it.next().group.m5383m());
                    } catch (NullPointerException unused) {
                    }
                }
            }
            gj0.m4141b("ManageEc2ProfileActivity", "Found " + arrayList2.size() + " mapping specific groups");
            LinearLayout linearLayout2 = (LinearLayout) scrollView.findViewById(R.id.group_selector_holder);
            xj0 xj0Var = new xj0(this.f3794a);
            xj0Var.m9793n(ManageEc2ProfileActivity.this.getString(R.string.groups) + ":");
            xj0Var.m9791l(ManageEc2ProfileActivity.this.getString(R.string.add_group));
            xj0Var.m9792m(ManageEc2ProfileActivity.this.f3784T);
            try {
                List queryForAll = C1328DB.m5404d(ConnectionGroup.class, this.f3794a).queryForAll();
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ConnectionGroup connectionGroup = (ConnectionGroup) it2.next();
                    if (connectionGroup != null && connectionGroup.f3993id != null) {
                        Iterator it3 = queryForAll.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                ConnectionGroup connectionGroup2 = (ConnectionGroup) it3.next();
                                if (connectionGroup.f3993id.equals(connectionGroup2.f3993id)) {
                                    arrayList3.add(connectionGroup2);
                                    break;
                                }
                            }
                        }
                    }
                    it2.remove();
                }
                xj0Var.m9795p(queryForAll, arrayList3);
            } catch (SQLException unused2) {
            }
            linearLayout2.addView(xj0Var);
            ManageEc2ProfileActivity.this.m5252t((Spinner) scrollView.findViewById(R.id.type_spinner), ec2Mapping.defaultType);
            ManageEc2ProfileActivity.this.m5250r((Spinner) scrollView.findViewById(R.id.id_spinner), ec2Mapping.defaultIdentity);
            ManageEc2ProfileActivity.this.m5253u((Spinner) scrollView.findViewById(R.id.via_spinner), ec2Mapping.defaultConnectVia);
            ((CheckBox) scrollView.findViewById(R.id.private_ips)).setChecked(ec2Mapping.privateIps);
            if (ec2Mapping.defaultPort != 22) {
                ((EditText) scrollView.findViewById(R.id.port_value)).setText(String.valueOf(ec2Mapping.defaultPort));
            }
            return scrollView;
        }

        /* renamed from: p */
        public List<Ec2Filter> m5273p() {
            ArrayList arrayList = new ArrayList();
            for (List<Ec2Filter> list : this.f3801h.values()) {
                if (list != null && !list.isEmpty()) {
                    arrayList.addAll(list);
                }
            }
            return arrayList;
        }

        /* renamed from: q */
        public List<Ec2GroupMapping> m5274q() {
            ArrayList arrayList = new ArrayList();
            for (List<Ec2GroupMapping> list : this.f3802i.values()) {
                if (list != null && !list.isEmpty()) {
                    arrayList.addAll(list);
                }
            }
            return arrayList;
        }

        /* renamed from: r */
        public List<Ec2Mapping> m5275r() {
            return this.f3800g;
        }

        /* renamed from: s */
        public List<Ec2Filter> m5276s() {
            ArrayList arrayList = new ArrayList();
            for (List<Ec2Filter> list : this.f3798e.values()) {
                if (list != null && !list.isEmpty()) {
                    arrayList.addAll(list);
                }
            }
            return arrayList;
        }

        /* renamed from: t */
        public List<Ec2GroupMapping> m5277t() {
            ArrayList arrayList = new ArrayList();
            for (List<Ec2GroupMapping> list : this.f3799f.values()) {
                if (list != null && !list.isEmpty()) {
                    arrayList.addAll(list);
                }
            }
            return arrayList;
        }

        /* renamed from: u */
        public List<Ec2Mapping> m5278u() {
            return this.f3797d;
        }

        /* renamed from: v */
        public Ec2Profile m5279v() {
            return this.f3795b;
        }

        /* renamed from: w */
        public final void m5280w(View view) {
            EditText editText = (EditText) view;
            if (editText.getText() == null || editText.getText().toString().isEmpty()) {
                this.f3795b.key = null;
                editText.setHint("");
            } else {
                this.f3795b.key = qg0.m7702c(editText.getText().toString(), User.m5527u(this.f3794a));
                editText.setHint(R.string.click_to_show);
            }
            editText.setText("");
        }

        /* renamed from: x */
        public final void m5281x(View view) {
            EditText editText = (EditText) view;
            if (editText.getText() == null || editText.getText().toString().isEmpty()) {
                this.f3795b.secret = null;
                editText.setHint("");
            } else {
                this.f3795b.secret = qg0.m7702c(editText.getText().toString(), User.m5527u(this.f3794a));
                editText.setHint(R.string.click_to_show);
            }
            editText.setText("");
        }

        /* renamed from: y */
        public final void m5282y(ViewPager viewPager, int i, Object obj) {
            View view = (View) obj;
            Ec2Mapping ec2Mapping = this.f3797d.get(i - 1);
            if (this.f3798e.get(ec2Mapping) != null) {
                List<Ec2Filter> list = this.f3801h.get(ec2Mapping);
                if (list == null) {
                    this.f3801h.put(ec2Mapping, this.f3798e.get(ec2Mapping));
                } else {
                    list.addAll(this.f3798e.get(ec2Mapping));
                    this.f3801h.put(ec2Mapping, list);
                }
                this.f3798e.remove(ec2Mapping);
            }
            ArrayList<Ec2Filter> m9249h = ((vj0) ((LinearLayout) view.findViewById(R.id.filter_selector_holder)).getChildAt(0)).m9249h();
            this.f3798e.put(ec2Mapping, m9249h);
            List<Ec2Filter> list2 = this.f3801h.get(ec2Mapping);
            if (list2 != null) {
                list2.removeAll(m9249h);
                this.f3801h.put(ec2Mapping, list2);
            }
            ec2Mapping.defaultType = ((Integer) ((Pair) ((Spinner) view.findViewById(R.id.type_spinner)).getSelectedItem()).first).intValue();
            ec2Mapping.defaultIdentity = (Identity) ((Spinner) view.findViewById(R.id.id_spinner)).getSelectedItem();
            ec2Mapping.defaultConnectVia = (Connection) ((Spinner) view.findViewById(R.id.via_spinner)).getSelectedItem();
            ec2Mapping.privateIps = ((CheckBox) view.findViewById(R.id.private_ips)).isChecked();
            try {
                ec2Mapping.defaultPort = Integer.valueOf(((EditText) view.findViewById(R.id.port_value)).getText().toString()).intValue();
            } catch (NumberFormatException unused) {
                ec2Mapping.defaultPort = 22;
            }
            xj0 xj0Var = (xj0) ((LinearLayout) view.findViewById(R.id.group_selector_holder)).getChildAt(0);
            if (this.f3799f.get(ec2Mapping) != null) {
                List<Ec2GroupMapping> list3 = this.f3802i.get(ec2Mapping);
                if (list3 == null) {
                    this.f3802i.put(ec2Mapping, this.f3799f.get(ec2Mapping));
                } else {
                    list3.addAll(this.f3799f.get(ec2Mapping));
                    this.f3802i.put(ec2Mapping, list3);
                }
                this.f3799f.remove(ec2Mapping);
            }
            ArrayList arrayList = new ArrayList();
            List<Ec2GroupMapping> list4 = this.f3802i.get(ec2Mapping);
            Iterator it = xj0Var.m9788i().iterator();
            while (it.hasNext()) {
                ConnectionGroup connectionGroup = (ConnectionGroup) it.next();
                Ec2GroupMapping ec2GroupMapping = new Ec2GroupMapping();
                ec2GroupMapping.group = connectionGroup;
                ec2GroupMapping.mapping = ec2Mapping;
                if (list4 != null) {
                    Iterator<Ec2GroupMapping> it2 = list4.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Ec2GroupMapping next = it2.next();
                        ConnectionGroup connectionGroup2 = next.group;
                        if (connectionGroup2 != null && connectionGroup2.m5383m() != null && next.group.f3993id.equals(connectionGroup.f3993id)) {
                            ec2GroupMapping = next;
                            break;
                        }
                    }
                }
                arrayList.add(ec2GroupMapping);
                if (list4 != null) {
                    list4.remove(ec2GroupMapping);
                }
            }
            this.f3799f.put(ec2Mapping, arrayList);
            this.f3802i.put(ec2Mapping, list4);
        }

        /* renamed from: z */
        public final void m5283z(ViewPager viewPager, int i, Object obj) {
            View view = (View) obj;
            EditText editText = (EditText) view.findViewById(R.id.name_value);
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.enabled);
            Spinner spinner = (Spinner) view.findViewById(R.id.region_spinner);
            this.f3795b.name = editText.getText().toString();
            this.f3795b.isEnabled = checkBox.isChecked();
            if (spinner.getSelectedItemPosition() == spinner.getCount() - 1) {
                this.f3795b.region = this.f3805l.getText().toString();
            } else {
                this.f3795b.region = (String) spinner.getSelectedItem();
            }
        }
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        setContentView(R.layout.manage_ec2profile);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                if (extras.containsKey("ec2profile_id")) {
                    try {
                        this.f3780P = (Ec2Profile) C1328DB.m5404d(Ec2Profile.class, this).queryForId((UUID) extras.get("ec2profile_id"));
                    } catch (NullPointerException unused) {
                        setResult(0, new Intent());
                        finish();
                    } catch (SQLException unused2) {
                        setResult(0, new Intent());
                        finish();
                    }
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        this.f3781Q = viewPager;
        viewPager.setCurrentItem(0);
        this.f3781Q.setAdapter(new C1270h(this, this.f3780P));
        this.f3781Q.setOnPageChangeListener(new C1265c());
        getWindow().setSoftInputMode(2);
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    @Override // cz.opentree.util.SessionedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResult(int r9, int r10, android.content.Intent r11) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.juicessh.activities.ManageEc2ProfileActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // cz.opentree.util.SessionedActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.f3782R = menu;
        getMenuInflater().inflate(R.menu.menu_manage_ec2_profile, menu);
        return true;
    }

    @Override // cz.opentree.util.SessionedActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_item_add_mapping /* 2131296560 */:
                ((C1270h) this.f3781Q.getAdapter()).m5271n();
                return true;
            case R.id.menu_item_remove_mapping /* 2131296570 */:
                C1270h c1270h = (C1270h) this.f3781Q.getAdapter();
                ViewPager viewPager = this.f3781Q;
                c1270h.m5268A(viewPager, viewPager.getCurrentItem());
                return true;
            case R.id.menu_item_save /* 2131296571 */:
                m5255w();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* renamed from: r */
    public void m5250r(Spinner spinner, Identity identity) {
        List arrayList;
        try {
            arrayList = C1328DB.m5404d(Identity.class, this).queryForAll();
        } catch (SQLException unused) {
            arrayList = new ArrayList();
        }
        Collections.sort(arrayList);
        C1268f c1268f = new C1268f(this, this, arrayList);
        spinner.setAdapter((SpinnerAdapter) c1268f);
        if (identity != null && c1268f.getCount() > 2) {
            int i = 1;
            while (true) {
                if (i >= c1268f.getCount() - 1) {
                    break;
                }
                if (((Identity) c1268f.getItem(i)).f3993id.equals(identity.f3993id)) {
                    spinner.setSelection(i);
                    break;
                }
                i++;
            }
        }
        spinner.setOnItemSelectedListener(new C1269g(spinner));
    }

    /* renamed from: s */
    public final void m5251s(Spinner spinner, TextView textView, String[] strArr, String str) {
        int i = 0;
        if (str != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    i2 = 0;
                    break;
                } else {
                    if (Ec2Profile.regions[i2].equals(str)) {
                        i = 1;
                        break;
                    }
                    i2++;
                }
            }
            if (i == 0) {
                i = strArr.length;
                textView.setText(str);
            } else {
                i = i2;
            }
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        arrayList.add(getString(R.string.custom));
        spinner.setAdapter((SpinnerAdapter) new C1266d(this, this, arrayList));
        spinner.setOnItemSelectedListener(new C1267e(this, strArr, textView));
        spinner.setSelection(i);
    }

    /* renamed from: t */
    public void m5252t(Spinner spinner, int i) {
        jh0 jh0Var = new jh0(this);
        int i2 = 0;
        while (true) {
            if (i2 >= jh0Var.getCount()) {
                break;
            }
            if (((Integer) jh0Var.getItem(i2).first).intValue() == 2) {
                jh0Var.m5116c(jh0Var.getItem(i2));
                break;
            }
            i2++;
        }
        spinner.setAdapter((SpinnerAdapter) jh0Var);
        for (int i3 = 0; i3 < jh0Var.getCount(); i3++) {
            if (((Integer) jh0Var.getItem(i3).first).intValue() == i) {
                spinner.setSelection(i3);
                return;
            }
        }
    }

    /* renamed from: u */
    public void m5253u(Spinner spinner, Connection connection) {
        ih0 ih0Var = new ih0(this, null, true);
        spinner.setAdapter((SpinnerAdapter) ih0Var);
        if (connection != null) {
            spinner.setSelection(ih0Var.m4780b(connection));
        }
    }

    /* renamed from: v */
    public void m5254v(int i) {
        Toast.makeText(this, getString(i), 0).show();
    }

    /* renamed from: w */
    public void m5255w() {
        Ec2Profile m5279v;
        String str;
        C1270h c1270h = (C1270h) this.f3781Q.getAdapter();
        this.f3781Q.findFocus().clearFocus();
        ViewPager viewPager = this.f3781Q;
        c1270h.m5283z(viewPager, 0, c1270h.instantiateItem((ViewGroup) viewPager, 0));
        for (int i = 1; i < c1270h.getCount(); i++) {
            ViewPager viewPager2 = this.f3781Q;
            c1270h.m5282y(viewPager2, i, c1270h.instantiateItem((ViewGroup) viewPager2, i));
        }
        try {
            m5279v = c1270h.m5279v();
            str = m5279v.name;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (str != null && !str.isEmpty()) {
            String str2 = m5279v.region;
            if (str2 != null && !str2.isEmpty()) {
                String str3 = m5279v.key;
                if (str3 != null && !str3.isEmpty()) {
                    String str4 = m5279v.secret;
                    if (str4 != null && !str4.isEmpty()) {
                        m5279v.disabledReason = null;
                        C1328DB.m5404d(Ec2Profile.class, this).createOrUpdate(c1270h.m5279v());
                        for (Ec2Mapping ec2Mapping : c1270h.m5278u()) {
                            ec2Mapping.profile = c1270h.m5279v();
                            C1328DB.m5404d(Ec2Mapping.class, this).createOrUpdate(ec2Mapping);
                        }
                        Iterator<Ec2Filter> it = c1270h.m5276s().iterator();
                        while (it.hasNext()) {
                            C1328DB.m5404d(Ec2Filter.class, this).createOrUpdate(it.next());
                        }
                        Iterator<Ec2GroupMapping> it2 = c1270h.m5277t().iterator();
                        while (it2.hasNext()) {
                            C1328DB.m5404d(Ec2GroupMapping.class, this).createOrUpdate(it2.next());
                        }
                        try {
                            for (Ec2Mapping ec2Mapping2 : c1270h.m5275r()) {
                                ec2Mapping2.profile = c1270h.m5279v();
                                C1328DB.m5404d(Ec2Mapping.class, this).delete(ec2Mapping2);
                            }
                            Iterator<Ec2Filter> it3 = c1270h.m5273p().iterator();
                            while (it3.hasNext()) {
                                C1328DB.m5404d(Ec2Filter.class, this).delete(it3.next());
                            }
                            Iterator<Ec2GroupMapping> it4 = c1270h.m5274q().iterator();
                            while (it4.hasNext()) {
                                C1328DB.m5404d(Ec2GroupMapping.class, this).delete(it4.next());
                            }
                        } catch (SQLException unused) {
                        }
                        finish();
                        return;
                    }
                    m5254v(R.string.please_enter_an_aws_access_secret);
                    return;
                }
                m5254v(R.string.please_enter_an_aws_access_key);
                return;
            }
            m5254v(R.string.please_select_a_region);
            return;
        }
        m5254v(R.string.please_enter_a_profile_name);
    }
}
