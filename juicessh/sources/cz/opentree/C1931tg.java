package cz.opentree;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.google.android.gms.internal.gtm.zzbn;
import com.google.android.gms.internal.gtm.zzbp;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: cz.opentree.tg */
/* loaded from: classes.dex */
public class C1931tg<T extends zzbn> extends C1930tf {

    /* renamed from: P */
    public zzbp<T> f6765P;

    public C1931tg(C2216wf c2216wf, zzbp<T> zzbpVar) {
        super(c2216wf);
        this.f6765P = zzbpVar;
    }

    /* renamed from: C0 */
    public final T m8681C0(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String lowerCase = xmlResourceParser.getName().toLowerCase(Locale.US);
                    if (lowerCase.equals("screenname")) {
                        String attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        String trim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(trim)) {
                            this.f6765P.mo1213f(attributeValue, trim);
                        }
                    } else if (lowerCase.equals("string")) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && trim2 != null) {
                            this.f6765P.mo1212d(attributeValue2, trim2);
                        }
                    } else if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(trim3)) {
                            try {
                                this.f6765P.mo1214p(attributeValue3, Boolean.parseBoolean(trim3));
                            } catch (NumberFormatException e) {
                                m8657e0("Error parsing bool configuration value", trim3, e);
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim4 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(trim4)) {
                            try {
                                this.f6765P.mo1211c(attributeValue4, Integer.parseInt(trim4));
                            } catch (NumberFormatException e2) {
                                m8657e0("Error parsing int configuration value", trim4, e2);
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException | XmlPullParserException e3) {
            m8674w0("Error parsing tracker configuration file", e3);
        }
        return this.f6765P.mo1210b();
    }

    /* renamed from: D0 */
    public final T m8682D0(int i) {
        try {
            return m8681C0(m8658f0().m9486n().getResources().getXml(i));
        } catch (Resources.NotFoundException e) {
            m8672t0("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
