package cafitnessclub.view.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import cafitnessclub.model.POJO.com.Instructor;
import cafitnessclub.model.POJO.com.Member;
import cafitnessclub.model.com.Instructors;
import cafitnessclub.model.com.Members;

public class InstructorPanel extends JPanel {
	
    private JTextField addressField;
    private JLabel addressLabel;
    private JTextArea displayArea;
    private JTextField emailField1;
    private JTextField emailField2;
    private JLabel emailLabel1;
    private JLabel emailLabel2;
    private JTextField firstLastNameField;
    private JLabel firstLastNameLabel;
    private JLabel instructorLabel;
    private JButton addInstructorButton;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JButton editInstructorButton;
    private JButton searchButton;
    private JLabel searchEmailLabel;
    private JButton deleteInstructorButton;
    private Instructor instructor;

	public InstructorPanel() {
        initComponents();
    }

    private void initComponents() {

      // VARIABLE DECLARATION
      // BUTTONS
        searchButton = new JButton();
        	searchButton.setText("Search");
        deleteInstructorButton = new JButton();
        	deleteInstructorButton.setText("Delete Current Instructor");
        editInstructorButton = new JButton();
        	editInstructorButton.setText("Edit Instructor Info");
        addInstructorButton = new JButton();
        	addInstructorButton.setText("Add New Instructor");
      // LABELS
        instructorLabel = new JLabel();
        	instructorLabel.setText("Instructor: ");
        searchEmailLabel = new JLabel();
        	searchEmailLabel.setText("Search Instructor by Email:");
        emailLabel1 = new JLabel();
        	emailLabel1.setText("Email:");
        firstLastNameLabel = new JLabel();
        	firstLastNameLabel.setText("First and Last Name: ");
        emailLabel2 = new JLabel();
        	emailLabel2.setText("Email: ");
        addressLabel = new JLabel();
        	addressLabel.setText("Address: ");
      // TEXT FIELDS
        addressField = new JTextField();
        emailField2 = new JTextField();
        firstLastNameField = new JTextField();
        emailField1 = new JTextField();
      // MISC
        jSeparator1 = new JSeparator();
        jScrollPane1 = new JScrollPane();
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setColumns(20);
        displayArea.setRows(5);
        jScrollPane1.setViewportView(displayArea);
      // END VARIABLE DECLARATION         
        
      // ACTION LISTENERS
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	String email = emailField1.getText();
    	    	if(email != null){
    	    		try {
    					instructor = Instructors.getInstructorByEmail(email);
    					if(instructor != null)
    						displayArea.setText(instructor.toString());
    					else
    						displayArea.setText("Instructor Not Found");
    				} catch (SQLException e) {
    					System.out.println("Error getting Instructor. "+ e.getMessage());
    					e.printStackTrace();
    				}
    	    	}
            }
        });
        deleteInstructorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	try {
        			Instructors.deleteInstructor(instructor);
        			if (true)
        				displayArea.setText("");
        		} catch (SQLException e) {
        			System.out.println("Error Deleting Instructor: " + e.getMessage());
        			e.printStackTrace();
        		}
            }
        });
        editInstructorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	try {
                	String name = firstLastNameField.getText();
                	String email = emailField2.getText();
                	String address = addressField.getText();
                	if(email == null){
                		displayArea.setText("You must enter Email to update!");
                		return;                		
                	}
                	if(instructor == null){
                		displayArea.setText("Search for Member First!");
                		return;
                	}
                	// edit current member
                	instructor.setName(name);
                	instructor.setEmail(email);
                	instructor.setAddress(address);	                	
            		Instructors.updateInstructor(instructor);
    		} catch (SQLException e) {
    			e.printStackTrace();
    		} catch(NumberFormatException e){
    			displayArea.setText("Search for Member First!");
    		}
            }
        });
        addInstructorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	
            	System.out.println("WHAT");
            	try {
                	Instructor newInstructor = new Instructor(firstLastNameField.getText(),
                			emailField2.getText(), addressField.getText());
                	if(newInstructor.instructorCheck())
                		Instructors.insertInstructor(newInstructor);
                	else {
                		displayArea.setText("Please fill out all the fields");
                		return;
                	}
            		} catch (SQLException e) {
            			System.out.println("Error Adding Instructor: " + e.getMessage());
            			e.printStackTrace();
            		}catch(NumberFormatException e){
            			displayArea.setText("Please fill out all the fields");
            		}
            }
        });
      // END ACTION LISTENERS

      // ADD ALL COMPONENTS
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(358, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editInstructorButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addInstructorButton))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(deleteInstructorButton)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchButton))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(emailLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailField1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
                            .addComponent(searchEmailLabel)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
                            .addComponent(instructorLabel)))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(addressLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(addressField))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(emailLabel2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(emailField2))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(firstLastNameLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(firstLastNameField))
                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)))
                .addGap(352, 352, 352))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(instructorLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchEmailLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel1)
                    .addComponent(emailField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton)
                    .addComponent(deleteInstructorButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(firstLastNameLabel)
                    .addComponent(firstLastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel2)
                    .addComponent(emailField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(editInstructorButton)
                    .addComponent(addInstructorButton))
                .addContainerGap(77, Short.MAX_VALUE))
        );
      // END ADD ALL COMPONENTS
    }
}