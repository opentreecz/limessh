package cz.opentree;

import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.net.Uri;
import android.util.Pair;
import android.util.Patterns;
import android.util.TypedValue;
import cz.opentree.limessh.R;
import java.util.regex.Matcher;

/* compiled from: URLScan.java */
/* loaded from: classes.dex */
public class cl0 {

    /* compiled from: URLScan.java */
    /* renamed from: cz.opentree.cl0$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0835a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f1978a;

        static {
            int[] iArr = new int[EnumC0836b.values().length];
            f1978a = iArr;
            try {
                iArr[EnumC0836b.BROWSER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1978a[EnumC0836b.EMAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1978a[EnumC0836b.PHONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: URLScan.java */
    /* renamed from: cz.opentree.cl0$b */
    /* loaded from: classes.dex */
    public enum EnumC0836b {
        NOTAURL,
        BROWSER,
        ABSOLUTEPATH,
        PHONE,
        EMAIL,
        TWITTER,
        SSH,
        SFTP,
        FTP,
        MARKETPLACE
    }

    /* renamed from: a */
    public static RectF[] m2868a(Context context, float f, float f2, float f3) {
        float applyDimension = TypedValue.applyDimension(1, 48.0f, context.getResources().getDisplayMetrics());
        float f4 = applyDimension / 2.0f;
        float f5 = f + f4;
        RectF rectF = new RectF(f - f4, f2 - f4, f5, f2 + f4);
        int i = (int) (applyDimension / f3);
        int i2 = i * i;
        RectF[] rectFArr = new RectF[i2];
        float f6 = rectF.left;
        float f7 = rectF.top;
        float f8 = f6 + f3;
        float f9 = f7 + f3;
        for (int i3 = 0; i3 < i2; i3++) {
            if (rectF.contains(f6, f7, f8, f9)) {
                rectFArr[i3] = new RectF(f6, f7, f8, f9);
            } else {
                if (f8 > f5) {
                    f6 = rectF.left;
                    f7 += f3;
                    f8 = f6 + f3;
                    f9 += f3;
                    if (rectF.contains(f6, f7, f8, f9)) {
                        rectFArr[i3] = new RectF(f6, f7, f8, f9);
                    }
                }
            }
            f6 += f3;
            f8 += f3;
        }
        return rectFArr;
    }

    /* renamed from: b */
    public static Pair<EnumC0836b, String> m2869b(String str) {
        Matcher matcher = Patterns.WEB_URL.matcher(str);
        if (matcher.find()) {
            String substring = str.substring(matcher.start(), matcher.end());
            if (substring.startsWith("http://") || substring.startsWith("https://")) {
                return new Pair<>(EnumC0836b.BROWSER, substring);
            }
        }
        return new Pair<>(EnumC0836b.NOTAURL, null);
    }

    /* renamed from: c */
    public static boolean m2870c(Context context, String str) {
        Pair<EnumC0836b, String> m2869b = m2869b(str);
        int i = C0835a.f1978a[((EnumC0836b) m2869b.first).ordinal()];
        if (i == 1) {
            Uri parse = Uri.parse((String) m2869b.second);
            if (parse.getScheme() == null) {
                parse = Uri.parse("http://" + ((String) m2869b.second));
            }
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            intent.addFlags(1074266112);
            context.startActivity(Intent.createChooser(intent, String.format(context.getString(R.string.open_address), m2869b.second)));
            return true;
        }
        if (i == 2) {
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.putExtra("android.intent.extra.EMAIL", new String[]{(String) m2869b.second});
            intent2.setType("plain/text");
            context.startActivity(Intent.createChooser(intent2, String.format(context.getString(R.string.email_person), m2869b.second)));
            return true;
        }
        if (i != 3) {
            return false;
        }
        context.startActivity(Intent.createChooser(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + ((String) m2869b.second))), String.format(context.getString(R.string.dial_number), m2869b.second)));
        return true;
    }
}
