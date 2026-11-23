package cz.opentree;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.widget.ExpandableListAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: AbstractExpandableListAdapter.java */
/* loaded from: classes.dex */
public abstract class dh0<A, B> implements ExpandableListAdapter {

    /* renamed from: a */
    public List<Map.Entry<A, List<B>>> f2170a;

    /* renamed from: b */
    public final DataSetObservable f2171b = new DataSetObservable();

    /* renamed from: c */
    public final Context f2172c;

    /* renamed from: d */
    public final Integer f2173d;

    /* renamed from: e */
    public final Integer f2174e;

    /* renamed from: f */
    public final Integer f2175f;

    /* renamed from: g */
    public final LayoutInflater f2176g;

    public dh0(Context context, int i, int i2, int i3) {
        this.f2170a = new ArrayList();
        this.f2172c = context;
        this.f2170a = new ArrayList();
        this.f2173d = Integer.valueOf(i);
        this.f2174e = Integer.valueOf(i2);
        this.f2175f = Integer.valueOf(i3);
        this.f2176g = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public void m3202a(Map.Entry<A, List<B>> entry) {
        m3208g().add(entry);
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean areAllItemsEnabled() {
        return true;
    }

    /* renamed from: b */
    public void m3203b() {
        m3208g().clear();
        m3209h();
    }

    /* renamed from: c */
    public Integer m3204c() {
        return this.f2175f;
    }

    /* renamed from: d */
    public DataSetObservable m3205d() {
        return this.f2171b;
    }

    /* renamed from: e */
    public Integer m3206e() {
        return this.f2173d;
    }

    /* renamed from: f */
    public Integer m3207f() {
        return this.f2174e;
    }

    /* renamed from: g */
    public List<Map.Entry<A, List<B>>> m3208g() {
        return this.f2170a;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return m3208g().get(i).getValue().get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return Integer.valueOf(i2).longValue();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return m3208g().get(i).getValue().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getCombinedChildId(long j, long j2) {
        return (j * 10000) + j2;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getCombinedGroupId(long j) {
        return j * 10000;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return m3208g().get(i).getKey();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return m3208g().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return Integer.valueOf(i).longValue();
    }

    /* renamed from: h */
    public void m3209h() {
        m3205d().notifyChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isEmpty() {
        return m3208g().size() == 0;
    }

    @Override // android.widget.ExpandableListAdapter
    public void onGroupCollapsed(int i) {
    }

    @Override // android.widget.ExpandableListAdapter
    public void onGroupExpanded(int i) {
    }

    @Override // android.widget.ExpandableListAdapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        m3205d().registerObserver(dataSetObserver);
    }

    @Override // android.widget.ExpandableListAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        m3205d().unregisterObserver(dataSetObserver);
    }
}
