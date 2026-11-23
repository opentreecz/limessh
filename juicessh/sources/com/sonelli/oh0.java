package com.sonelli;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.models.Team;
import com.sonelli.juicessh.models.TeamMembership;
import com.sonelli.juicessh.services.CloudSync;
import com.squareup.picasso.Picasso;
import java.util.Collections;
import java.util.List;

/* compiled from: InviteListAdapter.java */
/* loaded from: classes.dex */
public class oh0 extends BaseAdapter implements ListAdapter {

    /* renamed from: O */
    public LayoutInflater f5486O;

    /* renamed from: P */
    public Context f5487P;

    /* renamed from: Q */
    public vk0 f5488Q;

    /* renamed from: R */
    public xh0 f5489R;

    /* renamed from: S */
    public List<TeamMembership> f5490S;

    /* compiled from: InviteListAdapter.java */
    /* renamed from: com.sonelli.oh0$a */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC1655a implements DialogInterface.OnClickListener {

        /* renamed from: O */
        public final /* synthetic */ int f5491O;

        /* compiled from: InviteListAdapter.java */
        /* renamed from: com.sonelli.oh0$a$a */
        /* loaded from: classes.dex */
        public class a extends CloudSync.AbstractC1376i {
            public a() {
            }

            @Override // com.sonelli.juicessh.services.CloudSync.AbstractC1376i
            /* renamed from: a */
            public void mo5314a() {
                super.mo5314a();
                oh0.this.f5489R.notifyDataSetChanged();
            }
        }

        public DialogInterfaceOnClickListenerC1655a(int i) {
            this.f5491O = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ((TeamMembership) oh0.this.f5490S.get(this.f5491O)).m5517v(true, oh0.this.f5487P, new a());
            oh0.this.f5490S.remove(this.f5491O);
            oh0.this.f5489R.notifyDataSetChanged();
        }
    }

    /* compiled from: InviteListAdapter.java */
    /* renamed from: com.sonelli.oh0$b */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC1656b implements DialogInterface.OnClickListener {

        /* renamed from: O */
        public final /* synthetic */ int f5494O;

        /* compiled from: InviteListAdapter.java */
        /* renamed from: com.sonelli.oh0$b$a */
        /* loaded from: classes.dex */
        public class a extends CloudSync.AbstractC1376i {
            public a() {
            }

            @Override // com.sonelli.juicessh.services.CloudSync.AbstractC1376i
            /* renamed from: a */
            public void mo5314a() {
                super.mo5314a();
                oh0.this.f5489R.notifyDataSetChanged();
            }
        }

        public DialogInterfaceOnClickListenerC1656b(int i) {
            this.f5494O = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ((TeamMembership) oh0.this.f5490S.get(this.f5494O)).m5517v(false, oh0.this.f5487P, new a());
            oh0.this.f5490S.remove(this.f5494O);
            oh0.this.f5489R.notifyDataSetChanged();
        }
    }

    /* compiled from: InviteListAdapter.java */
    /* renamed from: com.sonelli.oh0$c */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1657c implements View.OnClickListener {

        /* renamed from: O */
        public final /* synthetic */ AlertDialog f5497O;

        public ViewOnClickListenerC1657c(AlertDialog alertDialog) {
            this.f5497O = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((Activity) oh0.this.f5487P).isFinishing()) {
                return;
            }
            this.f5497O.show();
        }
    }

    public oh0(List<TeamMembership> list, xh0 xh0Var, Context context) {
        Collections.sort(list);
        this.f5487P = context;
        this.f5490S = list;
        this.f5489R = xh0Var;
        this.f5488Q = new vk0(context);
        this.f5486O = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5490S.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f5490S.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5486O.inflate(R.layout.invite_menu_item, (ViewGroup) null, false);
        }
        TeamMembership teamMembership = this.f5490S.get(i);
        if (teamMembership == null) {
            view.setVisibility(8);
            return view;
        }
        Team team = teamMembership.team;
        if (team == null) {
            view.setVisibility(8);
            return view;
        }
        if (team.m5383m() == null) {
            view.setVisibility(8);
            return view;
        }
        TextView textView = (TextView) view.findViewById(R.id.itemTitle);
        TextView textView2 = (TextView) view.findViewById(R.id.itemSubtitle);
        ImageView imageView = (ImageView) view.findViewById(R.id.itemIcon);
        Button button = (Button) view.findViewById(R.id.respond_button);
        this.f5488Q.m9297j(this.f5487P.getString(R.string.teamshare_invite));
        this.f5488Q.m9295h(String.format(this.f5487P.getString(R.string.do_you_want_to_join_team), this.f5490S.get(i).team.m5383m().name));
        this.f5488Q.setCancelable(true);
        this.f5488Q.setPositiveButton(this.f5487P.getString(R.string.accept), new DialogInterfaceOnClickListenerC1655a(i));
        this.f5488Q.setNegativeButton(this.f5487P.getString(R.string.reject), new DialogInterfaceOnClickListenerC1656b(i));
        button.setOnClickListener(new ViewOnClickListenerC1657c(this.f5488Q.create()));
        if (this.f5490S.get(i).owner == null || this.f5490S.get(i).owner.m5383m() == null) {
            gj0.m4142c("Adapters/InviteListAdapter", "Got an invite - but not the associated user that invited us");
            this.f5490S.remove(i);
            notifyDataSetChanged();
            return null;
        }
        textView.setText(this.f5490S.get(i).owner.m5383m().name);
        textView2.setText(this.f5487P.getResources().getString(R.string.invited_you_to) + " " + this.f5490S.get(i).team.m5383m().name);
        vl0 m10685j = Picasso.m10676n(this.f5487P).m10685j(this.f5490S.get(i).owner.m5383m().picture);
        m10685j.m9311i(new uk0());
        m10685j.m9307e(imageView);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.f5490S.size() < 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }
}
