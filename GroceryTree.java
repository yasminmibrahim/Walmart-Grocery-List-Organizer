import java.util.*;


public class GroceryTree implements Queue<GroceryJCheckBox> {
    
    private int k;
    private int size;
    private ArrayList<GroceryJCheckBox> tree;
    private Comparator<GroceryJCheckBox> comp;
    
    public GroceryTree(int k) {
        this.k = k;
        comp = new Comparator<GroceryJCheckBox>() {
                    public int compare(GroceryJCheckBox o1, GroceryJCheckBox o2) {
                        return o1.compareTo(o2);
                    }
                };
    }
    
    public GroceryJCheckBox peek() {
        if(size == 0)
            return null;
        return tree.get(0);
    }
    
    public GroceryJCheckBox element() {
        return null;
    }
    
    public GroceryJCheckBox poll() {
        return null;
    }
    
    public GroceryJCheckBox remove() {
         if(size == 0)
            return null;
        if(size == 1) {
            size--;
            return tree.remove(0);
        }
        GroceryJCheckBox remove = tree.get(0);
        int index = size-1;
        int parent = 0;
        int child = parent*k + 1;
        int max = child;
        int height = 1;
        boolean m = false;
        tree.set(0, tree.remove(index));
        size--;
        index = parent;
        while(child < size) {
            int i = 1;
            max = child;
            m = false;
            while(i <= (Math.pow(k, height)) && child<size) {
                if((comp.compare(tree.get(parent), tree.get(child)) > 0) && (comp.compare(tree.get(max), tree.get(child)) >= 0)) {
                    if(comp.compare(tree.get(max), tree.get(child)) > 0) max = child;
                    m = true;
                }
                child = parent*k + (i+1);
                i++;
            }
            if(m) {
                GroceryJCheckBox p = tree.get(parent);
                tree.set(parent, tree.get(max));
                tree.set(max, p);
            }
            height++;
            index = parent*k + 1;
            parent = index;
            child = parent*k + 1;
        }
        return remove;
    }
    
    public boolean offer(GroceryJCheckBox e) {
        return true;
    }
    
    public boolean add(GroceryJCheckBox e) {
        tree.add(e);
        size++;
        int index = size-1;
        int parent = (index-1)/k;
        while(index > 0) {
            parent = (index-1)/k;
            if(comp.compare(tree.get(parent), e) > 0) {
                GroceryJCheckBox p = tree.get(parent);
                tree.set(parent, e);
                tree.set(index, p);
                index = parent;
            }
            else break;
        }
        return true;
    }
    
    public void clear() { 
    }
    
    public void retainAll() {
    }
    
    public boolean isEmpty() {
        return false;
    }
    
    public int size() {
        return this.size;
    }
    
    
        //********************************************************************************
    //   DO NOT EDIT ANYTHING BELOW THIS LINE (except to add the JavaDocs)
    //********************************************************************************
    /**
     * {@inheritDoc}
     */
    public boolean addAll(Collection<? extends GroceryJCheckBox> c) {
        throw new UnsupportedOperationException();
    }
    /**
     * {@inheritDoc}
     */
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }
    /**
     * {@inheritDoc}
     */
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o) {
        throw new UnsupportedOperationException();
    }
    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        throw new UnsupportedOperationException();
    }
    /**
     * {@inheritDoc}
     */
    public Iterator<GroceryJCheckBox> iterator() {
        throw new UnsupportedOperationException();
    }
    /**
     * {@inheritDoc}
     */
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }
    /**
     * {@inheritDoc}
     */
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    /**
     * {@inheritDoc}
     */
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    /**
     * {@inheritDoc}
     */
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }
    /**
     * {@inheritDoc}
     */
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }
}