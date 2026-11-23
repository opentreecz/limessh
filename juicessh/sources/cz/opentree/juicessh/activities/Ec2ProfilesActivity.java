package cz.opentree.juicessh.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.ec2link.Ec2Profile;
import cz.opentree.juicessh.p002db.C1328DB;
import cz.opentree.juicessh.services.Ec2Link;
import cz.opentree.juicessh.views.FontAwesomeTextView;
import cz.opentree.tj0;
import cz.opentree.util.SessionedActivity;
import java.sql.SQLException;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Ec2ProfilesActivity extends SessionedActivity {

    /* renamed from: P */
    public ListView f3725P;

    /* renamed from: Q */
    public tj0 f3726Q;

    /* renamed from: cz.opentree.juicessh.activities.Ec2ProfilesActivity$a */
    /* loaded from: classes.dex */
    public class C1249a implements AdapterView.OnItemClickListener {
        public C1249a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Ec2Link.m5632b(Ec2ProfilesActivity.this, (Ec2Profile) ((ListView) adapterView).getAdapter().getItem(i));
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.Ec2ProfilesActivity$b */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1250b implements View.OnClickListener {
        public ViewOnClickListenerC1250b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ec2ProfilesActivity.this.m5220o(null);
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.Ec2ProfilesActivity$c */
    /* loaded from: classes.dex */
    public class C1251c extends ArrayAdapter<Ec2Profile> {
        public C1251c(Context context, int i) {
            super(context, i);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        @SuppressLint({"StringFormatMatches"})
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = Ec2ProfilesActivity.this.getLayoutInflater().inflate(R.layout.identity_menu_item, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.itemTitle);
            TextView textView2 = (TextView) view.findViewById(R.id.itemSubtitle);
            ((FontAwesomeTextView) view.findViewById(R.id.itemIcon)).setText(R.string.icon_refresh);
            Ec2Profile item = getItem(i);
            String str = item.name;
            if (str != null) {
                textView.setText(str);
            } else {
                textView.setText(R.string.ec2_sync_profile);
            }
            if (item.isEnabled) {
                long j = item.lastSyncTime * 1000;
                if (j > 1) {
                    String formatDateTime = DateUtils.formatDateTime(Ec2ProfilesActivity.this, j, 16);
                    String formatDateTime2 = DateUtils.formatDateTime(Ec2ProfilesActivity.this, j, 1);
                    if (item.lastSyncItemCount != 1) {
                        textView2.setText(String.format(Ec2ProfilesActivity.this.getString(R.string.items_synced_on), Integer.valueOf(item.lastSyncItemCount), formatDateTime, formatDateTime2));
                    } else {
                        textView2.setText(String.format(Ec2ProfilesActivity.this.getString(R.string.item_synced_on), Integer.valueOf(item.lastSyncItemCount), formatDateTime, formatDateTime2));
                    }
                } else {
                    textView2.setText(R.string.never_syncronised);
                }
            } else {
                String string = Ec2ProfilesActivity.this.getString(R.string.disabled);
                if (item.disabledReason != null) {
                    string = string + ": " + item.disabledReason;
                }
                textView2.setText(string);
            }
            return view;
        }
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        setContentView(R.layout.simple_list_activity);
        this.f3725P = (ListView) findViewById(R.id.list);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.empty);
        TextView textView = (TextView) findViewById(R.id.emptyTitle);
        TextView textView2 = (TextView) findViewById(R.id.emptyMessage);
        this.f3725P.setDividerHeight(0);
        registerForContextMenu(this.f3725P);
        this.f3725P.setOnItemClickListener(new C1249a());
        textView.setText(getString(R.string.no_profiles));
        textView2.setText(getString(R.string.you_do_not_have_any_ec2_sync_profiles));
        this.f3725P.setEmptyView(linearLayout);
        ((FloatingActionButton) findViewById(R.id.fab_new)).setOnClickListener(new ViewOnClickListenerC1250b());
        this.f3725P.setAdapter((ListAdapter) new C1251c(this, R.layout.identity_menu_item));
        this.f3726Q = new tj0(this.f3725P);
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f3726Q, new IntentFilter("cz.opentree.juicessh.ec2sync.progress"));
        m5221p();
    }

    /* renamed from: n */
    public final void m5219n(Ec2Profile ec2Profile) {
        try {
            C1328DB.m5404d(Ec2Profile.class, this).delete(ec2Profile);
            Ec2Link.m5631a(this);
        } catch (SQLException unused) {
            Toast.makeText(this, R.string.there_was_a_problem_deleting_this_item, 0).show();
        }
    }

    /* renamed from: o */
    public final void m5220o(Ec2Profile ec2Profile) {
        Intent intent = new Intent(this, (Class<?>) ManageEc2ProfileActivity.class);
        try {
            intent.putExtra("ec2profile_id", ec2Profile.f3993id);
        } catch (NullPointerException unused) {
        }
        startActivity(intent);
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        super.onContextItemSelected(menuItem);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
        Ec2Profile ec2Profile = (Ec2Profile) ((ListView) adapterContextMenuInfo.targetView.getParent()).getAdapter().getItem(adapterContextMenuInfo.position);
        int itemId = menuItem.getItemId();
        if (itemId == R.id.delete) {
            m5219n(ec2Profile);
            m5221p();
            return true;
        }
        if (itemId == R.id.edit) {
            m5220o(ec2Profile);
            return true;
        }
        if (itemId != R.id.sync_now) {
            return true;
        }
        Ec2Link.m5632b(this, ec2Profile);
        return true;
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        MenuInflater menuInflater = getMenuInflater();
        contextMenu.setHeaderTitle(R.string.ec2_sync_profile);
        menuInflater.inflate(R.menu.ec2_profile_context_menu, contextMenu);
    }

    @Override // cz.opentree.util.SessionedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f3726Q);
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* renamed from: p */
    public final void m5221p() {
        ArrayAdapter arrayAdapter = (ArrayAdapter) this.f3725P.getAdapter();
        arrayAdapter.clear();
        Iterator<Ec2Profile> it = Ec2Profile.m5534s(this).iterator();
        while (it.hasNext()) {
            arrayAdapter.add(it.next());
        }
        arrayAdapter.notifyDataSetChanged();
    }
}
