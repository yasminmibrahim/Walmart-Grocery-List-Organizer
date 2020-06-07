import java.util.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.Color;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.EventQueue;

public class GroceryListOrganizerGUI extends JFrame {
    
    private ArrayList<JButton> buttons;  //list of category buttons
    private List<Aisle> aisles = Arrays.asList(Aisle.values());  //list of enum Aisle values
    private JPanel panel;     //main panel
    private JPanel CategoryPanel;  //panel that holds the category buttons
    private JPanel ListPanel;      //parent panel of grocery and organized list panels
    private JPanel GroceryListPanel;  //grocery list panel, sub panel of ListPanel
    private JPanel OragnizedListPanel; //organized list panel, sub panel of ListPanel
    
    private JLabel ItemToAddLabel = new JLabel();
    private JTextField ItemToAdd = new JTextField();
    private JButton AddButton = new JButton();
    private JLabel GroceryListLabel = new JLabel();
    private JLabel OrganizedListLabel = new JLabel();
    
    private GroceryJButton ClickedButton;   //button that is currently clicked
    
    public GroceryListOrganizerGUI() {
        this.buttons = new ArrayList<JButton>();
        this.panel = new JPanel();
        this.CategoryPanel = new JPanel();
        this.ListPanel = new JPanel();
        this.GroceryListPanel = new JPanel();
        this.OragnizedListPanel = new JPanel();
        
        
        setLayout(new BorderLayout());  //sets grame to BorderLayout
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));     //sets main panel to BoxLayout vertically
        this.CategoryPanel.setLayout(new GridLayout(2,2));  //sets CategoryPanel to GridLayout 2x2
        this.ListPanel.setLayout(new BoxLayout(this.ListPanel, BoxLayout.X_AXIS));  //sets ListPanel to BoxLayout horizontally
        this.GroceryListPanel.setLayout(new BoxLayout(this.GroceryListPanel, BoxLayout.Y_AXIS)); //sets GroceryListPanel to BoxLayout horizontally
        this.OragnizedListPanel.setLayout(new BoxLayout(this.OragnizedListPanel, BoxLayout.Y_AXIS)); //sets OrganizedListPanel to BoxLayout horizontally
        
        add(panel, BorderLayout.CENTER);  //adds main panel to center position of frame
        
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
                GroceryJButton categoryButton = new GroceryJButton(aisles.get(i), categories[j]);
                categoryButton.setOpaque(true);
                categoryButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        BroceryButtonActionPerformed(evt);
                    }
                });
                buttons.add(categoryButton);
                
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
        if(ItemToAdd.getText().equals("")) {      //if user didn't enter anything, returns
            return;
        }
        Aisle aisle = null;
        if(ClickedButton != null) {  //if a category is chosen, records aisle of category
            aisle = ClickedButton.getAisle();
        }
        
        JCheckBox item = new JCheckBox(ItemToAdd.getText()+" - "+(aisle!=null ? aisle.toString() : "Other"));
        GroceryListPanel.add(item);
        ItemToAdd.setText("");
        
        if(ClickedButton != null && ClickedButton.getBackground() == Color.BLUE) {
            ClickedButton.setBackground(null);
            ClickedButton = null;
        }
        
        pack();
    }
    
    private void BroceryButtonActionPerformed(ActionEvent evt) {
        GroceryJButton buttonClicked = (GroceryJButton)evt.getSource();
        if(buttonClicked.getBackground() != Color.BLUE) {
            for(int i = 0; i < buttons.size(); i++) {
                if(buttons.get(i).getBackground() == Color.BLUE) {
                    buttons.get(i).setBackground(null);
                    break;
                }
            }
            buttonClicked.setBackground(Color.BLUE);
            ClickedButton = buttonClicked;
        }
        else buttonClicked.setBackground(null);
        ClickedButton = buttonClicked;
        
        
    }
    
    /*
    private static void createAndShowGUI() {
        
        
        //Create and set up the window.
        JFrame frame = new JFrame("Grocery List Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //frame.prepareUI();
        frame.pack();
        frame.setVisible(true);
        
    }
    */
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                //createAndShowGUI();
                new GroceryListOrganizerGUI().setVisible(true);
            }
        });
    }
  
}  
