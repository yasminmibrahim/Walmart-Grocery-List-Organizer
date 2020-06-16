import java.util.*;
import javax.swing.*;

public class GroceryJCheckBox extends JCheckBox {
    
    private Aisle aisle;
    
    public GroceryJCheckBox(Aisle a, String text) {
        super(text);
        this.aisle = a;
    }
    
    public Aisle getAisle() {
        return aisle;
    }
    
    public int compareTo(GroceryJCheckBox o2) {
        return (o2.getAisle().getNum()) - (aisle.getNum());
    }
}