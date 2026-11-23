package com.sonelli.juicessh.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TableRow;
import android.widget.Toast;
import com.sonelli.fh0;
import com.sonelli.gj0;
import com.sonelli.ih0;
import com.sonelli.jh0;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.models.Config;
import com.sonelli.juicessh.models.Connection;
import com.sonelli.juicessh.models.ConnectionGroup;
import com.sonelli.juicessh.models.ConnectionGroupMembership;
import com.sonelli.juicessh.models.Identity;
import com.sonelli.juicessh.models.Snippet;
import com.sonelli.juicessh.p002db.C1328DB;
import com.sonelli.uh0;
import com.sonelli.util.NewGroupPrompt;
import com.sonelli.util.SessionedActivity;
import com.sonelli.vh0;
import com.sonelli.xj0;
import com.sonelli.yj0;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class ManageConnectionActivity extends SessionedActivity {

    /* renamed from: S */
    public EditText f3754S;

    /* renamed from: T */
    public EditText f3755T;

    /* renamed from: U */
    public EditText f3756U;

    /* renamed from: V */
    public xj0<ConnectionGroup> f3757V;

    /* renamed from: W */
    public Spinner f3758W;

    /* renamed from: X */
    public Spinner f3759X;

    /* renamed from: Y */
    public Spinner f3760Y;

    /* renamed from: Z */
    public Spinner f3761Z;

    /* renamed from: a0 */
    public TableRow f3762a0;

    /* renamed from: b0 */
    public EditText f3763b0;

    /* renamed from: c0 */
    public ih0 f3764c0;

    /* renamed from: d0 */
    public jh0 f3765d0;

    /* renamed from: e0 */
    public uh0 f3766e0;

    /* renamed from: f0 */
    public fh0 f3767f0;

    /* renamed from: g0 */
    public TableRow f3768g0;

    /* renamed from: h0 */
    public TableRow f3769h0;

    /* renamed from: i0 */
    public TableRow f3770i0;

    /* renamed from: j0 */
    public TableRow f3771j0;

    /* renamed from: k0 */
    public Spinner f3772k0;

    /* renamed from: P */
    public yj0<ConnectionGroup> f3751P = null;

    /* renamed from: Q */
    public Connection f3752Q = new Connection();

    /* renamed from: R */
    public Identity f3753R = new Identity();

    /* renamed from: l0 */
    public xj0.AbstractC2296d f3773l0 = new C1260a();

    /* renamed from: com.sonelli.juicessh.activities.ManageConnectionActivity$a */
    /* loaded from: classes.dex */
    public class C1260a extends xj0.AbstractC2296d {

        /* renamed from: com.sonelli.juicessh.activities.ManageConnectionActivity$a$a */
        /* loaded from: classes.dex */
        public class a implements NewGroupPrompt.PromptListener {

            /* renamed from: a */
            public yj0<ConnectionGroup> f3775a;

            /* renamed from: b */
            public final /* synthetic */ View f3776b;

            public a(View view) {
                this.f3776b = view;
                this.f3775a = (yj0) view;
            }

            @Override // com.sonelli.util.NewGroupPrompt.PromptListener
            /* renamed from: e */
            public void mo5209e(String str) {
                ConnectionGroup connectionGroup = new ConnectionGroup(str);
                try {
                    C1328DB.m5404d(ConnectionGroup.class, ManageConnectionActivity.this).create(connectionGroup);
                    try {
                        List queryForAll = C1328DB.m5404d(ConnectionGroup.class, ManageConnectionActivity.this).queryForAll();
                        ConnectionGroup connectionGroup2 = null;
                        Iterator it = queryForAll.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ConnectionGroup connectionGroup3 = (ConnectionGroup) it.next();
                            if (connectionGroup3.f3993id.equals(connectionGroup.f3993id)) {
                                connectionGroup2 = connectionGroup3;
                                break;
                            }
                        }
                        ManageConnectionActivity.this.f3757V.m9794o(queryForAll);
                        if (connectionGroup2 != null) {
                            this.f3775a.m10184d(connectionGroup2);
                        }
                    } catch (SQLException unused) {
                    }
                } catch (SQLException e) {
                    gj0.m4142c("ManageConnectionActivity", "Could not save connection group");
                    e.printStackTrace();
                    ManageConnectionActivity manageConnectionActivity = ManageConnectionActivity.this;
                    Toast.makeText(manageConnectionActivity, manageConnectionActivity.getString(R.string.unknown_problem_making_group), 0).show();
                }
            }

            @Override // com.sonelli.util.NewGroupPrompt.PromptListener
            public void onCancel() {
                try {
                    this.f3775a.f8257P.setSelection(0);
                    this.f3775a = null;
                } catch (NullPointerException unused) {
                }
            }
        }

        public C1260a() {
        }

        @Override // com.sonelli.xj0.AbstractC2296d
        /* renamed from: a */
        public void mo5244a(View view) {
            NewGroupPrompt newGroupPrompt = new NewGroupPrompt(ManageConnectionActivity.this, new a(view));
            newGroupPrompt.m9011o(true);
            if (ManageConnectionActivity.this.isFinishing()) {
                return;
            }
            newGroupPrompt.show();
        }
    }

    /* renamed from: com.sonelli.juicessh.activities.ManageConnectionActivity$b */
    /* loaded from: classes.dex */
    public class C1261b implements AdapterView.OnItemSelectedListener {
        public C1261b() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [android.widget.Adapter] */
        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i == adapterView.getAdapter().getCount() - 1) {
                ManageConnectionActivity.this.startActivityForResult(new Intent(ManageConnectionActivity.this, (Class<?>) ManageIdentityActivity.class), 2);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.sonelli.juicessh.activities.ManageConnectionActivity$c */
    /* loaded from: classes.dex */
    public class C1262c implements AdapterView.OnItemSelectedListener {
        public C1262c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            int itemId = (int) ManageConnectionActivity.this.f3765d0.getItemId(i);
            if (itemId == 0) {
                ManageConnectionActivity.this.f3752Q.type = 0;
                ManageConnectionActivity.this.f3768g0.setVisibility(0);
                ManageConnectionActivity.this.f3769h0.setVisibility(0);
                ManageConnectionActivity.this.f3770i0.setVisibility(0);
                ManageConnectionActivity.this.f3771j0.setVisibility(0);
                ManageConnectionActivity.this.f3762a0.setVisibility(8);
                return;
            }
            if (itemId == 1) {
                ManageConnectionActivity.this.f3752Q.type = 1;
                ManageConnectionActivity.this.f3768g0.setVisibility(0);
                ManageConnectionActivity.this.f3769h0.setVisibility(0);
                ManageConnectionActivity.this.f3770i0.setVisibility(0);
                ManageConnectionActivity.this.f3771j0.setVisibility(0);
                ManageConnectionActivity.this.f3762a0.setVisibility(0);
                return;
            }
            if (itemId == 2) {
                ManageConnectionActivity.this.f3752Q.type = 2;
                ManageConnectionActivity.this.f3768g0.setVisibility(8);
                ManageConnectionActivity.this.f3769h0.setVisibility(8);
                ManageConnectionActivity.this.f3770i0.setVisibility(8);
                ManageConnectionActivity.this.f3771j0.setVisibility(8);
                ManageConnectionActivity.this.f3762a0.setVisibility(8);
                return;
            }
            if (itemId != 3) {
                return;
            }
            ManageConnectionActivity.this.f3752Q.type = 3;
            ManageConnectionActivity.this.f3768g0.setVisibility(0);
            ManageConnectionActivity.this.f3769h0.setVisibility(0);
            ManageConnectionActivity.this.f3770i0.setVisibility(8);
            ManageConnectionActivity.this.f3771j0.setVisibility(8);
            ManageConnectionActivity.this.f3762a0.setVisibility(8);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public void connect(View view) {
        m5242v();
    }

    @Override // com.sonelli.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        int m4780b;
        int m8893a;
        setContentView(R.layout.manage_connection);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.group_selector_holder);
        this.f3768g0 = (TableRow) findViewById(R.id.addressRow);
        this.f3769h0 = (TableRow) findViewById(R.id.portRow);
        this.f3770i0 = (TableRow) findViewById(R.id.viaRow);
        this.f3771j0 = (TableRow) findViewById(R.id.identityRow);
        this.f3754S = (EditText) findViewById(R.id.nickname_value);
        this.f3755T = (EditText) findViewById(R.id.address_value);
        this.f3756U = (EditText) findViewById(R.id.port_value);
        this.f3758W = (Spinner) findViewById(R.id.via_spinner);
        ih0 ih0Var = new ih0(this, null, true);
        this.f3764c0 = ih0Var;
        this.f3758W.setAdapter((SpinnerAdapter) ih0Var);
        this.f3760Y = (Spinner) findViewById(R.id.snippetSpinner);
        uh0 uh0Var = new uh0(this);
        this.f3766e0 = uh0Var;
        this.f3760Y.setAdapter((SpinnerAdapter) uh0Var);
        this.f3761Z = (Spinner) findViewById(R.id.backspaceModeSpinner);
        fh0 fh0Var = new fh0(this);
        this.f3767f0 = fh0Var;
        this.f3761Z.setAdapter((SpinnerAdapter) fh0Var);
        Spinner spinner = (Spinner) findViewById(R.id.idSpinner);
        this.f3772k0 = spinner;
        spinner.setAdapter((SpinnerAdapter) new vh0(this, new ArrayList()));
        this.f3772k0.setOnItemSelectedListener(new C1261b());
        this.f3762a0 = (TableRow) findViewById(R.id.mosh_command_row);
        EditText editText = (EditText) findViewById(R.id.mosh_command_value);
        this.f3763b0 = editText;
        editText.setText(Config.m5458d("mosh:mosh-server", this));
        xj0<ConnectionGroup> xj0Var = new xj0<>(this);
        this.f3757V = xj0Var;
        xj0Var.m9791l(getString(R.string.add_to_group));
        this.f3757V.m9789j();
        this.f3757V.m9792m(this.f3773l0);
        linearLayout.addView(this.f3757V);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                if (extras.containsKey("connection_id")) {
                    try {
                        try {
                            this.f3752Q = (Connection) C1328DB.m5404d(Connection.class, this).queryForId((UUID) extras.get("connection_id"));
                            ih0 ih0Var2 = new ih0(this, this.f3752Q, true);
                            this.f3764c0 = ih0Var2;
                            this.f3758W.setAdapter((SpinnerAdapter) ih0Var2);
                            this.f3754S.setText(this.f3752Q.nickname);
                            this.f3755T.setText(this.f3752Q.address);
                            this.f3756U.setText(String.valueOf(this.f3752Q.port));
                            String str = this.f3752Q.moshCommand;
                            if (str != null && str.length() > 0) {
                                this.f3763b0.setText(this.f3752Q.moshCommand);
                            }
                            this.f3753R = this.f3752Q.m5470v(this);
                            Snippet snippet = this.f3752Q.snippet;
                            if (snippet != null && snippet.m5383m() != null && (m8893a = this.f3766e0.m8893a(this.f3752Q.snippet.m5383m())) > -1) {
                                this.f3760Y.setSelection(m8893a);
                            }
                            int i = this.f3752Q.backspaceMode;
                            if (i > -1) {
                                this.f3761Z.setSelection(i);
                            }
                            Connection connection = this.f3752Q.via;
                            if (connection != null && connection.m5383m() != null && (m4780b = this.f3764c0.m4780b(this.f3752Q.via.m5383m())) > -1) {
                                this.f3758W.setSelection(m4780b);
                            }
                            getSupportActionBar().setTitle(R.string.update_connection);
                            m5241u(this.f3752Q);
                        } catch (SQLException unused) {
                            setResult(0, new Intent());
                            finish();
                            return;
                        }
                    } catch (NullPointerException unused2) {
                        setResult(0, new Intent());
                        finish();
                        return;
                    }
                }
            } catch (NullPointerException unused3) {
            }
        }
        this.f3759X = (Spinner) findViewById(R.id.type_spinner);
        jh0 jh0Var = new jh0(this);
        this.f3765d0 = jh0Var;
        this.f3759X.setAdapter((SpinnerAdapter) jh0Var);
        this.f3759X.setSelection(this.f3765d0.m5115b(this.f3752Q.type));
        this.f3759X.setOnItemSelectedListener(new C1262c());
    }

    @Override // com.sonelli.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
        m5243w();
        try {
            this.f3757V.m9794o(C1328DB.m5404d(ConnectionGroup.class, this).queryForAll());
        } catch (SQLException unused) {
        }
    }

    @Override // com.sonelli.util.SessionedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (i2 == -1) {
                try {
                    Bundle extras = intent.getExtras();
                    if (extras.containsKey("identity_id")) {
                        Identity identity = (Identity) C1328DB.m5404d(Identity.class, this).queryForId((UUID) extras.get("identity_id"));
                        m5243w();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= this.f3772k0.getAdapter().getCount() - 1) {
                                i3 = -1;
                                break;
                            } else if (((Identity) this.f3772k0.getAdapter().getItem(i3)).f3993id.equals(identity.f3993id)) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (i3 != -1) {
                            this.f3772k0.setSelection(i3);
                        }
                    }
                } catch (NullPointerException | SQLException unused) {
                }
            }
        }
        try {
            if (i2 != -1) {
                if (i2 == 0) {
                    this.f3751P.f8257P.setSelection(0);
                    this.f3751P = null;
                }
            }
            this.f3751P = null;
        } catch (NullPointerException unused2) {
        }
    }

    @Override // com.sonelli.util.SessionedActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_manage_connection, menu);
        return true;
    }

    @Override // com.sonelli.util.SessionedActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_item_save) {
            return super.onOptionsItemSelected(menuItem);
        }
        m5242v();
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

    /* renamed from: u */
    public final void m5241u(Connection connection) {
        try {
            List<ConnectionGroup> queryForAll = C1328DB.m5404d(ConnectionGroup.class, this).queryForAll();
            List<ConnectionGroupMembership> queryForEq = C1328DB.m5404d(ConnectionGroupMembership.class, this).queryForEq("connection_id", connection.f3993id);
            ArrayList<ConnectionGroup> arrayList = new ArrayList<>();
            for (ConnectionGroupMembership connectionGroupMembership : queryForEq) {
                Iterator<ConnectionGroup> it = queryForAll.iterator();
                while (true) {
                    if (it.hasNext()) {
                        ConnectionGroup next = it.next();
                        if (connectionGroupMembership.group.m5383m().f3993id.equals(next.f3993id)) {
                            arrayList.add(next);
                            break;
                        }
                    }
                }
            }
            this.f3757V.m9795p(queryForAll, arrayList);
        } catch (SQLException unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        if (r4 != 3) goto L58;
     */
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m5242v() {
        /*
            Method dump skipped, instructions count: 463
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.juicessh.activities.ManageConnectionActivity.m5242v():void");
    }

    /* renamed from: w */
    public final void m5243w() {
        Spinner spinner = (Spinner) findViewById(R.id.idSpinner);
        vh0 vh0Var = (vh0) spinner.getAdapter();
        int selectedItemPosition = spinner.getSelectedItemPosition();
        boolean z = selectedItemPosition == vh0Var.getCount() - 1;
        Identity identity = (selectedItemPosition == 0 || selectedItemPosition == -1 || selectedItemPosition == vh0Var.getCount() - 1 || vh0Var.isEmpty()) ? null : (Identity) vh0Var.getItem(spinner.getSelectedItemPosition());
        Identity identity2 = this.f3753R;
        try {
            List queryForAll = C1328DB.m5404d(Identity.class, this).queryForAll();
            Collections.sort(queryForAll);
            vh0Var.m9226c();
            vh0Var.m9224a(queryForAll);
            vh0Var.notifyDataSetChanged();
        } catch (SQLException unused) {
        }
        if (vh0Var.m9225b() > 0) {
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < vh0Var.getCount() - 1; i3++) {
                Identity identity3 = (Identity) vh0Var.getItem(i3);
                if (identity != null && identity3.f3993id.equals(identity.f3993id)) {
                    i = i3;
                }
                if (identity2 != null && identity3.f3993id.equals(identity2.f3993id)) {
                    i2 = i3;
                }
            }
            if (z) {
                spinner.setSelection(0);
            } else if (i != -1) {
                spinner.setSelection(i);
            } else if (i2 != -1) {
                spinner.setSelection(i2);
            }
        }
    }
}
