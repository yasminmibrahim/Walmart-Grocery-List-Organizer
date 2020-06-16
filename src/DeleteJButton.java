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
    
    public int compareTo(DeleteJButton o2) {
        return (o2.getButton().getAisle().getNum()) - (delete.getAisle().getNum());
    }
}