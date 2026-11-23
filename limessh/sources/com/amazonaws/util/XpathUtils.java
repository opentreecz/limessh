package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class XpathUtils {

    /* renamed from: a */
    public static Log f498a = LogFactory.m237c(XpathUtils.class);

    /* renamed from: b */
    public static DocumentBuilderFactory f499b = DocumentBuilderFactory.newInstance();

    /* renamed from: a */
    public static Node m704a(String str, Node node) throws XPathExpressionException {
        if (node == null) {
            return null;
        }
        return (Node) m710g().evaluate(str, node, XPathConstants.NODE);
    }

    /* renamed from: b */
    public static String m705b(String str, Node node) throws XPathExpressionException {
        return m708e(str, node);
    }

    /* renamed from: c */
    public static Document m706c(InputStream inputStream) throws SAXException, IOException, ParserConfigurationException {
        NamespaceRemovingInputStream namespaceRemovingInputStream = new NamespaceRemovingInputStream(inputStream);
        Document parse = f499b.newDocumentBuilder().parse(namespaceRemovingInputStream);
        namespaceRemovingInputStream.close();
        return parse;
    }

    /* renamed from: d */
    public static Document m707d(String str) throws SAXException, IOException, ParserConfigurationException {
        return m706c(new ByteArrayInputStream(str.getBytes(StringUtils.f489a)));
    }

    /* renamed from: e */
    public static String m708e(String str, Node node) throws XPathExpressionException {
        if (m709f(node)) {
            return null;
        }
        if (".".equals(str) || m704a(str, node) != null) {
            return m710g().evaluate(str, node).trim();
        }
        return null;
    }

    /* renamed from: f */
    public static boolean m709f(Node node) {
        return node == null;
    }

    /* renamed from: g */
    public static XPath m710g() {
        return XPathFactory.newInstance().newXPath();
    }
}
