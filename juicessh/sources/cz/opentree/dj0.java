package cz.opentree;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.Plugin;
import cz.opentree.juicessh.models.User;
import cz.opentree.juicessh.views.CardListItem;
import cz.opentree.pi0;
import com.squareup.picasso.Picasso;
import java.util.List;

/* compiled from: PluginsFragment.java */
/* loaded from: classes.dex */
public class dj0 extends Fragment implements CardListItem.OnClickListener {

    /* renamed from: O */
    public ListView f2199O;

    /* renamed from: P */
    public View f2200P;

    /* renamed from: Q */
    public View f2201Q;

    /* renamed from: R */
    public final gh0 f2202R = new gh0();

    /* compiled from: PluginsFragment.java */
    /* renamed from: cz.opentree.dj0$a */
    /* loaded from: classes.dex */
    public class C0883a extends pi0.AbstractC1720p {

        /* renamed from: a */
        public final /* synthetic */ Activity f2203a;

        public C0883a(Activity activity) {
            this.f2203a = activity;
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: a */
        public void mo3228a(String str) {
            super.mo3228a(str);
            dj0.this.m3227l(this.f2203a);
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            if (oi0.m7047d(user)) {
                return;
            }
            dj0.this.m3227l(this.f2203a);
        }
    }

    /* compiled from: PluginsFragment.java */
    /* renamed from: cz.opentree.dj0$b */
    /* loaded from: classes.dex */
    public class RunnableC0884b implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ Activity f2205O;

        public RunnableC0884b(Activity activity) {
            this.f2205O = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            new wk0(this.f2205O, dj0.this.getString(R.string.pro_feature), dj0.this.getString(R.string.plugins_require_pro)).show();
        }
    }

    /* compiled from: PluginsFragment.java */
    /* renamed from: cz.opentree.dj0$c */
    /* loaded from: classes.dex */
    public class C0885c extends pi0.AbstractC1719o {

        /* renamed from: a */
        public final /* synthetic */ LayoutInflater f2207a;

        /* compiled from: PluginsFragment.java */
        /* renamed from: cz.opentree.dj0$c$a */
        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://sonelli.com/plugins"));
                intent.addFlags(1074266112);
                dj0.this.startActivity(intent);
            }
        }

        /* compiled from: PluginsFragment.java */
        /* renamed from: cz.opentree.dj0$c$b */
        /* loaded from: classes.dex */
        public class b implements View.OnClickListener {

            /* renamed from: O */
            public final /* synthetic */ Plugin f2210O;

            public b(Plugin plugin) {
                this.f2210O = plugin;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (dj0.this.getActivity() != null) {
                    Intent launchIntentForPackage = dj0.this.getActivity().getPackageManager().getLaunchIntentForPackage(this.f2210O.m5488e());
                    if (launchIntentForPackage != null) {
                        dj0.this.startActivity(launchIntentForPackage);
                    } else {
                        Toast.makeText(dj0.this.getActivity(), dj0.this.getString(R.string.error_plugin_not_installed), 0).show();
                    }
                }
            }
        }

        /* compiled from: PluginsFragment.java */
        /* renamed from: cz.opentree.dj0$c$c */
        /* loaded from: classes.dex */
        public class c implements View.OnClickListener {

            /* renamed from: O */
            public final /* synthetic */ Plugin f2212O;

            public c(Plugin plugin) {
                this.f2212O = plugin;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (dj0.this.getActivity() != null) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.f2212O.m5488e()));
                    intent.addFlags(1074266112);
                    try {
                        dj0.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        Toast.makeText(dj0.this.getActivity(), dj0.this.getString(R.string.google_play_not_installed), 0).show();
                    }
                }
            }
        }

        /* compiled from: PluginsFragment.java */
        /* renamed from: cz.opentree.dj0$c$d */
        /* loaded from: classes.dex */
        public class d implements View.OnClickListener {
            public d() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dj0.this.m3226k();
            }
        }

        public C0885c(LayoutInflater layoutInflater) {
            this.f2207a = layoutInflater;
        }

        @Override // cz.opentree.pi0.AbstractC1719o
        /* renamed from: a */
        public void mo3230a() {
            super.mo3230a();
            dj0.this.f2199O.setVisibility(8);
            dj0.this.f2201Q.setVisibility(8);
            dj0.this.f2200P.setVisibility(0);
            ((TextView) dj0.this.f2200P.findViewById(R.id.error_message)).setText(R.string.please_try_again_later);
            dj0.this.f2200P.setOnClickListener(null);
        }

        @Override // cz.opentree.pi0.AbstractC1719o
        /* renamed from: b */
        public void mo3231b() {
            super.mo3231b();
            dj0.this.f2199O.setVisibility(8);
            dj0.this.f2201Q.setVisibility(8);
            dj0.this.f2200P.setVisibility(0);
            ((TextView) dj0.this.f2200P.findViewById(R.id.error_message)).setText(R.string.tap_to_retry);
            dj0.this.f2200P.setOnClickListener(new d());
        }

        @Override // cz.opentree.pi0.AbstractC1719o
        /* renamed from: c */
        public void mo3232c(List<Plugin> list) {
            super.mo3232c(list);
            if (dj0.this.getActivity() == null || dj0.this.getActivity().isFinishing()) {
                return;
            }
            dj0.this.f2202R.m4135b();
            CardListItem cardListItem = new CardListItem(dj0.this.getActivity(), -2);
            cardListItem.m5678t(dj0.this.getString(R.string.about));
            LinearLayout linearLayout = (LinearLayout) this.f2207a.inflate(R.layout.plugin_card_content, (ViewGroup) null, false);
            ((TextView) linearLayout.findViewById(R.id.description)).setText(dj0.this.getString(R.string.plugins_description));
            cardListItem.m5665g().setVisibility(8);
            cardListItem.m5664f().setVisibility(8);
            cardListItem.m5667i().setVisibility(8);
            cardListItem.m5673o(linearLayout);
            cardListItem.m5672n(dj0.this.getString(R.string.view_documentation));
            cardListItem.m5671m(new a());
            dj0.this.f2202R.m4134a(cardListItem);
            int i = 0;
            for (Plugin plugin : list) {
                CardListItem cardListItem2 = new CardListItem(dj0.this.getActivity(), i);
                i++;
                cardListItem2.m5678t(plugin.m5487d());
                cardListItem2.m5677s(plugin.m5484a());
                cardListItem2.m5674p(R.string.icon_puzzle_piece);
                Picasso.m10676n(dj0.this.getActivity()).m10685j(plugin.m5486c()).m9309g(cardListItem2);
                LinearLayout linearLayout2 = (LinearLayout) this.f2207a.inflate(R.layout.plugin_card_content, (ViewGroup) null, false);
                ((TextView) linearLayout2.findViewById(R.id.description)).setText(plugin.m5485b());
                cardListItem2.m5673o(linearLayout2);
                if (plugin.m5489f(dj0.this.getActivity())) {
                    cardListItem2.m5672n(dj0.this.getString(R.string.open));
                    cardListItem2.m5671m(new b(plugin));
                } else {
                    cardListItem2.m5672n(dj0.this.getString(R.string.install));
                    cardListItem2.m5671m(new c(plugin));
                }
                dj0.this.f2202R.m4134a(cardListItem2);
            }
            dj0.this.f2201Q.setVisibility(8);
            dj0.this.f2200P.setVisibility(8);
            dj0.this.f2199O.setVisibility(0);
        }
    }

    @Override // cz.opentree.juicessh.views.CardListItem.OnClickListener
    /* renamed from: g */
    public void mo2526g(int i) {
    }

    /* renamed from: k */
    public final void m3226k() {
        this.f2199O.setVisibility(8);
        this.f2200P.setVisibility(8);
        this.f2201Q.setVisibility(0);
        pi0.m7330i(getActivity(), new C0885c((LayoutInflater) getActivity().getSystemService("layout_inflater")));
    }

    /* renamed from: l */
    public void m3227l(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.runOnUiThread(new RunnableC0884b(activity));
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (kj0.m5917a().m5930j()) {
            pi0.m7331j(activity, new C0883a(activity));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.card_list, viewGroup, false);
        this.f2201Q = inflate.findViewById(R.id.loading_layout);
        this.f2200P = inflate.findViewById(R.id.error_layout);
        ListView listView = (ListView) inflate.findViewById(R.id.list);
        this.f2199O = listView;
        listView.setAdapter((ListAdapter) this.f2202R);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        m3226k();
    }
}
