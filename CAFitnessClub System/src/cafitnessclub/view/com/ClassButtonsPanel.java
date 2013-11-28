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

    public ClassButtonsPanel() {
        initComponents();
    }

    private void initComponents() {

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
      // END ACTION LISTENERS
        	
        	
      // ADD ALL COMPONENTS
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(addClassButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                .addComponent(viewScheduleLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(instructorRadioBtn)
                    .addComponent(roomRadioBtn))
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(addClassButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(instructorRadioBtn)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomRadioBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(viewScheduleLabel)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
      // END ADD ALL COMPONENTS
    }
}

