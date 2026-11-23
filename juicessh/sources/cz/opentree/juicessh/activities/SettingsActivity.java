package cz.opentree.juicessh.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import cz.opentree.ej0;
import cz.opentree.juicessh.R;
import cz.opentree.util.SessionedFragmentActivity;

/* loaded from: classes.dex */
public class SettingsActivity extends SessionedFragmentActivity {
    @Override // cz.opentree.util.SessionedFragmentActivity
    /* renamed from: j */
    public void mo5203j(Bundle bundle) {
    }

    @Override // cz.opentree.util.SessionedFragmentActivity
    /* renamed from: l */
    public void mo5204l() {
    }

    @Override // cz.opentree.util.SessionedFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fragment_container);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ej0()).commitAllowingStateLoss();
        }
    }

    @Override // cz.opentree.util.SessionedFragmentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override // cz.opentree.util.SessionedFragmentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
