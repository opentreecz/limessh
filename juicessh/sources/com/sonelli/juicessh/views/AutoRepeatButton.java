package com.sonelli.juicessh.views;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public class AutoRepeatButton extends TerminalThemedButton {

    /* renamed from: T */
    public long f4290T;

    /* renamed from: U */
    public long f4291U;

    /* renamed from: V */
    public Runnable f4292V;

    /* renamed from: com.sonelli.juicessh.views.AutoRepeatButton$a */
    /* loaded from: classes.dex */
    public class RunnableC1390a implements Runnable {
        public RunnableC1390a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoRepeatButton.this.performClick();
            AutoRepeatButton autoRepeatButton = AutoRepeatButton.this;
            autoRepeatButton.postDelayed(autoRepeatButton.f4292V, AutoRepeatButton.this.f4291U);
        }
    }

    /* renamed from: com.sonelli.juicessh.views.AutoRepeatButton$b */
    /* loaded from: classes.dex */
    public class ViewOnTouchListenerC1391b implements View.OnTouchListener {
        public ViewOnTouchListenerC1391b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                AutoRepeatButton autoRepeatButton = AutoRepeatButton.this;
                autoRepeatButton.removeCallbacks(autoRepeatButton.f4292V);
                AutoRepeatButton autoRepeatButton2 = AutoRepeatButton.this;
                autoRepeatButton2.postDelayed(autoRepeatButton2.f4292V, AutoRepeatButton.this.f4290T);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            AutoRepeatButton autoRepeatButton3 = AutoRepeatButton.this;
            autoRepeatButton3.removeCallbacks(autoRepeatButton3.f4292V);
            return false;
        }
    }

    public AutoRepeatButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4290T = 500L;
        this.f4291U = 50L;
        this.f4292V = new RunnableC1390a();
        m5655b();
    }

    /* renamed from: b */
    private void m5655b() {
        if (Build.VERSION.SDK_INT >= 12) {
            this.f4290T = ViewConfiguration.getKeyRepeatTimeout();
            this.f4291U = ViewConfiguration.getKeyRepeatDelay();
        }
        setOnTouchListener(new ViewOnTouchListenerC1391b());
    }
}
