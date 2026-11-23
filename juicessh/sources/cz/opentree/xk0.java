package cz.opentree;

import android.preference.Preference;
import androidx.fragment.app.FragmentActivity;
import cz.opentree.juicessh.controllers.PinManager;
import cz.opentree.juicessh.models.Config;
import cz.opentree.juicessh.views.dbpreferences.EncSwitchDBPreference;
import cz.opentree.util.Session;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: EncryptedTwoStateDBOnPreferenceChangeListener.java */
/* loaded from: classes.dex */
public class xk0 implements Preference.OnPreferenceChangeListener {

    /* renamed from: a */
    public FragmentActivity f7990a;

    /* renamed from: b */
    public AtomicBoolean f7991b = new AtomicBoolean(false);

    /* compiled from: EncryptedTwoStateDBOnPreferenceChangeListener.java */
    /* renamed from: cz.opentree.xk0$a */
    /* loaded from: classes.dex */
    public class C2298a implements PinManager.PinPromptSimpleListener {

        /* renamed from: a */
        public final /* synthetic */ Preference f7992a;

        public C2298a(Preference preference) {
            this.f7992a = preference;
        }

        @Override // cz.opentree.juicessh.controllers.PinManager.PinPromptSimpleListener
        /* renamed from: a */
        public void mo5376a(PinManager.PinPromptDialog pinPromptDialog) {
        }

        @Override // cz.opentree.juicessh.controllers.PinManager.PinPromptSimpleListener
        /* renamed from: d */
        public void mo5377d() {
            Session.m9046g().m9049h().m10501j(xk0.this.f7990a, true);
            xk0.this.m9799d(this.f7992a, true);
            xk0.this.f7991b.set(false);
        }

        @Override // cz.opentree.juicessh.controllers.PinManager.PinPromptSimpleListener
        /* renamed from: e */
        public void mo5378e() {
            xk0.this.f7991b.set(false);
        }
    }

    public xk0(FragmentActivity fragmentActivity) {
        this.f7990a = fragmentActivity;
    }

    /* renamed from: d */
    public final void m9799d(Preference preference, boolean z) {
        if (preference instanceof EncSwitchDBPreference) {
            ((EncSwitchDBPreference) preference).m5703q(z);
        }
    }

    @Override // android.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (this.f7991b.get()) {
            gj0.m4141b("EncDBOnPreferenceChangeListener", "Already processing a change for this preference [" + preference.getKey() + "]");
            return false;
        }
        this.f7991b.set(true);
        Boolean bool = (Boolean) obj;
        if (!(preference instanceof EncSwitchDBPreference)) {
            throw new IllegalArgumentException("Unallowed Preference Type");
        }
        if (((EncSwitchDBPreference) preference).m5684h() == bool.booleanValue()) {
            gj0.m4141b("EncDBOnPreferenceChangeListener", "Can't change preference to same value");
            this.f7991b.set(false);
            return false;
        }
        if (preference.getKey().equals("pinlock:enabled")) {
            if (!bool.booleanValue()) {
                Session.m9046g().m9049h().m10501j(this.f7990a, false);
                this.f7991b.set(false);
                return true;
            }
            Config.m5462h("pinlock:style", String.valueOf(2), this.f7990a);
            PinManager.m5372a(this.f7990a, new C2298a(preference));
        }
        return false;
    }
}
