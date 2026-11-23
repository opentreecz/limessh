package com.amazonaws.auth;

import com.amazonaws.internal.config.InternalConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class SignerFactory {

    /* renamed from: a */
    public static final Map<String, Class<? extends Signer>> f104a;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f104a = concurrentHashMap;
        concurrentHashMap.put("QueryStringSignerType", QueryStringSigner.class);
        concurrentHashMap.put("AWS3SignerType", AWS3Signer.class);
        concurrentHashMap.put("AWS4SignerType", AWS4Signer.class);
        concurrentHashMap.put("NoOpSignerType", NoOpSigner.class);
    }

    /* renamed from: a */
    public static Signer m127a(String str, String str2) {
        Class<? extends Signer> cls = f104a.get(str);
        if (cls == null) {
            throw new IllegalArgumentException();
        }
        try {
            Signer newInstance = cls.newInstance();
            if (newInstance instanceof ServiceAwareSigner) {
                ((ServiceAwareSigner) newInstance).mo91a(str2);
            }
            return newInstance;
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Cannot create an instance of " + cls.getName(), e);
        } catch (InstantiationException e2) {
            throw new IllegalStateException("Cannot create an instance of " + cls.getName(), e2);
        }
    }

    /* renamed from: b */
    public static Signer m128b(String str, String str2) {
        return m130d(str, str2);
    }

    /* renamed from: c */
    public static Signer m129c(String str, String str2) {
        return m127a(str, str2);
    }

    /* renamed from: d */
    public static Signer m130d(String str, String str2) {
        return m127a(InternalConfig.Factory.m223a().m222i(str, str2).m224a(), str);
    }
}
