import java.util.*;
import javax.swing.*;

public class GroceryListSort {
    
    private ArrayList<GroceryJCheckBox> GroceryList;
    
    /*
    public GroceryListSort(ArrayList<GroceryJCheckBox> GroceryList) {
        this.GroceryList = GroceryList;
    }
    */
    
    public static void sort(ArrayList<GroceryJCheckBox> gl, ArrayList<DeleteJButton> dl) {   //min heap
        GroceryJCheckBox[] GroceryList = (GroceryJCheckBox[])gl.toArray();
        DeleteJButton[] DeleteList = (DeleteJButton[])dl.toArray();
        
        GroceryTree sort = new GroceryTree(2);
        for(int i = 0; i < GroceryList.length; i++) {
            sort.add(GroceryList[i]);
        }
        for(int i = 0; i < GroceryList.length; i++) {
            GroceryList[GroceryList.length-1-i] = sort.remove();
        }
    }
}