package com.sonelli;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDelegate;
import com.github.machinarius.preferencefragment.PreferenceFragment;
import com.j256.ormlite.dao.CloseableIterator;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.activities.Ec2ProfilesActivity;
import com.sonelli.juicessh.activities.LogViewerActivity;
import com.sonelli.juicessh.activities.MainActivity;
import com.sonelli.juicessh.activities.ManageSnippetsActivity;
import com.sonelli.juicessh.activities.SoftwareLicensesActivity;
import com.sonelli.juicessh.models.Host;
import com.sonelli.juicessh.models.User;
import com.sonelli.juicessh.p002db.C1328DB;
import com.sonelli.juicessh.views.ActionPreference;
import com.sonelli.juicessh.views.dbpreferences.EncListDBPreference;
import com.sonelli.juicessh.views.dbpreferences.EncSwitchDBPreference;
import com.sonelli.juicessh.views.dbpreferences.ListDBPreference;
import com.sonelli.juicessh.views.dbpreferences.SwitchDBPreference;
import com.sonelli.pi0;
import com.sonelli.util.ProBlockablePreference;
import com.sonelli.util.Session;
import java.sql.SQLException;

/* compiled from: SettingsFragment.java */
/* loaded from: classes.dex */
public class ej0 extends PreferenceFragment implements Preference.OnPreferenceClickListener {

    /* renamed from: V */
    public PreferenceCategory f2426V;

    /* renamed from: W */
    public PreferenceCategory f2427W;

    /* renamed from: X */
    public PreferenceCategory f2428X;

    /* renamed from: Y */
    public PreferenceCategory f2429Y;

    /* renamed from: Z */
    public Preference f2430Z;

    /* renamed from: a0 */
    public Preference f2431a0;

    /* renamed from: b0 */
    public ListPreference f2432b0;

    /* renamed from: c0 */
    public ListPreference f2433c0;

    /* renamed from: d0 */
    public Preference f2434d0;

    /* renamed from: e0 */
    public Preference f2435e0;

    /* renamed from: f0 */
    public Preference f2436f0;

    /* renamed from: g0 */
    public Preference f2437g0;

    /* renamed from: h0 */
    public ListPreference f2438h0;

    /* compiled from: SettingsFragment.java */
    /* renamed from: com.sonelli.ej0$a */
    /* loaded from: classes.dex */
    public class C0938a implements Preference.OnPreferenceChangeListener {

        /* renamed from: a */
        public final /* synthetic */ Preference.OnPreferenceChangeListener f2439a;

        public C0938a(ej0 ej0Var, Preference.OnPreferenceChangeListener onPreferenceChangeListener) {
            this.f2439a = onPreferenceChangeListener;
        }

        @Override // android.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference preference, Object obj) {
            try {
                AppCompatDelegate.setDefaultNightMode(Integer.valueOf(Integer.parseInt(obj.toString())).intValue());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return this.f2439a.onPreferenceChange(preference, obj);
        }
    }

    /* compiled from: SettingsFragment.java */
    /* renamed from: com.sonelli.ej0$b */
    /* loaded from: classes.dex */
    public class C0939b implements Preference.OnPreferenceClickListener {
        public C0939b() {
        }

        @Override // android.preference.Preference.OnPreferenceClickListener
        public boolean onPreferenceClick(Preference preference) {
            if (!((EncSwitchDBPreference) preference).m5684h()) {
                zk0 m9049h = Session.m9046g().m9049h();
                m9049h.m10502k(ej0.this.getActivity(), 0L);
                m9049h.m10499h(ej0.this.getActivity(), 0);
            }
            return false;
        }
    }

    /* compiled from: SettingsFragment.java */
    /* renamed from: com.sonelli.ej0$c */
    /* loaded from: classes.dex */
    public class C0940c implements AdapterView.OnItemLongClickListener {
        public C0940c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (!((Preference) ((ListView) adapterView).getAdapter().getItem(i)).getKey().equals("action:version")) {
                return false;
            }
            ej0.this.startActivity(new Intent(ej0.this.getActivity(), (Class<?>) LogViewerActivity.class));
            return true;
        }
    }

    /* compiled from: SettingsFragment.java */
    /* renamed from: com.sonelli.ej0$d */
    /* loaded from: classes.dex */
    public class C0941d extends pi0.AbstractC1720p {
        public C0941d() {
        }

        @Override // com.sonelli.pi0.AbstractC1720p
        /* renamed from: a */
        public void mo3228a(String str) {
            if (kj0.m5917a().m5939x() && kj0.m5917a().mo5138y()) {
                ej0 ej0Var = ej0.this;
                ej0Var.m3522z(ej0Var.f2430Z);
            }
            if (kj0.m5917a().m5928g() && kj0.m5917a().mo5132h()) {
                ej0 ej0Var2 = ej0.this;
                ej0Var2.m3522z(ej0Var2.f2432b0);
            }
            if (kj0.m5917a().m5932m() && kj0.m5917a().m5933n()) {
                ej0 ej0Var3 = ej0.this;
                ej0Var3.m3522z(ej0Var3.f2433c0);
            }
            if (kj0.m5917a().m5931k() && kj0.m5917a().mo5133l()) {
                ej0 ej0Var4 = ej0.this;
                ej0Var4.m3522z(ej0Var4.f2436f0);
            }
            if (kj0.m5917a().m5935q() && kj0.m5917a().mo5135r()) {
                ej0 ej0Var5 = ej0.this;
                ej0Var5.m3522z(ej0Var5.f2434d0);
            }
        }

        @Override // com.sonelli.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            if (oi0.m7047d(user)) {
                return;
            }
            if (kj0.m5917a().m5939x() && kj0.m5917a().mo5138y()) {
                ej0 ej0Var = ej0.this;
                ej0Var.m3522z(ej0Var.f2430Z);
            }
            if (kj0.m5917a().m5928g() && kj0.m5917a().mo5132h()) {
                ej0 ej0Var2 = ej0.this;
                ej0Var2.m3522z(ej0Var2.f2432b0);
            }
            if (kj0.m5917a().m5932m() && kj0.m5917a().m5933n()) {
                ej0 ej0Var3 = ej0.this;
                ej0Var3.m3522z(ej0Var3.f2433c0);
            }
            if (kj0.m5917a().m5931k() && kj0.m5917a().mo5133l()) {
                ej0 ej0Var4 = ej0.this;
                ej0Var4.m3522z(ej0Var4.f2436f0);
            }
            if (kj0.m5917a().m5935q() && kj0.m5917a().mo5135r()) {
                ej0 ej0Var5 = ej0.this;
                ej0Var5.m3522z(ej0Var5.f2434d0);
            }
        }
    }

    /* compiled from: SettingsFragment.java */
    /* renamed from: com.sonelli.ej0$e */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC0942e implements DialogInterface.OnClickListener {

        /* compiled from: SettingsFragment.java */
        /* renamed from: com.sonelli.ej0$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: O */
            public final /* synthetic */ Handler f2444O;

            /* compiled from: SettingsFragment.java */
            /* renamed from: com.sonelli.ej0$e$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC2489a implements Runnable {
                public RunnableC2489a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(ej0.this.getActivity(), R.string.known_hosts_cleared, 0).show();
                }
            }

            public a(Handler handler) {
                this.f2444O = handler;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                CloseableIterator it = C1328DB.m5404d(Host.class, ej0.this.getActivity()).iterator();
                while (it.hasNext()) {
                    try {
                        C1328DB.m5404d(Host.class, ej0.this.getActivity()).delete((Host) it.next());
                    } catch (SQLException e) {
                        gj0.m4142c("SettingsFragment", "Unable to delete known host: " + e.getMessage());
                    }
                }
                this.f2444O.postDelayed(new RunnableC2489a(), 0L);
            }
        }

        public DialogInterfaceOnClickListenerC0942e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            new Thread(new a(new Handler())).start();
        }
    }

    @Override // com.github.machinarius.preferencefragment.PreferenceFragment, androidx.fragment.app.Fragment
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m720h(R.xml.settings);
        this.f2426V = (PreferenceCategory) m722j("general");
        this.f2427W = (PreferenceCategory) m722j("account");
        this.f2428X = (PreferenceCategory) m722j("about_us");
        this.f2429Y = (PreferenceCategory) m722j("terminal");
        this.f2430Z = m722j("action:manageSnippets");
        this.f2432b0 = (ListPreference) m722j("terminal:theme");
        this.f2433c0 = (ListPreference) m722j("terminal:font");
        this.f2436f0 = m722j("action:manageEc2SyncProfiles");
        this.f2431a0 = m722j("action:rate_us");
        this.f2434d0 = m722j("pinlock:enabled");
        this.f2435e0 = m722j("action:clear_known_hosts");
        this.f2437g0 = m722j("action:version");
        ListPreference listPreference = (ListPreference) m722j("theme:dark");
        this.f2438h0 = listPreference;
        this.f2438h0.setOnPreferenceChangeListener(new C0938a(this, listPreference.getOnPreferenceChangeListener()));
        try {
            String str = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
            this.f2437g0.setSummary(getString(R.string.app_name) + " v" + str + "");
        } catch (PackageManager.NameNotFoundException unused) {
        }
        this.f2431a0.setOnPreferenceClickListener(this);
        this.f2430Z.setOnPreferenceClickListener(this);
        m722j("action:website").setOnPreferenceClickListener(this);
        m722j("action:software_licenses").setOnPreferenceClickListener(this);
        this.f2436f0.setOnPreferenceClickListener(this);
        this.f2435e0.setOnPreferenceClickListener(this);
        this.f2434d0.setOnPreferenceChangeListener(new xk0(getActivity()));
        this.f2434d0.setOnPreferenceClickListener(new C0939b());
        if (!kj0.m5917a().m5931k()) {
            this.f2426V.removePreference(this.f2436f0);
        }
        if (!kj0.m5917a().m5939x()) {
            this.f2426V.removePreference(this.f2430Z);
        }
        if (!kj0.m5917a().m5928g()) {
            this.f2429Y.removePreference(this.f2432b0);
        }
        if (!kj0.m5917a().m5932m()) {
            this.f2429Y.removePreference(this.f2433c0);
        }
        if (!kj0.m5917a().m5935q()) {
            this.f2427W.removePreference(this.f2434d0);
        }
        if (kj0.m5917a().mo5137w()) {
            return;
        }
        this.f2428X.removePreference(this.f2431a0);
    }

    @Override // android.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        String key = preference.getKey();
        if (key.equals("action:logout")) {
            m3518v();
        }
        if (key.equals("action:manageSnippets")) {
            m3520x();
        }
        if (key.equals("action:manageEc2SyncProfiles")) {
            m3519w();
        }
        if (key.equals("action:rate_us")) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getResources().getString(R.string.app_package_name)));
            intent.addFlags(1074266112);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                Toast.makeText(getActivity(), getString(R.string.google_play_not_installed), 0).show();
            }
        }
        if (key.equals("action:software_licenses")) {
            startActivity(new Intent(getActivity(), (Class<?>) SoftwareLicensesActivity.class));
        }
        if (key.equals("action:website")) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.app_website)));
            intent2.addFlags(1074266112);
            try {
                startActivity(Intent.createChooser(intent2, getString(R.string.select_browser)));
            } catch (ActivityNotFoundException unused2) {
                Toast.makeText(getActivity(), getString(R.string.there_are_no_browsers_available), 0).show();
            }
        }
        if (key.equals("action:clear_known_hosts")) {
            m3517u();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getListView().setDivider(null);
        m3521y();
        getListView().setOnItemLongClickListener(new C0940c());
    }

    /* renamed from: u */
    public final void m3517u() {
        vk0 vk0Var = new vk0(getActivity());
        vk0Var.m9296i(R.string.clear_known_hosts);
        vk0Var.m9294g(R.string.are_you_sure_clear_known_hosts);
        vk0Var.setPositiveButton(R.string.confirm, new DialogInterfaceOnClickListenerC0942e());
        vk0Var.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
        if (getActivity().isFinishing()) {
            return;
        }
        vk0Var.show();
    }

    /* renamed from: v */
    public final void m3518v() {
        pi0.m7335n(getActivity());
        User.m5519B(null, getActivity());
        User.m5520C(null, getActivity());
        Intent intent = new Intent(getActivity(), (Class<?>) MainActivity.class);
        intent.setFlags(805306368);
        getActivity().startActivity(intent);
    }

    /* renamed from: w */
    public final void m3519w() {
        startActivity(new Intent(getActivity(), (Class<?>) Ec2ProfilesActivity.class));
    }

    /* renamed from: x */
    public final void m3520x() {
        startActivity(new Intent(getActivity(), (Class<?>) ManageSnippetsActivity.class));
    }

    /* renamed from: y */
    public void m3521y() {
        this.f2430Z.setOnPreferenceClickListener(this);
        pi0.m7331j(getActivity(), new C0941d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"NewApi"})
    /* renamed from: z */
    public void m3522z(Preference preference) {
        if (preference == 0) {
            return;
        }
        if (preference instanceof ProBlockablePreference) {
            ((ProBlockablePreference) preference).mo5652f(true);
            return;
        }
        preference.setEnabled(false);
        if (SwitchDBPreference.class.isAssignableFrom(preference.getClass())) {
            SwitchDBPreference switchDBPreference = (SwitchDBPreference) preference;
            switchDBPreference.m5686l(R.string.pro_users_only);
            switchDBPreference.mo5685k(false);
            return;
        }
        if (ActionPreference.class.isAssignableFrom(preference.getClass())) {
            preference.setSummary(R.string.pro_users_only);
            return;
        }
        if (ListPreference.class.isAssignableFrom(preference.getClass())) {
            preference.setSummary(R.string.pro_users_only);
            return;
        }
        if (ListDBPreference.class.isAssignableFrom(preference.getClass())) {
            preference.setSummary(R.string.pro_users_only);
        } else if (EncSwitchDBPreference.class.isAssignableFrom(preference.getClass())) {
            preference.setSummary(R.string.pro_users_only);
        } else if (EncListDBPreference.class.isAssignableFrom(preference.getClass())) {
            preference.setSummary(R.string.pro_users_only);
        }
    }
}
