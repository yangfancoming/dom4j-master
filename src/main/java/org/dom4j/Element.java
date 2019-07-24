

package org.dom4j;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <code>Element</code> interface defines an XML element. An element can have
 * declared namespaces, attributes, child nodes and textual content.
 * <p>
 * Some of this interface is optional. Some implementations may be read-only and
 * not support being modified. Some implementations may not support the parent
 * relationship and methods such as {@link #getParent}or {@link #getDocument}.
 *
 * @author <a href="mailto:jstrachan@apache.org">James Strachan </a>
 * @version $Revision: 1.47 $
 */
@SuppressWarnings("unused")
public interface Element extends Branch {
	// Name and namespace related methods
	// -------------------------------------------------------------------------

	/**
	 * Returns the <code>QName</code> of this element which represents the
	 * local name, the qualified name and the <code>Namespace</code>.
	 *
	 * @return the <code>QName</code> associated with this element
	 */
	QName getQName();

	/**
	 * Sets the <code>QName</code> of this element which represents the local
	 * name, the qualified name and the <code>Namespace</code>.
	 *
	 * @param qname is the <code>QName</code> to be associated with this element
	 */
	void setQName(QName qname);

	/**
	 * Returns the <code>Namespace</code> of this element if one exists
	 * otherwise <code>Namespace.NO_NAMESPACE</code> is returned.
	 *
	 * @return the <code>Namespace</code> associated with this element
	 */
	Namespace getNamespace();

	/**
	 * Returns the <code>QName</code> for the given qualified name, using the
	 * namespace URI in scope for the given prefix of the qualified name or the
	 * default namespace if the qualified name has no prefix.
	 *
	 * @param qualifiedName DOCUMENT ME!
	 * @return the <code>QName</code> for the given qualified name
	 */
	QName getQName(String qualifiedName);

	/**
	 * Returns the <code>Namespace</code> which is mapped to the given prefix
	 * or null if it could not be found.
	 *
	 * @param prefix DOCUMENT ME!
	 * @return the <code>Namespace</code> associated with the given prefix
	 */
	Namespace getNamespaceForPrefix(String prefix);

	/**
	 * Returns the <code>Namespace</code> which is mapped to the given URI or
	 * null if it could not be found. If there is more than one
	 * <code>Namespace</code> mapped to the URI, which of them will be
	 * returned is undetermined.
	 *
	 * @param uri DOCUMENT ME!
	 * @return the <code>Namespace</code> associated with the given URI
	 */
	Namespace getNamespaceForURI(String uri);

	/**
	 * Returns the all namespaces which are mapped to the given URI or an empty
	 * list if no such namespaces could be found.
	 *
	 * @param uri DOCUMENT ME!
	 * @return the namespaces associated with the given URI
	 * @since 1.5
	 */
	List<Namespace> getNamespacesForURI(String uri);

	/**
	 * Returns the namespace prefix of this element if one exists otherwise an
	 * empty <code>String</code> is returned.
	 *
	 * @return the prefix of the <code>Namespace</code> of this element or an
	 * empty <code>String</code>
	 */
	String getNamespacePrefix();

	/**
	 * Returns the URI mapped to the namespace of this element if one exists
	 * otherwise an empty <code>String</code> is returned.
	 *
	 * @return the URI for the <code>Namespace</code> of this element or an
	 * empty <code>String</code>
	 */
	String getNamespaceURI();

	/**
	 * Returns the fully qualified name of this element. This will be the same
	 * as the value returned from {@link #getName}if this element has no
	 * namespace attached to this element or an expression of the form
	 * <pre>
	 * getNamespacePrefix() + &quot;:&quot; + getName()
	 * </pre>
	 * will be returned.
	 *
	 * @return the fully qualified name of the element.
	 */
	String getQualifiedName();

	/**
	 * Returns any additional namespaces declarations for this element other
	 * than namespace returned via the {@link #getNamespace()}method. If no
	 * additional namespace declarations are present for this element then an
	 * empty list will be returned. The list is backed by the element such that
	 * changes to the list will be reflected in the element though the reverse
	 * is not the case.
	 *
	 * @return a list of any additional namespace declarations.
	 */
	List<Namespace> additionalNamespaces();

	/**
	 * Returns all the namespaces declared by this element. If no namespaces are
	 * declared for this element then an empty list will be returned. The list
	 * is backed by the element such that changes to the list will be reflected
	 * in the element though the reverse is not the case.
	 *
	 * @return a list of namespaces declared for this element.
	 */
	List<Namespace> declaredNamespaces();

	// Builder methods
	// -------------------------------------------------------------------------

	/**
	 * Adds the attribute value of the given local name. If an attribute already
	 * exists for the given name it will be replaced. Attributes with null
	 * values are silently ignored. If the value of the attribute is null then
	 * this method call will remove any attributes with the given name.
	 *
	 * @param name  is the name of the attribute whose value is to be added or
	 *              updated
	 * @param value is the attribute's value
	 * @return this <code>Element</code> instance.
	 */
	Element addAttribute(String name, String value);

	/**
	 * Adds the attribute value of the given fully qualified name. If an
	 * attribute already exists for the given name it will be replaced.
	 * Attributes with null values are silently ignored. If the value of the
	 * attribute is null then this method call will remove any attributes with
	 * the given name.
	 *
	 * @param qName is the fully qualified name of the attribute whose value is to
	 *              be added or updated
	 * @param value is the attribute's value
	 * @return this <code>Element</code> instance.
	 */
	Element addAttribute(QName qName, String value);

	/**
	 * Adds a new <code>Comment</code> node with the given text to this
	 * element.
	 *
	 * @param comment is the text for the <code>Comment</code> node.
	 * @return this <code>Element</code> instance.
	 */
	Element addComment(String comment);

	/**
	 * Adds a new <code>CDATA</code> node with the given text to this element.
	 *
	 * @param cdata is the text for the <code>CDATA</code> node.
	 * @return this <code>Element</code> instance.
	 */
	Element addCDATA(String cdata);

	/**
	 * Adds a new <code>Entity</code> node with the given name and text to
	 * this element and returns a reference to the new node.
	 *
	 * @param name is the name for the <code>Entity</code> node.
	 * @param text is the text for the <code>Entity</code> node.
	 * @return this <code>Element</code> instance.
	 */
	Element addEntity(String name, String text);

	/**
	 * Adds a namespace to this element for use by its child content
	 *
	 * @param prefix is the prefix to use, which should not be null or blank
	 * @param uri    is the namespace URI
	 * @return this <code>Element</code> instance.
	 */
	Element addNamespace(String prefix, String uri);

	/**
	 * Adds a processing instruction for the given target
	 *
	 * @param target is the target of the processing instruction
	 * @param text   is the textual data (key/value pairs) of the processing
	 *               instruction
	 * @return this <code>Element</code> instance.
	 */
	Element addProcessingInstruction(String target, String text);

	/**
	 * Adds a processing instruction for the given target
	 *
	 * @param target is the target of the processing instruction
	 * @param data   is a Map of the key / value pairs of the processing
	 *               instruction
	 * @return this <code>Element</code> instance.
	 */
	Element addProcessingInstruction(String target, Map<String, String> data);

	/**
	 * Adds a new <code>Text</code> node with the given text to this element.
	 *
	 * @param text is the text for the <code>Text</code> node.
	 * @return this <code>Element</code> instance.
	 */
	Element addText(String text);

	// Typesafe modifying methods
	// -------------------------------------------------------------------------

	/**
	 * Adds the given <code>Attribute</code> to this element. If the given
	 * node already has a parent defined then an
	 * <code>IllegalAddException</code> will be thrown. Attributes with null
	 * values are silently ignored.
	 *
	 * If the value of the attribute is null then this method call will remove
	 * any attributes with the QName of this attribute.
	 *
	 * @param attribute is the attribute to be added
	 */
	void add(Attribute attribute);

	/**
	 * Adds the given <code>CDATA</code> to this element. If the given node
	 * already has a parent defined then an <code>IllegalAddException</code>
	 * will be thrown.
	 *
	 * @param cdata is the CDATA to be added
	 */
	void add(CDATA cdata);

	/**
	 * Adds the given <code>Entity</code> to this element. If the given node
	 * already has a parent defined then an <code>IllegalAddException</code>
	 * will be thrown.
	 *
	 * @param entity is the entity to be added
	 */
	void add(Entity entity);

	/**
	 * Adds the given <code>Text</code> to this element. If the given node
	 * already has a parent defined then an <code>IllegalAddException</code>
	 * will be thrown.
	 *
	 * @param text is the text to be added
	 */
	void add(Text text);

	/**
	 * Adds the given <code>Namespace</code> to this element. If the given
	 * node already has a parent defined then an
	 * <code>IllegalAddException</code> will be thrown.
	 *
	 * @param namespace is the namespace to be added
	 */
	void add(Namespace namespace);

	/**
	 * Removes the given <code>Attribute</code> from this element.
	 *
	 * @param attribute is the attribute to be removed
	 * @return true if the attribute was removed
	 */
	boolean remove(Attribute attribute);

	/**
	 * Removes the given <code>CDATA</code> if the node is an immediate child
	 * of this element. If the given node is not an immediate child of this
	 * element then the {@link Node#detach()}method should be used instead.
	 *
	 * @param cdata is the CDATA to be removed
	 * @return true if the cdata was removed
	 */
	boolean remove(CDATA cdata);

	/**
	 * Removes the given <code>Entity</code> if the node is an immediate child
	 * of this element. If the given node is not an immediate child of this
	 * element then the {@link Node#detach()}method should be used instead.
	 *
	 * @param entity is the entity to be removed
	 * @return true if the entity was removed
	 */
	boolean remove(Entity entity);

	/**
	 * Removes the given <code>Namespace</code> if the node is an immediate
	 * child of this element. If the given node is not an immediate child of
	 * this element then the {@link Node#detach()}method should be used
	 * instead.
	 *
	 * @param namespace is the namespace to be removed
	 * @return true if the namespace was removed
	 */
	boolean remove(Namespace namespace);

	/**
	 * Removes the given <code>Text</code> if the node is an immediate child
	 * of this element. If the given node is not an immediate child of this
	 * element then the {@link Node#detach()}method should be used instead.
	 *
	 * @param text is the text to be removed
	 * @return true if the text was removed
	 */
	boolean remove(Text text);

	// Text methods
	// -------------------------------------------------------------------------

	/**
	 * Returns the text value of this element without recursing through child
	 * elements. This method iterates through all {@link Text},{@link CDATA}
	 * and {@link Entity}nodes that this element contains and appends the text
	 * values together.
	 *
	 * @return the textual content of this Element. Child elements are not
	 * navigated. This method does not return null;
	 */
	String getText();

	/**
	 * DOCUMENT ME!
	 *
	 * @return the trimmed text value where whitespace is trimmed and normalised
	 * into single spaces. This method does not return null.
	 */
	String getTextTrim();

	/**
	 * Returns the XPath string-value of this node. The behaviour of this method
	 * is defined in the <a href="http://www.w3.org/TR/xpath">XPath
	 * specification </a>. This method returns the string-value of all the
	 * contained {@link Text},{@link CDATA},{@link Entity}and {@link
	 * Element} nodes all appended together.
	 *
	 * @return the text from all the child Text and Element nodes appended
	 * together.
	 */
	String getStringValue();

	/**
	 * Accesses the data of this element which may implement data typing
	 * bindings such as XML Schema or Java Bean bindings or will return the same
	 * value as {@link #getText}
	 *
	 * @return DOCUMENT ME!
	 */
	Object getData();

	/**
	 * Sets the data value of this element if this element supports data binding
	 * or calls {@link #setText}if it doesn't
	 *
	 * @param data DOCUMENT ME!
	 */
	void setData(Object data);

	// Attribute methods
	// -------------------------------------------------------------------------

	/**
	 * Returns the {@link Attribute}instances this element contains as a backed
	 * {@link List}so that the attributes may be modified directly using the
	 * {@link List}interface. The <code>List</code> is backed by the
	 * <code>Element</code> so that changes to the list are reflected in the
	 * element and vice versa.
	 *
	 * @return the attributes that this element contains as a <code>List</code>
	 */
	List<Attribute> attributes();

	/**
	 * Sets the attributes that this element contains
	 *
	 * @param attributes DOCUMENT ME!
	 */
	void setAttributes(List<Attribute> attributes);

	/**
	 * DOCUMENT ME!
	 *
	 * @return the number of attributes this element contains
	 */
	int attributeCount();

	/**
	 * DOCUMENT ME!
	 *
	 * @return an iterator over the attributes of this element
	 */
	Iterator<Attribute> attributeIterator();

	/**
	 * Returns the attribute at the specified indexGets the
	 *
	 * @param index DOCUMENT ME!
	 * @return the attribute at the specified index where index &gt;= 0 and
	 * index &lt; number of attributes or throws an
	 * IndexOutOfBoundsException if the index is not within the
	 * allowable range
	 */
	Attribute attribute(int index);

	/**
	 * Returns the attribute with the given name
	 *
	 * @param name DOCUMENT ME!
	 * @return the attribute for the given local name in any namespace. If there
	 * are more than one attributes with the given local name in
	 * different namespaces then the first one is returned.
	 */
	Attribute attribute(String name);

	/**
	 * DOCUMENT ME!
	 *
	 * @param qName is the fully qualified name
	 * @return the attribute for the given fully qualified name or null if it
	 * could not be found.
	 */
	Attribute attribute(QName qName);

	/**
	 * This returns the attribute value for the attribute with the given name
	 * and any namespace or null if there is no such attribute or the empty
	 * string if the attribute value is empty.
	 *
	 * @param name is the name of the attribute value to be returned
	 * @return the value of the attribute, null if the attribute does not exist
	 * or the empty string
	 */
	String attributeValue(String name);

	/**
	 * This returns the attribute value for the attribute with the given name
	 * and any namespace or the default value if there is no such attribute
	 * value.
	 *
	 * @param name         is the name of the attribute value to be returned
	 * @param defaultValue is the default value to be returned if the attribute has no
	 *                     value defined.
	 * @return the value of the attribute or the defaultValue if the attribute
	 * has no value defined.
	 */
	String attributeValue(String name, String defaultValue);

	/**
	 * This returns the attribute value for the attribute with the given fully
	 * qualified name or null if there is no such attribute or the empty string
	 * if the attribute value is empty.
	 *
	 * @param qName is the fully qualified name
	 * @return the value of the attribute, null if the attribute does not exist
	 * or the empty string
	 */
	String attributeValue(QName qName);

	/**
	 * This returns the attribute value for the attribute with the given fully
	 * qualified name or the default value if there is no such attribute value.
	 *
	 * @param qName        is the fully qualified name
	 * @param defaultValue is the default value to be returned if the attribute has no
	 *                     value defined.
	 * @return the value of the attribute or the defaultValue if the attribute
	 * has no value defined.
	 */
	String attributeValue(QName qName, String defaultValue);

	/**
	 * Sets the attribute value of the given local name.
	 *
	 * @param name  is the name of the attribute whose value is to be added or
	 *              updated
	 * @param value is the attribute's value
	 * @deprecated As of version 0.5. Please use {@link
	 * #addAttribute(String, String)} instead. WILL BE REMOVED IN
	 * dom4j-1.6 !!
	 */
	void setAttributeValue(String name, String value);

	/**
	 * Sets the attribute value of the given fully qualified name.
	 *
	 * @param qName is the fully qualified name of the attribute whose value is to
	 *              be added or updated
	 * @param value is the attribute's value
	 * @deprecated As of version 0.5. Please use {@link
	 * #addAttribute(QName, String)} instead. WILL BE REMOVED IN
	 * dom4j-1.6 !!
	 */
	void setAttributeValue(QName qName, String value);

	// Content methods
	// -------------------------------------------------------------------------

	/**
	 * Returns the first element for the given local name and any namespace.
	 *
	 * @param name DOCUMENT ME!
	 * @return the first element with the given local name
	 */
	Element element(String name);

	/**
	 * Returns the first element for the given fully qualified name.
	 *
	 * @param qName is the fully qualified name to search for
	 * @return the first element with the given fully qualified name
	 */
	Element element(QName qName);

	/**
	 * Returns the elements contained in this element. If this element does not
	 * contain any elements then this method returns an empty list. The list is
	 * backed by the element such that changes to the list will be reflected in
	 * the element though the reverse is not the case.
	 *
	 * @return a list of all the elements in this element.
	 */
	List<Element> elements();

	/**
	 * Returns the elements contained in this element with the given local name
	 * and any namespace. If no elements are found then this method returns an
	 * empty list. The list is backed by the element such that changes to the
	 * list will be reflected in the element though the reverse is not the case.
	 *
	 * @param name DOCUMENT ME!
	 * @return a list of all the elements in this element for the given local
	 * name
	 */
	List<Element> elements(String name);

	/**
	 * Returns the elements contained in this element with the given fully
	 * qualified name. If no elements are found then this method returns an
	 * empty list. The list is backed by the element such that changes to the
	 * list will be reflected in the element though the reverse is not the case.
	 *
	 * @param qName is the fully qualified name to search for
	 * @return a list of all the elements in this element for the given fully
	 * qualified name.
	 */
	List<Element> elements(QName qName);

	/**
	 * Returns an iterator over all this elements child elements.
	 *
	 * @return an iterator over the contained elements
	 */
	Iterator<Element> elementIterator();

	/**
	 * Returns an iterator over the elements contained in this element which
	 * match the given local name and any namespace.
	 *
	 * @param name DOCUMENT ME!
	 * @return an iterator over the contained elements matching the given local
	 * name
	 */
	Iterator<Element> elementIterator(String name);

	/**
	 * Returns an iterator over the elements contained in this element which
	 * match the given fully qualified name.
	 *
	 * @param qName is the fully qualified name to search for
	 * @return an iterator over the contained elements matching the given fully
	 * qualified name
	 */
	Iterator<Element> elementIterator(QName qName);

	// Helper methods
	// -------------------------------------------------------------------------

	/**
	 * DOCUMENT ME!
	 *
	 * @return true if this element is the root element of a document and this
	 * element supports the parent relationship else false.
	 */
	boolean isRootElement();

	/**
	 * Returns true if this <code>Element</code> has mixed content. Mixed
	 * content means that an element contains both textual data and child
	 * elements.
	 *
	 * @return true if this element contains mixed content.
	 */
	boolean hasMixedContent();

	/**
	 * Returns true if this <code>Element</code> has text only content.
	 *
	 * @return true if this element is empty or only contains text content.
	 */
	boolean isTextOnly();

	/**
	 * Appends the attributes of the given element to me. This method behaves
	 * like the {@link java.util.Collection#addAll(java.util.Collection)}
	 * method.
	 *
	 * @param element is the element whose attributes will be added to me.
	 */
	void appendAttributes(Element element);

	/**
	 * Creates a deep copy of this element The new element is detached from its
	 * parent, and getParent() on the clone will return null.
	 *
	 * @return a new deep copy Element
	 */
	Element createCopy();

	/**
	 * Creates a deep copy of this element with the given local name The new
	 * element is detached from its parent, and getParent() on the clone will
	 * return null.
	 *
	 * @param name DOCUMENT ME!
	 * @return a new deep copy Element
	 */
	Element createCopy(String name);

	/**
	 * Creates a deep copy of this element with the given fully qualified name.
	 * The new element is detached from its parent, and getParent() on the clone
	 * will return null.
	 *
	 * @param qName DOCUMENT ME!
	 * @return a new deep copy Element
	 */
	Element createCopy(QName qName);

	String elementText(String name);

	String elementText(QName qname);

	String elementTextTrim(String name);

	String elementTextTrim(QName qname);

	/**
	 * Returns a node at the given index suitable for an XPath result set. This
	 * means the resulting Node will either be null or it will support the
	 * parent relationship.
	 *
	 * @param index DOCUMENT ME!
	 * @return the Node for the given index which will support the parent
	 * relationship or null if there is not a node at the given index.
	 */
	Node getXPathResult(int index);
}

