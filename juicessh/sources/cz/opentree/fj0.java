package cz.opentree;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import cz.opentree.limessh.R;

/* compiled from: SoftwareLicensesFragment.java */
/* loaded from: classes.dex */
public class fj0 extends Fragment {

    /* renamed from: O */
    public final rh0 f2700O = new rh0();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R.layout.card_list, viewGroup, false);
        ((ListView) inflate.findViewById(R.id.list)).setAdapter((ListAdapter) this.f2700O);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f2700O.m7907f(getActivity());
    }
}
