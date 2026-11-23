package com.sonelli.juicessh.models;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Book {

    /* renamed from: a */
    public String f4072a;

    /* renamed from: b */
    public String f4073b;

    /* renamed from: c */
    public String f4074c;

    /* renamed from: d */
    public String f4075d;

    /* renamed from: e */
    public String f4076e;

    /* renamed from: f */
    public static Book m5449f(JSONObject jSONObject) {
        try {
            Book book = new Book();
            JSONObject jSONObject2 = jSONObject.getJSONObject("book");
            if (jSONObject2.has("title")) {
                book.f4072a = jSONObject2.getString("title");
            }
            if (jSONObject2.has("asin")) {
                jSONObject2.getString("asin");
            }
            if (jSONObject2.has("description")) {
                book.f4073b = jSONObject2.getString("description");
            }
            if (jSONObject2.has("icon")) {
                book.f4074c = jSONObject2.getString("icon");
            }
            if (jSONObject2.has("author")) {
                book.f4075d = jSONObject2.getString("author");
            }
            if (jSONObject2.has("isbn")) {
                jSONObject2.getString("isbn");
            }
            if (jSONObject.has("affiliateurl")) {
                book.f4076e = jSONObject.getString("affiliateurl");
            }
            return book;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public String m5450a() {
        return this.f4075d;
    }

    /* renamed from: b */
    public String m5451b() {
        return this.f4073b;
    }

    /* renamed from: c */
    public String m5452c() {
        return this.f4074c;
    }

    /* renamed from: d */
    public String m5453d() {
        return this.f4072a;
    }

    /* renamed from: e */
    public String m5454e() {
        return this.f4076e;
    }
}
