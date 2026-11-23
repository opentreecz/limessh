package cz.opentree.limessh.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.format.DateUtils;
import android.widget.TextView;
import cz.opentree.limessh.R;
import cz.opentree.util.Session;

/* loaded from: classes.dex */
public class LockoutActivity extends Activity {

    /* renamed from: O */
    public TextView f3730O;

    /* renamed from: P */
    public CountDownTimer f3731P;

    /* renamed from: cz.opentree.limessh.activities.LockoutActivity$a */
    /* loaded from: classes.dex */
    public class CountDownTimerC1252a extends CountDownTimer {
        public CountDownTimerC1252a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            LockoutActivity.this.finish();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            LockoutActivity.this.f3730O.setText(String.format(LockoutActivity.this.getString(R.string.too_many_incorrect_security_lock_attempts), DateUtils.getRelativeTimeSpanString(System.currentTimeMillis() + j + 60000)));
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.lockout);
        this.f3730O = (TextView) findViewById(R.id.subtitle);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f3731P.cancel();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Long valueOf = Long.valueOf(300000 - Long.valueOf(System.currentTimeMillis() - Long.valueOf(Session.m9046g().m9049h().m10495d(this)).longValue()).longValue());
        if (valueOf.longValue() <= 0) {
            finish();
        }
        this.f3731P = new CountDownTimerC1252a(valueOf.longValue(), 1000L).start();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
    }
}
