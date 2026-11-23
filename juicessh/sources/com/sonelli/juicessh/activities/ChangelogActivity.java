package com.sonelli.juicessh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.sonelli.gj0;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.models.Config;
import com.sonelli.juicessh.models.User;
import com.sonelli.util.SessionedActivity;
import java.util.Scanner;

/* loaded from: classes.dex */
public class ChangelogActivity extends SessionedActivity implements View.OnClickListener {

    /* renamed from: P */
    public TextView f3717P;

    /* renamed from: Q */
    public Button f3718Q;

    /* renamed from: R */
    public int f3719R = -1;

    @Override // com.sonelli.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        setContentView(R.layout.changelog);
        TextView textView = (TextView) findViewById(R.id.changelog);
        this.f3717P = textView;
        textView.setMovementMethod(new ScrollingMovementMethod());
        Button button = (Button) findViewById(R.id.button_ok);
        this.f3718Q = button;
        button.setOnClickListener(this);
        Intent intent = getIntent();
        if (intent != null) {
            this.f3719R = intent.getIntExtra("previous_version", -1);
        }
    }

    @Override // com.sonelli.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
        Scanner scanner = new Scanner(getResources().openRawResource(R.raw.changelog));
        String str = "";
        while (scanner.hasNextLine()) {
            str = str + scanner.nextLine() + "\n";
        }
        if (str.isEmpty()) {
            finish();
        }
        this.f3717P.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.button_ok) {
            return;
        }
        int i = this.f3719R;
        if (i <= 0 || i >= 124 || Config.m5459e(this, "changelog:seen_auth_migration_message") || User.m5525s(this).equals("New User")) {
            startActivity(new Intent(this, (Class<?>) MainActivity.class));
        } else {
            gj0.m4142c("ChangelogActivity", "Redirecting to the authentication migration activity");
            startActivity(new Intent(this, (Class<?>) AuthenticationMigrationActivity.class));
        }
    }
}
