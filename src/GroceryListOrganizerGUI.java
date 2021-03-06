import java.util.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.Color;
import java.awt.Dimension;
 
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
    private JPanel OrganizedListPanel; //organized list panel, sub panel of ListPanel
    private JPanel DeletePanel; //panel that holds delete buttons corresponding to each checkbox
    
    private JLabel ItemToAddLabel = new JLabel();
    private JTextField ItemToAdd = new JTextField();
    private JButton AddButton = new JButton();
    private JLabel GroceryListLabel = new JLabel();
    private JLabel OrganizedListLabel = new JLabel();
    
    private GroceryJButton ClickedButton;   //button that is currently clicked
    
    private ArrayList<GroceryJCheckBox> GroceryList = new ArrayList<GroceryJCheckBox>();
    private ArrayList<DeleteJButton> DeleteList = new ArrayList<DeleteJButton>();
    
    private Object[] GroceryArray;
    private Object[] DeleteArray;
    
    public GroceryListOrganizerGUI() {
        this.buttons = new ArrayList<JButton>();
        this.panel = new JPanel();
        this.CategoryPanel = new JPanel();
        this.ListPanel = new JPanel();
        this.GroceryListPanel = new JPanel();
        //this.OrganizedListPanel = new JPanel();
        this.DeletePanel = new JPanel();
        
        setSize(1000,400);
        setMinimumSize(new Dimension(1000,400));
        
        setLayout(new BorderLayout());  //sets grame to BorderLayout
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));     //sets main panel to BoxLayout vertically
        this.CategoryPanel.setLayout(new GridLayout(10,4));  //sets CategoryPanel to GridLayout 10x4
        this.ListPanel.setLayout(new BoxLayout(this.ListPanel, BoxLayout.X_AXIS));  //sets ListPanel to BoxLayout horizontally
        this.GroceryListPanel.setLayout(new BoxLayout(this.GroceryListPanel, BoxLayout.Y_AXIS)); //sets GroceryListPanel to BoxLayout vertically
        //this.OrganizedListPanel.setLayout(new BoxLayout(this.OrganizedListPanel, BoxLayout.Y_AXIS)); //sets OrganizedListPanel to BoxLayout vertically
        this.DeletePanel.setLayout(new BoxLayout(this.DeletePanel, BoxLayout.Y_AXIS)); //sets DeletePanel to BoxLayout vertically
        
        add(panel, BorderLayout.CENTER);  //adds main panel to center position of frame
        
        ItemToAddLabel.setText("Which item would you like to add?");
        AddButton.setText("Add");
        AddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        
        GroceryListLabel.setText("Grocery List:");
        //OrganizedListLabel.setText("Organized List:");
        
        panel.add(ItemToAddLabel);
        panel.add(ItemToAdd);
        
        for(int i = 0; i < aisles.size(); i++) {
            String[] categories = (aisles.get(i)).getCategories();
            for(int j = 0; j < categories.length; j++){
                GroceryJButton categoryButton = new GroceryJButton(aisles.get(i), categories[j]);
                categoryButton.setOpaque(true);
                categoryButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        GroceryButtonActionPerformed(evt);
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
        ListPanel.add(DeletePanel);
        //ListPanel.add(Box.createHorizontalStrut(100));
        //ListPanel.add(OrganizedListPanel);
        
        GroceryListPanel.add(GroceryListLabel);
        //OrganizedListPanel.add(OrganizedListLabel);
        
        
        panel.add(AddButton);
        panel.add(ListPanel);

        
        
    }
    
    private void AddButtonActionPerformed(ActionEvent evt) {
        if(ItemToAdd.getText().equals("")) {      //if user didn't enter anything, returns
            return;
        }
        Aisle aisle = Aisle.OTHER;
        if(ClickedButton != null) {  //if a category is chosen, records aisle of category
            aisle = ClickedButton.getAisle();
        }
        
        GroceryJCheckBox item = new GroceryJCheckBox(aisle, ItemToAdd.getText() + " - " + (aisle!=null ? aisle.toString() : "Other"));
        DeleteJButton delete = new DeleteJButton(item, "delete");
        delete.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        DeleteButtonActionPerformed(evt);
                    }
                });
        
        GroceryList.add(item);
        DeleteList.add(delete);
        GroceryListPanel.add(item);
        DeletePanel.add(delete);
        //OrganizedListPanel.add(item);
        
        
        ItemToAdd.setText("");
        
        if(ClickedButton != null && ClickedButton.getForeground() == Color.BLUE) {
            ClickedButton.setForeground(null);
            ClickedButton = null;
        }
        
        GroceryArray = GroceryList.toArray();
        DeleteArray = DeleteList.toArray();
        
        GroceryListSort.sort(GroceryArray, DeleteArray);
        
        GroceryListPanel.removeAll();
        DeletePanel.removeAll();
        
        int size = GroceryList.size();
        
        GroceryList.clear();
        DeleteList.clear();
        
        
        
        for(int i = 0; i < size; i++) {
            GroceryList.add((GroceryJCheckBox)GroceryArray[i]);
            GroceryListPanel.add((GroceryJCheckBox)GroceryArray[i]);
            DeleteList.add((DeleteJButton)DeleteArray[i]);
            DeletePanel.add((DeleteJButton)DeleteArray[i]);
        }
        
        pack();
    }
    
    private void GroceryButtonActionPerformed(ActionEvent evt) {
        GroceryJButton buttonClicked = (GroceryJButton)evt.getSource();
        //buttonClicked.setBorderPainted(false);
        if(buttonClicked.getForeground() != Color.BLUE) {
            for(int i = 0; i < buttons.size(); i++) {
                if(buttons.get(i).getForeground() == Color.BLUE) {
                    buttons.get(i).setForeground(null);
                    break;
                }
            }
            buttonClicked.setForeground(Color.BLUE);
            ClickedButton = buttonClicked;
        }
        else buttonClicked.setForeground(null);
        ClickedButton = buttonClicked;
        
        
    }
    
    private void DeleteButtonActionPerformed(ActionEvent evt) {
        DeleteJButton delete = (DeleteJButton)evt.getSource();
        GroceryListPanel.remove(delete.getButton());
        GroceryList.remove(delete.getButton());
        DeletePanel.remove(delete);
        DeleteList.remove(delete);
        
        ListPanel.revalidate();
        ListPanel.repaint();
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
        GroceryListOrganizerGUI gui = new GroceryListOrganizerGUI();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                //createAndShowGUI();
                gui.setVisible(true);
                gui.setLocationRelativeTo(null);
                
            }
        });
    }
  
}  
