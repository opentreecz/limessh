package com.amazonaws.transform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class StaxUnmarshallerContext {

    /* renamed from: a */
    public int f431a;

    /* renamed from: b */
    public final XmlPullParser f432b;

    /* renamed from: c */
    public final Deque<String> f433c = new LinkedList();

    /* renamed from: d */
    public String f434d = "";

    /* renamed from: e */
    public Map<String, String> f435e = new HashMap();

    /* renamed from: f */
    public List<MetadataExpression> f436f = new ArrayList();

    /* renamed from: g */
    public final Map<String, String> f437g;

    /* loaded from: classes.dex */
    public static class MetadataExpression {

        /* renamed from: a */
        public String f438a;

        /* renamed from: b */
        public int f439b;

        /* renamed from: c */
        public String f440c;

        public MetadataExpression(String str, int i, String str2) {
            this.f438a = str;
            this.f439b = i;
            this.f440c = str2;
        }
    }

    public StaxUnmarshallerContext(XmlPullParser xmlPullParser, Map<String, String> map) {
        this.f432b = xmlPullParser;
        this.f437g = map;
    }

    /* renamed from: a */
    public int m615a() {
        return this.f433c.size();
    }

    /* renamed from: b */
    public Map<String, String> m616b() {
        return this.f435e;
    }

    /* renamed from: c */
    public boolean m617c() {
        return this.f431a == 0;
    }

    /* renamed from: d */
    public int m618d() throws XmlPullParserException, IOException {
        int next = this.f432b.next();
        this.f431a = next;
        if (next == 4) {
            this.f431a = this.f432b.next();
        }
        m622h();
        if (this.f431a == 2) {
            Iterator<MetadataExpression> it = this.f436f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MetadataExpression next2 = it.next();
                if (m621g(next2.f438a, next2.f439b)) {
                    this.f435e.put(next2.f440c, m619e());
                    break;
                }
            }
        }
        return this.f431a;
    }

    /* renamed from: e */
    public String m619e() throws XmlPullParserException, IOException {
        String nextText = this.f432b.nextText();
        if (this.f432b.getEventType() != 3) {
            this.f432b.next();
        }
        this.f431a = this.f432b.getEventType();
        m622h();
        return nextText;
    }

    /* renamed from: f */
    public void m620f(String str, int i, String str2) {
        this.f436f.add(new MetadataExpression(str, i, str2));
    }

    /* renamed from: g */
    public boolean m621g(String str, int i) {
        if (".".equals(str)) {
            return true;
        }
        int i2 = -1;
        while (true) {
            i2 = str.indexOf("/", i2 + 1);
            if (i2 <= -1) {
                break;
            }
            if (str.charAt(i2 + 1) != '@') {
                i++;
            }
        }
        if (m615a() == i) {
            if (this.f434d.endsWith("/" + str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    public final void m622h() {
        int i = this.f431a;
        if (i != 2) {
            if (i == 3) {
                this.f433c.pop();
                this.f434d = this.f433c.isEmpty() ? "" : this.f433c.peek();
                return;
            }
            return;
        }
        String str = this.f434d + "/" + this.f432b.getName();
        this.f434d = str;
        this.f433c.push(str);
    }
}
