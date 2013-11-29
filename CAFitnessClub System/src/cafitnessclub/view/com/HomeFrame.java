package cafitnessclub.view.com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import cafitnessclub.model.POJO.com.ClassObject;
import cafitnessclub.model.com.Classes;

public class HomeFrame extends JFrame {
	
	JFrame HomeFrame;
	GradientPanel mainPanel;
	JLabel titleLabel;
	JTabbedPane optionsTab;
	JToolBar membersToolBar;
	JButton editMemberButton;
    JButton viewMemberInfoButton;
    ClassesTable table;
    JScrollPane spTable;
	
	public HomeFrame()
	{
		HomeFrame = this;
		mainPanel = new GradientPanel();
		titleLabel = new Title();
		optionsTab = new MyTabbedPane();	
        table = new ClassesTable();
        spTable = new JScrollPane(table);
		
		initComponents();
	}
	public void initComponents()
	{   
        spTable.setPreferredSize(new Dimension(400,300));
        final ClassDialog dialog = new ClassDialog("TEST");
      
     // MOUSE LISTENER
        table.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());
                if (row >= 0 && column >= 0) {
                	int temp = (int) table.getModel().getValueAt(row, 0);
                	System.out.println("CLASSID: " + temp);
                	dialog.setInfo(temp);                	
                    dialog.setVisible(true);
                }
            }        	
        });
      // END MOUSE LISTENER
        
      // TAB PANE DECLARATIONS
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("res/FitnessClubLogo.gif");

        JComponent classesPanel = new JPanel(new BorderLayout()); //makeTextPanel("Panel #1");
        	classesPanel.add(new ClassButtonsPanel(), BorderLayout.NORTH);
        	//classesPanel.add(new ClassesPanel(), BorderLayout.CENTER);
        tabbedPane.addTab("Classes", icon, classesPanel, "Currently offered classes");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent membersPanel = new MembersPanel(); //makeTextPanel("Panel #2");
        tabbedPane.addTab("Members & Memberships", icon, membersPanel, "Edit member accounts and memberships");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        JComponent staffPanel = new InstructorPanel();
        tabbedPane.addTab("Instructors", icon, staffPanel, "Edit Instructors");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
      // END TAB PANE DECLARATIONS        
       
      // ADD COMPONENTS TO PANEL AND FRAME
		mainPanel.setLayout(new BorderLayout()); // SET LAYOUT OF MAIN PANEL
        mainPanel.add(titleLabel, BorderLayout.NORTH); // ADD LOGO
        mainPanel.add(tabbedPane, BorderLayout.CENTER); // ADD TABS
        //mainPanel.add(small);
		//mainPanel.add(optionsTab);
		//mainPanel.add(spTable);
		//mainPanel.add(table);
		//add(table);
        this.setLayout(new BorderLayout()); // SET LAYOUT OF FRAME 
		this.add(mainPanel, BorderLayout.CENTER); // ADD MAIN PANEL TO FRAME
        // this.add(spTable, BorderLayout.PAGE_END);
        //this.add(mainPanel);        
        this.setBackground(new java.awt.Color(0, 90, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		Insets insets = getInsets();
		this.setSize(new Dimension(insets.left + insets.right + 1000,
		             insets.top + insets.bottom + 600));
		setLocationRelativeTo(null);
		setVisible(true);
		this.setResizable(false);
	  // END ADD COMPONENTS TO PANEL AND FRAME	
	}
	
	/** Adds text to a panel */ 
	protected JComponent makeTextPanel(String text) {
	        JPanel panel = new JPanel(false);
	        JLabel filler = new JLabel(text);
	        filler.setHorizontalAlignment(JLabel.CENTER);
	        panel.setLayout(new GridLayout(1, 1));
	        panel.add(filler);
	        return panel;
	}
	 
	 /** Returns an ImageIcon, or null if the path was invalid. */
	    protected static ImageIcon createImageIcon(String path) {
	        java.net.URL imgURL = null; //TabbedPaneDemo.class.getResource(path);
	        if (imgURL != null) {
	            return new ImageIcon(imgURL);
	        } else {
	            System.err.println("Couldn't find file: " + path);
	            return null;
	        }
	    }
}