import java.util.*;
import javax.swing.*;

public class DeleteJButton extends JButton {
    
    private GroceryJCheckBox delete;
    
    public DeleteJButton(GroceryJCheckBox delete, String text) {
        super(text);
        this.delete = delete;
    }
    
    public GroceryJCheckBox getButton() {
        return delete;
    }
}