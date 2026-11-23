package cz.opentree.juicessh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TextView;
import com.j256.ormlite.stmt.query.SimpleComparison;
import cz.opentree.gj0;
import cz.opentree.juicessh.R;
import cz.opentree.util.SessionedActivity;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class LogViewerActivity extends SessionedActivity {

    /* renamed from: P */
    public ScrollView f3733P;

    /* renamed from: Q */
    public TextView f3734Q;

    /* renamed from: cz.opentree.juicessh.activities.LogViewerActivity$a */
    /* loaded from: classes.dex */
    public class RunnableC1253a implements Runnable {
        public RunnableC1253a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogViewerActivity.this.f3733P.fullScroll(KeycodeConstants.KEYCODE_MEDIA_RECORD);
        }
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        setContentView(R.layout.log_viewer);
        this.f3734Q = (TextView) findViewById(R.id.log_view);
        this.f3733P = (ScrollView) findViewById(R.id.scroll_view);
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
        m5224n();
    }

    /* renamed from: n */
    public void m5224n() {
        this.f3734Q.setText("");
        Iterator it = new ArrayList(gj0.m4143d(this)).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = str.contains("(error)") ? "red" : "green";
            this.f3734Q.append(Html.fromHtml("<font color=" + str2 + SimpleComparison.GREATER_THAN_OPERATION + str + "</font><br />"));
        }
        this.f3733P.post(new RunnableC1253a());
    }

    @Override // cz.opentree.util.SessionedActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_log_viewer, menu);
        return true;
    }

    @Override // cz.opentree.util.SessionedActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != R.id.menu_item_email) {
            if (itemId != R.id.menu_item_refresh) {
                return super.onOptionsItemSelected(menuItem);
            }
            m5224n();
            return true;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{getString(R.string.support_email_address)});
        intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.log_viewer));
        intent.putExtra("android.intent.extra.TEXT", this.f3734Q.getText());
        startActivity(Intent.createChooser(intent, getString(R.string.share)));
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
