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
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import cafitnessclub.model.POJO.com.ClassObject;
import cafitnessclub.model.POJO.com.Instructor;
import cafitnessclub.model.POJO.com.Room;
import cafitnessclub.model.com.Classes;
import cafitnessclub.model.com.Instructors;
import cafitnessclub.model.com.Rooms;

public class EditClassDialog extends JDialog {
	
    private JButton cancelButton;
    private JLabel classTypeLabel;
    private JLabel endTimeLabel;
    private JLabel instructorLabel;
    private JSeparator jSeparator1;
    private JButton okButton;
    private JComboBox<String> classTypeCombo;
    private JComboBox<Time> endTimeCombo;
    private JComboBox<String> instructorCombo;
    private JComboBox<String> roomCombo;
    private JComboBox<Time> startTimeCombo;
    private JLabel roomLabel;
    private JLabel startTimeLabel;
    private Instructor[] instructors;
    private Room[] rooms;
    private int classID;

    public EditClassDialog(String title, int classID){
    	this.classID = classID;
        setTitle(title);
        initComponents();
        setLocationRelativeTo(null);
    }

	private void initComponents(){

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
        classTypeCombo = new JComboBox<String>();
        	classTypeCombo.setModel(new DefaultComboBoxModel<String>(new String[] { 
        			"Aerobics", "Basketball", "Karate", "Kickboxing", "Pilates", 
        			"Pool", "Racquetball", "Tennis", "Yoga", "Zumba"}));
        startTimeCombo = new JComboBox<Time>();
        	startTimeCombo.setModel(new DefaultComboBoxModel<Time>(new Time[] { 
        			new Time(06,00,00), new Time(9,00,00), new Time(12,00,00), 
        			new Time(15,00,00), new Time(18,00,00)}));
        endTimeCombo = new JComboBox<Time>();
        	endTimeCombo.setModel(new DefaultComboBoxModel<Time>(new Time[] { 
        			new Time(07,30,00), new Time(10,30,00), new Time(01,30,00), 
        			new Time(16,30,00), new Time(19,30,00)}));    	
        	
        instructorCombo = new JComboBox<String>();
        roomCombo = new JComboBox<String>();
        try{
        	 instructors= Instructors.getAllInstructors();
        	String[] instructorNames = Instructors.getAllInstructorNames();
        	instructorCombo.setModel(new DefaultComboBoxModel<String>(instructorNames));        	
        	
        
        	rooms = Rooms.getAllRooms();
        	String[] roomNames = Rooms.getAllRoomNames();
        	roomCombo.setModel(new DefaultComboBoxModel<String>(roomNames));
        	
        	
        	ClassObject clase = Classes.getClass(classID);
        	instructorCombo.setSelectedItem(clase.getInstructor().getName());
        	roomCombo.setSelectedItem(clase.getRoom().getRoomName().toString());
        	startTimeCombo.setSelectedItem(clase.getStartTime().toString());
        	endTimeCombo.setSelectedItem(clase.getEndTime().toString());
        	classTypeCombo.setSelectedItem(clase.getName());
        }catch (SQLException e){
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        }
        	
      // END COMBO BOXES
        
      // ACTION LISTENERS
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {            	
            	String classType = (String)classTypeCombo.getSelectedItem();
            	Time startTime = (Time)startTimeCombo.getSelectedItem();
            	Time endTime = (Time)endTimeCombo.getSelectedItem();
            	Instructor instructor = instructors[instructorCombo.getSelectedIndex()];
            	Room room = rooms[roomCombo.getSelectedIndex()];
            	
            	
            	
            	ClassObject newClass = new ClassObject(classID, classType, startTime, endTime, instructor, room);
            	
            	try {
            		Classes.updateClass(newClass, instructor, room);
					//Classes.addClass(newClass, instructor, room);
				} catch (SQLException e) {
					e.printStackTrace();
				}
            	
            	dispose();
            	JOptionPane.showMessageDialog(new JFrame(), "New Class has been added!", "Class Creation Successful", JOptionPane.INFORMATION_MESSAGE);
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