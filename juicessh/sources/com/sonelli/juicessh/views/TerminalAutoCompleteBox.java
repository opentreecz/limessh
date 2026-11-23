package com.sonelli.juicessh.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import com.sonelli.juicessh.views.TerminalView;

/* loaded from: classes.dex */
public class TerminalAutoCompleteBox extends AppCompatEditText {

    /* renamed from: O */
    public TerminalView.OnBackListener f4323O;

    /* renamed from: P */
    public TerminalView.OnEscListener f4324P;

    /* renamed from: com.sonelli.juicessh.views.TerminalAutoCompleteBox$a */
    /* loaded from: classes.dex */
    public class ViewOnFocusChangeListenerC1399a implements View.OnFocusChangeListener {

        /* renamed from: com.sonelli.juicessh.views.TerminalAutoCompleteBox$a$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ((InputMethodManager) TerminalAutoCompleteBox.this.getContext().getSystemService("input_method")).showSoftInput(TerminalAutoCompleteBox.this, 0);
            }
        }

        public ViewOnFocusChangeListenerC1399a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                TerminalAutoCompleteBox.this.postDelayed(new a(), 100L);
            }
        }
    }

    public TerminalAutoCompleteBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5688a();
    }

    /* renamed from: a */
    public void m5688a() {
        setOnFocusChangeListener(new ViewOnFocusChangeListenerC1399a());
    }

    /* renamed from: b */
    public void m5689b(TerminalView.OnBackListener onBackListener) {
        this.f4323O = onBackListener;
    }

    /* renamed from: c */
    public void m5690c(TerminalView.OnEscListener onEscListener) {
        this.f4324P = onEscListener;
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        TerminalView.OnEscListener onEscListener;
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 4) {
            if (keyCode == 111 && keyEvent.getAction() == 0 && (onEscListener = this.f4324P) != null) {
                return onEscListener.mo5341a();
            }
        } else if (keyEvent.getAction() == 0) {
            if (keyEvent.getDevice() == null || keyEvent.getDeviceId() < 0 || keyEvent.getDevice().getKeyboardType() != 2) {
                TerminalView.OnBackListener onBackListener = this.f4323O;
                if (onBackListener != null) {
                    return onBackListener.mo5342a();
                }
            } else {
                TerminalView.OnEscListener onEscListener2 = this.f4324P;
                if (onEscListener2 != null) {
                    return onEscListener2.mo5341a();
                }
            }
        }
        return false;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        int i = editorInfo.imeOptions & (-1073741825);
        editorInfo.imeOptions = i;
        editorInfo.imeOptions = i | 268435456;
        return onCreateInputConnection;
    }
}
