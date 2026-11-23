package cz.opentree.juicessh.activities;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import com.github.machinarius.preferencefragment.PreferenceFragment;
import com.j256.ormlite.dao.CloseableIterator;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.ConnectionGroup;
import cz.opentree.juicessh.p002db.C1328DB;
import cz.opentree.util.SessionedFragmentActivity;
import java.util.ArrayList;
import java.util.Collections;

@TargetApi(11)
/* loaded from: classes.dex */
public class ConfigureWidgetActivity extends SessionedFragmentActivity {

    /* renamed from: P */
    public int f3720P;

    @SuppressLint({"ValidFragment"})
    /* renamed from: cz.opentree.juicessh.activities.ConfigureWidgetActivity$a */
    /* loaded from: classes.dex */
    public static class SharedPreferencesOnSharedPreferenceChangeListenerC1248a extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

        /* renamed from: V */
        public Context f3721V;

        /* renamed from: W */
        public int f3722W;

        /* renamed from: X */
        public ListPreference f3723X;

        /* renamed from: Y */
        public ListPreference f3724Y;

        public SharedPreferencesOnSharedPreferenceChangeListenerC1248a(Context context, int i) {
            this.f3721V = context;
            this.f3722W = i;
        }

        @Override // com.github.machinarius.preferencefragment.PreferenceFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            try {
                m723k().setSharedPreferencesName(this.f3721V.getPackageName() + "_widget-" + this.f3722W);
                m720h(R.xml.widget_preferences);
                PreferenceManager.setDefaultValues(this.f3721V, R.xml.widget_preferences, true);
                this.f3723X = (ListPreference) m722j("widget:group");
                this.f3724Y = (ListPreference) m722j("widget:update_frequency");
                m5216p();
                m5217q();
            } catch (NullPointerException unused) {
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            super.onPause();
            m723k().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            m723k().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            m5217q();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: p */
        public final void m5216p() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList<ConnectionGroup> arrayList3 = new ArrayList();
            CloseableIterator it = C1328DB.m5404d(ConnectionGroup.class, this.f3721V).iterator();
            while (it.hasNext()) {
                arrayList3.add((ConnectionGroup) it.next());
            }
            Collections.sort(arrayList3);
            arrayList.add(this.f3721V.getString(R.string.frequently_used));
            arrayList2.add("-1");
            arrayList.add(this.f3721V.getString(R.string.port_forwards));
            arrayList2.add("-3");
            arrayList.add(this.f3721V.getString(R.string.all));
            arrayList2.add("-2");
            for (ConnectionGroup connectionGroup : arrayList3) {
                arrayList.add(connectionGroup.name);
                arrayList2.add(connectionGroup.f3993id.toString());
            }
            this.f3723X.setEntries((CharSequence[]) arrayList.toArray(new String[arrayList.size()]));
            this.f3723X.setEntryValues((CharSequence[]) arrayList2.toArray(new String[arrayList2.size()]));
        }

        /* renamed from: q */
        public final void m5217q() {
            this.f3723X.setSummary((CharSequence) null);
            this.f3723X.setSummary(String.format(getString(R.string.connections_will_be_shown), this.f3723X.getEntry()));
            this.f3724Y.setSummary((CharSequence) null);
            this.f3724Y.setSummary(String.format(getString(R.string.widget_will_update), this.f3724Y.getEntry()));
        }
    }

    @Override // cz.opentree.util.SessionedFragmentActivity
    /* renamed from: j */
    public void mo5203j(Bundle bundle) {
        Bundle extras = getIntent().getExtras();
        setContentView(R.layout.widget_settings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (extras != null) {
            this.f3720P = extras.getInt("appWidgetId", 0);
        }
        if (this.f3720P == 0) {
            finish();
        }
        Intent intent = new Intent();
        intent.putExtra("appWidgetId", this.f3720P);
        setResult(-1, intent);
        getSupportFragmentManager().beginTransaction().replace(R.id.settings_content, new SharedPreferencesOnSharedPreferenceChangeListenerC1248a(this, this.f3720P)).commit();
    }

    @Override // cz.opentree.util.SessionedFragmentActivity
    /* renamed from: l */
    public void mo5204l() {
    }

    @Override // cz.opentree.util.SessionedFragmentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_widget_configure, menu);
        return true;
    }

    @Override // cz.opentree.util.SessionedFragmentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_item_save) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // cz.opentree.util.SessionedFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f3720P != 0) {
            AppWidgetManager.getInstance(this).notifyAppWidgetViewDataChanged(this.f3720P, R.id.widget_list);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
