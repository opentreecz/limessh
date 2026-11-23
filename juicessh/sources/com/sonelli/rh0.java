package com.sonelli;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.activities.ViewLicenseActivity;
import com.sonelli.juicessh.views.CardListItem;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LicenseCardListAdapter.java */
/* loaded from: classes.dex */
public class rh0 extends gh0 {

    /* renamed from: P */
    public JSONArray f6213P = new JSONArray();

    /* compiled from: LicenseCardListAdapter.java */
    /* renamed from: com.sonelli.rh0$a */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC1818a implements View.OnClickListener {

        /* renamed from: O */
        public final /* synthetic */ Context f6214O;

        /* renamed from: P */
        public final /* synthetic */ int f6215P;

        public ViewOnClickListenerC1818a(Context context, int i) {
            this.f6214O = context;
            this.f6215P = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent(this.f6214O, (Class<?>) ViewLicenseActivity.class);
                intent.putExtra("LICENSE_RESOURCE", this.f6214O.getResources().getIdentifier(rh0.this.f6213P.getJSONObject(this.f6215P).getString("licenseFile"), OrmLiteConfigUtil.RAW_DIR_NAME, this.f6214O.getApplicationInfo().packageName));
                this.f6214O.startActivity(intent);
            } catch (JSONException e) {
                Toast.makeText(this.f6214O, R.string.could_not_load_license, 0).show();
                e.printStackTrace();
            }
        }
    }

    /* renamed from: f */
    public void m7907f(Context context) {
        m4135b();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        CardListItem cardListItem = new CardListItem(context, -1);
        cardListItem.m5678t(context.getString(R.string.about));
        cardListItem.m5667i().setVisibility(8);
        cardListItem.m5665g().setVisibility(8);
        TextView textView = (TextView) layoutInflater.inflate(R.layout.card_text_content, (ViewGroup) null, false);
        textView.setText(R.string.juicessh_uses_the_following_components);
        cardListItem.m5673o(textView);
        m4134a(cardListItem);
        try {
            Scanner scanner = new Scanner(context.getResources().openRawResource(R.raw.licenses));
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
                sb.append("\n");
            }
            JSONObject jSONObject = new JSONObject(sb.toString());
            if (jSONObject.has("components")) {
                this.f6213P = jSONObject.getJSONArray("components");
                gj0.m4141b("LicenseCardListAdapter", "Found " + this.f6213P.length() + " software components");
            }
        } catch (NullPointerException unused) {
            gj0.m4142c("LicenseCardListAdapter", "Failed to open res/raw/licenses.json file due to null context");
        } catch (JSONException e) {
            gj0.m4142c("LicenseCardListAdapter", "Failed to open res/raw/licenses.json file");
            e.printStackTrace();
        }
        for (int i = 0; i < this.f6213P.length(); i++) {
            try {
                CardListItem cardListItem2 = new CardListItem(context, i);
                cardListItem2.m5678t(this.f6213P.getJSONObject(i).getString("name"));
                cardListItem2.m5677s(this.f6213P.getJSONObject(i).getString("author") + " / " + this.f6213P.getJSONObject(i).getString("licenseName"));
                cardListItem2.m5674p(R.string.icon_link);
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.license_card_content, (ViewGroup) null, false);
                ((TextView) linearLayout.findViewById(R.id.description)).setText(this.f6213P.getJSONObject(i).getString("description"));
                cardListItem2.m5672n(linearLayout.getResources().getString(R.string.view_license));
                cardListItem2.m5671m(new ViewOnClickListenerC1818a(context, i));
                cardListItem2.m5673o(linearLayout);
                m4134a(cardListItem2);
            } catch (NullPointerException unused2) {
                gj0.m4142c("LicenseCardListAdapter", "Tried to initiate license card with an invalid context");
                return;
            } catch (JSONException unused3) {
                gj0.m4142c("LicenseCardListAdapter", "Tried to initiate license card with an invalid JSON descriptor");
                return;
            }
        }
    }
}
