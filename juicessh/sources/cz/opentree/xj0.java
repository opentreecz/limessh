package cz.opentree;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import cz.opentree.juicessh.R;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: MultiSelector.java */
/* loaded from: classes.dex */
public class xj0<ITEM extends Comparable<ITEM>> extends LinearLayout {

    /* renamed from: c0 */
    public static String f7972c0 = "MultiSelector";

    /* renamed from: O */
    public List<ITEM> f7973O;

    /* renamed from: P */
    public TextView f7974P;

    /* renamed from: Q */
    public LinearLayout f7975Q;

    /* renamed from: R */
    public Button f7976R;

    /* renamed from: S */
    public int f7977S;

    /* renamed from: T */
    public ArrayList<yj0<ITEM>> f7978T;

    /* renamed from: U */
    public Context f7979U;

    /* renamed from: V */
    public AbstractC2296d f7980V;

    /* renamed from: W */
    public View.OnClickListener f7981W;

    /* renamed from: a0 */
    public AdapterView.OnItemSelectedListener f7982a0;

    /* renamed from: b0 */
    public View.OnClickListener f7983b0;

    /* compiled from: MultiSelector.java */
    /* renamed from: cz.opentree.xj0$a */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC2293a implements View.OnClickListener {

        /* compiled from: MultiSelector.java */
        /* renamed from: cz.opentree.xj0$a$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: O */
            public final /* synthetic */ ScrollView f7985O;

            public a(ScrollView scrollView) {
                this.f7985O = scrollView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f7985O.smoothScrollTo(0, xj0.this.f7976R.getBottom());
            }
        }

        public ViewOnClickListenerC2293a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            yj0 yj0Var = new yj0(xj0.this.f7979U);
            yj0Var.m10186f(xj0.this.f7973O);
            yj0Var.m10183c(xj0.this.f7983b0);
            yj0Var.m10185e(xj0.this.f7982a0);
            xj0.this.f7975Q.addView(yj0Var, xj0.this.f7975Q.getChildCount() - 1);
            xj0.this.f7978T.add(yj0Var);
            for (View view2 = (View) xj0.this.f7975Q.getParent(); view2 != null; view2 = (View) view2.getParent()) {
                if (view2.getClass().equals(ScrollView.class)) {
                    new Handler().post(new a((ScrollView) view2));
                    return;
                }
            }
        }
    }

    /* compiled from: MultiSelector.java */
    /* renamed from: cz.opentree.xj0$b */
    /* loaded from: classes.dex */
    public class C2294b implements AdapterView.OnItemSelectedListener {
        public C2294b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            Spinner spinner = (Spinner) adapterView;
            yj0 yj0Var = (yj0) spinner.getParent().getParent();
            if (yj0Var.m10181a() == 0) {
                if (spinner.getSelectedItemPosition() > 0) {
                    xj0.this.f7980V.mo5244a(yj0Var);
                }
            } else if (spinner.getSelectedItemPosition() >= yj0Var.m10181a()) {
                xj0.this.f7980V.mo5244a(yj0Var);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: MultiSelector.java */
    /* renamed from: cz.opentree.xj0$c */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC2295c implements View.OnClickListener {
        public ViewOnClickListenerC2295c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (xj0.this.f7977S == -1 || xj0.this.f7978T.size() > xj0.this.f7977S) {
                yj0 yj0Var = (yj0) view.getParent().getParent();
                xj0.this.f7975Q.removeView(yj0Var);
                xj0.this.f7978T.remove(yj0Var);
            }
        }
    }

    /* compiled from: MultiSelector.java */
    /* renamed from: cz.opentree.xj0$d */
    /* loaded from: classes.dex */
    public static abstract class AbstractC2296d {
        /* renamed from: a */
        public abstract void mo5244a(View view);
    }

    public xj0(Context context) {
        super(context);
        this.f7977S = -1;
        this.f7978T = new ArrayList<>();
        this.f7981W = new ViewOnClickListenerC2293a();
        this.f7982a0 = new C2294b();
        this.f7983b0 = new ViewOnClickListenerC2295c();
        this.f7979U = context;
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.multi_selector, (ViewGroup) this, true);
        this.f7974P = (TextView) findViewById(R.id.multi_selector_title);
        Button button = (Button) findViewById(R.id.multi_selector_add);
        this.f7976R = button;
        button.setOnClickListener(this.f7981W);
        this.f7975Q = (LinearLayout) findViewById(R.id.multi_selector_form);
    }

    /* renamed from: i */
    public ArrayList<ITEM> m9788i() {
        ArrayList<ITEM> arrayList = new ArrayList<>();
        Iterator<yj0<ITEM>> it = this.f7978T.iterator();
        while (it.hasNext()) {
            yj0<ITEM> next = it.next();
            try {
                if (!arrayList.contains(next.m10182b())) {
                    arrayList.add(next.m10182b());
                }
            } catch (NullPointerException unused) {
                gj0.m4141b(f7972c0, "Nothing selected");
            }
        }
        return arrayList;
    }

    /* renamed from: j */
    public void m9789j() {
        TextView textView = this.f7974P;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* renamed from: k */
    public void m9790k() {
        Iterator<yj0<ITEM>> it = this.f7978T.iterator();
        while (it.hasNext()) {
            this.f7975Q.removeView(it.next());
        }
        this.f7978T.clear();
    }

    /* renamed from: l */
    public void m9791l(String str) {
        this.f7976R.setText(str);
    }

    /* renamed from: m */
    public void m9792m(AbstractC2296d abstractC2296d) {
        this.f7980V = abstractC2296d;
    }

    /* renamed from: n */
    public void m9793n(String str) {
        this.f7974P.setText(str);
    }

    /* renamed from: o */
    public void m9794o(List<ITEM> list) {
        Collections.sort(list);
        this.f7973O = list;
        Iterator<yj0<ITEM>> it = this.f7978T.iterator();
        while (it.hasNext()) {
            it.next().m10186f(list);
        }
    }

    /* renamed from: p */
    public void m9795p(List<ITEM> list, ArrayList<ITEM> arrayList) {
        m9790k();
        m9794o(list);
        Iterator<ITEM> it = arrayList.iterator();
        while (it.hasNext()) {
            ITEM next = it.next();
            yj0<ITEM> yj0Var = new yj0<>(this.f7979U);
            yj0Var.m10186f(list);
            yj0Var.m10183c(this.f7983b0);
            yj0Var.m10185e(this.f7982a0);
            this.f7975Q.addView(yj0Var, r2.getChildCount() - 1);
            this.f7978T.add(yj0Var);
            yj0Var.m10184d(next);
        }
    }
}
