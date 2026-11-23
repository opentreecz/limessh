package cz.opentree.juicessh.activities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.provider.FontsContractCompat;
import androidx.viewpager.widget.ViewPager;
import cz.opentree.ai0;
import cz.opentree.bl0;
import cz.opentree.gj0;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.connections.ConnectionManager;
import cz.opentree.juicessh.connections.listeners.BasicTransportChainListener;
import cz.opentree.juicessh.connections.transports.ConnectionProvider;
import cz.opentree.juicessh.connections.transports.TerminalSessionProvider;
import cz.opentree.juicessh.models.Config;
import cz.opentree.juicessh.models.Connection;
import cz.opentree.juicessh.models.PortForward;
import cz.opentree.juicessh.models.Snippet;
import cz.opentree.juicessh.models.User;
import cz.opentree.juicessh.p002db.C1328DB;
import cz.opentree.juicessh.parsers.ConnectionIntentParser;
import cz.opentree.juicessh.views.TerminalThemedButton;
import cz.opentree.juicessh.views.TerminalView;
import cz.opentree.kj0;
import cz.opentree.lh0;
import cz.opentree.mi0;
import cz.opentree.ni0;
import cz.opentree.oi0;
import cz.opentree.pi0;
import cz.opentree.ti0;
import cz.opentree.util.BackgroundPrompt;
import cz.opentree.util.SessionedFragmentActivity;
import cz.opentree.util.TerminalGestureListener;
import cz.opentree.vk0;
import cz.opentree.wk0;
import cz.opentree.zi0;
import jackpal.androidterm.emulatorview.EmulatorView;
import jackpal.androidterm.emulatorview.TermSession;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class TerminalEmulatorActivity extends SessionedFragmentActivity implements ConnectionIntentParser.ParsedConnectionIntentHandler {

    /* renamed from: P */
    public ViewPager f3888P;

    /* renamed from: Q */
    public lh0 f3889Q;

    /* renamed from: R */
    public ai0 f3890R;

    /* renamed from: S */
    public TerminalSessionProvider f3891S;

    /* renamed from: T */
    public TerminalView f3892T;

    /* renamed from: U */
    public int f3893U;

    /* renamed from: V */
    public TerminalThemedButton f3894V;

    /* renamed from: X */
    public TerminalThemedButton f3896X;

    /* renamed from: a0 */
    public RelativeLayout f3899a0;

    /* renamed from: b0 */
    public LinearLayout f3900b0;

    /* renamed from: c0 */
    public RelativeLayout f3901c0;

    /* renamed from: d0 */
    public RelativeLayout f3902d0;

    /* renamed from: f0 */
    public String f3904f0;

    /* renamed from: g0 */
    public LinearLayout f3905g0;

    /* renamed from: h0 */
    public LinearLayout f3906h0;

    /* renamed from: W */
    public boolean f3895W = false;

    /* renamed from: Y */
    public boolean f3897Y = false;

    /* renamed from: Z */
    public boolean f3898Z = false;

    /* renamed from: e0 */
    public final AtomicBoolean f3903e0 = new AtomicBoolean(false);

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$a */
    /* loaded from: classes.dex */
    public class C1294a implements ConnectionManager.ChainRequest {

        /* renamed from: a */
        public final /* synthetic */ int f3907a;

        /* renamed from: b */
        public final /* synthetic */ UUID f3908b;

        public C1294a(int i, UUID uuid) {
            this.f3907a = i;
            this.f3908b = uuid;
        }

        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: a */
        public UUID mo5334a() {
            return this.f3908b;
        }

        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: b */
        public void mo5335b(ai0 ai0Var) {
            gj0.m4142c("TerminalEmulatorActivity", "Disconnected chain: " + mo5337d());
            TerminalEmulatorActivity terminalEmulatorActivity = TerminalEmulatorActivity.this;
            ai0 ai0Var2 = terminalEmulatorActivity.f3890R;
            if (ai0Var2 == null || ai0Var.f1399b != ai0Var2.f1399b) {
                return;
            }
            terminalEmulatorActivity.finish();
        }

        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: c */
        public void mo5336c() {
            gj0.m4142c("TerminalEmulatorActivity", "Couldn't find chain to disconnect: " + mo5337d());
        }

        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: d */
        public int mo5337d() {
            return this.f3907a;
        }

        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: e */
        public void mo5338e() {
            gj0.m4142c("TerminalEmulatorActivity", "Denied disconnection of chain: " + mo5337d());
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$b */
    /* loaded from: classes.dex */
    public class C1295b implements BasicTransportChainListener {
        public C1295b() {
        }

        @Override // cz.opentree.juicessh.connections.listeners.BasicTransportChainListener
        /* renamed from: a */
        public void mo3218a() {
            TerminalEmulatorActivity.this.finish();
        }

        @Override // cz.opentree.juicessh.connections.listeners.BasicTransportChainListener
        /* renamed from: b */
        public void mo3219b(int i, UUID uuid) {
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$c */
    /* loaded from: classes.dex */
    public class C1296c implements BackgroundPrompt.BackgroundPromptListener {
        public C1296c() {
        }

        @Override // cz.opentree.util.BackgroundPrompt.BackgroundPromptListener
        /* renamed from: a */
        public void mo5339a() {
            gj0.m4141b("TerminalEmulatorActivity", "Closing terminal activity at users request (session not backgrounded)");
            TerminalEmulatorActivity terminalEmulatorActivity = TerminalEmulatorActivity.this;
            ai0 ai0Var = terminalEmulatorActivity.f3890R;
            terminalEmulatorActivity.mo5320f(ai0Var.f1399b, ai0Var.m2097k());
        }

        @Override // cz.opentree.util.BackgroundPrompt.BackgroundPromptListener
        /* renamed from: b */
        public void mo5340b() {
            gj0.m4141b("TerminalEmulatorActivity", "Closing terminal activity at users request (session backgrounded)");
            TerminalEmulatorActivity.this.finish();
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$d */
    /* loaded from: classes.dex */
    public class C1297d extends pi0.AbstractC1720p {

        /* renamed from: a */
        public final /* synthetic */ ContextMenu f3912a;

        public C1297d(ContextMenu contextMenu) {
            this.f3912a = contextMenu;
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            if (oi0.m7047d(user)) {
                this.f3912a.getItem(3).setTitle(TerminalEmulatorActivity.this.getString(R.string.snippets));
                this.f3912a.getItem(3).setEnabled(true);
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$e */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC1298e implements DialogInterface.OnClickListener {

        /* renamed from: O */
        public final /* synthetic */ boolean f3914O;

        /* renamed from: P */
        public final /* synthetic */ TextView f3915P;

        /* renamed from: Q */
        public final /* synthetic */ ClipboardManager f3916Q;

        public DialogInterfaceOnClickListenerC1298e(boolean z, TextView textView, ClipboardManager clipboardManager) {
            this.f3914O = z;
            this.f3915P = textView;
            this.f3916Q = clipboardManager;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String charSequence;
            if (!this.f3914O) {
                try {
                    this.f3916Q.setPrimaryClip(ClipData.newPlainText("JuiceSSH", this.f3915P.getText().subSequence(this.f3915P.getSelectionStart(), this.f3915P.getSelectionEnd())));
                    return;
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (this.f3915P.getSelectionStart() != this.f3915P.getSelectionEnd()) {
                charSequence = this.f3915P.getText().subSequence(this.f3915P.getSelectionStart(), this.f3915P.getSelectionEnd()).toString();
                Toast.makeText(TerminalEmulatorActivity.this.getApplicationContext(), R.string.saving_snippet_from_selected_text, 1).show();
            } else {
                charSequence = this.f3915P.getText().toString();
            }
            try {
                C1328DB.m5404d(Snippet.class, TerminalEmulatorActivity.this).createOrUpdate(new Snippet("Session Snippet - " + new Date().getTime(), charSequence));
            } catch (SQLException e2) {
                e2.printStackTrace();
                gj0.m4142c("TerminalEmulatorActivity", "Failed to create new snippet");
                Toast.makeText(TerminalEmulatorActivity.this.getApplicationContext(), R.string.failed_to_save_snippet, 1).show();
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$f */
    /* loaded from: classes.dex */
    public class C1299f extends EmulatorView.SelectingTextListener {

        /* renamed from: a */
        public int f3918a = 0;

        /* renamed from: b */
        public int f3919b;

        public C1299f() {
            this.f3919b = Config.m5460f(TerminalEmulatorActivity.this, "terminal:margin_selection");
        }

        @Override // jackpal.androidterm.emulatorview.EmulatorView.SelectingTextListener
        public void onSelectionFinish() {
            super.onSelectionFinish();
            if (this.f3919b > 0) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) TerminalEmulatorActivity.this.f3892T.getLayoutParams();
                int i = this.f3918a;
                layoutParams.leftMargin = i;
                layoutParams.rightMargin = i;
                TerminalEmulatorActivity.this.f3892T.setLayoutParams(layoutParams);
            }
            TerminalEmulatorActivity terminalEmulatorActivity = TerminalEmulatorActivity.this;
            terminalEmulatorActivity.registerForContextMenu(terminalEmulatorActivity.f3892T);
            Toast.makeText(TerminalEmulatorActivity.this, "Copied to Clipboard", 1).show();
            TerminalEmulatorActivity.this.m5328s();
        }

        @Override // jackpal.androidterm.emulatorview.EmulatorView.SelectingTextListener
        public void onSelectionStart() {
            super.onSelectionStart();
            int i = this.f3919b;
            if (i > 0) {
                int applyDimension = (int) TypedValue.applyDimension(1, i, TerminalEmulatorActivity.this.getResources().getDisplayMetrics());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) TerminalEmulatorActivity.this.f3892T.getLayoutParams();
                this.f3918a = layoutParams.leftMargin;
                layoutParams.leftMargin = applyDimension;
                layoutParams.rightMargin = applyDimension;
                TerminalEmulatorActivity.this.f3892T.setLayoutParams(layoutParams);
            }
            TerminalEmulatorActivity terminalEmulatorActivity = TerminalEmulatorActivity.this;
            terminalEmulatorActivity.unregisterForContextMenu(terminalEmulatorActivity.f3892T);
            TerminalEmulatorActivity.this.m5330u();
        }

        @Override // jackpal.androidterm.emulatorview.EmulatorView.SelectingTextListener
        public void onStartPointSelected() {
            super.onStartPointSelected();
            TerminalEmulatorActivity.this.m5329t();
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$g */
    /* loaded from: classes.dex */
    public class C1300g implements TerminalView.OnEscListener {

        /* renamed from: a */
        public final /* synthetic */ TerminalView f3921a;

        public C1300g(TerminalEmulatorActivity terminalEmulatorActivity, TerminalView terminalView) {
            this.f3921a = terminalView;
        }

        @Override // cz.opentree.juicessh.views.TerminalView.OnEscListener
        /* renamed from: a */
        public boolean mo5341a() {
            TerminalView terminalView = this.f3921a;
            if (terminalView == null) {
                return false;
            }
            terminalView.getTermSession().write(new byte[]{27}, 0, 1);
            return true;
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$h */
    /* loaded from: classes.dex */
    public class C1301h implements TerminalView.OnBackListener {
        public C1301h() {
        }

        @Override // cz.opentree.juicessh.views.TerminalView.OnBackListener
        /* renamed from: a */
        public boolean mo5342a() {
            TerminalEmulatorActivity.this.m5331v();
            return false;
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$i */
    /* loaded from: classes.dex */
    public class C1302i implements TerminalView.OnResizeListener {

        /* renamed from: a */
        public final /* synthetic */ TerminalView f3923a;

        public C1302i(TerminalView terminalView) {
            this.f3923a = terminalView;
        }

        @Override // cz.opentree.juicessh.views.TerminalView.OnResizeListener
        /* renamed from: a */
        public void mo5343a(int i, int i2, int i3, int i4) {
            if (i != 0 && i2 != 0) {
                try {
                    TerminalEmulatorActivity.this.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
                    int max = Math.max(1, (i2 - this.f3923a.getTopOfScreenMargin()) / ((int) this.f3923a.getCharacterHeight()));
                    int max2 = Math.max(1, (int) (i / this.f3923a.getCharacterWidth()));
                    gj0.m4141b("TerminalEmulatorActivity", "Resizing terminal to COLUMNS:(" + max2 + ")" + max2 + " LINES:(" + max + ")" + max + " for a " + i + "x" + i2 + "px terminal size @ font size " + TerminalEmulatorActivity.this.f3893U + " with " + this.f3923a.getCharacterWidth() + "x" + this.f3923a.getCharacterHeight() + "px characters");
                    TerminalSessionProvider terminalSessionProvider = TerminalEmulatorActivity.this.f3891S;
                    if (terminalSessionProvider == null) {
                    } else {
                        terminalSessionProvider.mo3503a(i, i2, max, max2);
                    }
                } catch (NullPointerException unused) {
                }
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$j */
    /* loaded from: classes.dex */
    public class C1303j implements EmulatorView.OnKeyPressListener {

        /* renamed from: a */
        public final /* synthetic */ TerminalView f3925a;

        public C1303j(TerminalView terminalView) {
            this.f3925a = terminalView;
        }

        @Override // jackpal.androidterm.emulatorview.EmulatorView.OnKeyPressListener
        public void onKeyPressed(int i) {
            TerminalEmulatorActivity.this.m5323n();
            this.f3925a.cancelSpecialKeyStatus();
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$k */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1304k implements View.OnClickListener {
        public ViewOnClickListenerC1304k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Config.m5462h("tutorial:terminal", "true", TerminalEmulatorActivity.this);
            if (TerminalEmulatorActivity.this.f3902d0.getParent() != null) {
                ((ViewGroup) TerminalEmulatorActivity.this.f3902d0.getParent()).removeView(TerminalEmulatorActivity.this.f3902d0);
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$l */
    /* loaded from: classes.dex */
    public class C1305l implements BackgroundPrompt.BackgroundPromptListener {
        public C1305l() {
        }

        @Override // cz.opentree.util.BackgroundPrompt.BackgroundPromptListener
        /* renamed from: a */
        public void mo5339a() {
            gj0.m4141b("TerminalEmulatorActivity", "Closing terminal activity at users request (session not backgrounded)");
            TerminalEmulatorActivity terminalEmulatorActivity = TerminalEmulatorActivity.this;
            ai0 ai0Var = terminalEmulatorActivity.f3890R;
            if (ai0Var == null) {
                terminalEmulatorActivity.finish();
            } else {
                terminalEmulatorActivity.mo5320f(ai0Var.f1399b, ai0Var.m2097k());
            }
        }

        @Override // cz.opentree.util.BackgroundPrompt.BackgroundPromptListener
        /* renamed from: b */
        public void mo5340b() {
            gj0.m4141b("TerminalEmulatorActivity", "Closing terminal activity at users request (session backgrounded)");
            TerminalEmulatorActivity.this.finish();
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$m */
    /* loaded from: classes.dex */
    public class C1306m implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        public final /* synthetic */ int f3929a;

        public C1306m(int i) {
            this.f3929a = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i == 1) {
                ((LinearLayout.LayoutParams) TerminalEmulatorActivity.this.f3888P.getLayoutParams()).setMargins(0, 0, 0, 0 - this.f3929a);
                TerminalEmulatorActivity.this.f3889Q.m6166c().requestFocus();
            } else {
                ((LinearLayout.LayoutParams) TerminalEmulatorActivity.this.f3888P.getLayoutParams()).setMargins(0, 0, 0, 0);
                TerminalEmulatorActivity.this.f3892T.requestFocus();
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$n */
    /* loaded from: classes.dex */
    public class ViewOnKeyListenerC1307n implements View.OnKeyListener {
        public ViewOnKeyListenerC1307n() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            TerminalView terminalView;
            if (keyEvent.getKeyCode() != 66 || keyEvent.getAction() != 1 || (terminalView = TerminalEmulatorActivity.this.f3892T) == null || terminalView.getTermSession() == null) {
                return false;
            }
            String str = TerminalEmulatorActivity.this.f3889Q.m6166c().getText().toString().trim() + "\n";
            TerminalEmulatorActivity.this.f3889Q.m6166c().setText("");
            TerminalEmulatorActivity.this.f3892T.getTermSession().write(str);
            return true;
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$o */
    /* loaded from: classes.dex */
    public class C1308o implements TextView.OnEditorActionListener {
        public C1308o() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            TerminalView terminalView;
            if (i != 6 || (terminalView = TerminalEmulatorActivity.this.f3892T) == null || terminalView.getTermSession() == null) {
                return false;
            }
            String str = TerminalEmulatorActivity.this.f3889Q.m6166c().getText().toString().trim() + "\n";
            TerminalEmulatorActivity.this.f3889Q.m6166c().setText("");
            TerminalEmulatorActivity.this.f3892T.getTermSession().write(str);
            return true;
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$p */
    /* loaded from: classes.dex */
    public class C1309p implements PortForward.OnToggleCompleteListener {
        public C1309p() {
        }

        @Override // cz.opentree.juicessh.models.PortForward.OnToggleCompleteListener
        /* renamed from: a */
        public void mo5344a(boolean z) {
            TerminalEmulatorActivity.this.finish();
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$q */
    /* loaded from: classes.dex */
    public class C1310q implements BasicTransportChainListener {

        /* renamed from: a */
        public final /* synthetic */ boolean f3934a;

        /* renamed from: b */
        public final /* synthetic */ boolean f3935b;

        /* renamed from: c */
        public final /* synthetic */ ConnectionProvider f3936c;

        /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$q$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TerminalEmulatorActivity.this.m5322m();
                int i = C1310q.this.f3936c.mo5368g().type;
            }
        }

        public C1310q(boolean z, boolean z2, ConnectionProvider connectionProvider) {
            this.f3934a = z;
            this.f3935b = z2;
            this.f3936c = connectionProvider;
        }

        @Override // cz.opentree.juicessh.connections.listeners.BasicTransportChainListener
        /* renamed from: a */
        public void mo3218a() {
            TerminalEmulatorActivity.this.setResult(0);
            TerminalEmulatorActivity.this.finish();
        }

        @Override // cz.opentree.juicessh.connections.listeners.BasicTransportChainListener
        /* renamed from: b */
        public void mo3219b(int i, UUID uuid) {
            Intent intent = new Intent();
            intent.putExtra("session_id", i);
            intent.putExtra("session_key", uuid.toString());
            TerminalEmulatorActivity.this.setResult(-1, intent);
            if (this.f3934a || this.f3935b) {
                TerminalEmulatorActivity.this.finish();
            } else {
                TerminalEmulatorActivity.this.runOnUiThread(new a());
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$r */
    /* loaded from: classes.dex */
    public class C1311r implements ConnectionManager.ChainRequest {

        /* renamed from: a */
        public final /* synthetic */ int f3939a;

        /* renamed from: b */
        public final /* synthetic */ UUID f3940b;

        public C1311r(int i, UUID uuid) {
            this.f3939a = i;
            this.f3940b = uuid;
        }

        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: a */
        public UUID mo5334a() {
            return this.f3940b;
        }

        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: b */
        public void mo5335b(ai0 ai0Var) {
            TerminalEmulatorActivity terminalEmulatorActivity = TerminalEmulatorActivity.this;
            terminalEmulatorActivity.f3890R = ai0Var;
            terminalEmulatorActivity.m5322m();
        }

        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: c */
        public void mo5336c() {
            TerminalEmulatorActivity.this.finish();
        }

        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: d */
        public int mo5337d() {
            return this.f3939a;
        }

        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: e */
        public void mo5338e() {
            gj0.m4142c("TerminalEmulatorActivity", "resume denied");
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$s */
    /* loaded from: classes.dex */
    public class C1312s implements ConnectionManager.ChainRequest {

        /* renamed from: a */
        public final /* synthetic */ int f3942a;

        /* renamed from: b */
        public final /* synthetic */ UUID f3943b;

        /* renamed from: c */
        public final /* synthetic */ boolean f3944c;

        public C1312s(int i, UUID uuid, boolean z) {
            this.f3942a = i;
            this.f3943b = uuid;
            this.f3944c = z;
        }

        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: a */
        public UUID mo5334a() {
            return this.f3943b;
        }

        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: b */
        public void mo5335b(ai0 ai0Var) {
            if (this.f3944c) {
                return;
            }
            TerminalEmulatorActivity terminalEmulatorActivity = TerminalEmulatorActivity.this;
            terminalEmulatorActivity.f3890R = ai0Var;
            terminalEmulatorActivity.m5322m();
        }

        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: c */
        public void mo5336c() {
            TerminalEmulatorActivity.this.finish();
        }

        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: d */
        public int mo5337d() {
            return this.f3942a;
        }

        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: e */
        public void mo5338e() {
        }
    }

    /* renamed from: cz.opentree.juicessh.activities.TerminalEmulatorActivity$t */
    /* loaded from: classes.dex */
    public class C1313t implements BasicTransportChainListener {
        public C1313t() {
        }

        @Override // cz.opentree.juicessh.connections.listeners.BasicTransportChainListener
        /* renamed from: a */
        public void mo3218a() {
        }

        @Override // cz.opentree.juicessh.connections.listeners.BasicTransportChainListener
        /* renamed from: b */
        public void mo3219b(int i, UUID uuid) {
            TerminalEmulatorActivity.this.finish();
        }
    }

    @Override // cz.opentree.juicessh.parsers.ConnectionIntentParser.ParsedConnectionIntentHandler
    /* renamed from: a */
    public void mo5315a(Connection connection, Snippet snippet, boolean z) {
        ai0 m5468s = connection.m5468s(this, new C1313t());
        m5468s.m2110x(snippet);
        m5468s.m2108v(z);
    }

    @Override // cz.opentree.juicessh.parsers.ConnectionIntentParser.ParsedConnectionIntentHandler
    /* renamed from: b */
    public void mo5316b(int i, UUID uuid) {
        ai0 ai0Var = this.f3890R;
        if (ai0Var != null) {
            if (ai0Var.f1399b == i) {
                TerminalView terminalView = this.f3892T;
                if (terminalView == null || terminalView.getParent() == null) {
                    m5322m();
                    return;
                } else {
                    this.f3890R.m2107u(true);
                    m5333x();
                    return;
                }
            }
            TerminalView terminalView2 = this.f3892T;
            if (terminalView2 != null && terminalView2.getParent() != null) {
                ((ViewGroup) this.f3892T.getParent()).removeView(this.f3892T);
            }
            this.f3892T = null;
            this.f3890R = null;
        }
        ConnectionManager.m5349b(this, new C1311r(i, uuid));
    }

    @Override // cz.opentree.juicessh.parsers.ConnectionIntentParser.ParsedConnectionIntentHandler
    /* renamed from: c */
    public void mo5317c(ConnectionProvider connectionProvider, boolean z, boolean z2) {
        if (connectionProvider instanceof PortForward) {
            ((PortForward) connectionProvider).m5496u(this, new C1309p());
            return;
        }
        C1310q c1310q = new C1310q(z, z2, connectionProvider);
        if (z2) {
            this.f3890R = connectionProvider.mo5368g().m5466A(this, c1310q);
        } else {
            this.f3890R = connectionProvider.mo5368g().m5468s(this, c1310q);
        }
    }

    @Override // cz.opentree.juicessh.parsers.ConnectionIntentParser.ParsedConnectionIntentHandler
    /* renamed from: d */
    public void mo5318d(int i, String str) {
        gj0.m4142c("TerminalEmulatorActivity", str);
        Toast.makeText(this, str, 0).show();
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        TerminalView terminalView;
        TerminalView terminalView2;
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 82) {
            if (keyEvent.getAction() == 0 && (terminalView = this.f3892T) != null) {
                try {
                    openContextMenu(terminalView);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
        switch (keyCode) {
            case 23:
                if (keyEvent.getAction() == 0 && (terminalView2 = this.f3892T) != null) {
                    if (this.f3895W) {
                        terminalView2.cancelSpecialKeyStatus();
                        m5323n();
                        this.f3892T.getTermSession().write(new byte[]{27}, 0, 1);
                    } else {
                        terminalView2.sendControlKey();
                        this.f3895W = true;
                        TerminalThemedButton terminalThemedButton = this.f3894V;
                        if (terminalThemedButton != null) {
                            terminalThemedButton.m5692d(1);
                        }
                    }
                }
                return true;
            case 24:
                if (keyEvent.getAction() == 0 && this.f3892T != null) {
                    gj0.m4142c("TerminalEmulatorActivity", "Font: " + this.f3893U + "++");
                    int i = this.f3893U + 1;
                    this.f3893U = i;
                    this.f3892T.setTextSize(i);
                    Config.m5462h("terminal:font_size", String.valueOf(this.f3893U), this);
                }
                return true;
            case 25:
                if (keyEvent.getAction() == 0 && this.f3892T != null && this.f3893U > 1) {
                    gj0.m4142c("TerminalEmulatorActivity", "Font: " + this.f3893U + "--");
                    int i2 = this.f3893U - 1;
                    this.f3893U = i2;
                    this.f3892T.setTextSize(i2);
                    Config.m5462h("terminal:font_size", String.valueOf(this.f3893U), this);
                }
                return true;
            default:
                return super.dispatchKeyEvent(keyEvent);
        }
    }

    @Override // cz.opentree.juicessh.parsers.ConnectionIntentParser.ParsedConnectionIntentHandler
    /* renamed from: e */
    public void mo5319e(int i, UUID uuid, Snippet snippet, boolean z) {
        ConnectionManager.m5349b(this, new C1312s(i, uuid, z));
    }

    @Override // cz.opentree.juicessh.parsers.ConnectionIntentParser.ParsedConnectionIntentHandler
    /* renamed from: f */
    public void mo5320f(int i, UUID uuid) {
        ConnectionManager.m5348a(this, new C1294a(i, uuid));
        finish();
    }

    @Override // cz.opentree.util.SessionedFragmentActivity
    /* renamed from: j */
    public void mo5203j(Bundle bundle) {
        this.f3899a0 = new RelativeLayout(this);
        LinearLayout linearLayout = new LinearLayout(this);
        this.f3900b0 = linearLayout;
        linearLayout.setOrientation(1);
        this.f3900b0.setGravity(17);
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        this.f3888P = (ViewPager) layoutInflater.inflate(R.layout.hacker_keyboard_pager, (ViewGroup) this.f3900b0, false);
        this.f3905g0 = (LinearLayout) layoutInflater.inflate(R.layout.copy_instructions_start_selection, (ViewGroup) this.f3900b0, false);
        this.f3906h0 = (LinearLayout) layoutInflater.inflate(R.layout.copy_instructions_end_selection, (ViewGroup) this.f3900b0, false);
        lh0 lh0Var = new lh0(this.f3888P);
        this.f3889Q = lh0Var;
        this.f3894V = (TerminalThemedButton) lh0Var.m6168e().findViewById(R.id.keyboard_ctrl);
        this.f3896X = (TerminalThemedButton) this.f3889Q.m6168e().findViewById(R.id.keyboard_alt);
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.tutorial_terminal, (ViewGroup) null, false);
        this.f3902d0 = relativeLayout;
        ((Button) relativeLayout.findViewById(R.id.tutorial_button)).setOnClickListener(new ViewOnClickListenerC1304k());
        int applyDimension = (int) TypedValue.applyDimension(1, 35.0f, getResources().getDisplayMetrics());
        this.f3888P.setAdapter(this.f3889Q);
        this.f3888P.addOnPageChangeListener(new C1306m(applyDimension));
        this.f3889Q.m6166c().setOnKeyListener(new ViewOnKeyListenerC1307n());
        this.f3889Q.m6166c().setOnEditorActionListener(new C1308o());
        this.f3901c0 = new RelativeLayout(this);
        this.f3901c0.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f3899a0.addView(this.f3900b0, new ViewGroup.LayoutParams(-1, -1));
        addContentView(this.f3899a0, new ViewGroup.LayoutParams(-1, -1));
        this.f3900b0.addView(this.f3901c0, new LinearLayout.LayoutParams(-1, -2, 1.0f));
        int intExtra = getIntent().getIntExtra("NOTIFICATION_TO_CANCEL", 0);
        if (intExtra > 0) {
            ((NotificationManager) getSystemService("notification")).cancel(intExtra);
        }
        String m5458d = Config.m5458d("terminal:keyboard_position", this);
        if (m5458d == null || m5458d.length() < 1) {
            m5458d = "0";
        }
        int parseInt = Integer.parseInt(m5458d);
        if (parseInt == 0) {
            this.f3900b0.addView(this.f3888P, 0);
        } else if (parseInt == 1) {
            this.f3900b0.addView(this.f3888P);
        }
        ConnectionIntentParser.m5541f(this, getIntent(), this);
    }

    @Override // cz.opentree.util.SessionedFragmentActivity
    /* renamed from: k */
    public void mo5321k(Intent intent) {
        ConnectionIntentParser.m5541f(this, intent, this);
    }

    public void keyboardPress(View view) {
        view.performHapticFeedback(1);
        if (view.getTag() == null || this.f3892T.getTermSession() == null) {
            return;
        }
        int parseInt = Integer.parseInt(view.getTag().toString());
        switch (parseInt) {
            case -22:
            case -21:
            case -20:
            case -19:
            case -18:
            case -17:
            case -16:
            case -15:
            case -14:
            case -13:
            case -12:
            case -11:
                if (this.f3904f0 == null) {
                    this.f3904f0 = Config.m5458d("terminal:type", this);
                }
                gj0.m4141b("TerminalEmulatorActivity", "Setting escape characters for terminal type: " + this.f3904f0);
                this.f3892T.getTermSession().write(new ti0(this.f3904f0).m8701a()[Math.abs(parseInt) + (-11)]);
                m5323n();
                return;
            case -10:
            case -9:
            case -8:
            default:
                dispatchKeyEvent(new KeyEvent(0, Integer.parseInt(view.getTag().toString())));
                m5323n();
                return;
            case -7:
                m5331v();
                return;
            case -6:
                new BackgroundPrompt(this, new C1296c()).show();
                return;
            case -5:
                m5332w();
                return;
            case FontsContractCompat.FontRequestCallback.FAIL_REASON_SECURITY_VIOLATION /* -4 */:
                if (this.f3897Y) {
                    this.f3897Y = false;
                    TerminalThemedButton terminalThemedButton = this.f3896X;
                    if (terminalThemedButton != null) {
                        terminalThemedButton.m5692d(0);
                        return;
                    }
                    return;
                }
                this.f3892T.getTermSession().write(new byte[]{27}, 0, 1);
                this.f3897Y = true;
                TerminalThemedButton terminalThemedButton2 = this.f3896X;
                if (terminalThemedButton2 != null) {
                    terminalThemedButton2.m5692d(1);
                    return;
                }
                return;
            case FontsContractCompat.FontRequestCallback.FAIL_REASON_FONT_LOAD_ERROR /* -3 */:
                if (this.f3889Q.m6167d() == 0) {
                    this.f3889Q.m6169f(1);
                    return;
                } else {
                    this.f3889Q.m6169f(0);
                    return;
                }
            case -2:
                if (this.f3895W) {
                    this.f3895W = false;
                    this.f3892T.cancelSpecialKeyStatus();
                    TerminalThemedButton terminalThemedButton3 = this.f3894V;
                    if (terminalThemedButton3 != null) {
                        terminalThemedButton3.m5692d(0);
                        return;
                    }
                    return;
                }
                this.f3892T.sendControlKey();
                this.f3895W = true;
                TerminalThemedButton terminalThemedButton4 = this.f3894V;
                if (terminalThemedButton4 != null) {
                    terminalThemedButton4.m5692d(1);
                    return;
                }
                return;
            case -1:
                this.f3892T.getTermSession().write("|");
                m5323n();
                return;
        }
    }

    @Override // cz.opentree.util.SessionedFragmentActivity
    /* renamed from: l */
    public void mo5204l() {
        ai0 ai0Var;
        if (this.f3892T == null || (ai0Var = this.f3890R) == null) {
            return;
        }
        ai0Var.m2107u(true);
        m5333x();
        getWindow().setSoftInputMode(16);
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.f3892T, 1);
    }

    /* renamed from: m */
    public void m5322m() {
        ai0 ai0Var = this.f3890R;
        if (ai0Var == null || ai0Var.m2102p() == null) {
            gj0.m4142c("TerminalEmulatorActivity", "Attempting to connect to a null chain!");
            finish();
            return;
        }
        getWindow().setSoftInputMode(16);
        Object m2102p = this.f3890R.m2102p();
        if (m2102p == null) {
            gj0.m4142c("TerminalEmulatorActivity", "Attempting to attach to incomplete TransportChain. Leaving window open in case it finishes soon.");
            return;
        }
        if (!(m2102p instanceof TerminalSessionProvider)) {
            gj0.m4141b("TerminalEmulatorActivity", "Closing terminal activity as requested transport does not require a terminal");
            finish();
            return;
        }
        TerminalSessionProvider terminalSessionProvider = (TerminalSessionProvider) m2102p;
        this.f3891S = terminalSessionProvider;
        this.f3904f0 = terminalSessionProvider.mo3214f();
        TerminalView terminalView = this.f3892T;
        if (terminalView == null) {
            if (terminalView != null) {
                ViewParent parent = terminalView.getParent();
                RelativeLayout relativeLayout = this.f3901c0;
                if (parent == relativeLayout) {
                    relativeLayout.removeView(this.f3892T);
                }
            }
            this.f3892T = m5326q(this.f3891S.mo3213e());
            m5333x();
            this.f3901c0.addView(this.f3892T, new ViewGroup.LayoutParams(-1, -1));
            this.f3901c0.requestLayout();
            if (this.f3892T == null) {
                ai0 ai0Var2 = this.f3890R;
                mo5320f(ai0Var2.f1399b, ai0Var2.m2097k());
                return;
            }
            int m5460f = Config.m5460f(this, "terminal:margin");
            if (m5460f > 0) {
                int applyDimension = (int) TypedValue.applyDimension(1, m5460f, getResources().getDisplayMetrics());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3892T.getLayoutParams();
                layoutParams.leftMargin = applyDimension;
                layoutParams.rightMargin = applyDimension;
                this.f3892T.setLayoutParams(layoutParams);
            }
            String m5458d = Config.m5458d("tutorial:terminal", this);
            if (m5458d != null && m5458d.length() > 0 && !Boolean.parseBoolean(m5458d)) {
                if (this.f3902d0.getParent() != null) {
                    ((ViewGroup) this.f3902d0.getParent()).removeView(this.f3902d0);
                }
                this.f3901c0.addView(this.f3902d0, new ViewGroup.LayoutParams(-1, -1));
                this.f3901c0.bringChildToFront(this.f3902d0);
            }
        } else if (terminalView.getParent() == null) {
            this.f3901c0.addView(this.f3892T, new ViewGroup.LayoutParams(-1, -1));
        }
        try {
            TermSession.OnBellListener onBellListener = this.f3891S.mo3213e().getOnBellListener();
            if (onBellListener instanceof zi0) {
                ((zi0) onBellListener).m10461e(this.f3890R);
            } else {
                gj0.m4142c("TerminalEmulatorActivity", "Unable to clear previous bell notifications (1)");
            }
        } catch (NullPointerException unused) {
            gj0.m4142c("TerminalEmulatorActivity", "Unable to clear previous bell notifications (2)");
        }
        this.f3890R.m2098l().m2506m(new C1295b());
        this.f3890R.m2107u(true);
    }

    /* renamed from: n */
    public void m5323n() {
        TerminalThemedButton terminalThemedButton;
        TerminalThemedButton terminalThemedButton2;
        if (this.f3895W && (terminalThemedButton2 = this.f3894V) != null) {
            this.f3895W = false;
            terminalThemedButton2.m5692d(0);
        }
        if (!this.f3897Y || (terminalThemedButton = this.f3896X) == null) {
            return;
        }
        this.f3897Y = false;
        terminalThemedButton.m5692d(0);
    }

    /* renamed from: o */
    public final void m5324o() {
        this.f3892T.toggleSelectingText(new C1299f());
    }

    @Override // cz.opentree.util.SessionedFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 13856 && i2 == -1 && intent != null) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(getContentResolver().openOutputStream(intent.getData())));
                bufferedWriter.write(this.f3892T.getTermSession().getTranscriptText().trim());
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        new BackgroundPrompt(this, new C1305l()).show();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Activity
    @SuppressLint({"SimpleDateFormat"})
    public boolean onContextItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 0:
                m5324o();
                break;
            case 1:
                m5325p(false);
                break;
            case 2:
                CharSequence text = ((android.text.ClipboardManager) getSystemService("clipboard")).getText();
                if (text != null) {
                    this.f3892T.getTermSession().write(text.toString());
                    break;
                }
                break;
            case 4:
                String str = this.f3891S.mo2814d() + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis())) + ".txt";
                Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("application/text");
                intent.putExtra("android.intent.extra.TITLE", str);
                startActivityForResult(intent, 13856);
                break;
            case 5:
                Intent m2557a = bl0.m2557a(this, this.f3891S);
                if (m2557a == null) {
                    Toast.makeText(this, getString(R.string.an_error_has_occurred), 0).show();
                    break;
                } else {
                    try {
                        startActivity(m2557a);
                        break;
                    } catch (ActivityNotFoundException unused) {
                        Toast.makeText(this, getString(R.string.no_capable_apps_found), 0).show();
                        break;
                    }
                }
            case 6:
                m5325p(true);
                break;
            case 7:
                String charSequence = menuItem.getTitle().toString();
                String charSequence2 = charSequence.subSequence(charSequence.indexOf("]") + 2, charSequence.length()).toString();
                if (charSequence2 != null && !charSequence2.isEmpty()) {
                    this.f3892T.getTermSession().write(charSequence2);
                    break;
                }
                break;
            case 8:
                new wk0(this, getString(R.string.warning), getString(R.string.screen_on_warning)).show();
                gj0.m4141b("TerminalEmulatorActivity", "Keeping screen locked on for this session");
                getWindow().addFlags(128);
                this.f3898Z = true;
                break;
            case 9:
                this.f3892T.getTermSession().reset();
                break;
        }
        return false;
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.setHeaderTitle(R.string.terminal);
        contextMenu.add(0, 0, 0, R.string.copy_from_screen);
        contextMenu.add(0, 1, 0, R.string.copy_whole_session);
        contextMenu.add(0, 2, 0, R.string.paste);
        if (kj0.m5917a().m5939x()) {
            SubMenu addSubMenu = contextMenu.addSubMenu(0, 3, 0, R.string.snippets);
            addSubMenu.add(0, 6, 0, R.string.create_snippet);
            ArrayList arrayList = new ArrayList();
            for (Snippet snippet : Snippet.m5501t(this)) {
                String str = snippet.name;
                if (str == null) {
                    str = getString(R.string.snippet);
                }
                arrayList.add("[" + str + "] " + snippet.content);
            }
            Collections.sort(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                addSubMenu.add(0, 7, 0, (String) it.next());
            }
            if (kj0.m5917a().mo5138y()) {
                String str2 = " (" + getString(R.string.pro_users_only) + ")";
                contextMenu.getItem(3).setTitle(getString(R.string.snippets) + str2);
                contextMenu.getItem(3).setEnabled(false);
                pi0.m7331j(this, new C1297d(contextMenu));
            }
        }
        contextMenu.add(0, 4, 0, R.string.save_transcript);
        contextMenu.add(0, 5, 0, R.string.share_transcript);
        if (!this.f3898Z) {
            contextMenu.add(0, 8, 0, R.string.keep_screen_on);
        }
        contextMenu.add(0, 9, 0, R.string.clear);
    }

    @Override // cz.opentree.util.SessionedFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        getWindow().clearFlags(128);
        this.f3898Z = false;
        this.f3903e0.set(false);
        ai0 ai0Var = this.f3890R;
        if (ai0Var != null) {
            ai0Var.m2107u(false);
            if (this.f3892T != null) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f3892T.getWindowToken(), 0);
            }
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
    public final void m5325p(boolean z) {
        TextView textView;
        String string;
        vk0 vk0Var = new vk0(this);
        if (z) {
            textView = new EditText(this);
            vk0Var.m9296i(R.string.create_snippet);
            string = getString(R.string.save);
        } else {
            textView = new TextView(this);
            vk0Var.m9296i(R.string.make_a_selection);
            string = getString(R.string.copy);
        }
        int parseInt = Integer.parseInt(Config.m5458d("terminal:font_size", this));
        if (parseInt == 0) {
            parseInt = 8;
        }
        textView.setTextSize(2, parseInt);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setTextIsSelectable(true);
        textView.setCursorVisible(true);
        textView.setSelectAllOnFocus(true);
        textView.setText(this.f3892T.getTermSession().getTranscriptText().trim());
        vk0Var.m9298k(textView);
        vk0Var.setPositiveButton(string, new DialogInterfaceOnClickListenerC1298e(z, textView, (ClipboardManager) getSystemService("clipboard")));
        vk0Var.setNegativeButton(getString(R.string.cancel), (DialogInterface.OnClickListener) null);
        AlertDialog create = vk0Var.create();
        if (isFinishing()) {
            return;
        }
        create.show();
        textView.requestFocus();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: q */
    public final TerminalView m5326q(TermSession termSession) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        TerminalView terminalView = new TerminalView(this.f3890R.f1399b, this, termSession, displayMetrics);
        terminalView.attachSession(termSession);
        if (!termSession.isRunning()) {
            termSession.initializeEmulator(80, 25);
            ai0 ai0Var = this.f3890R;
            termSession.setOnBellListener(new zi0(this, ai0Var.f1399b, ai0Var.m2097k()));
        }
        terminalView.setExtGestureListener(new TerminalGestureListener(this, terminalView));
        terminalView.setAltSendsEsc(false);
        terminalView.setMouseTracking(true);
        mi0 m2102p = this.f3890R.m2102p();
        if (m2102p != 0 && (m2102p instanceof TerminalSessionProvider)) {
            terminalView.setTermType(((TerminalSessionProvider) m2102p).mo3214f());
            int m6425j = m2102p.m6425j();
            if (m6425j == 0) {
                gj0.m4141b("TerminalEmulatorActivity", "Setting backspace mode to default (^?)");
                terminalView.setBackspaceKey("\u007f");
            } else if (m6425j == 1) {
                gj0.m4141b("TerminalEmulatorActivity", "Setting backspace mode to legacy (^H)");
                terminalView.setBackspaceKey("\b");
            }
        }
        terminalView.setAutocomplete(false);
        registerForContextMenu(terminalView);
        C1300g c1300g = new C1300g(this, terminalView);
        terminalView.m5694a(c1300g);
        this.f3889Q.m6166c().m5690c(c1300g);
        this.f3889Q.m6166c().m5689b(new C1301h());
        terminalView.m5695b(new C1302i(terminalView));
        terminalView.setOnKeyPressListener(new C1303j(terminalView));
        return terminalView;
    }

    /* renamed from: r */
    public ViewPager m5327r() {
        return this.f3888P;
    }

    /* renamed from: s */
    public void m5328s() {
        this.f3900b0.removeView(this.f3906h0);
    }

    /* renamed from: t */
    public void m5329t() {
        this.f3900b0.removeView(this.f3905g0);
        this.f3900b0.addView(this.f3906h0);
    }

    /* renamed from: u */
    public void m5330u() {
        this.f3900b0.addView(this.f3905g0);
    }

    /* renamed from: v */
    public void m5331v() {
        if (this.f3889Q.m6167d() != 0) {
            this.f3889Q.m6169f(0);
            return;
        }
        if (this.f3888P.getParent() != null) {
            this.f3900b0.removeView(this.f3888P);
            return;
        }
        String m5458d = Config.m5458d("terminal:keyboard_position", this);
        if (m5458d == null || m5458d.length() < 1) {
            m5458d = "0";
        }
        int parseInt = Integer.parseInt(m5458d);
        if (parseInt == 0) {
            this.f3900b0.addView(this.f3888P, 0);
        } else if (parseInt == 1) {
            this.f3900b0.addView(this.f3888P);
        } else if (parseInt == 2) {
            m5332w();
        }
        int currentItem = this.f3888P.getCurrentItem();
        if (currentItem == 0) {
            this.f3892T.requestFocus();
        } else {
            if (currentItem != 1) {
                return;
            }
            this.f3889Q.m6166c().requestFocus();
        }
    }

    /* renamed from: w */
    public void m5332w() {
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    /* renamed from: x */
    public final void m5333x() {
        if (this.f3892T == null) {
            gj0.m4142c("TerminalEmulatorActivity", "Could not update terminal theme/size on as terminal view not loaded");
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f3899a0.setForceDarkAllowed(false);
            this.f3892T.setForceDarkAllowed(false);
        }
        String m5458d = Config.m5458d("terminal:theme", this);
        Integer valueOf = (m5458d == null || m5458d.length() < 1) ? 0 : Integer.valueOf(Integer.parseInt(m5458d));
        try {
            this.f3893U = Integer.parseInt(Config.m5458d("terminal:font_size", this));
        } catch (NumberFormatException unused) {
            this.f3893U = 8;
        }
        int[] m6688a = ni0.m6688a(valueOf.intValue());
        this.f3892T.setColors(m6688a);
        this.f3892T.setBackgroundColor(m6688a[257]);
        this.f3892T.setTextSize(this.f3893U);
        RelativeLayout relativeLayout = this.f3899a0;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(m6688a[257]);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(m6688a[257]);
            getWindow().setNavigationBarColor(m6688a[257]);
        }
        this.f3889Q.m6170g(m6688a[256], m6688a[257]);
    }
}
