package cafitnessclub.view.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

public class ClassButtonsPanel extends JPanel {
	
    private JButton addClassButton;
    private ButtonGroup buttonGroup1;
    private JRadioButton instructorRadioBtn;
    private JRadioButton roomRadioBtn;
    private JLabel viewScheduleLabel;
    private JButton refreshButton;
    private ClassesPanel classesPanel;
    private JButton deleteClassButton;
    private JScrollPane jScrollPane1;
    private JTextArea displayArea;

    public ClassButtonsPanel() {
        initComponents();
    }

    private void initComponents() {
    	
    	classesPanel = new ClassesPanel();

        addClassButton = new JButton();
        	addClassButton.setText("Add a Class");
        instructorRadioBtn = new JRadioButton();
        	instructorRadioBtn.setText("Instructor");
        roomRadioBtn = new JRadioButton();
        	roomRadioBtn.setText("Room");
        viewScheduleLabel = new JLabel();
        	viewScheduleLabel.setText("View Schedule By: ");
        buttonGroup1 = new ButtonGroup();
	        buttonGroup1.add(instructorRadioBtn);
	        buttonGroup1.add(roomRadioBtn);
	    refreshButton = new JButton();
	    	refreshButton.setText("Refresh List");
	    deleteClassButton = new JButton();
	    	deleteClassButton.setText("Delete A Class");
	    jScrollPane1 = new JScrollPane();
	    displayArea = new JTextArea();
	    	displayArea.setEditable(false);
	        displayArea.setColumns(20);
	        displayArea.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
	        displayArea.setRows(1);
	        jScrollPane1.setViewportView(displayArea);
        	
      // ACTION LISTENERS
        	addClassButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ClassDialog addClassDialog;
					addClassDialog = new ClassDialog("Add New Class");
					addClassDialog.setVisible(true);                    
                }
            });
        	refreshButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                     if (instructorRadioBtn.isSelected())
                    	 System.out.println();
                     else if (roomRadioBtn.isSelected())
                    	 System.out.println();
                }
            });
        	deleteClassButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    DeleteClassDialog deleteDialog = new DeleteClassDialog("Delete A Class");
                    deleteDialog.setVisible(true);
                }
            });
      // END ACTION LISTENERS
        	
        	
      // ADD ALL COMPONENTS
        	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    //.addGap(97, 97, 97)
                	.addGap(250,250,250)
                    .addComponent(addClassButton)
//                    .addGap(48, 48, 48)
//                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(deleteClassButton)
                    .addGap(30, 30, 30)
                    .addComponent(refreshButton)
                    .addContainerGap(145, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(deleteClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                            .addGroup(layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(addClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(39, Short.MAX_VALUE))
            );
      // END ADD ALL COMPONENTS
    }
    
    public JButton getRefreshBtn(){
    	return this.refreshButton;
    }
}

