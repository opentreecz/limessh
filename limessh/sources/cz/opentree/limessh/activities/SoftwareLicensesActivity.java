package cz.opentree.limessh.activities;

import android.os.Bundle;
import cz.opentree.fj0;
import cz.opentree.limessh.R;
import cz.opentree.util.SessionedFragmentActivity;

/* loaded from: classes.dex */
public class SoftwareLicensesActivity extends SessionedFragmentActivity {
    @Override // cz.opentree.util.SessionedFragmentActivity
    /* renamed from: j */
    public void mo5203j(Bundle bundle) {
        setContentView(R.layout.fragment_container);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new fj0()).commitAllowingStateLoss();
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
