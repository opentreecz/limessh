package com.sonelli;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.sonelli.juicessh.views.CardListItem;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CardListAdapter.java */
/* loaded from: classes.dex */
public class gh0 extends BaseAdapter implements ListAdapter {

    /* renamed from: O */
    public ArrayList<CardListItem> f2875O = new ArrayList<>();

    /* renamed from: a */
    public void m4134a(CardListItem cardListItem) {
        this.f2875O.add(cardListItem);
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return true;
    }

    /* renamed from: b */
    public void m4135b() {
        this.f2875O.clear();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public CardListItem getItem(int i) {
        return this.f2875O.get(i);
    }

    /* renamed from: d */
    public CardListItem m4137d(int i) {
        Iterator<CardListItem> it = this.f2875O.iterator();
        while (it.hasNext()) {
            CardListItem next = it.next();
            if (next.m5666h() == i) {
                return next;
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2875O.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        CardListItem cardListItem = this.f2875O.get(i);
        if (cardListItem == null) {
            return null;
        }
        return cardListItem.m5668j().getVisibility() != 0 ? new FrameLayout(viewGroup.getContext()) : cardListItem.m5668j();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return true;
    }
}
