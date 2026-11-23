package com.sonelli;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.viewpager.widget.PagerAdapter;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.activities.TerminalEmulatorActivity;
import com.sonelli.juicessh.adapters.FrequentlyUsedListAdapter;
import com.sonelli.juicessh.models.Connection;
import com.sonelli.juicessh.models.ConnectionCounter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FixedFrequentlyUsedPagerAdapter.java */
/* loaded from: classes.dex */
public class kh0 extends PagerAdapter implements FrequentlyUsedListAdapter.FrequentlyUsedCounterProvider {

    /* renamed from: a */
    public Context f4539a;

    /* renamed from: b */
    public ViewGroup f4540b;

    /* renamed from: c */
    public LayoutInflater f4541c;

    /* renamed from: e */
    public int f4543e;

    /* renamed from: f */
    public int f4544f;

    /* renamed from: d */
    public int f4542d = 0;

    /* renamed from: g */
    public SparseArray<View> f4545g = new SparseArray<>();

    /* renamed from: h */
    public List<ConnectionCounter> f4546h = new ArrayList();

    /* renamed from: i */
    public AdapterView.OnItemClickListener f4547i = new C1452a();

    /* compiled from: FixedFrequentlyUsedPagerAdapter.java */
    /* renamed from: com.sonelli.kh0$a */
    /* loaded from: classes.dex */
    public class C1452a implements AdapterView.OnItemClickListener {
        public C1452a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Connection m5383m = ((ConnectionCounter) adapterView.getItemAtPosition(i)).connection.m5383m();
            Intent intent = new Intent(kh0.this.f4539a, (Class<?>) TerminalEmulatorActivity.class);
            intent.setData(Uri.parse("ssh://" + m5383m.f3993id.toString()));
            intent.putExtra("background", false);
            kh0.this.f4539a.startActivity(intent);
        }
    }

    /* compiled from: FixedFrequentlyUsedPagerAdapter.java */
    /* renamed from: com.sonelli.kh0$b */
    /* loaded from: classes.dex */
    public class AsyncTaskC1453b extends AsyncTask<Void, Void, List<ConnectionCounter>> {
        public AsyncTaskC1453b() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<ConnectionCounter> doInBackground(Void... voidArr) {
            return ConnectionCounter.m5473r(kh0.this.f4539a, 100L);
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(List<ConnectionCounter> list) {
            super.onPostExecute(kh0.this.f4546h);
            kh0.this.f4546h = list;
            kh0.this.f4542d = (int) Math.ceil(r3.f4546h.size() / kh0.this.f4543e);
            for (int i = 0; i < kh0.this.f4545g.size(); i++) {
                try {
                    ((FrequentlyUsedListAdapter) ((C1454c) ((View) kh0.this.f4545g.get(kh0.this.f4545g.keyAt(i))).getTag()).f4553d.getAdapter()).m5346b();
                } catch (NullPointerException unused) {
                }
            }
            kh0.this.notifyDataSetChanged();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    /* compiled from: FixedFrequentlyUsedPagerAdapter.java */
    /* renamed from: com.sonelli.kh0$c */
    /* loaded from: classes.dex */
    public class C1454c {

        /* renamed from: a */
        public FrameLayout f4550a;

        /* renamed from: b */
        public ImageView f4551b;

        /* renamed from: c */
        public ImageView f4552c;

        /* renamed from: d */
        public ListView f4553d;

        /* renamed from: e */
        public LinearLayout f4554e;

        /* renamed from: f */
        public LinearLayout f4555f;

        public C1454c(kh0 kh0Var) {
        }

        public /* synthetic */ C1454c(kh0 kh0Var, C1452a c1452a) {
            this(kh0Var);
        }
    }

    public kh0(Context context, ViewGroup viewGroup, int i) {
        this.f4539a = context;
        this.f4540b = viewGroup;
        this.f4541c = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f4543e = i;
        this.f4544f = Math.round(TypedValue.applyDimension(1, 55.0f, context.getResources().getDisplayMetrics()));
    }

    @Override // com.sonelli.juicessh.adapters.FrequentlyUsedListAdapter.FrequentlyUsedCounterProvider
    /* renamed from: a */
    public List<ConnectionCounter> mo5347a(int i) {
        if (this.f4546h.isEmpty()) {
            return new ArrayList();
        }
        int size = this.f4546h.size();
        int i2 = this.f4543e;
        if (size < i * i2) {
            return new ArrayList();
        }
        int i3 = i * i2;
        int min = Math.min(i2, this.f4546h.size() - i3);
        if (min < 0) {
            min = 0;
        }
        return this.f4546h.subList(i3, min + i3);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        try {
            this.f4545g.remove(i);
            viewGroup.removeView((View) obj);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return Math.max(1, this.f4542d);
    }

    /* renamed from: h */
    public int m5898h() {
        int i;
        int i2;
        if (this.f4546h.size() == 0) {
            i2 = this.f4544f;
            i = this.f4543e;
        } else {
            int size = this.f4546h.size();
            i = this.f4543e;
            if (size > i) {
                i2 = this.f4544f;
            } else {
                i2 = this.f4544f;
                i = this.f4546h.size();
            }
        }
        return i2 * i;
    }

    /* renamed from: i */
    public void m5899i() {
        new AsyncTaskC1453b().execute(new Void[0]);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.f4545g.get(i);
        if (view == null || view.getTag() == null) {
            View inflate = this.f4541c.inflate(R.layout.indicated_page, (ViewGroup) null, false);
            C1454c c1454c = new C1454c(this, null);
            c1454c.f4550a = (FrameLayout) inflate.findViewById(R.id.content);
            c1454c.f4551b = (ImageView) inflate.findViewById(R.id.left_indicator);
            c1454c.f4552c = (ImageView) inflate.findViewById(R.id.right_indicator);
            LinearLayout linearLayout = (LinearLayout) this.f4541c.inflate(R.layout.frequently_used_page, (ViewGroup) null, false);
            c1454c.f4553d = (ListView) linearLayout.findViewById(R.id.page_list);
            c1454c.f4554e = (LinearLayout) linearLayout.findViewById(R.id.empty);
            c1454c.f4555f = (LinearLayout) linearLayout.findViewById(R.id.loading);
            c1454c.f4550a.addView(linearLayout);
            c1454c.f4553d.setEmptyView(c1454c.f4555f);
            c1454c.f4553d.setAdapter((ListAdapter) new FrequentlyUsedListAdapter(this.f4539a, this, i));
            c1454c.f4553d.setOnItemClickListener(this.f4547i);
            c1454c.f4553d.setDivider(this.f4539a.getResources().getDrawable(R.drawable.highlight));
            if (i == 0) {
                c1454c.f4551b.setVisibility(4);
            }
            if (i == getCount() - 1) {
                c1454c.f4552c.setVisibility(4);
            }
            inflate.setTag(c1454c);
            viewGroup.addView(inflate, 0);
            this.f4545g.put(i, inflate);
        }
        return this.f4545g.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        View view;
        super.notifyDataSetChanged();
        this.f4540b.setLayoutParams(new LinearLayout.LayoutParams(-1, m5898h()));
        if (this.f4545g.size() <= 0 || (view = this.f4545g.get(0)) == null) {
            return;
        }
        C1454c c1454c = (C1454c) view.getTag();
        if (this.f4545g.size() > 1) {
            c1454c.f4552c.setVisibility(0);
        }
        c1454c.f4553d.getEmptyView().setVisibility(8);
        if (c1454c.f4553d.getCount() > 0) {
            c1454c.f4553d.setVisibility(0);
            c1454c.f4554e.setVisibility(8);
        } else {
            c1454c.f4553d.setVisibility(8);
            c1454c.f4554e.setVisibility(0);
        }
    }
}
