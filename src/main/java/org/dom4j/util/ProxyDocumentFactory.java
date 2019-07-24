

package org.dom4j.util;

import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.CDATA;
import org.dom4j.Comment;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentType;
import org.dom4j.Element;
import org.dom4j.Entity;
import org.dom4j.Namespace;
import org.dom4j.NodeFilter;
import org.dom4j.ProcessingInstruction;
import org.dom4j.QName;
import org.dom4j.Text;
import org.dom4j.XPath;
import org.dom4j.rule.Pattern;

import org.jaxen.VariableContext;

/**
 * <p>
 * <code>ProxyDocumentFactory</code> implements a proxy to a DocumentFactory
 * which is useful for implementation inheritence, allowing the pipelining of
 * various factory implementations. For example an EncodingDocumentFactory which
 * takes care of encoding strings outside of allowable XML ranges could be used
 * with a DatatypeDocumentFactory which is XML Schema Data Type aware.
 * </p>
 * 
 * @author <a href="mailto:jstrachan@apache.org">James Strachan </a>
 * @version $Revision: 1.13 $
 */
public abstract class ProxyDocumentFactory {
    private DocumentFactory proxy;

    public ProxyDocumentFactory() {
        // use default factory
        this.proxy = DocumentFactory.getInstance();
    }

    public ProxyDocumentFactory(DocumentFactory proxy) {
        this.proxy = proxy;
    }

    // Factory methods
    // -------------------------------------------------------------------------
    public Document createDocument() {
        return proxy.createDocument();
    }

    public Document createDocument(Element rootElement) {
        return proxy.createDocument(rootElement);
    }

    public DocumentType createDocType(String name, String publicId,
            String systemId) {
        return proxy.createDocType(name, publicId, systemId);
    }

    public Element createElement(QName qname) {
        return proxy.createElement(qname);
    }

    public Element createElement(String name) {
        return proxy.createElement(name);
    }

    public Attribute createAttribute(Element owner, QName qname, String value) {
        return proxy.createAttribute(owner, qname, value);
    }

    public Attribute createAttribute(Element owner, String name, String value) {
        return proxy.createAttribute(owner, name, value);
    }

    public CDATA createCDATA(String text) {
        return proxy.createCDATA(text);
    }

    public Comment createComment(String text) {
        return proxy.createComment(text);
    }

    public Text createText(String text) {
        return proxy.createText(text);
    }

    public Entity createEntity(String name, String text) {
        return proxy.createEntity(name, text);
    }

    public Namespace createNamespace(String prefix, String uri) {
        return proxy.createNamespace(prefix, uri);
    }

    public ProcessingInstruction createProcessingInstruction(String target,
            String data) {
        return proxy.createProcessingInstruction(target, data);
    }

    public ProcessingInstruction createProcessingInstruction(String target,
            Map<String, String> data) {
        return proxy.createProcessingInstruction(target, data);
    }

    public QName createQName(String localName, Namespace namespace) {
        return proxy.createQName(localName, namespace);
    }

    public QName createQName(String localName) {
        return proxy.createQName(localName);
    }

    public QName createQName(String name, String prefix, String uri) {
        return proxy.createQName(name, prefix, uri);
    }

    public QName createQName(String qualifiedName, String uri) {
        return proxy.createQName(qualifiedName, uri);
    }

    public XPath createXPath(String xpathExpression) {
        return proxy.createXPath(xpathExpression);
    }

    public XPath createXPath(String xpathExpression,
            VariableContext variableContext) {
        return proxy.createXPath(xpathExpression, variableContext);
    }

    public NodeFilter createXPathFilter(String xpathFilterExpression,
            VariableContext variableContext) {
        return proxy.createXPathFilter(xpathFilterExpression, variableContext);
    }

    public NodeFilter createXPathFilter(String xpathFilterExpression) {
        return proxy.createXPathFilter(xpathFilterExpression);
    }

    public Pattern createPattern(String xpathPattern) {
        return proxy.createPattern(xpathPattern);
    }

    // Implementation methods
    // -------------------------------------------------------------------------
    protected DocumentFactory getProxy() {
        return proxy;
    }

    protected void setProxy(DocumentFactory proxy) {
        if (proxy == null) {
            // use default factory
            proxy = DocumentFactory.getInstance();
        }

        this.proxy = proxy;
    }
}

