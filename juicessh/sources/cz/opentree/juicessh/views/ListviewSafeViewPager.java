package cz.opentree.juicessh.views;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public class ListviewSafeViewPager extends ViewPager {
    public ListviewSafeViewPager(Context context) {
        super(context);
    }

    /* renamed from: a */
    public ViewParent m5682a() {
        ViewGroup viewGroup = this;
        while (viewGroup.getParent() != null) {
            viewGroup = (ViewGroup) viewGroup.getParent();
            if ((viewGroup instanceof ScrollView) || (viewGroup instanceof ListView)) {
                return viewGroup;
            }
        }
        return null;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        ViewParent m5682a = m5682a();
        if (onInterceptTouchEvent && m5682a != null && getAdapter().getCount() > 1) {
            m5682a.requestDisallowInterceptTouchEvent(true);
        }
        return onInterceptTouchEvent;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        ViewParent m5682a = m5682a();
        if (onTouchEvent && m5682a != null && getAdapter().getCount() > 1) {
            m5682a.requestDisallowInterceptTouchEvent(true);
        }
        return onTouchEvent;
    }
}
