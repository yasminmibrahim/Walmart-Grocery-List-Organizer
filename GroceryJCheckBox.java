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
}