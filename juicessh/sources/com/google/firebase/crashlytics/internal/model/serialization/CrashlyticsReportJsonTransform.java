package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.Base64;
import android.util.JsonReader;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.firebase.encoders.DataEncoder;
import com.sonelli.bd0;
import com.sonelli.oa0;
import com.sonelli.pa0;
import com.sonelli.qa0;
import com.sonelli.ra0;
import com.sonelli.sa0;
import com.sonelli.t90;
import com.sonelli.ta0;
import com.sonelli.ua0;
import com.sonelli.va0;
import com.sonelli.wa0;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class CrashlyticsReportJsonTransform {

    /* renamed from: a */
    public static final DataEncoder f1237a;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes.dex */
    public interface ObjectParser<T> {
        /* renamed from: a */
        T mo1817a(@NonNull JsonReader jsonReader) throws IOException;
    }

    static {
        bd0 bd0Var = new bd0();
        bd0Var.m2443g(t90.f6726a);
        bd0Var.m2444h(true);
        f1237a = bd0Var.m2442f();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    @NonNull
    /* renamed from: A */
    public static oa0.AbstractC1645d.e m1785A(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1645d.e.a m7007a = oa0.AbstractC1645d.e.m7007a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c = 0;
                        break;
                    }
                    break;
                case -293026577:
                    if (nextName.equals("jailbroken")) {
                        c = 1;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m7007a.mo6391b(jsonReader.nextString());
                    break;
                case 1:
                    m7007a.mo6392c(jsonReader.nextBoolean());
                    break;
                case 2:
                    m7007a.mo6394e(jsonReader.nextString());
                    break;
                case 3:
                    m7007a.mo6393d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return m7007a.mo6390a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    @NonNull
    /* renamed from: B */
    public static oa0 m1786B(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1642a m6913b = oa0.m6913b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -2118372775:
                    if (nextName.equals("ndkPayload")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1962630338:
                    if (nextName.equals("sdkVersion")) {
                        c = 1;
                        break;
                    }
                    break;
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c = 2;
                        break;
                    }
                    break;
                case 344431858:
                    if (nextName.equals("gmpAppId")) {
                        c = 3;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1984987798:
                    if (nextName.equals("session")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m6913b.mo6932f(m1812z(jsonReader));
                    break;
                case 1:
                    m6913b.mo6934h(jsonReader.nextString());
                    break;
                case 2:
                    m6913b.mo6928b(jsonReader.nextString());
                    break;
                case 3:
                    m6913b.mo6930d(jsonReader.nextString());
                    break;
                case 4:
                    m6913b.mo6931e(jsonReader.nextString());
                    break;
                case 5:
                    m6913b.mo6933g(jsonReader.nextInt());
                    break;
                case 6:
                    m6913b.mo6929c(jsonReader.nextString());
                    break;
                case 7:
                    m6913b.mo6935i(m1787C(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return m6913b.mo6927a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001a. Please report as an issue. */
    @NonNull
    /* renamed from: C */
    public static oa0.AbstractC1645d m1787C(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1645d.b m6954a = oa0.AbstractC1645d.m6954a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -2128794476:
                    if (nextName.equals("startedAt")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1606742899:
                    if (nextName.equals("endedAt")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1335157162:
                    if (nextName.equals("device")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1291329255:
                    if (nextName.equals("events")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        c = 5;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3599307:
                    if (nextName.equals("user")) {
                        c = 7;
                        break;
                    }
                    break;
                case 286956243:
                    if (nextName.equals("generator")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1025385094:
                    if (nextName.equals("crashed")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 2047016109:
                    if (nextName.equals("generatorType")) {
                        c = '\n';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m6954a.mo6992l(jsonReader.nextLong());
                    break;
                case 1:
                    m6954a.m6990j(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 2:
                    m6954a.mo6985e(Long.valueOf(jsonReader.nextLong()));
                    break;
                case 3:
                    m6954a.mo6984d(m1800n(jsonReader));
                    break;
                case 4:
                    m6954a.mo6986f(m1798l(jsonReader, qa0.m7642b()));
                    break;
                case 5:
                    m6954a.mo6991k(m1785A(jsonReader));
                    break;
                case 6:
                    m6954a.mo6982b(m1797k(jsonReader));
                    break;
                case 7:
                    m6954a.mo6993m(m1788D(jsonReader));
                    break;
                case '\b':
                    m6954a.mo6987g(jsonReader.nextString());
                    break;
                case '\t':
                    m6954a.mo6983c(jsonReader.nextBoolean());
                    break;
                case '\n':
                    m6954a.mo6988h(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return m6954a.mo6981a();
    }

    @NonNull
    /* renamed from: D */
    public static oa0.AbstractC1645d.f m1788D(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1645d.f.a m7008a = oa0.AbstractC1645d.f.m7008a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("identifier")) {
                m7008a.mo6656b(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return m7008a.mo6655a();
    }

    /* renamed from: a */
    public static /* synthetic */ void m1789a(Throwable th, AutoCloseable autoCloseable) {
        if (th == null) {
            autoCloseable.close();
        } else {
            try {
                autoCloseable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    @NonNull
    /* renamed from: k */
    public static oa0.AbstractC1645d.a m1797k(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1645d.a.AbstractC2501a m6970a = oa0.AbstractC1645d.a.m6970a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c = 0;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c = 1;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m6970a.mo6978c(jsonReader.nextString());
                    break;
                case 1:
                    m6970a.mo6980e(jsonReader.nextString());
                    break;
                case 2:
                    m6970a.mo6979d(jsonReader.nextString());
                    break;
                case 3:
                    m6970a.mo6977b(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return m6970a.mo6976a();
    }

    @NonNull
    /* renamed from: l */
    public static <T> pa0<T> m1798l(@NonNull JsonReader jsonReader, @NonNull ObjectParser<T> objectParser) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(objectParser.mo1817a(jsonReader));
        }
        jsonReader.endArray();
        return pa0.m7255e(arrayList);
    }

    @NonNull
    /* renamed from: m */
    public static oa0.AbstractC1643b m1799m(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1643b.a m6936a = oa0.AbstractC1643b.m6936a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("key")) {
                m6936a.mo6940b(jsonReader.nextString());
            } else if (nextName.equals("value")) {
                m6936a.mo6941c(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return m6936a.mo6939a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    @NonNull
    /* renamed from: n */
    public static oa0.AbstractC1645d.c m1800n(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1645d.c.a m6994a = oa0.AbstractC1645d.c.m6994a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1981332476:
                    if (nextName.equals("simulator")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1969347631:
                    if (nextName.equals("manufacturer")) {
                        c = 1;
                        break;
                    }
                    break;
                case 112670:
                    if (nextName.equals("ram")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c = 3;
                        break;
                    }
                    break;
                case 81784169:
                    if (nextName.equals("diskSpace")) {
                        c = 4;
                        break;
                    }
                    break;
                case 94848180:
                    if (nextName.equals("cores")) {
                        c = 5;
                        break;
                    }
                    break;
                case 104069929:
                    if (nextName.equals("model")) {
                        c = 6;
                        break;
                    }
                    break;
                case 109757585:
                    if (nextName.equals("state")) {
                        c = 7;
                        break;
                    }
                    break;
                case 2078953423:
                    if (nextName.equals("modelClass")) {
                        c = '\b';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m6994a.mo2425i(jsonReader.nextBoolean());
                    break;
                case 1:
                    m6994a.mo2421e(jsonReader.nextString());
                    break;
                case 2:
                    m6994a.mo2424h(jsonReader.nextLong());
                    break;
                case 3:
                    m6994a.mo2418b(jsonReader.nextInt());
                    break;
                case 4:
                    m6994a.mo2420d(jsonReader.nextLong());
                    break;
                case 5:
                    m6994a.mo2419c(jsonReader.nextInt());
                    break;
                case 6:
                    m6994a.mo2422f(jsonReader.nextString());
                    break;
                case 7:
                    m6994a.mo2426j(jsonReader.nextInt());
                    break;
                case '\b':
                    m6994a.mo2423g(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return m6994a.mo2417a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    @NonNull
    /* renamed from: o */
    public static oa0.AbstractC1645d.d m1801o(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1645d.d.b m6995a = oa0.AbstractC1645d.d.m6995a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1335157162:
                    if (nextName.equals("device")) {
                        c = 0;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c = 1;
                        break;
                    }
                    break;
                case 107332:
                    if (nextName.equals("log")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE)) {
                        c = 3;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals("timestamp")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m6995a.mo2743c(m1804r(jsonReader));
                    break;
                case 1:
                    m6995a.mo2742b(m1802p(jsonReader));
                    break;
                case 2:
                    m6995a.mo2744d(m1808v(jsonReader));
                    break;
                case 3:
                    m6995a.mo2746f(jsonReader.nextString());
                    break;
                case 4:
                    m6995a.mo2745e(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return m6995a.mo2741a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    @NonNull
    /* renamed from: p */
    public static oa0.AbstractC1645d.d.a m1802p(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1645d.d.a.AbstractC2502a m6996a = oa0.AbstractC1645d.d.a.m6996a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1332194002:
                    if (nextName.equals("background")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1090974952:
                    if (nextName.equals("execution")) {
                        c = 1;
                        break;
                    }
                    break;
                case 555169704:
                    if (nextName.equals("customAttributes")) {
                        c = 2;
                        break;
                    }
                    break;
                case 928737948:
                    if (nextName.equals("uiOrientation")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m6996a.mo3177b(Boolean.valueOf(jsonReader.nextBoolean()));
                    break;
                case 1:
                    m6996a.mo3179d(m1805s(jsonReader));
                    break;
                case 2:
                    m6996a.mo3178c(m1798l(jsonReader, sa0.m8419b()));
                    break;
                case 3:
                    m6996a.mo3180e(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return m6996a.mo3176a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001a. Please report as an issue. */
    @NonNull
    /* renamed from: q */
    public static oa0.AbstractC1645d.d.a.b.AbstractC2503a m1803q(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1645d.d.a.b.AbstractC2503a.AbstractC2504a m6998a = oa0.AbstractC1645d.d.a.b.AbstractC2503a.m6998a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 3373707:
                    if (nextName.equals("name")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3530753:
                    if (nextName.equals("size")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3601339:
                    if (nextName.equals("uuid")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1153765347:
                    if (nextName.equals("baseAddress")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m6998a.mo3703c(jsonReader.nextString());
                    break;
                case 1:
                    m6998a.mo3704d(jsonReader.nextLong());
                    break;
                case 2:
                    m6998a.m7000f(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 3:
                    m6998a.mo3702b(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return m6998a.mo3701a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    @NonNull
    /* renamed from: r */
    public static oa0.AbstractC1645d.d.c m1804r(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1645d.d.c.a m7005a = oa0.AbstractC1645d.d.c.m7005a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1708606089:
                    if (nextName.equals("batteryLevel")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1455558134:
                    if (nextName.equals("batteryVelocity")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1439500848:
                    if (nextName.equals("orientation")) {
                        c = 2;
                        break;
                    }
                    break;
                case 279795450:
                    if (nextName.equals("diskUsed")) {
                        c = 3;
                        break;
                    }
                    break;
                case 976541947:
                    if (nextName.equals("ramUsed")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1516795582:
                    if (nextName.equals("proximityOn")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m7005a.mo5859b(Double.valueOf(jsonReader.nextDouble()));
                    break;
                case 1:
                    m7005a.mo5860c(jsonReader.nextInt());
                    break;
                case 2:
                    m7005a.mo5862e(jsonReader.nextInt());
                    break;
                case 3:
                    m7005a.mo5861d(jsonReader.nextLong());
                    break;
                case 4:
                    m7005a.mo5864g(jsonReader.nextLong());
                    break;
                case 5:
                    m7005a.mo5863f(jsonReader.nextBoolean());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return m7005a.mo5858a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    @NonNull
    /* renamed from: s */
    public static oa0.AbstractC1645d.d.a.b m1805s(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1645d.d.a.b.AbstractC2505b m6997a = oa0.AbstractC1645d.d.a.b.m6997a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1337936983:
                    if (nextName.equals("threads")) {
                        c = 0;
                        break;
                    }
                    break;
                case -902467928:
                    if (nextName.equals("signal")) {
                        c = 1;
                        break;
                    }
                    break;
                case 937615455:
                    if (nextName.equals("binaries")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1481625679:
                    if (nextName.equals("exception")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m6997a.mo3469e(m1798l(jsonReader, ta0.m8636b()));
                    break;
                case 1:
                    m6997a.mo3468d(m1809w(jsonReader));
                    break;
                case 2:
                    m6997a.mo3466b(m1798l(jsonReader, ua0.m8863b()));
                    break;
                case 3:
                    m6997a.mo3467c(m1806t(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return m6997a.mo3465a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    @NonNull
    /* renamed from: t */
    public static oa0.AbstractC1645d.d.a.b.c m1806t(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1645d.d.a.b.c.AbstractC2506a m7001a = oa0.AbstractC1645d.d.a.b.c.m7001a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
                        c = 0;
                        break;
                    }
                    break;
                case -934964668:
                    if (nextName.equals("reason")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE)) {
                        c = 2;
                        break;
                    }
                    break;
                case 91997906:
                    if (nextName.equals("causedBy")) {
                        c = 3;
                        break;
                    }
                    break;
                case 581754413:
                    if (nextName.equals("overflowCount")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m7001a.mo4106c(m1798l(jsonReader, va0.m9206b()));
                    break;
                case 1:
                    m7001a.mo4108e(jsonReader.nextString());
                    break;
                case 2:
                    m7001a.mo4109f(jsonReader.nextString());
                    break;
                case 3:
                    m7001a.mo4105b(m1806t(jsonReader));
                    break;
                case 4:
                    m7001a.mo4107d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return m7001a.mo4104a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    @NonNull
    /* renamed from: u */
    public static oa0.AbstractC1645d.d.a.b.e.AbstractC2510b m1807u(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.AbstractC2511a m7004a = oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.m7004a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1019779949:
                    if (nextName.equals("offset")) {
                        c = 0;
                        break;
                    }
                    break;
                case -887523944:
                    if (nextName.equals("symbol")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3571:
                    if (nextName.equals("pc")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3143036:
                    if (nextName.equals("file")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m7004a.mo5096d(jsonReader.nextLong());
                    break;
                case 1:
                    m7004a.mo5098f(jsonReader.nextString());
                    break;
                case 2:
                    m7004a.mo5097e(jsonReader.nextLong());
                    break;
                case 3:
                    m7004a.mo5094b(jsonReader.nextString());
                    break;
                case 4:
                    m7004a.mo5095c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return m7004a.mo5093a();
    }

    @NonNull
    /* renamed from: v */
    public static oa0.AbstractC1645d.d.AbstractC2512d m1808v(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1645d.d.AbstractC2512d.a m7006a = oa0.AbstractC1645d.d.AbstractC2512d.m7006a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("content")) {
                m7006a.mo6102b(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return m7006a.mo6101a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    @NonNull
    /* renamed from: w */
    public static oa0.AbstractC1645d.d.a.b.AbstractC2507d m1809w(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1645d.d.a.b.AbstractC2507d.AbstractC2508a m7002a = oa0.AbstractC1645d.d.a.b.AbstractC2507d.m7002a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1147692044:
                    if (nextName.equals("address")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3059181:
                    if (nextName.equals("code")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals("name")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m7002a.mo4425b(jsonReader.nextLong());
                    break;
                case 1:
                    m7002a.mo4426c(jsonReader.nextString());
                    break;
                case 2:
                    m7002a.mo4427d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return m7002a.mo4424a();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    @NonNull
    /* renamed from: x */
    public static oa0.AbstractC1645d.d.a.b.e m1810x(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1645d.d.a.b.e.AbstractC2509a m7003a = oa0.AbstractC1645d.d.a.b.e.m7003a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals("name")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m7003a.mo4736b(m1798l(jsonReader, wa0.m9458b()));
                    break;
                case 1:
                    m7003a.mo4738d(jsonReader.nextString());
                    break;
                case 2:
                    m7003a.mo4737c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return m7003a.mo4735a();
    }

    @NonNull
    /* renamed from: y */
    public static oa0.AbstractC1644c.b m1811y(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1644c.b.a m6948a = oa0.AbstractC1644c.b.m6948a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("filename")) {
                m6948a.mo6953c(jsonReader.nextString());
            } else if (nextName.equals("contents")) {
                m6948a.mo6952b(Base64.decode(jsonReader.nextString(), 2));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return m6948a.mo6951a();
    }

    @NonNull
    /* renamed from: z */
    public static oa0.AbstractC1644c m1812z(@NonNull JsonReader jsonReader) throws IOException {
        oa0.AbstractC1644c.a m6942a = oa0.AbstractC1644c.m6942a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("files")) {
                m6942a.mo6946b(m1798l(jsonReader, ra0.m7901b()));
            } else if (nextName.equals("orgId")) {
                m6942a.mo6947c(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return m6942a.mo6945a();
    }

    @NonNull
    /* renamed from: E */
    public oa0 m1813E(@NonNull String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                oa0 m1786B = m1786B(jsonReader);
                m1789a(null, jsonReader);
                return m1786B;
            } finally {
            }
        } catch (IllegalStateException e) {
            throw new IOException(e);
        }
    }

    @NonNull
    /* renamed from: F */
    public String m1814F(@NonNull oa0 oa0Var) {
        return f1237a.mo1851b(oa0Var);
    }

    @NonNull
    /* renamed from: i */
    public oa0.AbstractC1645d.d m1815i(@NonNull String str) throws IOException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                oa0.AbstractC1645d.d m1801o = m1801o(jsonReader);
                m1789a(null, jsonReader);
                return m1801o;
            } finally {
            }
        } catch (IllegalStateException e) {
            throw new IOException(e);
        }
    }

    @NonNull
    /* renamed from: j */
    public String m1816j(@NonNull oa0.AbstractC1645d.d dVar) {
        return f1237a.mo1851b(dVar);
    }
}
