package com.github.machinarius.preferencefragment;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.github.machinarius.preferencefragment.PreferenceManagerCompat;

/* loaded from: classes.dex */
public abstract class PreferenceFragment extends Fragment implements PreferenceManagerCompat.OnPreferenceTreeClickListener {

    /* renamed from: O */
    public PreferenceManager f502O;

    /* renamed from: P */
    public ListView f503P;

    /* renamed from: Q */
    public boolean f504Q;

    /* renamed from: R */
    public boolean f505R;

    /* renamed from: S */
    public Handler f506S = new HandlerC0416a();

    /* renamed from: T */
    public final Runnable f507T = new RunnableC0417b();

    /* renamed from: U */
    public View.OnKeyListener f508U = new ViewOnKeyListenerC0418c();

    /* loaded from: classes.dex */
    public interface OnPreferenceStartFragmentCallback {
        /* renamed from: a */
        boolean m728a(PreferenceFragment preferenceFragment, Preference preference);
    }

    /* renamed from: com.github.machinarius.preferencefragment.PreferenceFragment$a */
    /* loaded from: classes.dex */
    public class HandlerC0416a extends Handler {
        public HandlerC0416a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            PreferenceFragment.this.m721i();
        }
    }

    /* renamed from: com.github.machinarius.preferencefragment.PreferenceFragment$b */
    /* loaded from: classes.dex */
    public class RunnableC0417b implements Runnable {
        public RunnableC0417b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PreferenceFragment.this.f503P.focusableViewAvailable(PreferenceFragment.this.f503P);
        }
    }

    /* renamed from: com.github.machinarius.preferencefragment.PreferenceFragment$c */
    /* loaded from: classes.dex */
    public class ViewOnKeyListenerC0418c implements View.OnKeyListener {
        public ViewOnKeyListenerC0418c() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (PreferenceFragment.this.f503P.getSelectedItem() instanceof Preference) {
                PreferenceFragment.this.f503P.getSelectedView();
            }
            return false;
        }
    }

    @Override // com.github.machinarius.preferencefragment.PreferenceManagerCompat.OnPreferenceTreeClickListener
    /* renamed from: a */
    public boolean mo719a(PreferenceScreen preferenceScreen, Preference preference) {
        if (getActivity() instanceof OnPreferenceStartFragmentCallback) {
            return ((OnPreferenceStartFragmentCallback) getActivity()).m728a(this, preference);
        }
        return false;
    }

    public final void ensureList() {
        if (this.f503P != null) {
            return;
        }
        View view = getView();
        if (view == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        View findViewById = view.findViewById(R.id.list);
        if (!(findViewById instanceof ListView)) {
            throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
        }
        ListView listView = (ListView) findViewById;
        this.f503P = listView;
        if (listView == null) {
            throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
        }
        listView.setOnKeyListener(this.f508U);
        this.f506S.post(this.f507T);
    }

    public ListView getListView() {
        ensureList();
        return this.f503P;
    }

    /* renamed from: h */
    public void m720h(int i) {
        m726n();
        m727o(PreferenceManagerCompat.m733e(this.f502O, getActivity(), i, m724l()));
    }

    /* renamed from: i */
    public final void m721i() {
        PreferenceScreen m724l = m724l();
        if (m724l != null) {
            m724l.bind(getListView());
        }
    }

    /* renamed from: j */
    public Preference m722j(CharSequence charSequence) {
        PreferenceManager preferenceManager = this.f502O;
        if (preferenceManager == null) {
            return null;
        }
        return preferenceManager.findPreference(charSequence);
    }

    /* renamed from: k */
    public PreferenceManager m723k() {
        return this.f502O;
    }

    /* renamed from: l */
    public PreferenceScreen m724l() {
        return PreferenceManagerCompat.m732d(this.f502O);
    }

    /* renamed from: m */
    public final void m725m() {
        if (this.f506S.hasMessages(1)) {
            return;
        }
        this.f506S.obtainMessage(1).sendToTarget();
    }

    /* renamed from: n */
    public final void m726n() {
        if (this.f502O == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    /* renamed from: o */
    public void m727o(PreferenceScreen preferenceScreen) {
        if (!PreferenceManagerCompat.m737i(this.f502O, preferenceScreen) || preferenceScreen == null) {
            return;
        }
        this.f504Q = true;
        if (this.f505R) {
            m725m();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen m724l;
        super.onActivityCreated(bundle);
        if (this.f504Q) {
            m721i();
        }
        this.f505R = true;
        if (bundle == null || (bundle2 = bundle.getBundle("android:preferences")) == null || (m724l = m724l()) == null) {
            return;
        }
        m724l.restoreHierarchyState(bundle2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        PreferenceManagerCompat.m730b(this.f502O, i, i2, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PreferenceManager m734f = PreferenceManagerCompat.m734f(getActivity(), 100);
        this.f502O = m734f;
        PreferenceManagerCompat.m735g(m734f, this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.preference_list_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PreferenceManagerCompat.m729a(this.f502O);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f503P = null;
        this.f506S.removeCallbacks(this.f507T);
        this.f506S.removeMessages(1);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen m724l = m724l();
        if (m724l != null) {
            Bundle bundle2 = new Bundle();
            m724l.saveHierarchyState(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        PreferenceManagerCompat.m736h(this.f502O, this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        PreferenceManagerCompat.m731c(this.f502O);
        PreferenceManagerCompat.m736h(this.f502O, null);
    }
}
