package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsReceiver;
import com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.report.ReportUploader;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.unity.UnityVersionProvider;
import com.sonelli.c90;
import com.sonelli.d90;
import com.sonelli.db0;
import com.sonelli.e90;
import com.sonelli.g90;
import com.sonelli.h90;
import com.sonelli.j60;
import com.sonelli.j90;
import com.sonelli.jc0;
import com.sonelli.k60;
import com.sonelli.k90;
import com.sonelli.m80;
import com.sonelli.o90;
import com.sonelli.ob0;
import com.sonelli.pb0;
import com.sonelli.q80;
import com.sonelli.q90;
import com.sonelli.qb0;
import com.sonelli.r90;
import com.sonelli.sb0;
import com.sonelli.sc0;
import com.sonelli.t80;
import com.sonelli.u80;
import com.sonelli.uc0;
import com.sonelli.v80;
import com.sonelli.vb0;
import com.sonelli.vc0;
import com.sonelli.w80;
import com.sonelli.wb0;
import com.sonelli.x80;
import com.sonelli.xa0;
import com.sonelli.xb0;
import com.sonelli.y80;
import com.sonelli.yb0;
import com.sonelli.z80;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class CrashlyticsController {

    /* renamed from: a */
    public final Context f1130a;

    /* renamed from: b */
    public final c90 f1131b;

    /* renamed from: c */
    public final z80 f1132c;

    /* renamed from: d */
    public final q90 f1133d;

    /* renamed from: e */
    public final x80 f1134e;

    /* renamed from: f */
    public final db0 f1135f;

    /* renamed from: g */
    public final h90 f1136g;

    /* renamed from: h */
    public final FileStore f1137h;

    /* renamed from: i */
    public final q80 f1138i;

    /* renamed from: j */
    public final ReportUploader.Provider f1139j;

    /* renamed from: k */
    public final C0655y f1140k;

    /* renamed from: l */
    public final LogFileManager f1141l;

    /* renamed from: m */
    public final sb0 f1142m;

    /* renamed from: n */
    public final ReportUploader.HandlingExceptionCheck f1143n;

    /* renamed from: o */
    public final CrashlyticsNativeComponent f1144o;

    /* renamed from: p */
    public final StackTraceTrimmingStrategy f1145p;

    /* renamed from: q */
    public final String f1146q;

    /* renamed from: r */
    public final AnalyticsReceiver f1147r;

    /* renamed from: s */
    public final AnalyticsConnector f1148s;

    /* renamed from: t */
    public final o90 f1149t;

    /* renamed from: u */
    public CrashlyticsUncaughtExceptionHandler f1150u;

    /* renamed from: v */
    public k60<Boolean> f1151v;

    /* renamed from: w */
    public k60<Boolean> f1152w;

    /* renamed from: x */
    public k60<Void> f1153x;

    /* renamed from: y */
    public static final FilenameFilter f1128y = new C0638h("BeginSession");

    /* renamed from: z */
    public static final FilenameFilter f1129z = new C0643m();

    /* renamed from: A */
    public static final Comparator<File> f1123A = new C0644n();

    /* renamed from: B */
    public static final Comparator<File> f1124B = new C0645o();

    /* renamed from: C */
    public static final Pattern f1125C = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");

    /* renamed from: D */
    public static final Map<String, String> f1126D = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");

    /* renamed from: E */
    public static final String[] f1127E = {"SessionUser", "SessionApp", "SessionOS", "SessionDevice"};

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes.dex */
    public interface CodedOutputStreamWriteAction {
        /* renamed from: a */
        void mo1719a(pb0 pb0Var) throws Exception;
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$a */
    /* loaded from: classes.dex */
    public class CallableC0628a implements Callable<Void> {

        /* renamed from: a */
        public final /* synthetic */ long f1154a;

        /* renamed from: b */
        public final /* synthetic */ String f1155b;

        public CallableC0628a(long j, String str) {
            this.f1154a = j;
            this.f1155b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            if (CrashlyticsController.this.m1693b0()) {
                return null;
            }
            CrashlyticsController.this.f1141l.m1757i(this.f1154a, this.f1155b);
            return null;
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$a0 */
    /* loaded from: classes.dex */
    public final class C0629a0 implements ReportUploader.HandlingExceptionCheck {
        public C0629a0() {
        }

        public /* synthetic */ C0629a0(CrashlyticsController crashlyticsController, C0638h c0638h) {
            this();
        }

        @Override // com.google.firebase.crashlytics.internal.report.ReportUploader.HandlingExceptionCheck
        /* renamed from: a */
        public boolean mo1721a() {
            return CrashlyticsController.this.m1693b0();
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$b */
    /* loaded from: classes.dex */
    public class CallableC0630b implements Callable<Void> {
        public CallableC0630b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            CrashlyticsController.this.m1676H();
            return null;
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$b0 */
    /* loaded from: classes.dex */
    public static final class RunnableC0631b0 implements Runnable {

        /* renamed from: O */
        public final Context f1159O;

        /* renamed from: P */
        public final Report f1160P;

        /* renamed from: Q */
        public final ReportUploader f1161Q;

        /* renamed from: R */
        public final boolean f1162R;

        public RunnableC0631b0(Context context, Report report, ReportUploader reportUploader, boolean z) {
            this.f1159O = context;
            this.f1160P = report;
            this.f1161Q = reportUploader;
            this.f1162R = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (w80.m9424c(this.f1159O)) {
                m80.m6375f().m6377b("Attempting to send crash report at time of crash...");
                this.f1161Q.m1832d(this.f1160P, this.f1162R);
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$c */
    /* loaded from: classes.dex */
    public class RunnableC0632c implements Runnable {
        public RunnableC0632c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CrashlyticsController crashlyticsController = CrashlyticsController.this;
            crashlyticsController.m1671E(crashlyticsController.m1696e0(new C0654x()));
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$c0 */
    /* loaded from: classes.dex */
    public static class C0633c0 implements FilenameFilter {

        /* renamed from: a */
        public final String f1164a;

        public C0633c0(String str) {
            this.f1164a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1164a);
            sb.append(".cls");
            return (str.equals(sb.toString()) || !str.contains(this.f1164a) || str.endsWith(".cls_temp")) ? false : true;
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$d */
    /* loaded from: classes.dex */
    public class C0634d implements FilenameFilter {

        /* renamed from: a */
        public final /* synthetic */ Set f1165a;

        public C0634d(CrashlyticsController crashlyticsController, Set set) {
            this.f1165a = set;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if (str.length() < 35) {
                return false;
            }
            return this.f1165a.contains(str.substring(0, 35));
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$e */
    /* loaded from: classes.dex */
    public class C0635e implements CodedOutputStreamWriteAction {

        /* renamed from: a */
        public final /* synthetic */ String f1166a;

        /* renamed from: b */
        public final /* synthetic */ String f1167b;

        /* renamed from: c */
        public final /* synthetic */ long f1168c;

        public C0635e(CrashlyticsController crashlyticsController, String str, String str2, long j) {
            this.f1166a = str;
            this.f1167b = str2;
            this.f1168c = j;
        }

        @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsController.CodedOutputStreamWriteAction
        /* renamed from: a */
        public void mo1719a(pb0 pb0Var) throws Exception {
            qb0.m7662p(pb0Var, this.f1166a, this.f1167b, this.f1168c);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$f */
    /* loaded from: classes.dex */
    public class C0636f implements CodedOutputStreamWriteAction {

        /* renamed from: a */
        public final /* synthetic */ String f1169a;

        /* renamed from: b */
        public final /* synthetic */ String f1170b;

        /* renamed from: c */
        public final /* synthetic */ String f1171c;

        /* renamed from: d */
        public final /* synthetic */ String f1172d;

        /* renamed from: e */
        public final /* synthetic */ int f1173e;

        public C0636f(String str, String str2, String str3, String str4, int i) {
            this.f1169a = str;
            this.f1170b = str2;
            this.f1171c = str3;
            this.f1172d = str4;
            this.f1173e = i;
        }

        @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsController.CodedOutputStreamWriteAction
        /* renamed from: a */
        public void mo1719a(pb0 pb0Var) throws Exception {
            qb0.m7664r(pb0Var, this.f1169a, this.f1170b, this.f1171c, this.f1172d, this.f1173e, CrashlyticsController.this.f1146q);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$g */
    /* loaded from: classes.dex */
    public class C0637g implements CodedOutputStreamWriteAction {

        /* renamed from: a */
        public final /* synthetic */ String f1175a;

        /* renamed from: b */
        public final /* synthetic */ String f1176b;

        /* renamed from: c */
        public final /* synthetic */ boolean f1177c;

        public C0637g(CrashlyticsController crashlyticsController, String str, String str2, boolean z) {
            this.f1175a = str;
            this.f1176b = str2;
            this.f1177c = z;
        }

        @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsController.CodedOutputStreamWriteAction
        /* renamed from: a */
        public void mo1719a(pb0 pb0Var) throws Exception {
            qb0.m7644B(pb0Var, this.f1175a, this.f1176b, this.f1177c);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$h */
    /* loaded from: classes.dex */
    public class C0638h extends C0653w {
        public C0638h(String str) {
            super(str);
        }

        @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsController.C0653w, java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return super.accept(file, str) && str.endsWith(".cls");
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$i */
    /* loaded from: classes.dex */
    public class C0639i implements CodedOutputStreamWriteAction {

        /* renamed from: a */
        public final /* synthetic */ int f1178a;

        /* renamed from: b */
        public final /* synthetic */ String f1179b;

        /* renamed from: c */
        public final /* synthetic */ int f1180c;

        /* renamed from: d */
        public final /* synthetic */ long f1181d;

        /* renamed from: e */
        public final /* synthetic */ long f1182e;

        /* renamed from: f */
        public final /* synthetic */ boolean f1183f;

        /* renamed from: g */
        public final /* synthetic */ int f1184g;

        /* renamed from: h */
        public final /* synthetic */ String f1185h;

        /* renamed from: i */
        public final /* synthetic */ String f1186i;

        public C0639i(CrashlyticsController crashlyticsController, int i, String str, int i2, long j, long j2, boolean z, int i3, String str2, String str3) {
            this.f1178a = i;
            this.f1179b = str;
            this.f1180c = i2;
            this.f1181d = j;
            this.f1182e = j2;
            this.f1183f = z;
            this.f1184g = i3;
            this.f1185h = str2;
            this.f1186i = str3;
        }

        @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsController.CodedOutputStreamWriteAction
        /* renamed from: a */
        public void mo1719a(pb0 pb0Var) throws Exception {
            qb0.m7666t(pb0Var, this.f1178a, this.f1179b, this.f1180c, this.f1181d, this.f1182e, this.f1183f, this.f1184g, this.f1185h, this.f1186i);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$j */
    /* loaded from: classes.dex */
    public class C0640j implements CodedOutputStreamWriteAction {

        /* renamed from: a */
        public final /* synthetic */ q90 f1187a;

        public C0640j(CrashlyticsController crashlyticsController, q90 q90Var) {
            this.f1187a = q90Var;
        }

        @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsController.CodedOutputStreamWriteAction
        /* renamed from: a */
        public void mo1719a(pb0 pb0Var) throws Exception {
            qb0.m7645C(pb0Var, this.f1187a.m7640b(), null, null);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$k */
    /* loaded from: classes.dex */
    public class C0641k implements CodedOutputStreamWriteAction {

        /* renamed from: a */
        public final /* synthetic */ String f1188a;

        public C0641k(String str) {
            this.f1188a = str;
        }

        @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsController.CodedOutputStreamWriteAction
        /* renamed from: a */
        public void mo1719a(pb0 pb0Var) throws Exception {
            qb0.m7665s(pb0Var, this.f1188a);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$l */
    /* loaded from: classes.dex */
    public class CallableC0642l implements Callable<Void> {

        /* renamed from: a */
        public final /* synthetic */ long f1189a;

        public CallableC0642l(long j) {
            this.f1189a = j;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            C0638h c0638h = null;
            if (CrashlyticsController.this.m1682M()) {
                m80.m6375f().m6377b("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
                return null;
            }
            if (CrashlyticsController.this.f1148s == null) {
                m80.m6375f().m6377b("Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
                return null;
            }
            C0652v c0652v = new C0652v(c0638h);
            CrashlyticsController.this.f1147r.mo1627a(c0652v);
            m80.m6375f().m6377b("Logging Crashlytics event to Firebase");
            Bundle bundle = new Bundle();
            bundle.putInt("fatal", 1);
            bundle.putLong("timestamp", this.f1189a);
            CrashlyticsController.this.f1148s.mo1595a("clx", "_ae", bundle);
            c0652v.m1734b();
            CrashlyticsController.this.f1147r.mo1627a(null);
            return null;
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$m */
    /* loaded from: classes.dex */
    public class C0643m implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.length() == 39 && str.endsWith(".cls");
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$n */
    /* loaded from: classes.dex */
    public class C0644n implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$o */
    /* loaded from: classes.dex */
    public class C0645o implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$p */
    /* loaded from: classes.dex */
    public class C0646p implements CrashlyticsUncaughtExceptionHandler.CrashListener {
        public C0646p() {
        }

        @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler.CrashListener
        /* renamed from: a */
        public void mo1726a(@NonNull SettingsDataProvider settingsDataProvider, @NonNull Thread thread, @NonNull Throwable th) {
            CrashlyticsController.this.m1692a0(settingsDataProvider, thread, th);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$q */
    /* loaded from: classes.dex */
    public class CallableC0647q implements Callable<j60<Void>> {

        /* renamed from: a */
        public final /* synthetic */ Date f1192a;

        /* renamed from: b */
        public final /* synthetic */ Throwable f1193b;

        /* renamed from: c */
        public final /* synthetic */ Thread f1194c;

        /* renamed from: d */
        public final /* synthetic */ SettingsDataProvider f1195d;

        /* renamed from: e */
        public final /* synthetic */ j60 f1196e;

        /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
        /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$q$a */
        /* loaded from: classes.dex */
        public class a implements SuccessContinuation<jc0, Void> {

            /* renamed from: a */
            public final /* synthetic */ Executor f1198a;

            public a(Executor executor) {
                this.f1198a = executor;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            @NonNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public j60<Void> mo1557a(@Nullable jc0 jc0Var) throws Exception {
                if (jc0Var == null) {
                    m80.m6375f().m6383i("Received null app settings, cannot send reports at crash time.");
                    return Tasks.m1562e(null);
                }
                CrashlyticsController.this.m1705o0(jc0Var, true);
                CrashlyticsController.this.f1149t.m6911m(this.f1198a, d90.m3165f(jc0Var));
                return CallableC0647q.this.f1196e;
            }
        }

        public CallableC0647q(Date date, Throwable th, Thread thread, SettingsDataProvider settingsDataProvider, j60 j60Var) {
            this.f1192a = date;
            this.f1193b = th;
            this.f1194c = thread;
            this.f1195d = settingsDataProvider;
            this.f1196e = j60Var;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j60<Void> call() throws Exception {
            CrashlyticsController.this.f1132c.m10402a();
            long m1638X = CrashlyticsController.m1638X(this.f1192a);
            CrashlyticsController.this.f1149t.m6909k(this.f1193b, this.f1194c, m1638X);
            CrashlyticsController.this.m1713w0(this.f1194c, this.f1193b, m1638X);
            Settings mo1843b = this.f1195d.mo1843b();
            int i = mo1843b.mo1846b().f4785a;
            int i2 = mo1843b.mo1846b().f4786b;
            CrashlyticsController.this.m1673F(i);
            CrashlyticsController.this.m1676H();
            CrashlyticsController.this.m1710t0(i2);
            if (!CrashlyticsController.this.f1131b.m2716b()) {
                return Tasks.m1562e(null);
            }
            Executor m9732c = CrashlyticsController.this.f1134e.m9732c();
            return this.f1195d.mo1842a().mo2703p(m9732c, new a(m9732c));
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$r */
    /* loaded from: classes.dex */
    public class C0648r implements SuccessContinuation<Void, Boolean> {
        public C0648r(CrashlyticsController crashlyticsController) {
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j60<Boolean> mo1557a(@Nullable Void r1) throws Exception {
            return Tasks.m1562e(Boolean.TRUE);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$s */
    /* loaded from: classes.dex */
    public class C0649s implements SuccessContinuation<Boolean, Void> {

        /* renamed from: a */
        public final /* synthetic */ j60 f1200a;

        /* renamed from: b */
        public final /* synthetic */ float f1201b;

        /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
        /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$s$a */
        /* loaded from: classes.dex */
        public class a implements Callable<j60<Void>> {

            /* renamed from: a */
            public final /* synthetic */ Boolean f1203a;

            /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
            /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$s$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C2488a implements SuccessContinuation<jc0, Void> {

                /* renamed from: a */
                public final /* synthetic */ List f1205a;

                /* renamed from: b */
                public final /* synthetic */ boolean f1206b;

                /* renamed from: c */
                public final /* synthetic */ Executor f1207c;

                public C2488a(List list, boolean z, Executor executor) {
                    this.f1205a = list;
                    this.f1206b = z;
                    this.f1207c = executor;
                }

                @Override // com.google.android.gms.tasks.SuccessContinuation
                @NonNull
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public j60<Void> mo1557a(@Nullable jc0 jc0Var) throws Exception {
                    if (jc0Var == null) {
                        m80.m6375f().m6383i("Received null app settings, cannot send reports during app startup.");
                        return Tasks.m1562e(null);
                    }
                    for (Report report : this.f1205a) {
                        if (report.getType() == Report.EnumC0663a.JAVA) {
                            CrashlyticsController.m1661v(jc0Var.f3539e, report.mo1838c());
                        }
                    }
                    CrashlyticsController.this.f1139j.mo1733a(jc0Var).m1833e(this.f1205a, this.f1206b, C0649s.this.f1201b);
                    CrashlyticsController.this.f1149t.m6911m(this.f1207c, d90.m3165f(jc0Var));
                    CrashlyticsController.this.f1153x.m5846e(null);
                    return Tasks.m1562e(null);
                }
            }

            public a(Boolean bool) {
                this.f1203a = bool;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public j60<Void> call() throws Exception {
                List<Report> m8423d = CrashlyticsController.this.f1142m.m8423d();
                if (this.f1203a.booleanValue()) {
                    m80.m6375f().m6377b("Reports are being sent.");
                    boolean booleanValue = this.f1203a.booleanValue();
                    CrashlyticsController.this.f1131b.m2715a(booleanValue);
                    Executor m9732c = CrashlyticsController.this.f1134e.m9732c();
                    return C0649s.this.f1200a.mo2703p(m9732c, new C2488a(m8423d, booleanValue, m9732c));
                }
                m80.m6375f().m6377b("Reports are being deleted.");
                CrashlyticsController.this.f1142m.m8422c(m8423d);
                CrashlyticsController.this.f1149t.m6910l();
                CrashlyticsController.this.f1153x.m5846e(null);
                return Tasks.m1562e(null);
            }
        }

        public C0649s(j60 j60Var, float f) {
            this.f1200a = j60Var;
            this.f1201b = f;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        @NonNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j60<Void> mo1557a(@Nullable Boolean bool) throws Exception {
            return CrashlyticsController.this.f1134e.m9738i(new a(bool));
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$t */
    /* loaded from: classes.dex */
    public class C0650t implements ReportUploader.Provider {
        public C0650t() {
        }

        @Override // com.google.firebase.crashlytics.internal.report.ReportUploader.Provider
        /* renamed from: a */
        public ReportUploader mo1733a(@NonNull jc0 jc0Var) {
            String str = jc0Var.f3537c;
            String str2 = jc0Var.f3538d;
            return new ReportUploader(jc0Var.f3539e, CrashlyticsController.this.f1138i.f5959a, d90.m3165f(jc0Var), CrashlyticsController.this.f1142m, CrashlyticsController.this.m1684O(str, str2), CrashlyticsController.this.f1143n);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$u */
    /* loaded from: classes.dex */
    public static class C0651u implements FilenameFilter {
        public C0651u() {
        }

        public /* synthetic */ C0651u(C0638h c0638h) {
            this();
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !CrashlyticsController.f1129z.accept(file, str) && CrashlyticsController.f1125C.matcher(str).matches();
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$v */
    /* loaded from: classes.dex */
    public static class C0652v implements AnalyticsReceiver.CrashlyticsOriginEventListener {

        /* renamed from: a */
        public final CountDownLatch f1210a;

        public C0652v() {
            this.f1210a = new CountDownLatch(1);
        }

        public /* synthetic */ C0652v(C0638h c0638h) {
            this();
        }

        @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsReceiver.CrashlyticsOriginEventListener
        /* renamed from: a */
        public void mo1632a(int i, Bundle bundle) {
            if ("_ae".equals(bundle.getString("name"))) {
                this.f1210a.countDown();
            }
        }

        /* renamed from: b */
        public void m1734b() throws InterruptedException {
            m80.m6375f().m6377b("Background thread awaiting app exception callback from FA...");
            if (this.f1210a.await(2000L, TimeUnit.MILLISECONDS)) {
                m80.m6375f().m6377b("App exception callback received from FA listener.");
            } else {
                m80.m6375f().m6377b("Timeout exceeded while awaiting app exception callback from FA listener.");
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$w */
    /* loaded from: classes.dex */
    public static class C0653w implements FilenameFilter {

        /* renamed from: a */
        public final String f1211a;

        public C0653w(String str) {
            this.f1211a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.contains(this.f1211a) && !str.endsWith(".cls_temp");
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$x */
    /* loaded from: classes.dex */
    public static class C0654x implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return ob0.f5470R.accept(file, str) || str.contains("SessionMissingBinaryImages");
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$y */
    /* loaded from: classes.dex */
    public static final class C0655y implements LogFileManager.DirectoryProvider {

        /* renamed from: a */
        public final FileStore f1212a;

        public C0655y(FileStore fileStore) {
            this.f1212a = fileStore;
        }

        @Override // com.google.firebase.crashlytics.internal.log.LogFileManager.DirectoryProvider
        /* renamed from: a */
        public File mo1735a() {
            File file = new File(this.f1212a.mo1828b(), "log-files");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.common.CrashlyticsController$z */
    /* loaded from: classes.dex */
    public final class C0656z implements ReportUploader.ReportFilesProvider {
        public C0656z() {
        }

        public /* synthetic */ C0656z(CrashlyticsController crashlyticsController, C0638h c0638h) {
            this();
        }

        @Override // com.google.firebase.crashlytics.internal.report.ReportUploader.ReportFilesProvider
        /* renamed from: a */
        public File[] mo1736a() {
            return CrashlyticsController.this.m1697f0();
        }

        @Override // com.google.firebase.crashlytics.internal.report.ReportUploader.ReportFilesProvider
        /* renamed from: b */
        public File[] mo1737b() {
            return CrashlyticsController.this.m1694c0();
        }
    }

    public CrashlyticsController(Context context, x80 x80Var, db0 db0Var, h90 h90Var, c90 c90Var, FileStore fileStore, z80 z80Var, q80 q80Var, sb0 sb0Var, ReportUploader.Provider provider, CrashlyticsNativeComponent crashlyticsNativeComponent, UnityVersionProvider unityVersionProvider, AnalyticsReceiver analyticsReceiver, AnalyticsConnector analyticsConnector, SettingsDataProvider settingsDataProvider) {
        new AtomicInteger(0);
        this.f1151v = new k60<>();
        this.f1152w = new k60<>();
        this.f1153x = new k60<>();
        new AtomicBoolean(false);
        this.f1130a = context;
        this.f1134e = x80Var;
        this.f1135f = db0Var;
        this.f1136g = h90Var;
        this.f1131b = c90Var;
        this.f1137h = fileStore;
        this.f1132c = z80Var;
        this.f1138i = q80Var;
        if (provider != null) {
            this.f1139j = provider;
        } else {
            this.f1139j = m1665B();
        }
        this.f1144o = crashlyticsNativeComponent;
        this.f1146q = unityVersionProvider.mo1849a();
        this.f1147r = analyticsReceiver;
        this.f1148s = analyticsConnector;
        q90 q90Var = new q90();
        this.f1133d = q90Var;
        C0655y c0655y = new C0655y(fileStore);
        this.f1140k = c0655y;
        LogFileManager logFileManager = new LogFileManager(context, c0655y);
        this.f1141l = logFileManager;
        C0638h c0638h = null;
        this.f1142m = sb0Var == null ? new sb0(new C0656z(this, c0638h)) : sb0Var;
        this.f1143n = new C0629a0(this, c0638h);
        sc0 sc0Var = new sc0(1024, new uc0(10));
        this.f1145p = sc0Var;
        this.f1149t = o90.m6900b(context, h90Var, fileStore, q80Var, logFileManager, q90Var, sc0Var, settingsDataProvider);
    }

    /* renamed from: A */
    public static void m1633A(InputStream inputStream, pb0 pb0Var, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read < 0) {
                break;
            } else {
                i2 += read;
            }
        }
        pb0Var.m7292X(bArr);
    }

    /* renamed from: G0 */
    public static void m1634G0(pb0 pb0Var, File file) throws IOException {
        if (!file.exists()) {
            m80.m6375f().m6379d("Tried to include a file that doesn't exist: " + file.getName());
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                m1633A(fileInputStream2, pb0Var, (int) file.length());
                w80.m9426e(fileInputStream2, "Failed to close file input stream.");
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                w80.m9426e(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: Q */
    public static long m1635Q() {
        return m1638X(new Date());
    }

    @NonNull
    /* renamed from: T */
    public static List<NativeSessionFile> m1636T(NativeSessionFileProvider nativeSessionFileProvider, String str, Context context, File file, byte[] bArr) {
        byte[] bArr2;
        j90 j90Var = new j90(file);
        File m5086b = j90Var.m5086b(str);
        File m5085a = j90Var.m5085a(str);
        try {
            bArr2 = xa0.m9752a(nativeSessionFileProvider.mo1622d(), context);
        } catch (Exception unused) {
            bArr2 = null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new u80("logs_file", "logs", bArr));
        arrayList.add(new u80("binary_images_file", "binaryImages", bArr2));
        arrayList.add(new g90("crash_meta_file", "metadata", nativeSessionFileProvider.mo1625g()));
        arrayList.add(new g90("session_meta_file", "session", nativeSessionFileProvider.mo1624f()));
        arrayList.add(new g90("app_meta_file", "app", nativeSessionFileProvider.mo1619a()));
        arrayList.add(new g90("device_meta_file", "device", nativeSessionFileProvider.mo1621c()));
        arrayList.add(new g90("os_meta_file", "os", nativeSessionFileProvider.mo1620b()));
        arrayList.add(new g90("minidump_file", "minidump", nativeSessionFileProvider.mo1623e()));
        arrayList.add(new g90("user_meta_file", "user", m5086b));
        arrayList.add(new g90("keys_file", "keys", m5085a));
        return arrayList;
    }

    /* renamed from: W */
    public static String m1637W(File file) {
        return file.getName().substring(0, 35);
    }

    /* renamed from: X */
    public static long m1638X(Date date) {
        return date.getTime() / 1000;
    }

    @NonNull
    /* renamed from: j0 */
    public static String m1649j0(@NonNull String str) {
        return str.replaceAll("-", "");
    }

    /* renamed from: v */
    public static void m1661v(@Nullable String str, @NonNull File file) throws Exception {
        if (str == null) {
            return;
        }
        m1662w(file, new C0641k(str));
    }

    /* renamed from: w */
    public static void m1662w(@NonNull File file, @NonNull CodedOutputStreamWriteAction codedOutputStreamWriteAction) throws Exception {
        FileOutputStream fileOutputStream;
        pb0 pb0Var = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            pb0Var = pb0.m7277z(fileOutputStream);
            codedOutputStreamWriteAction.mo1719a(pb0Var);
            w80.m9431j(pb0Var, "Failed to flush to append to " + file.getPath());
            w80.m9426e(fileOutputStream, "Failed to close " + file.getPath());
        } catch (Throwable th2) {
            th = th2;
            w80.m9431j(pb0Var, "Failed to flush to append to " + file.getPath());
            w80.m9426e(fileOutputStream, "Failed to close " + file.getPath());
            throw th;
        }
    }

    /* renamed from: y0 */
    public static void m1663y0(pb0 pb0Var, File[] fileArr, String str) {
        Arrays.sort(fileArr, w80.f7632c);
        for (File file : fileArr) {
            try {
                m80.m6375f().m6377b(String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", str, file.getName()));
                m1634G0(pb0Var, file);
            } catch (Exception e) {
                m80.m6375f().m6380e("Error writting non-fatal to session.", e);
            }
        }
    }

    /* renamed from: A0 */
    public final void m1664A0(String str) throws Exception {
        Context m1683N = m1683N();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int m9434m = w80.m9434m();
        String str2 = Build.MODEL;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long m9443v = w80.m9443v();
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        boolean m9415B = w80.m9415B(m1683N);
        int m9435n = w80.m9435n(m1683N);
        String str3 = Build.MANUFACTURER;
        String str4 = Build.PRODUCT;
        m1670D0(str, "SessionDevice", new C0639i(this, m9434m, str2, availableProcessors, m9443v, blockCount, m9415B, m9435n, str3, str4));
        this.f1144o.mo1613c(str, m9434m, str2, availableProcessors, m9443v, blockCount, m9415B, m9435n, str3, str4);
    }

    /* renamed from: B */
    public final ReportUploader.Provider m1665B() {
        return new C0650t();
    }

    /* renamed from: B0 */
    public final void m1666B0(pb0 pb0Var, Thread thread, Throwable th, long j, String str, boolean z) throws Exception {
        Thread[] threadArr;
        Map<String, String> m7639a;
        Map<String, String> treeMap;
        vc0 vc0Var = new vc0(th, this.f1145p);
        Context m1683N = m1683N();
        t80 m8602a = t80.m8602a(m1683N);
        Float m8605b = m8602a.m8605b();
        int m8606c = m8602a.m8606c();
        boolean m9438q = w80.m9438q(m1683N);
        int i = m1683N.getResources().getConfiguration().orientation;
        long m9443v = w80.m9443v() - w80.m9422a(m1683N);
        long m9423b = w80.m9423b(Environment.getDataDirectory().getPath());
        ActivityManager.RunningAppProcessInfo m9432k = w80.m9432k(m1683N.getPackageName(), m1683N);
        LinkedList linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = vc0Var.f7444c;
        String str2 = this.f1138i.f5960b;
        String m4389d = this.f1136g.m4389d();
        int i2 = 0;
        if (z) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                threadArr2[i2] = entry.getKey();
                linkedList.add(this.f1145p.mo1848a(entry.getValue()));
                i2++;
            }
            threadArr = threadArr2;
        } else {
            threadArr = new Thread[0];
        }
        if (w80.m9433l(m1683N, "com.crashlytics.CollectCustomKeys", true)) {
            m7639a = this.f1133d.m7639a();
            if (m7639a != null && m7639a.size() > 1) {
                treeMap = new TreeMap(m7639a);
                qb0.m7667u(pb0Var, j, str, vc0Var, thread, stackTraceElementArr, threadArr, linkedList, 8, treeMap, this.f1141l.m1751c(), m9432k, i, m4389d, str2, m8605b, m8606c, m9438q, m9443v, m9423b);
                this.f1141l.m1749a();
            }
        } else {
            m7639a = new TreeMap<>();
        }
        treeMap = m7639a;
        qb0.m7667u(pb0Var, j, str, vc0Var, thread, stackTraceElementArr, threadArr, linkedList, 8, treeMap, this.f1141l.m1751c(), m9432k, i, m4389d, str2, m8605b, m8606c, m9438q, m9443v, m9423b);
        this.f1141l.m1749a();
    }

    /* renamed from: C */
    public final void m1667C(String str) {
        for (File file : m1699h0(str)) {
            file.delete();
        }
    }

    /* renamed from: C0 */
    public final void m1668C0(String str) throws Exception {
        String str2 = Build.VERSION.RELEASE;
        String str3 = Build.VERSION.CODENAME;
        boolean m9417D = w80.m9417D(m1683N());
        m1670D0(str, "SessionOS", new C0637g(this, str2, str3, m9417D));
        this.f1144o.mo1617g(str, str2, str3, m9417D);
    }

    /* renamed from: D */
    public boolean m1669D() {
        if (!this.f1132c.m10404c()) {
            String m1685P = m1685P();
            return m1685P != null && this.f1144o.mo1615e(m1685P);
        }
        m80.m6375f().m6377b("Found previous crash marker.");
        this.f1132c.m10405d();
        return true;
    }

    /* renamed from: D0 */
    public final void m1670D0(String str, String str2, CodedOutputStreamWriteAction codedOutputStreamWriteAction) throws Exception {
        ob0 ob0Var;
        pb0 pb0Var = null;
        try {
            ob0Var = new ob0(m1687S(), str + str2);
            try {
                pb0Var = pb0.m7277z(ob0Var);
                codedOutputStreamWriteAction.mo1719a(pb0Var);
                w80.m9431j(pb0Var, "Failed to flush to session " + str2 + " file.");
                w80.m9426e(ob0Var, "Failed to close session " + str2 + " file.");
            } catch (Throwable th) {
                th = th;
                w80.m9431j(pb0Var, "Failed to flush to session " + str2 + " file.");
                w80.m9426e(ob0Var, "Failed to close session " + str2 + " file.");
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            ob0Var = null;
        }
    }

    /* renamed from: E */
    public void m1671E(File[] fileArr) {
        HashSet hashSet = new HashSet();
        for (File file : fileArr) {
            m80.m6375f().m6377b("Found invalid session part file: " + file);
            hashSet.add(m1637W(file));
        }
        if (hashSet.isEmpty()) {
            return;
        }
        for (File file2 : m1696e0(new C0634d(this, hashSet))) {
            m80.m6375f().m6377b("Deleting invalid session file: " + file2);
            file2.delete();
        }
    }

    /* renamed from: E0 */
    public final void m1672E0(File file, String str, int i) {
        m80.m6375f().m6377b("Collecting session parts for ID " + str);
        File[] m1696e0 = m1696e0(new C0653w(str + "SessionCrash"));
        boolean z = m1696e0 != null && m1696e0.length > 0;
        m80 m6375f = m80.m6375f();
        Locale locale = Locale.US;
        m6375f.m6377b(String.format(locale, "Session %s has fatal exception: %s", str, Boolean.valueOf(z)));
        File[] m1696e02 = m1696e0(new C0653w(str + "SessionEvent"));
        boolean z2 = m1696e02 != null && m1696e02.length > 0;
        m80.m6375f().m6377b(String.format(locale, "Session %s has non-fatal exceptions: %s", str, Boolean.valueOf(z2)));
        if (z || z2) {
            m1707q0(file, str, m1690Y(str, m1696e02, i), z ? m1696e0[0] : null);
        } else {
            m80.m6375f().m6377b("No events present for session ID " + str);
        }
        m80.m6375f().m6377b("Removing session part files for ID " + str);
        m1667C(str);
    }

    /* renamed from: F */
    public void m1673F(int i) throws Exception {
        m1675G(i, true);
    }

    /* renamed from: F0 */
    public final void m1674F0(String str) throws Exception {
        m1670D0(str, "SessionUser", new C0640j(this, m1691Z(str)));
    }

    /* renamed from: G */
    public final void m1675G(int i, boolean z) throws Exception {
        int i2 = !z ? 1 : 0;
        m1708r0(i2 + 8);
        File[] m1700i0 = m1700i0();
        if (m1700i0.length <= i2) {
            m80.m6375f().m6377b("No open sessions to be closed.");
            return;
        }
        String m1637W = m1637W(m1700i0[i2]);
        m1674F0(m1637W);
        if (z) {
            this.f1149t.m6906h();
        } else if (this.f1144o.mo1615e(m1637W)) {
            m1680K(m1637W);
            if (!this.f1144o.mo1611a(m1637W)) {
                m80.m6375f().m6377b("Could not finalize native session: " + m1637W);
            }
        }
        m1716y(m1700i0, i2, i);
        this.f1149t.m6904d(m1635Q());
    }

    /* renamed from: H */
    public final void m1676H() throws Exception {
        long m1635Q = m1635Q();
        String v80Var = new v80(this.f1136g).toString();
        m80.m6375f().m6377b("Opening a new session with ID " + v80Var);
        this.f1144o.mo1618h(v80Var);
        m1712v0(v80Var, m1635Q);
        m1718z0(v80Var);
        m1668C0(v80Var);
        m1664A0(v80Var);
        this.f1141l.m1755g(v80Var);
        this.f1149t.m6905g(m1649j0(v80Var), m1635Q);
    }

    /* renamed from: H0 */
    public void m1677H0(long j, String str) {
        this.f1134e.m9737h(new CallableC0628a(j, str));
    }

    /* renamed from: I */
    public void m1678I(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, SettingsDataProvider settingsDataProvider) {
        m1701k0();
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(new C0646p(), settingsDataProvider, uncaughtExceptionHandler);
        this.f1150u = crashlyticsUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(crashlyticsUncaughtExceptionHandler);
    }

    /* renamed from: J */
    public final File[] m1679J(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    /* renamed from: K */
    public final void m1680K(String str) {
        m80.m6375f().m6377b("Finalizing native report for session " + str);
        NativeSessionFileProvider mo1612b = this.f1144o.mo1612b(str);
        File mo1623e = mo1612b.mo1623e();
        if (mo1623e == null || !mo1623e.exists()) {
            m80.m6375f().m6383i("No minidump data found for session " + str);
            return;
        }
        LogFileManager logFileManager = new LogFileManager(this.f1130a, this.f1140k, str);
        File file = new File(m1688U(), str);
        if (!file.mkdirs()) {
            m80.m6375f().m6377b("Couldn't create native sessions directory");
            return;
        }
        List<NativeSessionFile> m1636T = m1636T(mo1612b, str, m1683N(), m1687S(), logFileManager.m1751c());
        k90.m5850b(file, m1636T);
        this.f1149t.m6903c(m1649j0(str), m1636T);
        logFileManager.m1749a();
    }

    /* renamed from: L */
    public boolean m1681L(int i) {
        this.f1134e.m9731b();
        if (m1693b0()) {
            m80.m6375f().m6377b("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        m80.m6375f().m6377b("Finalizing previously open sessions.");
        try {
            m1675G(i, false);
            m80.m6375f().m6377b("Closed all previously open sessions");
            return true;
        } catch (Exception e) {
            m80.m6375f().m6380e("Unable to finalize previously open sessions.", e);
            return false;
        }
    }

    /* renamed from: M */
    public final boolean m1682M() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: N */
    public final Context m1683N() {
        return this.f1130a;
    }

    /* renamed from: O */
    public final CreateReportSpiCall m1684O(String str, String str2) {
        String m9442u = w80.m9442u(m1683N(), "com.crashlytics.ApiEndpoint");
        return new wb0(new xb0(m9442u, str, this.f1135f, y80.m10100i()), new yb0(m9442u, str2, this.f1135f, y80.m10100i()));
    }

    /* renamed from: P */
    public final String m1685P() {
        File[] m1700i0 = m1700i0();
        if (m1700i0.length > 0) {
            return m1637W(m1700i0[0]);
        }
        return null;
    }

    /* renamed from: R */
    public File m1686R() {
        return new File(m1687S(), "fatal-sessions");
    }

    /* renamed from: S */
    public File m1687S() {
        return this.f1137h.mo1828b();
    }

    /* renamed from: U */
    public File m1688U() {
        return new File(m1687S(), "native-sessions");
    }

    /* renamed from: V */
    public File m1689V() {
        return new File(m1687S(), "nonfatal-sessions");
    }

    /* renamed from: Y */
    public final File[] m1690Y(String str, File[] fileArr, int i) {
        if (fileArr.length <= i) {
            return fileArr;
        }
        m80.m6375f().m6377b(String.format(Locale.US, "Trimming down to %d logged exceptions.", Integer.valueOf(i)));
        m1709s0(str, i);
        return m1696e0(new C0653w(str + "SessionEvent"));
    }

    /* renamed from: Z */
    public final q90 m1691Z(String str) {
        return m1693b0() ? this.f1133d : new j90(m1687S()).m5087d(str);
    }

    /* renamed from: a0 */
    public synchronized void m1692a0(@NonNull SettingsDataProvider settingsDataProvider, @NonNull Thread thread, @NonNull Throwable th) {
        m80.m6375f().m6377b("Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        Date date = new Date();
        try {
            r90.m7891a(this.f1134e.m9738i(new CallableC0647q(date, th, thread, settingsDataProvider, m1702l0(date.getTime()))));
        } catch (Exception unused) {
        }
    }

    /* renamed from: b0 */
    public boolean m1693b0() {
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.f1150u;
        return crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.m1738a();
    }

    /* renamed from: c0 */
    public File[] m1694c0() {
        LinkedList linkedList = new LinkedList();
        File m1686R = m1686R();
        FilenameFilter filenameFilter = f1129z;
        Collections.addAll(linkedList, m1695d0(m1686R, filenameFilter));
        Collections.addAll(linkedList, m1695d0(m1689V(), filenameFilter));
        Collections.addAll(linkedList, m1695d0(m1687S(), filenameFilter));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    /* renamed from: d0 */
    public final File[] m1695d0(File file, FilenameFilter filenameFilter) {
        return m1679J(file.listFiles(filenameFilter));
    }

    /* renamed from: e0 */
    public final File[] m1696e0(FilenameFilter filenameFilter) {
        return m1695d0(m1687S(), filenameFilter);
    }

    /* renamed from: f0 */
    public File[] m1697f0() {
        return m1679J(m1688U().listFiles());
    }

    /* renamed from: g0 */
    public File[] m1698g0() {
        return m1696e0(f1128y);
    }

    /* renamed from: h0 */
    public final File[] m1699h0(String str) {
        return m1696e0(new C0633c0(str));
    }

    /* renamed from: i0 */
    public final File[] m1700i0() {
        File[] m1698g0 = m1698g0();
        Arrays.sort(m1698g0, f1123A);
        return m1698g0;
    }

    /* renamed from: k0 */
    public void m1701k0() {
        this.f1134e.m9737h(new CallableC0630b());
    }

    /* renamed from: l0 */
    public final j60<Void> m1702l0(long j) {
        return Tasks.m1560c(new ScheduledThreadPoolExecutor(1), new CallableC0642l(j));
    }

    /* renamed from: m0 */
    public void m1703m0() {
        boolean mo1628b = this.f1147r.mo1628b();
        m80.m6375f().m6377b("Registered Firebase Analytics event listener for breadcrumbs: " + mo1628b);
    }

    /* renamed from: n0 */
    public final void m1704n0(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = f1125C.matcher(name);
            if (!matcher.matches()) {
                m80.m6375f().m6377b("Deleting unknown file: " + name);
                file.delete();
            } else if (!set.contains(matcher.group(1))) {
                m80.m6375f().m6377b("Trimming session file: " + name);
                file.delete();
            }
        }
    }

    /* renamed from: o0 */
    public final void m1705o0(@NonNull jc0 jc0Var, boolean z) throws Exception {
        Context m1683N = m1683N();
        ReportUploader mo1733a = this.f1139j.mo1733a(jc0Var);
        for (File file : m1694c0()) {
            m1661v(jc0Var.f3539e, file);
            this.f1134e.m9736g(new RunnableC0631b0(m1683N, new vb0(file, f1126D), mo1733a, z));
        }
    }

    /* renamed from: p0 */
    public j60<Void> m1706p0(float f, j60<jc0> j60Var) {
        if (this.f1142m.m8420a()) {
            m80.m6375f().m6377b("Unsent reports are available.");
            return m1711u0().mo2702o(new C0649s(j60Var, f));
        }
        m80.m6375f().m6377b("No reports are available.");
        this.f1151v.m5846e(Boolean.FALSE);
        return Tasks.m1562e(null);
    }

    /* renamed from: q0 */
    public final void m1707q0(File file, String str, File[] fileArr, File file2) {
        ob0 ob0Var;
        boolean z = file2 != null;
        File m1686R = z ? m1686R() : m1689V();
        if (!m1686R.exists()) {
            m1686R.mkdirs();
        }
        pb0 pb0Var = null;
        try {
            try {
                ob0Var = new ob0(m1686R, str);
                try {
                    pb0Var = pb0.m7277z(ob0Var);
                    m80.m6375f().m6377b("Collecting SessionStart data for session ID " + str);
                    m1634G0(pb0Var, file);
                    pb0Var.m7302h0(4, m1635Q());
                    pb0Var.m7279D(5, z);
                    pb0Var.m7300f0(11, 1);
                    pb0Var.m7283L(12, 3);
                    m1715x0(pb0Var, str);
                    m1663y0(pb0Var, fileArr, str);
                    if (z) {
                        m1634G0(pb0Var, file2);
                    }
                    w80.m9431j(pb0Var, "Error flushing session file stream");
                    w80.m9426e(ob0Var, "Failed to close CLS file");
                } catch (Exception e) {
                    e = e;
                    m80.m6375f().m6380e("Failed to write session file for session ID: " + str, e);
                    w80.m9431j(pb0Var, "Error flushing session file stream");
                    m1717z(ob0Var);
                }
            } catch (Throwable th) {
                th = th;
                w80.m9431j(null, "Error flushing session file stream");
                w80.m9426e(null, "Failed to close CLS file");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            ob0Var = null;
        } catch (Throwable th2) {
            th = th2;
            w80.m9431j(null, "Error flushing session file stream");
            w80.m9426e(null, "Failed to close CLS file");
            throw th;
        }
    }

    /* renamed from: r0 */
    public final void m1708r0(int i) {
        HashSet hashSet = new HashSet();
        File[] m1700i0 = m1700i0();
        int min = Math.min(i, m1700i0.length);
        for (int i2 = 0; i2 < min; i2++) {
            hashSet.add(m1637W(m1700i0[i2]));
        }
        this.f1141l.m1750b(hashSet);
        m1704n0(m1696e0(new C0651u(null)), hashSet);
    }

    /* renamed from: s0 */
    public final void m1709s0(String str, int i) {
        r90.m7894d(m1687S(), new C0653w(str + "SessionEvent"), i, f1124B);
    }

    /* renamed from: t0 */
    public void m1710t0(int i) {
        File m1688U = m1688U();
        File m1686R = m1686R();
        Comparator<File> comparator = f1124B;
        int m7896f = i - r90.m7896f(m1688U, m1686R, i, comparator);
        r90.m7894d(m1687S(), f1129z, m7896f - r90.m7893c(m1689V(), m7896f, comparator), comparator);
    }

    /* renamed from: u0 */
    public final j60<Boolean> m1711u0() {
        if (this.f1131b.m2716b()) {
            m80.m6375f().m6377b("Automatic data collection is enabled. Allowing upload.");
            this.f1151v.m5846e(Boolean.FALSE);
            return Tasks.m1562e(Boolean.TRUE);
        }
        m80.m6375f().m6377b("Automatic data collection is disabled.");
        m80.m6375f().m6377b("Notifying that unsent reports are available.");
        this.f1151v.m5846e(Boolean.TRUE);
        j60<TContinuationResult> mo2702o = this.f1131b.m2717c().mo2702o(new C0648r(this));
        m80.m6375f().m6377b("Waiting for send/deleteUnsentReports to be called.");
        return r90.m7897g(mo2702o, this.f1152w.m5842a());
    }

    /* renamed from: v0 */
    public final void m1712v0(String str, long j) throws Exception {
        String format = String.format(Locale.US, "Crashlytics Android SDK/%s", y80.m10100i());
        m1670D0(str, "BeginSession", new C0635e(this, str, format, j));
        this.f1144o.mo1614d(str, format, j);
    }

    /* renamed from: w0 */
    public final void m1713w0(Thread thread, Throwable th, long j) {
        ob0 ob0Var;
        String m1685P;
        pb0 pb0Var = null;
        try {
            m1685P = m1685P();
        } catch (Exception e) {
            e = e;
            ob0Var = null;
        } catch (Throwable th2) {
            th = th2;
            ob0Var = null;
            w80.m9431j(pb0Var, "Failed to flush to session begin file.");
            w80.m9426e(ob0Var, "Failed to close fatal exception file output stream.");
            throw th;
        }
        if (m1685P == null) {
            m80.m6375f().m6379d("Tried to write a fatal exception while no session was open.");
            w80.m9431j(null, "Failed to flush to session begin file.");
            w80.m9426e(null, "Failed to close fatal exception file output stream.");
            return;
        }
        ob0Var = new ob0(m1687S(), m1685P + "SessionCrash");
        try {
            try {
                pb0Var = pb0.m7277z(ob0Var);
                m1666B0(pb0Var, thread, th, j, "crash", true);
            } catch (Exception e2) {
                e = e2;
                m80.m6375f().m6380e("An error occurred in the fatal exception logger", e);
                w80.m9431j(pb0Var, "Failed to flush to session begin file.");
                w80.m9426e(ob0Var, "Failed to close fatal exception file output stream.");
            }
            w80.m9431j(pb0Var, "Failed to flush to session begin file.");
            w80.m9426e(ob0Var, "Failed to close fatal exception file output stream.");
        } catch (Throwable th3) {
            th = th3;
            w80.m9431j(pb0Var, "Failed to flush to session begin file.");
            w80.m9426e(ob0Var, "Failed to close fatal exception file output stream.");
            throw th;
        }
    }

    /* renamed from: x */
    public void m1714x() {
        this.f1134e.m9736g(new RunnableC0632c());
    }

    /* renamed from: x0 */
    public final void m1715x0(pb0 pb0Var, String str) throws IOException {
        for (String str2 : f1127E) {
            File[] m1696e0 = m1696e0(new C0653w(str + str2 + ".cls"));
            if (m1696e0.length == 0) {
                m80.m6375f().m6377b("Can't find " + str2 + " data for session ID " + str);
            } else {
                m80.m6375f().m6377b("Collecting " + str2 + " data for session ID " + str);
                m1634G0(pb0Var, m1696e0[0]);
            }
        }
    }

    /* renamed from: y */
    public final void m1716y(File[] fileArr, int i, int i2) {
        m80.m6375f().m6377b("Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String m1637W = m1637W(file);
            m80.m6375f().m6377b("Closing session: " + m1637W);
            m1672E0(file, m1637W, i2);
            i++;
        }
    }

    /* renamed from: z */
    public final void m1717z(ob0 ob0Var) {
        if (ob0Var == null) {
            return;
        }
        try {
            ob0Var.m7009a();
        } catch (IOException e) {
            m80.m6375f().m6380e("Error closing session file stream in the presence of an exception", e);
        }
    }

    /* renamed from: z0 */
    public final void m1718z0(String str) throws Exception {
        String m4389d = this.f1136g.m4389d();
        q80 q80Var = this.f1138i;
        String str2 = q80Var.f5963e;
        String str3 = q80Var.f5964f;
        String mo1740a = this.f1136g.mo1740a();
        int m3459h = e90.m3458f(this.f1138i.f5961c).m3459h();
        m1670D0(str, "SessionApp", new C0636f(m4389d, str2, str3, mo1740a, m3459h));
        this.f1144o.mo1616f(str, m4389d, str2, str3, mo1740a, m3459h, this.f1146q);
    }
}
