package cz.opentree.limessh.activities;

import android.os.Bundle;
import cz.opentree.limessh.R;
import cz.opentree.limessh.fragments.ManageCloudSyncFragment;
import cz.opentree.util.SessionedFragmentActivity;

/* loaded from: classes.dex */
public class ManageCloudSyncActivity extends SessionedFragmentActivity {
    @Override // cz.opentree.util.SessionedFragmentActivity
    /* renamed from: j */
    public void mo5203j(Bundle bundle) {
        setContentView(R.layout.fragment_container);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new ManageCloudSyncFragment()).commitAllowingStateLoss();
        }
    }

    @Override // cz.opentree.util.SessionedFragmentActivity
    /* renamed from: l */
    public void mo5204l() {
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
