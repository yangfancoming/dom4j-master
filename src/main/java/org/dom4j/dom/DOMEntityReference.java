

package org.dom4j.dom;

import org.dom4j.Element;
import org.dom4j.tree.DefaultEntity;
import org.w3c.dom.*;

/**
 * <p>
 * <code>DOMEntity</code> implements a Entity node which supports the W3C DOM
 * API.
 * </p>
 * 
 * @author <a href="mailto:jstrachan@apache.org">James Strachan </a>
 * @version $Revision: 1.12 $
 */
public class DOMEntityReference extends DefaultEntity implements
        org.w3c.dom.EntityReference {
    public DOMEntityReference(String name) {
        super(name);
    }

    public DOMEntityReference(String name, String text) {
        super(name, text);
    }

    public DOMEntityReference(Element parent, String name, String text) {
        super(parent, name, text);
    }

    // org.w3c.dom.Node interface
    // -------------------------------------------------------------------------
    public boolean supports(String feature, String version) {
        return DOMNodeHelper.supports(this, feature, version);
    }

    public String getNamespaceURI() {
        return DOMNodeHelper.getNamespaceURI(this);
    }

    public String getPrefix() {
        return DOMNodeHelper.getPrefix(this);
    }

    public void setPrefix(String prefix) throws DOMException {
        DOMNodeHelper.setPrefix(this, prefix);
    }

    public String getLocalName() {
        return DOMNodeHelper.getLocalName(this);
    }

    public String getNodeName() {
        return getName();
    }

    // already part of API
    //
    // public short getNodeType();
    public String getNodeValue() throws DOMException {
        return null;
    }

    public void setNodeValue(String nodeValue) throws DOMException {
    }

    public org.w3c.dom.Node getParentNode() {
        return DOMNodeHelper.getParentNode(this);
    }

    public NodeList getChildNodes() {
        return DOMNodeHelper.getChildNodes(this);
    }

    public org.w3c.dom.Node getFirstChild() {
        return DOMNodeHelper.getFirstChild(this);
    }

    public org.w3c.dom.Node getLastChild() {
        return DOMNodeHelper.getLastChild(this);
    }

    public org.w3c.dom.Node getPreviousSibling() {
        return DOMNodeHelper.getPreviousSibling(this);
    }

    public org.w3c.dom.Node getNextSibling() {
        return DOMNodeHelper.getNextSibling(this);
    }

    public NamedNodeMap getAttributes() {
        return null;
    }

    public Document getOwnerDocument() {
        return DOMNodeHelper.getOwnerDocument(this);
    }

    public org.w3c.dom.Node insertBefore(org.w3c.dom.Node newChild,
            org.w3c.dom.Node refChild) throws DOMException {
        checkNewChildNode(newChild);

        return DOMNodeHelper.insertBefore(this, newChild, refChild);
    }

    public org.w3c.dom.Node replaceChild(org.w3c.dom.Node newChild,
            org.w3c.dom.Node oldChild) throws DOMException {
        checkNewChildNode(newChild);

        return DOMNodeHelper.replaceChild(this, newChild, oldChild);
    }

    public org.w3c.dom.Node removeChild(org.w3c.dom.Node oldChild)
            throws DOMException {
        return DOMNodeHelper.removeChild(this, oldChild);
    }

    public org.w3c.dom.Node appendChild(org.w3c.dom.Node newChild)
            throws DOMException {
        checkNewChildNode(newChild);

        return DOMNodeHelper.appendChild(this, newChild);
    }

    private void checkNewChildNode(org.w3c.dom.Node newChild)
            throws DOMException {
        final int nodeType = newChild.getNodeType();

        if (!((nodeType == org.w3c.dom.Node.ELEMENT_NODE)
                || (nodeType == org.w3c.dom.Node.TEXT_NODE)
                || (nodeType == org.w3c.dom.Node.COMMENT_NODE)
                || (nodeType == org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE)
                || (nodeType == org.w3c.dom.Node.CDATA_SECTION_NODE) 
                || (nodeType == org.w3c.dom.Node.ENTITY_REFERENCE_NODE))) {
            throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Given node cannot be a child of an entity " + "reference");
        }
    }

    public boolean hasChildNodes() {
        return DOMNodeHelper.hasChildNodes(this);
    }

    public org.w3c.dom.Node cloneNode(boolean deep) {
        return DOMNodeHelper.cloneNode(this, deep);
    }

    public void normalize() {
        DOMNodeHelper.normalize(this);
    }

    public boolean isSupported(String feature, String version) {
        return DOMNodeHelper.isSupported(this, feature, version);
    }

    public boolean hasAttributes() {
        return DOMNodeHelper.hasAttributes(this);
    }

    public String getBaseURI() {
        DOMNodeHelper.notSupported();
        return null;
    }

    public short compareDocumentPosition(Node other) throws DOMException {
        DOMNodeHelper.notSupported();
        return 0;
    }

    public String getTextContent() throws DOMException {
        DOMNodeHelper.notSupported();
        return null;
    }

    public void setTextContent(String textContent) throws DOMException {
        DOMNodeHelper.notSupported();
    }

    public boolean isSameNode(Node other) {
        DOMNodeHelper.notSupported();
        return false;
    }

    public String lookupPrefix(String namespaceURI) {
        DOMNodeHelper.notSupported();
        return null;
    }

    public boolean isDefaultNamespace(String namespaceURI) {
        DOMNodeHelper.notSupported();
        return false;
    }

    public String lookupNamespaceURI(String prefix) {
        DOMNodeHelper.notSupported();
        return null;
    }

    public boolean isEqualNode(Node other) {
        DOMNodeHelper.notSupported();
        return false;
    }

    public Object getFeature(String feature, String version) {
        DOMNodeHelper.notSupported();
        return null;
    }

    public Object setUserData(String key, Object data, UserDataHandler handler) {
        DOMNodeHelper.notSupported();
        return null;
    }

    public Object getUserData(String key) {
        DOMNodeHelper.notSupported();
        return null;
    }
}

