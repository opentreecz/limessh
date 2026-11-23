package cz.opentree;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.ec2link.Ec2Profile;
import java.util.UUID;

/* compiled from: Ec2SyncProgressReceiver.java */
/* loaded from: classes.dex */
public class tj0 extends BroadcastReceiver {

    /* renamed from: a */
    public ListView f6789a;

    public tj0(ListView listView) {
        this.f6789a = listView;
    }

    /* renamed from: a */
    public static void m8703a(Context context, UUID uuid, String str, boolean z) {
        Intent intent = new Intent("cz.opentree.juicessh.ec2sync.progress");
        if (z) {
            intent.putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, 8);
        } else {
            intent.putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, 7);
        }
        intent.putExtra("ec2profile_id", uuid);
        intent.putExtra("failReason", str);
        context.sendBroadcast(intent);
    }

    /* renamed from: b */
    public static void m8704b(Context context, UUID uuid, int i) {
        Intent intent = new Intent("cz.opentree.juicessh.ec2sync.progress");
        intent.putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, 6);
        intent.putExtra("ec2profile_id", uuid);
        intent.putExtra("connection_count", i);
        context.sendBroadcast(intent);
    }

    /* renamed from: c */
    public static void m8705c(Context context, UUID uuid, int i) {
        Intent intent = new Intent("cz.opentree.juicessh.ec2sync.progress");
        intent.putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, 3);
        intent.putExtra("ec2profile_id", uuid);
        intent.putExtra("items_processed", i);
        context.sendBroadcast(intent);
    }

    /* renamed from: d */
    public static void m8706d(Context context, UUID uuid, int i) {
        Intent intent = new Intent("cz.opentree.juicessh.ec2sync.progress");
        intent.putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, i);
        intent.putExtra("ec2profile_id", uuid);
        context.sendBroadcast(intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        int i;
        View view;
        try {
            extras = intent.getExtras();
            i = extras.getInt(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE);
            UUID uuid = (UUID) extras.get("ec2profile_id");
            view = null;
            int i2 = 0;
            while (true) {
                if (i2 >= this.f6789a.getChildCount()) {
                    break;
                }
                View childAt = this.f6789a.getChildAt(i2);
                if (((Ec2Profile) this.f6789a.getAdapter().getItem(i2)).f3993id.equals(uuid)) {
                    view = childAt;
                    break;
                }
                i2++;
            }
        } catch (NullPointerException unused) {
        }
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.itemSubtitle);
        switch (i) {
            case 1:
                textView.setText(context.getString(R.string.starting_backup));
                return;
            case 2:
                textView.setText(context.getString(R.string.contacting_amazon_api));
                return;
            case 3:
                int i3 = extras.getInt("items_processed");
                if (i3 == 0) {
                    textView.setText(context.getString(R.string.processing_items));
                    return;
                }
                textView.setText(context.getString(R.string.processing_items) + i3);
                return;
            case 4:
                textView.setText(context.getString(R.string.importing_items));
                return;
            case 5:
                textView.setText(context.getString(R.string.cleaning_old_items));
                return;
            case 6:
                long currentTimeMillis = System.currentTimeMillis();
                String formatDateTime = DateUtils.formatDateTime(context, currentTimeMillis, 16);
                String formatDateTime2 = DateUtils.formatDateTime(context, currentTimeMillis, 1);
                try {
                    int i4 = extras.getInt("connection_count");
                    if (i4 != 1) {
                        textView.setText(String.format(context.getString(R.string.items_synced_on), Integer.valueOf(i4), formatDateTime, formatDateTime2));
                    } else {
                        textView.setText(String.format(context.getString(R.string.item_synced_on), Integer.valueOf(i4), formatDateTime, formatDateTime2));
                    }
                    return;
                } catch (NullPointerException unused2) {
                    textView.setText(String.format(context.getString(R.string.last_sync), formatDateTime, formatDateTime2));
                    return;
                }
            case 7:
                String str = "";
                try {
                    str = extras.getString("failReason");
                } catch (NullPointerException unused3) {
                }
                textView.setText(String.format(context.getString(R.string.sync_failed), str));
                return;
            case 8:
                String string = context.getString(R.string.disabled);
                try {
                    string = string + ": " + extras.getString("failReason");
                } catch (NullPointerException unused4) {
                }
                textView.setText(String.format(string, new Object[0]));
                return;
            default:
                return;
        }
    }
}
