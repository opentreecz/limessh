package cz.opentree.juicessh.fragments;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cz.opentree.gh0;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.Config;
import cz.opentree.juicessh.models.User;
import cz.opentree.juicessh.receivers.SyncProgressReceiver;
import cz.opentree.juicessh.services.CloudSync;
import cz.opentree.juicessh.views.CardListItem;
import cz.opentree.pi0;
import cz.opentree.util.RetryPrompt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ManageCloudSyncFragment extends Fragment {

    /* renamed from: X */
    public static int f3999X = 0;

    /* renamed from: Y */
    public static int f4000Y = 1;

    /* renamed from: Z */
    public static int f4001Z = 2;

    /* renamed from: a0 */
    public static int f4002a0 = 3;

    /* renamed from: b0 */
    public static int f4003b0 = 4;

    /* renamed from: O */
    public SyncProgressReceiver f4004O;

    /* renamed from: P */
    public C1339k f4005P;

    /* renamed from: Q */
    public C1339k f4006Q;

    /* renamed from: R */
    public View f4007R;

    /* renamed from: S */
    public View f4008S;

    /* renamed from: T */
    public View f4009T;

    /* renamed from: U */
    public LayoutInflater f4010U;

    /* renamed from: V */
    public final Handler f4011V = new Handler();

    /* renamed from: W */
    public gh0 f4012W;

    /* loaded from: classes.dex */
    public interface OnToggleChangedListener {
        /* renamed from: a */
        void mo5418a(boolean z);
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$a */
    /* loaded from: classes.dex */
    public class C1329a implements OnToggleChangedListener {

        /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$a$a */
        /* loaded from: classes.dex */
        public class a implements User.OnPasswordChangedListener {
            public a() {
            }

            @Override // cz.opentree.juicessh.models.User.OnPasswordChangedListener
            /* renamed from: a */
            public void mo5419a(boolean z) {
                if (z) {
                    return;
                }
                ManageCloudSyncFragment.this.f4005P.m5430f(false);
            }
        }

        public C1329a() {
        }

        @Override // cz.opentree.juicessh.fragments.ManageCloudSyncFragment.OnToggleChangedListener
        /* renamed from: a */
        public void mo5418a(boolean z) {
            if (z && User.m5530z(ManageCloudSyncFragment.this.getActivity())) {
                User.m5524G(ManageCloudSyncFragment.this.getActivity(), R.string.cloudsync_passphrase_required, new a());
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$b */
    /* loaded from: classes.dex */
    public class C1330b implements SyncProgressReceiver.OnSyncCompleteListener {
        public C1330b() {
        }

        @Override // cz.opentree.juicessh.receivers.SyncProgressReceiver.OnSyncCompleteListener
        /* renamed from: a */
        public void mo5420a() {
            ManageCloudSyncFragment.this.m5411l();
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$c */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1331c implements View.OnClickListener {
        public ViewOnClickListenerC1331c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            User.m5524G(ManageCloudSyncFragment.this.getActivity(), R.string.cloudsync_passphrase_required, null);
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$d */
    /* loaded from: classes.dex */
    public class C1332d implements CardListItem.OnClickListener {

        /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$d$a */
        /* loaded from: classes.dex */
        public class a extends CloudSync.AbstractC1376i {
            public a() {
            }

            @Override // cz.opentree.juicessh.services.CloudSync.AbstractC1376i
            /* renamed from: a */
            public void mo5314a() {
                if (ManageCloudSyncFragment.this.isAdded()) {
                    ManageCloudSyncFragment.this.m5411l();
                }
            }
        }

        public C1332d() {
        }

        @Override // cz.opentree.juicessh.views.CardListItem.OnClickListener
        /* renamed from: g */
        public void mo2526g(int i) {
            if (ManageCloudSyncFragment.this.getActivity() != null) {
                CloudSync.m5628h(ManageCloudSyncFragment.this.getActivity(), new a());
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$e */
    /* loaded from: classes.dex */
    public class RunnableC1333e implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ TextView f4019O;

        public RunnableC1333e(TextView textView) {
            this.f4019O = textView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4019O.setText(CloudSync.m5622b(ManageCloudSyncFragment.this.getActivity()));
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$f */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1334f implements View.OnClickListener {
        public ViewOnClickListenerC1334f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ManageCloudSyncFragment.this.m5411l();
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$g */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1335g implements View.OnClickListener {

        /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$g$a */
        /* loaded from: classes.dex */
        public class a implements RetryPrompt.RetryPromptListener {

            /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$g$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C2491a extends pi0.AbstractC1720p {

                /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$g$a$a$a, reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public class C2492a extends pi0.AbstractC1718n {
                    public C2492a() {
                    }

                    @Override // cz.opentree.pi0.AbstractC1718n
                    /* renamed from: a */
                    public void mo5421a() {
                        super.mo5421a();
                        Toast.makeText(ManageCloudSyncFragment.this.getActivity(), ManageCloudSyncFragment.this.getActivity().getString(R.string.could_not_contact_cloudsync_service), 0).show();
                    }

                    @Override // cz.opentree.pi0.AbstractC1718n
                    /* renamed from: c */
                    public void mo5422c() {
                        super.mo5422c();
                        if (ManageCloudSyncFragment.this.getActivity() != null) {
                            ManageCloudSyncFragment.this.m5411l();
                        }
                    }
                }

                public C2491a() {
                }

                @Override // cz.opentree.pi0.AbstractC1720p
                /* renamed from: a */
                public void mo3228a(String str) {
                    super.mo3228a(str);
                    Toast.makeText(ManageCloudSyncFragment.this.getActivity(), ManageCloudSyncFragment.this.getString(R.string.could_not_contact_cloudsync_service), 0).show();
                }

                @Override // cz.opentree.pi0.AbstractC1720p
                /* renamed from: b */
                public void mo3229b(User user) {
                    super.mo3229b(user);
                    pi0.m7340s(ManageCloudSyncFragment.this.getActivity(), user, new C2492a());
                }
            }

            public a() {
            }

            @Override // cz.opentree.util.RetryPrompt.RetryPromptListener
            /* renamed from: a */
            public void mo2520a() {
                Toast.makeText(ManageCloudSyncFragment.this.getActivity(), ManageCloudSyncFragment.this.getActivity().getString(R.string.wiping_cloudsync_backups), 0).show();
                pi0.m7331j(ManageCloudSyncFragment.this.getActivity(), new C2491a());
            }

            @Override // cz.opentree.util.RetryPrompt.RetryPromptListener
            public void onCancel() {
            }
        }

        public ViewOnClickListenerC1335g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RetryPrompt retryPrompt = new RetryPrompt(ManageCloudSyncFragment.this.getActivity(), new a());
            retryPrompt.m9295h(ManageCloudSyncFragment.this.getString(R.string.are_you_sure_wipe_cloudsync));
            retryPrompt.m9297j(ManageCloudSyncFragment.this.getString(R.string.wipe_cloudsync));
            retryPrompt.create().show();
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$h */
    /* loaded from: classes.dex */
    public class RunnableC1336h implements Runnable {
        public RunnableC1336h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ManageCloudSyncFragment.this.m5415p();
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$i */
    /* loaded from: classes.dex */
    public class C1337i extends pi0.AbstractC1717m {

        /* renamed from: a */
        public final /* synthetic */ LinkedHashMap f4027a;

        /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$i$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: O */
            public final /* synthetic */ String f4029O;

            /* renamed from: P */
            public final /* synthetic */ String f4030P;

            public a(String str, String str2) {
                this.f4029O = str;
                this.f4030P = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                ManageCloudSyncFragment.this.m5414o(this.f4029O, this.f4030P);
            }
        }

        public C1337i(LinkedHashMap linkedHashMap) {
            this.f4027a = linkedHashMap;
        }

        @Override // cz.opentree.pi0.AbstractC1717m
        /* renamed from: a */
        public void mo5423a() {
            super.mo5423a();
            ManageCloudSyncFragment.this.m5416q();
        }

        @Override // cz.opentree.pi0.AbstractC1717m
        /* renamed from: b */
        public void mo5424b(JSONObject jSONObject) {
            super.mo5424b(jSONObject);
            if (ManageCloudSyncFragment.this.getActivity() == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            try {
                for (String str : this.f4027a.keySet()) {
                    sb.append(str);
                    sb.append("\n");
                    if (jSONObject.has((String) this.f4027a.get(str))) {
                        sb2.append(jSONObject.getString((String) this.f4027a.get(str)));
                        sb2.append("\n");
                    } else {
                        sb2.append("0\n");
                    }
                }
                ManageCloudSyncFragment.this.f4011V.post(new a(sb.toString().trim(), sb2.toString().trim()));
            } catch (JSONException unused) {
                ManageCloudSyncFragment.this.m5416q();
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$j */
    /* loaded from: classes.dex */
    public class C1338j {

        /* renamed from: a */
        public TextView f4032a;

        /* renamed from: b */
        public TextView f4033b;

        public C1338j(ManageCloudSyncFragment manageCloudSyncFragment) {
        }
    }

    /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$k */
    /* loaded from: classes.dex */
    public class C1339k {

        /* renamed from: a */
        public Context f4034a;

        /* renamed from: b */
        public String f4035b;

        /* renamed from: c */
        public int f4036c;

        /* renamed from: d */
        public int f4037d;

        /* renamed from: e */
        public View f4038e;

        /* renamed from: f */
        public TextView f4039f;

        /* renamed from: g */
        public TextView f4040g;

        /* renamed from: h */
        public CompoundButton f4041h;

        /* renamed from: i */
        public ArrayList<CardListItem> f4042i = new ArrayList<>();

        /* renamed from: j */
        public ArrayList<View> f4043j = new ArrayList<>();

        /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$k$a */
        /* loaded from: classes.dex */
        public class a implements CompoundButton.OnCheckedChangeListener {

            /* renamed from: a */
            public final /* synthetic */ Context f4045a;

            /* renamed from: b */
            public final /* synthetic */ OnToggleChangedListener f4046b;

            public a(ManageCloudSyncFragment manageCloudSyncFragment, Context context, OnToggleChangedListener onToggleChangedListener) {
                this.f4045a = context;
                this.f4046b = onToggleChangedListener;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Config.m5462h(C1339k.this.f4035b, String.valueOf(z), this.f4045a);
                C1339k.this.m5429e(z);
                OnToggleChangedListener onToggleChangedListener = this.f4046b;
                if (onToggleChangedListener != null) {
                    onToggleChangedListener.mo5418a(z);
                }
            }
        }

        /* renamed from: cz.opentree.juicessh.fragments.ManageCloudSyncFragment$k$b */
        /* loaded from: classes.dex */
        public class b implements View.OnClickListener {
            public b(ManageCloudSyncFragment manageCloudSyncFragment) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1339k.this.f4041h.toggle();
            }
        }

        public C1339k(Context context, LayoutInflater layoutInflater, int i, int i2, int i3, String str, OnToggleChangedListener onToggleChangedListener) {
            this.f4034a = context;
            this.f4035b = str;
            this.f4036c = i2;
            this.f4037d = i3;
            View inflate = layoutInflater.inflate(R.layout.manage_cloudsync_enabler, (ViewGroup) null, false);
            this.f4038e = inflate;
            this.f4039f = (TextView) inflate.findViewById(R.id.title);
            this.f4040g = (TextView) this.f4038e.findViewById(R.id.subtitle);
            this.f4041h = (CompoundButton) this.f4038e.findViewById(R.id.indicator);
            this.f4039f.setText(i);
            this.f4040g.setText(i3);
            this.f4041h.setOnCheckedChangeListener(new a(ManageCloudSyncFragment.this, context, onToggleChangedListener));
            this.f4038e.setClickable(true);
            this.f4038e.setOnClickListener(new b(ManageCloudSyncFragment.this));
            m5428d();
        }

        /* renamed from: b */
        public void m5426b(View view) {
            this.f4043j.add(view);
            if (view instanceof CompoundButton) {
                CompoundButton compoundButton = (CompoundButton) view;
                compoundButton.setChecked(this.f4041h.isChecked() && compoundButton.isChecked());
            }
            view.setEnabled(this.f4041h.isChecked());
        }

        /* renamed from: c */
        public void m5427c(CardListItem cardListItem) {
            this.f4042i.add(cardListItem);
            ManageCloudSyncFragment.this.m5413n(cardListItem, this.f4041h.isChecked());
        }

        /* renamed from: d */
        public void m5428d() {
            m5430f(Config.m5459e(this.f4034a, this.f4035b));
        }

        /* renamed from: e */
        public void m5429e(boolean z) {
            this.f4040g.setText(z ? this.f4036c : this.f4037d);
            Iterator<View> it = this.f4043j.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (!z && (next instanceof CompoundButton)) {
                    ((CompoundButton) next).setChecked(false);
                }
                next.setEnabled(z);
            }
            Iterator<CardListItem> it2 = this.f4042i.iterator();
            while (it2.hasNext()) {
                ManageCloudSyncFragment.this.m5413n(it2.next(), z);
            }
        }

        /* renamed from: f */
        public void m5430f(boolean z) {
            this.f4041h.setChecked(z);
        }
    }

    /* renamed from: h */
    public final void m5407h(CardListItem cardListItem) {
        cardListItem.m5676r(new C1332d());
    }

    /* renamed from: i */
    public final View m5408i() {
        View view = this.f4009T;
        if (view != null) {
            return view;
        }
        this.f4009T = this.f4010U.inflate(R.layout.manage_cloudsync_status_success, (ViewGroup) null, false);
        this.f4012W.getItem(f4002a0).m5672n(getActivity().getString(R.string.wipe_cloudsync));
        this.f4012W.getItem(f4002a0).m5671m(new ViewOnClickListenerC1335g());
        C1338j c1338j = new C1338j(this);
        c1338j.f4032a = (TextView) this.f4009T.findViewById(R.id.status_text_key);
        c1338j.f4033b = (TextView) this.f4009T.findViewById(R.id.status_text_value);
        this.f4009T.setTag(c1338j);
        return this.f4009T;
    }

    /* renamed from: j */
    public View m5409j() {
        View view = this.f4007R;
        if (view != null) {
            return view;
        }
        View inflate = this.f4010U.inflate(R.layout.centered_progress_spinner, (ViewGroup) null, false);
        this.f4007R = inflate;
        return inflate;
    }

    /* renamed from: k */
    public final View m5410k() {
        View view = this.f4008S;
        if (view != null) {
            return view;
        }
        View inflate = this.f4010U.inflate(R.layout.manage_cloudsync_status_error, (ViewGroup) null, false);
        this.f4008S = inflate;
        inflate.setOnClickListener(new ViewOnClickListenerC1334f());
        return this.f4008S;
    }

    /* renamed from: l */
    public void m5411l() {
        if (isDetached()) {
            return;
        }
        this.f4011V.post(new RunnableC1336h());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(getString(R.string.connections_capital_c), "cz.opentree.juicessh.models.Connection");
        linkedHashMap.put(getString(R.string.connection_groups), "cz.opentree.juicessh.models.ConnectionGroup");
        linkedHashMap.put(getString(R.string.identities), "cz.opentree.juicessh.models.Identity");
        linkedHashMap.put(getString(R.string.snippets), "cz.opentree.juicessh.models.Snippet");
        linkedHashMap.put(getString(R.string.port_forwards), "cz.opentree.juicessh.models.PortForward");
        linkedHashMap.put(getString(R.string.ec2_sync_profiles), "cz.opentree.juicessh.models.ec2link.Ec2Profile");
        linkedHashMap.put(getString(R.string.config_items), "cz.opentree.juicessh.models.Config");
        pi0.m7329h(getActivity(), new C1337i(linkedHashMap));
    }

    /* renamed from: m */
    public void m5412m() {
        this.f4005P.m5428d();
        this.f4006Q.m5428d();
        m5411l();
    }

    /* renamed from: n */
    public void m5413n(CardListItem cardListItem, boolean z) {
        cardListItem.m5679u(z);
        this.f4012W.notifyDataSetChanged();
    }

    /* renamed from: o */
    public void m5414o(String str, String str2) {
        View m5408i = m5408i();
        C1338j c1338j = (C1338j) m5408i.getTag();
        c1338j.f4032a.setText(str);
        c1338j.f4033b.setText(str2);
        this.f4012W.m4137d(f4002a0).m5673o(m5408i);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f4010U = (LayoutInflater) getActivity().getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.layout.card_list, viewGroup, false);
        ListView listView = (ListView) inflate.findViewById(R.id.list);
        gh0 gh0Var = new gh0();
        this.f4012W = gh0Var;
        listView.setAdapter((ListAdapter) gh0Var);
        CardListItem cardListItem = new CardListItem(getActivity(), f3999X);
        cardListItem.m5678t(getString(R.string.about));
        cardListItem.m5667i().setVisibility(8);
        cardListItem.m5665g().setVisibility(8);
        cardListItem.m5664f().setVisibility(8);
        TextView textView = (TextView) layoutInflater.inflate(R.layout.card_text_content, (ViewGroup) null, false);
        textView.setText(R.string.cloudsync_long_description);
        cardListItem.m5673o(textView);
        this.f4012W.m4134a(cardListItem);
        CardListItem cardListItem2 = new CardListItem(getActivity(), f4000Y);
        cardListItem2.m5678t(getString(R.string.manage));
        cardListItem2.m5667i().setVisibility(8);
        cardListItem2.m5674p(R.string.icon_cogs);
        this.f4005P = new C1339k(getActivity(), layoutInflater, R.string.enabled, R.string.cloudsync_is_enabled, R.string.cloudsync_is_disabled, "cloudsync:enabled", new C1329a());
        this.f4006Q = new C1339k(getActivity(), layoutInflater, R.string.include_identities, R.string.identities_will_be_included, R.string.identities_wont_be_included, "cloudsync:identities", null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, Math.round(TypedValue.applyDimension(1, 16.0f, getActivity().getResources().getDisplayMetrics())));
        this.f4005P.f4038e.setLayoutParams(layoutParams);
        cardListItem2.m5662d(this.f4006Q.f4038e);
        cardListItem2.m5662d(this.f4005P.f4038e);
        this.f4012W.m4134a(cardListItem2);
        CardListItem cardListItem3 = new CardListItem(getActivity(), f4001Z);
        cardListItem3.m5678t(getString(R.string.sync_now));
        cardListItem3.m5674p(R.string.icon_refresh);
        this.f4012W.m4134a(cardListItem3);
        m5407h(cardListItem3);
        this.f4004O = new SyncProgressReceiver(cardListItem3.m5667i(), cardListItem3.m5665g(), new C1330b());
        CardListItem cardListItem4 = new CardListItem(getActivity(), f4002a0);
        cardListItem4.m5678t(getString(R.string.remote_status));
        cardListItem4.m5677s(getString(R.string.items_currently_in_cloudsync));
        cardListItem4.m5674p(R.string.icon_info);
        this.f4012W.m4134a(cardListItem4);
        if (!User.m5530z(getActivity())) {
            CardListItem cardListItem5 = new CardListItem(getActivity(), f4003b0);
            cardListItem5.m5678t(getString(R.string.encryption_passphrase));
            cardListItem5.m5674p(R.string.icon_key);
            cardListItem5.m5667i().setVisibility(8);
            TextView textView2 = (TextView) layoutInflater.inflate(R.layout.card_text_content, (ViewGroup) null, false);
            textView2.setText(R.string.cloudsync_passphrase_required);
            cardListItem5.m5673o(textView2);
            cardListItem5.m5672n(getString(R.string.update_passphrase));
            cardListItem5.m5671m(new ViewOnClickListenerC1331c());
            this.f4012W.m4134a(cardListItem5);
        }
        this.f4005P.m5426b(this.f4006Q.f4038e);
        this.f4005P.m5426b(this.f4006Q.f4041h);
        this.f4005P.m5426b(this.f4006Q.f4039f);
        this.f4005P.m5426b(this.f4006Q.f4040g);
        this.f4005P.m5427c(cardListItem3);
        m5417r();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.f4004O, new IntentFilter("cz.opentree.juicessh.cloudsync.progress"));
        m5412m();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.f4004O);
    }

    /* renamed from: p */
    public void m5415p() {
        this.f4012W.m4137d(f4002a0).m5673o(m5409j());
    }

    /* renamed from: q */
    public void m5416q() {
        this.f4012W.m4137d(f4002a0).m5673o(m5410k());
    }

    /* renamed from: r */
    public final void m5417r() {
        if (getActivity() == null) {
            return;
        }
        getActivity().runOnUiThread(new RunnableC1333e(this.f4012W.m4137d(f4001Z).m5667i()));
    }
}
