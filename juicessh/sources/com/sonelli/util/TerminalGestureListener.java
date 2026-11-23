package com.sonelli.util;

import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import com.sonelli.cl0;
import com.sonelli.juicessh.activities.TerminalEmulatorActivity;
import com.sonelli.juicessh.models.Config;
import com.sonelli.juicessh.views.TerminalView;

/* loaded from: classes.dex */
public class TerminalGestureListener extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: O */
    public TerminalEmulatorActivity f7284O;

    /* renamed from: P */
    public TerminalView f7285P;

    /* renamed from: Q */
    public int f7286Q;

    /* renamed from: R */
    public MotionEvent.PointerCoords f7287R;

    /* renamed from: S */
    public final Handler f7288S = new Handler();

    /* renamed from: T */
    public final Runnable f7289T = new RunnableC2130a();

    /* renamed from: com.sonelli.util.TerminalGestureListener$a */
    /* loaded from: classes.dex */
    public class RunnableC2130a implements Runnable {
        public RunnableC2130a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TerminalGestureListener.this.f7284O == null || TerminalGestureListener.this.f7284O.isFinishing()) {
                return;
            }
            TerminalGestureListener.this.f7284O.openContextMenu(TerminalGestureListener.this.f7285P);
        }
    }

    public TerminalGestureListener(TerminalEmulatorActivity terminalEmulatorActivity, TerminalView terminalView) {
        this.f7284O = terminalEmulatorActivity;
        this.f7285P = terminalView;
        this.f7286Q = Config.m5460f(terminalEmulatorActivity, "terminal:horizontal_swipe_mode");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0029, code lost:
    
        if (r25 == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0032, code lost:
    
        r15 = r2;
        r5 = 42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0030, code lost:
    
        r15 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x002e, code lost:
    
        if (r25 == 0) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m9069c(int r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            r2 = 2
            if (r1 == r2) goto L84
            r3 = 3
            if (r1 != r3) goto Lc
            goto L84
        Lc:
            int r4 = r0.f7286Q
            r5 = 44
            r6 = 42
            r7 = 4096(0x1000, float:5.74E-42)
            r8 = -1
            if (r4 == 0) goto L42
            r9 = 1
            if (r4 == r9) goto L37
            if (r4 == r2) goto L2c
            if (r4 == r3) goto L27
            r1 = 4
            if (r4 == r1) goto L26
            r5 = r8
            r15 = r5
            r17 = r15
            goto L4a
        L26:
            return
        L27:
            r2 = 29
            if (r1 != 0) goto L32
            goto L30
        L2c:
            r2 = 30
            if (r1 != 0) goto L32
        L30:
            r15 = r2
            goto L34
        L32:
            r15 = r2
            r5 = r6
        L34:
            r17 = r7
            goto L4a
        L37:
            if (r1 != 0) goto L3c
            r1 = 21
            goto L3e
        L3c:
            r1 = 22
        L3e:
            r15 = r1
            r17 = r2
            goto L49
        L42:
            if (r1 != 0) goto L45
            goto L46
        L45:
            r5 = r6
        L46:
            r15 = r5
            r17 = r7
        L49:
            r5 = r8
        L4a:
            com.sonelli.juicessh.views.TerminalView r1 = r0.f7285P
            jackpal.androidterm.emulatorview.TermSession r1 = r1.getTermSession()
            boolean r1 = r1.isRunning()
            if (r1 == 0) goto L84
            android.view.KeyEvent r1 = new android.view.KeyEvent
            r10 = 300(0x12c, double:1.48E-321)
            long r12 = java.lang.System.currentTimeMillis()
            r14 = 0
            r16 = 0
            r9 = r1
            r9.<init>(r10, r12, r14, r15, r16, r17)
            com.sonelli.juicessh.views.TerminalView r2 = r0.f7285P
            r2.dispatchKeyEvent(r1)
            if (r5 <= r8) goto L84
            android.view.KeyEvent r1 = new android.view.KeyEvent
            r17 = 300(0x12c, double:1.48E-321)
            long r19 = java.lang.System.currentTimeMillis()
            r21 = 0
            r23 = 0
            r16 = r1
            r22 = r5
            r16.<init>(r17, r19, r21, r22, r23)
            com.sonelli.juicessh.views.TerminalView r2 = r0.f7285P
            r2.dispatchKeyEvent(r1)
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.util.TerminalGestureListener.m9069c(int):void");
    }

    /* renamed from: d */
    public boolean m9070d(MotionEvent motionEvent) {
        if (this.f7287R == null && motionEvent.getAction() == 0) {
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            this.f7287R = pointerCoords;
            pointerCoords.x = motionEvent.getX();
            this.f7287R.y = motionEvent.getY();
            this.f7288S.postDelayed(this.f7289T, 500L);
            return false;
        }
        if (this.f7287R != null) {
            if (motionEvent.getAction() == 1) {
                this.f7288S.removeCallbacks(this.f7289T);
                this.f7287R = null;
                return false;
            }
            if (motionEvent.getAction() == 2) {
                float x = motionEvent.getX() - this.f7287R.x;
                float y = motionEvent.getY() - this.f7287R.y;
                if (Math.abs(y) > Math.abs(x) && Math.abs(y) > 50.0f) {
                    this.f7288S.removeCallbacks(this.f7289T);
                    this.f7287R = null;
                    return false;
                }
                if (Math.abs(x) > Math.abs(y) && Math.abs(x) > 100.0f) {
                    this.f7288S.removeCallbacks(this.f7289T);
                    this.f7287R = null;
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float x = motionEvent2.getX() - motionEvent.getX();
        float y = motionEvent2.getY() - motionEvent.getY();
        if (Math.abs(x) > Math.abs(y) && Math.abs(x) > 100.0f && Math.abs(f) > 100.0f) {
            if (x > 0.0f) {
                m9069c(1);
            } else {
                m9069c(0);
            }
            return true;
        }
        if (Math.abs(y) <= Math.abs(x) || Math.abs(y) <= 50.0f || Math.abs(f2) <= 50.0f) {
            return onSingleTapUp(motionEvent);
        }
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(final MotionEvent motionEvent) {
        ((InputMethodManager) this.f7284O.getSystemService("input_method")).showSoftInput(this.f7285P, 0, new ResultReceiver(new Handler()) { // from class: com.sonelli.util.TerminalGestureListener.2

            /* renamed from: com.sonelli.util.TerminalGestureListener$2$a */
            /* loaded from: classes.dex */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    TerminalGestureListener.this.f7284O.m5331v();
                }
            }

            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i, Bundle bundle) {
                String findWordAt;
                super.onReceiveResult(i, bundle);
                boolean z = true;
                if (i == 2) {
                    if (TerminalGestureListener.this.f7284O.m5327r() == null || TerminalGestureListener.this.f7284O.m5327r().getCurrentItem() != 1) {
                        return;
                    }
                    TerminalGestureListener.this.f7284O.m5331v();
                    return;
                }
                RectF[] m2868a = cl0.m2868a(TerminalGestureListener.this.f7284O, motionEvent.getX(), motionEvent.getY(), TerminalGestureListener.this.f7285P.getCharacterWidth());
                RectF rectF = new RectF(TerminalGestureListener.this.f7285P.getLeft(), TerminalGestureListener.this.f7285P.getTop(), TerminalGestureListener.this.f7285P.getRight(), TerminalGestureListener.this.f7285P.getBottom());
                int length = m2868a.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    RectF rectF2 = m2868a[i2];
                    if (rectF.contains(rectF2) && (findWordAt = TerminalGestureListener.this.f7285P.findWordAt(rectF2.centerX(), rectF2.centerY(), 2083)) != null && !findWordAt.isEmpty() && cl0.m2870c(TerminalGestureListener.this.f7284O, findWordAt)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    return;
                }
                TerminalGestureListener.this.f7284O.runOnUiThread(new a());
            }
        });
        return true;
    }
}
