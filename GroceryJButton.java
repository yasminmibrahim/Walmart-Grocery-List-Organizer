import java.util.*;
import javax.swing.*;

public class GroceryJButton extends JButton {
    
    private Aisle aisle;
    
    public GroceryJButton(Aisle a, String text) {
        super(text);
        this.aisle = a;
    }
    
    public Aisle getAisle() {
        return aisle;
    }
}