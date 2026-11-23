package com.amazonaws.regions;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class RegionUtils {

    /* renamed from: a */
    public static List<Region> f195a;

    /* renamed from: b */
    public static final Log f196b = LogFactory.m238d("com.amazonaws.request");

    /* renamed from: a */
    public static Region m267a(String str) {
        for (Region region : m269c()) {
            if (region.m256c().equals(str)) {
                return region;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static Region m268b(String str) {
        String host = m270d(str).getHost();
        for (Region region : m269c()) {
            Iterator<String> it = region.m258f().values().iterator();
            while (it.hasNext()) {
                if (m270d(it.next()).getHost().equals(host)) {
                    return region;
                }
            }
        }
        throw new IllegalArgumentException("No region found with any service for endpoint " + str);
    }

    /* renamed from: c */
    public static synchronized List<Region> m269c() {
        List<Region> list;
        synchronized (RegionUtils.class) {
            if (f195a == null) {
                m271e();
            }
            list = f195a;
        }
        return list;
    }

    /* renamed from: d */
    public static URI m270d(String str) {
        try {
            URI uri = new URI(str);
            if (uri.getHost() != null) {
                return uri;
            }
            return new URI("http://" + str);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Unable to parse service endpoint: " + e.getMessage());
        }
    }

    /* renamed from: e */
    public static synchronized void m271e() {
        synchronized (RegionUtils.class) {
            if (System.getProperty("com.amazonaws.regions.RegionUtils.fileOverride") != null) {
                try {
                    m274h();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException("Couldn't find regions override file specified", e);
                }
            }
            if (f195a == null) {
                m273g();
            }
            if (f195a == null) {
                throw new RuntimeException("Failed to initialize the regions.");
            }
        }
    }

    /* renamed from: f */
    public static void m272f(InputStream inputStream) {
        try {
            f195a = new RegionMetadataParser().m266e(inputStream);
        } catch (Exception e) {
            f196b.mo230f("Failed to parse regional endpoints", e);
        }
    }

    /* renamed from: g */
    public static void m273g() {
        Log log = f196b;
        if (log.mo227c()) {
            log.mo225a("Initializing the regions with default regions");
        }
        f195a = RegionDefaults.m259a();
    }

    /* renamed from: h */
    public static void m274h() throws FileNotFoundException {
        String property = System.getProperty("com.amazonaws.regions.RegionUtils.fileOverride");
        Log log = f196b;
        if (log.mo227c()) {
            log.mo225a("Using local override of the regions file (" + property + ") to initiate regions data...");
        }
        m272f(new FileInputStream(new File(property)));
    }
}
