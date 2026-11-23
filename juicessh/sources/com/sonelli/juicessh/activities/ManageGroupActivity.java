package com.sonelli.juicessh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.sonelli.gj0;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.models.Connection;
import com.sonelli.juicessh.models.ConnectionGroup;
import com.sonelli.juicessh.models.ConnectionGroupMembership;
import com.sonelli.juicessh.p002db.C1328DB;
import com.sonelli.util.SessionedActivity;
import com.sonelli.xj0;
import com.sonelli.yj0;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class ManageGroupActivity extends SessionedActivity {

    /* renamed from: P */
    public LinearLayout f3814P;

    /* renamed from: Q */
    public EditText f3815Q;

    /* renamed from: R */
    public xj0<Connection> f3816R;

    /* renamed from: S */
    public ConnectionGroup f3817S;

    /* renamed from: T */
    public yj0<Connection> f3818T;

    /* renamed from: U */
    public xj0.AbstractC2296d f3819U = new C1271a();

    /* renamed from: com.sonelli.juicessh.activities.ManageGroupActivity$a */
    /* loaded from: classes.dex */
    public class C1271a extends xj0.AbstractC2296d {
        public C1271a() {
        }

        @Override // com.sonelli.xj0.AbstractC2296d
        /* renamed from: a */
        public void mo5244a(View view) {
            ManageGroupActivity.this.f3818T = (yj0) view;
            ManageGroupActivity.this.startActivityForResult(new Intent(ManageGroupActivity.this, (Class<?>) ManageConnectionActivity.class), 1);
        }
    }

    @Override // com.sonelli.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        setContentView(R.layout.manage_group);
        this.f3814P = (LinearLayout) findViewById(R.id.main_content);
        this.f3815Q = (EditText) findViewById(R.id.groupName_value);
        xj0<Connection> xj0Var = new xj0<>(this);
        this.f3816R = xj0Var;
        xj0Var.m9793n(getString(R.string.connections_capital_c) + ":");
        this.f3816R.m9791l(getString(R.string.add_connection));
        this.f3816R.m9792m(this.f3819U);
        this.f3814P.addView(this.f3816R);
        Bundle extras = getIntent().getExtras();
        try {
            List<Connection> queryForAll = C1328DB.m5404d(Connection.class, this).queryForAll();
            if (extras == null || !extras.containsKey("group_id")) {
                this.f3817S = new ConnectionGroup();
                return;
            }
            UUID uuid = (UUID) extras.get("group_id");
            if (uuid == null) {
                gj0.m4142c("ManageGroupActivity", "Attempted to edit an invalid group");
                this.f3817S = new ConnectionGroup();
                return;
            }
            ConnectionGroup connectionGroup = (ConnectionGroup) C1328DB.m5404d(ConnectionGroup.class, this).queryForId(uuid);
            this.f3817S = connectionGroup;
            if (connectionGroup == null) {
                gj0.m4142c("ManageGroupActivity", "Unable to load group " + uuid.toString() + " from DB");
                this.f3817S = new ConnectionGroup();
                return;
            }
            this.f3815Q.setText(connectionGroup.name);
            gj0.m4141b("ManageGroupActivity", "Loading group memberships for group " + this.f3817S.f3993id.toString());
            List<ConnectionGroupMembership> queryForEq = C1328DB.m5404d(ConnectionGroupMembership.class, this).queryForEq("group_id", this.f3817S);
            ArrayList<Connection> arrayList = new ArrayList<>();
            for (ConnectionGroupMembership connectionGroupMembership : queryForEq) {
                Iterator<Connection> it = queryForAll.iterator();
                while (true) {
                    if (it.hasNext()) {
                        Connection next = it.next();
                        if (connectionGroupMembership.connection.m5383m() != null && connectionGroupMembership.connection.f3993id.equals(next.f3993id)) {
                            arrayList.add(next);
                            break;
                        }
                    }
                }
            }
            gj0.m4141b("ManageGroupActivity", "Group " + this.f3817S.name + " has " + arrayList.size() + " connections");
            this.f3816R.m9795p(queryForAll, arrayList);
            getSupportActionBar().setTitle(R.string.update_group);
        } catch (NullPointerException e) {
            e.printStackTrace();
            this.f3817S = new ConnectionGroup();
        } catch (SQLException e2) {
            e2.printStackTrace();
            gj0.m4142c("ManageGroupActivity", e2.getMessage());
            this.f3817S = new ConnectionGroup();
        }
    }

    @Override // com.sonelli.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
        try {
            this.f3816R.m9794o(C1328DB.m5404d(Connection.class, this).queryForAll());
        } catch (SQLException unused) {
        }
    }

    /* renamed from: n */
    public void m5287n() {
        boolean z;
        if (this.f3815Q.getText().toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.you_must_enter_a_group_name), 0).show();
            return;
        }
        try {
            this.f3817S.name = this.f3815Q.getText().toString();
            C1328DB.m5404d(ConnectionGroup.class, this).createOrUpdate(this.f3817S);
            List<ConnectionGroupMembership> queryForEq = C1328DB.m5404d(ConnectionGroupMembership.class, this).queryForEq("group_id", this.f3817S);
            ArrayList arrayList = new ArrayList();
            Iterator<Connection> it = this.f3816R.m9788i().iterator();
            while (it.hasNext()) {
                Connection next = it.next();
                ConnectionGroupMembership connectionGroupMembership = new ConnectionGroupMembership();
                for (ConnectionGroupMembership connectionGroupMembership2 : queryForEq) {
                    if (connectionGroupMembership2.connection.m5383m() != null && connectionGroupMembership2.connection.f3993id.toString().equals(next.f3993id.toString())) {
                        connectionGroupMembership = connectionGroupMembership2;
                    }
                }
                connectionGroupMembership.group = this.f3817S;
                connectionGroupMembership.connection = next;
                C1328DB.m5404d(ConnectionGroupMembership.class, this).createOrUpdate(connectionGroupMembership);
                arrayList.add(next);
            }
            for (ConnectionGroupMembership connectionGroupMembership3 : queryForEq) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = false;
                        break;
                    }
                    Connection connection = (Connection) it2.next();
                    if (connectionGroupMembership3.connection.m5383m() != null && connectionGroupMembership3.connection.f3993id.toString().equals(connection.f3993id.toString())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    C1328DB.m5404d(ConnectionGroupMembership.class, this).delete(connectionGroupMembership3);
                }
            }
            Intent intent = new Intent();
            intent.putExtra("id", this.f3817S.f3993id);
            setResult(-1, intent);
            finish();
        } catch (SQLException e) {
            gj0.m4142c("ManageGroupActivity", "Failed to save group: " + e.getMessage());
            setResult(0, new Intent());
            finish();
        }
    }

    @Override // com.sonelli.util.SessionedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        try {
            if (i2 == -1) {
                try {
                    intent.getExtras().containsKey("id");
                } catch (NullPointerException unused) {
                }
                this.f3818T = null;
            } else {
                if (i2 != 0) {
                    return;
                }
                this.f3818T.f8257P.setSelection(0);
                this.f3818T = null;
            }
        } catch (NullPointerException unused2) {
        }
    }

    @Override // com.sonelli.util.SessionedActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_manage_group, menu);
        return true;
    }

    @Override // com.sonelli.util.SessionedActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_item_save) {
            return super.onOptionsItemSelected(menuItem);
        }
        m5287n();
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
