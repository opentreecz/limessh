package cz.opentree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.User;
import com.squareup.picasso.Picasso;
import java.util.List;

/* compiled from: SpinnerArrayAdapter.java */
/* loaded from: classes.dex */
public class vh0<ITEM> extends BaseAdapter implements SpinnerAdapter {

    /* renamed from: O */
    public Context f7460O;

    /* renamed from: P */
    public List<ITEM> f7461P;

    /* renamed from: Q */
    public LayoutInflater f7462Q;

    /* renamed from: R */
    public boolean f7463R = false;

    public vh0(Context context, List<ITEM> list) {
        this.f7460O = context;
        this.f7461P = list;
        this.f7462Q = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    public void m9224a(List<ITEM> list) {
        this.f7461P.addAll(list);
    }

    /* renamed from: b */
    public int m9225b() {
        return this.f7461P.size();
    }

    /* renamed from: c */
    public void m9226c() {
        this.f7461P.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<ITEM> list = this.f7461P;
        return (list == null || list.size() == 0) ? this.f7463R ? 1 : 2 : this.f7463R ? this.f7461P.size() : this.f7461P.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f7461P.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return -1L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f7462Q.inflate(R.layout.spinner_item, (ViewGroup) null, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.itemTitle);
        ImageView imageView = (ImageView) view.findViewById(R.id.itemIcon);
        imageView.setImageResource(R.drawable.ic_contact_picture);
        imageView.setVisibility(8);
        List<ITEM> list = this.f7461P;
        if (list == null || (i == 0 && list.size() == 0)) {
            textView.setText(this.f7460O.getResources().getString(R.string.select_one) + "...");
            return view;
        }
        if (!this.f7463R && ((this.f7461P.size() == 0 && i == this.f7461P.size() + 1) || (this.f7461P.size() > 0 && i == this.f7461P.size()))) {
            textView.setText(this.f7460O.getResources().getString(R.string._new) + "...");
            return view;
        }
        Object obj = this.f7461P.size() > 0 ? this.f7461P.get(i) : this.f7461P.get(i - 1);
        textView.setText(obj.toString());
        if (obj.getClass().getName().equals("cz.opentree.juicessh.models.User")) {
            User user = (User) obj;
            imageView.setVisibility(0);
            if (user.picture != null) {
                Picasso.m10676n(this.f7460O).m10685j(user.picture).m9307e(imageView);
            }
        }
        return view;
    }
}
