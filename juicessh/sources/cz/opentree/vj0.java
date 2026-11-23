package cz.opentree;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import cz.opentree.limessh.R;
import cz.opentree.limessh.models.ec2link.Ec2Filter;
import cz.opentree.limessh.models.ec2link.Ec2Mapping;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: FilterMultiSelector.java */
/* loaded from: classes.dex */
public class vj0 extends LinearLayout {

    /* renamed from: b0 */
    public static String f7478b0 = "MappingMultiSelector";

    /* renamed from: O */
    public List<String> f7479O;

    /* renamed from: P */
    public TextView f7480P;

    /* renamed from: Q */
    public LinearLayout f7481Q;

    /* renamed from: R */
    public Button f7482R;

    /* renamed from: S */
    public int f7483S;

    /* renamed from: T */
    public ArrayList<wj0> f7484T;

    /* renamed from: U */
    public Context f7485U;

    /* renamed from: V */
    public Ec2Mapping f7486V;

    /* renamed from: W */
    public View.OnClickListener f7487W;

    /* renamed from: a0 */
    public View.OnClickListener f7488a0;

    /* compiled from: FilterMultiSelector.java */
    /* renamed from: cz.opentree.vj0$a */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC2173a implements View.OnClickListener {

        /* compiled from: FilterMultiSelector.java */
        /* renamed from: cz.opentree.vj0$a$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: O */
            public final /* synthetic */ ScrollView f7490O;

            public a(ScrollView scrollView) {
                this.f7490O = scrollView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f7490O.smoothScrollTo(0, vj0.this.f7482R.getBottom());
            }
        }

        public ViewOnClickListenerC2173a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            wj0 wj0Var = new wj0(vj0.this.f7485U);
            wj0Var.m9573c(vj0.this.f7486V);
            wj0Var.m9575e(vj0.this.f7479O);
            wj0Var.m9574d(vj0.this.f7488a0);
            vj0.this.f7481Q.addView(wj0Var, vj0.this.f7481Q.getChildCount() - 1);
            vj0.this.f7484T.add(wj0Var);
            for (View view2 = (View) vj0.this.f7481Q.getParent(); view2 != null; view2 = (View) view2.getParent()) {
                if (view2.getClass().equals(ScrollView.class)) {
                    new Handler().post(new a((ScrollView) view2));
                    return;
                }
            }
        }
    }

    /* compiled from: FilterMultiSelector.java */
    /* renamed from: cz.opentree.vj0$b */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC2174b implements View.OnClickListener {
        public ViewOnClickListenerC2174b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (vj0.this.f7483S == -1 || vj0.this.f7484T.size() > vj0.this.f7483S) {
                wj0 wj0Var = (wj0) view.getParent().getParent();
                vj0.this.f7481Q.removeView(wj0Var);
                vj0.this.f7484T.remove(wj0Var);
            }
        }
    }

    public vj0(Context context) {
        super(context);
        this.f7483S = -1;
        this.f7484T = new ArrayList<>();
        this.f7487W = new ViewOnClickListenerC2173a();
        this.f7488a0 = new ViewOnClickListenerC2174b();
        this.f7485U = context;
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.multi_selector, (ViewGroup) this, true);
        this.f7480P = (TextView) findViewById(R.id.multi_selector_title);
        Button button = (Button) findViewById(R.id.multi_selector_add);
        this.f7482R = button;
        button.setOnClickListener(this.f7487W);
        this.f7481Q = (LinearLayout) findViewById(R.id.multi_selector_form);
    }

    /* renamed from: h */
    public ArrayList<Ec2Filter> m9249h() {
        ArrayList<Ec2Filter> arrayList = new ArrayList<>();
        Iterator<wj0> it = this.f7484T.iterator();
        while (it.hasNext()) {
            try {
                Ec2Filter m9571a = it.next().m9571a();
                m9571a.mapping = this.f7486V;
                arrayList.add(m9571a);
            } catch (NullPointerException unused) {
                gj0.m4141b(f7478b0, "Nothing selected");
            }
        }
        return arrayList;
    }

    /* renamed from: i */
    public void m9250i() {
        Iterator<wj0> it = this.f7484T.iterator();
        while (it.hasNext()) {
            this.f7481Q.removeView(it.next());
        }
        this.f7484T.clear();
    }

    /* renamed from: j */
    public void m9251j(String str) {
        this.f7482R.setText(str);
    }

    /* renamed from: k */
    public void m9252k(Ec2Mapping ec2Mapping) {
        this.f7486V = ec2Mapping;
    }

    /* renamed from: l */
    public void m9253l(String str) {
        this.f7480P.setText(str);
    }

    /* renamed from: m */
    public void m9254m(List<String> list, ArrayList<Ec2Filter> arrayList) {
        m9250i();
        m9255n(list);
        Iterator<Ec2Filter> it = arrayList.iterator();
        while (it.hasNext()) {
            Ec2Filter next = it.next();
            wj0 wj0Var = new wj0(this.f7485U);
            wj0Var.m9573c(this.f7486V);
            wj0Var.m9575e(list);
            wj0Var.m9574d(this.f7488a0);
            this.f7481Q.addView(wj0Var, r2.getChildCount() - 1);
            this.f7484T.add(wj0Var);
            wj0Var.m9572b(next);
        }
    }

    /* renamed from: n */
    public void m9255n(List<String> list) {
        this.f7479O = list;
        Iterator<wj0> it = this.f7484T.iterator();
        while (it.hasNext()) {
            it.next().m9575e(list);
        }
    }
}
