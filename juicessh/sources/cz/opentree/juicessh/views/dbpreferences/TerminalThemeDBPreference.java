package cz.opentree.juicessh.views.dbpreferences;

import android.app.AlertDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import cz.opentree.util.ProBlockablePreference;
import cz.opentree.zh0;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class TerminalThemeDBPreference extends ListDBPreference implements ProBlockablePreference, View.OnClickListener {
    public TerminalThemeDBPreference(Context context) {
        super(context);
        new AtomicBoolean(false);
        new AtomicBoolean(false);
        m5726l();
    }

    public TerminalThemeDBPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new AtomicBoolean(false);
        new AtomicBoolean(false);
        m5726l();
    }

    /* renamed from: l */
    public void m5726l() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.preference.ListPreference, android.preference.DialogPreference
    public void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        builder.setAdapter(new zh0(getContext(), getEntries(), getEntryValues()), this);
        super.onPrepareDialogBuilder(builder);
    }
}
