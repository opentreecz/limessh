package cz.opentree.juicessh.activities;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager.widget.ViewPager;
import cz.opentree.ai0;
import cz.opentree.eh0;
import cz.opentree.gj0;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.Connection;
import cz.opentree.juicessh.models.ConnectionCounter;
import cz.opentree.juicessh.models.ConnectionGroup;
import cz.opentree.juicessh.models.ConnectionGroupMembership;
import cz.opentree.juicessh.models.ConnectionIdentity;
import cz.opentree.juicessh.models.Host;
import cz.opentree.juicessh.models.Identity;
import cz.opentree.juicessh.models.PortForward;
import cz.opentree.juicessh.models.Share;
import cz.opentree.juicessh.models.Snippet;
import cz.opentree.juicessh.models.User;
import cz.opentree.juicessh.models.ec2link.Ec2Connection;
import cz.opentree.juicessh.p002db.C1328DB;
import cz.opentree.kj0;
import cz.opentree.oi0;
import cz.opentree.pi0;
import cz.opentree.qg0;
import cz.opentree.sh0;
import cz.opentree.sj0;
import cz.opentree.ug0;
import cz.opentree.util.NewGroupPrompt;
import cz.opentree.util.SessionedFragmentActivity;
import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;

/* loaded from: classes.dex */
public class AddressBookActivity extends SessionedFragmentActivity {

    /* renamed from: P */
    public ViewPager f3693P;

    /* renamed from: Q */
    public eh0 f3694Q;

    /* renamed from: R */
    public Menu f3695R;

    /* renamed from: S */
    public sj0 f3696S;

    /* renamed from: cz.opentree.juicessh.activities.AddressBookActivity$a */
    /* loaded from: classes.dex */
    public class C1237a implements ViewPager.OnPageChangeListener {

        /* renamed from: cz.opentree.juicessh.activities.AddressBookActivity$a$a */
        /* loaded from: classes.dex */
        public class a extends pi0.AbstractC1720p {
            public a() {
            }

            @Override // cz.opentree.pi0.AbstractC1720p
            /* renamed from: a */
            public void mo3228a(String str) {
                super.mo3228a(str);
            }

            @Override // cz.opentree.pi0.AbstractC1720p
            /* renamed from: b */
            public void mo3229b(User user) {
                super.mo3229b(user);
                if (oi0.m7047d(user)) {
                    AddressBookActivity.this.getMenuInflater().inflate(R.menu.menu_addressbook_portforwards, AddressBookActivity.this.f3695R);
                }
            }
        }

        public C1237a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (AddressBookActivity.this.f3695R == null) {
                return;
            }
            AddressBookActivity.this.f3695R.clear();
            AddressBookActivity addressBookActivity = AddressBookActivity.this;
            AddressBookActivity.super.onCreateOptionsMenu(addressBookActivity.f3695R);
            if (i == 0) {
                if (kj0.m5917a().m5938u()) {
                    pi0.m7331j(AddressBookActivity.this, new a());
                    return;
                } else {
                    AddressBookActivity.this.getMenuInflater().inflate(R.menu.menu_addressbook_portforwards, AddressBookActivity.this.f3695R);
                    return;
                }
            }
            if (i == 1) {
                AddressBookActivity.this.getMenuInflater().inflate(R.menu.menu_addressbook_connections, AddressBookActivity.this.f3695R);
            } else {
                if (i != 2) {
                    return;
                }
                AddressBookActivity.this.getMenuInflater().inflate(R.menu.menu_addressbook_identities, AddressBookActivity.this.f3695R);
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.AddressBookActivity$b */
    /* loaded from: classes.dex */
    public class C1238b extends pi0.AbstractC1720p {

        /* renamed from: a */
        public final /* synthetic */ ContextMenu f3699a;

        public C1238b(ContextMenu contextMenu) {
            this.f3699a = contextMenu;
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            if (oi0.m7047d(user) && kj0.m5917a().mo5139z() && kj0.m5917a().m5921A()) {
                this.f3699a.getItem(1).setTitle(AddressBookActivity.this.getString(R.string.share));
                this.f3699a.getItem(1).setEnabled(true);
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.AddressBookActivity$c */
    /* loaded from: classes.dex */
    public class C1239c extends pi0.AbstractC1720p {

        /* renamed from: a */
        public final /* synthetic */ ContextMenu f3701a;

        public C1239c(ContextMenu contextMenu) {
            this.f3701a = contextMenu;
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            if (oi0.m7047d(user)) {
                if (kj0.m5917a().mo5139z() && kj0.m5917a().m5921A()) {
                    this.f3701a.getItem(2).setTitle(AddressBookActivity.this.getString(R.string.share));
                    this.f3701a.getItem(2).setEnabled(true);
                }
                if (kj0.m5917a().mo5134o() && kj0.m5917a().m5934p()) {
                    this.f3701a.getItem(4).setTitle(AddressBookActivity.this.getString(R.string.homescreen_shortcut));
                    this.f3701a.getItem(4).setEnabled(true);
                }
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.AddressBookActivity$d */
    /* loaded from: classes.dex */
    public class C1240d extends pi0.AbstractC1720p {

        /* renamed from: a */
        public final /* synthetic */ ContextMenu f3703a;

        public C1240d(ContextMenu contextMenu) {
            this.f3703a = contextMenu;
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            if (oi0.m7047d(user) && kj0.m5917a().mo5134o() && kj0.m5917a().m5934p()) {
                this.f3703a.getItem(2).setTitle(AddressBookActivity.this.getString(R.string.homescreen_shortcut));
                this.f3703a.getItem(2).setEnabled(true);
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.AddressBookActivity$e */
    /* loaded from: classes.dex */
    public class C1241e extends pi0.AbstractC1720p {

        /* renamed from: a */
        public final /* synthetic */ ConnectionGroup f3705a;

        public C1241e(ConnectionGroup connectionGroup) {
            this.f3705a = connectionGroup;
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            if (!oi0.m7047d(user)) {
                AddressBookActivity.this.startActivity(new Intent(AddressBookActivity.this, (Class<?>) PurchaseActivity.class));
            } else {
                Intent intent = new Intent(AddressBookActivity.this, (Class<?>) ManageShareActivity.class);
                intent.putExtra("group_id", this.f3705a.f3993id);
                AddressBookActivity.this.startActivityForResult(intent, 1);
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.AddressBookActivity$f */
    /* loaded from: classes.dex */
    public class C1242f extends pi0.AbstractC1720p {
        public C1242f() {
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            if (oi0.m7047d(user)) {
                Toast.makeText(AddressBookActivity.this, R.string.only_connection_groups_can_be_shared, 0).show();
            } else {
                AddressBookActivity.this.startActivity(new Intent(AddressBookActivity.this, (Class<?>) PurchaseActivity.class));
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.AddressBookActivity$g */
    /* loaded from: classes.dex */
    public class C1243g extends ug0.AbstractC2009b {
        public C1243g() {
        }

        @Override // cz.opentree.ug0.AbstractC2009b
        /* renamed from: a */
        public void mo5207a() {
            super.mo5207a();
            gj0.m4142c("AddressBookActivity", "Failed to export public key for invalid private key");
            AddressBookActivity addressBookActivity = AddressBookActivity.this;
            Toast.makeText(addressBookActivity, addressBookActivity.getString(R.string.unable_to_export_key), 0).show();
        }

        @Override // cz.opentree.ug0.AbstractC2009b
        /* renamed from: b */
        public void mo5208b(String str) {
            super.mo5208b(str);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", AddressBookActivity.this.getString(R.string.juicessh_public_key));
            intent.putExtra("android.intent.extra.TEXT", str);
            AddressBookActivity addressBookActivity = AddressBookActivity.this;
            addressBookActivity.startActivity(Intent.createChooser(intent, addressBookActivity.getResources().getString(R.string.share_using)));
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.AddressBookActivity$h */
    /* loaded from: classes.dex */
    public class C1244h extends sj0 {
        public C1244h() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                Bundle extras = intent.getExtras();
                int i = extras.getInt("state");
                if (extras.containsKey("portforward_id")) {
                    AddressBookActivity.this.m5206r((UUID) extras.get("portforward_id"), i);
                }
            } catch (NullPointerException unused) {
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.AddressBookActivity$i */
    /* loaded from: classes.dex */
    public class C1245i implements NewGroupPrompt.PromptListener {
        public C1245i() {
        }

        @Override // cz.opentree.util.NewGroupPrompt.PromptListener
        /* renamed from: e */
        public void mo5209e(String str) {
            try {
                C1328DB.m5404d(ConnectionGroup.class, AddressBookActivity.this).create(new ConnectionGroup(str));
                AddressBookActivity.this.f3694Q.m3497f().m4449j();
                AddressBookActivity.this.f3694Q.notifyDataSetChanged();
            } catch (SQLException e) {
                gj0.m4142c("AddressBookActivity", "Could not save connection group");
                e.printStackTrace();
                AddressBookActivity addressBookActivity = AddressBookActivity.this;
                Toast.makeText(addressBookActivity, addressBookActivity.getString(R.string.unknown_problem_making_group), 0).show();
            }
        }

        @Override // cz.opentree.util.NewGroupPrompt.PromptListener
        public void onCancel() {
        }
    }

    @Override // cz.opentree.util.SessionedFragmentActivity
    /* renamed from: j */
    public void mo5203j(Bundle bundle) {
        setContentView(R.layout.address_book);
        this.f3693P = (ViewPager) findViewById(R.id.viewpager);
        eh0 eh0Var = new eh0(this);
        this.f3694Q = eh0Var;
        this.f3693P.setAdapter(eh0Var);
        this.f3693P.setCurrentItem(this.f3694Q.m3499h(1));
        this.f3693P.setOnPageChangeListener(new C1237a());
        this.f3696S = m5205q();
    }

    @Override // cz.opentree.util.SessionedFragmentActivity
    /* renamed from: l */
    public void mo5204l() {
        this.f3694Q.m3497f().m4449j();
        this.f3694Q.m3498g().notifyDataSetInvalidated();
        this.f3694Q.m3500i().notifyDataSetInvalidated();
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f3696S, new IntentFilter("cz.opentree.juicessh.connection.state"));
    }

    @Override // cz.opentree.util.SessionedFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        gj0.m4141b("AddressBookActivity", "Processing activity result");
        if (i == 45839 && i2 == -1) {
            Bundle extras = intent.getExtras();
            try {
                if (extras.containsKey("requesting_connection_id") && extras.containsKey("identity_id")) {
                    try {
                        Connection connection = (Connection) C1328DB.m5404d(Connection.class, this).queryForId((UUID) extras.get("requesting_connection_id"));
                        Identity identity = (Identity) C1328DB.m5404d(Identity.class, this).queryForId((UUID) extras.get("identity_id"));
                        if (connection != null && identity != null) {
                            gj0.m4141b("AddressBookActivity", "Setting identity for connection");
                            connection.m5472z(identity, this);
                        }
                        if (extras.containsKey("endpoint_portfoward_id")) {
                            gj0.m4141b("AddressBookActivity", "Resuming Portforward connection");
                            ((PortForward) C1328DB.m5404d(PortForward.class, this).queryForId((UUID) extras.get("endpoint_portforward_id"))).m5496u(this, null);
                            return;
                        }
                        if (extras.containsKey("endpoint_connection_id")) {
                            gj0.m4141b("AddressBookActivity", "Resuming Portforward connection");
                            Connection connection2 = (Connection) C1328DB.m5404d(Connection.class, this).queryForId((UUID) extras.get("endpoint_connection_id"));
                            Intent intent2 = new Intent(this, (Class<?>) TerminalEmulatorActivity.class);
                            intent2.setFlags(603979776);
                            int i3 = connection.type;
                            if (i3 == 1) {
                                intent2.setData(Uri.parse("mosh://" + connection2.f3993id.toString()));
                            } else if (i3 == 2) {
                                intent2.setData(Uri.parse("local://" + connection2.f3993id.toString()));
                            } else if (i3 != 3) {
                                intent2.setData(Uri.parse("ssh://" + connection2.f3993id.toString()));
                            } else {
                                intent2.setData(Uri.parse("telnet://" + connection2.f3993id.toString()));
                            }
                            intent2.putExtra("background", false);
                            startActivity(intent2);
                        }
                    } catch (SQLException unused) {
                    }
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        ContextMenu.ContextMenuInfo menuInfo = menuItem.getMenuInfo();
        if (ExpandableListView.ExpandableListContextMenuInfo.class.isAssignableFrom(menuInfo.getClass())) {
            ExpandableListView.ExpandableListContextMenuInfo expandableListContextMenuInfo = (ExpandableListView.ExpandableListContextMenuInfo) menuInfo;
            int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListContextMenuInfo.packedPosition);
            int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListContextMenuInfo.packedPosition);
            int packedPositionType = ExpandableListView.getPackedPositionType(expandableListContextMenuInfo.packedPosition);
            if (packedPositionType != 0) {
                if (packedPositionType == 1) {
                    try {
                        Connection connection = this.f3694Q.m3497f().m3208g().get(packedPositionGroup).getValue().get(packedPositionChild);
                        switch (menuItem.getItemId()) {
                            case R.id.clearHistory /* 2131296373 */:
                                gj0.m4141b("AddressBookActivity", "Clearing connection counters");
                                try {
                                    C1328DB.m5404d(ConnectionCounter.class, this).delete((Collection) C1328DB.m5404d(ConnectionCounter.class, this).queryForEq("connection_id", connection.f3993id));
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                gj0.m4141b("AddressBookActivity", "Clearing host key and fingerprint");
                                try {
                                    C1328DB.m5404d(Host.class, this).delete((Collection) C1328DB.m5404d(Host.class, this).queryForEq("hostname", connection.address));
                                } catch (SQLException e2) {
                                    e2.printStackTrace();
                                }
                                return true;
                            case R.id.delete /* 2131296400 */:
                                if (Ec2Connection.class.isAssignableFrom(connection.getClass())) {
                                    Toast.makeText(this, getString(R.string.cant_modify_ec2_connection), 1).show();
                                    return false;
                                }
                                try {
                                    C1328DB.m5404d(ConnectionGroupMembership.class, this).delete((Collection) C1328DB.m5404d(ConnectionGroupMembership.class, this).queryForEq("connection_id", connection.f3993id));
                                    C1328DB.m5404d(ConnectionCounter.class, this).delete((Collection) C1328DB.m5404d(ConnectionCounter.class, this).queryForEq("connection_id", connection.f3993id));
                                    C1328DB.m5404d(ConnectionIdentity.class, this).delete((Collection) C1328DB.m5404d(ConnectionIdentity.class, this).queryForEq("connection_id", connection.f3993id));
                                    C1328DB.m5404d(Connection.class, this).delete(connection);
                                    this.f3694Q.m3497f().m4449j();
                                    return true;
                                } catch (SQLException e3) {
                                    e3.printStackTrace();
                                    return false;
                                }
                            case R.id.duplicate /* 2131296411 */:
                                if (Ec2Connection.class.isAssignableFrom(connection.getClass())) {
                                    Toast.makeText(this, getString(R.string.cant_duplicate_ec2_connection), 1).show();
                                    return false;
                                }
                                connection.f3993id = UUID.randomUUID();
                                connection.nickname = String.format(getString(R.string.copy_of), connection.m5471w());
                                try {
                                    C1328DB.m5404d(Connection.class, this).createIfNotExists(connection);
                                    Intent intent = new Intent(this, (Class<?>) ManageConnectionActivity.class);
                                    intent.putExtra("connection_id", connection.f3993id);
                                    startActivityForResult(intent, 5);
                                } catch (SQLException e4) {
                                    gj0.m4142c("AddressBookActivity", "Unable to duplicate connection: " + e4.getMessage());
                                }
                                return true;
                            case R.id.edit /* 2131296417 */:
                                if (Ec2Connection.class.isAssignableFrom(connection.getClass())) {
                                    Toast.makeText(this, getString(R.string.cant_modify_ec2_connection), 1).show();
                                    return false;
                                }
                                Intent intent2 = new Intent(this, (Class<?>) ManageConnectionActivity.class);
                                intent2.putExtra("connection_id", connection.f3993id);
                                startActivityForResult(intent2, 5);
                                return true;
                            case R.id.homescreen /* 2131296468 */:
                                Intent intent3 = new Intent(this, (Class<?>) TerminalEmulatorActivity.class);
                                intent3.setAction("android.intent.action.MAIN");
                                intent3.setFlags(402653184);
                                int i = connection.type;
                                if (i == 1) {
                                    intent3.setData(Uri.parse("mosh://" + connection.f3993id.toString()));
                                } else if (i == 2) {
                                    intent3.setData(Uri.parse("local://" + connection.f3993id.toString()));
                                } else if (i != 3) {
                                    intent3.setData(Uri.parse("ssh://" + connection.f3993id.toString()));
                                } else {
                                    intent3.setData(Uri.parse("telnet://" + connection.f3993id.toString()));
                                }
                                intent3.putExtra("background", false);
                                ShortcutManager shortcutManager = (ShortcutManager) getSystemService(ShortcutManager.class);
                                if (!shortcutManager.isRequestPinShortcutSupported()) {
                                    Toast.makeText(this, getString(R.string.homescreen_shortcuts_not_supported), 0).show();
                                    break;
                                } else {
                                    ShortcutInfo build = new ShortcutInfo.Builder(this, connection.m5471w()).setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher)).setIntent(intent3).setShortLabel(connection.m5471w()).build();
                                    shortcutManager.requestPinShortcut(build, PendingIntent.getBroadcast(this, 0, shortcutManager.createShortcutResultIntent(build), 0).getIntentSender());
                                    break;
                                }
                            case R.id.share /* 2131296709 */:
                                pi0.m7331j(this, new C1242f());
                                return true;
                            default:
                                return true;
                        }
                    } catch (IndexOutOfBoundsException | NullPointerException unused) {
                        return false;
                    }
                }
            } else if (packedPositionGroup != this.f3694Q.m3497f().getGroupCount() - 1) {
                ConnectionGroup key = this.f3694Q.m3497f().m3208g().get(packedPositionGroup).getKey();
                int itemId = menuItem.getItemId();
                if (itemId == R.id.delete) {
                    try {
                        C1328DB.m5404d(Share.class, this).delete((Collection) C1328DB.m5404d(Share.class, this).queryForEq("group_id", key));
                        C1328DB.m5404d(ConnectionGroupMembership.class, this).delete((Collection) C1328DB.m5404d(ConnectionGroupMembership.class, this).queryForEq("group_id", key));
                        C1328DB.m5404d(ConnectionGroup.class, this).delete(key);
                        this.f3694Q.m3497f().m4449j();
                        return true;
                    } catch (SQLException unused2) {
                        return false;
                    }
                }
                if (itemId != R.id.edit) {
                    if (itemId != R.id.share) {
                        return true;
                    }
                    pi0.m7331j(this, new C1241e(key));
                    return true;
                }
                Intent intent4 = new Intent(this, (Class<?>) ManageGroupActivity.class);
                intent4.putExtra("group_id", key.f3993id);
                startActivityForResult(intent4, 3);
                return true;
            }
        } else if (AdapterView.AdapterContextMenuInfo.class.isAssignableFrom(menuInfo.getClass())) {
            AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
            if (this.f3693P.getCurrentItem() == this.f3694Q.m3499h(2)) {
                Identity item = this.f3694Q.m3498g().getItem(adapterContextMenuInfo.position);
                switch (menuItem.getItemId()) {
                    case R.id.delete /* 2131296400 */:
                        try {
                            C1328DB.m5404d(ConnectionIdentity.class, this).delete((Collection) C1328DB.m5404d(ConnectionIdentity.class, this).queryForEq("identity_id", item));
                            Snippet snippet = item.snippet;
                            if (snippet != null && snippet.m5383m() != null) {
                                C1328DB.m5404d(Snippet.class, this).delete(item.snippet);
                            }
                            C1328DB.m5404d(Identity.class, this).delete(item);
                            this.f3694Q.m3498g().notifyDataSetInvalidated();
                            return true;
                        } catch (SQLException unused3) {
                            return false;
                        }
                    case R.id.edit /* 2131296417 */:
                        Intent intent5 = new Intent(this, (Class<?>) ManageIdentityActivity.class);
                        intent5.putExtra("identity_id", item.f3993id);
                        startActivityForResult(intent5, 2);
                        return true;
                    case R.id.export_private_key /* 2131296438 */:
                        if (!item.m5482t()) {
                            Toast.makeText(this, getString(R.string.identity_has_no_key_to_export), 0).show();
                            return false;
                        }
                        try {
                            String m7700a = qg0.m7700a(item.privatekey, User.m5527u(this));
                            Intent intent6 = new Intent("android.intent.action.SEND");
                            intent6.setType("text/plain");
                            intent6.putExtra("android.intent.extra.SUBJECT", getString(R.string.juicessh_private_key));
                            intent6.putExtra("android.intent.extra.TEXT", m7700a);
                            startActivity(Intent.createChooser(intent6, getResources().getString(R.string.share_using)));
                            return true;
                        } catch (qg0.C1762a unused4) {
                            Toast.makeText(this, getString(R.string.unable_to_export_key), 0).show();
                            return false;
                        }
                    case R.id.export_public_key /* 2131296439 */:
                        if (!item.m5482t()) {
                            Toast.makeText(this, getString(R.string.identity_has_no_key_to_export), 0).show();
                            return false;
                        }
                        try {
                            ug0.m8891a(this, qg0.m7700a(item.privatekey, User.m5527u(this)), qg0.m7700a(item.privatekeyPassword, User.m5527u(this)), new C1243g());
                            return true;
                        } catch (qg0.C1762a e5) {
                            gj0.m4142c("AddressBookActivity", "Unable to export public key: " + e5.getMessage());
                            Toast.makeText(this, getString(R.string.unable_to_export_key), 0).show();
                            return false;
                        }
                    default:
                        return true;
                }
            }
            if (this.f3693P.getCurrentItem() == this.f3694Q.m3499h(0)) {
                PortForward item2 = this.f3694Q.m3500i().getItem(adapterContextMenuInfo.position);
                switch (menuItem.getItemId()) {
                    case R.id.delete /* 2131296400 */:
                        try {
                            C1328DB.m5404d(PortForward.class, this).delete(item2);
                            this.f3694Q.m3500i().notifyDataSetInvalidated();
                            return true;
                        } catch (SQLException unused5) {
                            break;
                        }
                    case R.id.duplicate /* 2131296411 */:
                        item2.f3993id = UUID.randomUUID();
                        item2.name = String.format(getString(R.string.copy_of), item2.name);
                        try {
                            C1328DB.m5404d(PortForward.class, this).createIfNotExists(item2);
                            Intent intent7 = new Intent(this, (Class<?>) ManagePortForwardActivity.class);
                            intent7.putExtra("id", item2.f3993id);
                            startActivityForResult(intent7, 4);
                        } catch (SQLException e6) {
                            gj0.m4142c("AddressBookActivity", "Unable to duplicate port forward: " + e6.getMessage());
                        }
                        return true;
                    case R.id.edit /* 2131296417 */:
                        Intent intent8 = new Intent(this, (Class<?>) ManagePortForwardActivity.class);
                        intent8.putExtra("id", item2.f3993id);
                        startActivityForResult(intent8, 4);
                        return true;
                    case R.id.homescreen /* 2131296468 */:
                        Intent intent9 = new Intent(this, (Class<?>) TerminalEmulatorActivity.class);
                        intent9.setFlags(402653184);
                        intent9.setAction("android.intent.action.MAIN");
                        intent9.setData(Uri.parse("ssh-forward://" + item2.f3993id.toString()));
                        ShortcutManager shortcutManager2 = (ShortcutManager) getSystemService(ShortcutManager.class);
                        if (shortcutManager2.isRequestPinShortcutSupported()) {
                            ShortcutInfo build2 = new ShortcutInfo.Builder(this, item2.name).setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher)).setIntent(intent9).setShortLabel(item2.name).build();
                            shortcutManager2.requestPinShortcut(build2, PendingIntent.getBroadcast(this, 0, shortcutManager2.createShortcutResultIntent(build2), 0).getIntentSender());
                        } else {
                            Toast.makeText(this, getString(R.string.homescreen_shortcuts_not_supported), 0).show();
                        }
                        return true;
                    default:
                        return true;
                }
            }
        }
        return false;
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        MenuInflater menuInflater = getMenuInflater();
        ViewPager viewPager = (ViewPager) view.getRootView().findViewById(R.id.viewpager);
        if (viewPager.getCurrentItem() != this.f3694Q.m3499h(1)) {
            if (viewPager.getCurrentItem() == this.f3694Q.m3499h(2)) {
                contextMenu.setHeaderTitle(getString(R.string.manage_identity));
                menuInflater.inflate(R.menu.identity_context_menu, contextMenu);
                return;
            }
            if (viewPager.getCurrentItem() == this.f3694Q.m3499h(0)) {
                contextMenu.setHeaderTitle(getString(R.string.manage_port_forward));
                menuInflater.inflate(R.menu.port_forward_context_menu, contextMenu);
                String str = " (" + getString(R.string.pro_users_only) + ")";
                if (!kj0.m5917a().mo5134o()) {
                    contextMenu.removeItem(R.id.homescreen);
                }
                if (kj0.m5917a().mo5134o() && kj0.m5917a().m5934p()) {
                    contextMenu.getItem(2).setTitle(getString(R.string.homescreen_shortcut) + str);
                    contextMenu.getItem(2).setEnabled(false);
                }
                pi0.m7331j(this, new C1240d(contextMenu));
                return;
            }
            return;
        }
        ExpandableListView.ExpandableListContextMenuInfo expandableListContextMenuInfo = (ExpandableListView.ExpandableListContextMenuInfo) contextMenuInfo;
        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListContextMenuInfo.packedPosition);
        int packedPositionType = ExpandableListView.getPackedPositionType(expandableListContextMenuInfo.packedPosition);
        if (packedPositionType == 0) {
            if (packedPositionGroup != this.f3694Q.m3497f().getGroupCount() - 1) {
                contextMenu.setHeaderTitle(getString(R.string.manage_group));
                menuInflater.inflate(R.menu.group_context_menu, contextMenu);
                if (!kj0.m5917a().mo5139z()) {
                    contextMenu.removeItem(R.id.share);
                }
                String str2 = " (" + getString(R.string.pro_users_only) + ")";
                if (kj0.m5917a().mo5139z() && kj0.m5917a().m5921A()) {
                    contextMenu.getItem(1).setTitle(getString(R.string.share) + str2);
                    contextMenu.getItem(1).setEnabled(false);
                }
                pi0.m7331j(this, new C1238b(contextMenu));
                return;
            }
            return;
        }
        if (packedPositionType != 1) {
            return;
        }
        contextMenu.setHeaderTitle(getString(R.string.manage_connection));
        menuInflater.inflate(R.menu.connection_context_menu, contextMenu);
        String str3 = " (" + getString(R.string.pro_users_only) + ")";
        if (!kj0.m5917a().mo5139z()) {
            contextMenu.removeItem(R.id.share);
        }
        if (!kj0.m5917a().mo5134o()) {
            contextMenu.removeItem(R.id.homescreen);
        }
        if (kj0.m5917a().mo5139z() && kj0.m5917a().m5921A()) {
            contextMenu.getItem(2).setTitle(getString(R.string.share) + str3);
            contextMenu.getItem(2).setEnabled(false);
        }
        if (kj0.m5917a().mo5134o() && kj0.m5917a().m5934p()) {
            contextMenu.getItem(4).setTitle(getString(R.string.homescreen_shortcut) + str3);
            contextMenu.getItem(4).setEnabled(false);
        }
        pi0.m7331j(this, new C1239c(contextMenu));
    }

    @Override // cz.opentree.util.SessionedFragmentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        this.f3695R = menu;
        getMenuInflater().inflate(R.menu.menu_addressbook_connections, menu);
        return true;
    }

    @Override // cz.opentree.util.SessionedFragmentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_item_new_connection /* 2131296563 */:
                startActivityForResult(new Intent(this, (Class<?>) ManageConnectionActivity.class), 5);
                return true;
            case R.id.menu_item_new_group /* 2131296564 */:
                NewGroupPrompt newGroupPrompt = new NewGroupPrompt(this, new C1245i());
                newGroupPrompt.m9011o(true);
                if (!isFinishing()) {
                    newGroupPrompt.show();
                }
                return true;
            case R.id.menu_item_new_identity /* 2131296565 */:
                startActivityForResult(new Intent(this, (Class<?>) ManageIdentityActivity.class), 2);
                return true;
            case R.id.menu_item_new_portforward /* 2131296566 */:
                startActivityForResult(new Intent(this, (Class<?>) ManagePortForwardActivity.class), 4);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // cz.opentree.util.SessionedFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f3696S);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
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

    /* renamed from: q */
    public final sj0 m5205q() {
        sj0 sj0Var = this.f3696S;
        return sj0Var != null ? sj0Var : new C1244h();
    }

    /* renamed from: r */
    public final void m5206r(UUID uuid, int i) {
        sh0 m3500i = this.f3694Q.m3500i();
        gj0.m4141b("AddressBookActivity", "Got PortForward State Change: " + i);
        if (i == ai0.f1395n) {
            m3500i.m8446h(uuid, true);
        } else {
            m3500i.m8446h(uuid, false);
        }
    }
}
