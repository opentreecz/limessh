package com.sonelli.juicessh.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.fragment.app.FragmentTransaction;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.fragments.ManageIdentityFragment;
import com.sonelli.juicessh.models.Identity;
import com.sonelli.juicessh.p002db.C1328DB;
import com.sonelli.util.SessionedFragmentActivity;
import java.sql.SQLException;
import java.util.UUID;

/* loaded from: classes.dex */
public class ManageIdentityActivity extends SessionedFragmentActivity {

    /* renamed from: P */
    public ManageIdentityFragment f3821P;

    /* renamed from: com.sonelli.juicessh.activities.ManageIdentityActivity$a */
    /* loaded from: classes.dex */
    public class C1272a implements ManageIdentityFragment.OnIdentityDialogCompleteListener {
        public C1272a() {
        }

        @Override // com.sonelli.juicessh.fragments.ManageIdentityFragment.OnIdentityDialogCompleteListener
        /* renamed from: a */
        public void mo5288a(Identity identity) {
            ManageIdentityActivity.this.setResult(-1);
            ManageIdentityActivity.this.finish();
        }

        @Override // com.sonelli.juicessh.fragments.ManageIdentityFragment.OnIdentityDialogCompleteListener
        public void onCancel() {
            ManageIdentityActivity.this.setResult(0);
            ManageIdentityActivity.this.finish();
        }
    }

    @Override // com.sonelli.util.SessionedFragmentActivity
    /* renamed from: j */
    public void mo5203j(Bundle bundle) {
        Identity identity;
        setContentView(R.layout.fragment_container);
        if (bundle == null) {
            try {
                Bundle extras = getIntent().getExtras();
                if (extras.containsKey("identity_id")) {
                    try {
                        identity = (Identity) C1328DB.m5404d(Identity.class, this).queryForId((UUID) extras.get("identity_id"));
                        getSupportActionBar().setTitle(R.string.update_identity);
                    } catch (SQLException unused) {
                        identity = new Identity();
                    }
                } else {
                    identity = new Identity();
                }
            } catch (NullPointerException unused2) {
                identity = new Identity();
            }
            ManageIdentityFragment manageIdentityFragment = new ManageIdentityFragment();
            this.f3821P = manageIdentityFragment;
            manageIdentityFragment.m5443r(identity);
            this.f3821P.m5444s(new C1272a());
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(R.id.fragment_container, this.f3821P);
            beginTransaction.commit();
        }
    }

    @Override // com.sonelli.util.SessionedFragmentActivity
    /* renamed from: l */
    public void mo5204l() {
    }

    @Override // com.sonelli.util.SessionedFragmentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_manage_identity, menu);
        return true;
    }

    @Override // com.sonelli.util.SessionedFragmentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_item_save) {
            return super.onOptionsItemSelected(menuItem);
        }
        ManageIdentityFragment manageIdentityFragment = this.f3821P;
        if (manageIdentityFragment == null) {
            return true;
        }
        manageIdentityFragment.m5441p();
        return true;
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
