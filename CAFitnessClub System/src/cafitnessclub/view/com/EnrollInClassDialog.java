package cafitnessclub.view.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import cafitnessclub.model.POJO.com.ClassObject;
import cafitnessclub.model.POJO.com.Enrollment;
import cafitnessclub.model.POJO.com.Member;
import cafitnessclub.model.com.Classes;
import cafitnessclub.model.com.Enrollments;

public class EnrollInClassDialog extends JDialog {
	
    private JButton cancelButton;
    private JTextField classIDField;
    private JLabel label;
    private JSeparator jSeparator1;
    private JButton okButton;
    private Member member;
    private JComboBox<String> classesCombo;
    private String[] classesArray;
    private ArrayList<ClassObject> classes;

    public EnrollInClassDialog(String title, Member member) {
        setTitle(title);
        initComponents();
        setLocationRelativeTo(null);
        this.member = member;
    }
    
    private void initComponents() {

    	try {
			classes = Classes.getClasses();
			
			classesArray = new String[classes.size()];
			int i = 0;
			for(ClassObject clase : classes){
				classesArray[i] = clase.getName() + ": " + clase.getStartTime();
				i++;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}    	
    	
        label = new JLabel();
        	label.setText("Choose Class: ");
        classIDField = new JTextField();
        jSeparator1 = new JSeparator();
        okButton = new JButton();
        	okButton.setText("OK");
        cancelButton = new JButton();
        	cancelButton.setText("Cancel");        
        classesCombo = new javax.swing.JComboBox<String>();
        	classesCombo.setModel(new javax.swing.DefaultComboBoxModel<String>(classesArray));
        	
      // ACTION LISTENERS
        	okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {                	
                	// Add member into the class
                	int index = classesCombo.getSelectedIndex();
                	ClassObject clase = classes.get(index);
                	int classID = clase.getClassID();
                	//int memberID = member.getMemberID();
                	Enrollment enrollment = new Enrollment(classID, member.getMemberID());
                	
                	
                	try {
						Enrollments.insertEnrollment(enrollment);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
                	
                	dispose();
                }
            });
        	cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                	dispose();
                }
            });
      // END ACTIONS LISTENERS
       
      // ADD ALL COMPONENTS
        	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(classesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 80, Short.MAX_VALUE)))
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(okButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cancelButton)
                    .addGap(41, 41, 41))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label)
                        .addComponent(classesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(okButton)
                        .addComponent(cancelButton))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
      // END ADD ALL COMPONENTS

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }
}