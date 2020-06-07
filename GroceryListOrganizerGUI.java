import java.util.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.EventQueue;

public class GroceryListOrganizerGUI extends JFrame {
    
    private ArrayList<JButton> buttons;
    private List<Aisle> aisles = Arrays.asList(Aisle.values());
    private JPanel panel;
    private JPanel CategoryPanel;
    private JPanel ListPanel;
    private JPanel GroceryListPanel;
    private JPanel OragnizedListPanel;
    
    private JLabel ItemToAddLabel = new JLabel();
    private JTextField ItemToAdd = new JTextField();
    private JButton AddButton = new JButton();
    private JLabel GroceryListLabel = new JLabel();
    private JLabel OrganizedListLabel = new JLabel();
    
    public GroceryListOrganizerGUI() {
        this.buttons = new ArrayList<JButton>();
        this.panel = new JPanel();
        this.CategoryPanel = new JPanel();
        this.ListPanel = new JPanel();
        this.GroceryListPanel = new JPanel();
        this.OragnizedListPanel = new JPanel();
        
        
        setLayout(new BorderLayout());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
        this.CategoryPanel.setLayout(new GridLayout(2,2));
        this.ListPanel.setLayout(new BoxLayout(this.ListPanel, BoxLayout.X_AXIS));
        this.GroceryListPanel.setLayout(new BoxLayout(this.GroceryListPanel, BoxLayout.Y_AXIS));
        this.OragnizedListPanel.setLayout(new BoxLayout(this.OragnizedListPanel, BoxLayout.Y_AXIS));
        
        add(panel, BorderLayout.CENTER);
        
        ItemToAddLabel.setText("Which item would you like to add?");
        AddButton.setText("Add");
        AddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        
        GroceryListLabel.setText("Grocery List:");
        OrganizedListLabel.setText("Organized List:");
        
        panel.add(ItemToAddLabel);
        panel.add(ItemToAdd);
        
        for(int i = 0; i < aisles.size(); i++) {
            String[] categories = (aisles.get(i)).getCategories();
            for(int j = 0; j < categories.length; j++){
                buttons.add(new JButton(categories[j].toString()));
            }
        }
        
        panel.add(CategoryPanel);
        
        for(int i = 0; i < buttons.size(); i++){
                CategoryPanel.add(buttons.get(i));
        }
        
        ListPanel.add(GroceryListPanel);
        ListPanel.add(Box.createHorizontalStrut(100));
        ListPanel.add(OragnizedListPanel);
        
        GroceryListPanel.add(GroceryListLabel);
        OragnizedListPanel.add(OrganizedListLabel);
        
        panel.add(AddButton);
        panel.add(ListPanel);

        
    }
    
    private void AddButtonActionPerformed(ActionEvent evt) {
        JCheckBox item = new JCheckBox(ItemToAdd.getText());
        GroceryListPanel.add(item);
        ItemToAdd.setText("");
        pack();
    }
    
    private static void createAndShowGUI() {
        
        /*
        //Create and set up the window.
        JFrame frame = new JFrame("Grocery List Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //frame.prepareUI();
        frame.pack();
        frame.setVisible(true);
        */
    }
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                //createAndShowGUI();
                new GroceryListOrganizerGUI().setVisible(true);
            }
        });
    }
  
}  
