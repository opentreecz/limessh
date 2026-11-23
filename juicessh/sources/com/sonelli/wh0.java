package com.sonelli;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.text.format.DateUtils;
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
import com.sonelli.juicessh.models.User;
import com.sonelli.juicessh.p002db.BaseModel;
import com.sonelli.juicessh.p002db.C1328DB;
import com.squareup.picasso.Picasso;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: TeamMemberListAdapter.java */
/* loaded from: classes.dex */
public class wh0 extends BaseAdapter implements ListAdapter {

    /* renamed from: O */
    public LayoutInflater f7702O;

    /* renamed from: P */
    public Context f7703P;

    /* renamed from: Q */
    public AlertDialog.Builder f7704Q;

    /* renamed from: R */
    public Team f7705R;

    /* renamed from: S */
    public xh0 f7706S;

    /* renamed from: T */
    public List<TeamMembership> f7707T;

    /* compiled from: TeamMemberListAdapter.java */
    /* renamed from: com.sonelli.wh0$a */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnClickListenerC2222a implements DialogInterface.OnClickListener {

        /* renamed from: O */
        public final /* synthetic */ int f7708O;

        public DialogInterfaceOnClickListenerC2222a(int i) {
            this.f7708O = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                C1328DB.m5404d(TeamMembership.class, wh0.this.f7703P).delete((BaseModel) wh0.this.f7707T.get(this.f7708O));
                wh0.this.f7707T.remove(this.f7708O);
                wh0.this.f7706S.notifyDataSetChanged();
            } catch (SQLException e) {
                gj0.m4142c("Adapters/InviteListAdapter", "Could not remove user from team: " + e.getMessage());
            }
        }
    }

    /* compiled from: TeamMemberListAdapter.java */
    /* renamed from: com.sonelli.wh0$b */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC2223b implements View.OnClickListener {

        /* renamed from: O */
        public final /* synthetic */ AlertDialog f7710O;

        public ViewOnClickListenerC2223b(AlertDialog alertDialog) {
            this.f7710O = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((Activity) wh0.this.f7703P).isFinishing()) {
                return;
            }
            this.f7710O.show();
        }
    }

    public wh0(User user, Team team, xh0 xh0Var, Context context) {
        this.f7707T = new ArrayList();
        this.f7706S = xh0Var;
        this.f7703P = context;
        this.f7705R = team;
        try {
            this.f7707T = C1328DB.m5404d(TeamMembership.class, context).queryForEq("team_id", team);
        } catch (SQLException e) {
            gj0.m4142c("Adapters/InviteListAdapter", "Failed to fetch team members: " + e.getMessage());
        }
        Collections.sort(this.f7707T);
        this.f7704Q = new AlertDialog.Builder(context);
        this.f7702O = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7707T.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f7707T.get(i);
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
        String str;
        String str2;
        if (view == null) {
            view = this.f7702O.inflate(R.layout.team_member_menu_item, (ViewGroup) null, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.itemTitle);
        TextView textView2 = (TextView) view.findViewById(R.id.itemSubtitle);
        ImageView imageView = (ImageView) view.findViewById(R.id.itemIcon);
        Button button = (Button) view.findViewById(R.id.respond_button);
        button.setVisibility(8);
        if (this.f7707T.get(i).user == null || this.f7707T.get(i).user.m5383m() == null || !this.f7707T.get(i).accepted) {
            str = this.f7707T.get(i).email;
            textView2.setText(this.f7703P.getResources().getString(R.string.invited_capital_i) + " " + ((Object) DateUtils.getRelativeTimeSpanString(this.f7707T.get(i).modified)));
            str2 = null;
        } else {
            str = this.f7707T.get(i).user.name;
            str2 = this.f7707T.get(i).user.picture;
            if (this.f7707T.get(i).accepted) {
                textView2.setText(this.f7703P.getResources().getString(R.string.last_seen) + " " + ((Object) DateUtils.getRelativeTimeSpanString(this.f7707T.get(i).user.modified)));
            } else {
                textView2.setText(this.f7703P.getResources().getString(R.string.invited_capital_i) + " " + ((Object) DateUtils.getRelativeTimeSpanString(this.f7707T.get(i).modified)));
            }
        }
        textView.setText(str);
        this.f7704Q.setTitle(this.f7703P.getString(R.string.remove_team_member));
        this.f7704Q.setMessage(String.format(this.f7703P.getString(R.string.are_you_sure_you_want_to_remove_x), str));
        this.f7704Q.setCancelable(true);
        this.f7704Q.setPositiveButton(this.f7703P.getString(R.string.yes), new DialogInterfaceOnClickListenerC2222a(i));
        this.f7704Q.setNegativeButton(this.f7703P.getString(R.string.f3673no), (DialogInterface.OnClickListener) null);
        button.setOnClickListener(new ViewOnClickListenerC2223b(this.f7704Q.create()));
        if (str2 != null) {
            vl0 m10685j = Picasso.m10676n(this.f7703P).m10685j(str2);
            m10685j.m9311i(new uk0());
            m10685j.m9307e(imageView);
        }
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
        return this.f7707T.size() < 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return true;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        try {
            this.f7707T = C1328DB.m5404d(TeamMembership.class, this.f7703P).queryForEq("team_id", this.f7705R);
        } catch (SQLException e) {
            gj0.m4142c("Adapters/InviteListAdapter", "Failed to fetch team members: " + e.getMessage());
        }
        Collections.sort(this.f7707T);
        super.notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }
}
