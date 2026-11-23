package cz.opentree.juicessh.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cz.opentree.gj0;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.ConnectionCounter;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class FrequentlyUsedListAdapter extends ArrayAdapter<ConnectionCounter> {

    /* renamed from: O */
    public Context f3951O;

    /* renamed from: P */
    public LayoutInflater f3952P;

    /* renamed from: Q */
    public FrequentlyUsedCounterProvider f3953Q;

    /* renamed from: R */
    public int f3954R;

    /* renamed from: S */
    public List<ConnectionCounter> f3955S;

    /* loaded from: classes.dex */
    public interface FrequentlyUsedCounterProvider {
        /* renamed from: a */
        List<ConnectionCounter> mo5347a(int i);
    }

    /* renamed from: cz.opentree.juicessh.adapters.FrequentlyUsedListAdapter$b */
    /* loaded from: classes.dex */
    public class C1316b {

        /* renamed from: a */
        public TextView f3956a;

        /* renamed from: b */
        public TextView f3957b;

        /* renamed from: c */
        public TextView f3958c;

        public C1316b(FrequentlyUsedListAdapter frequentlyUsedListAdapter) {
        }
    }

    public FrequentlyUsedListAdapter(Context context, FrequentlyUsedCounterProvider frequentlyUsedCounterProvider, int i) {
        super(context, R.layout.frequently_used_item);
        this.f3951O = context;
        this.f3952P = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f3953Q = frequentlyUsedCounterProvider;
        this.f3954R = i;
        List<ConnectionCounter> mo5347a = frequentlyUsedCounterProvider.mo5347a(i);
        this.f3955S = mo5347a;
        m5345a(mo5347a);
    }

    /* renamed from: a */
    public void m5345a(List<ConnectionCounter> list) {
        Iterator<ConnectionCounter> it = list.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    /* renamed from: b */
    public void m5346b() {
        clear();
        List<ConnectionCounter> mo5347a = this.f3953Q.mo5347a(this.f3954R);
        this.f3955S = mo5347a;
        m5345a(mo5347a);
        notifyDataSetChanged();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f3952P.inflate(R.layout.frequently_used_item, viewGroup, false);
            view.setPadding(0, 0, 0, 0);
        }
        C1316b c1316b = (C1316b) view.getTag();
        if (c1316b == null) {
            c1316b = new C1316b();
            c1316b.f3956a = (TextView) view.findViewById(R.id.itemTitle);
            c1316b.f3957b = (TextView) view.findViewById(R.id.itemSubtitle);
            c1316b.f3958c = (TextView) view.findViewById(R.id.itemIcon);
            c1316b.f3958c.setTypeface(Typeface.createFromAsset(this.f3951O.getAssets(), "fonts/fontawesome-webfont.ttf"));
            if (c1316b.f3956a != null) {
                if (!((c1316b.f3957b == null) | (c1316b.f3958c == null))) {
                    view.setTag(c1316b);
                }
            }
            gj0.m4142c("FrequentlyUsedListAdapter", "Failed to inflate page " + this.f3954R + " position " + i);
            return getView(i, null, viewGroup);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c1316b.f3958c.getLayoutParams();
        layoutParams.setMargins(0, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        c1316b.f3958c.setLayoutParams(layoutParams);
        try {
            c1316b.f3956a.setText(getItem(i).connection.toString());
            int i2 = getItem(i).count;
            if (i2 == 1) {
                c1316b.f3957b.setText(this.f3951O.getString(R.string.connected_once));
            } else if (i2 != 2) {
                c1316b.f3957b.setText(String.format(this.f3951O.getString(R.string.connected_x_times), Integer.valueOf(getItem(i).count)));
            } else {
                c1316b.f3957b.setText(this.f3951O.getString(R.string.connected_twice));
            }
            return view;
        } catch (NullPointerException unused) {
            gj0.m4142c("FrequentlyUsedListAdapter", "Found invalid ConnectionCounter at page " + this.f3954R + " position " + i);
            return new View(this.f3951O);
        }
    }
}
