package com.sonelli.juicessh.activities;

import android.os.Bundle;
import com.sonelli.fj0;
import com.sonelli.juicessh.R;
import com.sonelli.util.SessionedFragmentActivity;

/* loaded from: classes.dex */
public class SoftwareLicensesActivity extends SessionedFragmentActivity {
    @Override // com.sonelli.util.SessionedFragmentActivity
    /* renamed from: j */
    public void mo5203j(Bundle bundle) {
        setContentView(R.layout.fragment_container);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new fj0()).commitAllowingStateLoss();
        }
    }

    @Override // com.sonelli.util.SessionedFragmentActivity
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
