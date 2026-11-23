package cz.opentree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import cz.opentree.limessh.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MultiSelectorItem.java */
/* loaded from: classes.dex */
public class yj0<ITEM> extends LinearLayout {

    /* renamed from: O */
    public Context f8256O;

    /* renamed from: P */
    public Spinner f8257P;

    /* renamed from: Q */
    public List<ITEM> f8258Q;

    public yj0(Context context) {
        super(context);
        this.f8258Q = new ArrayList();
        this.f8256O = context;
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.multi_selector_item, (ViewGroup) this, true);
        this.f8257P = (Spinner) findViewById(R.id.multi_selector_spinner);
    }

    /* renamed from: a */
    public int m10181a() {
        List<ITEM> list = this.f8258Q;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: b */
    public ITEM m10182b() throws NullPointerException {
        if (this.f8258Q.size() == 0) {
            throw new NullPointerException("No items in spinner");
        }
        if (this.f8257P.getSelectedItemPosition() == -1) {
            throw new NullPointerException("Nothing selected");
        }
        try {
            return this.f8258Q.get(this.f8257P.getSelectedItemPosition());
        } catch (Exception unused) {
            throw new NullPointerException("New item selected");
        }
    }

    /* renamed from: c */
    public void m10183c(View.OnClickListener onClickListener) {
        ((Button) findViewById(R.id.multi_selector_remove)).setOnClickListener(onClickListener);
    }

    /* renamed from: d */
    public void m10184d(ITEM item) {
        if (this.f8258Q.size() == 0) {
            return;
        }
        for (int i = 0; i < this.f8258Q.size(); i++) {
            if (this.f8258Q.get(i).hashCode() == item.hashCode()) {
                this.f8257P.setSelection(i);
            }
        }
    }

    /* renamed from: e */
    public void m10185e(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f8257P.setOnItemSelectedListener(onItemSelectedListener);
    }

    /* renamed from: f */
    public void m10186f(List<ITEM> list) {
        ITEM item;
        this.f8258Q = list;
        try {
            item = m10182b();
        } catch (NullPointerException unused) {
            item = null;
        }
        this.f8257P.setAdapter((SpinnerAdapter) new vh0(this.f8256O, list));
        try {
            m10184d(item);
        } catch (NullPointerException unused2) {
        }
    }
}
