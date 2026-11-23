package cz.opentree.juicessh.views.dbpreferences;

import android.app.AlertDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import cz.opentree.util.ProBlockablePreference;
import cz.opentree.yh0;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class TerminalFontDBPreference extends ListDBPreference implements ProBlockablePreference, View.OnClickListener {
    public TerminalFontDBPreference(Context context) {
        super(context);
        new AtomicBoolean(false);
        new AtomicBoolean(false);
        m5725l();
    }

    public TerminalFontDBPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new AtomicBoolean(false);
        new AtomicBoolean(false);
        m5725l();
    }

    /* renamed from: l */
    public void m5725l() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.preference.ListPreference, android.preference.DialogPreference
    public void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        builder.setAdapter(new yh0(getContext(), getEntries(), getEntryValues()), this);
        super.onPrepareDialogBuilder(builder);
    }
}
