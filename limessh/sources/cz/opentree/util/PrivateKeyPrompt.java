package cz.opentree.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import cz.opentree.ek0;
import cz.opentree.gj0;
import cz.opentree.gk0;
import cz.opentree.limessh.R;
import cz.opentree.ph0;
import cz.opentree.qh0;
import cz.opentree.ug0;
import cz.opentree.vk0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

/* loaded from: classes.dex */
public class PrivateKeyPrompt extends vk0 {

    /* renamed from: S */
    public AlertDialog f7206S;

    /* renamed from: T */
    public boolean f7207T;

    /* renamed from: U */
    public ph0 f7208U;

    /* renamed from: V */
    public Spinner f7209V;

    /* renamed from: W */
    public Spinner f7210W;

    /* renamed from: X */
    public EditText f7211X;

    /* renamed from: Y */
    public LinearLayout f7212Y;

    /* renamed from: Z */
    public TableLayout f7213Z;

    /* renamed from: a0 */
    public Activity f7214a0;

    /* renamed from: b0 */
    public AsyncTask f7215b0;

    /* renamed from: c0 */
    public TabHost f7216c0;

    /* renamed from: d0 */
    public PrivateKeyPromptListener f7217d0;

    /* loaded from: classes.dex */
    public interface PrivateKeyPromptListener {
        /* renamed from: e */
        void mo5448e(String str);

        void onCancel();
    }

    /* renamed from: cz.opentree.util.PrivateKeyPrompt$a */
    /* loaded from: classes.dex */
    public class C2099a implements TabHost.TabContentFactory {

        /* renamed from: a */
        public final /* synthetic */ LayoutInflater f7218a;

        /* renamed from: b */
        public final /* synthetic */ Activity f7219b;

        /* renamed from: cz.opentree.util.PrivateKeyPrompt$a$a */
        /* loaded from: classes.dex */
        public class a implements AdapterView.OnItemSelectedListener {
            public a() {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                ph0 ph0Var = PrivateKeyPrompt.this.f7208U;
                C2099a c2099a = C2099a.this;
                qh0 m7319a = ph0Var.m7319a(c2099a.f7219b, PrivateKeyPrompt.this.f7209V.getSelectedItemPosition());
                PrivateKeyPrompt.this.f7210W.setAdapter((SpinnerAdapter) m7319a);
                PrivateKeyPrompt.this.f7210W.setSelection(m7319a.m7710a(m7319a.m7711b()));
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        }

        public C2099a(LayoutInflater layoutInflater, Activity activity) {
            this.f7218a = layoutInflater;
            this.f7219b = activity;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            View inflate = this.f7218a.inflate(R.layout.private_key_prompt_generatepage, (ViewGroup) null);
            PrivateKeyPrompt.this.f7209V = (Spinner) inflate.findViewById(R.id.key_format_spinner);
            PrivateKeyPrompt.this.f7210W = (Spinner) inflate.findViewById(R.id.key_strength_spinner);
            PrivateKeyPrompt.this.f7213Z = (TableLayout) inflate.findViewById(R.id.form_layout);
            PrivateKeyPrompt.this.f7212Y = (LinearLayout) inflate.findViewById(R.id.loading_layout);
            PrivateKeyPrompt.this.f7211X = (EditText) inflate.findViewById(R.id.key_passphrase);
            PrivateKeyPrompt.this.f7209V.setAdapter((SpinnerAdapter) PrivateKeyPrompt.this.f7208U);
            PrivateKeyPrompt.this.f7209V.setOnItemSelectedListener(new a());
            PrivateKeyPrompt.this.f7209V.setSelection(0);
            return inflate;
        }
    }

    /* renamed from: cz.opentree.util.PrivateKeyPrompt$b */
    /* loaded from: classes.dex */
    public class C2100b implements TabHost.TabContentFactory {

        /* renamed from: a */
        public final /* synthetic */ LayoutInflater f7222a;

        public C2100b(PrivateKeyPrompt privateKeyPrompt, LayoutInflater layoutInflater) {
            this.f7222a = layoutInflater;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            return this.f7222a.inflate(R.layout.private_key_prompt_pastepage, (ViewGroup) null);
        }
    }

    /* renamed from: cz.opentree.util.PrivateKeyPrompt$c */
    /* loaded from: classes.dex */
    public class C2101c implements TabHost.TabContentFactory {

        /* renamed from: a */
        public final /* synthetic */ LayoutInflater f7223a;

        public C2101c(PrivateKeyPrompt privateKeyPrompt, LayoutInflater layoutInflater) {
            this.f7223a = layoutInflater;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            return (LinearLayout) this.f7223a.inflate(R.layout.blank, (ViewGroup) null);
        }
    }

    /* renamed from: cz.opentree.util.PrivateKeyPrompt$d */
    /* loaded from: classes.dex */
    public class C2102d implements TabHost.OnTabChangeListener {

        /* renamed from: O */
        public final /* synthetic */ Fragment f7224O;

        public C2102d(PrivateKeyPrompt privateKeyPrompt, Fragment fragment) {
            this.f7224O = fragment;
        }

        @Override // android.widget.TabHost.OnTabChangeListener
        public void onTabChanged(String str) {
            if (str.equals("tag_importTab")) {
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent.setType("*/*");
                this.f7224O.startActivityForResult(intent, 13508);
            }
        }
    }

    /* renamed from: cz.opentree.util.PrivateKeyPrompt$e */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2103e implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2103e(PrivateKeyPrompt privateKeyPrompt) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: cz.opentree.util.PrivateKeyPrompt$f */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2104f implements DialogInterface.OnClickListener {

        /* renamed from: O */
        public final /* synthetic */ Activity f7225O;

        /* renamed from: cz.opentree.util.PrivateKeyPrompt$f$a */
        /* loaded from: classes.dex */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                PrivateKeyPrompt.this.f7217d0.mo5448e("");
            }
        }

        public DialogInterfaceOnClickListenerC2104f(Activity activity) {
            this.f7225O = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (PrivateKeyPrompt.this.f7217d0 != null) {
                vk0 vk0Var = new vk0(this.f7225O);
                vk0Var.m9296i(R.string.clear_private_key);
                vk0Var.m9294g(R.string.are_you_sure_clear_private_key);
                vk0Var.setPositiveButton(R.string.f3674ok, new a()).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).create().show();
            }
        }
    }

    /* renamed from: cz.opentree.util.PrivateKeyPrompt$g */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2105g implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC2105g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            PrivateKeyPromptListener privateKeyPromptListener = PrivateKeyPrompt.this.f7217d0;
            if (privateKeyPromptListener != null) {
                privateKeyPromptListener.onCancel();
            }
        }
    }

    /* renamed from: cz.opentree.util.PrivateKeyPrompt$h */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnCancelListenerC2106h implements DialogInterface.OnCancelListener {
        public DialogInterfaceOnCancelListenerC2106h() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.cancel();
            PrivateKeyPromptListener privateKeyPromptListener = PrivateKeyPrompt.this.f7217d0;
            if (privateKeyPromptListener != null) {
                privateKeyPromptListener.onCancel();
            }
        }
    }

    /* renamed from: cz.opentree.util.PrivateKeyPrompt$i */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnShowListenerC2107i implements DialogInterface.OnShowListener {

        /* renamed from: cz.opentree.util.PrivateKeyPrompt$i$a */
        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {

            /* renamed from: cz.opentree.util.PrivateKeyPrompt$i$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class AsyncTaskC2513a extends AsyncTask<C2108j, Void, String> {
                public AsyncTaskC2513a() {
                }

                @Override // android.os.AsyncTask
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public String doInBackground(C2108j... c2108jArr) {
                    Thread.currentThread().setName("Key Generator");
                    try {
                        int i = c2108jArr[0].f7233a;
                        gk0.C1047a m4161b = i != 1 ? i != 2 ? gk0.m4161b(c2108jArr[0].f7235c) : gk0.m4163d(c2108jArr[0].f7234b, c2108jArr[0].f7235c) : gk0.m4160a(c2108jArr[0].f7234b, c2108jArr[0].f7235c);
                        if (m4161b != null) {
                            return m4161b.f2884a;
                        }
                        gj0.m4142c("PrivateKeyPrompt", "Key generation failed: unknown failure");
                        return null;
                    } catch (ek0 e) {
                        gj0.m4142c("PrivateKeyPrompt", e.getMessage());
                        return null;
                    }
                }

                @Override // android.os.AsyncTask
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public void onPostExecute(String str) {
                    super.onPostExecute(str);
                    if (PrivateKeyPrompt.this.m9291a().isFinishing() || PrivateKeyPrompt.this.f7215b0.isCancelled() || !PrivateKeyPrompt.this.f7206S.isShowing()) {
                        return;
                    }
                    PrivateKeyPrompt.this.f7206S.getButton(-1).setEnabled(true);
                    PrivateKeyPrompt.this.f7213Z.setVisibility(0);
                    PrivateKeyPrompt.this.f7212Y.setVisibility(8);
                    if (str == null || str.isEmpty()) {
                        Toast.makeText(PrivateKeyPrompt.this.f7214a0, PrivateKeyPrompt.this.f7214a0.getString(R.string.key_generation_failed), 0).show();
                    } else {
                        PrivateKeyPrompt.this.f7206S.dismiss();
                        PrivateKeyPrompt.this.f7217d0.mo5448e(str);
                    }
                }

                @Override // android.os.AsyncTask
                public void onPreExecute() {
                    super.onPreExecute();
                    PrivateKeyPrompt.this.f7206S.getButton(-1).setEnabled(false);
                    PrivateKeyPrompt.this.f7212Y.setVisibility(0);
                    PrivateKeyPrompt.this.f7213Z.setVisibility(8);
                    ((InputMethodManager) PrivateKeyPrompt.this.f7214a0.getSystemService("input_method")).hideSoftInputFromWindow(PrivateKeyPrompt.this.f7211X.getWindowToken(), 0);
                }
            }

            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrivateKeyPrompt privateKeyPrompt = PrivateKeyPrompt.this;
                if (privateKeyPrompt.f7217d0 != null) {
                    if (!privateKeyPrompt.f7216c0.getCurrentTabTag().equals("tag_pasteTab")) {
                        if (PrivateKeyPrompt.this.f7216c0.getCurrentTabTag().equals("tag_generateTab")) {
                            C2108j c2108j = new C2108j((int) PrivateKeyPrompt.this.f7209V.getSelectedItemId(), (int) PrivateKeyPrompt.this.f7210W.getSelectedItemId(), PrivateKeyPrompt.this.f7211X.getText().toString());
                            if (PrivateKeyPrompt.this.f7215b0 != null) {
                                PrivateKeyPrompt.this.f7215b0.cancel(true);
                            }
                            PrivateKeyPrompt.this.f7215b0 = new AsyncTaskC2513a().execute(c2108j);
                            return;
                        }
                        return;
                    }
                    String trim = ((EditText) PrivateKeyPrompt.this.f7216c0.getCurrentView()).getText().toString().trim();
                    if (trim.isEmpty() || !ug0.m8892b(trim)) {
                        Toast.makeText(PrivateKeyPrompt.this.m9291a(), PrivateKeyPrompt.this.m9291a().getString(R.string.invalid_private_key), 0).show();
                    } else {
                        PrivateKeyPrompt.this.f7206S.dismiss();
                        PrivateKeyPrompt.this.f7217d0.mo5448e(trim);
                    }
                }
            }
        }

        public DialogInterfaceOnShowListenerC2107i() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            if (!PrivateKeyPrompt.this.f7207T) {
                PrivateKeyPrompt.this.f7206S.getButton(-3).setEnabled(false);
            }
            Button button = PrivateKeyPrompt.this.f7206S.getButton(-1);
            if (button == null) {
                return;
            }
            button.setOnClickListener(new a());
        }
    }

    /* renamed from: cz.opentree.util.PrivateKeyPrompt$j */
    /* loaded from: classes.dex */
    public static class C2108j {

        /* renamed from: a */
        public int f7233a;

        /* renamed from: b */
        public int f7234b;

        /* renamed from: c */
        public String f7235c;

        public C2108j(int i, int i2, String str) {
            this.f7233a = i;
            this.f7234b = i2;
            this.f7235c = str;
        }
    }

    public PrivateKeyPrompt(Fragment fragment, Activity activity, boolean z, PrivateKeyPromptListener privateKeyPromptListener) {
        super(activity);
        this.f7207T = false;
        this.f7214a0 = activity;
        this.f7217d0 = privateKeyPromptListener;
        this.f7207T = z;
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
        this.f7208U = new ph0(activity);
        TabHost tabHost = (TabHost) layoutInflater.inflate(R.layout.private_key_prompt, (ViewGroup) null);
        this.f7216c0 = tabHost;
        tabHost.setup();
        TabHost tabHost2 = this.f7216c0;
        tabHost2.addTab(tabHost2.newTabSpec("tag_generateTab").setIndicator(activity.getString(R.string.generate)).setContent(new C2099a(layoutInflater, activity)));
        TabHost tabHost3 = this.f7216c0;
        tabHost3.addTab(tabHost3.newTabSpec("tag_pasteTab").setIndicator(activity.getResources().getString(R.string.paste)).setContent(new C2100b(this, layoutInflater)));
        TabHost tabHost4 = this.f7216c0;
        tabHost4.addTab(tabHost4.newTabSpec("tag_importTab").setIndicator(activity.getResources().getString(R.string.import_)).setContent(new C2101c(this, layoutInflater)));
        this.f7216c0.setOnTabChangedListener(new C2102d(this, fragment));
        m9296i(R.string.set_private_key);
        for (int i = 0; i < this.f7216c0.getTabWidget().getTabCount(); i++) {
            this.f7216c0.getTabWidget().getChildAt(i).getLayoutParams().height = Math.round(TypedValue.applyDimension(1, 50.0f, activity.getResources().getDisplayMetrics()));
        }
        m9298k(this.f7216c0);
        setPositiveButton(activity.getResources().getString(R.string.f3674ok), new DialogInterfaceOnClickListenerC2103e(this));
        setNeutralButton("Clear", new DialogInterfaceOnClickListenerC2104f(activity));
        setNegativeButton(activity.getResources().getString(R.string.cancel), new DialogInterfaceOnClickListenerC2105g());
        setOnCancelListener(new DialogInterfaceOnCancelListenerC2106h());
    }

    /* renamed from: A */
    public AlertDialog m9036A() {
        if (this.f7206S == null) {
            create();
        }
        return this.f7206S;
    }

    /* renamed from: B */
    public void m9037B(Uri uri) {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream openInputStream = m9291a().getContentResolver().openInputStream(uri);
            Objects.requireNonNull(openInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine + "\n");
            }
            String sb2 = sb.toString();
            if (ug0.m8892b(sb2)) {
                this.f7206S.dismiss();
                Toast.makeText(m9291a(), "Private Key Imported", 0).show();
                this.f7217d0.mo5448e(sb2);
            } else {
                gj0.m4142c("PrivateKeyPrompt", "Key file does not meet the validation specs.");
                Activity activity = this.f7214a0;
                Toast.makeText(activity, activity.getString(R.string.invalid_private_key), 0).show();
                this.f7216c0.setCurrentTabByTag("tag_generateTab");
            }
        } catch (IOException unused) {
            Activity activity2 = this.f7214a0;
            Toast.makeText(activity2, activity2.getString(R.string.invalid_private_key), 0).show();
            this.f7216c0.setCurrentTabByTag("tag_generateTab");
        }
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog create() {
        AlertDialog create = super.create();
        this.f7206S = create;
        create.setOnShowListener(new DialogInterfaceOnShowListenerC2107i());
        return this.f7206S;
    }

    @Override // android.app.AlertDialog.Builder
    public AlertDialog show() {
        m9036A().dismiss();
        if (m9291a() != null && !m9291a().isFinishing()) {
            m9036A().show();
        }
        return m9036A();
    }
}
