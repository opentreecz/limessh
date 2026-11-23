package cz.opentree.limessh.services;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.vending.billing.IInAppBillingService;
import cz.opentree.gj0;
import cz.opentree.limessh.R;
import cz.opentree.limessh.activities.MainActivity;
import cz.opentree.limessh.activities.ThankYouForPurchasingActivity;
import cz.opentree.limessh.models.Purchase;
import cz.opentree.limessh.models.User;
import cz.opentree.limessh.widgets.ConnectionWidgetProvider;
import cz.opentree.pi0;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class BillingService implements ServiceConnection {

    /* renamed from: a */
    public OnServiceConnectedListener f4154a;

    /* renamed from: b */
    public IInAppBillingService f4155b;

    /* renamed from: c */
    public Activity f4156c;

    /* loaded from: classes.dex */
    public interface OnServiceConnectedListener {
        void onConnected();
    }

    /* renamed from: cz.opentree.limessh.services.BillingService$a */
    /* loaded from: classes.dex */
    public class C1365a extends pi0.AbstractC1720p {

        /* renamed from: a */
        public final /* synthetic */ Purchase f4157a;

        /* renamed from: cz.opentree.limessh.services.BillingService$a$a */
        /* loaded from: classes.dex */
        public class a extends pi0.AbstractC1718n {

            /* renamed from: cz.opentree.limessh.services.BillingService$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC2494a implements Runnable {
                public RunnableC2494a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        BillingService.this.m5618f().mo711M0(3, BillingService.this.f4156c.getPackageName(), C1365a.this.f4157a.token);
                        Intent intent = new Intent(BillingService.this.f4156c, (Class<?>) ConnectionWidgetProvider.class);
                        intent.setAction(ConnectionWidgetProvider.f4385b);
                        LocalBroadcastManager.getInstance(BillingService.this.f4156c).sendBroadcast(intent);
                        Intent intent2 = new Intent(BillingService.this.f4156c, (Class<?>) MainActivity.class);
                        intent2.setFlags(268468224);
                        BillingService.this.f4156c.startActivity(intent2);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    } catch (C1366b e2) {
                        e2.printStackTrace();
                    }
                }
            }

            public a() {
            }

            @Override // cz.opentree.pi0.AbstractC1718n
            /* renamed from: a */
            public void mo5421a() {
                super.mo5421a();
                gj0.m4142c("Services/Billing", "Failed to submit purchase to API");
                Toast.makeText(BillingService.this.f4156c, BillingService.this.f4156c.getString(R.string.failed_to_verify_purchase_with_api), 0).show();
            }

            @Override // cz.opentree.pi0.AbstractC1718n
            /* renamed from: c */
            public void mo5422c() {
                super.mo5422c();
                new Thread(new RunnableC2494a()).start();
            }
        }

        public C1365a(Purchase purchase) {
            this.f4157a = purchase;
        }

        @Override // cz.opentree.pi0.AbstractC1720p
        /* renamed from: b */
        public void mo3229b(User user) {
            super.mo3229b(user);
            pi0.m7337p(BillingService.this.f4156c, this.f4157a, user, new a());
        }
    }

    /* renamed from: cz.opentree.limessh.services.BillingService$b */
    /* loaded from: classes.dex */
    public static class C1366b extends Exception {
        public C1366b(String str) {
            super(str);
        }
    }

    /* renamed from: cz.opentree.limessh.services.BillingService$c */
    /* loaded from: classes.dex */
    public class C1367c {

        /* renamed from: a */
        public String f4161a;

        public C1367c(BillingService billingService) {
        }
    }

    public BillingService(Activity activity) {
        this.f4156c = activity;
    }

    /* renamed from: b */
    public void m5614b() throws C1366b {
        try {
            Bundle mo714j0 = m5618f().mo714j0(3, this.f4156c.getPackageName(), "inapp", null);
            if (mo714j0.getInt("RESPONSE_CODE") == 0) {
                ArrayList<String> stringArrayList = mo714j0.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList2 = mo714j0.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                for (int i = 0; i < stringArrayList.size(); i++) {
                    if (new Purchase(stringArrayList.get(i), stringArrayList2.get(i)).state.intValue() == 0) {
                        this.f4156c.startActivity(new Intent(this.f4156c, (Class<?>) ThankYouForPurchasingActivity.class));
                        return;
                    }
                }
            }
        } catch (RemoteException e) {
            throw new C1366b(e.getMessage());
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: c */
    public void m5615c(OnServiceConnectedListener onServiceConnectedListener) {
        this.f4154a = onServiceConnectedListener;
        ResolveInfo resolveService = this.f4156c.getPackageManager().resolveService(new Intent("com.android.vending.billing.InAppBillingService.BIND"), 0);
        if (resolveService == null) {
            gj0.m4142c("Services/Billing", "Could not look up explicit intent for com.android.vending.billing.InAppBillingService.BIND service");
            return;
        }
        Intent intent = new Intent();
        ServiceInfo serviceInfo = resolveService.serviceInfo;
        intent.setComponent(new ComponentName(serviceInfo.packageName, serviceInfo.name));
        this.f4156c.getApplicationContext().bindService(intent, this, 1);
    }

    /* renamed from: d */
    public void m5616d(String str) throws C1366b {
        try {
            Bundle mo714j0 = m5618f().mo714j0(3, this.f4156c.getPackageName(), "inapp", null);
            if (mo714j0.getInt("RESPONSE_CODE") == 0) {
                ArrayList<String> stringArrayList = mo714j0.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList2 = mo714j0.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                for (int i = 0; i < stringArrayList.size(); i++) {
                    Purchase purchase = new Purchase(stringArrayList.get(i), stringArrayList2.get(i));
                    if (purchase.state.intValue() == 0) {
                        User.m5527u(this.f4156c);
                        pi0.m7335n(this.f4156c);
                        User.m5519B(str, this.f4156c);
                        pi0.m7331j(this.f4156c, new C1365a(purchase));
                    }
                }
            }
        } catch (RemoteException e) {
            throw new C1366b(e.getMessage());
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: e */
    public void m5617e() {
        if (this.f4155b != null) {
            try {
                this.f4156c.getApplicationContext().unbindService(this);
            } catch (IllegalArgumentException unused) {
                gj0.m4141b("Services/Billing", "Could not unbind from billing service as it was never bound");
            }
            this.f4155b = null;
        }
    }

    /* renamed from: f */
    public IInAppBillingService m5618f() throws C1366b {
        IInAppBillingService iInAppBillingService = this.f4155b;
        if (iInAppBillingService != null) {
            return iInAppBillingService;
        }
        throw new C1366b("Billing service is not connected");
    }

    /* renamed from: g */
    public C1367c m5619g(String str) throws C1366b {
        try {
            Bundle bundle = new Bundle();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            Bundle mo713g0 = m5618f().mo713g0(3, this.f4156c.getPackageName(), "inapp", bundle);
            if (mo713g0.getInt("RESPONSE_CODE") != 0) {
                throw new C1366b("Unable to retrieve product information from Play Store");
            }
            ArrayList<String> stringArrayList = mo713g0.getStringArrayList("DETAILS_LIST");
            if (stringArrayList == null || stringArrayList.size() <= 0) {
                throw new C1366b("Unable to find product: " + str);
            }
            JSONObject jSONObject = new JSONObject(stringArrayList.get(0));
            C1367c c1367c = new C1367c(this);
            jSONObject.getString("productId");
            jSONObject.getString("title");
            jSONObject.getString(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE);
            jSONObject.getString("description");
            c1367c.f4161a = jSONObject.getString("price");
            jSONObject.getString("price_amount_micros");
            jSONObject.getString("price_currency_code");
            return c1367c;
        } catch (RemoteException e) {
            throw new C1366b(e.getMessage());
        } catch (JSONException unused) {
            throw new C1366b("Unable to parse Play Store response when requesting information about " + str);
        }
    }

    /* renamed from: h */
    public void m5620h(String str, int i) throws C1366b {
        try {
            Bundle mo712V = m5618f().mo712V(3, this.f4156c.getPackageName(), str, "inapp", null);
            if (mo712V.getInt("RESPONSE_CODE") == 0) {
                this.f4156c.startIntentSenderForResult(((PendingIntent) mo712V.getParcelable("BUY_INTENT")).getIntentSender(), i, new Intent(), 0, 0, 0);
            } else {
                gj0.m4142c("Services/Billing", "Unable to process purchase request - error code " + mo712V.getInt("RESPONSE_CODE"));
                throw new C1366b("Unable to process purchase request");
            }
        } catch (IntentSender.SendIntentException e) {
            throw new C1366b(e.getMessage());
        } catch (RemoteException e2) {
            throw new C1366b(e2.getMessage());
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f4155b = IInAppBillingService.AbstractBinderC0415a.m715q(iBinder);
        OnServiceConnectedListener onServiceConnectedListener = this.f4154a;
        if (onServiceConnectedListener != null) {
            onServiceConnectedListener.onConnected();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f4155b = null;
    }
}
