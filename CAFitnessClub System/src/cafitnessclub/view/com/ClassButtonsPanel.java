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
import javax.swing.LayoutStyle;

public class ClassButtonsPanel extends JPanel {
	
    private JButton addClassButton;
    private ButtonGroup buttonGroup1;
    private JRadioButton instructorRadioBtn;
    private JRadioButton roomRadioBtn;
    private JLabel viewScheduleLabel;
    private JButton refreshButton;
    private ClassesPanel classesPanel;

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
	    	refreshButton.setText("Refresh");
        	
      // ACTION LISTENERS
        	addClassButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    AddClassDialog addClassDialog;
					try {
						addClassDialog = new AddClassDialog("Add New Class");
						addClassDialog.setVisible(true);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}                    
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
      // END ACTION LISTENERS
        	
        	
      // ADD ALL COMPONENTS
        	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(addClassButton)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                    .addComponent(viewScheduleLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(instructorRadioBtn)
                        .addComponent(roomRadioBtn))
                    .addGap(18, 18, 18)
                    .addComponent(refreshButton)
                    .addGap(68, 68, 68))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(addClassButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(instructorRadioBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(roomRadioBtn))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(viewScheduleLabel))
                        .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(31, Short.MAX_VALUE))
            );
      // END ADD ALL COMPONENTS
    }
}

