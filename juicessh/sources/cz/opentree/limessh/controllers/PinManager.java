package cz.opentree.limessh.controllers;

import android.content.Intent;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import cz.opentree.cj0;
import cz.opentree.gj0;
import cz.opentree.limessh.R;
import cz.opentree.limessh.activities.LockoutActivity;
import cz.opentree.limessh.models.User;
import cz.opentree.kj0;
import cz.opentree.util.Session;
import cz.opentree.zk0;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class PinManager {

    /* renamed from: a */
    public static AtomicBoolean f3985a = new AtomicBoolean(false);

    /* loaded from: classes.dex */
    public interface PinPromptDialog {
        /* renamed from: b */
        PinPromptDialog mo2824b(FragmentActivity fragmentActivity);

        /* renamed from: c */
        void mo2825c(PinPromptSimpleListener pinPromptSimpleListener);

        /* renamed from: d */
        void mo2826d(PinPromptListener pinPromptListener);

        void dismiss();

        boolean isShowing();
    }

    /* loaded from: classes.dex */
    public interface PinPromptListener {
        /* renamed from: d */
        void mo5374d();

        /* renamed from: e */
        void mo5375e();

        void onCancel();
    }

    /* loaded from: classes.dex */
    public interface PinPromptSimpleListener {
        /* renamed from: a */
        void mo5376a(PinPromptDialog pinPromptDialog);

        /* renamed from: d */
        void mo5377d();

        /* renamed from: e */
        void mo5378e();
    }

    /* renamed from: cz.opentree.limessh.controllers.PinManager$a */
    /* loaded from: classes.dex */
    public static class C1324a implements PinPromptListener {

        /* renamed from: a */
        public int f3986a = 0;

        /* renamed from: b */
        public final /* synthetic */ int f3987b;

        /* renamed from: c */
        public final /* synthetic */ zk0 f3988c;

        /* renamed from: d */
        public final /* synthetic */ FragmentActivity f3989d;

        /* renamed from: e */
        public final /* synthetic */ PinPromptSimpleListener f3990e;

        /* renamed from: f */
        public final /* synthetic */ PinPromptDialog f3991f;

        public C1324a(int i, zk0 zk0Var, FragmentActivity fragmentActivity, PinPromptSimpleListener pinPromptSimpleListener, PinPromptDialog pinPromptDialog) {
            this.f3987b = i;
            this.f3988c = zk0Var;
            this.f3989d = fragmentActivity;
            this.f3990e = pinPromptSimpleListener;
            this.f3991f = pinPromptDialog;
        }

        @Override // cz.opentree.limessh.controllers.PinManager.PinPromptListener
        /* renamed from: d */
        public void mo5374d() {
            if (this.f3987b + this.f3986a > 0) {
                this.f3988c.m10500i(this.f3989d, 0, 0L);
            }
            PinManager.f3985a.set(false);
            PinPromptSimpleListener pinPromptSimpleListener = this.f3990e;
            if (pinPromptSimpleListener != null) {
                pinPromptSimpleListener.mo5377d();
            }
        }

        @Override // cz.opentree.limessh.controllers.PinManager.PinPromptListener
        /* renamed from: e */
        public void mo5375e() {
            int i = this.f3986a + 1;
            this.f3986a = i;
            int i2 = this.f3987b;
            if (i2 + i < 5) {
                FragmentActivity fragmentActivity = this.f3989d;
                Toast.makeText(fragmentActivity, String.format(fragmentActivity.getString(R.string.incorrect_pin_attempt_x_remaining), Integer.valueOf(5 - (this.f3987b + this.f3986a))), 0).show();
                this.f3988c.m10499h(this.f3989d, this.f3987b + this.f3986a);
                return;
            }
            this.f3988c.m10500i(this.f3989d, i2 + i, System.currentTimeMillis());
            if (this.f3991f.isShowing()) {
                this.f3991f.dismiss();
            }
            PinManager.f3985a.set(false);
            PinPromptSimpleListener pinPromptSimpleListener = this.f3990e;
            if (pinPromptSimpleListener != null) {
                pinPromptSimpleListener.mo5378e();
            }
            this.f3989d.startActivity(new Intent(this.f3989d, (Class<?>) LockoutActivity.class));
        }

        @Override // cz.opentree.limessh.controllers.PinManager.PinPromptListener
        public void onCancel() {
            if (this.f3991f.isShowing()) {
                this.f3991f.dismiss();
            }
            PinManager.f3985a.set(false);
            PinPromptSimpleListener pinPromptSimpleListener = this.f3990e;
            if (pinPromptSimpleListener != null) {
                pinPromptSimpleListener.mo5378e();
            }
        }
    }

    /* renamed from: cz.opentree.limessh.controllers.PinManager$b */
    /* loaded from: classes.dex */
    public static class C1325b implements PinPromptListener {

        /* renamed from: a */
        public final /* synthetic */ PinPromptSimpleListener f3992a;

        public C1325b(PinPromptSimpleListener pinPromptSimpleListener) {
            this.f3992a = pinPromptSimpleListener;
        }

        @Override // cz.opentree.limessh.controllers.PinManager.PinPromptListener
        /* renamed from: d */
        public void mo5374d() {
            this.f3992a.mo5377d();
        }

        @Override // cz.opentree.limessh.controllers.PinManager.PinPromptListener
        /* renamed from: e */
        public void mo5375e() {
            this.f3992a.mo5378e();
        }

        @Override // cz.opentree.limessh.controllers.PinManager.PinPromptListener
        public void onCancel() {
            this.f3992a.mo5378e();
        }
    }

    /* renamed from: a */
    public static void m5372a(FragmentActivity fragmentActivity, PinPromptSimpleListener pinPromptSimpleListener) {
        cj0 m2823i = cj0.m2823i(true, 1);
        m2823i.mo2826d(new C1325b(pinPromptSimpleListener));
        m2823i.mo2824b(fragmentActivity);
    }

    /* renamed from: b */
    public static void m5373b(FragmentActivity fragmentActivity, boolean z, boolean z2, PinPromptSimpleListener pinPromptSimpleListener) {
        if (!kj0.m5917a().m5935q() || User.m5525s(fragmentActivity) == null || User.m5529y(fragmentActivity).booleanValue()) {
            if (pinPromptSimpleListener != null) {
                pinPromptSimpleListener.mo5377d();
                return;
            }
            return;
        }
        zk0 m9049h = Session.m9046g().m9049h();
        int m10493b = m9049h.m10493b(fragmentActivity);
        if (m10493b >= 5) {
            if (Long.valueOf(System.currentTimeMillis() - Long.valueOf(m9049h.m10495d(fragmentActivity)).longValue()).longValue() < 300000) {
                f3985a.set(false);
                fragmentActivity.startActivity(new Intent(fragmentActivity, (Class<?>) LockoutActivity.class));
                return;
            } else {
                Long l = 0L;
                m9049h.m10500i(fragmentActivity, 0, l.longValue());
                m10493b = 0;
            }
        }
        boolean m10494c = m9049h.m10494c(fragmentActivity);
        if (!z2 && !m10494c) {
            if (pinPromptSimpleListener != null) {
                pinPromptSimpleListener.mo5377d();
                return;
            }
            return;
        }
        if (f3985a.get() && !z2) {
            gj0.m4141b("PinManager", "Not attempting pincheck as an attempt is already in progress");
            return;
        }
        f3985a.set(true);
        if (User.m5528v(fragmentActivity) == null) {
            m9049h.m10501j(fragmentActivity, false);
            m9049h.m10492a(fragmentActivity);
            pinPromptSimpleListener.mo5377d();
            return;
        }
        cj0 m2823i = cj0.m2823i(z, 0);
        m2823i.mo2825c(pinPromptSimpleListener);
        m2823i.mo2826d(new C1324a(m10493b, m9049h, fragmentActivity, pinPromptSimpleListener, m2823i));
        gj0.m4141b("PinManager", "Showing pinprompt");
        m2823i.mo2824b(fragmentActivity);
        if (pinPromptSimpleListener != null) {
            pinPromptSimpleListener.mo5376a(m2823i);
        }
    }
}
