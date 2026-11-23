package com.amazonaws.regions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Deprecated
/* loaded from: classes.dex */
public class RegionMetadataParser {
    @Deprecated
    public RegionMetadataParser() {
    }

    /* renamed from: a */
    public static void m261a(Region region, Element element, boolean z) {
        String m262b = m262b("ServiceName", element);
        String m262b2 = m262b("Hostname", element);
        String m262b3 = m262b("Http", element);
        String m262b4 = m262b("Https", element);
        if (!z || m265f(m262b2)) {
            region.m258f().put(m262b, m262b2);
            region.m254a().put(m262b, Boolean.valueOf("true".equals(m262b3)));
            region.m255b().put(m262b, Boolean.valueOf("true".equals(m262b4)));
        } else {
            throw new IllegalStateException("Invalid service endpoint (" + m262b2 + ") is detected.");
        }
    }

    /* renamed from: b */
    public static String m262b(String str, Element element) {
        Node item = element.getElementsByTagName(str).item(0);
        if (item == null) {
            return null;
        }
        return item.getChildNodes().item(0).getNodeValue();
    }

    /* renamed from: c */
    public static List<Region> m263c(InputStream inputStream, boolean z) throws IOException {
        try {
            try {
                Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                NodeList elementsByTagName = parse.getElementsByTagName("Region");
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < elementsByTagName.getLength(); i++) {
                    Node item = elementsByTagName.item(i);
                    if (item.getNodeType() == 1) {
                        arrayList.add(m264d((Element) item, z));
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            throw new IOException("Unable to parse region metadata file: " + e2.getMessage(), e2);
        }
    }

    /* renamed from: d */
    public static Region m264d(Element element, boolean z) {
        Region region = new Region(m262b("Name", element), m262b("Domain", element));
        NodeList elementsByTagName = element.getElementsByTagName("Endpoint");
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            m261a(region, (Element) elementsByTagName.item(i), z);
        }
        return region;
    }

    /* renamed from: f */
    public static boolean m265f(String str) {
        return str.endsWith(".amazonaws.com");
    }

    @Deprecated
    /* renamed from: e */
    public List<Region> m266e(InputStream inputStream) throws IOException {
        return m263c(inputStream, false);
    }
}
