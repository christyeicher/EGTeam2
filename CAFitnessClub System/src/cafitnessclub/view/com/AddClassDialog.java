/**
 * This program
 * @author: Christy Eicher
 * Version
*/

package cafitnessclub.view.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import cafitnessclub.model.POJO.com.ClassObject;
import cafitnessclub.model.POJO.com.Instructor;
import cafitnessclub.model.POJO.com.Room;
import cafitnessclub.model.com.Instructors;

public class AddClassDialog extends JDialog {
	
    private JButton cancelButton;
    private JComboBox classTypeCombo;
    private JLabel classTypeLabel;
    private JComboBox endTimeCombo;
    private JLabel endTimeLabel;
    private JComboBox instructorCombo;
    private JLabel instructorLabel;
    private JSeparator jSeparator1;
    private JButton okButton;
    private JComboBox roomCombo;
    private JLabel roomLabel;
    private JComboBox startTimeCombo;
    private JLabel startTimeLabel;

    public AddClassDialog(String title) throws SQLException {
        setTitle(title);
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() throws SQLException {

        classTypeLabel = new JLabel();
        	classTypeLabel.setText("Class Type: ");
        startTimeLabel = new JLabel();
        	startTimeLabel.setText("Start Time: ");
        endTimeLabel = new JLabel();
        	endTimeLabel.setText("End Time: ");
        instructorLabel = new JLabel();
        	instructorLabel.setText("Instructor: ");
        roomLabel = new JLabel();
        	roomLabel.setText("Room: ");
        okButton = new JButton();
        	okButton.setText("OK");
        cancelButton = new JButton();
        	cancelButton.setText("Cancel");
        jSeparator1 = new JSeparator();
      // COMBO BOXES
        classTypeCombo = new JComboBox();
        	classTypeCombo.setModel(new DefaultComboBoxModel(new String[] { 
        			"Choose Class Type...", "Aerobics", "Basketball", 
        			"Karate", "Kickboxing", "Pilates", "Pool", "Racquetball", 
        			"Tennis", "Yoga", "Zumba" }));
        startTimeCombo = new JComboBox();
        	startTimeCombo.setModel(new DefaultComboBoxModel(new String[] { 
        			"Choose Start Time...", "6am", "9am", "12pm", "3pm", "6pm" }));
        endTimeCombo = new JComboBox();
        	endTimeCombo.setModel(new DefaultComboBoxModel(new String[] { 
        			"Choose End Time...", "7:30am", "10:30am", "1:30pm", "4:30pm", "7:30pm" }));
        	
        	
        instructorCombo = new JComboBox();
        	//Instructor[] instructors = Instructors.getAllInstructors();
        	//instructorCombo.setModel(new DefaultComboBoxModel(instructors));
        	instructorCombo.setModel(new DefaultComboBoxModel(new String[] { 
        			"Choose Instructor...", "Adam Sewell", "Andy Nguyen", "Chuck Norris", 
        			"Danielle Valley", "Jacque Cousteau", "Jennifer Lopez", "Jennifer Prugh", 
        			"LeBron James", "Lindsey Morrone", "Lorien Neargarder", "Mark Tanaka", 
        			"Michael Phelps", "Serena Williams", "Shareef Johnson", "Vanessa Vortex" }));
        	
        	
        roomCombo = new JComboBox();
        	roomCombo.setModel(new DefaultComboBoxModel(new String[] { "Choose Room...", 
        			"BB1", "FL1", "FL2", "G1", "P1", "RB1", "TC1" }));
      // END COMBO BOXES
        
      // ACTION LISTENERS
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	//ClassObject newClass = new ClassObject("", null, new Time(06, 00, 00), null, null);
            	System.out.println(instructorCombo.getSelectedItem().toString());
            	dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	dispose();
            }
        });
      // END ACTION LISTENERS

      // ADD ALL COMPONENTS  
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(classTypeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(classTypeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(startTimeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startTimeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(endTimeLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(endTimeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(instructorLabel)
                                    .addComponent(roomLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(roomCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(instructorCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(okButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(classTypeLabel)
                    .addComponent(classTypeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(startTimeLabel)
                    .addComponent(startTimeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(endTimeLabel)
                    .addComponent(endTimeCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(instructorLabel)
                    .addComponent(instructorCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(roomLabel)
                    .addComponent(roomCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(14, Short.MAX_VALUE))
        );
      // END ADD ALL COMPONENTS

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }
}