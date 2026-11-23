package cz.opentree.juicessh.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import cz.opentree.bj0;
import cz.opentree.juicessh.R;
import cz.opentree.util.SessionedFragmentActivity;
import cz.opentree.wk0;

/* loaded from: classes.dex */
public class BookclubActivity extends SessionedFragmentActivity {

    /* renamed from: cz.opentree.juicessh.activities.BookclubActivity$a */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC1247a implements DialogInterface.OnClickListener {

        /* renamed from: O */
        public final /* synthetic */ wk0 f3715O;

        public DialogInterfaceOnClickListenerC1247a(wk0 wk0Var) {
            this.f3715O = wk0Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f3715O.m9579o()) {
                return;
            }
            BookclubActivity.this.startActivity(new Intent(BookclubActivity.this, (Class<?>) MainActivity.class));
        }
    }

    /* renamed from: m */
    public static wk0 m5215m(Context context) {
        return new wk0(context, context.getString(R.string.remove_bookclub), context.getString(R.string.remove_bookclub_text));
    }

    @Override // cz.opentree.util.SessionedFragmentActivity
    /* renamed from: j */
    public void mo5203j(Bundle bundle) {
        setContentView(R.layout.fragment_container);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new bj0()).commitAllowingStateLoss();
        }
    }

    @Override // cz.opentree.util.SessionedFragmentActivity
    /* renamed from: l */
    public void mo5204l() {
    }

    @Override // cz.opentree.util.SessionedFragmentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_bookclub, menu);
        return true;
    }

    @Override // cz.opentree.util.SessionedFragmentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_item_remove_booklub) {
            wk0 m5215m = m5215m(this);
            m5215m.setPositiveButton(R.string.f3674ok, new DialogInterfaceOnClickListenerC1247a(m5215m));
            m5215m.m9577m(R.string.never_show_bookclub_again);
            if (!isFinishing()) {
                m5215m.show();
            }
        }
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
