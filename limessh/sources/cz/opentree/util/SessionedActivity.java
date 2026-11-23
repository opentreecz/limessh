package cz.opentree.util;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import cz.opentree.limessh.R;
import cz.opentree.limessh.controllers.PinManager;
import cz.opentree.limessh.models.Config;
import cz.opentree.kj0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class SessionedActivity extends AppCompatActivity {

    /* renamed from: O */
    public ArrayList<PinManager.PinPromptDialog> f7266O = new ArrayList<>();

    /* renamed from: cz.opentree.util.SessionedActivity$a */
    /* loaded from: classes.dex */
    public class C2119a implements PinManager.PinPromptSimpleListener {
        public C2119a() {
        }

        @Override // cz.opentree.limessh.controllers.PinManager.PinPromptSimpleListener
        /* renamed from: a */
        public void mo5376a(PinManager.PinPromptDialog pinPromptDialog) {
            SessionedActivity.this.m9057i(pinPromptDialog);
        }

        @Override // cz.opentree.limessh.controllers.PinManager.PinPromptSimpleListener
        /* renamed from: d */
        public void mo5377d() {
            SessionedActivity.this.mo5214l();
        }

        @Override // cz.opentree.limessh.controllers.PinManager.PinPromptSimpleListener
        /* renamed from: e */
        public void mo5378e() {
        }
    }

    /* renamed from: cz.opentree.util.SessionedActivity$b */
    /* loaded from: classes.dex */
    public class C2120b implements PinManager.PinPromptSimpleListener {
        public C2120b() {
        }

        @Override // cz.opentree.limessh.controllers.PinManager.PinPromptSimpleListener
        /* renamed from: a */
        public void mo5376a(PinManager.PinPromptDialog pinPromptDialog) {
            Session.m9046g().m9047d(SessionedActivity.this);
        }

        @Override // cz.opentree.limessh.controllers.PinManager.PinPromptSimpleListener
        /* renamed from: d */
        public void mo5377d() {
        }

        @Override // cz.opentree.limessh.controllers.PinManager.PinPromptSimpleListener
        /* renamed from: e */
        public void mo5378e() {
        }
    }

    /* renamed from: i */
    public final void m9057i(PinManager.PinPromptDialog pinPromptDialog) {
        this.f7266O.add(pinPromptDialog);
    }

    /* renamed from: j */
    public abstract void mo5213j(Bundle bundle);

    /* renamed from: k */
    public void m9058k(Intent intent) {
    }

    /* renamed from: l */
    public abstract void mo5214l();

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 != -1) {
            finish();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setFormat(1);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isTaskRoot() && bundle == null) {
            kj0.m5916G(this);
        }
        int i = -1;
        try {
            i = Integer.parseInt(Config.m5458d("theme:dark", this));
        } catch (NumberFormatException unused) {
        }
        AppCompatDelegate.setDefaultNightMode(i);
        mo5213j(bundle);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m9058k(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_item_faq) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://limessh.com/faq"));
            startActivity(intent);
            return true;
        }
        if (itemId != R.id.menu_rate_limessh) {
            return false;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getResources().getString(R.string.app_package_name)));
        intent2.addFlags(1074266112);
        try {
            startActivity(intent2);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, getString(R.string.google_play_not_installed), 0).show();
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Session.m9046g().m9047d(this);
        Session.m9046g().m9048f(this, new C2120b());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Session.m9046g().m9047d(this);
        Session.m9046g().m9048f(this, new C2119a());
    }
}
