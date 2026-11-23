package cz.opentree.limessh.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import cz.opentree.gj0;
import cz.opentree.ih0;
import cz.opentree.limessh.R;
import cz.opentree.limessh.models.Connection;
import cz.opentree.limessh.models.PortForward;
import cz.opentree.limessh.p002db.C1328DB;
import cz.opentree.th0;
import cz.opentree.util.SessionedActivity;
import java.sql.SQLException;
import java.util.UUID;

/* loaded from: classes.dex */
public class ManagePortForwardActivity extends SessionedActivity {

    /* renamed from: P */
    public PortForward f3823P;

    /* renamed from: Q */
    public TextView f3824Q;

    /* renamed from: R */
    public Spinner f3825R;

    /* renamed from: S */
    public Spinner f3826S;

    /* renamed from: T */
    public TextView f3827T;

    /* renamed from: U */
    public TextView f3828U;

    /* renamed from: V */
    public TextView f3829V;

    /* renamed from: W */
    public CheckBox f3830W;

    /* renamed from: X */
    public CheckBox f3831X;

    /* renamed from: Y */
    public TableRow f3832Y;

    /* renamed from: Z */
    public TableRow f3833Z;

    /* renamed from: a0 */
    public TableRow f3834a0;

    /* renamed from: b0 */
    public TableRow f3835b0;

    /* renamed from: c0 */
    public TableRow f3836c0;

    /* renamed from: cz.opentree.limessh.activities.ManagePortForwardActivity$a */
    /* loaded from: classes.dex */
    public class C1273a implements AdapterView.OnItemSelectedListener {
        public C1273a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            ManagePortForwardActivity managePortForwardActivity = ManagePortForwardActivity.this;
            managePortForwardActivity.m5291o(((Integer) managePortForwardActivity.f3826S.getSelectedItem()).intValue());
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            ManagePortForwardActivity.this.m5291o(0);
        }
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        setContentView(R.layout.manage_port_forward);
        this.f3824Q = (TextView) findViewById(R.id.name);
        this.f3825R = (Spinner) findViewById(R.id.connection_spinner);
        this.f3826S = (Spinner) findViewById(R.id.mode_spinner);
        this.f3827T = (TextView) findViewById(R.id.local_port);
        this.f3828U = (TextView) findViewById(R.id.remote_host);
        this.f3829V = (TextView) findViewById(R.id.remote_port);
        this.f3830W = (CheckBox) findViewById(R.id.open_in_browser);
        this.f3831X = (CheckBox) findViewById(R.id.use_as_proxy);
        this.f3832Y = (TableRow) findViewById(R.id.row_remote_host);
        this.f3833Z = (TableRow) findViewById(R.id.row_remote_port);
        this.f3834a0 = (TableRow) findViewById(R.id.row_open_in_browser);
        this.f3835b0 = (TableRow) findViewById(R.id.row_use_as_proxy);
        this.f3836c0 = (TableRow) findViewById(R.id.row_socks_explanation);
        this.f3826S.setOnItemSelectedListener(new C1273a());
        th0 th0Var = new th0(this);
        ih0 ih0Var = new ih0(this, null, false);
        this.f3826S.setAdapter((SpinnerAdapter) th0Var);
        this.f3825R.setAdapter((SpinnerAdapter) ih0Var);
        try {
            UUID uuid = (UUID) getIntent().getExtras().get("id");
            gj0.m4142c("PortForwardActivity", "Loading forward: " + uuid.toString());
            PortForward portForward = (PortForward) C1328DB.m5404d(PortForward.class, this).queryForId(uuid);
            this.f3823P = portForward;
            portForward.connection.m5383m();
            this.f3824Q.setText(this.f3823P.name);
            this.f3827T.setText(String.valueOf(this.f3823P.localPort));
            this.f3828U.setText(this.f3823P.host);
            this.f3829V.setText(String.valueOf(this.f3823P.remotePort));
            this.f3830W.setChecked(this.f3823P.openInBrowser.booleanValue());
            this.f3831X.setChecked(this.f3823P.useAsProxy.booleanValue());
            int m4780b = ih0Var.m4780b(this.f3823P.connection);
            if (m4780b > -1) {
                this.f3825R.setSelection(m4780b);
            }
            this.f3826S.setSelection(this.f3823P.mode);
            getSupportActionBar().setTitle(R.string.update_port_forward);
        } catch (IllegalArgumentException unused) {
            this.f3823P = new PortForward();
        } catch (NullPointerException unused2) {
            this.f3823P = new PortForward();
        } catch (SQLException e) {
            this.f3823P = new PortForward();
            e.printStackTrace();
        }
    }

    @Override // cz.opentree.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
    }

    /* renamed from: n */
    public void m5290n() {
        try {
            this.f3823P.name = this.f3824Q.getText().toString();
            this.f3823P.connection = (Connection) this.f3825R.getSelectedItem();
            this.f3823P.host = this.f3828U.getText().toString();
            if (this.f3827T.getText().length() > 0) {
                this.f3823P.localPort = Integer.parseInt(this.f3827T.getText().toString());
            }
            if (this.f3829V.getText().length() > 0) {
                this.f3823P.remotePort = Integer.parseInt(this.f3829V.getText().toString());
            }
            this.f3823P.mode = ((Integer) this.f3826S.getSelectedItem()).intValue();
            this.f3823P.openInBrowser = Boolean.valueOf(this.f3830W.isChecked());
            this.f3823P.useAsProxy = Boolean.valueOf(this.f3831X.isChecked());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String m5498w = this.f3823P.m5498w(this);
        if (m5498w != null) {
            Toast.makeText(this, m5498w, 0).show();
            return;
        }
        try {
            C1328DB.m5404d(PortForward.class, this).createOrUpdate(this.f3823P);
            setResult(-1);
        } catch (SQLException e2) {
            gj0.m4142c("PortForwardActivity", "Unable to save port forward: " + e2.getMessage());
        }
        finish();
    }

    /* renamed from: o */
    public void m5291o(int i) {
        if (i == 0 || i == 1) {
            this.f3835b0.setVisibility(8);
            this.f3832Y.setVisibility(0);
            this.f3833Z.setVisibility(0);
            this.f3834a0.setVisibility(0);
            this.f3836c0.setVisibility(8);
            return;
        }
        if (i != 2) {
            return;
        }
        this.f3832Y.setVisibility(8);
        this.f3833Z.setVisibility(8);
        this.f3834a0.setVisibility(8);
        this.f3836c0.setVisibility(0);
    }

    @Override // cz.opentree.util.SessionedActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_manage_portforward, menu);
        return true;
    }

    @Override // cz.opentree.util.SessionedActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_item_save) {
            return super.onOptionsItemSelected(menuItem);
        }
        m5290n();
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
