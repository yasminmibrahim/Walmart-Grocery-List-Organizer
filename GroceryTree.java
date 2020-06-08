import java.util.*;
import javax.swing.*;

public class GroceryTree implements Queue<JComponent> {
    
    private int k;
    private int GrocerySize;
    private int DeleteSize;
    private ArrayList<GroceryJCheckBox> GroceryList;
    private ArrayList<DeleteJButton> DeleteList;
    private Comparator<GroceryJCheckBox> GroceryComp;
    private Comparator<DeleteJButton> DeleteComp;
    
    public GroceryTree(int k) {
        this.k = k;
        this.GrocerySize = 0;
        this.DeleteSize = 0;
        this.GroceryList = new ArrayList<GroceryJCheckBox>();
        this.DeleteList = new ArrayList<DeleteJButton>();
        GroceryComp = new Comparator<GroceryJCheckBox>() {
            public int compare(GroceryJCheckBox o1, GroceryJCheckBox o2) {
                return o1.compareTo(o2);
            }
        };
        DeleteComp = new Comparator<DeleteJButton>() {
            public int compare(DeleteJButton o1, DeleteJButton o2) {
                return o1.compareTo(o2);
            }
        };
    }
    
    public JComponent peek() {
        return null;
    }
    
    public JComponent element() {
        return null;
    }
    
    public JComponent poll() {
        return null;
    }
    
    public JComponent remove() {
         if(GrocerySize == 0)
            return null;
        if(GrocerySize == 1) {
            GrocerySize--;
            return GroceryList.remove(0);
        }
        GroceryJCheckBox remove = GroceryList.get(0);
        int index = GrocerySize-1;
        int parent = 0;
        int child = parent*k + 1;
        int max = child;
        int height = 1;
        boolean m = false;
        GroceryList.set(0, GroceryList.remove(index));
        GrocerySize--;
        index = parent;
        while(child < GrocerySize) {
            int i = 1;
            max = child;
            m = false;
            while(i <= (Math.pow(k, height)) && child<GrocerySize) {
                if((GroceryComp.compare(GroceryList.get(parent), GroceryList.get(child)) > 0) && (GroceryComp.compare(GroceryList.get(max), GroceryList.get(child)) >= 0)) {
                    if(GroceryComp.compare(GroceryList.get(max), GroceryList.get(child)) > 0) max = child;
                    m = true;
                }
                child = parent*k + (i+1);
                i++;
            }
            if(m) {
                GroceryJCheckBox p = GroceryList.get(parent);
                GroceryList.set(parent, GroceryList.get(max));
                GroceryList.set(max, p);
            }
            height++;
            index = parent*k + 1;
            parent = index;
            child = parent*k + 1;
        }
        return remove;
    }
    
    public JComponent deleteRemove() {
         if(DeleteSize == 0)
            return null;
        if(DeleteSize == 1) {
            DeleteSize--;
            return DeleteList.remove(0);
        }
        DeleteJButton remove = DeleteList.get(0);
        int index = DeleteSize-1;
        int parent = 0;
        int child = parent*k + 1;
        int max = child;
        int height = 1;
        boolean m = false;
        DeleteList.set(0, DeleteList.remove(index));
        DeleteSize--;
        index = parent;
        while(child < DeleteSize) {
            int i = 1;
            max = child;
            m = false;
            while(i <= (Math.pow(k, height)) && child<DeleteSize) {
                if((DeleteComp.compare(DeleteList.get(parent), DeleteList.get(child)) > 0) && (DeleteComp.compare(DeleteList.get(max), DeleteList.get(child)) >= 0)) {
                    if(DeleteComp.compare(DeleteList.get(max), DeleteList.get(child)) > 0) max = child;
                    m = true;
                }
                child = parent*k + (i+1);
                i++;
            }
            if(m) {
                DeleteJButton p = DeleteList.get(parent);
                DeleteList.set(parent, DeleteList.get(max));
                DeleteList.set(max, p);
            }
            height++;
            index = parent*k + 1;
            parent = index;
            child = parent*k + 1;
        }
        return remove;
    }
    
    public boolean offer(JComponent e) {
        return true;
    }
    
    public boolean add(JComponent e) {
        GroceryList.add((GroceryJCheckBox)e);
        GrocerySize++;
        int index = GrocerySize-1;
        int parent = (index-1)/k;
        while(index > 0) {
            parent = (index-1)/k;
            if(GroceryComp.compare(GroceryList.get(parent), (GroceryJCheckBox)e) > 0) {
                GroceryJCheckBox p = GroceryList.get(parent);
                GroceryList.set(parent, (GroceryJCheckBox)e);
                GroceryList.set(index, p);
                index = parent;
            }
            else break;
        }
        return true;
    }
    
    public boolean deleteAdd(JComponent e) {
        DeleteList.add((DeleteJButton)e);
        DeleteSize++;
        int index = DeleteSize-1;
        int parent = (index-1)/k;
        while(index > 0) {
            parent = (index-1)/k;
            if(DeleteComp.compare(DeleteList.get(parent), (DeleteJButton)e) > 0) {
                DeleteJButton p = DeleteList.get(parent);
                DeleteList.set(parent, (DeleteJButton)e);
                DeleteList.set(index, p);
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
        return 0;
    }
    
    public int grocerySize() {
        return this.GrocerySize;
    }
    
    public int deleteSize() {
        return this.DeleteSize;
    }
    
    
        //********************************************************************************
    //   DO NOT EDIT ANYTHING BELOW THIS LINE (except to add the JavaDocs)
    //********************************************************************************
    /**
     * {@inheritDoc}
     */
    public boolean addAll(Collection<? extends JComponent> c) {
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
    public Iterator<JComponent> iterator() {
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