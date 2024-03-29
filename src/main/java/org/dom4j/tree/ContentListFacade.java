

package org.dom4j.tree;

import org.dom4j.IllegalAddException;
import org.dom4j.Node;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * <code>ContentListFacade</code> represents a facade of the content of a
 * {@link org.dom4j.Branch} which is returned via calls to the {@link
 * org.dom4j.Branch#content}  method to allow users to modify the content of a
 * {@link org.dom4j.Branch} directly using the {@link List} interface. This list
 * is backed by the branch such that changes to the list will be reflected in
 * the branch and changes to the branch will be reflected in this list.
 * </p>
 * 
 * @author <a href="mailto:james.strachan@metastuff.com">James Strachan </a>
 * @version $Revision: 1.11 $
 */
public class ContentListFacade<T extends Node> extends AbstractList<T> {
    /** The content of the Branch which is modified if I am modified */
    private List<T> branchContent;

    /** The <code>AbstractBranch</code> instance which owns the content */
    private AbstractBranch branch;

    public ContentListFacade(AbstractBranch branch, List<T> branchContent) {
        this.branch = branch;
        this.branchContent = branchContent;
    }

    @Override
    public boolean add(T node) {
        branch.childAdded(node);

        return branchContent.add(node);
    }

    @Override
    public void add(int index, T node) {
        branch.childAdded(node);
        branchContent.add(index, node);
    }

    @Override
    public T set(int index, T node) {
        branch.childAdded(node);

        return branchContent.set(index, node);
    }

    @Override
    public boolean remove(Object object) {
        branch.childRemoved(asNode(object));

        return branchContent.remove(object);
    }

    @Override
    public T remove(int index) {
        T node = branchContent.remove(index);

        if (node != null) {
            branch.childRemoved(node);
        }

        return node;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        int count = branchContent.size();

        for (Iterator<? extends T> iter = collection.iterator(); iter.hasNext(); count++) {
            add(iter.next());
        }

        return count == branchContent.size();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        int count = branchContent.size();

        for (Iterator<? extends T> iter = collection.iterator(); iter.hasNext(); count--) {
            add(index++, iter.next());
        }

        return count == branchContent.size();
    }

    @Override
    public void clear() {
        for (Node node : this) {
            branch.childRemoved(node);
        }

        branchContent.clear();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object object : c) {
            branch.childRemoved(asNode(object));
        }

        return branchContent.removeAll(c);
    }

    @Override
    public int size() {
        return branchContent.size();
    }

    @Override
    public boolean isEmpty() {
        return branchContent.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return branchContent.contains(o);
    }

    @Override
    public Object[] toArray() {
        return branchContent.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return branchContent.toArray(a);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return branchContent.containsAll(c);
    }

    @Override
    public T get(int index) {
        return branchContent.get(index);
    }

    @Override
    public int indexOf(Object o) {
        return branchContent.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return branchContent.lastIndexOf(o);
    }

    protected Node asNode(Object object) {
        if (object instanceof Node) {
            return (Node) object;
        } else {
            throw new IllegalAddException(
                    "This list must contain instances of "
                            + "Node. Invalid type: " + object);
        }
    }

    protected List<T> getBackingList() {
        return branchContent;
    }
}

