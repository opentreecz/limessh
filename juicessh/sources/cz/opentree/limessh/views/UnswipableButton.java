package cz.opentree.limessh.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;

/* loaded from: classes.dex */
public class UnswipableButton extends AppCompatButton {

    /* renamed from: O */
    public final C1403b f4339O;

    /* renamed from: P */
    public final GestureDetector f4340P;

    /* renamed from: cz.opentree.limessh.views.UnswipableButton$a */
    /* loaded from: classes.dex */
    public class ViewOnTouchListenerC1402a implements View.OnTouchListener {
        public ViewOnTouchListenerC1402a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return UnswipableButton.this.f4340P.onTouchEvent(motionEvent);
        }
    }

    /* renamed from: cz.opentree.limessh.views.UnswipableButton$b */
    /* loaded from: classes.dex */
    public final class C1403b extends GestureDetector.SimpleOnGestureListener {
        public C1403b(UnswipableButton unswipableButton) {
        }

        public /* synthetic */ C1403b(UnswipableButton unswipableButton, ViewOnTouchListenerC1402a viewOnTouchListenerC1402a) {
            this(unswipableButton);
        }
    }

    public UnswipableButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C1403b c1403b = new C1403b(this, null);
        this.f4339O = c1403b;
        this.f4340P = new GestureDetector(getContext(), c1403b);
        m5697b();
    }

    /* renamed from: b */
    public final void m5697b() {
        setOnTouchListener(new ViewOnTouchListenerC1402a());
    }
}
