package com.sonelli.juicessh.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.models.Snippet;
import com.sonelli.juicessh.p002db.C1328DB;
import com.sonelli.juicessh.views.FontAwesomeTextView;
import com.sonelli.util.SessionedActivity;
import com.sonelli.vk0;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.UUID;

/* loaded from: classes.dex */
public class ManageSnippetsActivity extends SessionedActivity {

    /* renamed from: P */
    public ListView f3846P;

    /* renamed from: com.sonelli.juicessh.activities.ManageSnippetsActivity$a */
    /* loaded from: classes.dex */
    public class C1276a implements AdapterView.OnItemClickListener {
        public C1276a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ManageSnippetsActivity.this.m5295o((UUID) view.getTag());
        }
    }

    /* renamed from: com.sonelli.juicessh.activities.ManageSnippetsActivity$b */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1277b implements View.OnClickListener {
        public ViewOnClickListenerC1277b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ManageSnippetsActivity.this.m5295o(null);
        }
    }

    /* renamed from: com.sonelli.juicessh.activities.ManageSnippetsActivity$c */
    /* loaded from: classes.dex */
    public class C1278c extends ArrayAdapter<Snippet> {
        public C1278c(Context context, int i) {
            super(context, i);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = ManageSnippetsActivity.this.getLayoutInflater().inflate(R.layout.identity_menu_item, viewGroup, false);
            }
            view.setTag(getItem(i).f3993id);
            TextView textView = (TextView) view.findViewById(R.id.itemTitle);
            TextView textView2 = (TextView) view.findViewById(R.id.itemSubtitle);
            ((FontAwesomeTextView) view.findViewById(R.id.itemIcon)).setText(R.string.icon_terminal);
            Snippet item = getItem(i);
            String str = item.name;
            if (str != null) {
                textView.setText(str);
            } else {
                textView.setText(R.string.snippet);
            }
            textView2.setText(item.content);
            return view;
        }
    }

    /* renamed from: com.sonelli.juicessh.activities.ManageSnippetsActivity$d */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC1279d implements DialogInterface.OnClickListener {

        /* renamed from: O */
        public final /* synthetic */ EditText f3850O;

        /* renamed from: P */
        public final /* synthetic */ EditText f3851P;

        /* renamed from: Q */
        public final /* synthetic */ Snippet f3852Q;

        public DialogInterfaceOnClickListenerC1279d(EditText editText, EditText editText2, Snippet snippet) {
            this.f3850O = editText;
            this.f3851P = editText2;
            this.f3852Q = snippet;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String obj = this.f3850O.getText().toString();
            String obj2 = this.f3851P.getText().toString();
            if (obj2.isEmpty()) {
                Toast.makeText(ManageSnippetsActivity.this, R.string.cant_save_an_empty_snippet, 0).show();
                return;
            }
            this.f3852Q.content = obj2;
            if (obj.isEmpty()) {
                this.f3852Q.name = null;
            } else {
                this.f3852Q.name = obj;
            }
            try {
                C1328DB.m5404d(Snippet.class, ManageSnippetsActivity.this).createOrUpdate(this.f3852Q);
                ManageSnippetsActivity.this.m5296p();
            } catch (SQLException unused) {
            }
        }
    }

    @Override // com.sonelli.util.SessionedActivity
    /* renamed from: j */
    public void mo5213j(Bundle bundle) {
        setContentView(R.layout.simple_list_activity);
        this.f3846P = (ListView) findViewById(R.id.list);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.empty);
        TextView textView = (TextView) findViewById(R.id.emptyTitle);
        TextView textView2 = (TextView) findViewById(R.id.emptyMessage);
        this.f3846P.setDividerHeight(0);
        registerForContextMenu(this.f3846P);
        this.f3846P.setOnItemClickListener(new C1276a());
        ((FloatingActionButton) findViewById(R.id.fab_new)).setOnClickListener(new ViewOnClickListenerC1277b());
        textView.setText(getString(R.string.no_snippets));
        textView2.setText(getString(R.string.you_do_not_have_any_snippets));
        this.f3846P.setEmptyView(linearLayout);
        this.f3846P.setAdapter((ListAdapter) new C1278c(this, R.layout.identity_menu_item));
    }

    @Override // com.sonelli.util.SessionedActivity
    /* renamed from: l */
    public void mo5214l() {
        m5296p();
    }

    /* renamed from: o */
    public final void m5295o(UUID uuid) {
        Snippet snippet;
        vk0 vk0Var = new vk0(this);
        vk0Var.m9296i(R.string.edit_snippet);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.snippet_dialog, (ViewGroup) null, false);
        EditText editText = (EditText) linearLayout.findViewById(R.id.nickname);
        EditText editText2 = (EditText) linearLayout.findViewById(R.id.snippet_content);
        vk0Var.m9298k(linearLayout);
        try {
            snippet = (Snippet) C1328DB.m5404d(Snippet.class, this).queryForId(uuid);
            try {
                editText.setText(snippet.name);
            } catch (NullPointerException unused) {
            }
            editText2.setText(snippet.content);
        } catch (Exception unused2) {
            snippet = new Snippet(null, null);
            vk0Var.m9296i(R.string.new_snippet);
        }
        vk0Var.setPositiveButton(getString(R.string.save), new DialogInterfaceOnClickListenerC1279d(editText, editText2, snippet));
        vk0Var.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
        if (isFinishing()) {
            return;
        }
        vk0Var.show();
    }

    @Override // android.app.Activity
    public boolean onContextItemSelected(MenuItem menuItem) {
        super.onContextItemSelected(menuItem);
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) menuItem.getMenuInfo();
        int itemId = menuItem.getItemId();
        if (itemId != R.id.delete) {
            if (itemId != R.id.edit) {
                return true;
            }
            m5295o((UUID) adapterContextMenuInfo.targetView.getTag());
            return true;
        }
        try {
            C1328DB.m5404d(Snippet.class, this).deleteById((UUID) adapterContextMenuInfo.targetView.getTag());
            m5296p();
            return true;
        } catch (SQLException unused) {
            return false;
        }
    }

    @Override // android.app.Activity, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        MenuInflater menuInflater = getMenuInflater();
        contextMenu.setHeaderTitle(R.string.snippet);
        menuInflater.inflate(R.menu.snippet_context_menu, contextMenu);
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
    public final void m5296p() {
        ArrayAdapter arrayAdapter = (ArrayAdapter) this.f3846P.getAdapter();
        arrayAdapter.clear();
        Iterator<Snippet> it = Snippet.m5501t(this).iterator();
        while (it.hasNext()) {
            arrayAdapter.add(it.next());
        }
        arrayAdapter.notifyDataSetChanged();
    }
}
