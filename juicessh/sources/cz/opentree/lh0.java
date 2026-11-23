package cz.opentree;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import cz.opentree.limessh.R;
import cz.opentree.limessh.views.TerminalAutoCompleteBox;
import cz.opentree.limessh.views.TerminalThemedButton;
import cz.opentree.limessh.views.TerminalThemedImageButton;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: HackersKeyboardPagerAdapter.java */
/* loaded from: classes.dex */
public class lh0 extends PagerAdapter {

    /* renamed from: a */
    public int f4801a = 0;

    /* renamed from: b */
    public TableLayout f4802b;

    /* renamed from: c */
    public TableLayout f4803c;

    /* renamed from: d */
    public TerminalAutoCompleteBox f4804d;

    public lh0(ViewPager viewPager) {
        LayoutInflater layoutInflater = (LayoutInflater) viewPager.getContext().getSystemService("layout_inflater");
        this.f4804d = (TerminalAutoCompleteBox) layoutInflater.inflate(R.layout.autocomplete_box, (ViewGroup) viewPager, false);
        this.f4802b = (TableLayout) layoutInflater.inflate(R.layout.hacker_keyboard, (ViewGroup) viewPager, false);
        this.f4803c = (TableLayout) layoutInflater.inflate(R.layout.hacker_keyboard_function_keys, (ViewGroup) viewPager, false);
    }

    /* renamed from: b */
    public final ArrayList<View> m6165b(View view) {
        if (!(view instanceof ViewGroup)) {
            ArrayList<View> arrayList = new ArrayList<>();
            arrayList.add(view);
            return arrayList;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(view);
            arrayList3.addAll(m6165b(childAt));
            arrayList2.addAll(arrayList3);
        }
        return arrayList2;
    }

    /* renamed from: c */
    public TerminalAutoCompleteBox m6166c() {
        return this.f4804d;
    }

    /* renamed from: d */
    public int m6167d() {
        return this.f4801a;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    /* renamed from: e */
    public TableLayout m6168e() {
        return this.f4802b;
    }

    /* renamed from: f */
    public void m6169f(int i) {
        this.f4801a = i;
        notifyDataSetChanged();
    }

    /* renamed from: g */
    public void m6170g(int i, int i2) {
        int argb = Color.argb(25, Color.red(i), Color.green(i), Color.blue(i));
        int argb2 = Color.argb(85, Color.red(i), Color.green(i), Color.blue(i));
        TableLayout tableLayout = this.f4802b;
        if (tableLayout != null) {
            Iterator<View> it = m6165b(tableLayout).iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next instanceof TerminalThemedButton) {
                    ((TerminalThemedButton) next).m5691c(i, argb, argb2);
                }
                if (next instanceof TerminalThemedImageButton) {
                    ((TerminalThemedImageButton) next).m5693a(i, argb, argb2);
                }
            }
        }
        TableLayout tableLayout2 = this.f4803c;
        if (tableLayout2 != null) {
            Iterator<View> it2 = m6165b(tableLayout2).iterator();
            while (it2.hasNext()) {
                View next2 = it2.next();
                if (next2 instanceof TerminalThemedButton) {
                    ((TerminalThemedButton) next2).m5691c(i, argb, argb2);
                }
                if (next2 instanceof TerminalThemedImageButton) {
                    ((TerminalThemedImageButton) next2).m5693a(i, argb, argb2);
                }
            }
        }
        TerminalAutoCompleteBox terminalAutoCompleteBox = this.f4804d;
        if (terminalAutoCompleteBox != null) {
            terminalAutoCompleteBox.setTextColor(i);
            this.f4804d.setCursorVisible(true);
            this.f4804d.setHintTextColor(i);
            this.f4804d.setBackgroundColor(argb);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == 0) {
            int i2 = this.f4801a;
            if (i2 == 0) {
                viewGroup.addView(this.f4802b);
                return this.f4802b;
            }
            if (i2 == 1) {
                viewGroup.addView(this.f4803c);
                return this.f4803c;
            }
        } else if (i != 1) {
            return null;
        }
        viewGroup.addView(this.f4804d);
        return this.f4804d;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
