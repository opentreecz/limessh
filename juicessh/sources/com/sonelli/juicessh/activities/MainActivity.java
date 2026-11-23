package com.sonelli.juicessh.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sonelli.gh0;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.models.Config;
import com.sonelli.juicessh.models.User;
import com.sonelli.juicessh.services.BillingService;
import com.sonelli.juicessh.services.CloudSync;
import com.sonelli.juicessh.services.PushNotification;
import com.sonelli.juicessh.views.CardListItem;
import com.sonelli.juicessh.views.ListviewSafeViewPager;
import com.sonelli.kh0;
import com.sonelli.kj0;
import com.sonelli.oi0;
import com.sonelli.pi0;
import com.sonelli.util.QuickConnectPrompt;
import com.sonelli.util.SessionedActivity;
import com.sonelli.wg0;
import com.sonelli.zg0;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class MainActivity extends SessionedActivity implements CardListItem.OnClickListener {

    /* renamed from: P */
    public final BillingService f3736P = new BillingService(this);

    /* renamed from: Q */
    public ListView f3737Q;

    /* renamed from: R */
    public gh0 f3738R;

    /* renamed from: S */
    public kh0 f3739S;

    /* renamed from: com.sonelli.juicessh.activities.MainActivity$a */
    /* loaded from: classes.dex */
    public class RunnableC1254a implements Runnable {
        public RunnableC1254a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.f3739S.m5899i();
        }
    }

    /* renamed from: com.sonelli.juicessh.activities.MainActivity$b */
    /* loaded from: classes.dex */
    public class RunnableC1255b implements Runnable {
        public RunnableC1255b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PushNotification.m5642k(MainActivity.this);
        }
    }

    /* renamed from: com.sonelli.juicessh.activities.MainActivity$c */
    /* loaded from: classes.dex */
    public class RunnableC1256c implements Runnable {

        /* renamed from: com.sonelli.juicessh.activities.MainActivity$c$a */
        /* loaded from: classes.dex */
        public class a implements BillingService.OnServiceConnectedListener {
            public a() {
            }

            @Override // com.sonelli.juicessh.services.BillingService.OnServiceConnectedListener
            public void onConnected() {
                try {
                    MainActivity.this.f3736P.m5614b();
                } catch (BillingService.C1366b e) {
                    e.printStackTrace();
                }
            }
        }

        public RunnableC1256c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.f3736P.m5615c(new a());
        }
    }

    /* renamed from: com.sonelli.juicessh.activities.MainActivity$d */
    /* loaded from: classes.dex */
    public class C1257d implements CardListItem.OnClickListener {

        /* renamed from: com.sonelli.juicessh.activities.MainActivity$d$a */
        /* loaded from: classes.dex */
        public class a implements QuickConnectPrompt.QuickConnectPromptListener {
            public a() {
            }

            @Override // com.sonelli.util.QuickConnectPrompt.QuickConnectPromptListener
            /* renamed from: a */
            public void mo5231a(Uri uri, boolean z) {
                Intent intent = new Intent(MainActivity.this, (Class<?>) TerminalEmulatorActivity.class);
                intent.setData(uri);
                intent.putExtra("save", z);
                MainActivity.this.startActivity(intent);
            }

            @Override // com.sonelli.util.QuickConnectPrompt.QuickConnectPromptListener
            public void onCancel() {
            }
        }

        public C1257d() {
        }

        @Override // com.sonelli.juicessh.views.CardListItem.OnClickListener
        /* renamed from: g */
        public void mo2526g(int i) {
            QuickConnectPrompt quickConnectPrompt = new QuickConnectPrompt(MainActivity.this, new a());
            if (MainActivity.this.isFinishing()) {
                return;
            }
            quickConnectPrompt.show();
        }
    }

    /* renamed from: com.sonelli.juicessh.activities.MainActivity$e */
    /* loaded from: classes.dex */
    public class C1258e extends pi0.AbstractC1720p {
        public C1258e() {
        }

        @Override // com.sonelli.pi0.AbstractC1720p
        /* renamed from: a */
        public void mo3228a(String str) {
            super.mo3228a(str);
            MainActivity.this.m5227o();
        }

        @Override // com.sonelli.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            if (oi0.m7047d(user)) {
                MainActivity.this.m5226n();
            } else {
                MainActivity.this.m5227o();
            }
        }
    }

    /* renamed from: com.sonelli.juicessh.activities.MainActivity$f */
    /* loaded from: classes.dex */
    public class C1259f extends zg0 {

        /* renamed from: c */
        public final /* synthetic */ SharedPreferences f3747c;

        /* renamed from: d */
        public final /* synthetic */ Handler f3748d;

        /* renamed from: com.sonelli.juicessh.activities.MainActivity$f$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: O */
            public final /* synthetic */ JSONArray f3749O;

            public a(JSONArray jSONArray) {
                this.f3749O = jSONArray;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1259f.this.f3747c.edit().putString("bookclub_list", this.f3749O.toString()).apply();
                C1259f.this.f3747c.edit().putBoolean("bookclub:new", true).apply();
            }
        }

        public C1259f(MainActivity mainActivity, SharedPreferences sharedPreferences, Handler handler) {
            this.f3747c = sharedPreferences;
            this.f3748d = handler;
        }

        @Override // com.sonelli.zg0
        /* renamed from: t */
        public void mo5232t(JSONArray jSONArray) {
            super.mo5232t(jSONArray);
            String string = this.f3747c.getString("bookclub_list", "");
            if (string.equals("")) {
                this.f3747c.edit().putString("bookclub_list", jSONArray.toString()).apply();
            } else {
                if (jSONArray.toString().equals(string)) {
                    return;
                }
                this.f3748d.post(new a(jSONArray));
            }
        }
    }

    @Override // com.sonelli.juicessh.views.CardListItem.OnClickListener
    /* renamed from: g */
    public void mo2526g(int i) {
        switch (i) {
            case 2:
                startActivity(new Intent(this, (Class<?>) AddressBookActivity.class));
                return;
            case 3:
                startActivity(new Intent(this, (Class<?>) PluginsActivity.class));
                return;
            case 4:
                startActivity(new Intent(this, (Class<?>) PurchaseActivity.class));
                return;
            case 5:
                startActivity(new Intent(this, (Class<?>) ManageCloudSyncActivity.class));
                return;
            case 6:
                startActivity(new Intent(this, (Class<?>) TeamShareActivity.class));
                return;
            case 7:
                startActivity(new Intent(this, (Class<?>) SettingsActivity.class));
                return;
            case 8:
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://sonelli.com/faq"));
                startActivity(intent);
                return;
            case 9:
                startActivity(new Intent(this, (Class<?>) BookclubActivity.class));
                return;
            default:
                return;
        }
    }

    @Override // com.sonelli.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        setContentView(R.layout.card_list);
        this.f3737Q = (ListView) findViewById(R.id.list);
        gh0 gh0Var = new gh0();
        this.f3738R = gh0Var;
        this.f3737Q.setAdapter((ListAdapter) gh0Var);
    }

    @Override // com.sonelli.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
        m5229q();
        Handler handler = new Handler();
        handler.postDelayed(new RunnableC1254a(), 100L);
        new Thread(new RunnableC1255b());
        handler.postDelayed(new RunnableC1256c(), 200L);
    }

    /* renamed from: n */
    public void m5226n() {
        if (kj0.m5917a().mo5131f()) {
            CardListItem cardListItem = new CardListItem(this, 5);
            cardListItem.m5676r(this);
            cardListItem.m5678t(getString(R.string.cloudsync));
            if (Config.m5459e(this, "cloudsync:enabled")) {
                cardListItem.m5677s(CloudSync.m5622b(this));
            } else {
                cardListItem.m5677s(getString(R.string.cloudsync_is_disabled));
            }
            cardListItem.m5674p(R.string.icon_cloud_download);
            this.f3738R.m4134a(cardListItem);
        }
        if (kj0.m5917a().mo5139z()) {
            CardListItem cardListItem2 = new CardListItem(this, 6);
            cardListItem2.m5676r(this);
            cardListItem2.m5678t(getString(R.string.teamshare));
            cardListItem2.m5677s(getString(R.string.share_your_connections));
            cardListItem2.m5674p(R.string.icon_group);
            this.f3738R.m4134a(cardListItem2);
        }
    }

    /* renamed from: o */
    public void m5227o() {
        CardListItem cardListItem = new CardListItem(this, 4);
        cardListItem.m5676r(this);
        cardListItem.m5678t(getString(R.string.unlock_pro_version_capitals));
        cardListItem.m5677s(getString(R.string.click_to_find_out_more));
        cardListItem.m5674p(R.string.icon_unlock);
        this.f3738R.m4134a(cardListItem);
    }

    @Override // com.sonelli.util.SessionedActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override // com.sonelli.util.SessionedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m5230r(intent.getExtras());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f3736P.m5617e();
    }

    /* renamed from: p */
    public void m5228p(CardListItem cardListItem) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (defaultSharedPreferences.getBoolean("bookclub:new", false)) {
            return;
        }
        Handler handler = new Handler();
        wg0 wg0Var = new wg0();
        wg0Var.m9505c("requested-location", getResources().getConfiguration().locale.getCountry());
        wg0Var.m9507e(this, "https://api.sonelli.com/bookclub", new C1259f(this, defaultSharedPreferences, handler));
    }

    /* renamed from: q */
    public void m5229q() {
        this.f3738R.m4135b();
        CardListItem cardListItem = new CardListItem(this, 0);
        cardListItem.m5676r(new C1257d());
        cardListItem.m5678t(getString(R.string.quick_connect));
        cardListItem.m5677s(getString(R.string.connect_to_a_new_host));
        cardListItem.m5674p(R.string.icon_bolt);
        this.f3738R.m4134a(cardListItem);
        CardListItem cardListItem2 = new CardListItem(this, 1);
        cardListItem2.m5678t(getString(R.string.frequently_used));
        cardListItem2.m5677s(getString(R.string.quick_access_to_your_frequent_connections));
        cardListItem2.m5674p(R.string.icon_star);
        ListviewSafeViewPager listviewSafeViewPager = new ListviewSafeViewPager(this);
        listviewSafeViewPager.setTag("frequentlyUsedPager");
        kh0 kh0Var = new kh0(this, listviewSafeViewPager, 3);
        this.f3739S = kh0Var;
        listviewSafeViewPager.setAdapter(kh0Var);
        listviewSafeViewPager.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f3739S.m5898h()));
        cardListItem2.m5673o(listviewSafeViewPager);
        cardListItem2.m5663e().setPadding(0, cardListItem2.m5663e().getPaddingTop(), 0, cardListItem2.m5663e().getPaddingBottom() / 2);
        this.f3738R.m4134a(cardListItem2);
        CardListItem cardListItem3 = new CardListItem(this, 2);
        cardListItem3.m5676r(this);
        cardListItem3.m5678t(getString(R.string.manage_connections));
        cardListItem3.m5677s(getString(R.string.manage_your_connections_and_identities));
        cardListItem3.m5674p(R.string.icon_globe);
        this.f3738R.m4134a(cardListItem3);
        pi0.m7331j(this, new C1258e());
        CardListItem cardListItem4 = new CardListItem(this, 7);
        cardListItem4.m5676r(this);
        cardListItem4.m5678t(getString(R.string.menu_settings));
        cardListItem4.m5677s(getString(R.string.personalise_your_sessions));
        cardListItem4.m5674p(R.string.icon_cogs);
        this.f3738R.m4134a(cardListItem4);
        CardListItem cardListItem5 = new CardListItem(this, 8);
        cardListItem5.m5676r(this);
        cardListItem5.m5678t(getString(R.string.help));
        cardListItem5.m5677s(getString(R.string.view_our_faq));
        cardListItem5.m5674p(R.string.icon_question);
        this.f3738R.m4134a(cardListItem5);
        if (kj0.m5917a().m5936s()) {
            CardListItem cardListItem6 = new CardListItem(this, 3);
            cardListItem6.m5676r(this);
            cardListItem6.m5678t(getString(R.string.plugins));
            cardListItem6.m5677s(getString(R.string.extend_juicessh_with_third_party_extensions));
            cardListItem6.m5674p(R.string.icon_puzzle_piece);
            cardListItem6.m5670l(false);
            this.f3738R.m4134a(cardListItem6);
        }
        if (kj0.m5917a().m5927e(this)) {
            CardListItem cardListItem7 = new CardListItem(this, 9);
            cardListItem7.m5676r(this);
            cardListItem7.m5678t(getString(R.string.bookclub));
            cardListItem7.m5677s(getString(R.string.find_and_recommend_books));
            cardListItem7.m5674p(R.string.icon_book);
            cardListItem7.m5670l(false);
            this.f3738R.m4134a(cardListItem7);
            m5228p(cardListItem7);
        }
    }

    /* renamed from: r */
    public void m5230r(Bundle bundle) {
        if (bundle != null && bundle.getBoolean("cloudsync", false)) {
            CloudSync.m5627g(this);
            bundle.remove("cloudsync");
        }
    }
}
