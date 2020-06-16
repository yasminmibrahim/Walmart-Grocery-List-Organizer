import java.util.*;
import javax.swing.*;

public class GroceryListSort {
    
    //private ArrayList<GroceryJCheckBox> GroceryList;
    
    /*
    public GroceryListSort(ArrayList<GroceryJCheckBox> GroceryList) {
        this.GroceryList = GroceryList;
    }
    */
    
    public static void sort(Object[] GroceryArray, Object[] DeleteArray) {   //min heap
        
        GroceryTree sort = new GroceryTree(2);
        for(int i = 0; i < GroceryArray.length; i++) {
            sort.add((GroceryJCheckBox)GroceryArray[i]);
            sort.deleteAdd((DeleteJButton)DeleteArray[i]);
        }
        for(int i = 0; i < GroceryArray.length; i++) {
            GroceryArray[GroceryArray.length-1-i] = sort.remove();
            DeleteArray[DeleteArray.length-1-i] = sort.deleteRemove();
        }
    }
}