package com.sonelli.juicessh.activities;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.sonelli.gj0;
import com.sonelli.juicessh.R;
import com.sonelli.util.SessionedActivity;
import java.util.Scanner;

/* loaded from: classes.dex */
public class ViewLicenseActivity extends SessionedActivity {

    /* renamed from: P */
    public int f3950P;

    @Override // com.sonelli.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        setContentView(R.layout.license_view);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Toast.makeText(this, R.string.could_not_load_license, 0).show();
            finish();
        }
        int i = extras.getInt("LICENSE_RESOURCE");
        this.f3950P = i;
        if (i == -1) {
            Toast.makeText(this, R.string.could_not_load_license, 0).show();
            finish();
        }
    }

    @Override // com.sonelli.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
        gj0.m4141b("ViewLicenseActivity", "Loading license resource ID: " + this.f3950P);
        Scanner scanner = new Scanner(getResources().openRawResource(this.f3950P));
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
            sb.append("\n");
        }
        ((TextView) findViewById(R.id.license_text)).setText(sb.toString());
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
