package com.sonelli.juicessh.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.sonelli.aj0;
import com.sonelli.gj0;
import com.sonelli.util.TerminalGestureListener;
import jackpal.androidterm.emulatorview.EmulatorView;
import jackpal.androidterm.emulatorview.TermSession;

/* loaded from: classes.dex */
public class TerminalView extends EmulatorView {

    /* renamed from: O */
    public OnResizeListener f4332O;

    /* renamed from: P */
    public OnBackListener f4333P;

    /* renamed from: Q */
    public OnEscListener f4334Q;

    /* renamed from: R */
    public GestureDetector.OnGestureListener f4335R;

    /* loaded from: classes.dex */
    public interface OnBackListener {
        /* renamed from: a */
        boolean mo5342a();
    }

    /* loaded from: classes.dex */
    public interface OnEscListener {
        /* renamed from: a */
        boolean mo5341a();
    }

    /* loaded from: classes.dex */
    public interface OnResizeListener {
        /* renamed from: a */
        void mo5343a(int i, int i2, int i3, int i4);
    }

    /* renamed from: com.sonelli.juicessh.views.TerminalView$a */
    /* loaded from: classes.dex */
    public class RunnableC1400a implements Runnable {
        public RunnableC1400a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((Activity) TerminalView.this.getContext()).getWindow().setSoftInputMode(16);
            TerminalView.this.clearFocus();
            TerminalView.this.requestFocus();
        }
    }

    /* renamed from: com.sonelli.juicessh.views.TerminalView$b */
    /* loaded from: classes.dex */
    public class ViewOnFocusChangeListenerC1401b implements View.OnFocusChangeListener {

        /* renamed from: com.sonelli.juicessh.views.TerminalView$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ((InputMethodManager) TerminalView.this.getContext().getSystemService("input_method")).showSoftInput(TerminalView.this, 0);
            }
        }

        public ViewOnFocusChangeListenerC1401b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                TerminalView.this.postDelayed(new a(), 100L);
            }
        }
    }

    public TerminalView(int i, Context context, TermSession termSession, DisplayMetrics displayMetrics) {
        super(context, termSession, displayMetrics);
        setUseCookedIME(true);
        setOnFocusChangeListener(new ViewOnFocusChangeListenerC1401b());
    }

    /* renamed from: a */
    public void m5694a(OnEscListener onEscListener) {
        this.f4334Q = onEscListener;
    }

    /* renamed from: b */
    public void m5695b(OnResizeListener onResizeListener) {
        this.f4332O = onResizeListener;
    }

    @Override // android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        OnEscListener onEscListener;
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 4) {
            if (keyCode == 111 && keyEvent.getAction() == 0 && (onEscListener = this.f4334Q) != null) {
                return onEscListener.mo5341a();
            }
        } else if (keyEvent.getAction() == 0) {
            if (keyEvent.getDevice() == null || keyEvent.getDeviceId() < 0 || keyEvent.getDevice().getKeyboardType() != 2) {
                OnBackListener onBackListener = this.f4333P;
                if (onBackListener != null) {
                    return onBackListener.mo5342a();
                }
            } else {
                OnEscListener onEscListener2 = this.f4334Q;
                if (onEscListener2 != null) {
                    return onEscListener2.mo5341a();
                }
            }
        }
        return false;
    }

    @Override // jackpal.androidterm.emulatorview.EmulatorView
    public Typeface getFont() {
        gj0.m4141b("Views/TerminalView", "Setting font to embedded monospace font");
        return Typeface.createFromAsset(getContext().getAssets(), aj0.m2116c(getContext()));
    }

    @Override // jackpal.androidterm.emulatorview.EmulatorView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        EmulatorView.OnKeyPressListener onKeyPressListener = this.mKeyPressListener;
        if (onKeyPressListener != null) {
            onKeyPressListener.onKeyPressed(i);
        }
        return onKeyDown;
    }

    @Override // jackpal.androidterm.emulatorview.EmulatorView, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // jackpal.androidterm.emulatorview.EmulatorView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        OnResizeListener onResizeListener = this.f4332O;
        if (onResizeListener != null) {
            onResizeListener.mo5343a(i, i2, i3, i4);
        }
    }

    @Override // jackpal.androidterm.emulatorview.EmulatorView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector.OnGestureListener onGestureListener = this.f4335R;
        return (onGestureListener == null || !(onGestureListener instanceof TerminalGestureListener)) ? super.onTouchEvent(motionEvent) : ((TerminalGestureListener) onGestureListener).m9070d(motionEvent) || super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0) {
            return;
        }
        postDelayed(new RunnableC1400a(), 200L);
    }

    @Override // jackpal.androidterm.emulatorview.EmulatorView
    public void setColors(int[] iArr) {
        super.setColors(iArr);
        OnResizeListener onResizeListener = this.f4332O;
        if (onResizeListener != null) {
            onResizeListener.mo5343a(getWidth(), getHeight(), getWidth(), getHeight());
        }
    }

    @Override // jackpal.androidterm.emulatorview.EmulatorView
    public void setExtGestureListener(GestureDetector.OnGestureListener onGestureListener) {
        this.f4335R = onGestureListener;
        super.setExtGestureListener(onGestureListener);
    }

    @Override // jackpal.androidterm.emulatorview.EmulatorView
    public void setTextSize(int i) {
        super.setTextSize(i);
        OnResizeListener onResizeListener = this.f4332O;
        if (onResizeListener != null) {
            onResizeListener.mo5343a(getWidth(), getHeight(), getWidth(), getHeight());
        }
    }
}
