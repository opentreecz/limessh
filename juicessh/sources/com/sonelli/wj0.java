package com.sonelli;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.models.ec2link.Ec2Filter;
import com.sonelli.juicessh.models.ec2link.Ec2Mapping;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: FilterMultiSelectorItem.java */
/* loaded from: classes.dex */
public class wj0 extends LinearLayout {

    /* renamed from: O */
    public Spinner f7752O;

    /* renamed from: P */
    public EditText f7753P;

    /* renamed from: Q */
    public Ec2Filter f7754Q;

    /* renamed from: R */
    public List<String> f7755R;

    /* compiled from: FilterMultiSelectorItem.java */
    /* renamed from: com.sonelli.wj0$a */
    /* loaded from: classes.dex */
    public class C2227a extends vh0<String> {
        public C2227a(wj0 wj0Var, Context context, List list) {
            super(context, list);
        }

        @Override // com.sonelli.vh0, android.widget.Adapter
        public int getCount() {
            return m9225b();
        }

        @Override // com.sonelli.vh0, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f7462Q.inflate(R.layout.spinner_item, (ViewGroup) null, false);
            }
            ((TextView) view.findViewById(R.id.itemTitle)).setText((String) this.f7461P.get(i));
            return view;
        }
    }

    /* compiled from: FilterMultiSelectorItem.java */
    /* renamed from: com.sonelli.wj0$b */
    /* loaded from: classes.dex */
    public class C2228b extends vh0<String> {
        public C2228b(wj0 wj0Var, Context context, List list) {
            super(context, list);
        }

        @Override // com.sonelli.vh0, android.widget.Adapter
        public int getCount() {
            return m9225b();
        }

        @Override // com.sonelli.vh0, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f7462Q.inflate(R.layout.spinner_item, (ViewGroup) null, false);
            }
            ((TextView) view.findViewById(R.id.itemTitle)).setText((String) this.f7461P.get(i));
            return view;
        }
    }

    public wj0(Context context) {
        super(context);
        this.f7754Q = new Ec2Filter();
        this.f7755R = new ArrayList();
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.mapping_multi_selector_item, (ViewGroup) this, true);
        this.f7752O = (Spinner) findViewById(R.id.mapping_multi_selector_spinner);
        this.f7753P = (EditText) findViewById(R.id.mapping_multi_selector_text);
        this.f7752O.setAdapter((SpinnerAdapter) new C2227a(this, context, this.f7755R));
    }

    /* renamed from: a */
    public Ec2Filter m9571a() throws NullPointerException {
        if (this.f7752O.getSelectedItemPosition() == -1) {
            throw new NullPointerException("No filter");
        }
        if (this.f7753P.getText().toString().isEmpty()) {
            throw new NullPointerException("No pattern");
        }
        try {
            this.f7754Q.key = this.f7755R.get(this.f7752O.getSelectedItemPosition());
            this.f7754Q.pattern = this.f7753P.getText().toString();
            return this.f7754Q;
        } catch (Exception unused) {
            throw new NullPointerException("New item selected");
        }
    }

    /* renamed from: b */
    public void m9572b(Ec2Filter ec2Filter) {
        if (this.f7755R.size() == 0) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= ((vh0) this.f7752O.getAdapter()).m9225b()) {
                break;
            }
            if (this.f7752O.getItemAtPosition(i).equals(ec2Filter.key)) {
                this.f7752O.setSelection(i);
                break;
            }
            i++;
        }
        this.f7753P.setText(ec2Filter.pattern);
        this.f7754Q = ec2Filter;
    }

    /* renamed from: c */
    public void m9573c(Ec2Mapping ec2Mapping) {
        this.f7754Q.mapping = ec2Mapping;
    }

    /* renamed from: d */
    public void m9574d(View.OnClickListener onClickListener) {
        ((Button) findViewById(R.id.multi_selector_remove)).setOnClickListener(onClickListener);
    }

    /* renamed from: e */
    public void m9575e(List<String> list) {
        this.f7755R = list;
        String str = null;
        try {
            if (((vh0) this.f7752O.getAdapter()).m9225b() > 0) {
                str = (String) this.f7752O.getSelectedItem();
            }
        } catch (NullPointerException unused) {
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        if (arrayList.size() == 0) {
            arrayList.add(getContext().getString(R.string.select_one));
        }
        arrayList.add(getContext().getString(R.string.new_dot_dot_dot));
        this.f7752O.setAdapter((SpinnerAdapter) new C2228b(this, getContext(), list));
        for (int i = 0; i < ((vh0) this.f7752O.getAdapter()).m9225b(); i++) {
            if (this.f7752O.getItemAtPosition(i).equals(str)) {
                this.f7752O.setSelection(i);
                return;
            }
        }
    }
}
